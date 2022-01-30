package m21_demo_TestNG_Framework;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class M21_Demo3_Data_Provider 
{
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) 
  {
	  System.out.println(n+"---"+s);
  }

  @DataProvider
  public Object[][] dp() 
  {
    return new Object[][] 
    {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
}
