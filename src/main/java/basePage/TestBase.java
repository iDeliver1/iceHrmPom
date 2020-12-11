package basePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



import io.github.bonigarcia.wdm.WebDriverManager;
import utils.TestUtil;
import utils.WebEventListener;

public class TestBase {

	protected WebDriver driver;
	public static String browserName = "chrome",url,Desc,Actual,PassExp,FailExp;
	public String Report_Name;
	protected String username;
	protected String password,cause;
	public  Properties prop;
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/"
					+ "config/config.properties");
		
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		url=prop.getProperty("url");
		this.username = prop.getProperty("username");
		this.password=prop.getProperty("password");
		
	}
	
	
	
	@BeforeTest
    public void beforeSuite() throws Throwable {
		
		String BrowserVersion = TestUtil.getBrowserVersion();	
		System.out.println("Browser Version- "+BrowserVersion);
		
		if(browserName.equals("chrome")){
			WebDriverManager.chromedriver().version(BrowserVersion).setup();
			driver = new ChromeDriver(); 
		
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/com/AP/qa/driver/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		initateURL();
	}

	
	public void initateURL() throws Throwable{
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(url);
		}
	
	
	public void Reporting_Description(String ReportDesc) {
	
		if(ReportDesc.contains("Login")) {
			Desc = "Login Validation";
			Actual = "User Must looged in with username "+username;
			PassExp = "User Successfully Logged in";
			FailExp="Log in Failed";
		}else if (ReportDesc.contains("Select")){
			Desc = "Select Product Validation";
			Actual = "User Should be able to select Product";
			PassExp = "User Successfully select product";
			FailExp="Unable to select product";
		}
		else if(ReportDesc.contains("Payment")) {
			Desc = "Payment Validation";
			Actual = "Payment should be succesfull";
			PassExp = "Payment Successfully passed";
			FailExp="Payment Failed";
			
		}else if(ReportDesc.contains("Logout")) {
			Desc = "Logout Validation";
			Actual = "User Must logged out with username"+username;
			PassExp = "User Successfully Logged out";
			FailExp="Log out Failed";
		}

	}
	
	
	public String get_Reportname(String Report) {
		Report_Name=Report;
		return Report_Name;
	}
	
	public static void log(String e) {
		Logger.getLogger(TestBase.class.getName());
		log.info(e);
		Reporter.log(e);
	}
	
	@AfterMethod
	public void CheckMethod_Status(ITestResult result) {
		
		Reporting_Description(result.getMethod().getMethodName());
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			
			
			String ResultRe = " Description "+Desc+" Actual "+Actual+" Expected "+PassExp;
			log(ResultRe);
		
			
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			String ResultRe = " Description "+Desc+" Actual "+Actual+" Expected "+FailExp +" due to "+cause;
			
			log.warning(ResultRe);
			
		}
	}
	
	
	
    @AfterTest
    public void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }


}
