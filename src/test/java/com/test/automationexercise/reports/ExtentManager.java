package com.test.automationexercise.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ExtentManager {

    public static ExtentReports extent;
    private static WebDriver driver;

    public static ExtentReports getReportInstance() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/TestReport.html");

            sparkReporter.config().setOfflineMode(true);
            sparkReporter.config().setDocumentTitle("Automation Report");
            sparkReporter.config().setReportName("QA Automation Framework Report");
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setEncoding("UTF-8");

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Project", "QA Automation Framework");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Tester", "Daniela AC");

        }
        return extent;
    }
}
