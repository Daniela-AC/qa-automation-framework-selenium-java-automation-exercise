package com.test.automationexercise.reports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String fileName) {
        TakesScreenshot ts =  (TakesScreenshot) driver;

        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        File directory = new File("screenshots");

        if (!directory.exists()) {
            directory.mkdirs();
        }

        String path = "screenshots/" + fileName + ".png";

        File destinationFile = new File(path);

        try {
            FileUtils.copyFile(sourceFile, destinationFile);
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot", e);
        }

        return destinationFile.getAbsolutePath();
    }
}
