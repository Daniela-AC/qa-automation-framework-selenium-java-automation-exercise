package com.test.automationexercise.pages;

import com.test.automationexercise.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CheckoutPage extends BasePage {

    private By totalPrice = By.xpath("//h4[.//b[text()='Total Amount']]/ancestor::tr//p[@class='cart_total_price']");
    private By placeOrderButton = By.xpath("//a[contains(text(), 'Place Order')]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void placeOrder() {
        scrollToElement(placeOrderButton);
        clickElement(placeOrderButton);
    }

    public int getTotalCost() {
        String priceText = extractText(totalPrice);
        String numeric = priceText.replaceAll("[^0-9]", "");
        return Integer.parseInt(numeric);
    }
}
