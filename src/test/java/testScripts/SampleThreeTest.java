package testScripts;

import org.testng.annotations.Test;

public class SampleThreeTest {
  @Test (groups="featureOne")
  public void testOne() {
	  System.out.println("This is TestOne- Sample three");
  }
  
  @Test (groups="featureTwo")
  public void testTwo() {
	  System.out.println("This is TestTwo- Sample three");
  }
  
  @Test (groups="featureThree")
  public void testThree() {
	  System.out.println("This is TestThree-Sample three");
  }
  
  @Test
  public void testFour() {
	  System.out.println("This is TestFour-Sample three");
  }
  
}
