package test.marketplace.auth;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class RegistrationTest extends App{

	@Test(groups = {"DMPM-845", "DMPM-1315","DMPM-354","DMPM-493","marketplace", "Registration", "priority-minor"})
	public void testCreatingAccount() {
		navigateToRegistrationPage();	
			registrationPage.fill1stPageFields(utils.readTestData("registration", "success", "firstName"),
					utils.readTestData("registration", "success", "surname"),
		
					utils.readTestData("registration", "success", "date"),
					utils.readTestData("registration", "success", "postcode"));
			registrationPage.tapNextButton();
			registrationPage.fill2ndPageFields(utils.readTestData("registration", "success", "email"),
					utils.readTestData("registration", "success", "mobile"));
			registrationPage.tapNextButton();
			registrationPage.fill3rdPageFields(utils.readTestData("registration", "success", "password"));
			Assert.assertNotNull(registrationPage.checkPinSetupScreenDisplayed(),"Logging in message is not displayed");	
	}
	
	@Test(groups = {"DMPM-185", "DMPM-375", "marketplace", "Registration", "priority-major"})
	public void testInlineErrorFields() {

		navigateToRegistrationPage();
		registrationPage.tapFirstNameField();
		Assert.assertTrue(common.isKeyboardShown(),"Registration - Keypad is not shown");
		registrationPage.tapSurnameField();
		Assert.assertEquals(registrationPage.getFirstNameErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		registrationPage.tapDOBField();
		Assert.assertEquals(registrationPage.getSurnameErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		registrationPage.tapPostcodeField();
		registrationPage.tapFirstNameField();
		Assert.assertEquals(registrationPage.getPostcodeErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
	}
		
	@Test(groups = {"DMPM-185", "DMPM-413", "marketplace", "Registration", "priority-major"})
	public void validationOnSubmit() {
		navigateToRegistrationPage();
		registrationPage.tapNextButton();
		Assert.assertEquals(registrationPage.getFirstNameErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		Assert.assertEquals(registrationPage.getSurnameErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		Assert.assertEquals(registrationPage.getDOBErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		Assert.assertEquals(registrationPage.getPostcodeErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		registrationPage.fill1stPageFieldsWithoutPostcode(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"));
		registrationPage.tapNextButton();
		Assert.assertNull(registrationPage.checkFirstNameErrorMsg());
		Assert.assertNull(registrationPage.checkSurnameErrorMsg());
		Assert.assertNull(registrationPage.checkDOBErrorMsg());
		Assert.assertNotNull(registrationPage.getPostcodeErrorMsg());
		registrationPage.enterPostcode(utils.readTestData("registration", "success", "postcode"));
		registrationPage.tapNextButton();
		Assert.assertNotNull(registrationPage.checkRegisterPage2Title());
		
		registrationPage.goBack();
		Assert.assertNotNull(registrationPage.checkRegisterPage1Title());
		
	}
	
	@Test(groups = {"DMPM-189", "DMPM-492", "marketplace", "Registration", "priority-minor"})
	public void validationOnSubmitEmailScreen() {
		navigateToRegistrationPage();
		registrationPage.fill1stPageFields(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"),
				utils.readTestData("registration", "success", "postcode"));
		registrationPage.tapNextButton();
		registrationPage.enterEmail(utils.readTestData("registration", "failure", "emailLong"));
		registrationPage.enterMobile(utils.readTestData("registration", "failure", "mobileInvalid"));
		registrationPage.tapNextButton();
		Assert.assertEquals(registrationPage.getInvalidEmailErrorMsg(), utils.readTestData("copy", "registrationPage", "invalidEmailErrorMsg"));
		Assert.assertEquals(registrationPage.getInvalidMobileErrorMsg(), utils.readTestData("copy", "registrationPage", "invalidMobileErrorMsg"));
		
	}
	
	/*	
	@Test(groups = {"DMPM-184", "DMPM-435", "marketplace", "Registration", "priority-major"})
	public void inlineErrorValidationOnTapout() {
		navigateToRegistrationPage();
		registrationPage.tapNextButton();
		Assert.assertEquals(registrationPage.getFirstNameErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		Assert.assertEquals(registrationPage.getSurnameErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		Assert.assertEquals(registrationPage.getDOBErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		Assert.assertEquals(registrationPage.getPostcodeErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		registrationPage.tapFirstNameField();
		registrationPage.tapSurnameField();
		registrationPage.enterSurname(utils.readTestData("registration", "failure", "1letterSurname"));
		Assert.assertEquals(registrationPage.getSurnameErrorMsg(), utils.readTestData("copy", "registrationPage", "shortSurnameErrorMsg"));
		registrationPage.enterSurname(utils.readTestData("registration", "failure", "longSurname"));
		Assert.assertEquals(registrationPage.getSurnameErrorMsg(), utils.readTestData("copy", "registrationPage", "shortSurnameErrorMsg"));
		registrationPage.enterSurname(utils.readTestData("registration", "failure", "40charSurname"));
		Assert.assertNull(registrationPage.checkSurnameErrorMsg());
		//TODO: Date picker not automated
		
	}
*/
	@Test(groups = {"DMPM-185", "DMPM-377","marketplace", "Registration", "priority-major"})
	public void inlineErrorValidations() {
		navigateToRegistrationPage();
		registrationPage.tapFirstNameField();

		registrationPage.enterFirstName(utils.readTestData("registration", "failure", "specialCharFirstname"));
		Assert.assertEquals(registrationPage.getFirstNameInvalidErrorMsg(), utils.readTestData("copy", "registrationPage", "specialCharErrorMsg"));
		registrationPage.tapSurnameField();
		registrationPage.tapFirstNameField();
		Assert.assertEquals(registrationPage.getSurnameInvalidErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		registrationPage.enterFirstName(utils.readTestData("registration", "failure", "noSpecialCharName"));
		Assert.assertNull(registrationPage.checkFirstNameInvalidErrorMsg());
		
		registrationPage.enterSurname(utils.readTestData("registration", "failure", "specialCharSurname"));
		Assert.assertEquals(registrationPage.getSurnameInvalidErrorMsg(), utils.readTestData("copy", "registrationPage", "specialCharErrorMsg"));
		registrationPage.tapPostcodeField();
		registrationPage.tapSurnameField();
		Assert.assertEquals(registrationPage.getSurnameInvalidErrorMsg(), utils.readTestData("copy", "registrationPage", "specialCharErrorMsg"));
		registrationPage.enterSurname(utils.readTestData("registration", "failure", "noSpecialCharName"));
		Assert.assertNull(registrationPage.checkSurnameInvalidErrorMsg());
		
	}
	
	@Test(groups = {"DMPM-45", "DMPM-460", "marketplace", "Registration", "priority-minor"})
	public void displayUserTips() {
		navigateToRegistrationPage();
		registrationPage.tapFirstNameField();
		Assert.assertEquals(registrationPage.getFirstNameUserTip(),utils.readTestData("copy", "registrationPage", "firstNameUserTip"));
		registrationPage.tapSurnameField();
		Assert.assertNull(registrationPage.checkFirstNameUserTip());
		registrationPage.fill1stPageFields(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"),
				utils.readTestData("registration", "success", "postcode"));
		registrationPage.tapNextButton();
		registrationPage.tapMobileNumberField();
		Assert.assertEquals(registrationPage.getMobileNumberUserTip(),utils.readTestData("copy", "registrationPage", "mobileNumberUserTip"));
		registrationPage.tapEmailField();
		Assert.assertNull(registrationPage.checkMobileNumberUserTip());
	}

	@Test(groups = {"DMPM-189", "DMPM-487", "DMPM-488", "marketplace", "Registration", "priority-minor"})
	public void inlineError2ndPage() {
		navigateToRegistrationPage();
		registrationPage.fill1stPageFields(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"),
				utils.readTestData("registration", "success", "postcode"));
		registrationPage.tapNextButton();
		registrationPage.tapEmailField();
		registrationPage.tapMobileNumberField();
		Assert.assertEquals(registrationPage.getInvalidEmailErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		registrationPage.tapEmailField();
		Assert.assertEquals(registrationPage.getInvalidMobileErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		
	}
	
	@Test(groups = {"DMPM-189", "DMPM-489" ,"DMPM-490", "marketplace", "Registration", "priority-minor"})
	public void inlineError2ndPageOnTapOut() {
		navigateToRegistrationPage();
		registrationPage.fill1stPageFields(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"),
				utils.readTestData("registration", "success", "postcode"));
		registrationPage.tapNextButton();
		registrationPage.enterEmail(utils.readTestData("registration", "failure", "emailLong"));
		registrationPage.tapMobileNumberField();
		Assert.assertEquals(registrationPage.getInvalidEmailErrorMsg(), utils.readTestData("copy", "registrationPage", "invalidEmailErrorMsg"));
		registrationPage.enterMobile(utils.readTestData("registration", "failure", "mobileInvalid"));
		registrationPage.tapEmailField();
		Assert.assertEquals(registrationPage.getInvalidMobileErrorMsg(), utils.readTestData("copy", "registrationPage", "invalidMobileErrorMsg"));
		Assert.assertEquals(registrationPage.getInvalidEmailErrorMsg(), utils.readTestData("copy", "registrationPage", "invalidEmailErrorMsg"));
		registrationPage.tapMobileNumberField();
		Assert.assertEquals(registrationPage.getInvalidMobileErrorMsg(), utils.readTestData("copy", "registrationPage", "invalidMobileErrorMsg"));
	}
	
	/*	
	@Test(groups = {"DMPM-188", "DMPM-423", "marketplace", "Registration", "priority-minor"})
	public void inlineMessageBehaviour() {
		navigateToRegistrationPage();
		registrationPage.fill1stPageFields(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"),
				utils.readTestData("registration", "success", "postcode"));
		registrationPage.tapNextButton();
		registrationPage.enterEmail(utils.readTestData("registration", "failure", "emailLong"));
		registrationPage.tapMobileNumberField();
		Assert.assertEquals(registrationPage.getInvalidEmailErrorMsg(), utils.readTestData("copy", "registrationPage", "invalidEmailErrorMsg"));
		registrationPage.tapEmailField();
		Assert.assertEquals(registrationPage.getInvalidEmailErrorMsg(), utils.readTestData("copy", "registrationPage", "invalidEmailErrorMsg"));		
	}
	*/
	@Test(groups = {"DMPM-189", "DMPM-491", "marketplace", "Registration", "priority-minor"})
	public void correctingInvalidData() {
		navigateToRegistrationPage();
		registrationPage.fill1stPageFields(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"),
				utils.readTestData("registration", "success", "postcode"));
		registrationPage.tapNextButton();
		registrationPage.tapEmailField();
		registrationPage.tapMobileNumberField();
		registrationPage.tapEmailField();
		Assert.assertEquals(registrationPage.getInvalidEmailErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		Assert.assertEquals(registrationPage.getInvalidMobileErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		registrationPage.enterEmail(utils.readTestData("registration", "success", "email"));
		Assert.assertNull(registrationPage.checkEmailErrorMsg());
		registrationPage.enterMobile(utils.readTestData("registration", "success", "mobile"));
		Assert.assertNull(registrationPage.checkMobileErrorMsg());
	}

	@Test(groups = {"DMPM-189", "DMPM-494", "marketplace", "Registration", "priority-minor"})
	public void cancelRegistration() {
		navigateToRegistrationPage();
		registrationPage.fill1stPageFields(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"),
				utils.readTestData("registration", "success", "postcode"));
		registrationPage.tapNextButton();
		registrationPage.fill2ndPageFields(utils.readTestData("registration", "success", "email"),
				utils.readTestData("registration", "success", "mobile"));
		registrationPage.tapCancelButton();
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
	}
	
	@Test(groups = {"DMPM-39", "DMPM-530", "marketplace", "Registration", "priority-major"})
	public void passwordSetupScreen() {
		
		navigateToRegistrationPage();
		registrationPage.fill1stPageFields(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"),
				utils.readTestData("registration", "success", "postcode"));
		registrationPage.tapNextButton();
		String mailAndPassword[] = registrationPage.fill2ndPageFields(utils.readTestData("registration", "success", "email"),
				utils.readTestData("registration", "success", "mobile"));
		String mailId = mailAndPassword[0];
		String mobileNumber = mailAndPassword[1];
		registrationPage.tapNextButton();
		Assert.assertNotNull(registrationPage.checkPasswordField(), "Password field not found");
		Assert.assertNotNull(registrationPage.checkConfirmPasswordField(), "Confirm Password field not found");
		Assert.assertNotNull(registrationPage.checkPasswordCharRequirements(),"Password char requirement not as expected");
		Assert.assertNotNull(registrationPage.checkPasswordNameRequirements(),"Password name requirement not as expected");
		
		Assert.assertNotNull(registrationPage.checkRegisterButton(), "Register button not found");
		registrationPage.navigateToPreviousScreen();
		Assert.assertNotNull(registrationPage.checkRegisterPage2Title(), "Did not navigate to screen 2");
		Assert.assertTrue(registrationPage.checkScreen2Entries(mailId, mobileNumber));
		registrationPage.tapNextButton();
		registrationPage.tapCancelButton(); 
	}
	
	
	@Test(groups = {"DMPM-39", "DMPM-531", "marketplace", "Registration", "priority-major"})
	public void passwordScreenInlineErrors() {
		navigateToRegistrationPage();
		registrationPage.fill1stPageFields(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"),
				utils.readTestData("registration", "success", "postcode"));
		registrationPage.tapNextButton();
		registrationPage.fill2ndPageFields(utils.readTestData("registration", "success", "email"),
				utils.readTestData("registration", "success", "mobile"));
		registrationPage.tapNextButton();
		registrationPage.tapPasswordField();
		registrationPage.tapConfirmPasswordField();
		Assert.assertEquals(registrationPage.getPasswordErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		registrationPage.tapPasswordField();
		Assert.assertEquals(registrationPage.getConfirmPasswordErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
	
		
	}
	
	@Test(groups = {"DMPM-39", "DMPM-532", "DMPM-572", "marketplace", "Registration", "priority-major"})
	public void passwordFieldValidation() {
		navigateToRegistrationPage();
		registrationPage.fill1stPageFields(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"),
				utils.readTestData("registration", "success", "postcode"));
		registrationPage.tapNextButton();
		registrationPage.fill2ndPageFields(utils.readTestData("registration", "success", "email"),
				utils.readTestData("registration", "success", "mobile"));
		registrationPage.tapNextButton();
		registrationPage.enterPassword(utils.readTestData("registration", "failure", "shortPassword"));
		registrationPage.tapConfirmPasswordField();
		Assert.assertTrue(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "shortPasswordErrorMsg")),
				"Error msg not displayed");
		registrationPage.tapPasswordField();
		Assert.assertTrue(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "shortPasswordErrorMsg")),
				"Error msg not displayed");
		
		registrationPage.enterPassword(utils.readTestData("registration", "success", "password"));
		Assert.assertNull(registrationPage.checkPasswordErrorMsg(), "Error msg still seen");
		
		List<Object> firstNameInPasswordList = (List<Object>)utils.readTestDataList("registration", "failure", "firstNameInPassword");
		for(Object firstNameInPassword : (List<Object>)firstNameInPasswordList) {		
			registrationPage.enterPassword(firstNameInPassword.toString());
			registrationPage.tapConfirmPasswordField();
			Assert.assertTrue(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "firstNamePasswordErrorMsg")),
					"Error msg not displayed");
		}	

		registrationPage.enterPassword(utils.readTestData("registration", "success", "password"));
		Assert.assertNull(registrationPage.checkPasswordErrorMsg(), "Error msg still seen");
		
		List<Object> lastNameInPasswordList = (List<Object>)utils.readTestDataList("registration", "failure", "lastNameInPassword");
		for(Object lastNameInPassword : (List<Object>)lastNameInPasswordList) {		
			registrationPage.enterPassword(lastNameInPassword.toString());
			registrationPage.tapConfirmPasswordField();
			Assert.assertTrue(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "lastNamePasswordErrorMsg")),
					"Error msg not displayed");
		}	
		
		registrationPage.tapPasswordField();
		Assert.assertTrue(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "shortPasswordErrorMsg")),
				"Error msg not displayed");
		registrationPage.enterPassword(utils.readTestData("registration", "success", "password"));
		Assert.assertNull(registrationPage.checkPasswordErrorMsg(), "Error msg still seen");
		
		registrationPage.enterPassword(utils.readTestData("registration", "failure", "onlyCharPassword"));
		registrationPage.tapConfirmPasswordField();
		Assert.assertTrue(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "onlycharPasswordErrorMsg")),
				"Error msg not displayed");
		
		registrationPage.enterPassword(utils.readTestData("registration", "failure", "onlyCharUpperCasePassword"));
		registrationPage.tapConfirmPasswordField();
		Assert.assertTrue(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "onlyCharUpperCasePasswordErrorMsg")),
				"Error msg not displayed");
		
		registrationPage.enterPassword(utils.readTestData("registration", "success", "password"));
		registrationPage.tapRegisterButton();
		Assert.assertEquals(registrationPage.getConfirmPasswordErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		
		registrationPage.enterConfirmPassword(utils.readTestData("registration", "failure", "shortPassword"));
		registrationPage.tapRegisterButton();
		Assert.assertEquals(registrationPage.getConfirmPasswordErrorMsg(), utils.readTestData("copy", "registrationPage", "passwordNotMatch"));
		registrationPage.tapConfirmPasswordField();
		Assert.assertEquals(registrationPage.getConfirmPasswordErrorMsg(), utils.readTestData("copy", "registrationPage", "passwordNotMatch"));
		registrationPage.enterConfirmPassword(utils.readTestData("registration", "success", "password"));
		Assert.assertNull(registrationPage.checkConfirmPasswordErrorMsg(), "Error msg still seen");
	}	
	
	@Test(groups = {"DMPM-39", "DMPM-573", "marketplace", "Registration", "priority-major"})
	public void passwordFieldValidationOnSubmit() {
		
		navigateToRegistrationPage();
		registrationPage.fill1stPageFields(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"),
				utils.readTestData("registration", "success", "postcode"));
		registrationPage.tapNextButton();
		registrationPage.fill2ndPageFields(utils.readTestData("registration", "success", "email"),
				utils.readTestData("registration", "success", "mobile"));
		registrationPage.tapNextButton();
		registrationPage.enterPassword(utils.readTestData("registration", "failure", "shortPassword"));
		registrationPage.tapRegisterButton();
		Assert.assertTrue(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "shortPasswordErrorMsg")),
				"Error msg not displayed");
		registrationPage.tapPasswordField();
		Assert.assertTrue(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "shortPasswordErrorMsg")),
				"Error msg not displayed");
		
		registrationPage.enterPassword(utils.readTestData("registration", "success", "password"));
		Assert.assertNull(registrationPage.checkPasswordErrorMsg(), "Error msg still seen");
		
		List<Object> firstNameInPasswordList = (List<Object>)utils.readTestDataList("registration", "failure", "firstNameInPassword");
		for(Object firstNameInPassword : (List<Object>)firstNameInPasswordList) {		
			registrationPage.enterPassword(firstNameInPassword.toString());
			registrationPage.tapRegisterButton();
			Assert.assertTrue(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "firstNamePasswordErrorMsg")),
					"Error msg not displayed");
		}	

		registrationPage.enterPassword(utils.readTestData("registration", "success", "password"));
		Assert.assertNull(registrationPage.checkPasswordErrorMsg(), "Error msg still seen");
		
		List<Object> lastNameInPasswordList = (List<Object>)utils.readTestDataList("registration", "failure", "lastNameInPassword");
		for(Object lastNameInPassword : (List<Object>)lastNameInPasswordList) {		
			registrationPage.enterPassword(lastNameInPassword.toString());
			registrationPage.tapRegisterButton();
			Assert.assertTrue(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "lastNamePasswordErrorMsg")),
					"Error msg not displayed");
		}	
		
		registrationPage.enterPassword(utils.readTestData("registration", "success", "password"));
		Assert.assertNull(registrationPage.checkPasswordErrorMsg(), "Error msg still seen");
		
		registrationPage.enterPassword(utils.readTestData("registration", "failure", "onlyCharPassword"));
		registrationPage.tapRegisterButton();
		Assert.assertTrue(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "onlycharPasswordErrorMsg")),
				"Error msg not displayed");
		
		registrationPage.enterPassword(utils.readTestData("registration", "failure", "onlyCharUpperCasePassword"));
		registrationPage.tapRegisterButton();
		Assert.assertTrue(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "onlyCharUpperCasePasswordErrorMsg")),
				"Error msg not displayed");
		
		registrationPage.enterPassword(utils.readTestData("registration", "success", "password"));
		registrationPage.tapRegisterButton();
		Assert.assertEquals(registrationPage.getConfirmPasswordErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		
		registrationPage.enterConfirmPassword(utils.readTestData("registration", "failure", "shortPassword"));
		registrationPage.tapRegisterButton();
		Assert.assertEquals(registrationPage.getConfirmPasswordErrorMsg(), utils.readTestData("copy", "registrationPage", "passwordNotMatch"));
		registrationPage.tapRegisterButton();
		Assert.assertEquals(registrationPage.getConfirmPasswordErrorMsg(), utils.readTestData("copy", "registrationPage", "passwordNotMatch"));
		registrationPage.enterConfirmPassword(utils.readTestData("registration", "success", "password"));
		Assert.assertNull(registrationPage.checkConfirmPasswordErrorMsg(), "Error msg still seen");
	}	
	
	@Test(groups = {"DMPM-1624", "DMPM-2068", "marketplace", "Registration", "priority-minor"})
	public void updatedDatePicker() {
		navigateToRegistrationPage();
		registrationPage.tapDateField();
		Assert.assertNotNull(registrationPage.checkYearPicker(), "Year picker not seen");
	}
	
	private void navigateToRegistrationPage() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		Assert.assertNotNull(welcomePage.checkRegisterButton(), "Welcome screen - Register button is not shown");
		welcomePage.tapRegisterButton();
		Assert.assertNotNull(registrationPage.checkRegistrationPageTitle(), "Registration page not loaded");
		
	}
	

}
