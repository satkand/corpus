package test.marketplace.offers;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class OffersWealthTest extends App {
	// scenario 1
	@Test(groups = { "DMPM-816", "DMPM-930", "marketplace", "Offers journey-Wealth", "priority-minor" })
	public void testWealthJourneyOffers() {
		navigateToWealthScreen();
		Assert.assertNotNull(offersPage.checkOfferImage(), "Wealth Page Offers - No offer Image");
		Assert.assertNotNull(offersPage.checkOfferTitle(), "Wealth tab Offers - No offer Title");
		Assert.assertNotNull(offersPage.checkActionButton(), "Wealth tab Offers - No Action Button");
		Assert.assertNotNull(offersPage.checkBackgroundImage(), "Wealth tab Offers - No Background Image");
		Assert.assertEquals(offersPage.getOffersDescriptionText(),
				utils.readTestData("copy", "offersPage", "wealthTab", "offerDescription"),
				"offer description for Wealth tab is not shown as expected");
		Assert.assertEquals(offersPage.getOffersPageTitle(),
				utils.readTestData("copy", "offersPage", "wealthTab", "offerTitle"),
				"offer title for Wealth tab is not shown as expected");
	}

	// scenario 2
	@Test(groups = { "DMPM-816", "DMPM-931", "marketplace", "Offers journey-Wealth", "priority-minor" })
	public void testRetryContentRetrievalWealthTab() {
		navigateToWealthScreen();
		if (!(offersPage.checkOfferTitle().isDisplayed() && offersPage.checkActionButton().isDisplayed()
				&& offersPage.checkBackgroundImage().isDisplayed())) {
			Assert.assertNotNull(landingPage.checkHomeTab(), " Offers flow - Navigation to different tab failed");
			landingPage.tapHomeTab();
			Assert.assertNotNull(landingPage.checkWealthTab(), " Offers flow - Navigation back to Vehicles tab failed");
			landingPage.tapWealthTab();
		}
		Assert.assertNotNull(offersPage.checkOfferImage(), "Wealth Page Offers - No offer Image");
		Assert.assertNotNull(offersPage.checkOfferTitle(), "Wealth tab Offers - No offer Title");
		Assert.assertNotNull(offersPage.checkActionButton(), "Wealth tab Offers - No Action Button");
		Assert.assertNotNull(offersPage.checkBackgroundImage(), "Wealth tab Offers - No Background Image");
	}

	private void navigateToWealthScreen() {
		welcomePage.tapGuestAccessButton();
		Assert.assertNotNull(landingPage.checkWealthTab(), " Offers flow - Wealths tab not shown");
		landingPage.tapWealthTab();

	}
}
