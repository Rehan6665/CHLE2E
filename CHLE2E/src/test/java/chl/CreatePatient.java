package chl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelDataProvider;

public class CreatePatient {
	
	String alertId = null;
	public static WebDriver driver=null;
	
	@BeforeSuite(description = "Login into CHL")
	public void driverInitiation(){
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	
	}
	
	@Test(priority = 1)
	public void login() {
		driver.get("https://chl.alpha-app.tls.global/Account/Login");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("Email")).sendKeys("mainsubowner@test.com");
		driver.findElement(By.id("Password")).sendKeys("Test@123");
		
		
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/div[3]/div/input")).click();
		
		
	}
	
	
	@Test(priority = 2,dataProvider = "Patient Data",dataProviderClass = ExcelDataProvider.class)
	public void createPatient(String Subsription, String firstname, String lastname, String email
			, String password, String contactNumber, String dob, String gender, String timeZone) {
		
		driver.findElement(By.xpath("//*[@id=\"logoutForm\"]/ul[1]/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"main-body\"]/p/a")).click();
		driver.findElement(By.xpath("//*[@id=\"ParentSubscriptionID_chosen\"]/a/span")).click();
	
	
		
		driver.findElement(By.xpath("//*[@id=\"ParentSubscriptionID_chosen\"]/div/div/input")).sendKeys(Subsription);
		driver.findElement(By.xpath("//*[@id=\"ParentSubscriptionID_chosen\"]/div/div/input")).sendKeys(Keys.ENTER,Keys.TAB);
		
	
		driver.findElement(By.id("FirstName")).sendKeys(firstname);
		driver.findElement(By.id("LastName")).sendKeys(lastname);
		driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"ConfirmEmail\"]")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"PhoneNumber\"]")).sendKeys(contactNumber);
		driver.findElement(By.xpath("//*[@id=\"DateOfBirth\"]")).sendKeys(dob);
		
		WebElement gender_dropDown =  driver.findElement(By.id("Gender"));
		Select select_gdropDown = new Select(gender_dropDown);
		if(gender.equals("Male"))
		{
			
			select_gdropDown.selectByValue("1");
		}
		else {select_gdropDown.selectByValue("2");}
		

		//driver.findElement(By.xpath("//*[@id=\"City\"]")).sendKeys(city);
		//driver.findElement(By.xpath("//*[@id=\"State\"]")).sendKeys(state);
		//driver.findElement(By.xpath("//*[@id=\"Zipcode\"]")).sendKeys(zipCode);
		
		
		driver.findElement(By.xpath("//*[@id=\"timeZone_chosen\"]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"timeZone_chosen\"]/div/div/input")).sendKeys(timeZone);
		driver.findElement(By.xpath("//*[@id=\"timeZone_chosen\"]/div/div/input")).sendKeys(Keys.ENTER,Keys.TAB);
		
	
		
	
		
		driver.findElement(By.xpath("//*[@id=\"addRowsSave\"]")).click();
		
		
	}

}
