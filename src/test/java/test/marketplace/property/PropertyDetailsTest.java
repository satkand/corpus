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
		Assert.assertEquals(propertyDetailsPage.getPropertyAddress().trim(), utils.readTestData("propertyDimension","propertyDetails","address"),"Property Address is not matching");
		
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
		Assert.assertEquals(propertyDetailsPage.getSuburbInsightDescription(), "View local demographic data and insurance risks of any suburb. Plus explore the range of local features and amenities.");
		Assert.assertNotNull(propertyDetailsPage.checkSuburbInsightTitleText(), "Property Details Page - Suburb Insight title text is not present");
		Assert.assertEquals(propertyDetailsPage.getSuburbInsightTitleText(), "Suburb insights","Suburb insight title text is not matching");

		Assert.assertNotNull(propertyDetailsPage.checkSuburbInsightImage(), "Property Details Page -suburn insight image is not present");
		
		propertyDetailsPage.tapShowMeInsightButton();
		Assert.assertNotNull(suburbDetailsPage.checkRiskAndHazardTitleText(), "Property Details Page -suburn insight image is not present");
		
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
		//TODO : Removed as part of story DMPM-7240
		//Assert.assertNotNull(propertyDetailsPage.checkFavouriteButton(), "Property Details Page - Favorite button is not present");
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
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Favorite button is not present when coming back from full screen view");
		
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
		
		Assert.assertNull(propertyDetailsPage.checkFullScreenImageCounter(), "Property Details Page - Property Image displays");
		if(propertyDetailsPage.checkConfidenceLevelLabel()!=null) {
			propertyDetailsPage.tapBackButton();
		}
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - page title not shown");
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","enterAdress"));
		//propertyExplorerPage.tapSearch();
		propertyExplorerPage.checkFirstItemIntheSearchDropdown();
		propertyExplorerPage.tapFirstItemIntheSearchDropdown();

		Assert.assertEquals(propertyDetailsPage.getEstimatedMarketValue(), utils.readTestData("propertyDimension","propertyDetailsHighConfidence","estimatedMarketValue"),"Estimated market value is not displayed");
		Assert.assertEquals(propertyDetailsPage.getConfidenceLevelLabel(), utils.readTestData("propertyDimension","propertyDetailsHighConfidence","confidenceLevel"),"Confidence level label is not displayed");

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
		Assert.assertNotNull(whatsNearbyPage.checkFullScreenMapPin(), "Property Explorer Page - Full screen map pin is not present");
		Assert.assertNotNull(whatsNearbyPage.checkFullScreenMapTitle(), "Property Explorer Page - Full screen map title is not present");
		Assert.assertNotNull(whatsNearbyPage.checkFullScreenMapCloseButton(), "Property Explorer Page - Full screen map pin is not present");
		
		whatsNearbyPage.tapFullScreenMapCloseButton();
		Assert.assertNotNull(propertyDetailsPage.checkMiniMap(), "Property Explorer Page - Mini Map not present");
		
		propertyExplorerPage.tapMiniMap();
		Assert.assertNotNull(whatsNearbyPage.checkFullScreenMapPin(), "Property Explorer Page - Full screen map pin is not present");
		Assert.assertNotNull(whatsNearbyPage.checkFullScreenMapTitle(), "Property Explorer Page - Full screen map pin is not present");
		Assert.assertNotNull(whatsNearbyPage.checkFullScreenMapCloseButton(), "Property Explorer Page - Full screen map pin is not present");
		
		whatsNearbyPage.tapFullScreenMapCloseButton();
		Assert.assertNotNull(propertyDetailsPage.checkMiniMap(), "Property Explorer Page - Mini Map not present");
		
		}
	
	@TestDetails(story1 = "DMPM-3988:DMPM-4470,DMPM-4471", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Property Hub", "priority-minor" })
	public void testDoubleTapToZoominAndOutPropertyImages() throws InterruptedException {
						
		navigateToPropertyDetails("StartYourJourney","MediumConfident");
		Assert.assertNotNull(propertyDetailsPage.checkPropertyImage(), "Property Details Page - Property image is not present");
		String propertyAddress = propertyDetailsPage.getPropertyAddress();
		
		propertyDetailsPage.tapPropertyImage();
		Assert.assertNotNull(propertyDetailsPage.checkFullScreenPropertyAddress(), "Property Details Page - Full screen property address is not present");
		Assert.assertEquals(propertyAddress,propertyDetailsPage.getFullScreenPropertyAddress(),"Property address is not matching");
		
		int imageCount = Integer.parseInt(utils.readTestData("propertyDimension","propertyDetails","numberOfImages"));
		int countContinue = 0;
		 	for(int i=1;i<3;i++) {
				Assert.assertNotNull(propertyDetailsPage.checkFullScreenPropertyImage(), "Property Details Page - Full screen view propertyimage is not present");
				Assert.assertNotNull(propertyDetailsPage.checkFullScreenImageCounter(), "Property Details Page - Full screen image counter is not present");
				
				propertyDetailsPage.doubleTapOnPropertyImage();
				Assert.assertEquals(propertyDetailsPage.getfullScreenImageCounter(), i+"/"+imageCount);
				propertyDetailsPage.swipeFullScreenImageCarouselLeftMultipleTimes();
				Assert.assertEquals(propertyDetailsPage.getfullScreenImageCounter(), (i+1)+"/"+imageCount);
				countContinue = i;
			}
				
			for(int i=countContinue;i>1;i--) {	
				propertyDetailsPage.swipeFullScreenImageCarouselRight();
				Assert.assertNotNull(propertyDetailsPage.checkFullScreenPropertyImage(), "Property Details Page - Full screen view propertyimage is not present");
				Assert.assertNotNull(propertyDetailsPage.checkFullScreenImageCounter(), "Property Details Page - Full screen image counter is not present");
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
		Assert.assertNotNull(whatsNearbyPage.checkFullScreenMapPin(), "Property Explorer Page - Full screen map pin is not present");
		Assert.assertTrue(whatsNearbyPage.isPropertyTabSelected(), "Whats nearby Page - Property tab is not selected by default");
		
		Assert.assertNotNull(whatsNearbyPage.checkEducationTab(), "Whats nearby Page - Education tab is not present");
		whatsNearbyPage.tapEducationTab();
		//TODO remove comment and update the education indicator element when API is integrated
//		Assert.assertNotNull(whatsNearbyPage.checkEducationCentreIndicator(), "Whats nearby Page - Education centre indicator is not present");
		
		Assert.assertNotNull(whatsNearbyPage.checkShoppingTab(), "Whats nearby Page - Shopping tab is not present");
		whatsNearbyPage.tapShoppingTab();
		//TODO
//		Assert.assertNotNull(whatsNearbyPage.checkShoppingAmenityIndicator(), "Whats nearby Page - Shopping Amenity Indicator is not present");
		
		Assert.assertNotNull(whatsNearbyPage.checkTransportTab(), "Whats nearby Page - Transport tab is not present");
		whatsNearbyPage.tapTransportTab();
		//TODO
//		Assert.assertNotNull(whatsNearbyPage.checkTransportAmenityIndicator(), "Whats nearby Page - transport Amenity Indicator is not present");
	
		Assert.assertNotNull(whatsNearbyPage.checkEntertainmentTab(), "Whats nearby Page - Entertainment tab is not present");
		whatsNearbyPage.tapEntertainmentTab();
		//TODO
//		Assert.assertNotNull(whatsNearbyPage.checkEntertainmentOutletIndicator(), "Whats nearby Page - Entertainment Amenity Indicator is not present");
		
		Assert.assertNotNull(whatsNearbyPage.checkHealthTab(), "Whats nearby Page - Health tab is not present");
		whatsNearbyPage.tapHealthTab();
		//TODO
//		Assert.assertNotNull(whatsNearbyPage.checkHealthCentreIndicator(), "Whats nearby Page - Health Amenity Indicator is not present");
		
		Assert.assertNotNull(whatsNearbyPage.checkDiningTab(), "Whats nearby Page - Dining tab is not present");
		whatsNearbyPage.tapDiningTab();
		//TODO
//		Assert.assertNotNull(whatsNearbyPage.checkDiningCentreIndicator(), "Whats nearby Page - Dining amenity Indicator is not present");
		
		Assert.assertNotNull(whatsNearbyPage.checkOtherTab(), "Whats nearby Page - Dining tab is not present");
		whatsNearbyPage.tapOtherTab();
		//TODO
//		Assert.assertNotNull(whatsNearbyPage.checkOtherAmenityIndicator(), "Whats nearby Page - Other Amenity Indicator is not present");

	}
	
	//TODO : Removed as part of story DMPM-7240 for R3
	// TODO: R3 Release
/*	@TestDetails(story1 = "DMPM-3663:DMPM-5577,DMPM-5578,DMPM-5579,DMPM-7240", priority = Priority.LOW)
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
		
	}*/
	
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
		if(webviewPage.checkWebViewLocationBarr()!=null) {
		Assert.assertNotNull(webviewPage.checkViewToolbarOptions(), "Web View Page - Web View toolbar options is not present");
		webviewPage.tapWebViewToolbarOprions();
		
		Assert.assertNotNull(webviewPage.checkWebViewAddToBookMarkButton(), "Web View Page - Web View add to bookmark button is not present");
		webviewPage.tapWebViewAddToBookMarkButton();
		
		Assert.assertEquals(webviewPage.getWebViewWebAddress(), Copy.PROPERTY_HUB_HOME_PROFESSIONAL_SERVICES_URL,"Property Details page - Home professional services URL is not matching");	
		
		}
		
		if(webviewPage.checkUrlBar()!=null) {
			Assert.assertEquals(webviewPage.getTextUrlBar(), Copy.PROPERTY_HUB_HOME_PROFESSIONAL_SERVICES_URL,"Property Details page - Home professional services URL is not matching");	
			
		}
		
		
	}
	
	@TestDetails(story1 = "DMPM-4844:DMPM-5915,DMPM-5926", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Property Hub", "priority-minor" })
	public void testHideFeaturesWhenItIsNotAvailable() {
		navigateToPropertyDetails("StartYourJourney","");
		Assert.assertNotNull(propertyDetailsPage.checkEstimatedMarketValueLabel(), "Property Details page - Estimated market value label is not present");
		
		//when there are no bedrooms, bedrooms counter and image should be hidden( update stubs as bedrooms = 0)
		Assert.assertNull(propertyDetailsPage.checkPropertyNumberOfBedroomsImage(), "Property Details page - Bedroom image is present");
		Assert.assertNull(propertyDetailsPage.checkPropertyNumberOfBedrooms(), "Property Details page - Bedroom count is present");
		propertyDetailsPage.tapAndroidDeviceBackButton();
		
		//when there are no bathrooms, bathrooms counter and image should be hidden( update stubs as bathrooms = 0)
		propertyExplorerPage.enterTextInPropertyHubSearchbox("l1 328 KINGSWAY");
		//propertyExplorerPage.tapSearch();
		propertyExplorerPage.checkFirstItemIntheSearchDropdown();
		propertyExplorerPage.tapFirstItemIntheSearchDropdown();
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
		Assert.assertNull(propertyDetailsPage.checkPropertyNumberOfBathroomsImage(), "Property Details page - bathroom image is present");
		Assert.assertNull(propertyDetailsPage.checkPropertyNumberOfBathrooms(), "Property Details page - bathroom count is present");
		propertyDetailsPage.tapAndroidDeviceBackButton();
		
		//when there are no parking spaces, parking spaces counter and image should be hidden( update stubs as parking spaces = 0)
		propertyExplorerPage.enterTextInPropertyHubSearchbox("l1 328 KINGSWAY");
		//propertyExplorerPage.tapSearch();
		propertyExplorerPage.checkFirstItemIntheSearchDropdown();
		propertyExplorerPage.tapFirstItemIntheSearchDropdown();
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
		Assert.assertNull(propertyDetailsPage.checkPropertyNumberOfParkingSpacesImage(), "Property Details page - parking spaces image is present");
		Assert.assertNull(propertyDetailsPage.checkPropertyNumberOfParkingSpaces(), "Property Details page - parking spaces count is present");
		propertyDetailsPage.tapAndroidDeviceBackButton();	
		
		//when there are no land size, land size and land size image should be hidden( update stubs as land size = 0)
		//TODO : till find a property in land size 0 
/*		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","enterAdress"));
		//propertyExplorerPage.tapSearch();
		propertyExplorerPage.checkFirstItemIntheSearchDropdown();
		propertyExplorerPage.tapFirstItemIntheSearchDropdown();
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
		Assert.assertNull(propertyDetailsPage.checkPropertyLandSize(), "Property Details page -land size is present");
		Assert.assertNull(propertyDetailsPage.checkPropertyLandSizeImage(), "Property Details page - land size image is present");
		propertyDetailsPage.tapAndroidDeviceBackButton();
	*/	
		//when there are no bedrooms, no bathrooms, no car spaces and no land size in the API, attribute bar should be hidden( update stubs as bed rooms, bath rooms, car spaces and land size = 0)
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","enterAdress"));
		//propertyExplorerPage.tapSearch();
		propertyExplorerPage.checkFirstItemIntheSearchDropdown();
		propertyExplorerPage.tapFirstItemIntheSearchDropdown();
		
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
		
	}
	
	@TestDetails(story1 = "DMPM-4982:DMPM-5935,DMPM-5936", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Home buying journey", "priority-minor" })
	public void testViewEducationCentresNearToTheProperty() {
		int numberOFSchools = 3;
		navigateToPropertyDetails("StartYourJourney","HighConfident");
		Assert.assertNotNull(propertyDetailsPage.checkEstimatedMarketValueLabel(), "Property Details page - Estimated market value label is not present");
		
		propertyDetailsPage.scrollToProfessionalServicesImage();
		Assert.assertNotNull(propertyDetailsPage.checkNearbyEducationTitle(), "Property Details Page - Nearby Education centres title is not displayed");
		Assert.assertNotNull(propertyDetailsPage.checkNearbyEducationViewAllButton(), "Property Details Page - Nearby Education centres, VIEW ALL button is not displayed");
		Assert.assertNotNull(propertyDetailsPage.checkNearbyEducationCentres(), "Property Details Page - Nearby Education centres are not displayed");
		Assert.assertEquals(propertyDetailsPage.fetchNearbyEducationCentres().size(),numberOFSchools,"Property Details page - Number of schools is not matching");
		
		Assert.assertEquals(propertyDetailsPage.fetchNearbyEducationCentres().get(0).getText(),utils.readTestData("propertyDimension","propertyDetailsHighConfidence","nearbySchool1") ,"Property Details page - School 1 name is not matching");
		Assert.assertEquals(propertyDetailsPage.fetchNearbyEducationCentres().get(1).getText(),utils.readTestData("propertyDimension","propertyDetailsHighConfidence","nearbySchool2") ,"Property Details page - School 2 name is not matching");
		Assert.assertEquals(propertyDetailsPage.fetchNearbyEducationCentres().get(2).getText(),utils.readTestData("propertyDimension","propertyDetailsHighConfidence","nearbySchool3") ,"Property Details page - School 2 name is not matching");
		
		propertyDetailsPage.tapNearbyEducationViewAllButton();
		Assert.assertNotNull(whatsNearbyPage.checkEducationTab(), "Whats nearby page - Education tab is not selected");
		Assert.assertTrue(whatsNearbyPage.isEducationTabSelected(), "Whats nearby page - Education tab is not selected");
		Assert.assertNotNull(whatsNearbyPage.checkFullScreenMap(), "Whats nearby page - Full screen map is not displayed");
		
		
	}
	
	@TestDetails(story1 = "DMPM-3702:DMPM-7931,DMPM-7933,DMPM-7953", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Property hub", "priority-minor" })
	public void testViewVirtualPropertyScreenDisclaimers() {
		
		//TODO: R3 Release
		//navigateToVirtualPropertyDetails();
		navigateToPropertyDetails("StartYourJourney","HighConfident");
		Assert.assertNotNull(propertyDetailsPage.checkEstimatedPropertyValueDisclaimer(), "Property Details page - Estimated property value disclaimer is not present");
		Assert.assertNotNull(propertyDetailsPage.checkCoreLogicDisclaimer(), "Property Details page - core logic disclaimer is not present");
		Assert.assertNotNull(propertyDetailsPage.checkConfidenceLevelDisclaimer(), "Property Details page - Confidence level disclaimer is not present");
		
		propertyDetailsPage.tapConfidenceLevelDisclaimer();
		Assert.assertNotNull(propertyDetailsPage.checkConfidenceLevelDisclaimerScreenTitle(), "Property Details page - Confidence disclaimer title is not present");
		Assert.assertNotNull(propertyDetailsPage.checkDisclaimerClose(), "Property Details page - Confidence disclaimer title is not present");
		Assert.assertEquals(propertyDetailsPage.getConfidenceLevelDisclaimerScreenTitle(),"Estimated property value/AVM confidence measures","Property Details page - School 1 name is not matching");
		propertyDetailsPage.tapDisclaimerClose();
		
		propertyDetailsPage.tapCoreLogicDisclaimer();
		Assert.assertNotNull(propertyDetailsPage.checkCoreLogicDisclaimerScreenTitle(), "Property Details page - Confidence disclaimer title is not present");
		Assert.assertNotNull(propertyDetailsPage.checkDisclaimerClose(), "Property Details page - Confidence disclaimer title is not present");
		Assert.assertEquals(propertyDetailsPage.getCoreLogicDisclaimer(),"Data provided by CoreLogic","Property Details page - School 1 name is not matching");
		propertyDetailsPage.tapDisclaimerClose();
		
		propertyDetailsPage.tapEstimatedPropertyValueDisclaimer();
		Assert.assertNotNull(propertyDetailsPage.checkEstimatedPropertyValueDisclaimerScreenTitle(), "Property Details page - Confidence disclaimer title is not present");
		Assert.assertNotNull(propertyDetailsPage.checkDisclaimerClose(), "Property Details page - Confidence disclaimer title is not present");
		Assert.assertEquals(propertyDetailsPage.getEstimatedPropertyValueDisclaimerScreenTitle(),"Estimated property value","Property Details page - School 1 name is not matching");
		propertyDetailsPage.tapDisclaimerClose();
		
		propertyDetailsPage.tapLastSaleDisclaimer();
		Assert.assertNotNull(propertyDetailsPage.checkLastSaleDisclaimerScreenTitle(), "Property Details page - Confidence disclaimer title is not present");
		Assert.assertNotNull(propertyDetailsPage.checkDisclaimerClose(), "Property Details page - Confidence disclaimer title is not present");
		Assert.assertEquals(propertyDetailsPage.getLastSaleDisclaimerScreenTitle(),"Last sale","Property Details page - School 1 name is not matching");
		propertyDetailsPage.tapDisclaimerClose();
		
		//TODO: R3 Release
		/*propertyDetailsPage.tapThisIsMyPropertyInfo();
		Assert.assertNotNull(propertyDetailsPage.checkThisIsMyPropertyDisclaimerScreenTitle(), "Property Details page - Confidence disclaimer title is not present");
		Assert.assertNotNull(propertyDetailsPage.checkDisclaimerClose(), "Property Details page - Confidence disclaimer title is not present");
		Assert.assertEquals(propertyDetailsPage.getThisIsMyPropertyDisclaimerScreenTitle(),"Last sale","Property Details page - School 1 name is not matching");
		propertyDetailsPage.tapDisclaimerClose();*/
		
	
	}
			
	public void navigateToPropertyDetails(String navigationPath, String confidenceLevel) {
		
		loginToApp(utils.readTestData("propertyDimension","propertyProducts","withProducts", "login"), utils.readTestData("propertyDimension", "propertyProducts","withProducts","pwd"));
		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
		Assert.assertNotNull(homePropertyPage.checkaddressLineText(), "Home Journey Page - Property Address is not shown");
		//homePropertyPage.scrollToJourneyBanner();
		//homePropertyPage.tapStartYourJourneyButton();
		homePropertyPage.scrollToLaunchPropertyExplorer();
		homePropertyPage.taplaunchPropertyExplorer();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - page title not shown");
		if(confidenceLevel.equals("HighConfident")) {
			propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","highConfidenceAddress"));
			
		}else if(confidenceLevel.equals("MediumConfident")){
			propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","enterAdress"));
		}else {
			propertyExplorerPage.enterTextInPropertyHubSearchbox("l1 328 kingsway");
		}
		//propertyExplorerPage.tapSearch();
		propertyExplorerPage.checkFirstItemIntheSearchDropdown();
		propertyExplorerPage.tapFirstItemIntheSearchDropdown();
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
			
		}
	
	public void navigateToVirtualPropertyDetails() {
		loginToApp(utils.readTestData("propertyDimension","propertyProducts","withProducts", "login"), utils.readTestData("propertyDimension", "propertyProducts","withProducts","pwd"));
		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
		homePropertyPage.scrollToVirtualAssetsCarousel();
		homePropertyPage.tapVirtualAssetViewDetailsButton();
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
		
	}
	
}
