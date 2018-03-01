package pages.marketplace.auth.pin;

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

	private By userName = By.id("au.com.suncorp.marketplace:id/enterPinUserNameText");
	private By backButton = By.id("au.com.suncorp.marketplace:id/reauthCancelButton");
	private By forgottenPINButton = By.id("au.com.suncorp.marketplace:id/customKeypadForgotPinButton");
	private By pinField = By.id("au.com.suncorp.marketplace:id/pinImage1");
	
	public WebElement checkUserName() {
		return find(userName);
	}
	
	public WebElement checkPinField() {
		return find(pinField);
	}
	
	public WebElement checkBackButton() {
		return find(backButton);
	}
	
	public void tapBackButton() {
		tapElement(backButton);
	}
	
	public void tapForgottenPINButton() {
		tapElement(forgottenPINButton);
	}

}
