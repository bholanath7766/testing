package m23_demo_WebDriver_API;
//1.Launch TestMeApp
//2.Display page title and url
//3.navigate to login page
//4.Display page title and url
//5.back to homePage
//6.Refresh and close
import org.testng.annotations.Test;

import utilityPackage.BrowserDriverUtility;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class M23_Demo4_WebDriverCommands 
{ 
  WebDriver driver;
  @Test
  public void launchTestMeApp() 
  {
	driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
    String homeTitle=driver.getTitle();
    String homeUrl=driver.getCurrentUrl();
    System.out.println("HomeTitle: "+homeTitle);
    System.out.println("HomeUrl: "+homeUrl);
    driver.navigate().to("https://lkmdemoaut.accenture.com/TestMeApp/login.htm");
    
    String loginTitle=driver.getTitle();
    String loginUrl=driver.getCurrentUrl();
    System.out.println("LoginTitle: "+loginTitle);
    System.out.println("LoginUrl: "+loginUrl);
    driver.navigate().back();
    
    driver.navigate().refresh();
	  
  }
  @BeforeClass
  public void beforeClass() 
  {
	driver=BrowserDriverUtility.getDriver("chrome");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() 
  {
	driver.close();
  }

}
