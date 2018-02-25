package test.marketplace.digitalVault;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;
import pages.marketplace.common.CommonPage;

public class DigitalVaultTest extends App {
	// Navigate to the DigitalVault tab and verify all elements

	
	@Test(groups = { "DMPM-528", "DMPM-1994", "DMPM-799", "DMPM-2000", "marketplace", "Home buying journey",
			"priority-minor" })
	public void testElementsOnDigitalVaultScreen() {
		navigateToDigiVaultPageWithEmptyData();
		Assert.assertNotNull(navigationMenu.checkSplitMenuIcon(), "Navigation menu button is not displayed");
		Assert.assertNotNull(digitalVaultPage.checkChatbotButton(), "Chatbot button is not displayed");
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digital Vault title is not displayed");
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultEmptyImageTitle(), "Empty screen title is not displayed");
		Assert.assertEquals(digitalVaultPage.getDigiVaultEmptyImageTitle(), utils.readTestData("copy", "digiVaultPage", "digiVaultEmptyImageTitle"), "Digital Vault Page - Empty screen title is not verified");
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultEmptyImageDescription(), "Empty screen label is not displayed");
		Assert.assertEquals(digitalVaultPage.getdigiVaultEmptyImageDescription(), utils.readTestData("copy", "digiVaultPage", "digiVaultEmptyImageDescription"), "Digital Vault Page - Empty screen description is not verified");
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultEmptyImage(), "Empty image is not displayed");
		Assert.assertNotNull(digiVaultCommonPage.checkAddButton(), "Add photos button is not displayed");
	}

	// DMPM-1995 : Scenario 2 - Adding images to Digital Vault
	// DMPM-1996 : Scenario 3 - Dismissing action sheet by tapping on cancel button
	// or else where
	@Test(groups = { "DMPM-528", "DMPM-1995", "DMPM-1996", "marketplace", "Home buying journey", "priority-minor" })
	public void testAddImageScreen() {
		navigateToDigiVaultPageWithEmptyData();
		Assert.assertNotNull(digiVaultCommonPage.checkAddButton(), "Add photos button is not displayed");
		digiVaultCommonPage.tapAddButton();
		Assert.assertNotNull(digitalVaultPage.checkAddFromPhotoLibraryButton(),
				"Add From Photo Library Button is not displayed");
		Assert.assertNotNull(digiVaultCommonPage.checkTakePhotoCard(), "Take photo button is not displayed");
		Assert.assertNotNull(digiVaultCommonPage.checkCancelButton(), "Cancel button is not displayed");
		digiVaultCommonPage.tapCancelButton();
		Assert.assertNotNull(digiVaultCommonPage.checkAddButton(), "Add photos button is not displayed");
	}

	
	@Test(groups = { "DMPM-1844", "DMPM-2022", "DMPM-2023", "marketplace", "Document Storage", "priority-minor" })
	public void testEnabledEditOption() {
		navigateToDigiVaultPage();
		Assert.assertNotNull(digiVaultCommonPage.checkForItem(), "No item present");
		Assert.assertTrue(digitalVaultPage.isEditClickable(), "Edit button is not enabled");
		digitalVaultPage.tapEditButton();
		Assert.assertNotNull(digiVaultCommonPage.checkDeleteContentsButton(), "Delete contents button is not displayed");
		Assert.assertNotNull(digitalVaultPage.checkMoveToFolderButton(), "Move to folder item is not displayed");
		common.goBack();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digital vault home page is not displayed");
		digitalVaultPage.tapFolderItem();
		Assert.assertTrue(folderViewPage.isEditClickable(), "Edit button is not enabled");
		digitalVaultPage.tapEditButton();
		Assert.assertNotNull(folderViewPage.checkDeleteFolderButton(), "Delete item is not displayed");
		Assert.assertNotNull(folderViewPage.checkMoveToFolderButton(), "Move to folder item is not displayed");
		common.goBack();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder page is not displayed");
		digiVaultCommonPage.tapDocumentItem();
		Assert.assertNotNull(imageViewPage.checkImageViewTitle(), "Image full screen is not displayed");
		Assert.assertTrue(imageViewPage.isEditClickable(), "Edit button is not enabled");
		imageViewPage.tapEditButton();
		Assert.assertNotNull(digiVaultCommonPage.checkDeleteDocumentButton(), "Delete item is not displayed");
		Assert.assertNotNull(digiVaultCommonPage.checkRenameDocumentButton(), "Rename item is not displayed");
		Assert.assertNotNull(imageViewPage.checkMoveDocumentToFolderButton(), "Move to folder item is not displayed");
		
	}
	
	@Test(groups = { "DMPM-1844", "DMPM-2024", "marketplace", "Document Storage", "priority-minor" })
	public void testDisabledEditOption() {
		navigateToDigiVaultPageWithEmptyData();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultEmptyImage(),"Empty image is not displayed");
		Assert.assertFalse(digitalVaultPage.isEditClickable(), "Edit button is enabled");
		digitalVaultPage.createFolder(utils.readTestData("digivault", "hasItems", "folderName"));
		Assert.assertFalse(folderViewPage.isEditClickable(), "Edit button is enabled");
	}
	
	@Test(groups = { "DMPM-1844", "DMPM-2179", "DMPM-2180", "DMPM-2181", "marketplace", "Document Storage", "priority-minor" })
	public void testRenameOptionViaEdit() {
		navigateToDigiVaultPage();
		digiVaultCommonPage.tapDocumentItem();
		Assert.assertTrue(imageViewPage.isEditClickable(), "Edit button is not enabled");
		imageViewPage.tapEditButton();
		Assert.assertNotNull(digiVaultCommonPage.checkRenameDocumentButton(), "Rename button is not present");
		digiVaultCommonPage.tapRenameDocumentButton();
		Assert.assertNotNull(digiVaultCommonPage.checkCancelButton(), "Cancel button is not displayed");
		Assert.assertNotNull(digiVaultCommonPage.checkPositiveButton(), "Rename button is not displayed");
		Assert.assertFalse(digiVaultCommonPage.isPositiveButtonEnabled(), "Rename button is not disabled");
		imageViewPage.enterName(utils.readTestData("digivault", "hasItems", "newname"));
		Assert.assertTrue(digiVaultCommonPage.isPositiveButtonEnabled(), "Rename button is not enabled");
		digiVaultCommonPage.tapPositiveButton();
		Assert.assertNotNull(imageViewPage.checkImageViewTitle(), "Image page view is not loaded");
		Assert.assertEquals(imageViewPage.readTitleValue(), utils.readTestData("digivault", "hasItems", "newname"), "New title not updated");
	}
	
	@Test(groups = { "DMPM-1844", "DMPM-2182", "marketplace", "Document Storage", "priority-minor" })
	public void testCancelRenameOptionViaEdit() {
		navigateToDigiVaultPage();
		digiVaultCommonPage.tapDocumentItem();
		Assert.assertTrue(imageViewPage.isEditClickable(), "Edit button is not enabled");
		imageViewPage.tapEditButton();
		Assert.assertNotNull(digiVaultCommonPage.checkRenameDocumentButton(), "Rename button is not present");
		digiVaultCommonPage.tapRenameDocumentButton();
		imageViewPage.enterName(utils.readTestData("digivault", "hasItems", "name"));
		digiVaultCommonPage.tapCancelButton();
		Assert.assertNotNull(imageViewPage.checkImageViewTitle(), "Image page view is not loaded");
		Assert.assertNull(imageViewPage.checkRenameDialogTitle(), "Rename dialog is still displayed");
	}
	
	@Test(groups = { "DMPM-1095", "DMPM-2025", "DMPM-2026", "DMPM-2027","DMPM-2028", "marketplace", "Document Storage", "priority-minor" })
	public void testCreateFolder() {
		navigateToDigiVaultPageWithEmptyData();
		Assert.assertNotNull(digiVaultCommonPage.checkAddButton(), "Add button is not present");
		digiVaultCommonPage.tapAddButton();
		Assert.assertNotNull(digitalVaultPage.checkCreateFolderCard(), "Add Folder button is not present");
		digitalVaultPage.tapCreateFolderCard();
		Assert.assertNotNull(digitalVaultPage.checkFolderNameField(), "Folder name field is not present");
		Assert.assertNotNull(common.isKeyboardShown(), "Keyboard not seen");
		Assert.assertNotNull(digiVaultCommonPage.checkCancelButton(), "Folder cancel button is not present");
		Assert.assertNotNull(digiVaultCommonPage.checkPositiveButton(), "Folder create button is not present");
		Assert.assertFalse(digiVaultCommonPage.isPositiveButtonEnabled(), "Folder create button is enabled");
		digitalVaultPage.enterFolderName(utils.readTestData("digivault","hasItems", "folderName"));
		Assert.assertTrue(digiVaultCommonPage.isPositiveButtonEnabled(), "Folder create button is disabled");
		digiVaultCommonPage.tapPositiveButton();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder not created");
		Assert.assertEquals(folderViewPage.getTitle(), utils.readTestData("digivault","hasItems", "folderName"));
	}
	
	
	@Test(groups = { "DMPM-1095", "DMPM-2029", "marketplace", "Document Storage", "priority-minor" })
	public void testCancelCreateFolder() {
		navigateToDigiVaultPageWithEmptyData();
		Assert.assertNotNull(digiVaultCommonPage.checkAddButton(), "Add button is not present");
		digiVaultCommonPage.tapAddButton();
		Assert.assertNotNull(digitalVaultPage.checkCreateFolderCard(), "Add Folder button is not present");
		digitalVaultPage.tapCreateFolderCard();
		Assert.assertNotNull(digiVaultCommonPage.checkCancelButton(), "Folder cancel button is not present");
		digiVaultCommonPage.tapFolderCreateCancelButton();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digivault root folder not loaded");
	}
	
	
	@Test(groups = { "DMPM-1736", "DMPM-2356","DMPM-2357", "DMPM-2358", "DMPM-2360", "marketplace", "Document Storage", "priority-minor" })
	public void testDisplayFolderActionMenu() {
		navigateToDigiVaultPage();
		digitalVaultPage.tapFolderItem();
		Assert.assertNotNull(digiVaultCommonPage.checkAddButton(), "Add button is not present");
		Assert.assertTrue(folderViewPage.isEditClickable(), "Edit button is not enabled");
		digiVaultCommonPage.tapAddButton();
		Assert.assertNotNull(folderViewPage.checkAddFileFromVaultCard(), "Add file from vault is not present");
		Assert.assertNotNull(digiVaultCommonPage.checkUploadPhotoCard(), "Add from gallery is not present");
		Assert.assertNotNull(digiVaultCommonPage.checkTakePhotoCard(), "Take photo option is not present");
		
		digiVaultCommonPage.tapDocumentMoreOption();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder page not loaded");
		digiVaultCommonPage.tapDocumentMoreOption();
		digiVaultCommonPage.tapDeleteDocumentButton();
		Assert.assertNotNull(digiVaultCommonPage.checkPositiveButton(), "Positive button not seen");
		digiVaultCommonPage.tapPositiveButton();
		Assert.assertNotNull(digiVaultCommonPage.checkAddButton(), "Add button is not present");
		Assert.assertFalse(folderViewPage.isEditClickable(), "Edit button is not enabled");
		digiVaultCommonPage.tapAddButton();
		Assert.assertNotNull(folderViewPage.checkAddFileFromVaultCard(), "Add file from vault is not present");
		Assert.assertNotNull(digiVaultCommonPage.checkUploadPhotoCard(), "Add from gallery is not present");
		Assert.assertNotNull(digiVaultCommonPage.checkTakePhotoCard(), "Take photo option is not present");
		folderViewPage.tapEmptyDigitalVaultImage();
		digiVaultCommonPage.addDocumentThroughCamera();
		cameraPage.capturePhoto();
		imagePreviewPage.tapNextButton();
		Assert.assertNotNull(digiVaultCommonPage.checkEditField(), "Edit field not present");
		Assert.assertNotNull(digiVaultCommonPage.checkCancelButton(), "Cancel button not present");
		Assert.assertNotNull(digiVaultCommonPage.checkPositiveButton(), "Save button not present");
		Assert.assertTrue(common.isKeyboardShown(), "Keyboard not seen");

		digiVaultCommonPage.enterName(utils.readTestData("digivault", "hasItems", "file1"));	
		Assert.assertTrue(digiVaultCommonPage.isPositiveButtonEnabled(), "Save button is disabled");
		digiVaultCommonPage.tapPositiveButton();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Did not navigate to digi root folder");
		Assert.assertNotNull(folderViewPage.findDocumentInPage(utils.readTestData("digivault", "hasItems", "file1")), "Document not found in the folder");
	}
	
		
	@Test(groups = { "DMPM-1607", "DMPM-2539", "DMPM-2540", "DMPM-2541", "DMPM-2542", "DMPM-2543","marketplace", "Document Storage", "priority-minor" })
	public void testItemActionMenuRename() {
		navigateToDigiVaultPage();
		Assert.assertNotNull(digitalVaultPage.checkFolderMoreOption(), "Folder Item action menu is not shown");
		Assert.assertNotNull(digiVaultCommonPage.checkDocumentMoreOption(), "Item action menu is not shown");
		digiVaultCommonPage.tapDocumentMoreOption();		
		Assert.assertNotNull(digiVaultCommonPage.checkRenameItem(), "Rename item is not shown");
		digiVaultCommonPage.tapRenameItem();
		Assert.assertNotNull(common.isKeyboardShown(), "Keyboard is not shown");
		Assert.assertNotNull(digiVaultCommonPage.checkPositiveButton(), "Rename button is not shown");
		Assert.assertFalse(digiVaultCommonPage.isPositiveButtonEnabled(), "Rename button is not disabled");
		digiVaultCommonPage.enterName(utils.readTestData("digivault", "hasItems", "newname"));
		Assert.assertTrue(digiVaultCommonPage.isPositiveButtonEnabled(), "Rename button is not enabled");
		digiVaultCommonPage.tapPositiveButton();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digital vault view is not loaded");
		digiVaultCommonPage.tapDocumentMoreOption();
		Assert.assertNotNull(digiVaultCommonPage.checkRenameItem(), "Rename item button is not shown");
		digiVaultCommonPage.tapRenameItem();
		Assert.assertNotNull(digiVaultCommonPage.checkCancelButton(), "Rename cancel button is not shown");
		digiVaultCommonPage.tapCancelButton();
		Assert.assertNull(digiVaultCommonPage.checkRenameDialogTitle(), "Rename dialog title is not shown");
		
		digitalVaultPage.tapFolderItem();
		Assert.assertNotNull(digiVaultCommonPage.checkDocumentMoreOption(), "Item action menu is not shown in the folder view");
		digiVaultCommonPage.tapDocumentMoreOption();
		Assert.assertNotNull(digiVaultCommonPage.checkRenameDocumentButton(), "Rename item is not shown");
		digiVaultCommonPage.tapRenameDocumentButton();
		Assert.assertNotNull(common.isKeyboardShown(), "Keyboard is not shown");
		Assert.assertNotNull(digiVaultCommonPage.checkPositiveButton(), "Rename button is not shown");
		Assert.assertFalse(digiVaultCommonPage.isPositiveButtonEnabled(), "Rename button is not disabled");
		digiVaultCommonPage.enterName(utils.readTestData("digivault", "hasItems", "newname"));
		Assert.assertTrue(digiVaultCommonPage.isPositiveButtonEnabled(), "Rename button is not enabled");
		digiVaultCommonPage.tapPositiveButton();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder view is not loaded");
		Assert.assertNotNull(folderViewPage.findDocumentInPage(utils.readTestData("digivault", "hasItems", "newname")), "Document not found in the folder");
		digiVaultCommonPage.tapDocumentMoreOption();
		Assert.assertNotNull(digiVaultCommonPage.checkRenameItem(), "Rename item button is not shown");
		digiVaultCommonPage.tapRenameItem();
		Assert.assertNotNull(digiVaultCommonPage.checkCancelButton(), "Rename cancel button is not shown");
		digiVaultCommonPage.tapCancelButton();
		Assert.assertNull(digiVaultCommonPage.checkRenameDialogTitle(), "Rename dialog title is not shown");
	}
	
	@Test(groups = { "DMPM-1607", "DMPM-2545","DMPM-2546","DMPM-2547", "marketplace", "Document Storage", "priority-minor" })
	public void testItemActionMenuDelete() {
		navigateToDigiVaultPage();
		Assert.assertNotNull(digiVaultCommonPage.checkDocumentMoreOption(), "Item action menu is not shown");
		digiVaultCommonPage.tapDocumentMoreOption();
		Assert.assertNotNull(digiVaultCommonPage.checkDeleteDocumentButton(), "Delete item is not shown");
		digiVaultCommonPage.tapDeleteDocumentButton();
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidOkButton(), "Delete button is not shown");
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidCancelButton(), "Delete cancel button is not shown");
		digiVaultCommonPage.tapAndroidCancelButton();
		digiVaultCommonPage.swipeToDelete();
		Assert.assertNotNull(digiVaultCommonPage.checkBinBox(), "Bin box is not shown");
		digiVaultCommonPage.tapBinBox();
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidCancelButton(), "Delete cancel button not shown");
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidOkButton(), "Delete ok button not shown");
		digiVaultCommonPage.tapAndroidCancelButton();
		Assert.assertNull(digiVaultCommonPage.checkAndroidOkButton(), "Delete ok button is shown");
		digiVaultCommonPage.swipeToDelete();
		Assert.assertNotNull(digiVaultCommonPage.checkBinBox(), "Bin box is not shown");
		digiVaultCommonPage.tapBinBox();
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidOkButton(), "Delete ok button not shown");
		digiVaultCommonPage.tapAndroidOkButton();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digi vault main screen is not shown");
		Assert.assertNull(digiVaultCommonPage.checkDocumentMoreOption(), "Item not deleted");
		
		digitalVaultPage.tapFolderItem();
		Assert.assertNotNull(digiVaultCommonPage.checkDocumentMoreOption(), "Item action menu is not shown");
		digiVaultCommonPage.tapDocumentMoreOption();
		Assert.assertNotNull(digiVaultCommonPage.checkDeleteDocumentButton(), "Delete item is not shown");
		digiVaultCommonPage.tapDeleteDocumentButton();
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidOkButton(), "Delete button is not shown");
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidCancelButton(), "Delete cancel button is not shown");
		digiVaultCommonPage.tapAndroidCancelButton();
		Assert.assertNotNull(digiVaultCommonPage.checkDocumentMoreOption(), "Item action menu is not shown");
		digiVaultCommonPage.swipeToDelete();
		Assert.assertNotNull(digiVaultCommonPage.checkBinBox(), "Bin box is not shown");
		digiVaultCommonPage.tapBinBox();
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidCancelButton(), "Delete cancel button not shown");
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidOkButton(), "Delete ok button not shown");
		digiVaultCommonPage.tapAndroidCancelButton();
		Assert.assertNull(digiVaultCommonPage.checkAndroidOkButton(), "Delete ok button is shown");
		digiVaultCommonPage.swipeToDelete();
		Assert.assertNotNull(digiVaultCommonPage.checkBinBox(), "Bin box is not shown");
		digiVaultCommonPage.tapBinBox();
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidOkButton(), "Delete ok button not shown");
		digiVaultCommonPage.tapAndroidOkButton();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder title is not shown");
		Assert.assertNull(digiVaultCommonPage.checkDocumentMoreOption(), "Item not deleted");
	}
	
	@Test(groups = { "DMPM-2363", "DMPM-2923", "DMPM-2924", "DMPM-2926", "DMPM-1736", "DMPM-2359","marketplace", "Document Storage", "priority-minor" })
	public void testEditImageTitle() {
		navigateToDigiVaultPageWithEmptyData();
		digitalVaultPage.addAPhotoThroughCamera();
		cameraPage.capturePhoto();
		imagePreviewPage.tapNextButton();
		Assert.assertNotNull(digiVaultCommonPage.checkEditField(), "Edit field not present");
		Assert.assertNotNull(digiVaultCommonPage.checkCancelButton(), "Cancel button not present");
		Assert.assertNotNull(digiVaultCommonPage.checkPositiveButton(), "Save button not present");
		Assert.assertTrue(common.isKeyboardShown(), "Keyboard not seen");
		
		digiVaultCommonPage.clearEditField();
		Assert.assertFalse(digiVaultCommonPage.isPositiveButtonEnabled(), "Save button is enabled");
		digiVaultCommonPage.enterName(utils.readTestData("digivault", "hasItems", "file1"));	
		Assert.assertTrue(digiVaultCommonPage.isPositiveButtonEnabled(), "Save button is disabled");
		digiVaultCommonPage.tapPositiveButton();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Did not navigate to digi root folder");
		Assert.assertNotNull(digitalVaultPage.findElementInPage(utils.readTestData("digivault", "hasItems", "file1")), "Document not found in the folder");
		
		
		//From gallery
		digitalVaultPage.addAPhotoThroughGallery();
		Assert.assertNotNull(galleryPage.checkGalleryTitle(), "Gallery not loaded");
		galleryPage.choosePicture();
		imagePreviewPage.finishSavingImageByChoosingFolder();
		Assert.assertNotNull(digiVaultCommonPage.checkEditField(), "Edit field not present");
		Assert.assertNotNull(digiVaultCommonPage.checkCancelButton(), "Cancel button not present");
		Assert.assertNotNull(digiVaultCommonPage.checkPositiveButton(), "Save button not present");
		Assert.assertTrue(common.isKeyboardShown(), "Keyboard not seen");
		
		digiVaultCommonPage.clearEditField();
		Assert.assertFalse(digiVaultCommonPage.isPositiveButtonEnabled(), "Save button is enabled");
		digiVaultCommonPage.enterName(utils.readTestData("digivault", "hasItems", "file2"));
		Assert.assertTrue(digiVaultCommonPage.isPositiveButtonEnabled(), "Save button is disabled");
		digiVaultCommonPage.tapPositiveButton();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Did not navigate to digi root folder");
		Assert.assertNotNull(digitalVaultPage.findElementInPage(utils.readTestData("digivault", "hasItems", "file2")), "Document not found in the folder");
	}
	
	@Test(groups = { "DMPM-2363", "DMPM-2927","marketplace", "Document Storage", "priority-minor" })
	public void testEditImageTitleCancel() {
		navigateToDigiVaultPageWithEmptyData();
		digitalVaultPage.addAPhotoThroughCamera();
		cameraPage.capturePhoto();
		imagePreviewPage.tapNextButton();
		Assert.assertNotNull(digiVaultCommonPage.checkCancelButton(), "Cancel button not present");
		digiVaultCommonPage.tapCancelButton();
		Assert.assertNull(digiVaultCommonPage.checkEditField(), "Save button not present");
	}
	

	@Test(groups = { "DMPM-1605", "DMPM-2769", "DMPM-2770", "DMPM-2771", "DMPM-2772", "DMPM-2773","marketplace", "Document Storage", "priority-minor" })
	public void testRenameFolderFromRootDirectory() {
		navigateToDigiVaultPage();
		digitalVaultPage.tapFolderMoreOption();
		Assert.assertNotNull(digitalVaultPage.checkRenameFolderButton(), "Rename folder button is not shown");
		digitalVaultPage.tapRenameFolderButton();	
		Assert.assertNotNull(digiVaultCommonPage.checkCancelButton(), "Rename button is not shown");
		Assert.assertTrue(common.isKeyboardShown(),"Keyboard not seen");
		digiVaultCommonPage.tapCancelButton();
		Assert.assertNull(digiVaultCommonPage.checkCancelButton(), "Rename button is not shown");
		
		digitalVaultPage.tapFolderMoreOption();
		Assert.assertNotNull(digitalVaultPage.checkRenameFolderButton(), "Rename folder button is not shown");
		digitalVaultPage.tapRenameFolderButton();
		Assert.assertNotNull(digiVaultCommonPage.checkPositiveButton(), "Rename button is not shown");
		digiVaultCommonPage.clearEditField();
		Assert.assertFalse(digiVaultCommonPage.isPositiveButtonEnabled(), "Save button is enabled");
		digiVaultCommonPage.enterName(utils.readTestData("digivault", "hasItems", "folder1"));	
		Assert.assertTrue(digiVaultCommonPage.isPositiveButtonEnabled(), "Save button is disabled");
		digiVaultCommonPage.tapPositiveButton();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Did not navigate to digi root folder");
		Assert.assertNotNull(digitalVaultPage.findElementInPage(utils.readTestData("digivault", "hasItems", "folder1")), "Folder was not renamed");	
	}
	
	@Test(groups = { "DMPM-820", "DMPM-1535", "DMPM-1536", "DMPM-1538", "DMPM-1539", "DMPM-1540","marketplace", "Document Storage", "priority-minor" })
	public void testDeleteImageFromFullScreenView() {
		navigateToDigiVaultPageWithEmptyData();
		digitalVaultPage.addAPhotoThroughCamera();
		cameraPage.capturePhoto();
		imagePreviewPage.finishSavingImageByChoosingFolder();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Did not navigate to digi root folder");
		
		digiVaultCommonPage.tapDocumentItem();
		imageViewPage.tapEditButton();
		Assert.assertNotNull(digiVaultCommonPage.checkDeleteDocumentButton(), "Delete Item button not present");
		digiVaultCommonPage.tapDeleteDocumentButton();
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidCancelButton(), "Cancel button not present");
		digiVaultCommonPage.tapAndroidCancelButton();
		Assert.assertNull(digiVaultCommonPage.checkAndroidCancelButton(), "Ok button not present");
		imageViewPage.tapEditButton();
		Assert.assertNotNull(digiVaultCommonPage.checkDeleteDocumentButton(), "Delete Item button not present");
		digiVaultCommonPage.tapDeleteDocumentButton();
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidOkButton(), "Ok button not present");
		digiVaultCommonPage.tapAndroidOkButton();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Did not navigate to digi root folder");
		Assert.assertNull(digiVaultCommonPage.checkDocumentMoreOption(), "Item not deleted");	
	}
	
	@Test(groups = { "DMPM-1115", "DMPM-2942", "DMPM-2943", "DMPM-2944", "marketplace", "Document Storage", "priority-minor" })
	public void testDeleteFolderFromRoot() {
		navigateToDigiVaultPageWithEmptyData();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digital vault home page is not displayed");
		digitalVaultPage.createFolder(utils.readTestData("digivault", "hasItems", "folderName"));
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder page is not displayed");
		common.goBack();
		digitalVaultPage.checkDigiVaultTitle();
		digitalVaultPage.tapFolderMoreOption();
		Assert.assertNotNull(digitalVaultPage.checkDeleteFolderButton(), "Hamburger menu or navigation menu is not dispalyed");
		digitalVaultPage.tapDeleteFolderButton();
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidCancelButton(), "Cancel button not present");
		digiVaultCommonPage.tapAndroidCancelButton();
		Assert.assertNull(digiVaultCommonPage.checkAndroidCancelButton(), "Ok button not present");
		digitalVaultPage.tapFolderMoreOption();
		Assert.assertNotNull(digitalVaultPage.checkDeleteFolderButton(), "Delete Item button not present");
		digitalVaultPage.tapDeleteFolderButton();
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidOkButton(), "Ok button not present");
		digiVaultCommonPage.tapAndroidOkButton();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Did not navigate to digi root folder");
		Assert.assertNull(digitalVaultPage.checkFolderMoreOption(), "Item not deleted");
		
		
		digitalVaultPage.createFolder(utils.readTestData("digivault", "hasItems", "folderName"));
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder page is not displayed");
		common.goBack();
		digitalVaultPage.checkDigiVaultTitle();
		digitalVaultPage.swipeToDeleteFolder();
		Assert.assertNotNull(digitalVaultPage.checkBinBoxForFolder(), "Bin box is not shown");
		digitalVaultPage.tapBinBoxForFolder();
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidCancelButton(), "Cancel button not present");
		digiVaultCommonPage.tapAndroidCancelButton();
		Assert.assertNull(digiVaultCommonPage.checkAndroidCancelButton(), "Ok button not present");
		digitalVaultPage.swipeToDeleteFolder();
		Assert.assertNotNull(digitalVaultPage.checkBinBoxForFolder(), "Bin box is not shown");
		digitalVaultPage.tapBinBoxForFolder();
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidOkButton(), "Ok button not present");
		digiVaultCommonPage.tapAndroidOkButton();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Did not navigate to digi root folder");
		Assert.assertNull(digitalVaultPage.checkFolderMoreOption(), "Item not deleted");
	}
	
	//DMPM-2710 - Scenario 1,2
	//DMPM-2676 - Scenario 1,2,3
	@Test(groups = { "DMPM-2710", "DMPM-2947", "DMPM-2948", "DMPM-1983", "DMPM-2676", "DMPM-2677", "marketplace", "Document Storage", "priority-minor" })
	public void testSelectFoldersForDeletion() {
		//TODO: Can be replaced later by a user which already has existing images.
		navigateToDigiVaultPageWithEmptyData();
		digitalVaultPage.createFolder(utils.readTestData("digivault", "hasItems", "folderName"));
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder view page not loaded");
		common.goBack();
		digitalVaultPage.createFolder(utils.readTestData("digivault", "hasItems", "folderName"));
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder view page not loaded");
		common.goBack();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Did not navigate to digi root folder");
		
		digitalVaultPage.tapEditButton();
		Assert.assertNotNull(digiVaultCommonPage.checkDeleteContentsButton(), "Delete contents button not present");
		digiVaultCommonPage.tapDeleteContentsButton();
		Assert.assertFalse(selectItemsPage.isDeleteButtonEnabled(), "Delete button is enabled");
		selectItemsPage.selectAllItems();	
		Assert.assertTrue(selectItemsPage.areAllItemsSelected(), "All items not selected");
		
		selectItemsPage.tapSelectAllButton();
		Assert.assertFalse(selectItemsPage.areAllItemsSelected(), "All items not deselected");
		selectItemsPage.tapSelectAllButton();
		Assert.assertTrue(selectItemsPage.areAllItemsSelected(), "All items not selected");
		Assert.assertTrue(selectItemsPage.isDeleteButtonEnabled(), "Delete button is disabled");
		selectItemsPage.tapDeleteButton();
		
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidOkButton(), "Android ok button not present");
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidCancelButton(), "Android cancel button not present");
	}
	

	
	
	// DMPM-799 : Scenario 2 - Navigating to the digital Vault screen
	private void navigateToDigiVaultPage() {
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
	}
	
	private void navigateToDigiVaultPageWithEmptyData() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("digivault", "hasItems", "login"), utils.readTestData("digivault", "hasItems", "pwd"));
		Assert.assertNotNull(navigationMenu.checkSplitMenuIcon(), "Split Menu button is not displayed");
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkDigitalVaultMenuItem(), "DigiVault Menu button is not displayed");
		navigationMenu.tapDigitalVaultMenuItem();
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

