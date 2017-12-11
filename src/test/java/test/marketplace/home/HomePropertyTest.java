package test.marketplace.home;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class HomePropertyTest extends App {
	
	@Test (groups = {"DMPM-86", "DMPM-857", "marketplace", "Home buying journey", "priority-minor"})
	public void testHomePropertyPageElements() {
		navigateToHomePropertyTab();
		Assert.assertNotNull(homePropertyPage.checkStartYourJourneyButton(), "Start your Journey button not shown on home tab");
	}
	
	// navigating to home journey screen and again navigating back to home property screen
	@Test (groups = {"DMPM-86", "DMPM-893", "marketplace", "Home buying journey", "priority-minor"})
	public void testNavigatingToHomeJourneyScreen() {
		navigateToHomePropertyTab();
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
