package pages.marketplace.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class DummyPageWithLinks extends BasePage {
	public DummyPageWithLinks(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//TODO Remove this page
	private By pinSetupOption = By.id("au.com.suncorp.marketplace:id/tempPinSetupNavigation");
	private By loginAsButton = By.id("au.com.suncorp.marketplace:id/loginButton");
	
	
	public WebElement checkPinSetupOption() {
		return find(pinSetupOption,30);
	}
	
	public void tapPinSetupOption() {
		find(pinSetupOption,30);
		tapElement(pinSetupOption);
	}
	
	public void tapLoginAsButton() {
		//find(loginAsButton,30);
		tapElement(loginAsButton);
	}
	
}
