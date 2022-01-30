package m26_exercise1_DataDrivenTesting;
//1.Login in TestMeApp-->Search Product-->Add to Cart-->Checkuot-->Payment gateway-->Successful Transaction
//2.Read read input from Excel file
//3. Design ExcelUtility
//4.Data Provider

import org.testng.annotations.Test;

import utilityPackage.BrowserDriverUtility;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class OrderProduct 
{
  WebDriver driver;
 
  @Test(priority = 0,enabled = false)
  public void signUp()
  {
	//if user is not register in TestMeApp 
	//Enable this method with proirity 0 and Register by giving userName and password
			  
	//UserRegistration_TestMeApp registration= new UserRegistration_TestMeApp();
	//registration.userRegistrationTestMeApp("Lalitha", "Password123");
  }
  
  @Test(priority = 1,enabled = true)
  public void launchTestMeApp()
  {
	driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
  }
  @Test(priority =2,enabled = true,dataProvider="loginCredentials")
  public void placeOrder(String username, String password, String bankname,
		  String bankusername, String bankpassword, String transactionpw)
  {
	//System.out.println(username+"---"+password+"---"+bankname+"---"+bankusername+"---"
	//  +bankpassword+"---"+transactionpw);
	 
	//SignIn TestMeApp
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.findElement(By.linkText("SignIn")).click();
		
	driver.findElement(By.id("userName")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
	  
	//Find Product
	driver.findElement(By.id("myInput")).sendKeys("Gift set");
	driver.findElement(By.xpath("//input[@type='submit' and @value='FIND DETAILS']")).click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
	//Add to cart
	driver.findElement(By.linkText("Add to cart")).click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.findElement(By.partialLinkText("Cart")).click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
	//checkout product
	driver.findElement(By.xpath("//a[@href='checkout.htm' and @class='btn btn-success btn-block']")).click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
	//Review and Payment
	driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
	WebDriverWait delay=new WebDriverWait(driver, 20);
	delay.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/div/div[1]/h2")));
	
	String column="1";
	String row="1";
	if(bankname.contentEquals("Andhra Bank"))
	{
	  column="1"; row="1";
	}
	else if(bankname.contentEquals("HDFC Bank"))
	{
	  column="2"; row="2";
	}
	else if(bankname.contentEquals("IDBI Bank"))
	{
	  column="1"; row="5";
	}
	else if(bankname.contentEquals("UCO Bank"))
	{
	  column="2"; row="7";
	}
	//Payment Gateway
	driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div/div["+column+"]/div["+row+"]/div/label/i")).click();
	driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/a")).click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
	//Payment Login
	driver.findElement(By.name("username")).sendKeys(bankusername);
	driver.findElement(By.name("password")).sendKeys(bankpassword);
	driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
	//Transaction Summary
	driver.findElement(By.name("transpwd")).sendKeys(transactionpw);
	driver.findElement(By.xpath("//input[@value='PayNow']")).click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
	//Order Details
	driver.findElement(By.linkText("SignOut")).click();//Back to home Page
	//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	WebDriverWait wait=new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SignIn")));
  }

  @DataProvider 
  public Object[][] loginCredentials() throws IOException 
  {
    return M26_ExcelReadUtility.readData("C:\\Users\\Training1.WIN-NFDCINOH1RK\\Documents"
    		+ "\\DataDrivenTesting\\DDTExercise1.xlsx","credentials");
    //C:\Users\Training1.WIN-NFDCINOH1RK\Documents\DataDrivenTesting\DDTExercise1.xlsx
    //credentials
    		
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
