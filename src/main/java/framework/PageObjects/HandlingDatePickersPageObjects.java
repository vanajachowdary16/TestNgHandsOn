package framework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.Utilities.BaseTest;

public class HandlingDatePickersPageObjects extends BaseTest{
	public HandlingDatePickersPageObjects(WebDriver driver) {
		this.driver=driver;			
	}
	
	public final static By dateLocator = By.id("datepicker");
	public final static String myInputDate="08/05/2025";
	public final static By frameLocator = By.cssSelector(".demo-frame");
	

	public final static String year ="2025";
	public final static String month="December";
	public final static String date ="25";
	
	public final static By yearLocator =By.cssSelector(".ui-datepicker-year");
	public final static By monthLocator = By.cssSelector(".ui-datepicker-month");
	public final static By nextButtonLocator = By.cssSelector(".ui-icon.ui-icon-circle-triangle-e");
	public final static By previousDate = By.cssSelector(".ui-datepicker-prev.ui-corner-all");
	public final static By daysLocator = By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td");
	
	
	//using sendKeys 
	public static void testDateInputField() {
		//driver.switchTo().frame(0);
		BaseTest.findElementByLocator(driver, dateLocator);
		BaseTest.sendKeysInput(driver, dateLocator, myInputDate);
	}
	
	public static void selectFutureDate(WebDriver driver, String year, String month, String date)
	{
          while(true) {
			
			String currentYear = BaseTest.findElementByLocator(driver, yearLocator).getText();
			String currentMonth = BaseTest.findElementByLocator(driver, monthLocator).getText();
			if(currentMonth.equals(month) && currentYear.equals(year)) {
				break;
			}
			BaseTest.findElementByLocator(driver,nextButtonLocator).click();
		}
		
		List<WebElement> dates = driver.findElements(daysLocator);
		for(WebElement dt : dates) {
			if(dt.getText().equals(date)){
				dt.click();
				break;
			}
			
		}
	}

}
