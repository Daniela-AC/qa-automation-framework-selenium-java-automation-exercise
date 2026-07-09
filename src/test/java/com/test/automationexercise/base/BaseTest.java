package com.test.automationexercise.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.test.automationexercise.reports.ExtentManager;
import com.test.automationexercise.reports.ScreenshotUtils;
import com.test.automationexercise.reports.TestListener;
import com.test.automationexercise.utils.drivers.DriverFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import com.test.automationexercise.utils.config.ConfigReader;
import org.junit.jupiter.api.TestInfo;

@ExtendWith(TestListener.class)
public class BaseTest {

    protected final ConfigReader config = new ConfigReader();
    protected final DriverFactory driverFactory = new DriverFactory();
    protected static ExtentReports report;
    public static ExtentTest test;
    public static boolean testFailed = false;

    @BeforeAll
    public static void startReport() {
        report = ExtentManager.getReportInstance();
    }

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        test = report.createTest(testInfo.getDisplayName());

        driverFactory.createDriver();
        driverFactory.getDriver().get(config.getBaseUrl());
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        if (testFailed) {
            System.out.println("Taking screenshot...");
            String screenshotPath = ScreenshotUtils.captureScreenshot(driverFactory.getDriver(), testInfo.getDisplayName());

            try {
                test.addScreenCaptureFromPath(screenshotPath);
                System.out.println("screenshot taken...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        driverFactory.quitDriver();

        testFailed = false;
    }

    @AfterAll
    public static void endReport() {
        report.flush();
    }
}
