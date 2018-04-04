package test.marketplace.property;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

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
	@Test (groups = {"DMPM-86", "DMPM-893", "DMPM-503", "DMPM-971", "marketplace", "Home buying journey", "priority-minor"})
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
	// navigating to Property tab and verify empty state for products
	@Test (groups = {"DMPM-2627","DMPM-4038","DMPM-2997","DMPM-4017", "marketplace", "Home buying journey", "priority-minor"})
		public void testDisplayEmptyStateForPropertyAsset() {
		
 		navigateToHomePropertyTab("withOutProducts");
		//enableFAPISettings();
		
		homePropertyPage.scrollToEmptyStatePropertyAsset();
		Assert.assertNotNull(homePropertyPage.checkaddressLineText(), "Home Property Page - Address Line is not present");
		Assert.assertNotNull(homePropertyPage.checksuburbText(), "Home Property Page - Suburb is not present");
		Assert.assertNull(homePropertyPage.checkproductDescriptionText(), "Home Property Page - Product Description is present");
		Assert.assertNull(homePropertyPage.checkactiveClaimTitle(), "Home Property Page - Active CLaime title is present");
		
		
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
		propertyDetailsPage.tapAndroidDeviceBackButton();

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
		
		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
	}
	
}
