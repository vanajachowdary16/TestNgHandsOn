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
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	 WebElement fromInput = wait.until(ExpectedConditions.elementToBeClickable(
             By.xpath("//div[@data-testid='to-testID-origin']//input")));
     fromInput.click();
     fromInput.clear();
     fromInput.sendKeys("Chennai");
     wait.until(ExpectedConditions.elementToBeClickable(
             By.xpath("//div[@data-testid='to-testID-origin']"))).click();
   //Select To City
     WebElement toInput = wait.until(ExpectedConditions.elementToBeClickable(
             By.xpath("//div[@data-testid='to-testID-destination']//input")));
     toInput.click();
     toInput.clear();
     toInput.sendKeys("Delhi");
     //Click To field
     wait.until(ExpectedConditions.elementToBeClickable(
         By.xpath("//div[@data-testid='to-testID-destination']"))).click();
     //Select from list directly
     wait.until(ExpectedConditions.elementToBeClickable(
         By.xpath("//div[contains(text(),'Delhi')]"))).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//div[@data-testid=\"undefined-month-October-2025\"]//following-sibling::*[contains(@data-testid,'calendar-day-1')]")).click();

	String depatureDate =driver.findElement(By.xpath("(//div[contains(text(), '2025')])[2]")).getText();
	System.out.println("selected depature date is " +depatureDate);
	}
}
