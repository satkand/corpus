package test.marketplace.offers;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class OffersPropertyTest extends App {
	// scenario 1
	@Test(groups = { "DMPM-815", "DMPM-928", "marketplace", "Offers journey-Property", "priority-minor" })
	public void testPropertyJourneyOffers() {
		navigateToPropertyScreen();
		Assert.assertNotNull(offersPage.checkOfferImage(), "Property Page Offers - No offer Image");
		Assert.assertNotNull(offersPage.checkActionButton(), "Property Page Offers - No Action Button");
		Assert.assertNotNull(offersPage.checkBackgroundImage(), "Property Page Offers - No Background Image");
		Assert.assertEquals(offersPage.getOffersDescriptionText(),utils.readTestData("copy", "offersPage", "propertyTab", "offerDescription"),"offer description for property tab is not shown as expected");
		Assert.assertEquals(offersPage.getOffersPageTitle(),
				utils.readTestData("copy", "offersPage", "propertyTab", "offerTitle"),
				"offer title for property tab is not shown as expected");
		}

	// scenario 2
	@Test(groups = { "DMPM-815", "DMPM-929", "marketplace", "Offers journey-Property", "priority-minor" })
	public void testRetryContentRetrievalPropertyTab() {
		navigateToPropertyScreen();
		if (!(offersPage.checkOfferTitle().isDisplayed() && offersPage.checkActionButton().isDisplayed()
				&& offersPage.checkBackgroundImage().isDisplayed())) {
			Assert.assertNotNull(landingPage.checkHealthTab(), " Offers flow - Navigation to different tab failed");
			landingPage.tapHealthTab();
			Assert.assertNotNull(landingPage.checkPropertyTab(),
					" Offers flow - Navigation back to Property tab failed");
			landingPage.tapPropertyTab();
		}
		Assert.assertNotNull(offersPage.checkOfferImage(), "Property Page Offers - No offer Image");
		Assert.assertNotNull(offersPage.checkActionButton(), "Property Page Offers - No Action Button");
		Assert.assertNotNull(offersPage.checkBackgroundImage(), "Property Page Offers - No Background Image");
	}
	
	@Test(groups = { "DMPM-500", "DMPM-934","DMPM-935", "marketplace", "Offers journey-Registration Page", "priority-minor" })
	public void testLinkToRegistrationPage() {
		navigateToPropertyScreen();
		Assert.assertNotNull(offersPage.checkActionButton(), "Property Page Offers - No offer banner");
		offersPage.tapCallToActionButton();
		Assert.assertNotNull(offersPage.checkRegistrationPage(), "Property Page Offers - No Registration Page");
		Assert.assertNotNull(offersPage.checkCancelButtonRegistrationPage(), "Registration Page Cancel - No cancel button");
		offersPage.tapCancelButtonRegistrationPage();
		Assert.assertNotNull(offersPage.checkActionButton(), "Property Page Offers - No Offer banner after Cancellation");
	
	}

	private void navigateToPropertyScreen() {
		welcomePage.tapGuestAccessButton();
		Assert.assertNotNull(landingPage.checkPropertyTab(), " Offers flow - Property tab not shown");
		landingPage.tapPropertyTab();
		offersPage.scrollDown();

	}
}
