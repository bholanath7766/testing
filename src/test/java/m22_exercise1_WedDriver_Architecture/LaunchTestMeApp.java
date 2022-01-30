package m22_exercise1_WedDriver_Architecture;

import org.testng.annotations.Test;

import m22_exercise1_WedDriver_Architecture.UtilityClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class LaunchTestMeApp
{ 
  WebDriver driver;
  @Test
  public void launchTestMeApp() throws InterruptedException 
  {
	  driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	  Thread.sleep(5000);
  }
  @BeforeClass
  public void beforeMethod() 
  {
	driver=UtilityClass.getDriver("chrome");
	driver.manage().window().maximize();
  }

  @AfterClass
  public void afterMethod() 
  {
	  driver.close();
  }

}
