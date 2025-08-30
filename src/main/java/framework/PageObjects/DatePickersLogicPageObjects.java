package framework.PageObjects;

import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import framework.Utilities.BaseTest;

public class DatePickersLogicPageObjects extends BaseTest {
	
	public DatePickersLogicPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	public final static By datePicker2Locator = By.id("txtDate");
	public final static String requiredYear = "2026";
	public final static String requiredMonth ="Jan";
	public final static String requiredDate="28";

	public final static By yearDropDown= By.cssSelector(".ui-datepicker-year");
	public final static By monthDropdown = By.cssSelector(".ui-datepicker-month");
	public final static By displayMonth = By.xpath("//select[@class='ui-datepicker-month']");

	private static HashMap<String, Month> monthMap = new HashMap<>();
	

	

	// Select Year and Month
	public void datePickersDropDown() {
		
		driver.findElement(datePicker2Locator).click();
		
		

		// Now elements exist because calendar popup is open
		WebElement selectYearDropDown = BaseTest.findElementByLocator(driver, yearDropDown);
		WebElement selectMonthDropDown = BaseTest.findElementByLocator(driver, monthDropdown);

		// Select required year
		Select selectYear = new Select(selectYearDropDown);
		selectYear.selectByVisibleText(requiredYear);
		
		
		// Adjust month until match
		while (true) {
			
			Select monthDropdownSelect = new Select(driver.findElement(displayMonth));
			String selectedMonth = monthDropdownSelect.getFirstSelectedOption().getText().substring(0, 3); // e.g., "Jan"


			//String selectedMonth = driver.findElement(displayMonth).getText();

			Month expectedMonth = convertMonth(requiredMonth);
			Month actualMonth = convertMonth(selectedMonth);

			int result = expectedMonth.compareTo(actualMonth);

			if (result < 0) {
				// Past month → click previous
				driver.findElement(By.xpath("//a[contains(@class,'ui-datepicker-prev')]")).click();
			} else if (result > 0) {
				// Future month → click next
				driver.findElement(By.xpath("//a[contains(@class='ui-datepicker-next ui-corner-all')]")).click();
			} else {
				break; // Correct month reached
			}
		}
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td/a"));
		for(WebElement dt : dates) {
		
			if(	dt.getText().equals(requiredDate)) {
				dt.click();
				break;
			}
		}
		
		String selectedDate = driver.findElement(By.id("txtDate")).getText();
		System.out.println("selected date is" +selectedDate);
	}

	// Convert string to Month enum
	public static Month convertMonth(String month) {
		if (monthMap.isEmpty()) {
			monthMap.put("Jan", Month.JANUARY);
			monthMap.put("Feb", Month.FEBRUARY);
			monthMap.put("Mar", Month.MARCH);
			monthMap.put("Apr", Month.APRIL);
			monthMap.put("May", Month.MAY);
			monthMap.put("Jun", Month.JUNE);
			monthMap.put("Jul", Month.JULY);
			monthMap.put("Aug", Month.AUGUST);
			monthMap.put("Sep", Month.SEPTEMBER);
			monthMap.put("Oct", Month.OCTOBER);
			monthMap.put("Nov", Month.NOVEMBER);
			monthMap.put("Dec", Month.DECEMBER);
		}

		Month vmonth = monthMap.get(month);
		if (vmonth == null) {
			System.out.println("Invalid month: " + month);
		}
		//System.out.println("Received monthName: '" + month + "'");

		return vmonth;
	}
}
