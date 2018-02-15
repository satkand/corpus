package pages.marketplace.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class RegistrationPage extends BasePage {
	
	public RegistrationPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	private By registrationPageTitle = By.xpath("//android.widget.ScrollView/android.widget.LinearLayout/"
			+ "android.widget.TextView[1]");
	private By cancelButton = By.id("au.com.suncorp.marketplace:id/cancelButton");
	private By firstNameField = By.id("au.com.suncorp.marketplace:id/firstNameField");
	private By surnameField = By.id("au.com.suncorp.marketplace:id/surnameField");
	private By dateField = By.id("au.com.suncorp.marketplace:id/dateOfBirthField");
	private By postcodeField = By.id("au.com.suncorp.marketplace:id/postcodeField");
	private By yearPicker = By.id("android:id/date_picker_year_picker");
	private By okButton = By.id("android:id/button1");
	private By nextButton = By.id("au.com.suncorp.marketplace:id/nextButton");
	
	private By emailField = By.id("au.com.suncorp.marketplace:id/emailAddressField");
	private By mobileField = By.id("au.com.suncorp.marketplace:id/mobileField");
	
	private By passwordField = By.id("au.com.suncorp.marketplace:id/passwordField");
	private By confirmPasswordField = By.id("au.com.suncorp.marketplace:id/confirmPasswordField");
	private By registerButton = By.id("au.com.suncorp.marketplace:id/registerButton");
	private By accountCreatedMsg = By.id("au.com.suncorp.marketplace:id/dialogMessage");
	private By pinSetupScreenTitle = By.id("au.com.suncorp.marketplace:id/enterPinMessage");
	
	private By firstNameErrorMsg = By.xpath("//TextInputLayout[@resource-id='au.com.suncorp.marketplace:id/firstNameInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By surnameErrorMsg = By.xpath("//TextInputLayout[@resource-id='au.com.suncorp.marketplace:id/surnameInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By dobErrorMsg = By.xpath("//TextInputLayout[@resource-id='au.com.suncorp.marketplace:id/dateOfBirthInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By postcodeErrorMsg = By.xpath("//TextInputLayout[@resource-id='au.com.suncorp.marketplace:id/postcodeInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	
	private By invalidEmailErrorMsg = By.xpath("//TextInputLayout[@resource-id='au.com.suncorp.marketplace:id/emailAddressInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By invalidMobileErrorMsg = By.xpath("//TextInputLayout[@resource-id='au.com.suncorp.marketplace:id/mobileInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	
	private By invalidTextErrorMsg = By.id("au.com.suncorp.marketplace:id/textinput_error");
	private By firstNameInvalidErrorMsg = By.xpath("//TextInputLayout[@resource-id='au.com.suncorp.marketplace:id/firstNameInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By surnameInvalidErrorMsg = By.xpath("//TextInputLayout[@resource-id='au.com.suncorp.marketplace:id/surnameInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By postcodeInvalidErrorMsg = By.xpath("//TextInputLayout[@resource-id='au.com.suncorp.marketplace:id/postcodeInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	

	
	private By registerPage1Title = By.id("Step 1 of 3");
	private By registerPage2Title = By.id("au.com.suncorp.marketplace:id/pageDescriptionText");
	private By backButton = By.id("BackButton");
	
	private By firstNameUserTip = By.xpath("//android.widget.ScrollView/android.widget.LinearLayout/"
			+ "TextInputLayout[1]/android.widget.TextView");
	private By mobileNumberUserTip = By.xpath("//android.widget.ScrollView/android.widget.LinearLayout/"
			+ "TextInputLayout[2]/android.widget.TextView");
	
	private By passwordLengthRequirementsField = By.id("au.com.suncorp.marketplace:id/lengthStatusLabel");
	private By passwordCharRequirements1Field = By.id("au.com.suncorp.marketplace:id/atLeastOneLowercase");
	private By passwordCharRequirements2Field = By.id("au.com.suncorp.marketplace:id/atLeastOneUppercase");
	private By passwordCharRequirements3Field = By.id("au.com.suncorp.marketplace:id/atLeastOneNumber");
	private By passwordNameRequirementsField = By.id("au.com.suncorp.marketplace:id/containsNameStatusLabel");
	private By passwordErrorMsg = By.xpath("//TextInputLayout[@resource-id='au.com.suncorp.marketplace:id/passwordInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By confirmPasswordErrorMsg = By.xpath("//TextInputLayout[@resource-id='au.com.suncorp.marketplace:id/confirmPasswordInputLayout']"
			+ "//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");


	private By setupNewAccountButton = By.id("au.com.suncorp.marketplace:id/newAccountButton");
	
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
		if(checkSetupNewAccountButton() != null) {
			tapSetupNewAccount();
		}
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
	
	public WebElement checkFirstNameErrorMsg() {
		return find(firstNameErrorMsg);
	}
	
	public WebElement checkSurnameErrorMsg() {
		return find(surnameErrorMsg);
	}
	
	public WebElement checkDOBErrorMsg() {
		return find(dobErrorMsg);
	}
	
	public WebElement checkPostCodeErrorMsg() {
		return find(postcodeErrorMsg);
	}
	
	public String getFirstNameErrorMsg() {
		return getText(firstNameErrorMsg);
	}
	
	public String getFirstNameUserTip() {
		return getText(firstNameUserTip);
	}
	
	public WebElement checkFirstNameUserTip() {
		return find(firstNameUserTip);
	}
	
	public String getMobileNumberUserTip() {
		return getText(mobileNumberUserTip);
	}
	
	public WebElement checkMobileNumberUserTip() {
		return find(mobileNumberUserTip);
	}
	
	public WebElement checkEmailErrorMsg() {
		return find(invalidEmailErrorMsg);
	}
	
	public WebElement checkMobileErrorMsg() {
		return find(invalidMobileErrorMsg);
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
		if(getText(passwordErrorMsg).contains(errorMsg)) {
			return true;
		}else
			return false;
	}
	
	public WebElement checkPasswordErrorMsg() {
		return find(passwordErrorMsg);
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
	
	public String getSurnameErrorMsg() {
		return getText(surnameErrorMsg);
	}
	
	public String getDOBErrorMsg() {
		return getText(dobErrorMsg);
	}
	
	public String getPostcodeErrorMsg() {
		return getText(postcodeErrorMsg);
	}
	
	public String getInvalidEmailErrorMsg() {
		return getText(invalidEmailErrorMsg);
	}
	
	public String getInvalidMobileErrorMsg() {
		return getText(invalidMobileErrorMsg);
	}
	
	public String getFirstNameInvalidErrorMsg() {
		return getText(firstNameInvalidErrorMsg);
	}
	
	public WebElement checkFirstNameInvalidErrorMsg() {
		return find(firstNameInvalidErrorMsg);
	}
	
	public String getSurnameInvalidErrorMsg() {
		return getText(surnameInvalidErrorMsg);
	}
	
	public WebElement checkSurnameInvalidErrorMsg() {
		return find(surnameInvalidErrorMsg);
	}
	
	public String getPostcodeInvalidErrorMsg() {
		return getText(postcodeInvalidErrorMsg);
	}
	
	public WebElement checkPostcodeInvalidErrorMsg() {
		return find(postcodeInvalidErrorMsg);
	}
	
	public String getInvalidTextErrorMsg() {
		return getText(invalidTextErrorMsg);
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
	
	public WebElement checkYearPicker() {
		return find(yearPicker);
	}
	
	public void tapConfirmPasswordField() {
		tapElement(confirmPasswordField);
	}
	
	public void enterConfirmPassword(String password) {
		typeValue(password, confirmPasswordField);
		dismissKeyboard();
	}
	
	public String getPasswordErrorMsg() {
		return getText(passwordErrorMsg);
	}
	
	public String getConfirmPasswordErrorMsg() {
		return getText(confirmPasswordErrorMsg);
	}
	
	public WebElement checkConfirmPasswordErrorMsg() {
		return find(confirmPasswordErrorMsg);
	}
	
	public WebElement checkFirstNameField() {
		return find(firstNameField);
	}

	public WebElement checkCancelButton() {
		return find(cancelButton);
	}

	public WebElement checkSetupNewAccountButton() {
		return find(setupNewAccountButton);
	}
	
	public void tapSetupNewAccount() {
		tapElement(setupNewAccountButton);
	}
	
}
