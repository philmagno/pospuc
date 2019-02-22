FROM openjdk:8-jdk-alpine

VOLUME /tmp

COPY target/*.jar api.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/api.jar"]