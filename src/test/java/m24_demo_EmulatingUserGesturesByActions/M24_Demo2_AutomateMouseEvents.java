package m24_demo_EmulatingUserGesturesByActions;
//1.launch https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx
//2.Drag 2 week package to price checker area and check price
//3.Very for price display
import org.testng.annotations.Test;

import utilityPackage.BrowserDriverUtility;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class M24_Demo2_AutomateMouseEvents 
{ 
  WebDriver driver;
  @Test
  public void priceChecker()
  {
	  //Not working check later
	driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 WebElement week1pack=driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceholder1_RadTreeView1']/ul/li/ul/li[3]/ul/li[2]/div/div/span"));
	 WebElement pricechecker=driver.findElement(By.id("ctl00_ContentPlaceholder1_priceChecker"));
	  
	  //Implement actions to drag week1pack to drop on pricechecker
	  Actions act=new Actions(driver);
	 act.dragAndDrop(week1pack, pricechecker).perform();
	  /*act.clickAndHold(week1pack)
	     .pause(3000)
	     .release(pricechecker);*/
	  
	        
	  
	
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
  { System.out.println("@AfterClass");
	// driver.close();
  }

}
