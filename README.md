SimpleDropWizardTwitter
=======================

A simple [dropwizard.io](http://dropwizard.io) service which enables posting to Twitter using the [Twitter4J library](https://github.com/yusuke/twitter4j).

Compile
=======
  `mvn clean package`

Run
===
  You need to register an app with Twitter at [https://apps.twitter.com/](https://apps.twitter.com/). Give it a name,
  description, and a website, tick the "Yes I agree" checkbox to agree with the terms and conditions, and then click
  "Create your Twitter application".

  On the Permissions tab, change to "Read and Write", then click the "Update Settings" button.

  On the "API Keys" tab, click the "Create my access token" button (you may need to refresh a few times for the access
  token values to appear).

  You'll need the following values:-
  * "API Key" is the consumer key.
  * "API secret" is the consumer secret.
  * "Access Token" is the access token.
  * "Access token secret" is the access token secret.

  To run, do the following, replacing the placeholders with the values from the API Keys tab.
  ```
  export twitter4j_debug=true
  export twitter4j_oauth_consumerKey=<your_app_consumer_key>
  export twitter4j_oauth_consumerSecret=<your_app_consumer_secret>
  export twitter4j_oauth_accessToken=<your_app_access_token>
  export twitter4j_oauth_accessTokenSecret=<your_app_access_token_secret>
  java -jar target/SimpleDropWizardTwitter-1.0.0.jar server
  ```

Test
====
  * `curl -X POST http://localhost:8080/tweet?tweet=Test%20123`


Development Environment
=======================

  * MacOS => 10.9.2
  * `mvn -version` => `Maven 3.1.1`
  * `java -version` => `Java 1.7.0_45`
