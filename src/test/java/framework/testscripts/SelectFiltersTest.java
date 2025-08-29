package framework.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.PageObjects.SearchFiltersPageObjects;
import framework.Utilities.BaseTest;

public class SelectFiltersTest {
	
	WebDriver driver;
	SearchFiltersPageObjects searchFilterObjects;
	
    public final static String flipkartUrl = "https://www.flipkart.com/";

	
	@BeforeClass
	public void setUp() {
		
		BaseTest.launchBrowser();
		driver=BaseTest.getDriver();
		searchFilterObjects= new SearchFiltersPageObjects(driver);
		driver.get(flipkartUrl);	
	}
	
	 @AfterSuite
	    public void tearDownBrowser() {
	        BaseTest.tearDown();
	    }
	 @Test
	 public void testSearchFilters() {
		 searchFilterObjects.searchProduct();
		 System.out.println("search is sucessful");
		 searchFilterObjects.getBrandNames();
		 searchFilterObjects.checkAllBrands();
		 searchFilterObjects.unCheckAllBrands();
		 
	 }
}
