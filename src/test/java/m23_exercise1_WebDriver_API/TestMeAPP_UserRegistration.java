package m23_exercise1_WebDriver_API;
//1.Launch TestMeApp SingnUp
//2.Register with all details
//3. Wait check username is Available
//4.vefify success registration
import org.testng.annotations.Test;

import utilityPackage.BrowserDriverUtility;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestMeAPP_UserRegistration 
{ 
  WebDriver driver;
  @Test
  public void registration() 
  {     
	    //Note Change userName
	    driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
		driver.findElement(By.linkText("SignUp")).click();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		driver.findElement(By.id("userName")).sendKeys("Rakesh");
		driver.findElement(By.id("firstName")).sendKeys("Akshay");
		//check userName Available or not
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		WebElement userAvailable= driver.findElement(By.cssSelector("span[id='err'][class='label label-default']"));
		Assert.assertEquals(userAvailable.getText(), "Available");
		driver.findElement(By.id("lastName")).sendKeys("Keskar");
		driver.findElement(By.id("password")).sendKeys("Rahul123");
		driver.findElement(By.cssSelector("input[type='password'][placeholder='Confirm Password']")).sendKeys("Rahul123");
		driver.findElement(By.cssSelector("input[value='Male']")).click();
		driver.findElement(By.id("emailAddress")).sendKeys("ak@gmail.com");
		driver.findElement(By.id("mobileNumber")).sendKeys("9824568735");
		driver.findElement(By.cssSelector("input[name='dob']")).sendKeys("22/09/1996");
		driver.findElement(By.id("address")).sendKeys("State: Maharashtra, A/P Pune");
		Select securityQue= new Select(driver.findElement(By.id("securityQuestion")));
		securityQue.selectByValue("411011");
		driver.findElement(By.id("answer")).sendKeys("Orange");
		driver.findElement(By.cssSelector("input[type='submit'][value='Register']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/main/div/div/div/form/fieldset/div[8]")));
		
	    String text=driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[8]")).getText();
	    Assert.assertEquals(text, "User Registered Succesfully!!! Please login");
	  
  }
  @BeforeClass
  public void beforeClass() 
  {
	driver=BrowserDriverUtility.getDriver("Chrome");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() 
  {
	  driver.close();
  }

}
