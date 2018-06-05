package test.marketplace.auth.pin;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.CustomRetryListener;
import pages.App;

public class PINOptionsTest extends App{
	
	// 52 - Scenario 5
	// 439 - Scenario 1
	@Test (retryAnalyzer = CustomRetryListener.class,groups = {"DMPM-439", "DMPM-52", "DMPM-2581", "DMPM-2583", "DMPM-1154", "marketplace", "pin", "priority-minor"})
	public void testElementsOnPinOptionsPage() {
		navigationToPinOptionsPageFromRegisration();
		Assert.assertNotNull(pinOptionsPage.checkEnablePinButton(),"Pin setup button is not displayed");
		Assert.assertNotNull(pinOptionsPage.checkMaybeLaterButton(),"Maybe later button is not displayed");
		Assert.assertNotNull(pinOptionsPage.checkPinPromptImage(),"Maybe later button is not displayed");
		Assert.assertNotNull(pinOptionsPage.checkPinPromptUserWelcome(),"Maybe later button is not displayed");
		Assert.assertNotNull(pinOptionsPage.checkPinPromptDescription(),"Maybe later button is not displayed");
		pinOptionsPage.tapEnablePinButton();
		if (enterCurrentPINPage.checkOkButton() != null) {

			enterCurrentPINPage.tapOkButton();
		}
		Assert.assertNotNull(pinSetupPage.checkEnterPINLabel(),"Pin setup screen is not displayed");
		pinSetupPage.tapCancelButton();
		Assert.assertNotNull(landingPage.checkLandingPageTitle(),"Landing page not loaded");
	}
/*	
	// 439 - scenario 3
	@Test (groups = {"DMPM-439", "DMPM-2583", "marketplace", "pin", "priority-minor"})
	public void testPinMaybeLaterOptionFromLogin() {
		navigationToPinOptionsPageFrom_LoginWithoutPIn();
		Assert.assertNotNull(pinOptionsPage.checkMaybeLaterButton(),"Maybe later button is not displayed");
		pinOptionsPage.tapMaybeLater();
		Assert.assertNotNull(landingPage.checkLandingPageTitle(),"Landing page not loaded");
	}
	
	// 439 - Scenario 2
	@Test (groups = {"DMPM-439",  "DMPM-2582", "marketplace", "pin", "priority-minor"})
	public void testPinAuthFrom_LoginWithPin() {
		navigationToPinOptionsPageFrom_LoginWithPIn();
		pinOptionsPage.tapEnablePinButton();
		Assert.assertNotNull(pinAuthPage.checkPinField(),"Pin Auth screen is not displayed");
		pinAuthPage.tapBackButton();
		Assert.assertNotNull(landingPage.checkLandingPageTitle(),"Landing page not loaded");
	}
	
	// 439 - Scenario 2
	@Test (groups = {"DMPM-439","DMPM-2582", "marketplace", "pin", "priority-minor"})
	public void testPinAuthFrom_LoginWithoutPin() {
		navigationToPinOptionsPageFrom_LoginWithoutPIn();
		pinOptionsPage.tapEnablePinButton();
		if (enterCurrentPINPage.checkOkButton() != null) {
		
						enterCurrentPINPage.tapOkButton();
				}
		Assert.assertNotNull(pinSetupPage.checkEnterPINLabel(), "PIN Setup Page - Enter 4 digit pin message not shown");
		pinSetupPage.tapCancelButton();
		Assert.assertNotNull(landingPage.checkLandingPageTitle(),"Landing page not loaded");
	}
	
	// DMPM-5071 Scenario 1
	@Test (groups = {"DMPM-5071", "marketplace", "pin", "priority-minor"})
	public void testPinOptionsPageImage() {
		navigateToPINOptionsPageFromWelcomeScreen();
		
		Assert.assertNotNull(pinOptionsPage.checkPinPromptImage(), "PIN Options Page - PIN prompt image is not displayed");
	}
	
	*/
	private void navigationToPinOptionsPageFromRegisration() {
		
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		
		Assert.assertNotNull(welcomePage.checkRegisterButton(), "Welcome screen - Register button is not shown");
		welcomePage.tapRegisterButton();
		
		if(getStartedPage.checkSetupNewAccountButton() != null) {
			getStartedPage.tapSetupNewAccount();
		}
		if(termsAndConditionsPage.checkAcceptButton() != null) {
			termsAndConditionsPage.tapAcceptButton();
		}
		registrationPage.fillRegistrationScreens(utils.readTestData("registration", "success", "firstName"),
				utils.readTestData("registration", "success", "surname"),
				utils.readTestData("registration", "success", "date"),
				utils.readTestData("registration", "success", "postcode"),
				utils.readTestData("registration", "success", "email"),
				utils.readTestData("registration", "success", "mobile"),
				utils.readTestData("registration", "success", "password"));
		pinOptionsPage.checkPinPromptUserWelcome();
	}
	
	private void navigationToPinOptionsPageFrom_LoginWithoutPIn() {
		loginToApp(utils.readTestData("PIN", "loginNoPin", "login"), 
				utils.readTestData("PIN", "loginNoPin", "pwd"), "DoNotTapMayBeLaterOption");
	}
	
	private void navigationToPinOptionsPageFrom_LoginWithPIn() {
		loginToApp(utils.readTestData("PIN", "loginWithExistingPin", "login"), 
				utils.readTestData("PIN", "loginWithExistingPin", "pwd"), "DoNotTapMayBeLaterOption");
	}
	
	private void navigateToPINOptionsPageFromWelcomeScreen() {
		if(loginAuthPage.checkChangeAccountButton() != null) {
			loginAuthPage.tapChangeAccountButton();
		}
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - Suncorp image is not shown");
		welcomePage.tapLoginButton();
		loginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validLoginCredentials", "login3"), utils.readTestData("loginCredentials", "validLoginCredentials", "pwd"));
		loginPage.tapLoginButton();
		if(termsAndConditionsPage.checkAcceptButton() != null) {
			termsAndConditionsPage.tapAcceptButton();
		}		Assert.assertNotNull(pinOptionsPage.checkMaybeLaterButton(), "PIN Options Page - User is not navigated to the PIN options page");
	}

}
