package pages.marketplace.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class FAPISettingsPage extends BasePage {
	
	
	public FAPISettingsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By userHasPropertiesToggle = By.id("au.com.suncorp.marketplace:id/hasPropertiesToggle");
	private By userHasBankAccounts = By.id("au.com.suncorp.marketplace:id/hasAccountsToggle");
	
	public void tapUserHasPropertiesToggle() {
		tapElement(userHasPropertiesToggle);
	}
	
	public WebElement checkUserHasPropertiesToggle() {
		return find(userHasPropertiesToggle);
	}
	
	public void tapUserHasBankAccounts() {
		tapElement(userHasBankAccounts);
	}
	
	public WebElement checkUserHasBankAccounts() {
		return find(userHasBankAccounts);
	}
	

}
