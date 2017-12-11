package pages.marketplace.wealth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class FinancePage extends BasePage {

	public FinancePage(AppiumDriver driver) {
		super(driver);
	}

	private By viewSpendingThisMonthButton = By.id("au.com.suncorp.marketplace:id/viewSpendingButton");
	
	public WebElement checkViewSpendingThisMonthButton() {
		return find(viewSpendingThisMonthButton);
	}
	
	public void tapviewSpendingThisMonthButton() {
		tapElement(viewSpendingThisMonthButton);
	}
}
