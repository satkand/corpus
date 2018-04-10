package test.marketplace.auth.registration;

import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import pages.App;

public class MemberLoginTest extends App {
	
	String errorVal; //To be used for inline errors

	private void navigateToWelcomeToSuncorpPage() {
		if(loginAuthPage.checkChangeAccountButton() != null) {
			loginAuthPage.tapChangeAccountButton();
		}
		
		welcomePage.checkWelcomeSuncorpImage();
		welcomePage.tapRegisterButton();
		getStartedPage.checkGetStartedPageTitle();
	}

	// DMPM-1493 Scenario 1
	// DMPM-2730 Scenario 1
	@Test(groups = {"DMPM-1493", "DMPM-2738", "DMPM-2730", "DMPM-2922", "marketplace", "Registration", "priority-high"})
	public void testMemberLoginPageElements() {
		navigateToWelcomeToSuncorpPage();
		List brandElements = utils.readTestDataList("brands");
		for(Object brandIcons : brandElements) {
			commonMemberLoginCheckMethod(brandIcons);
		}
	}

	private void commonMemberLoginCheckMethod(Object brandIcons) {
		HashMap<String, String> brandIcon = (HashMap<String, String>)brandIcons;
		Assert.assertNotNull(getStartedPage.checkMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value")), "Get Started Page - Member login icon not displayed");
		getStartedPage.tapMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));
		Assert.assertEquals(memberLoginPage.getPageTitle(), brandIcon.get("brandIcon"));
		Assert.assertNotNull(memberLoginPage.checkCancelButton(), "Member Login - Cancel button not displayed");
		Assert.assertNotNull(memberLoginPage.checkEmailField(), "Member Login - Email field not displayed");
		Assert.assertNotNull(memberLoginPage.checkPasswordField(), "Member Login - Password field not displayed");
		Assert.assertNotNull(memberLoginPage.checkNextButton(), "Member Login - Next button not displayed");
		Assert.assertNotNull(memberLoginPage.checkForgotPasswordButton(), "Member Login - Forgot Password button not displayed");
		Assert.assertNotNull(memberLoginPage.checkNoCredentialsButton(), "Member Login - No Credentials button not displayed");
		memberLoginPage.tapCancelButton();
	}

	// DMPM-1493 Scenario 2, 3
	@Test(groups = {"DMPM-1493", "DMPM-2741", "DMPM-2743", "marketplace", "Registration", "priority-medium"})
	public void testPasswordFieldValidations() {
		navigateToWelcomeToSuncorpPage();
		List brandElements = utils.readTestDataList("brands");
		for(Object brandIcons : brandElements) {
			commonPasswordFieldRequirementsMethod(brandIcons);
		}
	}

	private void commonPasswordFieldRequirementsMethod(Object brandIcons) {
		HashMap<String, String> brandIcon = (HashMap<String, String>)brandIcons;
		Assert.assertNotNull(getStartedPage.checkMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value")), "Get Started Page - Member login icon not displayed");
		getStartedPage.tapMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));

		memberLoginPage.enterPassword(utils.readTestData("loginCredentials", "validLoginCredentials", "pwd"));
		Assert.assertEquals(memberLoginPage.getPasswordFieldValue(), utils.readTestData("loginCredentials", "validLoginCredentials", "maskedValidPwd"), "Member Login Page - Data is not masked");
		memberLoginPage.relaunchApp(-1, "Config");
		Assert.assertEquals(memberLoginPage.getPasswordFieldValue(), "", "Member Login Page - Password field is not empty");
		memberLoginPage.tapCancelButton();
	}

	// DMPM-1493 Scenario 4, 5, 7
	@Test(groups = {"DMPM-1493", "DMPM-2755", "DMPM-2757", "DMPM-2759", "marketplace", "Registration", "priority-high"})
	public void testInlineValidation() {
		navigateToWelcomeToSuncorpPage();
		List brandElements = utils.readTestDataList("brands");
		for(Object brandIcons : brandElements) {
			commonMemberLoginInlineValidationMethod(brandIcons, "passwordField");
		}

		for(Object brandIcons : brandElements) {
			commonMemberLoginInlineValidationMethod(brandIcons, "nextButton");
		}
	}

	private void commonMemberLoginInlineValidationMethod(Object brandIcons, String tapOn) {
		HashMap<String, String> brandIcon = (HashMap<String, String>)brandIcons;
		Assert.assertNotNull(getStartedPage.checkMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value")), "Get Started Page - Member login icon not displayed");
		getStartedPage.tapMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));

		String errorVal = "";
		/** Tapping out of the Field **/
		//Empty Email Error
		memberLoginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailEmpty"));
		memberLoginPage.tapOn(tapOn);
		Assert.assertEquals(memberLoginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "emptyEmailError"), "Member Login - Email error displayed is incorrect");

		//Email length more than 100 characters
		memberLoginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailExceedsMaxLength"));
		memberLoginPage.tapOn(tapOn);
		Assert.assertEquals(memberLoginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "longEmailError"), "Member Login - Email error displayed is incorrect");

		//Email length less than 2 characters
		memberLoginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailMinLength"));
		memberLoginPage.tapOn(tapOn);
		errorVal = memberLoginPage.getEmailFieldErrorValue().replace("\n\n", " ");
		Assert.assertEquals(errorVal, utils.readTestData("copy", "loginPage", "shortEmailError"), "Member Login - Email error displayed is incorrect");

		//Incorrect email format 1
		memberLoginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailIncorrectFormat1"));
		memberLoginPage.tapOn(tapOn);
		Assert.assertEquals(memberLoginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "invalidEmailError"), "Member Login - Email error displayed is incorrect");

		//Incorrect email format 2
		memberLoginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailIncorrectFormat2"));
		memberLoginPage.tapOn(tapOn);
		Assert.assertEquals(memberLoginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "invalidEmailError"), "Member Login - Email error displayed is incorrect");

		//Empty password - only inline error displayed for password
		memberLoginPage.enterPassword(utils.readTestData("loginCredentials", "invalidCredentials","passwordEmpty"));
		if (tapOn == "passwordField") {
			memberLoginPage.tapEmailField();
		}
		else
			memberLoginPage.tapOn(tapOn);
		Assert.assertEquals(memberLoginPage.getPasswordFieldErrorValue(), utils.readTestData("copy", "loginPage", "emptyPasswordError"), "Member Login - Password error displayed is incorrect");

		memberLoginPage.tapCancelButton();
	}

	// DMPM-1493 Scenario 6
	@Test(groups = {"DMPM-1493", "DMPM-2738", "marketplace", "Registration", "priority-high"})
	public void testInlineValidationsHiding() {
		navigateToWelcomeToSuncorpPage();
		List brandElements = utils.readTestDataList("brands");
		for(Object brandIcons : brandElements) {
			commonMemberLoginValidationsHidingMethod(brandIcons);
		}
	}

	private void commonMemberLoginValidationsHidingMethod(Object brandIcons) {
		HashMap<String, String> brandIcon = (HashMap<String, String>)brandIcons;
		Assert.assertNotNull(getStartedPage.checkMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value")), "Get Started Page - Member login icon not displayed");
		getStartedPage.tapMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));

		String errorVal = "";
		memberLoginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "invalidCredentials", "emailMinLength"), "");
		memberLoginPage.tapNextButton();
		errorVal = memberLoginPage.getEmailFieldErrorValue().replace("\n\n", " ");
		Assert.assertEquals(errorVal, utils.readTestData("copy", "loginPage", "shortEmailError"));
		Assert.assertEquals(memberLoginPage.getPasswordFieldErrorValue(),utils.readTestData("copy", "loginPage", "emptyPasswordError"));

		//Check inline errors exist when field is highlighted
		memberLoginPage.tapEmailField();
		Assert.assertEquals(errorVal, utils.readTestData("copy", "loginPage", "shortEmailError"));
		memberLoginPage.tapPasswordField();
		Assert.assertEquals(memberLoginPage.getPasswordFieldErrorValue(), utils.readTestData("copy", "loginPage", "emptyPasswordError"));
		//Check inline errors are removed as valid credentials are entered
		memberLoginPage.enterEmail(utils.readTestData("loginCredentials", "validLoginCredentials", "login"));
		Assert.assertNull(memberLoginPage.checkEmailFieldError());
		memberLoginPage.enterPassword("a");
		Assert.assertNull(memberLoginPage.checkPasswordFieldError());

		memberLoginPage.tapCancelButton();
	}

	// DMPM-2098 Scenario 1, 2, 3
	// DMPM-1493 Scenario 8
	// DMPM-1545 Scenario 1, 8
	// DMPM-2362 Scenario 1, 2, 3
	// DMPM-45 Scenario 1
	@Test(groups = {"DMPM-2098", "DMPM-3571", "DMPM-3572", "DMPM-3573", "DMPM-2730", "DMPM-2760", "DMPM-1545", "DMPM-3552", "DMPM-3560", "DMPM-45", "marketplace", "Registration", "priority-high"})
	public void testSuccessfulMemberLogin() {
		navigateToWelcomeToSuncorpPage();
		List brandElements = utils.readTestDataList("brands");
		for(Object brandIcons : brandElements) {
			commonSuccessfulMemberLoginMethod(brandIcons);
		}
	}

	private void commonSuccessfulMemberLoginMethod(Object brandIcons) {
		HashMap<String, String> brandIcon = (HashMap<String, String>)brandIcons;
		if(welcomePage.checkWelcomeSuncorpImage() != null){
			navigateToWelcomeToSuncorpPage();
		}
		Assert.assertNotNull(getStartedPage.checkMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value")), "Get Started Page - Member login icon not displayed");
		getStartedPage.tapMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));

		memberLoginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validMemberLogin", "login"), utils.readTestData("loginCredentials", "validMemberLogin", "pwd"));
		memberLoginPage.tapNextButton();

		Assert.assertNotNull(memberLoginPage.checkMobileRegisterPageTitle(), "Mobile Register - Almost there! Page not displayed");
		Assert.assertNotNull(memberLoginPage.checkMobileRegisterPageDescription(), "Mobile Register - Description to the user not shown");
		Assert.assertNotNull(memberLoginPage.checkMobileTextField(), "Mobile Register - Mobile number text field");
		Assert.assertNotNull(memberLoginPage.checkRegiterWithMobileButton(), "Mobile Register - Register button not displayed");
		Assert.assertNotNull(memberLoginPage.checkNoMarketingTermsText(), "Mobile Register - No Marketing terms text not displayed");
		memberLoginPage.tapMobileTextField();
		Assert.assertEquals(memberLoginPage.getMobileNumberTipText(), Copy.MOBILE_NUMBER_TIP, "Mobile Register - Mobile number tool tip text is incorrect");
		
		memberLoginPage.enterMobileNumber(utils.readTestData("registration", "success", "mobile"));
		memberLoginPage.tapRegisterButton();

		Assert.assertNotNull(pinOptionsPage.checkPinPromptUserWelcome(), "PIN Option Page - Pin Enable option not displayed");
		pinOptionsPage.tapMaybeLater();
		Assert.assertNotNull(landingPage.checkLandingPageTitle(), "Landing Page - Landing page title not displayed");
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkLockMenuOption(), "Navigation Menu - Nav menu not loaded properly");
		navigationMenu.tapLockMenuOption();

		if(loginAuthPage.checkChangeAccountButton() != null) {
			loginAuthPage.tapChangeAccountButton();
		}
	}
	
	
	// DMPM-1545 Scenario 2, 3, 4, 6
	@Test(groups = {"DMPM-1545", "marketplace", "Registration", "priority-medium"})
	public void testMobileNumberValidations() {
		navigateToWelcomeToSuncorpPage();
		List brandElements = utils.readTestDataList("brands");
		for(Object brandIcons: brandElements) {
			commonMobileNumberValidationsMethod(brandIcons);
		}
	}
	
	private void commonMobileNumberValidationsMethod(Object brandIcons) {
		HashMap<String, String> brandIcon = (HashMap<String, String>) brandIcons;
		Assert.assertNotNull(getStartedPage.checkMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value")), "Get Started Page - Member login icon not displayed");
		getStartedPage.tapMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));
		
		memberLoginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validMemberLogin", "login"), utils.readTestData("loginCredentials", "validMemberLogin", "pwd"));
		memberLoginPage.tapNextButton();
		Assert.assertNotNull(memberLoginPage.checkMobileRegisterPageTitle(), "Mobile Register - Almost there! Page not displayed");
		
		memberLoginPage.tapMobileTextField();
		Assert.assertTrue(memberLoginPage.checkKeyboard(), "Mobile Register - Keyboard not displayed");
		
		// Invalid mobile number - does not start with 04
		memberLoginPage.enterMobileNumber(utils.readTestData("registration", "failure", "mobileInvalidFormat"));
		memberLoginPage.tapRegisterButton();
		errorVal = memberLoginPage.getMobileFieldError().replaceAll("\n\n", " ");
		Assert.assertEquals(errorVal, utils.readTestData("copy", "memberLogin", "invalidMobileNumberError"), "Member Register - Error dislpayed is not correct");
		
		// Empty mobile number
		memberLoginPage.enterMobileNumber(utils.readTestData("registration", "failure", "mobileEmpty"));
		memberLoginPage.tapRegisterButton();
		errorVal = memberLoginPage.getMobileFieldError().replaceAll("\n\n", " ");
		Assert.assertEquals(errorVal, utils.readTestData("copy", "memberLogin", "emptyMobileNumberError"), "Member Register - Error dislpayed is not correct");
		
		// Short mobile number
		memberLoginPage.enterMobileNumber(utils.readTestData("registration", "failure", "mobileShort"));
		memberLoginPage.tapRegisterButton();
		errorVal = memberLoginPage.getMobileFieldError().replaceAll("\n\n", " ");
		//TODO - Short mobile number starting with 04XXXX need to be checked
		Assert.assertEquals(errorVal, utils.readTestData("copy", "memberLogin", "shortMobileNumberError"), "Member Register - Error dislpayed is not correct");
		
		memberLoginPage.tapCancelButton();
	}
	
	// DMPM-1545 Scenario 7
	@Test(groups = {"DMPM-1545", "DMPM-3559", "marketplace", "Registration", "priority-high"})
	public void testBackCancelBehaviour() {
		navigateToWelcomeToSuncorpPage();
		List brandElements = utils.readTestDataList("brands");
		for (Object brandIcons : brandElements) {
			commonBackCancelMethod(brandIcons);
		}
	}
	
	private void commonBackCancelMethod(Object brandIcons) {
		HashMap<String, String> brandIcon = (HashMap<String, String>) brandIcons;
		Assert.assertNotNull(getStartedPage.checkMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value")), "Get Started Page - Member login icon not displayed");
		getStartedPage.tapMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));
		
		memberLoginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validMemberLogin", "login"), utils.readTestData("loginCredentials", "validMemberLogin", "pwd"));
		memberLoginPage.tapNextButton();
		Assert.assertNotNull(memberLoginPage.checkMobileRegisterPageTitle(), "Mobile Register - Almost there! Page not displayed");
		
		memberLoginPage.tapBackBtn();
		Assert.assertEquals(memberLoginPage.getPageTitle(), brandIcon.get("brandIcon"), "Member Login Page - User is not navigated to the Get");
		Assert.assertTrue(memberLoginPage.getEmailFieldValue().contains(utils.readTestData("loginCredentials", "validMemberLogin", "login")), "Member Login Page - Email value not present or do not match to entered value");
		Assert.assertEquals(memberLoginPage.getPasswordFieldValue(), "", "Member Login Page - Password field is not empty");
		
		memberLoginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validMemberLogin", "login"), utils.readTestData("loginCredentials", "validMemberLogin", "pwd"));
		memberLoginPage.tapNextButton();
		Assert.assertNotNull(memberLoginPage.checkMobileRegisterPageTitle(), "Mobile Register - Almost there! Page not displayed");
		
		memberLoginPage.tapCancelButton();
		Assert.assertNotNull(getStartedPage.checkGetStartedPageTitle(), "Get Started Page - User is not navigated to the Get Started Page");
	}
	
	// DMPM-1545 Scenario 5
	@Test(groups = {"DMPM-1545", "DMPM-3557", "marketplace", "Registration", "priority-high"})
	public void testCorrectingInlineValidationError() {
		navigateToWelcomeToSuncorpPage();
		List brandElements = utils.readTestDataList("brands");
		for (Object brandIcons : brandElements) {
			commonMobileValidationCorrectionMethod(brandIcons);
		}
	}
	
	private void commonMobileValidationCorrectionMethod(Object brandIcons) {
		HashMap<String, String> brandIcon = (HashMap<String, String>) brandIcons;
		Assert.assertNotNull(getStartedPage.checkMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value")), "Get Started Page - Member login icon not displayed");
		getStartedPage.tapMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));
		
		memberLoginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validMemberLogin", "login"), utils.readTestData("loginCredentials", "validMemberLogin", "pwd"));
		memberLoginPage.tapNextButton();
		Assert.assertNotNull(memberLoginPage.checkMobileRegisterPageTitle(), "Mobile Register - Almost there! Page not displayed");
		
		memberLoginPage.enterMobileNumber(utils.readTestData("registration", "failure", "mobileShort"));
		memberLoginPage.tapRegisterButton();
		errorVal = memberLoginPage.getMobileFieldError().replaceAll("\n\n", " ");
		//TODO - Short mobile number error for number starting with '04' is to be checked with Sucharitha for new changes
		Assert.assertEquals(errorVal, utils.readTestData("copy", "memberLogin", "shortMobileNumberError"), "Member Register - Error dislpayed is not correct");
		
		memberLoginPage.enterMobileNumber(utils.readTestData("registration", "success", "mobile"));
		Assert.assertNull(memberLoginPage.checkMobileFieldError(), "Member Register - Error is still displayed");
		
		memberLoginPage.tapCancelButton();
	}
	
	// DMPM-2362 Scenario 4, 5
	@Test(groups = {"DMPM-2362", "DMPM-4211", "DMPM-4212", "marketplace", "Registration", "priority-high"})
	public void testInvalidCredentialsMemberLogin() {
		navigateToWelcomeToSuncorpPage();
		List brandElements = utils.readTestDataList("brands");
		for (Object brandIcons : brandElements) {
			commonInvalidCredentialsMemberLoginMethod(brandIcons);
		}
	}
	
	private void commonInvalidCredentialsMemberLoginMethod(Object brandIcons) {
		HashMap<String, String> brandIcon = (HashMap<String, String>) brandIcons;
		Assert.assertNotNull(getStartedPage.checkMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value")), "Get Started Page - Member login icon not displayed");
		getStartedPage.tapMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));
		
		memberLoginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validMemberLogin", "login"), utils.readTestData("loginCredentials", "invalidCredentials", "invalidMemberLoginPwd"));
		memberLoginPage.tapNextButton();
		
		Assert.assertNotNull(memberLoginPage.checkSnackbarDisplayed(), "Member Login - Snackbar is not displayed");
		Assert.assertEquals(memberLoginPage.getSnackbarText(), utils.readTestData("copy", "memberLogin", "incorrectCredentialsSnackbarText"), "Member Login - Snackbar text is not correct fot incorrect credentials");
		memberLoginPage.tapSnackbarOkButton();
		
		Assert.assertEquals(memberLoginPage.getPageTitle(), brandIcon.get("brandIcon"), "Member Login Page - Title is not correct");	
		memberLoginPage.tapCancelButton();
	}
	
	//DMPM-1481 Scenario 1, 3, 4
		@Test(groups = {"DMPM-1481", "DMPM-3544", "DMPM-3546", "DMPM-3547", "marketplace", "Registration", "priority-medium"})
		public void testSuncorpLoginCredentials() {
			navigateToWelcomeToSuncorpPage();
			List brandElements = utils.readTestDataList("brands");
			for (Object brandIcons : brandElements) {
				HashMap<String, String> brandIcon = (HashMap<String, String>)brandIcons;
				Assert.assertNotNull(getStartedPage.checkMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value")), "Get Started Page - Member login icon not displayed");
				getStartedPage.tapMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));
				
				// Test with valid credentials
				memberLoginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validLoginCredentials", "login"), utils.readTestData("loginCredentials", "validLoginCredentials", "pwd"));
				memberLoginPage.tapNextButton();
				
				Assert.assertNotNull(pinOptionsPage.checkPinPromptUserWelcome(), "PIN Option Page - Pin Enable option not displayed");
				pinOptionsPage.tapMaybeLater();
				Assert.assertNotNull(landingPage.checkLandingPageTitle(), "Landing Page - Landing page title not displayed");
				navigationMenu.tapSplitMenuIcon();
				Assert.assertNotNull(navigationMenu.checkLockMenuOption(), "Navigation Menu - Nav menu not loaded properly");
				navigationMenu.tapLockMenuOption();

				// Test with invalid credentials
				navigateToWelcomeToSuncorpPage();
				Assert.assertNotNull(getStartedPage.checkMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value")), "Get Started Page - Member login icon not displayed");
				getStartedPage.tapMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));
				
				memberLoginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validLoginCredentials", "login"), utils.readTestData("loginCredentials", "invalidCredentials", "invalidPassword"));
				memberLoginPage.tapNextButton();
				
				Assert.assertNotNull(memberLoginPage.checkSnackbarDisplayed(), "Member Login Page - Error Snackbar not displayed");
				memberLoginPage.tapSnackbarOkButton();
				Assert.assertEquals(memberLoginPage.getPageTitle(), brandIcon.get("brandIcon"), "User not back on the"+brandIcon.get("brandIcon"));
				
				memberLoginPage.tapCancelButton();
			}
		}
		
		// DMPM-1481 Scenario 2
		@Test(groups = {"DMPM-1481", "DMPM-3545", "marketplace", "Registration", "priority-medium"})
		public void testSuncorpInsuranceCredentials() {
			navigateToWelcomeToSuncorpPage();
			
			getStartedPage.tapSuncorpBrandIcon();
			Assert.assertNotNull(getStartedPage.checkSuncorpAccountOptionsSheet(), "Get Started - Suncorp login options sheet not displayed");
			getStartedPage.tapSuncorpInsuranceButton();
			Assert.assertNotNull(loginPage.checkLoginPageTitle(), "Login Page - User is not navigated to the login page");
			loginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validLoginCredentials", "login"), utils.readTestData("loginCredentials", "validLoginCredentials", "pwd"));
			loginPage.tapLoginButton();
			
			Assert.assertNotNull(pinOptionsPage.checkPinPromptUserWelcome(), "PIN Option Page - Pin Enable option not displayed");
			pinOptionsPage.tapMaybeLater();
			Assert.assertNotNull(landingPage.checkLandingPageTitle(), "Landing Page - Landing page title not displayed");
			navigationMenu.tapSplitMenuIcon();
			Assert.assertNotNull(navigationMenu.checkLockMenuOption(), "Navigation Menu - Nav menu not loaded properly");
			navigationMenu.tapLockMenuOption();
		}
}
