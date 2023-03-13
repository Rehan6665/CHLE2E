package chl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginPage {
	
	String alertId = null;
	public static WebDriver driver=null;
	
	@BeforeSuite(description = "Login into CHL")
	public void driverInitiation(){
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	
	}
	
	@Test
	public void login(){
		
		driver.get("https://chl.alpha-app.tls.global/Account/Login");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("Email")).sendKeys("mainsubowner@test.com");
		driver.findElement(By.id("Password")).sendKeys("Test@123");
		
		
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/div[3]/div/input")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	@AfterSuite(enabled = false)
	public void closeBrowser()
	{
		
		driver.close();

		
	}
	

}
