package pages.marketplace.offers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

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
	private By firstNameRegistrationPage = By.id("au.com.suncorp.marketplace:id/firstNameField");
	private By cancelRegistrationPage = By.id("au.com.suncorp.marketplace:id/cancelButton");

	public WebElement checkOfferImage() {
		return find(offerIcon, 30);
	}

	public WebElement checkOfferTitle() {
		return find(offerTitle);
	}

	public WebElement checkActionButton() {
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

	public WebElement checkRegistrationPage() {
		return find(firstNameRegistrationPage, 30);
	}

	public WebElement checkCancelButtonRegistrationPage() {
		return find(cancelRegistrationPage, 30);
	}

	public void tapCancelButtonRegistrationPage() {
		tapElement(cancelRegistrationPage);
	}
	
	public String getOffersPageTitle(){
		return getText(offerTitle);
	}
}
