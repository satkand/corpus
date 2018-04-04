package test.marketplace.offers;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class OffersVehiclesTest extends App {
	// scenario 1
	// Story DMPM-2253 TCs "DMPM-4649","DMPM-4650"
	@Test(groups = { "DMPM-814", "DMPM-926","DMPM-2253", "DMPM-4649","DMPM-4650", "marketplace", "Offers", "priority-minor" })
	public void testVehicleJourneyOffers() {
		navigateToVehicleScreen();
		Assert.assertNotNull(offersPage.checkOfferTitle(), "Vehicle tab Offers - No offer Title");
		Assert.assertNotNull(offersPage.checkCallToActionButton(), "Vehicle tab Offers - No Action Button");
		Assert.assertNotNull(offersPage.checkBackgroundImage(), "Vehicle tab Offers - No Background Image");
		Assert.assertNull(offersPage.checkOfferIcon(), "Vehicle tab Offers - Offer Icon is still present");
		Assert.assertEquals(offersPage.getOffersDescriptionText(),
				utils.readTestData("copy", "offersPage", "vehiclesTab", "offerDescription"),
				"offer description for vehicles tab is not shown as expected");
		Assert.assertEquals(offersPage.getOffersPageTitle(),
				utils.readTestData("copy", "offersPage", "vehiclesTab", "offerTitle"),
				"offer title for vehicles tab is not shown as expected");
		Assert.assertNotNull(offersPage.checkOfferLogoImage(), "Property Page Offers - No offer logo image");
		
	}

	// scenario 2
	@Test(groups = { "DMPM-814", "DMPM-927", "marketplace", "Offers", "priority-minor" })
	public void testRetryContentRetrievalVehiclesTab() {
		navigateToVehicleScreen();
		if (!(offersPage.checkOfferTitle().isDisplayed() && offersPage.checkCallToActionButton().isDisplayed())) {
				//&& offersPage.checkBackgroundImage().isDisplayed())) {
			Assert.assertNotNull(landingPage.checkHomeTab(), " Offers flow - Navigation to different tab failed");
			landingPage.tapHomeTab();
			Assert.assertNotNull(landingPage.checkVehiclesTab(),
					" Offers flow - Navigation back to Vehicles tab failed");
			landingPage.tapVehiclesTab();
		}
		Assert.assertNotNull(offersPage.checkOfferIcon(), "Vehicles Page Offers - No offer Image");
		Assert.assertNotNull(offersPage.checkOfferTitle(), "Vehicle tab Offers - No offer Title");
		Assert.assertNotNull(offersPage.checkCallToActionButton(), "Vehicle tab Offers - No Action Button");
		//Assert.assertNotNull(offersPage.checkBackgroundImage(), "Vehicle tab Offers - No Background Image");
	}

	private void navigateToVehicleScreen() {
		welcomePage.tapGuestAccessButton();
		Assert.assertNotNull(landingPage.checkVehiclesTab(), " Offers flow - Vehicles tab not shown");
		landingPage.tapVehiclesTab();
		offersPage.scrollToOffersBanner();
	}
}
