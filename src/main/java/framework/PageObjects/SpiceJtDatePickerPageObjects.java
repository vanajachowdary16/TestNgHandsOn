package framework.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.Utilities.BaseTest;

public class SpiceJtDatePickerPageObjects extends BaseTest{
	
	public SpiceJtDatePickerPageObjects(WebDriver driver) {
		this.driver = driver;	}
	
	//div[contains(@data-test-id,"October-2025")]
	//div[contains(@data-test-id,'"+ requiredMonthyear + "')]
	
	public static String requiredYear="2025";
	public static String requiredMonth="December";
	public static String requiredDate="25";
	public static String requiredMonthyear ="December 2025";
	public final static By calendaricon = By.xpath("//div[text() ='Departure Date']");
	public final static By actualDate = By.xpath("//div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar' and contains(text(),'" + requiredDate + "')]");
	public static String alldivsXpath="//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']";
			//("//button//*[name()='svg']");
	public final static By nextButton = By.xpath("//div[contains(@class,'css-1dbjc4n') and contains(@class,'r-1loqt21')]");
	public static String monthxpath ="//div[contains(@class,'css-76zvg2') and contains(text(),'2025')]";
	
	public final static By monthYearLocator = By.xpath(monthxpath);
	public final static String selectDay = "//div[@data-testid='undefined-calendar-day-25']";

	public final static By selectDateXpath = By.xpath(selectDay);
	
	
	public static void testDatePicker() throws InterruptedException {
		
	driver.findElement(calendaricon).click();
	String selectedDateText =driver.findElement(monthYearLocator).getText();
	System.out.println(selectedDateText);
	String[] parts = selectedDateText.replace(",", "").split(" ");
	String selectedDate  = parts[1];
	String selectedMonth = parts[2];
	String selectedYear  = parts[3];
	String testXpath = driver.findElement(By.xpath(alldivsXpath)).getText();
	System.out.println("test xpath get text is" +testXpath);
	
	List<WebElement> myMonthYear = driver.findElements(By.xpath(alldivsXpath));

	for (WebElement dt : myMonthYear) {
	    String testGetText = dt.getText().trim();

	    String[] testParts = testGetText.split(" ");
	    if (testParts.length >= 2) {
	        String currentMonth = testParts[0];
	        String currentYear = testParts[1];

	        if (currentMonth.equals(requiredMonth) && currentYear.equals(requiredYear)) {
	            System.out.println("✅ Yes, the date is correct: " + currentMonth + " " + currentYear);
	            dt.click();
	            Thread.sleep(5000);
	           WebElement element = driver.findElement(monthYearLocator);
	           ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	           element.findElement(selectDateXpath).click();
	          /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	           WebElement date = wait.until(ExpectedConditions.elementToBeClickable(
	               By.xpath("//div[@data-testid='undefined-calendar-day-21']")));
	           date.click();*/

	           // WebElement element1 = driver.findElement(selectDateXpath);
	            //((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
	         
	            

	            
	            String selectdDate = driver.findElement(actualDate).getText();
	            System.out.println("🎯 Selected date is: " + selectedDate);
	           //driver.findElement(selectDateXpath).click();
	            break; // stop loop once correct month-year is found
	        }
	        // Do nothing if it doesn’t match
	    }
	    // Skip if format is invalid
	}
	




	
	
	/*List<WebElement> allMonths = driver.findElements(monthYearLocator);
	for(WebElement mn : allMonths) {
		String monthvalue = mn.getText();
		System.out.println(monthvalue);
	}*/
	}

}
