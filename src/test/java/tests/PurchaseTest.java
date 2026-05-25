package tests;

import base.BaseTest;
import com.test.automationexercise.pages.*;
import com.test.automationexercise.utils.PurchaseService;
import com.test.automationexercise.utils.data.TestCredentials;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PurchaseTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    UserPage userPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    PurchaseService purchaseService;
    PaymentPage paymentPage;
    OrderPlacedPage orderPlacedPage;

    @BeforeEach
    public void initPages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        userPage = new UserPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        purchaseService = new PurchaseService(productsPage);
        paymentPage = new PaymentPage(driver);
        orderPlacedPage = new OrderPlacedPage(driver);
    }

    @Test
    public void testSuccessfulPurchase() {
        homePage.goToLoginPage();
        loginPage.logIn(TestCredentials.VALID_EMAIL, TestCredentials.CORRECT_PASSWORD);
        userPage.goToProductsTab();

        productsPage.addProductToTheCart();
        userPage.goToCartTab();
        cartPage.goToCheckoutPage();

        Assertions.assertEquals(checkoutPage.getTotalCost(), purchaseService.getExpectedTotal());

        checkoutPage.placeOrder();
        paymentPage.fillPayment(TestCredentials.NAME_ON_CARD, TestCredentials.CARD_NUMBER, TestCredentials.CVC, TestCredentials.EXPIRATION_MONTH, TestCredentials.EXPIRATION_YEAR);
        paymentPage.payAndConfirmOrder();

        Assertions.assertEquals("ORDER PLACED!", orderPlacedPage.getOrderPlacedText());
    }
}
