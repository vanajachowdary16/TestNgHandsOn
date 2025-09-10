package practicExtnReprt;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewExtentTest {
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("reports/spark.html");
  @BeforeTest
  public void beforeTest() {
	  
	  extent.attachReporter(spark);
  }

  @AfterTest
  public void afterTest() {
	  extent.flush();
  }
  @Test
  public void f1() {
	  ExtentTest test = extent.createTest("Launch Browser and website")
			  .assignAuthor("vanu").assignCategory("smoke test").assignDevice("chrome");
	  test.log(Status.PASS, "user launched website");
	  test.pass("user launched website verified");
  }
  @Test
  public void f2() {
	  ExtentTest test = extent.createTest("verify login");
	  test.log(Status.INFO, "alers are displaying");
	  test.pass("login is verified");
	  test.warning("Reset password alerts displayed");
  }
  @Test
  public void f3() {
	  ExtentTest test = extent.createTest("verify login dashboard");
	  test.log(Status.SKIP, "verify dashboard skipped");
  }
  @Test
  public void f4() {
	  ExtentTest test = extent.createTest("verify user send emails from test application");
	  test.fail("unable to laod emails due to server down");
  }
  @Test
  public void f5() {
	  ExtentTest test = extent.createTest("verify reports and analytics");
	  test.fail("reports getting crashed");
  }
  @Test
  public void f6() {
	  ExtentTest test = extent.createTest("verify logout");
	  test.pass("user logged out from application");
	  test.info("user is redirected to login page");
  }

}
