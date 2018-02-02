package pages.marketplace.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class LoginReauthPage extends BasePage{

	
	private By reloginButton = By.id("au.com.suncorp.marketplace:id/loginButton");
	
	public LoginReauthPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement checkReloginButton(){
		return find(reloginButton);
	}
	
	public void tapReloginButton() {
		tapElement(reloginButton);
	}
}
