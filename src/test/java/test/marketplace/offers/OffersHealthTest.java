package test.marketplace.offers;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class OffersHealthTest extends App {
	// scenario 1
	@Test(groups = { "DMPM-817", "DMPM-932", "marketplace", "Offers", "priority-minor" })
	public void testHealthJourneyOffers() {
		navigateToHealthScreen();
		Assert.assertNotNull(offersPage.checkOfferTitle(), "Health Page Offers - No offer Title");
		Assert.assertNotNull(offersPage.checkCallToActionButton(), "Health Page Offers - No Action Button");
		//Assert.assertNotNull(offersPage.checkBackgroundImage(), "Health Page Offers - No Background Image");
		Assert.assertEquals(offersPage.getOffersDescriptionText(),
				utils.readTestData("copy", "offersPage", "healthTab", "offerDescription"),
				"offer description for health tab is not shown as expected");
		Assert.assertEquals(offersPage.getOffersPageTitle(),
				utils.readTestData("copy", "offersPage", "healthTab", "offerTitle"),
				"offer title for health tab is not shown as expected");

	}

	// scenario 2
	@Test(groups = { "DMPM-817", "DMPM-933", "marketplace", "Offers", "priority-minor" })
	public void testRetryContentRetrievalHealthTab() {
		navigateToHealthScreen();
		if (!(offersPage.checkOfferTitle().isDisplayed() && offersPage.checkCallToActionButton().isDisplayed())) {
				//&& offersPage.checkBackgroundImage().isDisplayed())) {
			Assert.assertNotNull(landingPage.checkWealthTab(), " Offers flow - Navigation to different tab failed");
			landingPage.tapWealthTab();
			Assert.assertNotNull(landingPage.checkHealthTab(), " Offers flow - Navigation back to Health tab failed");
			landingPage.tapHealthTab();
		}
		Assert.assertNotNull(offersPage.checkOfferIcon(), "Health Page Offers - No offer Image");
		Assert.assertNotNull(offersPage.checkOfferTitle(), "Health Page Offers - No offer Title");
		Assert.assertNotNull(offersPage.checkCallToActionButton(), "Health Page Offers - No Action Button");
		//Assert.assertNotNull(offersPage.checkBackgroundImage(), "Health Page Offers - No Background Image");
	}

	private void navigateToHealthScreen() {
		welcomePage.tapGuestAccessButton();
		landingPage.swipeToHealthTab();
		Assert.assertNotNull(landingPage.checkHealthTab(), " Offers flow - Health tab not shown");
		landingPage.tapHealthTab();
		offersPage.scrollToOffersBanner();
	}
}
