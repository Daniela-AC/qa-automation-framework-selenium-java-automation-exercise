package com.test.automationexercise.pages;

import com.test.automationexercise.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By loginButton = By.xpath("//i[@class='fa fa-lock']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() {
        clickElement(loginButton);
    }
}
