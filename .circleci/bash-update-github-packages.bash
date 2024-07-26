#!/bin/bash

# Source the necessary scripts
source ./.circleci/bash-find-github-packages.bash > /dev/null
source ./.circleci/bash-fetch-github-packages.bash > /dev/null
source ./.circleci/bash-update-pom-file.bash > /dev/null

# Function to find all directories that contain a pom.xml file
find_pom_directories() {
  local start_directory="$1"
  find "$start_directory" -path "*/target" -prune -o -name "pom.xml" -exec dirname {} \; | sed 's|$|/|'
}

# Function to process each package
update_single_package() {
  local package_name="$1"
  local user="$2"
  local pom_directory="$3"
  local origin_dir="$4"
  local groupId="${package_name%.*}"
  local artifactId="${package_name##*.}"

  echo " - $package_name (Found)"
  version_number=$(fetch_latest_version_number "$user" "maven" "$package_name")
  echo "Package: $package_name"
  echo "groupId: $groupId"
  echo "artifactId: $artifactId"
  echo "version: $version_number"
  
  cd "$pom_directory"
  update_pom_file $groupId $artifactId $version_number "pom.xml"
  cd "$origin_dir"
}

# Function to process a list of packages
process_packages() {
  local user="$1"
  local pom_directory="$2"
  local origin_dir="$3"
  local packages="$4"
  
  pom_file="$pom_directory/pom.xml"

  echo "Packages: $packages"
  # Iterate through each package
  echo "Iterating through Maven packages of $user:"
  while IFS= read -r package_name; do
    local groupId="${package_name%.*}"
    local artifactId="${package_name##*.}"
    echo "Package: $package_name"
    echo "groupId: $groupId"
    echo "artifactId: $artifactId"

    # Check if the Maven package is listed in the pom.xml
    if grep -q "<artifactId>$artifactId</artifactId>" "$pom_file"; then
      update_single_package "$package_name" "$user" "$pom_directory" "$origin_dir"
    else
      echo " - $package_name (Not Found)"
    fi
  done <<< "$packages"
}

update_github_packages_in_pom() {
  local user=$1
  local pom_directory=$2
  
  # Fetch packages of a specific type
  local packages=$(get_github_packages_of_user_and_type "$user" "maven")
  origin_dir=$(pwd)

  process_packages $user $pom_directory $origin_dir $packages
}

# Function to update GitHub packages in found pom directories
update_github_packages_of_project() {
  local user="$1"
  local start_directory="$2"

  # Call the function and store the results in a variable
  local pom_directories=$(find_pom_directories "$start_directory")
  echo "Iterating through Pom directories: $pom_directories"

  while IFS= read -r pom_dir; do
    echo "POM directory: $pom_dir"  
    update_github_packages_in_pom "$user" "$pom_dir"
  done <<< "$pom_directories"
}

