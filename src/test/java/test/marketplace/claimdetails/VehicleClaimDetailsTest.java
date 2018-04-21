package test.marketplace.claimdetails;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import automation.framework.common.TestDetails.Priority;
import pages.App;

public class VehicleClaimDetailsTest extends App{

	@TestDetails(story1 = "DMPM-3724:DMPM-4348", priority = Priority.LOW)
	@Test(groups = { "marketplace", "pin", "priority-minor" })
	public void testvehicleClaimDetails() {
		
		String username = utils.readTestData("claimDetails","login");
		String pwd = utils.readTestData("claimDetails", "pwd");
        String claimNumber = utils.readTestData("claimDetails","vehicle","claimLodged","claimNumber");
        String expctdProductTypeText = utils.readTestData("claimDetails","vehicle","claimLodged","insuranceType");
        String expctdVehicleRiskLabelText = utils.readTestData("claimDetails","vehicle","claimLodged","vehicleRisk");
        String expctdVehicleRiskPrimaryDescText = utils.readTestData("claimDetails","vehicle","claimLodged","vehicleRiskPrimaryDesc");
        String expctdVehicleRiskSecondaryDescText = utils.readTestData("claimDetails","vehicle","claimLodged","vehicleRiskSecondaryDesc");
        String expctdIncidentLossCauseText = utils.readTestData("claimDetails","vehicle","claimLodged","whatHappened");
        String expctdAccidentTypeText = utils.readTestData("claimDetails","vehicle","claimLodged","accidentType");
        String expctdEventDate = utils.readTestData("claimDetails","vehicle","claimLodged","eventDate");
        
        navigateToFapiSettingsPage(username, pwd);
        fapiSettingsPage.navigateToClaimDetails(claimNumber);
		Assert.assertNotNull(common.checkLoadingIndicator(), "Loading Indicator is not displayed");
		Assert.assertEquals(claimDetailsPage.getClaimNumberLabelText(),Copy.CLAIM_NUMBER_LABEL,"Claim Number Label Textis incorrect");
		Assert.assertEquals(claimDetailsPage.getClaimNumberText(),claimNumber,"Claim Number Text is incorrect");
		Assert.assertEquals(claimDetailsPage.getProductTypeText(),expctdProductTypeText,"Product Type Text is incorrect");
		Assert.assertEquals(claimDetailsPage.getHomeRiskAddrLabelText(),expctdVehicleRiskLabelText,"Home Risk Addr Label Textis incorrect");
		Assert.assertEquals(claimDetailsPage.getHomeRiskAddrPrimaryDescText(),expctdVehicleRiskPrimaryDescText,"Home Risk Addr Primary Desc Text is incorrect");
		Assert.assertEquals(claimDetailsPage.getHomeRiskAddrSecondaryDescText(),expctdVehicleRiskSecondaryDescText,"Home Risk Addr Secondary Desc Text is incorrect");
		Assert.assertEquals(claimDetailsPage.getIncidentLossCauseLabel(),Copy.WHAT_HAPPENED_LABEL,"Incident Loss Cause Labelis incorrect");
		Assert.assertEquals(claimDetailsPage.getIncidentLossCauseValue(),expctdIncidentLossCauseText,"Incident Loss Cause Value is incorrect");
		Assert.assertEquals(claimDetailsPage.getIncidentSubLossCauseLabel(),Copy.ACCIDENT_TYPE_LABEL,"Incident Sub Loss Cause Labelis incorrect");
		Assert.assertEquals(claimDetailsPage.getIncidentSubLossCauseValue(),expctdAccidentTypeText,"Incident Sub Loss Cause Value is incorrect");
		Assert.assertEquals(claimDetailsPage.getEventDateValue(),expctdEventDate,"Event Date Value is incorrect");
		Assert.assertEquals(claimDetailsPage.getEventDateLabel(),Copy.EVENT_DATE_LABEL,"Event Date Label is incorrect");
		
	}
	
	@TestDetails(story1 = "DMPM-3724:DMPM-4348", priority = Priority.LOW)
	@Test(groups = { "marketplace", "pin", "priority-minor" })
	public void testvehicleClaimStageValues() {

		String username = utils.readTestData("claimDetails", "login");
		String pwd = utils.readTestData("claimDetails", "pwd");
		String claimLodgeClaimNumber =utils.readTestData("claimDetails", "vehicle", "claimLodged", "claimNumber");
		String damageReviewClaimNumber=utils.readTestData("claimDetails", "vehicle", "damageReview", "claimNumber");
		String repairClaimNumber =utils.readTestData("claimDetails", "vehicle", "repair", "claimNumber");
		String claimCompletedClaimNumber =utils.readTestData("claimDetails", "vehicle", "claimCompleted", "claimNumber") ;
		String claimLodgeLabel =utils.readTestData("claimDetails", "vehicle", "claimLodged", "claimStageLabel");
		String damageReviewLabel=utils.readTestData("claimDetails", "vehicle", "damageReview", "claimStageLabel");
		String repairLabel =utils.readTestData("claimDetails", "vehicle", "repair", "claimStageLabel");
		String claimCompletedLabel =utils.readTestData("claimDetails", "vehicle", "claimCompleted", "claimStageLabel") ;
		String claimLodgeValue= utils.readTestData("claimDetails", "vehicle", "claimLodged", "claimStageValue");
		String damageReviewValue =	utils.readTestData("claimDetails", "vehicle", "damageReview", "claimStageValue");
		String repairValue =	utils.readTestData("claimDetails", "vehicle", "repair", "claimStageValue");
		String claimCompletedValue =	utils.readTestData("claimDetails", "vehicle", "claimCompleted", "claimStageValue");

		navigateToFapiSettingsPage(username, pwd);
		fapiSettingsPage.navigateToClaimDetails(claimLodgeClaimNumber);
		common.checkLoadingIndicator();
		claimDetailsPage.scrollToClaimStageLabel();
		Assert.assertTrue(claimDetailsPage.isClaimStageOneEnabled(),"Claim Stage One is not Enabled");
		Assert.assertFalse(claimDetailsPage.isClaimStageTwoEnabled(),"Claims Stage Two is Enabled");
		Assert.assertFalse(claimDetailsPage.isClaimStageThreeEnabled(),"Claims Stage Three is Enabled");
		Assert.assertFalse(claimDetailsPage.isClaimStageFourEnabled(),"Claims Stage Four is Enabled");
		assertClaimStageLabelAndValue(claimLodgeLabel,claimLodgeValue);
		
		claimDetailsPage.tapNavigateBackButton();
		fapiSettingsPage.navigateToClaimDetails(damageReviewClaimNumber);
		common.checkLoadingIndicator();
		claimDetailsPage.scrollToClaimStageLabel();
		Assert.assertTrue(claimDetailsPage.isClaimStageOneEnabled(),"Claim Stage One is not Enabled");
		Assert.assertTrue(claimDetailsPage.isClaimStageTwoEnabled(),"Claim Stage Two is not Enabled");
		Assert.assertFalse(claimDetailsPage.isClaimStageThreeEnabled(),"Claims Stage Three is Enabled");
		Assert.assertFalse(claimDetailsPage.isClaimStageFourEnabled(),"Claims Stage Four is Enabled");
		assertClaimStageLabelAndValue(damageReviewLabel,damageReviewValue);
		
		claimDetailsPage.tapNavigateBackButton();
		fapiSettingsPage.navigateToClaimDetails(repairClaimNumber);
		common.checkLoadingIndicator();
		claimDetailsPage.scrollToClaimStageLabel();
		Assert.assertTrue(claimDetailsPage.isClaimStageOneEnabled(),"Claim Stage One is not Enabled");
		Assert.assertTrue(claimDetailsPage.isClaimStageTwoEnabled(),"Claim Stage Two is not Enabled");
		Assert.assertTrue(claimDetailsPage.isClaimStageThreeEnabled(),"Claims Stage Three is not Enabled");
		Assert.assertFalse(claimDetailsPage.isClaimStageFourEnabled(),"Claims Stage Four is Enabled");
		assertClaimStageLabelAndValue(repairLabel,repairValue);
		
		claimDetailsPage.tapNavigateBackButton();
		fapiSettingsPage.navigateToClaimDetails(claimCompletedClaimNumber);
		common.checkLoadingIndicator();
		claimDetailsPage.scrollToClaimStageLabel();
		Assert.assertTrue(claimDetailsPage.isClaimStageOneEnabled(),"Claim Stage One is not Enabled");
		Assert.assertTrue(claimDetailsPage.isClaimStageTwoEnabled(),"Claim Stage Two is not Enabled");
		Assert.assertTrue(claimDetailsPage.isClaimStageThreeEnabled(),"Claims Stage Three is not Enabled");
		Assert.assertTrue(claimDetailsPage.isClaimStageFourEnabled(),"Claims Stage Four is not Enabled");
		assertClaimStageLabelAndValue(claimCompletedLabel,claimCompletedValue);
	}

	@TestDetails(story1 = "DMPM-3724:DMPM-4348", priority = Priority.LOW)
	@Test(groups = { "marketplace", "pin", "priority-minor" })
	public void testvehicleAndPropertyExcessNotPaid() {

		String username = utils.readTestData("claimDetails", "login");
		String pwd = utils.readTestData("claimDetails", "pwd");
		String claimNumber = utils.readTestData("claimDetails", "vehicle", "claimLodged", "claimNumber");
		String expctdTotalExccess = utils.readTestData("claimDetails", "vehicle", "claimLodged", "excess",
				"yourTotalExccess");

		navigateToFapiSettingsPage(username, pwd);
		fapiSettingsPage.navigateToClaimDetails(claimNumber);
		Assert.assertEquals(claimDetailsPage.getExcessTitle(), Copy.YOUR_EXCESS_TOTAL_LABEL, "YOUR EXCESS TOTAL LABEL is incorrect");
		Assert.assertEquals(claimDetailsPage.getYourTotalAcessAmount(), expctdTotalExccess,
				"Your Total Acess Amount is incorrect");

	}

	@TestDetails(story1 = "DMPM-3724:DMPM-4348", priority = Priority.LOW)
	@Test(groups = { "marketplace", "pin", "priority-minor" })
	public void testvehicleAndPropertyExcessZero() {

		String username = utils.readTestData("claimDetails", "login");
		String pwd = utils.readTestData("claimDetails", "pwd");
		String claimNumber = utils.readTestData("claimDetails", "vehicle", "claimLodged", "excess","zeroExcess","claimNumber");
		String expctdTotalExccess = utils.readTestData("claimDetails", "vehicle", "claimLodged", "excess", "zeroExcess","yourTotalExccess");

		navigateToFapiSettingsPage(username, pwd);
		fapiSettingsPage.navigateToClaimDetails(claimNumber);
		Assert.assertEquals(claimDetailsPage.getYourTotalAcessAmount(), expctdTotalExccess,
				"Your Total Acess Amount is incorrect");

	}
	
	@TestDetails(story1 = "DMPM-3724:DMPM-4348", priority = Priority.LOW)
	@Test(groups = { "marketplace", "pin", "priority-minor" })
	public void testVehicleAndPropertyPartialExcess() {

		String username = utils.readTestData("claimDetails", "login");
		String pwd = utils.readTestData("claimDetails", "pwd");
		String claimNumber = utils.readTestData("claimDetails", "property", "assessmentComplete","claimNumber");
		String expctdOutstandingExcess = utils.readTestData("claimDetails", "property", "assessmentComplete", "excess","yourOutstandingExcess");
		String expctdExcessRecieved = utils.readTestData("claimDetails", "property", "assessmentComplete", "excess","excessRecieved");
		String expectedTotalExcess =utils.readTestData("claimDetails", "property", "assessmentComplete", "excess","totalExcess");

		navigateToFapiSettingsPage(username, pwd);
		fapiSettingsPage.navigateToClaimDetails(claimNumber);
		Assert.assertEquals(claimDetailsPage.getExcessTitle(),Copy.OUTSTANDING_EXCESS_TITLE_LABEL ,"Excess Title Label is incorrect");
		Assert.assertEquals(claimDetailsPage.getYourTotalAcessAmount(), expctdOutstandingExcess,"Your Total Acess Amount is incorrect");
		Assert.assertEquals(claimDetailsPage.getExcessTitle(),Copy.EXCESS_RECIEVED_LABEL ,".Excess Title is incorrect");
		Assert.assertEquals(claimDetailsPage.getExcessPaidAmount(), expctdExcessRecieved,"Excess Paid Amount is incorrect");
		Assert.assertEquals(claimDetailsPage.getPartialExcessTotalTitle(),Copy.EXCESS_TOTAL_EXCESS_LABEL ,"Partial Excess Total Title is incorrect");
		Assert.assertEquals(claimDetailsPage.getPartialExcessTotalAmount(), expectedTotalExcess,"Partial Excess Total Amount is incorrect");
	}
	
	
	@TestDetails(story1 = "DMPM-3724:DMPM-4348", priority = Priority.LOW)
	@Test(groups = { "marketplace", "pin", "priority-minor" })
	public void testvehicleAndPropertyExcessPaid() {

		String username = utils.readTestData("claimDetails", "login");
		String pwd = utils.readTestData("claimDetails", "pwd");
		String claimNumber = utils.readTestData("claimDetails", "vehicle", "repair","claimNumber");
		String expctdReferenceNumber = utils.readTestData("claimDetails", "vehicle", "repair", "excess", "referenceNumber");
		String expctdPaidExcess = utils.readTestData("claimDetails", "vehicle", "repair", "excess", "paidExcess");
		
		navigateToFapiSettingsPage(username, pwd);
		fapiSettingsPage.navigateToClaimDetails(claimNumber);
		Assert.assertEquals(claimDetailsPage.getExcessTitle(), Copy.YOUR_PAID_EXCESS_LABEL,"Excess Title is incorrect");
		Assert.assertEquals(claimDetailsPage.getYourTotalAcessAmount(), expctdPaidExcess,"Your Total Acess Amount is incorrect");
		Assert.assertEquals(claimDetailsPage.getPaymentReferenceNumberLabel(),Copy.REFERENCE_NUMBER_LABEL,"Payment Reference Number Label is incorrect");
		Assert.assertEquals(claimDetailsPage.getPaymentReferenceNumber(),expctdReferenceNumber,"Payment Reference Number is incorrect");
		Assert.assertEquals(claimDetailsPage.getPaidButtonText(),Copy.PAID_BUTTON_LABEL,"Paid Button Text is incorrect");
		
	}
	
	
	@TestDetails(story1 = "DMPM-3724:DMPM-4348", priority = Priority.LOW)
	@Test(groups = { "marketplace", "pin", "priority-minor" })
	public void testVehicleClaim(){
		
		String username = utils.readTestData("claimDetails","login");
		String pwd = utils.readTestData("claimDetails", "pwd");
        String claimNumber = utils.readTestData("claimDetails","vehicle","damageReview","claimNumber");
		String [] nextActions = {Copy.CHECK_CLAIM_UPDATES_LABEL,Copy.DOWNLOAD_DOCUMENTS_LABEL,Copy.UPLOAD_DOCUMENTS_LABEL,Copy.VIEW_ITEMS_DAMAGED_AND_LOST_LABEL};
		String [] mcmTitle = {Copy.CHECK_CLAIM_UPDATES_TITLE,Copy.DOWNLOAD_DOCUMENTS_TITLE,Copy.UPLOAD_DOCUMENTS_TITLE,Copy.VIEW_ITEMS_DAMAGED_AND_LOST_TITLE};

        navigateToFapiSettingsPage(username, pwd);
        fapiSettingsPage.navigateToClaimDetails(claimNumber);
        claimDetailsPage.scrollToEventDateLabel();
		Assert.assertNotNull(claimDetailsPage.checkNextActionsLabel(Copy.CHECK_CLAIM_UPDATES_LABEL),"Check Claim Updates Label is incorrect");
		Assert.assertNotNull(claimDetailsPage.checkNextActionsLabel(Copy.DOWNLOAD_DOCUMENTS_LABEL),"Download Documents Label is incorrect");
		Assert.assertNotNull(claimDetailsPage.checkNextActionsLabel(Copy.UPLOAD_DOCUMENTS_LABEL),"Upload Documents Label is incorrect");
		Assert.assertNotNull(claimDetailsPage.checkNextActionsLabel(Copy.VIEW_ITEMS_DAMAGED_AND_LOST_LABEL),"View Items Damaged And Lost Label is incorrect");
		assertMCMWebview(nextActions,mcmTitle);
		
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
	
	private void assertMCMWebview(String [] nextActions,String [] mcmTitle){
		
		for (int i = 0; i < nextActions.length; i++) {
			claimDetailsPage.tapNextActionsLabel(nextActions[i]);
			Assert.assertNotNull(claimDetailsPage.checkClaimDetailsTitle(mcmTitle[i]), mcmTitle + " is not displayed");
			Assert.assertNotNull(webviewPage.checkWebview(), "");
			nextActionWebViewPage.tapCloseButton();
			common.waitForLoadingIndicatorToDisappear();
			Assert.assertNotNull(claimDetailsPage.checkClaimDetailsTitle(Copy.CLAIM_DETAILS_TITLE), "");
		}
	
	}

}
