#!/bin/bash

# Configure git user email and name
git config --global user.email "${USER_EMAIL}"
git config --global user.name "${USER_NAME}" 

git push -d origin AUTO-UPDATE-DEPENDENCIES
git checkout -b AUTO-UPDATE-DEPENDENCIES
git pull origin master

# Run 'mvn versions:update-properties'
mvn versions:update-properties

# Compare the pom.xml files before and after the update
if [[ -n $(git status --porcelain) ]]; then
    git add -u
    git commit -m "Automated versions:update-properties"
    git push origin AUTO-UPDATE-DEPENDENCIES --set-upstream
    sleep 5

    curl -L -X POST -H "Accept: application/vnd.github+json" -H "Authorization: Bearer ${_WRITE_PR}" -H "X-GitHub-Api-Version: 2022-11-28" https://api.github.com/repos/WJ-van-Hoek/PANDORA/pulls -d '{"title":"AUTO-PR: update properties","head":"AUTO-UPDATE-DEPENDENCIES","base":"master"}'
    # If files are the same, indicate no changes and exit
    echo "Changes found in 'pom.xml' after running 'mvn versions:update-properties'. PR is waiting!"
    exit 1
else
    # If files are the same, indicate no changes and exit
    echo "No changes found in 'pom.xml' after running 'mvn versions:update-properties'. Exiting..."
    exit 0
fi
