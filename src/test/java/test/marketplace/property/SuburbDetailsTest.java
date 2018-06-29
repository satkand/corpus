package test.marketplace.property;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import automation.framework.common.TestDetails.Priority;
import pages.App;

public class SuburbDetailsTest extends App {
	
	@TestDetails(story1 = "DMPM-1130:DMPM-5973,DMPM-5974",story2 = "DMPM-1407:DMPM-7955,DMPM-7957,DMPM-7961", story3 = "DMPM-7522:DMPM-9313",story4 = "DMPM-7557:DMPM-8917", story5 = "DMPM-1581:DMPM-7992", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Property Hub", "priority-minor" })
	public void testSuburbInsightFromPropertyHub() {
		
		navigateToSuburbDetails("Property Hub","NotAGuest");
		verifyScreenContents();
		suburbDetailsPage.tapBackButton();
		
		if(suburbDetailsPage.checkDemographicsTitleText()!=null) {
			suburbDetailsPage.tapBackButton();
		}
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Property Hub page - page title is not present when coming back from suburb insight");

	}
	
	@TestDetails(story1 = "DMPM-1130:DMPM-5973,DMPM-5974", story2 = "DMPM-1407:DMPM-7955,DMPM-7957,DMPM-7961",story3 = "DMPM-1581:DMPM-7992", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Property Hub", "priority-minor" })
	public void testSuburbInsightFromPropertyDetails() {
		
		navigateToSuburbDetails("Property Details","NotAGuest");
		verifyScreenContents();
		suburbDetailsPage.tapBackButton();
		Assert.assertNotNull(propertyDetailsPage.checkShowMeInsightButton(), "Property details Page - Show me insights button is not shown");

	}
	
	
//	@TestDetails(story1 = "DMPM-7528:DMPM-9318,DMPM-9319,DMPM-9320, priority = Priority.LOW)
	@Test(groups = { "DMPM-7528","DMPM-9318","DMPM-9319","DMPM-9320","marketplace", "Property Hub", "priority-minor" })
	public void testViewSuburbDetailsPOICategories() {
		
		navigateToSuburbDetails("Property Details","NotAGuest");
		suburbDetailsPage.tapWhatsNearbyeButton();
		Assert.assertNotNull(whatsNearbyPage.checkFullScreenMap(), "propertyDetails Page - Suburb details title is not present");
		
		verifyPOICategoriesOnFulllScreenMap();
		
		
	}
	
//	@TestDetails(story1 = "DMPM-1402:DMPM-6053,DMPM-6058", story2 = "DMPM-1391:DMPM-6611, priority = Priority.LOW)
	@Test(groups = { "DMPM-1402","DMPM-9277","DMPM-9278","DMPM-9281","DMPM-9283","DMPM-9285","DMPM-7885","DMPM-9388","DMPM-9381","DMPM-9383","DMPM-9386","DMPM-9387","marketplace", "Property Hub", "priority-minor" })
	public void testSuburbDemographicsFromPropertyHub() {
		
		navigateToSuburbDetails("Property Hub","NotAGuest");
		suburbDetailsPage.tapBackButton();
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyHub","searchText"));
		propertyExplorerPage.checkFirstItemIntheSearchDropdown();
		propertyExplorerPage.tapFirstItemIntheSearchDropdown();
		Assert.assertNotNull(suburbDetailsPage.checkScreenTitleWithSuburbName("Clyde North, VIC 3978"), "propertyDetails Page - Suburb details title is not present");
		
		verifyDemographics();
	}
	
	
//	@TestDetails(story1 = "DMPM-1402:DMPM-6053,DMPM-6058", story2 = "DMPM-1391:DMPM-6611, priority = Priority.LOW)
	@Test(groups = { "DMPM-1402","DMPM-9277","DMPM-9278","DMPM-9281","DMPM-9283","DMPM-9285","DMPM-7885","DMPM-9388","DMPM-9381","DMPM-9383","DMPM-9386","DMPM-9387","marketplace", "Property Hub", "priority-minor" })
	public void testSuburbDemographicsFromPropertyDetails() {
		
		navigateToSuburbDetails("Property Details","NotAGuest");
		verifyDemographics();
	}
	
	public void verifyPOICategoriesOnFulllScreenMap() {
		Assert.assertNotNull(whatsNearbyPage.checkEducationTab(), "Whats nearby Page - Education tab is not present");
		whatsNearbyPage.tapEducationTab();
		Assert.assertNotNull(whatsNearbyPage.checkEducationCentreIndicator(), "Whats nearby Page - Education tab is not present");
		Assert.assertTrue(whatsNearbyPage.isEducationTabSelected(),"Whats nearby page - Education tab is not selected.");
		
		Assert.assertNotNull(whatsNearbyPage.checkShoppingTab(), "Whats nearby Page - Shopping tab is not present");
		whatsNearbyPage.tapShoppingTab();
		Assert.assertNotNull(whatsNearbyPage.checkShoppingAmenityIndicator(), "Whats nearby Page - Education tab is not present");
		Assert.assertTrue(whatsNearbyPage.isShoppingTabSelected(),"Whats nearby page - Education tab is not selected.");
		
		Assert.assertNotNull(whatsNearbyPage.checkTransportTab(), "Whats nearby Page - Transport tab is not present");
		whatsNearbyPage.tapTransportTab();
		Assert.assertNotNull(whatsNearbyPage.checkTransportAmenityIndicator(), "Whats nearby Page - Education tab is not present");
		Assert.assertTrue(whatsNearbyPage.isTransportTabSelected(),"Whats nearby page - Education tab is not selected.");
		
		whatsNearbyPage.swipeTabsLeft();
		
		Assert.assertNotNull(whatsNearbyPage.checkEntertainmentTab(), "Whats nearby Page - Entertainment tab is not present");
		whatsNearbyPage.tapEntertainmentTab();
		Assert.assertTrue(whatsNearbyPage.isEntertainmentTabSelected(),"Whats nearby page - Education tab is not selected.");
		
		Assert.assertNotNull(whatsNearbyPage.checkHealthTab(), "Whats nearby Page - Health tab is not present");
		whatsNearbyPage.tapHealthTab();
		Assert.assertNotNull(whatsNearbyPage.checkHealthCentreIndicator(), "Whats nearby Page - Education tab is not present");
		Assert.assertTrue(whatsNearbyPage.isHealthTabSelected(),"Whats nearby page - Education tab is not selected.");
		
		Assert.assertNotNull(whatsNearbyPage.checkDiningTab(), "Whats nearby Page - Dining tab is not present");
		whatsNearbyPage.tapDiningTab();
		Assert.assertNotNull(whatsNearbyPage.checkDiningCentreIndicator(), "Whats nearby Page - Education tab is not present");
		Assert.assertTrue(whatsNearbyPage.isDiningTabSelected(),"Whats nearby page - Education tab is not selected.");
		
		whatsNearbyPage.swipeTabsLeft();
		
		Assert.assertNotNull(whatsNearbyPage.checkOtherTab(), "Whats nearby Page - Dining tab is not present");
		whatsNearbyPage.tapOtherTab();
		Assert.assertNotNull(whatsNearbyPage.checkOtherAmenityIndicator(), "Whats nearby Page - Education tab is not present");
		Assert.assertTrue(whatsNearbyPage.isOtherTabSelected(),"Whats nearby page - Education tab is not selected.");
		
	}
	
	public void verifyDemographics() {
		
		checkElements();
		suburbDetailsPage.scrollToDisclaimerLabelText();
		suburbDetailsPage.tapfamilyCompositionButton();
		Assert.assertNotNull(demographicsPage.checkdemographicsTitle(), "Demographics Page - page title is not shown");
		Assert.assertEquals(demographicsPage.getdemographicsTitle(),"Demographics", "Demographics Page - page title is not shown");
		Assert.assertNotNull(demographicsPage.checkbackButton(), "Demographics Page - back button is not shown");
		verifyFamilyCompositionScreen();
		demographicsPage.tapbackButton();
		
		suburbDetailsPage.tapOccupancyTypeButton();
		verifyOccupancyTypeScreen();
		demographicsPage.tapbackButton();
		
		suburbDetailsPage.tapagesButton();
		verifyAgesScreen();
		demographicsPage.tapbackButton();
		
		suburbDetailsPage.tapTravelButton();
		verifyTravelScreen();
		demographicsPage.tapbackButton();
		
		suburbDetailsPage.tapWeeklyIncomeButton();
		verifyWeeklyIncomeScreen();
		demographicsPage.tapbackButton();
		
		suburbDetailsPage.tapfamilyCompositionButton();
		demographicsPage.swipeFullScreenImageCarouselLeft();
		verifyOccupancyTypeScreen();
		
		demographicsPage.tapgoToNextPageArrow();
		verifyAgesScreen();
		
		demographicsPage.swipeFullScreenImageCarouselLeft();
		verifyTravelScreen();
		
		demographicsPage.tapgoToNextPageArrow();
		verifyWeeklyIncomeScreen();
		
		demographicsPage.swipeFullScreenImageCarouselRight();
		verifyTravelScreen();
		
		demographicsPage.tapgoToPreviousPageArrow();
		verifyAgesScreen();
		
		demographicsPage.swipeFullScreenImageCarouselRight();
		verifyOccupancyTypeScreen();
		
		demographicsPage.tapgoToPreviousPageArrow();
		verifyFamilyCompositionScreen();
		
		demographicsPage.tapbackButton();
		Assert.assertNotNull(suburbDetailsPage.checkScreenTitleWithSuburbName("Clyde North, VIC 3978"), "Property details Page - Show me insights button is not shown");

	}

	public void verifyFamilyCompositionScreen() {
		Assert.assertNotNull(demographicsPage.checkfamilyCompTitle(), "demographics Page - familyComp Title is not shown");
		Assert.assertNotNull(demographicsPage.checkfamilyCompSuburb(), "demographics Page - familyComp suburb is not shown");
		Assert.assertNotNull(demographicsPage.checkfamilyCompDesc(), "demographics Page - familyComp desc is not shown");
		Assert.assertNotNull(demographicsPage.checkfamilyCompCat1Label(), "demographics Page - familyComp category 1 label is not shown");
		Assert.assertNotNull(demographicsPage.checkfamilyCompCat1Value(), "demographics Page - familyComp category 1 value is not shown");
		Assert.assertNotNull(demographicsPage.checkfamilyCompCat1Bar(), "demographics Page - familyComp category 1 chart is not shown");
		Assert.assertNotNull(demographicsPage.checkfamilyCompCat2Label(), "demographics Page - familyComp category 2 label is not shown");
		Assert.assertNotNull(demographicsPage.checkfamilyCompCat2Value(), "demographics Page - familyComp category 2 value is not shown");
		Assert.assertNotNull(demographicsPage.checkfamilyCompCat2Bar(), "demographics Page - familyComp category 2 is chart not shown");
		Assert.assertNotNull(demographicsPage.checkfamilyCompCat3Label(), "demographics Page - familyComp category 3 label is not shown");
		Assert.assertNotNull(demographicsPage.checkfamilyCompCat3Value(), "demographics Page - familyComp category 3 value is not shown");
		Assert.assertNotNull(demographicsPage.checkfamilyCompCat3Bar(), "demographics Page - familyComp category 3 chart is not shown");
		
	}

	public void verifyOccupancyTypeScreen() {
		Assert.assertNotNull(demographicsPage.checkoccupancyTypeTitle(), "demographics Page - occupancy Title is not shown");
		Assert.assertEquals(demographicsPage.getoccupancyTypeTitle(), "Occupancy type", "demographics Page - occupancy Title is not shown");
		Assert.assertNotNull(demographicsPage.checkoccupancyTypeSuburb(), "demographics Page - occupancy suburb is not shown");
		Assert.assertEquals(demographicsPage.getoccupancyTypeSuburb(),"Clyde North, VIC 3978", "demographics Page - occupancy suburb is not shown");
	
	}

	public void verifyAgesScreen() {
		Assert.assertNotNull(demographicsPage.checkAgesTitle(), "demographics Page - Ages Title is not shown");
		Assert.assertEquals(demographicsPage.getAgesTitle(), "Ages", "demographics Page - Ages Title is not shown");
		Assert.assertNotNull(demographicsPage.checkAgesSuburb(), "demographics Page - Ages suburb is not shown");
		Assert.assertEquals(demographicsPage.getAgesSuburb(),"Clyde North, VIC 3978", "demographics Page - Ages suburb is not shown");
	
	}

	public void verifyTravelScreen() {
		Assert.assertNotNull(demographicsPage.checktravelTitle(), "demographics Page - travel Title is not shown");
		Assert.assertEquals(demographicsPage.gettravelTitle(), "Travel", "demographics Page - travel Title is not shown");
		Assert.assertNotNull(demographicsPage.checktravelSuburb(), "demographics Page - travel suburb is not shown");
		Assert.assertEquals(demographicsPage.gettravelSuburb(),"Clyde North, VIC 3978", "demographics Page - travel suburb is not shown");
	
	}

	public void verifyWeeklyIncomeScreen() {
		Assert.assertNotNull(demographicsPage.checkincomeTitle(), "demographics Page - travel Title is not shown");
		Assert.assertEquals(demographicsPage.getincomeTitle(), "Income", "demographics Page - travel Title is not shown");
		Assert.assertNotNull(demographicsPage.checkincomeSuburb(), "demographics Page - travel suburb is not shown");
		Assert.assertEquals(demographicsPage.getincomeSuburb(),"Clyde North, VIC 3978", "demographics Page - travel suburb is not shown");
	
	}
	
	public void verifyScreenContents() {
		
		checkElements();
		verifyElementNames();
		suburbDetailsPage.scrollToDisclaimerLabelText();
		Assert.assertNotNull(suburbDetailsPage.checkTravelButton(), "Suburb Details page - Travel button is not present");
		Assert.assertNotNull(suburbDetailsPage.checkWeeklyIncomeButton(),"Suburb Details page - Weekly income button is not present");
		Assert.assertEquals(suburbDetailsPage.getDemographicsTitleText(),Copy.SUBURB_DETAILS_DEMOGRAPHICS_TITLE_TEXT,"Suburb Details page - Theft Risk label is not matching");
		Assert.assertEquals(suburbDetailsPage.getdemographicsText(),Copy.SUBURB_DETAILS_DEMOGRAPHICS_TEXT, "Suburb Details page - Theft RIsk value is not present");
		Assert.assertEquals(suburbDetailsPage.getDisclaimerLabelText(),Copy.SUBURB_DETAILS_DISCLAIMER_LABEL_TEXT, "Suburb Details page - Theft Risk value is not present");
		suburbDetailsPage.tapDisclaimerButton();
		Assert.assertNotNull(suburbDetailsPage.checkDisclaimerPageTitle(),"Suburb Details page - Disclaimer page title is not present");
		Assert.assertEquals(suburbDetailsPage.getDisclaimerPageTitleText(),"Disclaimer", "Suburb Details page - Theft Risk value is not present");
		Assert.assertNotNull(suburbDetailsPage.checkDisclaimerBackButton(),"Suburb Details page - Disclaimer page back button is not present");
		
		suburbDetailsPage.tapDisclaimerBackButton();
		Assert.assertNotNull(suburbDetailsPage.checkDemographicsTitleText(), "Suburb Details page - Demographics title is not present");

	}
	
	public void checkElements() {
		
		Assert.assertNotNull(suburbDetailsPage.checkWhatsNearbyButton(), "Suburb Details page - Whats nearby button is not present");
		Assert.assertNotNull(suburbDetailsPage.checkBackButton(), "Suburb Details page - Back button is not present");
		Assert.assertNotNull(suburbDetailsPage.checkRiskAndHazardTitleText(), "Suburb Details page - Risk and Hazards title is not present");
		Assert.assertNotNull(suburbDetailsPage.checkRiskAndHazardTextt(), "Suburb Details page - Risk and Hazards text is not present");
		Assert.assertNotNull(suburbDetailsPage.checkFloodRiskLabelText(),"Suburb Details page - Floor Risk label is not matching");
		Assert.assertNotNull(suburbDetailsPage.checkFloodRiskValue(), "Suburb Details page - Flood Risk value is not present");
		Assert.assertNotNull(suburbDetailsPage.checkBushFireLabelText(),"Suburb Details page - Bush Fire Risk label is not matching");
		Assert.assertNotNull(suburbDetailsPage.checkBushFireValue(), "Suburb Details page - Bush Fire value is not present");
		Assert.assertNotNull(suburbDetailsPage.checkTheftRiskLabelText(),"Suburb Details page - Theft Risk label is not matching");
		Assert.assertNotNull(suburbDetailsPage.checkTheftRiskValue(), "Suburb Details page - Theft RIsk value is not present");
		suburbDetailsPage.scrollToDisclaimerLabelText();
		Assert.assertNotNull(suburbDetailsPage.checkDemographicsTitleText(), "Suburb Details page - Demographics title is not present");
		Assert.assertNotNull(suburbDetailsPage.checkDemographicsText(), "Suburb Details page - Demographics text is not present");
		Assert.assertNotNull(suburbDetailsPage.checkFamilyCompositionButton(),"Suburb Details page - Family Composition button is not present");//
		Assert.assertNotNull(suburbDetailsPage.checkOccupancyTypeButton(), "Suburb Details page - Occupancy Type button is not present");
		Assert.assertNotNull(suburbDetailsPage.checkAgesButton(),"Suburb Details page - Ages button not present");
	}
	
	
	public void verifyElementNames() {
		suburbDetailsPage.scrollUpToRiskAndHazardTitleText();
		Assert.assertEquals(suburbDetailsPage.getRiskAndHazardTitleText(),Copy.SUBURB_DETAILS_RISK_AND_HAZARD_TITLE,"Suburb Details page - Floor Risk label is not matching");//
		Assert.assertEquals(suburbDetailsPage.getRiskAndHazardText(),Copy.SUBURB_DETAILS_RISK_AND_HAZARD_TEXT,"Suburb Details page - Floor Risk label is not matching");
		Assert.assertEquals(suburbDetailsPage.getFloodRiskLabelText(),Copy.SUBURB_DETAILS_FLOOD_RISK_LABEL_TEXT,"Suburb Details page - Floor Risk label is not matching");
		Assert.assertEquals(suburbDetailsPage.getFloodRiskValue(),utils.readTestData("propertyDimension","suburbInsight", "floodRiskValue"), "Suburb Details page - Flood Risk value is not present");//
		Assert.assertEquals(suburbDetailsPage.getBushFireLabelText(),Copy.SUBURB_DETAILS_BUSH_FIRE_LABEL_TEXT,"Suburb Details page - Bush Fire Risk label is not matching");
		Assert.assertEquals(suburbDetailsPage.getBushFireValue(),utils.readTestData("propertyDimension","suburbInsight", "bushFireValue"), "Suburb Details page - Bush Fire value is not present");
		Assert.assertEquals(suburbDetailsPage.getTheftRiskLabelText(),Copy.SUBURB_DETAILS_THIEF_RISK_LABEL_TAXT,"Suburb Details page - Theft Risk label is not matching");
		Assert.assertEquals(suburbDetailsPage.getTheftRiskValue(),utils.readTestData("propertyDimension","suburbInsight", "theifRiskValue"), "Suburb Details page - Theft RIsk value is not present");
	}
	
	public void navigateToSuburbDetails(String navigationPath, String userType) {
	
	if(navigationPath.equals("Property Hub")) {
		
		if(userType.equals("Guest"))
		{
			welcomePage.tapGuestAccessButton();
		}else {
			loginToApp(utils.readTestData("propertyDimension","suburbInsight", "login"), utils.readTestData("propertyDimension", "suburbInsight","pwd"));
		}
		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
//		Assert.assertNotNull(homePropertyPage.checkaddressLineText(), "Home tab is not selected on landing page");
		//homePropertyPage.scrollToJourneyBanner();
		//homePropertyPage.tapStartYourJourneyButton();
		homePropertyPage.scrollToLaunchPropertyExplorer();
		homePropertyPage.taplaunchPropertyExplorer();
		Assert.assertNotNull(propertyHubPage.checkSearchBar(), "Property Hub Page - Search bar is not present");
		propertyExplorerPage.tapSuburbInsight();
		
		Assert.assertEquals(propertyExplorerPage.getPropertyExplorerSearchHintText(), "Enter suburb", "Suburb search hint is not matching");
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","suburbInsight","suburbSearchText"));
		//propertyExplorerPage.tapSearch();
		propertyExplorerPage.checkFirstItemIntheSearchDropdown();
		propertyExplorerPage.tapFirstItemIntheSearchDropdown();
		Assert.assertNotNull(suburbDetailsPage.checkSuburbNameText(utils.readTestData("propertyDimension","propertyDetails","stateAndSuburb")), "Suburb Details Page - Suburb details title is not present");
		
	}
	
	if(navigationPath.equals("Property Details")) {
		
		if(userType.equals("Guest"))
		{
			welcomePage.tapGuestAccessButton();
		}else {
			loginToApp(utils.readTestData("propertyDimension","suburbInsight", "login"), utils.readTestData("propertyDimension", "suburbInsight","pwd"));
		}
		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
		//Assert.assertNotNull(homePropertyPage.checkaddressLineText(), "Home Journey Page - Property Address is not shown");
		//homePropertyPage.scrollToJourneyBanner();
		//homePropertyPage.tapStartYourJourneyButton();
		homePropertyPage.scrollToLaunchPropertyExplorer();
		homePropertyPage.taplaunchPropertyExplorer();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - page title not shown");
		
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","highConfidenceAddress"));
		//propertyExplorerPage.tapSearch();
		propertyExplorerPage.checkFirstItemIntheSearchDropdown();
		propertyExplorerPage.tapFirstItemIntheSearchDropdown();
				
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
		String suburbName = propertyDetailsPage.getPropertyStatePostCode();
		
		propertyDetailsPage.scrollToShowMeInsightButton();
		propertyDetailsPage.tapShowMeInsightButton();
		
		Assert.assertTrue(suburbDetailsPage.checkScreenTitleWithSuburbName(suburbName), "Suburb Details Page - Suburb details title is not present");
		
	}
}
}
