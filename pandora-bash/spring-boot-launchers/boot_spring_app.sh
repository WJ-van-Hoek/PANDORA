#!/bin/bash

# Check if JAR file argument is provided
if [ $# -lt 1 ]; then
  echo "Usage: $0 <path_to_spring_boot_app.jar> [additional_spring_boot_properties]"
  exit 1
fi

# Extract the JAR file path from the argument
SPRING_BOOT_APP="$1"

# Check if the JAR file exists
if [ ! -f "$SPRING_BOOT_APP" ]; then
  echo "Error: $SPRING_BOOT_APP not found!"
  exit 1
fi

# Extract Spring Boot properties if provided
PROPERTIES=""
if [ $# -gt 1 ]; then
  PROPERTIES="$2"
fi

# Launch the Spring Boot application with properties
java -jar "$SPRING_BOOT_APP" --spring.config.additional-location="$PROPERTIES" &

# Exit script
exit 0
