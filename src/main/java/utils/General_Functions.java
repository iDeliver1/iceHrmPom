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

	
	public HomePage iceHrmLogin(String username, String password) {
		objLog.setUsername(username);
		objLog.setPassword(password);
		objLog.clickOnSignBtn();
		
		try {
			Assert.assertEquals(true, objLog.validateUser());
			System.out.println(prop.get("error_Reson"));
			return objHome = new HomePage(GFdriver);
		}catch(Exception e) {
			TestBase.Error_Reason = e.toString();
			return null;
		}
		
	}
	
	
	public void iceHrmHomepage(String TabName) {
		
		if(TabName.equalsIgnoreCase("Attendance")) {
			try {
				objAtte =	(AttendancePage) objHome.clickOnTab(TabName);
				}
				catch(Exception e) {
				}
		}else {
			try {
				objLeave =(LeavePage) objHome.clickOnTab(TabName);
				}
				catch(Exception e) {
				}
		}
		
	}
	
	
	
public boolean iceHrmAttendancePage(String AttendanceWay,int time) {
		
	try {
	switch(AttendanceWay) {
	
	case "IN"  : objAtte.punchSystem(AttendanceWay,time);
				Thread.sleep(4000);
				return true;
				
	case "OUT"	: objAtte.punchSystem(AttendanceWay, time);
				 Thread.sleep(4000);
				 return true;
				 
	 default : System.out.println("invalid section");
				 return false;
	}
		
	}catch(Exception e) {
		return false;
	}
		
	}
	
	
	
	public void iceHrmLeavePage(String Leave) throws InterruptedException {
		objLeave.applyForLeave(Leave);
		objHome.HomeBtn.click();
	}
	
	
}
