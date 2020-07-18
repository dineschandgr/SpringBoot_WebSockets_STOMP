# SpringBoot_WebSockets_STOMP

Websockets using Spring Boot Framework and STOMP protocol

**WebSockets**

WebSocket is a thin, lightweight layer above TCP. This makes it suitable for using “subprotocols” to embed messages. 

In this application,i use STOMP messaging protocol with Spring to create an interactive web application.

The websocket open a connection through which client and the server communicate. The connection is disconnected only by the client

The Client pushes the mesage through the queue topic and server also pushes the reponse back in the same queue

**Prerequisities**

1. We need spring-boot-starter-websocket dependency for the backend
2. We need the 5 dependencies as defined in pom.xml for the front end client

**Back End Server**

1. @MessageMapping("/hello") annotation is used to send message from the client to the server

2. @SendTo("/topic/user") annotation is used to sebd message from the server to the client

3. - AN in-memory queue would be created to hold the message in the topic /topic/user

4. A STOMP endpoint is configured with /websocket-example, to which the java script client connects to write the message

5. A Scheduler class SchedulerConfig is configured with @EnableScheduling annotation
to write message to the queue every 3 secs and these messages will be delivered to the client with websockets

**FRONT END Client**

The follwing java script libraries are used in the front end index.html

 1. <script src="/webjars/jquery/jquery.min.js"></script>
 2. <script src="/webjars/sockjs-client/sockjs.min.js"></script>
 3. <script src="/webjars/stomp-websocket/stomp.min.js"></script>
 
 The app.js has all the logic which includes opening the socket and connecting to the STOMP end point
 
 var socket = new SockJS('/websocket-example');
 
 **Steps**
 
 1. Start the Spring Boot server with the url http://localhost:8080
 2. Click the connect button to open a websocket connection from client to server
 3. A connection is opened once the server accepts it
 4. Then the scheduler sends a message every 3 second to the queue in the topic \topic\user which is pushed to the client 
 5. When a message is typed and sent from client side, server receives the message and responds back to the client
 6. The connection is disconnected only when we click disconnect button or close the browser window
