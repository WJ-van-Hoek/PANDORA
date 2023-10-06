# Use the official OpenJDK base image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/pandora-data-0.0.1-SNAPSHOT.jar /app/pandora-data-0.0.1-SNAPSHOT.jar

# Expose the port that your Spring Boot application listens on (default is 8080)
EXPOSE 8081

# Define the command to run your Spring Boot application
CMD ["java", "-jar", "pandora-data-0.0.1-SNAPSHOT.jar"]