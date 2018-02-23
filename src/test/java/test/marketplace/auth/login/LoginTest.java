package test.marketplace.auth.login;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class LoginTest extends App {

	//@Test (groups = {"DMPM-28", "DMPM-391", "marketplace", "login", "priority-?"}) //Scenario 1
	public void testLoginPageElements(){
		navigateToLoginScreen();
		Assert.assertNotNull(loginPage.checkLoginPageTitle(), "Login screen - page title is not shown");
		Assert.assertEquals(loginPage.getLoginPageTitle(), utils.readTestData("copy", "loginPage", "loginPageTitle"), "Login page title is not shown as expected");
		Assert.assertNotNull(loginPage.checkEmailField(), "Login screen - email field is not shown");
		Assert.assertNotNull(loginPage.checkPasswordField(), "Login screen - password is not shown");
		Assert.assertNotNull(loginPage.checkLoginButton(), "Login screen - login button is not shown");
		Assert.assertNotNull(loginPage.checkHelpButton(), "Login screen - help link is not shown");
		Assert.assertNotNull(loginPage.checkBackButton(), "Login screen - back button is not shown");
	}
	
	//@Test (groups = {"DMPM-28", "DMPM-392", "DMPM-395", "marketplace", "login", "priority-?"}) //Scenario 2 4
	public void testKeyboardDisplay() {
		navigateToLoginScreen();
		
		// Asserting that keyboard is not shown before tapping on email field and also keyboard is shown after tapping on email field
		Assert.assertFalse(common.isKeyboardShown(), "keyboard is shown");
		loginPage.tapEmailField();
		//along with asserting this is dismissing the keyboard as well
		Assert.assertTrue(common.isKeyboardShown(), "keyboard not shown");
		
		// Asserting that keyboard is not shown before tapping on password field and also keyboard is shown after tapping on password field
		Assert.assertFalse(common.isKeyboardShown(), "keyboard is shown");
		loginPage.tapPasswordField();
		//along with asserting this is dismissing the keyboard as well
		Assert.assertTrue(common.isKeyboardShown(), "keyboard not shown");
	}
	
	// @Test TODO - This scenario needs to be implemented
	public void abc() {
		navigateToLoginScreen();
		loginPage.enterPassword("abc");
		common.moveAppToBackground();
	}
	
	/*
	//@Test (groups = {"DMPM-28", "DMPM-396", "DMPM-397", "marketplace", "login", "priority-?"}) //scenario 5 6 7
	public void testChevronBehaviour() {
		navigateToLoginScreen();
		loginPage.tapEmailField();
		Assert.assertTrue(keypad.isNextChevronEnabled(), "Login screen - keyboard Next Chevron is disabled");
		keypad.tapNextChevron();
		//focus on password field
		Assert.assertTrue(keypad.isPrevChevronEnabled(), "Login screen - keyboard Previous Chevron is disabled");
		Assert.assertFalse(keypad.isNextChevronEnabled(), "Login screen - keyboard Next Chevron is enabled");
		Assert.assertNull(keypad.checkKeyboardNextButton(), "Login screen - keyboard next button shown");
		Assert.assertNotNull(keypad.checkKeyboardContinueButton(), "Login screen - keyboard continue button not shown");
		Assert.assertNotNull(keypad.checkKeyboardDoneButton(), "Login screen - keyboard done button not shown");
		Assert.assertNotNull(keypad.checkKeyboard(), "Login screen - keyboard not shown");
		
		keypad.tapPrevChevron();
		//foucus on email field
		Assert.assertFalse(keypad.isPrevChevronEnabled(), "Login screen - keyboard Previous Chevron is enabled");
		Assert.assertTrue(keypad.isNextChevronEnabled(), "Login screen - keyboard Next Chevron is disabled");
		Assert.assertNotNull(keypad.checkKeyboardNextButton(), "Login screen - keyboard next button not shown");
		Assert.assertNull(keypad.checkKeyboardContinueButton(), "Login screen - keyboard continue button shown");
		Assert.assertNotNull(keypad.checkKeyboardDoneButton(), "Login screen - keyboard done button not shown");
		Assert.assertNotNull(keypad.checkKeyboard(), "Login screen - keyboard not shown");
		
		keypad.tapKeyboardNextButton();
		//focus on password field
		Assert.assertTrue(keypad.isPrevChevronEnabled(), "Login screen - keyboard Previous Chevron is disabled");
		Assert.assertFalse(keypad.isNextChevronEnabled(), "Login screen - keyboard Next Chevron is enabled");
		Assert.assertNull(keypad.checkKeyboardNextButton(), "Login screen - keyboard next button shown");
		Assert.assertNotNull(keypad.checkKeyboardContinueButton(), "Login screen - keyboard continue button not shown");
		Assert.assertNotNull(keypad.checkKeyboardDoneButton(), "Login screen - keyboard done button not shown");
		Assert.assertNotNull(keypad.checkKeyboard(), "Login screen - keyboard not shown");
		
		keypad.tapKeyboardDoneButton();
		Assert.assertNull(keypad.checkKeyboard(), "Login screen - keyboard shown");

	}
		
	//@Test //Scenario 8
	public void testSuccessfulLoginByTappingonKeypadContinueBtn() {
		navigateToLoginScreen();
		loginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validLoginCredentials", "login1", "login"), utils.readTestData("loginCredentials", "validLoginCredentials", "login1", "pwd"));
		keypad.tapKeyboardContinueButton();
		// TODO -> Add what's shown after user logs in
		// TODO validate success message
		// TODO verify what screen is shown after logging in
		Assert.assertNull(keypad.checkKeyboardContinueButton(), "Login screen - keyboard continue button shown");
		Assert.assertNull(keypad.checkKeyboard(), "Login screen - keyboard shown");
	}
	

	
	//@Test //Scenario 9
	public void testAppsideInlineErrorValidatons() {
		navigateToLoginScreen();
		List invalidCredentialsList = utils.readTestDataList("loginCredentials", "invalidLoginCredentials_appSideValidations");
		for(Object invalidLoginCredentails : invalidCredentialsList) {
			enterRegexInvalidCredentials(invalidLoginCredentails);
		}
	}
	
	private void enterRegexInvalidCredentials(Object invalidLoginCredentails) {
		HashMap<String, String> invalidCredentails = (HashMap<String, String>)invalidLoginCredentails;
		loginPage.enterLoginCredentials(invalidCredentails.get("login"), invalidCredentails.get("pwd"));
		keypad.tapKeyboardDoneButton();
		
		if(!(invalidCredentails.get("loginError") == null)) {
			Assert.assertEquals(loginPage.getEmailFieldErrorValue(), invalidCredentails.get("loginError"));
		} else {
			Assert.assertNull(loginPage.checkEmailFieldError());
		}
		
		if(!(invalidCredentails.get("pwdError") == null)) {
			Assert.assertEquals(loginPage.getPasswordFieldErrorValue(), invalidCredentails.get("pwdError"));
		} else {
			Assert.assertNull(loginPage.checkPasswordFieldError());
		}
		
		Assert.assertEquals(loginPage.isLoginButtonEnabled(), invalidCredentails.get("loginButton"));
	}
	
	//@Test //Scenario 10
	public void testServersideValidations() {
		navigateToLoginScreen();
		List invalidCredentialsList = utils.readTestDataList("loginCredentials", "invalidLoginCredentials_ServerSideValidations");
		for(Object invalidLoginCredentails : invalidCredentialsList) {
			enterServersideInvalidCredentials(invalidLoginCredentails);
		}
	}
	
	private void enterServersideInvalidCredentials(Object invalidLoginCredentails) {
		HashMap<String, String> invalidCredentails = (HashMap<String, String>)invalidLoginCredentails;
		loginPage.enterLoginCredentials(invalidCredentails.get("login"), invalidCredentails.get("pwd"));
		loginPage.tapLoginButton();
		
		if(!(invalidCredentails.get("loginError") == null)) {
			Assert.assertEquals(loginPage.getEmailFieldErrorValue(), invalidCredentails.get("loginError"));
		} else {
			Assert.assertNull(loginPage.checkEmailFieldError());
		}
		
		if(!(invalidCredentails.get("pwdError") == null)) {
			Assert.assertEquals(loginPage.getPasswordFieldErrorValue(), invalidCredentails.get("pwdError"));
		} else {
			Assert.assertNull(loginPage.checkPasswordFieldError());
		}
	}
	*/
	
	@Test //Scenario 6
	public void testHidingInilineErrorMessages() {
		navigateToLoginScreen();
		/*
		TODO clear the error messages which occured during server side validations as well
		List invalidList = new ArrayList();
		invalidList.add(utils.readTestDataList("loginCredentials", "invalidLoginCredentials_appSideValidations").get(4));
		invalidList.add(utils.readTestDataList("loginCredentials", "invalidLoginCredentials_ServerSideValidations").get(1));
		 */
		HashMap<String, String> invalidCredentails = (HashMap<String, String>)(utils.readTestDataList("loginCredentials", "invalidLoginCredentials_appSideValidations").get(2));
		loginPage.enterLoginCredentials(invalidCredentails.get("login"), invalidCredentails.get("pwd"));
		common.dismissKeyboardShown();
		Assert.assertEquals(loginPage.getEmailFieldErrorValue(), invalidCredentails.get("loginError"));
		Assert.assertEquals(loginPage.getPasswordFieldErrorValue(), invalidCredentails.get("pwdError"));
		loginPage.enterEmail("a");
		Assert.assertNull(loginPage.checkEmailFieldError());
		loginPage.enterPassword("a");
		Assert.assertNull(loginPage.checkPasswordFieldError());
	}
	
	//@Test //scenario 7
	public void testSuccessfulLoginByTappingonLoginBtn() {
		navigateToLoginScreen();
		loginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validLoginCredentials", "login1", "login"), utils.readTestData("loginCredentials", "validLoginCredentials", "login1", "pwd"));
		common.dismissKeyboardShown();
		loginPage.tapLoginButton();
		// TODO -> Add what's shown after user logs in
		// TODO validate success message
		// TODO verify what screen is shown after logging in
	}
	
	private void navigateToLoginScreen() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen -Suncorp image is not shown");
		welcomePage.tapLoginButton();
	}
}
