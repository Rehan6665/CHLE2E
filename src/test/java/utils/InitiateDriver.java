package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitiateDriver {
	
	String alertId = null;
	public static WebDriver driver=null;
	
	@BeforeSuite(description = "Login into CHL")
	public void driverInitiation(){
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

	}
	
	@AfterSuite(description = "Closing the browser")
	public void closeBrowser()
	{

		driver.close();
		Reporter.log("Browser closed successfully");

	}


}
