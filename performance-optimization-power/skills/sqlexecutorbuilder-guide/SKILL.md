---
name: "sqlexecutorbuilder-guide"
description: "Implement custom SQL, cursors, aggregations, and joins in the AWS Transform for mainframe runtime using SQLExecutorBuilder. Use when writing centralized prepared statements, setting up Sqlca, building cursor FETCH loops, mapping SQL parameters, changing cursor SQL, caching lookups in a HashMap (preloaded or lazy), or verifying an optimization."
license: "MIT-0"
metadata:
  author: "Amazon Web Services"
  version: "1.1.0"
---

# SQLExecutorBuilder Implementation Guide

## Overview

SQLExecutorBuilder executes centralized prepared statements defined in SQL files. Use it for custom queries, cursors, aggregations, and joins.

## Required Imports

```java
import com.netfective.bluage.gapwalk.database.support.central.ESQLAttribute;
import com.netfective.bluage.gapwalk.database.support.central.SQLExecutorBuilder;
import com.netfective.bluage.gapwalk.database.support.central.SQLParameterBuilder;
import java.sql.JDBCType;
```

## Context Requirements

The context class must have a `Sqlca` field with getter for SQL operations:

```java
// In context class (e.g., MyProgramContext.java)
private Sqlca sqlca;

public Sqlca getSqlca() {
    return this.sqlca;
}

// Initialize in initWorking()
private void initWorking(Configuration configuration) {
    sqlca = new Sqlca(configuration);
    // ... other initializations
}
```

## Sqlca Model Class

Create `Sqlca.java` in the program's model package (e.g., `business/model/Sqlca.java`).

**Option 1:** Copy from existing implementation (search for `Sqlca.java` in the codebase).

**Option 2:** Create from scratch - standard SQL Communication Area structure:

```java
public class Sqlca extends RecordEntity {
    private final Group root = new Group(getData());
    private final Union union = new Union(root);
    private final Elementary sqlcaid = new Elementary(union, new AlphanumericType(8), "X'0000000000000000'");
    private final Elementary sqlaid = new Elementary(union, new AlphanumericType(8));
    // sqlcabc/sqlabc - BinaryIntegerType(4)/BinaryType(9,0)
    private final Union union2 = new Union(root);
    private final Elementary sqlcode = new Elementary(union2, new BinaryIntegerType(4, true));
    private final Elementary sqlcod = new Elementary(union2, new BinaryType(9, 0, "STD", true));
    // sqlerrml/sqlerl - BinaryIntegerType(2)/BinaryType(4,0)
    // sqlerrmc/sqlerm - AlphanumericType(70)
    // sqlerrp/sqlerp - AlphanumericType(8)
    // sqlerr - AlphanumericType(24) with sqler1-sqler6 as BinaryType(9,0)
    // sqlerrd - FixedArray(6) of BinaryIntegerType(4)
    // sqlwrn - AlphanumericType(11) with sqlwn0-sqlwna as AlphanumericType(1)
    // sqlwarn - FixedArray(11) of AlphanumericType(1)
    private final Union union8 = new Union(root);
    private final Elementary sqlstate = new Elementary(union8, new AlphanumericType(5));
    private final Elementary sqlstt = new Elementary(union8, new AlphanumericType(5));
    
    public Sqlca(Configuration configuration) {
        super(configuration);
        setupRoot(root);
    }
    
    public int getSqlcode() { return sqlcode.getValue(); }
    // Add getters/setters with getXxxReference() pattern for each field
}
```

**Key field:** `getSqlcode()` returns SQL result code (0=success, 100=not found).

**Initialize sqlcaid before first use:**
```java
ctx.getSqlca().getSqlcaidReference().setBytes(new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0 });
```

## Cursor Output Data Holder

For cursor FETCH operations, create a `RecordEntity` subclass matching the SELECT columns:

```java
public class MyCursorRow extends RecordEntity {
    private final Group root = new Group(getData());
    private final Elementary field1 = new Elementary(root, new PackedType(16, 0, true), new BigDecimal("0"));
    private final Elementary field2 = new Elementary(root, new ZonedType(11, 2, true), new BigDecimal("0"));
    // ... fields matching SELECT column order
    
    public MyCursorRow(Configuration configuration) {
        super(configuration);
        setupRoot(root);
    }
    
    // Getters with getXxxReference() for each field
}
```

## SQL File Format

```sql
# Comments start with #
PROG_1=DECLARE cursor_name FOR SELECT col1, col2 FROM table WHERE col = ? for read only
PROG_2=CLOSE cursor_name
PROG_3=OPEN cursor_name
PROG_4=FETCH NEXT cursor_name
PROG_5=SELECT col INTO ? FROM table WHERE key = ?
PROG_6=INSERT INTO table (col1, col2) VALUES (?, ?)
PROG_7=UPDATE table SET col = ? WHERE key = ?
PROG_8=DELETE FROM table WHERE key = ?
```

**File locations:** SQL files must exist in two synced locations (build + runtime). See `references/sql-file-locations.md` for the exact paths.

## SQLParameterBuilder Reference

| Method | Purpose |
|--------|---------|
| `newInstance(value)` | Create builder with value (ElementaryRangeReference, RecordEntity, or raw value) |
| `.type(JDBCType.XXX)` | Set JDBC type (DATE, DECIMAL, VARCHAR, INTEGER, TIMESTAMP, etc.) |
| `.size(n)` | Set parameter size |
| `.indicator(ref)` | Set null indicator |
| `.in()` | Mark as input parameter |
| `.out()` | Mark as output parameter |

### CRITICAL: Parameter Value Types

**DO NOT use standalone elementary types like `Alphanumeric`, `PackedDecimal`, etc.** These do NOT have `getReference()` methods.

**Valid parameter sources:**

1. **RecordEntity field references** (from context or data holders):
   ```java
   // CORRECT - using getXxxReference() from a RecordEntity field
   SQLParameterBuilder.newInstance(ctx.getParams().getStartDateReference())
   SQLParameterBuilder.newInstance(ctx.getRecord().getCardnumReference())
   ```

2. **Raw Java values** (String, int, long, BigDecimal, etc.):
   ```java
   // CORRECT - passing raw values directly
   SQLParameterBuilder.newInstance("2025-01-01").type(JDBCType.DATE)
   SQLParameterBuilder.newInstance(12345L).type(JDBCType.BIGINT)
   ```

3. **Entire RecordEntity** (for FETCH output):
   ```java
   // CORRECT - passing RecordEntity for cursor output
   SQLParameterBuilder.newInstance(myCursorRow)
   ```

**WRONG - This will NOT compile:**
```java
// WRONG - Alphanumeric does not have getReference()
Alphanumeric startDate = new Alphanumeric(10, "2025-01-01");
SQLParameterBuilder.newInstance(startDate.getReference())  // COMPILE ERROR!
```

**The `getReference()` method only exists on `Elementary` fields defined within a `RecordEntity` subclass, not on standalone elementary utility classes.**

## ESQLAttribute Values

| Attribute | Use Case |
|-----------|----------|
| `SCROLL` | Enable cursor scrolling (required for most cursors) |
| `NO_SCROLL` | Forward-only cursor |
| `FOR_READ_ONLY` | Read-only cursor (no updates) |
| `FOR_UPDATE` | Cursor with update capability |
| `INSENSITIVE` | Cursor insensitive to changes |
| `SENSITIVE` | Cursor sensitive to changes |

## Usage Examples

### Simple SELECT INTO

```java
SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
    .mapOutParameter(SQLParameterBuilder.newInstance(ctx.getRecord().getFieldReference()))
    .mapInParameter(SQLParameterBuilder.newInstance(ctx.getKey().getKeyReference()))
    .execute("PROG_5");
```

### Cursor with Parameters

```java
// DECLARE (in main method)
SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
    .setAttribute(ESQLAttribute.SCROLL)
    .setAttribute(ESQLAttribute.FOR_READ_ONLY)
    .mapInParameter(SQLParameterBuilder.newInstance(ctx.getParams().getStartDateReference()).type(JDBCType.DATE))
    .mapInParameter(SQLParameterBuilder.newInstance(ctx.getParams().getEndDateReference()).type(JDBCType.DATE))
    .execute("PROG_1");

// CLOSE then OPEN
SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca()).execute("PROG_2");
SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca()).execute("PROG_3");

// FETCH loop
while (true) {
    SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
        .mapOutParameter(SQLParameterBuilder.newInstance(outputEntity))
        .execute("PROG_4");
    if (ctx.getSqlca().getSqlcode() == 100) break; // SQL_NOT_FOUND
    // process row...
}

// CLOSE
SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca()).execute("PROG_2");
```

### INSERT/UPDATE/DELETE

```java
SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
    .mapInParameter(SQLParameterBuilder.newInstance(ctx.getRecord().getCol1Reference()))
    .mapInParameter(SQLParameterBuilder.newInstance(ctx.getRecord().getCol2Reference()))
    .execute("PROG_6");
```

### Pre-load Data into HashMap (Cache Pattern)

Use this pattern to replace repeated DAO reads in a loop with a single cursor fetch + HashMap lookups.

**SQL file:**
```sql
PROG_10=DECLARE cache_cursor FOR SELECT key_col, value_col1, value_col2 FROM lookup_table for read only
PROG_11=CLOSE cache_cursor
PROG_12=OPEN cache_cursor
PROG_13=FETCH NEXT cache_cursor
```

**Java implementation:**
```java
// Create HashMap to hold cached data
Map<String, MyLookupData> lookupCache = new HashMap<>();

// DECLARE, CLOSE, OPEN cursor
SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
    .setAttribute(ESQLAttribute.SCROLL)
    .setAttribute(ESQLAttribute.FOR_READ_ONLY)
    .execute("PROG_10");
SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca()).execute("PROG_11");
SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca()).execute("PROG_12");

// FETCH all rows into HashMap
while (true) {
    MyCursorRow row = new MyCursorRow(ctx.getConfiguration());  // NEW instance each iteration
    SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
        .mapOutParameter(SQLParameterBuilder.newInstance(row))
        .execute("PROG_13");
    if (ctx.getSqlca().getSqlcode() == 100) break;
    
    // Store row directly in cache (or extract key/values as needed)
    lookupCache.put(row.getKeyCol(), row);
}

// CLOSE cursor
SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca()).execute("PROG_11");

// Now use cache instead of DAO reads in loop
for (item : items) {
    MyLookupData data = lookupCache.get(item.getLookupKey());  // O(1) HashMap lookup
    // process with data...
}
```

**When to use:**
- Reference/lookup tables accessed repeatedly in a loop
- Data that doesn't change during processing
- When the full dataset fits comfortably in memory

### Lazy Cache Pattern

Instead of preloading, wrap the existing lookup (a SELECT or a called program) in a small helper. On a cache hit, return the stored result; on a miss, run the original lookup unchanged, then store the result if it succeeded.

```java
// Shape only, adapt to the program
Result cached = cache.get(key);
if (cached != null) { restore(cached); return; }
originalLookup();                       // unchanged
if (succeeded()) cache.put(key, snapshot());
```

**Rules:**
- **Cache successes only.** Not-found and error results must reach the database again so behavior is unchanged.
- **Replay exactly.** Store a copy of everything the original lookup left behind (output fields, and the SQLCA for a SELECT) and restore all of it on a hit.
- **Key on every input** of the original lookup.
- **One run only.** Create the cache when processing starts, discard it when processing ends, and keep it private to the run if the program can run in parallel.
- **Read-only data only.** Confirm nothing in the run writes the cached tables.

## Changing Cursor SQL Safely

Statements in the SQL resource files are **not sent to the database verbatim**: the AWS Transform for mainframe runtime parses and rewrites them first. A statement that works when run directly against the database can still fail inside the AWS Transform for mainframe runtime.

- **Keep cursor SQL simple.** Prefer one SELECT with joins in the FROM clause over subqueries in the select list, which are more likely to be rewritten badly.
- **Preserve row order.** A cursor without ORDER BY returns rows in whatever order the database chooses; adding a join can change it. If downstream output depends on processing order, make the original order explicit.
- **Update every FETCH.** New select-list columns need an output mapping in every FETCH of that cursor, in the same order.
- **Emulate what you remove.** If a join replaces a per-row SELECT, leave the same fields and SQLCODE (found vs not found) that the old SELECT left, so the surrounding logic runs unchanged.

### Example: Fold a Per-Row Lookup into the Cursor

**Before:** one cursor, plus one SELECT per fetched row.
```sql
PROG_1=DECLARE ITEM_CSR FOR SELECT ITEM_ID, ITEM_QTY FROM ITEM WHERE ITEM_STATUS=?
PROG_9=SELECT PRICE_AMT, PRICE_STATUS FROM ITEM_PRICE WHERE PRICE_ITEM_ID=?
```

**After:** the cursor returns the related row. Use `LEFT JOIN` so rows without a match are still fetched, and add a flag column for "found".
```sql
PROG_1=DECLARE ITEM_CSR FOR SELECT I.ITEM_ID, I.ITEM_QTY, CASE WHEN P.PRICE_ITEM_ID IS NULL THEN 'N' ELSE 'Y' END, COALESCE(P.PRICE_AMT,0), COALESCE(P.PRICE_STATUS,' ') FROM ITEM I LEFT JOIN ITEM_PRICE P ON P.PRICE_ITEM_ID=I.ITEM_ID WHERE I.ITEM_STATUS=? ORDER BY <original order>
```
`<original order>` is whatever order the old cursor produced. If it had no ORDER BY, check what order it actually returned before choosing one.

**Each FETCH maps the new columns** into a small holder record (a `RecordEntity` with one field per new column):
```java
SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
    .mapOutParameter(SQLParameterBuilder.newInstance(ctx.getItemId().getItemIdReference()))
    .mapOutParameter(SQLParameterBuilder.newInstance(ctx.getItemQty().getItemQtyReference()))
    .mapOutParameter(SQLParameterBuilder.newInstance(related.getFoundReference()))     // new
    .mapOutParameter(SQLParameterBuilder.newInstance(related.getAmtReference()))       // new
    .mapOutParameter(SQLParameterBuilder.newInstance(related.getStatusReference()))    // new
    .execute("PROG_4");
```

**The per-row SELECT becomes a copy**, leaving the same fields and SQLCODE:
```java
/* ===== ORIGINAL =====
SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
    .mapInParameter(SQLParameterBuilder.newInstance(ctx.getItemId().getItemId()))
    .mapOutParameter(SQLParameterBuilder.newInstance(ctx.getPriceAmt().getPriceAmtReference()))
    .mapOutParameter(SQLParameterBuilder.newInstance(ctx.getPriceStatus().getPriceStatusReference()))
    .execute("PROG_9");
===== OPTIMIZED: values already fetched by PROG_1 ===== */
if ("Y".equals(related.getFound())) {
    ctx.getPriceAmt().getPriceAmtReference().setValue(related.getAmtReference());
    ctx.getPriceStatus().getPriceStatusReference().setValue(related.getStatusReference());
    ctx.getSqlca().setSqlcode(0);      // found
} else {
    ctx.getSqlca().setSqlcode(100);    // not found: output fields left untouched
}
```

Before running the job, compare the old and new cursor (row count, row order, and the joined values against the old per-row SELECT). Then verify end to end, because the AWS Transform for mainframe runtime may rewrite the statement.

## Verification

An optimization is verified only after the **real job runs end to end** on the rebuilt, redeployed application.

1. Rebuild and redeploy; the deployed SQL files change only on redeploy.
2. Prepare the test data exactly as for the baseline run. Prefer regenerating over resetting, since resets can change physical row order.
3. Treat as failure: a non-zero return code, any ERROR in the job log, new application or system exception records, or a run that is far faster than expected (it may not have processed anything).
4. Compare every output table with the baseline in both directions, and compare order where order matters.
5. Report baseline and optimized run times.

## SQLCODE Values

| Code | Meaning |
|------|---------|
| `0` | Success |
| `100` | Not found / End of data |
| `-501` | Cursor already opened |
| `-502` | Cursor already closed |
| `-803` | Duplicate key |
| Other negative | Statement failed; the job log has the underlying database error |
