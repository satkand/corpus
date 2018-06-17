package pages.marketplace.auth.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class LoginAuthPage extends BasePage{

	private By userNameWelcomeScreen = By.id("au.com.suncorp.marketplace:id/reauthUserNameText");
	private By loginButton = By.id("au.com.suncorp.marketplace:id/loginButton");
	private By changeAccountButton = By.id("au.com.suncorp.marketplace:id/changeUserButton");
	
	//Reauth with password
//	private By userImagePasswordReauth = By.id("au.com.suncorp.marketplace:id/profilePicture");
//	private By userNamePasswordReauth = By.id("au.com.suncorp.marketplace:id/userNameText");
	private By passwordReauthField = By.id("au.com.suncorp.marketplace:id/passwordField");
	private By forgotPasswordReauthButton = By.id("au.com.suncorp.marketplace:id/forgotPasswordButton");
	private By backButtonReauthPassword = By.id("au.com.suncorp.marketplace:id/backButton");
	private By reauthPasswordLoginBtn = By.id("au.com.suncorp.marketplace:id/loginButton");
//	private By reauthPasswordLogin = By.id("au.com.suncorp.marketplace:id/loginButton");
	private By passwordInlineError = By.id("au.com.suncorp.marketplace:id/textinput_error");
	
	public LoginAuthPage(AppiumDriver driver) {
		super(driver);
	}

	public WebElement checkChangeAccountButton(){
		return find(changeAccountButton);
	}
	
	public void tapChangeAccountButton() {
		tapElement(changeAccountButton);
	}
	
	public WebElement checkReloginButton(){
		return find(loginButton);
	}
	
	public void tapReloginButton() {
		tapElement(loginButton);
	}
	
	public WebElement checkUserName() {
		return find(userNameWelcomeScreen);
	}
	
	public WebElement checkPasswordReauthField() {
		return find(passwordReauthField);
	}
	
	public WebElement checkForgotPasswordReauthButton() {
		return find(forgotPasswordReauthButton);
	}
	
	public void relaunchApp(int time, String appName) {
		selectSuncorpApp(time, appName);
	}
	
	public void tapBackButton() {
		tapElement(backButtonReauthPassword);
	}
	
	public void enterPassword(String password) {
		typeValue(password, passwordReauthField);
	}
	
	public String getPasswordFieldVal() {
		return getText(passwordReauthField);
	}
	
	public Boolean getPasswordFieldMaskedVal(String maskedValue) {
		Boolean status;
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));
		if (osVersion >= 6.0) {
			status = getText(passwordReauthField).equals(maskedValue);
		}
		else { 
			status = getText(passwordReauthField).equals("");
		}
		
		return status;
	}
	
	public void tapPasswordField() {
		tapElement(passwordReauthField);
	}
	
	public WebElement checkPasswordInlineError() {
		return find(passwordInlineError);
	}
	
	public String getPasswordInlineErrorVal() {
		return getText(passwordInlineError);
	}
	
	public void tapReauthPasswordLoginBtn() {
		tapElement(reauthPasswordLoginBtn);
	}
	
	public void restartApp() {
		closeAndLaunchApp();
	}
}
