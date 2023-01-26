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