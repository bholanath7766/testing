package m21_Scenario1_TestNG_TestSuite;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClass 
{
 
  @BeforeTest
  public void beforeTest() 
  {
	  System.out.println("In beforeTest");
  }

  @AfterTest
  public void afterTest()
  {
	  System.out.println("In afterTest");
  }

  @BeforeSuite
  public void beforeSuite() 
  {
	  System.out.println("In beforeSuite");
  }

  @AfterSuite
  public void afterSuite() 
  {
	  System.out.println("In afterSuite");
  }

}
/* Result of testng_TestNGSuite
   beforeSuite

  beforeTest
    TestClass01: beforeClass
      TestClass01: beforeMethod
         TestClass01: testMethod1
       TestClass01: afterMethod
       TestClass01: beforeMethod
          TestClass01: testMethod2
       TestClass01: afterMethod
     TestClass01: afterClass
  afterTest
  
  beforeTest
    TestClass02: beforeClass
      TestClass02:beforeMethod
        TestClass02:testMethod1
      TestClass02: afterMethod
      TestClass02: beforeMethod
        TestClass02: testMethod2
      TestClass02: afterMethod
    TestClass02: afterClass
  afterTest

afterSuite
 */
