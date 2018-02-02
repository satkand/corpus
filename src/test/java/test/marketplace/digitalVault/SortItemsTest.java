package test.marketplace.digitalVault;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class SortItemsTest extends App {
	// DMPM-1109 : Scenario: 1-Display enabled sort items option
	// DMPM-1109 : Scenario: 2-Display sort options
	// DMPM-1109 : Scenario: 3 Select currently applied sorting
	@Test(groups = { "DMPM-1109", "DMPM-2003","DMPM-2004","marketplace", "Document Storage","priority-minor" })
	public void testEnabledSortItemsOption() {
		navigateToDigiVaultPage();
		Boolean photosAddedSuccessfully = addingPhotosToGallery();
		if (photosAddedSuccessfully) {
			Assert.assertNotNull(digitalVaultPage.checkSortingButtonIcon().isEnabled(), "Sorting Button Icon is not enabled");
			Assert.assertNotNull(digitalVaultPage.checkSortingButtonIcon(), "Sorting Button Icon is not displayed");
			digitalVaultPage.tapSortingButtonIcon();
			Assert.assertNotNull(digitalVaultPage.checkSortByDate(), "Sort by Date is not displayed");
			Assert.assertNotNull(digitalVaultPage.checkSortByName(), "Sort by Name Icon is not displayed");		
			digitalVaultPage.tapSortByDate();
			digitalVaultPage.tapSortingButtonIcon();
			digitalVaultPage.tapSortByName();
		}
	}

	private void navigateToDigiVaultPage() {
		//welcomePage.tapLoginButton();
		//loginToApp(utils.readTestData("hasImages", "login"), utils.readTestData("hasImages", "pwd"));
		welcomePage.tapGuestAccessButton();
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkDigiVaultMenuIcon(), "DigiVault Menu button is not displayed");
		navigationMenu.tapDigiVaultMenuIcon();
		Assert.assertNotNull(navigationMenu.checkSplitMenuIcon(), "Hamburger menu or navigation menu is not dispalyed");
		Assert.assertNotNull(digitalVaultPage.checkTakePhotoButton(), "DigiVault Menu is not dispalyed");
	}
	private Boolean addingPhotosToGallery() {
		Assert.assertNotNull(digitalVaultPage.checkTakePhotoButton(), "Take photo button is not displayed");
		digitalVaultPage.tapTakePhotoButton();
		Assert.assertNotNull(digitalVaultPage.checkTakePhotoButton(), "Add photo button is not displayed");
		digitalVaultPage.tapTakePhotoButton();
		digitalVaultPage.tapAllowCameraButton();
		if(digitalVaultPage.checkCameraButtonGalaxy()!=null) {
			digitalVaultPage.tapCameraButtonGalaxy();
		}
		if(digitalVaultPage.checkCameraButtonPixel()!=null) {
			digitalVaultPage.tapCameraButtonPixel();
		}
		Assert.assertNotNull(digitalVaultPage.checkOkButton(), "Photo is not captured");
		digitalVaultPage.tapOkButton();
		Assert.assertNotNull(digitalVaultPage.checkRenameImageButton(),"Rename button is not displayed");
		digitalVaultPage.tapRenameImageButton();
		digitalVaultPage.renameImage(utils.readTestData("digitalVault", "imageName"));
		Assert.assertNotNull(digitalVaultPage.checkSaveEditedTitleButton(), "Saving button after editing Image name is not displayed");	
		digitalVaultPage.tapSaveEditedTitleButton();
		Assert.assertNotNull(digitalVaultPage.checkSaveImageButton(), "Save Image button is not displayed");	
		digitalVaultPage.tapSaveImageButton();	
		Assert.assertNotNull(digitalVaultPage.checkTakePhotoButton(), "navigation back to Gallery is not successful");
		if(digitalVaultPage.checkTakePhotoButton()!=null) {
			return true;
		}
		else {
			return false;
		}
			
		
	}
}
