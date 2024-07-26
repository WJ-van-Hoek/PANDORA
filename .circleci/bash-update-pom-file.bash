#!/bin/bash

check_if_parent_pom() {
  # Parameters
  TARGET_GROUP_ID=$1
  TARGET_ARTIFACT_ID=$2
  POM_FILE=$3

  if [[ -z "$TARGET_GROUP_ID" || -z "$TARGET_ARTIFACT_ID" || -z "$POM_FILE" ]]; then
    echo "Usage: $0 <target.groupId> <target.artifactId> <pomFile>"
    exit 1
  fi

  # Extract the parent information using grep and sed
  PARENT_GROUP_ID=$(grep -A3 "<parent>" "$POM_FILE" | grep "<groupId>" | sed -E 's|<groupId>(.*)</groupId>|\1|' | xargs)
  PARENT_ARTIFACT_ID=$(grep -A3 "<parent>" "$POM_FILE" | grep "<artifactId>" | sed -E 's|<artifactId>(.*)</artifactId>|\1|' | xargs)

  echo $PARENT_GROUP_ID
  echo $PARENT_ARTIFACT_ID

  # Check if the extracted parent matches the target groupId and artifactId
  if [[ "$PARENT_GROUP_ID" == "$TARGET_GROUP_ID" && "$PARENT_ARTIFACT_ID" == "$TARGET_ARTIFACT_ID" ]]; then
    echo "The POM file $POM_FILE has the specified parent (groupId: $TARGET_GROUP_ID, artifactId: $TARGET_ARTIFACT_ID)."
    return 0
  else
    echo "The POM file $POM_FILE does not have the specified parent (groupId: $TARGET_GROUP_ID, artifactId: $TARGET_ARTIFACT_ID)."
    return 1
  fi
}

update_pom_file() {
  # Parameters
  GROUP_ID=$1
  ARTIFACT_ID=$2
  PROPERTY_NAME="$ARTIFACT_ID.version"
  NEW_VERSION=$3
  POM_FILE=$4

  if [[ -z "$GROUP_ID" || -z "$ARTIFACT_ID" || -z "$NEW_VERSION" || -z "$POM_FILE" ]]; then
    echo "Usage: $0 <groupId> <artifactId> <newVersion> <pomFile>"
    exit 1
  fi

  # Check if the specified groupId and artifactId are the parent of the POM file
  if check_if_parent_pom "$GROUP_ID" "$ARTIFACT_ID" "$POM_FILE"; then
    # Update the version in the <parent> section
    sed -i.bak "/<parent>/,/<\/parent>/s|<version>.*</version>|<version>${NEW_VERSION}</version>|" "$POM_FILE"
  else
    # Use sed to update the property version
    sed -i.bak "s#<${PROPERTY_NAME}>.*</${PROPERTY_NAME}>#<${PROPERTY_NAME}>${NEW_VERSION}</${PROPERTY_NAME}>#" "$POM_FILE"
    echo "Updated ${PROPERTY_NAME} to version ${NEW_VERSION} in ${POM_FILE}"
  fi
}

#check_if_parent_pom 'com.general' 'plugin-parent-pom' 'pom.xml'
#update_pom_file 'com.general' 'plugin-parent-pom' '0.0.4' 'pom.xml'
