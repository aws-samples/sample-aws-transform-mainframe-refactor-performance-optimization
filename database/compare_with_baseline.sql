-- Compare the latest ACCPCAD run with the saved baseline (base_* tables).
-- Read-only. Every check should show diff = 0 and result = PASS.
--   psql -h localhost -U postgres -d tradingapp -f compare_with_baseline.sql
--
-- Baseline tables are created after the unoptimized run with:
--   CREATE TABLE base_ord AS SELECT * FROM tbtrdord WHERE ord_currency = 'CAD';
--   CREATE TABLE base_stq AS SELECT * FROM tbtrdstq;
--   CREATE TABLE base_exc AS SELECT * FROM tbtrdexc;
--   CREATE TABLE base_sum AS SELECT * FROM tbtrdsum;
--   CREATE TABLE base_log AS SELECT * FROM tbtrdlog;
-- IDs (stq_id, exc_id) are not compared: identity counters keep counting across runs.

WITH checks AS (
  SELECT 1 n, 'TBTRDORD rows (both directions)' check_name,
         (SELECT count(*) FROM (
            (SELECT * FROM tbtrdord WHERE ord_currency = 'CAD' EXCEPT ALL SELECT * FROM base_ord)
            UNION ALL
            (SELECT * FROM base_ord EXCEPT ALL SELECT * FROM tbtrdord WHERE ord_currency = 'CAD')) x) diff
  UNION ALL
  SELECT 2, 'TBTRDSTQ rows (both directions)',
         (SELECT count(*) FROM (
            (SELECT stq_currency, stq_trade_data FROM tbtrdstq EXCEPT ALL SELECT stq_currency, stq_trade_data FROM base_stq)
            UNION ALL
            (SELECT stq_currency, stq_trade_data FROM base_stq EXCEPT ALL SELECT stq_currency, stq_trade_data FROM tbtrdstq)) x)
  UNION ALL
  SELECT 3, 'TBTRDSTQ order (by STQ_ID)',
         (SELECT count(*) FROM
            (SELECT row_number() OVER (ORDER BY stq_id) rn, stq_currency, stq_trade_data FROM tbtrdstq) n
            FULL JOIN
            (SELECT row_number() OVER (ORDER BY stq_id) rn, stq_currency, stq_trade_data FROM base_stq) b USING (rn)
          WHERE (n.stq_currency, n.stq_trade_data) IS DISTINCT FROM (b.stq_currency, b.stq_trade_data))
  UNION ALL
  SELECT 4, 'TBTRDEXC rows (both directions)',
         (SELECT count(*) FROM (
            (SELECT exc_type, exc_description FROM tbtrdexc EXCEPT ALL SELECT exc_type, exc_description FROM base_exc)
            UNION ALL
            (SELECT exc_type, exc_description FROM base_exc EXCEPT ALL SELECT exc_type, exc_description FROM tbtrdexc)) x)
  UNION ALL
  SELECT 5, 'TBTRDEXC order (by EXC_ID)',
         (SELECT count(*) FROM
            (SELECT row_number() OVER (ORDER BY exc_id) rn, exc_type, exc_description FROM tbtrdexc) n
            FULL JOIN
            (SELECT row_number() OVER (ORDER BY exc_id) rn, exc_type, exc_description FROM base_exc) b USING (rn)
          WHERE (n.exc_type, n.exc_description) IS DISTINCT FROM (b.exc_type, b.exc_description))
  UNION ALL
  SELECT 6, 'TBTRDSUM rows (both directions)',
         (SELECT count(*) FROM (
            (SELECT * FROM tbtrdsum EXCEPT ALL SELECT * FROM base_sum)
            UNION ALL
            (SELECT * FROM base_sum EXCEPT ALL SELECT * FROM tbtrdsum)) x)
  UNION ALL
  SELECT 7, 'No APPLICATION/SYSTEM exceptions in this run',
         (SELECT count(*) FROM tbtrdexc WHERE exc_type <> 'DATA')
)
SELECT n, check_name, diff, CASE WHEN diff = 0 THEN 'PASS' ELSE 'FAIL' END AS result
FROM checks ORDER BY n;

-- Row counts, for context
SELECT 'orders'  t, (SELECT count(*) FROM base_ord) baseline, (SELECT count(*) FROM tbtrdord WHERE ord_currency = 'CAD') latest
UNION ALL SELECT 'stq', (SELECT count(*) FROM base_stq), (SELECT count(*) FROM tbtrdstq)
UNION ALL SELECT 'exc', (SELECT count(*) FROM base_exc), (SELECT count(*) FROM tbtrdexc)
UNION ALL SELECT 'sum', (SELECT count(*) FROM base_sum), (SELECT count(*) FROM tbtrdsum);

-- Run times (needs base_log; skip this query if it doesn't exist)
SELECT 'baseline' run, log_start_ts, log_end_ts,
       to_timestamp(trim(log_end_ts), 'YYYY-MM-DD HH24:MI:SS') - to_timestamp(trim(log_start_ts), 'YYYY-MM-DD HH24:MI:SS') AS elapsed
FROM base_log WHERE log_transaction = 'ACCEPTANCE' AND log_currency = 'CAD'
UNION ALL
SELECT 'latest', log_start_ts, log_end_ts,
       to_timestamp(trim(log_end_ts), 'YYYY-MM-DD HH24:MI:SS') - to_timestamp(trim(log_start_ts), 'YYYY-MM-DD HH24:MI:SS')
FROM tbtrdlog WHERE log_transaction = 'ACCEPTANCE' AND log_currency = 'CAD';
