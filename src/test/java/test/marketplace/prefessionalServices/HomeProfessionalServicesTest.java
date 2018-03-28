package test.marketplace.prefessionalServices;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class HomeProfessionalServicesTest extends App{

	// 4170 - Scenario 1 (TC-DMPM-4702),Scenario 2 (TC-DMPM-4703),Scenario 3 (TC-DMPM-4704),
	// navigating to home Professional Services screen
	@Test (groups = {"DMPM-4170","DMPM-4702", "DMPM-4703", "DMPM-4704", "marketplace", "Home buying journey", "priority-minor"})
	public void testNavigatingToProfessionalServicesScreen() {
		navigateToProfessionalServices();
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
		Assert.assertNotNull(webviewPage.checkUrlBar(), "home Services Page - View services button is not present");
		Assert.assertEquals(webviewPage.getUrlBarText(), utils.readTestData("copy", "professionalServices","urlBarText"), "home Services Page - View Services web view URL is different to the expected URL");
				
		webviewPage.tapWebviewCloseButton();
		Assert.assertNotNull(homeServicesPage.checkProfessionalServicesPageTitle(), "home Services Page - home Services Page title is not present");
		
	}

	private void navigateToProfessionalServices() {
		loginToApp(utils.readTestData("loginCredentials","validLoginCredentials","login"), utils.readTestData("loginCredentials","validLoginCredentials","pwd"));
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkProffessionalServicesMenuItem(), "Navigation Menu - home Servicesmenu item is not present");
		navigationMenu.tapProffessionalServicesMenuItem();
		Assert.assertNotNull(homeServicesPage.checkProfessionalServicesPageTitle(), "home Services Page - home Services Page title is not present");
				
	}
			
		
}
