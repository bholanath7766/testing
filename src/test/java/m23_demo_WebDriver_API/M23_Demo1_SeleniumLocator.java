//TestMeApp login 
//signout
package m23_demo_WebDriver_API;
import org.testng.annotations.Test;

import utilityPackage.BrowserDriverUtility;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class M23_Demo1_SeleniumLocator 
{
  WebDriver driver;
  @Test
  public void loginTest() 
  { 
	//if user is not register in TestMeApp 
	//Uncomment following two lines and Register by giving userName and password
		  
	//UserRegistration_TestMeApp registration= new UserRegistration_TestMeApp();
	//registration.userRegistrationTestMeApp("akshay", "akshay321");
	driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	Assert.assertEquals(driver.getTitle(),"Home");
	driver.findElement(By.linkText("SignIn")).click();
    
	driver.findElement(By.id("userName")).sendKeys("Aniket");
	driver.findElement(By.id("password")).sendKeys("Aniket123");
	driver.findElement(By.name("Login")).click();
	
	Assert.assertEquals(driver.getTitle(), "Home");
	driver.findElement(By.linkText("SignOut")).click();
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
//username Aniket
//password Aniket123