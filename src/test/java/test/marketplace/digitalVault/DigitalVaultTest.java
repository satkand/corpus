package test.marketplace.digitalVault;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class DigitalVaultTest extends App {
	// DMPM-810 : Scenario 1 - Access
	// DMPM-810 : Scenario 2 - Take a photo
	// DMPM-810 : Scenario 3 - Back
	@Test(groups = { "DMPM-810", "DMPM-1527","DMPM-1529","DMPM-1531","marketplace", "Document Storage","priority-minor" })
	public void testCameraAccessOnDigitalVaultScreen() {
		navigateToDigiVaultPage();
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
//		Assert.assertNotNull(digitalVaultPage.checkCameraButton(), "Camera is not displayed");
//		digitalVaultPage.tapCameraButton();
		Assert.assertNotNull(digitalVaultPage.checkOkButton(), "Photo is not captured");
		digitalVaultPage.tapOkButton();
		Assert.assertNotNull(digitalVaultPage.checkBackToGalleryButton(), "Back to gallery button is not displayed");
		Assert.assertNotNull(digitalVaultPage.checkSaveImageButton(), "Save button is not displayed");
		Assert.assertNotNull(digitalVaultPage.checkRenameImageButton(), "Rename button is not displayed");
		digitalVaultPage.tapBackToGalleryButton();
		Assert.assertNotNull(digitalVaultPage.checkTakePhotoButton(), "navigation back to Gallery is not successful");	
		}

	// DMPM-810 : Scenario 4 - Rename
	// DMPM-810 : Scenario 5 - Save
	@Test(groups = { "DMPM-810", "DMPM-1532","DMPM-1533","marketplace", "Document Storage","priority-minor" })
	public void testRenamingImageCapturedByCamera() {
		navigateToDigiVaultPage();
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
//		Assert.assertNotNull(digitalVaultPage.checkCameraButton(),"Camera is not displayed");
//		digitalVaultPage.tapCameraButton();
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
}
