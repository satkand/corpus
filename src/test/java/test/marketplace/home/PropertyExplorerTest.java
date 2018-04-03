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
		Assert.assertNotNull(propertyExplorerPage.checkPropertyExplorerSearchbox(), "Property Hub Page - search box not present");
		
		propertyExplorerPage.enterTextInPropertyExplorerSearchbox(utils.readTestData("propertyDimension","propertyExplorer","enterAdress"));
		propertyExplorerPage.tapSearch();
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
		
		propertyExplorerPage.scrollToWhatsNearButton();
		Assert.assertNotNull(propertyExplorerPage.checkMiniMap(), "Property Hub Page - Mini Map not present");
		Assert.assertNotNull(propertyExplorerPage.checkMiniMapLocationPin(), "Property Hub Page - Mini Map location pin not present");
		Assert.assertNotNull(propertyExplorerPage.checkPropertyExplorerSearchbox(), "Property Hub Page - search box not present");
		
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","enterAdress"));
		propertyExplorerPage.tapSearch();
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
		
		propertyDetailsPage.scrollToWhatsNearButton();
		Assert.assertNotNull(propertyDetailsPage.checkMiniMap(), "Property Hub Page - Mini Map not present");
		Assert.assertNotNull(propertyDetailsPage.checkMiniMapLocationPin(), "Property Hub Page - Mini Map location pin not present");
		
	}
	
	public void navigateToPropertyExplorer() {
		loginToApp(utils.readTestData("propertyDimension","propertyProducts","withProducts", "login"), utils.readTestData("propertyDimension", "propertyProducts","withProducts","pwd"));
		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
		homePropertyPage.scrollToJourneyBanner();
		homePropertyPage.tapStartYourJourneyButton();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - page title not shown");
	
	}

}
