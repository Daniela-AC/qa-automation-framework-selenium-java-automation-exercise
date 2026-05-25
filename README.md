# QA Automation Framework - Selenium Java

Automation framework built using Selenium WebDriver with Java. Implements Page Object Model (POM), reusable utilities,
and dynamic test data generation.

## 🚀 Technologies
- Java
- Selenium WebDriver
- JUNit
- Gradle
- Java Faker

## 🧱 Framework Design
- Page Object Model (POM)
- BasePage for common actions
- Custom Wait Utilities
- Test Data Factory for dynamic data

## 📂 Project Structure
```
src
├── main
│   ├── java
│       ├── com.test.automationexercise
│           ├── pages
│               └── base
│           └── utils
│               └── data
├── test
│   └── java
│       ├── base
│       └── tests
│   └── resources
│       ├── config
│       └── files


```

## ✅ Test Scenarios
### Positive
- User can sign up successfully
- User can log in with valid credentials
- Successful purchase
- Sending contact form successfully

### Negative
- Log in with wrong credentials
- Sign up with existing email

## 📌 Notes
This project is part of my transition from manual QA to automation, focusing on building scalable and maintainable test
frameworks.
