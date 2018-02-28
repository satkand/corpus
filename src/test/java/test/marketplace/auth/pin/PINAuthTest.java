package test.marketplace.auth.pin;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class PINAuthTest extends App{

	
	@Test (groups = {"DMPM-58", "DMPM-2286","DMPM-2288", "DMPM-2292", "marketplace", "pin", "priority-minor"})
	public void testLoginUsingPin() {
		navigateToPinAuthScreen();
		Assert.assertNotNull(pinAuthPage.checkUserName(),"Pin Auth screen is not displayed");
		Assert.assertNotNull(pinAuthPage.checkPinField(), "Pin field - is not shown");
		Assert.assertNotNull(pinAuthPage.checkBackButton(), "Pin field - is not shown");
		enterPIN(utils.readTestData("PIN", "loginWithExistingPin", "pin"));
		Assert.assertNotNull(landingPage.checkVehiclesTab(), "Landing page - is not shown");
	}
	
	@Test (groups = {"DMPM-58", "DMPM-2304", "marketplace", "pin", "priority-minor"})
	public void cancelReauthUsingPin() {
		navigateToPinAuthScreen();
		Assert.assertNotNull(pinAuthPage.checkBackButton(), "Pin field - is not shown");
		pinAuthPage.tapBackButton();
		Assert.assertNotNull(loginAuthPage.checkReloginButton(),"Did not navigate back to reauth page");
	}
	
	private void navigateToPinAuthScreen() {
		loginToApp(utils.readTestData("PIN", "loginWithExistingPin", "login"), 
				utils.readTestData("PIN", "loginWithExistingPin", "pwd"), "DoNotTapMayBeLaterOption");
		pinOptionsPage.tapEnablePinButton();
		enterPIN(utils.readTestData("PIN", "loginWithExistingPin", "pin"));
	
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkLockMenuOption(), "Settings menu item is not shown");
		navigationMenu.tapLockMenuOption();	
		Assert.assertNotNull(loginAuthPage.checkReloginButton(),"Login button not present");
		loginAuthPage.tapReloginButton();
	}	
	
	private void enterPIN(String pin) {
		for(char pinDigit : pin.toCharArray()) {
			pinCustomKeypad.tapPINEntry(pinDigit);
		}
	}
}
