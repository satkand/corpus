package test.marketplace.auth.registration;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class GetStartedPageTest extends App{

	private void navigateToWelcomeToSuncorpPage() {
		welcomePage.checkWelcomeSuncorpImage();
		welcomePage.tapRegisterButton();
		getStartedPage.checkGetStartedPageTitle();
	}

	//DMPM-1420 - Scenario 1, 2, 3
	@Test(groups = {"DMPM-1420", "DMPM-2656", "DMPM-2658", "DMPM-2659", "marketplace", "Registration", "priority-medium"})
	public void testRegisterPageElements() {
		navigateToWelcomeToSuncorpPage();
		Assert.assertNotNull(getStartedPage.checkGetStartedPageTitle(), "Welcome to Suncorp family - Welcome title not displayed");
		Assert.assertNotNull(getStartedPage.checkGetStartedPageSubheader(), "Welcome to Suncorp family - Welcome page subheader not displayed");
		Assert.assertNotNull(getStartedPage.checkSuncorpBrandIcon(), "Welcome to Suncorp family - Suncorp brand icon not displayed");
		Assert.assertNotNull(getStartedPage.checkAamiBrandIcon(), "Welcome to Suncorp family - AAMI brand icon not displayed");
		Assert.assertNotNull(getStartedPage.checkApiaBrandIcon(), "Welcome to Suncorp family - APIA brand icon not displayed");
		Assert.assertNotNull(getStartedPage.checkGioBrandIcon(), "Welcome to Suncorp family - GIO brand icon not displayed");
		Assert.assertNotNull(getStartedPage.checkShannonsBrandIcon(), "Welcome to Suncorp family - Shannons brand icon not displayed");
		Assert.assertNotNull(getStartedPage.checkNewAccountText(), "Welcome to Suncorp family - New account text not displayed");
		Assert.assertNotNull(getStartedPage.checkSetupNewAccountButton(), "Welcome to Suncorp family - Set Up New Account button not displayed");

		getStartedPage.tapBackButton();
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen -Suncorp image is not shown");
	}

	//DMPM-1420 - Scenario 4, 5, 6
	//DMPM-2914 - Scenario 1, 2
	//DMPM-2632 - Scenario 1
	@Test(groups = {"DMPM-1420", "DMPM-2914", "DMPM-2660", "DMPM-2661", "DMPM-2662", "DMPM-3507", "DMPM-3508", "marketplace", "Registration", "priority-high"})
	public void testSupportedBrandCredentials() {
		// Checking Scenario 1 from DMPM-2632
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome Page - User is not navigated to the welcome page");
		welcomePage.tapLoginButton();
		Assert.assertNotNull(loginPage.checkLoginPageTitle(), "Login Page - User is not navigated to the login page");
		loginPage.tapBackButton();
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome Page - User is not navigated back to the welcome page");
		
		navigateToWelcomeToSuncorpPage();
		Assert.assertNotNull(getStartedPage.checkGetStartedPageTitle(), "Welcome to Suncorp family - Welcome title not displayed");

		// Testing navigation to AAMI, APIA, GIO and Shannons login pages
		List brandElements = utils.readTestDataList("brands");
		for(Object brandIcons : brandElements) {
			commonMemberLoginCheck(brandIcons);
		}

		// Testing navigation to Suncorp login page
		getStartedPage.tapSuncorpBrandIcon();
		// Verify accounts options sheet and elements
		Assert.assertNotNull(getStartedPage.checkSuncorpAccountOptionsSheet(), "Welcome to Suncorp family - Suncorp accounts sheets not displayed");
		Assert.assertNotNull(getStartedPage.checkSuncorpAccountOptionsHeading(), "Welcome to Suncorp family - Suncorp accounts sheets heading not displayed");
		Assert.assertNotNull(getStartedPage.checkSuncorpBanking(), "Welcome to Suncorp family - Suncorp banking option not displayed");
		Assert.assertNotNull(getStartedPage.checkSuncorpInsurance(), "Welcome to Suncorp family - Suncorp insurance option not displayed");
		Assert.assertNotNull(getStartedPage.checkSuncorpBothOption(), "Welcome to Suncorp family - Suncorp both option not displayed");

		if(getStartedPage.checkSuncorpAccountOptionsSheet() == null) {
			getStartedPage.tapSuncorpBrandIcon();
		}
		getStartedPage.tapSuncorpBankingButton();
		//		TODO: Add suitable transition state needed
		//		Assert.assertNotNull(loginPage.checkLoginPageTitle(), "");

		if(getStartedPage.checkSuncorpAccountOptionsSheet() == null) {
			getStartedPage.tapSuncorpBrandIcon();	
		}
		getStartedPage.tapSuncorpInsuranceButton();
		Assert.assertNotNull(loginPage.checkLoginPageTitle(), "Login Page - User is not navigated to the Login Page");
		loginPage.tapBackButton();
		Assert.assertNotNull(getStartedPage.checkGetStartedPageTitle(), "Get Started -  User is not navigated back to the Get Started page");

		if(getStartedPage.checkSuncorpAccountOptionsSheet() == null) {
			getStartedPage.tapSuncorpBrandIcon();	
		}
		getStartedPage.tapSuncorpBothButton();
		//		TODO: Add suitable transition state needed
		//		Assert.assertNotNull(loginPage.checkLoginPageTitle(), "");
	}

	private void commonMemberLoginCheck(Object brandIcons) {
		HashMap<String, String> brandIcon = (HashMap<String, String>)brandIcons;
		getStartedPage.checkMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));
		getStartedPage.tapMemberBrandIcon(brandIcon.get("button"), utils.readTestData("bundleId", "value"));
		Assert.assertEquals(memberLoginPage.getPageTitle(), brandIcon.get("brandIcon"));
		memberLoginPage.tapCancelButton();
	}
}
