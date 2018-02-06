package pages.marketplace.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class NavigationMenuPage extends BasePage {

	private By splitMenuIcon = MobileBy.AccessibilityId("Open navigation menu");
	
	private By suncorpMenuItem = By.xpath("//android.widget.CheckedTextView[@text='One Suncorp']");
	private By productsMenuItem = By.xpath("//android.widget.CheckedTextView[@text='My Products']");
	private By homeJourneyMenuItem = By.xpath("//android.widget.CheckedTextView[@text='Home journey']");
	private By backToStartMenuItem = By.xpath("//android.widget.CheckedTextView[@text='Back to start']");
	private By lockMenuOption = By.xpath("//android.widget.CheckedTextView[@text='Lock']");
	private By fapiSettingsMenuItem = By.xpath("//android.widget.CheckedTextView[@text='FAPI Settings']");
	private By digiVaultMenuItem = By.xpath("//android.widget.CheckedTextView[@text='Digital Vault']");
	
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
	
	public WebElement checkHomeJourneyMenuItem() {
		 return find(homeJourneyMenuItem);
	}
	
	public void tapHomeJourneyMenuItem() {
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
	
	public WebElement checkFAPISettingsMenuItem() {
		 return find(fapiSettingsMenuItem);
	}
	
	public void tapFAPISettingsMenuItem() {
		find(fapiSettingsMenuItem, 30);
		 tapElement(fapiSettingsMenuItem);
	}
	
	public void slideOpenNavigationMenu() {
		swipeHorizontallyToRight();
	}
	
	public void slideCloseNavigationMenu() {
		swipeHorizontallyToLeft();
	}

	public void closeNavigationMenu(){
		closeNavigationMenuByTappingOut();
	}
	
	public WebElement checkDigiVaultMenuIcon() {
		 return find(digiVaultMenuItem,30);
	}
	
	public void tapDigiVaultMenuIcon() {
		 find(digiVaultMenuItem,30);
		 tapElement(digiVaultMenuItem);
	}
}
