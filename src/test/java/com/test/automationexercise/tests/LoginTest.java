package com.test.automationexercise.tests;

import com.test.automationexercise.base.BaseTest;
import com.test.automationexercise.pages.HomePage;
import com.test.automationexercise.pages.LoginPage;
import com.test.automationexercise.pages.UserPage;
import com.test.automationexercise.utils.data.TestCredentials;
import com.test.automationexercise.utils.drivers.DriverFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class LoginTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    UserPage userPage;

    @BeforeEach
    public void initPages() {
        WebDriver driver = DriverFactory.getDriver();

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        userPage = new UserPage(driver);
    }

    @Test
    public void testLogInToTheAccount() {
        test.info("Starting login test");

        homePage.goToLoginPage();
        loginPage.logIn(TestCredentials.VALID_EMAIL, TestCredentials.CORRECT_PASSWORD);

        test.info("Validating successful login test");
        Assertions.assertTrue(userPage.getLoggedInText().contains("Logged in as"));
    }

    @Test
    public void testLogInWithWrongCredentials() {
        test.info("Starting login test");

        homePage.goToLoginPage();

        test.info("Entering invalid credentials ");
        loginPage.logIn(TestCredentials.VALID_EMAIL, TestCredentials.WRONG_PASSWORD);

        test.info("Validating error message for invalid login");
        Assertions.assertEquals("Your email or password is incorrect!", loginPage.getWrongCredentialsMessage());
    }
}
