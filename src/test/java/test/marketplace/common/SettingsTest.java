package test.marketplace.common;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class SettingsTest extends App{

	
	@Test (groups = {"DMPM-52", "DMPM-1143", "DMPM-1146", "DMPM-1148", "DMPM-1149", "marketplace", "pin", "priority-minor"})
	public void testPinAuthenticationOptions() {
		navigateToSettingsPage();
		Assert.assertNotNull(settingsPage.checkEnablePinToggle(), "Enable pin toggle button not present");
		if(settingsPage.isPinToggleEnabled()) {
			settingsPage.tapEnablePinToggle();
			Assert.assertFalse(settingsPage.isPinToggleEnabled(), "Toggle button did not get disabled");
		}else {
			settingsPage.tapEnablePinToggle();
			Assert.assertNotNull(pinSetupPage.checkEnterPINLabel(), "Pin setup screen not displayed");
		}
	}
	
	private void navigateToSettingsPage() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("hasNoProducts", "login"), 
				utils.readTestData("hasNoProducts", "pwd"));
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkSettingsMenuItem(), "Settings title not seen");
		navigationMenu.tapSettingsMenuItem();
		Assert.assertNotNull(settingsPage.checkSettingsTitle(), "Settings title not seen");
	}
}
