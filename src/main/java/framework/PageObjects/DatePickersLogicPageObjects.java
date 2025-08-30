package framework.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import framework.Utilities.BaseTest;

public class DatePickersLogicPageObjects extends BaseTest{
	
	public DatePickersLogicPageObjects(WebDriver driver) {
		this.driver = driver;
		
	}
	public final static By datePicker2Locator = By.cssSelector("input.hasDatepicker:nth-of-type(2)");
	public final static String requiredyear = "2026";
	public final static String requiredMonth ="Aug";
	public final static String requiredDate="28";
 
	public final static By yearDropDown= By.cssSelector(".ui-datepicker-year");
	public final static By monthDropdown = By.cssSelector(".ui-datepicker-month");
	
	static WebElement selectYearDropDown=BaseTest.findElementByLocator(driver, yearDropDown);
	static WebElement selectMonthDropDown = BaseTest.findElementByLocator(driver, monthDropdown);
	
	public static void datePickersDropDown() {
		driver.findElement(datePicker2Locator).click();
		 Select selectYear = new Select(selectYearDropDown);
		 selectYear.selectByVisibleText(requiredyear);
		 
	}

}
