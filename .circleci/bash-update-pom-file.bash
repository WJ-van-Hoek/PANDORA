#!/bin/bash

update_pom_file() {
  # Parameters
  PROPERTY_NAME=$1
  NEW_VERSION=$2
  POM_FILE=$3

  if [[ -z "$PROPERTY_NAME" || -z "$NEW_VERSION" || -z "$POM_FILE" ]]; then
    echo "Usage: $0 <property.name> <newVersion> <pomFile>"
    exit 1
  fi

  # Use sed to update the property version
  sed -i.bak "s#<${PROPERTY_NAME}>.*</${PROPERTY_NAME}>#<${PROPERTY_NAME}>${NEW_VERSION}</${PROPERTY_NAME}>#" "$POM_FILE"

  echo "Updated ${PROPERTY_NAME} to version ${NEW_VERSION} in ${POM_FILE}"
}
