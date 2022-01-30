package m21_demo_TestNG_Framework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class M21_Demo1_Annotations {
  @Test
  public void testScript1() 
  {
	  System.out.println("testScript1");
  }
  
  @Test()
  public void testScript2()
  {
	  System.out.println("testScript2");
  }
  
  @Test
  public void testScript3()
  {
	  System.out.println("testScript3");
  }
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("beforeMethod");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("afterMethod");
  }

  @BeforeClass
  public void beforeClass() 
  {
	  System.out.println("beforeClass");
  }

  @AfterClass
  public void afterClass() 
  {
	  System.out.println("afterClass");
  }

}
 /*
beforeClass

beforeMethod
testScript1
afterMethod

beforeMethod
testScript2
afterMethod

beforeMethod
testScript3
afterMethod

afterClass*/
