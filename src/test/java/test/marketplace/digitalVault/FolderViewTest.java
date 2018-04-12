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
		selectItemsPage.selectAllFolders();
		Assert.assertTrue(selectItemsPage.areAllFoldersSelected(), "All items not selected");
		selectItemsPage.tapSelectAllButton();
		Assert.assertFalse(selectItemsPage.areAllFoldersSelected(), "All items not deselected");
		selectItemsPage.tapSelectAllButton();
		Assert.assertTrue(selectItemsPage.areAllFoldersSelected(), "All items not selected");
	    selectItemsPage.checkMoveButton();
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
		folderViewPage.checkFolderTitle();
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
		folderViewPage.checkDeleteFolderButton();
		folderViewPage.tapDeleteFolderButton();
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidDialogMsg(), "Delete confirmation msg is not shown");
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidOkButton(), "Rename button is not shown");
		digiVaultCommonPage.tapAndroidOkButton();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Did not navigate to root folder");
		
	}
	
	//DMPM-2151 - Scenario 1,2,3,4,5
		@Test(groups = { "DMPM-2151", "DMPM-2950","DMPM-2951","DMPM-2952","DMPM-2953","marketplace", "Document Storage", "priority-minor" })
		public void testMoveFileFromInsideFolder() {
			navigateToFolderView();			
			Assert.assertNotNull(digiVaultCommonPage.checkDocumentMoreOption(), "Document more button not present");
			digiVaultCommonPage.tapDocumentMoreOption();
			Assert.assertNotNull(digiVaultCommonPage.checkMoveDocumentToFolderButton(), "Move to folder button not present");
			digiVaultCommonPage.tapMoveDocumentToFolderButton();
			Assert.assertNotNull(chooseFolderPage.checkAddFolderButton(), "Add new folder button not present");
			Assert.assertNotNull(digitalVaultPage.findDocumentInPage(utils.readTestData("digivault", "hasItems", "rootFolder")), "Folder was not renamed");	
			chooseFolderPage.tapAddFolderButton();
			Assert.assertNotNull(digiVaultCommonPage.checkPositiveButton(), "Positive button not present");
			digiVaultCommonPage.enterName(utils.readTestData("digivault", "hasItems", "folder1"));
			digiVaultCommonPage.tapPositiveButton();
			Assert.assertNotNull(digiVaultCommonPage.checkDocumentMoreOption(), "No document present");
			digiVaultCommonPage.tapBackNavigationButton();
			Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digital vault home page is not displayed");
			
			digiVaultCommonPage.tapFolder(utils.readTestData("digivault", "hasItems", "folder1"));
			folderViewPage.checkFolderTitle();
			Assert.assertNotNull(digiVaultCommonPage.checkDocumentMoreOption(), "Document more button not present");
			digiVaultCommonPage.tapDocumentMoreOption();
			Assert.assertNotNull(digiVaultCommonPage.checkMoveDocumentToFolderButton(), "Move to folder button not present");
			digiVaultCommonPage.tapMoveDocumentToFolderButton();
			digiVaultCommonPage.tapFolder(utils.readTestData("digivault", "hasItems", "folderName"));
			Assert.assertNotNull(chooseFolderPage.checkMoveToFolderButton(), "Pick folder button not present");
			chooseFolderPage.tapMoveToFolderButton();
			Assert.assertEquals(folderViewPage.getTitle(), utils.readTestData("digivault", "hasItems", "folderName"));
		}
	
		//DMPM-2130 - Scenario 1,2,3,4,5,6,8,9,10
		@Test(groups = { "DMPM-2130", "DMPM-2527", "DMPM-2528", "DMPM-2529", "DMPM-2530", "DMPM-2531", "DMPM-2532", "DMPM-2533", "DMPM-2534", "DMPM-2536", "DMPM-2537","marketplace", "Document Storage", "priority-minor" })
		public void testMoveMultipleFilesFromInsideFolderToExistingFolderViaEdit() {
			//TODO: Can be replaced later by a user which already has existing images.
			navigateToFolderView();
			digiVaultCommonPage.addAPhotoThroughGallery();
			galleryPage.selectPicture();
			imagePreviewPage.finishSavingImage(utils.readTestData("digivault", "hasItems", "file1"));
			folderViewPage.waitForSuccessNotificationToDisappear();
			Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Did not navigate to folder");
			common.goBack();
			digitalVaultPage.checkDigiVaultTitle();
			digitalVaultPage.createFolder(utils.readTestData("digivault", "hasItems", "folder1"));
			Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Did not navigate to folder");
			folderViewPage.waitForSuccessNotificationToDisappear();
			common.goBack();
			digitalVaultPage.checkDigiVaultTitle();
			digiVaultCommonPage.tapFolder(utils.readTestData("digivault", "hasItems", "folderName"));
			folderViewPage.tapEditButton();
			Assert.assertNotNull(digiVaultCommonPage.checkMoveToFolderButton(), "Move contents button not present");
			digiVaultCommonPage.tapMoveToFolderButton();
			Assert.assertNotNull(selectItemsPage.checkCloseButton(), "Close button not present");
			selectItemsPage.tapCloseButton();
			Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Did not navigate to folder");
			
			digitalVaultPage.tapEditButton();
			digiVaultCommonPage.checkMoveToFolderButton();
			digiVaultCommonPage.tapMoveToFolderButton();
			Assert.assertFalse(selectItemsPage.isMoveButtonEnabled(), "Move button is enabled");
			selectItemsPage.selectAllItems();
			Assert.assertTrue(selectItemsPage.areAllItemsSelected(), "All items not selected");
			
			selectItemsPage.tapSelectAllButton();
			Assert.assertFalse(selectItemsPage.areAllItemsSelected(), "All items not deselected");
			selectItemsPage.tapSelectAllButton();
			Assert.assertTrue(selectItemsPage.areAllItemsSelected(), "All items not selected");
			Assert.assertTrue(selectItemsPage.isMoveButtonEnabled(), "Move button is disabled");
			selectItemsPage.tapMoveButton();
			
			chooseFolderPage.checkAddFolderButton();
			Assert.assertFalse(chooseFolderPage.isMoveToFolderButtonEnabled(), "Move button not enabled");
			digiVaultCommonPage.tapFolder(utils.readTestData("digivault", "hasItems", "folder1"));
			Assert.assertNotNull(chooseFolderPage.checkMoveToFolderButton(), "Pick folder button not present");
			Assert.assertTrue(chooseFolderPage.isMoveToFolderButtonEnabled(), "Move button not enabled");
			chooseFolderPage.tapMoveToFolderButton();
			Assert.assertEquals(folderViewPage.getTitle(), utils.readTestData("digivault", "hasItems", "folder1"));
			Assert.assertNotNull(digitalVaultPage.findDocumentInPage(utils.readTestData("digivault", "hasItems", "file1")), "File was not moved");
		}
		
	
		//DMPM-2334 - Scenario 1-9
		@Test(groups = { "DMPM-2334", "DMPM-2861", "DMPM-2862", "DMPM-2863", "DMPM-2864", "DMPM-2865", "DMPM-2866", 
				"DMPM-2867", "DMPM-2868", "DMPM-2869","marketplace", "Document Storage", "priority-minor" })
		public void testDeleteMultipleFilesFromInsideFolderViaEdit() {
			navigateToFolderView();
			digiVaultCommonPage.addAPhotoThroughGallery();
			Assert.assertNotNull(galleryPage.checkGalleryTitle(), "Gallery not loaded");
			galleryPage.choosePicture();
			imagePreviewPage.finishSavingImage(utils.readTestData("digivault", "hasItems", "file1"));
			Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Did not navigate to folder");
			
			folderViewPage.tapEditButton();
			Assert.assertNotNull(folderViewPage.checkDeleteItemsButton(), "Delete items button not present");
			folderViewPage.tapDeleteItemsButton();
			Assert.assertNotNull(selectItemsPage.checkCloseButton(), "Close button not present");
			selectItemsPage.tapCloseButton();
			folderViewPage.checkFolderTitle();
			
			folderViewPage.tapEditButton();
			Assert.assertNotNull(folderViewPage.checkDeleteItemsButton(), "Delete items button not present");
			folderViewPage.tapDeleteItemsButton();
			Assert.assertFalse(selectItemsPage.isDeleteButtonEnabled(), "Delete button is enabled");
			selectItemsPage.selectAllItems();
			Assert.assertTrue(selectItemsPage.areAllItemsSelected(), "All items not selected");
			
			selectItemsPage.tapSelectAllButton();
			Assert.assertFalse(selectItemsPage.areAllItemsSelected(), "All items not deselected");
			selectItemsPage.tapSelectAllButton();
			Assert.assertTrue(selectItemsPage.areAllItemsSelected(), "All items not selected");
			Assert.assertTrue(selectItemsPage.isDeleteButtonEnabled(), "Move button is disabled");
			selectItemsPage.tapDeleteButton();
			
			Assert.assertNotNull(digiVaultCommonPage.checkAndroidDialogMsg(), "Delete confirmation msg is not shown");
			Assert.assertNotNull(digiVaultCommonPage.checkAndroidCancelButton(), "Delete cancelbutton is not shown");
			digiVaultCommonPage.tapAndroidCancelButton();
			folderViewPage.checkFolderTitle();
			folderViewPage.tapEditButton();
			Assert.assertNotNull(folderViewPage.checkDeleteItemsButton(), "Delete items button not present");
			folderViewPage.tapDeleteItemsButton();
			selectItemsPage.tapSelectAllButton();
			Assert.assertTrue(selectItemsPage.isDeleteButtonEnabled(), "Move button is disabled");
			selectItemsPage.tapDeleteButton();
			
			
			Assert.assertNotNull(digiVaultCommonPage.checkAndroidOkButton(), "Delete button is not shown");
			digiVaultCommonPage.tapAndroidOkButton();
			folderViewPage.checkFolderTitle();
			Assert.assertNull(digiVaultCommonPage.checkDocumentMoreOption(), "All files not deleted");
			
		}
		
		
		//DMPM-1603 - Scenario 7
		@Test(groups = { "DMPM-2130", "DMPM-2537","marketplace", "Document Storage", "priority-minor" })
		public void testMoveMultipleFilesFromInsideFolderToExistingFolderViaEdit_cancelFolderSelection() {
			//TODO: Can be replaced later by a user which already has existing images.
			navigateToFolderView();
			folderViewPage.tapEditButton();
			Assert.assertNotNull(digiVaultCommonPage.checkMoveToFolderButton(), "Move contents button not present");
			digiVaultCommonPage.tapMoveToFolderButton();
			Assert.assertNotNull(selectItemsPage.checkMoveButton(), "Move contents button not present");

			Assert.assertFalse(selectItemsPage.isMoveButtonEnabled(), "Move button is enabled");
			selectItemsPage.selectAllItems();
			Assert.assertTrue(selectItemsPage.isMoveButtonEnabled(), "Move button is disabled");
			selectItemsPage.tapMoveButton();
			Assert.assertNotNull(chooseFolderPage.checkBackButton(), "Back button not present");
			chooseFolderPage.tapBackButton();
			//To be modified to check folder once bug is fixed
			Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Did not navigate to digi root folder");
		}
		//DMPM-2135 - Scenario 1,2,3,4,5,6,8,9,10
		@Test(groups = { "DMPM-2135", "DMPM-2527", "DMPM-2528", "DMPM-2529", "DMPM-2530", "DMPM-2531", "DMPM-2532", "DMPM-2533", "DMPM-2534", "DMPM-2536", "DMPM-2537","marketplace", "Document Storage", "priority-minor" })
		public void testMoveMultipleFilesFromInsideFolderToNewFolderViaEdit() {
			//TODO: Can be replaced later by a user which already has existing images.
			navigateToFolderView();
			digiVaultCommonPage.addAPhotoThroughGallery();
//			Assert.assertNotNull(galleryPage.checkGalleryTitle(), "Gallery not loaded");
//			galleryPage.choosePicture();
			galleryPage.selectPicture();
			imagePreviewPage.finishSavingImage(utils.readTestData("digivault", "hasItems", "file1"));
			Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Did not navigate to folder");
						
			folderViewPage.tapEditButton();
			Assert.assertNotNull(digiVaultCommonPage.checkMoveToFolderButton(), "Move contents button not present");
			digiVaultCommonPage.tapMoveToFolderButton();
			Assert.assertFalse(selectItemsPage.isMoveButtonEnabled(), "Move button is enabled");
			selectItemsPage.selectAllItems();
			Assert.assertTrue(selectItemsPage.areAllItemsSelected(), "All items not selected");
			
			selectItemsPage.tapSelectAllButton();
			Assert.assertFalse(selectItemsPage.areAllItemsSelected(), "All items not deselected");
			selectItemsPage.tapSelectAllButton();
			Assert.assertTrue(selectItemsPage.areAllItemsSelected(), "All items not selected");
			Assert.assertTrue(selectItemsPage.isMoveButtonEnabled(), "Move button is disabled");
			selectItemsPage.tapMoveButton();
			
			Assert.assertNotNull(chooseFolderPage.checkAddFolderButton(), "Add new folder button not present");
			Assert.assertFalse(chooseFolderPage.isMoveToFolderButtonEnabled(), "Move button not enabled");
			chooseFolderPage.tapAddFolderButton();
			Assert.assertNotNull(digiVaultCommonPage.checkPositiveButton(), "Positive button not present");
			digiVaultCommonPage.enterName(utils.readTestData("digivault", "hasItems", "folder1"));
			digiVaultCommonPage.tapPositiveButton();
			Assert.assertNotNull(digiVaultCommonPage.checkDocumentMoreOption(), "No document present");
			Assert.assertEquals(folderViewPage.getTitle(), utils.readTestData("digivault", "hasItems", "folder1"));
			
			//move to root folder
			folderViewPage.tapEditButton();
			Assert.assertNotNull(digiVaultCommonPage.checkMoveToFolderButton(), "Move contents button not present");
			digiVaultCommonPage.tapMoveToFolderButton();
			Assert.assertNotNull(selectItemsPage.checkMoveButton(), "No move button present");
			selectItemsPage.tapSelectAllButton();
			selectItemsPage.tapMoveButton();
			
			Assert.assertNotNull(digitalVaultPage.findDocumentInPage(utils.readTestData("digivault", "hasItems", "rootFolder")), "Root folder not seen");
			digiVaultCommonPage.tapFolder(utils.readTestData("digivault", "hasItems", "rootFolder"));
			Assert.assertNotNull(chooseFolderPage.checkMoveToFolderButton(), "Pick folder button not present");
			chooseFolderPage.tapMoveToFolderButton();
			Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digital vault home page is not displayed");
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
		digiVaultCommonPage.addAPhotoThroughCamera();
		digiVaultCommonPage.waitForAddButtonToDisappear();
		cameraPage.capturePhoto();
		imagePreviewPage.finishSavingImageByChoosingFolder();
		
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digital vault home page is not displayed");
		digitalVaultPage.createFolder(utils.readTestData("digivault", "hasItems", "folderName"));
		digiVaultCommonPage.addAPhotoThroughCamera();
		digiVaultCommonPage.waitForAddButtonToDisappear();
		cameraPage.capturePhoto();
		imagePreviewPage.finishSavingImage();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder view page not loaded");
		Assert.assertNotNull(digiVaultCommonPage.checkAddButton(), "Folder view page not loaded");
		common.goBack();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digital vault home page is not displayed");
	}
}
