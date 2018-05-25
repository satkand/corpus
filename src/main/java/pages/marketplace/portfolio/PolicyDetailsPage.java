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
	private String policyEndDateId = "au.com.suncorp.marketplace:id/policyEndDateText";
	private By policyEndYear = By.id("au.com.suncorp.marketplace:id/policyEndYearText");
	private String policyEndYearId = "au.com.suncorp.marketplace:id/policyEndYearText";
	private By policyBrandImage = By.id("au.com.suncorp.marketplace:id/policyBrandImage");
	private By navigateBackButton = MobileBy.AccessibilityId("Navigate up");
	//if above navgiate button don't have accessibility ID use this
	private By navigateUpBtn = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
	private By debitDayLabel = By.id("au.com.suncorp.marketplace:id/debitDayLabel");
	private By instalmentFrequency = By.id("au.com.suncorp.marketplace:id/instalmentFrequency");
	private String instalmentFrequencyId = "au.com.suncorp.marketplace:id/instalmentFrequency";
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
	//private By risksTitle = By.id("au.com.suncorp.marketplace:id/risksTitle");
	private By risksTitle = By.id("au.com.suncorp.marketplace:id/riskDescription");
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
	private By riskViewOnlyDetails = By.id("au.com.suncorp.marketplace:id/riskViewOnlyDetails");
	private By discountsTitle = By.id("au.com.suncorp.marketplace:id/discountsTitle");
	private By discountsSubtitle = By.id("au.com.suncorp.marketplace:id/discountsSubtitle");
	private By rewardsTitle = By.id("au.com.suncorp.marketplace:id/rewardsTitle");
	private By policyMaintenanceTitle = By.id("au.com.suncorp.marketplace:id/policyUnderPolicyMaintenanceTitle");
	private By policyMaintenanceErrorMessage = By
			.id("au.com.suncorp.marketplace:id/policyUnderPolicyMaintenanceSubtitle");
	private By policyActiveStatus = By.id("au.com.suncorp.marketplace:id/policyActiveStatusText");
	private By policyrenewalStatus = By.id("au.com.suncorp.marketplace:id/renewalStatusText");
	private By renewNowButton = By.id("au.com.suncorp.marketplace:id/renewNowButton");
	private String optionalCoverTypeLabelId = "au.com.suncorp.marketplace:id/optionalCoverType";
	private String riskViewDetailsId = "au.com.suncorp.marketplace:id/riskViewDetails";
	private String riskViewOnlyDetailsId = "au.com.suncorp.marketplace:id/riskViewOnlyDetails";
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
	
	private By discountsAndBenefitsTitle = By.id("au.com.suncorp.marketplace:id/discountsAndBenefitsTitle");
	private String discountsAndBenefitsTitleId = "au.com.suncorp.marketplace:id/discountsAndBenefitsTitle";
	private By coverPeriodLabel = By.id("au.com.suncorp.marketplace:id/coverPeriodLabel");
	private By coverPeriodStart = By.id("au.com.suncorp.marketplace:id/coverPeriodStart");
	private By coverPeriodEnd = By.id("au.com.suncorp.marketplace:id/coverPeriodEnd");
	private String coverPeriodEndId = "au.com.suncorp.marketplace:id/coverPeriodEnd";
	
	public WebElement checkRiskViewDetails() {
		return find(riskViewDetails);
	}
	public WebElement checkCoverPeriodLabel() {
		return find(coverPeriodLabel);
	}
	
	public String getCoverPeriodLabel() {
		return getText(coverPeriodLabel);
	}
	
	public WebElement checkCoverPeriodStart() {
		return find(coverPeriodStart);
	}
	
	public String getCoverPeriodStart() {
		return getText(coverPeriodStart);
	}
	
	public WebElement checkCoverPeriodEnd() {
		return find(coverPeriodEnd,3);
	}
	
	public String getCoverPeriodEnd() {
		return getText(coverPeriodEnd);
	}
	
	public void scrollToCoverPeriod() {
			if (getScreenHeight()>1920) {
				scrollToElement(coverPeriodEndId, "id");
			}
			else {
				scrollToElement(coverPeriodEnd);
			}
		
	}
	
	public WebElement checkDiscountsAndBenefitsTitle() {
		
		return find(discountsAndBenefitsTitle,3);
	}
	
	public void scrollToDiscountsAndBenefits() {
		if (getScreenHeight()>1920) {
			
			scrollToElement(discountsAndBenefitsTitleId, "id");
		}
		else {
			scrollToElement(discountsAndBenefitsTitle);
		}
		
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
	
	public WebElement checkPolicyStartYear() {

		return find(policyStartYear);
	}

	public String getPolicyEndDate() {

		return getText(policyEndDate);
	}
	
	public WebElement checkPolicyEndDate() {

		return find(policyEndDate);
	}
	
	public void scrollToPolicyEndDate() {
		if (getScreenHeight()>1920) {
			scrollToElement(policyEndDateId, "id");
		}
		else {
			scrollToElement(policyEndDate);
		}
	}
	
	public void scrollToPolicyEndYear() {
		if (getScreenHeight()>1920) {
			scrollToElement(policyEndYearId, "id");
		}
		else {
			scrollToElement(policyEndYear);
		}
	}
	
	public WebElement checkPolicyEndYear() {

		return find(policyEndYear);
	}
	
	public String getPolicyEndYear() {

		return getText(policyEndYear);
	}

	public void tapNavigateBackButton() {
		if (find(navigateBackButton,30)==null) {
			tapElement(navigateBackButton);
		}
		else {
			WebElement element = find(navigateUpBtn,30);
			tapElement(element);
		}
		
	}
	
	public String getInstalmentFreqText() {

		return getText(instalmentFrequency);

	}
	
	public WebElement checkInstallmentFreuency() {
		return find(instalmentFrequency);
	}
	
	public void scrollToInstallmentFrequncy() {
		if (getScreenHeight()>1920) {
			scrollToElement(instalmentFrequencyId, "id");
		}
		else {
			scrollToElement(instalmentFrequency);
		}
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

	public void scrollToRiskViewDetailsButton() {
			if (getScreenHeight()>1920) {
				scrollToElement(riskViewDetailsId, "id");
			}
			else {
				scrollToElement(riskViewDetails);
			}
		
	}
	
	public WebElement checkRiskViewOnlyButton() {
		return find(riskViewOnlyDetails);
	}
	public void scrollToRiskViewOnlyButton() {
		if (getScreenHeight()>1920) {
			scrollToElement(riskViewOnlyDetailsId, "id");
		}
		else {
			scrollToElement(riskViewOnlyDetails);
		} 
	}

	public void scrollToRisksTitle() {

		scrollToElement(risksTitle, "id");
	}

	public void scrollToRewardsSubtitle() {
		if (getScreenHeight()>1920) {
			scrollToElement(rewardsSubtitleId, "id",25);
		}
		else {
			scrollToElement(rewardsSubtitle);
		} 
		
	}
	
	public void scrollToDiscountsTitle() {

		scrollToElement(discountsTitle, "id");
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
	
	public void tapRiskViewOnlyDetails() {

		tapElement(riskViewOnlyDetails);
	}

	public void tapRenewNowButton() {

		tapElement(renewNowButton);
	}

	public String getIncludedCoverLabel() {
		
		return scrollAndGetElementText(includedCoverLabel, 1);
	}
	
	public WebElement checkDiscountsTitle() {
		return find(discountsTitle,3);
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
