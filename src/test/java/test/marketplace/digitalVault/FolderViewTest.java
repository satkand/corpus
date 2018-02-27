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
	
	//DMPM-2122 - Scenario 1,2,3,4,5 
	@Test(groups = { "DMPM-2122", "DMPM-2856","DMPM-2857","DMPM-2858","DMPM-2859","DMPM-2860", "marketplace", "Document Storage", "priority-minor" })
	public void testRenameFolderFromInsideFolder() {
		navigateToFolderView();
		folderViewPage.tapEditButton();
		Assert.assertNotNull(folderViewPage.checkRenameFolderButton(), "Rename folder button not present");
		folderViewPage.tapRenameFolderButton();                                                                                                  
		Assert.assertNotNull(digiVaultCommonPage.checkCancelButton(), "Cancel button not present");	
		Assert.assertTrue(common.isKeyboardShown(),"Keyboard not seen");
		digiVaultCommonPage.tapCancelButton();
		Assert.assertNull(digiVaultCommonPage.checkCancelButton(), "Rename button is not shown");
		
		folderViewPage.tapEditButton();
		Assert.assertNotNull(folderViewPage.checkRenameFolderButton(), "Rename folder button not present");
		folderViewPage.tapRenameFolderButton();
		Assert.assertNotNull(digiVaultCommonPage.checkPositiveButton(), "Rename button is not shown");
		digiVaultCommonPage.clearEditField();
		Assert.assertFalse(digiVaultCommonPage.isPositiveButtonEnabled(), "Save button is enabled");
		digiVaultCommonPage.enterName(utils.readTestData("digivault", "hasItems", "folder1"));	
		Assert.assertTrue(digiVaultCommonPage.isPositiveButtonEnabled(), "Save button is disabled");
		digiVaultCommonPage.tapPositiveButton();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Did not navigate to  folder");
		Assert.assertEquals(folderViewPage.getTitle(), utils.readTestData("digivault", "hasItems", "folder1"));
	}
	
	//DMPM-2127 - Scenario 1,2,3,4
	@Test(groups = { "DMPM-2127", "DMPM-2897","DMPM-2898","DMPM-2899","DMPM-2900","marketplace", "Document Storage", "priority-minor" })
	public void testDeleteFolderFromInsideFolder() {
		navigateToFolderView();
		folderViewPage.tapEditButton();
		Assert.assertNotNull(folderViewPage.checkDeleteFolderButton(), "Delete folder button not present");
		folderViewPage.tapDeleteFolderButton();
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidCancelButton(), "Cancel button not present");	
		digiVaultCommonPage.tapAndroidCancelButton();
		Assert.assertNull(digiVaultCommonPage.checkAndroidCancelButton(), "Rename button is not shown");
		
		folderViewPage.tapEditButton();
		Assert.assertNotNull(folderViewPage.checkDeleteFolderButton(), "Delete folder button not present");
		folderViewPage.tapDeleteFolderButton();
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidDialogMsg(), "Delete confirmation msg is not shown");
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidOkButton(), "Rename button is not shown");
		digiVaultCommonPage.tapAndroidOkButton();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Did not navigate to root folder");
		
	}
	
	private void navigateToFolderView() {
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
