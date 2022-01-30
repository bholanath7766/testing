package m22_exercise1_WedDriver_Architecture;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class UtilityClass 
{
   public static WebDriver getDriver(String browserName)
   { 
	 if(browserName.equalsIgnoreCase(browserName))
	 {
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\Public\\MyDrivers\\chromedriver_V90\\chromedriver.exe");
	   return new ChromeDriver();
	 }
	 else if(browserName.equalsIgnoreCase("ie"))
	 {
	   System.setProperty("webdriver.ie.drover","C:\\Users\\Public\\MyDrivers"
	   		+ "\\IEDriverServer_Win32_3.150.1\\IEDriverServer.exe");
	   return new InternetExplorerDriver();
	 }
	 else return null;
   }
}
//C:\Users\Public\MyDrivers\chromedriver_V90\chromedriver.exe
//C:\Users\Public\MyDrivers\IEDriverServer_Win32_3.150.1\IEDriverServer.exe
