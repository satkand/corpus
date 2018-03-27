package test.marketplace.home;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;
import pages.marketplace.common.NavigationMenuPage;

public class HomeJourneyMenuTest extends App {
	
	@Test (groups = {"DMPM-797", "DMPM-855", "DMPM-856", "marketplace", "Home buying journey", "priority-minor"})
	
	//DMPM-797 - Scenario 1 & 2
	// Navigating to Home journey option in Menu
	// Navigating to Home journey screen
	public void testHomeJourneyMenu()
	{
		navigateToHomeJourneyMenu();
		Assert.assertNotNull(navigationMenu.checkHomeJourneyMenuItem(), " Navigation Draw - Home Journey menu option not shown");
		navigationMenu.tapHomeJourneyMenuItem();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - Home Journey page title is not shown");
		Assert.assertNotNull(navigationMenu.checkSplitMenuIcon(), "Home Journey Page - Hamburger Menu not shown");
		
	}
	


private void navigateToHomeJourneyMenu() {
	welcomePage.tapGuestAccessButton();
	navigationMenu.tapSplitMenuIcon();
	
}
}