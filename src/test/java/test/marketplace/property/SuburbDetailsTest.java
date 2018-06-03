package test.marketplace.property;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import automation.framework.common.TestDetails.Priority;
import pages.App;

public class SuburbDetailsTest extends App {
	
	@TestDetails(story1 = "DMPM-1130:DMPM-5973,DMPM-5974", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Property Hub", "priority-minor" })
	public void testSuburbInsightFromPropertyHub() {
		
		navigateToPropertyDetails("Property Hub","NotAGuest");
		verifyScreenContents();
		suburbDetailsPage.tapBackButton();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - page title not shown");
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Property Hub page - page title is not present when coming back from suburb insight");

	}
	
	@TestDetails(story1 = "DMPM-1130:DMPM-5973,DMPM-5974", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Property Hub", "priority-minor" })
	public void testSuburbInsightFromPropertyDetails() {
		
		navigateToPropertyDetails("Property Details","NotAGuest");
		verifyScreenContents();
		suburbDetailsPage.tapBackButton();
		Assert.assertNotNull(propertyDetailsPage.checkShowMeInsightButton(), "Property details Page - Show me insights button is not shown");

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
	}
	
	public void checkElements() {
		Assert.assertNotNull(suburbDetailsPage.checkBackButton(), "Suburb Details page - Back button is not present");
		Assert.assertNotNull(suburbDetailsPage.checkRiskAndHazardTitleText(), "Suburb Details page - Risk and Hazards title is not present");
		Assert.assertNotNull(suburbDetailsPage.checkRiskAndHazardTextt(), "Suburb Details page - Risk and Hazards text is not present");
		Assert.assertNotNull(suburbDetailsPage.checkFloodRiskLabelText(),"Suburb Details page - Floor Risk label is not matching");
		Assert.assertNotNull(suburbDetailsPage.checkFloodRiskValue(), "Suburb Details page - Flood Risk value is not present");
		Assert.assertNotNull(suburbDetailsPage.checkBushFireLabelText(),"Suburb Details page - Bush Fire Risk label is not matching");
		Assert.assertNotNull(suburbDetailsPage.checkBushFireValue(), "Suburb Details page - Bush Fire value is not present");
		Assert.assertNotNull(suburbDetailsPage.checkTheftRiskLabelText(),"Suburb Details page - Theft Risk label is not matching");
		Assert.assertNotNull(suburbDetailsPage.checkTheftRiskValue(), "Suburb Details page - Theft RIsk value is not present");
		Assert.assertNotNull(suburbDetailsPage.checkDemographicsTitleText(), "Suburb Details page - Demographics title is not present");
		Assert.assertNotNull(suburbDetailsPage.checkDemographicsText(), "Suburb Details page - Demographics text is not present");
		suburbDetailsPage.scrollToDisclaimerLabelText();
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
	
	public void navigateToPropertyDetails(String navigationPath, String userType) {
	
	if(navigationPath.equals("Property Hub")) {
		
		if(userType.equals("Guest"))
		{
			welcomePage.tapGuestAccessButton();
		}else {
			loginToApp(utils.readTestData("propertyDimension","suburbInsight", "login"), utils.readTestData("propertyDimension", "suburbInsight","pwd"));
		}
		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
		homePropertyPage.scrollToJourneyBanner();
		homePropertyPage.tapStartYourJourneyButton();
		propertyExplorerPage.tapSuburbInsight();
		
		Assert.assertEquals(propertyExplorerPage.getPropertyExplorerSearchHintText(), "Enter suburb's name", "Suburb search hint is not matching");
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","suburbInsight","suburbSearchText"));
		propertyExplorerPage.tapSearch();
		Assert.assertNotNull(suburbDetailsPage.checkSuburbNameText(), "Suburb Details Page - Suburb details title is not present");
		
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
		homePropertyPage.scrollToJourneyBanner();
		homePropertyPage.tapStartYourJourneyButton();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - page title not shown");
		
		propertyExplorerPage.enterTextInPropertyHubSearchbox(utils.readTestData("propertyDimension","propertyExplorer","highConfidenceAddress"));
		propertyExplorerPage.tapSearch();
		Assert.assertNotNull(propertyDetailsPage.checkPropertyAddress(), "Property Details Page - Property address is not present");
		String suburbName = propertyDetailsPage.getPropertyStatePostCode();
		
		propertyDetailsPage.scrollToShowMeInsightButton();
		propertyDetailsPage.tapShowMeInsightButton();
		
		Assert.assertTrue(suburbDetailsPage.checkScreenTitleWithSuburbName(suburbName), "Suburb Details Page - Suburb details title is not present");
		
	}
}
}
