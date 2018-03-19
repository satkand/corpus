package test.marketplace.home;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class PropertyExplorerTest extends App{

	// DMPM-3110 - Scenario 1
	// navigating to Property Explorer and see the mini map
	@Test (groups = {"DMPM-3110", "DMPM-3868", "marketplace", "Home buying journey", "priority-minor"})
	public void testDisplayMiniMapOnPropertyDetailsScreen() {
		navigateToPropertyExplorer();
		Assert.assertNotNull(propertyHubPage.checkPropertyHubSearchbox(), "Property Hub Page - search box not present");
		
		propertyHubPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimention","propertyExplorer","enterAdress"));
		propertyHubPage.tapSearch();
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
		
		propertyHubPage.scrollToWhatsNewButton();
		Assert.assertNotNull(propertyHubPage.checkMiniMap(), "Property Hub Page - Mini Map not present");
		Assert.assertNotNull(propertyHubPage.checkMiniMapLocationPin(), "Property Hub Page - Mini Map location pin not present");
		
	}
	
	public void navigateToPropertyExplorer() {
		loginToApp(utils.readTestData("propertyDimention","propertyProducts","withProducts", "login"), utils.readTestData("propertyDimention", "propertyProducts","withProducts","pwd"));
		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
		homePropertyPage.scrollToJourneyBanner();
		homePropertyPage.tapStartYourJourneyButton();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - page title not shown");
	
	}

}
