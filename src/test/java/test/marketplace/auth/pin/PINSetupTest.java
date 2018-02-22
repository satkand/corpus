package test.marketplace.auth.pin;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

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
	
	private void navigateToPINSetupPage() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("PIN", "loginWithoutExistingPin", "login"), 
				utils.readTestData("PIN", "loginWithoutExistingPin", "pwd"));
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkSettingsMenuItem(), "Settings title not seen");
		navigationMenu.tapSettingsMenuItem();
		if(!settingsPage.isPinToggleEnabled()) {
			settingsPage.tapEnablePinToggle();
		}
		Assert.assertNotNull(pinSetupPage.checkEnterPINLabel(), "Did not navigate to pin setup screen");
	}
	
	private void enterPIN(String pin) {
		for(char pinDigit : pin.toCharArray()) {
			pinCustomKeypad.tapPINEntry(pinDigit);
		}
	}
}
