# Step 1: Build stage (use Maven with JDK 17)
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy Maven project files
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
COPY src src

# Build the JAR inside Docker (skip tests to save time)
RUN ./mvnw clean package -DskipTests

# Step 2: Run stage (smaller image)
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the JAR from the builder stage
COPY --from=builder /app/target/backend-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Render sets PORT env automatically)
ENV PORT=8081
EXPOSE ${PORT}

# Start the application
ENTRYPOINT ["sh", "-c", "java -jar /app/app.jar --server.port=${PORT}"]
