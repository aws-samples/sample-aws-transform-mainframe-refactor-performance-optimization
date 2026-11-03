-- Test data for ACCPCAD (TRDPB000, order acceptance / matching) in currency CAD, exchange TSX.
-- Usage:
--   psql -h localhost -U postgres -d tradingapp -v orders=20000 -f generate_cad_data.sql
-- "orders" = number of buy/sell order pairs (each pair = 1 buy row + 1 sell row).
-- Re-running wipes and recreates all CAD data.

\if :{?orders}
\else
  \set orders 20000
\endif
\set customers 2000
\set securities 1000

BEGIN;

-- Clean previous run output and CAD data
TRUNCATE tbtrdstq, tbtrdexc, tbtrdsum, tbtrdlog;
DELETE FROM tbtrdord WHERE ord_currency = 'CAD';
DELETE FROM tbtrdsac WHERE sac_currency = 'CAD';
DELETE FROM tbtrdmac WHERE mac_currency = 'CAD';
DELETE FROM tbtrdcus WHERE cus_currency = 'CAD';
DELETE FROM tbtrdsec WHERE sec_currency = 'CAD';

-- Customers: ~2% inactive ('I') so some orders take the overdue/exception path
INSERT INTO tbtrdcus (cus_customer_id, cus_currency, cus_description, cus_status)
SELECT 'CADC' || lpad(g::text, 8, '0'), 'CAD', 'CAD customer ' || g,
       CASE WHEN g % 50 = 0 THEN 'I' ELSE 'A' END
FROM generate_series(1, :customers) g;

-- Securities (FIGI-like ids)
INSERT INTO tbtrdsec (sec_figi, sec_currency, sec_description, sec_symbol, sec_share_class_figi, sec_type)
SELECT 'BBGCAD' || lpad(g::text, 6, '0'), 'CAD', 'CAD security ' || g, 'TSX' || g,
       'BBGSCL' || lpad(g::text, 6, '0'), 'Common Stock'
FROM generate_series(1, :securities) g;

-- One active security account and one active money account per customer
INSERT INTO tbtrdsac (sac_currency, sac_number, sac_customer_id, sac_status)
SELECT 'CAD', 100000 + g, 'CADC' || lpad(g::text, 8, '0'), 'A'
FROM generate_series(1, :customers) g;

INSERT INTO tbtrdmac (mac_currency, mac_number, mac_customer_id, mac_balance, mac_status)
SELECT 'CAD', 200000 + g, 'CADC' || lpad(g::text, 8, '0'), 1000000.00, 'A'
FROM generate_series(1, :customers) g;

-- Order pairs: buy (B) and sell (S) share trade id + FIGI, status 101 = ACCEPTED
WITH p AS (
  SELECT g,
         lpad(g::text, 12, '0')                                          AS tradeid,
         'BBGCAD' || lpad((1 + (g * 7) % :securities)::text, 6, '0')     AS figi,
         'CADC' || lpad((1 + (g * 13) % :customers)::text, 8, '0')       AS buyer,
         'CADC' || lpad((1 + (g * 17 + 1) % :customers)::text, 8, '0')   AS seller,
         (1 + g % 500)::numeric(9,2)                                     AS qty,
         (10 + (g % 9000))::numeric(9,2)                                 AS amt
  FROM generate_series(1, :orders) g
)
INSERT INTO tbtrdord (ord_trading_xchng, ord_tradeid, ord_buy_sell_ind, ord_customer_id,
                      ord_figi, ord_quantity, ord_currency, ord_amount, ord_status)
SELECT 'TSX', tradeid, 'B', buyer,  figi, qty, 'CAD', amt, '101' FROM p
UNION ALL
SELECT 'TSX', tradeid, 'S', seller, figi, qty, 'CAD', amt, '101' FROM p;

COMMIT;

ANALYZE tbtrdord; ANALYZE tbtrdcus; ANALYZE tbtrdsec; ANALYZE tbtrdsac; ANALYZE tbtrdmac;

SELECT ord_buy_sell_ind, ord_status, count(*) FROM tbtrdord
WHERE ord_currency = 'CAD' GROUP BY 1, 2 ORDER BY 1, 2;
