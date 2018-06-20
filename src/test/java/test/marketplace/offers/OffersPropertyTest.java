package test.marketplace.offers;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.TestDetails;
import pages.App;

public class OffersPropertyTest extends App {
	// scenario 1
	// Story DMPM-2253 TCs "DMPM-4649","DMPM-4650"
	@TestDetails(story1 ="DMPM-815:DMPM-928", story2 ="DMPM-2253:DMPM-4649,DMPM-4650")
	@Test(groups = {"marketplace", "Offers", "priority-minor" })
	public void testPropertyJourneyOffers() {
		navigateToPropertyScreen("offers");
		Assert.assertNotNull(offersPage.checkCallToActionButton(), "Property Page Offers - No Action Button");
		Assert.assertNotNull(offersPage.checkBackgroundImage(), "Property Page Offers - No Background Image");
		Assert.assertNull(offersPage.checkOfferIcon(), "Property Page Offers - Offer Icon is still present");
		Assert.assertEquals(offersPage.getOffersDescriptionText(),utils.readTestData("offersPage", "propertyTab", "offerDescription"),"offer description for property tab is not shown as expected");
		Assert.assertEquals(offersPage.getOffersPageTitle(), utils.readTestData("offersPage", "propertyTab", "offerTitle"), "offer title for property tab is not shown as expected");
		Assert.assertNotNull(offersPage.checkOfferLogoImage(), "Property Page Offers - No offer logo image");
		}

	// scenario 2
	@TestDetails(story1 ="DMPM-815:DMPM-929")
	@Test(groups = {"marketplace", "Offers", "priority-minor" })
	public void testRetryContentRetrievalPropertyTab() {
		navigateToPropertyScreen("offers");
		if (!(offersPage.checkOfferTitle().isDisplayed() && offersPage.checkCallToActionButton().isDisplayed())) {
				//&& offersPage.checkBackgroundImage().isDisplayed())) {
			Assert.assertNotNull(landingPage.checkHealthTab(), " Offers flow - Navigation to different tab failed");
			landingPage.tapHealthTab();
			Assert.assertNotNull(landingPage.checkHomeTab(),
					" Offers flow - Navigation back to Property tab failed");
			landingPage.tapHomeTab();
		}
		//Offers icon is removed as per DMPM-2253
		//Assert.assertNotNull(offersPage.checkOfferIcon(), "Property Page Offers - No offer Image");
		Assert.assertNotNull(offersPage.checkCallToActionButton(), "Property Page Offers - No Action Button");
		Assert.assertNotNull(offersPage.checkBackgroundImage(), "Property Page Offers - No Background Image");
		Assert.assertNotNull(offersPage.checkOfferLogoImage(), "Property Page Offers - No offer logo image");
	}
	
    // TODO: R3 Release
	/*	@TestDetails(story1 ="DMPM-500:DMPM-934,DMPM-935")
	@Test(groups = {"marketplace", "Offers", "priority-minor" })
	public void testLinkToRegistrationPage() {
		navigateToPropertyScreen("offers");
		Assert.assertNotNull(offersPage.checkCallToActionButton(), "Property Page Offers - No offer banner");
		offersPage.tapCallToActionButton();
		Assert.assertNotNull(registrationPage.checkFirstNameField(), "Property Page Offers - No Registration Page");
		Assert.assertNotNull(registrationPage.checkCancelButton(), "Registration Page Cancel - No cancel button");
		registrationPage.tapCancelButton();
		Assert.assertNotNull(offersPage.checkCallToActionButton(), "Property Page Offers - No Offer banner after Cancellation");
	
	}*/
	
	private void navigateToPropertyScreen(String loginType) {
		if(loginType.equals("offers")) {
			loginToApp(utils.readTestData("offersPage", "login","email"), utils.readTestData("offersPage", "login","pwd"));
			}
		else {
			welcomePage.tapGuestAccessButton();
		}
		Assert.assertNotNull(landingPage.checkHomeTab(), " Offers flow - Property tab not shown");
		landingPage.tapHomeTab();
		offersPage.scrollToOffersBanner();
	}
}
