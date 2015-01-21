#Twitter Update Module

##Introduction
This project is for a custom Spring XD sink to send Tweets to Twitter.  This module will normally be created as a tap in a stream to send Tweets based on some sort of condition.

##Installation

1. Clone this project.
2. Change directories to the root of the project, and run the command `mvn clean package`.  This will create a jar file that matches the module layout in Spring XD.
3. Start the Spring XD single node server.
4. Start the Spring XD shell and upload the module with the command `module upload --file <path-to-jar> --name twitter-update --type sink`.

##Application Registration

You need to register your application for access to your Twitter feed.  To register the application with Twitter, follow these [instructions](http://spring.io/guides/gs/register-twitter-app/).  Once it's registered, you will need these 4 properties:

* Consumer Key
* Consumer Secret
* Access Token
* Access Token Secret

*Make sure you give your application read and write access; otherwise it won't be able to send updates to your timeline.*

##Tap Creation

To create a tap with this sink, specify it as the sink for your tap like this:

`stream create --name eatontap --definition "tap:stream:eaton.csv-transformer > twitter-update --consumerKey=xxx --consumerSecret=xxx --accessToken=xxx --accessTokenSecret=xxx" --deploy`

Once the tap is invoked, you should see a new update posted in your timeline.
