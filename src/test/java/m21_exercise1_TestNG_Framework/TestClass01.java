package m21_exercise1_TestNG_Framework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestClass01 
{
  @Test(priority=1)
  public void tMethod1() 
  {
	  System.out.println("Testclass01: tMethod1");
  }
  
  @Test(priority=0)
  public void tMethod2()
  {
	  System.out.println("Testclass01: tMethod2"); 
  }
  
  @Test(priority=2)
  public void tMethod5()
  {
	  System.out.println("Testclass01: testMethod5");
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("Testclass01: beforeMethod");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("Testclass01: afterMethod");
  }

  @BeforeClass
  public void beforeClass() 
  {
	  System.out.println("Testclass01: beforeClass");
  }

  @AfterClass
  public void afterClass() 
  {
	  System.out.println("Testclass01: afterClass");
  }

}
