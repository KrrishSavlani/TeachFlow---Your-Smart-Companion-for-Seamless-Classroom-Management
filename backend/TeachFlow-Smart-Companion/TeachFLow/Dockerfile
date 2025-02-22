# Use Ubuntu as the base image
FROM ubuntu:latest

# Install OpenJDK 17 and required dependencies
RUN apt update && apt install -y openjdk-17-jdk && rm -rf /var/lib/apt/lists/*

# Set working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container (change `backend.jar` to your actual JAR file name)
COPY target/backend.jar backend.jar

# Expose port 8080
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "backend.jar"]

