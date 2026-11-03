# aws-transform-mainframe-refactor-performance-optimization

> **Important:** This is sample code for demonstration and testing only.
> It is **not intended for production use**. The Tomcat server, database
> configuration, and batch job endpoints have no authentication or TLS, and the
> database role relies on passwordless loopback trust. Before using any part of this code in production,
> complete your own security review and apply the hardening steps in
> [SECURITY.md](SECURITY.md).

A z/OS COBOL/DB2 trading application, refactored to Java with **AWS Transform for mainframe** (runtime 5.274.0). It runs on Tomcat 10.1 (Java 21) with PostgreSQL. This repo is used to test the **Kiro performance optimization power** on a refactored batch job.

## Layout

| Folder | Contents |
|---|---|
| `app-pom/` | Refactored application (Maven): programs, JCL as Groovy scripts, SQL files |
| `server/` | Tomcat customizations only: `conf/`, `bin/config/*.yml`, `bin/setenv.sh`, control cards |
| `database/` | PostgreSQL DDL, CAD test data generator, reset script |
| `performance-optimization-power/` | The Kiro power used for the optimization |

## Prerequisites

| Requirement | Version used here | Notes |
|---|---|---|
| **AWS Transform for mainframe runtime** | 5.274.0 | **Not included in this repository.** See below. |
| Amazon Corretto JDK | 21 | Required, not just recommended. The runtime ships Groovy 4.0.16; on Java 23 jobs fail with `Unsupported class file major version 67`. |
| Apache Maven | 3.9.x | |
| Apache Tomcat | 10.1.x | |
| PostgreSQL | 14 or later (18 used here) | Local instance. `psql` is often not on `PATH` for packaged installs; use the full path to the client binary. |
| Node.js | Not required separately | The `app-web` module downloads its own Node via `frontend-maven-plugin`, so the first build needs network access. The Angular UI is not needed to run the batch benchmark. |

**Obtaining the runtime.** The AWS Transform for mainframe runtime libraries and the
`gapwalk_*` web applications are licensed vendor components. They are not
redistributed here, and `.gitignore` excludes them. You must obtain the 5.274.0
runtime archive yourself through your AWS Transform for mainframe entitlement, then:

1. Extract it so the runtime's Tomcat tree becomes the `server/` directory in this repository, keeping the `conf/`, `bin/config/` and control-card files that *are* tracked here.
2. Install the runtime's Maven artifacts (group `com.netfective.bluage`, version `5.274.0`) into your local Maven repository. The build declares them `provided`, so it will not download them from a public repository.

Without the runtime, this repository will not build or run. What it does contain
is the refactored application source, the database scripts, the Tomcat
configuration, and the Kiro power.

## The batch job: ACCPCAD

`ACCPCAD` runs program **TRDPB000** (order acceptance and matching) for currency CAD. It reads every accepted buy order through a cursor, finds the matching sell order, validates both customers, the security and four accounts, then marks the pair matched and queues it for settlement.

### Performance issue

The refactored code keeps the mainframe's row-by-row style. For every buy order it makes about 12 database round trips:

- 1 SELECT for the matching sell order
- 2 customer lookups and 1 security lookup, each through a sub-program call
- 4 account lookups (buyer and seller security and money accounts)
- 2 UPDATEs and 1 INSERT

Customers, securities and accounts are small reference tables, so the same rows are read again and again. Run time grows with the number of orders.

### How the Kiro power fixes it

The power's skills identify these hotspots and apply two of its patterns:

1. **Join in the database:** the buy-order cursor LEFT JOINs the matching sell order, removing one SELECT per order.
2. **HashMap cache:** customer, security and account lookups are cached on first read for the rest of the run. Errors and not-found results are not cached, so output is unchanged.

This cuts database statements per matched order from about 12 to about 4.

## Running

> Tomcat is bound to `127.0.0.1` on purpose. The batch endpoints have no
> authentication. Don't expose port 8080 without adding authentication
> (see [SECURITY.md](SECURITY.md)). If you run this on a remote host, reach it
> through an SSH tunnel rather than removing the `address` attribute.

### 1. Create the database and test data

Run both scripts as a PostgreSQL administrative user. They issue `DROP TABLE`,
`CREATE TABLE` and `TRUNCATE`:

```bash
createdb tradingapp
psql -d tradingapp -f database/tradingapp_pg.sql
psql -d tradingapp -v orders=200000 -f database/generate_cad_data.sql
```

`orders` is the number of buy/sell **pairs**, so `200000` creates 400,000 rows in
`TBTRDORD`, against 2,000 customers, 1,000 securities, 2,000 securities accounts
and 2,000 money accounts. The default is 20,000 pairs. Every 50th customer is
created inactive, so a small share of orders deliberately takes the
exception path.

### 2. Build

```bash
export JAVA_HOME=/path/to/amazon-corretto-21.jdk/Contents/Home
cd app-pom
mvn clean install -DskipTests
```

This produces `app-pom/app-service/target/app-service-1.0.0.war`.

### 3. Deploy

There is no context descriptor in `server/conf`, so deployment is a copy into the
Tomcat `webapps` directory:

```bash
cp app-pom/app-service/target/app-service-1.0.0.war $CATALINA_BASE/webapps/
```

If you deploy from an IDE instead, make sure only one Tomcat is running on port
8080. A leftover exploded application directory in `webapps/` shadows a newly
deployed WAR, and because `server/*` is gitignored, a stale deployment does not
show up in `git status`. When a run gives unexpected results, check the deployed
copy — for example whether `WEB-INF/classes/sql/TRDPB000.sql` contains the join —
rather than the source tree.

### 4. Start Tomcat

Start it with the working directory set to `server/bin`. The `IKJEFT01` control
cards are resolved relative to the working directory, as
`CLOUDFRM.TRADING.BATCHDB2.CARD/<member>`:

```bash
cd server/bin
./startup.sh
```

`server/bin/setenv.sh` sets `JAVA_HOME` and the heap (`-Xms1g -Xmx4g`). Confirm
the server is on loopback only:

```bash
lsof -nP -iTCP:8080 -sTCP:LISTEN     # expect 127.0.0.1:8080
```

### 5. Run the job

```bash
time curl localhost:8080/gapwalk_application/script/ACCPCAD
```

A clean run ends with `Program return code is 0` in the Tomcat log and no
`APPLICATION` or `SYSTEM` exception rows in `TBTRDEXC`.

### Re-running

`ACCPCAD` only processes orders in status `101`, and a second run against
already-matched data abends. Before each run, either:

- regenerate the data with `database/generate_cad_data.sql` — preferred when comparing two runs, because it restores the same physical row order; or
- run `database/reset_cad_run.sql`, which is faster but rewrites every order row and therefore changes physical row order, and with it the order of rows written to `TBTRDSTQ` and `TBTRDEXC`.

Downstream, `SETLCAD` (program `TRDPB001`) settles what `ACCPCAD` queued. It is
not part of the optimization work in this repository.

## Database credentials

Two logins are involved:

| Login | Used by | Privileges |
|---|---|---|
| Administrative (for example `postgres`) | The scripts in `database/` | Full. They issue `DROP TABLE`, `CREATE TABLE` and `TRUNCATE`. |
| `tradingapp_app` | The application at runtime | `SELECT`, `INSERT`, `UPDATE`, `DELETE` on the `tradingapp` tables only |

`tradingapp_app` is created by the last section of `database/tradingapp_pg.sql`,
so running that script is what sets it up. The three datasources in
`server/conf/server.xml` (`jdbc/bluesam`, `jdbc/blu4iv`, `jdbc/primary`) point at
`jdbc:postgresql://localhost:5432/tradingapp` as that role, with an **empty
`password` attribute**. That is deliberate: the sample expects loopback
connections to be trusted in `pg_hba.conf`, restricted to `127.0.0.1`.

**Never put a database password in `server.xml`.** It is a tracked file, so a
password placed there is one `git add` away from being published. If your
PostgreSQL instance requires password authentication, configure it locally rather
than committing a credential — and see [SECURITY.md](SECURITY.md) for how
credentials should be handled outside a sample.

If a `CREATE` or `TRUNCATE` fails at runtime, run that statement under the
administrative login. Do not grant more privileges to `tradingapp_app`, and do
not switch the datasources back to a superuser.

Tomcat reads `server.xml` from `CATALINA_BASE`, which is not always this
repository — IDE run configurations usually supply their own. If a configuration
change appears to have no effect, check which `conf/server.xml` is actually in
use.

## Using the Kiro power

`performance-optimization-power/` is a [Kiro](https://kiro.dev) power: four
skills that describe how to find and remove per-row database round-trips in an
application refactored by AWS Transform for mainframe. It contains no MCP server,
so it contributes knowledge rather than tools.

| Skill | Covers |
|---|---|
| `getting-started` | Which technique to choose, and the measure-first workflow |
| `hotspot-identification` | The antipattern taxonomy, and counting round-trips per iteration |
| `sqlexecutorbuilder-guide` | Cursor mechanics, rewriting cursor SQL safely, the lazy cache pattern |
| `batch-operations` | The DAO batch API, and when it does not apply |

To install it, copy the directory into your Kiro powers directory:

```bash
cp -R performance-optimization-power ~/.kiro/powers/installed/
```

Alternatively, add it in Kiro as a local power source pointing at this directory.
Then ask Kiro to optimize a batch program, and it will load the relevant skill.

The skills are deliberately generic: they contain no program, table or job names
from this application, so they can be applied to other refactored applications.

## Cleanup

```bash
# 1. Stop Tomcat
$CATALINA_HOME/bin/shutdown.sh

# 2. Remove the deployed application (WAR and exploded directory)
rm -rf $CATALINA_BASE/webapps/app-service-1.0.0.war $CATALINA_BASE/webapps/app_service

# 3. Drop the database and the application role
dropdb tradingapp
dropuser tradingapp_app
```

Run both commands as the administrative user that created them. Build output under `app-pom/*/target/` and Tomcat's `logs/`
and `temp/` directories can be deleted too; a full ACCPCAD run writes roughly
400,000 lines to `catalina.out`.

## Security

See [SECURITY.md](SECURITY.md) for the known gaps in this sample — no
authentication, no TLS, a privileged database login — and what to do instead in
production. Report vulnerabilities through the process described there, not as a
public issue.

## Contributing and license

Contributions are welcome; see [CONTRIBUTING.md](CONTRIBUTING.md). This project is
licensed under the MIT-0 License; see [LICENSE](LICENSE).
