package test.marketplace.property;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import automation.framework.common.TestDetails.Priority;
import pages.App;

public class PropertyDetailsTest extends App{

	// DMPM-1126 - Scenario 1
	//DMPM-4822
	// navigating to Property Details and Verify property details
	@Test (groups = {"DMPM-1126", "DMPM-4312", "marketplace", "Home buying journey", "priority-minor"})
	public void testNavigateToPropertyDetailsScreen() {
		navigateToPropertyDetails("StartYourJourney","MediumConfident");
		
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
		Assert.assertEquals(propertyDetailsPage.getPropertyAddress(), utils.readTestData("propertyDimension","propertyDetails","address"),"property address is not matching");
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyStatePostCode(), "Property Details Page - Property Postcode and state are not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyStatePostCode(), utils.readTestData("propertyDimension","propertyDetails","stateAndSuburb"),"post code is not matching");
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyNumberOfBedrooms(), "Property Details Page - Number of bedrooms are not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyNumberOfBedrooms(),  utils.readTestData("propertyDimension","propertyDetails","bedRooms"),"bedroom count is not matching");
		Assert.assertNotNull(propertyDetailsPage.checkPropertyNumberOfBedroomsImage(), "Property Details Page - Bedroom image is not present");
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyNumberOfBathrooms(), "Property Details Page - Number of bathrooms are not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyNumberOfBathrooms(),   utils.readTestData("propertyDimension","propertyDetails","bathrooms"),"bath room count is not matching");
		Assert.assertNotNull(propertyDetailsPage.checkPropertyNumberOfBathroomsImage(), "Property Details Page - bathrooms image is not present");
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyNumberOfParkingSpaces(), "Property Details Page - Number of parking spaces are not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyNumberOfParkingSpaces(),  utils.readTestData("propertyDimension","propertyDetails","parkingSpaces"),"parking spaces count is not matching");
		Assert.assertNotNull(propertyDetailsPage.checkPropertyNumberOfParkingSpacesImage(), "Property Details Page - Parking spaces image is not present");
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyLandSize(), "Property Details Page -  Land size not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyLandSize(), utils.readTestData("propertyDimension","propertyDetails","landSize"),"property land size is not matching");
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyType(), "Property Details Page -  Property type is not present");
		Assert.assertEquals(propertyDetailsPage.getPropertyType(), utils.readTestData("propertyDimension","propertyDetails","propertyType"),"property type is not matching");

		//Show more accordion was removed as part of story 4822
		Assert.assertNull(propertyDetailsPage.checkPropertyShowMoreInfo(), "Property Details Page -  Show more info Label is not present");
			
	}
	
	// DMPM-1126 - Scenario 2 and scenario 3
	//DMPM-1267 - Scenario 1
	//DMPM-4822
	// navigating to Property Details and Verify show more information
	@Test (groups = {"DMPM-1126", "DMPM-4310","DMPM-4315","DMPM-1267","DMPM-3536","DMPM-4822", "marketplace", "Home buying journey", "priority-minor"})
	public void testShowMoreInfoOnPropertyDetailsScreen() {
		
		navigateToPropertyDetails("StartYourJourney","MediumConfident");
		propertyDetailsPage.scrollToWhatsNearButton();
		Assert.assertNotNull(propertyDetailsPage.checkLastSaleTitle(), "Property Details Page -  Last Sale title is not present");
		Assert.assertEquals(propertyDetailsPage.getLastSaleValue(), utils.readTestData("propertyDimension","propertyDetails","salePrice"),"Sale value of the property is not matching");
		Assert.assertEquals(propertyDetailsPage.getLastSaleDate(), utils.readTestData("propertyDimension","propertyDetails","saleDate"),"Sale date of the property is not matching");
		Assert.assertEquals(propertyDetailsPage.getLastSaleValue(), utils.readTestData("propertyDimension","propertyDetails","salePrice"), "property sales price is not matching");
		Assert.assertEquals(propertyDetailsPage.getLastSaleDate(), utils.readTestData("propertyDimension","propertyDetails","saleDate"),"property sale date is not matching");
		
		Assert.assertNull(propertyDetailsPage.checkPropertyShowMoreInfo(), "Property Details Page -  Show more info Label is not present");
		
	}
	
	//DMPM-1275 - Scenario 1 and scenario 2
	@Test (groups = {"DMPM-1275", "DMPM-4450","DMPM-4451","marketplace", "Home buying journey", "priority-minor"})
	public void testSuburbInsightInPropertyDetailsScreen() {
			
		navigateToPropertyDetails("StartYourJourney","MediumConfident");
		propertyDetailsPage.scrollToShowMeInsightButton();
		Assert.assertNotNull(propertyDetailsPage.checkSuburbInsightDescription(), "Property Details Page - suburb insight description is not present");
		Assert.assertEquals(propertyDetailsPage.getSuburbInsightDescription(), "Get the latest median prices, real estate market data & demographic information","Suburb insight description is not matching");
		Assert.assertNotNull(propertyDetailsPage.checkSuburbInsightTitleText(), "Property Details Page - Suburb Insight title text is not present");
		Assert.assertEquals(propertyDetailsPage.getSuburbInsightTitleText(), "North Heidelberg suburb insight","Suburb insight title text is not matching");

		Assert.assertEquals(propertyDetailsPage.getSuburbInsightDescription(), "Get the latest median prices, real estate market data & demographic information","suburb insight description is not matching");
		Assert.assertNotNull(propertyDetailsPage.checkSuburbInsightTitleText(), "Property Details Page - Suburb Insight title text is not present");
		Assert.assertEquals(propertyDetailsPage.getSuburbInsightTitleText(), "North Heidelberg suburb insight","suburn insight title text is not matching");
		Assert.assertNotNull(propertyDetailsPage.checkSuburbInsightImage(), "Property Details Page -suburn insight image is not present");
		
		propertyDetailsPage.tapShowMeInsightButton();
		propertyDetailsPage.tapAndroidDeviceBackButton();
		Assert.assertNotNull(propertyDetailsPage.checkSuburbInsightTitleText(), "Property Details Page - Suburb Insight title text is not present");
	}
	
	//DMPM-1151 - Scenario 1 (TC DMPM-4462), Scenario 3(TC DMPM-4464), Scenario 5 (TC DMPM-4466)
	//DMPM-4788 - Scenario 1 (TC DMPM-5530)
	//Navigate to property details and see what the property actually looks like
	@Test (groups = {"DMPM-1151", "DMPM-4462","DMPM-4464","DMPM-4466","DMPM-4788","DMPM-5530","marketplace", "Home buying journey", "priority-minor"})
	public void testDisplayPropertyImages() {
				
		navigateToPropertyDetails("StartYourJourney","MediumConfident");
		Assert.assertNotNull(propertyDetailsPage.checkPropertyImage(), "Property Details Page - Property image is not present");
		Assert.assertNotNull(propertyDetailsPage.checkFavouriteButton(), "Property Details Page - Favorite button is not present");
		Assert.assertNotNull(propertyDetailsPage.checkImageNumberText(), "Property Details Page - Image number text is not present");
		Assert.assertNotNull(propertyDetailsPage.checkBackButton(), "Property Details Page - back button is not present");
		
		int imageCount = Integer.parseInt(utils.readTestData("propertyDimension","propertyDetails","numberOfImages"));
		for(int i=1;i<=imageCount;i++) {
			Assert.assertNotNull(propertyDetailsPage.checkPropertyImage(), "Property Details Page - Property image is not present");
			Assert.assertEquals(propertyDetailsPage.getImageNumberText(), i+"/"+imageCount,"Image number test is not matching");

			Assert.assertEquals(propertyDetailsPage.getImageNumberText(), i+"/"+imageCount, "image count is not matching");

			
			//Story DMPM-4780 covers from below code
			if(i%2==0) {
				propertyDetailsPage.tapPropertyImage();
				String imageNumberInNormalView = propertyDetailsPage.getfullScreenImageCounter();
				propertyDetailsPage.tapFullScreenCloseButton();

				Assert.assertEquals(propertyDetailsPage.getImageNumberText(), imageNumberInNormalView, "Image number text in full screen view and normal view is not matching");

				Assert.assertEquals(propertyDetailsPage.getImageNumberText(), imageNumberInNormalView,"image nuber text is not matching");
			}

			propertyDetailsPage.swipeImageCarouselLeft();
			
			
		}
		
		for(int i=imageCount;i>0;i--) {
			Assert.assertNotNull(propertyDetailsPage.checkPropertyImage(), "Property Details Page - Property image is not present");

			Assert.assertEquals(propertyDetailsPage.getImageNumberText(), i+"/"+imageCount,"Image number test is not matching");

			Assert.assertEquals(propertyDetailsPage.getImageNumberText(), i+"/"+imageCount,"image count is not matching");
			propertyDetailsPage.swipeImageCarouselRight();
			propertyDetailsPage.waitForFullScreenLoadingIndicatorToDisappear();
			
		}		
		
	}
	
	//DMPM-3794 - Scenario 1 (TC DMPM-4478), Scenario 3(TC DMPM-4480), Scenario 5 (TC DMPM-4483), Scenario 6 (TC DMPM-4484)
	//DMPM-4788 - Scenario 1 (TC DMPM-5530)
	//Navigate to property details, tap on image and see the full screen view
	@Test (groups = {"DMPM-3794", "DMPM-4478","DMPM-4480","DMPM-4483","DMPM-4484","DMPM-4788","DMPM-5530","marketplace", "Property Hub", "priority-minor"})
	public void testDisplayPropertyImagesFullScreenView() {
				
		
		navigateToPropertyDetails("StartYourJourney","MediumConfident");
		Assert.assertNotNull(propertyDetailsPage.checkPropertyImage(), "Property Details Page - Property image is not present");
		
		String propertyAddress = propertyDetailsPage.getPropertyAddress();
		propertyDetailsPage.tapPropertyImage();
		Assert.assertNotNull(propertyDetailsPage.checkFullScreenPropertyImage(), "Property Details Page - Full screen view property image is not present");
		Assert.assertNotNull(propertyDetailsPage.checkFullScreenCloseButton(), "Property Details Page - Full screen view close button is not present");
		Assert.assertNotNull(propertyDetailsPage.checkFullScreenImageCounter(), "Property Details Page - Full screen view Image number text is not present");
		Assert.assertNotNull(propertyDetailsPage.checkFullScreenPropertyAddress(), "Property Details Page - Full screen property address is not present");

		Assert.assertEquals(propertyAddress, propertyDetailsPage.getFullScreenPropertyAddress(),"Property address is not matching in normal view and full screen view");

		Assert.assertEquals(propertyAddress, propertyDetailsPage.getFullScreenPropertyAddress(),"property full screen address is not matching");
		
		int imageCount = Integer.parseInt(utils.readTestData("propertyDimension","propertyDetails","numberOfImages"));
		for(int i=1;i<=imageCount;i++) {
			Assert.assertNotNull(propertyDetailsPage.checkFullScreenPropertyImage(), "Property Details Page - Full screen view propertyimage is not present");

			Assert.assertEquals(propertyDetailsPage.getfullScreenImageCounter(), i+"/"+imageCount,"Image number test is not matching");

			Assert.assertEquals(propertyDetailsPage.getfullScreenImageCounter(), i+"/"+imageCount, "image count is not matching");
			propertyDetailsPage.swipeFullScreenImageCarouselLeft();
			propertyDetailsPage.waitForFullScreenLoadingIndicatorToDisappear();
		}
		
		for(int i=imageCount;i>0;i--) {	
			Assert.assertNotNull(propertyDetailsPage.checkFullScreenPropertyImage(), "Property Details Page - Full screen view propertyimage is not present");

			Assert.assertEquals(propertyDetailsPage.getfullScreenImageCounter(), i+"/"+imageCount,"Image number test is not matching");

			Assert.assertEquals(propertyDetailsPage.getfullScreenImageCounter(), i+"/"+imageCount,"image count is not matching");
			propertyDetailsPage.swipeFullScreenImageCarouselRight();
			propertyDetailsPage.waitForFullScreenLoadingIndicatorToDisappear();
		}	
		
		propertyDetailsPage.tapFullScreenCloseButton();
		Assert.assertNotNull(propertyDetailsPage.checkFavouriteButton(), "Property Details Page - Favorite button is not present when coming back from full screen view");
		
	}
	
	
	// DMPM-3116 - Scenario 1 (DMPM-5245)
	// navigating to Property details and verify the estimated property value section
	@Test (groups = {"DMPM-3116","DMPM-5245", "marketplace", "Property Hub", "priority-minor"})
	public void testEstimatedPropertyValue() {
		
		navigateToPropertyDetails("StartYourJourney","MediumConfident");
		Assert.assertNotNull(propertyDetailsPage.checkEstimatedMarketValueLabel(), "Property Details Page - Estmated market value label is not present");
		Assert.assertNotNull(propertyDetailsPage.checkEstimatedMarketValueinfoButton(), "Property Details Page - Estmated market value info button is not present");
		Assert.assertNotNull(propertyDetailsPage.checkEstimatedMarketValue(), "Property Details Page - Estmated market value is not present");
		Assert.assertNotNull(propertyDetailsPage.checkConfidenceLevelLabel(), "Property Details Page - Estmated market value - confidence level label is not present");
		Assert.assertNotNull(propertyDetailsPage.checkConfidenceIndicator(), "Property Details Page - Estmated market value - confidence indicator is not present");
		Assert.assertNotNull(propertyDetailsPage.checkConfidenceIndicatorInfoButton(), "Property Details Page - Estmated market value - confidence indicator info button is not present");
		
		Assert.assertEquals(propertyDetailsPage.getEstimatedMarketValueLabel(), utils.readTestData("copy","propertyExplorer","estimatedMarketValue"),"Estimated market value label is not matching");
		Assert.assertEquals(propertyDetailsPage.getEstimatedMarketValue(), utils.readTestData("propertyDimension","propertyDetails","estimatedMarketValue"),"Estimated market value is not displayed");
		Assert.assertEquals(propertyDetailsPage.getConfidenceLevelLabel(), utils.readTestData("propertyDimension","propertyDetails","confidenceLevel"),"Confidence level label is not displayed");
		Assert.assertEquals(propertyDetailsPage.getEstimatedMarketValueLabel(), utils.readTestData("copy","propertyExplorer","estimatedMarketValue"), "property estimated market value label is not matching");
		Assert.assertEquals(propertyDetailsPage.getEstimatedMarketValue(), utils.readTestData("propertyDimension","propertyDetails","estimatedMarketValue"),"property estimated market value is not matching");
		Assert.assertEquals(propertyDetailsPage.getConfidenceLevelLabel(), utils.readTestData("propertyDimension","propertyDetails","confidenceLevel"),"property confidence labe is not matching");
		
		propertyDetailsPage.tapBackButton();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - page title not shown");
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","highConfidenceAddress"));
		propertyExplorerPage.tapSearch();

		Assert.assertEquals(propertyDetailsPage.getEstimatedMarketValue(), utils.readTestData("propertyDimension","propertyDetailsHighConfidence","estimatedMarketValue"),"Estimated market value is not displayed");
		Assert.assertEquals(propertyDetailsPage.getConfidenceLevelLabel(), utils.readTestData("propertyDimension","propertyDetailsHighConfidence","confidenceLevel"),"Confidence level label is not displayed");

		Assert.assertEquals(propertyDetailsPage.getEstimatedMarketValue(), utils.readTestData("propertyDimension","propertyDetailsHighConfidence","estimatedMarketValue"),"property estimated market value is not matching");
		Assert.assertEquals(propertyDetailsPage.getConfidenceLevelLabel(), utils.readTestData("propertyDimension","propertyDetailsHighConfidence","confidenceLevel"),"property confidence level is not matching");
		
		//TODO
		//Still low confidence property details need to be verified (currently mock data is NOT available for low confidence)
		
	}
		
	// DMPM-1261 - Scenario 1 (DMPM-4716), Scenario 2 (DMPM-4717), Scenario 5 (DMPM-4720)
	// navigating to Property details and verify the full screen view of the map
	@Test (groups = {"DMPM-1261","DMPM-4716","DMPM-4717","DMPM-4720", "marketplace", "Property Hub", "priority-minor"})
	public void testDisplayOptionToGoToFullScreenMap() {
			
		navigateToPropertyDetails("StartYourJourney","MediumConfident");
		propertyDetailsPage.scrollToWhatsNearButton();
		Assert.assertNotNull(propertyDetailsPage.checkMiniMap(), "Property Explorer Page - Mini Map not present");
		
		propertyExplorerPage.tapMiniMapWhatsNearByButton();
		Assert.assertNotNull(propertyFullScreenMap.checkFullScreenMapPin(), "Property Explorer Page - Full screen map pin is not present");
		Assert.assertNotNull(propertyFullScreenMap.checkFullScreenMapTitle(), "Property Explorer Page - Full screen map pin is not present");
		Assert.assertNotNull(propertyFullScreenMap.checkFullScreenMapCloseButton(), "Property Explorer Page - Full screen map pin is not present");
		
		propertyFullScreenMap.tapFullScreenMapCloseButton();
		Assert.assertNotNull(propertyDetailsPage.checkMiniMap(), "Property Explorer Page - Mini Map not present");
		
		propertyExplorerPage.tapMiniMap();
		Assert.assertNotNull(propertyFullScreenMap.checkFullScreenMapPin(), "Property Explorer Page - Full screen map pin is not present");
		Assert.assertNotNull(propertyFullScreenMap.checkFullScreenMapPin(), "Property Explorer Page - Full screen map pin is not present");
		Assert.assertNotNull(propertyFullScreenMap.checkFullScreenMapTitle(), "Property Explorer Page - Full screen map pin is not present");
		Assert.assertNotNull(propertyFullScreenMap.checkFullScreenMapCloseButton(), "Property Explorer Page - Full screen map pin is not present");
		
		propertyFullScreenMap.tapFullScreenMapCloseButton();
		Assert.assertNotNull(propertyDetailsPage.checkMiniMap(), "Property Explorer Page - Mini Map not present");
		
		}
	
	@TestDetails(story1 = "DMPM-3988:DMPM-4470,DMPM-4471", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Property Hub", "priority-minor" })
	public void testDoubleTapToZoominAndOutPropertyImages() {
						
		navigateToPropertyDetails("StartYourJourney","MeduimConfident");
		Assert.assertNotNull(propertyDetailsPage.checkPropertyImage(), "Property Details Page - Property image is not present");
		String propertyAddress = propertyDetailsPage.getPropertyAddress();
		
		propertyDetailsPage.tapPropertyImage();
		Assert.assertNotNull(propertyDetailsPage.checkFullScreenPropertyAddress(), "Property Details Page - Full screen property address is not present");
		Assert.assertEquals(propertyAddress,propertyDetailsPage.getFullScreenPropertyAddress(),"Property address is not matching");
				
		int imageCount = Integer.parseInt(utils.readTestData("propertyDimension","propertyDetails","numberOfImages"));
				
		 	for(int i=1;i<imageCount-4;i++) {
				Assert.assertNotNull(propertyDetailsPage.checkFullScreenPropertyImage(), "Property Details Page - Full screen view propertyimage is not present");
				propertyDetailsPage.doubleTapOnPropertyImage();
				Assert.assertEquals(propertyDetailsPage.getfullScreenImageCounter(), i+"/"+imageCount);
				propertyDetailsPage.swipeFullScreenImageCarouselLeftMultipleTimes();
				Assert.assertEquals(propertyDetailsPage.getfullScreenImageCounter(), (i+1)+"/"+imageCount);
			}
				
			for(int i=2;i>1;i--) {	
				propertyDetailsPage.swipeFullScreenImageCarouselRight();
				Assert.assertNotNull(propertyDetailsPage.checkFullScreenPropertyImage(), "Property Details Page - Full screen view propertyimage is not present");
				propertyDetailsPage.doubleTapOnPropertyImage();
				Assert.assertEquals(propertyDetailsPage.getfullScreenImageCounter(), i+"/"+imageCount);
				propertyDetailsPage.swipeFullScreenImageCarouselRight();
				Assert.assertEquals(propertyDetailsPage.getfullScreenImageCounter(), (i-1)+"/"+imageCount);
			}
				
				
		}
	
	@TestDetails(story1 = "DMPM-4151:DMPM-5587,DMPM-5588", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Property Hub", "priority-minor" })
	public void testDisplayPointOfInterestCategories() {
		navigateToPropertyDetails("StartYourJourney","HighConfident");
		propertyDetailsPage.scrollToWhatsNearButton();
		Assert.assertNotNull(propertyDetailsPage.checkMiniMap(), "Property Explorer Page - Mini Map not present");
		
		propertyExplorerPage.tapMiniMapWhatsNearByButton();
		Assert.assertNotNull(propertyFullScreenMap.checkFullScreenMapPin(), "Property Explorer Page - Full screen map pin is not present");
		Assert.assertTrue(propertyFullScreenMap.isPropertyTabSelected(), "Whats nearby Page - Property tab is not selected by default");
		
		Assert.assertNotNull(propertyFullScreenMap.checkEducationTab(), "Whats nearby Page - Education tab is not present");
		propertyFullScreenMap.tapEducationTab();
		Assert.assertTrue(propertyFullScreenMap.checkElementWithAccessibilityID(Copy.FULL_SCREEN_MAP_EDUCATION_CENTRE_INDICATOR), "Whats nearby Page - Education centre indicator is not present");
		
		Assert.assertNotNull(propertyFullScreenMap.checkShoppingTab(), "Whats nearby Page - Shopping tab is not present");
		propertyFullScreenMap.tapShoppingTab();
		Assert.assertTrue(propertyFullScreenMap.checkElementWithAccessibilityID(Copy.FULL_SCREEN_MAP_SHOPPING_AMENITY_INDICATOR), "Whats nearby Page - Shopping Amenity Indicator is not present");
		
		Assert.assertNotNull(propertyFullScreenMap.checkTransportTab(), "Whats nearby Page - Transport tab is not present");
		propertyFullScreenMap.tapTransportTab();
		Assert.assertTrue(propertyFullScreenMap.checkElementWithAccessibilityID(Copy.FULL_SCREEN_MAP_TRANSPORT_AMENITY_INDICATOR), "Whats nearby Page - transport Amenity Indicator is not present");
	
		Assert.assertNotNull(propertyFullScreenMap.checkEntertainmentTab(), "Whats nearby Page - Entertainment tab is not present");
		propertyFullScreenMap.tapEntertainmentTab();
		Assert.assertTrue(propertyFullScreenMap.checkElementWithAccessibilityID(Copy.FULL_SCREEN_MAP_ENTERTAINMENTOUTLET_INDICATOR), "Whats nearby Page - Entertainment Amenity Indicator is not present");
		
		Assert.assertNotNull(propertyFullScreenMap.checkHealthTab(), "Whats nearby Page - Health tab is not present");
		propertyFullScreenMap.tapHealthTab();
		Assert.assertTrue(propertyFullScreenMap.checkElementWithAccessibilityID(Copy.FULL_SCREEN_MAP_HEALTH_CENTRE_INDICATOR), "hats nearby Page - Health Amenity Indicator is not present");
		
		Assert.assertNotNull(propertyFullScreenMap.checkDiningTab(), "Whats nearby Page - Dining tab is not present");
		propertyFullScreenMap.tapDiningTab();
		Assert.assertTrue(propertyFullScreenMap.checkElementWithAccessibilityID(Copy.FULL_SCREEN_MAP_DINING_CENTRE_INDICATOR), "Whats nearby Page - Dining amenity Indicator is not present");
		
		Assert.assertNotNull(propertyFullScreenMap.checkOtherTab(), "Whats nearby Page - Dining tab is not present");
		propertyFullScreenMap.tapOtherTab();
		Assert.assertTrue(propertyFullScreenMap.checkElementWithAccessibilityID(Copy.FULL_SCREEN_MAP_OTHER_AMENITY_INDICATOR), "Whats nearby Page - Other Amenity Indicator is not present");
		
		
	}
	
	@TestDetails(story1 = "DMPM-3663:DMPM-5577,DMPM-5578,DMPM-5579,", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Property Hub", "priority-minor" })
	public void testDisplayOptionToSaveProperty() {
		navigateToPropertyDetails("StartYourJourney","HighConfident");
		Assert.assertNotNull(propertyDetailsPage.checkThisIsMyPropertyLabel(), "Property details page - This is my property label is not present");
		Assert.assertNotNull(propertyDetailsPage.checkThisIsMyPropertyInfo(), "Property details page - This is my property info icon is not present");
		Assert.assertNotNull(propertyDetailsPage.checkThisIsMyPropertyToggleButton(), "Property details page - This is my property toggle button is not present");
		Assert.assertEquals(propertyDetailsPage.getThisIsMyPropertyLabel(), Copy.PROPERTY_DETAILS_THIS_IS_MY_PROPERTY_LABEL,"this is my property label is not matching");
		
		propertyDetailsPage.tapThisIsMyPropertyToggleButton();
		Assert.assertNotNull(propertyDetailsPage.checkMyPropertyBottomSheetTitleLabel(), "Property details page - This is my property label is not present");
		Assert.assertNotNull(propertyDetailsPage.checkMyPropertyBottomSheetOwnerOccupierButton(), "Property details page - This is my property label is not present");
		Assert.assertNotNull(propertyDetailsPage.checkMyPropertyBottomSheetRenterButton(), "Property details page - This is my property info icon is not present");
		Assert.assertNotNull(propertyDetailsPage.checkMyPropertyBottomSheetLandLordButton(), "Property details page - This is my property toggle button is not present");
		Assert.assertEquals(propertyDetailsPage.getMyPropertyBottomSheetTitleLabel(), Copy.PROPERTY_DETAILS_BOTTOM_SHEET_TITLE,"my property label is not matching in the bottom sheet");
		Assert.assertEquals(propertyDetailsPage.getMyPropertyBottomSheetOwnerOccupierButton(), Copy.PROPERTY_DETAILS_OWNER_OCCUPIER_BUTTON_TEXT,"my property label is not matching in the bottom sheet");
		Assert.assertEquals(propertyDetailsPage.getMyPropertyBottomSheetRenterButton(), Copy.PROPERTY_DETAILS_RENTER_BUTTON_TEXT,"my property label is not matching in the bottom sheet");
		Assert.assertEquals(propertyDetailsPage.getMyPropertyBottomSheetLandLordButton(), Copy.PROPERTY_DETAILS_LANDLORD_BUTTON_TEXT,"my property label is not matching in the bottom sheet");
		
		propertyDetailsPage.tapOutsideOfMyPropertyBottomSheet();
		Assert.assertNull(propertyDetailsPage.checkMyPropertyBottomSheetTitleLabel(), "Property details page - This is my property label still presents after cancelling the bottom sheet");
		Assert.assertFalse(propertyDetailsPage.isToggleButtonSelected(), "This is my property toggle button is selected even after dismissing the bottom sheet");
		
	}
	
	@TestDetails(story1 = "DMPM-4982:DMPM-5935,DMPM-5936", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Home buying journey", "priority-minor" })
	public void testViewPropertyProfessionalServices() {
		
		navigateToPropertyDetails("StartYourJourney","HighConfident");
		Assert.assertNotNull(propertyDetailsPage.checkEstimatedMarketValueLabel(), "Property Details page - Estimated market value label is not present");
		
		homePropertyPage.scrollToHomeProfessionalServicesButton();
		Assert.assertNotNull(homePropertyPage.checkHomeProfessionalServicesImage(), "Property Details page - Home professional services image is not present");
		Assert.assertNotNull(homePropertyPage.checkHomeProfessionalServicesTitle(), "Property Details page - Home professional services title is not present");
		Assert.assertEquals(homePropertyPage.getHomeProfessionalServicesTitle(), Copy.PROPERTY_HUB_HOME_PROFESSIONAL_SERVICES_TITLE,"Property Details page - Home professional services title is not matching");
		Assert.assertNotNull(homePropertyPage.checkHomeProfessionalServicesDescription(), "Property Details page - Home professional services description is not present");
		Assert.assertEquals(homePropertyPage.getHomeProfessionalServicesDescription(), Copy.PROPERTY_HUB_HOME_PROFESSIONAL_SERVICES_DESCRIPTION,"Property Details page - Home professional services description is not matching");
		Assert.assertNotNull(homePropertyPage.checkHomeProfessionalServicesButton(), "Property Details page - Home professional services button is not present");
		
		homePropertyPage.tapHomeProfessionalServicesButton();
		if(webviewPage.checkPopUp()!=null) {
			webviewPage.tapWebViewPopup();
		}
		Assert.assertNotNull(webviewPage.checkWebViewLocationBarr(), "Web View Page - Web View location bar is not present");
		Assert.assertEquals(webviewPage.getWebViewLocationBar(), Copy.LOCATION_BAR_TEXT,"Property Details page - Home professional services Location bar URL is not matching");
		
		Assert.assertNotNull(webviewPage.checkViewToolbarOptions(), "Web View Page - Web View toolbar options is not present");
		webviewPage.tapWebViewToolbarOprions();
		
		Assert.assertNotNull(webviewPage.checkWebViewAddToBookMarkButton(), "Web View Page - Web View add to bookmark button is not present");
		webviewPage.tapWebViewAddToBookMarkButton();
		
		Assert.assertEquals(webviewPage.getWebViewWebAddress(), Copy.PROPERTY_HUB_HOME_PROFESSIONAL_SERVICES_URL,"Property Details page - Home professional services URL is not matching");	
	}
	
	@TestDetails(story1 = "DMPM-4844:DMPM-5915,DMPM-5926", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Property Hub", "priority-minor" })
	public void testHideFeaturesWhenItIsNotAvailable() {
		navigateToPropertyDetails("StartYourJourney","HighConfident");
		Assert.assertNotNull(propertyDetailsPage.checkEstimatedMarketValueLabel(), "Property Details page - Estimated market value label is not present");
		
		//when there are no bedrooms, bedrooms counter and image should be hidden( update stubs as bedrooms = 0)
		Assert.assertNull(propertyDetailsPage.checkPropertyNumberOfBedroomsImage(), "Property Details page - Bedroom image is present");
		Assert.assertNull(propertyDetailsPage.checkPropertyNumberOfBedrooms(), "Property Details page - Bedroom count is present");
		propertyDetailsPage.tapAndroidDeviceBackButton();
		
		//when there are no bathrooms, bathrooms counter and image should be hidden( update stubs as bathrooms = 0)
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","enterAdress"));
		propertyExplorerPage.tapSearch();
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
		Assert.assertNull(propertyDetailsPage.checkPropertyNumberOfBathroomsImage(), "Property Details page - bathroom image is present");
		Assert.assertNull(propertyDetailsPage.checkPropertyNumberOfBathrooms(), "Property Details page - bathroom count is present");
		propertyDetailsPage.tapAndroidDeviceBackButton();
		
		//when there are no parking spaces, parking spaces counter and image should be hidden( update stubs as parking spaces = 0)
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","enterAdress"));
		propertyExplorerPage.tapSearch();
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
		Assert.assertNull(propertyDetailsPage.checkPropertyNumberOfParkingSpacesImage(), "Property Details page - parking spaces image is present");
		Assert.assertNull(propertyDetailsPage.checkPropertyNumberOfParkingSpaces(), "Property Details page - parking spaces count is present");
		propertyDetailsPage.tapAndroidDeviceBackButton();	
		
		//when there are no land size, land size and land size image should be hidden( update stubs as land size = 0)
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","enterAdress"));
		propertyExplorerPage.tapSearch();
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
		Assert.assertNull(propertyDetailsPage.checkPropertyLandSize(), "Property Details page -land size is present");
		Assert.assertNull(propertyDetailsPage.checkPropertyLandSizeImage(), "Property Details page - land size image is present");
		propertyDetailsPage.tapAndroidDeviceBackButton();
		
		//when there are no bedrooms, no bathrooms, no car spaces and no land size in the API, attribute bar should be hidden( update stubs as bed rooms, bath rooms, car spaces and land size = 0)
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","enterAdress"));
		propertyExplorerPage.tapSearch();
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
		Assert.assertNull(propertyDetailsPage.checkAttributeBar(), "Property Details page -land size is present");
		
	}
	
			
	public void navigateToPropertyDetails(String navigationPath, String confidenceLevel) {
		
		loginToApp(utils.readTestData("propertyDimension","propertyProducts","withProducts", "login"), utils.readTestData("propertyDimension", "propertyProducts","withProducts","pwd"));
		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
		homePropertyPage.scrollToJourneyBanner();
		homePropertyPage.tapStartYourJourneyButton();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - page title not shown");
		if(confidenceLevel.equals("HighConfident")) {
			propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","highConfidenceAddress"));
			
		}else {
			propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","enterAdress"));
		}
			
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
