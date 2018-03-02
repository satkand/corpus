package test.marketplace.auth.pin;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class ForgotPINTest extends App {

	//Scenario 1
	@Test (groups = {"DMPM-67", "DMPM-504", "marketplace", "pin", "priority-major"})
	public void testPINReAuthPasswordPageElements() {
		navigateToPINReAuthPasswordPage();
		//Verifying the elements present on the screen
		Assert.assertNotNull(forgotPINPage.checkForgottenPINPageTitle(), "PIN Reauthenticate Password screen - 'Forgotten PIN page title is not shown");
		Assert.assertEquals(forgotPINPage.getForgottenPINPageTitle(), utils.readTestData("copy", "pinReAuthPasswordPage", "forgottenPINPageTitle"), "PIN Reauthenticate Password screen - page title copy not shown as expected");
		Assert.assertNotNull(forgotPINPage.checkPINReAuthPasswordLabe(), "PIN Reauthenticate Password screen - 'enter pwd to reset pin' label is not shown");
		Assert.assertEquals(forgotPINPage.getPINReAuthPasswordLabe(), utils.readTestData("copy", "pinReAuthPasswordPage", "pinReAuthPasswordLabel"), "PIN Reauthenticate Password screen - Please enter your pwd to reset ur pin copy is not valid");
		Assert.assertNotNull(forgotPINPage.checkPasswordField(), "PIN Reauthenticate Password screen - password field is not shown");
		Assert.assertNotNull(forgotPINPage.checkNextButton(), "PIN Reauthenticate Password screen - Next button is not shown");
		Assert.assertNotNull(forgotPINPage.checkForgotPasswordButton(), "PIN Reauthenticate Password screen - Forgot password button is not shown");
		Assert.assertNotNull(forgotPINPage.checkBackButton(), "PIN Reauthenticate Password screen - Back button is not shown");
	}

	//Scenario 3
	@Test (groups = {"DMPM-67", "DMPM-504", "marketplace", "pin", "priority-major"})
	public void testClearPasswordOnMovingAppToBackground() {
		navigateToPINReAuthPasswordPage();
		//Password should get cleared by moving the app to background
		forgotPINPage.enterPassword(utils.readTestData("loginCredentials", "validLoginCredentials", "login1", "pwd"));
		common.moveAppToBackground();
		Assert.assertEquals(forgotPINPage.getPasswordValue(), "", "password value still shown even after app is moved to background and launched back");
	}
	
	//Scenario 2 and Scenario 4 and Scenario 5
	@Test (groups = {"DMPM-67", "DMPM-504", "DMPM-505", "marketplace", "pin", "priority-major"})
	public void testValidatePasswordWithEmptyValue() {
		navigateToPINReAuthPasswordPage();
		String expectedErrorMessage = utils.readTestData("copy", "pinReAuthPasswordPage", "passwordRequiredError");
		// Verifying that the keyboard is shown when password field is tapped
		forgotPINPage.tapPasswordField();
		// isKeyboardShown() methods checks if the kyboard is present and if present it dimisses the keyboard as well
		Assert.assertTrue(common.isKeyboardShown(), "PIN Reauthenticate Password page - keybaord is not shown");
		// Verifying that the 'password required error" message is shown when password field is left empty and tapped on Next button
		forgotPINPage.tapNextButton();
		Assert.assertNotNull(forgotPINPage.checkPasswordRequiredError(), "PIN Reauthenticate Password screen - password required error not shown");
		Assert.assertEquals(forgotPINPage.getPasswordRequiredErrorMessage(), expectedErrorMessage, expectedErrorMessage+" not shown");
		// Verifying that the keyboard is not shown when keyboard is dismissed
		Assert.assertFalse(common.isKeyboardShown(), "PIN Reauthenticate Password page - keybaord is not shown");
	}
	
	// TODO Scenario 6
	// If in case there are invalid password values in future, then we need to modify the methods (uncomment the TODO statements), so that they can enter some invalid data
	// Scenario 6
	@Test (groups = {"DMPM-67", "DMPM-505", "marketplace", "pin", "priority-major"})
	public void testInvalidPwdByTappingOnNextButton() {
		navigateToPINReAuthPasswordPage();
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
		forgotPINPage.enterPassword(utils.readTestData("loginCredentials", "validLoginCredentials", "login1", "pwd"));
		Assert.assertNull(forgotPINPage.checkPasswordRequiredError(), "PIN Reauthenticate Password screen - password required error shown");
	}
	
	//Scenario 8
	@Test (groups = {"DMPM-67", "DMPM-505", "marketplace", "pin", "priority-major"})
	public void testReauthSuccessfulByTappingOnNextButton() {
		navigateToPINReAuthPasswordPage();
		forgotPINPage.tapPasswordField();
		// Entering valid password and verifying that success message is shown on tap of Next button
		forgotPINPage.enterPassword(utils.readTestData("loginCredentials", "validLoginCredentials", "login1", "pwd"));
		forgotPINPage.tapNextButton();
		Assert.assertNotNull(pinSetupPage.checkEnterPINLabel(), "PIN Setup screen not shown");
	}
	
	private void navigateToPINReAuthPasswordPage() {
		loginToApp(utils.readTestData("loginCredentials", "validLoginCredentials", "login1", "login"), utils.readTestData("loginCredentials", "validLoginCredentials", "login1", "pwd"));
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.tapLockMenuOption();
		dummy.tapLoginAsButton();
		pinAuthPage.tapForgottenPINButton();
	}
}
