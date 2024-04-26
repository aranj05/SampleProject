package parallelScripts;

import org.testng.annotations.Test;

public class SampleTwo {
	@Test
	  public void testOne() {
		long id= Thread.currentThread().getId();
		  System.out.println("This is TestOne- SampleTwo.." +id);
	  }
	  
	  @Test
	  public void testTwo() {
		  long id= Thread.currentThread().getId();
		  System.out.println("This is TestTwo- SampleTwo.." +id);
	  }
	  
	  @Test
	  public void testThree() {
		  long id= Thread.currentThread().getId();
		  System.out.println("This is TestThree- SampleTwo.." +id);
	  }
}
