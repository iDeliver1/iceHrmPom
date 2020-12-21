package utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import basePage.TestBase;
import pageModules.AttendancePage;
import pageModules.HomePage;
import pageModules.LeavePage;
import pageModules.LoginPage;

public class General_Functions extends TestBase {

	LoginPage objLog;
	WebDriver GFdriver;
	HomePage objHome;
	AttendancePage objAtte;
	LeavePage objLeave;
	
	
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
			System.out.println(prop.get("error_Reson"));
			return objHome = new HomePage(GFdriver);
		}catch(Exception e) {
			TestBase.Error_Reason = e.toString();
			return null;
		}
		
	}
	
	
	public void ICE_HRM_Homepage(String TabName) {
		
		if(TabName.equalsIgnoreCase("Attendance")) {
			try {
				objAtte =	(AttendancePage) objHome.click_onTAb(TabName);
				}
				catch(Exception e) {
				}
		}else {
			try {
				objLeave =(LeavePage) objHome.click_onTAb(TabName);
				}
				catch(Exception e) {
				}
		}
		
	}
	
	
	
public boolean ICE_HRM_AttendancePage(String AttendanceWay,int time) {
		
	try {
	switch(AttendanceWay) {
	case "IN"  : objAtte.punch_in();
				objAtte.PunchSystem(AttendanceWay,time);
				return true;
				
	case "OUT"	:objAtte.punch_out();
				 objAtte.PunchSystem(AttendanceWay, time);
				 return true;
				 
	 default : System.out.println("invalid section");
				 return false;
	}
		
	}catch(Exception e) {
		return false;
	}
		
	}
	
	
	
	public void ICE_HRM_LeavePage(String Leave) throws InterruptedException {
		objLeave.Applyfor_Leave(Leave);
		objHome.HomeBtn.click();
	}
	
	
}
