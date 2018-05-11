package pages.marketplace.property;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class PropertyHubPage  extends BasePage{

	public PropertyHubPage(AppiumDriver driver) {
		super(driver);
	}

	private By propertyHubPageTitle = By.xpath("//android.widget.TextView[@text='Property Hub']");
	private By backButton = MobileBy.AccessibilityId("Navigate up");
	private By searchBar = By.id("au.com.suncorp.marketplace:id/search_bar");
	private By enabledSearchBar = By.id("au.com.suncorp.marketplace:id/search_src_text");
	private By searchIcon = By.id("au.com.suncorp.marketplace:id/propertySearchIcon");
	private By placeHolderimage = By.id("au.com.suncorp.marketplace:id/propertySearchImage");
	private By descriptionHeading = By.id("au.com.suncorp.marketplace:id/propertySearchInfo1Text");
	private By description = By.id("au.com.suncorp.marketplace:id/propertySearchInfo2Text");
	private By chatIcon = By.id("au.com.suncorp.marketplace:id/chatbotOption");
	private By clearSerchButton = By.id("au.com.suncorp.marketplace:id/search_close_btn");
	private By propertyExplorerSearchHintText = By.id("au.com.suncorp.marketplace:id/propertySearchHintText");
	
	public void enterTextInPropertyHubSearch(String propertySearchText) {
		tapElement(searchBar);
		typeValue(propertySearchText, enabledSearchBar);
	}
	
	public String getPropertyExplorerSearchHintText() {
		return getText(propertyExplorerSearchHintText);
	}
	
	public WebElement checkPropertyExplorerSearchHint() {
		return find(propertyExplorerSearchHintText);
	}
	
	public WebElement checkPropertyHubPageTitle() {
		return find(propertyHubPageTitle);
	}
	
	public String getPropertyHubPageTitle() {
		return getText(propertyHubPageTitle);
	}
	
	public WebElement checkBackButton() {
		return find(backButton);
	}
	
	public void tapBackButton() {
		tapElement(backButton);
	}
	
	public WebElement checkSearchBar() {
		return find(searchBar);
	}
	
	public WebElement checkEnabledSearchBar() {
		return find(enabledSearchBar);
	}
	
	public String getEnabledSearchBarText() {
		return getText(enabledSearchBar);
	}
	
	public WebElement checkSearchIcon() {
		return find(searchIcon);
	}
	
	public void tapSearchIcon() {
		tapElement(searchIcon);
	}
	
	public WebElement checkPlaceHolderimage() {
		return find(placeHolderimage);
	}
	
	public WebElement checkDescriptionHeading() {
		return find(descriptionHeading);
	}
	
	public String getDescriptionHeading() {
		return getText(descriptionHeading);
	}
	
	public WebElement checkDescription() {
		return find(description);
	}
	
	public String getDescription() {
		return getText(description);
	}
	
	public WebElement checkChatIcon() {
		return find(chatIcon);
	}
	
	public WebElement checkClearSerchButton() {
		return find(clearSerchButton);
	}
	
	public void tapClearSerchButton() {
		tapElement(clearSerchButton);
	}

}
