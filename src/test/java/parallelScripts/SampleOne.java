package parallelScripts;

import org.testng.annotations.Test;

public class SampleOne {
  @Test
  public void testOne() {
	  long id= Thread.currentThread().getId();
	  System.out.println("This is TestOne- SampleOne.." +id);
  }
  
  @Test
  public void testTwo() {
	  long id= Thread.currentThread().getId();
	  System.out.println("This is TestTwo- SampleOne.." +id);
  }
  
  @Test
  public void testThree() {
	  long id= Thread.currentThread().getId();
	  System.out.println("This is TestThree- SampleOne.." +id);
  }
  
}
