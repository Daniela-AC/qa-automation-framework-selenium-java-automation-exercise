package com.test.automationexercise.pages;

import com.test.automationexercise.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage extends BasePage {

    private By loggedInText = By.xpath("//a[contains(text(),' Logged in as ')]");
    private By productsButton = By.xpath("//a[contains(text(), 'Products')]");
    private By iFrame = By.xpath("//iframe[contains(@id, 'aswift')]");
    private By closePopUpButton = By.id("dismiss-button-element");
    private By cartButton = By.xpath("//a[contains(text(), 'Cart')]");
    private By contactButton = By.xpath("//a[contains(text(), 'Contact us')]");

    public UserPage(WebDriver driver) {
        super(driver);
    }

    public String getLoggedInText() {
        return wait.untilVisible(loggedInText).getText();
    }

    public void goToProductsTab() {
        clickElement(productsButton);
        closePopUpIfVisible(iFrame, closePopUpButton);
    }

    public void goToCartTab() {
        clickElement(cartButton);
    }

    public void goToContactTab() {
        clickElement(contactButton);
    }
}
