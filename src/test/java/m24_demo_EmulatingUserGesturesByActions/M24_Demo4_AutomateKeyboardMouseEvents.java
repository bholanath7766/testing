package m24_demo_EmulatingUserGesturesByActions;

import org.testng.annotations.Test;

import utilityPackage.BrowserDriverUtility;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class M24_Demo4_AutomateKeyboardMouseEvents {
  WebDriver driver;
  @Test
  public void signIn()
  {
	driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	WebElement signIn=driver.findElement(By.linkText("SignIn"));
	
	Actions action=new Actions(driver);
	action.keyDown(Keys.SHIFT)
	      .click(signIn)
	      .keyUp(Keys.SHIFT)
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
    driver.close();//not Working
    driver.quit();
    
  }
}
