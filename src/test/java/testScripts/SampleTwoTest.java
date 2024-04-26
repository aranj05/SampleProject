package testScripts;

import org.testng.annotations.Test;

public class SampleTwoTest {
  @Test (groups="featureOne")
  public void testOne() {
	  System.out.println("This is TestOne- Sample One");
  }
  
  @Test (groups="featureTwo")
  public void testTwo() {
	  System.out.println("This is TestTwo- Sample One");
  }
  
  @Test (groups="featureThree")
  public void testThree() {
	  System.out.println("This is TestThree- Sample One");
  }
  
  @Test
  public void testFour() {
	  System.out.println("This is TestFour- Sample One");
  }
  
}
