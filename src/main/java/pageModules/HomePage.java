package pageModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import basePage.BasePage;

public class HomePage extends BasePage {
	@FindBy(xpath = "//a[@id='atteandanceLink']")
	WebElement AttendanceTab;
	
	@FindBy(xpath = "//a[@class='logo']")
	public WebElement HomeBtn;
	
	
	@FindBy(xpath = "//a[@id='leavesLink']")
	WebElement LeaveTab;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	
	public Object clickOnTab(String TabName) {
		HomeBtn.click();
		if(TabName.equalsIgnoreCase("Attendance")) {
			AttendanceTab.click();
			return new AttendancePage(driver);
		}
		else if(TabName.equalsIgnoreCase("Leave")) {
			LeaveTab.click();
			 return new LeavePage(driver);
		}
		else
			return false;
		
	}
}
