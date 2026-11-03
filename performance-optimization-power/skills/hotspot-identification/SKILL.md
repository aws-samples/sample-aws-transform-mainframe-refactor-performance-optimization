---
name: "hotspot-identification"
description: "Identify performance bottlenecks in AWS Transform for mainframe refactor application code. Use when analyzing code for slow patterns, finding repeated DAO reads/writes in loops, spotting row-by-row processing that should be set-based, or reviewing code for optimization candidates."
license: "MIT-0"
metadata:
  author: "Amazon Web Services"
  version: "1.1.0"
---

# Hotspot Identification Guide

## Overview

This guide helps identify performance bottlenecks in AWS Transform for mainframe refactor applications that are candidates for optimization. Work through the patterns below, then apply the matching technique from the `sqlexecutorbuilder-guide` or `batch-operations` skills.

## Hotspot Patterns to Look For

### 1. Repeated DAO Reads in Loops

**Pattern:** Same table queried per iteration of a loop.

```java
// PROBLEM: N database round-trips
for (item : items) {
    dao.retrieve();  // hits database each iteration
    // use data...
}
```

**Solution:** Pre-load data into HashMap using SQLExecutorBuilder cursor.

```java
// OPTIMIZED: 1 database round-trip + N HashMap lookups
Map<Key, Value> cache = new HashMap<>();
// Use SQLExecutorBuilder cursor to load all needed data
// Then iterate using cache.get(key)
```

**Variant:** if only part of the table is used, or the lookup is done by a called program, fill the cache on first lookup instead of preloading. See "Lazy Cache Pattern" in `sqlexecutorbuilder-guide`.

**Also look for:** the repeated read may not be a DAO call. In migrated mainframe code it is often a call to a small master-data lookup program, or a singleton `SELECT ... INTO` run through SQLExecutorBuilder. Each is still one round trip per iteration.

---

### 2. DAO Write/Update Inside Loops

**Pattern:** Direct or indirect database writes per iteration.

```java
// PROBLEM - Direct: N database round-trips
for (item : items) {
    dao.withRecord(record).write();  // hits database each iteration
}
```

**Solution:** Use `addRecordToBatch()` + `batchWriteDirect()`/`batchUpdateDirect()`.

```java
// OPTIMIZED: 1 database round-trip for all records
for (item : items) {
    MyRecord record = new MyRecord(ctx.getConfiguration());
    record.setField1(value1);
    dao.withRecord(record).addRecordToBatch();
}
dao.batchWriteDirect();
```

#### Indirect Batch Candidates

The write may be hidden inside a function called from the loop. These are also batch candidates:

```java
// PROBLEM - Indirect: Also N round-trips (hidden in function)
for (item : items) {
    processItem(item);  // calls dao.write() internally — still N round-trips
}
```

When optimizing indirect cases, you may need to:
- Refactor the called function to accept a batch mode flag
- Extract the DAO operation out of the function
- Restructure the code to collect records first, then batch write

---

### 3. Row-by-Row Processing That Could Be Set-Based

**Pattern:** Aggregations or calculations done in Java that the database could do.

```java
// PROBLEM: Fetch all rows, aggregate in Java
BigDecimal total = BigDecimal.ZERO;
while (cursor.hasNext()) {
    total = total.add(row.getAmount());
}
```

**Solution:** Use SQLExecutorBuilder with GROUP BY, SUM, COUNT at database level.

```sql
-- OPTIMIZED: Database does the aggregation
SELECT SUM(amount) FROM table WHERE condition = ?
```

---

### 4. Multiple Round-Trips for Related Data

**Pattern:** Fetching parent then children separately.

```java
// PROBLEM: 1 + N round-trips
Parent parent = parentDao.retrieve();
for (childId : parent.getChildIds()) {
    Child child = childDao.retrieve(childId);  // N more queries
}
```

**Solution:** Use SQLExecutorBuilder with JOINs to fetch in single query.

```sql
-- OPTIMIZED: 1 round-trip with JOIN
SELECT p.*, c.* FROM parent p 
JOIN child c ON p.id = c.parent_id 
WHERE p.id = ?
```

**Also look for:** a cursor loop that runs a separate query for each fetched row to get its counterpart row, sometimes from the same table. Return that row from the cursor itself with an outer join, so rows without a match are still processed. Follow "Changing Cursor SQL Safely" in `sqlexecutorbuilder-guide`.

---

## How to Analyze Code for Hotspots

1. **Look for loops** — Any `for`, `while`, or `do-while` is a candidate
2. **Check what's inside** — DAO calls? Database operations?
3. **Trace function calls** — A clean-looking loop might call a function that does DAO operations
4. **Count potential round-trips** — If iterations × DAO calls is high, it's a hotspot
5. **Compare data sizes** — If the loop's driving table is much larger than the tables it looks up, the same rows are being re-read many times
6. **Report before changing** — List each hotspot with its location, calls per iteration and the pattern it matches

## Red Flags in Code Review

- `dao.retrieve()` inside any loop
- `dao.write()` or `dao.update()` inside any loop
- Functions called from loops that accept record/entity parameters (likely doing DB ops)
- Aggregation variables (`sum`, `count`, `total`) being accumulated in loops
- Multiple sequential DAO calls for related tables
- A singleton SELECT executed inside a cursor FETCH loop
- A sub-program call inside a loop whose only job is to look something up
- A former multi-row database operation converted into a loop of single-row statements
- Per-row console logging (`DISPLAY`) inside the loop

## When NOT to Batch

Even when you identify a loop with DAO writes/updates, batching isn't always appropriate:

- **Operations requiring immediate consistency** — When subsequent code must see the written data immediately
- **When next operation depends on previous result** — e.g., need a generated ID from the insert before proceeding
- **When multiple batch records affect the same row** — Last one wins, others are lost
