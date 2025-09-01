package framework.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.PageObjects.SpiceJtDatePickerPageObjects;
import framework.Utilities.BaseTest;

public class SpiceJtDatePicker {
	
	WebDriver driver;
	SpiceJtDatePickerPageObjects spicjtdatepicker;
	public final static String spicejetUrl ="https://www.spicejet.com/";
	
	@BeforeClass
	public void setUp() {
		
		BaseTest.launchBrowser();
		driver=BaseTest.getDriver();
		spicjtdatepicker= new SpiceJtDatePickerPageObjects(driver);
		driver.get(spicejetUrl);	
		
	}
	 @AfterSuite
	    public void tearDownBrowser() {
	        BaseTest.tearDown();
	    }
	 
	 @Test
	 public void testSpicejtDatePicker() throws InterruptedException {
		 spicjtdatepicker.testDatePicker();
		 
	 }
}
