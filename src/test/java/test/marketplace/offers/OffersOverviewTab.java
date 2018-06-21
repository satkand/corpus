package test.marketplace.offers;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.TestDetails;
import pages.App;

public class OffersOverviewTab extends App {
	// scenario 1
	// Story DMPM-2253 TCs "DMPM-4649","DMPM-4650"
	@TestDetails(story1 ="DMPM-97:DMPM-924", story2 ="DMPM-2253: DMPM-4649,DMPM-4650")
	@Test(groups = {"marketplace", "Offers", "priority-minor" })
	public void testOverviewTabOffers() {
		navigateToOverviewScreen("offers");
		Assert.assertNotNull(offersPage.checkOfferTitle(), "Overview Page Offers - No offer Title");
		Assert.assertNotNull(offersPage.checkCallToActionButton(), "Overview Page Offers - No Action Button");
		Assert.assertNotNull(offersPage.checkBackgroundImage(), "Overview Page Offers - No Background Image");
		Assert.assertNull(offersPage.checkOfferIcon(), "Overview Page Offers - Offer Icon is still present");
		Assert.assertEquals(offersPage.getOffersDescriptionText(),
				utils.readTestData("offersPage", "overviewTab", "offerDescription"),
				"offer description for overview tab is not shown as expected");
		Assert.assertEquals(offersPage.getOffersPageTitle(),
				utils.readTestData("offersPage", "overviewTab", "offerTitle"),
				"offer title for overview tab is not shown as expected");
		Assert.assertNotNull(offersPage.checkOfferLogoImage(), "Property Page Offers - No offer logo image");
		
	}

	// scenario 2
	@TestDetails(story1 ="DMPM-97:DMPM-925")
	@Test(groups = {"marketplace", "Offers", "priority-minor" })
	public void testRetryContentRetrievalOverviewTab() {
		navigateToOverviewScreen("offers");
		if (!(offersPage.checkOfferTitle().isDisplayed() && offersPage.checkCallToActionButton().isDisplayed())) {
				//&& offersPage.checkBackgroundImage().isDisplayed())) {
			Assert.assertNotNull(landingPage.checkFinanceTab(), " Offers flow - Navigation to different tab failed");
			landingPage.tapFinanceTab();
			Assert.assertNotNull(landingPage.checkSuncorpTab(),
					" Offers flow - Navigation back to Overview tab failed");
			landingPage.tapSuncorpTab();
		}
		//Offers icon is removed as per DMPM-2253
		//Assert.assertNotNull(offersPage.checkOfferIcon(), "Overview Page Offers - No offer Image");
		Assert.assertNotNull(offersPage.checkOfferTitle(), "Overview Page Offers - No offer Title");
		Assert.assertNotNull(offersPage.checkCallToActionButton(), "Overview Page Offers - No Action Button");
		Assert.assertNotNull(offersPage.checkBackgroundImage(), "Overview Page Offers - No Background Image");
	}
	
	// TODO: R3 Release
	/*@TestDetails(story1 = "DMPM-500:DMPM-934,DMPM-935")
	@Test(groups = {"marketplace", "Offers",
			"priority-minor" })
	public void testLinkToRegistrationPage() {
		navigateToOverviewScreen("offers");
		Assert.assertNotNull(offersPage.checkCallToActionButton(), "Suncorp Page Offers - No offer banner");
		offersPage.tapCallToActionButton();
		Assert.assertNotNull(registrationPage.checkFirstNameField(), "Suncorp Page Offers - No Registration Page");
		Assert.assertNotNull(registrationPage.checkCancelButton(),
				"Registration Page Cancel - No cancel button");
		registrationPage.tapCancelButton();
		Assert.assertNotNull(offersPage.checkCallToActionButton(),
				"Suncorp Page Offers - No Offer banner after Cancellation");

	}*/
	
	@TestDetails(story1 ="DMPM-1198:DMPM-1398")
	@Test(groups = {"marketplace", "Offers", "priority-minor" })
	public void testRedirectToExternalURL() {
		String webViewUrl,url = new String();
		webViewUrl = utils.readTestData("offersPage", "overviewTab","url");
		navigateToOverviewScreen("offers");
		Assert.assertNotNull(offersPage.checkCallToActionButton(), "Suncorp Page Offers - No offer banner");
		offersPage.tapCallToActionButton();
		url = webviewPage.getWebviewBrowserUrl();
		Assert.assertNotNull(url.contains(webViewUrl), "Did not open chrome Browser");
		
		Assert.assertNotNull(offersPage.checkChromeToolBar(), "Did not open chrome Browser");
	}
	
	
	private void navigateToOverviewScreen(String loginType) {
		if(loginType.equals("offers")) {
			loginToApp(utils.readTestData("offersPage", "login","email"), utils.readTestData("offersPage", "login","pwd"));
			}
		else {
			welcomePage.tapGuestAccessButton();
		}
		
		Assert.assertNotNull(landingPage.isSuncorpTabSelected(),
				" Offers flow for Overview - Suncorp tab not selected");
		offersPage.scrollToOffersBanner();
	}
}
