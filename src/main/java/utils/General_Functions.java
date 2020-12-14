package utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import basePage.TestBase;
import pageModules.HomePage;
import pageModules.LoginPage;

public class General_Functions extends TestBase {

	LoginPage objLog;
	WebDriver GFdriver;
	HomePage objHome;
	
	
	public General_Functions(WebDriver driver) {
		this.GFdriver = driver;
		objLog = new LoginPage(GFdriver);
	}

	
	public HomePage ICE_HRM_Login(String username, String password) {
		objLog.setUsername(username);
		objLog.setPassword(password);
		objLog.Click_On_SignBtn();
		
		try {
			Assert.assertEquals(true, objLog.ValidateUser());
			//TestUtil.saveValue("hello");
			System.out.println(prop.get("error_Reson"));
			return objHome = new HomePage(GFdriver);
		}catch(Exception e) {
			return null;
		}
		
	}
}
