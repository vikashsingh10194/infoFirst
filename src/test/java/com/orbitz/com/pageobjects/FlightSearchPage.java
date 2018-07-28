package com.orbitz.com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightSearchPage {
	/*
	 * @author Vikash.Singh
	 * 
	 * 
	 * All WebElements are identified by @FindBy annotation
	 * 
	 */

	WebDriver driver = null;

	@FindBy(xpath = ".//*[@id='oneway-flight']")
	private WebElement oneWay;

	public FlightSearchPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** it will return false if button is not selected ***/
	public boolean verifyOneWayButton() {

		if (oneWay.isSelected()) {

			System.out.println("One way button is selected");
			return true;
		} else {
			return false;
		}
	}

	public void verifySourceDestination() {
		List<WebElement> selected_Journey = driver.findElements(By.xpath(".//div[@class='secondary']"));
		for (WebElement cities : selected_Journey) {
			if (cities.getText().equals("BOM - BLR")) {
				System.out.println("searched journey was from  " + cities.getText());
				break;
			} else {
				System.out.println("no matching found");
			}
		}
	}
}
