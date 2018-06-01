package pages.marketplace.auth.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class LoginPage extends BasePage{
	
	public LoginPage(AppiumDriver driver) {
		super(driver);
	}

	private By loadingIndicator = By.id("au.com.suncorp.marketplace:id/loadingIndicator");
	private By loginPageTitle = By.id("au.com.suncorp.marketplace:id/screenTitleText");
	private By emailField = By.id("au.com.suncorp.marketplace:id/emailAddressField");
	private By passwordField = By.id("au.com.suncorp.marketplace:id/passwordField");
	private By loginButton = By.id("au.com.suncorp.marketplace:id/loginButton");
	private By forgotPasswordButton = By.id("au.com.suncorp.marketplace:id/forgotPasswordButton");
	private By backButton = MobileBy.AccessibilityId("Back");
	private By noCredentialsButton = By.id("au.com.suncorp.marketplace:id/noCredentialsButton");

	
	//TODO Both have same id -> need to differentiate them
	private By emailFieldError = By.xpath("//TextInputLayout[@text='Email']//android.widget.LinearLayout/android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By passwordFieldError = By.xpath("//TextInputLayout[@text='Password']//android.widget.LinearLayout/android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	//Different android class on older devices
	private By emailFieldErrorOldDevice = By.xpath("//android.widget.LinearLayout[@text='Email']//android.widget.LinearLayout/android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By passwordFieldErrorOldDevice = By.xpath("//android.widget.LinearLayout[@text='Password']//android.widget.LinearLayout/android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	
	//Error scenario
	private By errorSnackbarText = By.id("au.com.suncorp.marketplace:id/snackbar_text");
	private By errorSnackbarButton = By.id("au.com.suncorp.marketplace:id/snackbar_action");
	
	//Reset Password
	private By resetPasswordTitle = By.id("au.com.suncorp.marketplace:id/resetPasswordTitleText");
	private By resetPasswordDescription = By.id("au.com.suncorp.marketplace:id/resetPasswordSubtitleText");
	private By resetPasswordEmailField = By.id("au.com.suncorp.marketplace:id/emailAddressField");
	private By resetLinkButton = By.id("au.com.suncorp.marketplace:id/sendResetLinkButton");
	private By resetPasswordBackButton = MobileBy.AccessibilityId("Back");
	private By resetPasswordEmailFieldError = By.id("au.com.suncorp.marketplace:id/textinput_error");
	private By resetPasswordSuccessSnackbar = By.id("au.com.suncorp.marketplace:id/snackbar_text");
	private By resetPasswordSuccessSnackbarButton = By.id("au.com.suncorp.marketplace:id/snackbar_action");
	
	private By emailPanel = By.id("android:id/titlePanel_default");
	private By emailPanelOptions = By.id("android:id/icon");
	
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

	
	public WebElement checkForgotPasswordButton(){
		return find(forgotPasswordButton);
	}
	
	public WebElement checkBackButton(){
		return find(backButton);
	}
	
	public void tapBackButton(){
		tapElement(backButton);
	}
		
	public WebElement checkEmailFieldError(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 7.0) {
			return find(emailFieldError,30);
		}
		else { 
			return find(emailFieldErrorOldDevice,30);
		}
	}
	
	public String getEmailFieldErrorValue() {
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 7.0) {
			return getText(emailFieldError);
		}
		else { 
			return getText(emailFieldErrorOldDevice);
		}	
	}
	
	public WebElement checkPasswordFieldError(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 7.0) {
			return find(passwordFieldError,30);
		}
		else { 
			return find(passwordFieldErrorOldDevice,30);
		}
	}
	
	public String getPasswordFieldErrorValue() {
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 7.0) {
			return getText(passwordFieldError);
		}
		else { 
			return getText(passwordFieldErrorOldDevice);
		}
	}
	
	public Boolean getPasswordFieldMaskedVal(String maskedValue) {
		Boolean status;
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));
		if (osVersion >= 7.0) {
			status = getText(passwordField).equals(maskedValue);
		}
		else { 
			status = getText(passwordField).equals("");
		}
		
		return status;
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
	
	public void waitForLoadingIndicatorToDismiss() {
		waitForElementToDisappear(loadingIndicator, 30);;
	}
	
	public String getEmailFieldData() {
		return getText(emailField);
	}
	
	public void tapForgotPassword() {
		tapElement(forgotPasswordButton);
	}
	
	public WebElement checkResetPasswordTitle() {
		return find(resetPasswordTitle);
	}
	
	public String getResetPasswordTitle() {
		return getText(resetPasswordTitle);
	}
	
	public WebElement checkResetPasswordDescription() {
		return find(resetPasswordDescription);
	}
	
	public String getResetPasswordDescription() {
		return getText(resetPasswordDescription);
	}
	
	public WebElement checkResetPasswordEmailField() {
		return find(resetPasswordEmailField,5);
	}
	
	public void enterResetPasswordEmail(String email) {
		typeValue(email, resetPasswordEmailField);
	}
	
	public String getResetPasswordEmailValue() {
		return getText(resetPasswordEmailField);
	}
	
	public void tapResetPasswordEmailField() {
		tapElement(resetPasswordEmailField);
	}
	
	public WebElement checkResetPasswordEmailError() {
		return find(resetPasswordEmailFieldError);
	}
	
	public String getResetPasswordEmailErrorVal() {
		return getText(resetPasswordEmailFieldError);
	}
	
	public WebElement checkResetLinkButton() {
		return find(resetLinkButton);
	}
	
	public void tapResetLinkButton() {
		tapElement(resetLinkButton);
	}
	
	public void tapResetPasswordBackButton() {
		tapElement(resetPasswordBackButton);
	}
	
	public WebElement checkResetPasswordSuccessSnackbar() {
		return find(resetPasswordSuccessSnackbar, 5);
	}
	
	public String getResetPasswordSuccessSnackbarText() {
		return getText(resetPasswordSuccessSnackbar);
	}
	
	public String getResetPasswordSuccessSnackbarBtn() {
		return getText(resetPasswordSuccessSnackbarButton);
	}
	
	public void tapResetPasswordSuccessSnackbarButton() {
		tapElement(resetPasswordSuccessSnackbarButton);
	}
	
	public WebElement checkEmailOptionPanel() {
		return find(emailPanel);
	}
	
	public WebElement checkFirstEmailPanelOption () {
		 WebElement firstOption = finds(emailPanelOptions).get(0);
		 return firstOption;
	}
	
	public void tapFirstEmailOption() {
		 WebElement firstOption = finds(emailPanelOptions).get(0);
		 tapElement(firstOption);
	}
	
	public String getSuncorpActivityValue(){
		return getActivityValue();
	}
	
	public void restartApp() {
		closeAndLaunchApp();
	}
}
