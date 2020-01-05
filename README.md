# spring-boot-lesson note

The **Spring Boot Maven plugin** provides many convenient features:
- It collects all the jars on the classpath and builds a single, runnable "über-jar", which makes it more convenient to execute and transport your service.
- It searches for the **public static void main()** method to flag as a runnable class.
- It provides a built-in dependency resolver that sets the version number to match Spring Boot dependencies. You can override any version you wish, but it will default to Boot’s chosen set of versions.

#### @SpringBootApplication is a convenience annotation that adds all of the following:
- @Configuration: Tags the class as a source of bean definitions for the application context.
- @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. 
For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, 
such as setting up a DispatcherServlet.
- @ComponentScan: Tells Spring to look for other components, configurations, and services in the hello package, letting it find the controllers.

The main() method uses Spring Boot’s SpringApplication.run() method to launch an application. Did you notice that there was not a single line of XML? There is no web.xml file, either. 
This web application is 100% pure Java and you did not have to deal with configuring any plumbing or infrastructure.

### Build an executable JAR

You can run the application from the command line with Gradle or Maven. You can also build a single executable JAR file that contains all the necessary dependencies, classes, and resources and run that. 
Building an executable jar so makes it easy to ship, version, and deploy the service as an application throughout the development lifecycle, across different environments, and so forth.

If you use Gradle, you can run the application by using **./gradlew bootRun**. Alternatively, you can build the JAR file by using **./gradlew build** and then run the JAR file, as follows:

```
java -jar build/libs/gs-scheduling-tasks-0.1.0.jar
```

If you use Maven, you can run the application by using **./mvnw spring-boot:run**. Alternatively, you can build the JAR file with **./mvnw clean package** and then run the JAR file, as follows:

```
java -jar target/gs-scheduling-tasks-0.1.0.jar
```