package test.marketplace.digitalVault;

import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class DigitalVaultTest extends App {
	// DMPM-810 : Scenario 1 - Access
	// DMPM-810 : Scenario 2 - Take a photo
//	// DMPM-810 : Scenario 3 - Back
//	@Test(groups = { "DMPM-810", "DMPM-1527","DMPM-1529","DMPM-1531","marketplace", "Document Storage","priority-minor" })
//	public void testCameraAccessOnDigitalVaultScreen() {
//		navigateToDigiVaultPage();
//		Assert.assertNotNull(digitalVaultPage.checkTakePhotoButton(), "Take photo button is not displayed");
//		digitalVaultPage.tapTakePhotoButton();
//		Assert.assertNotNull(digitalVaultPage.checkAddPhotosButton(), "Add photo button is not displayed");
//		digitalVaultPage.tapAddPhotoButton();
//		digitalVaultPage.tapAllowCameraButton();
//		Assert.assertNotNull(digitalVaultPage.checkCameraButton(), "Camera is not displayed");
//		digitalVaultPage.tapCameraButton();
//		Assert.assertNotNull(digitalVaultPage.checkOkButton(), "Photo is not captured");
//		digitalVaultPage.tapOkButton();
//		Assert.assertNotNull(digitalVaultPage.checkBackToGalleryButton(), "Back to gallery button is not displayed");
//		Assert.assertNotNull(digitalVaultPage.checkSaveImageButton(), "Save button is not displayed");
//		Assert.assertNotNull(digitalVaultPage.checkRenameImageButton(), "Rename button is not displayed");
//		digitalVaultPage.tapBackToGalleryButton();
//		Assert.assertNotNull(digitalVaultPage.checkTakePhotoButton(), "navigation back to Gallery is not successful");	
//		}

	// DMPM-810 : Scenario 4 - Rename
	@Test(groups = { "DMPM-810", "DMPM-1532","marketplace", "Document Storage","priority-minor" })
	public void testRenamingImageCapturedByCamera() {
		navigateToDigiVaultPage();
		Assert.assertNotNull(digitalVaultPage.checkTakePhotoButton(), "Take photo button is not displayed");
		digitalVaultPage.tapTakePhotoButton();
		Assert.assertNotNull(digitalVaultPage.checkAddPhotosButton(), "Add photo button is not displayed");
		digitalVaultPage.tapAddPhotoButton();
		digitalVaultPage.tapAllowCameraButton();
		Assert.assertNotNull(digitalVaultPage.checkCameraButton(),"Camera is not displayed");
		digitalVaultPage.tapCameraButton();
		Assert.assertNotNull(digitalVaultPage.checkOkButton(), "Photo is not captured");
		digitalVaultPage.tapOkButton();
		Assert.assertNotNull(digitalVaultPage.checkRenameImageButton(),"Rename button is not displayed");
		digitalVaultPage.tapRenameImageButton();
		digitalVaultPage.renameImage("TestName");
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
//		if (pinAuthPage.checkPinPromptDismissButton().isDisplayed());
//			{
//			pinAuthPage.tapPinPromptDismissButton();
//			}
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkDigiVaultMenuIcon(), "DigiVault Menu button is not displayed");
		navigationMenu.tapDigiVaultMenuIcon();
		Assert.assertNotNull(navigationMenu.checkSplitMenuIcon(), "Hamburger menu or navigation menu is not dispalyed");
		Assert.assertNotNull(digitalVaultPage.checkTakePhotoButton(), "DigiVault Menu is not dispalyed");
//		digitalVaultPage.tapTakePhotoButton();
//		digitalVaultPage.tapAddPhotoButton();
//		//digitalVaultPage.tapAllowCameraButton();
//        digitalVaultPage.tapCameraButton();
//        digitalVaultPage.tapOkButton();
//        digitalVaultPage.tapSaveImageButton();

	}
}
