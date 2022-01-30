package m21_demo_TestNG_Framework;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class M21_Demo9_Assert_SoftAssert {
  @Test
  public void test1() 
  {   
	  SoftAssert softAss=new SoftAssert();
	  System.out.println("\nAssert1"); 
	  softAss.assertEquals(10, 35);   //fail
	  
	  System.out.println("\nAssert2");
	  softAss.assertEquals("Hello","uk");//fail
	  
	  System.out.println("\nAssert3");
	  softAss.assertTrue(10>4);//pass
	  
	  softAss.assertAll(); 
	   
	  Assert.assertTrue("Hello".contentEquals("ll"));
  }
  
  
  
}
