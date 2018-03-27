package pages.marketplace.auth.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class GetStartedPage extends BasePage {

	public GetStartedPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By getStartedPageTitle = By.id("au.com.suncorp.marketplace:id/headingText");
	private By backButton = By.id("au.com.suncorp.marketplace:id/backButton");
	private By setupNewAccountButton = By.id("au.com.suncorp.marketplace:id/newAccountButton");	
	private String registerWithSupportedGroupButtonsuffix = "au.com.suncorp.marketplace:id/";
	private By registerWithSupportedGroupButton;
	
	public WebElement checkGetStartedPageTitle() {
		return find(getStartedPageTitle);
	}
	
	public WebElement checkRegisterWithSupportedGroupButton(String supportedGroupName) {
		registerWithSupportedGroupButton = By.id(registerWithSupportedGroupButtonsuffix+supportedGroupName+"Button");
		return find(registerWithSupportedGroupButton);
	}
	
	public void tapBackButton() {
		tapElement(backButton);
	}
	
	public WebElement checkSetupNewAccountButton() {
		return find(setupNewAccountButton);
	}
	
	public void tapSetupNewAccount() {
		tapElement(setupNewAccountButton);
	}
	
	public void tapRegisterWithSupportedGroupButton(String supportedGroupName){
		registerWithSupportedGroupButton = By.id(registerWithSupportedGroupButtonsuffix+supportedGroupName+"Button");
		tapElement(registerWithSupportedGroupButton);
	}

}
