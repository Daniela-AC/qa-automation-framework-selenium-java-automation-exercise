package com.test.automationexercise.pages;

import com.test.automationexercise.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By proceedToCheckoutButton = By.xpath("//a[contains(text(), 'Checkout')]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void goToCheckoutPage() {
        clickElement(proceedToCheckoutButton);
    }
}
