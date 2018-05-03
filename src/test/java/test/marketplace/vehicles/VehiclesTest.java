package test.marketplace.vehicles;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import pages.App;

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

		//Step 2: Scroll to Vehicle dimension background image
		vehiclesPage.scrollToVehicleDimensionBkgrndImg();

		//Step 3: Validate Vehicles services tile title
		Assert.assertNotNull(vehiclesPage.checkVehicleDimensionBkgrndImg(), "Vehicles Page- Vehicles services background image not shown");
	}

	/*
	 * Story: DMPM-5367
	 * Test Case: DMPM-6286- Android-Derived assets details UI for Vehicles
	 */
	@TestDetails(story1 = "DMPM-5367:DMPM-6286")
	@Test(groups = {"marketplace", "Vehicle dimension", "priority-high"})
	public void testVehiclesDerivedAssetDetails() {
		//Step 1: Login to App and then navigate Vehicles Dimension
		navigateToVehiclesTab("hasVehicles");
		
		//Step 2: Scroll to Derived Asset
		Assert.assertNotNull(vehiclesPage.scrollToDerivedAsset(), "Asset details view not found");
		
		
		//Step 2: Tap Derived Asset
		vehiclesPage.tapPolicyViewDocumentsBtn();

		//Step 3: Validate Asset details UI elements
		verifyAssetDetailsVehicleImage();
		verifyAssetDetailsVehicleCameraImage();
		verifyAssetDetailsVehicleDescription();
		verifyAssetDetailsVehicleMakeAClaim();
		verifyAssetDetailsVehicleAddDocuments();
	}
	
	private void verifyAssetDetailsVehicleImage() {
		Assert.assertNotNull(vehiclesPage.checkPolicyVehicleTypeImage(), "Vehicles asset's vehicle type image not shown");
	}

	private void verifyAssetDetailsVehicleCameraImage() {
		Assert.assertNotNull(vehiclesPage.checkVehicleTakePhotoImage(), "Vehicles asset's vehicle type camera icon not shown");
	}

	private void verifyAssetDetailsVehicleDescription() {
		Assert.assertNotNull(vehiclesPage.checkVehicleDescriptionText(), "Vehicles asset's vehicle description not shown");
	}

	private void verifyAssetDetailsVehicleMakeAClaim() {
		Assert.assertNotNull(vehiclesPage.checkVehicleMakeClaimBtn(), "Vehicles asset's make claim button not shown");
	}

	private void verifyAssetDetailsVehicleAddDocuments() {
		Assert.assertNotNull(vehiclesPage.checkVehicleAddDocumentsBtn(), "Vehicles asset's add document button not shown");
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
