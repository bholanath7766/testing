package m23_exercise2_WebDriver_API;
//login TestMeApp
//Navigate to Order Details
//Display no of rows
//Display order details
//if no any order err
import org.testng.annotations.Test;

import utilityPackage.BrowserDriverUtility;
import utilityPackage.UserRegistration_TestMeApp;

import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class Check_OrderDetals 
{ 
  WebDriver driver;
  @Test
  public void loginTestMeApp() 
  { 
	//if user is not register in TestMeApp 
	//Uncomment following two lines and Register by giving userName and password
		  
    UserRegistration_TestMeApp registration= new UserRegistration_TestMeApp();
	registration.userRegistrationTestMeApp("AkshayKeskar", "akshay321");
	  
    driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
    driver.findElement(By.linkText("SignIn")).click();
    driver.findElement(By.id("userName")).sendKeys("AkshayKeskar");
    driver.findElement(By.id("password")).sendKeys("akshay321");
    driver.findElement(By.cssSelector("input[type='submit'][value='Login']")).click();
    driver.findElement(By.linkText("OrderDetails")).click();
    
    List<WebElement> tableRows= driver.findElements(By.tagName("tr"));
    int countTableRows=tableRows.size();
    System.out.println("No of Rows: "+countTableRows);
    for(int i=0;i<countTableRows;i++)
    {
      System.out.println(tableRows.get(i).getText());
    }
    
    if(countTableRows<=1)
    {
      System.out.println("Order table empty");
    }
    
    driver.findElement(By.linkText("SignOut")).click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }
  @BeforeClass
  public void beforeClass() 
  {
	driver=BrowserDriverUtility.getDriver("chrome");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() 
  {
	driver.close();
  }

}
