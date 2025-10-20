package loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class testLoginPage {
	
	WebDriver driver;
	
	public testLoginPage(WebDriver driver) {
		
		this.driver= driver;
	}
	
	
	public void enterUsername(String username) {
		
		WebElement username1= driver.findElement(By.xpath("//input[@id='username']"));
		username1.sendKeys(username);
		
	}
	
	public void enterPassword(String password) {
		WebElement password1= driver.findElement(By.xpath("//input[@id='password']"));
		password1.sendKeys(password);
	}
	
	public void clickBtn() {
		WebElement button= driver.findElement(By.xpath("//button[@id='submit']"));
		button.click();
		
	}
	
	public String validateLogin() {
		WebElement success= driver.findElement(By.xpath("//h1[contains(text(),'Logged In Successfully')]"));
		return success.getText();
		
	}
	
	public String getErrorMessage() {
        WebElement invalid= driver.findElement(By.xpath("//div[contains(text(),'Your username is invalid!')]"));
        return invalid.getText();
    }

}
