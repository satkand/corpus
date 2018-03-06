package test.marketplace.auth.login;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class LoginTest extends App {
	
	//DMPM-43 - Scenario-1
	@Test (groups = {"DMPM-43", "DMPM-207", "marketplace", "login", "priority-medium"})
	public void testLoginPageElements() {
		navigateToLoginScreen();
		Assert.assertNotNull(loginPage.checkLoginPageTitle(), "Login screen - page title is not shown");
		Assert.assertEquals(loginPage.getLoginPageTitle(), utils.readTestData("copy", "loginPage", "loginPageTitle"), "Login page title is not shown as expected");
		Assert.assertNotNull(loginPage.checkEmailField(), "Login screen - email field is not shown");
		Assert.assertNotNull(loginPage.checkPasswordField(), "Login screen - password is not shown");
		Assert.assertNotNull(loginPage.checkLoginButton(), "Login screen - login button is not shown");
		Assert.assertNotNull(loginPage.checkHelpButton(), "Login screen - help link is not shown");
		Assert.assertNotNull(loginPage.checkBackButton(), "Login screen - back button is not shown");
	}
	
	//DMPM-43 - Scenario-2
	@Test (groups = {"DMPM-43", "DMPM-208", "marketplace", "login", "priority-medium"})
	public void testKeyboardDisplay() {
		navigateToLoginScreen();
		
		// Asserting that keyboard is not shown before tapping on email field and also keyboard is shown after tapping on email field
		Assert.assertFalse(common.isKeyboardShown(), "keyboard is shown");
		loginPage.tapEmailField();
		Assert.assertTrue(common.isKeyboardShown(), "keyboard not shown");
		
		// Asserting that keyboard is not shown before tapping on password field and also keyboard is shown after tapping on password field
		Assert.assertFalse(common.isKeyboardShown(), "keyboard is shown");
		loginPage.tapPasswordField();
		Assert.assertTrue(common.isKeyboardShown(), "keyboard not shown");
	}
	
	//DMPM-43 - Scenario-3
	@Test (groups = {"DMPM-43", "DMPM-211", "marketplace", "login", "priority-minor"})
	public void testClearPasswordField() {
		navigateToLoginScreen();
		loginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validLoginCredentials", "login1", "login"), utils.readTestData("loginCredentials", "validLoginCredentials", "login1", "pwd"));
		//Putting the app in background indefinitely and launching it using currentActivity method
		loginPage.relaunchApp(-1);
		Assert.assertNotNull(loginPage.checkLoginPageTitle(), "Login screen - page title is not shown");
		Assert.assertNull(loginPage.checkPasswordFieldError());
	}
	
	//DMPM-43 - Scenario-4,5
	@Test (groups = {"DMPM-43", "DMPM-211", "marketplace", "login", "priority-medium"})
	public void testInlineValidation() {
		navigateToLoginScreen();
		List invalidCredentialsList = utils.readTestDataList("loginCredentials", "invalidLoginCredentials_appSideValidations");
		for(Object invalidLoginCredentails : invalidCredentialsList) {
			enterRegexInvalidCredentials(invalidLoginCredentails);
		}
	}
	
	//Enter the invalid credentials from JSON file
	
	private void enterRegexInvalidCredentials(Object invalidLoginCredentails) {
		HashMap<String, String> invalidCredentails = (HashMap<String, String>)invalidLoginCredentails;
		loginPage.enterLoginCredentials(invalidCredentails.get("login"), invalidCredentails.get("pwd"));
		loginPage.tapLoginButton(); //Move out of password field

		if(!(invalidCredentails.get("loginError") == null)) {
			String errorVal = loginPage.getEmailFieldErrorValue().replace("\n\n", " ");
					
			Assert.assertEquals(errorVal, invalidCredentails.get("loginError"));
		} else {
			Assert.assertNull(loginPage.checkEmailFieldError());
		}
		
		if(!(invalidCredentails.get("pwdError") == null)) {
			Assert.assertEquals(loginPage.getPasswordFieldErrorValue(), invalidCredentails.get("pwdError"));
		} else {
			Assert.assertNull(loginPage.checkPasswordFieldError());
		}		
	}
	
	//DMPM-43 - Scenario-6 applies only when the inline error 'Field is required' is displayed
	
	@Test (groups = {"DMPM-43", "DMPM-294", "marketplace", "login", "priority-minor"})
	public void testHideInlineErrorMsg() {
		navigateToLoginScreen();
		HashMap<String, String> invalidCredentails = (HashMap<String, String>)(utils.readTestDataList("loginCredentials", "invalidLoginCredentials_appSideValidations").get(0));
		loginPage.enterLoginCredentials(invalidCredentails.get("login"), invalidCredentails.get("pwd"));
		loginPage.tapLoginButton();
		String errorVal = loginPage.getEmailFieldErrorValue().replace("\n\n", " ");
		Assert.assertEquals(errorVal, invalidCredentails.get("loginError"));
		Assert.assertEquals(loginPage.getPasswordFieldErrorValue(),invalidCredentails.get("pwdError"));
		loginPage.enterEmail("ab");
		Assert.assertNull(loginPage.checkEmailFieldError());
		loginPage.enterPassword("a");
		Assert.assertNull(loginPage.checkPasswordFieldError());
	}
	
	//DMPM-43 - Scenario-7
	@Test (groups = {"DMPM-43", "DMPM-", "marketplace", "login", "priority-minor"})
	public void testValidCredentials() {
		
		if (welcomePage.checkWelcomeSuncorpImage() != null) {
			navigateToLoginScreen();
			loginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validLoginCredentials", "login1", "login"), utils.readTestData("loginCredentials", "validLoginCredentials", "login1", "pwd"));
			loginPage.tapLoginButton();
			Assert.assertNotNull(loginPage.checkEnablePinScreenTitle(), "Login screen - Title message not displayed");
		}
		else {
			Assert.assertNotNull(loginAuthPage.checkReloginButton(), "Reauth Page - Relogin button not displayed");
			loginAuthPage.tapChangeAccountButton();
			navigateToLoginScreen();
			loginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validLoginCredentials", "login1", "login"), utils.readTestData("loginCredentials", "validLoginCredentials", "login1", "pwd"));
			loginPage.tapLoginButton();
			Assert.assertNotNull(loginPage.checkEnablePinScreenTitle(), "Login screen - Title message not displayed");
		}
	}
	
	private void navigateToLoginScreen() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen -Suncorp image is not shown");
		welcomePage.tapLoginButton();
	}
}
