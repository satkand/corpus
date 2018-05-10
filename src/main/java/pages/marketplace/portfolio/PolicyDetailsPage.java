package pages.marketplace.portfolio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class PolicyDetailsPage extends BasePage {

	public PolicyDetailsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By policyDescription = By.id("au.com.suncorp.marketplace:id/policyDescriptionText");
	private By policyNumberLabel = By.id("au.com.suncorp.marketplace:id/policyNumberLabelText");
	private By policyNumberText = By.id("au.com.suncorp.marketplace:id/policyNumberText");
	private By periodOfCoverLabel = By.id("au.com.suncorp.marketplace:id/periodOfCoverLabelText");
	private By policyStartDate = By.id("au.com.suncorp.marketplace:id/policyStartDateText");
	private By policyStartYear = By.id("au.com.suncorp.marketplace:id/policyStartYearText");
	private By policyEndDate = By.id("au.com.suncorp.marketplace:id/policyEndDateText");
	private By policyEndYear = By.id("au.com.suncorp.marketplace:id/policyEndYearText");
	private By policyBrandImage = By.id("au.com.suncorp.marketplace:id/policyBrandImage");
	private By navigateBackButton = MobileBy.AccessibilityId("Navigate up");
	private By debitDayLabel = By.id("au.com.suncorp.marketplace:id/debitDayLabel");
	private By instalmentFrequency = By.id("au.com.suncorp.marketplace:id/instalmentFrequency");
	private By instalmentAmount = By.id("au.com.suncorp.marketplace:id/instalmentAmount");
	private By paymentMethodLabel = By.id("au.com.suncorp.marketplace:id/paymentMethodTitle");
	private By paymentMethodAccount = By.id("au.com.suncorp.marketplace:id/paymentMethodAccount");
	private By policyDetailsBanner = By.id("au.com.suncorp.marketplace:id/policyDetailsBanner");
	private By insuredAmount = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/insuredAmountLabel\").fromParent(new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/insuredAmount\"))");
	private By coverType = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/coverTypeLabel\").fromParent(new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/coverType\"))");
	private By coverPeriod = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/coverPeriodLabel\").fromParent(new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/coverPeriod\"))");
	private By risksTitle = By.id("au.com.suncorp.marketplace:id/risksTitle");
	private By rewardsSubtitle = By.id("au.com.suncorp.marketplace:id/rewardsSubtitle");
	private By optionalCoverDescription = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/optionalCoverType\").fromParent(new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/optionalCoverDescription\")).instance(0)");
	private By includedCoverDescription = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/optionalCoverType\").fromParent(new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/optionalCoverDescription\")).instance(1)");
	private By includedCoverLabel = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/optionalCoverType\").instance(1)");
	private By optionalCoverLabel = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/optionalCoverType\").instance(0)");
	private By riskViewDetails = By.id("au.com.suncorp.marketplace:id/riskViewDetails");
	private By discountsTitle = By.id("au.com.suncorp.marketplace:id/discountsTitle");
	private By discountsSubtitle = By.id("au.com.suncorp.marketplace:id/discountsSubtitle");
	private By rewardsTitle = By.id("au.com.suncorp.marketplace:id/rewardsTitle");
	private By policyMaintenanceTitle = By.id("au.com.suncorp.marketplace:id/policyUnderPolicyMaintenanceTitle");
	private By policyMaintenanceErrorMessage = By
			.id("au.com.suncorp.marketplace:id/policyUnderPolicyMaintenanceSubtitle");
	private By policyActiveStatus = By.id("au.com.suncorp.marketplace:id/policyActiveStatusText");
	private By policyrenewalStatus = By.id("PolicyDetails.PolicyStatus");
	private By renewNowButton = By.id("au.com.suncorp.marketplace:id/renewNowButton");
	private String optionalCoverTypeLabelId = "au.com.suncorp.marketplace:id/optionalCoverType";
	private String riskViewDetailsId = "au.com.suncorp.marketplace:id/riskViewDetails";
	private String rewardsSubtitleId = "au.com.suncorp.marketplace:id/rewardsSubtitle";
	private By coverTypeText = By.id("au.com.suncorp.marketplace:id/coverType");
	private By riskDescription = By.id("au.com.suncorp.marketplace:id/riskDescription");
	private By riskIcon = By.id("au.com.suncorp.marketplace:id/riskIcon");
	private By registrationNumber = By.id("au.com.suncorp.marketplace:id/registrationNumber");
	
	public WebElement checkPolicyRiskDescription() {
		return find(riskDescription);
	}
	
	public String getPolicyRiskDescription() {
		return getText(riskDescription);
	}
	
	public WebElement checkPolicyRiskIcon() {
		return find(riskIcon);
	}
	
	public WebElement checkRegistrationNumber() {
		return find(registrationNumber);
	}
	
	public String getRegistrationNumber() {
		return getText(registrationNumber);
	}
	

	public WebElement checkCoverTypeTextUsingId() {
		return find(coverTypeText);
	}
	public String getCoverTypeTextUsingId() {
		return getText(coverTypeText);
	}
	
	public WebElement checkPolicyDescription() {
		return find(policyDescription);
	}

	public WebElement checkPolicyDetailsBanner() {

		return find(policyDetailsBanner);
	}

	public WebElement checkPolicyDetailsScreenTitle(String copy) {

		return findByUIAutomator(copy, "text");
	}

	public WebElement checkPolicyNumberLabel() {
		return find(policyNumberLabel);
	}

	public WebElement checkPeriodOfCoverLabel() {

		return find(periodOfCoverLabel);
	}

	public WebElement checkPolicyBrandImage() {
		return find(policyBrandImage);
	}

	public String getPolicyDescriptionText() {

		return getText(policyDescription);
	}

	public String getPolicyNumberText() {

		return getText(policyNumberText);
	}

	public String getPolicyStartDate() {

		return getText(policyStartDate);
	}

	public String getpolicyStartYear() {

		return getText(policyStartYear);
	}

	public String getPolicyEndDate() {

		return getText(policyEndDate);
	}

	public String getPolicyEndYear() {

		return getText(policyEndYear);
	}

	public void tapNavigateBackButton() {

		tapElement(navigateBackButton);
	}

	public String getInstalmentFreqText() {

		return getText(instalmentFrequency);

	}

	public String getInstalmentAmt() {
		
		return scrollAndGetElementText(instalmentAmount, 1);
	}

	public String getInstalmentDebitDayLabel() {
		
		return scrollAndGetElementText(debitDayLabel, 1);
	}

	public String getPaymentMethodText() {

		return getText(paymentMethodLabel);
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

	public WebElement checkInsuredAmountText(String text) {
		return scrollToElementByText(text, 3);

	}

	public WebElement checkCoverTypeLabelText(String text) {
		return scrollToElementByText(text, 3);
	}

	public String getCoverTypeText() {
		
		return scrollAndGetElementText(coverType, 1);
	}

	public WebElement checkCoverTypeText(String text) {
		 return scrollToElementByText(text, 3);
	}

	public WebElement checkCoverPeriodLabelText(String text) {
		
		return scrollToElementByText(text, 1);
	}

	public String getCoverPeriodText() {
		
		return scrollAndGetElementText(coverPeriod, 1);
	}

	public String getPaymentMethodAccountText() {
		
		return scrollAndGetElementText(paymentMethodAccount, 1);
	}

	public WebElement scrollToRiskViewDetailsButton() {

		return scrollToElement(riskViewDetailsId, "id");

	}

	public void scrollToRisksTitle() {

		scrollToElement(risksTitle, "id");
	}

	public void scrollToRewardsSubtitle() {

		scrollToElement(rewardsSubtitleId, "id");
	}

	public WebElement scrollToOptionalCover() {

		return scrollToElement(optionalCoverTypeLabelId, "id");
	}

	public String getOptionalCoverDescription() {

		return getText(optionalCoverDescription);
	}

	public String getIncludedCoverDescription() {

		return getText(includedCoverDescription);
	}

	public String getOptionalCoverLabel() {

		return getText(optionalCoverLabel);
	}

	public void tapRiskViewDetails() {

		tapElement(riskViewDetails);
	}

	public void tapRenewNowButton() {

		tapElement(renewNowButton);
	}

	public String getIncludedCoverLabel() {
		
		return scrollAndGetElementText(includedCoverLabel, 1);
	}

	public String getDiscountsTitle() {

		return getText(discountsTitle);
	}

	public String getDiscounts() {

		return getText(discountsSubtitle);
	}

	public String getRewardsTitle() {

		return getText(rewardsTitle);
	}

	public String getRewardsSubtitle() {

		return getText(rewardsSubtitle);
	}

	public boolean isDiscountOrRewardsDisplayed() {

		WebElement element1 = find(discountsTitle, 2);
		WebElement element2 = find(rewardsTitle, 2);
		boolean status = false;

		for (int i = 0; i < 4; i++) {

			if (element1 == null || element2 == null) {

				swipeScreen("DOWN");

			} else {
				status = true;
				break;
			}

			element1 = find(discountsTitle, 2);
			element2 = find(rewardsTitle, 2);
		}

		return status;
	}

	public String getPolicyMaintenanceErrorMessageText() {

		return getText(policyMaintenanceErrorMessage);
	}

	public String getPolicyMaintenanceTitle() {

		return getText(policyMaintenanceTitle);
	}

	public String getPolicyActiveStatus() {

		return getText(policyActiveStatus);
	}

	public String getPolicyRenewalStatus() {

		return getText(policyrenewalStatus);
	}


}
