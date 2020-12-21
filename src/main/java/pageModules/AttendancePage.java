package pageModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import basePage.BasePage;
import utils.TestUtil;

public class AttendancePage extends BasePage {
	@FindBy(xpath = "//button[@id='punchButton']")
	WebElement PunchBtn;
	
	@FindBy(xpath = "//input[@id='time']")
	WebElement Time;
	
	@FindBy(xpath = "//textarea[@id='note']")
	WebElement Note;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement Save;
	
	@FindBy(xpath = "//button[@id='punchButton']")
	WebElement Punchout;
	
	
	public AttendancePage(WebDriver driver) {
			super(driver);
	}

	
	public void PunchSystem(String Status,int time) {
		Time.clear();
		Time.sendKeys(TestUtil.fTimestamp(time));
		Note.clear();
		Note.sendKeys(Status);
		Save.click();
		
	}
	
	public void punch_in() {
		PunchBtn.click();
	}
	
	
	public void punch_out() {
		Punchout.click();
	}
	
	
	
}
