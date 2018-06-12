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
	@TestDetails(story1 = "DMPM-4170:DMPM-4702,DMPM-4703,DMPM-4704", story2 = "DMPM-4416:DMPM-4707", priority = Priority.LOW)
	@Test (groups = {"marketplace", "Home buying journey", "priority-minor"})
	public void testNavigatingToProfessionalServicesScreen() {
		navigateToProfessionalServices();
		homeServicesPage.tapProfessionalServicesIntroCloseButton();
		Assert.assertNotNull(homeServicesPage.checkHomeServicesTitle(), "home Services Page - Home Services subtitle is not present");
		Assert.assertEquals(homeServicesPage.getHomeServicesTitle(), utils.readTestData("copy", "professionalServices","homeServicesHeading"), "home Services Page - Home Services Description text is different to the expected text");
	
		checkProfessionalServicesScreenElements();

		homeServicesPage.tapViewServicesButton();	
		verifyWebviewBrowserUrl();
		Assert.assertNotNull(homeServicesPage.checkProfessionalServicesPageTitle(), "home Services Page - home Services Page title is not present");
		
	}
	
	@TestDetails(story1 = "DMPM-4416:DMPM-4706,DMPM-4707,DMPM-4708", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Home buying journey", "priority-minor" })
	public void testProfessionalServicesIntroScreen() {
		navigateToProfessionalServices();
		
		checkProfessionalServicesIntroScreenElements();
		
		homeServicesPage.tapProfessionalServicesIntroGotItButton();
		Assert.assertNotNull(homeServicesPage.checkHomeServicesTitle(), "Home Professtional services page - Title is not present");
		
		homeServicesPage.tapViewServicesButton();			
		verifyWebviewBrowserUrl();
		
	}
	
	@TestDetails(story1 = "DMPM-6102:DMPM-7073,DMPM-4707", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Home buying journey", "priority-minor" })
	public void testProfessionalServicesUpdatedURL() {
		
		navigateToProfessionalServices();
		homeServicesPage.tapProfessionalServicesIntroGotItButton();
		Assert.assertNotNull(homeServicesPage.checkHomeServicesTitle(), "Home Professtional services page - Title is not present");
		
		homeServicesPage.tapViewServicesButton();
		verifyWebviewBrowserUrl();
		
		Assert.assertNotNull(homeServicesPage.checkProfessionalServicesPageTitle(), "home Services Page - home Services Page title is not present");
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.tapSuncorpMenuItem();
		
		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
		Assert.assertNotNull(homePropertyPage.checkaddressLineText(), "Home tab is not selected on landing page");
		
		homePropertyPage.scrollToJourneyBanner();
		homePropertyPage.tapStartYourJourneyButton();
		Assert.assertNotNull(homeJourneyPage.checkJourneyTitleText(), "home Journey Page - home Journey Page title is not present");
		
		homeJourneyPage.scrollToViewServiceVendorsButton();
		homeJourneyPage.tapViewServiceVendorsButton();
		
		verifyWebviewBrowserUrl();
		
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "home Journey Page - home Journey Page title is not present");
		
		homeJourneyPage.tapBackButton();
		homePropertyPage.scrollToJourneyBanner();
		homePropertyPage.tapStartYourJourneyButton();
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","highConfidenceAddress"));
		
		//propertyExplorerPage.tapSearch();
		propertyExplorerPage.checkFirstItemIntheSearchDropdown();
		propertyExplorerPage.tapFirstItemIntheSearchDropdown();
				
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
			
		propertyDetailsPage.scrollToProfessionaServicesButton();
		propertyDetailsPage.tapProfessionaServicesButton();
		
		if(webviewPage.checkWebviewBrowserUrl()!=null) {
			Assert.assertEquals(webviewPage.getWebviewBrowserUrl(),Copy.HOME_PROFESSIONAL_SERVICES_URL, "home Services Page - View Services web view URL is different to the expected URL");
			webviewPage.tapWebviewChromeCloseButton();
			
		}else if(webviewPage.checkUrlBar()!=null) {
			Assert.assertEquals(webviewPage.getTextUrlBar().replaceAll("[^a-zA-Z0-9]", "").toString(), Copy.LOCATION_BAR_TEXT_S5, "home Services Page - View Services web view URL is different to the expected URL");
			webviewPage.tapDeviceBackButton();
			
		}else {
			Assert.assertEquals(webviewPage.getWebViewLocationBar(),Copy.HOME_PROFESSIONAL_SERVICES_URL, "home Services Page - View Services web view URL is different to the expected URL");
			
		}
	}

	private void navigateToProfessionalServices() {
		loginToApp(utils.readTestData("loginCredentials","validLoginCredentials","login"), utils.readTestData("loginCredentials","validLoginCredentials","pwd"));
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkProffessionalServicesMenuItem(), "Navigation Menu - home Servicesmenu item is not present");
		navigationMenu.tapProffessionalServicesMenuItem();
		Assert.assertNotNull(homeServicesPage.getProfessionalServicesIntroTitle(), "home Services Page - home Services Page title is not present");
		//TODO make sure to close the intro popup by device back button in atleast 1 test method (DMPM-4707)
			
	}
			
	private void checkProfessionalServicesScreenElements() {
		Assert.assertNotNull(homeServicesPage.checkHomeServicesDescription(), "home Services Page - Home Services description is not present");
		Assert.assertEquals(homeServicesPage.getHomeServicesDescription(), utils.readTestData("copy", "professionalServices","homeServicesDescription"), "home Services Page - Home Services Description text is different to the expected text");
		Assert.assertNotNull(homeServicesPage.checkChooseServiceLabel(), "home Services Page - Home Services label is not present");
		Assert.assertEquals(homeServicesPage.getChooseServiceLabel(), utils.readTestData("copy", "professionalServices","chooseServiceLabel"), "home Services Page - Home Services title description text is different to the expected text");
		Assert.assertNotNull(homeServicesPage.checkHomeServicesImage(), "home Services Page - Home Services image is not present");
		Assert.assertNotNull(homeServicesPage.checkChatBotButton(), "home Services Page - Home Services chat bot button is not present");
		Assert.assertNotNull(homeServicesPage.checkViewServicesButton(), "home Services Page - View services button is not present");
	}
	
	private void checkProfessionalServicesIntroScreenElements()  {
		Assert.assertNotNull(homeServicesPage.checkProfessionalServicesIntroCloseButton(), "Home Professtional services page - intro close button is not present");
		Assert.assertNotNull(homeServicesPage.checkProfessionalServicesIntroImage(), "Home Professtional services page - intro image is not present");
		Assert.assertNotNull(homeServicesPage.checkProfessionalServicesIntroDesc(), "Home Professtional services page - intro description is not present");
		Assert.assertNotNull(homeServicesPage.checkProfessionalServicesIntroGotItButton(), "Home Professtional services page - intro GOT IT button is not present");
		Assert.assertEquals(homeServicesPage.getProfessionalServicesIntroTitle(), Copy.HOME_PROFESSIONAL_SERVICES_INTRO_TITLE,"Home Professtional services intro pop up -Title is not matching");
		Assert.assertEquals(homeServicesPage.getProfessionalServicesIntroDesc(), Copy.HOME_PROFESSIONAL_SERVICES_INTRO_DESCRIPTION,"Home Professtional services intro pop up -description is not matching");
		
	}
	
	private void verifyWebviewBrowserUrl() {
		if(webviewPage.checkWebviewBrowserUrl()!=null) {
			Assert.assertEquals(webviewPage.getWebviewBrowserUrl(), Copy.HOME_PROFESSIONAL_SERVICES_URL, "home Services Page - View Services web view URL is different to the expected URL");
			webviewPage.tapWebviewChromeCloseButton();
		}else if(webviewPage.checkUrlBar()!=null) {
			Assert.assertNotNull(webviewPage.checkUrlBar(), "Web View Page - Web View URL bar is not present");
			
			if(!(whatsNearbyPage.getDeviceModel().equalsIgnoreCase("SM-G900F"))) {
				webviewPage.tapWebViewToolbarOprions();
				Assert.assertNotNull(webviewPage.checkWebViewOpenInChromeButton(), "Home Journey Page - Home Journey page title is not shown");
				webviewPage.tapWebViewOpenInChromeButton();
				Assert.assertEquals(webviewPage.getTextUrlBar(), Copy.PROPERTY_HUB_HOME_PROFESSIONAL_SERVICES_URL,"Home professional services URL is not matching");
			}else {
				Assert.assertEquals(webviewPage.getTextUrlBar().replaceAll("[^a-zA-Z0-9]", "").toString(), Copy.LOCATION_BAR_TEXT_S5,"Home professional services URL is not matching");
			}
			webviewPage.tapDeviceBackButton();

		}else {
			Assert.assertEquals(webviewPage.getWebviewBrowserUrl(), Copy.HOME_PROFESSIONAL_SERVICES_URL, "home Services Page - View Services web view URL is different to the expected URL");
		}
		
	}
		
}
