package chl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.ExcelDataProvider;
import utils.InitiateDriver;

public class CreateOwner extends InitiateDriver{


	String subscription;
	String email;
	String firstname;
	String lastname;
	String contactNumber;
	String fullname;
	String subscriptionName;
	String description;
	String parentSubscription;

	@Test(priority = 1,dataProvider = "Owner Data",dataProviderClass = ExcelDataProvider.class)
	public void createOwner(String firstname, String lastname, String email
			, String password, String contactNumber, String dob, String gender, String timeZone) {


		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.contactNumber = contactNumber;
		this.fullname = firstname +" "+lastname;

		try {

			driver.get("https://tranquility-management.azurewebsites.net/Account/Login");
			driver.manage().window().maximize();

			driver.findElement(By.id("Email")).sendKeys("Admin@gmail.com");
			driver.findElement(By.id("Password")).sendKeys("Admin@123");


			driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/div[3]/div/input")).click();

			driver.findElement(By.xpath("//*[@id=\"logoutForm\"]/ul[1]/li[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"logoutForm\"]/ul[1]/li[1]/ul/li[1]/a")).click();

			driver.findElement(By.xpath("//*[@id=\"main-body\"]/p/a")).click();



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


			WebElement userType_dropDown =  driver.findElement(By.id("AdminUserType"));
			Select uselect_gdropDown = new Select(userType_dropDown);
			uselect_gdropDown.selectByValue("4");

			
			driver.findElement(By.xpath("//*[@id=\"timeZone_chosen\"]/a/span")).click();
			driver.findElement(By.xpath("//*[@id=\"timeZone_chosen\"]/div/div/input")).sendKeys(timeZone);
			driver.findElement(By.xpath("//*[@id=\"timeZone_chosen\"]/div/div/input")).sendKeys(Keys.ENTER,Keys.TAB);

			driver.findElement(By.xpath("//*[@id=\"main-body\"]/form/div/div[26]/div/input")).click();

			SoftAssert softAssert = new SoftAssert();

			softAssert.assertNotEquals( driver.findElement(By.xpath("//*[@id=\"main-body\"]/form/div/fieldset[1]/div[1]/div/span")).getText(),"The Agency Subscription field is required.");
			softAssert.assertNotEquals(driver.findElement(By.xpath("//*[@id=\"main-body\"]/form/div/fieldset[1]/div[5]/div/span")).getText(),"The Confirmed Email Address field is required.");
			softAssert.assertNotEquals(driver.findElement(By.xpath("//*[@id=\"ConfirmPasswordDiv\"]/div/span")).getText(),"The Confirmed Password field is required.");
			softAssert.assertNotEquals(driver.findElement(By.xpath("//*[@id=\"main-body\"]/form/div/fieldset[1]/div[8]/div/span")).getText(),"The Primary Phone Number field is required.");
			softAssert.assertNotEquals(driver.findElement(By.xpath("//*[@id=\"main-body\"]/form/div/div[1]/ul/li")).getText(),"Email ID already exist.","Same email id");

			softAssert.assertAll();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Test(priority = 2,dataProvider = "Child Subscrption Details",dataProviderClass = ExcelDataProvider.class)
	public void createSubscripion(String SubscriptionName, String description , String parentSubscription) {
		
		

		driver.findElement(By.xpath("//*[@id=\"logoutForm\"]/ul[1]/li[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"logoutForm\"]/ul[1]/li[1]/ul/li[2]/a")).click();

		driver.findElement(By.xpath("//*[@id=\"main-body\"]/a")).click();


		if( SubscriptionName==null) {
			driver.findElement(By.id("SubscriptionName")).sendKeys("");
		}else {driver.findElement(By.id("SubscriptionName")).sendKeys(SubscriptionName);}


		if(description ==null) {
			driver.findElement(By.xpath("//*[@id=\"Desc\"]")).sendKeys("");
		}else {driver.findElement(By.xpath("//*[@id=\"Desc\"]")).sendKeys(description);}


		driver.findElement(By.xpath("//*[@id=\"Status\"]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/form/div/div[4]/div/div/a/span")).click();

		if(fullname == null) {
			driver.findElement(By.xpath("//*[@id=\"OwnerID_chosen\"]/div/div/input")).sendKeys("");
		}else {driver.findElement(By.xpath("//*[@id=\"OwnerID_chosen\"]/div/div/input")).sendKeys(fullname);}

		driver.findElement(By.xpath("/html/body/div[2]/form/div/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER,Keys.TAB);

		
		driver.findElement(By.xpath("//*[@id=\"IsAgency\"]")).click();
				
		driver.findElement(By.xpath("//*[@id=\"ParentSubscriptionID_chosen\"]/a/span")).click();

		if(parentSubscription == null) {
			driver.findElement(By.xpath("//*[@id=\"ParentSubscriptionID_chosen\"]/div/div/input")).sendKeys("");
		}else {driver.findElement(By.xpath("//*[@id=\"ParentSubscriptionID_chosen\"]/div/div/input")).sendKeys(parentSubscription);}

		driver.findElement(By.xpath("//*[@id=\"ParentSubscriptionID_chosen\"]/div/div/input")).sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//*[@id=\"main-body\"]/form/div/div[23]/div/input")).click();
		System.out.println("Subscription created successfully");
		
		subscriptionName = SubscriptionName;
		
	}
	
	@Test(priority = 3)
	public void assignSubscriptionToOwner() {
		
		
		driver.findElement(By.xpath("//*[@id=\"logoutForm\"]/ul[1]/li[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"logoutForm\"]/ul[1]/li[1]/ul/li[1]/a")).click();

		driver.findElement(By.xpath("//*[@id=\"SearchString\"]")).sendKeys(firstname);
		driver.findElement(By.xpath("//*[@id=\"main-body\"]/form/div[1]/div[1]/button")).click();

		driver.findElement(By.xpath("//*[@id=\"UserGrid\"]/tbody/tr/td[7]/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"SubscriptionID_chosen\"]/a/span")).click();
		
		driver.findElement(By.xpath("//*[@id=\"SubscriptionID_chosen\"]/div/div/input")).sendKeys(subscriptionName);
		driver.findElement(By.xpath("//*[@id=\"SubscriptionID_chosen\"]/div/div/input")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//*[@id=\"main-body\"]/form/div/div[22]/div/input")).click();
	}
	
	
}
