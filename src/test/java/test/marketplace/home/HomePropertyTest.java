package test.marketplace.home;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class HomePropertyTest extends App {
	
	@Test (groups = {"DMPM-86", "DMPM-857", "marketplace", "Home buying journey", "priority-minor"})
	public void testHomePropertyPageElements() {
		navigateToHomePropertyTab();
		
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
		navigateToHomePropertyTab();
		homePropertyPage.scrollToJourneyBanner();
		homePropertyPage.tapStartYourJourneyButton();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - page title not shown");
		homeJourneyPage.tapBackButton();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
	}
	
	private void navigateToHomePropertyTab() {
		welcomePage.tapGuestAccessButton();
		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
	}
}
