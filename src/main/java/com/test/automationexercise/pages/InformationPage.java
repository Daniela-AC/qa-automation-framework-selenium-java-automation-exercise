package com.test.automationexercise.pages;

import com.test.automationexercise.pages.base.BasePage;
import com.test.automationexercise.utils.data.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InformationPage extends BasePage {

    private By femaleGender = By.id("id_gender2");
    private By passwordInput = By.id("password");
    private By daySelector = By.id("days");
    private By monthSelector = By.id("months");
    private By yearSelector = By.id("years");
    private By firstNameInput = By.id("first_name");
    private By lastNameInput = By.id("last_name");
    private By addressInput = By.id("address1");
    private By countrySelector = By.id("country");
    private By stateInput = By.id("state");
    private By cityInput = By.id("city");
    private By zipcodeInput = By.id("zipcode");
    private By mobileNumberInput = By.id("mobile_number");
    private By createAccountButton = By.xpath("//button[@data-qa='create-account']");

    public InformationPage(WebDriver driver) {
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
