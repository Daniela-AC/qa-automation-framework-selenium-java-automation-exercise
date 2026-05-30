package com.test.automationexercise.reports;

import com.test.automationexercise.base.BaseTest;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class TestListener implements TestWatcher {

    @Override
    public void testSuccessful(ExtensionContext context) {
        BaseTest.test.pass("Test passed successfully");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        BaseTest.test.fail("Failure message: " + cause.getMessage());
    }
}
