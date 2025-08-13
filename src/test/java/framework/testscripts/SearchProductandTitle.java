package framework.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import framework.PageObjects.HomePageObjects;
import framework.Utilities.BaseTest;

public class SearchProductandTitle {

    WebDriver driver;
    HomePageObjects homePage;

    public final static String flipkartUrl = "https://www.flipkart.com/";

    @BeforeClass
    public void setUP() {
        BaseTest.launchBrowser();
        driver = BaseTest.getDriver();
        driver.get(flipkartUrl);

        homePage = new HomePageObjects(driver);
    }

    @AfterSuite
    public void tearDownBrowser() {
        BaseTest.tearDown();
    }

    @Test
    public void testProductSearchandTitle() {
        homePage.searchProduct();
        homePage.selectFirstProduct();
        BaseTest.swtichToWindow();
        homePage.getProductTitle();
        System.out.println(homePage.getProductTitle());
    }
}
