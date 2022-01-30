package m21_Scenario1_TestNG_TestSuite;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestClass01 extends BaseClass
{
  @Test
  public void testMethod1() 
  {
	  //System.out.println("TestClass01: ");
	  System.out.println("TestClass01: testMethod1");
  }
  
  @Test
  public void testMethod2() 
  {
	  System.out.println("TestClass01: testMethod2");
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("TestClass01: beforeMethod");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("TestClass01: afterMethod");
  }

  @BeforeClass
  public void beforeClass() 
  {
	  System.out.println("TestClass01: beforeClass");
  }

  @AfterClass
  public void afterClass() 
  {
	  System.out.println("TestClass01: afterClass");
  }

}
