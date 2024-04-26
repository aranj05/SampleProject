package parallelScripts;

import org.testng.annotations.Test;

public class SampleThree {
	@Test
	  public void testOne() {
		long id= Thread.currentThread().getId();
		  System.out.println("This is TestOne- SampleThree" +id);
	  }
	  
	  @Test
	  public void testTwo() {
		  long id= Thread.currentThread().getId();
		  System.out.println("This is TestTwo- SampleThree" +id);
	  }
	  
	  @Test
	  public void testThree() {
		  long id= Thread.currentThread().getId();
		  System.out.println("This is TestThree- SampleThree" +id);
	  }
}
