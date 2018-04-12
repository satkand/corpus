package pages.marketplace.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import automation.framework.common.Copy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class SettingsPage  extends BasePage {

	private By settingsTitle = By.xpath("//android.widget.TextView[@text='Settings']");
	private By pinSettingsTitle = By.id("au.com.suncorp.marketplace:id/pinSettingsTitle");
	private By enablePinToggle = By.id("au.com.suncorp.marketplace:id/enablePinToggle");
	private By changePinLink =  By.id("au.com.suncorp.marketplace:id/changePin");
	
	public SettingsPage(@SuppressWarnings("rawtypes") AppiumDriver driver) {
		super(driver);
	}
	
	public WebElement checkSettingsTitle() {
		return findByUIAutomator(Copy.SETTINGS_TITLE_TEXT, "text");
	}
	
	public WebElement checkEnablePinToggle() {
		return find(enablePinToggle);
	}
	
	public void tapEnablePinToggle() {
		tapElement(enablePinToggle);
	}
	
	public boolean isPinToggleEnabled() {
		return isToggleEnabled(enablePinToggle);
	}
	
	public WebElement checkChangePinLink() {
		return find(changePinLink);
	}
	
	public void tapChangePinLink() {
		tapElement(changePinLink);
	}
	
	
	
}
