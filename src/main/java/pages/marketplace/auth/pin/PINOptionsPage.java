package pages.marketplace.auth.pin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class PINOptionsPage extends BasePage{

	//No Fingerprint enabled
	private By enablePinButton = By.id("au.com.suncorp.marketplace:id/enablePinPromptEnablePinButton");
	private By maybeLaterButton = By.id("au.com.suncorp.marketplace:id/enablePinPromptDismissButton");
	private By enableFingerPrintButton = By.id("au.com.suncorp.marketplace:id/enableFingerprintButton");
	private By pinPromptImage = By.id("au.com.suncorp.marketplace:id/enablePinPromptImage");
	private By pinPromptUserWelcome = By.id("au.com.suncorp.marketplace:id/enablePinPromptUserWelcome");
	private By pinPromptDescription = By.id("au.com.suncorp.marketplace:id/enablePinPromptDescription");
	
	//Fingerprint enabled
	private By promptUserWelcome = By.id("au.com.suncorp.marketplace:id/enablePromptUserWelcome");
	private By promptDescription = By.id("au.com.suncorp.marketplace:id/enablePromptDescription");
	private By promptImage = By.id("au.com.suncorp.marketplace:id/enablePromptImage");
	private By enablePinButtonWithFingerprint = By.id("au.com.suncorp.marketplace:id/enablePinButton");
	private By enableFingerPrintBtn = By.id("au.com.suncorp.marketplace:id/enableFingerprintButton");
	private By maybeLaterPromptButton = By.id("au.com.suncorp.marketplace:id/enablePromptDismissButton");

	
	public PINOptionsPage(AppiumDriver driver) {
		super(driver);
	}

	//Methods for Fingerprint not enabled cases
	
//	public WebElement checkEnablePinButton(){
//		return find(enablePinButton);
//	}
	
	public WebElement checkEnablePinButton() {

		if (checkFingerPrintButton() == null) {

			return find(enablePinButton);
		} else {

			return find(enableFingerPrintButton);
		}

	}
	
	public WebElement checkFingerPrintButton(){
		return find(enableFingerPrintButton,5);
	}
	
	public WebElement checkMaybeLaterButton(){
//		return find(maybeLaterButton);
		if (find(pinPromptImage) != null) {
			
			return find(maybeLaterButton, 50);
		}
		else 
			return find(maybeLaterPromptButton, 50);
	}
	
	public WebElement checkPinPromptImage() {

		if (checkFingerPrintButton() == null) {

			return find(pinPromptImage);

		} else {

			return find(promptImage);
		}

	}
	
	public WebElement checkPinPromptUserWelcome(){
		if (find(pinPromptImage) != null) {
			return find(pinPromptUserWelcome, 50);
		}
		else 
			return find(promptUserWelcome, 50);
	}
	
	public WebElement checkPinPromptDescription() {

		if (checkFingerPrintButton() == null) {

			return find(pinPromptDescription);

		} else {

			return find(promptDescription);

		}

	}
	
	public void tapEnablePinButton() {

		if (checkFingerPrintButton() == null) {

			tapElement(enablePinButton);

		} else {

			tapElement(enablePinButtonWithFingerprint);

		}

	}

	public void tapMaybeLater(){
		if (find(pinPromptImage) != null) {
			tapElement(maybeLaterButton);
		}
		else 
			tapElement(maybeLaterPromptButton);
	}
	
	//Methods for Fingerprint enabled cases
	
	public WebElement checkPromptUserWelcome(){
		return find(promptUserWelcome, 30);
	}
	
	public WebElement checkPromptDescription(){
		return find(promptDescription);
	}
	
	public WebElement checkPromptImage(){
		return find(promptImage);
	}
	
	public WebElement checkMaybeLaterPromptButton(){
		return find(maybeLaterPromptButton);
	}
	
	public void tapPromptMaybeLater(){
		tapElement(maybeLaterPromptButton);
	}
	
	public WebElement checkEnableFingerprintBtn() {
		return find (enableFingerPrintBtn,2);
	}
}
