package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitiateDriver {
	
	String alertId = null;
	public static WebDriver driver=null;
	
	@BeforeSuite(description = "Login into CHL")
	public void driverInitiation(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}
	
	@AfterSuite(description = "Closing the browser")
	public void closeBrowser()
	{

		driver.close();
		Reporter.log("Browser closed successfully");

	}


}
