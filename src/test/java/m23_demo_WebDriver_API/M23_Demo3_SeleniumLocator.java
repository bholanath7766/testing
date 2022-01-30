//Login to TestMeApp
//Search for Gift Set
//add to cart 
//click on cart validate product
//Logout
package m23_demo_WebDriver_API;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilityPackage.BrowserDriverUtility;

public class M23_Demo3_SeleniumLocator 
{
  WebDriver driver;
  @Test(priority=0)
  public void loginTestMeApp() 
  { 
	//if user is not register in TestMeApp 
	//Uncomment following two lines and Register by giving userName and password
		  
    //UserRegistration_TestMeApp registration= new UserRegistration_TestMeApp();
    //registration.userRegistrationTestMeApp("akshay", "akshay321");
	  
    driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
    driver.findElement(By.linkText("SignIn")).click();
    
    driver.findElement(By.id("userName")).sendKeys("Aniket");
    driver.findElement(By.id("password")).sendKeys("Aniket123");
    driver.findElement(By.name("Login")).click();
  }
  
  @Test(priority = 1)
  public void addToCart()
  {
	driver.findElement(By.id("myInput")).sendKeys("Gift Set");
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.findElement(By.cssSelector("input[type='submit'][name='val']")).click();//Find Details
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//a[@href='#' and @class='btn btn-success btn-product']")).click();//Add to cart
	
	WebElement cart=driver.findElement(By.partialLinkText("Cart"));//Cart 1
	cart.click();
	

    String productName=driver.findElement(By.cssSelector("h4[class='nomargin']")).getText();
	Assert.assertEquals(productName, "Gift set");
	driver.findElement(By.linkText("SignOut")).click();//SignOut
	
  }
  @BeforeClass
  public void beforeClass() 
  {
    driver=BrowserDriverUtility.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() 
  {
	driver.close();
  }

}
