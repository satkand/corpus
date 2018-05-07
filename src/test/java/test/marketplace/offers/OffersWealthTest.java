package test.marketplace.offers;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class OffersWealthTest extends App {
	// scenario 1
	// Story DMPM-2253 TCs "DMPM-4649","DMPM-4650"
	@Test(groups = { "DMPM-816", "DMPM-930","DMPM-2253", "DMPM-4649","DMPM-4650", "marketplace", "Offers", "priority-minor" })
	public void testWealthJourneyOffers() {
		navigateToWealthScreen();
		Assert.assertNotNull(offersPage.checkOfferTitle(), "Wealth tab Offers - No offer Title");
		Assert.assertNotNull(offersPage.checkCallToActionButton(), "Wealth tab Offers - No Action Button");
		Assert.assertNotNull(offersPage.checkBackgroundImage(), "Wealth tab Offers - No Background Image");
		Assert.assertNull(offersPage.checkOfferIcon(), "Wealth tab Offers - Offer Icon is still present");
		Assert.assertEquals(offersPage.getOffersDescriptionText(),
				utils.readTestData("copy", "offersPage", "wealthTab", "offerDescription"),
				"offer description for Wealth tab is not shown as expected");
		Assert.assertEquals(offersPage.getOffersPageTitle(),
				utils.readTestData("copy", "offersPage", "wealthTab", "offerTitle"),
				"offer title for Wealth tab is not shown as expected");
		Assert.assertNotNull(offersPage.checkOfferLogoImage(), "Property Page Offers - No offer logo image");
		
	}

	// scenario 2
	@Test(groups = { "DMPM-816", "DMPM-931", "marketplace", "Offers", "priority-minor" })
	public void testRetryContentRetrievalWealthTab() {
		navigateToWealthScreen();
		if (!(offersPage.checkOfferTitle().isDisplayed() && offersPage.checkCallToActionButton().isDisplayed())) {
				//&& offersPage.checkBackgroundImage().isDisplayed())) {
			Assert.assertNotNull(landingPage.checkHomeTab(), " Offers flow - Navigation to different tab failed");
			landingPage.tapHomeTab();
			Assert.assertNotNull(landingPage.checkFinanceTab(), " Offers flow - Navigation back to Vehicles tab failed");
			landingPage.tapFinanceTab();
		}
		Assert.assertNotNull(offersPage.checkOfferIcon(), "Wealth Page Offers - No offer Image");
		Assert.assertNotNull(offersPage.checkOfferTitle(), "Wealth tab Offers - No offer Title");
		Assert.assertNotNull(offersPage.checkCallToActionButton(), "Wealth tab Offers - No Action Button");
		//Assert.assertNotNull(offersPage.checkBackgroundImage(), "Wealth tab Offers - No Background Image");
	}

	private void navigateToWealthScreen() {
		welcomePage.tapGuestAccessButton();
		Assert.assertNotNull(landingPage.checkFinanceTab(), " Offers flow - Wealths tab not shown");
		landingPage.tapFinanceTab();
		offersPage.scrollToOffersBanner();
	}
}
