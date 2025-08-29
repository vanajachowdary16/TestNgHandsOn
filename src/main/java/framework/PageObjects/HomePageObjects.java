package framework.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.Utilities.BaseTest;

public class HomePageObjects extends BaseTest {
    
    public final static By searchBar = By.xpath("//input[@title='Search for Products, Brands and More']");
    public final static By firstProduct = By.xpath("(//a[@class='WKTcLC'])[1]");
    public final static By productTitleXpath = By.xpath("//h1[@class='_6EBuvT']");

    public final static String product = "titan watches";

    public HomePageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct() {
        BaseTest.findElementByLocator(driver, searchBar);
        BaseTest.sendKeysInput(driver, searchBar, product);
    }

    public void selectFirstProduct() {
        BaseTest.findElementByLocator(driver, firstProduct).click();
    }

    public String getProductTitle() {
    	BaseTest.explicitWait(productTitleXpath);
        WebElement product = BaseTest.findElementByLocator(driver, productTitleXpath);
        return product.getText();       
    }  
    
}
