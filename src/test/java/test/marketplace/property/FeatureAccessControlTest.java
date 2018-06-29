package test.marketplace.property;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class FeatureAccessControlTest extends App{

	// 6708 scenario 1,4,5
	//TCs : 9370, 9374, 9375
	@Test (groups = {"DMPM-6708", "DMPM-9449", "DMPM-9452", "DMPM-9453", "marketplace", "Home buying journey", "priority-minor"})
	public void testEmailVerificationWhenAccessingPropertyOrSuburbInsight() {
		navigateToPropertyExplorer();
		Assert.assertNotNull(propertyExplorerPage.checkPropertyHubSearchbox(), "Property Explorer Page - Search bar is not found");
		propertyExplorerPage.tapPropertyExplorerSearchbox();
		verifyScreenContents();
		
		Assert.assertNotNull(propertyExplorerPage.checkPropertyHubSearchbox(), "Property Explorer Page - Search bar is not found");
		propertyExplorerPage.tapSuburbInsight();
		propertyExplorerPage.tapPropertyExplorerSearchbox();
		verifyScreenContents();
			
	}
	
	public void verifyScreenContents() {

		Assert.assertNotNull(featureAccessControlPage.checkverificationButton(), "Feature Access Control Page - Verification button is not found");
		Assert.assertNotNull(featureAccessControlPage.checkverificationTitleImage(), "Feature Access Control Page - Verification Image is not found");
		Assert.assertNotNull(featureAccessControlPage.checkverificationMessageLabel(), "Feature Access Control Page - Verification Message is not found");
		Assert.assertNotNull(featureAccessControlPage.checkverificationLinkLabel(), "Feature Access Control Page - Verification Message is not found");
		Assert.assertNotNull(featureAccessControlPage.checkverificationemailLabel(), "Feature Access Control Page - Verification email is not found");
		
		Assert.assertEquals(featureAccessControlPage.getverificationTitleLabel(), "To continue, please verify your email address", "Home Journey Page - Moving in card title copy is not shown as expected");
		Assert.assertEquals(featureAccessControlPage.getverificationMessageLabel(), "Either you haven't verified your email address or the link we've sent you previously has expired.", "Home Journey Page - Moving in card title copy is not shown as expected");
		Assert.assertEquals(featureAccessControlPage.getverificationLinkLabel(), "We'll send you a new verification link to:", "Home Journey Page - Moving in card title copy is not shown as expected");
		Assert.assertEquals(featureAccessControlPage.getverificationemailLabel(), "amila.bandara@outware.com.au", "Home Journey Page - Moving in card title copy is not shown as expected");
		
		featureAccessControlPage.tapverificationButton();
		Assert.assertNotNull(featureAccessControlPage.checkSuccessDismissButton(), "Feature Access Control Page - Success Message is not displayed");
		featureAccessControlPage.tapSuccessDismissButtonButton();
		Assert.assertNotNull(featureAccessControlPage.checkcloseButton(), "Feature Access Control Page - Close button is not found");
		featureAccessControlPage.tapcloseButton();
	}

	public void navigateToPropertyExplorer() {
		loginToApp(utils.readTestData("propertyDimension","FeatureAccessControl","login"), utils.readTestData("propertyDimension", "FeatureAccessControl","pwd"));
		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
		homePropertyPage.tapStartYourJourneyButton();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - page title not shown");
		
	}

}
