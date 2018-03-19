package test.marketplace.home;

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
	
	//2627 - Scenario 1 and scenario 2
	// navigating to Property tap on add a property or policy button
	@Test (groups = {"DMPM-2627", "DMPM-3504","DMPM-3505", "marketplace", "Home buying journey", "priority-minor"})
	public void testAddAPropertyOrPolicy() {
		navigateToHomePropertyTab("noProperties");
		
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
	// navigating to Property tab and verify products
	@Test (groups = {"DMPM-2646", "DMPM-4037", "marketplace", "Home buying journey", "priority-minor"})
	public void testDisplayActiveProductsAssociatedWithAPropertyAsset() {
			
		navigateToHomePropertyTab("withProducts");
		enableFAPISettings();
		
		Assert.assertNotNull(homePropertyPage.checkaddressLineText(), "Home Property Page - Address Line is not present");
		Assert.assertNotNull(homePropertyPage.checksuburbText(), "Home Property Page - Suburb is not present");
		List<String> descriptionList = homePropertyPage.fetchProductDescriptionTextList();
		
		String addressLine = utils.readTestData("propertyDimention","propertyProducts","withProducts","addressLineText");
		String description1 = utils.readTestData("propertyDimention","propertyProducts","withProducts","productDescriptionText1");
		String description2 = utils.readTestData("propertyDimention","propertyProducts","withProducts","productDescriptionText2");
		String suburb = utils.readTestData("propertyDimention","propertyProducts","withProducts","suburbText");
					
		Assert.assertEquals(homePropertyPage.getaddressLineText(), addressLine, "Home Property Page - Property address is not shown as expected");
		Assert.assertEquals(homePropertyPage.getsuburbText(), suburb, "Home Property Page - Property suburb is not displayed as expected");
		Assert.assertEquals(descriptionList.get(0), description1, "Home Property Page - Property suburb is not displayed as expected");
		Assert.assertEquals(descriptionList.get(1), description2, "Home Property Page - Property suburb is not displayed as expected");
					
		
	}
		
	//2646 - scenario 2 
	// navigating to Property tab and verify empty state for products
	@Test (groups = {"DMPM-2627","DMPM-4038", "marketplace", "Home buying journey", "priority-minor"})
		public void testDisplayEmptyStateForPropertyAsset() {
		
 		navigateToHomePropertyTab("withOutProducts");
		enableFAPISettings();
		
		homePropertyPage.scrollToEmptyStatePropertyAsset();
		Assert.assertNotNull(homePropertyPage.checkaddressLineText(), "Home Property Page - Address Line is not present");
		Assert.assertNotNull(homePropertyPage.checksuburbText(), "Home Property Page - Suburb is not present");
		Assert.assertNull(homePropertyPage.checkproductDescriptionText(), "Home Property Page - Product Description is present");
		
		
	}
	
	private void navigateToHomePropertyTab(String loginType) {
		if(loginType.equals("withProducts")) {
			loginToApp(utils.readTestData("propertyDimention","propertyProducts","withProducts", "login"), utils.readTestData("propertyDimention", "propertyProducts","withProducts","pwd"));
		}else if(loginType.equals("noProperties")){
			loginToApp(utils.readTestData("propertyDimention","NoProperties", "login"), utils.readTestData("propertyDimention","NoProperties", "pwd"));
		}else if(loginType.equals("withOutProducts")){
			loginToApp(utils.readTestData("propertyDimention","propertyProducts","withOutProducts", "login"), utils.readTestData("propertyDimention","propertyProducts","withOutProducts", "pwd"));
		}else {
			welcomePage.tapGuestAccessButton();
			//loginToApp(utils.readTestData("propertyDimention", "login"), utils.readTestData("propertyDimention", "pwd"));
		}
		
		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
	}
	
	private void enableFAPISettings() {
		
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.tapFAPISettingsMenuItem();
		fapiSettingsPage.tapUserHasPropertiesToggle();
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.tapSuncorpMenuItem();
		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
		
	}
}
