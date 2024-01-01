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
   - [Coding Standards](#coding-standards)
   - [Documentation](#documentation)
   - [Testing](#testing)
4. [Community](#community)
   - [Communication Channels](#communication-channels)
   - [Getting Help](#getting-help)
5. [License](#license)

## Getting Started

### Prerequisites
**Java Development Kit (JDK):**
PANDORA requires JDK 17 or later. You can download the JDK from [Oracle](https://www.oracle.com/java/technologies/downloads/).
- To check your version of java run the following in your terminal:
`java --version`

**Apache Maven:**
Install Maven by downloading it from the [official Apache Maven website](https://maven.apache.org/download.cgi). 
- To check your version of maven run the following in your terminal:
`mvn -v`

**Integrated Development Environment (IDE):**
Choose a Java IDE that supports Maven, such as [Eclipse](https://www.eclipse.org/), [IntelliJ IDEA](https://www.jetbrains.com/idea/), or [Spring Tool Suite](https://spring.io/tools).

**Git:**
Git is used for version control. Install Git from [git-scm.com](https://git-scm.com/).
- To check your version of git run the following in your terminal:
`git --version`


### Development setup
1. Navigate to your workspace in your terminal
2. Clone the PANDORA repository
`git clone https://github.com/WJ-van-Hoek/PANDORA.git`
3. Import the PANDORA maven project in your IDE


## Contributing

### Code of Conduct

Please review our [Code of Conduct](CODE_OF_CONDUCT.md) before contributing.

### How to Contribute

1. Fork the repository.
2. Create a new branch from master following the guidelines at [Branching Strategy](#branching-strategy)
3. Make your changes and commit them with descriptive messages.
4. Push your branch to your fork: `git push origin PANDORA-XXX`.
5. Submit a pull request to the `master` branch of the original repository.

### Reporting Bugs

If you encounter any issues or bugs while using our Spring project, we appreciate your help in improving the software. To ensure effective bug reporting, please follow these guidelines:

1. **Search for Duplicates:**
   - Before reporting a new bug, please check the existing issues to see if the problem has already been reported. If it has, feel free to add any additional information or context in the existing thread.

2. **Provide Clear and Detailed Information:**
   - When creating a new bug report, include a clear and concise title that summarizes the issue. In the description, provide detailed steps to reproduce the bug, including any relevant code snippets, configurations, or input data.

3. **Environment Information:**
   - Specify the environment details where the issue occurred:
      - Operating System: [e.g., Windows 10, Ubuntu 20.04]
      - Browser (if applicable)

4. **Error Messages and Logs:**
   - Include any error messages, stack traces, or log outputs related to the issue. This information is crucial for understanding the root cause of the problem.

5. **Screenshots or Videos (if applicable):**
   - If the issue is related to the web interface, consider attaching screenshots or videos that demonstrate the problem. Visual aids can significantly speed up the debugging process.

6. **Expected vs. Actual Behavior:**
   - Clearly describe what you expected to happen and what actually happened. This helps in understanding the desired functionality and identifying any deviations.

7. **Additional Context:**
   - Provide any additional context or information that might be relevant to the issue. This could include specific use cases, browser details (if applicable), or any workarounds you've attempted.

8. **Labeling:**
   - Help us categorize and prioritize the issue by applying relevant labels (e.g., bug, enhancement, help wanted) when creating the bug report.

Thank you for contributing to the improvement of PANDORA! We will review your bug report as soon as possible.


### Suggesting Enhancements

We welcome contributions and suggestions for enhancing PANDORA. If you have ideas for new features or improvements, please follow these guidelines to ensure a smooth and constructive enhancement proposal:

1. **Search for Existing Enhancements:**
   - Before suggesting a new enhancement, check if a similar proposal already exists in the project's issues. If it does, you can contribute by adding your thoughts and feedback to the existing discussion.

2. **Clearly Define the Enhancement:**
   - Provide a clear and detailed description of the enhancement you are suggesting. Clearly articulate the problem or limitation you are addressing and how your proposed enhancement would improve the project.

3. **Use Descriptive Titles:**
   - Choose a title that succinctly summarizes the proposed enhancement. A descriptive title makes it easier for others to understand the nature of the suggestion.

4. **Provide Use Cases:**
   - Include real-world use cases or scenarios that demonstrate why the suggested enhancement would be beneficial. This helps in understanding the practical implications and potential impact on users.

5. **Consider Compatibility:**
   - If applicable, discuss how the enhancement may affect existing features or compatibility with other components. Consider backward compatibility and provide recommendations for migration if necessary.

6. **Optional: Include Design or Implementation Details:**
   - If you have specific design or implementation ideas for the enhancement, feel free to include them. While detailed technical proposals are not mandatory, they can provide valuable insights for developers.

7. **Labeling:**
   - Help categorize your enhancement proposal by applying relevant labels (e.g., enhancement, feature request) when creating the issue.

8. **Discussion and Feedback:**
   - Be open to discussions and feedback from the community. Engage with contributors who show interest in your enhancement proposal and consider their perspectives to refine and improve the suggestion.

9. **Be Patient:**
   - Understand that the enhancement proposal may take time to be reviewed and accepted. Be patient and open to iterative discussions as the proposal evolves.

Thank you for taking the time to contribute to the improvement of PANDORA. Your suggestions and enhancements are valuable in making the project better for everyone.


## Development Guidelines

### Branching Strategy

PANDORA follows a branching strategy to organize and manage code changes effectively. This strategy is designed to streamline development, testing, and collaboration among contributors.

1. **Master Branch:**
   - The `master` branch represents the latest stable version of the project. It should always reflect a buidable and runnable state.

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
   - Code review is an integral part of our development process. Contributors are encouraged to review each other's code, provide feedback, and ensure that changes meet project standards.

6. **Merging:**
   - Only after a feature or bugfix has been reviewed and approved, it can be merged into the `master` branch.

   - Fast-forward merges are preferred to maintain a linear history. However, in some cases, merge commits may be necessary (e.g., in the case of complex features or conflicting changes).

By following this branching strategy, we aim to maintain a clean and organized project history while allowing for parallel development of features and bug fixes. Contributors are encouraged to communicate and coordinate to ensure smooth collaboration.


### Coding Standards

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
   - Keep the PANDORA readme file up-to-date with information on setting up PANDORA, dependencies, build instructions.


### Testing

[Explain the testing process and provide information on how contributors can run tests locally.]

## Community

### Communication Channels

[List all communication channels for the community, such as mailing lists, forums, or chat platforms.]

### Getting Help

[Provide information on how contributors can seek help, whether through documentation, community channels, or other means.]

## License

Developments of PANDORA are licensed under GNU GPL-3. Find the full license text [here](LICENSE.md)

## Conclusion

Thank you for your interest in contributing to PANDORA! We appreciate your efforts in making this project better for everyone. Happy coding!
