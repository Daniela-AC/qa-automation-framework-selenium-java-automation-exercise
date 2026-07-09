package com.test.automationexercise.pages;

import com.test.automationexercise.pages.base.BasePage;
import com.test.automationexercise.data.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpInformationPage extends BasePage {

    private final By femaleGender = By.id("id_gender2");
    private final By passwordInput = By.id("password");
    private final By daySelector = By.id("days");
    private final By monthSelector = By.id("months");
    private final By yearSelector = By.id("years");
    private final By firstNameInput = By.id("first_name");
    private final By lastNameInput = By.id("last_name");
    private final By addressInput = By.id("address1");
    private final By countrySelector = By.id("country");
    private final By stateInput = By.id("state");
    private final By cityInput = By.id("city");
    private final By zipcodeInput = By.id("zipcode");
    private final By mobileNumberInput = By.id("mobile_number");
    private final By createAccountButton = By.xpath("//button[@data-qa='create-account']");

    public SignUpInformationPage(WebDriver driver) {
        super(driver);
    }

    public void fillInAccountInformation(UserData userData) {
        clickElement(femaleGender);
        type(passwordInput, userData.password);
        selectDataByValue(daySelector, userData.day);
        selectDataByValue(monthSelector, userData.month);
        selectDataByValue(yearSelector, userData.year);
    }

    public void fillInAddressInformation(UserData userData) {
        type(firstNameInput, userData.firstName);
        type(lastNameInput, userData.lastName);
        type(addressInput, userData.address);
        selectDataByValue(countrySelector, userData.country);
        type(stateInput, userData.state);
        type(cityInput, userData.city);
        type(zipcodeInput, userData.zipcode);
        type(mobileNumberInput, userData.mobileNumber);
    }

    public void clickCreateAccountButton() {
        clickElement(createAccountButton);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
