Department service is a REST API implemented using Spring boot
that registers to Discovery Service.

Application.yml is used to configure all properties
    Spring Profiles determine the active profiles

Source:https://www.youtube.com/watch?v=c3gKseNAs9w
https://www.youtube.com/watch?v=VAmntTPebKE
https://www.youtube.com/watch?v=SzbeDqBSRkc
https://www.youtube.com/watch?v=VVn9OG9nfH0

Service registry
----------------
We register Department Service to service registry which is a 
eureka server running in http://localhost:8761/

actuator
========
Check the status of the application
add management:Web:endpoints in application.yml to expose
all endpoints inside /actuator
https://www.baeldung.com/spring-boot-actuator-enable-endpoints

Spring Data Rest
================
https://www.baeldung.com/spring-data-rest-intro

Build
==========
mvn clean install 
    
This Creates Jar file per the name specified in pom file/<finalName>department-service-vmn</finalName>
Jar file can be found in target/ directory

Running the Appplication
==========================
cd target
java -jar "jarfilename" --spring.profiles.active=qa

Dockerezing
============
Dockerfile is used to mention the required imports for the docker
image and the actual Jar file to be dockerized