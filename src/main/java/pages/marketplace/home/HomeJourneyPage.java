package pages.marketplace.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class HomeJourneyPage extends BasePage {

	public HomeJourneyPage(AppiumDriver driver) {
		super(driver);
	}
	
	private By homeJourneyPageTitle = By.xpath("//android.widget.TextView[@text='Home journey']");
	private By backButton = MobileBy.AccessibilityId("Navigate up");
	
	public WebElement checkHomeJourneyPageTitle() {
		return find(homeJourneyPageTitle);
	}

	public void tapBackButton() {
		tapElement(backButton);
	}
}
