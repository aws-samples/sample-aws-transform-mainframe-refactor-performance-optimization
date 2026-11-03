---
name: "getting-started"
description: "Choose the right performance optimization technique for AWS Transform for mainframe refactor applications. Use when starting a performance investigation, deciding between SQLExecutorBuilder, DAO batching, or caching, or looking up JDBCType/SQLCODE references."
license: "MIT-0"
metadata:
  author: "Amazon Web Services"
  version: "1.1.0"
---

# AWS Transform for mainframe Runtime Performance Optimization — Getting Started

## Overview

AWS Transform for mainframe refactor applications (migrated from AS/400 or z/OS COBOL/DB2) often have performance bottlenecks from patterns that worked on mainframes but don't translate well to Java/RDBMS. The most common is row-by-row processing: a cursor loop that makes several small database calls for every row. Use these techniques to identify those hotspots and implement optimizations:

- **SQLExecutorBuilder** — Execute custom SQL, cursors, aggregations, and joins directly
- **DAO Batch Operations** — Batch multiple writes/updates into single database round-trips
- **Pre-load Caching** — Replace repeated lookups with HashMap-based caching

## How to Work

1. **Read all skills in this power first.** Use them for both analysis and implementation, not only for ideas.
2. **Find the moving parts.** Locate the job script that runs the program, the program's main processing loop, every program it calls, and the SQL resource file its statement IDs come from.
3. **Measure before changing.** Count database calls per loop iteration, and compare the size of the driving table with the tables it looks up. Record a baseline run (time and output tables).
4. **Report, then wait.** List each hotspot with its location, calls per iteration and the pattern it matches. Implement only what is approved, and honor any constraints given.
5. **Implement with this power's patterns.** For each change, name the skill and section it follows. If nothing here fits, say so before improvising.
6. **Make changes reviewable.** Keep the original code as a comment next to the code that replaces it.
7. **Verify end to end** (see "Verification" in `sqlexecutorbuilder-guide`). A successful compile or a direct database test is not verification.

## When to Use Each Technique

| Technique | Use Case |
|-----------|----------|
| SQLExecutorBuilder | Custom SQL, cursors, aggregations, joins, set-based operations |
| Batch writes/updates | Multiple INSERTs or UPDATEs to same table in a loop |
| Pre-load cache | Repeated lookups of reference data, when most of the table is used |
| Lazy cache | Repeated lookups when only part of the data is touched, or the lookup goes through a called program |
| Join into the driving cursor | A related row fetched with a separate query for each cursor row |

## Database-Level vs Application-Level Processing

**Use SQLExecutorBuilder (database level) when:**
- Aggregations (SUM, COUNT, AVG, GROUP BY)
- Filtering large datasets (WHERE clauses)
- Joining multiple tables
- Sorting large result sets
- Complex calculations on many rows

**Keep at application level when:**
- Business logic is complex and procedural
- Results need to be cached for multiple uses
- Processing requires external service calls

## Related Skills

Once you've picked a direction, use the matching skill:

- **hotspot-identification** — How to identify performance bottlenecks in code
- **sqlexecutorbuilder-guide** — Complete SQLExecutorBuilder API reference and examples
- **batch-operations** — DAO batch write/update patterns and rules

## JDBCType Reference

| JDBCType | Java Type | SQL Type |
|----------|-----------|----------|
| `VARCHAR` | String | VARCHAR, CHAR |
| `INTEGER` | int, Integer | INT, INTEGER |
| `BIGINT` | long, Long | BIGINT |
| `DECIMAL` | BigDecimal | DECIMAL, NUMERIC |
| `DATE` | LocalDate, String | DATE |
| `TIMESTAMP` | Timestamp, String | TIMESTAMP |
| `TIME` | LocalTime, String | TIME |

## SQLCODE Reference

| Code | Meaning |
|------|---------|
| `0` | Success |
| `100` | Not found / End of data |
| `-501` | Cursor already opened |
| `-502` | Cursor already closed |
| `-803` | Duplicate key |
