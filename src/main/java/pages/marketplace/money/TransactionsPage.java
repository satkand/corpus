package pages.marketplace.money;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class TransactionsPage extends BasePage{

	private By accountDetailsButton = By.id("au.com.suncorp.marketplace:id/largeAccountDetailsButton");
	private By transferPayButton = By.id("au.com.suncorp.marketplace:id/transferPromptButton");
	
	public TransactionsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement checkAccountDetailsButton(){
		
		return find(accountDetailsButton,20);
		
	}
	public void tapTransferPayButton() {

		tapElement(transferPayButton);

	}
	
	
	
	

}
