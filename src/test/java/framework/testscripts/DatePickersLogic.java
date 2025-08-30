package framework.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.PageObjects.DatePickersLogicPageObjects;
import framework.Utilities.BaseTest;

public class DatePickersLogic extends BaseTest {

	static DatePickersLogicPageObjects datepickerslogic;
	public final static String datePickerTestUrl="https://testautomationpractice.blogspot.com/";
	

;
	
@BeforeClass
public void setUp() {
	
	BaseTest.launchBrowser();
	driver=BaseTest.getDriver();
	datepickerslogic= new DatePickersLogicPageObjects(driver);
	driver.get(datePickerTestUrl);	
	
}
 @AfterSuite
    public void tearDownBrowser() {
        BaseTest.tearDown();
    }
	 
	
	 @Test
	 public static void testDatePickersDemoLogic() {
		 datepickerslogic.datePickersDropDown();
		
	 }
}
