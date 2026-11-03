---
name: "batch-operations"
description: "Convert per-row DAO inserts and updates into batched database round-trips in the AWS Transform for mainframe runtime. Use when a loop performs multiple INSERTs or UPDATEs to the same table, when applying addRecordToBatch/batchWriteDirect/batchUpdateDirect, or when reasoning about DAO lock behavior."
license: "MIT-0"
metadata:
  author: "Amazon Web Services"
  version: "1.1.0"
---

# DAO Batch Operations Guide

## Overview

Use batch operations to convert multiple individual INSERT or UPDATE calls into a single database round-trip.

## Available Methods

| Method | Description |
|--------|-------------|
| `addRecordToBatch()` | Add current entity to batch list |
| `batchWriteDirect()` | INSERT all batched entities using JDBC batch |
| `batchUpdateDirect()` | UPDATE all batched entities using JDBC batch |
| `batchWrite()` | INSERT using JPA batch (slower than batchWriteDirect) |

## Basic Usage Pattern

```java
for (each item) {
    MyRecord record = new MyRecord(ctx.getConfiguration()); // NEW instance each time
    record.setField1(value1);
    record.setField2(value2);
    DAOManager.getDAO(ctx, FileIds.TABLE).withRecord(record).addRecordToBatch();
}
DAOManager.getDAO(ctx, FileIds.TABLE).batchWriteDirect();
```

## Critical Rules

### Rule 1: Create a NEW RecordEntity Instance for Each Batch Add

**WRONG — Reusing the same object:**
```java
MyRecord record = new MyRecord(ctx.getConfiguration());
for (item : items) {
    record.setField1(item.getValue());  // Overwrites previous values
    dao.withRecord(record).addRecordToBatch();  // All batch entries point to same object
}
dao.batchWriteDirect();  // All records have the LAST item's values!
```

**CORRECT — New instance each iteration:**
```java
for (item : items) {
    MyRecord record = new MyRecord(ctx.getConfiguration());  // NEW each time
    record.setField1(item.getValue());
    dao.withRecord(record).addRecordToBatch();
}
dao.batchWriteDirect();  // Each record has correct values
```

### Rule 2: Copy ALL Fields for Updates

For `batchUpdateDirect()`, the DAO uses the primary key to identify which row to update. You must copy ALL fields to the new instance, not just the ones you're changing.

```java
for (item : items) {
    MyRecord record = new MyRecord(ctx.getConfiguration());
    // Copy ALL fields, including PK
    record.setId(item.getId());           // PK - identifies the row
    record.setField1(item.getField1());   // Even if unchanged
    record.setField2(newValue);           // The field you're actually updating
    record.setField3(item.getField3());   // Even if unchanged
    dao.withRecord(record).addRecordToBatch();
}
dao.batchUpdateDirect();
```

### Rule 3: Indirect Writes Are Also Candidates

Batch optimization applies whether the DAO write/update is directly in the loop OR hidden inside a function called from the loop. See the `hotspot-identification` skill for details on recognizing and refactoring indirect cases.

### Rule 4: Programs Without DAOs

Programs migrated from COBOL/DB2 often write through SQLExecutorBuilder statements rather than DAOs, so the DAO batch methods don't apply directly. Per-row UPDATE/INSERT statements there are still candidates. Flush any batch at the program's existing commit points so commit and restart behavior stay the same, and preserve the original error handling. Confirm that a batching API exists for this case in the AWS Transform for mainframe runtime version in use before proposing it.

## When NOT to Batch

See the `hotspot-identification` skill for cases where batching isn't appropriate (immediate consistency, dependent operations, same-row conflicts).

## DAO Lock Behavior

Understanding locks is important when combining reads and updates:

- `retrieve()` without `.noLock()` acquires a lock on the row
- `.update()` requires this lock to be held
- Don't skip a locking read to reuse data from a prior `.noLock()` read — the lock state matters

```java
// CORRECT: Lock acquired, then update
dao.retrieve();  // Acquires lock
// modify record...
dao.update();    // Works because lock is held

// WRONG: No lock, update will fail or behave unexpectedly
dao.noLock().retrieve();  // No lock acquired
// modify record...
dao.update();  // May fail or cause issues
```

## Batch Write vs Batch Update Summary

| Operation | Method | Use When |
|-----------|--------|----------|
| Multiple INSERTs | `addRecordToBatch()` + `batchWriteDirect()` | Creating new records in a loop |
| Multiple UPDATEs | `addRecordToBatch()` + `batchUpdateDirect()` | Modifying existing records in a loop |

Both require new RecordEntity instances per batch add. Both execute as a single database round-trip.
