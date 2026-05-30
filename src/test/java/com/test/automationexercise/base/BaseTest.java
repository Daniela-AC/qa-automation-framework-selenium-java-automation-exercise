package com.test.automationexercise.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.test.automationexercise.reports.ExtentManager;
import com.test.automationexercise.reports.TestListener;
import com.test.automationexercise.utils.drivers.DriverFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import com.test.automationexercise.utils.config.ConfigReader;

@ExtendWith(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    private final ConfigReader config = new ConfigReader();
    private final DriverFactory driverFactory = new DriverFactory();
    protected static ExtentReports report;
    public static ExtentTest test;

    @BeforeAll
    public static void startReport() {
        report = ExtentManager.getReportInstance();
    }

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        test = report.createTest(testInfo.getDisplayName());

        driver = driverFactory.createDriver();
        driver.get(config.getBaseUrl());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterAll
    public static void endReport() {
        report.flush();
    }
}
