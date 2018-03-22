package pages.marketplace.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class PropertyExplorerPage  extends BasePage{

	public PropertyExplorerPage(AppiumDriver driver) {
		super(driver);
	}
	
	private By miniMap = By.id("au.com.suncorp.marketplace:id/mapView");
	private By miniMapWhatsNearByButton = By.id("au.com.suncorp.marketplace:id/nearbyButton");
	private By miniMapLocationPin = By.xpath("//android.widget.FrameLayout[@resource-id='au.com.suncorp.marketplace:id/mapView']//android.widget.FrameLayout//android.view.View[@content-desc='Google Map']//android.view.View");
	private By propertyExplorerSearchbox = By.id("au.com.suncorp.marketplace:id/search_bar");
	private By propertyExplorerSearchText = By.id("au.com.suncorp.marketplace:id/search_src_text");
	
	
	public WebElement checkPropertyExplorerSearchbox() {
		return find(propertyExplorerSearchbox);
	}
	
	public void tapSearch() {
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
		
	}
	
	public void scrollToWhatsNearButton() {
		scrollToElement(miniMapWhatsNearByButton, "true");
	}
	
	public void enterTextInPropertyExplorerSearchbox(String propertySearchText) {
		tapElement(propertyExplorerSearchbox);
		typeValue(propertySearchText, propertyExplorerSearchText);
	}
	
	public WebElement checkMiniMap() {
		return find(miniMap);
	}
	
	public WebElement checkMiniMapWhatsNearButton() {
		return find(miniMapWhatsNearByButton);
	}
	
	public WebElement checkMiniMapLocationPin() {
		return find(miniMapLocationPin);
	}

}
