package com.test.automationexercise.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.test.automationexercise.reports.ExtentManager;
import com.test.automationexercise.utils.ScreenshotUtils;
import com.test.automationexercise.listeners.TestListener;
import com.test.automationexercise.drivers.DriverFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import com.test.automationexercise.config.ConfigReader;
import org.junit.jupiter.api.TestInfo;

@ExtendWith(TestListener.class)
public class BaseTest {

    protected final ConfigReader config = new ConfigReader();
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

        DriverFactory.createDriver();
        DriverFactory.getDriver().get(config.getBaseUrl());
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        if (testFailed) {
            System.out.println("Taking screenshot...");
            String screenshotPath = ScreenshotUtils.captureScreenshot(DriverFactory.getDriver(), testInfo.getDisplayName());

            try {
                test.addScreenCaptureFromPath(screenshotPath);
                System.out.println("screenshot taken...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        DriverFactory.quitDriver();

        testFailed = false;
    }

    @AfterAll
    public static void endReport() {
        report.flush();
    }
}
