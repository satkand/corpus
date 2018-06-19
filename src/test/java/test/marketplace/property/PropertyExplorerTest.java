package test.marketplace.property;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class PropertyExplorerTest extends App{

	// DMPM-3110 - Scenario 1
	//DMPM-969 - Scenario 1 (DMPM-4019), Scenario 2 (4020), Scenario 3 (4026), Scenario 4 (4030), Scenario 5 (4032), 
	// navigating to Property Explorer and see the mini map
	@Test (groups = {"DMPM-3110", "DMPM-3868","DMPM-969", "DMPM-4019", "DMPM-4020", "DMPM-4026","DMPM-4030","DMPM-4032", "marketplace", "Home buying journey", "priority-minor"})
	public void testDisplayMiniMapOnPropertyDetailsScreen() {
		navigateToPropertyExplorer();
		Assert.assertNotNull(propertyExplorerPage.checkPropertyExplorerSearchbox(), "Property Explorer Page - search box not present");
		Assert.assertNotNull(propertyExplorerPage.checkPropertyExplorerSearchHint(), "Property Explorer Page - search Hint not present");
		Assert.assertEquals(propertyExplorerPage.getPropertyExplorerSearchHintText(), utils.readTestData("copy","propertyExplorer","propertyInsightSearchHintText"));
		
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","clearSearchText"));
		Assert.assertNotNull(propertyExplorerPage.checkClearSerchButton(), "Property Explorer Page - Clear search option is not present");
		
		propertyExplorerPage.tapClearSerchButton();
		Assert.assertEquals(propertyExplorerPage.getPropertyExplorerSearchText(), "","Search text has not been cleared");
		
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","enterAdress"));
		//propertyExplorerPage.tapSearch();
		propertyExplorerPage.checkFirstItemIntheSearchDropdown();
		propertyExplorerPage.tapFirstItemIntheSearchDropdown();
				
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
		
		propertyDetailsPage.scrollToWhatsNearButton();
		Assert.assertNotNull(propertyDetailsPage.checkMiniMap(), "Property Explorer Page - Mini Map not present");
		Assert.assertNotNull(propertyDetailsPage.checkMiniMapLocationPin(), "Property Explorer Page - Mini Map location pin not present");
		
	}
	
	// DMPM-969 - Scenario 1 (DMPM-4019), Scenario 2 (4020), Scenario 3 (4026), Scenario 4 (4030), Scenario 5 (4032)
	// navigating to Property Details from START YOUR JOURNEY Button
	@Test (groups = {"DMPM-969", "DMPM-4019", "DMPM-4020", "DMPM-4026","DMPM-4030","DMPM-4032", "marketplace", "Home buying journey", "priority-minor"})
	public void testNavigatingToThePropertyOrSuburbSearch() {
		navigateToPropertyExplorer();
		Assert.assertEquals(propertyExplorerPage.getHomeJourneyTitle(), utils.readTestData("copy","propertyDetailsPage","HomeJourneyTitle"));
		Assert.assertNotNull(propertyExplorerPage.checkPropertyInsightTab(), "Property Details Page -  Property insight tab is not present");
		Assert.assertNotNull(propertyExplorerPage.checkSuburbInsightTab(), "Property Details Page -  Suburb insight tab is not present");
		Assert.assertNotNull(propertyExplorerPage.checkPropertyExplorerSearchbox(), "Property explorer Page - property Insight search box not present");
		
		propertyExplorerPage.tapSuburbInsight();
		Assert.assertNotNull(propertyExplorerPage.checkPropertyExplorerSearchbox(), "Property Explorer Page - suburb Insight search box not present");
		Assert.assertNotNull(propertyExplorerPage.checkPropertyExplorerSearchHint(), "Property Explorer Page - search Hint not present");
		Assert.assertEquals(propertyExplorerPage.getPropertyExplorerSearchHintText(), utils.readTestData("copy","propertyExplorer","suburbInsightSearchHintText"));
		
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","clearSearchText"));
		Assert.assertNotNull(propertyExplorerPage.checkClearSerchButton(), "Property Explorer Page - Clear search option is not present");
		
		propertyExplorerPage.tapClearSerchButton();
		Assert.assertEquals(propertyExplorerPage.getPropertyExplorerSearchText(), "","Search text has not been cleared");
	
		propertyExplorerPage.tapPropertyInsight();
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","enterAdress"));
		//propertyExplorerPage.tapSearch();
		propertyExplorerPage.checkFirstItemIntheSearchDropdown();
		propertyExplorerPage.tapFirstItemIntheSearchDropdown();
				
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
		
		propertyDetailsPage.tapDeviceBackButton();
		if(propertyDetailsPage.checkPropertyAddress()!=null) {
			propertyDetailsPage.tapDeviceBackButton();
		}
		
		Assert.assertEquals(propertyExplorerPage.getHomeJourneyTitle(), utils.readTestData("copy","propertyDetailsPage","HomeJourneyTitle"));
		
		propertyExplorerPage.tapBackButton();
		Assert.assertNotNull(landingPage.checkLandingPageTitle(), "Landing Page - Page title is not present");
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
			
	}
	
	// DMPM-4049 - Scenario 1 (DMPM-5126)
	// navigating to Property Explorer and search a property and switch tabs
	@Test (groups = {"DMPM-4049","DMPM-5126", "marketplace", "Home buying journey", "priority-minor"})
	public void testClearTextWhenChangingSearchType() {
		
		navigateToPropertyExplorer();
		Assert.assertNotNull(propertyExplorerPage.checkPropertyExplorerSearchbox(), "Property Explorer Page - search box not present");
		
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","clearSearchText"));
		Assert.assertNotNull(propertyExplorerPage.checkClearSerchButton(), "Property Explorer Page - Clear search option is not present");
		
		propertyExplorerPage.tapSuburbInsight();
		Assert.assertNotNull(propertyExplorerPage.checkPropertyExplorerSearchbox(), "Property Explorer Page - suburb Insight search box not present");
		Assert.assertEquals(propertyExplorerPage.getPropertyExplorerSearchText(), "", "Previous search text is still present");
		
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","clearSearchText"));	
		propertyExplorerPage.tapPropertyInsight();
		Assert.assertNotNull(propertyExplorerPage.checkPropertyExplorerSearchbox(), "Property Explorer Page - suburb Insight search box not present");
		Assert.assertNotNull(propertyExplorerPage.checkClearSerchButton(), "Property Explorer Page - Clear search option is not present");
		Assert.assertEquals(propertyExplorerPage.getPropertyExplorerSearchText(), "", "Previous search text is still present");
		
	}
	
	public void navigateToPropertyExplorer() {
		loginToApp(utils.readTestData("propertyDimension","propertyProducts","withProducts", "login"), utils.readTestData("propertyDimension", "propertyProducts","withProducts","pwd"));
		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
		Assert.assertNotNull(homePropertyPage.checkaddressLineText(), "Home Property Page - Start your journey button is not shown");
		//homePropertyPage.scrollToJourneyBanner();
		//homePropertyPage.tapStartYourJourneyButton();
		homePropertyPage.scrollToLaunchPropertyExplorer();
		homePropertyPage.taplaunchPropertyExplorer();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - page title not shown");
	
	}

}
