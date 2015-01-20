# Eaton PoC 

##Introduction
This repository contains projects for the Eaton PoC, relating to Spring XD flows and customizations.  It contains the following projects:

* [csv-transformer](./csv-transformer) - A custom transformer to transform from CSV to JSON.
* [twitter-channel-adapter](./twitter-channel-adapter) - A custom channel adapter to send messages to Twitter.

The rest of this document describes how to get the base Spring XD / GemFire XD environment running.

##Dependencies

* [Latest GemFire XD](https://network.pivotal.io/products/gemfirexd)
* [Latest Spring XD](http://repo.spring.io/release/org/springframework/xd/spring-xd/)
* [Gradle](http://gradle.org/downloads)
* [csv-transformer](./csv-transformer) and [twitter-channel-adapter](./twitter-channel-adapter) installed in your Spring XD environment (see their respective READMEs).

##Testing

1. Create a new table in GemFire XD:

    `create table app.eaton ("id" int generated always as identity, "site" integer, "publisher" varchar(100), "time" integer, "min_value" double, "max_value" double, "avg_value" double, "actual_value" double);`

2. Create a new stream in the Spring XD shell, using the CSV transformer in the flow:

    `stream create --name eaton --definition "http | csvtransformer | jdbc --url=jdbc:gemfirexd://192.168.56.101:1527 --driverClassName=com.pivotal.gemfirexd.jdbc.ClientDriver --username=app --password=app --columns=site,publisher,time,min_value,max_value,avg_value,actual_value" --deploy`

3. If you are using an HTTP source, post some sample CSV data in the Spring XD shell:

    `http post --target http://localhost:9000 --data "site, publisher, time, min_value, max_value, avg_value, actual_value\n1, 74dcbbfc-09bf-4cf4-b8c3-ccab062f9808, 100, 1420088400, 81.932060, 91.932060, 86.932060, 87.932060"`

4. Verify a record was created in the GemFire XD table.

    `select * from app.eaton;`
