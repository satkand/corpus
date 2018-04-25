package test.marketplace.claimdetails;

import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import automation.framework.common.TestDetails.Priority;
import pages.App;

public class PropertyClaimLodgementTest extends App{
	
	@TestDetails(story1 = "DMPM-2220:DMPM-5856,DMPM-5857", priority = Priority.LOW)
	@Test(groups = { "marketplace", "claim lodgement", "priority-minor" })
	public void testDisplayClaimIntro() {

		String username = utils.readTestData("claimDetails", "login");
		String pwd = utils.readTestData("claimDetails", "pwd");
		
		navigateToFapiSettingsPage(username, pwd);
		fapiSettingsPage.tapPropertyClaimLodgementButton();
		assertClaimIntroScreen();
		claimIntroPage.tapCloseButton();
		fapiSettingsPage.tapVehicleClaimLodgementButton();
		assertClaimIntroScreen();	
		
	}
	
	@TestDetails(story1 = "DMPM-4595:DMPM-6071,DMPM-6072", priority = Priority.LOW)
	@Test(groups = { "marketplace", "claim lodgement", "priority-minor" })
	public void testDisplayPropertyAssetSummary(){

		String username = utils.readTestData("claimLodgement", "login");
		String pwd = utils.readTestData("claimLodgement", "pwd");
		String expctdPolicyDescription = utils.readTestData("claimLodgement", "property","home&Building","policyDescription");
		String expctdhomeRiskAddress = utils.readTestData("claimLodgement", "property","home&Building","homeRiskAddress");
		String [] brandNames = {utils.readTestData("claimLodgement", "property","home&Building","brand1"),utils.readTestData("claimLodgement", "property","home&Building","brand2"),
				            utils.readTestData("claimLodgement", "property","home&Building","brand3"),utils.readTestData("claimLodgement", "property","home&Building","brand4"),
				            utils.readTestData("claimLodgement", "property","home&Building","brand5"),utils.readTestData("claimLodgement", "property","home&Building","brand6")};
		navigateToFapiSettingsPage(username, pwd);
		assertPropertyPolicyDescForEachBrand(brandNames,expctdPolicyDescription);
		navigateToMakeClaimScreen(utils.readTestData("claimLodgement", "property","home&Building","brand1"),"property");
		Assert.assertEquals(makeAClaimPage.getAssetDescriptionText(),expctdhomeRiskAddress,"policy end year is incorrect");
		Assert.assertEquals(makeAClaimPage.getIncidentDateFieldLabel(),Copy.INCIDENT_DATE_FIELD_LABEL,"policy end year is incorrect");
		Assert.assertNotNull(makeAClaimPage.checkIncidentDateField(),"policy end year is incorrect");
		Assert.assertEquals(makeAClaimPage.getStartClaimButtonText(),Copy.START_CLAIM_BUTTON_LABEL,"policy end year is incorrect");
	}
	
	@TestDetails(story1 = "DMPM-4489:DMPM-6136,DMPM-6137", priority = Priority.LOW)
	@Test(groups = { "marketplace", "claim lodgement", "priority-minor" })
	public void testDisplayVehicleAssetSummary(){

		String username = utils.readTestData("claimLodgement", "login");
		String pwd = utils.readTestData("claimLodgement", "pwd");
		String expctdPolicyDescription = utils.readTestData("claimLodgement", "vehicle","car","policyDescription");
		String expctdVehicleDescription = utils.readTestData("claimLodgement", "vehicle","car","vehicleDescription");
		String expctdVehicleRegistration = utils.readTestData("claimLodgement", "vehicle","car","vehicleRegistration");
		String [] brandNames = {utils.readTestData("claimLodgement", "vehicle","car","brand1"),utils.readTestData("claimLodgement", "vehicle","car","brand2"),
				            utils.readTestData("claimLodgement", "vehicle","car","brand3"),utils.readTestData("claimLodgement", "vehicle","car","brand4"),
				            utils.readTestData("claimLodgement", "vehicle","car","brand5"),utils.readTestData("claimLodgement", "vehicle","car","brand6")};
		navigateToFapiSettingsPage(username, pwd);
		assertVehiclePolicyDescForEachBrand(brandNames,expctdPolicyDescription);
		navigateToMakeClaimScreen(utils.readTestData("claimLodgement", "vehicle","car","brand1"),"vehicle");
		Assert.assertEquals(makeAClaimPage.getAssetDescriptionText(),expctdVehicleDescription ,"policy end year is incorrect");
		Assert.assertEquals(makeAClaimPage.getRegistrationNumberText(),expctdVehicleRegistration ,"policy end year is incorrect");
		Assert.assertEquals(makeAClaimPage.getIncidentDateFieldLabel(),Copy.INCIDENT_DATE_FIELD_LABEL,"policy end year is incorrect");
		Assert.assertNotNull(makeAClaimPage.checkIncidentDateField(),"policy end year is incorrect");
		Assert.assertEquals(makeAClaimPage.getStartClaimButtonText(),Copy.START_CLAIM_BUTTON_LABEL,"policy end year is incorrect");
		
	}
	
	@TestDetails(story1 = "DMPM-2222:DMPM-6502,DMPM-6503", priority = Priority.LOW)
	@Test(groups = { "marketplace", "claim lodgement", "priority-minor" })
	public void testSelectIncidentDate() throws ParseException{

		String username = utils.readTestData("claimLodgement", "login");
		String pwd = utils.readTestData("claimLodgement", "pwd");
		String dateToBeSelected =utils.readTestData("claimLodgement", "vehicle","car","validIncidentDate"); 
		navigateToFapiSettingsPage(username, pwd);
		fapiSettingsPage.tapVehicleClaimLodgementButton();
		claimIntroPage.tapNextButton();
		Assert.assertEquals(makeAClaimPage.getIncidentDateFieldInputText(),Copy.INCIDENT_DATE_FIELD_INPUT_LABEL,"policy end year is incorrect");
		makeAClaimPage.tapIncidentDateFieldInputLayout();
		Assert.assertNotNull(makeAClaimPage.checkDatePickerHeaderYear(),"Date Picker Header Year is not displayed");
		Assert.assertNotNull(makeAClaimPage.checkDatePickerHeaderDate(),"Date Picker Header Date is not displayed");
		Assert.assertNotNull(makeAClaimPage.checkMonthView(),"Date Picker month view is not displayed");
		makeAClaimPage.selectDate(dateToBeSelected);
		Assert.assertEquals(makeAClaimPage.getIncidentDateFieldText(),dateToBeSelected,"Date not set properly");
	}
	
	@TestDetails(story1 = "DMPM-2222:DMPM-6504,DMPM-6505", priority = Priority.LOW)
	@Test(groups = { "marketplace", "claim lodgement", "priority-minor" })
	public void testInvalidIncidentDate() throws ParseException{

		String username = utils.readTestData("claimLodgement", "login");
		String pwd = utils.readTestData("claimLodgement", "pwd");
		String dateToBeSelected =utils.readTestData("claimLodgement", "vehicle","car","futureIncidentDate"); 
		navigateToFapiSettingsPage(username, pwd);
		fapiSettingsPage.tapVehicleClaimLodgementButton();
		claimIntroPage.tapNextButton();
		makeAClaimPage.tapStartClaimButton();
		Assert.assertEquals(makeAClaimPage.getInLineErrorMsgText(),Copy.EMPTY_DATE_ERROR_MSG,"Empty date error message not displayed");
		makeAClaimPage.tapIncidentDateFieldInputLayout();
		makeAClaimPage.selectDate(dateToBeSelected);
		Assert.assertEquals(makeAClaimPage.getInLineErrorMsgText(),Copy.FUTURE_DATE_ERROR_MSG,"Future date error message not displayed");
	}
	
	private void navigateToFapiSettingsPage(String userName, String pwd) {
		
		loginToApp(userName, pwd);
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.scrollToDevSettings();
		navigationMenu.tapDevSettings();
		
	}
	
	private void assertPropertyPolicyDescForEachBrand(String [] brandnames,String expctdPolicyDescription){
		
		for(int i=0;i<brandnames.length;i++) {	
			
			String expectedBrandName = brandnames[i];
			
			navigateToMakeClaimScreen(expectedBrandName,"property");
			
			if(expectedBrandName.equals(utils.readTestData("claimLodgement", "property","home&Building","brand2"))) {
				
				expectedBrandName = brandnames[i].toUpperCase();
			}
			Assert.assertEquals(makeAClaimPage.getPolicyDescriptionTitle(),expectedBrandName+" "+expctdPolicyDescription,"policy discription is incorrect for "+brandnames[i]);
			makeAClaimPage.tapNavigateBackButton();
			
		}
	}
		private void assertVehiclePolicyDescForEachBrand(String [] brandnames,String expctdPolicyDescription){
			
			for(int i=0;i<brandnames.length;i++) {	
				
				String expectedBrandName = brandnames[i];
				
				navigateToMakeClaimScreen(expectedBrandName,"vehicle");
				
				if(expectedBrandName.equals(utils.readTestData("claimLodgement", "vehicle","car","brand2"))) {
					
					expectedBrandName = brandnames[i].toUpperCase();
				}
				Assert.assertEquals(makeAClaimPage.getPolicyDescriptionTitle(),expectedBrandName+" "+expctdPolicyDescription,"policy description is incorrect for "+brandnames[i]);
				makeAClaimPage.tapNavigateBackButton();
				
			}
		
	}
	public void navigateToMakeClaimScreen(String brandName,String policyType) {
		
		if(policyType.equals("property")) {
		fapiSettingsPage.selectPropertyBrand(brandName);
		fapiSettingsPage.tapPropertyClaimLodgementButton();
		
		}else {
			fapiSettingsPage.scrollToVehicleClaimLodgementButton();
			fapiSettingsPage.selectVehicleBrand(brandName);
			fapiSettingsPage.tapVehicleClaimLodgementButton();
		}
		claimIntroPage.tapNextButton();
	}
	
	private void assertClaimIntroScreen() {
		Assert.assertEquals(claimIntroPage.getClaimPrerequisiteTitleText(),Copy.CLAIM_PREREQUISITE_TITLE,"Claim Prerequisite Title is incorrect");
		Assert.assertEquals(claimIntroPage.getClaimInstructionFileText(),Copy.CLAIM_INSTRUCTION_FILE_LABEL,"Claim Instruction File label is incorrect");
		Assert.assertEquals(claimIntroPage.getClaimInstructionDocsText(),Copy.CLAIM_INSTRUCTION_DOCS_LABEL,"Claim Instruction Docs label is incorrect");
		Assert.assertEquals(claimIntroPage.getClaimInstructionPeopleText(),Copy.CLAIM_INSTRUCTION_PEOPLE,"Claim Instruction People is incorrect");
		Assert.assertEquals(claimIntroPage.getClaimInstructionSubmitText(),Copy.CLAIM_INSTRUCTION_SUBMIT,"Claim Instruction Submit is incorrect");
		Assert.assertNotNull(claimIntroPage.checkNextButton(), "Next button is not displyed");
	}

}
