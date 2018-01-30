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
	@Test(groups = { "DMPM-810", "DMPM-1527","DMPM-1529","marketplace", "Document Storage","priority-minor" })
	public void testCameraAccessOnDigitalVaultScreen() {
		navigateToDigiVaultPage();
		Assert.assertNotNull(digitalVaultPage.checkTakePhotoButton(), "Take photo button is not displayed");
		digitalVaultPage.tapTakePhotoButton();
		Assert.assertNotNull(digitalVaultPage.checkAddPhotosButton(), "Add photo button is not displayed");
		digitalVaultPage.tapAddPhotoButton();
		Assert.assertNotNull(digitalVaultPage.checkCameraButton(), "Camera is not displayed");
		digitalVaultPage.tapCameraButton();
		Assert.assertNotNull(digitalVaultPage.checkOkButton(), "Photo is not captured");
		digitalVaultPage.tapOkButton();
		Assert.assertNotNull(digitalVaultPage.checkbackToGalleryButton(), "Back to gallery button is not displayed");
		Assert.assertNotNull(digitalVaultPage.checkSaveImageButton(), "Save button is not displayed");
		Assert.assertNotNull(digitalVaultPage.checkRenameImageButton(), "Rename button is not displayed");
		
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
