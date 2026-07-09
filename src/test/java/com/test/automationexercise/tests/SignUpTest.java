package com.test.automationexercise.tests;

import com.test.automationexercise.base.BaseTest;
import com.test.automationexercise.pages.AccountCreatedPage;
import com.test.automationexercise.data.TestCredentials;
import com.test.automationexercise.data.TestDataFactory;
import com.test.automationexercise.data.UserData;
import com.test.automationexercise.drivers.DriverFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.test.automationexercise.pages.HomePage;
import com.test.automationexercise.pages.SignUpInformationPage;
import com.test.automationexercise.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class SignUpTest extends BaseTest {

    HomePage homePage;
    LoginPage login;
    SignUpInformationPage informationPage;
    AccountCreatedPage accountCreatedPage;

    @BeforeEach
    public void initPages() {
        WebDriver driver = DriverFactory.getDriver();

        homePage = new HomePage(driver);
        login = new LoginPage(driver);
        informationPage = new SignUpInformationPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
    }

    @Test
    public void testCreateAccount() {
        UserData userData = TestDataFactory.createValidUser();

        test.info("Starting account creation test");

        homePage.goToLoginPage();
        login.startSigningUp(userData.firstName, userData.email);

        test.info("Filling account and address information");
        informationPage.fillInAccountInformation(userData);
        informationPage.fillInAddressInformation(userData);
        informationPage.clickCreateAccountButton();

        test.info("Validating successful account creation");
        Assertions.assertEquals("ACCOUNT CREATED!", accountCreatedPage.getAccountCreatedMessage());
    }

    @Test
    public void testSignUpWithExistingEmail() {
        test.info("Starting sign-up test with existing email");

        homePage.goToLoginPage();
        login.startSigningUp(TestCredentials.NAME, TestCredentials.VALID_EMAIL);

        test.info("Validating existing email address message");
        Assertions.assertEquals("Email Address already exist!", login.getEmailExistMessage());
    }
}
