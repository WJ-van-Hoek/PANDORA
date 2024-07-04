#!/bin/bash

# Function to perform curl request to an API URL
# Arguments:
#   $1: api_url - URL to fetch data from
# Returns:
#   Raw JSON response from the API URL
curl_api_url() {
  local api_url=$1

  # Perform curl request with necessary headers and capture response headers
  local response_headers=$(curl -s -D - -o /dev/null -H "Accept: application/vnd.github+json" \
                          -H "Authorization: Bearer ${_READ_PACKAGE}" \
                          -H "X-GitHub-Api-Version: 2022-11-28" \
                          "$api_url")
                          
  # Extract HTTP status code from response headers
  local http_status=$(echo "$response_headers" | head -n 1 | awk '{print $2}')

  if [ $http_status -ne 200 ]; then
    >&2 echo "Error: Failed to fetch data from $api_url (HTTP status code: $http_status)"
    return 1
  fi

  # Perform curl request again to fetch raw JSON data
  local raw_json=$(curl -s -L \
    			-H "Accept: application/vnd.github+json" \
    			-H "Authorization: Bearer ${_READ_PACKAGE}" \
			-H "X-GitHub-Api-Version: 2022-11-28" \
                     "$api_url")

  # Return raw JSON data
  echo "$raw_json"
}

# Function to fetch version information for a given package and return raw JSON
# Arguments:
#   $1: user - GitHub username
#   $2: package_type - Type of package (e.g., maven)
#   $3: package_name - Name of the package
# Returns:
#   JSON response containing version details for the package
fetch_all_versions() {
  local user=$1
  local package_type=$2
  local package_name=$3

  # Primary and fallback API URLs for fetching package versions from GitHub API
  local api_user_url="https://api.github.com/users/${user}/packages/${package_type}/${package_name}/versions"
  local api_org_url="https://api.github.com/orgs/${user}/packages/${package_type}/${package_name}/versions"

  # Try fetching from the primary API URL
  local raw_json=$(curl_api_url "$api_user_url")

  # If primary API call fails, attempt the fallback API URL
  if [ $? -ne 0 ]; then
    raw_json=$(curl_api_url "$api_org_url")
  fi

  echo "$raw_json"
}

# Function to fetch the latest version details for a package
# Arguments:
#   $1: user - GitHub username
#   $2: package_type - Type of package (e.g., maven)
#   $3: package_name - Name of the package
# Returns:
#   JSON block containing details of the latest version of the package
fetch_latest_version() {
  local user=$1
  local package_type=$2
  local package_name=$3

  # Fetch all versions for the package and store the JSON response
  local raw_json=$(fetch_all_versions "$user" "$package_type" "$package_name")

  # Extract version details and find the latest one
  local latest_version=$(echo "$raw_json" | grep -E '"name":|"created_at":' | awk '
    /"name"/ { version = $2 }
    /"created_at"/ { created = $2; print version, created }
  ' | sed 's/[",]//g' | sort -k2 -r | head -n1 | awk '{print $1}')
  
  # Find the JSON block for the latest version based on its "name"
  local block_start=$(echo "$raw_json" | grep -n "\"name\": \"$latest_version\"" | cut -d ':' -f 1)
  local block_end=$((block_start + 9))  # Assuming each block is 9 lines long

  # Extract the JSON block containing details of the latest version
  echo "$raw_json" | sed -n "${block_start},${block_end}p"
}

# Raw function to extract the latest version number from a JSON block
# Arguments:
#   $1: package_block - JSON block containing details of a package version
# Returns:
#   Version number (e.g., "0.2.7")
fetch_latest_version_number_raw() {
  local package_block="$1"

  # Extract the value of "name" from the JSON block using grep and awk
  local name=$(echo "$package_block" | grep -Po '"name": "\K[^"]+' | awk '{print $1}')

  echo "$name"
}

# Function to fetch and return the latest version number of a package
# Arguments:
#   $1: user - GitHub username
#   $2: package_type - Type of package (e.g., maven)
#   $3: package_name - Name of the package
# Returns:
#   Latest version number (e.g., "0.2.7")
fetch_latest_version_number() {
  local user=$1
  local package_type=$2
  local package_name=$3
  
  # Fetch the JSON block of the latest version
  local package_block=$(fetch_latest_version "$user" "$package_type" "$package_name")
  
  # Extract and return the version number from the JSON block
  local version_number=$(fetch_latest_version_number_raw "$package_block")
  
  echo "$version_number"
}

# Example function demonstrating usage
example() {
  local user="WJ-van-Hoek"
  local package_type="maven"
  local package_name="com.general.parent-pom"

  # Fetch the latest version number of the package
  local latest_version_number=$(fetch_latest_version_number "$user" "$package_type" "$package_name")

  # Output the latest version number to the user
  echo "$latest_version_number"
}

# Run the example function to demonstrate usage
example

