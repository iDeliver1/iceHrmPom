package utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageModules.LoginPage;

public class General_Functions {

	LoginPage objLog;
	WebDriver GFdriver;
	
	
	public General_Functions(WebDriver driver) {
		this.GFdriver = driver;
		objLog = new LoginPage(GFdriver);
	}

	
	public Boolean ICE_HRM_Login(String username, String password) {
		objLog.setUsername(username);
		objLog.setPassword(password);
		objLog.Click_On_SignBtn();
		
		try {
			Assert.assertEquals(true, objLog.ValidateUser());
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
}
