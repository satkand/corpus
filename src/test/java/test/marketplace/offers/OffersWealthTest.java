package test.marketplace.offers;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.TestDetails;
import pages.App;

public class OffersWealthTest extends App {
	// scenario 1
	// Story DMPM-2253 TCs "DMPM-4649","DMPM-4650"
	@TestDetails(story1="DMPM-816:DMPM-930", story2="DMPM-2253:DMPM-4649,DMPM-4650")
	@Test(groups = {"marketplace", "Offers", "priority-minor" })
	public void testWealthJourneyOffers() {
		navigateToWealthScreen("offers");
		Assert.assertNotNull(offersPage.checkOfferTitle(), "Wealth tab Offers - No offer Title");
		Assert.assertNotNull(offersPage.checkCallToActionButton(), "Wealth tab Offers - No Action Button");
		Assert.assertNotNull(offersPage.checkBackgroundImage(), "Wealth tab Offers - No Background Image");
		Assert.assertNull(offersPage.checkOfferIcon(), "Wealth tab Offers - Offer Icon is still present");
		Assert.assertEquals(offersPage.getOffersDescriptionText(),
				utils.readTestData("offersPage", "wealthTab", "offerDescription"), "offer description for Wealth tab is not shown as expected");
		Assert.assertEquals(offersPage.getOffersPageTitle(),
				utils.readTestData("offersPage", "wealthTab", "offerTitle"), "offer title for Wealth tab is not shown as expected");
		Assert.assertNotNull(offersPage.checkOfferLogoImage(), "Property Page Offers - No offer logo image");
		
	}

	// scenario 2
	@TestDetails(story1="DMPM-816:DMPM-931")
	@Test(groups = {"marketplace", "Offers", "priority-minor" })
	public void testRetryContentRetrievalWealthTab() {
		navigateToWealthScreen("offers");
		if (!(offersPage.checkOfferTitle().isDisplayed() && offersPage.checkCallToActionButton().isDisplayed())) {
				//&& offersPage.checkBackgroundImage().isDisplayed())) {
			Assert.assertNotNull(landingPage.checkHomeTab(), " Offers flow - Navigation to different tab failed");
			landingPage.tapHomeTab();
			Assert.assertNotNull(landingPage.checkFinanceTab(), " Offers flow - Navigation back to Vehicles tab failed");
			landingPage.tapFinanceTab();
		}
		//Offers icon is removed as per DMPM-2253
		//Assert.assertNotNull(offersPage.checkOfferIcon(), "Wealth Page Offers - No offer Image");
		Assert.assertNotNull(offersPage.checkOfferTitle(), "Wealth tab Offers - No offer Title");
		Assert.assertNotNull(offersPage.checkCallToActionButton(), "Wealth tab Offers - No Action Button");
		Assert.assertNotNull(offersPage.checkBackgroundImage(), "Wealth tab Offers - No Background Image");
	}

	private void navigateToWealthScreen(String loginType) {
		if(loginType.equals("offers")) {
			loginToApp(utils.readTestData("offersPage", "login","email"), utils.readTestData("offersPage", "login","pwd"));
			}
		else {
			welcomePage.tapGuestAccessButton();
		}
		Assert.assertNotNull(landingPage.checkFinanceTab(), " Offers flow - Wealths tab not shown");
		landingPage.tapFinanceTab();
		offersPage.scrollToOffersBanner();
	}
}
