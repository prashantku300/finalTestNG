package LoginTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.baseSetup;
import loginPage.testLoginPage;

public class loginTest extends baseSetup {
	
	@Test(priority=1)
	public void testValidLogin() {
		
		testLoginPage lp= new testLoginPage(driver);
		lp.enterUsername("student");
		lp.enterPassword("Password123");
		lp.clickBtn();
		String successmsg=lp.validateLogin();
		Assert.assertTrue(successmsg.contains("Logged In Successfully"), "Login Failed!");
		
	}
	
	@Test(priority=2)
	public void invalidLogin() {
		
		testLoginPage lp= new testLoginPage(driver);
		lp.enterUsername("prashant");
		lp.enterPassword("Test@heuf");
		lp.clickBtn();
	    String Invalidmsg=lp.validateLogin();
	    Assert.assertTrue(Invalidmsg.contains("Your username is invalid!"), "Error message mismatch!");
	}
	
	
	
	
	
	
	

}
