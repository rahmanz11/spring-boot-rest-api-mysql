## Spring Boot MySQL REST API Application

## Configuration
Please check the file src/main/resources/application.properties file for necessary configturation and database connectivity
Change information according to your environment and requirement
To keep the integrity of the build and test, please make sure the contents of the both properties files are same:
src/main/resources/application.properties and
src/test/resources/application.properties

## For database
Please follow instructions in src/main/resources/db.sql 

## Build
gradlew build

## Run
gradlew bootRun

## Test
gradlew test

## Test class
Test classes are available in src/test/java/com/rest/api

## Libraris
org.springframework.boot:spring-boot-starter-data-jpa: To make the project compatible with Spring Data JPA for database operations
org.springframework.boot:spring-boot-starter-web: To make the project compatible for web service api development and auto configuration
mysql:mysql-connector-java: To connect to the mysql database
junit: For Junit test
org.springframework.boot:spring-boot-starter-test: To make the project compatible for spring boot test
excluded org.junit.vintage: To resolve confliction between Junit Jupiter and Vintage classes