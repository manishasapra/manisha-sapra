package com.n26.monefy.app.core.utils;

import org.apache.logging.log4j.LogManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Test event listener for TestNG Cases
 */
public class TestCaseEventListener implements ITestListener {

    final LoggerUtility log = new LoggerUtility(LogManager.getLogger(getClass()));

    @Override
    public void onTestStart(ITestResult result) {
        log.initiateTestHTML(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.infoMSG("Success of test cases and its details are : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.errorMSG("Failure of test cases and its details are : " + result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.infoMSG("Skip of test cases and its details are : "+result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.infoMSG("Failure of test cases and its details are : "+result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        log.infoMSG("Starting test suite.");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.endTestHTML();
    }
}
