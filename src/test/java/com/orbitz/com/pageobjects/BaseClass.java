package com.orbitz.com.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orbitz.utils.CommonUtils;
import com.orbitz.utils.TakeScreensots;

import org.testng.annotations.Parameters;

public class BaseClass extends TestBase {

	//fLIGHT DATA from properties file for source and destination
	String sourceCity = CommonUtils.getFlightData("SOURCE");
	String destinationCity = CommonUtils.getFlightData("DESTINATION");

	@Test
	public void bookFlight() throws InterruptedException {
		FlightBook book = new FlightBook(driver);
		System.out.println(sourceCity + destinationCity);
		book.selectProduct();
		book.selectOriginCity(sourceCity);
		book.selectDestinationCity(destinationCity);
		// book.selectOriginCity("Mumbai, India (BOM-Chhatrapati Shivaji Intl.)");
		// book.selectDestinationCity("Bengaluru, India (BLR-Kempegowda Intl.)");
		book.selectJourneyDate();
		book.searchFLight();
		Thread.sleep(2000);
		TakeScreensots.captureScreenShot(driver);
		Thread.sleep(2000);
		FlightSearchPage searchPage = new FlightSearchPage(driver);
		boolean value = searchPage.verifyOneWayButton();
		System.out.println("value getting as   " + value);
		Assert.assertTrue(value, "We are getting false as return please check");
		searchPage.verifySourceDestination();
		System.out.println("Search validated");
	}

}
