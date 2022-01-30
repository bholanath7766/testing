package utilityPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserDriverUtility 
{
	public static WebDriver getDriver(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			//Path from system
			// System.setProperty("webdriver.chrome.driver","C:\\Users\\Training1\\eclipse-workspace"
			//	+ "\\SeleniumCaseStudy\\src\\test\\resources\\MyDrivers\\chromedriver_V90\\chromedriver.exe");
			//Path from src resource
			//D:\Eclips Workspace\Selenium_Projects\Selenium_Exercise\src\test\resources\MyDrivers\chromedriver_V89\chromedriver.exe
			 System.setProperty("webdriver.chrome.driver","src/test/resources/MyDrivers/chromedriver_V90/chromedriver.exe");
			 return new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Users\\Training1\\eclipse-workspace\\Selenium"
					+ "\\src\\main\\resources\\MyDrivers\\IEDriverServer_Win32_3.150.1\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		else return null;
	}
}
//C:\Users\Public\MyDrivers\chromedriver_V90\chromedriver.exe
