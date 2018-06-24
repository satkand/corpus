package pages.marketplace.money;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class ToAccountPage extends BasePage{

	public ToAccountPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void chooseToAccount(String accountName){
		
		tapElement(findByUIAutomator(accountName, "text",30));
	}
	

}
