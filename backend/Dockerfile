# Step 1: Use lightweight OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Step 2: Create working directory
WORKDIR /app

# Step 3: Copy the built JAR file into the image
COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose the port (Render will inject PORT automatically)
ENV PORT=8081
EXPOSE ${PORT}

# Step 5: Set entry point
ENTRYPOINT ["sh", "-c", "java -jar /app/app.jar --server.port=${PORT}"]