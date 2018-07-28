package com.orbitz.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreensots {

	public static void captureScreenShot(WebDriver driver) {
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("D:/Assignments/WeekSecond/ScreenShots" + System.currentTimeMillis() + ".png"));
			System.out.println("Screenshot is captured successfully");
		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}
}