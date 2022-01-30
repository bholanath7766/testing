package m25_demo_SwitchingToWindowsFrames;
//1.Launch TestMeApp
//2.Leave Search box empty Click on Find Details
//3.Handel Alert dialog
//4.Verify message on Alert dialog
//5.Navigate to login page
import org.testng.annotations.Test;

import utilityPackage.BrowserDriverUtility;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class M25_Demo1_NavigateDialogs 
{ 
  WebDriver driver;
  @Test
  public void alertDialog() 
  {
	driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	driver.findElement(By.cssSelector("input[type='submit'][value='FIND DETAILS']")).click();
	driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	
	if(ExpectedConditions.alertIsPresent()!=null)
	{
	  Alert alert=driver.switchTo().alert();
	  String alertMessage=alert.getText();
	  System.out.println("Alert Dialog Message: "+alertMessage);
	  Assert.assertTrue(alertMessage.contentEquals("Please enter some product name"));
	  alert.accept();
	}
	
	//driver.navigate().to("https://lkmdemoaut.accenture.com/TestMeApp/login.htm");
	driver.findElement(By.linkText("SignIn")).click();
  }
  @BeforeClass
  public void beforeClass()
  {
	driver=BrowserDriverUtility.getDriver("Chrome");
	driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() 
  {
	driver.close();
  }

}
