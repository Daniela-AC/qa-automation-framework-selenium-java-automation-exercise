package com.test.automationexercise.tests;

import com.test.automationexercise.base.BaseTest;
import com.test.automationexercise.pages.ContactPage;
import com.test.automationexercise.pages.HomePage;
import com.test.automationexercise.pages.LoginPage;
import com.test.automationexercise.pages.UserPage;
import com.test.automationexercise.data.TestCredentials;
import com.test.automationexercise.drivers.DriverFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class ContactTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    UserPage userPage;
    ContactPage contactPage;

    @BeforeEach
    public void initPages() {
        WebDriver driver = DriverFactory.getDriver();

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        userPage = new UserPage(driver);
        contactPage = new ContactPage(driver);
    }

    @Test
    public void testSendContactFormSuccessfully() {
        test.info("Starting contact form test");

        homePage.goToLoginPage();
        loginPage.logIn(TestCredentials.VALID_EMAIL, TestCredentials.CORRECT_PASSWORD);
        userPage.goToContactTab();

        test.info("Filling up the contact form");
        contactPage.fillInContactMessage();
        contactPage.uploadDocument();
        contactPage.submitMessageAndAcceptAlert();

        test.info("Validating contact form submission");
        Assertions.assertEquals("Success! Your details have been submitted successfully.", contactPage.getSuccessfulContactMessage());
    }
}
