package pageModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import basePage.BasePage;

public class LoginPage extends BasePage {
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement SignInbtn;
	
	
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement User;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement Password;
	
	
	@FindBy(xpath = "//a[contains(text(),'IceHrm Employee')]")
	WebElement Validate_User;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	
	
	public void setUsername(String username) {
		User.clear();
		User.sendKeys(username);
	}
	
	public void setPassword(String pass) {
		Password.clear();
		Password.sendKeys(pass);
	}
	
	public void clickOnSignBtn() {
		SignInbtn.click();
	}
	
	
	public boolean validateUser() {
		return Validate_User.isDisplayed();
	}
	
}
