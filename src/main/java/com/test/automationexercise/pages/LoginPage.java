package com.test.automationexercise.pages;

import com.test.automationexercise.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By nameInput = By.xpath("//input[@data-qa='signup-name']");
    private By emailInput = By.xpath("//input[@data-qa='signup-email']");
    private By signUpButton = By.xpath("//button[@data-qa='signup-button']");
    private By emailLoginInput = By.xpath("//input[@data-qa='login-email']");
    private By passwordInput = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");
    private By emailExistMessage = By.xpath("//div[@class='signup-form']//p");
    private By wrongCredentialsMessage = By.xpath("//div[@class='login-form']//p");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void startSigningUp(String name, String email) {
        type(nameInput, name);
        type(emailInput, email);
        clickElement(signUpButton);
    }

    public void logIn(String email, String password) {
        type(emailLoginInput, email);
        type(passwordInput, password);
        clickElement(loginButton);
    }

    public String getEmailExistMessage() {
        return extractText(emailExistMessage);
    }

    public String getWrongCredentialsMessage() {
        return extractText(wrongCredentialsMessage);
    }
}
