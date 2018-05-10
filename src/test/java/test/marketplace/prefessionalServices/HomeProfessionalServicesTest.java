package test.marketplace.prefessionalServices;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import automation.framework.common.TestDetails.Priority;
import pages.App;

public class HomeProfessionalServicesTest extends App{

	//4170 - Scenario 1 (TC-DMPM-4702),Scenario 2 (TC-DMPM-4703),Scenario 3 (TC-DMPM-4704),
	//4416 - Scenario 2 (TC-DMPM-4707)
	// navigating to home Professional Services screen
	@Test (groups = {"DMPM-4170","DMPM-4702", "DMPM-4703", "DMPM-4704","DMPM-4416","DMPM-4707", "marketplace", "Home buying journey", "priority-minor"})
	public void testNavigatingToProfessionalServicesScreen() {
		navigateToProfessionalServices();
		homeServicesPage.tapProfessionalServicesIntroCloseButton();
		Assert.assertNotNull(homeServicesPage.checkHomeServicesTitle(), "home Services Page - Home Services subtitle is not present");
		Assert.assertEquals(homeServicesPage.getHomeServicesTitle(), utils.readTestData("copy", "professionalServices","homeServicesHeading"), "home Services Page - Home Services Description text is different to the expected text");
	
		Assert.assertNotNull(homeServicesPage.checkHomeServicesDescription(), "home Services Page - Home Services description is not present");
		Assert.assertEquals(homeServicesPage.getHomeServicesDescription(), utils.readTestData("copy", "professionalServices","homeServicesDescription"), "home Services Page - Home Services Description text is different to the expected text");
		Assert.assertNotNull(homeServicesPage.checkChooseServiceLabel(), "home Services Page - Home Services label is not present");
		Assert.assertEquals(homeServicesPage.getChooseServiceLabel(), utils.readTestData("copy", "professionalServices","chooseServiceLabel"), "home Services Page - Home Services title description text is different to the expected text");
		Assert.assertNotNull(homeServicesPage.checkHomeServicesImage(), "home Services Page - Home Services image is not present");
		Assert.assertNotNull(homeServicesPage.checkChatBotButton(), "home Services Page - Home Services chat bot button is not present");
		Assert.assertNotNull(homeServicesPage.checkViewServicesButton(), "home Services Page - View services button is not present");

		homeServicesPage.tapViewServicesButton();			
		Assert.assertNotNull(webviewPage.checkWebviewBrowserUrl(), "home Services Page - View services button is not present");
		Assert.assertEquals(webviewPage.getWebviewBrowserUrl(), Copy.HOME_PROFESSIONAL_SERVICES_URL, "home Services Page - View Services web view URL is different to the expected URL");
				
		webviewPage.tapWebviewChromeCloseButton();
		Assert.assertNotNull(homeServicesPage.checkProfessionalServicesPageTitle(), "home Services Page - home Services Page title is not present");
		
	}
	
	@TestDetails(story1 = "DMPM-4416:DMPM-4706,DMPM-4707,DMPM-4708", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Home buying journey", "priority-minor" })
	public void testProfessionalServicesIntroScreen() {
		navigateToProfessionalServices();
		Assert.assertNotNull(homeServicesPage.checkProfessionalServicesIntroCloseButton(), "Home Professtional services page - intro close button is not present");
		Assert.assertNotNull(homeServicesPage.checkProfessionalServicesIntroImage(), "Home Professtional services page - intro image is not present");
		Assert.assertNotNull(homeServicesPage.checkProfessionalServicesIntroDesc(), "Home Professtional services page - intro description is not present");
		Assert.assertNotNull(homeServicesPage.checkProfessionalServicesIntroGotItButton(), "Home Professtional services page - intro GOT IT button is not present");
		
		Assert.assertEquals(homeServicesPage.getProfessionalServicesIntroTitle(), Copy.HOME_PROFESSIONAL_SERVICES_INTRO_TITLE,"Home Professtional services intro pop up -Title is not matching");
		Assert.assertEquals(homeServicesPage.getProfessionalServicesIntroDesc(), Copy.HOME_PROFESSIONAL_SERVICES_INTRO_DESCRIPTION,"Home Professtional services intro pop up -description is not matching");
		
		homeServicesPage.tapProfessionalServicesIntroGotItButton();
		Assert.assertNotNull(homeServicesPage.checkHomeServicesTitle(), "Home Professtional services page - Title is not present");
		
		homeServicesPage.tapViewServicesButton();			
		Assert.assertNotNull(webviewPage.checkWebviewBrowserUrl(), "home Services Page - View services button is not present");
		Assert.assertEquals(webviewPage.getWebviewBrowserUrl(),Copy.HOME_PROFESSIONAL_SERVICES_URL, "home Services Page - View Services web view URL is different to the expected URL");
		
		
	}

	private void navigateToProfessionalServices() {
		loginToApp(utils.readTestData("loginCredentials","validLoginCredentials","login"), utils.readTestData("loginCredentials","validLoginCredentials","pwd"));
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkProffessionalServicesMenuItem(), "Navigation Menu - home Servicesmenu item is not present");
		navigationMenu.tapProffessionalServicesMenuItem();
		Assert.assertNotNull(homeServicesPage.getProfessionalServicesIntroTitle(), "home Services Page - home Services Page title is not present");
		//TODO make sure to close the intro popup by device back button in atleast 1 test method (DMPM-4707)
			
	}
			
		
}
