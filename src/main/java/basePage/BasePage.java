package basePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private static  final int TIMEOUT = 5; //seconds
    private  static final int POLLING = 100; //milliseconds

    protected WebDriver driver;
    private WebDriverWait wait;


    public BasePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
    	 this.driver = driver;
         wait = new WebDriverWait(driver, TIMEOUT, POLLING);
         PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}

	protected void waitForElementToAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }
    
    protected void MoveElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
}
