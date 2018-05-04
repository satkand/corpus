package test.marketplace.vehicles;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import pages.App;
import pages.marketplace.vehicles.VehiclesPage;

public class VehiclesTest extends App {

	// 507 - Scenario 1
	// 507 - Scenario 2
	// 1052 - Scenario 1
	//	@Test (groups = {"DMPM-507", "DMPM-1284", "DMPM-1290", "DMPM-1052", "DMPM-1320", "marketplace", "Vehicle dimension", "priority-minor"})
	public void testVehiclesListOnVehiclesPage() {
		navigateToVehiclesTab("hasVehicles");
		vehiclesPage.waitForDataToLoad();

		int i = 0;

		List vehicleDescriptionList = vehiclesPage.fetchVehicleDescriptionList();
		List vehicleRegistrationNumberList = vehiclesPage.fetchVehicleRegistrationNumberList();

		List vehicleImageTypeList = vehiclesPage.fetchVehicleTypeImageList();
		List addPhotoButtonsList = vehiclesPage.fetchAddPhotoButtons();
		//List checkClaimStatusButtonsList = vehiclesPage.fetchCheckClaimStatusButtons();
		List viewDetailsButtonsList = vehiclesPage.fetchViewDetailsButtons();

		// Load the expected vehicles list to be shown for each month from test data sheet
		List vehiclesList = utils.readTestDataList("hasVehicles", "vehiclesList");
		int numOfVehicles = vehiclesList.size();
		// Iterating over each vehicle
		for (Object vehicleItem : vehiclesList) {
			HashMap vehicleCell = (HashMap)vehicleItem;

			// verify the vehicles list shown with the expected data from 'TestData' sheet
			Assert.assertEquals(vehicleDescriptionList.get(i), vehicleCell.get("description"), "Vehicles Page : Vehicle description shown for " + i + " vehicle not shown as expected");
			Assert.assertEquals(vehicleRegistrationNumberList.get(i), vehicleCell.get("RegNo"), "Vehicles Page : Vehicle Registration number shown for " + i + " vehicle not shown as expected");

			Assert.assertNotNull(vehicleImageTypeList.get(i), "Vehicles Page : Vehicle Image type for " + i + " vehicle not shown");
			Assert.assertNotNull(addPhotoButtonsList.get(i), "Vehicles Page : Add photo button for " + i + " vehicle is not shown");
			//Assert.assertNotNull(checkClaimStatusButtonsList.get(i), "Vehicles Page : Check claim status button for " + i + " vehicle is not shown");
			Assert.assertNotNull(viewDetailsButtonsList.get(i), "Vehicles Page : View details button for " + i + " vehicle is not shown");

			i++;
		}
	}

	// 507 - Scenario 3
	//	@Test (groups = {"DMPM-507", "DMPM-1294", "marketplace", "Vehicle dimension", "priority-minor"})
	public void testNavigatingToVehicleDetailsScreen(){
		navigateToVehiclesTab("hasVehicles");
		Assert.assertNotNull(vehiclesPage.checkViewDetailsButton(), "Vehicles Page - view details button not shown");
		vehiclesPage.tapViewDetailsButton();
		Assert.assertNotNull(vehicleDetailsPage.checkVehicleDetailsPageTitle(), "Vehicle Details page - Page Title not shown");
		vehicleDetailsPage.tapBackButton();
		Assert.assertTrue(landingPage.isVehiclesTabSelected(), "Vehicles tab is not selected on landing page");
	}

	/*
	 * Story: DMPM-4609
	 * Test case: DMPM-5136 - Display vehicle services tile
	 */
	@TestDetails(story1 = "DMPM-4609:DMPM-5136")
	//	@Test(groups = {"marketplace", "Vehicle dimension", "priority-minor"})
	public void testVehiclesTile()
	{
		//Step 1, 2 & 3: Login to App and then navigate Vehicles Dimension
		navigateToVehiclesTab("guest");

		//Step 4
		//Validate Vehicles services tile image.
		verifyVehiclesTileTitle();

		//Validate Vehicles services tile title
		verifyVehiclesTileImage();

		//Validate Vehicles services tile description
		verifyVehiclesTileDesc();

		//Validate Vehicles services tile button
		verifyVehiclesTileBtn();
	}


	/*

	 * Story: DMPM-5582
	 * Test case: DMPM-6034 - Display background image - Vehicle Dimension
	 */
	@TestDetails(story1 = "DMPM-5582:DMPM-6034")
//	@Test(groups = {"marketplace", "Vehicle dimension", "priority-minor"})
	public void testVehiclesDimensionBkgrndImg()
	{
		//Step 1: Login to App and then navigate Vehicles Dimension
		navigateToVehiclesTab("hasVehicles");

		//Step 2: Verify add vehicle tile image
		verifyAddPolicyTileImage();

		//Step 3: Validate Vehicles services tile title
		Assert.assertNotNull(vehiclesPage.checkVehicleDimensionBkgrndImg(), "Vehicles Page- Vehicles services background image not shown");
	}

	/* Stories: DMPM-5356, DMPM-5354
	 * Test case: DMPM-5728 - Add Vehicle Policy-Registered User
	 * Test case: DMPM-5725 - Vehicle dimension display loading indicator
	 * Test case: DMPM-5726 - Vehicle dimension hide loading indicator
	 */
	@TestDetails(story1 = "DMPM-5356:DMPM-5728", story2 = "DMPM-5354:DMPM-5725,DMPM-5726")
	//@Test(groups = {"marketplace", "Vehicle dimension", "priority-medium"})
	public void testVehiclesAddAPolicy()
	{
		//Step 1: Login to App and then navigate Vehicles Dimension
		navigateToVehiclesTab("hasVehicles");
		
		//Step 2a: DMPM-5725 wait for loader to appear
		vehiclesPage.waitForLoadingIndicatorToAppear();
		
		//Step 2b: DMPM-5726 wait for loader to disappear after loading the data
		vehiclesPage.waitForDataToLoad();
		
		//Step 2c:DMPM-5728-verify add vehicle policy info One and Two
		verifyAddPolicyTileInfoOneTwoIcons();
		
		//Step 2d:DMPM-5728-verify add vehicle policy info One and Two
		verifyAddPolicyInfoTexts();
		
		//Step 3 : DMPM-5728-Validate add a vehicles policy tile and add action text and button
		verifyAddVehiclesPolicyActionText();
	
		//Step 4: DMPM-5728-Select add a vehicles policy
		vehiclesPage.tapAddAVechilesPolicy();
		
		//Step 5: Verify that add policy page is displayed
		verifyAddInsurancePage();
		
	}
	
	@TestDetails(story1 = "DMPM-5355:DMPM-6687")
	@Test(groups = {"marketplace", "Vehicle dimension", "priority-medium"})
	public void testVehiclesAddAPolicyGuestUser()
	{
		//Step 1: Login to App and then navigate Vehicles Dimension
		navigateToVehiclesTab("guest");
	
		//Step 2: Select add a vehicles policy as a Guest user
		vehiclesPage.tapAddAVechilesPolicy();
		
		//Step 3: Verify that add policy page is Not loaded and feature locked alert is displayed
		vehiclesPage.waitForFeatureLockAlertTitle();
		verifyAlertTitle();
		
	}
	
	private void verifyAlertTitle() {
		Assert.assertNotNull(vehiclesPage.checkFeatureLockAlertTitle(), "Feature locked alert message not shown");
		vehiclesPage.dismissFeatureLockedAlert();
	}

	private void verifyAddInsurancePage() {
		vehiclesPage.waitForInsurancePageToLoad();
		Assert.assertNotNull(vehiclesPage.checkAddInsurancePolicyLabel(), "Add insurance policy page not displayed");
		Assert.assertNotNull(vehiclesPage.checkAddInsurancePolicyButton(), "Add insurance policy page not displayed");
	}

	private void verifyAddPolicyTileImage() {
		if(vehiclesPage.isAddVehiclePolicyImageDisplayed()==null) {
			vehiclesPage.scrollToAddVechilePolicyImage();
		}
		Assert.assertNotNull(vehiclesPage.checkAddVehiclePolicyImage(), "Add Vehicle policy tile image is not shown");
		
	}
	
	private void verifyAddPolicyTileInfoOneTwoIcons() {
		if(vehiclesPage.isAddVehiclePolicyInfoOneIconDisplayed()==null) {
			vehiclesPage.scrollToAddVechilePolicyInfoOneText();
		}
		Assert.assertNotNull(vehiclesPage.checkAddVehiclePolicyInfoOneIcon(), "Add Vehicle policy tile info one icon is not shown");
		
		if(vehiclesPage.isAddVehiclePolicyInfoTwoIconDisplayed()==null) {
			vehiclesPage.scrollToAddVechilePolicyInfoTwoText();
		}
		Assert.assertNotNull(vehiclesPage.checkAddVehiclePolicyInfoTwoIcon(), "Add Vehicle policy tile info teo icon is not shown");
		
	}
	private void verifyAddPolicyInfoTexts() {
		if(vehiclesPage.isAddVehiclePolicyInfoOneTxtDisplayed()==null) {
			vehiclesPage.scrollToAddVechilePolicyInfoOneText();
		}
		Assert.assertNotNull(vehiclesPage.checkAddVehiclePolicyInfoOneTxt(), "Add vehicle tile info one text is not shown");
		Assert.assertEquals(vehiclesPage.getAddVehiclePolicyInfoOneTxt(),Copy.ADD_A_VEHICLE_POLICY_INFO_ONE,"Add Vehicle policy info one is not as expected");
		
		if(vehiclesPage.isAddVehiclePolicyInfoTwoTxtDisplayed() == null) {
			vehiclesPage.scrollToAddVechilePolicyInfoTwoText();
		}
		Assert.assertNotNull(vehiclesPage.checkAddVehiclePolicyInfoTwoTxt(), "Add vehicle tile info two text is not shown");
		Assert.assertEquals(vehiclesPage.getAddVehiclePolicyInfoTwoTxt(),Copy.ADD_A_VEHICLE_POLICY_INFO_TWO,"Add Vehicle policy info one is not as expected");
		
	}

	private void verifyAddVehiclesPolicyActionText() {
		if(vehiclesPage.isAddVehiclePolicyActionTxtDisplayed()==null) {
			vehiclesPage.scrollToaddVehiclePolicyActionText();
		}
		Assert.assertNotNull(vehiclesPage.checkAddVehiclePolicyActionTxt(), "Add a policy action button not shown");
		Assert.assertEquals(vehiclesPage.getAddVehiclePolicyActionTxt(), Copy.ADD_A_VEHICLE_POLICY,"Add a vehicles Tile button text is not as expected");
	}

	private void verifyVehiclesTileBtn() {
		if(vehiclesPage.isVehiclesServicesBtnDisplayed()==null) {
			vehiclesPage.scrollToVechilesTileBtn();
		}
		Assert.assertNotNull(vehiclesPage.checkVehiclesServicesBtn(), "Vehicles Page = Vehicles services button not shown");
		Assert.assertEquals(vehiclesPage.getVehiclesServicesBtnTxt(), Copy.VEHICLE_SERVICES_BTN_TXT,"Vehicles Page = Vehicles Tile button text is not as expected");

	}

	private void verifyVehiclesTileDesc() {
		if(vehiclesPage.isVehiclesServicesDescDisplayed()==null) {
			vehiclesPage.scrollToVechilesTileDesc();
		}
		Assert.assertNotNull(vehiclesPage.checkVehiclesServicesDesc(), "Vehicles Page = Vehicles services tile description not shown");
		Assert.assertEquals(vehiclesPage.getVehiclesServicesDesc(), Copy.VEHICLE_SERVICES_DESCRIPTION,"Vehicles Page = Vehicles services description is not as expected");
	}

	private void verifyVehiclesTileImage() {
		if(vehiclesPage.isVehicleServicesImageDisplayed()==null) {
			vehiclesPage.scrollToVechilesTile();
		}
		Assert.assertNotNull(vehiclesPage.checkVehicleServicesImage(), "Vehicles Page = Vehicles services tile image not shown");
	}

	private void verifyVehiclesTileTitle() {
		if(vehiclesPage.isVehiclesServicesTitleDisplayed()==null) {
			vehiclesPage.scrollToVechilesTile();
		}
		Assert.assertNotNull(vehiclesPage.checkVehicleServicesTitle(), "Vehicles Page = Vehicles Tile title not shown");
		Assert.assertEquals(vehiclesPage.getVehicleServicesTitle(), Copy.VEHICLE_SERVICES_TITLE,"Vehicles Page = Vehicles Tile title not shown");

	}

	private void navigateToVehiclesTab(String loginType) {
		if(loginType.equals("hasVehicles")) {
			loginToApp(utils.readTestData("hasVehicles", "login"), utils.readTestData("hasVehicles", "pwd"));
		}
		else {
			welcomePage.tapGuestAccessButton();
		}
		landingPage.tapVehiclesTab();
		Assert.assertTrue(landingPage.isVehiclesTabSelected(), "Vehicles tab is not selected on landing page");
	}
}
