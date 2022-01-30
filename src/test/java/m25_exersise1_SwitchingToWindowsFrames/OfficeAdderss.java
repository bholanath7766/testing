package m25_exersise1_SwitchingToWindowsFrames;
//1.Launch TestMeApp
//2.Mouse hover About Us-->Our Offices-->Bangalore
//3.Navigate driver control to contact page
//4.Navigate driver inside frame of contact info
//5.Display and verify contact info
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

public class OfficeAdderss {
  WebDriver driver;
  @Test
  public void contactInfo() 
  {
	driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
	WebElement aboutUs=driver.findElement(By.linkText("AboutUs"));
	WebElement ourOffices=driver.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[3]/ul/li/a"));
	WebElement bangalore=driver.findElement(By.cssSelector("a[href='contact.htm?id=bgl'][target='_blank']"));

	 Actions action=new Actions(driver);
	    action.moveToElement(aboutUs)
	          .moveToElement(ourOffices)
	          .moveToElement(bangalore)
	          .click()
	          .build().perform();
   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
   
   Set<String> windowIds=driver.getWindowHandles();
   System.out.println("HomeID: "+windowIds.toArray()[0].toString());
   System.out.println("ContactUsID: "+windowIds.toArray()[1].toString());
   
   driver.switchTo().window(windowIds.toArray()[1].toString());
   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   Assert.assertEquals(driver.getTitle(), "Contact Us");
   
   driver.switchTo().frame("main_page");
   String address=driver.findElement(By.id("demo3")).getText();
   System.out.println(address);
   
   Assert.assertTrue(address.contains("Bangalore"));
   driver.switchTo().defaultContent();
	
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
  }

}
