package pages.marketplace.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class LoginPage extends BasePage{
	
	public LoginPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By loginPageTitle = By.id("au.com.suncorp.marketplace:id/screenTitleText");
	private By emailField = By.id("au.com.suncorp.marketplace:id/emailAddressField");
	private By passwordField = By.id("au.com.suncorp.marketplace:id/passwordField");
	private By loginButton = By.id("au.com.suncorp.marketplace:id/loginButton");
	private By helpButton = By.id("au.com.suncorp.marketplace:id/login_help_text");
	private By backButton = By.id("au.com.suncorp.marketplace:id/backButton");
	
	//TODO Both have same id -> need to differentiate them
	private By emailFieldError =  By.id("au.com.suncorp.marketplace:id/textinput_error");
	private By passwordFieldError = By.id("au.com.suncorp.marketplace:id/textinput_error");
	
	/*
	 -> 	Log in
	 -> I need help logging in
	 -> This field is required
	*/
	
	public WebElement checkLoginPageTitle(){
		return find(loginPageTitle,20);
	}
	
	public String getLoginPageTitle(){
		return getText(loginPageTitle);
	}

	public WebElement checkEmailField(){
		return find(emailField);
	}
	
	public void tapEmailField() {
		tapElement(emailField);
	}
	
	public void enterEmail(String emailValue) {
		find(emailField,30);
		typeValue(emailValue, emailField);
	}
	
	public WebElement checkPasswordField(){
		return find(passwordField);
	}
	
	public void tapPasswordField() {
		tapElement(passwordField);
	}
	
	public void enterPassword(String pwdValue) {
		typeValue(pwdValue, passwordField);
	}
	
	public void enterLoginCredentials(String email, String pwd) {
		enterEmail(email);
		enterPassword(pwd);
	}
	
	public WebElement checkLoginButton(){
		return find(loginButton);
	}
	
	public void tapLoginButton(){
		tapElement(loginButton);
	}
	
	public boolean isLoginButtonEnabled(){
		return isEnabled(loginButton);
	}
	
	public WebElement checkHelpButton(){
		return find(helpButton);
	}
	
	public WebElement checkBackButton(){
		return find(backButton);
	}
	
	public void tapBackButton(){
		tapElement(backButton);
	}
		
	public WebElement checkEmailFieldError(){
		return find(emailFieldError);
	}
	
	public String getEmailFieldErrorValue() {
		return getText(emailFieldError);
	}
	
	public WebElement checkPasswordFieldError(){
		return find(passwordFieldError);
	}
	
	public String getPasswordFieldErrorValue() {
		return getText(passwordFieldError);
	}
}
