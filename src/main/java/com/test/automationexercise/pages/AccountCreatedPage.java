package com.test.automationexercise.pages;

import com.test.automationexercise.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage extends BasePage {

    private By accountCreatedTitle = By.xpath("//h2[@data-qa='account-created']");

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountCreatedMessage() {
        return extractText(accountCreatedTitle);
    }
}
