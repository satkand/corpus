package test.marketplace.auth.pin;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.CustomRetryListener;
import automation.framework.common.TestDetails;
import automation.framework.common.TestDetails.Priority;
import pages.App;

public class ChangePINTest extends App {

	@TestDetails(story1 = "DMPM-3724:DMPM-4348,DMPM-4337", story2 = "DMPM-1339:DMPM-2285,DMPM-2291", priority = Priority.LOW)
	@Test(groups = { "marketplace", "pin", "priority-minor" })
	public void testChangePinScreenDetails() {

		String username = utils.readTestData("PIN", "loginForConfirmCurrentPin", "login");
		String pwd = utils.readTestData("PIN", "loginForConfirmCurrentPin", "pwd");
		String pin = utils.readTestData("PIN", "loginForConfirmCurrentPin", "pin");

		navigateToSettingsWithPinTrue(username, pwd);
		Assert.assertNotNull(settingsPage.checkChangePinLink(), "Change PIN option is not displayed");
		settingsPage.tapChangePinLink();
		Assert.assertNotNull(enterCurrentPINPage.checkEnterExistingPinLabel(),
				"Enter existing pin label not displayed");
		Assert.assertNotNull(enterCurrentPINPage.checkPinField(), "Pin field is not displayed");
		Assert.assertNotNull(enterCurrentPINPage.checkForgotPinButton(), "Forgot pin button is not displayed");
		enterPIN(pin);
		Assert.assertNotNull(common.checkLoadingIndicator(), "Loading Spinner not displayed");
		enterCurrentPINPage.tapOkButton();
		Assert.assertNotNull(pinSetupPage.checkEnterPINLabel(), "Re-enter pin label is not displayed");

	}

	@TestDetails(story1 = "DMPM-3724:DMPM-4341,DMPM-4525", priority = Priority.LOW)
	@Test(groups = { "marketplace", "pin", "priority-minor" })
	public void testForgotPin() {

		String username = utils.readTestData("PIN", "loginWithExistingPin", "login");
		String pwd = utils.readTestData("PIN", "loginWithExistingPin", "pwd");
		
		navigateToSettingsWithPinTrue(username, pwd);
		settingsPage.checkChangePinLink();
		settingsPage.tapChangePinLink();
		enterCurrentPINPage.tapForgotPinButton();

		Assert.assertNotNull(forgotPINPage.checkForgottenPINPageTitle(),
				"PIN Reauthenticate Password screen - 'Forgotten PIN page title is not shown");

		common.tapBackNavigateButton();

		Assert.assertNotNull(enterCurrentPINPage.checkEnterExistingPinLabel(),
				"Not on Enter existing pin page");
		
		enterCurrentPINPage.tapBackButton() ;
		
		Assert.assertNotNull(settingsPage.checkSettingsTitle(), "Not on setttings page");

	}

	@TestDetails(story1 = "DMPM-3724:DMPM-4343,DMPM-4350", priority = Priority.LOW)
	@Test(groups = { "marketplace", "pin", "priority-minor" })
	public void testConfirmPINLocked() {

		String username = utils.readTestData("PIN", "loginWithPinLocked", "login");
		String pwd = utils.readTestData("PIN", "loginWithPinLocked", "pwd");
		String pin = utils.readTestData("PIN", "loginWithPinLocked", "pin");

		navigateToSettingsWithPinTrue(username, pwd);
		settingsPage.checkChangePinLink();
		settingsPage.tapChangePinLink();
		enterPIN(pin);
		enterCurrentPINPage.checkPinLockedMessage();
		Assert.assertTrue(enterCurrentPINPage.getPinLockedMessage().equals(Copy.PIN_LOCK_ALERT_MESSAGE),
				"Pin Locked Message is incorrect");
		enterCurrentPINPage.tapOkButton();
		
		Assert.assertNotNull(forgotPINPage.checkForgottenPINPageTitle(), "Not on forgotten pin page");

	}

	@TestDetails(story1 = "DMPM-3724:DMPM-4528", priority = Priority.LOW)
	@Test(groups = { "marketplace", "pin", "priority-minor" })
	public void testCancelPINSetup() {

		String username = utils.readTestData("PIN", "loginWithPinLocked", "login");
		String pwd = utils.readTestData("PIN", "loginWithPinLocked", "pwd");
		String invalidPin = utils.readTestData("PIN", "loginWithPinLocked", "pin");
		String validPin = utils.readTestData("PIN", "loginWithExistingPin", "pin");

		navigateToSettingsWithPinTrue(username, pwd);
		settingsPage.checkChangePinLink();
		settingsPage.tapChangePinLink();
		enterPIN(invalidPin);
		enterCurrentPINPage.checkPinLockedMessage();
		enterCurrentPINPage.tapReAuthenticateButton();
		forgotPINPage.checkForgottenPINPageTitle();
		forgotPINPage.enterPassword(pwd);
		forgotPINPage.tapNextButton();
		enterCurrentPINPage.tapOkButton();
		Assert.assertNotNull(pinSetupPage.checkEnterPINLabel(), "Enter new pin screen is not displayed");
		enterPIN(validPin);
		pinSetupPage.checkReEnterPINLabel();
		pinSetupPage.tapCancelButton();
		Assert.assertNotNull(settingsPage.checkSettingsTitle(), "Not on setttings page");
	}

	@TestDetails(story1 = "DMPM-3724:DMPM-4522", priority = Priority.LOW)
	@Test(groups = { "marketplace", "pin", "priority-minor" })
	public void testCancelForgotPinForPinLocked() {

		String username = utils.readTestData("PIN", "loginWithPinLocked", "login");
		String pwd = utils.readTestData("PIN", "loginWithPinLocked", "pwd");
		String invalidPin = utils.readTestData("PIN", "loginWithPinLocked", "pin");
		
		navigateToSettingsWithPinTrue(username, pwd);
		settingsPage.checkChangePinLink();
		settingsPage.tapChangePinLink();
		enterPIN(invalidPin);
		enterCurrentPINPage.checkPinLockedMessage();
		enterCurrentPINPage.tapReAuthenticateButton();
		forgotPINPage.checkForgottenPINPageTitle();
		common.tapBackNavigateButton();
		Assert.assertNotNull(settingsPage.checkSettingsTitle(), "Not on setttings page");
		Assert.assertFalse(settingsPage.isPinToggleEnabled(), "Pin toggle is enabled");

	}

	@TestDetails(story1 = "DMPM-3724:DMPM-4527,DMPM-4343", priority = Priority.LOW)
	@Test(retryAnalyzer = CustomRetryListener.class, groups = { "marketplace", "pin", "priority-minor" })
	public void testPINSetupSuccessForPinLocked() {

		String username = utils.readTestData("PIN", "loginForPinLockedSetupFlow", "login");
		String pwd = utils.readTestData("PIN", "loginForPinLockedSetupFlow", "pwd");
		String validPin = utils.readTestData("PIN", "loginForPinLockedSetupFlow", "validPin");
		String invalidPin = utils.readTestData("PIN", "loginForPinLockedSetupFlow", "invalidPin");

		navigateToSettingsWithPinTrue(username, pwd);
		settingsPage.checkChangePinLink();
		settingsPage.tapChangePinLink();
		enterPINMultipleTimes(invalidPin, 3);
		enterCurrentPINPage.checkPinLockedMessage();
		enterCurrentPINPage.tapReAuthenticateButton();
		forgotPINPage.checkForgottenPINPageTitle();
		forgotPINPage.enterPassword(pwd);
		forgotPINPage.tapNextButton();
		enterCurrentPINPage.tapOkButton();
		pinSetupPage.checkEnterPINLabel();
		enterPIN(validPin);
		pinSetupPage.checkReEnterPINLabel();
		enterPIN(validPin);
		Assert.assertNotNull(pinSetupPage.checkPINSuccessfullySetMessage(),
				"Pin successfully set message is not displayed");
		Assert.assertNotNull(settingsPage.checkSettingsTitle(), "Not on setttings page");
		Assert.assertTrue(settingsPage.isPinToggleEnabled(), "Pin toggle is disabled");
	}

	private void navigateToSettingsWithPinTrue(String userName, String pwd) {
		loginToApp(userName, pwd);
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.checkSettingsMenuItem();
		navigationMenu.tapSettingsMenuItem();
	}

	private void enterPIN(String pin) {
		for (char pinDigit : pin.toCharArray()) {
			pinCustomKeypad.tapPINEntry(pinDigit);
		}
	}

	private void enterPINMultipleTimes(String pin, int count) {

		for (int i = 0; i < count; i++) {
			enterPIN(pin);

			if (i != count - 1) {
				common.waitForLoadingIndicatorToDisappear();
				if (i == 0) {

					Assert.assertTrue(
							enterCurrentPINPage.getIncorrectPINErrorMessage().equals(Copy.INCORRECT_PIN_ERROR_MESSAGE),
							"Error message is incorrect");
				}
			}

		}

	}

}
