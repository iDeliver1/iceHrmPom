package pageModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import basePage.BasePage;

public class LoginPage extends BasePage {
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement signInbtn;
	
	
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement user;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	
	@FindBy(xpath = "//a[contains(text(),'IceHrm Employee')]")
	WebElement Validate_User;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	
	
	public void setUsername(String username) {
		user.clear();
		user.sendKeys(username);
	}
	
	public void setPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}
	
	public void Click_On_SignBtn() {
		signInbtn.click();
	}
	
	
	public boolean ValidateUser() {
		return Validate_User.isDisplayed();
	}
	
}
