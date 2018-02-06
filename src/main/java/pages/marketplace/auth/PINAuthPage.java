package pages.marketplace.auth;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class PINAuthPage extends BasePage {
	
	public PINAuthPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By forgottenPINButton = By.id("au.com.suncorp.marketplace:id/customKeypadForgotPinButton");
	
	public void tapForgottenPINButton() {
		tapElement(forgottenPINButton);
	}
	
}
