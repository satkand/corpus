package test.marketplace.property;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import automation.framework.common.TestDetails.Priority;
import pages.App;

public class PropertyHubTest  extends App{

	@TestDetails(story1 = "DMPM-3720:DMPM-4473,DMPM-4474,DMPM-4475,DMPM-4476,DMPM-4477", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Property Hub", "priority-minor" })
	public void testNavigateToPropertySearchFunctionFromAddProperty() {
		
		navigateToAddProperty();
		Assert.assertNotNull(propertyHubPage.checkBackButton(), "Property Hub Page - Back button is not present");
		Assert.assertNotNull(propertyHubPage.checkBackButton(), "Property Hub Page - Back button is not present");
		Assert.assertEquals(propertyHubPage.getPropertyHubPageTitle(), Copy.PROPERTY_HUB_TITLE_TEXT, "Property Hub title is not matching");
		
		Assert.assertNotNull(propertyHubPage.checkSearchBar(), "Property Hub Page - Search bar is not present");
		Assert.assertNotNull(propertyHubPage.checkSearchIcon(), "Property Hub Page - Search icon is not present");
		Assert.assertNotNull(propertyHubPage.checkPlaceHolderimage(), "Property Hub Page - Image is not present");
		Assert.assertNotNull(propertyHubPage.checkDescriptionHeading(), "Property Hub Page - Description heading is not present");
		Assert.assertNotNull(propertyHubPage.checkDescription(), "Property Hub Page - Description is not present");
		Assert.assertNotNull(propertyHubPage.checkDescription(), "Property Hub Page - Description is not present");
		Assert.assertNotNull(propertyHubPage.checkChatIcon(), "Property Hub Page - Description is not present");
		
		Assert.assertEquals(propertyHubPage.getDescriptionHeading(), Copy.PROPERTY_HUB_DESCRIPTION_HEADING, "Property Hub description heading text is not matching");
		Assert.assertEquals(propertyHubPage.getDescription(), Copy.PROPERTY_HUB_DESCRIPTION,"Property hub description is not matching");
		
		Assert.assertNotNull(propertyHubPage.checkPropertyExplorerSearchHint(), "Property Hub Page - Search hint is not present");
		Assert.assertEquals(propertyHubPage.getPropertyExplorerSearchHintText(), Copy.PROPERTY_HUB_SEARCH_HINT,"Search hint is not matching");
		Assert.assertNull(propertyHubPage.checkClearSerchButton(), "Property Hub Page - Clear search button presents on the search field without entering any letters");
		
		
		propertyHubPage.enterTextInPropertyHubSearch(utils.readTestData("propertyDimension","propertyHub","searchText"));
		Assert.assertNotNull(propertyHubPage.checkClearSerchButton(), "Property Hub Page - Clear search button is not present");
		
		propertyHubPage.tapClearSerchButton();
		Assert.assertNotNull(propertyHubPage.checkEnabledSearchBar(), "Property Hub Page - enabled search bar is not present");
		Assert.assertEquals(propertyHubPage.getEnabledSearchBarText(), "","entered text is not cleared in the search bar");
		
		propertyHubPage.tapBackButton();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");

	}
	
	@TestDetails(story1 = "DMPM-4625:DMPM-5229,DMPM-5230", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Home buying journey", "priority-minor" })
	public void testViewPropertyProfessionalServices() {
		
		navigateToPropertyHub();
		Assert.assertNotNull(propertyExplorerPage.checkPropertyInsightTab(), "Property Explorer page - Property Insight tab is not present");
		
		homePropertyPage.scrollToHomeProfessionalServicesButton();
		Assert.assertNotNull(homePropertyPage.checkHomeProfessionalServicesImage(), "Home Property Page - Home professional services image is not present");
		Assert.assertNotNull(homePropertyPage.checkHomeProfessionalServicesTitle(), "Home Property Page - Home professional services title is not present");
		Assert.assertEquals(homePropertyPage.getHomeProfessionalServicesTitle(), Copy.PROPERTY_HUB_HOME_PROFESSIONAL_SERVICES_TITLE,"Home professional services title is not matching");
		Assert.assertNotNull(homePropertyPage.checkHomeProfessionalServicesDescription(), "Home Property Page - Home professional services description is not present");
		Assert.assertEquals(homePropertyPage.getHomeProfessionalServicesDescription(), Copy.PROPERTY_HUB_HOME_PROFESSIONAL_SERVICES_DESCRIPTION,"Home professional services description is not matching");
		Assert.assertNotNull(homePropertyPage.checkHomeProfessionalServicesButton(), "Home Property Page - Home professional services button is not present");
		
		homePropertyPage.tapHomeProfessionalServicesButton();
		Assert.assertNotNull(webviewPage.checkWebviewBrowserUrl(), "Web View Page - Web View URL bar is not present");
		Assert.assertEquals(webviewPage.getWebviewBrowserUrl(), Copy.PROPERTY_HUB_HOME_PROFESSIONAL_SERVICES_URL,"Home professional services URL is not matching");
			
	}
	
	@TestDetails(story1 = "DMPM-1392:DMPM-6594,DMPM-6611", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Property Hub", "priority-minor" })
	public void testSuburbDetailsMiniMap() {
		navigateToPropertyHub();
		Assert.assertNotNull(propertyExplorerPage.checkSuburbInsightTab(), "Property Explorer page - Property Insight tab is not present");
		
		propertyExplorerPage.tapSuburbInsight();
		propertyExplorerPage.enterTextInPropertyExplorerSearchbox(utils.readTestData("propertyDimension","propertyHub","searchText"));
		propertyExplorerPage.tapSearch();
		
		Assert.assertNotNull(suburbDetailsPage.checkSuburbNameText(), "Suburb details page - Suburb name is not present");
		Assert.assertNotNull(suburbDetailsPage.checkStaticMap(), "Suburb details page - Static map is not present");
		Assert.assertNotNull(suburbDetailsPage.checkWhatsNearbyeButton(), "Suburb details page - Whats nearby button is not present");
		
		suburbDetailsPage.tapBackButton();
		Assert.assertNotNull(propertyExplorerPage.checkPropertyInsightTab(), "Property Explorer page - Property Insight tab is not present");
		propertyExplorerPage.tapPropertyInsight();
		propertyExplorerPage.enterTextInPropertyExplorerSearchbox(utils.readTestData("propertyDimension","propertyHub","searchText"));
		propertyExplorerPage.tapSearch();
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property details page - Property Address is not present");
		
		propertyDetailsPage.scrollToShowMeInsightButton();
		propertyDetailsPage.tapShowMeInsightButton();
		Assert.assertNotNull(suburbDetailsPage.checkSuburbNameText(), "Suburb details page - Suburb name is not present");
		Assert.assertNotNull(suburbDetailsPage.checkStaticMap(), "Suburb details page - Static map is not present");
		Assert.assertNotNull(suburbDetailsPage.checkWhatsNearbyeButton(), "Suburb details page - Whats nearby button is not present");
		
		
		
	}
	
	private void navigateToPropertyHub() {
		navigateToPropertyDimension();
		homePropertyPage.scrollToJourneyBanner();
		homePropertyPage.tapStartYourJourneyButton();
	}

	public void navigateToAddProperty() {
		navigateToPropertyDimension();
		homePropertyPage.tapAddAPropertyOrPolicyButton();
		Assert.assertNotNull(homePropertyPage.checkAddPropertyActionSheetButton(), "Home Property Page - Property action sheet button is not present");
		
		homePropertyPage.tapAddPropertyActionSheetButton();
		Assert.assertNotNull(propertyHubPage.checkPropertyHubPageTitle(), "Property Hub Page - Page title is not present");
		
	}
	
	public void navigateToPropertyDimension() {
		loginToApp(utils.readTestData("propertyDimension","propertyHub","login"), utils.readTestData("propertyDimension", "propertyHub","pwd"));
		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
		
	}
}
