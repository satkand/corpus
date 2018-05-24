package test.marketplace.auth.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import automation.framework.common.Copy;
import pages.App;

public class LoginTest extends App {

	//DMPM-43 - Scenario-1
	@Test (groups = {"DMPM-43", "DMPM-207", "marketplace", "login", "priority-medium"})
	public void testLoginPageElements() {
		navigateToLoginScreen();
		Assert.assertNotNull(loginPage.checkLoginPageTitle(), "Login screen - page title is not shown");
		Assert.assertEquals(loginPage.getLoginPageTitle(), utils.readTestData("copy", "loginPage", "loginPageTitle"), "Login page title is not shown as expected");
		Assert.assertNotNull(loginPage.checkEmailField(), "Login screen - email field is not shown");
		Assert.assertNotNull(loginPage.checkPasswordField(), "Login screen - password is not shown");
		Assert.assertNotNull(loginPage.checkLoginButton(), "Login screen - login button is not shown");
		Assert.assertNotNull(loginPage.checkForgotPasswordButton(), "Login screen - Forgot Password button is not shown");
		Assert.assertNotNull(loginPage.checkBackButton(), "Login screen - back button is not shown");
	}

	//DMPM-43 - Scenario-2
	@Test (groups = {"DMPM-43", "DMPM-208", "marketplace", "login", "priority-medium"})
	public void testKeyboardDisplay() {
		navigateToLoginScreen();

		// Asserting that keyboard is not shown before tapping on email field and also keyboard is shown after tapping on email field
		Assert.assertFalse(common.isKeyboardShown(), "keyboard is shown");
		loginPage.tapEmailField();
		//Dismissing the keyboard after verification
		Assert.assertTrue(common.isKeyboardShown(), "keyboard not shown");

		// Asserting that keyboard is not shown before tapping on password field and also keyboard is shown after tapping on password field
		Assert.assertFalse(common.isKeyboardShown(), "keyboard is shown");
		loginPage.tapPasswordField();
		//Dismissing the keyboard after verification
		Assert.assertTrue(common.isKeyboardShown(), "keyboard not shown");
	}

	//DMPM-43 - Scenario-3
	@Test (groups = {"DMPM-43", "DMPM-211", "marketplace", "login", "priority-minor"})
	public void testClearPasswordField() {
		navigateToLoginScreen();
		loginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validLoginCredentials", "login"), utils.readTestData("loginCredentials", "invalidCredentials", "invalidPassword"));
		//Putting the app in background indefinitely and launching it using currentActivity method
		loginPage.relaunchApp(-1, "Config");
		Assert.assertNotNull(loginPage.checkLoginPageTitle(), "Login screen - page title is not shown");
		Assert.assertEquals(loginPage.getPasswordFieldValue(), "", "VLogin screen - Password field is not empty");
	}

	//DMPM-43 - Scenario-4,5
	//DMPM-235 - Scenario-1,2,5

	@Test (groups = {"DMPM-43", "DMPM-293", "DMPM-235", "DMPM-912", "DMPM-912", "DMPM-915", "marketplace", "login", "priority-medium"})
	public void testInlineValidation() {

		String errorVal = "";
		navigateToLoginScreen();

		/** Tapping out of the Field **/
		//Empty Email Error
		loginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailEmpty"));
		loginPage.tapPasswordField();
		Assert.assertEquals(loginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "emptyEmailError"));

		//Email length more than 100 characters
		loginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailExceedsMaxLength"));
		loginPage.tapPasswordField();
		Assert.assertEquals(loginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "longEmailError"));

		//Email length less than 2 characters
		loginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailMinLength"));
		loginPage.tapPasswordField();
		errorVal = loginPage.getEmailFieldErrorValue().replace("\n\n", " ");
		Assert.assertEquals(errorVal, utils.readTestData("copy", "loginPage", "shortEmailError"));

		//Incorrect email format 1
		loginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailIncorrectFormat1"));
		loginPage.tapPasswordField();
		Assert.assertEquals(loginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "invalidEmailError"));

		//Incorrect email format 2
		loginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailIncorrectFormat2"));
		loginPage.tapPasswordField();
		Assert.assertEquals(loginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "invalidEmailError"));

		//Empty password - only inline error displayed for password
		loginPage.enterPassword(utils.readTestData("loginCredentials", "invalidCredentials","passwordEmpty"));
		loginPage.tapEmailField();
		Assert.assertEquals(loginPage.getPasswordFieldErrorValue(), utils.readTestData("copy", "loginPage", "emptyPasswordError"));

		/** Tapping on the Login button **/
		//Empty Email Error
		loginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailEmpty"));
		loginPage.tapLoginButton();
		Assert.assertEquals(loginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "emptyEmailError"));

		//Email length more than 100 characters
		loginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailExceedsMaxLength"));
		loginPage.tapLoginButton();
		Assert.assertEquals(loginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "longEmailError"));

		//Email length less than 2 characters
		loginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailMinLength"));
		loginPage.tapLoginButton();
		errorVal = loginPage.getEmailFieldErrorValue().replace("\n\n", " ");
		Assert.assertEquals(errorVal, utils.readTestData("copy", "loginPage", "shortEmailError"));

		//Incorrect email format 1
		loginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailIncorrectFormat1"));
		loginPage.tapLoginButton();
		Assert.assertEquals(loginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "invalidEmailError"));

		//Incorrect email format 2
		loginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailIncorrectFormat2"));
		loginPage.tapLoginButton();
		Assert.assertEquals(loginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "invalidEmailError"));

		//Empty password - only inline error displayed for password
		loginPage.enterPassword(utils.readTestData("loginCredentials", "invalidCredentials","passwordEmpty"));
		loginPage.tapLoginButton();
		Assert.assertEquals(loginPage.getPasswordFieldErrorValue(), utils.readTestData("copy", "loginPage", "emptyPasswordError"));
	}

	//DMPM-43 - Scenario-6 applies only when the inline error 'Field is required' is displayed
	//DMPM-235 - Scenario-3 and 4

	@Test (groups = {"DMPM-43", "DMPM-235", "DMPM-294", "DMPM-913", "DMPM-914", "marketplace", "login", "priority-minor"})
	public void testHideInlineErrorMsg() {
		String errorVal = "";
		navigateToLoginScreen();
		loginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "invalidCredentials", "emailMinLength"), "");
		loginPage.tapLoginButton();
		errorVal = loginPage.getEmailFieldErrorValue().replace("\n\n", " ");
		Assert.assertEquals(errorVal, utils.readTestData("copy", "loginPage", "shortEmailError"));
		Assert.assertEquals(loginPage.getPasswordFieldErrorValue(),utils.readTestData("copy", "loginPage", "emptyPasswordError"));

		//Check inline errors exist when field is highlighted
		loginPage.tapEmailField();
		Assert.assertEquals(errorVal, utils.readTestData("copy", "loginPage", "shortEmailError"));
		loginPage.tapPasswordField();
		Assert.assertEquals(loginPage.getPasswordFieldErrorValue(), utils.readTestData("copy", "loginPage", "emptyPasswordError"));
		//Check inline errors are removed as valid credentials are entered
		loginPage.enterEmail(utils.readTestData("loginCredentials", "validLoginCredentials", "login"));
		Assert.assertNull(loginPage.checkEmailFieldError());
		loginPage.enterPassword("a");
		Assert.assertNull(loginPage.checkPasswordFieldError());
	}

	//DMPM-43 - Scenario-7
	//DMPM-163 - Scenario-1, 2

	@Test (groups = {"DMPM-43", "DMPM-163", "DMPM-1135", "DMPM-1136", "marketplace", "login", "priority-high"})
	public void testValidCredentials() {
		navigateToLoginScreen();
		loginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validLoginCredentials", "login"), utils.readTestData("loginCredentials", "validLoginCredentials", "pwd"));
		loginPage.tapLoginButton();
		Assert.assertNotNull(loginPage.checkLoadingIndicator(), "Login screen - Login indicator not displayed");
		
		if(termsAndConditionsPage.checkAcceptButton() != null){
			termsAndConditionsPage.tapAcceptButton();
		}
		Assert.assertNotNull(pinOptionsPage.checkEnablePinButton(), "PIN Options Page - Title message not displayed");
	}

	//DMPM-163 - Scenario-3  - incorrect credentials: 401 Bad Username or Password

	@Test (groups = {"DMPM-163", "DMPM-1137", "marketplace", "login", "priority-high"})
	public void testInvalidCredentials() {
		navigateToLoginScreen();
		loginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validLoginCredentials", "login"), utils.readTestData("loginCredentials", "invalidCredentials", "invalidPassword"));
		loginPage.tapLoginButton();
		Assert.assertNotNull(loginPage.checkSnackbarText(), "Login Screen -  The snackbar not displayed");
		Assert.assertEquals(loginPage.getSnackbarTextValue(), Copy.LOGIN_INVALID_CREDENTIALS_SNACKBAR_TEXT, "Login Screen - The text on the Snackbar is incorrect");
		Assert.assertNotNull(loginPage.checkSnackbarButton(), "Login Screen - The button not displayed on the snackbar");
		Assert.assertEquals(loginPage.getSnackbarTextValue(), utils.readTestData("copy", "loginPage", "snackbarTextIncorrectLogin"));
		loginPage.tapSnackbarOkButton();
		Assert.assertNull(loginPage.checkSnackbarText(), "Login Screen - The snackbar still displayed");
	}

	// DMMPM-3729 Scenario 1, 2
	@Test (groups = {"DMPM-3729", "DMPM-4767", "DMPM-4770", "marketplace", "login", "priority-high"})
	public void testForgotSuncorpLoginPassword() {
		navigateToLoginScreen();

		Assert.assertNotNull(loginPage.checkForgotPasswordButton(), "Login Page - Forgot Password button is not displayed");

		loginPage.tapForgotPassword();
		Assert.assertNotNull(loginPage.checkResetPasswordTitle(), "Reset Password - User is not navigated to the Reset Password page");
		Assert.assertEquals(loginPage.getResetPasswordTitle(), Copy.RESET_PASSWORD_TITLE_TEXT, "Reset Password title does not match");
		Assert.assertNotNull(loginPage.checkResetPasswordDescription(), "Reset Password - Description is not displayed");
		Assert.assertEquals(loginPage.getResetPasswordDescription(), Copy.RESET_PASSWORD_DESCRIPTION_TEXT, "Reset Password description does not match");
		Assert.assertNotNull(loginPage.checkResetPasswordEmailField(), "Reset Password - Email Field is not displayed");
		Assert.assertNotNull(loginPage.checkResetLinkButton(), "Reset Password - Send Reset Link button is not displayed");

		loginPage.tapResetPasswordBackButton();
		Assert.assertNotNull(loginPage.checkLoginPageTitle(), "Login Page - User is not naviagted back to the Login Page");
		//Blank email value
		loginPage.enterEmail("");
		loginPage.tapDeviceBackButton();
		loginPage.tapForgotPassword();
		Assert.assertEquals(loginPage.getResetPasswordTitle(), Copy.RESET_PASSWORD_TITLE_TEXT, "User is not navigated to the Reset Password");
		Assert.assertEquals(loginPage.getResetPasswordEmailValue(), "", "Reset Password - Email field is not empty");
		loginPage.tapResetPasswordBackButton();

		//Invalid email valid
		loginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials", "emailIncorrectFormat1"));
		loginPage.tapDeviceBackButton();
		loginPage.tapForgotPassword();
		Assert.assertEquals(loginPage.getResetPasswordTitle(), Copy.RESET_PASSWORD_TITLE_TEXT, "User is not navigated to the Reset Password");
		Assert.assertEquals(loginPage.getResetPasswordEmailValue(), "", "Reset Password - Email field is not empty");
		loginPage.tapResetPasswordBackButton();

		//Valid email value
		loginPage.enterEmail(utils.readTestData("loginCredentials","validLoginCredentials", "login"));
		loginPage.tapDeviceBackButton();
		loginPage.tapForgotPassword();
		Assert.assertEquals(loginPage.getResetPasswordTitle(), Copy.RESET_PASSWORD_TITLE_TEXT, "User is not navigated to the Reset Password");
		Assert.assertEquals(loginPage.getResetPasswordEmailValue(), utils.readTestData("loginCredentials","validLoginCredentials", "login"), "Reset Password - Email does not match with the email entered in login page");
		loginPage.tapResetPasswordBackButton();
		Assert.assertNotNull(loginPage.checkLoginPageTitle(), "Login Page - User is not navigated back to Login Page");
		loginPage.tapBackButton();

		//Navigate to Login Screen via Suncorp Insurance Credentials
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome Page - User is not navigated to the Welcome Page");
		welcomePage.tapRegisterButton();
		Assert.assertEquals(getStartedPage.getGetStartedPageTitleValue().replace("\n", " "), utils.readTestData("copy", "getStartedPage", "getStartedPageTitle"), "Get Started - User is not navigated to the Get Started Page");
		getStartedPage.tapBrandSelectDropDown();
		Assert.assertNotNull(getStartedPage.checkSelectBrandAlert(), "Select Brand List - The alert is not displayed");
		Assert.assertNotNull(getStartedPage.checkSuncorpBrandExists(), "Select Brand List - Suncorp brand is not displayed");
		getStartedPage.tapSuncorpBrand();
		getStartedPage.tapNextButton();
		Assert.assertNotNull(getStartedPage.checkSuncorpAccountOptionsSheet(), "Get Started - Suncorp login options sheet not displayed");
		getStartedPage.tapSuncorpInsuranceButton();
		
		if(termsAndConditionsPage.checkAcceptButton() != null){
			termsAndConditionsPage.tapAcceptButton();
		}
		
		loginPage.tapForgotPassword();
		Assert.assertNotNull(loginPage.checkResetPasswordTitle(), "Reset Password - User is not navigated to the Reset Password screen");
		Assert.assertEquals(loginPage.getResetPasswordTitle(), Copy.RESET_PASSWORD_TITLE_TEXT, "Reset Password title does not match");
		Assert.assertNotNull(loginPage.checkResetPasswordDescription(), "Reset Password - Description is not displayed");
		Assert.assertEquals(loginPage.getResetPasswordDescription(), Copy.RESET_PASSWORD_DESCRIPTION_TEXT, "Reset Password description does not match");
		Assert.assertNotNull(loginPage.checkResetPasswordEmailField(), "Reset Password - Email Field is not displayed");
		Assert.assertNotNull(loginPage.checkResetLinkButton(), "Reset Password - Send Reset Link button is not displayed");
	}

	// DMPM-3729 Scenario 3, 4, 5, 6, 7
	@Test (groups = {"DMPM-3729", "DMPM-4773", "DMPM-4774", "DMPM-4776", "DMPM-4777", "DMPM-4778 ", "marketplace", "login", "priority-medium"})
	public void testResetPasswordEmailValidations() {
		String errorVal = "";
		navigateToLoginScreen();

		loginPage.tapForgotPassword();
		Assert.assertNotNull(loginPage.checkResetPasswordTitle(), "Reset Password - User is not navigated to the Reset Password screen");

		/** Checking validations as the email is typed in **/
		//Only one character typed in
		loginPage.enterResetPasswordEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailMinLength"));
		Assert.assertEquals(loginPage.getResetPasswordEmailErrorVal(), Copy.RESET_PASSWORD_LONG_EMAIL_ERROR, "Reset Password - Inline error is incorrect");

		//As user types in more than 100 characters
		loginPage.enterResetPasswordEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailExceedsMaxLengthInvalid"));
		Assert.assertEquals(loginPage.getResetPasswordEmailErrorVal(), Copy.RESET_PASSWORD_LONG_EMAIL_ERROR, "Reset Password - Inline error is incorrect");

		/** Tapping on the Send Reset Link button **/
		//Empty Email Error
		loginPage.enterResetPasswordEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailEmpty"));
		loginPage.tapResetLinkButton();
		Assert.assertEquals(loginPage.getResetPasswordEmailErrorVal(), Copy.RESET_PASSWORD_EMPTY_EMAIL_ERROR, "Reset Password - Inline error is incorrect");

		//Email length more than 100 characters
		loginPage.enterResetPasswordEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailExceedsMaxLength"));
		loginPage.tapResetLinkButton();
		Assert.assertEquals(loginPage.getResetPasswordEmailErrorVal(), Copy.RESET_PASSWORD_LONG_EMAIL_ERROR, "Reset Password - Inline error is incorrect");

		//Email length less than 2 characters
		loginPage.enterResetPasswordEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailMinLength"));
		loginPage.tapResetLinkButton();
		errorVal = loginPage.getResetPasswordEmailErrorVal().replace("\n\n", " ");
		Assert.assertEquals(errorVal, Copy.RESET_PASSWORD_SHORT_EMAIL_ERROR, "Reset Password - Inline error is incorrect");

		//Incorrect email format 1
		loginPage.enterResetPasswordEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailIncorrectFormat1"));
		loginPage.tapResetLinkButton();
		Assert.assertEquals(loginPage.getResetPasswordEmailErrorVal(), Copy.RESET_PASSWORD_INVALID_EMAIL_ERROR, "Reset Password - Inline error is incorrect");

		//Incorrect email format 2
		loginPage.enterResetPasswordEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailIncorrectFormat2"));
		loginPage.tapResetLinkButton();
		Assert.assertEquals(loginPage.getResetPasswordEmailErrorVal(), Copy.RESET_PASSWORD_INVALID_EMAIL_ERROR, "Reset Password - Inline error is incorrect");

		/** Correcting invalid email id **/
		//Enter incorrect email id and correct the invalid data
		loginPage.enterResetPasswordEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailIncorrectFormat1"));
		loginPage.tapResetLinkButton();
		Assert.assertEquals(loginPage.getResetPasswordEmailErrorVal(), Copy.RESET_PASSWORD_INVALID_EMAIL_ERROR, "Reset Password - Inline error is incorrect");
		loginPage.enterEmail(utils.readTestData("loginCredentials", "validLoginCredentials","login"));
		Assert.assertNull(loginPage.checkResetPasswordEmailError(), "Reset Password - Error message is still displayed");

		/** Put focus back on Field **/
		loginPage.enterResetPasswordEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailIncorrectFormat1"));
		loginPage.tapResetLinkButton();
		Assert.assertEquals(loginPage.getResetPasswordEmailErrorVal(), Copy.RESET_PASSWORD_INVALID_EMAIL_ERROR, "Reset Password - Inline error is incorrect");
		loginPage.tapDeviceBackButton();
		loginPage.tapResetPasswordEmailField();
		Assert.assertEquals(loginPage.getResetPasswordEmailErrorVal(), Copy.RESET_PASSWORD_INVALID_EMAIL_ERROR, "Reset Password - Inline error is incorrect");
	}

	// DMPM-3729 Scenario 8
	// DMPM-3827 Scenario 1, 2
	@Test (groups = {"DMPM-3729", "DMPM-4785", "DMPM-3827", "DMPM-6109", "DMPM-6110", "marketplace", "login", "priority-high"}, priority = 10)
	public void testSuccessfulSendEmailLink() {
		navigateToLoginScreen();

		loginPage.tapForgotPassword();
		Assert.assertNotNull(loginPage.checkResetPasswordTitle(), "Reset Password - User is not navigated to the Reset Password screen");
		loginPage.enterEmail(utils.readTestData("loginCredentials", "validLoginCredentials","login2"));
		loginPage.tapResetLinkButton();

		common.waitForSuccessLoadingSpinnerToDisappear();
		Assert.assertNotNull(loginPage.checkResetPasswordSuccessSnackbar(), "Reset Password - Snackbar is not displayed after successfully sending the reset link");
		Assert.assertEquals(loginPage.getResetPasswordSuccessSnackbarText(), Copy.RESET_PASSWORD_SUCCESS_SNACKBAR_TEXT, "Reset Password - Text on the snackbar is not correct");
		Assert.assertEquals(loginPage.getResetPasswordSuccessSnackbarBtn(), Copy.RESET_PASSWORD_SUCCESS_SNACKBAR_BTN, "Reset Password - Button on the snackbar is not correct");

		Assert.assertEquals(loginPage.getLoginPageTitle(), utils.readTestData("copy", "loginPage", "loginPageTitle"), "Login Page - User is not navigated to the Log in page");
		loginPage.tapBackButton();
		
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome Page - User is not navigated to the Welcome Page");
		welcomePage.tapRegisterButton();
		Assert.assertEquals(getStartedPage.getGetStartedPageTitleValue().replace("\n", " "), utils.readTestData("copy", "getStartedPage", "getStartedPageTitle"), "Get Started - User is not navigated to the Get Started Page");
		getStartedPage.tapBrandSelectDropDown();
		Assert.assertNotNull(getStartedPage.checkSelectBrandAlert(), "Select Brand List - The alert is not displayed");
		Assert.assertNotNull(getStartedPage.checkSuncorpBrandExists(), "Select Brand List - Suncorp brand is not displayed");
		getStartedPage.tapSuncorpBrand();
		getStartedPage.tapNextButton();
		Assert.assertNotNull(getStartedPage.checkSuncorpAccountOptionsSheet(), "Get Started - Suncorp Accounts option is not displayed");
		getStartedPage.tapSuncorpInsuranceButton();
		
		if(termsAndConditionsPage.checkAcceptButton() != null){
			termsAndConditionsPage.tapAcceptButton();
		}

		loginPage.tapForgotPassword();
		Assert.assertNotNull(loginPage.checkResetPasswordTitle(), "Reset Password - User is not navigated to the Reset Password screen");
		loginPage.enterEmail(utils.readTestData("loginCredentials", "validLoginCredentials","login"));
		loginPage.tapResetLinkButton();

		common.waitForSuccessLoadingSpinnerToDisappear();
		Assert.assertNotNull(loginPage.checkResetPasswordSuccessSnackbar(), "Reset Password - Snackbar is not displayed after successfully sending the reset link");
		Assert.assertEquals(loginPage.getResetPasswordSuccessSnackbarText(), Copy.RESET_PASSWORD_SUCCESS_SNACKBAR_TEXT, "Reset Password - Text on the snackbar is not correct");
		Assert.assertEquals(loginPage.getResetPasswordSuccessSnackbarBtn(), Copy.RESET_PASSWORD_SUCCESS_SNACKBAR_BTN, "Reset Password - Button on the snackbar is not correct");

		Assert.assertEquals(loginPage.getLoginPageTitle(), utils.readTestData("copy", "loginPage", "loginPageTitle"), "Login Page - User is not navigated to the Log in page");
	}

	// DMPM-3827 Scenario 3
	@Test (groups = {"DMPM-3729", "DMPM-6111", "marketplace", "login", "priority-high"}, priority = 9)
	public void testTapOpenMailButton(){
		navigateToLoginScreen();

		loginPage.tapForgotPassword();
		Assert.assertNotNull(loginPage.checkResetPasswordTitle(), "Reset Password - User is not navigated to the Reset Password screen");
		loginPage.enterEmail(utils.readTestData("loginCredentials", "validLoginCredentials","login2"));
		loginPage.tapResetLinkButton();
		
		common.waitForSuccessLoadingSpinnerToDisappear();
		Assert.assertNotNull(loginPage.checkResetPasswordSuccessSnackbar(), "Reset Password - Snackbar is not displayed after successfully sending the reset link");
		Assert.assertEquals(loginPage.getResetPasswordSuccessSnackbarText(), Copy.RESET_PASSWORD_SUCCESS_SNACKBAR_TEXT, "Reset Password - Text on the snackbar is not correct");
		Assert.assertEquals(loginPage.getResetPasswordSuccessSnackbarBtn(), Copy.RESET_PASSWORD_SUCCESS_SNACKBAR_BTN, "Reset Password - Button on the snackbar is not correct");

		loginPage.tapResetPasswordSuccessSnackbarButton();
		//For NOT google phones with default app and other email apps
		if(loginPage.checkEmailOptionPanel()!=null) {
			Assert.assertNotNull(loginPage.checkFirstEmailPanelOption(), "Email app option is not displayed");
			loginPage.tapFirstEmailOption();
			Assert.assertFalse(loginPage.getActivityValue().contains("ChooserActivity"), "User is not navigated out of the app");
		}
		//For google phones with GMAIL as default app
		Assert.assertNull(loginPage.checkResetPasswordSuccessSnackbar(), "Reset Password - Snackbar still displayed");
		Assert.assertFalse(loginPage.getActivityValue().contains("ChooserActivity"), "User is not navigated out of the app");
	}
	
	//DMPM-69 Scenario 1, 2, 3, 4
	@Test (groups = {"DMPM-69", "DMPM-3510", "DMPM-3511", "DMPM-3512", "DMPM-3513", "marketplace", "login", "priority-high"}, priority = 8)
	public void testSoftLogoutBehaviour(){
		navigateToLoginScreen();

		loginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validLoginCredentials", "login1"), utils.readTestData("loginCredentials", "validLoginCredentials", "pwd"));
		loginPage.tapLoginButton();
		
		if(termsAndConditionsPage.checkAcceptButton() != null){
			termsAndConditionsPage.tapAcceptButton();
		}
		
		//Soft log out by tapping on the log out button
		Assert.assertNotNull(pinOptionsPage.checkPinPromptUserWelcome(), "Login Page - User is not navigated to the Enable PIN page");
		pinOptionsPage.tapMaybeLater();
		Assert.assertNotNull(landingPage.checkLandingPageTitle(), "Landing Page - User is not navigated to Landing Page");
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkLockMenuOption(), "Nav Menu - Lock item is not diplayed");
		navigationMenu.tapLockMenuOption();
		Assert.assertNotNull(loginAuthPage.checkChangeAccountButton(), "Reauth Welcome Screen - User is not navigated back to reauth screen");
		
		//Soft log out by killing and relaunching the app
		loginAuthPage.tapReloginButton();
		Assert.assertNotNull(loginAuthPage.checkForgotPasswordReauthButton(), "Reauth with Password Screen - User is not navigated back to reauth with password");
		loginAuthPage.enterPassword(utils.readTestData("loginCredentials", "validLoginCredentials", "pwd"));
		loginAuthPage.tapReauthPasswordLoginBtn();
		Assert.assertNotNull(landingPage.checkLandingPageTitle(), "Landing page - User is not navigated to the Landing Page");
		loginPage.restartApp();
		
		configPage.tapContinueToDismiss();
		Assert.assertNotNull(loginAuthPage.checkChangeAccountButton(), "Reauth Welcome Screen - User is not navigated back to reauth screen");
	}

	private void navigateToLoginScreen() {
		if(loginAuthPage.checkChangeAccountButton() != null) {
			loginAuthPage.tapChangeAccountButton();
		}
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - Suncorp image is not shown");
		welcomePage.tapLoginButton();
	}
}
