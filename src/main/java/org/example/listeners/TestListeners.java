package org.example.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {
    private static final Logger LOGGER = LogManager.getLogger(TestListeners.class);
    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("*******************************************************");
        LOGGER.info("Test " + result.getMethod().getMethodName() + " started");
        LOGGER.info("*******************************************************");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("*******************************************************");
        LOGGER.info("Test " + result.getMethod().getMethodName() + " success");
        LOGGER.info("*******************************************************");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.info("*******************************************************");
        LOGGER.info("Test " + result.getMethod().getMethodName() + " failed");
        LOGGER.info("*******************************************************");
    }
}
