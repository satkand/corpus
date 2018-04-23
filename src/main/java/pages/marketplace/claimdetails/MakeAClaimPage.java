package pages.marketplace.claimdetails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class MakeAClaimPage extends BasePage {

	public MakeAClaimPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By policyDescriptionTitle = By.id("au.com.suncorp.marketplace:id/assetTitle");
	private By assetDescription = By.id("au.com.suncorp.marketplace:id/assetDescription");
	private By incidentDateLabel = By.id("au.com.suncorp.marketplace:id/incidentDateTitle");
	private By incidentDateField = By.id("au.com.suncorp.marketplace:id/incidentDateField");
	private By startClaimButton = By.id("au.com.suncorp.marketplace:id/startClaim");
	private By navigateBackButton = MobileBy.AccessibilityId("Navigate up");
	private By registrationNumber = By.id("au.com.suncorp.marketplace:id/registrationNumber");
	public String getPolicyDescriptionTitle() {

		return getText(policyDescriptionTitle);
	}

	public String getAssetDescriptionText() {

		return getText(assetDescription);
	}
	
	public String getRegistrationNumberText() {

		return getText(registrationNumber);
	}

	public WebElement checkIncidentDateField() {

		return find(incidentDateField);
	}

	public String getIncidentDateFieldLabel() {

		return getText(incidentDateLabel);
	}

	public String getStartClaimButtonText() {

		return getText(startClaimButton);
	}

	public void tapStartClaimButton() {

		tapElement(startClaimButton);
	}
	public void tapNavigateBackButton() {

		tapElement(navigateBackButton);
	}
	
}
