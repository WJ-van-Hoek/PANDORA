

# PANDORA GUIDELINES

## Welcome

Welcome to the PANDORA open-source repository! We appreciate your interest and contributions.

## Table of Contents

1. [Getting Started](#getting-started)
   - [Prerequisites](#prerequisites)
   - [Development setup](#development-setup)
2. [Contributing](#contributing)
   - [Code of Conduct](#code-of-conduct)
   - [How to Contribute](#how-to-contribute)
   - [Reporting Bugs](#reporting-bugs)
   - [Suggesting Enhancements](#suggesting-enhancements)
3. [Development Guidelines](#development-guidelines)
   - [Branching Strategy](#branching-strategy)
   - [Coding Standards](#coding-standards-setting-up-checkstyle-cleanup-and-formatter)
   - [Documentation](#documentation)
   - [Testing](#testing)
4. [Community](#community)
   - [Communication Channels](#communication-channels)
5. [License](#license)

## Getting Started

### Prerequisites

**Software Development Kit Manager (SDKMAN):**  
SDKMAN is a versatile and convenient tool that simplifies the management of various Software Development Kits (SDKs) on your system. With just a couple of commands, you can easily install, switch between, and manage different versions of SDKs. The installation process is straightforward, requiring the following two lines in the terminal:  

`curl -s https://get.sdkman.io | bash`  
`source $HOME/.sdkman/bin/sdkman-init.sh`

**Java Development Kit (JDK):**  
PANDORA is currently developed in JDK 17.0.9.
To make sure you install and use the correct JDK version:  

`sdk install java 17.0.9-tem`  
`sdk use java 17.0.9-tem`

To make sure you configured the correct JDK version:  
`java --version`

**Apache Maven:**  
Apache Maven is an open-source project management and build automation tool that provides a comprehensive and consistent way to manage and build Java-based projects. Developed by the Apache Software Foundation, Maven simplifies the software development process by automating the project's build infrastructure and managing dependencies.  

PANDORA is currently building with Maven 3.9.9.  

To make sure you install and use the correct Maven version:  
`sdk install maven 3.9.9`  
`sdk use maven 3.9.9`

To make sure you configured the correct Maven version:  
`mvn -v`

**Git:**  

Git is used for version control.

Install the latest git version (on a Debian-based system):  
`sudo apt -y install git`

To make sure you installed git correctly:  
`git -v`

**Integrated Development Environment (IDE):**  
***- Eclipse/STS***
1. Download the tarball for a 64-bit version of STS for Linux:  
`wget https://cdn.spring.io/spring-tools/release/STS4/4.28.1.RELEASE/dist/e4.34/spring-tool-suite-4-4.28.1.RELEASE-e4.34.0-linux.gtk.x86_64.tar.gz`
2. Extract the tarball:  
`tar -xvzf spring-tool-suite-4-4.28.1.RELEASE-e4.34.0-linux.gtk.x86_64.tar.gz`
3. Delete the tarball:  
`rm spring-tool-suite-4-4.28.1.RELEASE-e4.34.0-linux.gtk.x86_64.tar.gz`
4. Run Spring Tool Suite:  
`./sts-4.28.1.RELEASE/SpringToolSuite4`

**Lombok:**  
Lombok is a Java library that simplifies boilerplate code in your Java projects. To use Lombok, you need to configure your IDE to recognize Lombok annotations.  

***- Eclipse/STS***  
1. Download the Lombok JAR:
`wget https://projectlombok.org/downloads/lombok.jar`
2. Run lombok.jar:
`java -jar lombok.jar`
3. Follow lombok installation interface.  

### Development setup
1. Navigate to your workspace in your terminal
2. Clone the PANDORA repository
`git clone https://github.com/WJ-van-Hoek/PANDORA.git`
3. Import the PANDORA maven project in your IDE.
4. Request a token to get package read access rights for some dependencies.
5. Add token to the ~./.m2/settings.xml as follows:
```xml
<settings>
  <servers>
    <!-- Server for github-parent-pom -->
    <server>
      <id>github-parent-pom</id>
      <username><YOUR_GITHUB_USERNAME></username>
      <password><YOUR_RECEIVED_TOKEN></password>
    </server>
    <!-- Server for github-spring-parent-pom -->
    <server>
      <id>github-spring-parent-pom</id>
      <username><YOUR_GITHUB_USERNAME></username>
      <password><YOUR_RECEIVED_TOKEN></password>
    </server>
    <!-- Server for github-utils -->
    <server>
      <id>github-utils</id>
      <username><YOUR_GITHUB_USERNAME></username>
      <password><YOUR_RECEIVED_TOKEN></password>
    </server>
  </servers>
</settings>
```
6. Navigate to the cloned PANDORA repository in your terminal
7. Run `mvn clean verify -U`
8. At this stage you should have a successful build, you can now start developing and contributing!

## Contributing

### Code of Conduct

Please review our [Code of Conduct](CODE_OF_CONDUCT.md) before contributing.

### How to Contribute

1. Fork the repository. 
2. Create a new branch from master following the guidelines at [Branching Strategy](#branching-strategy)
3. Make your changes and commit them with descriptive messages.
4. Push your branch to your fork: `git push origin PANDORA-XXX`.
5. Submit a pull request to the `master` branch of the original repository.  

Contact us if you want to develop directly on the repository, without forking. In that case, you need to generate an SSH key and the key needs to be added to repository administration.

### Reporting Bugs

If you encounter any issues or bugs while using our Spring project, we appreciate your help in improving the software. To ensure effective bug reporting, please follow these guidelines:

1. **Search for Duplicates:**  
   Before reporting a new bug, please check the existing issues to see if the problem has already been reported. If it has, feel free to add any additional information or context in the existing thread.

2. **Provide Clear and Detailed Information:**  
   When creating a new bug report, include a clear and concise title that summarizes the issue. In the description, provide detailed steps to reproduce the bug, including any relevant code snippets, configurations, or input data.

3. **Environment Information:**  
   Specify the environment details where the issue occurred:
    - Operating System: [e.g., Windows 10, Ubuntu 20.04]
    - Browser (if applicable)

4. **Error Messages and Logs:**  
   Include any error messages, stack traces, or log outputs related to the issue. This information is crucial for understanding the root cause of the problem.

5. **Screenshots or Videos (if applicable):**  
   If the issue is related to the web interface, consider attaching screenshots or videos that demonstrate the problem. Visual aids can significantly speed up the debugging process.

6. **Expected vs. Actual Behavior:**  
   Clearly describe what you expected to happen and what actually happened. This helps in understanding the desired functionality and identifying any deviations.

7. **Additional Context:**  
   Provide any additional context or information that might be relevant to the issue. This could include specific use cases, browser details (if applicable), or any workarounds you've attempted.

8. **Labeling:**  
   Help us categorize and prioritize the issue by applying relevant labels (e.g., bug, enhancement, help wanted) when creating the bug report.

Thank you for contributing to the improvement of PANDORA! We will review your bug report as soon as possible.


### Suggesting Enhancements

We welcome contributions and suggestions for enhancing PANDORA. If you have ideas for new features or improvements, please follow these guidelines to ensure a smooth and constructive enhancement proposal:

1. **Search for Existing Enhancements:**  
   Before suggesting a new enhancement, check if a similar proposal already exists in the project's issues. If it does, you can contribute by adding your thoughts and feedback to the existing discussion.

2. **Clearly Define the Enhancement:**  
   Provide a clear and detailed description of the enhancement you are suggesting. Clearly articulate the problem or limitation you are addressing and how your proposed enhancement would improve the project.

3. **Use Descriptive Titles:**  
   Choose a title that succinctly summarizes the proposed enhancement. A descriptive title makes it easier for others to understand the nature of the suggestion.

4. **Provide Use Cases:**  
   Include real-world use cases or scenarios that demonstrate why the suggested enhancement would be beneficial. This helps in understanding the practical implications and potential impact on users.

5. **Consider Compatibility:**  
   If applicable, discuss how the enhancement may affect existing features or compatibility with other components. Consider backward compatibility and provide recommendations for migration if necessary.

6. **Optional: Include Design or Implementation Details:**  
   If you have specific design or implementation ideas for the enhancement, feel free to include them. While detailed technical proposals are not mandatory, they can provide valuable insights for developers.

7. **Labeling:**  
   Help categorize your enhancement proposal by applying relevant labels (e.g., enhancement, feature request) when creating the issue.

8. **Discussion and Feedback:**  
   Be open to discussions and feedback from the community. Engage with contributors who show interest in your enhancement proposal and consider their perspectives to refine and improve the suggestion.

9. **Be Patient:**  
   Understand that the enhancement proposal may take time to be reviewed and accepted. Be patient and open to iterative discussions as the proposal evolves.

Thank you for taking the time to contribute to the improvement of PANDORA. Your suggestions and enhancements are valuable in making the project better for everyone.


## Development Guidelines

### Branching Strategy

PANDORA follows a branching strategy to organize and manage code changes effectively. This strategy is designed to streamline development, testing, and collaboration among contributors.

1. **Master Branch:**  
   The `master` branch represents the latest stable version of the project. It should always reflect a buidable and runnable state.

2. **Feature Branches:**  
- For the development of new features or major changes, contributors should create feature branches from the `master` branch. Naming of the branch should follow the following convention `feature/PANDORA-XXX`, where `XXX` represents the ticket number.

- Work on the feature branch should be isolated and focused on specific changes. Frequent commits and updates are encouraged to track progress.

- Once the feature is complete, a pull request should be submitted for review and merging into the `master` branch.

3. **Bugfix Branches:**  
- Bug fixes should be addressed in separate bugfix branches created from the `master` branch. Naming of the branch should follow the following convention `bug-fix/PANDORA-XXX`, where `XXX` represents the ticket number.

- Similar to feature branches, bugfix branches should be kept focused on resolving the specific issue. Frequent commits are encouraged for better traceability.

 - After fixing the bug, a pull request should be submitted for review and merging into the `master` branch.

4. **Pull Requests:**  
- All changes, whether from feature branches or bugfix branches, should be proposed through pull requests (PRs). PRs facilitate code review and discussion among contributors.

- PRs must pass automated tests and adhere to coding standards before being considered for merging.

5. **Code Review:**  
Code review is an integral part of our development process. Contributors are encouraged to review each other's code, provide feedback, and ensure that changes meet project standards.

6. **Merging:**  
- Only after a feature or bugfix has been reviewed and approved, it can be merged into the `master` branch.

- Fast-forward merges are preferred to maintain a linear history. However, in some cases, merge commits may be necessary (e.g., in the case of complex features or conflicting changes).

By following this branching strategy, we aim to maintain a clean and organized project history while allowing for parallel development of features and bug fixes. Contributors are encouraged to communicate and coordinate to ensure smooth collaboration.



### Coding Standards: Setting up Checkstyle, Cleanup, and Formatter

To maintain code consistency and readability across our project, contributors are encouraged to follow these guidelines for setting up Checkstyle, code cleanup, and code formatting in their integrated development environment (IDE).

1. **Checkstyle Configuration:**  
  - Ensure that you have the Checkstyle plugin installed in your IDE.

  - Configure your IDE to use Checkstyle configuration file `pandora-style/sun-checks.xml`. This file contains the rules and configurations for code style checking.

  - Configure your IDE to run Checkstyle checks automatically on code changes or builds. This helps in identifying and fixing style violations early in the development process.

2. **Code Cleanup Profile:**  
  - Configure your IDE to use the code cleanup configuration file `pandora-style/pandora-cs-cleanup.xml`. This file contains settings for organizing and optimizing code.

  - Run code cleanup periodically on your codebase to apply the defined rules and keep the codebase organized.

3. **Code Formatter:**  
 - Configure your IDE to use the code formatter configuration file `pandora-style/pandora-cs-formatter.xml`. This file contains the formatting rules for the code.

 - Ensure that your IDE is configured to format code automatically upon save. This ensures that code changes are consistently formatted.

By following these guidelines, contributors can ensure that their code adheres to the project's coding standards, making it easier for the team to collaborate and maintain a consistent codebase.


### Documentation

Documentation is a fundamental aspect of PANDORA, playing a pivotal role in understanding, collaboration, and future development. To maintain a high standard of documentation, please adhere to the following guidelines:

1. **Code Comments:**  
 - Utilize in-line comments to explain complex code segments, non-trivial algorithms, or any aspect of the code that may be unclear.

 - Include header comments at the beginning of each source file, offering a brief overview of the file's purpose, key classes or functions, and any relevant usage information.

2. **Function and Method Documentation:**  
 - Document each class, method, and function with clear, concise descriptions, including parameters, return values, and applicable exceptions.

 - Embed examples or use cases in the documentation to illustrate how to use specific functions or methods.

3. **New Feature Documentation:**  
 - When introducing new features, provide a high-level overview detailing the feature's purpose, benefits, and any associated concepts.

 - Include usage examples to guide users on leveraging the new feature. This may involve code snippets, configuration samples, or step-by-step instructions.

 - Document any new configuration settings or options associated with the feature.

4. **Changelog Updates:**  
 - For every new feature, enhancement, or significant change, update the PANDORA changelog. Clearly state what has been added, modified, or fixed.

 - Ensure that the documentation accurately reflects version information, providing users and contributors with insights into when a particular feature or change was introduced.

5. **Readme File:**  
Keep the PANDORA readme file up-to-date with information on setting up PANDORA, dependencies, build instructions.


### Testing

Testing is a critical component of ensuring the reliability and stability of PANDORA. Contributors are encouraged to follow these guidelines to understand the testing process and run tests locally.

1. **Testing Process Overview:**  
	Our testing process encompasses various levels, including unit tests and integration tests.

 - **Unit Tests:**  
     Verify the correctness of individual components or functions in isolation using the JUnit framework.

 - **Integration Tests:**  
     Validate the interactions between Spring components and ensure they work seamlessly together.

2. **Running Unit Tests:**  

 - To run unit tests, use the following command:

     ```bash
     ./mvnw test
     ```

 - Ensure that all unit tests pass before submitting changes.

3. **Running Integration Tests:**  

 - Integration tests may require additional setup or configuration. Refer to the project documentation for specific instructions.

 - Run integration tests using the following command:  

     ```bash
     ./mvnw integration-test
     ```

4. **Coverage Reports:**  

- Monitor test coverage by reviewing reports locally generated during the testing process with JaCoCo.
- Generate coverage reports by running:

     ```bash
     ./mvnw clean verify
     ```
- Find coverage reports in `target/site/jacoco/index.html of the maven module of interest

8. **Continuous Integration (CI):**  

	Our CI pipeline automatically runs tests on every pull request. Ensure that your changes pass all tests in the CI environment before submitting a pull request.

9. **Reporting Issues with Tests:**  

	If you encounter test failures or issues, report them in the PANDORA's issue tracker. Include detailed information about the failure and steps to reproduce it.

10. **Collaboration on Testing:**  

	Collaborate with other contributors to improve and expand the test suite. Discuss testing strategies and best practices within the development community.

By following these testing guidelines, contributors can ensure the robustness of PANDORA and identify potential issues early in the development process. Your efforts in testing contribute to the overall reliability of PANDORA.


## Community

### Communication Channels

Effective communication is crucial for a successful PANDORA. Here are the communication channels available for the PANDORA community:

1. **GitHub Issues:**  
   Use GitHub Issues for reporting bugs, suggesting enhancements, and discussing technical aspects of the project. Engage in existing discussions and create new issues when needed.

2. **GitHub Discussions:**  
   GitHub Discussions provide a space for broader, more open-ended conversations. Feel free to start discussions on PANDORA-related topics, share ideas, or seek advice from the community.

3. **GitHub Pull Requests:**  
   Use GitHub Pull Requests for proposing changes, submitting contributions, and collaborating on code improvements. Follow our [contribution guidelines](#how-to-contribute) for a smooth review process.

4. **Contacting the Owner:**  
   For private matters or inquiries that require direct communication with the project owner, feel free to message [@WJ-van-Hoek](https://github.com/WJ-van-Hoek) directly.

5. **Code of Conduct Reporting:**  
   If you encounter any code of conduct violations, please report them to [@WJ-van-Hoek](https://github.com/WJ-van-Hoek) privately or through the appropriate channels outlined in our [Code of Conduct](CODE_OF_CONDUCT.md).

Remember to be respectful and considerate in all communications. We value the diversity of our community and strive to maintain an inclusive and welcoming environment for everyone.

## License

Developments of PANDORA are licensed under GNU GPL-3. Find the full license text [here](LICENSE.md)

## Conclusion

Thank you for your interest in contributing to PANDORA! We appreciate your efforts in making this project better for everyone. Happy coding!
