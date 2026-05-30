package com.test.automationexercise.utils.drivers;

import com.test.automationexercise.utils.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private final ConfigReader config = new ConfigReader();

    public WebDriver createDriver() {

        String browser = config.getBrowser().toLowerCase();

        switch (browser) {
            case "chrome":
                return new ChromeDriver(getChromeOptions());
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--incognito", "--disable-popup-blocking", "--disable-notifications",
                "--disable-blink-features=AutomationControlled", "--disable-extensions", "--ignore-certificate-errors");

        if (config.isHeadless()) {
            options.addArguments("--headless=new");
        }

        return options;
    }
}
