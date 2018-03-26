package pages.marketplace.auth.login;

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

	private By loadingIndicator = By.id("au.com.suncorp.marketplace:id/loadingIndicator");
	private By loginPageTitle = By.id("au.com.suncorp.marketplace:id/screenTitleText");
	private By emailField = By.id("au.com.suncorp.marketplace:id/emailAddressField");
	private By passwordField = By.id("au.com.suncorp.marketplace:id/passwordField");
	private By loginButton = By.id("au.com.suncorp.marketplace:id/loginButton");
	private By helpButton = By.id("au.com.suncorp.marketplace:id/login_help_text");
	private By backButton = By.id("au.com.suncorp.marketplace:id/backButton");
	private By noCredentialsButton = By.id("au.com.suncorp.marketplace:id/noCredentialsButton");

	
	//TODO Both have same id -> need to differentiate them
//	private By emailFieldError =  By.id("au.com.suncorp.marketplace:id/textinput_error");
	private By emailFieldError = By.xpath("//TextInputLayout[@text='Email']//android.widget.LinearLayout/android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
//	private By passwordFieldError = By.id("au.com.suncorp.marketplace:id/textinput_error");
	private By passwordFieldError = By.xpath("//TextInputLayout[@text='Password']//android.widget.LinearLayout/android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	
	//Error scenario
	private By errorSnackbarText = By.id("au.com.suncorp.marketplace:id/snackbar_text");
	private By errorSnackbarButton = By.id("au.com.suncorp.marketplace:id/snackbar_action");
	
	public WebElement checkLoginPageTitle(){
		return find(loginPageTitle,20);
	}
	
	public WebElement checkNoCredentialsButton() {
		return find(noCredentialsButton);
	}
	
	public void tapNoCredentialsButton() {
		tapElement(noCredentialsButton);
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
		isKeyboardPresent();
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
		return find(emailFieldError,30);
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
	
	public String getPasswordFieldValue() {
		return getText(passwordField);
	}
	
	public void relaunchApp(int time, String appName) {
		selectSuncorpApp(time, appName);
	}
	
	public WebElement checkSnackbarText() {
		return find(errorSnackbarText);
	}
	
	public String getSnackbarTextValue () {
		return getText(errorSnackbarText);
	}
	
	public WebElement checkSnackbarButton() {
		return find(errorSnackbarButton, 30);
	}
	
	public void tapSnackbarOkButton() {
		tapElement(errorSnackbarButton);
	}
	
	public WebElement checkLoadingIndicator() {
		return find(loadingIndicator, 30);
	}
}
