package m24_demo_EmulatingUserGesturesByActions;
//1.Launch TestMeApp
//2.On home Mouse hover About Us-->Our Office-->Bangalore
//3.close
import org.testng.annotations.Test;

import utilityPackage.BrowserDriverUtility;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class M24_Demo1_AumateMouseEvents 
{
	WebDriver driver;
  @Test
  public void checkOurOffice() 
  {
    driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
    WebElement aboutUs=driver.findElement(By.linkText("AboutUs"));
    WebElement ourOffices=driver.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[3]/ul/li/a"));
    WebElement bangalore=driver.findElement(By.cssSelector("a[href='contact.htm?id=bgl'][target='_blank']"));
    
    Actions action=new Actions(driver);
    action.moveToElement(aboutUs)
          .moveToElement(ourOffices)
          .moveToElement(bangalore)
          .click()
          .build().perform();
   
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
	  driver.quit();
  }

}
