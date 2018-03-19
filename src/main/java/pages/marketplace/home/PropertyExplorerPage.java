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
		// TODO Auto-generated constructor stub
	}
	
	private By miniMap = By.id("au.com.suncorp.marketplace:id/mapView");
	private By miniMapWhatsNewButton = By.id("au.com.suncorp.marketplace:id/nearbyButton");
	private By miniMapLocationPin = By.xpath("//android.widget.FrameLayout[@resource-id='au.com.suncorp.marketplace:id/mapView']//android.widget.FrameLayout//android.view.View[@content-desc='Google Map']//android.view.View");
	private By propertyExplorerSearchbox = By.id("au.com.suncorp.marketplace:id/search_bar");
	private By propertyExplorerSearchText = By.id("au.com.suncorp.marketplace:id/search_src_text");
	
	
	public WebElement checkPropertyHubSearchbox() {
		return find(propertyExplorerSearchbox);
	}
	
//	public void tapPropertyHubSearchbox() {
//		tapElement(propertyHubSearchbox);
//	}
	
	public void tapSearch() {
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
		
	}
	
	public void scrollToWhatsNewButton() {
		scrollToElement(miniMapWhatsNewButton, "true");
	}
	
	public void enterTextInPropertyHubSearchbox(String propertySearchText) {
		tapElement(propertyExplorerSearchbox);
		typeValue(propertySearchText, propertyExplorerSearchText);
	}
	
	public WebElement checkMiniMap() {
		return find(miniMap);
	}
	
	public WebElement checkMiniMapWhatsNewButton() {
		return find(miniMapWhatsNewButton);
	}
	
	public WebElement checkMiniMapLocationPin() {
		return find(miniMapLocationPin);
	}

}
