package test.marketplace.settings;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import automation.framework.common.TestDetails.Priority;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
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
	
	@TestDetails(story1 = "DMPM-275:DMPM-3528,DMPM-3529,DMPM-3533", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Settings", "priority-minor" })
	public void testForceUpdateScreen() throws Throwable {
		UpdatingMinAppVersionAndRestartingConfigApp();
		Assert.assertNotNull(forceUpdatePage.checkForceUpdateHeadingText(), "Force Update Page - Heading text is not present");
		Assert.assertNotNull(forceUpdatePage.checkForceUpdateDescription(), "Force Update Page - Description is not present");
		Assert.assertNotNull(forceUpdatePage.checkForceUpdateImage(), "Force Update Page - Image is not present");
		Assert.assertNotNull(forceUpdatePage.checkForceUpdateDownloadNewVersionButton(), "Force Update Page - Download button is not present");
		
		Assert.assertEquals(forceUpdatePage.getForceUpdateHeadingText(),Copy.FORCEUPDATE_INTRO_HEADING_TEXT, "Force Update Page - Heading text is different to the expected");
		Assert.assertEquals(forceUpdatePage.getForceUpdateDescription(),Copy.FORCEUPDATE_DESCRIPTION, "Force Update Page - description is different to the expected");
		
		forceUpdatePage.tapForceUpdateDownloadNewVersionButton();
		//TODO when suncorp app is available in the Play Store, add another assertion to verify that user is redirected to the correct page
		Assert.assertNotNull(forceUpdatePage.checkPlayStoreTitle(), "Force Update Page - Play Store title is not present after tapping on Update button");
		homeServicesPage.tapDeviceBackButton();
		
		UpdatingMinAppVersionAndRestartingConfigApp();
		Assert.assertNotNull(forceUpdatePage.checkForceUpdateHeadingText(), "Force Update Page - Heading text is not present");
		
		String AppActivity = ((AndroidDriver)driver).currentActivity();
		
		homeServicesPage.tapDeviceBackButton();
		
		String MarketPlaceAppClosed = ((AndroidDriver)driver).currentActivity();
		boolean checkAppActivity = false;
		
		if(!MarketPlaceAppClosed.equals(".presentation.startup.view.ForcedUpdateActivity")) {
			checkAppActivity= true;
		}
		Assert.assertTrue(checkAppActivity,"MarketPlace app was not closed even after tapping on the back button");
	
	}
	protected void UpdatingMinAppVersionAndRestartingConfigApp() throws Throwable {
		homeServicesPage.restartConfig();
		Assert.assertNotNull(configPage.checkConfigPageTitle(), "Config Page - Title is not present");
		configPage.scrollToContinueButton();
		Assert.assertNotNull(configPage.checkMinimumAppVersionEditText(), "Config Page - Minimum App Version text field is not present");
		
		//TODO update minimum app version logic when config app is properly updating the minimum app version number
		configPage.enterMinimumAppVersion("0.8.0");
		Assert.assertNotNull(configPage.checkContinueButton(), "Config Page - Continue button is not present");
		
		configPage.tapContinueButton();
	}

}
