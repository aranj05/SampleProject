package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GooglePageTest {
	WebDriver driver;        //Initialization at class level
	
	@BeforeTest
	//@BeforeMethod
	public void setup() {
		driver=new ChromeDriver();  //declaration
		driver.manage().window().maximize();
	}
 // @Test (enabled=false)            //skipping test case
  public void javaSearchTest() {
	  
		driver.get("https://www.google.com/");
		WebElement srcBox= driver.findElement(By.className("gLFyf"));
		srcBox.sendKeys("Java Tutorial");
		srcBox.submit();
		Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");    //hard assertion
		}
 /* @Test
 public void SearchTest() {
	  
		driver.get("https://www.google.com/");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(driver.getTitle(), "Google page");        //soft assertion
		WebElement srcBox= driver.findElement(By.className("gLFyf"));
		srcBox.sendKeys("Java Tutorial");
		srcBox.submit();
		softAssert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
		softAssert.assertAll();             //combining all assertion & give the results
		} */
  
 // @Test (priority= 1)
  public void seleniumSearchTest() {
	  
		driver.get("https://www.google.com/");
		WebElement srcBox= driver.findElement(By.className("gLFyf"));
		srcBox.sendKeys("Selenium Tutorial");
		srcBox.submit();
		Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");
		}
  
  @Test (alwaysRun= true,dependsOnMethods="appiumSearchTest")
  public void cucumberSearchTest() {
	  
		driver.get("https://www.google.com/");
		WebElement srcBox= driver.findElement(By.className("gLFyf"));
		srcBox.sendKeys("Cucumber Tutorial");
		srcBox.submit();
		Assert.assertEquals(driver.getTitle(), "Cucumber Tutorial - Google Search");
		}
  
  @Test 
  public void appiumSearchTest() {
	  
		driver.get("https://www.google.com/");
		WebElement srcBox= driver.findElement(By.className("gLFyf"));
		srcBox.sendKeys("Appium Tutorial");
		srcBox.submit();
		Assert.assertEquals(driver.getTitle(), "Appium Tutorial - Google Search page");
		}
  
  
  
  @AfterTest
  //@AfterMethod
  public void tearDown() {
	 driver.close(); 
  }
}
