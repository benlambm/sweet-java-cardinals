NEW GUI VERSION INSTRUCTIONS:

The GUI version (Checkpoint 4) of our JavaSweets database application can be started by running the JavaSweetsDriverGUI java file.

Please note first though that the database must be imported in MySQL by using the included SQL script 'cardinalsDatabase.sql'.

Our MySQL setup is:
username = itp220,
password = itp220,
database name = cardinals220

Also, the JavaSweetsDriverDB requires a JDBC driver (mysql_connector_java_5.0.6_bin.jar must be in the classpath).

To login, we have hard-coded this sample login credentials here:
Owner-Login: username is cardinal, password is cardinal
Customer-Login: username is guest, password is guest [or create a new one]




OLD CONSOLE VERSION
Run JavaSweetsDriver to start program

Enter 1 to Load sample data (console version)

Owner-Login: username is cardinal, password is cardinal [hard-coded in]
Customer-Login: username is guest, password is guest [or create a new one]

The correct menu options load automatically depending on whether you sign in as customer or owner