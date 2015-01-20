#CSV Transformer

##Introduction
This project is for a custom Spring XD transformer to transform an CSV payload into a JSON string payload.  The JSON string payload can then be used by the Spring XD JDBC sink to insert into a database.

##Installation

1. Clone this project.
2. Change directories to the root of the project, and run the command `gradle build`.
3. Copy the `build/libs/csv-transformer-<version>.jar` file to the `<spring-xd>/xd/lib` directory.
4. Copy the `src/main/resources/csvtransformer.xml` file to `<spring-xd>/xd/modules/processor` directory.
5. Download the [org.json](http://central.maven.org/maven2/org/json/json/20141113/json-20141113.jar) jar file and put in the `<spring-xd>/xd/lib` directory.
6. Copy the `gemfirexd-client.jar` file from the `<gemfirexd>/lib` directory to the `<spring-xd>/xd/lib` directory.
6. Start the Spring XD single node server.

