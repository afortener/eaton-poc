#Rabbit Decoder Module

##Introduction
This is a customer Spring XD source module to listen for messsages on a
RabbitMQ queue, and decode the bytes into a CSV format for upstream
modules.

##Installation

1. Clone this project.
2. Change directories to the root of the project, and run the command `mvn clean package`.  This will create a jar file that matches the module layout in Spring XD.
3. Start the Spring XD single node server.
4. Start the Spring XD shell and upload the module with the command `module upload --file <path-to-jar> --name rabbit-decoder --type source`.

