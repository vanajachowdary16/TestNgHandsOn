package framework.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import framework.PageObjects.GoibiboPageObjects;
import framework.Utilities.BaseTest;

public class GoibiboSiteAutomation {

	    WebDriver driver;
	    GoibiboPageObjects goibibo;
	    public final static String goibiboUrl = "https://www.goibibo.com/";

	    @BeforeClass
	    public void setUp() {
	        BaseTest.launchBrowser();
	        driver = BaseTest.getDriver();
	        driver.get(goibiboUrl);
	        goibibo = new GoibiboPageObjects(driver);
	    }
}
