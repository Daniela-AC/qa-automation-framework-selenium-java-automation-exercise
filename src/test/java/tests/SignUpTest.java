package tests;

import base.BaseTest;
import com.test.automationexercise.pages.AccountCreatedPage;
import com.test.automationexercise.utils.data.TestCredentials;
import com.test.automationexercise.utils.data.TestDataFactory;
import com.test.automationexercise.utils.data.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.test.automationexercise.pages.HomePage;
import com.test.automationexercise.pages.InformationPage;
import com.test.automationexercise.pages.LoginPage;

public class SignUpTest extends BaseTest {

    HomePage homePage;
    LoginPage login;
    InformationPage informationPage;
    AccountCreatedPage accountCreatedPage;

    @BeforeEach
    public void initPages() {
        homePage = new HomePage(driver);
        login = new LoginPage(driver);
        informationPage = new InformationPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
    }

    @Test
    public void testCreateAccount() {
        UserData userData = TestDataFactory.createValidUser();

        homePage.goToLoginPage();
        login.startSigningUp(userData.firstName, userData.email);

        informationPage.fillInAccountInformation(userData);
        informationPage.fillInAddressInformation(userData);
        informationPage.clickCreateAccountButton();

        Assertions.assertEquals("ACCOUNT CREATED!", accountCreatedPage.getAccountCreatedMessage());
    }

    @Test
    public void testSignUpWithExistingEmail() {
        homePage.goToLoginPage();
        login.startSigningUp(TestCredentials.NAME, TestCredentials.VALID_EMAIL);
        Assertions.assertEquals("Email Address already exist!", login.getEmailExistMessage());
    }
}
