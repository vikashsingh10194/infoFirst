package com.orbitz.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


public class TestListeners implements ITestListener {
	/*
	 * @author Vikash.Singh
	 * 
	 * 
	 * Implementing ITestListener
	 * 
	 */
	WebDriver driver = null;

	public void onFinish(ITestContext result) {
		System.out.println("finished test details are " + result.getName());

	}

	public void onStart(ITestContext result) {
	System.out.println("Started test details are " + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("TestFailed test details are " + result.getName());

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Failed test details are " + result.getName());

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("TestSkipped test details are " + result.getName());
		
		//TakeScreensots.captureScreenShot(driver);

	}

	public void onTestStart(ITestResult result) {
		System.out.println("TestStart test details are " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("TestSuccess test details are " + result.getName());
	}

}
