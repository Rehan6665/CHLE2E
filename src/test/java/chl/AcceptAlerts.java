package chl;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import utils.InitiateDriver;

public class AcceptAlerts extends InitiateDriver{

	@Test
	public void acceptAlerts() throws InterruptedException {

		String firstName = "Zilong";

		driver.get("https://chl.alpha-app.tls.global/Account/Login");
		driver.manage().window().maximize();

		driver.findElement(By.id("Email")).sendKeys("mainsubowner@test.com");
		driver.findElement(By.id("Password")).sendKeys("Test@123");
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/div[3]/div/input")).click();

		Thread.sleep(35000);
		
		driver.findElement(By.xpath("//*[@id=\"SearchString\"]")).sendKeys(firstName);
		driver.findElement(By.xpath("//*[@id=\"main-body\"]/form/div[1]/div[2]/button")).click();
		
		ArrayList<String> newTb = null;
		int i =1;
		do
		{
		WebElement alertElement = driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[2]/div["+i+"]/div[5]"));
		String alertData = alertElement.getAttribute("id");
		String alertId = alertData.replace("accept_alert_", "");
		
		//System.out.println(alertId);
		String alertName = "https://chl.alpha-app.tls.global/Home/AddNotes?AlertID="+alertId+"";

		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get(alertName);
		newTb = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(newTb.get(1));
		//Thread.sleep(2000);
	
		driver.findElement(By.xpath("//*[@id=\"addnotes\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"addnotes\"]")).sendKeys("Resolved alert "+i+" - Testing ");
		
		driver.findElement(By.xpath("//*[@id=\"clr_alert\"]/span")).click();
		Thread.sleep(2000);
		driver.close();
		i++;
		driver.switchTo().window(newTb.get(0));
		
		
		}while(i<4);
		
		
	}

}
