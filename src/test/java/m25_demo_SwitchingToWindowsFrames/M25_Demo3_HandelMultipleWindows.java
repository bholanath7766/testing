package m25_demo_SwitchingToWindowsFrames;
//1.Launch TestMeApp
//2.Verify HomePage Title
//3.Mouse hover About Us-->Our Offices-->Bangalore
//4.Navigate driver control to contact page
//5.Verify Title
import org.testng.annotations.Test;

import utilityPackage.BrowserDriverUtility;

import org.testng.annotations.BeforeClass;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class M25_Demo3_HandelMultipleWindows 
{ 
  WebDriver driver;
  @Test
  public void contactUs() 
  {
	driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	Assert.assertEquals(driver.getTitle(),"Home");
	String homeWindowId=driver.getWindowHandle();
	
	WebElement aboutUs=driver.findElement(By.linkText("AboutUs"));
	WebElement ourOffices=driver.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[3]/ul/li/a"));
	WebElement bangalore=driver.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[3]/ul/li/ul/li[2]/a"));
	Actions action=new Actions(driver);
	action.moveToElement(aboutUs)
	      .moveToElement(ourOffices)
	      .moveToElement(bangalore).click()
	      .build().perform();
	
	
   System.out.println("homeWindowId"+homeWindowId);
   Set<String> allWindows=driver.getWindowHandles();
   //iterate each window
	for(String handle: allWindows)
	{
	  System.out.println("Title: "+driver.getTitle()+" Id: "+handle);
      driver.switchTo().window(handle);
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
   System.out.println("Title: "+driver.getTitle());
   Assert.assertEquals(driver.getTitle(), "Contact Us");
   
  }
  @BeforeClass
  public void beforeClass() 
  {
	driver=BrowserDriverUtility.getDriver("Chrome");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass()
  {
	 driver.close();
	 //driver.quit();
  }

}
