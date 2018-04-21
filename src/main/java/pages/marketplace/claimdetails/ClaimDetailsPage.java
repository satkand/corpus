package pages.marketplace.claimdetails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class ClaimDetailsPage extends BasePage {

	public ClaimDetailsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By brandIcon = By.id("au.com.suncorp.marketplace:id/brandIcon");
	private By productType = By.id("au.com.suncorp.marketplace:id/productTypeLabel");
	private By claimNumberView = By.id("au.com.suncorp.marketplace:id/claimNumberLabel");
	private By homeRiskAddrLabel = By.id("au.com.suncorp.marketplace:id/riskTitle");
	private By homeRiskAddrPrimaryDesc = By.id("au.com.suncorp.marketplace:id/riskPrimaryDescription");
	private By homeRiskAddrSecondaryDesc = By.id("au.com.suncorp.marketplace:id/riskSecondaryDescription");
	private By incidentLossCauseLabel = By.id("au.com.suncorp.marketplace:id/incidentLossCauseTitle");
	private By incidentLossCauseValue = By.id("au.com.suncorp.marketplace:id/incidentLossCause");
	private By incidentSubLossCauseLabel = By.id("au.com.suncorp.marketplace:id/incidentSubLossCauseTitle");
	private By incidentSubLossCauseValue = By.id("au.com.suncorp.marketplace:id/incidentSubLossCause");
	private By eventDateLabel = By.id("au.com.suncorp.marketplace:id/eventDateTitle");
	private By eventDateValue = By.id("au.com.suncorp.marketplace:id/eventDateLabel");
	private By navigateBackButton = MobileBy.AccessibilityId("Navigate up");
	private By claimStageValue = By.id("au.com.suncorp.marketplace:id/claimStageTitle");
	private By claimStageLabel = By.id("au.com.suncorp.marketplace:id/claimStageLabel");
	private By claimStageOne = By.id("au.com.suncorp.marketplace:id/claimStageOne");
	private By claimStageTwo = By.id("au.com.suncorp.marketplace:id/claimStageTwo");
	private By claimStageThree = By.id("au.com.suncorp.marketplace:id/claimStageThree");
	private By claimStageFour = By.id("au.com.suncorp.marketplace:id/claimStageFour");
	private By excessTitle = By.id("au.com.suncorp.marketplace:id/excessTitle");
	private By excessAmount = By.id("au.com.suncorp.marketplace:id/excessAmount");
	private By excessPaidTitle = By.id("au.com.suncorp.marketplace:id/excessPaidTitle");
	private By excessPaidAmount = By.id("au.com.suncorp.marketplace:id/excessPaid");
	private By partialExcessTotalTitle = By.id("au.com.suncorp.marketplace:id/partialExcessTotalTitle");
	private By partialExcessTotalAmount = By.id("au.com.suncorp.marketplace:id/partialExcessTotal");
	private By paymentReferenceNumber = By.id("au.com.suncorp.marketplace:id/paymentReferenceNumber");
	private By paymentReferenceNumberLabel = By.id("au.com.suncorp.marketplace:id/paymentReferenceNumberTitle");
	private By paidButton = By.id("au.com.suncorp.marketplace:id/payNowButton");
	private String eventDateLabelId = "au.com.suncorp.marketplace:id/eventDateTitle";
	
	
	public WebElement checkBrandIcon() {

		return find(brandIcon, 5);
	}

	public WebElement checkProductType() {

		return find(productType, 5);
	}

	public WebElement claimNumberViewl() {

		return find(claimNumberView, 5);

	}

	public WebElement checkHomeRiskAddrLabel() {

		return find(homeRiskAddrLabel, 5);
	}

	public WebElement checkHomeRiskAddrPrimaryDesc() {

		return find(homeRiskAddrPrimaryDesc, 5);
	}

	public WebElement checkHomeRiskAddrSecondaryDescDesc() {

		return find(homeRiskAddrSecondaryDesc, 5);
	}

	public String getClaimNumberLabelText() {

		return getText(claimNumberView).split(":")[0].trim();

	}

	public String getProductTypeText() {

		return getText(productType);
	}

	public String getClaimNumberText() {

		return getText(claimNumberView).split(":")[1].trim();

	}

	public String getHomeRiskAddrLabelText() {

		return getText(homeRiskAddrLabel);

	}

	public String getHomeRiskAddrPrimaryDescText() {

		return getText(homeRiskAddrPrimaryDesc);

	}

	public String getHomeRiskAddrSecondaryDescText() {

		return getText(homeRiskAddrSecondaryDesc);

	}

	public String getIncidentLossCauseLabel() {
		
		return scrollAndGetElementText(incidentLossCauseLabel,3);

	}

	public String getIncidentLossCauseValue() {
		
		return scrollAndGetElementText(incidentLossCauseValue,1);
	}

	public String getIncidentSubLossCauseLabel() {
		
		return scrollAndGetElementText(incidentSubLossCauseLabel,1);

	}

	public String getIncidentSubLossCauseValue() {
		
		return scrollAndGetElementText(incidentSubLossCauseValue,1);

	}

	public String getEventDateLabel() {
		
		return scrollAndGetElementText(eventDateLabel,1);

	}
	
	public void scrollToEventDateLabel() {
		
		scrollToElement(eventDateLabelId, "id");
		
	}

	public String getEventDateValue() {
		
		return scrollAndGetElementText(eventDateValue,1);

	}

	public void tapNavigateBackButton() {

		tapElement(navigateBackButton);
	}

	public String claimStageValue() {
		
		return scrollAndGetElementText(claimStageValue,1);

	}

	public String claimStageLabel() {
		
		return scrollAndGetElementText(claimStageLabel,3);

	}
	
	public boolean isClaimStageOneEnabled() {

		return isEnabled(claimStageOne);
	}
	
	public boolean isClaimStageTwoEnabled() {

		return isEnabled(claimStageTwo);
	}
	
	public boolean isClaimStageThreeEnabled() {

		return isEnabled(claimStageThree);
	}
	
	public boolean isClaimStageFourEnabled() {

		return isEnabled(claimStageFour);
	}
	
	public void scrollToClaimStageLabel() {
		
		scrollToElement(claimStageLabel);
		
		
	}
	
	public String getYourTotalAcessAmount() {

		return getText(excessAmount);

	}
	
	public String getExcessTitle() {

		return getText(excessTitle);

	}
	
	public String getExcessPaidTitle() {

		return getText(excessPaidTitle);

	}
	
	public String getExcessPaidAmount() {

		return getText(excessPaidAmount);

	}
	public String getPartialExcessTotalTitle() {

		return getText(partialExcessTotalTitle);

	}
	
	public String getPartialExcessTotalAmount() {

		return getText(partialExcessTotalAmount);

	}
	public String getPaymentReferenceNumber() {

		return getText(paymentReferenceNumber);

	}
	public String getPaymentReferenceNumberLabel() {

		return getText(paymentReferenceNumberLabel);

	}
	public String getPaidButtonText() {

		return getText(paidButton);

	}
	
	public WebElement checkNextActionsLabel(String text) {

		return findByUIAutomator(text, "text");
	}
	
	public void tapNextActionsLabel(String text) {

		tapElement(findByUIAutomator(text, "text"));
	}
	
	public WebElement checkClaimDetailsTitle(String text) {

		return findByUIAutomator(text, "text");
	}
	

}
