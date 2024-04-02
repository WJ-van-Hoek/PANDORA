#!/bin/bash

PANDORA_PATH="./../.."
CALCULATION_SERVICES_PATH="${PANDORA_PATH}/pandora-calculation-services"
BOOT_PATH="${CALCULATION_SERVICES_PATH}/target"
FILE_NAME="${BOOT_PATH}/pandora-calculation-services-0.0.1-SNAPSHOT.jar"

./boot_spring_app.sh "$FILE_NAME"
