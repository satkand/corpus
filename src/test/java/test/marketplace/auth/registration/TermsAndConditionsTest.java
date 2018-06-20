package test.marketplace.auth.registration;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import pages.App;

public class TermsAndConditionsPage extends App {
	String titleValue;
	
	
	
	
	//@Test(groups = {"DMPM-845", "DMPM-1315","DMPM-354","DMPM-493","marketplace", "Registration", "priority-minor"})
	@TestDetails(story1 = "DMPM-7121:DMPM-7245")
	@Test(groups = { "marketplace", "TC", "priority-Critical" })
	public void testRegistration_Dismiss_button() {
		
		
			/*Assert.assertNotNull(getStartedPage.checkGetStartedPageTitle(), "Welcome to Suncorp family - Welcome title not displayed");
			titleValue = getStartedPage.getGetStartedPageTitleValue().replace("\n", " ");
			//Assert.assertEquals(titleValue, utils.readTestData("copy", "getStartedPage", "getStartedPageTitle") ,"Welcome to Suncorp family - Welcome title not correct");
			Assert.assertEquals(titleValue, Copy.getStartedPageTitle ,"Welcome to Suncorp family - Welcome title not correct");
			*/

			
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
			
			
			/*List brandElements = utils.readTestDataList("brands");
			for(Object brandIcons : brandElements) {
				HashMap<String, String> brandIcon = (HashMap<String, String>)brandIcons;
				getStartedPage.tapBrandSelectDropDown();
				System.out.println(getStartedPage.checkSelectBrandAlert());
				System.out.println(getStartedPage.checkBrandExists(brandIcon.get("brandName")));
				Assert.assertNotNull(getStartedPage.checkSelectBrandAlert(), "Select Brand List - The alert is not displayed");
				Assert.assertNotNull(getStartedPage.checkBrandExists(brandIcon.get("brandName")), "Select Brand List - "+brandIcon.get("brandName")+" not displayed");
				getStartedPage.dismissDropDownList();
				getStartedPage.tapNextButton();
			}*/


		//Assert.assertNotNull(loginPage.checkLoginPageTitle(), "Login screen - page title is not shown");
		//welcomeSuncorpImage
		

	}
	
	private void navigateToWelcomeToSuncorpPage() {
		if(loginAuthPage.checkChangeAccountButton() != null) {
			loginAuthPage.tapChangeAccountButton();
		}
		
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome Screen - User is not navigated to the welcome screen");;
		welcomePage.tapRegisterButton();
		Assert.assertNotNull(getStartedPage.checkGetStartedPageTitle(), "Get Started Page - User is not navigated to the get started screen");
	}
	
	private void commonMemberLoginCheck(Object brandIcons) {
		HashMap<String, String> brandIcon = (HashMap<String, String>)brandIcons;
		getStartedPage.tapBrandSelectDropDown();
		Assert.assertNotNull(getStartedPage.checkSelectBrandAlert(), "Select Brand List - The alert is not displayed");
		Assert.assertNotNull(getStartedPage.checkBrandExists(brandIcon.get("brandName")), "Select Brand List - "+brandIcon.get("brandName")+" not displayed");
		getStartedPage.tapBrandFromList(brandIcon.get("brandName"));
		getStartedPage.tapNextButton();
//		System.out.println(termsAndConditionsPage.checkTermsAndConditionsTitle());
		if(termsAndConditionsPage.checkAcceptButton() != null){
			//termsAndConditionsPage.tapAcceptButton();
			termsAndConditionsPage.tapCancelButton();
		}
		//System.out.println(memberLoginPage.getPageTitle());
		//Assert.assertEquals(memberLoginPage.getPageTitle(), brandIcon.get("brandIcon"), "Member Login Page - Title is not correct");
		//memberLoginPage.tapCancelButton(); 
	}
	
}
