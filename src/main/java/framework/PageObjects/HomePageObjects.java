package framework.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.Utilities.BaseTest;

public class HomePageObjects extends BaseTest {

    WebDriver driver;

    // Locators only
    public final static By searchBar = By.xpath("//input[@title='Search for Products, Brands and More']");
    public final static By firstProduct = By.xpath("(//a[@class='WKTcLC'])[1]");
    public final static By productTitleXpath = By.xpath("//h1[@class='_6EBuvT']");

    public final static String product = "titan watches";

    public HomePageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct() {
        BaseTest.findElement(driver, searchBar);
        BaseTest.sendKeys(driver, searchBar, product);
    }

    public void selectFirstProduct() {
        BaseTest.findElement(driver, firstProduct).click();
    }

    public String getProductTitle() {
    	BaseTest.explicitWait(productTitleXpath);
        WebElement product = BaseTest.findElement(driver, productTitleXpath);
        BaseTest.jsScrollToElement(driver, product);
        return product.getText();
       
    }  
    
}
