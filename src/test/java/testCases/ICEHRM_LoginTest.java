package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePage.TestBase;
import utils.General_Functions;

public class ICEHRM_LoginTest extends TestBase {

	General_Functions objGen;
	boolean checkMethod;
	
	@BeforeClass
	public void init() {
		objGen = new General_Functions(driver);
	}

	@Test(priority = 1)	
	public void LoginTest() {
		checkMethod =	objGen.ICE_HRM_Login(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertEquals(true, checkMethod);
	}
}
