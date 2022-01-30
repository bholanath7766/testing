package m21_exercise1_TestNG_Framework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestClass02 
{
  @Test(priority=0)
  public void tMethod3() 
  {
	  System.out.println("TsetClass02: tMethod3");
  }
  
  @Test(priority=1)
  public void tMethod4() 
  {
	  System.out.println("TsetClass02: tMethod4");
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("TsetClass02: beforeMethod");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("TsetClass02: afterMethod");
  }

  @BeforeClass
  public void beforeClass() 
  {
	  System.out.println("TsetClass02: beforeClass");
  }

  @AfterClass
  public void afterClass() 
  {
	  System.out.println("TsetClass02: afterMethod");
  }

}
