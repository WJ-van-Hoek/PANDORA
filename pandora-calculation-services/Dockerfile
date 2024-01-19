# Use the official OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/pandora-calculation-0.0.1-SNAPSHOT.jar /app/pandora-calculation-0.0.1-SNAPSHOT.jar

# Expose the port that your Spring Boot application listens on (default is 8080)
EXPOSE 9001

# Define the command to run your Spring Boot application
CMD ["java", "-jar", "pandora-calculation-0.0.1-SNAPSHOT.jar"]