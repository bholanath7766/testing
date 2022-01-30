package m22_demo_WebDriver_Architeture;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class M22_Demo1_LaunchBrowserTest 
{
  WebDriver driver;
  @Test
  public void launchTestMEApp() 
  {
	  driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	  String title=driver.getTitle();
	  Assert.assertEquals(title, "Home");
  }
  
  @BeforeClass
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver","src/test/resources/MyDrivers/chromedriver_V90/chromedriver.exe");
	  //C:\Users\Public\MyDrivers\chromedriver_V90\chromedriver.exe
	  //C:\Users\Training1\eclipse-workspace\Selenium\src\main\resources\MyDrivers\chromedriver_V90\chromedriver.exe

	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void afterMethod()
  {
	  driver.close();
  }

}
