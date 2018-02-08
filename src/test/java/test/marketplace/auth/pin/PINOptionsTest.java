package test.marketplace.auth.pin;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.App;

public class PINOptionsTest extends App{

	@Test (groups = {"DMPM-52", "DMPM-1154", "DMPM-2581", "DMPM-2582", "marketplace", "pin", "priority-minor"})
	public void testPinCancel() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		Assert.assertNotNull(welcomePage.checkRegisterButton(), "Welcome screen - Register button is not shown");
		welcomePage.tapRegisterButton();
		if(registrationPage.checkSetupNewAccountButton() != null) {
			registrationPage.tapSetupNewAccount();
		}
		Assert.assertNotNull(registrationPage.checkRegistrationPageTitle(), "Registration page not loaded");
		registrationPage.fill1stPageFields(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"),
				utils.readTestData("registration", "success", "postcode"));
		registrationPage.tapNextButton();
		registrationPage.fill2ndPageFields(utils.readTestData("registration", "success", "email"),
				utils.readTestData("registration", "success", "mobile"));
		registrationPage.tapNextButton();
		registrationPage.fill3rdPageFields(utils.readTestData("registration", "success", "password"));
		pinOptionsPage.checkAllElements();
		
		pinOptionsPage.tapEnablePinButton();
		Assert.assertNotNull(pinSetupPage.checkEnterPINLabel(),"Pin setup screen is not displayed");
		pinSetupPage.tapCancelButton();
		Assert.assertNotNull(landingPage.checkVehiclesTab(),"Landing page not loaded");
		
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkSettingsMenuItem(), "Settings title not seen");
		navigationMenu.tapSettingsMenuItem();
		Assert.assertFalse(settingsPage.isPinToggleEnabled(), "Toggle is still enabled");
		if(!settingsPage.isPinToggleEnabled()) {
			settingsPage.tapEnablePinToggle();
		}
		pinSetupPage.tapCancelButton();
		Assert.assertNotNull(settingsPage.checkSettingsTitle(), "Settings title not seen");
		Assert.assertFalse(settingsPage.isPinToggleEnabled(), "Toggle button did not get disabled");
	}
	
	@Test (groups = {"DMPM-439", "DMPM-2583", "marketplace", "pin", "priority-minor"})
	public void testPinMaybeLaterOptions() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		Assert.assertNotNull(welcomePage.checkRegisterButton(), "Welcome screen - Register button is not shown");
		welcomePage.tapRegisterButton();
		if(registrationPage.checkSetupNewAccountButton() != null) {
			registrationPage.tapSetupNewAccount();
		}
		Assert.assertNotNull(registrationPage.checkRegistrationPageTitle(), "Registration page not loaded");
		registrationPage.fill1stPageFields(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"),
				utils.readTestData("registration", "success", "postcode"));
		registrationPage.tapNextButton();
		registrationPage.fill2ndPageFields(utils.readTestData("registration", "success", "email"),
				utils.readTestData("registration", "success", "mobile"));
		registrationPage.tapNextButton();
		registrationPage.fill3rdPageFields(utils.readTestData("registration", "success", "password"));
		Assert.assertNotNull(pinOptionsPage.checkEnablePinButton(),"Pin setup button is not displayed");
		Assert.assertNotNull(pinOptionsPage.checkMaybeLaterButton(),"Maybe later button is not displayed");
		pinOptionsPage.tapMaybeLater();
		Assert.assertNotNull(landingPage.checkVehiclesTab(),"Landing page not loaded");
	}
}
