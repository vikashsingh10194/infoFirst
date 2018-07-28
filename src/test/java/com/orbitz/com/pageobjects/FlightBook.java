package com.orbitz.com.pageobjects;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightBook {
	/*
	 * @author Vikash.Singh
	 * 
	 * 
	 * All WebElements are identified by @FindBy annotation
	 * 
	 */

	WebDriver driver = null;
	//String stringFormat;

	@FindBy(xpath = "//*[@id=\"tab-flight-tab\"]/span[1]")
	private WebElement product;

	@FindBy(xpath = "//*[@id=\"flight-type-one-way-label\"]")
	private WebElement oneWay;

	@FindBy(xpath = "//*[@id=\"flight-origin\"]")
	private WebElement sourceCity;

	@FindBy(xpath = "//*[@id=\"flight-destination\"]")
	private WebElement destinationCity;

	@FindBy(xpath = "//*[@id=\"search-button\"]")
	private WebElement searchButton;

	@FindBy(xpath = "//*[@id=\"flight-departing\"]")
	private WebElement onwardCalender;
	@FindBy(xpath=".//*[@id='flight-departing-wrapper']/div/div/div[1]/button")
	private WebElement closeCalender;

	public FlightBook(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectProduct() throws InterruptedException {

		product.click();
		oneWay.click();
		Thread.sleep(1000);

	}

	public void selectOriginCity(String city) {

		sourceCity.sendKeys(city);

	}

	public void selectDestinationCity(String cityName) throws InterruptedException {
		destinationCity.sendKeys(cityName);
		Thread.sleep(1000);

	}

	public void selectJourneyDate() throws InterruptedException {
		onwardCalender.click();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/YYYY");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendar.DATE, 5);
		date = calendar.getTime();

		String stringFormat = format.format(date);

		onwardCalender.sendKeys(stringFormat);
		Thread.sleep(1000);
		closeCalender.click();
		System.out.println("DEPARTING DATE IS SELECTED");
		
	}

	public void searchFLight() {

		searchButton.click();

	}

}