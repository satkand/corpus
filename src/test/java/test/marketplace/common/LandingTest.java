package test.marketplace.common;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class LandingTest extends App {
	
	//Scenario 1
	// Verify the tabs on the screen
	@Test (groups = {"DMPM-78", "DMPM-308", "marketplace", "Guest User", "priority-minor"})
	public void testTabsDisplayedOnLandingScreen() {
		navigateToLandingPage();
		Assert.assertNotNull(landingPage.checkLandingPageTitle(), "Landing page - page title not shown");
		Assert.assertNotNull(landingPage.checkSuncorpTab(), "Landing page - Suncorp tab not shown");
		Assert.assertNotNull(landingPage.checkHomeTab(), "Landing page - Home tab not shown");
		Assert.assertNotNull(landingPage.checkVehiclesTab(), "Landing page - Vehicles tab not shown");
		landingPage.swipeToHealthTab();
		Assert.assertNotNull(landingPage.checkWealthTab(), "Landing page - Wealth tab not shown");
		Assert.assertNotNull(landingPage.checkHealthTab(), "Landing page - Health tab not shown");
		//Suncorp tab selected by default
		landingPage.swipeToSuncorpTab();
		Assert.assertTrue(landingPage.isSuncorpTabSelected(), "Landing Page - suncorp tab is not selected by default");
	}
	
	
	//Scenario 2
	// Tap on each tab and verify that the correct tab is shown selected
	@Test (groups = {"DMPM-78", "DMPM-309", "marketplace", "Guest User", "priority-minor"})
	public void testTappingOnNavigationBarTabs() {
		navigateToLandingPage();
		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Landing Page - Home tab is not selected");
		landingPage.tapVehiclesTab();
		Assert.assertTrue(landingPage.isVehiclesTabSelected(), "Landing Page - Vehicles tab is not selected");
		landingPage.tapWealthTab();
		Assert.assertTrue(landingPage.isWealthTabSelected(), "Landing Page - Wealth tab is not selected");
		landingPage.tapHealthTab();
		Assert.assertTrue(landingPage.isHealthTabSelected(), "Landing Page - Health tab is not selected");
		landingPage.swipeToSuncorpTab();
		landingPage.tapSuncorpTab();
		Assert.assertTrue(landingPage.isSuncorpTabSelected(), "Landing Page - Suncorp tab is not selected");
	}
	
	private void navigateToLandingPage() {
		welcomePage.tapGuestAccessButton();
	}
}
