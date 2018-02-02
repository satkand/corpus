package test.marketplace.auth;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.framework.utils.AutoUtilities;
import pages.App;
import pages.marketplace.auth.PINSetupPage;
import pages.marketplace.common.WelcomePage;

public class PINSetupTest extends App {
	
	@Test (groups = {"DMPM-19", "DMPM-301", "marketplace", "pin", "priority-medium"})
	public void testPINSetupPageElements() {
		navigateToPINSetupPage();
		Assert.assertNotNull(pinSetupPage.checkEnterPINLabel(), "PIN Setup Page - Enter 4 digit pin message not shown");
		Assert.assertEquals(pinSetupPage.getEnterPINLabel(), utils.readTestData("copy", "pinSetupPage", "enterPINLabel"),"PIN Setup Page - Enter 4 digit pin copy is not valid");
		Assert.assertNotNull(pinSetupPage.checkCancelButton(), "PIN Setup page - Close option not shown");
		Assert.assertNotNull(pinCustomKeypad.checkDeletePinEntry(), "PIN Setup page - Delete pin option not shown");
	}
	
	@Test (groups = {"DMPM-19", "DMPM-301", "marketplace", "pin", "priority-medium"})
	public void testBlacklistedNumbersAsPIN() {
		navigateToPINSetupPage();
		List invalidPINList = (List)utils.readTestDataList("pinEntries", "invalidPINEntries");
		// for each invalid pin entry, verify that the error message is shown
		for(Object invalidPIN : (List)invalidPINList) {
			enterPIN(invalidPIN.toString());
			Assert.assertNotNull(pinSetupPage.checkInvalidPINAlertMessage(), "Invalid PIN Alert - Message not shown");
			Assert.assertEquals(pinSetupPage.getInvalidPINAlertMessage(), utils.readTestData("copy", "pinSetupPage", "invalidPINAlertMessage"),"PIN Setup Page - blacklisted pin error alert copy is not valid");
			Assert.assertNotNull(pinSetupPage.checkInvalidPINAlertOKButton(), "Invalid PIN Alert - Ok button not shown");
			pinSetupPage.tapInvalidPINAlertOKButton();
		}	
	}
	
	// testing pin setup behaviour when different valid pins are given on enter pin and reenter pin pages
	@Test (groups = {"DMPM-19", "DMPM-304", "marketplace", "pin", "priority-medium"})
	public void testDifferentPINOnConfirmPINPage() {
		navigateToPINSetupPage();
		enterPIN(utils.readTestData("pinEntries", "validPINEntry1"));
		Assert.assertNotNull(pinSetupPage.checkReEnterPINLabel(), "Reenter PIN Page - is not shown");
		Assert.assertEquals(pinSetupPage.getReEnterPINLabel(), utils.readTestData("copy", "pinSetupPage", "reEnterPINLabel"),"Reenter PIN Page - ReEnter 4 digit pin copy is not valid");
		enterPIN(utils.readTestData("pinEntries", "validPINEntry2"));
		Assert.assertNotNull(pinSetupPage.checkPINsDonotMatchErrorMessage(), "pins do not match error message not shown");
		Assert.assertEquals(pinSetupPage.getPINsDonotMatchErrorMessage(), utils.readTestData("copy", "pinSetupPage", "pinsDonotMatchErrorMessage"),"pins do not match error copy is not valid");
	}
	
	// setting up valid pin
	@Test (groups = {"DMPM-19", "DMPM-302", "marketplace", "pin", "priority-medium"})
	public void testValidNumberAsPIN() {
		navigateToPINSetupPage();
		String validPIN = utils.readTestData("pinEntries", "validPINEntry1");
		enterPIN(validPIN);
		Assert.assertNotNull(pinSetupPage.checkReEnterPINLabel(), "Reenter PIN Page - is not shown");
		enterPIN(validPIN);
		Assert.assertNotNull(pinSetupPage.checkPINSuccessfullySetNotification(), "Reenter PIN page - PIN is not set successfully");
		Assert.assertNotNull(pinSetupPage.checkPINSuccessfullySetMessage(), "Reenter PIN page - PIN is not set successfully");
		Assert.assertEquals(pinSetupPage.getPINSuccessfullySetMessage(), utils.readTestData("copy", "pinSetupPage", "pinSuccessfullySetMessage"),"pins set successfully alert copy is not valid");
	}
	
	// testing close button on pin setup screen
	@Test (groups = {"DMPM-19", "DMPM-315", "marketplace", "pin", "priority-medium"})
	public void testCloseOptionOnPINSetupPage() {
		navigateToPINSetupPage();
		//Verifying cancel button on Enter PIN Setup Page
		pinSetupPage.tapCancelButton();
		Assert.assertNotNull(dummy.checkPinSetupOption(), "Cancel didnt close PIN Setup page");	
		
		// Verifying Cancel button on Reenter PIN Setup page
		dummy.tapPinSetupOption();
		enterPIN(utils.readTestData("pinEntries", "validPINEntry1"));
		Assert.assertNotNull(pinSetupPage.checkReEnterPINLabel(), "Reenter PIN Page - is not shown");
		pinSetupPage.tapCancelButton();
		Assert.assertNotNull(dummy.checkPinSetupOption(), "Cancel didnt close Reenetr PIN Setup page");	
	}
	
	@Test (groups = {"DMPM-52", "DMPM-1143", "DMPM-1146", "DMPM-1148", "marketplace", "pin", "priority-minor"})
	public void testPinAuthenticationOptions() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("hasNoProducts", "login"), 
				utils.readTestData("hasNoProducts", "pwd"));
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkSettingsMenuItem(), "Settings title not seen");
		navigationMenu.tapSettingsMenuItem();
		Assert.assertNotNull(settingsPage.checkSettingsTitle(), "Settings title not seen");
		Assert.assertNotNull(settingsPage.checkEnablePinToggle(), "Enable pin toggle button not present");
		if(settingsPage.isToggleEnabled()) {
			settingsPage.tapEnablePinToggle();
			Assert.assertFalse(settingsPage.isToggleEnabled(), "Toggle button did not get disabled");
		}else {
			settingsPage.tapEnablePinToggle();
			Assert.assertNotNull(pinSetupPage.checkEnterPINLabel(), "Pin setup screen not displayed");
		}
	}
	
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
		Assert.assertNotNull(loginPage.checkEnablePinButton(),"Pin setup button is not displayed");
		Assert.assertNotNull(loginPage.checkMaybeLaterButton(),"Maybe later button is not displayed");
		loginPage.tapEnablePinButton();
		Assert.assertNotNull(pinSetupPage.checkEnterPINLabel(),"Pin setup screen is not displayed");
		pinSetupPage.tapCancelButton();
		Assert.assertNotNull(landingPage.checkVehiclesTab(),"Landing page not loaded");
		
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkSettingsMenuItem(), "Settings title not seen");
		navigationMenu.tapSettingsMenuItem();
		if(!settingsPage.isToggleEnabled()) {
			settingsPage.tapEnablePinToggle();
		}
		pinSetupPage.tapCancelButton();
		Assert.assertNotNull(settingsPage.checkSettingsTitle(), "Settings title not seen");
		Assert.assertFalse(settingsPage.isToggleEnabled(), "Toggle button did not get disabled");
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
		Assert.assertNotNull(loginPage.checkEnablePinButton(),"Pin setup button is not displayed");
		Assert.assertNotNull(loginPage.checkMaybeLaterButton(),"Maybe later button is not displayed");
		loginPage.tapMaybeLater();
		Assert.assertNotNull(landingPage.checkVehiclesTab(),"Landing page not loaded");
	}
	
	@Test (groups = {"DMPM-58", "DMPM-2286","DMPM-2292", "marketplace", "pin", "priority-minor"})
	public void testLoginUsingPin() {
		navigateToReauthScreen();
		Assert.assertNotNull(loginReauthPage.checkReloginButton(),"Login button not present");
		loginReauthPage.tapReloginButton();
		Assert.assertNotNull(pinSetupPage.checkPinField(), "Pin field - is not shown");
		Assert.assertNotNull(pinSetupPage.checkCancelButton(), "Pin field - is not shown");
		enterPIN(utils.readTestData("hasPin", "pin"));
		Assert.assertNotNull(landingPage.checkVehiclesTab(), "Landing page - is not shown");
	}
	
	@Test (groups = {"DMPM-58", "DMPM-2304", "marketplace", "pin", "priority-minor"})
	public void cancelReauthUsingPin() {
		navigateToReauthScreen();
		Assert.assertNotNull(loginReauthPage.checkReloginButton(),"Login button not present");
		loginReauthPage.tapReloginButton();
		Assert.assertNotNull(pinAuthPage.checkCancelButton(), "Pin field - is not shown");
		pinSetupPage.tapCancelButton();
		Assert.assertNotNull(loginReauthPage.checkReloginButton(),"Did not navigate back to reauth page");
	}
	
	@Test (groups = {"DMPM-1993", "DMPM-2622", "marketplace", "pin", "priority-minor"})
	public void cancelPinSetupFromPasswordReauthentication() {
		navigateToReauthScreen();
		loginReauthPage.tapReloginButton();
		pinAuthPage.tapForgottenPINButton();
		pinReAuthPasswordPage.enterPassword(utils.readTestData("hasPin", "pwd"));
		pinReAuthPasswordPage.tapNextButton();
		Assert.assertNotNull(pinSetupPage.checkCancelButton(), "Pin field - is not shown");
		pinSetupPage.tapCancelButton();
		Assert.assertNotNull(landingPage.checkVehiclesTab(), "Landing page - is not shown");
		
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkSettingsMenuItem(), "Settings menu item is not shown");
		navigationMenu.tapSettingsMenuItem();
		if(!settingsPage.isToggleEnabled()) {
			settingsPage.tapEnablePinToggle();
		}
		pinAuthPage.tapForgottenPINButton();
		pinReAuthPasswordPage.enterPassword(utils.readTestData("hasPin", "pwd"));
		pinReAuthPasswordPage.tapNextButton();
		Assert.assertNotNull(pinSetupPage.checkCancelButton(), "Pin field - is not shown");
		pinSetupPage.tapCancelButton();
		Assert.assertNotNull(settingsPage.checkEnablePinToggle(), "Settings page not loaded");
		
		settingsPage.tapChangePin();
		pinAuthPage.tapForgottenPINButton();
		pinReAuthPasswordPage.enterPassword(utils.readTestData("hasPin", "pwd"));
		pinReAuthPasswordPage.tapNextButton();
		Assert.assertNotNull(pinSetupPage.checkCancelButton(), "Pin field - is not shown");
		pinSetupPage.tapCancelButton();
		Assert.assertNotNull(settingsPage.checkEnablePinToggle(), "Settings page not loaded");
	}
	
	private void navigateToReauthScreen() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("hasPin", "login"), 
				utils.readTestData("hasPin", "pwd"));
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkSettingsMenuItem(), "Settings menu item is not shown");
		navigationMenu.tapSettingsMenuItem();
		if(!settingsPage.isToggleEnabled()) {
			settingsPage.tapEnablePinToggle();
		}
	
		enterPIN(utils.readTestData("hasPin", "pin"));
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkLockMenuOption(), "Settings menu item is not shown");
		navigationMenu.tapLockMenuOption();
		
	}
	
	private void enterPIN(String pin) {
		for(char pinDigit : pin.toCharArray()) {
			pinCustomKeypad.tapPINEntry(pinDigit);
		}
	}
	
	private void navigateToPINSetupPage() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("hasNoProducts", "login"), 
				utils.readTestData("hasNoProducts", "pwd"));
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkSettingsMenuItem(), "Settings title not seen");
		navigationMenu.tapSettingsMenuItem();
		if(!settingsPage.isToggleEnabled()) {
			settingsPage.tapEnablePinToggle();
		}
	}
	
}
