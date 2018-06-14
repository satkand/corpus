package pages.marketplace.auth.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import automation.framework.common.BasePage;
import automation.framework.utils.AutoUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class MemberLoginPage extends BasePage {
	
	AutoUtilities utils = new AutoUtilities();

	public MemberLoginPage(AppiumDriver driver) {
		super(driver);
	}

	private By pageTitle = By.id("au.com.suncorp.marketplace:id/screenTitleText");
	private By cancelButton = MobileBy.AccessibilityId("Cancel");
	private By emailTextField = By.id("au.com.suncorp.marketplace:id/emailAddressField");
	private By passwordTextField = By.id("au.com.suncorp.marketplace:id/passwordField");
	private By nextButton = By.id("au.com.suncorp.marketplace:id/nextButton");
	private By forgotPasswordButton = By.id("au.com.suncorp.marketplace:id/forgotPasswordButton");
	private By noCredentialsButton = By.id("au.com.suncorp.marketplace:id/noCredentialsButton");
	private By emailFieldError = By.xpath("//TextInputLayout[@text='Email']//android.widget.LinearLayout/android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By emailFieldErrorOldDevice = By.xpath("//android.widget.LinearLayout[@text='Email']//android.widget.LinearLayout/android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By passwordFieldError = By.xpath("//TextInputLayout[@text='Password']//android.widget.LinearLayout/android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By passwordFieldErrorOldDevice = By.xpath("//android.widget.LinearLayout[@text='Password']//android.widget.LinearLayout/android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By incorrectEmailSnackbarText = By.id("au.com.suncorp.marketplace:id/snackbar_text");
	private By incorrectEmailSnackBarButton = By.id("au.com.suncorp.marketplace:id/snackbar_action");
	
	//Mobile registration page elements
	private By mobileRegisterPageTitle = By.xpath("//android.widget.TextView[@text='Almost there!']");
	private By mobileRegisterPageDescription = By.id("au.com.suncorp.marketplace:id/registrationMobileText");
	private By mobileTextField = By.id("au.com.suncorp.marketplace:id/mobileField");
	private By regiterWithMobileButton = By.id("au.com.suncorp.marketplace:id/registerButton");
	private By noMarketingTermsText = By.id("au.com.suncorp.marketplace:id/noMarketingTermsText");
	private By registrationTermsText = By.id("au.com.suncorp.marketplace:id/registrationTermsText");
	private By mobileNumberError  = By.id("au.com.suncorp.marketplace:id/textinput_error");
	private By mobileNumberTip = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Use 04XXXXXXXX format\")");
	private By mobileNumberCancelButton = MobileBy.AccessibilityId("Cancel");
	
	//Member Login Reset Password
	private By resetPasswordTitle = By.id("au.com.suncorp.marketplace:id/resetPasswordTitleText");
	private By resetPasswordDescription = By.id("au.com.suncorp.marketplace:id/resetPasswordSubtitleText");
	private By resetPasswordEmailField = By.id("au.com.suncorp.marketplace:id/emailAddressField");
	private By resetLinkButton = By.id("au.com.suncorp.marketplace:id/sendResetLinkButton");
	private By resetPasswordBackButton = MobileBy.AccessibilityId("Back");
	private By resetPasswordEmailFieldError = By.id("au.com.suncorp.marketplace:id/textinput_error");
	private By resetPasswordSuccessSnackbar = By.id("au.com.suncorp.marketplace:id/snackbar_text");
	private By resetPasswordSuccessSnackbarButton = By.id("au.com.suncorp.marketplace:id/snackbar_action");
	
	//Suncorp Bank Login elements
	private By suncorpBankLoginTitle = By.id("au.com.suncorp.marketplace:id/bankingLoginTitle");
	private By suncorpBankLoginBackButton = MobileBy.AccessibilityId("Back");
	
	public String getPageTitle() {
		find(pageTitle, 30);
		return getText(pageTitle);
	}

	public WebElement checkCancelButton() {
		return find(cancelButton);
	}

	public void tapCancelButton() {
		tapElement(cancelButton);
	}

	public WebElement checkEmailField() {
		return find(emailTextField);
	}

	public void enterEmail(String emailValue) {
		typeValue(emailValue, emailTextField);
	}

	public void tapEmailField() {
		tapElement(emailTextField);
	}
	
	public String getEmailFieldValue() {
		return getText(emailTextField);
	}
	
	public WebElement checkEmailFieldError(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return find(emailFieldError,30);
		}
		else { 
			return find(emailFieldErrorOldDevice,30);
		}
	}
	
	public String getEmailFieldErrorValue(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return getText(emailFieldError);
		}
		else { 
			return getText(emailFieldErrorOldDevice);
		}
	}
	
	public WebElement checkPasswordField() {
		return find(passwordTextField);
	}
	
	public void enterPassword(String pwdValue) {
		typeValue(pwdValue, passwordTextField);
	}

	public void tapPasswordField() {
		tapElement(passwordTextField);
	}
	
	public WebElement checkPasswordFieldError(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return find(passwordFieldError,30);
		}
		else { 
			return find(passwordFieldErrorOldDevice,30);
		}
	}
	
	public String getPasswordFieldErrorValue(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return getText(passwordFieldError);
		}
		else { 
			return getText(passwordFieldErrorOldDevice);
		}
	}

	public WebElement checkNextButton() {
		return find(nextButton);
	}
	
	public void tapNextButton() {
		dismissKeyboard();
		tapElement(nextButton);
	}

	public WebElement checkForgotPasswordButton() {
		return find(forgotPasswordButton);
	}

	public WebElement checkNoCredentialsButton() {
		return find(noCredentialsButton);
	}
	
	public Boolean getPasswordFieldMaskedVal(String maskedValue) {
		Boolean status;
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			status = getText(passwordTextField).equals(maskedValue);
		}
		else { 
			status = getText(passwordTextField).equals(""); 
		}
		return status;
	}

	public String getPasswordFieldValue() {
		find(passwordTextField, 30);
		return getText(passwordTextField);
	}

	public void relaunchApp(int time, String appName) {
		selectSuncorpApp(time, appName);
	}

	public void tapOn(String tapOn) {
		switch (tapOn) {
		case "passwordField":
			tapElement(passwordTextField);
			break;
		case "nextButton":
			tapElement(nextButton);
			break;
		default:
			break;
		}
	}
	
	public void enterLoginCredentials(String email, String pwd) {
		enterEmail(email);
		enterPassword(pwd);
	}
	
	public void tapNoCredentialsButton() {
		tapElement(noCredentialsButton);
	}
	
	public WebElement checkMobileRegisterPageTitle() {
		return find(mobileRegisterPageTitle, 30);
	}
	
	public WebElement checkMobileRegisterPageDescription() {
		return find(mobileRegisterPageDescription);
	}
	
	public WebElement checkMobileTextField() {
		return find(mobileTextField);
	}

	public void tapMobileTextField() {
		tapElement(mobileTextField);
	}
	
	public void enterMobileNumber(String number) {
		typeValue(number, mobileTextField);
	}
	
	public WebElement checkRegiterWithMobileButton() {
		return find(regiterWithMobileButton);
	}
	
	public void tapRegisterButton() {
		find(regiterWithMobileButton);
		tapElement(regiterWithMobileButton);
	}
	
	public WebElement checkNoMarketingTermsText() {
		return find(noMarketingTermsText);
	}
	
	public WebElement checkRegistrationTermsText() {
		return find(registrationTermsText);
	}
	
	public String getMobileFieldError() {
		return getText(mobileNumberError);
	}
	
	public WebElement checkMobileFieldError() {
		return find(mobileNumberError, 5);
	}
	
	public Boolean checkKeyboard() {
		return isKeyboardPresent();
	}
	
	public void tapMobileNumberCancelButton() {
		tapElement(mobileNumberCancelButton);
	}
	
	public void tapBackBtn() {
		tapDeviceBackButton();
	}
	
	public WebElement checkSnackbarDisplayed() {
		return find(incorrectEmailSnackbarText, 30);
	}
	
	public String getSnackbarText() {
		return getText(incorrectEmailSnackbarText);
	}
	
	public void tapSnackbarOkButton() {
		find(incorrectEmailSnackBarButton);
		tapElement(incorrectEmailSnackBarButton);
	}
	
	public WebElement checkMobileNumberTip() {
		return find(mobileNumberTip);
	}
	
	public String getMobileNumberTipText() {
		return getText(mobileNumberTip);
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
		return find(resetPasswordEmailField);
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
		return find(resetPasswordSuccessSnackbar, 30);
	}
	
	public String getResetPasswordSuccessSnackbarText() {
		return getText(resetPasswordSuccessSnackbar);
	}
	
	public String getResetPasswordSuccessSnackbarBtn() {
		return getText(resetPasswordSuccessSnackbarButton);
	}
	
	public WebElement checkSuncorpBankLoginTitle() {
		return find(suncorpBankLoginTitle);
	}
	
	public void tapSuncorpBankLoginBackButton() {
		tapElement(suncorpBankLoginBackButton);
	}
}
