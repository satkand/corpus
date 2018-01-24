package test.marketplace.offers;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class OffersOverviewTab extends App {
	// scenario 1
	@Test(groups = { "DMPM-97", "DMPM-924", "marketplace", "Offers journey-Overview", "priority-minor" })
	public void testOverviewTabOffers() {
		navigateToOverviewScreen();
		Assert.assertNotNull(offersPage.checkOfferImage(), "Overview Page Offers - No offer Image");
		Assert.assertNotNull(offersPage.checkOfferTitle(), "Overview Page Offers - No offer Title");
		Assert.assertNotNull(offersPage.checkActionButton(), "Overview Page Offers - No Action Button");
		Assert.assertNotNull(offersPage.checkBackgroundImage(), "Overview Page Offers - No Background Image");
		Assert.assertEquals(offersPage.getOffersDescriptionText(),
				utils.readTestData("copy", "offersPage", "overviewTab", "offerDescription"),
				"offer description for overview tab is not shown as expected");
		Assert.assertEquals(offersPage.getOffersPageTitle(),
				utils.readTestData("copy", "offersPage", "overviewTab", "offerTitle"),
				"offer title for overview tab is not shown as expected");

	}

	// scenario 2
	@Test(groups = { "DMPM-97", "DMPM-925", "marketplace", "Offers journey-Overview", "priority-minor" })
	public void testRetryContentRetrievalOverviewTab() {
		navigateToOverviewScreen();
		if (!(offersPage.checkOfferTitle().isDisplayed() && offersPage.checkActionButton().isDisplayed()
				&& offersPage.checkBackgroundImage().isDisplayed())) {
			Assert.assertNotNull(landingPage.checkWealthTab(), " Offers flow - Navigation to different tab failed");
			landingPage.tapWealthTab();
			Assert.assertNotNull(landingPage.checkSuncorpTab(),
					" Offers flow - Navigation back to Overview tab failed");
			landingPage.tapSuncorpTab();
		}
		Assert.assertNotNull(offersPage.checkOfferImage(), "Overview Page Offers - No offer Image");
		Assert.assertNotNull(offersPage.checkOfferTitle(), "Overview Page Offers - No offer Title");
		Assert.assertNotNull(offersPage.checkActionButton(), "Overview Page Offers - No Action Button");
		Assert.assertNotNull(offersPage.checkBackgroundImage(), "Overview Page Offers - No Background Image");
	}

	@Test(groups = { "DMPM-500", "DMPM-934", "DMPM-935", "marketplace", "Offers journey-Registration Page",
			"priority-minor" })
	public void testLinkToRegistrationPage() {
		navigateToOverviewScreen();
		Assert.assertNotNull(offersPage.checkActionButton(), "Suncorp Page Offers - No offer banner");
		offersPage.tapCallToActionButton();
		Assert.assertNotNull(registrationPage.checkRegistrationPage(), "Suncorp Page Offers - No Registration Page");
		Assert.assertNotNull(registrationPage.checkCancelButton(),
				"Registration Page Cancel - No cancel button");
		registrationPage.tapCancelButton();
		Assert.assertNotNull(offersPage.checkActionButton(),
				"Suncorp Page Offers - No Offer banner after Cancellation");

	}

	private void navigateToOverviewScreen() {
		welcomePage.tapGuestAccessButton();
		Assert.assertNotNull(landingPage.isSuncorpTabSelected(),
				" Offers flow for Overview - Suncorp tab not selected");
	}
}
