package pages.marketplace.auth.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class TermsAndConditionsPage extends BasePage {

	public TermsAndConditionsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By acceptButton = By.id("au.com.suncorp.marketplace:id/acceptButton");
	
	public WebElement checkAcceptButton() {
		return find(acceptButton);
	}
	
	public void tapAcceptButton() {
		tapElement(acceptButton);
	}

}
