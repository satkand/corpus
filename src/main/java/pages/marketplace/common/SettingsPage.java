package pages.marketplace.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class SettingsPage  extends BasePage {

	private By settingsTitle = By.xpath("//android.widget.TextView[@text='Settings']");
	private By pinSettingsTitle = By.id("au.com.suncorp.marketplace:id/pinSettingsTitle");
	private By enablePinToggle = By.id("au.com.suncorp.marketplace:id/enablePinToggle");
	private By changePinLink =  By.id("au.com.suncorp.marketplace:id/changePin");
	
	public SettingsPage(@SuppressWarnings("rawtypes") AppiumDriver driver) {
		super(driver);
	}
	
	public WebElement checkSettingsTitle() {
		return find(settingsTitle);
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
}
