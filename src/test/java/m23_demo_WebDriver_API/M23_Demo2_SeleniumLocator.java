//TestMeApp on Home
//count no of Links,display href
package m23_demo_WebDriver_API;
import org.testng.annotations.Test;

import utilityPackage.BrowserDriverUtility;

import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class M23_Demo2_SeleniumLocator 
{ 
  WebDriver driver;
  @Test
  public void countLinks() 
  {
	driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	Assert.assertEquals(driver.getTitle(), "Home");
	
	List<WebElement> allLinks= driver.findElements((By.tagName("a")));
	 int countLink= allLinks.size();
	 System.out.println("Total counts of Anchor Elements: "+countLink);
	 
	 for(int i=0; i<allLinks.size();i++)
	 {
	   String textValue=allLinks.get(i).getText();
	   String hrefValue=allLinks.get(i).getAttribute("href");
	   System.out.println(textValue+"---->"+hrefValue);
	 }
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	driver=BrowserDriverUtility.getDriver("Chrome");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod()
  {
	driver.close();
  }

}
