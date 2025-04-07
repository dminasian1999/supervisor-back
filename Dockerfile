## Stage 1: Build the application
#FROM maven:3.8.6-eclipse-temurin-17 AS builder
#WORKDIR /app
#COPY pom.xml .
#COPY src ./src
#RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY ./target/supervisor-back-0.0.1-SNAPSHOT.jar ./supervisor-back.jar
CMD ["java", "-jar", "/app/supervisor-back.jar"]