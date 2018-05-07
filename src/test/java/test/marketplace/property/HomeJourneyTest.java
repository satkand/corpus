package test.marketplace.property;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class HomeJourneyTest extends App {
	
	// 503 - Scenario 2
	//4850 - Scenario 1
	@Test (groups = {"DMPM-503", "DMPM-972","DMPM-4850", "marketplace", "Home buying journey", "priority-minor"})
	public void testHomeJourneyPageElements() {
		navigateToHomePropertyTab();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - Home Journey page title is not shown");

		homeJourneyPage.scrollToJourneyDescriptionText();
		
		Assert.assertNotNull(homeJourneyPage.checkJourneyTitleText(), "Home Journey Page - Journey title text is not shown");
		Assert.assertEquals(homeJourneyPage.getJourneyTitleText(), utils.readTestData("copy", "homeJourneyPage", "journeyTitleText"), "Home Journey Page -Journey title copy is not shown as expected");
		Assert.assertNotNull(homeJourneyPage.checkJourneySubtitleText(), "Home Journey Page - Journey subtitle text is not shown");
		Assert.assertEquals(homeJourneyPage.getJourneySubtitleText(), utils.readTestData("copy", "homeJourneyPage", "journeySubtitleText"), "Home Journey Page - Journey subtitle text copy is not shown as expected");
		Assert.assertNotNull(homeJourneyPage.checkJourneyDescriptionText(), "Home Journey Page - Journey description text is not shown");
		Assert.assertEquals(homeJourneyPage.getJourneyDescriptionText(), utils.readTestData("copy", "homeJourneyPage", "journeyDescriptionText"), "Home Journey Page - Journey description text copy is not shown as expected");
		
		homeJourneyPage.scrollToPlanningReadMoreButton();
		
		Assert.assertNotNull(homeJourneyPage.checkPlanningImage(), "Home Journey Page - Planning card Image is not shown");
		Assert.assertNotNull(homeJourneyPage.checkPlanningTitleText(), "Home Journey Page - Planning card Title text is not shown");
		Assert.assertEquals(homeJourneyPage.getPlanningTitleText(), utils.readTestData("copy", "homeJourneyPage", "planningTitleText"), "Home Journey Page - Planning card title copy is not shown as expected");
		Assert.assertNotNull(homeJourneyPage.checkPlanningDescriptionText(), "Home Journey Page - Planning card description is not shown");
		Assert.assertEquals(homeJourneyPage.getPlanningDescriptionText(), utils.readTestData("copy", "homeJourneyPage", "planningDescriptionText"), "Home Journey Page - Planning card description copy is not shown as expected");
		Assert.assertNotNull(homeJourneyPage.checkPlanningReadMoreButton(), "Home Journey Page - Planning card Read More button is not shown");

		// Swiping to the next card and verifying elements on that card
		common.swipeLeft();
		Assert.assertNotNull(homeJourneyPage.checkHouseHuntingImage(), "Home Journey Page - House hunting card Image is not shown");
		Assert.assertNotNull(homeJourneyPage.checkHouseHuntingTitleText(), "Home Journey Page - House hunting card Title text is not shown");
		Assert.assertEquals(homeJourneyPage.getHouseHuntingTitleText(), utils.readTestData("copy", "homeJourneyPage", "houseHuntingTitleText"), "Home Journey Page - House hunting card title copy is not shown as expected");
		Assert.assertNotNull(homeJourneyPage.checkHouseHuntingDescriptionText(), "Home Journey Page - House hunting card description is not shown");
		Assert.assertEquals(homeJourneyPage.getHouseHuntingDescriptionText(), utils.readTestData("copy", "homeJourneyPage", "houseHuntingDescriptionText"), "Home Journey Page - House hunting card description copy is not shown as expected");
		Assert.assertNotNull(homeJourneyPage.checkHouseHuntingReadMoreButton(), "Home Journey Page - House hunting card Read More button is not shown");
		
		// Swiping to the next card and verifying elements on that card
		common.swipeLeft();
		Assert.assertNotNull(homeJourneyPage.checkGettingReadyImage(), "Home Journey Page - Getting ready card Image is not shown");
		Assert.assertNotNull(homeJourneyPage.checkGettingReadyTitleText(), "Home Journey Page - Getting ready card Title text is not shown");
		Assert.assertEquals(homeJourneyPage.getGettingReadyTitleText(), utils.readTestData("copy", "homeJourneyPage", "gettingReadyTitleText"), "Home Journey Page - Getting ready card title copy is not shown as expected");
		Assert.assertNotNull(homeJourneyPage.checkGettingReadyDescriptionText(), "Home Journey Page - Getting ready card description is not shown");
		Assert.assertEquals(homeJourneyPage.getGettingReadyDescriptionText(), utils.readTestData("copy", "homeJourneyPage", "gettingReadyDescriptionText"), "Home Journey Page - Getting ready card description copy is not shown as expected");
		Assert.assertNotNull(homeJourneyPage.checkGettingReadyReadMoreButton(), "Home Journey Page - Getting ready card Read More button is not shown");

		// Swiping to the next card and verifying elements on that card
		common.swipeLeft();
		Assert.assertNotNull(homeJourneyPage.checkmovingInImage(), "Home Journey Page - Moving in card Image is not shown");
		Assert.assertNotNull(homeJourneyPage.checkMovingInTitleText(), "Home Journey Page - Moving in card Title text is not shown");
		Assert.assertEquals(homeJourneyPage.getMovingInTitleText(), utils.readTestData("copy", "homeJourneyPage", "movingInTitleText"), "Home Journey Page - Moving in card title copy is not shown as expected");
		Assert.assertNotNull(homeJourneyPage.checkMovingInDescriptionText(), "Home Journey Page - Moving in card description is not shown");
		Assert.assertEquals(homeJourneyPage.getMovingInDescriptionText(), utils.readTestData("copy", "homeJourneyPage", "movingInDescriptionText"), "Home Journey Page - Moving in card description copy is not shown as expected");
		Assert.assertNotNull(homeJourneyPage.checkMovingInReadMoreButton(), "Home Journey Page - Moving in card Read More button is not shown");	
	}
	
	// 503 - Scenario 3
	@Test (groups = {"DMPM-503", "DMPM-983", "marketplace", "Home buying journey", "priority-minor"})
	public void testNavigatingToHomeBuyingGuideLinks() {
		navigateToHomePropertyTab();
		homeJourneyPage.scrollToPlanningReadMoreButton();

		// Tapping on read more button and verifying that the correct page(url) is opened
		homeJourneyPage.tapPlanningReadMoreButton();
		Assert.assertEquals(webviewPage.getWebviewBrowserUrl(), utils.readTestData("copy", "homeJourneyPage", "planningReadMoreButtonLink"), "Planning card page - browser url is not valid");
		webviewPage.tapWebviewChromeCloseButton();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - Home Journey page title is not shown");

		// swipe to the next card
		common.swipeLeft();
		// Tapping on read more button and verifying that the correct page(url) is opened
		homeJourneyPage.tapHouseHuntingReadMoreButton();
		Assert.assertEquals(webviewPage.getWebviewBrowserUrl(), utils.readTestData("copy", "homeJourneyPage", "houseHuntingReadMoreButtonLink"), "House Hunting card page - browser url is not valid");
		webviewPage.tapWebviewChromeCloseButton();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - Home Journey page title is not shown");

		// swipe to the next card
		common.swipeLeft();
		// Tapping on read more button and verifying that the correct page(url) is opened
		homeJourneyPage.tapGettingReadyReadMoreButton();
		Assert.assertEquals(webviewPage.getWebviewBrowserUrl(), utils.readTestData("copy", "homeJourneyPage", "gettingReadyReadMoreButtonLink"), "Getting Ready card page - browser url is not valid");
		webviewPage.tapWebviewChromeCloseButton();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - Home Journey page title is not shown");
		
		// swipe to the next card
		common.swipeLeft();
		// Tapping on read more button and verifying that the correct page(url) is opened
		homeJourneyPage.tapMovingInReadMoreButton();
		Assert.assertEquals(webviewPage.getWebviewBrowserUrl(), utils.readTestData("copy", "homeJourneyPage", "movingInReadMoreButtonLink"), "Moving In card page - browser url is not valid");
		webviewPage.tapWebviewChromeCloseButton();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - Home Journey page title is not shown");
	}
	
	@Test (groups = {"DMPM-797", "DMPM-855", "DMPM-856","DMPM-6057","DMPM-6762", "marketplace", "Home buying journey", "priority-minor"})
	
	//DMPM-797 - Scenario 1 & 2
	//DMPM-855: Navigating to Home journey option in Menu
	//"DMPM-6057","DMPM-6762",
	public void testHomeJourneyviaMenu()
	{
		navigateToHomeJourneyviaMenu();
		Assert.assertNull(navigationMenu.checkHomeJourneyMenuItem(), " Navigation Draw - Home Journey menu option not shown");
		Assert.assertNotNull(navigationMenu.checkSuncorpMenuItem(), " Navigation Draw - One suncorp menu option not shown");
		
		navigationMenu.tapSuncorpMenuItem();
		landingPage.tapHomeTab();
		//DMPM-856: Navigating to Home journey screen
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - Home Journey page title is not shown");
		Assert.assertNotNull(navigationMenu.checkSplitMenuIcon(), "Home Journey Page - Hamburger Menu not shown");
		
	}
	
	private void navigateToHomeJourneyviaMenu() {
		welcomePage.tapGuestAccessButton();
		navigationMenu.tapSplitMenuIcon();
	
}
	private void navigateToHomePropertyTab() {
		welcomePage.tapGuestAccessButton();
		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
		homePropertyPage.scrollToJourneyBanner();
		homePropertyPage.tapStartYourJourneyButton();
	}
}
