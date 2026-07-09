package com.test.automationexercise.tests;

import com.test.automationexercise.base.BaseTest;
import com.test.automationexercise.pages.*;
import com.test.automationexercise.data.TestCredentials;
import com.test.automationexercise.drivers.DriverFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class PurchaseTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    UserPage userPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;
    OrderPlacedPage orderPlacedPage;

    @BeforeEach
    public void initPages() {
        WebDriver driver = DriverFactory.getDriver();

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        userPage = new UserPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        paymentPage = new PaymentPage(driver);
        orderPlacedPage = new OrderPlacedPage(driver);
    }

    @Test
    public void testSuccessfulPurchase() {
        test.info("Starting purchase test");

        homePage.goToLoginPage();
        loginPage.logIn(TestCredentials.VALID_EMAIL, TestCredentials.CORRECT_PASSWORD);
        userPage.goToProductsTab();

        test.info("Adding products to cart and proceeding to checkout");
        productsPage.addProductToTheCart();
        userPage.goToCartTab();

        test.info("Validating cart total against expected total");
        Assertions.assertEquals(checkoutPage.getTotalCost(), productsPage.getExpectedTotal());


        cartPage.goToCheckoutPage();
        checkoutPage.placeOrder();

        test.info("Filling payment information");
        paymentPage.fillPayment(TestCredentials.NAME_ON_CARD, TestCredentials.CARD_NUMBER, TestCredentials.CVC, TestCredentials.EXPIRATION_MONTH, TestCredentials.EXPIRATION_YEAR);
        paymentPage.payAndConfirmOrder();

        test.info("Validating order placed successfully");
        Assertions.assertEquals("ORDER PLACED!", orderPlacedPage.getOrderPlacedText());
    }
}
