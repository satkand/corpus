package pages.marketplace.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class WelcomePage extends BasePage {

	private By welcomeSuncorpImage = By.id("au.com.suncorp.marketplace:id/splashImage");
	private By registerButton = By.id("au.com.suncorp.marketplace:id/registerButton");
	private By loginButton = By.id("au.com.suncorp.marketplace:id/loginButton");
	private By guestAccessButton = By.id("au.com.suncorp.marketplace:id/guestAccessButton");
	
	//TODO -> id needs to be added
	private By needHelpButton = By.xpath("//android.widget.TextView[@text='Need help?']");
	
	
	public WelcomePage(@SuppressWarnings("rawtypes") AppiumDriver driver) {
		super(driver);
	}
	
	public WebElement checkWelcomeSuncorpImage(){
		return find(welcomeSuncorpImage);
	}
	
	public WebElement checkRegisterButton(){
		return find(registerButton);
	}
	
	public void tapRegisterButton(){
		tapElement(registerButton);
	}
	
	public WebElement checkLoginButton(){
		return find(loginButton);
	}
	
	public void tapLoginButton(){
		checkLoginButton();
		tapElement(loginButton);
	}
	
	public WebElement checkGuestAccessButton(){
		return find(guestAccessButton);
	}
	
	public void tapGuestAccessButton(){
		find(guestAccessButton, 30);
		tapElement(guestAccessButton);
	}
	
	public WebElement checkNeedHelpButton(){
		return find(needHelpButton);
	}
}
