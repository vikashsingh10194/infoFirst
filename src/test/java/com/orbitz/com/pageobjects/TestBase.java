/**
 * 
 */
package com.orbitz.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.orbitz.utils.TakeScreensots;

/**
 * @author Vikash.Singh
 *
 */
public class TestBase {

	static WebDriver driver = null;
	static String url = "https://www.orbitz.com/";

	@Parameters("browser")
	@BeforeMethod
	public void openBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			// Here I am setting up the path for ChromeDriver
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			try {
				driver = new ChromeDriver();
			} catch (Exception e) {
				System.out.println("Not able to launch browser " + e.getMessage());

			}

		} else if (browser.equalsIgnoreCase("firefox")) {

			// Here I am setting up the path for firefoxDriver

			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			try {
				driver = new FirefoxDriver();
			} catch (Exception e) {
				System.out.println("Not able to launch browser " + e.getMessage());
			}
		}
		driver.get(url);
		driver.manage().window().maximize();
		TakeScreensots.captureScreenShot(driver);


	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}