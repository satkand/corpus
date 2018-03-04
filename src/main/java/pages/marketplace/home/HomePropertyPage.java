package pages.marketplace.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class HomePropertyPage extends BasePage {

	public HomePropertyPage(AppiumDriver driver) {
		super(driver);
	}

	private By homeJourneyBannerImage = By.id("au.com.suncorp.marketplace:id/homeJourneyBannerImage");
	private By homeJourneyBannerHeading = By.id("au.com.suncorp.marketplace:id/journeyHeadingText");
	private By homeJourneyBannerDescription = By.id("au.com.suncorp.marketplace:id/journeyDescriptionText");
	private By startYourJourneyButton = By.id("au.com.suncorp.marketplace:id/startHomeJourneyButton");
	
	
	public void scrollToJourneyBanner(){
		scrollToElement(startYourJourneyButton);
	}
	
	public WebElement checkHomeJourneyBannerImage() {
		return find(homeJourneyBannerImage);
	}
	
	public String getHomeJourneyBannerHeading() {
		return getText(homeJourneyBannerHeading);
	}
	
	public String getHomeJourneyBannerDescription() {
		return getText(homeJourneyBannerDescription);
	}
	
	public WebElement checkStartYourJourneyButton() {
		return find(startYourJourneyButton);
	}
	
	public void tapStartYourJourneyButton() {
		tapElement(startYourJourneyButton);
	}
}
