# SQL File Locations

SQLExecutorBuilder runs statements by ID (e.g. `.execute("PROG_5")`). The SQL text lives in a per-program properties file (`ID=SQL`, `#` for comments).

- **Source:** usually `src/main/resources/sql/PROGRAMNAME.sql` in the service module. Find it by searching for the statement ID used in the code.
- **Runtime:** the copy the server actually loads. Depending on the setup it is packaged into the deployed application or kept in a server-side `sql/` folder.

Keep both in sync. If the runtime copy is packaged, a source change has no effect until the application is rebuilt and redeployed.
