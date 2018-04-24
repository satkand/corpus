package test.marketplace.property;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import automation.framework.common.CustomRetryListener;
import automation.framework.common.TestDetails;
import automation.framework.common.TestDetails.Priority;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;

import pages.App;

public class HomePropertyTest extends App {
	
	@Test (groups = {"DMPM-86", "DMPM-857", "marketplace", "Home buying journey", "priority-minor"})
	public void testHomePropertyPageElements() {
		navigateToHomePropertyTab("guest");
		
		homePropertyPage.scrollToJourneyBanner();
		Assert.assertNotNull(homePropertyPage.checkHomeJourneyBannerImage(), "Home Property Page - Home Journey Banner Image is not shown");
		Assert.assertEquals(homePropertyPage.getHomeJourneyBannerHeading(), utils.readTestData("copy", "homePropertyPage", "homeJourneyBannerHeading"), "Home Property Page - Home Journey Banner Heading text is not shown as expected");
		Assert.assertEquals(homePropertyPage.getHomeJourneyBannerDescription(), utils.readTestData("copy", "homePropertyPage", "homeJourneyBannerDescription"), "Home Property Page - Home Journey Banner Description text is not shown as expected");
		Assert.assertNotNull(homePropertyPage.checkStartYourJourneyButton(), "Home Property Page - Start your Journey button not shown on home tab");
	}
	
	// 86 - scenario
	// 503 - Scenario 1
	// navigating to home journey screen and again navigating back to home property screen
	//@Test (groups = {"DMPM-86", "DMPM-893", "DMPM-503", "DMPM-971", "marketplace", "Home buying journey", "priority-minor"})
	public void testNavigatingToHomeJourneyScreen() {
		navigateToHomePropertyTab("guest");
		homePropertyPage.scrollToJourneyBanner();
		homePropertyPage.tapStartYourJourneyButton();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - page title not shown");
		homeJourneyPage.tapBackButton();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
	}
	
	//Story 2627 - Scenario 1 (TC : DMPM-3504) and scenario 2 (TC: DMPM-3505)
	//Story 2620 - Scenario 2 (No Assets - Display my property assets - TC-DMPM-3548)
	// navigating to Property tap on add a property or policy button
	@Test (groups = {"DMPM-2627", "DMPM-3504","DMPM-3505","DMPM-2620","DMPM-3548", "marketplace", "Home buying journey", "priority-minor"})
	public void testAddAPropertyOrPolicy() {
		navigateToHomePropertyTab("noProperties");
		
		Assert.assertNull(homePropertyPage.checkaddressLineText(), "Home Property Page - Property Assets are displaying");
		Assert.assertNull(homePropertyPage.checksuburbText(), "Home Property Page - Property Assets are displaying");
		
		Assert.assertNotNull(homePropertyPage.checkAddAPropertyOrPolicyImage(), "Home Property Page - Image is not present in add property section");
		Assert.assertNotNull(homePropertyPage.checkAddAPropertyOrPolicyButton(), "Home Property Page - Add a Property or Policy button is not present");
		
		Assert.assertNotNull(homePropertyPage.checkPropertyInsightInfo(), "Home Property Page - Property insigh info is not present");
		Assert.assertEquals(homePropertyPage.getPropertyInsightInfo(), utils.readTestData("copy", "homePropertyPage", "propertyInsightInfo"), "Home Property Page - Property insight info is not shown as expected");
		
		Assert.assertNotNull(homePropertyPage.checkOrganiseDocumentsInfo(), "Home Property Page - Organise documents info is not present");
		Assert.assertEquals(homePropertyPage.getOrganiseDocumentsInfo(), utils.readTestData("copy", "homePropertyPage", "organiseDocumentsInfo"), "Home Property Page - Organise document info is not shown as expected");
		
		Assert.assertNotNull(homePropertyPage.checkAccessProfessionalInfo(), "Home Property Page - Access professional services and suburs info is not present");
		Assert.assertEquals(homePropertyPage.getAccessProfessionalInfo(), utils.readTestData("copy", "homePropertyPage", "accessProfessionalInfo"), "Home Property Page - Access Professional info is not shown as expected");
		
		homePropertyPage.tapAddAPropertyOrPolicyButton();
		Assert.assertNotNull(homePropertyPage.checkAddPropertyOrPolicyActionSheetTitle(), "Home Property Page - Add a property or Policy action sheet title is not present");
		Assert.assertEquals(homePropertyPage.getAddPropertyOrPolicyActionSheetTitle(), utils.readTestData("copy", "homePropertyPage", "addPropertyOrPolicyActionSheetTitle"), "Home Property Page - Property insight info is not shown as expected");
		Assert.assertNotNull(homePropertyPage.checkAddPolicyActionSheetButton(), "Home Property Page - Policy action sheet button is not present");
		Assert.assertNotNull(homePropertyPage.checkAddPropertyActionSheetButton(), "Home Property Page - Property action sheet button is not present");
		
		homePropertyPage.tapAddPolicyActionSheetButton();
		homePropertyPage.tapDeviceBackButton();
		Assert.assertNotNull(homePropertyPage.checkAddAPropertyOrPolicyButton(), "Home Property Page - Add a Property or Policy button is not present");
		
		homePropertyPage.tapAddAPropertyOrPolicyButton();
		homePropertyPage.tapAddPropertyActionSheetButton();
		homePropertyPage.tapDeviceBackButton();
		Assert.assertNotNull(homePropertyPage.checkAddAPropertyOrPolicyButton(), "Home Property Page - Add a Property or Policy button is not present");
		
		
	}
	
	//2646 - Scenario 1
	//2997 - scenario 1
	//2620 - scenario 1
	// navigating to Property tab and verify products
	@Test (groups = {"DMPM-2646", "DMPM-4037","DMPM-2997","DMPM-4014","DMPM-2620","DMPM-3541", "marketplace", "Home buying journey", "priority-minor"})
	public void testDisplayActiveProductsAssociatedWithAPropertyAsset() {
			
		navigateToHomePropertyTab("withProducts");

		Assert.assertNotNull(homePropertyPage.checkpropertyImage(), "Home Property Page - Property Asset image is not available");
		Assert.assertNotNull(homePropertyPage.checkaddressLineText(), "Home Property Page - Address Line is not present");
		Assert.assertNotNull(homePropertyPage.checksuburbText(), "Home Property Page - Suburb is not present");
		List<String> descriptionList = homePropertyPage.fetchProductDescriptionTextList();
		
		String addressLine = utils.readTestData("propertyDimension","propertyProducts","withProducts","addressLineText");
		String description1 = utils.readTestData("propertyDimension","propertyProducts","withProducts","productDescriptionText1");
		String description2 = utils.readTestData("propertyDimension","propertyProducts","withProducts","productDescriptionText2");
		String suburb = utils.readTestData("propertyDimension","propertyProducts","withProducts","suburbText");
					
		Assert.assertEquals(homePropertyPage.getaddressLineText(), addressLine, "Home Property Page - Address line is not shown as expected");
		Assert.assertEquals(homePropertyPage.getsuburbText(), suburb, "Home Property Page - Property suburb is not displayed as expected");
		Assert.assertEquals(descriptionList.get(0), description1, "Home Property Page - Property description1 is not displayed as expected");
		Assert.assertEquals(descriptionList.get(1), description2, "Home Property Page - Property description 2 is not displayed as expected");
				
		Assert.assertNotNull(homePropertyPage.checkactiveClaimTitle(), "Home Property Page - Active Claim status is not displaying");
		Assert.assertEquals(homePropertyPage.getactiveClaimTitle(),utils.readTestData("copy","homePropertyPage","activeClaim") , "Home Property Page - Active CLaim title is not displayed as expected");
		
	}
		
	//2646 - scenario 2 
	//2997 - scenario 2
	//3001 - scenario 5
	// navigating to Property tab and verify empty state for products
	@Test (groups = {"DMPM-2627","DMPM-4038","DMPM-2997","DMPM-4017","DMPM-4461", "marketplace", "Home buying journey", "priority-minor"})
		public void testDisplayEmptyStateForPropertyAsset() {
		
 		navigateToHomePropertyTab("withOutProducts");
 		
		homePropertyPage.scrollToEmptyStatePropertyAsset();
		Assert.assertNotNull(homePropertyPage.checkaddressLineText(), "Home Property Page - Address Line is not present");
		Assert.assertNotNull(homePropertyPage.checksuburbText(), "Home Property Page - Suburb is not present");
		Assert.assertNull(homePropertyPage.checkproductDescriptionText(), "Home Property Page - Product Description is present");
		Assert.assertNull(homePropertyPage.checkactiveClaimTitle(), "Home Property Page - Active CLaime title is present");
		
		/*TODO (3001 - scenario 5) below code needs to be run in API. In Stubs this will fail*/
		//homePropertyPage.scrollToVirtualAssetsCarousel();
		//Assert.assertNull(homePropertyPage.checkVirtualAssetsTitleTxt(), "Property Dimention Page - Virtual assets title is not present");
		//Assert.assertNull(homePropertyPage.checkVirtualAssetImage(), "Property Dimention Page - Virtual asset image is not present");
		
	}
	
	//3799 - scenario 1 (TC-DMPM-3506)
	//2620 - scenario 3 (TC-DMPM-3549)
	//Add a property or policy (Guest Experience)
	@Test (groups = {"DMPM-2799","DMPM-3506","DMPM-2620","DMPM-3549", "marketplace", "Home buying journey", "priority-minor"})
		public void testAddPolicyGuestExperience() {
			
		navigateToHomePropertyTab("guest");
		Assert.assertNull(homePropertyPage.checkaddressLineText(), "Home Property Page - Property Assets are displaying for guest user");
		Assert.assertNull(homePropertyPage.checksuburbText(), "Home Property Page - Property Assets are displaying for guest user");
		
		homePropertyPage.tapAddAPropertyOrPolicyButton();
		Assert.assertNotNull(homePropertyPage.checkFeatureLockedMsgTitle(), "Home Property Page - Feature Locked Title is not present");
		Assert.assertEquals(homePropertyPage.getFeatureLockedMsgTitle(), utils.readTestData("copy", "homePropertyPage","featureLockedMsgTitle"), "Home Property Page - Feature Locked message title is different to the expected title");
			
		Assert.assertNotNull(homePropertyPage.checkFeatureLockedTextCopy(), "Home Property Page - Feature Locked message copy is not present");
		Assert.assertEquals(homePropertyPage.getFeatureLockedTextCopy(), utils.readTestData("copy", "homePropertyPage","featureLockedTextCopy"), "Home Property Page - Feature Locked message text is different to the expected message");
		
		Assert.assertNotNull(homePropertyPage.checkFeatureLockedMsgSignUpButton(), "Home Property Page - Sign Up button is not present");
		Assert.assertNotNull(homePropertyPage.checkFeatureLockedMsgLogInButton(), "Home Property Page - Log in button is not present");
			
	}

	//3803 - scenario 1 (TC-DMPM-4712), Scenario 2 (TC-4714)
	//View my property assets details option from property dimension
	@Test (groups = {"DMPM-3803","DMPM-4712","DMPM-4714", "marketplace", "Property Dimension", "priority-minor"})
		public void testViewPropertyAssetsDetailsOption() {
		
		navigateToHomePropertyTab("withProducts");
		Assert.assertNotNull(homePropertyPage.checkPropertyDetailsButton(), "Home Property Page - Property details button is not present");
		
		homePropertyPage.tapPropertyDetailsButton();
		Assert.assertNotNull(propertyDetailsPage.checkDerivedAssetText(), "Property Details Page - Temporary screen for derived assets is not present");
		propertyDetailsPage.tapAndroidDeviceBackButton();
		
		homePropertyPage.tapPropertyImage();
		Assert.assertNotNull(propertyDetailsPage.checkDerivedAssetText(), "Property Details Page - Temporary screen for derived assets is not present");
		propertyDetailsPage.tapAndroidDeviceBackButton();
		
		homePropertyPage.tapAddressLineText();
		Assert.assertNotNull(propertyDetailsPage.checkDerivedAssetText(), "Property Details Page - Temporary screen for derived assets is not present");
		propertyDetailsPage.tapAndroidDeviceBackButton();
		
		homePropertyPage.scrollToSuppliedAsset();;
		homePropertyPage.tapPropertyDetailsButton();
		Assert.assertNotNull(propertyDetailsPage.checkSuppliedAssetText(), "Property Details Page - Temporary screen for Supplied assets is not present");
		propertyDetailsPage.tapAndroidDeviceBackButton();
		
		homePropertyPage.tapPropertyImage();
		Assert.assertNotNull(propertyDetailsPage.checkSuppliedAssetText(), "Property Details Page - Temporary screen for Supplied assets is not present");
		propertyDetailsPage.tapAndroidDeviceBackButton();
		
		homePropertyPage.tapAddressLineText();
		Assert.assertNotNull(propertyDetailsPage.checkSuppliedAssetText(), "Property Details Page - Temporary screen for Supplied assets is not present");

	}
	
	@TestDetails(story1 = "DMPM-3001:DMPM-4457,DMPM-4458,DMPM-4459,DMPM-4460", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Property Dimension", "priority-minor" })
	public void testDisplayVirtualAssets() {
		navigateToHomePropertyTab("noProperties");
		homePropertyPage.scrollToVirtualAssetsCarousel();
		Assert.assertNotNull(homePropertyPage.checkVirtualAssetsTitleTxt(), "Property Dimention Page - Virtual assets title is not present");
		Assert.assertEquals(homePropertyPage.getVirtualAssetsTitleTxt(), Copy.VIRTUAL_ASSETS_TITLE_TEXT, "Home Property Page - Your saved properties label is different to the expected label");
		
		Assert.assertNotNull(homePropertyPage.checkVirtualAssetImage(), "Property Dimention Page - Virtual asset image is not present");
		Assert.assertNotNull(homePropertyPage.checkVirtualAssetEstimatedSalesPriceLabel(), "Property Dimention Page - Virtual asset Estimated Sales Price Label is not present");
		Assert.assertEquals(homePropertyPage.getVirtualAssetEstimatedSalesPriceLabel(), Copy.VIRTUAL_ASSETS_ESTIMATED_SALES_PRICE_LABEL, "Home Property Page - Estimated sale price label is different to the expected title");
		Assert.assertNotNull(homePropertyPage.checkVirtualAssetSalePrice(), "Property Dimention Page - Virtual asset Sale Price is not present");
		Assert.assertEquals(homePropertyPage.getVirtualAssetSalePrice(),Copy.VIRTUAL_ASSETS_ESTIMATED_SALE_PRICE , "Home Property Page - Estimated sale price is different to the expected value");
		Assert.assertNotNull(homePropertyPage.checkVirtualAssetAddress(), "Property Dimention Page - Virtual asset adress is not present");
		Assert.assertEquals(homePropertyPage.getVirtualAssetAddress(), Copy.VIRTUAL_ASSETS_PROPERTY_ADDRESS, "Home Property Page - Address is different to the expected");
		
		Assert.assertNotNull(homePropertyPage.checkVirtualAssetBedroomIcon(), "Property Dimention Page - Virtual asset Bedroom Icon is not present");
		Assert.assertNotNull(homePropertyPage.checkVirtualAssetNoOFBedrooms(), "Property Dimention Page - Virtual asset number of bedrooms is not present");
		Assert.assertEquals(homePropertyPage.getVirtualAssetNoOFBedrooms(), Copy.VIRTUAL_ASSETS_PROPERTY_NO_OF_BEDROOMS, "Home Property Page - No of Bedrooms is different to the expected");
		Assert.assertNotNull(homePropertyPage.checkVirtualAssetNoOFBathrooms(), "Property Dimention Page - Virtual asset number of bathrooms is not present");
		Assert.assertEquals(homePropertyPage.getVirtualAssetNoOFBathrooms(), Copy.VIRTUAL_ASSETS_PROPERTY_NO_OF_BATHROOMS, "Home Property Page - No of Bathrooms is different to the expected");
		Assert.assertNotNull(homePropertyPage.checkVirtualAssetNoOFCarParks(), "Property Dimention Page - Virtual asset number of car parks is not present");
		Assert.assertEquals(homePropertyPage.getVirtualAssetNoOFCarParks(), Copy.VIRTUAL_ASSETS_PROPERTY_NO_OF_PARKING_SPACES, "Home Property Page - No of carparks is different to the expected");
		Assert.assertNotNull(homePropertyPage.checkVirtualAssetLandSize(), "Property Dimention Page - Virtual asset land size is not present");
		Assert.assertEquals(homePropertyPage.getVirtualAssetLandSize(), Copy.VIRTUAL_ASSETS_PROPERTY_LAND_SIZE, "Home Property Page - Land size is different to the expected");
		
		Assert.assertNotNull(homePropertyPage.checkVirtualAssetViewDetailsButton(), "Property Dimention Page - Virtual asset View Details button is not present");
		
		homePropertyPage.swipePropertyCarouselLeft();
		
		Assert.assertNotNull(homePropertyPage.checkVirtualAssetImage(), "Property Dimention Page - Virtual asset image is not present");
		Assert.assertNotNull(homePropertyPage.checkVirtualAssetEstimatedSalesPriceLabel(), "Property Dimention Page - Virtual asset Estimated Sales Price Label is not present");
		Assert.assertNotNull(homePropertyPage.checkVirtualAssetSalePrice(), "Property Dimention Page - Virtual asset Sale Price is not present");
		Assert.assertNotNull(homePropertyPage.checkVirtualAssetAddress(), "Property Dimention Page - Virtual asset adress is not present");
		
		Assert.assertNotNull(homePropertyPage.checkVirtualAssetViewDetailsButton(), "Property Dimention Page - Virtual asset View Details button is not present");
	
		homePropertyPage.swipePropertyCarouselRight();
		Assert.assertNotNull(homePropertyPage.checkVirtualAssetAddress(), "Property Dimention Page - Virtual asset adress is not present");
		Assert.assertEquals(homePropertyPage.getVirtualAssetAddress(), Copy.VIRTUAL_ASSETS_PROPERTY_ADDRESS, "Home Property Page - Address is different to the expected");
		
		homePropertyPage.tapVirtualAssetViewDetailsButton();
		
		//TODO - update these assertions for the particular property details. ATM this is only verifying page navigation to Property Details
		Assert.assertNotNull(propertyDetailsPage.checkThisIsMyPropertyLabel(), "Home property page Page - User is not navigated to Property details screen when clicks on View Details button");
		Assert.assertNotNull(propertyDetailsPage.checkEstimatedMarketValueLabel(), "Home property page Page - User is not navigated to Property details screen when clicks on View Details button");
		
		
	}
	
	@TestDetails(story1 = "DMPM-3025:DMPM-4454,DMPM-4455,DMPM-4456", priority = Priority.LOW)
	@Test(retryAnalyzer = CustomRetryListener.class, groups = { "marketplace", "Property Dimension", "priority-minor" })
	public void testDisplayOptionToShowPropertyAssetDocuments() {
		
		navigateToHomePropertyTab("withProducts");
		Assert.assertNotNull(homePropertyPage.checkPropertyDocumentsButton(), "Home property page -property documents button is not present");
		String propertyAddress = homePropertyPage.getaddressLineText().replace(",", "");
		
		
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkDigitalVaultMenuItem(), "Navigation menu - Digital Vault Menu button is not displayed");
		navigationMenu.tapDigitalVaultMenuItem();
		
		// fetch the folder names shown on the current page
		List<String> folders = digitalVaultPage.fetchFolderNameList();
		//iterate the folder list to find out delete the folder if it is already available in the list
		for(int i=0; i<folders.size();i++) {
			if(folders.get(i).toString().equals(propertyAddress)) {
				Assert.assertNotNull(digitalVaultPage.checkFolderMoreOption(), "Digital Vault page - Folder more option is not present");
				digitalVaultPage.swipeToDeleteFolder();
				Assert.assertNotNull(digitalVaultPage.checkBinBoxForFolder(), "Digital Vault page - Bin box button is not present");
				digitalVaultPage.tapBinBoxForFolder();
				Assert.assertNotNull(digitalVaultPage.checkDeleteFolderPopupButton(), "Digital Vault page - Delete folder popup button is not present");
				digitalVaultPage.tapDeleteFolderPopupButton();
				Assert.assertNotNull(digitalVaultPage.checkDeleteFolderConfirmationMsg(), "Digital Vault page - Delete folder popup button is not present");		
			}				
		}
		
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkSuncorpMenuItem(), "Navigation menu - One suncorp Menu button is not displayed");
		navigationMenu.tapSuncorpMenuItem();
		Assert.assertNotNull(homePropertyPage.checkPropertyDocumentsButton(), "Home Property page - property document button is not present");
		
		homePropertyPage.tapPropertyDocumentsButton();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder View page - Folder Title label is not present");
		Assert.assertNotNull(folderViewPage.checkEditButton(), "Folder View page - Edit button is not present");
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder View page - Edit button is not present");
		Assert.assertEquals(propertyAddress, folderViewPage.getTitle(),"Folder View Page - folder name is not matching with the property address");
		
		verifyDocumentsFolderName(propertyAddress);

		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkSuncorpMenuItem(), "Navigation menu - One suncorp Menu button is not displayed");
		navigationMenu.tapSuncorpMenuItem();
		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Landing page - Home tab is not selected on landing page");
		
		homePropertyPage.tapPropertyDocumentsButton();
		Assert.assertEquals(propertyAddress, folderViewPage.getTitle(),"Folder View Page - folder name is not matching with the property address");
		
		verifyDocumentsFolderName(propertyAddress);
	
	}
	
	@TestDetails(story1 = "DMPM-1263:DMPM-6016,DMPM-6017,DMPM-6018,DMPM-6019", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Property Hub", "priority-minor" })
	public void testVirtualAssetsPropertyCardInFullscreenMapView() {
		navigateToHomePropertyTab("noProperties");
		homePropertyPage.scrollToVirtualAssetsCarousel();
		Assert.assertNotNull(homePropertyPage.checkVirtualAssetsTitleTxt(), "Property Dimention Page - Virtual assets title is not present");
		Assert.assertEquals(homePropertyPage.getVirtualAssetsTitleTxt(), "Your saved properties", "Home Property Page - Your saved properties label is different to the expected label");
		Assert.assertNotNull(homePropertyPage.checkVirtualAssetViewDetailsButton(), "Property Dimention Page - Virtual assets title is not present");
		
		homePropertyPage.tapVirtualAssetViewDetailsButton();
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property details page - User is not navigated to Property details screen when clicks on View Details button in virtual property tile");
		
		String propertyAddress = propertyDetailsPage.getPropertyAddress()+", "+propertyDetailsPage.getPropertyStatePostCode().replace(",", "");
		String propertyType = propertyDetailsPage.getPropertyType();
	
		propertyDetailsPage.scrollToWhatsNearButton();
		propertyDetailsPage.tapMiniMapWhatsNearbyButton();
		Assert.assertNotNull(whatsNearbyPage.checkFullScreenMap(), "Whats nearby page - Fullscreen map is not displayed");
		Assert.assertNotNull(whatsNearbyPage.checkPropertyTab(), "Whats nearby page - User is not navigated to whats nearby screen when clicks on whats nearby button in minimap");
		Assert.assertTrue(whatsNearbyPage.isPropertyTabSelected(), "Property tab is not selected by default");
		
		whatsNearbyPage.tapFullScreenMapCloseButton();
		Assert.assertNotNull(propertyDetailsPage.checkMiniMap(), "Property details page - User is not navigated to Property details screen when clicks on View Details button in virtual property tile");
		
		propertyDetailsPage.tapMiniMap();
		Assert.assertNotNull(whatsNearbyPage.checkFullScreenMap(), "Whats nearby page - Fullscreen map is not displayed");
		Assert.assertNotNull(whatsNearbyPage.checkPropertyTab(), "WHats nearby page - User is not navigated to whats nearby screen when clicks on whats nearby button in minimap");
		Assert.assertTrue(whatsNearbyPage.isPropertyTabSelected(), "Property tab is not selected by default");
		
		Assert.assertNotNull(whatsNearbyPage.checkPropertyCardThumbnail(), "Whats nearby page - Property Card Thumbnail is not displayed");
		Assert.assertNotNull(whatsNearbyPage.checkPropertyCardTitle(), "Whats nearby page - Property card title is not displayed");
		Assert.assertNotNull(whatsNearbyPage.checkPropertyCardDetails(), "Whats nearby page - Property card details is not displayed");
		Assert.assertEquals(whatsNearbyPage.getPropertyCardTitle(), propertyAddress, "Whats nearby page - Title is different to the property address");
		Assert.assertEquals(whatsNearbyPage.getPropertyCardDetails(), propertyType, "Whats nearby page - Property type is different to the property address");
		
		whatsNearbyPage.tapFullScreenGoogleLabel();
		Assert.assertNull(whatsNearbyPage.checkOtherTab(), "Whats nearby page - Other tab is displayed");//This assert is used for time pass till the property card is disappeared 
		Assert.assertNull(whatsNearbyPage.checkPropertyCardThumbnail(), "Whats nearby page - Property Card Thumbnail is still displayed");
		Assert.assertNull(whatsNearbyPage.checkPropertyCardTitle(), "Whats nearby page - Property card title is still displayed");
		Assert.assertNull(whatsNearbyPage.checkPropertyCardDetails(), "Whats nearby page - Property card details is still displayed");
		
		whatsNearbyPage.tapFullScreenMapPropertyPin();
		Assert.assertNotNull(whatsNearbyPage.checkPropertyCardThumbnail(), "Whats nearby page - Property Card Thumbnail is not displayed");
		Assert.assertNotNull(whatsNearbyPage.checkPropertyCardTitle(), "Whats nearby page - Property card title is not displayed");
		Assert.assertNotNull(whatsNearbyPage.checkPropertyCardDetails(), "Whats nearby page - Property card details is not displayed");
		Assert.assertEquals(whatsNearbyPage.getPropertyCardTitle(), propertyAddress, "Whats nearby page - Title is different to the property address");
		Assert.assertEquals(whatsNearbyPage.getPropertyCardDetails(), propertyType, "Whats nearby page - Property type is different to the property address");
		
		whatsNearbyPage.tapPropertyCardThumbnail();
		Assert.assertNotNull(propertyDetailsPage.checkMiniMap(), "Property details page - User is not navigated to Property details screen when clicks on View Details button in virtual property tile");
		
		propertyDetailsPage.tapMiniMapWhatsNearbyButton();
		Assert.assertNotNull(whatsNearbyPage.checkPropertyCardTitle(), "Whats nearby page - Property card title is not displayed");
		
		whatsNearbyPage.tapPropertyCardTitle();
		Assert.assertNotNull(propertyDetailsPage.checkMiniMap(), "Property details page - User is not navigated to Property details screen when clicks on View Details button in virtual property tile");
				
	}
	
	
	
	private void verifyDocumentsFolderName(String folderName) {
		folderViewPage.tapBackButton();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "DigiVault title is not displayed");
		
		boolean isNameDuplicated = false;
		boolean isNameNotPresent = false;
		int count = 0;
		// fetch the folder names shown on the current page
		List<String> folderList = digitalVaultPage.fetchFolderNameList();
		
		//iterate the folder list to find out folder name is already available in the list
		for(int i=0; i<folderList.size();i++) {
			if(folderList.get(i).toString().equals(folderName)) {
				count = count+1;
			}				
		}
		
		if (count>1) {
			isNameDuplicated = true;
		}
		if (count<1) {
			isNameNotPresent = true;
		}
		
		Assert.assertFalse(isNameDuplicated, "Multiple folders were created for property "+folderName);
		Assert.assertFalse(isNameNotPresent, "Folder was not created for the property "+folderName);
	}

	private void navigateToHomePropertyTab(String loginType) {
		if(loginType.equals("withProducts")) {
			loginToApp(utils.readTestData("propertyDimension","propertyProducts","withProducts", "login"), utils.readTestData("propertyDimension", "propertyProducts","withProducts","pwd"));
		}else if(loginType.equals("noProperties")){
			loginToApp(utils.readTestData("propertyDimension","NoProperties", "login"), utils.readTestData("propertyDimension","NoProperties", "pwd"));
		}else if(loginType.equals("withOutProducts")){
			loginToApp(utils.readTestData("propertyDimension","propertyProducts","withOutProducts", "login"), utils.readTestData("propertyDimension","propertyProducts","withOutProducts", "pwd"));
		}else {
			welcomePage.tapGuestAccessButton();
		}
		
		landingPage.tapPropertyTab();
		Assert.assertTrue(landingPage.ispropertyTabSelected(), "Home tab is not selected on landing page");
	}
	

	
}
