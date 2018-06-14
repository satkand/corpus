package test.marketplace.auth.registration;

import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
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
			common.waitForLoadingIndicatorToDisappear();
			Assert.assertNotNull(pinOptionsPage.checkPinPromptUserWelcome(),"Pin enable screen is not displayed");
	}
	
	@Test(groups = {"DMPM-185", "DMPM-375", "marketplace", "Registration", "priority-major"})
	public void testInlineErrorFields() {

		navigateToRegistrationPage();
		registrationPage.tapFirstNameField();
		Assert.assertTrue(common.isKeyboardShown(),"Registration - Keypad is not shown");
		registrationPage.tapSurnameField();
		Assert.assertEquals(registrationPage.getFirstNameErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		common.dismissKeyboardShown();
		registrationPage.tapPostcodeField();
		Assert.assertEquals(registrationPage.getSurnameErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		registrationPage.tapFirstNameField();
		common.dismissKeyboardShown();
		Assert.assertEquals(registrationPage.getPostCodeErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
	}
		
	@Test(groups = {"DMPM-185", "DMPM-413", "marketplace", "Registration", "priority-major"})
	public void testValidationOnSubmit() {
		navigateToRegistrationPage();
		registrationPage.tapNextButton();
		Assert.assertEquals(registrationPage.getFirstNameErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		Assert.assertEquals(registrationPage.getSurnameErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		Assert.assertEquals(registrationPage.getDOBErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		Assert.assertEquals(registrationPage.getPostCodeErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		registrationPage.fill1stPageFieldsWithoutPostcode(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"));
		registrationPage.tapNextButton();
		Assert.assertNull(registrationPage.checkFirstNameErrorMsg());
		Assert.assertNull(registrationPage.checkSurnameErrorMsg());
		Assert.assertNull(registrationPage.checkDOBErrorMsg());
		Assert.assertNotNull(registrationPage.getPostCodeErrorMsg());
		registrationPage.enterPostcode(utils.readTestData("registration", "success", "postcode"));
		registrationPage.tapNextButton();
		Assert.assertNotNull(registrationPage.checkRegisterPage2Title());	
		common.goBack();
		Assert.assertNotNull(registrationPage.checkRegisterPage1Title());
		
	}
	
	@Test(groups = {"DMPM-189", "DMPM-492", "marketplace", "Registration", "priority-minor"})
	public void testValidationOnSubmitEmailScreen() {
		navigateToRegistrationPage();
		registrationPage.fill1stPageFields(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"),
				utils.readTestData("registration", "success", "postcode"));
		registrationPage.tapNextButton();
		registrationPage.enterEmail(utils.readTestData("registration", "failure", "invalidEmail"));
		registrationPage.enterMobile(utils.readTestData("registration", "failure", "mobileInvalidFormat"));
		registrationPage.tapNextButton();
		Assert.assertEquals(registrationPage.getInvalidEmailErrorMsg(), utils.readTestData("copy", "registrationPage", "invalidEmailErrorMsg"));
		Assert.assertEquals(registrationPage.getInvalidMobileErrorMsg(), utils.readTestData("copy", "registrationPage", "invalidMobileErrorMsg"));
		
	}
	
	
	@Test(groups = {"DMPM-184", "DMPM-435", "marketplace", "Registration", "priority-major"})
	public void inlineErrorValidationOnTapout() {
		navigateToRegistrationPage();
		registrationPage.tapNextButton();
		Assert.assertEquals(registrationPage.getFirstNameErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		Assert.assertEquals(registrationPage.getSurnameErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		Assert.assertEquals(registrationPage.getDOBErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		Assert.assertEquals(registrationPage.getPostCodeErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		registrationPage.tapFirstNameField();
		Assert.assertEquals(registrationPage.getFirstNameErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"), "Reg Page 1 - Error not displayed for the First Name field");
		registrationPage.tapSurnameField();
		registrationPage.enterSurname(utils.readTestData("registration", "failure", "1letterSurname"));
		registrationPage.tapFirstNameField();
		Assert.assertEquals(registrationPage.getSurnameErrorMsg(), utils.readTestData("copy", "registrationPage", "shortSurnameErrorMsg"));
		registrationPage.enterSurname(utils.readTestData("registration", "failure", "longSurname"));
		registrationPage.tapFirstNameField();
		Assert.assertEquals(registrationPage.getSurnameErrorMsg(), utils.readTestData("copy", "registrationPage", "shortSurnameErrorMsg"));
		registrationPage.enterSurname(utils.readTestData("registration", "failure", "30charFirstname"));
		Assert.assertNull(registrationPage.checkSurnameErrorMsg());
	}

	@Test(groups = {"DMPM-185", "DMPM-377","marketplace", "Registration", "priority-major"})
	public void testInlineErrorValidations() {
		navigateToRegistrationPage();
		registrationPage.tapFirstNameField();

		registrationPage.enterFirstName(utils.readTestData("registration", "failure", "specialCharFirstname"));
		Assert.assertEquals(registrationPage.getFirstNameErrorMsg(), utils.readTestData("copy", "registrationPage", "specialCharErrorMsg"));
		registrationPage.tapSurnameField();
		registrationPage.tapFirstNameField();
		Assert.assertEquals(registrationPage.getSurnameErrorMsg(), utils.readTestData("copy", "registrationPage", "fieldErrorMsg"));
		registrationPage.enterFirstName(utils.readTestData("registration", "failure", "noSpecialCharName"));
		Assert.assertNull(registrationPage.checkFirstNameErrorMsg());
		
		registrationPage.enterSurname(utils.readTestData("registration", "failure", "specialCharSurname"));
		Assert.assertEquals(registrationPage.getSurnameErrorMsg(), utils.readTestData("copy", "registrationPage", "specialCharErrorMsg"));
		registrationPage.tapPostcodeField();
		registrationPage.tapSurnameField();
		Assert.assertEquals(registrationPage.getSurnameErrorMsg(), utils.readTestData("copy", "registrationPage", "specialCharErrorMsg"));
		registrationPage.enterSurname(utils.readTestData("registration", "failure", "noSpecialCharName"));
		Assert.assertNull(registrationPage.checkSurnameErrorMsg());
		
	}
	
	@Test(groups = {"DMPM-45", "DMPM-460", "marketplace", "Registration", "priority-minor"})
	public void testDisplayUserTips() {
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
	public void testInlineError2ndPage() {
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
	public void testInlineError2ndPageOnTapOut() {
		navigateToRegistrationPage();
		registrationPage.fill1stPageFields(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"),
				utils.readTestData("registration", "success", "postcode"));
		registrationPage.tapNextButton();
		registrationPage.enterEmail(utils.readTestData("registration", "failure", "invalidEmail"));
		registrationPage.tapMobileNumberField();
		Assert.assertEquals(registrationPage.getInvalidEmailErrorMsg(), utils.readTestData("copy", "registrationPage", "invalidEmailErrorMsg"));
		registrationPage.enterMobile(utils.readTestData("registration", "failure", "mobileInvalidFormat"));
		registrationPage.tapEmailField();
		Assert.assertEquals(registrationPage.getInvalidMobileErrorMsg(), utils.readTestData("copy", "registrationPage", "invalidMobileErrorMsg"));
		Assert.assertEquals(registrationPage.getInvalidEmailErrorMsg(), utils.readTestData("copy", "registrationPage", "invalidEmailErrorMsg"));
		registrationPage.tapMobileNumberField();
		Assert.assertEquals(registrationPage.getInvalidMobileErrorMsg(), utils.readTestData("copy", "registrationPage", "invalidMobileErrorMsg"));
	}
	
	
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
		String errorVal = registrationPage.getInvalidEmailErrorMsg().replace("\n\n", " ");
		Assert.assertEquals(errorVal, utils.readTestData("copy", "registrationPage", "longEmailErrorMsg2"));
		registrationPage.tapEmailField();
		Assert.assertEquals(errorVal, utils.readTestData("copy", "registrationPage", "longEmailErrorMsg2"));
	}
	
	
	@Test(groups = {"DMPM-189", "DMPM-491", "marketplace", "Registration", "priority-minor"})
	public void testCorrectingInvalidData() {
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
	public void testCancelRegistration() {
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
	public void testPasswordSetupScreen() {
		
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
		Assert.assertNotNull(registrationPage.checkRegisterPage3Title(), "Registration Page 3 - User is naviageted back Registration page 3");
		registrationPage.tapCancelButton(); 
	}
	
	
	@Test(groups = {"DMPM-39", "DMPM-531", "marketplace", "Registration", "priority-major"})
	public void testPasswordScreenInlineErrors() {
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
	public void testPasswordFieldValidation() {
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
	public void testPasswordFieldValidationOnSubmit() {
		
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
	public void testUpdatedDatePicker() {
		navigateToRegistrationPage();
		registrationPage.tapDateField();
		Assert.assertNotNull(registrationPage.checkYearPicker(), "Year picker not seen");
	}
	
	// DMPM-2730 : I don't have any credentials
	@Test( groups = { "DMPM-2730","DMPM-2922","DMPM-2925","marketplace", "Registration", "priority-major" })
	public void testNoCredentialsSupportedBrand() {
		navigateToGetStartedPage();
		
		List brandElements = utils.readTestDataList("brands");
		for(Object brandIcons : brandElements) {
			if(welcomePage.checkWelcomeSuncorpImage() != null) {
				navigateToGetStartedPage();
			}
			
			HashMap<String, String> brandIcon = (HashMap<String, String>)brandIcons;
			getStartedPage.tapBrandSelectDropDown();
			Assert.assertNotNull(getStartedPage.checkSelectBrandAlert(), "Select Brand List - The alert is not displayed");
			Assert.assertNotNull(getStartedPage.checkBrandExists(brandIcon.get("brandName")), "Select Brand List - "+brandIcon.get("brandName")+" not displayed");
			getStartedPage.tapBrandFromList(brandIcon.get("brandName"));
			getStartedPage.tapNextButton();

			if(termsAndConditionsPage.checkTermsAndConditionsTitle() != null){
				termsAndConditionsPage.tapAcceptButton();
			}
			Assert.assertNotNull(memberLoginPage.checkNoCredentialsButton(), "Member Login - No Credentials button not displayed");
			
			memberLoginPage.tapNoCredentialsButton();
			Assert.assertNotNull(registrationPage.checkRegisterPage1Title(), "Registration Page - User is not navigated to the Registration page 1");
			registrationPage.tapCancelButton();
		}
	}
	
	// DMPM-213 : Check if post code is valid
	@Test(groups = { "DMPM-213","DMPM-3842","DMPM-3843","marketplace","Registration", "priority-major" })
	public void testPostcodeInlineError() {

		navigateToRegistrationPage();
		
		// check post code field is mandatory error message is displayed on tapping outside the post code field
		registrationPage.enterPostcode("");
		registrationPage.enterSurname("");
		Assert.assertNotNull(registrationPage.checkPostCodeErrorMsg(),"Postcode tooltip inline message is not displayed.");
		Assert.assertEquals(registrationPage.getPostCodeErrorMsg(),utils.readTestData("copy", "registrationPage", "fieldErrorMsg"),
				"Incorrect postcode inline message is displayed");

		// check post code field is mandatory error message is displayed on tapping Next button
		registrationPage.enterPostcode("");
		registrationPage.tapNextButton();
		Assert.assertNotNull(registrationPage.checkPostCodeErrorMsg(),"Postcode tooltip inline message is not displayed.");
		Assert.assertEquals(registrationPage.getPostCodeErrorMsg(),utils.readTestData("copy", "registrationPage", "fieldErrorMsg"),
				"Incorrect postcode inline message is displayed");

		// check invalid post code error message is displayed on tapping Next button
		registrationPage.enterPostcode(utils.readTestData("registration", "failure", "invalidPostcode"));
		registrationPage.tapNextButton();
		Assert.assertNotNull(registrationPage.checkPostCodeErrorMsg(),"Postcode tooltip inline message is not displayed.");
		Assert.assertEquals(registrationPage.getPostCodeErrorMsg(),utils.readTestData("copy", "registration", "invalidPostcodeMessage"),
				"Incorrect postcode inline message is displayed");

		registrationPage.enterPostcode(utils.readTestData("registration", "success", "postcode"));
		registrationPage.tapNextButton();
		Assert.assertNull(registrationPage.checkPostCodeErrorMsg(),"Postcode tooltip inline message is displayed.");

	}

	// DMPM-329 : Updates to Validation of Maximum Length of Fields
	@Test(groups = {"DMPM-329","DMPM-3715","DMPM-3725","marketplace", "Registration", "priority-major" })
	public void testMaximumLengthError() {

		navigateToRegistrationPage();
		
		// check maximum length of first name
		registrationPage.enterFirstName(utils.readTestData("registration", "failure", "longFirstName"));
		Assert.assertNotNull(registrationPage.checkFirstNameErrorMsg(), "First Name inline message is not displayed.");
		Assert.assertEquals(registrationPage.getFirstNameErrorMsg(),utils.readTestData("copy", "registrationPage", "longFirstNameErrorMsg"),
				"Maximum length error message for first name is not displayed");

		registrationPage.clearField("firstNameField");
		
		// check maximum length of  surname
		registrationPage.enterSurname(utils.readTestData("registration", "failure", "longSurname"));
		Assert.assertNotNull(registrationPage.checkSurnameErrorMsg(), "Surname inline message is not displayed.");
		Assert.assertEquals(registrationPage.getSurnameErrorMsg(),utils.readTestData("copy", "registrationPage", "longSurnameErrorMsg"),
				"Maximum length error message for surname is not displayed");

		registrationPage.clearField("surNameField");
	
		registrationPage.fill1stPageFields(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"),
				utils.readTestData("registration", "success", "postcode"));
		
		// check no error message is displayed if first name and surname is within the permitted length limit
		Assert.assertNull(registrationPage.checkFirstNameErrorMsg(), "First Name inline message is displayed.");
		Assert.assertNull(registrationPage.checkSurnameErrorMsg(), "Surname inline message is displayed.");

		registrationPage.tapNextButton();

		// check error message is displayed for long mobile number
		registrationPage.enterMobile(utils.readTestData("registration", "failure", "mobileLong"));
		Assert.assertNotNull(registrationPage.checkMobileErrorMsg(), "Mobile number inline message is not displayed.");
		Assert.assertEquals(registrationPage.getInvalidMobileErrorMsg(),utils.readTestData("copy", "registrationPage", "longMobileErrorMsg"),
				"Maximum length error message for mobile number is not displayed");

		registrationPage.clearField("mobileField");

		// check error message is displayed for long email ID
		registrationPage.enterEmail(utils.readTestData("registration", "failure", "emailLong"));
		Assert.assertNotNull(registrationPage.checkEmailErrorMsg(), "Email inline message is not displayed.");
		String errorVal = registrationPage.getInvalidEmailErrorMsg().replace("\n\n", " ");
		//Validation as user enters value
		Assert.assertEquals(errorVal, utils.readTestData("copy", "registrationPage", "longEmailErrorMsg"),
				"Maximum length error message for email is not displayed");

		registrationPage.clearField("emailField");

		registrationPage.fill2ndPageFields(utils.readTestData("registration", "success", "email"),
				utils.readTestData("registration", "success", "mobile"));

		// check no error message is displayed if mobile number and email id is valid
		Assert.assertNull(registrationPage.checkMobileErrorMsg(), "Mobile number inline message is displayed.");
		Assert.assertNull(registrationPage.checkEmailErrorMsg(), "Email inline message is displayed.");

	}

	// DMPM-1058 : Prevent user name from being used when creating a password
	@Test(groups = { "DMPM-1058","DMPM-1816","DMPM-3817","DMPM-3820","marketplace","Registration", "priority-major" })
	public void testDesiredPasswordError() {

		navigateToRegistrationPage();
		registrationPage.fill1stPageFields(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"),
				utils.readTestData("registration", "success", "postcode"));

		registrationPage.tapNextButton();

		registrationPage.enterEmail(utils.readTestData("registration", "success", "email1"));
		registrationPage.enterMobile(utils.readTestData("registration", "success", "mobile"));

		registrationPage.tapNextButton();

		Assert.assertNotNull(registrationPage.checkPasswordNameRequirements(),"Password name requirements are not displayed.");
		Assert.assertEquals(registrationPage.getPasswordNameRequirementsText(),utils.readTestData("copy", "registrationPage", "passwordNameRequirement"),
				"Incorrect password name requirements are displayed");

		registrationPage.enterPassword(utils.readTestData("registration", "success", "firstName"));
		Assert.assertNotNull(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "firstNamePasswordErrorMsg")),
				"Desired password must not contain first name message is not displayed.");

		registrationPage.enterConfirmPassword("");
		Assert.assertNotNull(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "firstNamePasswordErrorMsg")),
				"Desired password must not contain first name message is not displayed.");

		registrationPage.tapRegisterButton();
		Assert.assertNotNull(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "firstNamePasswordErrorMsg")),
				"Desired password must not contain first name message is not displayed.");

		registrationPage.clearField("desiredPassword");

		registrationPage.enterPassword(utils.readTestData("registration", "success", "surname"));
		Assert.assertNotNull(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "lastNamePasswordErrorMsg")),
				"Desired password must not contain surname message is not displayed.");

		registrationPage.enterConfirmPassword("");
		Assert.assertNotNull(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "lastNamePasswordErrorMsg")),
				"Desired password must not contain surname message is not displayed.");

		registrationPage.tapRegisterButton();
		Assert.assertNotNull(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "lastNamePasswordErrorMsg")),
				"Desired password must not contain surname message is not displayed.");
		registrationPage.clearField("desiredPassword");

		registrationPage.enterPassword(utils.readTestData("registration", "success", "email1"));
		Assert.assertNotNull(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "emailPasswordErrorMsg")),
				"Desired password must not contain email message is not displayed.");

		registrationPage.enterConfirmPassword("");
		Assert.assertNotNull(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "emailPasswordErrorMsg")),
				"Desired password must not contain email message is not displayed.");

		registrationPage.tapRegisterButton();
		Assert.assertNotNull(registrationPage.checkPasswordRequirements(utils.readTestData("copy", "registrationPage", "emailPasswordErrorMsg")),
				"Desired password must not contain email message is not displayed.");

	}
	

	// DMPM-38 : Check Uniqueness of Email Address Used for Registration
	@Test(groups = {"DMPM-38", "DMPM-2469", "DMPM-2470", "DMPM-2471", "DMPM-2474", "marketplace", "Registration",
			"priority-major" })
	public void testDuplicateEmailId() {

		navigateToRegistrationPage();
		registrationPage.fill1stPageFields(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"),
				utils.readTestData("registration", "success", "postcode"));

		registrationPage.tapNextButton();

		// Enter email id which already exists
		registrationPage.enterEmail(utils.readTestData("loginCredentials", "validLoginCredentials","login"));
		registrationPage.enterMobile(utils.readTestData("registration", "success", "mobile"));

		registrationPage.tapNextButton();

		Assert.assertNotNull(registrationPage.checkDuplicateEmailPopUpTitle(),"Duplicate email alert pop up is not displayed on registration.");

		// Check the elements on the pop up alert
		Assert.assertEquals(registrationPage.getDuplicateEmailPopUpTitle(),utils.readTestData("copy", "registrationPage", "duplicateEmailPopUpTitle"),
				"Duplicate email alert pop up title is not correct");

		Assert.assertEquals(registrationPage.getDuplicateEmailPopUpText(),utils.readTestData("copy", "registrationPage", "duplicateEmailPopUpText"),
				"Duplicate email alert pop up title is not correct");

		Assert.assertEquals(registrationPage.getDuplicateEmailPopUpOkButtonLabel(),utils.readTestData("copy", "registrationPage", "duplicateEmailPopUpOkButtonText"),
				"Duplicate email alert pop up title is not correct");

		Assert.assertEquals(registrationPage.getDuplicateEmailPopUpAnotherLoginButtonLabel().toUpperCase(), Copy.DUPLICTE_EMAIL_POPUP_USE_ANOTHER_EMAIL_BUTTON_TEXT,
				"Duplicate email alert pop up title is not correct");

		registrationPage.tapOkButton();

		// Check pop up alert is dismissed on tapping Ok button
		Assert.assertNotNull(registrationPage.checkRegisterPage2Title(),"Registration Page 2 is not displayed on registration.");

		registrationPage.tapNextButton();

		Assert.assertNotNull(registrationPage.checkDuplicateEmailPopUpTitle(),"Duplicate email alert pop up is not displayed on registration.");

		registrationPage.tapLoginWithThisEmailButton();

		Assert.assertEquals(loginPage.getLoginPageTitle(), utils.readTestData("copy", "loginPage", "loginPageTitle"),
				"Login page title is not shown as expected");
		
		Assert.assertNotNull(loginPage.getEmailFieldData().contains(utils.readTestData("loginCredentials", "validLoginCredentials","login")), "Email field is not pre populated with email as expected");
	}

	private void navigateToRegistrationPage() {
		// To check if the user is already logged in
		if(loginAuthPage.checkChangeAccountButton() != null) {
			loginAuthPage.tapChangeAccountButton();
		}
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		Assert.assertNotNull(welcomePage.checkRegisterButton(), "Welcome screen - Register button is not shown");
		welcomePage.tapRegisterButton();
		if(getStartedPage.checkSetupNewAccountButton() != null) {
			getStartedPage.tapSetupNewAccount();
		}
		Assert.assertNotNull(termsAndConditionsPage.checkTermsAndConditionsTitle(), "Terms and Condition - Terms and Condition page is not displayed");
		termsAndConditionsPage.tapAcceptButton();
		Assert.assertNotNull(registrationPage.checkRegistrationPageTitle(), "Registration page not loaded");
	}
	
	private void navigateToGetStartedPage() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		Assert.assertNotNull(welcomePage.checkRegisterButton(), "Welcome screen - Register button is not shown");
		welcomePage.tapRegisterButton();
		Assert.assertNotNull(getStartedPage.checkGetStartedPageTitle(), "Get started page not loaded");

	}
	

}