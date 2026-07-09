package com.test.automationexercise.drivers;

import com.test.automationexercise.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private static WebDriver driver;
    private static final ConfigReader config = new ConfigReader();

    public static WebDriver createDriver() {

        String browser = config.getBrowser().toLowerCase();

        driver = switch (browser) {
            case "chrome" -> new ChromeDriver(getChromeOptions());
            case "firefox" -> new FirefoxDriver(getFirefoxOptions());
            case "edge" -> new EdgeDriver(getEdgeOptions());
            default -> throw new IllegalArgumentException("Browser not supported: " + browser);
        };

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--incognito", "--disable-popup-blocking", "--disable-notifications",
                "--disable-blink-features=AutomationControlled", "--disable-extensions", "--ignore-certificate-errors");

        if (config.isHeadless()) {
            options.addArguments("--headless=new");
        }

        return options;
    }

    private static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();

        options.addArguments("-private", "--disable-popup-blocking", "--disable-notifications", "--ignore-certificate-errors");

        if (config.isHeadless()) {
            options.addArguments("--headless");
        }

        return options;
    }

    private static EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();

        options.addArguments("--start-maximized", "--inprivate", "--disable-popup-blocking", "--disable-notifications",
                "--disable-blink-features=AutomationControlled", "--disable-extensions", "--ignore-certificate-errors");

        if (config.isHeadless()) {
            options.addArguments("--headless=new");
        }

        return options;
    }
}
