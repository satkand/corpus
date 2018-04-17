package pages.marketplace.property;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class SuburbDetailsPage extends BasePage{

	public SuburbDetailsPage(AppiumDriver driver) {
		super(driver);
	}
	
	private By disclaimerLabelText = By.xpath("//android.widget.TextView[@text='Disclaimer']");
	private By suburbName = By.xpath("//android.widget.TextView[@text='Sunnydale, SA 5353']");
	private By backButton = MobileBy.AccessibilityId("Navigate up");
	
	private By riskAndHazardTitleText = By.id("au.com.suncorp.marketplace:id/risksAndHazardsTitle");
	private By riskAndHazardText = By.id("au.com.suncorp.marketplace:id/risksAndHazardsText");
	private By floodRiskLabelText = By.id("au.com.suncorp.marketplace:id/floodText");
	private By floodRiskValue= By.id("au.com.suncorp.marketplace:id/floodRatingText");
	private By bushFireLabelText = By.id("au.com.suncorp.marketplace:id/bushfireText");
	private By bushFireValue= By.id("au.com.suncorp.marketplace:id/bushfireRatingText");
	private By theftRiskLabelText = By.id("au.com.suncorp.marketplace:id/theftText");
	private By theftRiskValue= By.id("au.com.suncorp.marketplace:id/theftRatingText");

	private By demographicsTitleText = By.id("au.com.suncorp.marketplace:id/demographicsTitle");
	private By demographicsText = By.id("au.com.suncorp.marketplace:id/demographicsText");
	private By familyCompositionButton = By.id("au.com.suncorp.marketplace:id/familyCompositionButton");
	private By occupancyTypeButton= By.id("au.com.suncorp.marketplace:id/occupancyTypeButton");
	private By agesButton = By.id("au.com.suncorp.marketplace:id/agesButton");
	private By travelButton= By.id("au.com.suncorp.marketplace:id/travelButton");
	private By weeklyIncomeButton = By.id("au.com.suncorp.marketplace:id/weeklyIncomeButton");
	
	public boolean checkScreenTitleWithSuburbName(String text) {
		String t = "//android.widget.TextView[@text='"+text+"']";
		By titleName = By.xpath(t);
		WebElement element = find(titleName);
		if (element !=null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void scrollToDisclaimerLabelText(){
		scrollToElement(disclaimerLabelText, "true");
	}
	
	public WebElement checkDisclaimerLabelText() {
		return find(disclaimerLabelText);
	}
	
	public String getDisclaimerLabelText() {
		return getText(disclaimerLabelText);
	}
	
	public WebElement checkSuburbNameText() {
		return find(suburbName);
	}
	
	public String getSuburbNameText() {
		return getText(suburbName);
	}
	
	public WebElement checkBackButton() {
		return find(backButton);
	}

	public void tapBackButton() {
		tapElement(backButton);
	}
	
	public WebElement checkRiskAndHazardTitleText() {
		return find(riskAndHazardTitleText);
	}
	
	public String getRiskAndHazardTitleText() {
		return getText(riskAndHazardTitleText);
	}
	
	public WebElement checkRiskAndHazardTextt() {
		return find(riskAndHazardText);
	}
	
	public String getRiskAndHazardText() {
		return getText(riskAndHazardText);
	}
	
	public WebElement checkFloodRiskLabelText() {
		return find(floodRiskLabelText);
	}
	
	public String getFloodRiskLabelText() {
		return getText(floodRiskLabelText);
	}
	
	public WebElement checkFloodRiskValue() {
		return find(floodRiskValue);
	}
	
	public String getFloodRiskValue() {
		return getText(floodRiskValue);
	}
	
	public WebElement checkBushFireLabelText() {
		return find(bushFireLabelText);
	}
	
	public String getBushFireLabelText() {
		return getText(bushFireLabelText);
	}
	
	public WebElement checkBushFireValue() {
		return find(bushFireValue);
	}
	
	public String getBushFireValue() {
		return getText(bushFireValue);
	}
	
	public WebElement checkTheftRiskLabelText() {
		return find(theftRiskLabelText);
	}
	
	public String getTheftRiskLabelText() {
		return getText(theftRiskLabelText);
	}
	
	public WebElement checkTheftRiskValue() {
		return find(theftRiskValue);
	}
	
	public String getTheftRiskValue() {
		return getText(theftRiskValue);
	}
	
	public WebElement checkDemographicsTitleText() {
		return find(demographicsTitleText);
	}
	
	public String getDemographicsTitleText() {
		return getText(demographicsTitleText);
	}
	
	public WebElement checkDemographicsText() {
		return find(demographicsText);
	}
	
	public String getdemographicsText() {
		return getText(demographicsText);
	}
	
	public WebElement checkFamilyCompositionButton() {
		return find(familyCompositionButton);
	}
	
	public void tapfamilyCompositionButton() {
		tapElement(familyCompositionButton);
	}
	
	public WebElement checkOccupancyTypeButton() {
		return find(occupancyTypeButton);
	}
	
	public void tapOccupancyTypeButton() {
		tapElement(occupancyTypeButton);
	}
	
	public WebElement checkAgesButton() {
		return find(agesButton);
	}
	
	public void tapagesButton() {
		tapElement(agesButton);
	}
	
	public WebElement checkTravelButton() {
		return find(travelButton);
	}
	
	public void tapTravelButton() {
		tapElement(travelButton);
	}
	
	public WebElement checkWeeklyIncomeButton() {
		return find(weeklyIncomeButton);
	}
	
	public void tapWeeklyIncomeButton() {
		tapElement(weeklyIncomeButton);
	}
	
}
