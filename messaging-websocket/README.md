## Messaging with websocket

The **@MessageMapping** annotation ensures that if a message is sent to destination "/hello", then the greeting() method is called.
The payload of the message is bound to a HelloMessage object which is passed into greeting().

Internally, the implementation of the method simulates a processing delay by causing the thread to sleep for 1 second. 
This is to demonstrate that after the client sends a message, the server can take as long as it needs to process the message asynchronously. 
The client may continue with whatever work it needs to do without waiting on the response.

After the 1 second delay, the greeting() method creates a Greeting object and returns it. The return value is broadcast to all subscribers
to "/topic/greetings" as specified in the @SendTo annotation. Note that the name from the input message is sanitized since in this case it 
will be echoed back and re-rendered in the browser DOM on the client side.

## Configure Spring for STOMP messaging annotations

WebSocketConfig is annotated with @Configuration to indicate that it is a Spring configuration class. It is also annotated **@EnableWebSocketMessageBroker**. 
As its name suggests, @EnableWebSocketMessageBroker enables WebSocket message handling, backed by a message broker.

The **configureMessageBroker()** method implements the default method in **WebSocketMessageBrokerConfigurer** to configure the message broker. 
It starts by calling **enableSimpleBroker()** to enable a simple memory-based message broker to carry the greeting messages back to the client on destinations prefixed with **"/topic"**. 
It also designates the **"/app"** prefix for messages that are bound for **@MessageMapping-annotated** methods. This prefix will be used to define all the message mappings; 
for example, **"/app/hello"** is the endpoint that the GreetingController.greeting() method is mapped to handle.