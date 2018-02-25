package test.marketplace.common;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class SettingsTest extends App{

	
	@Test (groups = {"DMPM-52", "DMPM-1143", "DMPM-1146", "DMPM-1148", "DMPM-1154", "marketplace", "pin", "priority-minor"})
	public void testPinAuthenticationOptions() {
		navigateToSettingsPageWithoutPin();
		Assert.assertNotNull(settingsPage.checkEnablePinToggle(), "Enable pin toggle button not present");
		Assert.assertFalse(settingsPage.isPinToggleEnabled(), "Toggle button is enabled");
		settingsPage.tapEnablePinToggle();
		Assert.assertNotNull(pinSetupPage.checkEnterPINLabel(), "Pin setup screen not displayed");
		pinSetupPage.tapCancelButton();
		Assert.assertNotNull(settingsPage.checkSettingsTitle(), "Settings title not seen");
		Assert.assertFalse(settingsPage.isPinToggleEnabled(), "Toggle button did not get disabled");

	}
	
	@Test (groups = {"DMPM-52","DMPM-1149", "marketplace", "pin", "priority-minor"})
	public void testPinAuthenticationOptionsWithPinEnabled() {
		navigateToSettingsPageWithPin();
		Assert.assertNotNull(settingsPage.checkEnablePinToggle(), "Enable pin toggle button not present");
		Assert.assertTrue(settingsPage.isPinToggleEnabled(), "Toggle button is disabled");
		settingsPage.tapEnablePinToggle();
		Assert.assertFalse(settingsPage.isPinToggleEnabled(), "Toggle button is enabled");
	}
	
	private void navigateToSettingsPageWithPin() {
		loginToApp(utils.readTestData("PIN", "loginWithExistingPin", "login"), 
				utils.readTestData("PIN", "loginWithExistingPin", "pwd"));
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkSettingsMenuItem(), "Settings title not seen");
		navigationMenu.tapSettingsMenuItem();
		Assert.assertNotNull(settingsPage.checkSettingsTitle(), "Settings title not seen");
	}
	
	private void navigateToSettingsPageWithoutPin() {
		loginToApp(utils.readTestData("PIN", "loginWithoutExistingPin", "login"), 
				utils.readTestData("PIN", "loginWithoutExistingPin", "pwd"));
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkSettingsMenuItem(), "Settings title not seen");
		navigationMenu.tapSettingsMenuItem();
		Assert.assertNotNull(settingsPage.checkSettingsTitle(), "Settings title not seen");
	}
}
