package m21_demo_TestNG_Framework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class M21_Demo6_AssertNull_Notnull 
{ //Assert Null
  @Test
  public void test1() 
  {
	  Object obj1=null;
	  Assert.assertNull(obj1, "Err obj1 have value null");//pass
  }
  
  //Assert Not Null
  @Test
  public void test2()
  {
	  String obj2="Happy";
	  Assert.assertNotNull(obj2, "Err obj2 is not null");//pass
  }
  
  @Test
  public void test3()
  {
	  Object obj3=null;
	  Assert.assertNotNull(obj3, "Err obj3 is null");//fail
  }
}
