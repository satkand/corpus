package test.marketplace.auth.pin;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class PINAuthTest extends App{

	
	@Test (groups = {"DMPM-58", "DMPM-2286","DMPM-2292", "marketplace", "pin", "priority-minor"})
	public void testLoginUsingPin() {
		navigateToReauthScreen();
		Assert.assertNotNull(loginReauthPage.checkReloginButton(),"Login button not present");
		loginReauthPage.tapReloginButton();
		Assert.assertNotNull(pinSetupPage.checkPinField(), "Pin field - is not shown");
		Assert.assertNotNull(pinSetupPage.checkCancelButton(), "Pin field - is not shown");
		enterPIN(utils.readTestData("hasPin", "pin"));
		Assert.assertNotNull(landingPage.checkVehiclesTab(), "Landing page - is not shown");
	}
	
	@Test (groups = {"DMPM-58", "DMPM-2304", "marketplace", "pin", "priority-minor"})
	public void cancelReauthUsingPin() {
		navigateToReauthScreen();
		Assert.assertNotNull(loginReauthPage.checkReloginButton(),"Login button not present");
		loginReauthPage.tapReloginButton();
		Assert.assertNotNull(pinSetupPage.checkCancelButton(), "Pin field - is not shown");
		pinSetupPage.tapCancelButton();
		Assert.assertNotNull(loginReauthPage.checkReloginButton(),"Did not navigate back to reauth page");
	}
	
	private void navigateToReauthScreen() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("hasPin", "login"), 
				utils.readTestData("hasPin", "pwd"));
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkSettingsMenuItem(), "Settings menu item is not shown");
		navigationMenu.tapSettingsMenuItem();
		if(!settingsPage.isPinToggleEnabled()) {
			settingsPage.tapEnablePinToggle();
		}
	
		enterPIN(utils.readTestData("hasPin", "pin"));
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkLockMenuOption(), "Settings menu item is not shown");
		navigationMenu.tapLockMenuOption();	
	}	
	
	private void enterPIN(String pin) {
		for(char pinDigit : pin.toCharArray()) {
			pinCustomKeypad.tapPINEntry(pinDigit);
		}
	}
}
