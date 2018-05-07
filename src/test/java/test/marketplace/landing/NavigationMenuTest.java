//
//package test.marketplace.landing;
//
//import org.openqa.selenium.By;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import automation.framework.common.Copy;
//import pages.App;
//
//public class NavigationMenuTest extends App {
//	//Scenario 3
//	// Displaying Navigation menu and verifying the items in the menu
//	// 4858 - Point 1
//	// DMPM-6057 - scenario 1
//	@Test (groups = {"DMPM-78", "DMPM-310", "DMPM-1447", "DMPM-4858", "DMPM-6057", "DMPM-6762", "marketplace", "Guest User", "priority-minor"})
//	public void testDisplayingNavigationMenu() {
//		navigateToLandingPage();
//		navigationMenu.tapSplitMenuIcon();
//
//		Assert.assertEquals(navigationMenu.getWelcomeMessageText(), Copy.NAV_MENU_WELCOME_MESSAGE, "Navigation Draw - Welcome Message not shown");
//		Assert.assertNotNull(navigationMenu.checkSuncorpMenuItem(), "Navigation Draw - Suncorp menu option not shown");
//		Assert.assertNotNull(navigationMenu.checkBankingHomeMenuItem(), "Navigation Draw - Banking Home menu option not shown");
//		Assert.assertNotNull(navigationMenu.checkProductsMenuItem(), " Navigation Draw - Products menu option not shown");
//		Assert.assertNotNull(navigationMenu.checkDigitalVaultMenuItem(), " Navigation Draw - Products menu option not shown");
//		Assert.assertNotNull(navigationMenu.checkProffessionalServicesMenuItem(), " Navigation Draw - Propfessional Services menu option not shown");
//		Assert.assertNotNull(navigationMenu.checkProductCatalogueItem(), "Navigation Draw - Product Catalogue menu option not shown");
//		Assert.assertNotNull(navigationMenu.checkRewardsForYouMenuItem(), "Navigation Draw - Rewards For You menu option not shown");
//
//		Assert.assertNotNull(navigationMenu.checkSettingsMenuItem(), " Navigation Draw - Propfessional Services menu option not shown");
//		Assert.assertNotNull(navigationMenu.checkBackToStartMenuItem(), " Navigation Draw - Back To Start menu option not shown");
//	}	
//	
//	//Scenario 4
//	// Verifying Back To Start option
//	@Test (groups = {"DMPM-78", "DMPM-311", "marketplace", "Guest User", "priority-minor"})
//	public void testBackToStartOption() {
//		navigateToLandingPage();
//		navigationMenu.tapSplitMenuIcon();
//		navigationMenu.tapBackToStartMenuItem();
//		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen -Suncorp image is not shown");
//		Assert.assertNotNull(welcomePage.checkGuestAccessButton(), "Welcome screen - Guest Access button is not shown");
//	}
//	
//	//Scenario 5
//	// Dismissing Navigation Menu
//	@Test (groups = {"DMPM-78", "DMPM-1257", "marketplace", "Guest User", "priority-minor"})
//	public void testDismissingNavigationMenu() {
//		navigateToLandingPage();
//		Assert.assertNotNull(landingPage.checkLandingPageTitle(), "Landing page - page title not shown");
//
//		// Closing the menu by swiping
//		navigationMenu.slideOpenNavigationMenu();
//		Assert.assertNotNull(navigationMenu.checkSuncorpMenuItem(), "Navigation Menu - Suncorp menu option not shown");
//		navigationMenu.slideCloseNavigationMenu();
//		Assert.assertNull(navigationMenu.checkSuncorpMenuItem(), "Navigation Menu - Suncorp menu option shown");
//
//		// Closing the menu by tapping outside the menu
//		navigationMenu.tapSplitMenuIcon();
//		Assert.assertNotNull(navigationMenu.checkSuncorpMenuItem(), "Navigation Menu - Suncorp menu option not shown");
//		navigationMenu.closeNavigationMenu();
//		Assert.assertNull(navigationMenu.checkSuncorpMenuItem(), "Navigation Menu - Suncorp menu option shown");
//	}
//	
//	private void navigateToLandingPage() {
//		welcomePage.tapGuestAccessButton();
//		
//	}
//}
//
