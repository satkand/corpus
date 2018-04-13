package test.marketplace.auth.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.App;

public class LoginAuthTest extends App{

	private void navigateToReauthWelcomeScreen() {
		// To make sure this method does not fail
		if(loginAuthPage.checkChangeAccountButton() != null) {
			loginAuthPage.tapChangeAccountButton();
		}
		
		welcomePage.checkWelcomeSuncorpImage();
		welcomePage.tapLoginButton();
		Assert.assertNotNull(loginPage.checkLoginPageTitle(), "Login screen - page title is not shown");
		
		loginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validLoginCredentials", "login"), utils.readTestData("loginCredentials", "validLoginCredentials", "pwd"));
		loginPage.tapLoginButton();
		
		Assert.assertNotNull(pinOptionsPage.checkPinPromptUserWelcome(), "PIN Option Page - Pin Enable option not displayed");
		pinOptionsPage.tapMaybeLater();
		Assert.assertNotNull(landingPage.checkLandingPageTitle(), "Landing Page - Landing page title not displayed");
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkLockMenuOption(), "Navigation Menu - Nav menu not loaded properly");
		navigationMenu.tapLockMenuOption();
	}
	
	
	//DMPM-1972 Scenario 1
	@Test(groups = {"DMPM-1972", "DMPM-2668", "marketplace", "login", "priority-high"})
	public void testReauthenticationPage() {
		navigateToReauthWelcomeScreen();
		loginAuthPage.relaunchApp(-1, "Config");
		
		Assert.assertNotNull(loginAuthPage.checkUserName(), "Reauth Page - User is not navigated to the Reauth page");
	}
	
	//DMPM-1972 Scenario 2
	@Test(groups = {"DMPM-1972", "DMPM-2669", "marketplace", "login", "priority-high"})
	public void testReauthLoginBehaviour() {
		navigateToReauthWelcomeScreen();
		
		// PIN Disabled
		loginAuthPage.tapReloginButton();
		Assert.assertNotNull(loginAuthPage.checkPasswordReauthField(), "Reauth With Password - User not navigated to Reauthentication with password screen");
		Assert.assertNotNull(loginAuthPage.checkForgotPasswordReauthButton(), "Reauth With Password - User not navigated to Reauthentication with password screen");

		loginAuthPage.enterPassword(utils.readTestData("loginCredentials", "validLoginCredentials", "pwd"));
		loginAuthPage.tapLoginReauthButton();
		Assert.assertNotNull(landingPage.checkSuncorpTab(), "User is not navigated to the Landing screen");
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkLockMenuOption(), "Navigation Menu - Nav menu not loaded properly");
		navigationMenu.tapSettingsMenuItem();
		//Wait for loading spinner to finish
		common.waitForLoadingSpinnerToDisappear();
		Assert.assertNotNull(settingsPage.checkSettingsTitle(), "User is not navigated to Settings page");
		Assert.assertNotNull(settingsPage.checkEnablePinToggle(), "Enable PIN toggle not found");

		settingsPage.tapEnablePinToggle();

		if(enterCurrentPINPage.checkEnterExistingPinLabel() != null){
			enterCurrentPINPage.enterPIN();
		}
		else if(pinSetupPage.checkEnterPINLabel() != null) {
			pinSetupPage.enterPIN();
			Assert.assertNotNull(pinSetupPage.checkReEnterPINLabel(), "User is not navigated to the ReEnter PIN page");
			pinSetupPage.enterPIN();
		}
		Assert.assertNotNull(settingsPage.checkSettingsTitle(), "User is not navigated back to Settings page");

		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkLockMenuOption(), "Navigation Menu - Nav menu not loaded properly");
		navigationMenu.tapLockMenuOption();
		
		// PIN Enabled
		loginAuthPage.tapReloginButton();
		Assert.assertNotNull(pinAuthPage.checkPinReauthUserName(), "Reauth with PIN - User is not navigated to the Reauthenticaton with PIN screen");
	}
}
