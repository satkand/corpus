package pages.marketplace.common;

import org.openqa.selenium.By;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class ConfigPage extends BasePage {

	private By configPageTitle = By.xpath("//android.widget.TextView[@text='Config']");
	private By continueButton = By.id("au.com.suncorp.marketplace:id/configContinueButton");
	
	//FAPI Settings page
	private By hasBankAccountsToggle = By.id("au.com.suncorp.marketplace:id/hasAccountsToggle");
	private By someTransactions = By.id("au.com.suncorp.marketplace:id/spendingManyTransactions");
	
	public ConfigPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void dismissConfigPage() {
		if(find(configPageTitle,30) != null) {
			// Added this just to add some delay before checking for keyboard
			find(continueButton,10);
			if(!(isKeyboardPresent() == true)) {
				isKeyboardPresent();
			}
			for(int i=0; i<=2; i++) {
				swipeScreen("down");
			}
			if(find(continueButton, 30) != null) {
				tapElement(continueButton);
			}
		}
	}
	
	public void enableHasBankAccountsToggle() {
		if (!isToggleEnabled(hasBankAccountsToggle)) {
			tapElement(hasBankAccountsToggle);
		}
	}
	
	public void disableHasBankAccountsToggle() {
		if (isToggleEnabled(hasBankAccountsToggle)) {
			tapElement(hasBankAccountsToggle);
		}
	}
	
	public void tapSomeTransactions() {
		tapElement(someTransactions);
	}

}
