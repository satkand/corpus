package test.marketplace.auth.pin;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import pages.App;

public class ForgotPINTest extends App {
	
	//Defect on Kumara(AOS 5.1):DMPM-9839
	//Scenario 1
	@TestDetails(story1 = "DMPM-67:DMPM-504")
	@Test (groups = {"marketplace", "pin", "priority-major"})
	public void testPINReAuthPasswordPageElements() {
		String userName = utils.readTestData("PIN", "loginWithExistingPin", "login1");
		String pwd = utils.readTestData("PIN", "loginWithExistingPin", "pwd");
		String validpin = utils.readTestData("PIN","loginWithExistingPin", "pin1");
		//navigateToPINReAuthPasswordPage();
		navigateToPinAuthScreen( userName,pwd,validpin);
		pinAuthPage.tapForgottenPINButton();
		//Verifying the elements present on the screen
		Assert.assertNotNull(forgotPINPage.checkForgottenPINPageTitle(), "PIN Reauthenticate Password screen - 'Forgotten PIN page title is not shown");
		Assert.assertEquals(forgotPINPage.getForgottenPINPageTitle(), Copy.FORGOTTEN_PIN_PAGE_TITLE, "PIN Reauthenticate Password screen - page title copy not shown as expected");
		Assert.assertNotNull(forgotPINPage.checkPINReAuthPasswordLabe(), "PIN Reauthenticate Password screen - 'enter pwd to reset pin' label is not shown");
		Assert.assertEquals(forgotPINPage.getPINReAuthPasswordLabe(), utils.readTestData("copy", "pinReAuthPasswordPage", "pinReAuthPasswordLabel"), "PIN Reauthenticate Password screen - Please enter your pwd to reset ur pin copy is not valid");
		Assert.assertNotNull(forgotPINPage.checkPasswordField(), "PIN Reauthenticate Password screen - password field is not shown");
		Assert.assertNotNull(forgotPINPage.checkNextButton(), "PIN Reauthenticate Password screen - Next button is not shown");
		Assert.assertNotNull(forgotPINPage.checkForgotPasswordButton(), "PIN Reauthenticate Password screen - Forgot password button is not shown");
		Assert.assertNotNull(forgotPINPage.checkBackButton(), "PIN Reauthenticate Password screen - Back button is not shown");
	}
	//Defect on Kumara(AOS 5.1):DMPM-9839
	//Scenario 3
	@TestDetails(story1 = "DMPM-67:DMPM-504")
	@Test (groups = {"marketplace", "pin", "priority-major"})
	public void testClearPasswordOnMovingAppToBackground() {
		
		String userName = utils.readTestData("PIN", "loginWithExistingPin", "login1");
		String pwd = utils.readTestData("PIN", "loginWithExistingPin", "pwd");
		String validpin = utils.readTestData("PIN","loginWithExistingPin", "pin1");
		//navigateToPINReAuthPasswordPage();
		navigateToPinAuthScreen( userName,pwd,validpin);
		pinAuthPage.tapForgottenPINButton();
		//Password should get cleared by moving the app to background
		forgotPINPage.enterPassword(pwd);
		forgotPINPage.relaunchApp(-1, "Config");
		Assert.assertEquals(forgotPINPage.getPasswordValue(), "", "password value still shown even after app is moved to background and launched back");
	}
	//Defect on Kumara(AOS 5.1):DMPM-9839
	//Scenario 2 and Scenario 4 and Scenario 5
	@TestDetails(story1 = "DMPM-67:DMPM-504,DMPM-505")
	@Test (groups = {"marketplace", "pin", "priority-major"})
	public void testValidatePasswordWithEmptyValue() {
		
		String userName = utils.readTestData("PIN", "loginWithExistingPin", "login1");
		String pwd = utils.readTestData("PIN", "loginWithExistingPin", "pwd");
		String validpin = utils.readTestData("PIN","loginWithExistingPin", "pin1");
		
		navigateToPinAuthScreen( userName,pwd,validpin);
		pinAuthPage.tapForgottenPINButton();

		// Verifying that the keyboard is shown when password field is tapped
		forgotPINPage.tapPasswordField();
		// isKeyboardShown() methods checks if the kyboard is present and if present it dimisses the keyboard as well
		Assert.assertTrue(common.isKeyboardShown(), "PIN Reauthenticate Password page - keybaord is not shown");
		// Verifying that the 'password required error" message is shown when password field is left empty and tapped on Next button
		forgotPINPage.tapNextButton();
		Assert.assertNotNull(forgotPINPage.checkPasswordRequiredError(), "PIN Reauthenticate Password screen - password required error not shown");
		Assert.assertEquals(forgotPINPage.getPasswordRequiredErrorMessage(), Copy.PASSWORD_REQUIRED_ERROR, Copy.PASSWORD_REQUIRED_ERROR+" not shown");
		// Verifying that the keyboard is not shown when keyboard is dismissed
		Assert.assertFalse(common.isKeyboardShown(), "PIN Reauthenticate Password page - keybaord is not shown");
	}
	
	//Defect on Kumara(AOS 5.1):DMPM-9839
	// TODO Scenario 6
	// If in case there are invalid password values in future, then we need to modify the methods (uncomment the TODO statements), so that they can enter some invalid data
	// Scenario 6
	@TestDetails(story1 = "DMPM-67:DMPM-505")
	@Test (groups = {"DMPM-67", "DMPM-505", "marketplace", "pin", "priority-major"})
	public void testInvalidPwdByTappingOnNextButton() {
		
		String userName = utils.readTestData("PIN", "loginWithExistingPin", "login1");
		String pwd = utils.readTestData("PIN", "loginWithExistingPin", "pwd");
		String validpin = utils.readTestData("PIN","loginWithExistingPin", "pin1");
		
		navigateToPinAuthScreen( userName,pwd,validpin);
		pinAuthPage.tapForgottenPINButton();
		String expectedErrorMessage = utils.readTestData("copy", "pinReAuthPasswordPage", "passwordRequiredError");
		// Invalid password - only blank password is invalid password as per story. So not typing anything, leaving the field blank
		forgotPINPage.tapPasswordField();
		//TODO pinReAuthPasswordPage.enterPassword(utils.readTestData("loginCredentials", "inValidPwds", "pwd1"));
		forgotPINPage.tapNextButton();
		// error message stating that password is required should be shown
		Assert.assertNotNull(forgotPINPage.checkPasswordRequiredError(), "PIN Reauthenticate Password screen - password required error not shown");
		Assert.assertEquals(forgotPINPage.getPasswordRequiredErrorMessage(), expectedErrorMessage, expectedErrorMessage+" not shown");
		
		// Verifying that on correcting the invalid pwd to a valid one and error should disappear
		forgotPINPage.tapPasswordField();
		forgotPINPage.enterPassword(pwd);
		Assert.assertNull(forgotPINPage.checkPasswordRequiredError(), "PIN Reauthenticate Password screen - password required error shown");
	}
	//Defect on Kumara(AOS 5.1):DMPM-9839
	//Scenario 8
	@TestDetails(story1 = "DMPM-67:DMPM-505")
	@Test (groups = {"marketplace", "pin", "priority-major"})
	public void testReauthSuccessfulByTappingOnNextButton() {
		
		String userName = utils.readTestData("PIN", "loginWithExistingPin", "login1");
		String pwd = utils.readTestData("PIN", "loginWithExistingPin", "pwd");
		String validpin = utils.readTestData("PIN","loginWithExistingPin", "pin1");
		
		navigateToPinAuthScreen( userName,pwd,validpin);
		pinAuthPage.tapForgottenPINButton();
		
		//navigateToPINReAuthPasswordPage();
		forgotPINPage.tapPasswordField();
		// Entering valid password and verifying that success message is shown on tap of Next button
		forgotPINPage.enterPassword(pwd);
		forgotPINPage.tapNextButton();
		assertNextButtonTapSucess();
		
	}

//	private void navigateToPINReAuthPasswordPage() {
//		loginToApp(utils.readTestData("loginCredentials", "validLoginCredentials", "login1"), utils.readTestData("loginCredentials", "validLoginCredentials","pwd"));
//		navigationMenu.tapSplitMenuIcon();
//		navigationMenu.tapLockMenuOption();
//		dummy.tapLoginAsButton();
//		pinAuthPage.tapForgottenPINButton();
//	}
	
	private void navigateToPinAuthScreen(String username, String password, String pin) {

		loginToApp(username, password, "DoNotTapMayBeLaterOption");
		pinOptionsPage.tapEnablePinButton();
		enterPIN(pin);
		if (enterCurrentPINPage.checkOkButton() != null) {

			enterCurrentPINPage.tapOkButton();
		}
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkLockMenuOption(), "Settings menu item is not shown");
		navigationMenu.tapLockMenuOption();
		Assert.assertNotNull(loginAuthPage.checkReloginButton(), "Login button not present");
		loginAuthPage.tapReloginButton();
	}
	
	private void enterPIN(String pin) {
		for (char pinDigit : pin.toCharArray()) {
			pinCustomKeypad.tapPINEntry(pinDigit);
		}
	}
	
	private void assertNextButtonTapSucess() {
		
		if (enterCurrentPINPage.checkOkButton() != null) {

			enterCurrentPINPage.tapOkButton();
		}
		Assert.assertNotNull(pinSetupPage.checkEnterPINLabel(), "PIN Setup screen not shown");
	}
}
