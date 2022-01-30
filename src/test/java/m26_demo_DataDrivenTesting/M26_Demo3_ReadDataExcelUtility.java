package m26_demo_DataDrivenTesting;
//1.Create Excel file-->2 columns-->UserName, Password
//2.Enter Data--> Add few data for UserName and Password
//3.Design ExcelUtility Class with readData method
//4.Design TestClass for loginTestMeApp
//5.Execute for multiple credentials
import org.testng.annotations.Test;

import utilityPackage.BrowserDriverUtility;
import utilityPackage.ExcelReadUtility;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class M26_Demo3_ReadDataExcelUtility 
{ 
  WebDriver driver;
  
  @Test(dataProvider = "loginCredentials")
  public void floginTestMeApp(String userName, String password)
  {
	driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	driver.findElement(By.linkText("SignIn")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.id("userName")).sendKeys(userName);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
  }
  
  @DataProvider
  public Object[][] loginCredentials() throws IOException 
  {
    return ExcelReadUtility.readData("C:\\Users\\Training1.WIN-NFDCINOH1RK\\Documents"
    		+ "\\DataDrivenTesting\\DDTDemo3.xlsx", "credentials");
    //C:\Users\Training1.WIN-NFDCINOH1RK\Documents\DataDrivenTesting\DDTDemo3.xlsx
    //credentials
  }
  
  @BeforeClass
  public void beforeClass() 
  {
	driver=BrowserDriverUtility.getDriver("Chrome");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() 
  {
	driver.close();
  }
}

