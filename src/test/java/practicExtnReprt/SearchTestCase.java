package practicExtnReprt;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import framework.PageObjects.ExtentReportsObjects;
import framework.Utilities.BaseTest;

public class SearchTestCase {
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("reports/spark.html");
	WebDriver driver;
	 ExtentReportsObjects extentreportsobj;
	
	@BeforeTest
	public void browserLaunch() {
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("myReport");
		extent.attachReporter(spark);
		BaseTest.launchBrowser();
		driver=BaseTest.getDriver();
		extentreportsobj = new ExtentReportsObjects(driver);
		driver.get("https://www.google.com");
		
	}
	
	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
		
	}
	
	@Test
	public void TestCase_001() {
		ExtentTest exTest = extent.createTest("verify the page title").assignAuthor("vanu")
				.assignCategory("functional test cases").assignDevice("Windows");
		exTest.info("i'm capturing the page title");
		String pageTitle = driver.getTitle();
		exTest.info("captured the page title");
		if(pageTitle.equalsIgnoreCase("google")) {
			
			exTest.pass("page title is verified" +pageTitle);
			
		}else {
			exTest.fail("page title is not matched with expected result " +pageTitle);
		}
	}
	
	@Test
	public void testCase_002() throws IOException {
		ExtentTest exTest = extent.createTest("verify the page title").assignAuthor("vanu")
				.assignCategory("functional test cases").assignDevice("Windows");
		try {
			driver.findElement(By.linkText("about")).click();
			exTest.pass("navigating to about page");
			
		}catch(Exception e) {
			exTest.fail("unexpted error in application" +e.getMessage());
			exTest.addScreenCaptureFromPath(captureScreenshot(driver));
			
		}
		
	}
	
	public static String captureScreenshot(WebDriver driver) throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFilePath = new File("reports/images/" +System.currentTimeMillis()+ ".png");
		String absolutePathLocation = destFilePath.getAbsolutePath();
		
		FileUtils.copyFile(srcFile, destFilePath);
		return absolutePathLocation;
	}

}
