package practicExtnReprt;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import framework.PageObjects.ExtentReportsObjects;
import framework.Utilities.BaseTest;

public class SimpleExtentReport1 {

    WebDriver driver;
    ExtentReportsObjects extentreportsobj;
    ExtentReports report;
    ExtentTest extentTest;

    @BeforeClass
    public void setUp() {
        BaseTest.launchBrowser();
        driver = BaseTest.getDriver();
        extentreportsobj = new ExtentReportsObjects(driver);

        // Initialize ExtentReports with SparkReporter
        ExtentSparkReporter spark = new ExtentSparkReporter("extent-report.html");
        report = new ExtentReports();
        report.attachReporter(spark);

        driver.get("https://www.google.com/");
    }

    @BeforeMethod
    public void createTest(Method method) {
        // Create new test entry for each @Test method
        extentTest = report.createTest(method.getName());
    }

    @Test
    public void validateTitle() {
        extentTest.log(Status.INFO, "TestCase validate title is started");
        String title = driver.getTitle();
        System.out.println(title);
        extentTest.log(Status.PASS, "Title is: " + title);
    }

    @Test
    public void gmailNavigate() throws IOException {
        extentTest.log(Status.WARNING, "TestCase Gmail navigation started");
        driver.findElement(By.linkText("Gmail")).click();
        driver.findElement(By.linkText("Sign in")).click();
        extentTest.log(Status.PASS, extentTest.addScreenCaptureFromPath(captureScreen(driver))+"Gmail navigation is completed");
    }

    @AfterSuite
    public void tearDownBrowser() {
        BaseTest.tearDown();
        report.flush(); // write everything to the report
    }
    public static String captureScreen(WebDriver driver) throws IOException {
    	
    	File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	File destFile = new File("reports/images/" +System.currentTimeMillis()+ ".png");
    	String absolute_screen =destFile.getAbsolutePath();
    	System.out.println(absolute_screen);
    	FileUtils.copyFile(srcFile, destFile);
		return absolute_screen;
    	
    }
}
