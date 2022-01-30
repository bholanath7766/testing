package m24_demo_EmulatingUserGesturesByActions;
//1.Launch TestMeApp
//2.implicity wait
//3. Auto Suggesstion Functionality: Search Bag -->Select Hand bag
//4. Validate product display
//5.close
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

public class M24_Demo3_AutomateKeyboardEvents 
{ 
  WebDriver driver;
  @Test
  public void autoSuggession() 
  {
    driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    
    WebElement searchProduct=driver.findElement(By.id("myInput"));
    
    Actions action=new Actions(driver);
    action.sendKeys(searchProduct, "Bag").pause(2000)
          .sendKeys(" ")
          .sendKeys(Keys.BACK_SPACE)
          .sendKeys(Keys.DOWN)
          .sendKeys(Keys.DOWN)
          .sendKeys(Keys.ENTER).build().perform();
   String productName=driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]"
   		+ "/div/div/div[1]/center[1]/h4")).getText();
   //System.out.println(productName);
   Assert.assertEquals(productName, "Hand bag");
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
