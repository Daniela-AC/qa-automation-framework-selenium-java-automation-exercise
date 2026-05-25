package com.test.automationexercise.pages;

import com.test.automationexercise.pages.base.BasePage;
import com.test.automationexercise.utils.data.TestCredentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage {

    private By selectFileButton = By.name("upload_file");
    private By nameInput = By.xpath("//input[@data-qa='name']");
    private By emailInput = By.xpath("//input[@data-qa='email']");
    private By subjectInput = By.xpath("//input[@data-qa='subject']");
    private By textArea = By.xpath("//textarea[@data-qa='message']");
    private By submitButton = By.xpath("//input[@data-qa='submit-button']");
    private By successfulContactMessage = By.xpath("//div[@id='contact-page']//div[contains(@class, 'alert-success')]");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void fillInContactMessage() {
        type(nameInput, TestCredentials.NAME);
        type(emailInput, TestCredentials.VALID_EMAIL);
        type(subjectInput, "Prueba Subject");
        scrollToElement(textArea);
        type(textArea, "This is a test for contact us tab.");
    }

    public void uploadDocument() {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/files/test_document.txt";
        type(selectFileButton, filePath);
    }

    public void submitMessageAndAcceptAlert() {
        clickElement(submitButton);
        acceptAlert();
    }

    public String getSuccessfulContactMessage() {
        return extractText(successfulContactMessage);
    }
}

