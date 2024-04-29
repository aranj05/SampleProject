package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import commomUtills.Utility;

public class ReportTest {
	WebDriver driver;        //Initialization at class level
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	
	
	@BeforeTest
	public void initExtent() {
		extentReports= new ExtentReports();
		spark=new ExtentSparkReporter("test-output/SparkReport.html")
				.viewConfigurer()
				.viewOrder()
				.as(new ViewName[] {
						ViewName.DASHBOARD,
						ViewName.TEST,
						ViewName.AUTHOR,
						ViewName.DEVICE,
						ViewName.LOG
				}).apply();
		extentReports.attachReporter(spark);
	}
	
	@BeforeMethod
	public void setup() {
		driver=new ChromeDriver();  //declaration
		driver.manage().window().maximize();
	}
  @Test            
  public void javaSearchTest() {
	  	extentTest= extentReports.createTest("Java Search Test");
		driver.get("https://www.google.com/");
		WebElement srcBox= driver.findElement(By.className("gLFyf"));
		srcBox.sendKeys("Java Tutorial");
		srcBox.submit();
		Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");    //hard assertion
		}
  
 @Test (retryAnalyzer= RetryAnalyzer.class)
  public void seleniumSearchTest() {
	 extentTest= extentReports.createTest("Selenium Search Test");
		driver.get("https://www.google.com/");
		WebElement srcBox= driver.findElement(By.className("gLFyf"));
		srcBox.sendKeys("Selenium Tutorial");
		srcBox.submit();
		Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search page");
		}
  
  
  
  @AfterTest
  public void finishExtent()
  {
	  extentReports.flush();
  }
  
  
  @AfterMethod
  public void tearDown(ITestResult result) {
	  extentTest.assignAuthor("Adarsh Ranjan")
	  .assignCategory("Rgression")
	  .assignDevice(System.getProperty("os.name"))
	  .assignDevice(System.getProperty("os.version"));
	  if(ITestResult.FAILURE== result.getStatus()) {
		  extentTest.log(Status.FAIL, result.getThrowable().getMessage());
		  String strPath=Utility.getScreenshotPath(driver);
		  extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(strPath).build());
	  }
	  else if(ITestResult.SKIP== result.getStatus()) {
		  extentTest.log(Status.SKIP, result.getThrowable().getMessage());
	  }
	 driver.close(); 
  }
}
