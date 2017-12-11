package pages.marketplace.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class HomePropertyPage extends BasePage {

	public HomePropertyPage(AppiumDriver driver) {
		super(driver);
	}

	private By startYourJourneyButton = By.id("au.com.suncorp.marketplace:id/startHomeJourneyButton");
	
	public WebElement checkStartYourJourneyButton() {
		return find(startYourJourneyButton);
	}
	
	public void tapStartYourJourneyButton() {
		tapElement(startYourJourneyButton);
	}
}
