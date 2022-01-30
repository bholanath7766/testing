package m25_demo_SwitchingToWindowsFrames;
//1.Launch TestMeApp
//2.Verify title of home page
//3.Open SingnUp page to new browser window navigate driver control to that page
//4.Verify title of SignUp page
import org.testng.annotations.Test;

import utilityPackage.BrowserDriverUtility;

import org.testng.annotations.BeforeClass;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class M25_Demo2_HandelMultipleWindows 	
{
  WebDriver driver;
  @Test
  public void switchToWindow() 
  {
	driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	String homeTitle=driver.getTitle();
	String homeWindowCurrent=driver.getWindowHandle();
    Assert.assertEquals(homeTitle, "Home");
    System.out.println("homeTitle: "+homeTitle);
    String signUpElement="Sign"+"Up";
    WebElement signUp=driver.findElement(By.linkText(signUpElement));
    //WebElement signUp=driver.findElement(By.linkText("SignUp"));
    Actions action=new Actions(driver);
    /*action.keyDown(Keys.CONTROL).click(signUp).keyUp(Keys.CONTROL)
          .build().perform();*/
    action.keyDown(Keys.SHIFT).click(signUp).keyUp(Keys.SHIFT)
         .build().perform();
    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    
    Set<String> allWindows=driver.getWindowHandles();
    String homeWindow=allWindows.toArray()[0].toString();
    String signUpWindow=allWindows.toArray()[1].toString();
    
    driver.switchTo().window(signUpWindow);
    
    String signUpTitle=driver.getTitle();
    Assert.assertTrue(signUpTitle.contentEquals("Sign Up"));
    System.out.println("signUpTitle: "+signUpTitle);
    
    System.out.println("homeWindow: "+homeWindow);
    System.out.println("homeWindowCurrent: "+homeWindowCurrent);
    System.out.println("signUpWindow: "+signUpWindow);
    
    driver.switchTo().window(homeWindowCurrent);
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
