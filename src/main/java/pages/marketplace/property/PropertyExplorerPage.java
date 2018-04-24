package pages.marketplace.property;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
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
	private By propertyExplorerSearchHintText = By.id("au.com.suncorp.marketplace:id/propertySearchHintText");
	private By clearSerchButton = By.id("au.com.suncorp.marketplace:id/search_close_btn");
	private By homeJourneyPageTitle = By.xpath("//android.widget.TextView[@text='Home journey']");
	private By propertyInsightTab = By.id("au.com.suncorp.marketplace:id/propertySearchButton");
	private By suburbInsightTab = By.id("au.com.suncorp.marketplace:id/suburbSearchButton");
	private By backButton = MobileBy.AccessibilityId("Navigate up");
	
	public WebElement checkPropertyExplorerSearchbox() {
		return find(propertyExplorerSearchbox);
	}
	
	public WebElement checkMiniMapLocationPin() {
		return find(miniMapLocationPin);
	}
	
	public void tapMiniMapWhatsNearByButton() {
		tapElement(miniMapWhatsNearByButton);
	}
	
	public void tapMiniMap() {
		tapElement(miniMap);
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
	
	public String getPropertyExplorerSearchHintText() {
		return getText(propertyExplorerSearchHintText);
	}
	
	public void tapBackButton(){
		tapElement(backButton);
	}
	
	public WebElement checkClearSerchButton() {
		return find(clearSerchButton);
	}
	
	public void tapClearSerchButton(){
		tapElement(clearSerchButton);
	}
	
	public WebElement checkPropertyInsightTab() {
		return find(propertyInsightTab);
	}
	
	public void tapPropertyInsight() {
		tapElement(propertyInsightTab);
	}
	
	public WebElement checkSuburbInsightTab() {
		return find(suburbInsightTab);
	}
	
	public void tapSuburbInsight() {
		tapElement(suburbInsightTab);
	}

	public String getHomeJourneyTitle() {
		return getText(homeJourneyPageTitle);
	}
	
	public void tapSearch() {
		tapEnterOnTheKeyboard();
	}
	
	public void enterTextInPropertyHubSearchbox(String propertySearchText) {
		tapElement(propertyExplorerSearchbox);
		typeValue(propertySearchText, propertyExplorerSearchText);
	}
	
	public String getPropertyExplorerSearchText() {
		return getText(propertyExplorerSearchText);
	}
	
	public WebElement checkPropertyExplorerSearchHint() {
		return find(propertyExplorerSearchHintText);
	}

}
