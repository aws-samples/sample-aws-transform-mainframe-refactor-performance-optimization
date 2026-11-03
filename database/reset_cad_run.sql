-- Reset CAD orders and run output so ACCPCAD can be re-run on the same data
-- (use between baseline and optimized runs).
--   psql -h localhost -U postgres -d tradingapp -f reset_cad_run.sql
BEGIN;
UPDATE tbtrdord SET ord_status = '101' WHERE ord_currency = 'CAD' AND ord_status <> '101';
TRUNCATE tbtrdstq, tbtrdexc, tbtrdsum, tbtrdlog;
COMMIT;
SELECT ord_status, count(*) FROM tbtrdord WHERE ord_currency = 'CAD' GROUP BY 1;
