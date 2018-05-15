package pages.marketplace.portfolio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class RiskDetailsPage extends BasePage {

	public RiskDetailsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By insuredAmount = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/riskInstalmentFrequency\").fromParent(new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/riskInstalmentAmount\"))");
	private By coverType = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/riskDetailsCoverType\").fromParent(new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/riskCoverType\"))");
	private By coverPeriod = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/coverPeriodLabel\").fromParent(new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/coverPeriod\"))");
	private By riskStartDateText = By.id("au.com.suncorp.marketplace:id/riskStartDateText");
	private By riskStartYearText = By.id("au.com.suncorp.marketplace:id/riskStartYearText");
	private By riskEndDateText = By.id("au.com.suncorp.marketplace:id/riskEndDateText");
	private By riskEndYearText = By.id("au.com.suncorp.marketplace:id/riskEndYearText");
	private By optionalCoverDescription = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/optionalCoverType\").fromParent(new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/optionalCoverDescription\")).instance(0)");
	private By includedCoverDescription = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/optionalCoverType\").fromParent(new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/optionalCoverDescription\")).instance(1)");
	private By includedCoverLabel = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/optionalCoverType\").instance(1)");
	private By optionalCoverLabel = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/optionalCoverType\").instance(0)");
	private By motorRiskParkingLabel = By.id("au.com.suncorp.marketplace:id/motorRiskParkingTitle");
	private By motorRiskParkingDescription = By.id("au.com.suncorp.marketplace:id/motorRiskParkingAddressLabel");
	private By navigateBackButton = MobileBy.AccessibilityId("Navigate up");
	private By standardExcess = By.id("au.com.suncorp.marketplace:id/standardExcessDescription");
	private By excessAmount = By.id("au.com.suncorp.marketplace:id/standardExcessValue");
	private By additionalExcessesTab = By.id("au.com.suncorp.marketplace:id/riskAdditionalExcessesTabTitle");
	private String additionalExcessesTabId = "au.com.suncorp.marketplace:id/riskAdditionalExcessesTabTitle";
	private String motorRiskParkingId = "au.com.suncorp.marketplace:id/motorRiskParkingTitle";
	private By additionalexcessDescription = By.id("au.com.suncorp.marketplace:id/excessDescription");
	private By additionalExcessListedDriver =By.id("au.com.suncorp.marketplace:id/listedDriverExcessValue");
	private By additionalExcessUnListedDriver =By.id("au.com.suncorp.marketplace:id/unlistedDriverExcessValue");
	private By coverStatusBannerText = By.id("au.com.suncorp.marketplace:id/coverStatusBannerText");
	private By riskCoverPeriodTitle = By.id("au.com.suncorp.marketplace:id/riskCoverPeriodTitle");
	private By coverPeriodStart = By.id("au.com.suncorp.marketplace:id/coverPeriodStart");
	private By coverPeriodEnd = By.id("au.com.suncorp.marketplace:id/coverPeriodEnd");
	public WebElement checkCoverStatusBannerText() {
		return find(coverStatusBannerText);
	}
	
	public String getCoverStatusBannerText() {
		return getText(coverStatusBannerText);
	}
	
	public String getRiskStartDateText() {

		return getText(riskStartDateText);
	}

	public String getRiskStartYearText() {

		return getText(riskStartYearText);
	}

	public String getRiskEndDateText() {

		return getText(riskEndDateText);
	}

	public String getRiskEndYearText() {

		return getText(riskEndYearText);
	}

	public WebElement checkRiskDescriptionText(String text) {
		
		return scrollToElementByText(text, 3);
	}

	
	public WebElement checkRegistrationNumberText(String text) {
		return scrollToElementByText(text, 1);
	}

	public WebElement checkInsuredAmountLabelText(String text) {
		
		return scrollToElementByText(text, 1);
	}

	public String getInsuredAmountText() {
		
		return scrollAndGetElementText(insuredAmount, 1);

	}

	public WebElement checkCoverTypeLabelText(String text) {
		
		return scrollToElementByText(text, 1);
	}

	public String getCoverTypeText() {
		
		return scrollAndGetElementText(coverType, 1);
	}

	public String getCoverPeriodText() {

		return scrollAndGetElementText(coverPeriod, 1);
	}

	public WebElement checkCoverPeriodLabelText(String text) {
		return scrollToElementByText(text, 1);
	}

	public String getOptionalCoverLabel() {

		return getText(optionalCoverLabel);
	}

	public String getOptionalCoverDescription() {

		return getText(optionalCoverDescription);
	}

	public String getIncludedCoverDescription() {

		return getText(includedCoverDescription);
	}

	public String getIncludedCoverLabel() {
		
		return scrollAndGetElementText(includedCoverLabel, 1);
	}

	public void scrollToMotorRiskParking() {

		scrollToElement(motorRiskParkingId, "id");
	}

	public String getMotorRiskParkingLabel() {

		return getText(motorRiskParkingLabel);
	}

	public String getMotorRiskParkingDescription() {

		return getText(motorRiskParkingDescription);
	}
	
	
	public void tapNavigateBackButton() {

		tapElement(navigateBackButton);
	}
 

	public String getExcessType() {
		
		return scrollAndGetElementText(standardExcess, 1);
	}
	
	public String getExcessAmount() {

		return scrollAndGetElementText(excessAmount, 1);

	}
	
	public WebElement checkAdditionalExcessesTab(){

	   return find(additionalExcessesTab,3);

	 }
	public void tapAdditionalExcessesTab(){

		   tapElement(additionalExcessesTab);

		 }
	
	public WebElement scrollToAdditionalExcessesTab(){

		   return scrollToElement(additionalExcessesTabId,"id");

	 }
	public String getAdditionalExcessesTabText(){

		   return getText(scrollToElement(additionalExcessesTabId,"id"));

	 }
	
	public String getAdditionalExcessDescription() {

		return getText(additionalexcessDescription);
		
	}

	public String getAdditionalExcessListedDriver() {
		
		return getText(additionalExcessListedDriver);
		
	}

	public String getAdditionalExcessUnListedDriver() {

		return getText(additionalExcessUnListedDriver);
	}

	public WebElement checkCoverPeriodLabel() {
		
		return find(riskCoverPeriodTitle);
	}

	public String getCoverPeriodLabel() {
		
		return getText(riskCoverPeriodTitle);
	}

	public WebElement checkCoverPeriodStart() {
		return find(coverPeriodStart);
	}

	public String getCoverPeriodStart() {
		return getText(coverPeriodStart);
	}

	public WebElement checkCoverPeriodEnd() {
		return find(coverPeriodEnd);
	}

	public String getCoverPeriodEnd() {
		return getText(coverPeriodEnd);
	}
	
}
