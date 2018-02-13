package test.marketplace.digitalVault;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class DigitalVaultTest extends App {
	// DMPM-1109 : Scenario: 1 - Display enabled sort items option
	// DMPM-1109 : Scenario: 2 - Display sort options
	// DMPM-1109 : Scenario: 3 - Select currently applied sorting
	// DMPM-810  :  Scenario 1 - Access
	// DMPM-810  :  Scenario 2 - Take a photo
	// DMPM-810  :  Scenario 3 - Back
	@Test(groups = { "DMPM-1109", "DMPM-2003", "DMPM-2004", "DMPM-2005", "DMPM-810", "DMPM-1527", "DMPM-1529",
			"DMPM-1531", "marketplace", "Document Storage", "priority-minor" })
	public void testAddingPhotosToDigitalVault() {
		navigateToDigiVaultPage();
		boolean photosAddedSuccessfully = addingPhotosToGallery();
		if (photosAddedSuccessfully) {
			Assert.assertNotNull(digitalVaultPage.checkSortingButtonIcon().isEnabled(),
					"Sorting Button Icon is not enabled");
			Assert.assertNotNull(digitalVaultPage.checkSortingButtonIcon(), "Sorting Button Icon is not displayed");
			digitalVaultPage.tapSortingButtonIcon();
			Assert.assertNotNull(digitalVaultPage.checkSortByDate(), "Sort by Date is not displayed");
			digitalVaultPage.tapSortByDate();
			Assert.assertNotNull(digitalVaultPage.checkSortByDate().isSelected(),
					"Sort options are dismissed after tapping on selected option");
		} else {
			Assert.assertNull(digitalVaultPage.checkSortingButtonIcon().isEnabled(), "Sorting Button Icon is enabled");

		}
	}
	
	// DMPM-810  : Scenario 4 - Rename
	// DMPM-810  : Scenario 5 - Save
	// DMPM-1109 : Scenario: 4 - Sort by name
	// DMPM-1109 : Scenario: 5 - Sort by date
	// DMPM-1109 : Scenario: 7 - Retain sorting
	// DMPM-1109 : Scenario: 8 - Display disabled sort items option when document storage is empty
	@Test(groups = { "DMPM-1109", "DMPM-2006", "DMPM-2007", "DMPM-2010", "DMPM-810", "DMPM-1532", "DMPM-1533",
			"marketplace", "Document Storage", "priority-minor" })
	public void testDifferentSortOptions() {
		navigateToDigiVaultPage();
		Assert.assertNull(digitalVaultPage.checkSortByDate(), "Sort by date is not enabled");
		boolean photosAddedSuccessfully = addingPhotosToGallery();
		if (photosAddedSuccessfully) {
			Assert.assertNotNull(digitalVaultPage.checkSortingButtonIcon().isEnabled(),
					"Sorting Button Icon is not enabled");
			Assert.assertNotNull(digitalVaultPage.checkSortingButtonIcon(), "Sorting Button Icon is not displayed");
			digitalVaultPage.tapSortingButtonIcon();
			Assert.assertNotNull(digitalVaultPage.checkSortByName(), "Sort by Name is not displayed");
			digitalVaultPage.tapSortByName();
			List<String> vehicleImageTypeList = digitalVaultPage.fetchImageTitleList();
			// Load the expected vehicles list to be shown for each month from test data sheet
			List<Object> imagesList = utils.readTestDataList("digitalVault", "imageName");
			int numberOfImages = imagesList.size();
			// Scenario: 5 Sort by name
			for (int count = 0; count < numberOfImages; count++) {
				// verify the images Name with the data from 'TestData' sheet
				Assert.assertEquals(vehicleImageTypeList.get(count), (String) imagesList.get(count),
						"Digital Vault Page : Sort by Name for image" + count + " is not as expected");
			}
			digitalVaultPage.tapSortingButtonIcon();
			Assert.assertNotNull(digitalVaultPage.checkSortByDate(), "Sort by Date is not displayed");
			digitalVaultPage.tapSortByDate();
			// Scenario: 4 Sort by date
			for (int i = numberOfImages - 1; i >= 0; i--) {
				// verify the images Name with the data from 'TestData' sheet
				Assert.assertEquals(vehicleImageTypeList.get(i), (String) imagesList.get(i),
						"Digital Vault Page : Sort by date for image" + i + " is not as expected");
			}
			// Scenario Outline: 6 Dismiss sorting options
			Assert.assertNotNull(digitalVaultPage.checkSortByDate(), "Sort by Date is not displayed");
			digitalVaultPage.tapSortingButtonIcon();
			digitalVaultPage.tapSortByDate();
			digitalVaultPage.tapSortingButtonIcon();
			digitalVaultPage.tapSortByName();
			Assert.assertFalse(digitalVaultPage.checkSortByDate().isSelected(), "Sort by Date is not Selected");
			// Scenario 7 : Retain Sorting
			navigationMenu.tapSplitMenuIcon();
			Assert.assertNotNull(navigationMenu.checkHomeJourneyMenuItem(), "Home Journey menu is not dispalyed");
			navigationMenu.tapHomeJourneyMenuItem();
			navigationMenu.tapSplitMenuIcon();
			Assert.assertNotNull(navigationMenu.checkDigiVaultMenuIcon(), "DigiVault Menu button is not displayed");
			navigationMenu.tapDigiVaultMenuIcon();
			Assert.assertTrue(digitalVaultPage.checkSortByName().isEnabled(), "Sort by Date is not Selected");
		} else {
			Assert.assertNull(digitalVaultPage.checkSortingButtonIcon().isEnabled(), "Sorting Button Icon is enabled");
		}
	}

	private void navigateToDigiVaultPage() {
		// Todo - Adding login user in Test data sheet
		// welcomePage.tapLoginButton();
		// loginToApp(utils.readTestData("hasImages", "login"),
		// utils.readTestData("hasImages", "pwd"));
		welcomePage.tapGuestAccessButton();
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkDigiVaultMenuIcon(), "DigiVault Menu button is not displayed");
		navigationMenu.tapDigiVaultMenuIcon();
		Assert.assertNotNull(navigationMenu.checkSplitMenuIcon(), "Hamburger menu or navigation menu is not dispalyed");
		Assert.assertNotNull(digitalVaultPage.checkTakePhotoButton(), "DigiVault Menu is not dispalyed");
	}
	
	// this method will be removed once image retention logic is implemented.
	private boolean addingPhotosToGallery() {
		List<Object> imageItem = utils.readTestDataList("digitalVault", "imageName");
		int size = imageItem.size();
		for (int i = 0; i < size; i++) {
			Assert.assertNotNull(digitalVaultPage.checkTakePhotoButton(), "Take photo button is not displayed");
			digitalVaultPage.tapTakePhotoButton();
			Assert.assertNotNull(digitalVaultPage.checkAddPhotoButton(), "Add photo button is not displayed");
			digitalVaultPage.tapAddPhotoButton();
			if (digitalVaultPage.checkAllowCameraButton() != null) {
				digitalVaultPage.tapAllowCameraButton();
			}
			if (digitalVaultPage.checkCameraButtonGalaxy() != null) {
				digitalVaultPage.tapCameraButtonGalaxy();
			}
			Assert.assertNotNull(digitalVaultPage.checkOkButton(), "Photo is not captured");
			digitalVaultPage.tapOkButton();
			Assert.assertNotNull(digitalVaultPage.checkRenameImageButton(), "Rename button is not displayed");
			digitalVaultPage.tapRenameImageButton();
			digitalVaultPage.renameImage((String) imageItem.get(i));
			Assert.assertNotNull(digitalVaultPage.checkSaveEditedTitleButton(),
					"Saving button after editing Image name is not displayed");
			digitalVaultPage.tapSaveEditedTitleButton();
			Assert.assertNotNull(digitalVaultPage.checkSaveImageButton(), "Save Image button is not displayed");
			digitalVaultPage.tapSaveImageButton();
			Assert.assertNotNull(digitalVaultPage.checkTakePhotoButton(),
					"navigation back to Gallery is not successful");
		}
		if (digitalVaultPage.checkTakePhotoButton() != null) {
			return true;
		} else {
			return false;
		}

	}
}