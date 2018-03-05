package test.marketplace.auth.pin;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.App;

public class PINOptionsTest extends App{
	
	// 52 - Scenario 5
	// 439 - Scenario 1
	@Test (groups = {"DMPM-439", "DMPM-52", "DMPM-2581", "DMPM-2583", "DMPM-1154", "marketplace", "pin", "priority-minor"})
	public void testElementsOnPinOptionsPage() {
		navigationToPinOptionsPageFromRegisration();
		Assert.assertNotNull(pinOptionsPage.checkEnablePinButton(),"Pin setup button is not displayed");
		Assert.assertNotNull(pinOptionsPage.checkMaybeLaterButton(),"Maybe later button is not displayed");
		Assert.assertNotNull(pinOptionsPage.checkPinPromptImage(),"Maybe later button is not displayed");
		Assert.assertNotNull(pinOptionsPage.checkPinPromptUserWelcome(),"Maybe later button is not displayed");
		Assert.assertNotNull(pinOptionsPage.checkPinPromptDescription(),"Maybe later button is not displayed");
		pinOptionsPage.tapEnablePinButton();
		Assert.assertNotNull(pinSetupPage.checkEnterPINLabel(),"Pin setup screen is not displayed");
		pinSetupPage.tapCancelButton();
		Assert.assertNotNull(landingPage.checkVehiclesTab(),"Landing page not loaded");
	}
	
	// 439 - scenario 3
	@Test (groups = {"DMPM-439", "DMPM-2583", "marketplace", "pin", "priority-minor"})
	public void testPinMaybeLaterOptionFromLogin() {
		navigationToPinOptionsPageFrom_LoginWithoutPIn();
		Assert.assertNotNull(pinOptionsPage.checkMaybeLaterButton(),"Maybe later button is not displayed");
		pinOptionsPage.tapMaybeLater();
		Assert.assertNotNull(landingPage.checkVehiclesTab(),"Landing page not loaded");
	}
	
	// 439 - Scenario 2
	@Test (groups = {"DMPM-439",  "DMPM-2582", "marketplace", "pin", "priority-minor"})
	public void testPinAuthFrom_LoginWithPin() {
		navigationToPinOptionsPageFrom_LoginWithPIn();
		pinOptionsPage.tapEnablePinButton();
		Assert.assertNotNull(pinAuthPage.checkPinField(),"Pin Auth screen is not displayed");
		pinAuthPage.tapBackButton();
		Assert.assertNotNull(landingPage.checkVehiclesTab(),"Landing page not loaded");
	}
	
	// 439 - Scenario 2
	@Test (groups = {"DMPM-439","DMPM-2582", "marketplace", "pin", "priority-minor"})
	public void testPinAuthFrom_LoginWithoutPin() {
		navigationToPinOptionsPageFrom_LoginWithoutPIn();
		pinOptionsPage.tapEnablePinButton();
		Assert.assertNotNull(pinSetupPage.checkEnterPINLabel(), "PIN Setup Page - Enter 4 digit pin message not shown");
		pinSetupPage.tapCancelButton();
		Assert.assertNotNull(landingPage.checkVehiclesTab(),"Landing page not loaded");
	}
	
	
	private void navigationToPinOptionsPageFromRegisration() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		Assert.assertNotNull(welcomePage.checkRegisterButton(), "Welcome screen - Register button is not shown");
		welcomePage.tapRegisterButton();
		if(getStartedPage.checkSetupNewAccountButton() != null) {
			getStartedPage.tapSetupNewAccount();
		}
		registrationPage.fillRegistrationScreens(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"),
				utils.readTestData("registration", "success", "postcode"),
				utils.readTestData("registration", "success", "email"),
				utils.readTestData("registration", "success", "mobile"),
				utils.readTestData("registration", "success", "password"));
	}
	
	private void navigationToPinOptionsPageFrom_LoginWithoutPIn() {
		loginToApp(utils.readTestData("PIN", "loginWithoutExistingPin", "login"), 
				utils.readTestData("PIN", "loginWithoutExistingPin", "pwd"), "DoNotTapMayBeLaterOption");
	}
	
	private void navigationToPinOptionsPageFrom_LoginWithPIn() {
		loginToApp(utils.readTestData("PIN", "loginWithExistingPin", "login"), 
				utils.readTestData("PIN", "loginWithExistingPin", "pwd"), "DoNotTapMayBeLaterOption");
	}

}
