package pages.marketplace.auth.pin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class ForgotPINPage extends BasePage {
	
	public ForgotPINPage(AppiumDriver driver) {
		super(driver);
	}
	
	private By forgottenPINPageTitle = By.id("au.com.suncorp.marketplace:id/forgottenPin");	
	private By pinReAuthPasswordLabel = By.id("au.com.suncorp.marketplace:id/passwordEnterMessage");	
	private By passwordField = By.id("au.com.suncorp.marketplace:id/passwordField");
	private By nextButton = By.id("au.com.suncorp.marketplace:id/submitButton");
	private By forgotPasswordButton = By.id("au.com.suncorp.marketplace:id/forgotPassword");
	private By backButton = MobileBy.AccessibilityId("Back");
	private By passwordRequiredError = By.id("au.com.suncorp.marketplace:id/textinput_error");

	public WebElement checkForgottenPINPageTitle(){
		return find(forgottenPINPageTitle,30);
	}
	
	public String getForgottenPINPageTitle() {
		return getText(forgottenPINPageTitle);
	}
	
	public WebElement checkPINReAuthPasswordLabe(){
		return find(pinReAuthPasswordLabel,30);
	}
	
	public String getPINReAuthPasswordLabe() {
		return getText(pinReAuthPasswordLabel);
	}
	
	public WebElement checkPasswordField(){
		return find(passwordField);
	}
	
	public void enterPassword(String password){
		typeValue(password, passwordField);
	}
	public void relaunchApp(int time, String appName) {
		selectSuncorpApp(time, appName);
	}
	public String getPasswordValue() {
		return getText(passwordField);
	}
	
	public void tapPasswordField(){
		tapElement(passwordField);
	}
	
	public WebElement checkNextButton(){
		return find(nextButton);
	}
	
	public void tapNextButton(){
		tapElement(nextButton);
	}
	
	public WebElement checkForgotPasswordButton(){
		return find(forgotPasswordButton);
	}
	
	public WebElement checkBackButton(){
		return find(backButton);
	}
	public void  tapBackButton(){
		
		tapElement(backButton);
	}
	public WebElement checkPasswordRequiredError(){
		return find(passwordRequiredError,5);
	}
	
	public String getPasswordRequiredErrorMessage() {
		return getText(passwordRequiredError);
	}
	
}
