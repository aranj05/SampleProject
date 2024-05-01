package testScripts;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment2 {
	WebDriver driver;
	Properties prop;
	
	@BeforeTest
	public void initSetup() throws IOException {
		prop =new Properties();
		String path=System.getProperty("user.dir")+
				"//src//main//resources//configFiles//config.properties";
		FileInputStream fin= new FileInputStream(path);
		prop.load(fin);
		fin.close();
	}
	
	@BeforeMethod
	public void setup() {
		String strBrowser=prop.getProperty("browser");
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(strBrowser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
	}
	
  @Test (dataProvider="logindata")
  public void addItem() {
	  driver.get(prop.getProperty("url"));
	  driver.findElement(By.id("login2")).click();
	  //driver.findElement(By.id("loginusername")).sendKeys(prop.getProperty("username"));
	  //driver.findElement(By.id("loginpassword")).sendKeys(prop.getProperty("password"));
	  driver.findElement(By.className("btn btn-primary")).click();
  }
  
  @DataProvider (name="logindata")
  public Object[][] getData() throws IOException, ParseException{
	  String path= System.getProperty("user.dir")+
			  "//src//main//resources//testData//customerDetails.json";
	  FileReader reader=new FileReader(path);
	  JSONParser parser=new JSONParser();
	  Object obj= parser.parse(reader);
	  JSONObject jsonObj=(JSONObject)obj;
	  JSONArray userArray= (JSONArray)jsonObj.get("customerData");
	  String arr[][]=new String[userArray.size()][];
	  for(int i=0; i<userArray.size();i++) {
		  JSONObject user=(JSONObject)userArray.get(i);
		  String strName= (String)user.get("Name");
		  String country= (String)user.get("Country");
		  String city= (String)user.get("City");
		  String creditCard= (String)user.get("Credit card");
		  String month= (String)user.get("Month");
		  String year= (String)user.get("Year");
		  String record[]= {strName,country,city,creditCard,month,year};
		  arr[i]=record;
	  }
	  return arr;
  }
}
