#CSV Transformer Module

##Introduction
This project is for a custom Spring XD transformer to transform an CSV payload into a JSON string payload.  The JSON string payload can then be used by the Spring XD JDBC sink to insert into a database.

##Installation

1. Clone this project.
2. Change directories to the root of the project, and run the command `mvn clean package`.  This will create a jar file that matches the module layout in Spring XD.
3. Start the Spring XD single node server.
4. Start the Spring XD shell and upload the module with the command `module upload --file <path-to-jar> --name csv-transformer --type processor`.

