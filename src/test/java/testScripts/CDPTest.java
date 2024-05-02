package testScripts;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.log.Log;
import org.openqa.selenium.devtools.v116.log.model.LogEntry;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CDPTest {
	
	ChromeDriver driver;
	DevTools devTools;
	
	@BeforeMethod
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		devTools= driver.getDevTools();
		devTools.createSession(driver.getWindowHandle());
	}
	
 /* @Test
  public void deviceModeTest() {
	  Map deviceMetrices=new HashMap() {{
		  put("width",800);
		  put("height",1200);
		  put("deviceScaleFactor",50);
		  put("mobile",true);
	  }};
	  driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrices);
	  driver.get("https://www.selenium.dev/");
	  } 
  @Test
  public void geoLocationTest() {
	  Map deviceMetrices=new HashMap() {{
		  put("latitude",33.748997);
		  put("longitude",-84.387985);
		  put("accuracy",100);	  
	  }};
	  driver.executeCdpCommand("Emulation.setGeolocationOverride", deviceMetrices);
	  driver.get("https://oldnavy.gap.com/stores");
	  } */
  
  @Test
  public void captureConsoleLogTest() {
	  devTools.send(Log.enable());
	  devTools.addListener(Log.entryAdded(), 
			  new Consumer<LogEntry>() {
		public void accept(LogEntry logEntry) {
			System.out.println("log:"+logEntry.getText());
			System.out.println("level:"+logEntry.getLevel());
		}
	  });
	  
	  driver.get("https://the-internet.herokuapp.com/");
	  }
  
  }

