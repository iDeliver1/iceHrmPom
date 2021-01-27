package pageModules;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.PageBase;

public class AdminTravelPage extends PageBase {
	
	@FindBy(xpath = "//*[@id=\"EmployeeTravelRecord\"]/div[2]/div/table/tbody/tr")
	public List <WebElement> empTravelTable;
	@FindBy(xpath = "//*[@id=\"EmployeeTravelRecord\"]/div[2]/div/table/tbody/tr/td")
	public WebElement empNoTravelTable;
	
	@FindBy(xpath = "//*[@id=\"EmployeeTravelRecord\"]/div[2]/div/table/tbody/tr/td/div/img")
	public List <WebElement> empTravelTableActionButton;

	int iTravelTableCount,iIterate;
	
	public AdminTravelPage( WebDriver driver) {
		super(driver);
	}
	
	public boolean empTravelAction() {
		
		try {
			
			if( !empNoTravelTable.getText().equalsIgnoreCase("No data available in table")) {
				iTravelTableCount = empTravelTable.size();
				
				for(iIterate=0;iIterate<=iTravelTableCount;iIterate++) {
					
					empTravelTableActionButton.get(1).click();
				}
				return true;
			}else {
				
				System.out.println("No Table");
				return false;
			}
		}catch(Exception e) {
			return false;
		}
		
	}

}
