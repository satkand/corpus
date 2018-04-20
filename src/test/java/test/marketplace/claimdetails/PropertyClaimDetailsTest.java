package test.marketplace.claimdetails;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import automation.framework.common.TestDetails.Priority;
import pages.App;

public class PropertyClaimDetailsTest extends App{

//	@TestDetails(story1 = "DMPM-3724:DMPM-4348", priority = Priority.LOW)
//	@Test(groups = { "marketplace", "pin", "priority-minor" })
//	public void testPropertyClaim() {
//		
//		String username = utils.readTestData("claimDetails","login");
//		String pwd = utils.readTestData("claimDetails", "pwd");
//        String claimNumber = utils.readTestData("claimDetails","property","claimLodged","claimNumber");
//        String expctdProductTypeText = utils.readTestData("claimDetails","property","claimLodged","insuranceType");
//        String expctdHomeRiskAddrLabelText = utils.readTestData("claimDetails","property","claimLodged","homeRiskAddress");
//        String expctdhomeRiskAddrPrimaryDescText = utils.readTestData("claimDetails","property","claimLodged","homeRiskAddrPrimaryDesc");
//        String expctdhomeRiskAddrSecondaryDescText = utils.readTestData("claimDetails","property","claimLodged","homeRiskAddrSecondaryDesc");
//        String expctdIncidentLossCauseText = utils.readTestData("claimDetails","property","claimLodged","whatHappened");
//        String expctdAccidentTypeText = utils.readTestData("claimDetails","property","claimLodged","accidentType");
//        String expctdEventDate = utils.readTestData("claimDetails","property","claimLodged","eventDate");
//        
//        navigateToFapiSettingsPage(username, pwd);
//        fapiSettingsPage.navigateToClaimDetails(claimNumber);
//		Assert.assertNotNull(common.checkLoadingIndicator(), "Loading Indicator is not displayed");
//		Assert.assertEquals(claimDetailsPage.getClaimNumberLabelText(),Copy.CLAIM_NUMBER_LABEL,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getClaimNumberText(),claimNumber,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getProductTypeText(),expctdProductTypeText,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getHomeRiskAddrLabelText(),expctdHomeRiskAddrLabelText,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.gethomeRiskAddrPrimaryDescText(),expctdhomeRiskAddrPrimaryDescText,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.gethomeRiskAddrSecondaryDescText(),expctdhomeRiskAddrSecondaryDescText,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getIncidentLossCauseLabel(),Copy.WHAT_HAPPENED_LABEL,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getIncidentLossCauseValue(),expctdIncidentLossCauseText,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getIncidentSubLossCauseLabel(),Copy.ACCIDENT_TYPE_LABEL,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getIncidentSubLossCauseValue(),expctdAccidentTypeText,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getEventDateValue(),expctdEventDate,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getEventDateLabel(),Copy.EVENT_DATE_LABEL,"policy end year is incorrect");
//		
//	}
//	
	@TestDetails(story1 = "DMPM-3724:DMPM-4348", priority = Priority.LOW)
	@Test(groups = { "marketplace", "pin", "priority-minor" })
	public void testPropertyClaimStageValues() {

		String username = utils.readTestData("claimDetails", "login");
		String pwd = utils.readTestData("claimDetails", "pwd");

		String claimLodgeNumber =utils.readTestData("claimDetails", "property", "claimLodged", "claimNumber");
		String claimInProgressNumber=utils.readTestData("claimDetails", "property", "claimInProgress", "claimNumber");
		String assessmentCompleteNumber =utils.readTestData("claimDetails", "property", "assessmentComplete", "claimNumber");
		String claimSettledAsAdvisedNumber =utils.readTestData("claimDetails", "property", "claimSettledAsAdvised", "claimNumber") ;
		
		String claimLodgeLabel =utils.readTestData("claimDetails", "property", "claimLodged", "claimStageLabel");
		String claimInProgressLabel=utils.readTestData("claimDetails", "property", "claimInProgress", "claimStageLabel");
		String assessmentCompleteLabel =utils.readTestData("claimDetails", "property", "assessmentComplete", "claimStageLabel");
		String claimSettledAsAdvisedLabel =utils.readTestData("claimDetails", "property", "claimSettledAsAdvised", "claimStageLabel") ;
		
	
		String claimLodgeValue= utils.readTestData("claimDetails", "property", "claimLodged", "claimStageValue");
		String claimInProgressValue =	utils.readTestData("claimDetails", "property", "claimInProgress", "claimStageValue");
		String assessmentCompleteValue =	utils.readTestData("claimDetails", "property", "assessmentComplete", "claimStageValue");
		String claimSettledAsAdvisedValue =	utils.readTestData("claimDetails", "property", "claimSettledAsAdvised", "claimStageValue");

		navigateToFapiSettingsPage(username, pwd);
		fapiSettingsPage.navigateToClaimDetails(claimLodgeNumber);
		common.checkLoadingIndicator();
		claimDetailsPage.scrollToClaimStageLabel();
		Assert.assertTrue(claimDetailsPage.isClaimStageOneEnabled(),"");
		Assert.assertFalse(claimDetailsPage.isClaimStageTwoEnabled(),"");
		Assert.assertFalse(claimDetailsPage.isClaimStageThreeEnabled(),"");
		Assert.assertFalse(claimDetailsPage.isClaimStageFourEnabled(),"");
		assertClaimStageLabelAndValue(claimLodgeLabel,claimLodgeValue);
		
		claimDetailsPage.tapNavigateBackButton();
		fapiSettingsPage.navigateToClaimDetails(claimInProgressNumber);
		common.checkLoadingIndicator();
		claimDetailsPage.scrollToClaimStageLabel();
		Assert.assertTrue(claimDetailsPage.isClaimStageOneEnabled(),"");
		Assert.assertTrue(claimDetailsPage.isClaimStageTwoEnabled(),"");
		Assert.assertFalse(claimDetailsPage.isClaimStageThreeEnabled(),"");
		Assert.assertFalse(claimDetailsPage.isClaimStageFourEnabled(),"");
		assertClaimStageLabelAndValue(claimInProgressLabel,claimInProgressValue);
		
		claimDetailsPage.tapNavigateBackButton();
		fapiSettingsPage.navigateToClaimDetails(assessmentCompleteNumber);
		common.checkLoadingIndicator();
		claimDetailsPage.scrollToClaimStageLabel();
		Assert.assertTrue(claimDetailsPage.isClaimStageOneEnabled(),"");
		Assert.assertTrue(claimDetailsPage.isClaimStageTwoEnabled(),"");
		Assert.assertTrue(claimDetailsPage.isClaimStageThreeEnabled(),"");
		Assert.assertFalse(claimDetailsPage.isClaimStageFourEnabled(),"");
		assertClaimStageLabelAndValue(assessmentCompleteLabel,assessmentCompleteValue);
		
		claimDetailsPage.tapNavigateBackButton();
		fapiSettingsPage.navigateToClaimDetails(claimSettledAsAdvisedNumber);
		common.checkLoadingIndicator();
		claimDetailsPage.scrollToClaimStageLabel();
		Assert.assertTrue(claimDetailsPage.isClaimStageOneEnabled(),"");
		Assert.assertTrue(claimDetailsPage.isClaimStageTwoEnabled(),"");
		Assert.assertTrue(claimDetailsPage.isClaimStageThreeEnabled(),"");
		Assert.assertTrue(claimDetailsPage.isClaimStageFourEnabled(),"");
		assertClaimStageLabelAndValue(claimSettledAsAdvisedLabel,claimSettledAsAdvisedValue);
	}
	
	
	private void navigateToFapiSettingsPage(String userName, String pwd) {
		
		loginToApp(userName, pwd);
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.scrollToDevSettings();
		navigationMenu.tapDevSettings();
		
	}
	
	
	private void assertClaimStageLabelAndValue(String stageLabel,String stageValue) {
		
			Assert.assertEquals(claimDetailsPage.claimStageLabel(), stageLabel, String.format("%s is not displayed", stageLabel));
			Assert.assertEquals(claimDetailsPage.claimStageValue(), stageValue, String.format("%s is not displayed", stageValue));
	}
	

}
	
  
	

