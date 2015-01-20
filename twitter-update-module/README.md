#Twitter Channel Adapter

##Introduction
This project is for a custom Spring XD sink to send Tweets to Twitter.  This module will normally be created as a tap in a stream to send Tweets based on some sort of condition.

##Installation

1. Clone this project.
2. Change directories to the root of the project, and run the command `gradle build`.
3. Copy the `src/main/resources/twitter-update.xml` file to the `<spring-xd>/xd/modules/sink` directory.
4. Download the following JAR files and put them in the `<spring-xd>/xd/lib` directory:
    * [Spring Integration Twitter](http://central.maven.org/maven2/org/springframework/integration/spring-integration-twitter/4.1.2.RELEASE/spring-integration-twitter-4.1.2.RELEASE.jar)
    * [Spring Social Config](http://central.maven.org/maven2/org/springframework/social/spring-social-config/1.1.0.RELEASE/spring-social-config-1.1.0.RELEASE.jar)
    * [Spring Social Core](http://central.maven.org/maven2/org/springframework/social/spring-social-core/1.1.0.RELEASE/spring-social-core-1.1.0.RELEASE.jar)
    * [Spring Social Twitter](http://central.maven.org/maven2/org/springframework/social/spring-social-twitter/1.1.0.RELEASE/spring-social-twitter-1.1.0.RELEASE.jar)
    * [Spring Social Web](http://central.maven.org/maven2/org/springframework/social/spring-social-web/1.1.0.RELEASE/spring-social-web-1.1.0.RELEASE.jar)
5. Start the Spring XD single node server.

##Application Registration

You need to register your application for access to your Twitter feed.  To register the application with Twitter, follow these [instructions](http://spring.io/guides/gs/register-twitter-app/).  Once it's registered, you will need these 4 properties:

* Consumer Key
* Consumer Secret
* Access Token
* Access Token Secret

*Make sure you give your application read and write access; otherwise it won't be able to send updates to your timeline.*

##Tap Creation

To create a tap with this sink, specify it as the sink for your tap like this:

`stream create --name eatontap --definition "tap:stream:eaton.csvtransformer > twitter-update --consumerKey=xxx --consumerSecret=xxx --accessToken=xxx --accessTokenSecret=xxx" --deploy`

Once the tap is invoked, you should see a new update posted in your timeline.
