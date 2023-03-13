package chl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.ApiClass;
import utils.ExcelDataProvider;
import utils.InitiateDriver;

public class CreateSensor extends InitiateDriver{

	
	
	
	
	String firstname;
	String fullname;
	
	
	
	
	
	
	@Test(priority = 4)
	public void openTLSAdmin() {
		
		
		driver.get("https://tranquility-management.azurewebsites.net/Account/Login");
		driver.findElement(By.id("Email")).sendKeys("Admin@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/div[3]/div/input")).click();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"logoutForm\"]/ul[1]/li[2]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/ul[1]/li[2]/ul/li[3]/a")).click();
		
	
		

	}	
	
	@Test(priority = 5,dataProvider = "Patient Data",dataProviderClass = ExcelDataProvider.class)
	public void createNeedHelpSensor(String subsription, String firstname, String lastname, String email
			, String password, String contactNumber, String dob, String gender, String timeZone) throws InterruptedException{
		
		this.firstname = firstname;
		this.fullname = firstname +" "+lastname;
		
		SimpleDateFormat formatter = new SimpleDateFormat("ddmmHHmmss");
		Date date = new Date();
		String deviceid ="ND_"+formatter.format(date);
		
		driver.findElement(By.xpath("/html/body/div[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"SensorTypeId_chosen\"]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"SensorTypeId_chosen\"]/div/div/input")).sendKeys("NEED HELP");
		driver.findElement(By.xpath("//*[@id=\"SensorTypeId_chosen\"]/div/div/input")).sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.xpath("//*[@id=\"model_DeviceId\"]")).sendKeys(deviceid);
		driver.findElement(By.xpath("//*[@id=\"model_Name\"]")).sendKeys("Need Help");
		driver.findElement(By.xpath("//*[@id=\"model_UserId_chosen\"]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"model_UserId_chosen\"]/div/div/input")).sendKeys(fullname);
		driver.findElement(By.xpath("//*[@id=\"model_UserId_chosen\"]/div/div/input")).sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.xpath("//*[@id=\"model_SensorLocation_chosen\"]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"model_SensorLocation_chosen\"]/div/div/input")).sendKeys("Bathroom");
		driver.findElement(By.xpath("//*[@id=\"model_SensorLocation_chosen\"]/div/div/input")).sendKeys(Keys.ENTER);
		
		
		
        
		driver.findElement(By.xpath("/html/body/div[2]/form[2]/div/div[10]/div/input")).click();
		
		ApiClass.pdevice(deviceid);
		
		
	}
	
	@Test(priority = 6)
	public void createDoorWindowSensor() {
		SimpleDateFormat formatter = new SimpleDateFormat("ddmmHHmmss");
		Date date = new Date();
		String deviceid = "D_" + formatter.format(date);
		
		driver.findElement(By.xpath("/html/body/div[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"SensorTypeId_chosen\"]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"SensorTypeId_chosen\"]/div/div/input")).sendKeys("DOORS AND WINDOWS");
		driver.findElement(By.xpath("//*[@id=\"SensorTypeId_chosen\"]/div/div/input")).sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.xpath("//*[@id=\"model_DeviceId\"]")).sendKeys(deviceid);
		driver.findElement(By.xpath("//*[@id=\"model_Name\"]")).sendKeys("DOORS AND WINDOWS");
		driver.findElement(By.xpath("//*[@id=\"model_UserId_chosen\"]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"model_UserId_chosen\"]/div/div/input")).sendKeys(fullname);
		driver.findElement(By.xpath("//*[@id=\"model_UserId_chosen\"]/div/div/input")).sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.xpath("//*[@id=\"model_SensorLocation_chosen\"]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"model_SensorLocation_chosen\"]/div/div/input")).sendKeys("Bathroom");
		driver.findElement(By.xpath("//*[@id=\"model_SensorLocation_chosen\"]/div/div/input")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//*[@id=\"main-body\"]/form[2]/div/div[9]/div/div[10]/input[1]")).clear();
		driver.findElement(By.xpath("//*[@id=\"main-body\"]/form[2]/div/div[9]/div/div[10]/input[1]")).sendKeys("0.5");
		driver.findElement(By.xpath("//*[@id=\"main-body\"]/form[2]/div/div[9]/div/div[13]/input[1]")).clear();
		driver.findElement(By.xpath("//*[@id=\"main-body\"]/form[2]/div/div[9]/div/div[13]/input[1]")).sendKeys("0.5");
		

		
		
		driver.findElement(By.xpath("/html/body/div[2]/form[2]/div/div[10]/div/input")).click();
		ApiClass.ddevice(deviceid);
		
	}
	
	@Test(priority = 7)
	public void createMotionSensor() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("ddmmHHmmss");
		Date date = new Date();
		String deviceid = "M_"+formatter.format(date);
		driver.findElement(By.xpath("/html/body/div[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"SensorTypeId_chosen\"]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"SensorTypeId_chosen\"]/div/div/input")).sendKeys("Monitoring");
		driver.findElement(By.xpath("//*[@id=\"SensorTypeId_chosen\"]/div/div/input")).sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.xpath("//*[@id=\"model_DeviceId\"]")).sendKeys(deviceid);
		driver.findElement(By.xpath("//*[@id=\"model_Name\"]")).sendKeys("Monitoring");
		driver.findElement(By.xpath("//*[@id=\"model_UserId_chosen\"]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"model_UserId_chosen\"]/div/div/input")).sendKeys(fullname);
		driver.findElement(By.xpath("//*[@id=\"model_UserId_chosen\"]/div/div/input")).sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.xpath("//*[@id=\"model_SensorLocation_chosen\"]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"model_SensorLocation_chosen\"]/div/div/input")).sendKeys("Bathroom");
		driver.findElement(By.xpath("//*[@id=\"model_SensorLocation_chosen\"]/div/div/input")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//*[@id=\"main-body\"]/form[2]/div/div[9]/div/div[10]/input[1]")).clear();
		driver.findElement(By.xpath("//*[@id=\"main-body\"]/form[2]/div/div[9]/div/div[10]/input[1]")).sendKeys("0");
		driver.findElement(By.xpath("//*[@id=\"main-body\"]/form[2]/div/div[9]/div/div[13]/input[1]")).clear();
		driver.findElement(By.xpath("//*[@id=\"main-body\"]/form[2]/div/div[9]/div/div[13]/input[1]")).sendKeys("0");
		
		driver.findElement(By.xpath("/html/body/div[2]/form[2]/div/div[10]/div/input")).click();
		ApiClass.mdevice(deviceid);
		
	}



}
