#!/bin/bash

# Project directory
PROJECT_DIR="C:\dev\workspaces\PANDORA\pandora-calculation"

# Docker image name
IMAGE_NAME="pandora-calculation"

# Version (can be a timestamp or any meaningful versioning)
VERSION="ALPHA_0.1"

# Navigate to the project directory
cd $PROJECT_DIR

# Build the Spring Boot project (use any build tool like Maven or Gradle)
mvn clean package  # Replace with your build command

# Run your tests here (e.g., unit tests)
mvn test  # Replace with your test command

# Build the Docker image using your Dockerfile
docker build -t $IMAGE_NAME:$VERSION .