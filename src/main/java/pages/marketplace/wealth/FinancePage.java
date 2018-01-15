package pages.marketplace.wealth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class FinancePage extends BasePage {

	public FinancePage(AppiumDriver driver) {
		super(driver);
	}

	private By netWorthLabel = By.id("au.com.suncorp.marketplace:id/netWorthTitle");
	private By netWorthAmount = By.id("au.com.suncorp.marketplace:id/netWorthAmount");
	private By viewSpendingThisMonthButton = By.id("au.com.suncorp.marketplace:id/viewSpendingButton");
	private By netWorthDisclaimerMessage = By.id("au.com.suncorp.marketplace:id/netWorthDisclaimer");
	
	public String getNetWorthLabel() {
		return getText(netWorthLabel);
	}
	
	public WebElement checkNetWorthAmount() {
		return find(netWorthAmount);
	}
	
	public String getNetWorthAmountValue() {
		return getText(netWorthAmount);
	}
	
	public WebElement checkViewSpendingThisMonthButton() {
		return find(viewSpendingThisMonthButton);
	}
	
	public void tapviewSpendingThisMonthButton() {
		tapElement(viewSpendingThisMonthButton);
	}
	
	public String getNetWorthDisclaimerMessage() {
		return getText(netWorthDisclaimerMessage);
	}
}
