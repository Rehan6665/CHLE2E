package chl;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import utils.InitiateDriver;

public class AcceptAlerts extends InitiateDriver{
	
	static String firstname;

	public static void firstName(String firstname) {

		AcceptAlerts.firstname = firstname;
	}


	@Test(priority = 14)
	public void acceptAlerts() throws InterruptedException {

	//	String firstName =firstname;
		//String firstName = "Kufra";
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
		Date date = new Date();
		String time =formatter.format(date);
		

		driver.get("https://chl.alpha-app.tls.global/Account/Login");
		driver.manage().window().maximize();

		driver.findElement(By.id("Email")).sendKeys("mainsubowner@test.com");
		driver.findElement(By.id("Password")).sendKeys("Test@123");
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/div[3]/div/input")).click();
		
		Thread.sleep(40000);
		
		
		for(int i=1;i<=4;i++) {
		
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement acceptAlert;
		WebElement TextArea;
		WebElement resolved;
		acceptAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[4]/div[2]/div[1]/div[5]/div")));
		acceptAlert.click();
		TextArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[4]/div[2]/div[1]/div[2]/div[1]/textarea")));
		TextArea.click();
		TextArea.sendKeys("Resolved Alert on: "+time);
		resolved = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[4]/div[2]/div[1]/div[2]/div[3]/div")));
		resolved.click();
		//driver.navigate().refresh();
		}
	}

}
