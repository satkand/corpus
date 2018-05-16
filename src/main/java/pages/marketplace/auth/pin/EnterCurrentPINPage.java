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
		// TODO Auto-generated constructor stub
	}
	
	private By enterExistingPinLabel = By.id("au.com.suncorp.marketplace:id/activatePinTitle");
	private By pinField = By.id("au.com.suncorp.marketplace:id/pinImage1");
	private By forgotPinButton = By.id("au.com.suncorp.marketplace:id/customKeypadForgotPinButton");
	private By PINLockAlertMessage = By.id("android:id/message");
	private By reAuthenticateButton = By.id("android:id/button1");
	private By incorrectPINErrorMessage = By.id("au.com.suncorp.marketplace:id/pinIncorrectErrorText");
	private By backButton = MobileBy.AccessibilityId("Back");
	private By buttonOne = By.id("au.com.suncorp.marketplace:id/customKeypadButton1");
	private By buttonThree = By.id("au.com.suncorp.marketplace:id/customKeypadButton3");
	private By buttonFive = By.id("au.com.suncorp.marketplace:id/customKeypadButton5");
	private By buttonSeven = By.id("au.com.suncorp.marketplace:id/customKeypadButton7");
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
	
	public String getPinInstructionTitileText() {

		return getText(pinInstructionTitile);
	}
	public String getPinInstructionMessageText() {

		return getText(pinInstructionMessage);
	}
	public void enterPIN(){
		tapElement(buttonOne);
		tapElement(buttonThree);
		tapElement(buttonFive);
		tapElement(buttonSeven);
	}
}
