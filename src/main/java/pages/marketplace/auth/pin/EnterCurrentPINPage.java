package pages.marketplace.auth.pin;

import java.security.KeyStore.PrivateKeyEntry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class EnterCurrentPINPage extends BasePage {

	public EnterCurrentPINPage(AppiumDriver driver) {
		super(driver);
	}

	private By enterExistingPinLabel = By.id("au.com.suncorp.marketplace:id/activatePinTitle");
	private By pinField = By.id("au.com.suncorp.marketplace:id/pinImage1");
	private By forgotPinButton = By.id("au.com.suncorp.marketplace:id/customKeypadForgotPinButton");
	private By PINLockAlertMessage = By.id("android:id/message");
	private By reAuthenticateButton = By.id("android:id/button1");
	private By incorrectPINErrorMessage = By.id("au.com.suncorp.marketplace:id/pinIncorrectErrorText");
	private By pinButton = null;
	private By backButton = MobileBy.AccessibilityId("Back");
	private By okButton = By.id("android:id/button1");
	private By pinInstructionTitile = By.id("au.com.suncorp.marketplace:id/pinInstructionTitle");
	private By pinInstructionMessage = By.id("au.com.suncorp.marketplace:id/pinInstructionMessage");

	public WebElement checkEnterExistingPinLabel() {
		return find(enterExistingPinLabel, 20);
	}

	public WebElement checkPINLockAlertMessage() {
		return find(PINLockAlertMessage, 20);
	}

	public WebElement checkReAuthenticateButton() {
		return find(reAuthenticateButton, 20);
	}

	public WebElement checkPinField() {
		return find(pinField, 5);
	}

	public WebElement checkForgotPinButton() {
		return find(forgotPinButton, 5);

	}


	public void tapForgotPinButton() {
		tapElement(forgotPinButton);
	}

	public void tapReAuthenticateButton() {
		tapElement(reAuthenticateButton);
	}
	
	public void tapBackButton() {
		tapElement(backButton);
	}
	
	public void tapOkButton() {
		tapElement(okButton);
	}
	
	public WebElement checkOkButton() {
		return find(okButton);
	}
	
	
	public WebElement checkPinLockedMessage() {

		return find(PINLockAlertMessage);
	}
	
	public String getPinLockedMessage() {

		return getText(PINLockAlertMessage);
	}

	public String getReAuthenticateButtonText() {

		return getText(reAuthenticateButton);
	}
	
	public String getIncorrectPINErrorMessage() {

		return getText(incorrectPINErrorMessage);
	}
	
	public void enterPIN(String PIN){
		for(int i=0; i<4 ;i++) {
			char digit = PIN.charAt(i);
			String elementAddition = "customKeypadButton"+digit;
			pinButton = By.id("au.com.suncorp.marketplace:id/"+elementAddition);
			tapElement(pinButton);
		}
	}

	public String getPinInstructionTitileText() {

		return getText(pinInstructionTitile);
	}
	public String getPinInstructionMessageText() {

		return getText(pinInstructionMessage);
	}
}
