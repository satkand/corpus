package test.marketplace.auth.pin;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import pages.App;

public class PINAuthTest extends App{
	//Defect on Kumara(AOS 5.1):DMPM-9839
  @TestDetails(story1 = "DMPM-58:DMPM-2286,DMPM-2288,DMPM-2292",story2 = "DMPM-3503:4532,4533,4534")
	@Test (groups = { "marketplace", "pin", "priority-minor"})
	public void testLoginUsingPin() {
		
		String userName = utils.readTestData("PIN", "loginWithExistingPin", "login");
		String pwd = utils.readTestData("PIN", "loginWithExistingPin", "pwd");
		String validpin = utils.readTestData("PIN","loginWithExistingPin", "pin");
		
		navigateToPinAuthScreen(userName,pwd,validpin);
		Assert.assertNotNull(pinAuthPage.checkUserName(),"Pin Auth screen is not displayed");
		Assert.assertNotNull(pinAuthPage.checkPinField(), "Pin field - is not shown");
		Assert.assertNotNull(pinAuthPage.checkBackButton(), "Pin field - is not shown");
		enterPIN(validpin);
		loginPage.waitForLoadingIndicatorToDismiss();
		Assert.assertNotNull(landingPage.checkLandingPageTitle(), "Landing page - is not shown");
	}
//Defect on Kumara(AOS 5.1):DMPM-9839
   @TestDetails(story1 = "DMPM-58:DMPM-2304")
	@Test (groups = {"marketplace", "pin", "priority-minor"})
	public void cancelReauthUsingPin() {
		String userName = utils.readTestData("PIN", "loginWithExistingPin", "login");
		String pwd = utils.readTestData("PIN", "loginWithExistingPin", "pwd");
		String validpin = utils.readTestData("PIN","loginWithExistingPin", "pin");
		navigateToPinAuthScreen(userName,pwd,validpin);
		Assert.assertNotNull(pinAuthPage.checkBackButton(), "Pin field - is not shown");
		pinAuthPage.tapBackButton();
		Assert.assertNotNull(loginAuthPage.checkReloginButton(),"Did not navigate back to reauth page");
	}
 //Defect on Kumara(AOS 5.1):DMPM-9839
	@TestDetails(story1 = "DMPM-3503:DMPM-4535,DMPM-4545,DMPM-4547",story2="DMPM-4963:no testID yet")
	@Test (groups = { "marketplace", "pin", "priority-minor"})
	public void testLoginUsingWhenPinLocked() {
		String userName = utils.readTestData("PIN", "loginLockPinAndSetup", "login");
		String pwd = utils.readTestData("PIN", "loginLockPinAndSetup", "pwd");
		String validpin = utils.readTestData("PIN", "loginLockPinAndSetup", "pin");
		String invalidPin = utils.readTestData("PIN", "loginLockPinAndSetup", "invalidPin");
		navigateToPinAuthScreen(userName,pwd,validpin);
		enterPINMultipleTimes(invalidPin,4);
		Assert.assertTrue(enterCurrentPINPage.getPinLockedMessage().equals(Copy.PIN_LOCK_ALERT_MESSAGE),"Pin Locked Message is incorrect");
		Assert.assertNotNull(enterCurrentPINPage.checkOkButton(), "Ok button is not displayed");
		enterCurrentPINPage.tapOkButton();
		Assert.assertNotNull(forgotPINPage.checkForgottenPINPageTitle(), "Forgot pin page is not displayed");
		forgotPINPage.enterPassword(pwd);
		forgotPINPage.tapNextButton();
	    Assert.assertTrue(enterCurrentPINPage.getPinInstructionTitileText().equals(Copy.PIN_INSTRUCTION_TITLE), "Pin disclaimer title is incorrect");
	    Assert.assertTrue(enterCurrentPINPage.getPinInstructionMessageText().equals(Copy.PIN_INSTRUCTION_MESSAGE), "Pin disclaimer message is incorrect");
		pinSetupPage.tapOkbutton();
		enterPIN(validpin);
		enterPIN(validpin);
		Assert.assertNotNull(pinSetupPage.checkPINSuccessfullySetMessage(),"Pin successfully set message is not displayed");
		Assert.assertNotNull(landingPage.checkLandingPageTitle(), "Landing page - is not shown");
		
	}
	
	//Defect on Kumara(AOS 5.1):DMPM-9839
	@TestDetails(story1 = "DMPM-3503:DMPM-4546")
	@Test (groups = { "marketplace", "pin", "priority-minor"})
	public void testCancellingForgotPin() {
		
		String userName = utils.readTestData("PIN", "cancelForgotPIN", "login");
		String pwd = utils.readTestData("PIN", "cancelForgotPIN", "pwd");
		String validpin = utils.readTestData("PIN", "cancelForgotPIN", "pin");
		String invalidPin = utils.readTestData("PIN", "cancelForgotPIN", "invalidPin");
		
		unlockAndNavigateToAuthScreen(userName ,pwd,validpin,invalidPin);
		enterPINMultipleTimes(invalidPin,4);
		enterCurrentPINPage.tapOkButton();
		forgotPINPage.tapBackButton();
		Assert.assertNotNull(loginAuthPage.checkChangeAccountButton(),"Not on reauth welcome page");
		
	}

	//Defect on Kumara(AOS 5.1):DMPM-9839
	@TestDetails(story1 = "DMPM-3503:DMPM-4535,DMPM-4545,DMPM-4547")
	@Test (groups = { "marketplace", "pin", "priority-minor"})
	public void testCancellingPinLockedSetup() {
		String userName = utils.readTestData("PIN", "cancelPINSetup", "login");
		String pwd = utils.readTestData("PIN", "cancelPINSetup", "pwd");
		String validpin = utils.readTestData("PIN", "cancelPINSetup", "pin");
		String invalidPin = utils.readTestData("PIN", "cancelPINSetup", "invalidPin");
		unlockAndNavigateToAuthScreen(userName ,pwd,validpin,invalidPin);
		enterPINMultipleTimes(invalidPin,4);
		Assert.assertTrue(enterCurrentPINPage.getPinLockedMessage().equals(Copy.PIN_LOCK_ALERT_MESSAGE),"Pin Locked Message is incorrect");
		Assert.assertNotNull(enterCurrentPINPage.checkOkButton(), "Ok button is not displayed");
		enterCurrentPINPage.tapOkButton();
		forgotPINPage.enterPassword(pwd);
		forgotPINPage.tapNextButton();
		pinSetupPage.tapOkbutton();
		pinSetupPage.tapCancelButton();
		Assert.assertNotNull(landingPage.checkLandingPageTitle(), "Landing page - is not shown");
		
	}
	
	private void navigateToPinAuthScreen(String username ,String password,String pin) {
		
		loginToApp(username, password, "DoNotTapMayBeLaterOption");
		pinOptionsPage.tapEnablePinButton();
		enterPIN(pin);
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkLockMenuOption(), "Settings menu item is not shown");
		navigationMenu.tapLockMenuOption();	
		Assert.assertNotNull(loginAuthPage.checkReloginButton(),"Login button not present");
		loginAuthPage.tapReloginButton();
	}	
	
	private void unlockAndNavigateToAuthScreen(String username ,String password,String pin,String invalidPin) {
		
		loginToApp(username, password, "DoNotTapMayBeLaterOption");
		pinOptionsPage.tapEnablePinButton();
		enterPIN(pin);
		enterCurrentPINPage.tapOkButton();
		forgotPINPage.enterPassword(password);
		forgotPINPage.tapNextButton();
		pinSetupPage.tapOkbutton();
		enterPIN(pin);
		enterPIN(pin);
		pinSetupPage.checkPINSuccessfullySetMessage();
		landingPage.checkLandingPageTitle();
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
