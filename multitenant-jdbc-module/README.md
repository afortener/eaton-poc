#Multitenant JDBC Module

##Introduction
This project is an extension of the standard JDBC sink module to support multitenancy.  The outbound adapter will insert into a table whose named is based on the multitenant field value specified.  For example, consider the following:

* The table name variable is `eaton`
* The multitenant field value variable is `source_id`
* A JSON object is received whose `source_id` value is `100`

The resulting values will then be inserted into a table named `eaton100`

##Installation

1. Clone this project.
2. Change directories to the root of the project, and run the command `mvn clean package`.  This will create a jar file that matches the module layout in Spring XD.
3. Start the Spring XD single node server.
4. Start the Spring XD shell and upload the module with the command `module upload --file <path-to-jar> --name multitenant-jdbc --type sink`.
