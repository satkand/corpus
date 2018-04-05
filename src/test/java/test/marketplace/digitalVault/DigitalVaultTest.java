package test.marketplace.digitalVault;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class DigitalVaultTest extends App {
	// Navigate to the DigitalVault tab and verify all elements

	
	@Test(groups = { "DMPM-528", "DMPM-1994", "DMPM-799", "DMPM-2000", "marketplace", "Document Storage",
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
	@Test(groups = { "DMPM-528", "DMPM-1995", "DMPM-1996", "marketplace", "Document Storage", "priority-minor" })
	public void testAddImageScreen() {
		navigateToDigiVaultPageWithEmptyData();
		Assert.assertNotNull(digiVaultCommonPage.checkAddButton(), "Add photos button is not displayed");
		digiVaultCommonPage.tapAddButton();
		Assert.assertNotNull(digitalVaultPage.checkAddFromPhotoLibraryButton(),
				"Add From Photo Library Button is not displayed");
		Assert.assertNotNull(digiVaultCommonPage.checkTakePhotoCard(), "Take photo button is not displayed");
		digitalVaultPage.tapSortingButtonIcon();
		Assert.assertNull(digiVaultCommonPage.checkTakePhotoCard(), "Take photo button is  displayed");
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
		folderViewPage.checkFolderTitle();
		Assert.assertTrue(folderViewPage.isEditClickable(), "Edit button is not enabled");
		digitalVaultPage.tapEditButton();
		Assert.assertNotNull(folderViewPage.checkDeleteFolderButton(), "Delete item is not displayed");
		Assert.assertNotNull(digiVaultCommonPage.checkMoveToFolderButton(), "Move to folder item is not displayed");
		common.goBack();
		folderViewPage.checkFolderTitle();
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
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Did not navigate to folder");
		Assert.assertTrue(folderViewPage.isEditClickable(), "Edit button is enabled");
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
		imageViewPage.enterName(utils.readTestData("digivault", "hasItems", "newname"));
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
		digitalVaultPage.checkDigiVaultTitle();
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
		folderViewPage.checkFolderTitle();
		digiVaultCommonPage.tapDocumentMoreOption();
		Assert.assertNotNull(digiVaultCommonPage.checkDeleteDocumentButton(), "Delete button not seen");
		digiVaultCommonPage.tapDeleteDocumentButton();
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidOkButton(), "Android ok button not seen");
		digiVaultCommonPage.tapAndroidOkButton();
		Assert.assertNotNull(digiVaultCommonPage.checkAddButton(), "Add button is not present");
		Assert.assertTrue(folderViewPage.isEditClickable(), "Edit button is not enabled");
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
		folderViewPage.checkFolderTitle();
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
		digitalVaultPage.checkDigiVaultTitle();
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
		folderViewPage.checkFolderTitle();
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
		digiVaultCommonPage.checkAndroidCancelButton();
		digiVaultCommonPage.checkAndroidOkButton();
		digiVaultCommonPage.tapAndroidCancelButton();
		Assert.assertNull(digiVaultCommonPage.checkAndroidOkButton(), "Delete ok button is shown");
		digiVaultCommonPage.swipeToDelete();
		Assert.assertNotNull(digiVaultCommonPage.checkBinBox(), "Bin box is not shown");
		digiVaultCommonPage.tapBinBox();
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidOkButton(), "Delete ok button not shown");
		digiVaultCommonPage.tapAndroidOkButton();
		digitalVaultPage.checkDigiVaultTitle();
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
		digiVaultCommonPage.checkAndroidCancelButton();
		digiVaultCommonPage.checkAndroidOkButton();
		digiVaultCommonPage.tapAndroidCancelButton();
		digiVaultCommonPage.checkAndroidOkButton();
		digiVaultCommonPage.swipeToDelete();
		Assert.assertNotNull(digiVaultCommonPage.checkBinBox(), "Bin box is not shown");
		digiVaultCommonPage.tapBinBox();
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidOkButton(), "Delete ok button not shown");
		digiVaultCommonPage.tapAndroidOkButton();
		folderViewPage.checkFolderTitle();
		Assert.assertNull(digiVaultCommonPage.checkDocumentMoreOption(), "Item not deleted");
	}
	
	@Test(groups = { "DMPM-804", "DMPM-1589", "DMPM-1590", "DMPM-1595", "DMPM-1596", "DMPM-1597", "DMPM-1598", "DMPM-1599","DMPM-1600","marketplace", "Document Storage", "priority-minor" })
	public void testAddImageFromGallery() {
		navigateToDigiVaultPageWithEmptyData();
		digiVaultCommonPage.tapAddButton();
		digiVaultCommonPage.tapUploadPhotoCardWithoutPermission();
		Assert.assertNotNull(digiVaultCommonPage.checkPermissionButton(), "Permission button not present");
		Assert.assertNotNull(digiVaultCommonPage.checkPermissionDontAllowButton(), "Permission button not present");
		digiVaultCommonPage.tapPermissionOkButton();
		Assert.assertNotNull(galleryPage.checkGalleryTitle(), "Gallery not loaded");
		Assert.assertNotNull(galleryPage.checkGalleryCancelButton(), "Cancel button not present");
		galleryPage.tapGalleryCancelButton();
		digitalVaultPage.checkDigiVaultTitle();
		
		digiVaultCommonPage.tapAddButton();
		digiVaultCommonPage.tapUploadPhotoCardWithoutPermission();
		galleryPage.checkGalleryTitle();
		galleryPage.choosePicture();
		Assert.assertNotNull(imagePreviewPage.checkPreviousButton(), "Previous button not present");
		imagePreviewPage.tapPreviousButton();
		digitalVaultPage.checkDigiVaultTitle();
		
		digiVaultCommonPage.tapAddButton();
		digiVaultCommonPage.tapUploadPhotoCardWithoutPermission();
		galleryPage.checkGalleryTitle();
		galleryPage.choosePicture();
		imagePreviewPage.tapNextButton();
		Assert.assertNotNull(digiVaultCommonPage.checkPositiveButton(), "Add button not present");
		digiVaultCommonPage.tapPositiveButton();
		Assert.assertNotNull(chooseFolderPage.checkPickFolderButton(), "Save button not present");
		chooseFolderPage.tapPickFolderButton();
		Assert.assertNotNull(digiVaultCommonPage.checkDocumentMoreOption(), "Document not created");
	}
	
	@Test(groups = { "DMPM-804", "DMPM-1591", "marketplace", "Document Storage", "priority-minor" })
	public void testPermissionWhileAddingImageFromGallery() {
		navigateToDigiVaultPageWithEmptyData();
		digiVaultCommonPage.tapAddButton();
		digiVaultCommonPage.tapTakePhotoCard();
		Assert.assertNotNull(digiVaultCommonPage.checkPermissionDontAllowButton(), "Permission button not present");
		digiVaultCommonPage.tapPermissionDontAllowButton();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Did not navigate to digi root folder");
	}
	
	@Test(groups = { "DMPM-2363", "DMPM-2923", "DMPM-2924", "DMPM-2926", "DMPM-1736", "DMPM-2359","marketplace", "Document Storage", "priority-minor" })
	public void testEditImageTitle() {
		navigateToDigiVaultPageWithEmptyData();
		digiVaultCommonPage.addAPhotoThroughCamera();
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
		Assert.assertNotNull(chooseFolderPage.checkPickFolderButton(),"Save button not present");
		chooseFolderPage.tapPickFolderButton();
		digitalVaultPage.checkDigiVaultTitle();
		Assert.assertNotNull(digitalVaultPage.findDocumentInPage(utils.readTestData("digivault", "hasItems", "file1")), "Document not found in the folder");
		
		
		//From gallery
		digiVaultCommonPage.addAPhotoThroughGallery();
		Assert.assertNotNull(galleryPage.checkGalleryTitle(), "Gallery not loaded");
		galleryPage.choosePicture();
		imagePreviewPage.tapNextButton();
		Assert.assertNotNull(digiVaultCommonPage.checkEditField(), "Edit field not present");
		Assert.assertNotNull(digiVaultCommonPage.checkCancelButton(), "Cancel button not present");
		Assert.assertNotNull(digiVaultCommonPage.checkPositiveButton(), "Save button not present");
		Assert.assertTrue(common.isKeyboardShown(), "Keyboard not seen");
		
		digiVaultCommonPage.clearEditField();
		Assert.assertFalse(digiVaultCommonPage.isPositiveButtonEnabled(), "Save button is enabled");
		digiVaultCommonPage.enterName(utils.readTestData("digivault", "hasItems", "file2"));
		Assert.assertTrue(digiVaultCommonPage.isPositiveButtonEnabled(), "Save button is disabled");
		digiVaultCommonPage.tapPositiveButton();
		Assert.assertNotNull(chooseFolderPage.checkPickFolderButton(),"Save button not present");
		chooseFolderPage.tapPickFolderButton();
		digitalVaultPage.checkDigiVaultTitle();
		Assert.assertNotNull(digitalVaultPage.findDocumentInPage(utils.readTestData("digivault", "hasItems", "file2")), "Document not found in the folder");
	}
	
	@Test(groups = { "DMPM-2363", "DMPM-2927","marketplace", "Document Storage", "priority-minor" })
	public void testEditImageTitleCancel() {
		navigateToDigiVaultPageWithEmptyData();
		digiVaultCommonPage.addAPhotoThroughCamera();
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
		digitalVaultPage.checkDigiVaultTitle();
		Assert.assertNotNull(digitalVaultPage.findDocumentInPage(utils.readTestData("digivault", "hasItems", "folder1")), "Folder was not renamed");	
	}

	
	@Test(groups = { "DMPM-820", "DMPM-1535", "DMPM-1536", "DMPM-1538", "DMPM-1539", "DMPM-1540","marketplace", "Document Storage", "priority-minor" })
	public void testDeleteImageFromFullScreenView() {
		navigateToDigiVaultPageWithEmptyData();
		digiVaultCommonPage.addAPhotoThroughCamera();
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
		digitalVaultPage.checkDigiVaultTitle();
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
		digitalVaultPage.checkDigiVaultTitle();
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
		digitalVaultPage.checkDigiVaultTitle();
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
		folderViewPage.checkFolderTitle();
		common.goBack();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Did not navigate to digi root folder");
		
		digitalVaultPage.tapEditButton();
		Assert.assertNotNull(digiVaultCommonPage.checkDeleteContentsButton(), "Delete contents button not present");
		digiVaultCommonPage.tapDeleteContentsButton();
		Assert.assertFalse(selectItemsPage.isDeleteButtonEnabled(), "Delete button is enabled");
		selectItemsPage.selectAllFolders();	
		Assert.assertTrue(selectItemsPage.areAllFoldersSelected(), "All items not selected");
		
		selectItemsPage.tapSelectAllButton();
		Assert.assertFalse(selectItemsPage.areAllFoldersSelected(), "All items not deselected");
		selectItemsPage.tapSelectAllButton();
		Assert.assertTrue(selectItemsPage.areAllFoldersSelected(), "All items not selected");
		Assert.assertTrue(selectItemsPage.isDeleteButtonEnabled(), "Delete button is disabled");
		selectItemsPage.tapDeleteButton();
		
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidOkButton(), "Android ok button not present");
		Assert.assertNotNull(digiVaultCommonPage.checkAndroidCancelButton(), "Android cancel button not present");
	}
	
	
	//DMPM-2728 - Scenario 1,2
	//DMPM-2894 - Scenario 1,2
	@Test(groups = { "DMPM-2728", "DMPM-3286", "DMPM-3287", "DMPM-2984", "DMPM-3407", "DMPM-3408", "marketplace", "Document Storage", "priority-minor" })
	public void testHideOptionsWhenNoFiles() {
		navigateToDigiVaultPageWithEmptyData();
		digitalVaultPage.createFolder(utils.readTestData("digivault", "hasItems", "folderName"));
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Digital vault folder page is not displayed");
		common.goBack();
		digitalVaultPage.checkEditButton();
		digitalVaultPage.tapEditButton();
		Assert.assertNull(digitalVaultPage.checkMoveToFolderButton(), "Move to folder button present");
		common.goBack();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digital vault home page is not displayed");
		
		digitalVaultPage.tapFolderItem();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Digital vault folder page is not displayed");
		digiVaultCommonPage.tapAddButton();
		Assert.assertNull(folderViewPage.checkAddFileFromVaultCard(), "Add from Vault card present");
		common.goBack();
		folderViewPage.checkEditButton();
		Assert.assertTrue(folderViewPage.isEditClickable(), "Edit button is not enabled");
		Assert.assertNull(folderViewPage.checkDeleteItemsButton(), "Delete items button present");
		Assert.assertNull(digiVaultCommonPage.checkMoveToFolderButton(), "Delete items button present");
	}
	
	
	//DMPM-2106 - Scenario 1
	@Test(groups = { "DMPM-2106", "DMPM-2846", "marketplace", "Document Storage", "priority-minor" })
	public void testViewItemsAddedByMe() {
		navigateToDigiVaultPage();
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.checkLockMenuOption();
		navigationMenu.tapLockMenuOption();
		Assert.assertNotNull(loginAuthPage.checkChangeAccountButton(), "Change account button is not shown");
		loginAuthPage.tapChangeAccountButton();
		Assert.assertNotNull(welcomePage.checkGuestAccessButton(), "Guest access button is not shown");
		welcomePage.tapGuestAccessButton();
		Assert.assertNotNull(navigationMenu.checkSplitMenuIcon(), "Split Menu button is not displayed");
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.checkDigitalVaultMenuItem();
		navigationMenu.tapDigitalVaultMenuItem();
		Assert.assertNull(digiVaultCommonPage.checkDocumentMoreOption(), "Document still present");
		Assert.assertNull(digitalVaultPage.checkFolderMoreOption(), "Folder still present");
	}
	
	//DMPM-2153 - Scenario 1,2,3,4
	@Test(groups = { "DMPM-2153", "DMPM-2954","DMPM-2955","DMPM-2956","DMPM-2957","marketplace", "Document Storage", "priority-minor" })
	public void testMoveFileFromFullScreenView() {
		navigateToDigiVaultPage();
		digiVaultCommonPage.tapDocumentItem();
		Assert.assertNotNull(imageViewPage.checkEditButton(), "Edit button not present");
		imageViewPage.tapEditButton();
		Assert.assertNotNull(digiVaultCommonPage.checkMoveDocumentToFolderButton(), "Move to folder button not present");
		digiVaultCommonPage.tapMoveDocumentToFolderButton();
		Assert.assertNotNull(chooseFolderPage.checkAddFolderButton(), "Add new folder button not present");
		chooseFolderPage.tapAddFolderButton();
		Assert.assertNotNull(digiVaultCommonPage.checkPositiveButton(), "Positive button not present");
		digiVaultCommonPage.enterName(utils.readTestData("digivault", "hasItems", "folder1"));
		digiVaultCommonPage.tapPositiveButton();
		Assert.assertNotNull(digiVaultCommonPage.checkDocumentMoreOption(), "No document present");
		common.goBack();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digital vault home page is not displayed");
		
		digiVaultCommonPage.tapFolder(utils.readTestData("digivault", "hasItems", "folder1"));
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Did not navigate to folder");
		digiVaultCommonPage.tapDocumentItem();
		imageViewPage.tapEditButton();
		Assert.assertNotNull(digiVaultCommonPage.checkMoveDocumentToFolderButton(), "Move to folder button not present");
		digiVaultCommonPage.tapMoveDocumentToFolderButton();
		digiVaultCommonPage.tapFolder(utils.readTestData("digivault", "hasItems", "folderName"));
		Assert.assertNotNull(chooseFolderPage.checkMoveToFolderButton(), "Pick folder button not present");
		chooseFolderPage.tapMoveToFolderButton();
		Assert.assertEquals(folderViewPage.getTitle(), utils.readTestData("digivault", "hasItems", "folderName"));
	}
	//DMPM-1603 - Scenario 1-10
	//DMPM-2163 - Scenario 1-4
	@Test(groups = { "DMPM-1603", "DMPM-2527", "DMPM-2528", "DMPM-2529", "DMPM-2530", "DMPM-2531", "DMPM-2532", "DMPM-2533", 
			"DMPM-2534", "DMPM-2536", "DMPM-2537", "DMPM-2163",  "DMPM-3178", "DMPM-3182", "DMPM-3183","marketplace", "Document Storage", "priority-minor" })
	public void testMoveMultipleFilesFromRootFolderToExistingFolderViaEdit() {
		//TODO: Can be replaced later by a user which already has existing images.
		navigateToDigiVaultPage();
		digiVaultCommonPage.addAPhotoThroughGallery();
		Assert.assertNotNull(galleryPage.checkGalleryTitle(), "Gallery not loaded");
		galleryPage.choosePicture();
		imagePreviewPage.finishSavingImageByChoosingFolder(utils.readTestData("digivault", "hasItems", "file1"));
		digitalVaultPage.checkDigiVaultTitle();
		
		digitalVaultPage.tapEditButton();
		Assert.assertNotNull(digiVaultCommonPage.checkMoveToFolderButton(), "Move contents button not present");
		digiVaultCommonPage.tapMoveToFolderButton();
		Assert.assertNotNull(selectItemsPage.checkCloseButton(), "Close button not present");
		selectItemsPage.tapCloseButton();
		digitalVaultPage.checkDigiVaultTitle();
		
		digitalVaultPage.tapEditButton();
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
		digiVaultCommonPage.tapFolder(utils.readTestData("digivault", "hasItems", "folderName"));
		Assert.assertNotNull(chooseFolderPage.checkMoveToFolderButton(), "Pick folder button not present");
		Assert.assertTrue(chooseFolderPage.isMoveToFolderButtonEnabled(), "Move button not enabled");
		chooseFolderPage.tapMoveToFolderButton();
		Assert.assertEquals(folderViewPage.getTitle(), utils.readTestData("digivault", "hasItems", "folderName"));
		Assert.assertNotNull(digitalVaultPage.findDocumentInPage(utils.readTestData("digivault", "hasItems", "file1")), "File was not moved");
	}
	
	//DMPM-1113 - Scenario 1-4
		@Test(groups = { "DMPM-1113", "DMPM-2909", "DMPM-2910", "DMPM-2911", "DMPM-2912", "marketplace", "Document Storage", "priority-minor" })
		public void testMoveMultipleFilesFromRootFolderToNewFolderViaEdit() {
			//TODO: Can be replaced later by a user which already has existing images.
			navigateToDigiVaultPage();
			digiVaultCommonPage.addAPhotoThroughGallery();
			Assert.assertNotNull(galleryPage.checkGalleryTitle(), "Gallery not loaded");
			galleryPage.choosePicture();
			imagePreviewPage.finishSavingImageByChoosingFolder(utils.readTestData("digivault", "hasItems", "file1"));
			digitalVaultPage.checkDigiVaultTitle();
			
			digitalVaultPage.tapEditButton();
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
			chooseFolderPage.tapAddFolderButton();
			Assert.assertNotNull(digiVaultCommonPage.checkPositiveButton(), "Positive button not present");
			digiVaultCommonPage.enterName(utils.readTestData("digivault", "hasItems", "folder1"));
			digiVaultCommonPage.tapPositiveButton();
			Assert.assertNotNull(digiVaultCommonPage.checkDocumentMoreOption(), "No document present");
			Assert.assertEquals(folderViewPage.getTitle(), utils.readTestData("digivault", "hasItems", "folder1"));
			Assert.assertNotNull(digiVaultCommonPage.checkDocumentMoreOption(), "No document present");
		}
		
	//DMPM-1998 - Scenario 1,2,3,4
		@Test(groups = { "DMPM-1998", "DMPM-2958", "DMPM-2959", "DMPM-2960", "DMPM-2961","marketplace", "Document Storage", "priority-minor" })
		public void testMoveSingleFileFromRootFolderViaEdit() {
			//TODO: Can be replaced later by a user which already has existing images.
			navigateToDigiVaultPage();			
			digitalVaultPage.tapEditButton();
			Assert.assertNotNull(digiVaultCommonPage.checkMoveToFolderButton(), "Move contents button not present");
			digiVaultCommonPage.tapMoveToFolderButton();
			Assert.assertNotNull(selectItemsPage.checkCloseButton(), "Close button not present");
			selectItemsPage.tapCloseButton();
			digitalVaultPage.checkDigiVaultTitle();
			
			digitalVaultPage.tapEditButton();
			Assert.assertNotNull(digiVaultCommonPage.checkMoveToFolderButton(), "Move contents button not present");
			digiVaultCommonPage.tapMoveToFolderButton();
			Assert.assertFalse(selectItemsPage.isMoveButtonEnabled(), "Move button is enabled");
			selectItemsPage.tapSelectAllButton();
			Assert.assertTrue(selectItemsPage.isMoveButtonEnabled(), "Move button is disabled");
			selectItemsPage.tapMoveButton();
			
			Assert.assertFalse(chooseFolderPage.isMoveToFolderButtonEnabled(), "Move button not enabled");
			digiVaultCommonPage.tapFolder(utils.readTestData("digivault", "hasItems", "folderName"));
			Assert.assertNotNull(chooseFolderPage.checkMoveToFolderButton(), "Pick folder button not present");
			Assert.assertTrue(chooseFolderPage.isMoveToFolderButtonEnabled(), "Move button not enabled");
			chooseFolderPage.tapMoveToFolderButton();
			Assert.assertEquals(folderViewPage.getTitle(), utils.readTestData("digivault", "hasItems", "folderName"));
			common.goBack();
			Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Did not navigate to digi root folder");
			digiVaultCommonPage.addAPhotoThroughGallery();
			Assert.assertNotNull(galleryPage.checkGalleryTitle(), "Gallery not loaded");
			galleryPage.choosePicture();
			imagePreviewPage.finishSavingImageByChoosingFolder();
			digitalVaultPage.checkDigiVaultTitle();
			digitalVaultPage.tapEditButton();
			Assert.assertNotNull(digiVaultCommonPage.checkMoveToFolderButton(), "Move contents button not present");
			digiVaultCommonPage.tapMoveToFolderButton();
			Assert.assertFalse(selectItemsPage.isMoveButtonEnabled(), "Move button is enabled");
			selectItemsPage.tapSelectAllButton();
			Assert.assertTrue(selectItemsPage.isMoveButtonEnabled(), "Move button is disabled");
			selectItemsPage.tapMoveButton();
			
			Assert.assertNotNull(chooseFolderPage.checkAddFolderButton(), "Add new folder button not present");
			Assert.assertFalse(chooseFolderPage.isMoveToFolderButtonEnabled(), "Move button not enabled");
			chooseFolderPage.tapAddFolderButton();
			Assert.assertNotNull(digiVaultCommonPage.checkPositiveButton(), "Positive button not present");
			digiVaultCommonPage.enterName(utils.readTestData("digivault", "hasItems", "file1"));
			digiVaultCommonPage.tapPositiveButton();
			Assert.assertNotNull(digiVaultCommonPage.checkDocumentMoreOption(), "No document present");
			Assert.assertEquals(folderViewPage.getTitle(), utils.readTestData("digivault", "hasItems", "file1"));
		}
	
		// DMPM-1109 : Scenario 1, 2, 3, 4,7
		@Test(groups = { "DMPM-1109", "DMPM-2003", "DMPM-2004", "DMPM-2005", "DMPM-2006","DMPM-2009","marketplace", "Document Storage", "priority-minor" })
		public void testDifferentSortByName() {
			navigateToDigiVaultPageWithEmptyData();
			List imagesList = (List) utils.readTestDataList("digivault", "hasItems", "images");
			int numberOfImages = imagesList.size();
			for (int i = 0; i < numberOfImages; i++) {
				digiVaultCommonPage.addAPhotoThroughGallery();
				Assert.assertNotNull(galleryPage.checkGalleryTitle(), "Gallery not loaded");
				galleryPage.choosePicture();
				imagePreviewPage.finishSavingImageByChoosingFolder((String) imagesList.get(i));
				digitalVaultPage.checkDigiVaultTitle();
			}
			
			Assert.assertNotNull(digitalVaultPage.checkSortingButtonIcon(), "Sorting Button Icon is not displayed");
			Assert.assertNotNull(digitalVaultPage.checkSortingButtonIcon().isEnabled(),"Sorting Button Icon is not enabled");
			digitalVaultPage.tapSortingButtonIcon();
			Assert.assertNotNull(digitalVaultPage.checkSortByName(), "Sort by Name is not displayed");
			digitalVaultPage.tapSortByName();
			List<String> imageTitleList = digitalVaultPage.fetchImageTitleList();
			for (int count = 0; count < numberOfImages; count++) {
					// verify the images Name with the data from 'TestData' sheet
				Assert.assertEquals(imageTitleList.get(count), (String) imagesList.get(count),
							"Digital Vault Page : Sort by Name for image" + count + " is not as expected");
			}
			Assert.assertNotNull(navigationMenu.checkSplitMenuIcon(), "Split Menu button is not displayed");
			navigationMenu.tapSplitMenuIcon();
			Assert.assertNotNull(navigationMenu.checkProductsMenuItem(), "Products Menu button is not displayed");
			navigationMenu.tapProductsMenuItem();
			Assert.assertNotNull(navigationMenu.checkSplitMenuIcon(), "Split Menu button is not displayed");
			navigationMenu.tapSplitMenuIcon();
			Assert.assertNotNull(navigationMenu.checkDigitalVaultMenuItem(), "DigiVault Menu button is not displayed");
			navigationMenu.tapDigitalVaultMenuItem();
			for (int count = 0; count < numberOfImages; count++) {
				// verify the images Name with the data from 'TestData' sheet
			Assert.assertEquals(imageTitleList.get(count), (String) imagesList.get(count),
						"Digital Vault Page : Sort by Name for image" + count + " is not as expected");
			}
		}

		//DMPM-1109 - Scenario 6,8
		@Test(groups = { "DMPM-1109", "DMPM-2008", "DMPM-2010", "marketplace", "Document Storage", "priority-minor" })
		public void testDifferentSortOptions() {
			navigateToDigiVaultPageWithEmptyData();
			Assert.assertNotNull(digitalVaultPage.checkSortingButtonIcon(), "Sorting Button Icon is not displayed");
			Assert.assertFalse(digitalVaultPage.isSortingButtonIconEnabled(),"Sorting Button Icon is enabled");
			digiVaultCommonPage.addAPhotoThroughGallery();
			Assert.assertNotNull(galleryPage.checkGalleryTitle(), "Gallery not loaded");
			galleryPage.choosePicture();
			imagePreviewPage.finishSavingImageByChoosingFolder(utils.readTestData("digivault", "hasItems", "file1"));
			digitalVaultPage.checkDigiVaultTitle();
			
			//When sort option is tapped again
			digitalVaultPage.tapSortingButtonIcon();
			Assert.assertNotNull(digitalVaultPage.checkSortByName(), "Sort by Name is not displayed");
			digitalVaultPage.tapSortingButtonIcon();
			Assert.assertNull(digitalVaultPage.checkSortByName(), "Sort by Name is  displayed");
			
			//When tapped outside the sorting option
			digitalVaultPage.tapSortingButtonIcon();
			Assert.assertNotNull(digitalVaultPage.checkSortByName(), "Sort by Name is not displayed");
			digiVaultCommonPage.tapDocumentMoreOption();
			Assert.assertNull(digitalVaultPage.checkSortByName(), "Sort by Name is  displayed");
			
			//When back button is pressed
			digitalVaultPage.tapSortingButtonIcon();
			Assert.assertNotNull(digitalVaultPage.checkSortByName(), "Sort by Name is not displayed");
			common.goBack();
			Assert.assertNull(digitalVaultPage.checkSortByName(), "Sort by Name is  displayed");
		}
		
	// DMPM-799 : Scenario 2 - Navigating to the digital Vault screen
	private void navigateToDigiVaultPage() {
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

		loginToApp(utils.readTestData("digivault", "hasItems", "login"), utils.readTestData("digivault", "hasItems", "pwd"));
		Assert.assertNotNull(navigationMenu.checkSplitMenuIcon(), "Split Menu button is not displayed");
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkDigitalVaultMenuItem(), "DigiVault Menu button is not displayed");
		navigationMenu.tapDigitalVaultMenuItem();
	}
	
	private void createDummyData() {
		
		Assert.assertNotNull(digiVaultCommonPage.checkAddButton(), "Add button not present");
		digiVaultCommonPage.addAPhotoThroughCamera();
		cameraPage.capturePhoto();
		imagePreviewPage.finishSavingImageByChoosingFolder();
		
		digitalVaultPage.checkDigiVaultTitle();
		digitalVaultPage.createFolder(utils.readTestData("digivault", "hasItems", "folderName"));
		digiVaultCommonPage.addAPhotoThroughCamera();
		cameraPage.capturePhoto();
		imagePreviewPage.finishSavingImage();
		folderViewPage.checkFolderTitle();
		digiVaultCommonPage.checkAddButton();
		common.goBack();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digital vault home page is not displayed");
	}
}

