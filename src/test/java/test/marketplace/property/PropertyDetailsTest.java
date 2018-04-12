package test.marketplace.property;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class PropertyDetailsTest extends App{

	// DMPM-1126 - Scenario 1
	//DMPM-4822
	// navigating to Property Details and Verify property details
	@Test (groups = {"DMPM-1126", "DMPM-4312", "marketplace", "Home buying journey", "priority-minor"})
	public void testNavigateToPropertyDetailsScreen() {
		navigateToPropertyDetails("StartYourJourney");
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyAddress(), utils.readTestData("propertyDimension","propertyDetails","address"),"Property Address is not matching");
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyStatePostCode(), "Property Details Page - Property Postcode and state are not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyStatePostCode(), utils.readTestData("propertyDimension","propertyDetails","stateAndSuburb"),"Post code is not matching");
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyNumberOfBedrooms(), "Property Details Page - Number of bedrooms are not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyNumberOfBedrooms(),  utils.readTestData("propertyDimension","propertyDetails","bedRooms"),"Number of bedrooms in the property is not matching");
		Assert.assertNotNull(propertyDetailsPage.checkPropertyNumberOfBedroomsImage(), "Property Details Page - Bedroom image is not present");
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyNumberOfBathrooms(), "Property Details Page - Number of bathrooms are not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyNumberOfBathrooms(),   utils.readTestData("propertyDimension","propertyDetails","bathrooms"),"Number of bathrooms in the property is not matching");
		Assert.assertNotNull(propertyDetailsPage.checkPropertyNumberOfBathroomsImage(), "Property Details Page - bathrooms image is not present");
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyNumberOfParkingSpaces(), "Property Details Page - Number of parking spaces are not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyNumberOfParkingSpaces(),  utils.readTestData("propertyDimension","propertyDetails","parkingSpaces"),"Number of parking spaces in the property is not matching");
		Assert.assertNotNull(propertyDetailsPage.checkPropertyNumberOfParkingSpacesImage(), "Property Details Page - Parking spaces image is not present");
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyLandSize(), "Property Details Page -  Land size not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyLandSize(), utils.readTestData("propertyDimension","propertyDetails","landSize"),"Land size of the property is not matching");
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyType(), "Property Details Page -  Property type is not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyType(), utils.readTestData("propertyDimension","propertyDetails","propertyType"),"Property type is not matching");

		//Show more accordion was removed as part of story 4822
		Assert.assertNull(propertyDetailsPage.checkPropertyShowMoreInfo(), "Property Details Page -  Show more info Label is not present");
			
	}
	
	// DMPM-1126 - Scenario 2 and scenario 3
	//DMPM-1267 - Scenario 1
	//DMPM-4822
	// navigating to Property Details and Verify show more information
	@Test (groups = {"DMPM-1126", "DMPM-4310","DMPM-4315","DMPM-1267","DMPM-3536","DMPM-4822", "marketplace", "Home buying journey", "priority-minor"})
	public void testShowMoreInfoOnPropertyDetailsScreen() {
		
		navigateToPropertyDetails("StartYourJourney");
		propertyDetailsPage.scrollToWhatsNearButton();
		Assert.assertNotNull(propertyDetailsPage.checkLastSaleTitle(), "Property Details Page -  Last Sale title is not present");
		Assert.assertEquals(propertyDetailsPage.getLastSaleValue(), utils.readTestData("propertyDimension","propertyDetails","salePrice"),"Sale value of the property is not matching");
		Assert.assertEquals(propertyDetailsPage.getLastSaleDate(), utils.readTestData("propertyDimension","propertyDetails","saleDate"),"Sale date of the property is not matching");
		
		Assert.assertNull(propertyDetailsPage.checkPropertyShowMoreInfo(), "Property Details Page -  Show more info Label is not present");
		
	}
	
	//DMPM-1275 - Scenario 1 and scenario 2
	@Test (groups = {"DMPM-1275", "DMPM-4450","DMPM-4451","marketplace", "Home buying journey", "priority-minor"})
	public void testSuburbInsightInPropertyDetailsScreen() {
			
		navigateToPropertyDetails("StartYourJourney");
		propertyDetailsPage.scrollToShowMeInsightButton();
		Assert.assertNotNull(propertyDetailsPage.checkSuburbInsightDescription(), "Property Details Page - suburb insight description is not present");
		Assert.assertEquals(propertyDetailsPage.getSuburbInsightDescription(), "Get the latest median prices, real estate market data & demographic information","Suburb insight description is not matching");
		Assert.assertNotNull(propertyDetailsPage.checkSuburbInsightTitleText(), "Property Details Page - Suburb Insight title text is not present");
		Assert.assertEquals(propertyDetailsPage.getSuburbInsightTitleText(), "North Heidelberg suburb insight","Suburb insight title text is not matching");
		Assert.assertNotNull(propertyDetailsPage.checkSuburbInsightImage(), "Property Details Page -suburn insight image is not present");
		
		propertyDetailsPage.tapShowMeInsightButton();
		propertyDetailsPage.tapAndroidDeviceBackButton();
		Assert.assertNotNull(propertyDetailsPage.checkSuburbInsightTitleText(), "Property Details Page - Suburb Insight title text is not present");
	}
	
	//DMPM-1151 - Scenario 1 (TC DMPM-4462), Scenario 3(TC DMPM-4464), Scenario 5 (TC DMPM-4466)
	//Navigate to property details and see what the property actually looks like
	@Test (groups = {"DMPM-1151", "DMPM-4462","DMPM-4464","DMPM-4466","marketplace", "Home buying journey", "priority-minor"})
	public void testDisplayPropertyImages() {
				
		navigateToPropertyDetails("StartYourJourney");
		Assert.assertNotNull(propertyDetailsPage.checkPropertyImage(), "Property Details Page - Property image is not present");
		Assert.assertNotNull(propertyDetailsPage.checkFavouriteButton(), "Property Details Page - Favorite button is not present");
		Assert.assertNotNull(propertyDetailsPage.checkImageNumberText(), "Property Details Page - Image number text is not present");
		Assert.assertNotNull(propertyDetailsPage.checkBackButton(), "Property Details Page - back button is not present");
		
		int imageCount = Integer.parseInt(utils.readTestData("propertyDimension","propertyDetails","numberOfImages"));
		for(int i=1;i<=imageCount;i++) {
			Assert.assertNotNull(propertyDetailsPage.checkPropertyImage(), "Property Details Page - Property image is not present");
			Assert.assertEquals(propertyDetailsPage.getImageNumberText(), i+"/"+imageCount,"Image number test is not matching");
			
			//Story DMPM-4780 covers from below code
			if(i%2==0) {
				propertyDetailsPage.tapPropertyImage();
				String imageNumberInNormalView = propertyDetailsPage.getfullScreenImageCounter();
				propertyDetailsPage.tapFullScreenCloseButton();
				Assert.assertEquals(propertyDetailsPage.getImageNumberText(), imageNumberInNormalView, "Image number text in full screen view and normal view is not matching");
			}

			propertyDetailsPage.swipeImageCarouselLeft();
		}
		
		for(int i=imageCount;i>0;i--) {
			Assert.assertNotNull(propertyDetailsPage.checkPropertyImage(), "Property Details Page - Property image is not present");
			Assert.assertEquals(propertyDetailsPage.getImageNumberText(), i+"/"+imageCount,"Image number test is not matching");
			propertyDetailsPage.swipeImageCarouselRight();
		}		
		
	}
	
	//DMPM-3794 - Scenario 1 (TC DMPM-4478), Scenario 3(TC DMPM-4480), Scenario 5 (TC DMPM-4483), Scenario 6 (TC DMPM-4484)
	//Navigate to property details, tap on image and see the full screen view
	@Test (groups = {"DMPM-3794", "DMPM-4478","DMPM-4480","DMPM-4483","DMPM-4484","marketplace", "Home buying journey", "priority-minor"})
	public void testDisplayPropertyImagesFullScreenView() {
				
		
		navigateToPropertyDetails("StartYourJourney");
		Assert.assertNotNull(propertyDetailsPage.checkPropertyImage(), "Property Details Page - Property image is not present");
		
		String propertyAddress = propertyDetailsPage.getPropertyAddress();
		propertyDetailsPage.tapPropertyImage();
		Assert.assertNotNull(propertyDetailsPage.checkFullScreenPropertyImage(), "Property Details Page - Full screen view property image is not present");
		Assert.assertNotNull(propertyDetailsPage.checkFullScreenCloseButton(), "Property Details Page - Full screen view close button is not present");
		Assert.assertNotNull(propertyDetailsPage.checkFullScreenImageCounter(), "Property Details Page - Full screen view Image number text is not present");
		Assert.assertNotNull(propertyDetailsPage.checkFullScreenPropertyAddress(), "Property Details Page - Full screen property address is not present");
		Assert.assertEquals(propertyAddress, propertyDetailsPage.getFullScreenPropertyAddress(),"Property address is not matching in normal view and full screen view");
		
		int imageCount = Integer.parseInt(utils.readTestData("propertyDimension","propertyDetails","numberOfImages"));
		for(int i=1;i<=imageCount;i++) {
			Assert.assertNotNull(propertyDetailsPage.checkFullScreenPropertyImage(), "Property Details Page - Full screen view propertyimage is not present");
			Assert.assertEquals(propertyDetailsPage.getfullScreenImageCounter(), i+"/"+imageCount,"Image number test is not matching");
			propertyDetailsPage.swipeFullScreenImageCarouselLeft();
		}
		
		for(int i=imageCount;i>0;i--) {	
			Assert.assertNotNull(propertyDetailsPage.checkFullScreenPropertyImage(), "Property Details Page - Full screen view propertyimage is not present");
			Assert.assertEquals(propertyDetailsPage.getfullScreenImageCounter(), i+"/"+imageCount,"Image number test is not matching");
			propertyDetailsPage.swipeFullScreenImageCarouselRight();
		}	
		
		propertyDetailsPage.tapFullScreenCloseButton();
		Assert.assertNotNull(propertyDetailsPage.checkFavouriteButton(), "Property Details Page - Favorite button is not present when coming back from full screen view");
		
	}
	
	// DMPM-3116 - Scenario 1 (DMPM-5245)
	// navigating to Property details and verify the estimated property value section
	@Test (groups = {"DMPM-3116","DMPM-5245", "marketplace", "Property Hub", "priority-minor"})
	public void testEstimatedPropertyValue() {
		
		navigateToPropertyDetails("StartYourJourney");
		Assert.assertNotNull(propertyDetailsPage.checkEstimatedMarketValueLabel(), "Property Details Page - Estmated market value label is not present");
		Assert.assertNotNull(propertyDetailsPage.checkEstimatedMarketValueinfoButton(), "Property Details Page - Estmated market value info button is not present");
		Assert.assertNotNull(propertyDetailsPage.checkEstimatedMarketValue(), "Property Details Page - Estmated market value is not present");
		Assert.assertNotNull(propertyDetailsPage.checkConfidenceLevelLabel(), "Property Details Page - Estmated market value - confidence level label is not present");
		Assert.assertNotNull(propertyDetailsPage.checkConfidenceIndicator(), "Property Details Page - Estmated market value - confidence indicator is not present");
		Assert.assertNotNull(propertyDetailsPage.checkConfidenceIndicatorInfoButton(), "Property Details Page - Estmated market value - confidence indicator info button is not present");
		
		Assert.assertEquals(propertyDetailsPage.getEstimatedMarketValueLabel(), utils.readTestData("copy","propertyExplorer","estimatedMarketValue"),"Estimated market value label is not matching");
		Assert.assertEquals(propertyDetailsPage.getEstimatedMarketValue(), utils.readTestData("propertyDimension","propertyDetails","estimatedMarketValue"),"Estimated market value is not displayed");
		Assert.assertEquals(propertyDetailsPage.getConfidenceLevelLabel(), utils.readTestData("propertyDimension","propertyDetails","confidenceLevel"),"Confidence level label is not displayed");
		
		propertyDetailsPage.tapBackButton();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - page title not shown");
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","highConfidenceAddress"));
		propertyExplorerPage.tapSearch();
		Assert.assertEquals(propertyDetailsPage.getEstimatedMarketValue(), utils.readTestData("propertyDimension","propertyDetailsHighConfidence","estimatedMarketValue"),"Estimated market value is not displayed");
		Assert.assertEquals(propertyDetailsPage.getConfidenceLevelLabel(), utils.readTestData("propertyDimension","propertyDetailsHighConfidence","confidenceLevel"),"Confidence level label is not displayed");
		
		//TODO
		//Still low confidence property details need to be verified (currently mock data is NOT available for low confidence)
		
	}
		

	public void navigateToPropertyDetails(String navigationPath) {
		if(navigationPath.equals("StartYourJourney")) {
			loginToApp(utils.readTestData("propertyDimension","propertyProducts","withProducts", "login"), utils.readTestData("propertyDimension", "propertyProducts","withProducts","pwd"));
			landingPage.tapHomeTab();
			Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
			homePropertyPage.scrollToJourneyBanner();
			Assert.assertNotNull(homePropertyPage.checkStartYourJourneyButton(), "Home Property Page - Start your journey button is not present");
			homePropertyPage.tapStartYourJourneyButton();
			Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - page title not shown");
		}else {
			//TODO when other navigation paths are developed
		}
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","enterAdress"));
		propertyExplorerPage.tapSearch();
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
		
	
	}
	
}
