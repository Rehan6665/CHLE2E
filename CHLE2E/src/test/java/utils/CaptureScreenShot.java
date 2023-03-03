package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenShot extends InitiateDriver {



	public void getScreenshot() throws IOException {

		Date currentdate = new Date();
		String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":","-");
		System.out.println(screenshotfilename);


		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		File destination =  new File("C:\\Users\\hp\\git\\CHLE2E\\CHLE2E\\ScreenShots\\"+screenshotfilename+".png");
		FileUtils.moveFile(screenShot, destination);


		




	}
}
