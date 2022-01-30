package utilityPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TestBrowserDriverUtility 
{
  WebDriver driver;
  @Test
  public void launchTestMeApp() throws InterruptedException 
  {
	  driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	  //driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	  Thread.sleep(5000);
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  driver=BrowserDriverUtility.getDriver("Chrome");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.close();
  }

}
