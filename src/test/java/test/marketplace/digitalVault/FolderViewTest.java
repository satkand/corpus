package test.marketplace.digitalVault;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class FolderViewTest extends App {

	@Test(groups = { "DMPM-1111", "DMPM-2717", "DMPM-2718", "DMPM-2719", "DMPM-2720", "DMPM-2721", "DMPM-2722","marketplace", "Document Storage", "priority-minor" })
	public void testAddFilesFromRootToFolder() {
		navigateToFolderView();
		folderViewPage.addAPhotoFromVault();
		Assert.assertNotNull(selectItemsPage.checkCloseButton(), "Cancel button not present");
		selectItemsPage.tapCloseButton();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Did not navigate to folder");
		folderViewPage.addAPhotoFromVault();
		Assert.assertNotNull(selectItemsPage.checkMoveButton(), "Cancel button not present");
		Assert.assertFalse(selectItemsPage.isMoveButtonEnabled(), "Move button is enabled");
		selectItemsPage.selectAllItems();
		Assert.assertTrue(selectItemsPage.areAllItemsSelected(), "All items not selected");
		
		selectItemsPage.tapSelectAllButton();
		Assert.assertFalse(selectItemsPage.areAllItemsSelected(), "All items not deselected");
		selectItemsPage.tapSelectAllButton();
		Assert.assertTrue(selectItemsPage.areAllItemsSelected(), "All items not selected");
		Assert.assertTrue(selectItemsPage.isMoveButtonEnabled(), "Move button is disabled");
		selectItemsPage.tapMoveButton();
		Assert.assertEquals(digiVaultCommonPage.findNumberOfItems(),2,"Items not moved");
		
	}
	
	private void navigateToFolderView() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("digivault", "hasItems", "login"), utils.readTestData("digivault", "hasItems", "pwd"));
		Assert.assertNotNull(navigationMenu.checkSplitMenuIcon(), "Split Menu button is not displayed");
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkDigitalVaultMenuItem(), "DigiVault Menu button is not displayed");
		navigationMenu.tapDigitalVaultMenuItem();
		if(digitalVaultPage.checkDigiVaultEmptyImage() != null) {
			createDummyData();
		}
		digitalVaultPage.tapFolderItem();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Did not navigate to folder");
	}

	private void createDummyData() {
		Assert.assertNotNull(digiVaultCommonPage.checkAddButton(), "Add button not present");
		digitalVaultPage.addAPhotoThroughCamera();
		cameraPage.capturePhoto();
		imagePreviewPage.finishSavingImageByChoosingFolder();
		
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digital vault home page is not displayed");
		digitalVaultPage.createFolder(utils.readTestData("digivault", "hasItems", "folderName"));
		digitalVaultPage.addAPhotoThroughCamera();
		cameraPage.capturePhoto();
		imagePreviewPage.finishSavingImage();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder view page not loaded");
		Assert.assertNotNull(digiVaultCommonPage.checkAddButton(), "Folder view page not loaded");
		common.goBack();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digital vault home page is not displayed");
	}
}
