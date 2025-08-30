package framework.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.PageObjects.HandlingDatePickersPageObjects;
import framework.Utilities.BaseTest;

public class HandlingDatePickers extends BaseTest{
	
	
	HandlingDatePickersPageObjects handlingDatePicker;
	public final static String mydatePickerUrl ="https://jqueryui.com/datepicker/";
	
	public final static String year ="2025";
	public final static String month="December";
	public final static String date ="25";
	
	public final static By dateLocator = By.id("datepicker");
	

	
	@BeforeClass
	public void setUp() {
		
		BaseTest.launchBrowser();
		driver=BaseTest.getDriver();
		handlingDatePicker= new HandlingDatePickersPageObjects(driver);
		driver.get(mydatePickerUrl);	
		
	}
	 @AfterSuite
	    public void tearDownBrowser() {
	        BaseTest.tearDown();
	    }
	
	@Test
	public void datePickerTest() {
		
		//handlingDatePicker.testDateInputField();
		driver.switchTo().frame(0);
		BaseTest.findElementByLocator(driver, dateLocator).click();
		HandlingDatePickersPageObjects.selectFutureDate(driver,year, month, date );
	}
	
	
	

}
