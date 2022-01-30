package m21_demo_TestNG_Framework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class M21_Demo8_AssertFail 
{
  @Test
  public void test1() 
  {
	  Assert.fail("Intentionally make assert fail");
  }
}
