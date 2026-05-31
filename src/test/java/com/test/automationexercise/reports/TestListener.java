package com.test.automationexercise.reports;

import com.test.automationexercise.base.BaseTest;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.api.extension.TestWatcher;

public class TestListener implements TestWatcher, TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        BaseTest.testFailed = true;
        BaseTest.test.fail("Failure message: " + throwable.getMessage());
        throw throwable;
    }
}
