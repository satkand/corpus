package test.marketplace.claimdetails;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import automation.framework.common.TestDetails.Priority;
import pages.App;

public class VehicleClaimDetailsTest extends App{
	
//	
//
//	@TestDetails(story1 = "DMPM-3724:DMPM-4348", priority = Priority.LOW)
//	@Test(groups = { "marketplace", "pin", "priority-minor" })
//	public void testvehicleClaim() {
//		
//		String username = utils.readTestData("claimDetails","login");
//		String pwd = utils.readTestData("claimDetails", "pwd");
//        String claimNumber = utils.readTestData("claimDetails","vehicle","claimLodged","claimNumber");
//        String expctdProductTypeText = utils.readTestData("claimDetails","vehicle","claimLodged","insuranceType");
//        String expctdVehicleRiskLabelText = utils.readTestData("claimDetails","vehicle","claimLodged","vehicleRisk");
//        String expctdVehicleRiskPrimaryDescText = utils.readTestData("claimDetails","vehicle","claimLodged","vehicleRiskPrimaryDesc");
//        String expctdVehicleRiskSecondaryDescText = utils.readTestData("claimDetails","vehicle","claimLodged","vehicleRiskSecondaryDesc");
//        String expctdIncidentLossCauseText = utils.readTestData("claimDetails","vehicle","claimLodged","whatHappened");
//        String expctdAccidentTypeText = utils.readTestData("claimDetails","vehicle","claimLodged","accidentType");
//        String expctdEventDate = utils.readTestData("claimDetails","vehicle","claimLodged","eventDate");
//        
//        navigateToFapiSettingsPage(username, pwd);
//        fapiSettingsPage.navigateToClaimDetails(claimNumber);
//		Assert.assertNotNull(common.checkLoadingIndicator(), "Loading Indicator is not displayed");
//		Assert.assertEquals(claimDetailsPage.getClaimNumberLabelText(),Copy.CLAIM_NUMBER_LABEL,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getClaimNumberText(),claimNumber,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getProductTypeText(),expctdProductTypeText,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getHomeRiskAddrLabelText(),expctdVehicleRiskLabelText,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.gethomeRiskAddrPrimaryDescText(),expctdVehicleRiskPrimaryDescText,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.gethomeRiskAddrSecondaryDescText(),expctdVehicleRiskSecondaryDescText,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getIncidentLossCauseLabel(),Copy.WHAT_HAPPENED_LABEL,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getIncidentLossCauseValue(),expctdIncidentLossCauseText,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getIncidentSubLossCauseLabel(),Copy.ACCIDENT_TYPE_LABEL,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getIncidentSubLossCauseValue(),expctdAccidentTypeText,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getEventDateValue(),expctdEventDate,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getEventDateLabel(),Copy.EVENT_DATE_LABEL,"policy end year is incorrect");
//		
//	}
//	
//	@TestDetails(story1 = "DMPM-3724:DMPM-4348", priority = Priority.LOW)
//	@Test(groups = { "marketplace", "pin", "priority-minor" })
//	public void testvehicleClaimStageValues() {
//
//		String username = utils.readTestData("claimDetails", "login");
//		String pwd = utils.readTestData("claimDetails", "pwd");
//
//		String claimLodgeClaimNumber =utils.readTestData("claimDetails", "vehicle", "claimLodged", "claimNumber");
//		String damageReviewClaimNumber=utils.readTestData("claimDetails", "vehicle", "damageReview", "claimNumber");
//		String repairClaimNumber =utils.readTestData("claimDetails", "vehicle", "repair", "claimNumber");
//		String claimCompletedClaimNumber =utils.readTestData("claimDetails", "vehicle", "claimCompleted", "claimNumber") ;
//		
//		String claimLodgeLabel =utils.readTestData("claimDetails", "vehicle", "claimLodged", "claimStageLabel");
//		String damageReviewLabel=utils.readTestData("claimDetails", "vehicle", "damageReview", "claimStageLabel");
//		String repairLabel =utils.readTestData("claimDetails", "vehicle", "repair", "claimStageLabel");
//		String claimCompletedLabel =utils.readTestData("claimDetails", "vehicle", "claimCompleted", "claimStageLabel") ;
//		
//	
//		String claimLodgeValue= utils.readTestData("claimDetails", "vehicle", "claimLodged", "claimStageValue");
//		String damageReviewValue =	utils.readTestData("claimDetails", "vehicle", "damageReview", "claimStageValue");
//		String repairValue =	utils.readTestData("claimDetails", "vehicle", "repair", "claimStageValue");
//		String claimCompletedValue =	utils.readTestData("claimDetails", "vehicle", "claimCompleted", "claimStageValue");
//
//		navigateToFapiSettingsPage(username, pwd);
//		fapiSettingsPage.navigateToClaimDetails(claimLodgeClaimNumber);
//		common.checkLoadingIndicator();
//		claimDetailsPage.scrollToClaimStageLabel();
//		Assert.assertTrue(claimDetailsPage.isClaimStageOneEnabled(),"");
//		Assert.assertFalse(claimDetailsPage.isClaimStageTwoEnabled(),"");
//		Assert.assertFalse(claimDetailsPage.isClaimStageThreeEnabled(),"");
//		Assert.assertFalse(claimDetailsPage.isClaimStageFourEnabled(),"");
//		assertClaimStageLabelAndValue(claimLodgeLabel,claimLodgeValue);
//		
//		claimDetailsPage.tapNavigateBackButton();
//		fapiSettingsPage.navigateToClaimDetails(damageReviewClaimNumber);
//		common.checkLoadingIndicator();
//		claimDetailsPage.scrollToClaimStageLabel();
//		Assert.assertTrue(claimDetailsPage.isClaimStageOneEnabled(),"");
//		Assert.assertTrue(claimDetailsPage.isClaimStageTwoEnabled(),"");
//		Assert.assertFalse(claimDetailsPage.isClaimStageThreeEnabled(),"");
//		Assert.assertFalse(claimDetailsPage.isClaimStageFourEnabled(),"");
//		assertClaimStageLabelAndValue(damageReviewLabel,damageReviewValue);
//		
//		claimDetailsPage.tapNavigateBackButton();
//		fapiSettingsPage.navigateToClaimDetails(repairClaimNumber);
//		common.checkLoadingIndicator();
//		claimDetailsPage.scrollToClaimStageLabel();
//		Assert.assertTrue(claimDetailsPage.isClaimStageOneEnabled(),"");
//		Assert.assertTrue(claimDetailsPage.isClaimStageTwoEnabled(),"");
//		Assert.assertTrue(claimDetailsPage.isClaimStageThreeEnabled(),"");
//		Assert.assertFalse(claimDetailsPage.isClaimStageFourEnabled(),"");
//		assertClaimStageLabelAndValue(repairLabel,repairValue);
//		
//		claimDetailsPage.tapNavigateBackButton();
//		fapiSettingsPage.navigateToClaimDetails(claimCompletedClaimNumber);
//		common.checkLoadingIndicator();
//		claimDetailsPage.scrollToClaimStageLabel();
//		Assert.assertTrue(claimDetailsPage.isClaimStageOneEnabled(),"");
//		Assert.assertTrue(claimDetailsPage.isClaimStageTwoEnabled(),"");
//		Assert.assertTrue(claimDetailsPage.isClaimStageThreeEnabled(),"");
//		Assert.assertTrue(claimDetailsPage.isClaimStageFourEnabled(),"");
//		assertClaimStageLabelAndValue(claimCompletedLabel,claimCompletedValue);
//	}
//
//	@TestDetails(story1 = "DMPM-3724:DMPM-4348", priority = Priority.LOW)
//	@Test(groups = { "marketplace", "pin", "priority-minor" })
//	public void testvehicleAndPropertyExcessNotPaid() {
//
//		String username = utils.readTestData("claimDetails", "login");
//		String pwd = utils.readTestData("claimDetails", "pwd");
//		String claimNumber = utils.readTestData("claimDetails", "vehicle", "claimLodged", "claimNumber");
//		String expctdTotalExccess = utils.readTestData("claimDetails", "vehicle", "claimLodged", "excess",
//				"yourTotalExccess");
//
//		navigateToFapiSettingsPage(username, pwd);
//		fapiSettingsPage.navigateToClaimDetails(claimNumber);
//		Assert.assertEquals(claimDetailsPage.getExcessTitle(), Copy.YOUR_EXCESS_TOTAL_LABEL, "policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getYourTotalAcessAmount(), expctdTotalExccess,
//				"policy end year is incorrect");
//
//	}
//
//	@TestDetails(story1 = "DMPM-3724:DMPM-4348", priority = Priority.LOW)
//	@Test(groups = { "marketplace", "pin", "priority-minor" })
//	public void testvehicleAndPropertyExcessZero() {
//
//		String username = utils.readTestData("claimDetails", "login");
//		String pwd = utils.readTestData("claimDetails", "pwd");
//		String claimNumber = utils.readTestData("claimDetails", "vehicle", "claimLodged", "excess","zeroExcess","claimNumber");
//		String expctdTotalExccess = utils.readTestData("claimDetails", "vehicle", "claimLodged", "excess", "zeroExcess","yourTotalExccess");
//
//		navigateToFapiSettingsPage(username, pwd);
//		fapiSettingsPage.navigateToClaimDetails(claimNumber);
//		Assert.assertEquals(claimDetailsPage.getYourTotalAcessAmount(), expctdTotalExccess,
//				"policy end year is incorrect");
//
//	}
//	
//	@TestDetails(story1 = "DMPM-3724:DMPM-4348", priority = Priority.LOW)
//	@Test(groups = { "marketplace", "pin", "priority-minor" })
//	public void testVehicleAndPropertyPartialExcess() {
//
//		String username = utils.readTestData("claimDetails", "login");
//		String pwd = utils.readTestData("claimDetails", "pwd");
//		String claimNumber = utils.readTestData("claimDetails", "property", "assessmentComplete","claimNumber");
//		String expctdOutstandingExcess = utils.readTestData("claimDetails", "property", "assessmentComplete", "excess","yourOutstandingExcess");
//		String expctdExcessRecieved = utils.readTestData("claimDetails", "property", "assessmentComplete", "excess","excessRecieved");
//		String expectedTotalExcess =utils.readTestData("claimDetails", "property", "assessmentComplete", "excess","totalExcess");
//
//		navigateToFapiSettingsPage(username, pwd);
//		fapiSettingsPage.navigateToClaimDetails(claimNumber);
//		Assert.assertEquals(claimDetailsPage.getExcessTitle(),Copy.OUTSTANDING_EXCESS_TITLE_LABEL ,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getYourTotalAcessAmount(), expctdOutstandingExcess,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getExcessTitle(),Copy.EXCESS_RECIEVED_LABEL ,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getExcessPaidAmount(), expctdExcessRecieved,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getPartialExcessTotalTitle(),Copy.EXCESS_TOTAL_EXCESS_LABEL ,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getPartialExcessTotalAmount(), expectedTotalExcess,"policy end year is incorrect");
//	}
//	
	
//	@TestDetails(story1 = "DMPM-3724:DMPM-4348", priority = Priority.LOW)
//	@Test(groups = { "marketplace", "pin", "priority-minor" })
//	public void testvehicleAndPropertyExcessPaid() {
//
//		String username = utils.readTestData("claimDetails", "login");
//		String pwd = utils.readTestData("claimDetails", "pwd");
//		String claimNumber = utils.readTestData("claimDetails", "vehicle", "repair","claimNumber");
//		String expctdReferenceNumber = utils.readTestData("claimDetails", "vehicle", "repair", "excess", "referenceNumber");
//		String expctdPaidExcess = utils.readTestData("claimDetails", "vehicle", "repair", "excess", "paidExcess");
//		
//		navigateToFapiSettingsPage(username, pwd);
//		fapiSettingsPage.navigateToClaimDetails(claimNumber);
//		Assert.assertEquals(claimDetailsPage.getExcessTitle(), Copy.YOUR_PAID_EXCESS_LABEL,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getYourTotalAcessAmount(), expctdPaidExcess,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getPaymentReferenceNumberLabel(),Copy.REFERENCE_NUMBER_LABEL,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getPaymentReferenceNumber(),expctdReferenceNumber,"policy end year is incorrect");
//		Assert.assertEquals(claimDetailsPage.getPaidButtonText(),Copy.PAID_BUTTON_LABEL,"policy end year is incorrect");
//		
//	}
	
	
	@TestDetails(story1 = "DMPM-3724:DMPM-4348", priority = Priority.LOW)
	@Test(groups = { "marketplace", "pin", "priority-minor" })
	public void testvehicleClaim() {
		
		String username = utils.readTestData("claimDetails","login");
		String pwd = utils.readTestData("claimDetails", "pwd");
        String claimNumber = utils.readTestData("claimDetails","vehicle","claimLodged","claimNumber");
        String expctdProductTypeText = utils.readTestData("claimDetails","vehicle","claimLodged","insuranceType");
        String expctdVehicleRiskLabelText = utils.readTestData("claimDetails","vehicle","claimLodged","vehicleRisk");

        navigateToFapiSettingsPage(username, pwd);
        fapiSettingsPage.navigateToClaimDetails(claimNumber);
        claimDetailsPage.scrollToEventDateLabel();
		Assert.assertNotNull(claimDetailsPage.checkNextActionsLabel(Copy.CHECK_CLAIM_UPDATES_LABEL),"policy end year is incorrect");
		Assert.assertNotNull(claimDetailsPage.checkNextActionsLabel(Copy.DOWNLOAD_DOCUMENTS_LABEL),"policy end year is incorrect");
		Assert.assertNotNull(claimDetailsPage.checkNextActionsLabel(Copy.UPLOAD_DOCUMENTS_LABEL),"policy end year is incorrect");
		claimDetailsPage.tapNextActionsLabel(Copy.CHECK_CLAIM_UPDATES_LABEL);
		nextActionWebViewPage.closeButton();
		Assert.assertNotNull(claimDetailsPage.checkClaimDetailsTitle(Copy.CLAIM_DETAILS_TITLE),"");
		
 }
	
	private void navigateToFapiSettingsPage(String userName, String pwd) {
		
		loginToApp(userName, pwd);
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.scrollToDevSettings();
		navigationMenu.tapDevSettings();
		
	}
	
	
	private void assertClaimStageLabelAndValue(String stageLabel,String stageValue) {
		
			Assert.assertEquals(claimDetailsPage.claimStageLabel(), stageLabel, String.format("%s is incorrect", stageLabel));
			Assert.assertEquals(claimDetailsPage.claimStageValue(), stageValue, String.format("%s is incorrect", stageValue));
	}

}
