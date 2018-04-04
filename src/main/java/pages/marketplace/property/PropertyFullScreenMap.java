package pages.marketplace.property;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class PropertyFullScreenMap extends BasePage{

	
	public PropertyFullScreenMap(AppiumDriver driver) {
		super(driver);
		}

	private By fullScreenMapPin = By.xpath("//android.widget.FrameLayout[@resource-id='au.com.suncorp.marketplace:id/whatsNearbyMapView']//android.widget.FrameLayout//android.view.View[@content-desc='Google Map']//android.view.View");
	private By fullScreenMapCloseButton = MobileBy.AccessibilityId("Navigate up");
	private By fullScreenMapTitle= By.xpath("//android.view.ViewGroup[@resource-id='au.com.suncorp.marketplace:id/suncorpToolbar']//android.widget.TextView");
	private By fullScreenMap= MobileBy.AccessibilityId("Google Map");
	
	public WebElement checkFullScreenMapCloseButton() {
		return find(fullScreenMapCloseButton);
	}
	
	public WebElement checkFullScreenMapTitle() {
		return find(fullScreenMapTitle);
	}
	
	public void tapFullScreenMapCloseButton() {
		tapElement(fullScreenMapCloseButton);
	}
	
	public WebElement checkFullScreenMapPin() {
		return find(fullScreenMapPin);
	}
	
	public WebElement checkFullScreenMap() {
		return find(fullScreenMap);
	}
	
	public void doubleTapFullScreenMap() {
		tapElement(fullScreenMap);
		tapElement(fullScreenMap);	
	}
	
}
