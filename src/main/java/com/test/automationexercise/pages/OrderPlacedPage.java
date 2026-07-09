package com.test.automationexercise.pages;

import com.test.automationexercise.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPlacedPage extends BasePage {

    private final By orderPlacedText = By.cssSelector("[data-qa='order-placed']");
    private final By downloadInvoiceButton = By.xpath("//a[contains(text(), 'Download Invoice')]");

    public OrderPlacedPage(WebDriver driver) {
        super(driver);
    }

    public String getOrderPlacedText() {
        return extractText(orderPlacedText);
    }

    public void downloadInvoice() {
        clickElement(downloadInvoiceButton);
    }
}
