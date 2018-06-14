package test.marketplace.auth.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.App;

public class LoginAuthTest extends App{

	private void navigateToReauthWelcomeScreen() {
		if(loginAuthPage.checkChangeAccountButton() != null) {
			loginAuthPage.tapChangeAccountButton();
		}
		
		welcomePage.checkWelcomeSuncorpImage();
		welcomePage.tapLoginButton();
		Assert.assertNotNull(loginPage.checkLoginPageTitle(), "Login screen - page title is not shown");
		
		loginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validLoginCredentials", "login"), utils.readTestData("loginCredentials", "validLoginCredentials", "pwd"));
		loginPage.tapLoginButton();
		
		if(termsAndConditionsPage.checkAcceptButton() != null) {
			termsAndConditionsPage.tapAcceptButton();
		}

		Assert.assertNotNull(pinOptionsPage.checkPinPromptUserWelcome(), "PIN Option Page - Pin Enable option not displayed");
		pinOptionsPage.tapMaybeLater();

		Assert.assertNotNull(landingPage.checkLandingPageTitle(), "Landing Page - Landing page title not displayed");
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkLogOutMenuOption(), "Navigation Menu - Nav menu not loaded properly");
		navigationMenu.tapLogOutMenuOption();
	}
	
	private void checkForTermsAndConditions() {
		if(termsAndConditionsPage.checkAcceptButton() != null){
			termsAndConditionsPage.tapAcceptButton();
		}
	}
	
	//DMPM-1972 Scenario 1
	@Test(groups = {"DMPM-1972", "DMPM-2668", "marketplace", "login", "priority-high"})
	public void testReauthenticationPage() {
		navigateToReauthWelcomeScreen();
		
		//Soft logged out scenario
		Assert.assertNotNull(loginAuthPage.checkUserName(), "Reauth Page - User is not navigated to the Reauth page");
		
		//Close and relaunch the app scenario
		loginAuthPage.tapReloginButton();
		loginAuthPage.enterPassword(utils.readTestData("loginCredentials", "validLoginCredentials", "pwd"));
		Assert.assertNotNull(loginAuthPage.checkPasswordReauthField(), "Password Reauth - User is not navigated to the Password Reauth Screen");
		loginAuthPage.tapReauthPasswordLoginBtn();
		
		checkForTermsAndConditions();
		
		Assert.assertNotNull(landingPage.checkLandingPageTitle(), "Landing Page - User is not navigated to the Landing Page");
		loginAuthPage.restartApp();
		
		//Dismiss the config page
		configPage.tapContinueToDismiss();
		Assert.assertNotNull(loginAuthPage.checkUserName(), "Reauth Page - User is not navigated to the Reauth page");
	}
	
	//DMPM-1972 Scenario 2
	//DMPM-44 Scenario 1
	@Test(groups = {"DMPM-1972", "DMPM-2669", "DMPM-44", "DMPM-2201", "marketplace", "login", "priority-high"})
	public void testReauthLoginBehaviour() {
		navigateToReauthWelcomeScreen();
		
		// PIN Disabled
		loginAuthPage.tapReloginButton();
		Assert.assertNotNull(loginAuthPage.checkPasswordReauthField(), "Reauth With Password - User not navigated to Reauthentication with password screen");
		Assert.assertNotNull(loginAuthPage.checkForgotPasswordReauthButton(), "Reauth With Password - User not navigated to Reauthentication with password screen");

		loginAuthPage.enterPassword(utils.readTestData("loginCredentials", "validLoginCredentials", "pwd"));
		loginAuthPage.tapReloginButton();
		
		checkForTermsAndConditions();
		
		Assert.assertNotNull(landingPage.checkSuncorpTab(), "User is not navigated to the Landing screen");
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkLogOutMenuOption(), "Navigation Menu - Nav menu not loaded properly");
		navigationMenu.tapSettingsMenuItem();
		//Wait for loading spinner to finish
		common.waitForLoadingIndicatorToDisappear();
		Assert.assertNotNull(settingsPage.checkSettingsTitle(), "User is not navigated to Settings page");
		Assert.assertNotNull(settingsPage.checkEnablePinToggle(), "Enable PIN toggle not found");

		settingsPage.tapEnablePinToggle();

		if (pinSetupPage.checkPinInstructionAlert() != null) {
			pinSetupPage.tapOkButton();
		}
		
		//Enabling the PIN
		if(enterCurrentPINPage.checkEnterExistingPinLabel() != null){
			enterCurrentPINPage.enterPIN(utils.readTestData("PIN", "loginWithExistingPin", "pin"));
		}
		else if(pinSetupPage.checkEnterPINLabel() != null) {
			Assert.assertEquals(pinSetupPage.getEnterPINLabel(), utils.readTestData("copy", "pinSetupPage", "enterPINLabel") ,"User is not navigated to the enter new PIN page");
			pinSetupPage.enterPIN(utils.readTestData("PIN", "loginWithExistingPin", "pin"));
			Assert.assertEquals(pinSetupPage.getReEnterPINLabel(), utils.readTestData("copy", "pinSetupPage", "reEnterPINLabel") ,"User is not navigated to the re-enter new PIN page");
			pinSetupPage.enterPIN(utils.readTestData("PIN", "loginWithExistingPin", "pin"));
		}
		
		Assert.assertNotNull(settingsPage.checkSettingsTitle(), "User is not navigated back to Settings page");

		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkLogOutMenuOption(), "Navigation Menu - Nav menu not loaded properly");
		navigationMenu.tapLogOutMenuOption();
		
		// PIN Enabled
		loginAuthPage.tapReloginButton();
		Assert.assertNotNull(pinAuthPage.checkPinReauthUserName(), "Reauth with PIN - User is not navigated to the Reauthenticaton with PIN screen");
	}
	
	//DMPM-44 Scenario 2, 3
	@Test (groups = {"DMPM-44", "DMPM-2202", "DMPM-2203", "marketplace", "login", "priority-medium"})
	public void testPasswordFieldBehaviour() {
		navigateToReauthWelcomeScreen();
		Assert.assertNotNull(loginAuthPage.checkReloginButton(), "Reauth Welcome Screen - Log In button is not displayed");
		loginAuthPage.tapReloginButton();
		
		Assert.assertNotNull(loginAuthPage.checkPasswordReauthField(), "Reauth With Password - User not navigated to Reauthentication with password screen");
		Assert.assertNotNull(loginAuthPage.checkForgotPasswordReauthButton(), "Reauth With Password - User not navigated to Reauthentication with password screen");
		
		loginAuthPage.tapPasswordField();
		Assert.assertTrue(common.isKeyboardShown(), "keyboard not shown");
		loginAuthPage.enterPassword(utils.readTestData("loginCredentials", "validLoginCredentials", "pwd"));
		Assert.assertTrue(loginAuthPage.getPasswordFieldMaskedVal(utils.readTestData("loginCredentials", "validLoginCredentials", "maskedValidPwd")), "Reauth With Password - Password value is not masked");
		
		// Relaunch the app after backgrounding
		loginAuthPage.relaunchApp(-1, "Config");
		Assert.assertEquals(loginAuthPage.getPasswordFieldVal(), "", "Password field is not cleared on relaunching the app");
	}
	
	//DMPM-44 Scenario 4, 5, 6, 7
	@Test (groups = {"DMPM-44", "DMPM-2204", "DMPM-2205", "DMPM-2206", "DMPM-2209", "marketplace", "login", "priority-medium"})
	public void testPasswordInlineValidations() {
		navigateToReauthWelcomeScreen();
		
		loginAuthPage.tapReloginButton();
		// Tapping on the Login button only way to focus out of the Password field
		//Empty Email Error
		loginAuthPage.enterPassword("");
		loginAuthPage.tapReauthPasswordLoginBtn();
		Assert.assertEquals(loginAuthPage.getPasswordInlineErrorVal(), utils.readTestData("copy", "loginPage", "emptyPasswordError"), "Password Reauth - Inline error displayed is not correct");
		
		loginAuthPage.tapPasswordField();
		Assert.assertEquals(loginAuthPage.getPasswordInlineErrorVal(), utils.readTestData("copy", "loginPage", "emptyPasswordError"), "Password Reauth - Inline is not displayed");
		
		loginAuthPage.enterPassword(utils.readTestData("loginCredentials", "validLoginCredentials", "pwd"));
		Assert.assertNull(loginAuthPage.checkPasswordInlineError(), "Password Reauth - Inline error is still displayed");
	}
	
	//DMPM-44 Scenario 8, 9
	@Test (groups = {"DMPM-44", "DMPM-2210", "DMPM-2213", "marketplace", "login", "priority-high"})
	public void testValidPasswordCredentials() {
		navigateToReauthWelcomeScreen();
		loginAuthPage.tapReloginButton();
		
		loginAuthPage.enterPassword(utils.readTestData("loginCredentials", "validLoginCredentials", "pwd"));
		loginAuthPage.tapReauthPasswordLoginBtn();
		
		checkForTermsAndConditions();
		
		common.waitForLoadingIndicatorToDisappear();
		Assert.assertNotNull(landingPage.checkLandingPageTitle(), "Landing Page - User is not navigated to the landing page");
	}
}
