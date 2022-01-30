package m26_demo_DataDrivenTesting;

import org.testng.annotations.Test;

import utilityPackage.BrowserDriverUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class M26_Demo4_ReadDataDataProvider 
{ 
  WebDriver driver;
  
  @Test(dataProvider = "credentials")
  public void login(String username, String password) 
  {
	  driver.findElement(By.linkText("SignIn")).click();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.findElement(By.name("userName")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.name("Login")).click();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

   @BeforeMethod
   public void beforeMethod()
   {
 	  driver=BrowserDriverUtility.getDriver("Chrome");
 	  driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
 	  //maximize the window
 	  driver.manage().window().maximize();
 	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   }
    
   @AfterMethod()
   public void afterMethod()
   {
 	  driver.close();
   }
   
   @DataProvider
   public Object[][] credentials() 
   {
     return new Object[][] 
      {
       new Object[] {"Sam","sam123"},
       new Object[] {"Raj","raj23"},
       new Object[] {"Jay","jay35"},
       new Object[] {"Ram","ram45"}
       
      };
   
  }

}
