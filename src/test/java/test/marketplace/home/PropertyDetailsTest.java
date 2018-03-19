package test.marketplace.home;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class PropertyDetailsTest extends App{

	// DMPM-1126 - Scenario 1
	// navigating to Property Details and Verify property details
	@Test (groups = {"DMPM-1126", "DMPM-4312", "marketplace", "Home buying journey", "priority-minor"})
	public void testNavigateToPropertyDetailsScreen() {
		navigateToPropertyDetails("StartYourJourney");
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyAddress(), utils.readTestData("propertyDimention","propertyDetails","address"));
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyStatePostCode(), "Property Details Page - Property Postcode and state are not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyStatePostCode(), utils.readTestData("propertyDimention","propertyDetails","stateAndSuburb"));
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyNumberOfBedrooms(), "Property Details Page - Number of bedrooms are not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyNumberOfBedrooms(),  utils.readTestData("propertyDimention","propertyDetails","bedRooms"));
		Assert.assertNotNull(propertyDetailsPage.checkPropertyNumberOfBedroomsImage(), "Property Details Page - Bedroom image is not present");
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyNumberOfBathrooms(), "Property Details Page - Number of bathrooms are not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyNumberOfBathrooms(),   utils.readTestData("propertyDimention","propertyDetails","bathRooms"));
		Assert.assertNotNull(propertyDetailsPage.checkPropertyNumberOfBathroomsImage(), "Property Details Page - bathrooms image is not present");
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyNumberOfParkingSpaces(), "Property Details Page - Number of parking spaces are not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyNumberOfParkingSpaces(),  utils.readTestData("propertyDimention","propertyDetails","parkingSpaces"));
		Assert.assertNotNull(propertyDetailsPage.checkPropertyNumberOfParkingSpacesImage(), "Property Details Page - Parking spaces image is not present");
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyLandSize(), "Property Details Page -  Land size not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyLandSize(), utils.readTestData("propertyDimention","propertyDetails","landSize"));
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyType(), "Property Details Page -  Property type is not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyType(), utils.readTestData("propertyDimention","propertyDetails","propertyType"));
		
		propertyDetailsPage.scrollToViewMoreInfo();
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyShowMoreInfo(), "Property Details Page -  Show more info Label is not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyShowMoreInfo(), utils.readTestData("copy","propertyDetailsPage","showMoreInfoLabel"));
				
	}
	
	// DMPM-1126 - Scenario 2
	// navigating to Property Details and Verify show more information
	@Test (groups = {"DMPM-1126", "DMPM-4310", "marketplace", "Home buying journey", "priority-minor"})
	public void testShowMoreInfoOnPropertyDetailsScreen() {
		
		navigateToPropertyDetails("StartYourJourney");
		propertyHubPage.scrollToWhatsNewButton();
		Assert.assertNotNull(propertyDetailsPage.checkPropertyShowMoreInfo(), "Property Details Page -  Show more info Label is not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyShowMoreInfo(), utils.readTestData("copy","propertyDetailsPage","showMoreInfoLabel"));
		
		propertyDetailsPage.tappropertyShowMoreDownArrow();
		Assert.assertNotNull(propertyDetailsPage.checkPropertyRoofTypeTitle(), "Property Details Page -  Property roof type title is not present");
		Assert.assertNotNull(propertyDetailsPage.checkPropertyWallMaterialTitle(), "Property Details Page -  Property wall material title is not present");
		Assert.assertNotNull(propertyDetailsPage.checkPropertyBuiltYearTitle(), "Property Details Page -  Property built year title is not present");
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyRoofType(), "Property Details Page -  Property roof type is not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyRoofType(), utils.readTestData("propertyDimention","propertyDetails","roofType"));
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyWallMaterial(), "Property Details Page -  Property wall material is not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyWallMaterial(), utils.readTestData("propertyDimention","propertyDetails","wallMaterial"));
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyBuiltYear(), "Property Details Page -  Property built year is not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyBuiltYear(),  utils.readTestData("propertyDimention","propertyDetails","buildYear"));
		
		propertyDetailsPage.tappropertyShowMoreDownArrow();
		Assert.assertEquals(propertyDetailsPage.getPropertyShowMoreInfo(), utils.readTestData("copy","propertyDetailsPage","showLessInfoLabel"));
		Assert.assertNull(propertyDetailsPage.checkPropertyRoofTypeTitle(), "Property Details Page -  Property roof type title is not present");
		
	}
	
	public void navigateToPropertyDetails(String navigationPath) {
		
		loginToApp(utils.readTestData("propertyDimention","propertyProducts","withProducts", "login"), utils.readTestData("propertyDimention", "propertyProducts","withProducts","pwd"));
		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
		homePropertyPage.scrollToJourneyBanner();
		homePropertyPage.tapStartYourJourneyButton();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - page title not shown");
		propertyHubPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimention","propertyExplorer","enterAdress"));
		propertyHubPage.tapSearch();
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
		
	
	}
}
