package test.marketplace.auth.login;

import static org.testng.Assert.assertNotNull;

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
		//Dismissing the keyboard after verification
		Assert.assertTrue(common.isKeyboardShown(), "keyboard not shown");
		
		// Asserting that keyboard is not shown before tapping on password field and also keyboard is shown after tapping on password field
		Assert.assertFalse(common.isKeyboardShown(), "keyboard is shown");
		loginPage.tapPasswordField();
		//Dismissing the keyboard after verification
		Assert.assertTrue(common.isKeyboardShown(), "keyboard not shown");
	}
	
	//DMPM-43 - Scenario-3
	@Test (groups = {"DMPM-43", "DMPM-211", "marketplace", "login", "priority-minor"})
	public void testClearPasswordField() {
		navigateToLoginScreen();
		loginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validLoginCredentials", "login"), utils.readTestData("loginCredentials", "invalidCredentials", "invalidPassword"));
		//Putting the app in background indefinitely and launching it using currentActivity method
		loginPage.relaunchApp(-1, "Config");
		Assert.assertNotNull(loginPage.checkLoginPageTitle(), "Login screen - page title is not shown");
		System.out.println("############"+loginPage.getPasswordFieldValue());
		Assert.assertEquals(loginPage.getPasswordFieldValue(), "", "VLogin screen - Password field is not empty");
	}
	
	//DMPM-43 - Scenario-4,5
	//DMPM-235 - Scenario-1,2,5
	
	@Test (groups = {"DMPM-43", "DMPM-293", "DMPM-235", "DMPM-912", "DMPM-912", "DMPM-915", "marketplace", "login", "priority-medium"})
	public void testInlineValidation() {
		
		String errorVal = "";
		navigateToLoginScreen();
	
		/** Tapping out of the Field **/
		//Empty Email Error
		loginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailEmpty"));
		loginPage.tapPasswordField();
		Assert.assertEquals(loginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "emptyEmailError"));
		
		//Email length more than 100 characters
		loginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailExceedsMaxLength"));
		loginPage.tapPasswordField();
		Assert.assertEquals(loginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "longEmailError"));
		
		//Email length less than 2 characters
		loginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailMinLength"));
		loginPage.tapPasswordField();
		errorVal = loginPage.getEmailFieldErrorValue().replace("\n\n", " ");
		Assert.assertEquals(errorVal, utils.readTestData("copy", "loginPage", "shortEmailError"));
		
		//Incorrect email format 1
		loginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailIncorrectFormat1"));
		loginPage.tapPasswordField();
		Assert.assertEquals(loginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "invalidEmailError"));
		
		//Incorrect email format 2
		loginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailIncorrectFormat2"));
		loginPage.tapPasswordField();
		Assert.assertEquals(loginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "invalidEmailError"));
		
		//Empty password - only inline error displayed for password
		loginPage.enterPassword(utils.readTestData("loginCredentials", "invalidCredentials","passwordEmpty"));
		loginPage.tapEmailField();
		Assert.assertEquals(loginPage.getPasswordFieldErrorValue(), utils.readTestData("copy", "loginPage", "emptyPasswordError"));
		
		/** Tapping on the Login button **/
		//Empty Email Error
		loginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailEmpty"));
		loginPage.tapLoginButton();
		Assert.assertEquals(loginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "emptyEmailError"));
		
		//Email length more than 100 characters
		loginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailExceedsMaxLength"));
		loginPage.tapLoginButton();
		Assert.assertEquals(loginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "longEmailError"));
		
		//Email length less than 2 characters
		loginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailMinLength"));
		loginPage.tapLoginButton();
		errorVal = loginPage.getEmailFieldErrorValue().replace("\n\n", " ");
		Assert.assertEquals(errorVal, utils.readTestData("copy", "loginPage", "shortEmailError"));
		
		//Incorrect email format 1
		loginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailIncorrectFormat1"));
		loginPage.tapLoginButton();
		Assert.assertEquals(loginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "invalidEmailError"));
		
		//Incorrect email format 2
		loginPage.enterEmail(utils.readTestData("loginCredentials", "invalidCredentials","emailIncorrectFormat2"));
		loginPage.tapLoginButton();
		Assert.assertEquals(loginPage.getEmailFieldErrorValue(), utils.readTestData("copy", "loginPage", "invalidEmailError"));
		
		//Empty password - only inline error displayed for password
		loginPage.enterPassword(utils.readTestData("loginCredentials", "invalidCredentials","passwordEmpty"));
		loginPage.tapLoginButton();
		Assert.assertEquals(loginPage.getPasswordFieldErrorValue(), utils.readTestData("copy", "loginPage", "emptyPasswordError"));
	}
	
	//DMPM-43 - Scenario-6 applies only when the inline error 'Field is required' is displayed
	//DMPM-235 - Scenario-3 and 4
	
	@Test (groups = {"DMPM-43", "DMPM-235", "DMPM-294", "DMPM-913", "DMPM-914", "marketplace", "login", "priority-minor"})
	public void testHideInlineErrorMsg() {
		String errorVal = "";
		navigateToLoginScreen();
		loginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "invalidCredentials", "emailMinLength"), "");
		loginPage.tapLoginButton();
		errorVal = loginPage.getEmailFieldErrorValue().replace("\n\n", " ");
		Assert.assertEquals(errorVal, utils.readTestData("copy", "loginPage", "shortEmailError"));
		Assert.assertEquals(loginPage.getPasswordFieldErrorValue(),utils.readTestData("copy", "loginPage", "emptyPasswordError"));
		
		//Check inline errors exist when field is highlighted
		loginPage.tapEmailField();
		Assert.assertEquals(errorVal, utils.readTestData("copy", "loginPage", "shortEmailError"));
		loginPage.tapPasswordField();
		Assert.assertEquals(loginPage.getPasswordFieldErrorValue(), utils.readTestData("copy", "loginPage", "emptyPasswordError"));
		//Check inline errors are removed as valid credentials are entered
		loginPage.enterEmail(utils.readTestData("loginCredentials", "validLoginCredentials", "login"));
		Assert.assertNull(loginPage.checkEmailFieldError());
		loginPage.enterPassword("a");
		Assert.assertNull(loginPage.checkPasswordFieldError());
	}
	
	//DMPM-43 - Scenario-7
	//DMPM-163 - Scenario-1, 2

	@Test (groups = {"DMPM-43", "DMPM-163", "DMPM-1135", "DMPM-1136", "marketplace", "login", "priority-high"})
	public void testValidCredentials() {
		if(loginAuthPage.checkChangeAccountButton() != null) {
			loginAuthPage.tapChangeAccountButton();
		}
		navigateToLoginScreen();
		loginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validLoginCredentials", "login"), utils.readTestData("loginCredentials", "validLoginCredentials", "pwd"));
		loginPage.tapLoginButton();
		Assert.assertNotNull(loginPage.checkLoadingIndicator(), "Login screen - Login indicator not displayed");
		Assert.assertNotNull(pinOptionsPage.checkEnablePinButton(), "PIN Options Page - Title message not displayed");
	}
	
	//DMPM-163 - Scenario-3  - incorrect credentials: 401 Bad Username or Password
	
	@Test (groups = {"DMPM-163", "DMPM-1137", "marketplace", "login", "priority-high"})
	public void testLoginServerSideValidations() {
		navigateToLoginScreen();
		loginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validLoginCredentials", "login"), utils.readTestData("loginCredentials", "invalidCredentials", "invalidPassword"));
		loginPage.tapLoginButton();
		Assert.assertNotNull(loginPage.checkSnackbarText(), "Login Screen -  The snackbar not displayed");
		Assert.assertNotNull(loginPage.checkSnackbarButton(), "Login Screen - The button not displayed on the snackbar");
		Assert.assertEquals(loginPage.getSnackbarTextValue(), utils.readTestData("copy", "loginPage", "snackbarTextIncorrectLogin"));
		loginPage.tapSnackbarOkButton();
		Assert.assertNull(loginPage.checkSnackbarText(), "Login Screen - The snackbar still displayed");
	}
	
	
	private void navigateToLoginScreen() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen -Suncorp image is not shown");
		welcomePage.tapLoginButton();
	}
}
