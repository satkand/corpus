package pages.marketplace.auth.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class TermsAndConditionsPage extends BasePage {

	public TermsAndConditionsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By termsAndConditionsTitle = By.id("au.com.suncorp.marketplace:id/registrationTermsAndConditionsTitle");
	private By loginTermsAndConditionsTitle = By.id("au.com.suncorp.marketplace:id/loginTermsAndConditionsTitle");
	private By acceptButton = By.id("au.com.suncorp.marketplace:id/acceptButton");
	private By cancelButton = By.id("au.com.suncorp.marketplace:id/cancelButton");
	//private By cancelButton = MobileBy.AccessibilityId("Cancel");
	
	public WebElement checkTermsAndConditionsTitle() {
		return find(termsAndConditionsTitle,45);
	}
	
	public WebElement checkAcceptButton() {
		return find(acceptButton,2);

	}
	
	public WebElement checkCancelButton() {
		return find(cancelButton,2);

	}
	
	public void tapAcceptButton() {
		tapElement(acceptButton);
	}
	
	public void tapCancelButton() {
		tapElement(cancelButton);
	}
	
	public WebElement checkLoginTermsAndConditionsTitle() {
		return find(loginTermsAndConditionsTitle);
	}
}
