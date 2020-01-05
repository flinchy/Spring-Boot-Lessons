# Scheduling Tasks with Spring

*The Scheduled annotation defines when a particular method runs*. 
NOTE: This example uses **fixedRate**, which specifies the interval between method invocations measured from the start time of each invocation. 
There are other options, like **fixedDelay**, which specifies the interval between invocations measured from the completion of the task. 
You can also use **@Scheduled(cron=". . .")** expressions for more sophisticated task scheduling.

### Enable Scheduling
Although scheduled tasks can be embedded in web apps and WAR files, the simpler approach demonstrated below creates a standalone application. 
You package everything in a single, executable JAR file, driven by a good old Java main() method. 

@EnableScheduling ensures that a background task executor is created. Without it, nothing gets scheduled.