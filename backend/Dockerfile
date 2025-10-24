# Step 1: Build stage
FROM maven:3.9.9-eclipse-temurin-17 AS builder
WORKDIR /app

# Copy pom.xml and wrapper files
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Give execute permission to mvnw
RUN chmod +x mvnw

# Copy the rest of the source code
COPY src src

# Build the JAR inside Docker (skip tests to save time)
RUN ./mvnw clean package -DskipTests

# Step 2: Run stage (smaller image)
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy only the final jar from the builder stage
COPY --from=builder /app/target/backend-0.0.1-SNAPSHOT.jar app.jar

# Expose port (optional)
EXPOSE 8081

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
