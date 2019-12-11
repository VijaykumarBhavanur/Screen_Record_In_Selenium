package com.bridgelabz.selenium.screenrecording;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.selenium.util.ScreenRecorderUtil;
/**
 * 
 * @author Vijaykumar Bhavanur
 * purpose: To demonstrate video recording of test automation
 *
 */
public class ScreenRecordTest {

	// Defining driver instance reference
	WebDriver driver;

	/**
	 * Method used to create and initialize driver instance
	 * 
	 * @throws Exception
	 */
	@BeforeMethod
	public void setup() throws Exception {
		// To set the path of the driver for the respective browser
		System.setProperty("webdriver.chrome.driver", "/home/admin1/Documents/chromedriver");

		// Creating browser instance based on driver
		driver = new ChromeDriver();
		// To Open URL of application to be tested

		// Starting video recorder
		ScreenRecorderUtil.startRecord("uploadTest");
		driver.get("https://tus.io/demo.html");

		// Maximizing window
		driver.manage().window().maximize();
	}

	/**
	 * Method to Test file upload
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void uploadTest() throws InterruptedException {
		// Finding webelement by xpath and sending path of file to be uploaded to it
		driver.findElement(
				By.xpath("//body/div[@class='wrapper']/div[@class='content']/div[@class='container']/p/input[1]"))
				.sendKeys("/home/admin1/Desktop/browse.png");

		// waiting for 5seconds
		Thread.sleep(5000);
	}

	/**
	 * Method to close resource such as browser after executing test methods
	 * 
	 * @throws Exception
	 */
	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		// Stoping video recorder
		ScreenRecorderUtil.stopRecord();
	}

}
