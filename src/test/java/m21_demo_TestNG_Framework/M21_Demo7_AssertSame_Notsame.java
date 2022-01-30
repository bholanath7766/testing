package m21_demo_TestNG_Framework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class M21_Demo7_AssertSame_Notsame {
  @Test
  public void test1() 
  {
	  Object obj1=new Object();
	  Object obj2=obj1; //Both reference obj1 and obj2 point same address/object
	  Assert.assertSame(obj1, obj2, "Err both object point same address");//pass  
  }
  
  @Test
  public void test2()
  {
	  Object obj3=new Object();
	  Object obj4=new Object();
	  Assert.assertNotSame(obj3, obj4, "Err both object point different address");//pass
	  
  }
}
