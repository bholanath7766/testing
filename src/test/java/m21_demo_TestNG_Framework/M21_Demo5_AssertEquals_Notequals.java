package m21_demo_TestNG_Framework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class M21_Demo5_AssertEquals_Notequals 
{
  //Assert Equals : //Assert.assertEquals(actual, expected);
  @Test
  public void test1() 
  {  int actual=10;
     int expected=10;
     Assert.assertEquals(actual, expected, "Err both integers are not same");//pass
  }
  
  //Assert NotEqals
  @Test
  public void test2()
  {
	  String titleActual="Home";//can take it from web page
	  String titleExpected="Home";//declare by QE
	  Assert.assertNotEquals(titleActual, titleExpected, "Err both title is same");//fail
  }
}
