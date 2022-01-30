package m23_demo_WebDriver_API;
//1.Launch TestMeApp
//2.signin 
//3.signout
//4.wait SignIn appeared in 20se//explicite wait
//5.close
import org.testng.annotations.Test;

import utilityPackage.BrowserDriverUtility;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class M23_Demo5_WaitCommands 
{ 
  WebDriver driver;
  @Test
  public void launchTestMeAPP() 
  { 
	//if user is not register in TestMeApp 
    //Uncomment following two lines and Register by giving userName and password
	  
	//UserRegistration_TestMeApp registration= new UserRegistration_TestMeApp();
	//registration.userRegistrationTestMeApp("AkshayKeskar", "akshay321");
	
	driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	driver.findElement(By.linkText("SignIn")).click();
	
	driver.findElement(By.id("userName")).sendKeys("AkshayKeskar");
	driver.findElement(By.id("password")).sendKeys("akshay321");
	driver.findElement(By.cssSelector("input[name='Login'][value='Login']")).click();
	
	driver.findElement(By.linkText("SignOut")).click();
	
	WebDriverWait delay=new WebDriverWait(driver,20);
	delay.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SignIn")));
	
	WebElement SignIn=driver.findElement(By.linkText("SignIn"));
	Assert.assertEquals(SignIn.getText(), "SignIn");
  }
  @BeforeClass
  public void beforeClass() 
  { 
	driver=BrowserDriverUtility.getDriver("Chrome");
    driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() 
  {
    driver.close();
  }

}
