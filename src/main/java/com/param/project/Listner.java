package com.param.project;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listner implements ITestListener {

	public void onTestStart(ITestResult result) {
		Reporter.log("Test case started " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test case succeded " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		Reporter.log("Test case failed " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test case skipped " + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}
