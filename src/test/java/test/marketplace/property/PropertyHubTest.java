package test.marketplace.property;

import java.util.List;

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
	
	//@TestDetails(story1 = "DMPM-4314:DMPM-7292,DMPM-7293,DMPM-7294,DMPM-7295", priority = Priority.LOW)
	@Test(groups = { "DMPM-4314:DMPM-8000,DMPM-8001,DMPM-8003,DMPM-8004","marketplace", "Property Hub", "priority-minor" })
	public void testPointOfInterestListInViewProperty() {
		
		String tabName = null;
		navigateToSearchPropertyDetailsMiniMap();
		verifyPOICategoriesOnFulllScreenMap();
		Assert.assertNotNull(whatsNearbyPage.checkPropertyCardTitle(), "What's nearby Page - Property Card is displayed in Property tab");
		
		whatsNearbyPage.tapEducationTab();
		Assert.assertTrue(whatsNearbyPage.isEducationTabSelected(), "Landing page - Home tab is not selected on landing page");
			
		tabName = whatsNearbyPage.getPlacesListCountLabel();
		verifyShowMoreList();
		verifyListCount(tabName,"Education");
		verifySortedList(tabName);
		
		whatsNearbyPage.tapShoppingTab();
		Assert.assertTrue(whatsNearbyPage.isShoppingTabSelected(), "Landing page - Home tab is not selected on landing page");
		
		tabName = whatsNearbyPage.getPlacesListCountLabel();
		verifyShowMoreList();
		verifyListCount(tabName,"Shopping");
		verifySortedList(tabName);
	
		whatsNearbyPage.tapTransportTab();
		Assert.assertTrue(whatsNearbyPage.isTransportTabSelected(), "Landing page - Home tab is not selected on landing page");
		
		tabName = whatsNearbyPage.getPlacesListCountLabel();
		verifyShowMoreList();
		verifyListCount(tabName, "Transport");
		verifySortedList(tabName);
		
		whatsNearbyPage.tapEntertainmentTab();
	    Assert.assertTrue(whatsNearbyPage.isEntertainmentTabSelected(), "Landing page - Home tab is not selected on landing page");
		
		tabName = whatsNearbyPage.getPlacesListCountLabel();
		verifyShowMoreList();
		verifyListCount(tabName,"Entertainment");
		verifySortedList(tabName);
			
		whatsNearbyPage.tapHealthTab();
		Assert.assertTrue(whatsNearbyPage.isHealthTabSelected(), "Landing page - Home tab is not selected on landing page");
		
		tabName = whatsNearbyPage.getPlacesListCountLabel();
		verifyShowMoreList();
		verifyListCount(tabName,"Health");
		verifySortedList(tabName);
		
		whatsNearbyPage.tapDiningTab();
		Assert.assertTrue(whatsNearbyPage.isDiningTabSelected(), "Landing page - Home tab is not selected on landing page");
		
		tabName = whatsNearbyPage.getPlacesListCountLabel();
		verifyShowMoreList();
		verifyListCount(tabName, "Dining");
		verifySortedList(tabName);
		
		whatsNearbyPage.tapOtherTab();
		Assert.assertTrue(whatsNearbyPage.isOtherTabSelected(), "Landing page - Home tab is not selected on landing page");
		
		tabName = whatsNearbyPage.getPlacesListCountLabel();
		verifyShowMoreList();
		verifyListCount(tabName, "Other");
		verifySortedList(tabName);
	}	
	
	@TestDetails(story1 = "DMPM-1251", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Feature Access Control ", "priority-minor" })
	public void testGuestExperienceForPropertyHub() {
		
		navigateToPropertyHub();
		propertyExplorerPage.enterTextInPropertyExplorerSearchbox(utils.readTestData("propertyDimension","propertyHub","searchText"));
		propertyExplorerPage.tapSearch();
		
		Assert.assertNotNull(homePropertyPage.checkFeatureLockedMsgTitle(), "Home Property Page - Feature Locked Title is not present");
		Assert.assertEquals(homePropertyPage.getFeatureLockedMsgTitle(), utils.readTestData("copy", "homePropertyPage","featureLockedMsgTitle"), "Home Property Page - Feature Locked message title is different to the expected title");
			
		Assert.assertNotNull(homePropertyPage.checkFeatureLockedTextCopy(), "Home Property Page - Feature Locked message copy is not present");
		Assert.assertEquals(homePropertyPage.getFeatureLockedTextCopy(), utils.readTestData("copy", "homePropertyPage","featureLockedTextCopy"), "Home Property Page - Feature Locked message text is different to the expected message");
		
		Assert.assertNotNull(homePropertyPage.checkFeatureLockedMsgSignUpButton(), "Home Property Page - Sign Up button is not present");
		Assert.assertNotNull(homePropertyPage.checkFeatureLockedMsgLogInButton(), "Home Property Page - Log in button is not present");
		
		propertyExplorerPage.tapSuburbInsight();
		propertyExplorerPage.enterTextInPropertyExplorerSearchbox(utils.readTestData("propertyDimension","propertyHub","searchText"));
		propertyExplorerPage.tapSearch();
		
		Assert.assertNotNull(homePropertyPage.checkFeatureLockedMsgTitle(), "Home Property Page - Feature Locked Title is not present");
		Assert.assertEquals(homePropertyPage.getFeatureLockedMsgTitle(), utils.readTestData("copy", "homePropertyPage","featureLockedMsgTitle"), "Home Property Page - Feature Locked message title is different to the expected title");
			
		Assert.assertNotNull(homePropertyPage.checkFeatureLockedTextCopy(), "Home Property Page - Feature Locked message copy is not present");
		Assert.assertEquals(homePropertyPage.getFeatureLockedTextCopy(), utils.readTestData("copy", "homePropertyPage","featureLockedTextCopy"), "Home Property Page - Feature Locked message text is different to the expected message");
		
		Assert.assertNotNull(homePropertyPage.checkFeatureLockedMsgSignUpButton(), "Home Property Page - Sign Up button is not present");
		Assert.assertNotNull(homePropertyPage.checkFeatureLockedMsgLogInButton(), "Home Property Page - Log in button is not present");
		
		
	}
	
	private void navigateToPropertyHub() {
		navigateToPropertyDimension("NotAGuest");
		homePropertyPage.scrollToJourneyBanner();
		homePropertyPage.tapStartYourJourneyButton();
	}

	public void navigateToAddProperty() {
		navigateToPropertyDimension("NotAGuest");
		homePropertyPage.tapAddAPropertyOrPolicyButton();
		Assert.assertNotNull(homePropertyPage.checkAddPropertyActionSheetButton(), "Home Property Page - Property action sheet button is not present");
		
		homePropertyPage.tapAddPropertyActionSheetButton();
		Assert.assertNotNull(propertyHubPage.checkPropertyHubPageTitle(), "Property Hub Page - Page title is not present");
		
	}
	
	public void navigateToPropertyDimension(String user) {
		if(user.equals("Guess")) {
			welcomePage.tapGuestAccessButton();
		}else {
		loginToApp(utils.readTestData("propertyDimension","propertyHub","login"), utils.readTestData("propertyDimension", "propertyHub","pwd"));
		}
		
		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
		
	}
	
	public void navigateToSearchPropertyDetailsMiniMap() {
		navigateToPropertyDimension("NotAGuest");
		homePropertyPage.scrollToJourneyBanner();
		homePropertyPage.tapStartYourJourneyButton();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - page title not shown");
		Assert.assertNotNull(propertyExplorerPage.checkPropertyHubSearchbox(), "Property Explorer Page - search box not present");
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","clearSearchText"));
		propertyExplorerPage.tapSearch();
		propertyDetailsPage.scrollToWhatsNearButton();
		Assert.assertNotNull(propertyDetailsPage.checkMiniMapWhatsNewButton(), "Home Property Page - Property action sheet button is not present");
		propertyDetailsPage.tapMiniMapWhatsNearbyButton();			
	}
	
	public void verifyPOICategoriesOnFulllScreenMap() {
		Assert.assertNotNull(whatsNearbyPage.checkEducationTab(), "Whats nearby Page - Education tab is not present");
		Assert.assertNotNull(whatsNearbyPage.checkShoppingTab(), "Whats nearby Page - Shopping tab is not present");
		Assert.assertNotNull(whatsNearbyPage.checkTransportTab(), "Whats nearby Page - Transport tab is not present");
		Assert.assertNotNull(whatsNearbyPage.checkEntertainmentTab(), "Whats nearby Page - Entertainment tab is not present");
		Assert.assertNotNull(whatsNearbyPage.checkHealthTab(), "Whats nearby Page - Health tab is not present");
		Assert.assertNotNull(whatsNearbyPage.checkDiningTab(), "Whats nearby Page - Dining tab is not present");
		Assert.assertNotNull(whatsNearbyPage.checkOtherTab(), "Whats nearby Page - Dining tab is not present");
	}
	
	public void verifyShowMoreList() {
		Assert.assertNotNull(whatsNearbyPage.checkPlacesListCountLabel(), "Whats nearby Page - POI count label is Not displayed in Education tab");
		Assert.assertNotNull(whatsNearbyPage.checkShowListLabelButton(), "Whats nearby Page - POI ShowList label is Not displayed in Education tab");
		
	}
	
	public void verifyListCount(String tabNameFullStr, String expectedTabName) {
		
		String DisplayingnumberOfitemsInTheList;
		Assert.assertEquals(whatsNearbyPage.getShowListLabelButton(),"Show list", "Whats nearby Page - ITem count is not matching");
		
		whatsNearbyPage.tapPOIexpandableListButton();
		int numberofItemsInTheList = whatsNearbyPage.getNumberOfItemsIntheList();
		String ActualnumberOfitemsInTheList= Integer.toString(numberofItemsInTheList);
		
		Assert.assertTrue(numberofItemsInTheList<=20,"Whats nearby Page - POI count is exceeding the maximum value");
		if(numberofItemsInTheList>=10) {
			DisplayingnumberOfitemsInTheList= tabNameFullStr.substring(tabNameFullStr.length()-3, tabNameFullStr.length()-1);
		}else{
			DisplayingnumberOfitemsInTheList= tabNameFullStr.substring(tabNameFullStr.length()-2, tabNameFullStr.length()-1);
		}
		Assert.assertEquals(DisplayingnumberOfitemsInTheList, ActualnumberOfitemsInTheList, "Whats nearby Page - Item count is not matching to the displaying count");
		Assert.assertEquals(tabNameFullStr, expectedTabName+" ("+ActualnumberOfitemsInTheList+")","Whats nearby Page - Places list count label displays wrong POI count");
	}
	
	public void verifySortedList(String tabName) {
		
		boolean isListSorted=true;
		List showList = whatsNearbyPage.getItemsList();
		Integer[] intarray=new Integer[showList.size()];
		
		for(int i=0;i<showList.size();i++) {
			intarray[i]=Integer.parseInt(showList.get(i).toString());	
		}
		
		for(int i=0;i<intarray.length-1;i++) {
			System.out.println(intarray[i]);
			if(intarray[i]>intarray[i+1]) {
				isListSorted = false;
			}
		}
		Assert.assertTrue(isListSorted, "Whats nearby Page - POI list is not sorted from distance in "+tabName+" tab ");
		Assert.assertEquals(whatsNearbyPage.getShowListLabelButton(),"Hide list", "Whats nearby Page - ITem count is not matching");
		
		whatsNearbyPage.tapPOIexpandableListButton();
		Assert.assertEquals(whatsNearbyPage.getShowListLabelButton(),"Show list", "Whats nearby Page - ITem count is not matching");	
	}
	
}
