package pages.marketplace.money;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class FromAccountPage extends BasePage{

	public FromAccountPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void chooseFromAccount(String accountName){
		
		tapElement(findByUIAutomator(accountName, "text",30));
	}
	

}
