package framework.Utilities;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	
	public final static String Project_Path=System.getProperty("user.dir") + "/";
	public final static String WebDriverPath=Project_Path+"/drivers/chromedriver.exe";
	public final static String browser ="chrome";
	public final static String agrstyle = "arguments[0].style.border='3px solid red'";
	public final static String argclick="arguments[0].click()";
	
	protected static WebDriver driver;
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void launchBrowser() {
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setBrowserName(browser);
		System.setProperty("webdriver.chrome.driver", WebDriverPath);
		try {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			
		}catch(Exception e) {
			
		}
	}
	
	public static void tearDown() {
		try {
			if(driver!=null) {
				driver.quit();
			}
		}catch(Exception e) {
			
			
		}
	}
	
	public static void explicitWait(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static WebElement findElement(WebDriver driver, By locator ) {
		WebElement element = null;
		try {
			BaseTest.explicitWait(locator);	
			element = driver.findElement((locator));
					
		}
		catch(NoSuchElementException  e) {
			System.out.println("element is not found: " +locator);
		}
		return element;
	}
	
	public static void sendKeys(WebDriver driver, By locator, String testData) {
		WebElement element = BaseTest.findElement(driver, locator);
		BaseTest.explicitWait(locator);	
		element.sendKeys(testData);
		element.sendKeys(Keys.TAB);
		element.sendKeys(Keys.ENTER);
		
	}
	
	public static void jsScrollToElement(WebDriver driver, WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		}catch(Exception e) {
			
		}
	}
	
	 public static void swtichToWindow() {
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			String childWindow = allWindows.stream()
				    .filter(handle -> !handle.equals(parentWindow))
				    .findFirst()
				    .orElseThrow(() -> new RuntimeException("Child window not found"));
			driver.switchTo().window(childWindow);
	 }

}
