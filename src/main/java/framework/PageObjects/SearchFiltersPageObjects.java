package framework.PageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.Utilities.BaseTest;

public class SearchFiltersPageObjects extends BaseTest {

    public final static By searchBar = By.xpath("//input[@title='Search for Products, Brands and More']");
    public final static String product = "watches";
    
    public SearchFiltersPageObjects(WebDriver driver) {
        this.driver = driver;
    }
    
    public void searchProduct() {
        BaseTest.findElementByLocator(driver, searchBar);
        BaseTest.sendKeysInput(driver, searchBar, product);      
    }

    public List<String> getBrandNames() {
        List<WebElement> brandElements = driver.findElements(
            By.xpath("//div[normalize-space()='Brand']/following::div[@class='_6i1qKy']")
        );
        return brandElements.stream()
            .map(e -> e.getText().trim())
            .filter(name -> !name.isEmpty())
            .collect(Collectors.toList());
    }

    public void checkAllBrands() {
        List<WebElement> brandElements = driver.findElements(
            By.xpath("//div[normalize-space()='Brand']/following::div[@class='_6i1qKy']")
        );

        for (WebElement brandElement : brandElements) {
            try {
                if (brandElement.isDisplayed() && brandElement.isEnabled()) {
                   brandElement.click();
                   Thread.sleep(500);
                    WebElement checkbox = brandElement.findElement(By.xpath(".//input[@type='checkbox']"));
                    if (checkbox.isSelected()) {
                        System.out.println("Checked successfully: " + brandElement.getText());
                    } else {
                        System.out.println("Failed to check: " + brandElement.getText());
                    }
                }
            }catch(Exception e) {
            	System.out.println("error in interacting with brand: " +brandElement.getText());
        }
    }
}
    
    public void unCheckAllBrands() {
    	List<WebElement> brandElements = driver.findElements(
                By.xpath("//div[normalize-space()='Brand']/following::div[@class='_6i1qKy']")
            );

            for (WebElement brandElement : brandElements) {
                try {
                    if (brandElement.isDisplayed() && brandElement.isEnabled()) {
                       brandElement.click();
                       Thread.sleep(500);
                        WebElement checkbox = brandElement.findElement(By.xpath(".//input[@type='checkbox']"));
                        if (checkbox.isSelected()) {
                            System.out.println("Checked successfully: " + brandElement.getText());
                        } else {
                            System.out.println("Failed to check: " + brandElement.getText());
                        }
                    }
                }catch(Exception e) {
                	System.out.println("error in interacting with brand: " +brandElement.getText());
            }
        }
    	
    }
}
