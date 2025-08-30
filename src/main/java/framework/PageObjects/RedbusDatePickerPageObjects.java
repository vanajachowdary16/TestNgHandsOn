package framework.PageObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.Utilities.BaseTest;

public class RedbusDatePickerPageObjects extends BaseTest{
	
	
	public final static By calendarLocator= By.xpath("//div[@class='dateInputWrapper___c8345a']");
	
	//public final static String inputDate ="12-12-2025";
	public final static String nextMonth = "Oct, 2025";
	
	public final static By dateSelectionLocator = By.xpath("//span[normalize-space()='27']");
	
	public final static By selectingNextMonth = By.xpath("//i[@aria-label='Next month, " + nextMonth + "']");
	public final static By selectedDateText = By.xpath("//span[@class='doj___e69938']");

	
	
	public RedbusDatePickerPageObjects(WebDriver driver) {
		this.driver = driver;	
	}
	public void navigateToMonth(WebDriver driver, String expMonthYear) throws ParseException {
		BaseTest.findElementByLocator(driver, calendarLocator).click();
	    // Format of month-year from the calendar
		boolean desiredDate=false;
	    SimpleDateFormat sdf = new SimpleDateFormat("MMM, yyyy", Locale.ENGLISH);

	    // Convert expected month-year string to Date
	    Date expectedDate = sdf.parse(expMonthYear);
	    System.out.println("expected date is " +expectedDate);

	    while (desiredDate=true) {
	        // Get current month-year displayed (strip the day part)
	        String currentMonthYearText = driver.findElement(By.cssSelector("span.doj___e69938")).getText();
	        String currentMonthYear = currentMonthYearText.substring(3); // "09 Oct, 2025" → "Oct, 2025"

	        Date currentDate = sdf.parse(currentMonthYear);

	        if (currentDate.equals(expectedDate)) {
	        	desiredDate=true;
	            break; // reached desired month-year
	        } 
	        else if (currentDate.before(expectedDate)) {
	            // Go forward
	            driver.findElement(By.xpath("//i[starts-with(@aria-label,'Next month')]")).click();
	        } 
	        else {
	            // If needed, go backward (if previous button exists)
	            driver.findElement(By.xpath("//i[starts-with(@aria-label,'Previous month')]")).click();
	        }
	    }
	}
	public void selectAvailableDate() {
		
		BaseTest.findElementByLocator(driver, calendarLocator).click();
		
	}
}
