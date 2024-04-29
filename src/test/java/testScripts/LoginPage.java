package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPage {
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String strBrowser) {
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(strBrowser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
	}
	
  @Test
  public void validLogin() {
	    
		
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.className("radius")).click();
		driver.findElement(By.cssSelector("div#flash-messages")).isDisplayed();
  }
}
