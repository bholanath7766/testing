package m21_demo_TestNG_Framework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class M21_Demo4_AssertTrue_False 
{ //Assert True
  @Test
  public void test1() 
  {
	  System.out.println("start test1");
	  Assert.assertTrue(20>5, "Err 5 is less than 20");//pass
	  System.out.println("End test2");
  }
  @Test
  public void test2()
  {
	  System.out.println("start test2");
	  Assert.assertTrue("Hello".equals("Hi"),"Err Hello ids not equals Hi");//fail(comment This for further execution)
	  System.out.println("end test2");
  }
  
  //Assert False
  /*
     @Test
  public void test3() 
  {
	  System.out.println("start test3");
	  Assert.assertFalse(20>5, "Err 5 is less than 20");//fail
	  System.out.println("end test3");
  }
  @Test
  public void test4()
  {
	  System.out.println("start test4");
	  Assert.assertFalse("Hello".equals("Hi"), "Err Hello is not equal Hi");//pass
	  System.out.println("end test4");
  }
  
  
  
   */
}
