package pages.marketplace.home;

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
		// TODO Auto-generated constructor stub
	}
	
	private By propertyExplorerSearchbox = By.id("au.com.suncorp.marketplace:id/search_bar");
	private By propertyExplorerSearchText = By.id("au.com.suncorp.marketplace:id/search_src_text");
	private By propertyExplorerSearchHintText = By.id("au.com.suncorp.marketplace:id/propertySearchHintText");
	private By clearSerchButton = By.id("au.com.suncorp.marketplace:id/search_close_btn");
	private By homeJourneyPageTitle = By.xpath("//android.widget.TextView[@text='Home journey']");
	private By propertyInsightTab = By.id("au.com.suncorp.marketplace:id/propertySearchButton");
	private By suburbInsightTab = By.id("au.com.suncorp.marketplace:id/suburbSearchButton");
	private By backButton = MobileBy.AccessibilityId("Navigate up");
	
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
	public WebElement checkSuburbInsightTab() {
		return find(suburbInsightTab);
	}
	public void tapSuburbInsight() {
		tapElement(suburbInsightTab);
	}
	public WebElement checkPropertyHubSearchbox() {
		return find(propertyExplorerSearchbox);
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
