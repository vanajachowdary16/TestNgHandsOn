package framework.testscripts;

import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.PageObjects.DatePickerPageObjects;
import framework.Utilities.BaseTest;

public class RedBusDatePickerTest {
	WebDriver driver;
	DatePickerPageObjects datepicker;
	public final static String redbusUrl ="https://www.redbus.in/";
	public final static String expMonthYear="Dec, 2025";
	
	@BeforeClass
	public void setUp() {
		
		BaseTest.launchBrowser();
		driver=BaseTest.getDriver();
		datepicker= new DatePickerPageObjects(driver);
		driver.get(redbusUrl);	
	}
	 @AfterSuite
	    public void tearDownBrowser() {
	        BaseTest.tearDown();
	    }
	 
	 @Test
	 public void datePickerTest() throws ParseException {
		 datepicker.navigateToMonth(driver, expMonthYear);
	 }

}
