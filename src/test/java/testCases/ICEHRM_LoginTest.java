package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePage.TestBase;
import utils.General_Functions;

public class ICEHRM_LoginTest extends TestBase {

	General_Functions objGen;
	
	
	@BeforeClass
	public void init() {
		objGen = new General_Functions(driver);
	}

	@Test(priority = 1)	
	public void LoginTest() {
		checkMethod =	objGen.ICE_HRM_Login(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertNotNull(checkMethod);
		Reporting_Description("Login Validation", "User should be able to logged with username "+username, "User successfully logged in", "Logged in failed ");
	}
}
