# QA Automation Framework - Selenium Java

Automation framework built using Selenium WebDriver with Java. Implements Page Object Model (POM), reusable utilities,
and dynamic test data generation.

## 🚀 Technologies
- Java
- Selenium WebDriver
- JUNit
- Gradle
- Java Faker
- Extent Reports

## 🧱 Framework Design
- Page Object Model (POM)
- BasePage for common actions
- Custom Wait Utilities
- Config Reader for environment configuration
- Driver Factory for browser initialization
- Test Data Factory for dynamic data generation
- ExtentReports integration

## 📂 Project Structure
```
src
├── main
│   ├── java
│       ├── com.test.automationexercise
│           ├── pages
│               └── base
│           └── utils
│               ├── config
│               ├── data
│               └── drivers
├── test
│   └── java
│       ├── base
│       ├── reports
│       └── tests
│   └── resources
│       └── files
test-output
├── TestReport.html
└── screenshots
```

## ✅ Test Scenarios
### Positive
- User can sign up successfully
- User can log in with valid credentials
- Successful purchase with total cart validation
- Sending contact form successfully

### Negative
- Log in with wrong credentials
- Sign up with existing email

## 📈 Reporting
The framework uses ExtentReports for test execution reporting.

### Features:
- Step-by-step execution logs
- Failure messages
- Automatic screenshots on test failures
- Execution timestamps

### Generated artifacts:
- test-output/TestReport.html
- test-output/screenshots/

### When a test fails:
- A screenshot is automatically captured.
- The screenshot is attached to the ExtentReport.
- The failure message is logged in the report.

## 📌 Notes
This project is part of my transition from manual QA to automation, focusing on building scalable and maintainable test
frameworks.

## Future Improvements
- Cross-browser execution
- GitHub Actions CI integration
- Parallel execution
- Environment-based configuration
