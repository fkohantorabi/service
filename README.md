What am I looking at?
-------------------------------------------
If you are doing any client/server project, chances are you have a service layer which needs to be protected and if you are writing lets say a native mobile app, you need endpoints for logging in and logging out instead of login forms and that, even thought those ones could be used too.

This project is a bare bone service layer in Java and Spring which exposes services through REST endpoints, and protects them with Spring security. The fine details of Spring security have been left out intentionally to increase customizability.

What are the endpoints?
-------------------------------------------
Assuming you are deploying on your local tomcat running on 8080, you will have the following endpoints:

* http://localhost:8080/service/s/start: This starts a new session by logging a hard coded user in. Eventually you will need this to accept username and password in a POST command and definitely over HTTPS.
* http://localhost:8080/service/s/stop: This one ends the user session. After this point the user is not authenticated anymore so the secure services will return a http unauthorized code.
* http://localhost:8080/service/public/hello: This is a public hello service. It will work whether the user is logged in or not.
* http://localhost:8080/service/secure/hello: This is a secure hello service. Unless the user is logged in, it will get a http unauthorized response upon calling.

Do I care about server side's session?
-------------------------------------------
Yes you do. Authenticated sessions are stored inside Java's http session. As it is, user sessions expire in one minute so that login expiries can be tried out. You will need to adjust this in web.xml.

How can I try this?
-------------------------------------------
This is a gradle project. If you don't have gradle plugin for Eclipse already, install it from Eclipse market place. Import the project it in Eclipse using the gradle import. Add the webapp to your tomcat server. Start the server and try the URLs above.
