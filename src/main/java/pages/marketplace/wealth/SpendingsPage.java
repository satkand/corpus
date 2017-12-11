package pages.marketplace.wealth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class SpendingsPage extends BasePage {
	
	public SpendingsPage(AppiumDriver driver) {
		super(driver);
	}

	private By spendingPageTitle = By.xpath("//android.widget.TextView[@text='Spending']");
	private By backButton = MobileBy.AccessibilityId("Navigate up");
	
	public WebElement checkSpendingPageTitle() {
		return find(spendingPageTitle,30);
	}

	public void tapBackButton() {
		tapElement(backButton);
	}
}
