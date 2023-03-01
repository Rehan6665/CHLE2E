package chl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

		try {



			SoftAssert softAssert = new SoftAssert();

			driver.findElement(By.xpath("//*[@id=\"logoutForm\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"main-body\"]/p/a")).click();
			driver.findElement(By.xpath("//*[@id=\"ParentSubscriptionID_chosen\"]/a/span")).click();


			if(Subsription == null) {
			driver.findElement(By.xpath("//*[@id=\"ParentSubscriptionID_chosen\"]/div/div/input")).sendKeys("");
			}else {driver.findElement(By.xpath("//*[@id=\"ParentSubscriptionID_chosen\"]/div/div/input")).sendKeys(Subsription);}

			driver.findElement(By.xpath("//*[@id=\"ParentSubscriptionID_chosen\"]/div/div/input")).sendKeys(Keys.ENTER,Keys.TAB);
			
			if(firstname ==null) {
				driver.findElement(By.id("FirstName")).sendKeys("");
			}else {driver.findElement(By.id("FirstName")).sendKeys(firstname);}
			
			if(lastname==null) {
				driver.findElement(By.id("LastName")).sendKeys("");
			}else {driver.findElement(By.id("LastName")).sendKeys(lastname);}
			
			
			if(email == null) {
				driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("");
			}else {driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(email);}
			
			
			
			driver.findElement(By.xpath("//*[@id=\"ConfirmEmail\"]")).sendKeys(email);
			
			if(password ==null) {
				driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("");
			}else {driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(password);}
			
			driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys(password);
			
			if(contactNumber ==null) {
				driver.findElement(By.xpath("//*[@id=\"PhoneNumber\"]")).sendKeys("");
				
			}else {driver.findElement(By.xpath("//*[@id=\"PhoneNumber\"]")).sendKeys(contactNumber);}
			
			if(dob ==null) {
				driver.findElement(By.xpath("//*[@id=\"DateOfBirth\"]")).sendKeys("");
				
			}else {driver.findElement(By.xpath("//*[@id=\"DateOfBirth\"]")).sendKeys(dob);}
			
			
			

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



			softAssert.assertNotEquals( driver.findElement(By.xpath("//*[@id=\"main-body\"]/form/div/fieldset[1]/div[1]/div/span")).getText(),"The Agency Subscription field is required.");
			softAssert.assertNotEquals(driver.findElement(By.xpath("//*[@id=\"main-body\"]/form/div/fieldset[1]/div[5]/div/span")).getText(),"The Confirmed Email Address field is required.");
			softAssert.assertNotEquals(driver.findElement(By.xpath("//*[@id=\"ConfirmPasswordDiv\"]/div/span")).getText(),"The Confirmed Password field is required.");
			softAssert.assertNotEquals(driver.findElement(By.xpath("//*[@id=\"main-body\"]/form/div/fieldset[1]/div[8]/div/span")).getText(),"The Primary Phone Number field is required.");
			softAssert.assertNotEquals(driver.findElement(By.xpath("//*[@id=\"main-body\"]/form/div/div[1]/ul/li")).getText(),"Email ID already exist.","Same email id");

			softAssert.assertAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			System.out.println("Excel Cells are not filled properly");
		}

	}

	@AfterSuite(description = "Closing the browser")
	public void closeBrowser()
	{

		driver.close();
		Reporter.log("Browser closed successfully");

	}

}
