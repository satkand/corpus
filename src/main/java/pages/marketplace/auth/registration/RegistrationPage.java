package pages.marketplace.auth.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class RegistrationPage extends BasePage {
	
	public RegistrationPage(AppiumDriver driver) {
		super(driver);
	}

	
	private By registrationPageTitle = By.xpath("//android.widget.ScrollView/android.widget.LinearLayout/"
			+ "android.widget.TextView[1]");
	private By cancelButton = MobileBy.AccessibilityId("Cancel");
	private By firstNameField = By.id("au.com.suncorp.marketplace:id/firstNameField");
	private By surnameField = By.id("au.com.suncorp.marketplace:id/surnameField");
	private By dateField = By.id("au.com.suncorp.marketplace:id/dateOfBirthField");
	private By postcodeField = By.id("au.com.suncorp.marketplace:id/postcodeField");
	private By yearPicker = By.id("android:id/date_picker_year_picker");
	private By yearPickerOldDevice = By.id("android:id/month_text_view");
	private By okButton = By.id("android:id/button1");
	private By nextButton = By.id("au.com.suncorp.marketplace:id/nextButton");
	
	private By emailField = By.id("au.com.suncorp.marketplace:id/emailAddressField");
	private By mobileField = By.id("au.com.suncorp.marketplace:id/mobileField");
	
	private By passwordField = By.id("au.com.suncorp.marketplace:id/passwordField");
	private By confirmPasswordField = By.id("au.com.suncorp.marketplace:id/confirmPasswordField");
	private By registerButton = By.id("au.com.suncorp.marketplace:id/registerButton");
	private By accountCreatedMsg = By.id("au.com.suncorp.marketplace:id/dialogMessage");
//	private By pinSetupScreenTitle = By.id("au.com.suncorp.marketplace:id/enterPinMessage");
	
	private By firstNameErrorMsg = By.xpath("//TextInputLayout[@resource-id='au.com.suncorp.marketplace:id/firstNameInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By firstNameErrorMsgOldDevice = By.xpath("//android.widget.LinearLayout[@resource-id='au.com.suncorp.marketplace:id/firstNameInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By surnameErrorMsg = By.xpath("//TextInputLayout[@resource-id='au.com.suncorp.marketplace:id/surnameInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By surnameErrorMsgOldDevice = By.xpath("//android.widget.LinearLayout[@resource-id='au.com.suncorp.marketplace:id/surnameInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By dobErrorMsg = By.xpath("//TextInputLayout[@resource-id='au.com.suncorp.marketplace:id/dateOfBirthInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By dobErrorMsgOldDevice = By.xpath("//android.widget.LinearLayout[@resource-id='au.com.suncorp.marketplace:id/dateOfBirthInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By postcodeErrorMsg = By.xpath("//TextInputLayout[@resource-id='au.com.suncorp.marketplace:id/postcodeInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By postcodeErrorMsgOldDevice = By.xpath("//android.widget.LinearLayout[@resource-id='au.com.suncorp.marketplace:id/postcodeInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	
	private By invalidEmailErrorMsg = By.xpath("//TextInputLayout[@resource-id='au.com.suncorp.marketplace:id/emailAddressInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By invalidEmailErrorMsgOldDevice = By.xpath("//android.widget.LinearLayout[@resource-id='au.com.suncorp.marketplace:id/emailAddressInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	
	private By invalidMobileErrorMsg = By.xpath("//TextInputLayout[@resource-id='au.com.suncorp.marketplace:id/mobileInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By invalidMobileErrorMsgOldDevice = By.xpath("//android.widget.LinearLayout[@resource-id='au.com.suncorp.marketplace:id/mobileInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	

	private By registerPage1Title = By.xpath("//android.widget.TextView[@text='Step 1 of 3']");
	private By registerPage2Title = By.id("au.com.suncorp.marketplace:id/pageDescriptionText");
	private By registerPage3Title = By.id("au.com.suncorp.marketplace:id/registrationStep3Label");
	private By backButton = By.id("BackButton");
	
	private By firstNameUserTip = By.xpath("//android.widget.ScrollView/android.widget.LinearLayout/"
			+ "TextInputLayout[1]/android.widget.TextView");
	private By firstNameUserTipOldDevice = By.xpath("//android.widget.LinearLayout[@resource-id='au.com.suncorp.marketplace:id/firstNameInputLayout']/android.widget.TextView");
	private By mobileNumberUserTip = By.xpath("//android.widget.ScrollView/android.widget.LinearLayout/"
			+ "TextInputLayout[2]/android.widget.TextView");
	private By mobileNumberUserTipOldDevice = By.xpath("//android.widget.LinearLayout[@resource-id='au.com.suncorp.marketplace:id/mobileInputLayout']/android.widget.TextView");
	
	
	private By passwordLengthRequirementsField = By.id("au.com.suncorp.marketplace:id/lengthStatusLabel");
	private By passwordCharRequirements1Field = By.id("au.com.suncorp.marketplace:id/atLeastOneLowercase");
	private By passwordCharRequirements2Field = By.id("au.com.suncorp.marketplace:id/atLeastOneUppercase");
	private By passwordCharRequirements3Field = By.id("au.com.suncorp.marketplace:id/atLeastOneNumber");
	private By passwordNameRequirementsField = By.id("au.com.suncorp.marketplace:id/containsNameStatusLabel");
	private By passwordErrorMsg = By.xpath("//TextInputLayout[@resource-id='au.com.suncorp.marketplace:id/passwordInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By passwordErrorMsgOldDevice = By.xpath("//android.widget.LinearLayout[@resource-id='au.com.suncorp.marketplace:id/passwordInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By confirmPasswordErrorMsg = By.xpath("//TextInputLayout[@resource-id='au.com.suncorp.marketplace:id/confirmPasswordInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By confirmPasswordErrorMsgOldDevice = By.xpath("//android.widget.LinearLayout[@resource-id='au.com.suncorp.marketplace:id/confirmPasswordInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By okButtonDuplicateEmailPopUp = By.id("android:id/button2");
	private By loginWithThisEmailButton = By.id("android:id/button1");
	private By duplicateEmailPopUpTitle = By.id("au.com.suncorp.marketplace:id/alertTitle");
	private By duplicateEmailPopUpText = By.id("android:id/message");

	public WebElement checkRegistrationPageTitle(){
		return find(registrationPageTitle,20);
	}
	
	public void tapCancelButton(){
		tapElement(cancelButton);
	}
	
	public void tapFirstNameField(){
		find(firstNameField, 20);
		tapElement(firstNameField);
	}
	
	public void tapSurnameField(){
		tapElement(surnameField);
	}
	
	public void tapDOBField(){
		tapElement(dateField);
	}
	
	public void tapPostcodeField(){
		tapElement(postcodeField);
	}
	
	public void tapMobileNumberField(){
		tapElement(mobileField);
	}
	
	public void tapEmailField(){
		tapElement(emailField);
	}
	
	public void tapBackButton() {
		tapElement(backButton);
	}
	
	public void tapNextButton() {
		tapElement(nextButton);
	}
	
	public void fill1stPageFields(String firstName, String surname, String date, String postcode) {
		typeValue(firstName, firstNameField);
		typeValue(surname, surnameField);
		//TODO datepicker to be implemented
		tapElement(dateField);

		tapElement(okButton);
		typeValue(postcode,postcodeField);
		dismissKeyboard();
	}
	
	public void fill1stPageFieldsWithoutPostcode(String firstName, String surname, String date) {
		typeValue(firstName, firstNameField);
		typeValue(surname, surnameField);
		//TODO datepicker to be implemented
		tapElement(dateField);
		tapElement(okButton);
		dismissKeyboard();
	}
	
	public void fillRegistrationScreens(String firstName, String surname, String date,
			String postcode, String email, String mobile, String password) {
		checkRegistrationPageTitle();
		fill1stPageFields(firstName, surname, date, postcode);
		tapNextButton();
		fill2ndPageFields(email, mobile);
		tapNextButton();
		fill3rdPageFields(password);
	}
	
	public void enterPostcode(String postcode) {
		typeValue(postcode,postcodeField);
		dismissKeyboard();
	}
	
	public void enterFirstName(String firstName) {
		typeValue(firstName,firstNameField);
		dismissKeyboard();
	}
	
	public void enterSurname(String surname) {
		typeValue(surname,surnameField);
		dismissKeyboard();
	}
	
	public String[] fill2ndPageFields(String email, String mobile) {
		String emailId = email + Math.random() + "@sbh.com";
		enterEmail(emailId);
		enterMobile(mobile);
		dismissKeyboard();
		return new String[] {getText(emailField) , getText(mobileField)};
	}
	
	public void enterEmail(String email) {
		typeValue(email, emailField);
	}
	
	public void enterMobile(String mobile) {
		typeValue(mobile, mobileField);
	}
	
	public void fill3rdPageFields(String password) {
		typeValue(password, passwordField);
		typeValue(password, confirmPasswordField);
		dismissKeyboard();
		tapElement(registerButton);
	}

	public String checkAccountCreatedMsgDisplayed() {
		return getText(accountCreatedMsg);
	}
	
	public WebElement checkFirstNameErrorMsg(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return find(firstNameErrorMsg,30);
		}
		else { 
			return find(firstNameErrorMsgOldDevice,30);
		}
	}
	
	public String getFirstNameErrorMsg(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return getText(firstNameErrorMsg);
		}
		else { 
			return getText(firstNameErrorMsgOldDevice);
		}
	}
	
	public WebElement checkSurnameErrorMsg(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return find(surnameErrorMsg,30);
		}
		else { 
			return find(surnameErrorMsgOldDevice,30);
		}
	}
	
	public String getSurnameErrorMsg(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return getText(surnameErrorMsg);
		}
		else { 
			return getText(surnameErrorMsgOldDevice);
		}
	}
	
	public WebElement checkDOBErrorMsg(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return find(dobErrorMsg,30);
		}
		else { 
			return find(dobErrorMsgOldDevice,30);
		}
	}
	
	public String getDOBErrorMsg(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return getText(dobErrorMsg);
		}
		else { 
			return getText(dobErrorMsgOldDevice);
		}
	}
	
	public WebElement checkPostCodeErrorMsg(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return find(postcodeErrorMsg,30);
		}
		else { 
			return find(postcodeErrorMsgOldDevice,30);
		}
	}
	
	public String getPostCodeErrorMsg(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return getText(postcodeErrorMsg);
		}
		else { 
			return getText(postcodeErrorMsgOldDevice);
		}
	}
	
	public WebElement checkFirstNameUserTip(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return find(firstNameUserTip,30);
		}
		else { 
			return find(firstNameUserTipOldDevice,30);
		}
	}
	
	public String getFirstNameUserTip(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return getText(firstNameUserTip);
		}
		else { 
			return getText(firstNameUserTipOldDevice);
		}
	}
	
	public WebElement checkMobileNumberUserTip(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return find(mobileNumberUserTip,30);
		}
		else { 
			return find(mobileNumberUserTipOldDevice,30);
		}
	}
	
	public String getMobileNumberUserTip(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return getText(mobileNumberUserTip);
		}
		else { 
			return getText(mobileNumberUserTipOldDevice);
		}
	}
	
	public WebElement checkEmailErrorMsg(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return find(invalidEmailErrorMsg,30);
		}
		else { 
			return find(invalidEmailErrorMsgOldDevice,30);
		}
	}
	
	public String getInvalidEmailErrorMsg(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return getText(invalidEmailErrorMsg);
		}
		else { 
			return getText(invalidEmailErrorMsgOldDevice);
		}
	}
	
	public WebElement checkMobileErrorMsg(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return find(invalidMobileErrorMsg,30);
		}
		else { 
			return find(invalidMobileErrorMsgOldDevice,30);
		}
	}
	
	public String getInvalidMobileErrorMsg(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return getText(invalidMobileErrorMsg);
		}
		else { 
			return getText(invalidMobileErrorMsgOldDevice);
		}
	}
	
	public WebElement checkPasswordField() {
		return find(passwordField);
	}
	
	public WebElement checkConfirmPasswordField() {
		return find(confirmPasswordField);
	}
	
	public WebElement checkPasswordLengthRequirements() {
		return find(passwordLengthRequirementsField);
	}
	
	public boolean checkPasswordRequirements(String errorMsg) {
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0 && getText(passwordErrorMsg).contains(errorMsg)) {
			return true;
		}
		else if (osVersion <= 6.0 && getText(passwordErrorMsgOldDevice).contains(errorMsg)){ 
			return true;
		}
		else return false;
	}
	
	public WebElement checkPasswordErrorMsg(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return find(passwordErrorMsg,30);
		}
		else { 
			return find(passwordErrorMsgOldDevice,30);
		}
	}
	
	public String getPasswordErrorMsg(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return getText(passwordErrorMsg);
		}
		else { 
			return getText(passwordErrorMsgOldDevice);
		}
	}
	
	public WebElement checkConfirmPasswordErrorMsg(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return find(confirmPasswordErrorMsg,30);
		}
		else { 
			return find(confirmPasswordErrorMsgOldDevice,30);
		}
	}
	
	public String getConfirmPasswordErrorMsg(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return getText(confirmPasswordErrorMsg);
		}
		else { 
			return getText(confirmPasswordErrorMsgOldDevice);
		}
	}
	
	public boolean checkPasswordCharRequirements() {
		if( find(passwordCharRequirements1Field) != null && find(passwordCharRequirements2Field) != null && find(passwordCharRequirements3Field) != null)
			return true;
		else
			return false;
	}
	
	public WebElement checkPasswordNameRequirements() {
		return find(passwordNameRequirementsField);
	}
	
	public WebElement checkRegisterButton() {
		return find(registerButton);
	}
	
	public void tapRegisterButton() {
		tapElement(registerButton);
	}
	
	public WebElement checkPreviousButton() {
		return find(backButton);
	}
	
	public void navigateToPreviousScreen() {
		navigateBack();
	}
	
	
	public boolean checkScreen2Entries(String email, String mobile) {
		if(getText(emailField).equalsIgnoreCase(email) && getText(mobileField).equalsIgnoreCase(mobile)) {
			return true;
		}else
			return false;		
	}
	
	public String getPasswordNameRequirementsText()
	{
		return getText(passwordNameRequirementsField);
	}
	
	public WebElement checkRegisterPage2Title() {
		return find(registerPage2Title);
	}
	
	public WebElement checkRegisterPage1Title() {
		return find(registerPage1Title);
	}	
	
	public void enterPassword(String password) {
		typeValue(password, passwordField);
		dismissKeyboard();
	}
	
	public void tapPasswordField() {
		tapElement(passwordField);
	}
	
	public void tapDateField() {
		tapElement(dateField);
	}
	
	public WebElement checkYearPicker(){
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));

		if (osVersion >= 6.0) {
			return find(yearPicker,30);
		}
		else { 
			return find(yearPickerOldDevice,30);
		}
	}
	
	public void tapConfirmPasswordField() {
		tapElement(confirmPasswordField);
	}
	
	public void enterConfirmPassword(String password) {
		typeValue(password, confirmPasswordField);
		dismissKeyboard();
	}
	
	public WebElement checkFirstNameField() {
		return find(firstNameField);
	}

	public WebElement checkCancelButton() {
		return find(cancelButton);
	}

	public void clearField(String fieldname)
	{
		switch (fieldname)
		{
		case "firstNameField" :
			clearValue(firstNameField);
			break;
		case "surNameField":
			clearValue(surnameField);
			break;
		case "mobileField":
			clearValue(mobileField);
			break;
		case "emailField":
			clearValue(emailField);
			break;
		case "desiredPassword":
			clearValue(passwordField);
			break;
		}
		dismissKeyboard();
		
	}

	public WebElement checkDuplicateEmailPopUpTitle(){
		return find(duplicateEmailPopUpTitle);
	}
	
	public String getDuplicateEmailPopUpTitle() {
		return getText(duplicateEmailPopUpTitle);
	}
	
	public String getDuplicateEmailPopUpText() {
		return getText(duplicateEmailPopUpText);
	}
	
	public String getDuplicateEmailPopUpOkButtonLabel() {
		return getText(okButtonDuplicateEmailPopUp);
	}
	
	public String getDuplicateEmailPopUpAnotherLoginButtonLabel() {
		return getText(loginWithThisEmailButton);
	}
	
	public void tapOkButton() {
		tapElement(okButtonDuplicateEmailPopUp);
	}
	
	public void tapLoginWithThisEmailButton() {
		tapElement(loginWithThisEmailButton);
	}
	
	public WebElement checkRegisterPage3Title() {
		return find(registerPage3Title);
	}
}
