package test.marketplace.offers;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class OffersOverviewTab extends App {
	// scenario 1
	// Story DMPM-2253 TCs "DMPM-4649","DMPM-4650"
	@Test(groups = { "DMPM-97", "DMPM-924","DMPM-2253", "DMPM-4649","DMPM-4650", "marketplace", "Offers", "priority-minor" })
	public void testOverviewTabOffers() {
		navigateToOverviewScreen();
		Assert.assertNotNull(offersPage.checkOfferTitle(), "Overview Page Offers - No offer Title");
		Assert.assertNotNull(offersPage.checkCallToActionButton(), "Overview Page Offers - No Action Button");
		Assert.assertNotNull(offersPage.checkBackgroundImage(), "Overview Page Offers - No Background Image");
		Assert.assertNull(offersPage.checkOfferIcon(), "Overview Page Offers - Offer Icon is still present");
		Assert.assertEquals(offersPage.getOffersDescriptionText(),
				utils.readTestData("copy", "offersPage", "overviewTab", "offerDescription"),
				"offer description for overview tab is not shown as expected");
		Assert.assertEquals(offersPage.getOffersPageTitle(),
				utils.readTestData("copy", "offersPage", "overviewTab", "offerTitle"),
				"offer title for overview tab is not shown as expected");
		Assert.assertNotNull(offersPage.checkOfferLogoImage(), "Property Page Offers - No offer logo image");
		
	}

	// scenario 2
	@Test(groups = { "DMPM-97", "DMPM-925", "marketplace", "Offers", "priority-minor" })
	public void testRetryContentRetrievalOverviewTab() {
		navigateToOverviewScreen();
		if (!(offersPage.checkOfferTitle().isDisplayed() && offersPage.checkCallToActionButton().isDisplayed())) {
				//&& offersPage.checkBackgroundImage().isDisplayed())) {
			Assert.assertNotNull(landingPage.checkFinanceTab(), " Offers flow - Navigation to different tab failed");
			landingPage.tapFinanceTab();
			Assert.assertNotNull(landingPage.checkSuncorpTab(),
					" Offers flow - Navigation back to Overview tab failed");
			landingPage.tapSuncorpTab();
		}
		Assert.assertNotNull(offersPage.checkOfferIcon(), "Overview Page Offers - No offer Image");
		Assert.assertNotNull(offersPage.checkOfferTitle(), "Overview Page Offers - No offer Title");
		Assert.assertNotNull(offersPage.checkCallToActionButton(), "Overview Page Offers - No Action Button");
		//Assert.assertNotNull(offersPage.checkBackgroundImage(), "Overview Page Offers - No Background Image");
	}

	@Test(groups = { "DMPM-500", "DMPM-934", "DMPM-935", "marketplace", "Offers",
			"priority-minor" })
	public void testLinkToRegistrationPage() {
		navigateToOverviewScreen();
		Assert.assertNotNull(offersPage.checkCallToActionButton(), "Suncorp Page Offers - No offer banner");
		offersPage.tapCallToActionButton();
		Assert.assertNotNull(registrationPage.checkFirstNameField(), "Suncorp Page Offers - No Registration Page");
		Assert.assertNotNull(registrationPage.checkCancelButton(),
				"Registration Page Cancel - No cancel button");
		registrationPage.tapCancelButton();
		Assert.assertNotNull(offersPage.checkCallToActionButton(),
				"Suncorp Page Offers - No Offer banner after Cancellation");

	}

	private void navigateToOverviewScreen() {
		welcomePage.tapGuestAccessButton();
		Assert.assertNotNull(landingPage.isSuncorpTabSelected(),
				" Offers flow for Overview - Suncorp tab not selected");
		offersPage.scrollToOffersBanner();
	}
}
