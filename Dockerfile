# Stage 1: Build the application
FROM maven:3.8.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/supervisor-back-0.0.1-SNAPSHOT.jar ./supervisor-back.jar
CMD ["java", "-jar", "supervisor-back.jar"]
