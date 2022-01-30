package m21_demo_TestNG_Framework;

import org.testng.annotations.Test;

public class M21_Demo2_Priority_Enable 
{
  @Test(priority = 0,enabled = false)
  public void testScript1() 
  {
	  System.out.println("testScript1");
  }
  @Test(priority = 2)
  public void testScript2()
  {
	  System.out.println("testScript2");
  }
  @Test (priority = 1)
  public void testScript3()
  {
	  System.out.println("testScript3");
  }
  
  
}
