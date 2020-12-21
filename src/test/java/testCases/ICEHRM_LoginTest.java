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
	public void Login_Test() {
		checkobjMethod =	objGen.ICE_HRM_Login(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertNotNull(checkobjMethod);
	}
	
	@Test(priority = 2,dependsOnMethods="Login_Test")	
	public void Punch_In_Test() {
		objGen.ICE_HRM_Homepage("Attendance");
		checkblnmethod = objGen.ICE_HRM_AttendancePage("IN",0);
		Assert.assertEquals(true, checkblnmethod);
	}
	
	@Test(priority = 3,dependsOnMethods="Punch_In_Test")	
	public void Leave_Test() throws InterruptedException {
		objGen.ICE_HRM_Homepage("Leave");
		objGen.ICE_HRM_LeavePage("Causal Leave");
		
	}
	@Test(priority = 4,dependsOnMethods="Leave_Test")	
	public void Punch_Out_Test() {
		objGen.ICE_HRM_Homepage("Attendance");
		checkblnmethod = objGen.ICE_HRM_AttendancePage("OUT",5);
		Assert.assertEquals(true, checkblnmethod);
		
	}
	
	
}
