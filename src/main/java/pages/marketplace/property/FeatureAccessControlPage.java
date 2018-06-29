package pages.marketplace.property;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class FeatureAccessControlPage extends BasePage{

	public FeatureAccessControlPage(AppiumDriver driver) {
		super(driver);
	}

//Update below IDs for Android devices when the API is up
	private By closeButton = MobileBy.AccessibilityId("Cancel");
	private By verificationTitleLabel = By.id("au.com.suncorp.marketplace:id/titleHeading");
	private By verificationTitleImage = By.id("au.com.suncorp.marketplace:id/emailIcon");
	private By verificationMessageLabel = By.id("au.com.suncorp.marketplace:id/promptTop");
	private By verificationLinkLabel = By.id("au.com.suncorp.marketplace:id/promptBottom");
	private By verificationemailLabel = By.id("au.com.suncorp.marketplace:id/userEmailAddress");
	private By verificationButton = By.id("au.com.suncorp.marketplace:id/sendEmailVerificationRequestButton");
	private By emailverificationRefreshButton = By.id("au.com.suncorp.marketplace:id/checkVerificationStatusButton");
	private By successMessage = By.id("EmailVerificationMessageLabel");//TODO : API returns an error when tapping on Send Verification button. this Element ID should be updated for Android when it is working
	private By successDismissButton = By.id("EmailVerificationSendVerificationButton");//TODO : API returns an error when tapping on Send Verification button. this Element ID should be updated for Android when it is working
	private By successMessageTitle = By.id("EmailVerificationTitleLabel");//TODO : API returns an error when tapping on Send Verification button. this Element ID should be updated for Android when it is working
	private By loadingIndicator = By.id("Sending verification");//TODO : API returns an error when tapping on Send Verification button. this Element ID should be updated for Android when it is working
	
	public void waitForLoadingIndicatorToDisappear() {
		waitForElementToDisappear(loadingIndicator,20);
	}
	
	public WebElement checkemailverificationRefreshButton() {
		return find(emailverificationRefreshButton);
	}
	
	public WebElement checksuccessMessageTitle() {
		return find(successMessageTitle);
	}
	
	public String getSuccessMessageTitle() {
		return getText(successMessageTitle);
	}
	
	
	public WebElement checkcloseButton() {
		return find(closeButton);
	}
	
	public void tapcloseButton() {
		tapElement(closeButton);
	}
	
	public WebElement checkverificationButton() {
		return find(verificationButton);
	}
	
	public void tapverificationButton() {
		tapElement(verificationButton);
	}
	
	public WebElement checkverificationTitleLabel() {
		return find(verificationTitleLabel);
	}
	
	public String getverificationTitleLabel() {
		return getText(verificationTitleLabel);
	}
	
	public WebElement checkverificationTitleImage() {
		return find(verificationTitleImage);
	}
	
	public WebElement checkverificationMessageLabel() {
		return find(verificationMessageLabel);
	}
	
	public String getverificationMessageLabel() {
		return getText(verificationMessageLabel);
	}
	
	public WebElement checkverificationLinkLabel() {
		return find(verificationLinkLabel);
	}
	
	public String getverificationLinkLabel() {
		return getText(verificationLinkLabel);
	}
	
	public WebElement checkverificationemailLabel() {
		return find(verificationemailLabel);
	}
	
	public String getverificationemailLabel() {
		return getText(verificationemailLabel);
	}
	
	public WebElement checkSuccessMeassage() {
		return find(successMessage);
	}
	
	public WebElement checkSuccessDismissButton() {
		return find(successDismissButton);
	}
	
	public void tapSuccessDismissButtonButton() {
		tapElement(successDismissButton);
	}
	
}
