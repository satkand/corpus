package pages.marketplace.landing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class NavigationMenuPage extends BasePage {
	
	private By splitMenuIcon = MobileBy.AccessibilityId("Open navigation menu");

	private By welcomeMessage = By.id("au.com.suncorp.marketplace:id/profileName");
	private By suncorpMenuItem = By.xpath("//android.widget.CheckedTextView[@text='Overview']");
	private By bankingHome = By.xpath("//android.widget.CheckedTextView[@text='Banking Home']");
	private By digitalVaultMenuItem = By.xpath("//android.widget.CheckedTextView[@text='DigitalSafe']");
	private By productsCatalogueItem = By.xpath("//android.widget.CheckedTextView[@text='Apply online']");
	private By productsMenuItem = By.xpath("//android.widget.CheckedTextView[@text='Policies & accounts']");
	private By rewardsForYou = By.xpath("//android.widget.CheckedTextView[@text='Rewards']");
	private By claimsMenuItem = By.xpath("//android.widget.CheckedTextView[@text='Active claims']");
	private By proffessionalServicesMenuItem = By.xpath("//android.widget.CheckedTextView[@text='Professional services']");
	
	private By settingsMenuItem = By.xpath("//android.widget.CheckedTextView[@text='Settings']");
	private By supportAndInformationMenuItem = By.xpath("//android.widget.CheckedTextView[@text='Support & information']");
	private By backToStartMenuItem = By.xpath("//android.widget.CheckedTextView[@text='Back to start']");
	private By devSettings = By.xpath("//android.widget.CheckedTextView[@text='Dev Settings']");
    private String devSettingsText ="Dev Settings";

	private By logOutMenuOption = By.xpath("//android.widget.CheckedTextView[@text='Log out']");
	private String logOutMenuOptionText="Log out";
	
	public void tapProffessionalServicesMenuItem() {
		 tapElement(proffessionalServicesMenuItem);
	}
	
	public WebElement checkProffessionalServicesMenuItem() {
		 return find(proffessionalServicesMenuItem);
	}
	
	public NavigationMenuPage(AppiumDriver driver) {
		super(driver);
	}
	
	public WebElement checkSplitMenuIcon() {
		 return find(splitMenuIcon,30);
	}
	
	public void tapSplitMenuIcon() {
		 find(splitMenuIcon,30);
		 tapElement(splitMenuIcon);
	}
	
	public WebElement checkSuncorpMenuItem() {
		 return find(suncorpMenuItem);
	}
	
	public void tapSuncorpMenuItem() {
		 find(suncorpMenuItem, 30);
		 tapElement(suncorpMenuItem);
	}
	
	public String getWelcomeMessageText() {
		return getText(welcomeMessage);
	}
	
	public WebElement checkBankingHomeMenuItem() {
		 return find(bankingHome);
	}
	
	public WebElement checkProductsMenuItem() {
		 return find(productsMenuItem);
	}
	
	public WebElement checkProductCatalogueItem() {
		 return find(productsCatalogueItem);
	}
	
	public void tapProductCatalogueMenuItem() {
		 find(productsCatalogueItem, 30);
		 tapElement(productsCatalogueItem);
	}
	
	public WebElement checkRewardsForYouMenuItem() {
		 return find(rewardsForYou);
	}
	
	public WebElement checkClaimsMenuItem() {
		 return find(claimsMenuItem);
	}
	
	public WebElement checkSupportAndInformationMenuItem() {
		 return find(supportAndInformationMenuItem);
	}
	
	public WebElement checkDigitalVaultMenuItem() {
		 return find(digitalVaultMenuItem);
	}

	public void tapProductsMenuItem() {
		find(productsMenuItem, 30);
		 tapElement(productsMenuItem);

	}

	public WebElement checkBackToStartMenuItem() {
		 return find(backToStartMenuItem);
	}
	
	public void tapBackToStartMenuItem() {
		 find(backToStartMenuItem, 30);
		 tapElement(backToStartMenuItem);
	}
	
	public WebElement checkLogOutMenuOption() {
		 return scrollToElement(logOutMenuOptionText, "text");
	}
	
	public void tapLogOutMenuOption() {
		 tapElement(logOutMenuOption);
	}
	
	public void tapDigitalVaultMenuItem() {
		 tapElement(digitalVaultMenuItem);
	}
	
	public WebElement checkDevSettings() {
		 return find(devSettings);
	}
	
//	public void scrollToDevSettings() {
//		scrollToElement(devSettings);
//	}
	
	public void tapDevSettings() {
		find(devSettings, 30);
		 tapElement(devSettings);
	}
	
	public WebElement checkSettingsMenuItem() {
		return find(settingsMenuItem);
	}
	
	public void tapSettingsMenuItem() {
		tapElement(settingsMenuItem);
	}
	
	public void slideOpenNavigationMenu() {
		swipeHorizontallyToRight();
	}
	
	public void slideCloseNavigationMenu() {
		swipeHorizontallyToLeft();
	}

	public void closeNavigationMenu(){
		tapOnBottomRightCorner();
	}
	
	public void scrollToDevSettings() {
		
		scrollToElement(devSettingsText,"text");
		 
	}
}
