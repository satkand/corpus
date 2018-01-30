package pages.marketplace.offers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class OffersPage extends BasePage {

	@SuppressWarnings("rawtypes")
	public OffersPage(AppiumDriver driver) {
		super(driver);
	}

	private By offerIcon = By.id("au.com.suncorp.marketplace:id/offerIcon");
	private By offerTitle = By.id("au.com.suncorp.marketplace:id/offerTitle");
	private By offerDescription = By.id("au.com.suncorp.marketplace:id/offerDescription");
	private By callToActionButton = By.id("au.com.suncorp.marketplace:id/offerActionButton");
	private By backgroundImage = By.id("au.com.suncorp.marketplace:id/offerBackgroundImage");
	

	public WebElement checkOfferIcon() {
		return find(offerIcon, 30);
	}

	public WebElement checkOfferTitle() {
		return find(offerTitle);
	}

	public WebElement checkCallToActionButton() {
		return find(callToActionButton,20);
	}

	public void tapCallToActionButton() {
		tapElement(callToActionButton);
	}

	public WebElement checkBackgroundImage() {
		return find(backgroundImage);
	}

	public String getOffersDescriptionText() {
		return getText(offerDescription);
	}

	public String getOfferTitleText() {
		return getText(offerTitle);
	}

	public void scrollDown() {
		swipeHorizontallyToLeft();
		swipeScreen("down");
	}
	
	public String getOffersPageTitle(){
		return getText(offerTitle);
	}
}
