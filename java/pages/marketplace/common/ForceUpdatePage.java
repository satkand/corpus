package pages.marketplace.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class ForceUpdatePage  extends BasePage{

	public ForceUpdatePage(AppiumDriver driver) {
		super(driver);
	}
	
	private By forceUpdateImage = By.id("au.com.suncorp.marketplace:id/forcedUpdateImage");
	private By forceUpdateHeadingText = By.id("au.com.suncorp.marketplace:id/titleText");
	private By forceUpdateDescription = By.id("au.com.suncorp.marketplace:id/messageText");
	private By forceUpdateDownloadNewVersionButton = By.id("au.com.suncorp.marketplace:id/updateButton");
	private By playStoreTitle = By.xpath("//android.widget.TextView[@text='Play Store']");
	
	
	public String getForceUpdateHeadingText() {
		return getText(forceUpdateHeadingText);
	}
	
	public WebElement checkPlayStoreTitle() {
		return find(playStoreTitle);
	}
	
	public WebElement checkForceUpdateHeadingText() {
		return find(forceUpdateHeadingText);
	}
	
	public String getForceUpdateDescription() {
		return getText(forceUpdateDescription);
	}
	
	public WebElement checkForceUpdateDescription() {
		return find(forceUpdateDescription);
	}
	
	public WebElement checkForceUpdateImage() {
		return find(forceUpdateImage);
	}
	
	public WebElement checkForceUpdateDownloadNewVersionButton() {
		return find(forceUpdateDownloadNewVersionButton);
	}
	
	public void tapForceUpdateDownloadNewVersionButton() {
		tapElement(forceUpdateDownloadNewVersionButton);
	}
	
	public void tapDeviceBackButton() {
		tapDeviceBackButton();
	}
	

}
