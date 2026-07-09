package com.test.automationexercise.pages;

import com.test.automationexercise.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {

    private final By nameOnCardInput = By.cssSelector("[data-qa='name-on-card']");
    private final By cardNumberInput = By.cssSelector("[data-qa='card-number']");
    private final By cvcInput = By.cssSelector("[data-qa='cvc']");
    private final By expirationMonthInput = By.cssSelector("[data-qa='expiry-month']");
    private final By expirationYearInput = By.cssSelector("[data-qa='expiry-year']");
    private final By payButton = By.cssSelector("[data-qa='pay-button']");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void fillPayment(String nameOnCard, String cardNumber, String cvc, String expirationMonth, String expirationYear) {
        type(nameOnCardInput, nameOnCard);
        type(cardNumberInput, cardNumber);
        type(cvcInput, cvc);
        type(expirationMonthInput, expirationMonth);
        type(expirationYearInput, expirationYear);
    }

    public void payAndConfirmOrder() {
        scrollToElement(payButton);
        clickElement(payButton);
    }
}
