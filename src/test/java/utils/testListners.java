package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Base.baseSetup;

public class testListners extends baseSetup implements ITestListener  {
	
	@Override
	public void onTestFails(ITestResult result) {

		System.out.println("Test Fails: "+ result.getName());
		WebDriver driver= this.driver;
		
		if(driver!= null) {
			takesScreenshot(driver, result.getName() );
		}
		
	}

	private void takesScreenshot(WebDriver driver, String testName) {
		
		String timestamp= new SimpleDateFormat("yyyymmdd_hhmmss").format(new Date());
		File src= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dastpath= System.getProperty("user.dir")+"/screensots/"+ testName +"_"+timestamp+ ".png";
		
		try {
			FileUtils.copyFile(src, new File(dastpath));
			System.out.println("📸 Screenshot saved at: " + dastpath);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		
	}

}
