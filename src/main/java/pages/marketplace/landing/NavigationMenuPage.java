package pages.marketplace.landing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class NavigationMenuPage extends BasePage {

	private By splitMenuIcon = MobileBy.AccessibilityId("Open navigation menu");
	private By profilePicture = By.id("au.com.suncorp.marketplace:id/profilePicture");

	private By suncorpMenuItem = By.xpath("//android.widget.CheckedTextView[@text='One Suncorp']");
	
	private By productsMenuItem = By.xpath("//android.widget.CheckedTextView[@text='My Products']");
	private By digitalVaultMenuItem = By.xpath("//android.widget.CheckedTextView[@text='Digital Vault']");
	private By homeJourneyMenuItem = By.xpath("//android.widget.CheckedTextView[@text='Home journey']");
	private By productsCatalogueItem = By.xpath("//android.widget.CheckedTextView[@text='Product catalogue']");

	private By propfessionalServicesMenuItem = By.xpath("//android.widget.CheckedTextView[@text='Professional services']");

	private By settingsMenuItem = By.xpath("//android.widget.CheckedTextView[@text='Settings']");
	private By backToStartMenuItem = By.xpath("//android.widget.CheckedTextView[@text='Back to start']");
	private By devSettings = By.xpath("//android.widget.CheckedTextView[@text='Dev Settings']");
    private String devSettingsText ="Dev Settings";
	private By lockMenuOption = By.xpath("//android.widget.CheckedTextView[@text='Lock']");

	public void tapProffessionalServicesMenuItem() {
		 tapElement(propfessionalServicesMenuItem);
	}
	
	public WebElement checkProffessionalServicesMenuItem() {
		 return find(propfessionalServicesMenuItem);
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
	
	public WebElement checkDigitalVaultMenuItem() {
		 return find(digitalVaultMenuItem);
	}

	public void tapProductsMenuItem() {
		find(productsMenuItem, 30);
		 tapElement(productsMenuItem);

	}
	
	public WebElement checkHomeJourneyMenuItem() {
		 return find(homeJourneyMenuItem);
	}
	
public void tapHomeJourneyMenuItem() {
	find(homeJourneyMenuItem, 30);
	 tapElement(homeJourneyMenuItem);
	
}
	public WebElement checkBackToStartMenuItem() {
		 return find(backToStartMenuItem);
	}
	
	public void tapBackToStartMenuItem() {
		 find(backToStartMenuItem, 30);
		 tapElement(backToStartMenuItem);
	}
	
	public WebElement checkLockMenuOption() {
		 return find(lockMenuOption);
	}
	
	public void tapLockMenuOption() {
		 tapElement(lockMenuOption);
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
	
	public WebElement checkProfilePicture() {
		return find(profilePicture, 30);
	}
	
	public void scrollToDevSettings() {
		
		scrollToElement(devSettingsText,"text");
		 
	}
}
