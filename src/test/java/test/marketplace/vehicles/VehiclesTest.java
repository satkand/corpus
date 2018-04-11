package test.marketplace.vehicles;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class VehiclesTest extends App {
	
	// 507 - Scenario 1
	// 507 - Scenario 2
	// 1052 - Scenario 1
	//@Test (groups = {"DMPM-507", "DMPM-1284", "DMPM-1290", "DMPM-1052", "DMPM-1320", "marketplace", "Vehicle dimension", "priority-minor"})
	public void testVehiclesListOnVehiclesPage() {
		navigateToVehiclesTab();
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
	//@Test (groups = {"DMPM-507", "DMPM-1294", "marketplace", "Vehicle dimension", "priority-minor"})
	public void testNavigatingToVehicleDetailsScreen(){
		navigateToVehiclesTab();
		Assert.assertNotNull(vehiclesPage.checkViewDetailsButton(), "Vehicles Page - view details button not shown");
		vehiclesPage.tapViewDetailsButton();
		Assert.assertNotNull(vehicleDetailsPage.checkVehicleDetailsPageTitle(), "Vehicle Details page - Page Title not shown");
		vehicleDetailsPage.tapBackButton();
		Assert.assertTrue(landingPage.isVehiclesTabSelected(), "Vehicles tab is not selected on landing page");
	}
	@Test
	public void testVehilesTile()
	{
		navigateToVehiclesTab();
	}
	private void navigateToVehiclesTab() {
		loginToApp(utils.readTestData("hasVehicles", "login"), utils.readTestData("hasVehicles", "pwd"));
		landingPage.tapVehiclesTab();
		Assert.assertTrue(landingPage.isVehiclesTabSelected(), "Vehicles tab is not selected on landing page");
	}
}
