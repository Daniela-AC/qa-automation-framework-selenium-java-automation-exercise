package tests;

import base.BaseTest;
import com.test.automationexercise.pages.ContactPage;
import com.test.automationexercise.pages.HomePage;
import com.test.automationexercise.pages.LoginPage;
import com.test.automationexercise.pages.UserPage;
import com.test.automationexercise.utils.data.TestCredentials;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    UserPage userPage;
    ContactPage contactPage;

    @BeforeEach
    public void initPages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        userPage = new UserPage(driver);
        contactPage = new ContactPage(driver);
    }

    @Test
    public void testSendContactFormSuccessfully() {
        homePage.goToLoginPage();
        loginPage.logIn(TestCredentials.VALID_EMAIL, TestCredentials.CORRECT_PASSWORD);
        userPage.goToContactTab();

        contactPage.fillInContactMessage();
        contactPage.uploadDocument();
        contactPage.submitMessageAndAcceptAlert();

        Assertions.assertEquals("Success! Your details have been submitted successfully.", contactPage.getSuccessfulContactMessage());
    }
}
