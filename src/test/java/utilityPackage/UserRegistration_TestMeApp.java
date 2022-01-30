package utilityPackage;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UserRegistration_TestMeApp 
{ WebDriver driver;
  @Test
  public void userRegistrationTestMeApp(String userNAme, String password) 
  {     
	    driver=BrowserDriverUtility.getDriver("Chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
		driver.findElement(By.linkText("SignUp")).click();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		driver.findElement(By.id("userName")).sendKeys(userNAme);
		driver.findElement(By.id("firstName")).sendKeys("Akshay");
		//check userName Available or not
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement userAvailable= driver.findElement(By.cssSelector("span[id='err'][class='label label-default']"));
		Assert.assertEquals(userAvailable.getText(), "Available");
		driver.findElement(By.id("lastName")).sendKeys("Keskar");
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[type='password'][placeholder='Confirm Password']")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Male']")).click();
		driver.findElement(By.id("emailAddress")).sendKeys("ak@gmail.com");
		driver.findElement(By.id("mobileNumber")).sendKeys("9824568735");
		driver.findElement(By.cssSelector("input[name='dob']")).sendKeys("22/09/1996");
		driver.findElement(By.id("address")).sendKeys("State: Maharashtra, A/P Pune");
		Select securityQue= new Select(driver.findElement(By.id("securityQuestion")));
		securityQue.selectByValue("411011");
		driver.findElement(By.id("answer")).sendKeys("Orange");
		driver.findElement(By.cssSelector("input[type='submit'][value='Register']")).click();
		driver.close();
  }

}
