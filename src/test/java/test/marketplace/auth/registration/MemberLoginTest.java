package test.marketplace.auth.registration;

import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.App;

public class MemberLoginTest extends App {

	private void navigateToWelcomeToSuncorpPage() {
		welcomePage.checkWelcomeSuncorpImage();
		welcomePage.tapRegisterButton();
		getStartedPage.checkGetStartedPageTitle();
	}

	// DMPM-1493 Scenario 1
	// DMPM-2730 Scenario 1
	@Test(groups = {"DMPM-1493", "DMPM-2738", "marketplace", "Registration", "priority-high"})
	public void testMemberLoginPageElements() {
		navigateToWelcomeToSuncorpPage();
		List brandElements = utils.readTestDataList("brands");
		for(Object brandIcons : brandElements) {
			commonMemberLoginCheck(brandIcons);
		}
	}

	private void commonMemberLoginCheck(Object brandIcons) {
		HashMap<String, String> brandIcon = (HashMap<String, String>)brandIcons;
		getStartedPage.checkMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));
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
			commonPasswordFieldRequirements(brandIcons);
		}
	}

	private void commonPasswordFieldRequirements(Object brandIcons) {
		HashMap<String, String> brandIcon = (HashMap<String, String>)brandIcons;
		getStartedPage.checkMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));
		getStartedPage.tapMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));

		memberLoginPage.enterPassword(utils.readTestData("loginCredentials", "validLoginCredentials", "pwd"));
		Assert.assertEquals(memberLoginPage.getPasswordFieldValue(), utils.readTestData("loginCredentials", "validLoginCredentials", "maskedValidPwd"), "Member Login Page - Data is not masked");
		memberLoginPage.relaunchApp(-1, "Config");
		Assert.assertEquals(loginPage.getPasswordFieldValue(), "", "Login screen - Password field is not empty");
		memberLoginPage.tapCancelButton();
	}

	// DMPM-1493 Scenario 4, 5, 7
	@Test(groups = {"DMPM-1493", "DMPM-2755", "DMPM-2757", "DMPM-2759", "marketplace", "Registration", "priority-high"})
	public void testInlineValidation() {
		navigateToWelcomeToSuncorpPage();
		List brandElements = utils.readTestDataList("brands");
		for(Object brandIcons : brandElements) {
			commonMemberLoginInlineValidation(brandIcons, "passwordField");
		}

		for(Object brandIcons : brandElements) {
			commonMemberLoginInlineValidation(brandIcons, "nextButton");
		}
	}

	private void commonMemberLoginInlineValidation(Object brandIcons, String tapOn) {
		HashMap<String, String> brandIcon = (HashMap<String, String>)brandIcons;
		getStartedPage.checkMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));
		getStartedPage.tapMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));

		String errorVal = "";
		/** Tapping out of the Field **/
		//Empty Email Error
		memberLoginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailEmpty"));
		memberLoginPage.tapOn(tapOn);
		Assert.assertEquals(memberLoginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "emptyEmailError"));

		//Email length more than 100 characters
		memberLoginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailExceedsMaxLength"));
		memberLoginPage.tapOn(tapOn);
		Assert.assertEquals(memberLoginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "longEmailError"));

		//Email length less than 2 characters
		memberLoginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailMinLength"));
		memberLoginPage.tapOn(tapOn);
		errorVal = memberLoginPage.getEmailFieldErrorValue().replace("\n\n", " ");
		Assert.assertEquals(errorVal, utils.readTestData("copy", "loginPage", "shortEmailError"));

		//Incorrect email format 1
		memberLoginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailIncorrectFormat1"));
		memberLoginPage.tapOn(tapOn);
		Assert.assertEquals(memberLoginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "invalidEmailError"));

		//Incorrect email format 2
		memberLoginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailIncorrectFormat2"));
		memberLoginPage.tapOn(tapOn);
		Assert.assertEquals(memberLoginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "invalidEmailError"));

		//Empty password - only inline error displayed for password
		memberLoginPage.enterPassword(utils.readTestData("loginCredentials", "invalidCredentials","passwordEmpty"));
		if (tapOn == "passwordField") {
			memberLoginPage.tapEmailField();
		}
		else
			memberLoginPage.tapOn(tapOn);
		Assert.assertEquals(memberLoginPage.getPasswordFieldErrorValue(), utils.readTestData("copy", "loginPage", "emptyPasswordError"));

		memberLoginPage.tapCancelButton();
	}

	// DMPM-1493 Scenario 6
	@Test(groups = {"DMPM-1493", "DMPM-2738", "marketplace", "Registration", "priority-high"})
	public void testInlineValidationsHiding() {
		navigateToWelcomeToSuncorpPage();
		List brandElements = utils.readTestDataList("brands");
		for(Object brandIcons : brandElements) {
			commonMemberLoginValidationsHiding(brandIcons);
		}
	}

	private void commonMemberLoginValidationsHiding(Object brandIcons) {
		HashMap<String, String> brandIcon = (HashMap<String, String>)brandIcons;
		getStartedPage.checkMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));
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

	// DMPM-2730 Scenario 2
	//	@Test(groups = {"DMPM-2730", "DMPM-2925", "marketplace", "Registration", "priority-medium"})
	//	public void testNoCredentials() {
	//		navigateToWelcomeToSuncorpPage();
	//		List brandElements = utils.readTestDataList("brands");
	//		for(Object brandIcons : brandElements) {
	//			commonNoCredentialsOption(brandIcons);
	//		}
	//	}
	//
	//	private void commonNoCredentialsOption(Object brandIcons) {
	//		HashMap<String, String> brandIcon = (HashMap<String, String>)brandIcons;
	//		getStartedPage.checkMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));
	//		getStartedPage.tapMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));
	//
	//		memberLoginPage.tapNoCredentialsButton();
	//		Assert.assertNotNull(registrationPage.checkRegistrationPageTitle(), "Registration Page - User not navigated to the Register page");
	//		registrationPage.tapCancelButton();
	//		memberLoginPage.tapCancelButton();
	//	}

	// DMPM-2098 Scenario 1, 2, 3
	// DMPM-2730 Scenario 8
	@Test(groups = {"DMPM-2098", "DMPM-3571", "DMPM-3572", "DMPM-3573", "DMPM-2730", "DMPM-2760", "marketplace", "Registration", "priority-high"})
	public void testRegisterMemberLogin() {
		navigateToWelcomeToSuncorpPage();
		List brandElements = utils.readTestDataList("brands");
		for(Object brandIcons : brandElements) {
			commonRegisterMemberLogin(brandIcons);
		}
	}

	private void commonRegisterMemberLogin(Object brandIcons) {
		HashMap<String, String> brandIcon = (HashMap<String, String>)brandIcons;
		if(welcomePage.checkWelcomeSuncorpImage() != null){
			navigateToWelcomeToSuncorpPage();
		}
		getStartedPage.checkMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));
		getStartedPage.tapMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));

		memberLoginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validMemberLogin", "login"), utils.readTestData("loginCredentials", "validMemberLogin", "pwd"));
		memberLoginPage.tapNextButton();

		Assert.assertNotNull(memberLoginPage.checkMobileRegisterPageTitle(), "Mobile Register - Almost there! Page not displayed");
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
}
