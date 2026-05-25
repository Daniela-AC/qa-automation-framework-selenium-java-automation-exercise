package com.test.automationexercise.pages.base;

import com.test.automationexercise.utils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtils wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    protected void selectDataByValue(By locator, String value) {
        WebElement dropdownElement = wait.untilClickable(locator);
        Select element = new Select(dropdownElement);
        element.selectByValue(value);
    }

    protected void clickElement(By locator) {
        wait.untilClickable(locator).click();
    }

    protected void type(By locator, String text) {
        wait.untilClickable(locator).sendKeys(text);
    }

    protected void closePopUpIfVisible(By iframeLocator, By closeButtonLocator) {
        List<WebElement> iframes = driver.findElements(iframeLocator);

        for (int i = 0; i < iframes.size(); i++) {
            try {
                driver.switchTo().defaultContent();
                driver.switchTo().frame(iframes.get(i));

                List<WebElement> closeButtons = driver.findElements(closeButtonLocator);

                if (!closeButtons.isEmpty()) {
                    WebElement closeButton = closeButtons.get(0);
                    if (closeButton.isDisplayed()) {
                        closeButton.click();
                        driver.switchTo().defaultContent();
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error en iframe index " + i + ": " + e.getMessage());
            }
        }
        driver.switchTo().defaultContent();
    }

    protected void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected String extractText(By locator) {
        return wait.untilVisible(locator).getText();
    }

    protected void acceptAlert() {
        wait.untilAlertIsPresent();
        driver.switchTo().alert().accept();
    }
}
