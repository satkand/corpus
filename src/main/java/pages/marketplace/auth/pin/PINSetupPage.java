package pages.marketplace.auth.pin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class PINSetupPage extends BasePage {
	
	public PINSetupPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By enterPINLabel = By.id("au.com.suncorp.marketplace:id/enterPinMessage");
	private By reEnterPINLabel = By.id("au.com.suncorp.marketplace:id/reenterPinMessage");
	private By cancelButton = By.id("au.com.suncorp.marketplace:id/pinSetupCancelButton");
	
	private By invalidPINAlertMessage = By.id("android:id/message");
	private By invalidPINAlertOKButton = By.id("android:id/button1");

	private By pinsDonotMatchErrorMessage = By.id("au.com.suncorp.marketplace:id/pinSetupInlineError");
	
	private By pinSuccessfullySetNotification = By.id("au.com.suncorp.marketplace:id/successAlertDialog");
	private By pinSuccessfullySetMessage = By.id("au.com.suncorp.marketplace:id/dialogMessage");
	
	private By pinButton = null;
	
	public WebElement checkEnterPINLabel() {
		return find(enterPINLabel);
	}
	
	public String getEnterPINLabel() {
		return getText(enterPINLabel);
	}
	
	public WebElement checkReEnterPINLabel() {
		return find(reEnterPINLabel);
	}	
	
	public String getReEnterPINLabel() {
		return getText(reEnterPINLabel);
	}
	
	public WebElement checkCancelButton() {
		return find(cancelButton);
	}
	
	public void tapCancelButton() {
		tapElement(cancelButton);
	}
	
	public WebElement checkInvalidPINAlertMessage() {
		return find(invalidPINAlertMessage);
	}
	
	public String getInvalidPINAlertMessage() {
		return getText(invalidPINAlertMessage);
	}
	
	public WebElement checkInvalidPINAlertOKButton() {
		return find(invalidPINAlertOKButton);
	}
	
	public void tapInvalidPINAlertOKButton() {
		tapElement(invalidPINAlertOKButton);
	}
	
	public WebElement checkPINsDonotMatchErrorMessage() {
		return find(pinsDonotMatchErrorMessage);
	}
	
	public String getPINsDonotMatchErrorMessage() {
		return getText(pinsDonotMatchErrorMessage);
	}
	
	public WebElement checkPINSuccessfullySetNotification() {
		return find(pinSuccessfullySetNotification);
	}
	
	public WebElement checkPINSuccessfullySetMessage() {
		return find(pinSuccessfullySetMessage);
	}
	
	public String getPINSuccessfullySetMessage() {
		return getText(pinSuccessfullySetMessage);
	}
	
	public void enterPIN(String PIN){
		for(int i=0; i<4 ;i++) {
			char digit = PIN.charAt(i);
			String elementAddition = "customKeypadButton"+digit;
			pinButton = By.id("au.com.suncorp.marketplace:id/"+elementAddition);
			tapElement(pinButton); 
		}
	}
}
