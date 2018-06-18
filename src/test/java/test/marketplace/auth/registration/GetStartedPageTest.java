package test.marketplace.auth.registration;

import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class GetStartedPageTest extends App{

	String titleValue;
	
	private void navigateToWelcomeToSuncorpPage() {
		if(loginAuthPage.checkChangeAccountButton() != null) {
			loginAuthPage.tapChangeAccountButton();
		}
		
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome Screen - User is not navigated to the welcome screen");;
		welcomePage.tapRegisterButton();
		Assert.assertNotNull(getStartedPage.checkGetStartedPageTitle(), "Get Started Page - User is not navigated to the get started screen");
	}

	//DMPM-1420 - Scenario 1, 2, 3
	@Test(groups = {"DMPM-1420", "DMPM-2656", "DMPM-2658", "DMPM-2659", "marketplace", "Registration", "priority-medium"})
	public void testRegisterPageElements() {
		navigateToWelcomeToSuncorpPage();
		Assert.assertNotNull(getStartedPage.checkGetStartedPageTitle(), "Welcome to Suncorp family - Welcome title not displayed");
		titleValue = getStartedPage.getGetStartedPageTitleValue().replace("\n", " ");
		Assert.assertEquals(titleValue, utils.readTestData("copy", "getStartedPage", "getStartedPageTitle") ,"Welcome to Suncorp family - Welcome title not correct");
		Assert.assertNotNull(getStartedPage.checkGetStartedPageSubheader(), "Welcome to Suncorp family - Welcome page subheader not displayed");
		Assert.assertNotNull(getStartedPage.checkBrandSelectDropDown(), "Welcome to Suncorp family - Select brand drop down is not displayed");

		List brandElements = utils.readTestDataList("brands");
		for(Object brandIcons : brandElements) {
			HashMap<String, String> brandIcon = (HashMap<String, String>)brandIcons;
			getStartedPage.tapBrandSelectDropDown();
			Assert.assertNotNull(getStartedPage.checkSelectBrandAlert(), "Select Brand List - The alert is not displayed");
			Assert.assertNotNull(getStartedPage.checkBrandExists(brandIcon.get("brandName")), "Select Brand List - "+brandIcon.get("brandName")+" not displayed");
			getStartedPage.dismissDropDownList();
		}
		
		//Check if suncorp brand login option is shown
		getStartedPage.tapBrandSelectDropDown();
		Assert.assertNotNull(getStartedPage.checkSelectBrandAlert(), "Select Brand List - The alert is not displayed");
		Assert.assertNotNull(getStartedPage.checkSuncorpBrandExists(), "Select Brand List - Suncorp brand is not displayed");
		getStartedPage.dismissDropDownList();

		Assert.assertNotNull(getStartedPage.checkNextButton(), "Welcome to Suncorp family - Next button is not displyed");
		Assert.assertNotNull(getStartedPage.checkSetupNewAccountButton(), "Welcome to Suncorp family - Set Up New Account button not displayed");
		getStartedPage.tapSetupNewAccount();
		if(termsAndConditionsPage.checkTermsAndConditionsTitle() != null){
			termsAndConditionsPage.tapAcceptButton();
		}
		Assert.assertNotNull(registrationPage.checkRegistrationPageTitle(), "Registration Page - User is not navigted to the Registration page");
		registrationPage.tapCancelButton();
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome Screen - User not navigated to the Welcome screen");
		welcomePage.tapRegisterButton();
		Assert.assertNotNull(getStartedPage.checkGetStartedPageTitle(), "Get Started Page - User is not navigated to the Get Started Screen");
		getStartedPage.tapBackButton();
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - User is not navigated back to the Welcome Screen");
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
			if(welcomePage.checkWelcomeSuncorpImage() != null) {
				navigateToWelcomeToSuncorpPage();
			}
			commonMemberLoginCheck(brandIcons);
		}

		navigateToWelcomeToSuncorpPage();
		// Testing navigation to Suncorp login page
		getStartedPage.tapBrandSelectDropDown();
		Assert.assertNotNull(getStartedPage.checkSelectBrandAlert(), "Select Brand List - The alert is not displayed");
		Assert.assertNotNull(getStartedPage.checkSuncorpBrandExists(), "Select Brand List - Suncorp brand is not displayed");
		getStartedPage.tapSuncorpBrand();
		getStartedPage.tapNextButton();
		
		// Verify accounts options sheet and elements
		Assert.assertNotNull(getStartedPage.checkSuncorpAccountOptionsSheet(), "Welcome to Suncorp family - Suncorp accounts sheets not displayed");
		Assert.assertNotNull(getStartedPage.checkSuncorpAccountOptionsHeading(), "Welcome to Suncorp family - Suncorp accounts sheets heading not displayed");
		Assert.assertNotNull(getStartedPage.checkSuncorpBanking(), "Welcome to Suncorp family - Suncorp banking option not displayed");
		Assert.assertNotNull(getStartedPage.checkSuncorpInsurance(), "Welcome to Suncorp family - Suncorp insurance option not displayed");
		Assert.assertNotNull(getStartedPage.checkSuncorpBothOption(), "Welcome to Suncorp family - Suncorp both option not displayed");

		//Check Suncorp Banking button
		getStartedPage.tapSuncorpBankingButton();
		if(termsAndConditionsPage.checkAcceptButton() != null){
			termsAndConditionsPage.tapAcceptButton();
		}
		
		Assert.assertNotNull(memberLoginPage.checkSuncorpBankLoginTitle(), "Suncorp bank Login - User is not naviagetd to the Suncorp bank Login page");
		memberLoginPage.tapSuncorpBankLoginBackButton();
		Assert.assertNotNull(getStartedPage.checkGetStartedPageTitle(), "Get Started -  User is not navigated back to the Get Started page");

		//Check Suncorp Insurance button
		getStartedPage.tapBrandSelectDropDown();
		Assert.assertNotNull(getStartedPage.checkSelectBrandAlert(), "Select Brand List - The alert is not displayed");
		Assert.assertNotNull(getStartedPage.checkSuncorpBrandExists(), "Select Brand List - Suncorp brand is not displayed");
		getStartedPage.tapSuncorpBrand();
		getStartedPage.tapNextButton();
		
		getStartedPage.tapSuncorpInsuranceButton();
		if(termsAndConditionsPage.checkAcceptButton() != null){
			termsAndConditionsPage.tapAcceptButton();
		}
		Assert.assertNotNull(loginPage.checkLoginPageTitle(), "Login Page - User is not navigated to the Login Page");
		loginPage.tapBackButton();
		Assert.assertNotNull(termsAndConditionsPage.checkTermsAndConditionsTitle(), "Terms and Conditions - User is not back on Terms and Conditions page");
		termsAndConditionsPage.tapDeviceBackButton();
		Assert.assertNotNull(getStartedPage.checkGetStartedPageTitle(), "Get Started -  User is not navigated back to the Get Started page");
		
		//Check Suncorp Both button
		getStartedPage.tapBrandSelectDropDown();
		Assert.assertNotNull(getStartedPage.checkSelectBrandAlert(), "Select Brand List - The alert is not displayed");
		Assert.assertNotNull(getStartedPage.checkSuncorpBrandExists(), "Select Brand List - Suncorp brand is not displayed");
		getStartedPage.tapSuncorpBrand();
		getStartedPage.tapNextButton();	
		
		getStartedPage.tapSuncorpBothButton();
		//	TODO: Add suitable transition state needed
		//	Assert.assertNotNull(loginPage.checkLoginPageTitle(), "");
	}

	private void commonMemberLoginCheck(Object brandIcons) {
		HashMap<String, String> brandIcon = (HashMap<String, String>)brandIcons;
		getStartedPage.tapBrandSelectDropDown();
		Assert.assertNotNull(getStartedPage.checkSelectBrandAlert(), "Select Brand List - The alert is not displayed");
		Assert.assertNotNull(getStartedPage.checkBrandExists(brandIcon.get("brandName")), "Select Brand List - "+brandIcon.get("brandName")+" not displayed");
		getStartedPage.tapBrandFromList(brandIcon.get("brandName"));
		getStartedPage.tapNextButton();
		
		if(termsAndConditionsPage.checkTermsAndConditionsTitle() != null){
			termsAndConditionsPage.tapAcceptButton();
		}
		Assert.assertEquals(memberLoginPage.getPageTitle(), brandIcon.get("brandIcon"), "Member Login Page - Title is not correct");
		memberLoginPage.tapCancelButton();
	}
}
