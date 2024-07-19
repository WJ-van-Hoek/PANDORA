#!/bin/bash

# Function to fetch packages from GitHub Packages API
get_github_packages_of_user() {
  local user="$1"
  curl -s -L \
    -H "Accept: application/vnd.github+json" \
    -H "Authorization: Bearer ${_READ_PACKAGE}" \
    -H "X-GitHub-Api-Version: 2022-11-28" \
    "https://api.github.com/users/${user}/packages?package_type=maven"
}

# Function to extract packages of a specific type from JSON data
# Arguments:
#   $1: type - Package type to filter (e.g., "maven")
#   $2: json_data - JSON data containing package information
# Outputs:
#   Outputs package names of the specified type
get_packages_of_type() {
  local type="$1"
  local json_data="$2"
  
  # Initialize an array to store package names
  local packages=()

  # Split JSON data by '{' character to process each object
  IFS='{'
  local objects=($json_data)

  # Loop through each object and extract package information
  for obj in "${objects[@]}"; do
    # Check if the object contains "package_type": "$type"
    if [[ $obj =~ "\"package_type\": \"$type\"" ]]; then
      # Extract the package name
      local package_name=$(echo "$obj" | grep -oP '"name": "\K[^"]+')

      # Append the package name to the array
      packages+=("$package_name")
    fi
  done

  # Output the package names
  printf '%s\n' "${packages[@]}"
}

# Function to fetch packages and extract those of a specific type
get_github_packages_of_user_and_type() {
  local user="$1"
  local type="$2"
  
  # Fetch packages from GitHub Packages API
  local response=$(get_github_packages_of_user "$user")
  
  # Extract and output packages of the specified type
  get_packages_of_type "$type" "$response"
}

get_github_packages_of_user_and_type "WJ-van-Hoek" "maven"

