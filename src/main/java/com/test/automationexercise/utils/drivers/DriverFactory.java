package com.test.automationexercise.utils.drivers;

import com.test.automationexercise.utils.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private final ConfigReader config = new ConfigReader();

    public WebDriver createDriver() {

        String browser = config.getBrowser().toLowerCase();

        return switch (browser) {
            case "chrome" -> new ChromeDriver(getChromeOptions());
            case "firefox" -> new FirefoxDriver(getFirefoxOptions());
            case "edge" -> new EdgeDriver(getEdgeOptions());
            default -> throw new IllegalArgumentException("Browser not supported: " + browser);
        };
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

    private FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();

        options.addArguments("-private", "--disable-popup-blocking", "--disable-notifications", "--ignore-certificate-errors");

        if (config.isHeadless()) {
            options.addArguments("--headless");
        }

        return options;
    }

    private EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();

        options.addArguments("--start-maximized", "--inprivate", "--disable-popup-blocking", "--disable-notifications",
                "--disable-blink-features=AutomationControlled", "--disable-extensions", "--ignore-certificate-errors");

        if (config.isHeadless()) {
            options.addArguments("--headless=new");
        }

        return options;
    }
}
