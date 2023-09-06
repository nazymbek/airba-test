FROM maven:3.3.9-jdk-8

COPY src /src/test/java/api

COPY pom.xml /airba-test-master/pom.xml

WORKDIR /apitesting/Restassured

ENTRYPOINT mvn clean test





