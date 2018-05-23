package pages.marketplace.property;

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
	
	private By journeyTitleText = By.id("au.com.suncorp.marketplace:id/journeyTitleText");
	private By journeySubtitleText = By.id("au.com.suncorp.marketplace:id/journeySubtitleText");
	private By journeyDescriptionText = By.id("au.com.suncorp.marketplace:id/journeyDescriptionText");
	
	private By planningImage = By.id("au.com.suncorp.marketplace:id/planningImage");
	private By planningTitleText = By.id("au.com.suncorp.marketplace:id/planningTitleText");
	private By planningDescriptionText = By.id("au.com.suncorp.marketplace:id/planningDescriptionText");
	private By planningReadMoreButton = By.id("au.com.suncorp.marketplace:id/planningReadMoreButton");
	
	private By houseHuntingImage = By.id("au.com.suncorp.marketplace:id/houseHuntingImage");
	private By houseHuntingTitleText = By.id("au.com.suncorp.marketplace:id/houseHuntingTitleText");
	private By houseHuntingDescriptionText = By.id("au.com.suncorp.marketplace:id/houseHuntingDescriptionText");
	private By houseHuntingReadMoreButton = By.id("au.com.suncorp.marketplace:id/houseHuntingReadMoreButton");
	
	private By gettingReadyImage = By.id("au.com.suncorp.marketplace:id/gettingReadyImage");
	private By gettingReadyTitleText = By.id("au.com.suncorp.marketplace:id/gettingReadyTitleText");
	private By gettingReadyDescriptionText = By.id("au.com.suncorp.marketplace:id/gettingReadyDescriptionText");
	private By gettingReadyReadMoreButton = By.id("au.com.suncorp.marketplace:id/gettingReadyReadMoreButton");
	
	private By movingInImage = By.id("au.com.suncorp.marketplace:id/movingInImage");
	private By movingInTitleText = By.id("au.com.suncorp.marketplace:id/movingInTitleText");
	private By movingInDescriptionText = By.id("au.com.suncorp.marketplace:id/movingInDescriptionText");
	private By movingInReadMoreButton = By.id("au.com.suncorp.marketplace:id/movingInReadMoreButton");
	
	//professional Services
	private By viewServiceVendorsButton = By.id("au.com.suncorp.marketplace:id/propertyViewProfessionalServicesButton");
	private By homeServiceDesc = By.id("au.com.suncorp.marketplace:id/propertyProfessionalServicesBodyText");
	private By homeServicesTitile = By.id("au.com.suncorp.marketplace:id/propertyProfessionalServicesTitle");
	private By homeServicesImage = By.id("au.com.suncorp.marketplace:id/professionalServicesImage");
	
	public void scrollToViewServiceVendorsButton(){
		scrollToElement(viewServiceVendorsButton);
	}
	
	public void tapViewServiceVendorsButton() {
		tapElement(viewServiceVendorsButton);
	}
	
	public WebElement checkHomeJourneyPageTitle() {
		String str = homeJourneyPageTitle.toString();
		if(find(homeJourneyPageTitle)!=null) {
			return find(homeJourneyPageTitle);
		}else {
			str = str.substring(str.length()-14, str.length()-2).toUpperCase();
			String t = "//android.widget.TextView[@text='"+str+"']";
			By titleName = By.xpath(t);
			return find(titleName);
		}
		
	}
	
	public WebElement checkBackButton() {
		return find(backButton);
	}
	
	public void tapBackButton() {
		tapElement(backButton);
	}
	
	public WebElement checkJourneyTitleText() {
		return find(journeyTitleText);
	}
	
	public String getJourneyTitleText() {
		return getText(journeyTitleText);
	}
	
	public WebElement checkJourneySubtitleText() {
		return find(journeySubtitleText);
	}
	
	public String getJourneySubtitleText() {
		return getText(journeySubtitleText);
	}
	
	public WebElement checkJourneyDescriptionText() {
		return find(journeyDescriptionText);
	}
	
	public String getJourneyDescriptionText() {
		return getText(journeyDescriptionText);
	}
	
	public void scrollToJourneyDescriptionText(){
		scrollToElement(journeyDescriptionText);
	}
	
	public WebElement checkPlanningImage() {
		return find(planningImage);
	}
	
	public WebElement checkPlanningTitleText() {
		return find(planningTitleText);
	}
	
	public String getPlanningTitleText() {
		return getText(planningTitleText);
	}
	
	public WebElement checkPlanningDescriptionText() {
		return find(planningDescriptionText);
	}
	
	public String getPlanningDescriptionText() {
		return getText(planningDescriptionText);
	}
	
	public WebElement checkPlanningReadMoreButton() {
		return find(planningReadMoreButton);
	}
	
	public void tapPlanningReadMoreButton() {
		tapElement(planningReadMoreButton);
	}
	
	public void scrollToPlanningReadMoreButton(){
		scrollToElement(planningReadMoreButton);
	}
	
	public WebElement checkHouseHuntingImage() {
		return find(houseHuntingImage);
	}
	
	public WebElement checkHouseHuntingTitleText() {
		return find(houseHuntingTitleText);
	}
	
	public String getHouseHuntingTitleText() {
		return getText(houseHuntingTitleText);
	}
	
	public WebElement checkHouseHuntingDescriptionText() {
		return find(houseHuntingDescriptionText);
	}
	
	public String getHouseHuntingDescriptionText() {
		return getText(houseHuntingDescriptionText);
	}
	
	public WebElement checkHouseHuntingReadMoreButton() {
		return find(houseHuntingReadMoreButton);
	}

	public void tapHouseHuntingReadMoreButton() {
		tapElement(houseHuntingReadMoreButton);
	}
	
	public WebElement checkGettingReadyImage() {
		return find(gettingReadyImage);
	}
	
	public WebElement checkGettingReadyTitleText() {
		return find(gettingReadyTitleText);
	}
	
	public String getGettingReadyTitleText() {
		return getText(gettingReadyTitleText);
	}
	
	public WebElement checkGettingReadyDescriptionText() {
		return find(gettingReadyDescriptionText);
	}
	
	public String getGettingReadyDescriptionText() {
		return getText(gettingReadyDescriptionText);
	}
	
	public WebElement checkGettingReadyReadMoreButton() {
		return find(gettingReadyReadMoreButton);
	}
	
	public void tapGettingReadyReadMoreButton() {
		tapElement(gettingReadyReadMoreButton);
	}
	
	public WebElement checkmovingInImage() {
		return find(movingInImage);
	}
	
	public WebElement checkMovingInTitleText() {
		return find(movingInTitleText);
	}
	
	public String getMovingInTitleText() {
		return getText(movingInTitleText);
	}
	
	public WebElement checkMovingInDescriptionText() {
		return find(movingInDescriptionText);
	}
	
	public String getMovingInDescriptionText() {
		return getText(movingInDescriptionText);
	}
	
	public WebElement checkMovingInReadMoreButton() {
		return find(movingInReadMoreButton);
	}
	
	public void tapMovingInReadMoreButton() {
		tapElement(movingInReadMoreButton);
	}
}
