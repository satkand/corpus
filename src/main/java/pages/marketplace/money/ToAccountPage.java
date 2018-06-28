package pages.marketplace.money;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class ToAccountPage extends BasePage{

	private By addPayee=By.id("au.com.suncorp.marketplace:id/addPayeeFab");



	public ToAccountPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void chooseToAccount(String accountName){
		
		tapElement(findByUIAutomator(accountName, "text",30));
	}


	public WebElement checkaddPayeeFab() {
		return find(addPayee);
	}
	public void addPayee() {
		tapElement(addPayee);
		
	}
	

}
