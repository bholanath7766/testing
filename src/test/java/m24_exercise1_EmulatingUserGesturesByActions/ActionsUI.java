package m24_exercise1_EmulatingUserGesturesByActions;
//1.Launch TestMeApp
//2.search wear--> Auto Suggession--> Select Summer Wear
//3.Find product details
//4.verify product display
import org.testng.annotations.Test;

import utilityPackage.BrowserDriverUtility;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ActionsUI 
{ 
  WebDriver driver;
  @Test
  public void productVerify() 
  {
	driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	
	WebElement searchProduct=driver.findElement(By.id("myInput"));
	
	Actions action= new Actions(driver);
	action.sendKeys(searchProduct, "wear").pause(2000)
	      .sendKeys(" ").sendKeys(Keys.BACK_SPACE)
	      .sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER)
	      .build().perform();
	//not able to select or control on Auto Succession element as they are hidden type
	//<div>Summer wear<input type="hidden" value="Summer wear"></div>
	
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	String productName=driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[3]"
			+ "/div/div/div[1]/center[1]/h4")).getText();
	Assert.assertEquals(productName, "Summer wear");
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

//JavascriptExecutor j = (JavascriptExecutor) driver;
//j.executeScript ("document.getElementByxpath(//input[@type='hidden' and @value='Summer wear']).click();");