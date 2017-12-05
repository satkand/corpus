package pages.marketplace.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class PINReAuthPasswordPage extends BasePage {
	
	public PINReAuthPasswordPage(AppiumDriver driver) {
		super(driver);
	}
	
	private By forgottenPINPageTitle = By.id("au.com.suncorp.marketplace:id/forgottenPin");	
	private By pinReAuthPasswordLabel = By.id("au.com.suncorp.marketplace:id/passwordEnterMessage");	
	private By passwordField = By.id("au.com.suncorp.marketplace:id/passwordField");
	private By nextButton = By.id("au.com.suncorp.marketplace:id/submitButton");
	private By forgotPasswordButton = By.id("au.com.suncorp.marketplace:id/forgotPassword");
	private By backButton = By.id("au.com.suncorp.marketplace:id/backButton"); //By.id("Back");
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
	
	public WebElement checkPasswordRequiredError(){
		return find(passwordRequiredError);
	}
	
	public String getPasswordRequiredErrorMessage() {
		return getText(passwordRequiredError);
	}
	
}
