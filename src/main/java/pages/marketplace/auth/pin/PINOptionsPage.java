package pages.marketplace.auth.pin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class PINOptionsPage extends BasePage{

	
	private By enablePinButton = By.id("au.com.suncorp.marketplace:id/enablePinPromptEnablePinButton");
	private By maybeLaterButton = By.id("au.com.suncorp.marketplace:id/enablePinPromptDismissButton");
	
	private By pinPromptImage = By.id("au.com.suncorp.marketplace:id/enablePromptImage");
	private By pinPromptUserWelcome = By.id("au.com.suncorp.marketplace:id/enablePromptUserWelcome");
	private By pinPromptDescription = By.id("au.com.suncorp.marketplace:id/enablePromptDescription");
	
	public PINOptionsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement checkEnablePinButton(){
		return find(enablePinButton);
	}
	
	public WebElement checkMaybeLaterButton(){
		return find(maybeLaterButton);
	}
	
	public WebElement checkPinPromptImage(){
		return find(pinPromptImage);
	}
	
	public WebElement checkPinPromptUserWelcome(){
		return find(pinPromptUserWelcome, 30);
	}
	
	public WebElement checkPinPromptDescription(){
		return find(pinPromptDescription);
	}
	
	public void tapEnablePinButton(){
		tapElement(enablePinButton);
	}
	
	public void tapMaybeLater(){
		tapElement(maybeLaterButton);
	}
	
}
