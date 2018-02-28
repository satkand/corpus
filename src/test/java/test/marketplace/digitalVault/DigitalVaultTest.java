package test.marketplace.digitalVault;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class DigitalVaultTest extends App {
	// Navigate to the DigitalVault tab and verify all elements

	
	@Test(groups = { "DMPM-528", "DMPM-1994", "DMPM-799", "DMPM-2000", "marketplace", "Home buying journey",
			"priority-minor" })
	public void testElementsOnDigitalVaultScreen() {
		navigateToDigiVaultPage();
		Assert.assertNotNull(navigationMenu.checkSplitMenuIcon(), "Navigation menu button is not displayed");
		Assert.assertNotNull(digitalVaultPage.checkChatbotButton(), "Chatbot button is not displayed");
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digital Vault title is not displayed");
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultEmptyImageTitle(), "Empty screen title is not displayed");
		Assert.assertEquals(digitalVaultPage.getDigiVaultEmptyImageTitle(), utils.readTestData("copy", "digiVaultPage", "digiVaultEmptyImageTitle"), "Digital Vault Page - Empty screen title is not verified");
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultEmptyImageDescription(), "Empty screen label is not displayed");
		Assert.assertEquals(digitalVaultPage.getdigiVaultEmptyImageDescription(), utils.readTestData("copy", "digiVaultPage", "digiVaultEmptyImageDescription"), "Digital Vault Page - Empty screen description is not verified");
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultEmptyImage(), "Empty image is not displayed");
		Assert.assertNotNull(digitalVaultPage.checkAddButton(), "Add photos button is not displayed");
	}

	// DMPM-1995 : Scenario 2 - Adding images to Digital Vault
	// DMPM-1996 : Scenario 3 - Dismissing action sheet by tapping on cancel button
	// or else where
	@Test(groups = { "DMPM-528", "DMPM-1995", "DMPM-1996", "marketplace", "Home buying journey", "priority-minor" })
	public void testAddImageScreen() {
		navigateToDigiVaultPage();
		Assert.assertNotNull(digitalVaultPage.checkAddButton(), "Add photos button is not displayed");
		digitalVaultPage.tapAddButton();
		Assert.assertNotNull(digitalVaultPage.checkAddFromPhotoLibraryButton(),
				"Add From Photo Library Button is not displayed");
		Assert.assertNotNull(digitalVaultPage.checkTakePhotoCard(), "Take photo button is not displayed");
		Assert.assertNotNull(digitalVaultPage.checkCancelButton(), "Cancel button is not displayed");
		digitalVaultPage.tapCancelButton();
		Assert.assertNotNull(digitalVaultPage.checkAddButton(), "Add photos button is not displayed");
	}

	
	@Test(groups = { "DMPM-1844", "DMPM-2022", "DMPM-2023", "marketplace", "Document Storage", "priority-minor" })
	public void testEnabledEditOption() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("digivault", "hasItems", "login"), utils.readTestData("digivault", "hasItems", "pwd"));
		navigateToDigiVaultPage();
		if(digitalVaultPage.checkDigiVaultEmptyImage() != null) {
			createDummyData();
		}
		Assert.assertNotNull(digitalVaultPage.checkForItem(), "No item present");
		Assert.assertTrue(digitalVaultPage.isEditClickable(), "Edit button is not enabled");
		digitalVaultPage.tapEditButton();
		Assert.assertNotNull(digitalVaultPage.checkDeleteContentsButton(), "Delete contents button is not displayed");
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
		digitalVaultPage.tapDocumentItem();
		Assert.assertNotNull(imageViewPage.checkImageViewTitle(), "Image full screen is not displayed");
		Assert.assertTrue(imageViewPage.isEditClickable(), "Edit button is not enabled");
		imageViewPage.tapEditButton();
		Assert.assertNotNull(imageViewPage.checkDeleteItemButton(), "Delete item is not displayed");
		Assert.assertNotNull(imageViewPage.checkRenameItemButton(), "Rename item is not displayed");
		Assert.assertNotNull(imageViewPage.checkMoveItemToFolderButton(), "Move to folder item is not displayed");
		
	}
	
	@Test(groups = { "DMPM-1844", "DMPM-2024", "marketplace", "Document Storage", "priority-minor" })
	public void testDisabledEditOption() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("digivault", "hasItems", "login"), utils.readTestData("digivault", "hasItems", "pwd"));
		navigateToDigiVaultPage();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultEmptyImage(),"Empty image is not displayed");
		Assert.assertFalse(digitalVaultPage.isEditClickable(), "Edit button is enabled");
		digitalVaultPage.createFolder(utils.readTestData("digivault", "hasItems", "folderName"));
		Assert.assertFalse(folderViewPage.isEditClickable(), "Edit button is enabled");
	}
	
	@Test(groups = { "DMPM-1844", "DMPM-2179", "DMPM-2180", "DMPM-2181", "marketplace", "Document Storage", "priority-minor" })
	public void testRenameOption() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("digivault", "hasItems", "login"), utils.readTestData("digivault", "hasItems", "pwd"));
		navigateToDigiVaultPage();
		if(digitalVaultPage.checkDigiVaultEmptyImage() != null) {
			createDummyData();
		}	
		digitalVaultPage.tapDocumentItem();
		Assert.assertTrue(imageViewPage.isEditClickable(), "Edit button is not enabled");
		imageViewPage.tapEditButton();
		Assert.assertNotNull(imageViewPage.checkRenameItemButton(), "Rename button is not present");
		imageViewPage.tapRenameItemButton();
		Assert.assertNotNull(imageViewPage.checkCancelButton(), "Cancel button is not displayed");
		Assert.assertNotNull(imageViewPage.checkPositiveButton(), "Rename button is not displayed");
		Assert.assertFalse(imageViewPage.isPositiveButtonEnabled(), "Rename button is not disabled");
		imageViewPage.enterName(utils.readTestData("digivault", "hasItems", "newname"));
		Assert.assertTrue(imageViewPage.isPositiveButtonEnabled(), "Rename button is not enabled");
		imageViewPage.tapPositiveButton();
		Assert.assertNotNull(imageViewPage.checkImageViewTitle(), "Image page view is not loaded");
		Assert.assertEquals(imageViewPage.readTitleValue(), utils.readTestData("digivault", "hasItems", "newname"), "New title not updated");
	}
	
	@Test(groups = { "DMPM-1844", "DMPM-2182", "marketplace", "Document Storage", "priority-minor" })
	public void testCancelRenameOption() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("digivault", "hasItems", "login"), utils.readTestData("digivault", "hasItems", "pwd"));
		navigateToDigiVaultPage();
		if(digitalVaultPage.checkDigiVaultEmptyImage() != null) {
			createDummyData();
		}
		digitalVaultPage.tapDocumentItem();
		Assert.assertTrue(imageViewPage.isEditClickable(), "Edit button is not enabled");
		imageViewPage.tapEditButton();
		Assert.assertNotNull(imageViewPage.checkRenameItemButton(), "Rename button is not present");
		imageViewPage.tapRenameItemButton();
		imageViewPage.enterName(utils.readTestData("digivault", "hasItems", "name"));
		imageViewPage.tapCancelButton();
		Assert.assertNotNull(imageViewPage.checkImageViewTitle(), "Image page view is not loaded");
		Assert.assertNull(imageViewPage.checkRenameDialogTitle(), "Rename dialog is still displayed");
	}
	
	@Test(groups = { "DMPM-1095", "DMPM-2025", "DMPM-2026", "DMPM-2027","DMPM-2028", "marketplace", "Document Storage", "priority-minor" })
	public void testCreateFolder() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("digivault", "hasItems", "login"), utils.readTestData("digivault", "hasItems", "pwd"));
		navigateToDigiVaultPage();
		Assert.assertNotNull(digitalVaultPage.checkAddButton(), "Add button is not present");
		digitalVaultPage.tapAddButton();
		Assert.assertNotNull(digitalVaultPage.checkCreateFolderCard(), "Add Folder button is not present");
		digitalVaultPage.tapCreateFolderCard();
		Assert.assertNotNull(digitalVaultPage.checkFolderNameField(), "Folder name field is not present");
		Assert.assertNotNull(common.isKeyboardShown(), "Keyboard not seen");
		Assert.assertNotNull(digitalVaultPage.checkCancelButton(), "Folder cancel button is not present");
		Assert.assertNotNull(digitalVaultPage.checkPositiveButton(), "Folder create button is not present");
		Assert.assertFalse(digitalVaultPage.isPositiveButtonEnabled(), "Folder create button is enabled");
		digitalVaultPage.enterFolderName(utils.readTestData("digivault","hasItems", "folderName"));
		Assert.assertTrue(digitalVaultPage.isPositiveButtonEnabled(), "Folder create button is disabled");
		digitalVaultPage.tapPositiveButton();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder not created");
		Assert.assertEquals(folderViewPage.getTitle(), utils.readTestData("digivault","hasItems", "folderName"));
	}
	
	
	@Test(groups = { "DMPM-1095", "DMPM-2029", "marketplace", "Document Storage", "priority-minor" })
	public void testCancelCreateFolder() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("digivault", "hasItems", "login"), utils.readTestData("digivault", "hasItems", "pwd"));
		navigateToDigiVaultPage();
		Assert.assertNotNull(digitalVaultPage.checkAddButton(), "Add button is not present");
		digitalVaultPage.tapAddButton();
		Assert.assertNotNull(digitalVaultPage.checkCreateFolderCard(), "Add Folder button is not present");
		digitalVaultPage.tapCreateFolderCard();
		Assert.assertNotNull(digitalVaultPage.checkCancelButton(), "Folder cancel button is not present");
		digitalVaultPage.tapFolderCreateCancelButton();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digivault root folder not loaded");
	}
	
	
	@Test(groups = { "DMPM-1736", "DMPM-2356","DMPM-2357", "DMPM-2358", "DMPM-2360", "marketplace", "Document Storage", "priority-minor" })
	public void testDisplayFolderActionMenu() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("digivault", "hasItems", "login"), utils.readTestData("digivault", "hasItems", "pwd"));
		navigateToDigiVaultPage();
		if(digitalVaultPage.checkDigiVaultEmptyImage() != null) {
			createDummyData();
		}
		digitalVaultPage.tapFolderItem();
		Assert.assertNotNull(folderViewPage.checkAddButton(), "Add button is not present");
		Assert.assertTrue(folderViewPage.isEditClickable(), "Edit button is not enabled");
		folderViewPage.tapAddButton();
		Assert.assertNotNull(folderViewPage.checkAddFileFromVaultCard(), "Add file from vault is not present");
		Assert.assertNotNull(folderViewPage.checkUploadPhotoCard(), "Add from gallery is not present");
		Assert.assertNotNull(folderViewPage.checkTakePhotoCard(), "Take photo option is not present");
		
		folderViewPage.tapDocumentMoreButton();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder page not loaded");
		folderViewPage.tapDocumentMoreButton();
		folderViewPage.tapDeleteDocumentButton();
		Assert.assertNotNull(folderViewPage.checkPositiveButton(), "Positive button not seen");
		folderViewPage.tapPositiveButton();
		Assert.assertNotNull(folderViewPage.checkAddButton(), "Add button is not present");
		Assert.assertFalse(folderViewPage.isEditClickable(), "Edit button is not enabled");
		folderViewPage.tapAddButton();
		Assert.assertNotNull(folderViewPage.checkAddFileFromVaultCard(), "Add file from vault is not present");
		Assert.assertNotNull(folderViewPage.checkUploadPhotoCard(), "Add from gallery is not present");
		Assert.assertNotNull(folderViewPage.checkTakePhotoCard(), "Take photo option is not present");
		folderViewPage.tapEmptyDigitalVaultImage();
		folderViewPage.addDocumentThroughCamera();
		cameraPage.capturePhoto();
		imagePreviewPage.tapNextButton();
		Assert.assertNotNull(imagePreviewPage.checkEditField(), "Edit field not present");
		Assert.assertNotNull(imagePreviewPage.checkCancelButton(), "Cancel button not present");
		Assert.assertNotNull(imagePreviewPage.checkPositiveButton(), "Save button not present");
		Assert.assertTrue(common.isKeyboardShown(), "Keyboard not seen");

		imagePreviewPage.enterName(utils.readTestData("digivault", "hasItems", "file1"));	
		Assert.assertTrue(imagePreviewPage.isPositiveButtonEnabled(), "Save button is disabled");
		imagePreviewPage.tapPositiveButton();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Did not navigate to digi root folder");
		Assert.assertNotNull(folderViewPage.findDocumentInPage(utils.readTestData("digivault", "hasItems", "file1")), "Document not found in the folder");
	}
	
		
	@Test(groups = { "DMPM-1607", "DMPM-2539", "DMPM-2540", "DMPM-2541", "DMPM-2542", "DMPM-2543","marketplace", "Document Storage", "priority-minor" })
	public void testItemActionMenu() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("digivault", "hasItems", "login"), utils.readTestData("digivault", "hasItems", "pwd"));
		navigateToDigiVaultPage();
		if(digitalVaultPage.checkDigiVaultEmptyImage() != null) {
			createDummyData();
		}
		Assert.assertNotNull(digitalVaultPage.checkFolderMoreOption(), "Folder Item action menu is not shown");
		Assert.assertNotNull(digitalVaultPage.checkDocumentMoreOption(), "Item action menu is not shown");
		digitalVaultPage.tapDocumentMoreOption();		
		Assert.assertNotNull(digitalVaultPage.checkRenameItem(), "Rename item is not shown");
		digitalVaultPage.tapRenameItem();
		Assert.assertNotNull(common.isKeyboardShown(), "Keyboard is not shown");
		Assert.assertNotNull(digitalVaultPage.checkPositiveButton(), "Rename button is not shown");
		Assert.assertFalse(digitalVaultPage.isPositiveButtonEnabled(), "Rename button is not disabled");
		digitalVaultPage.enterName(utils.readTestData("digivault", "hasItems", "newname"));
		Assert.assertTrue(digitalVaultPage.isPositiveButtonEnabled(), "Rename button is not enabled");
		digitalVaultPage.tapPositiveButton();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digital vault view is not loaded");
 		digitalVaultPage.tapDocumentMoreOption();
		Assert.assertNotNull(digitalVaultPage.checkRenameItem(), "Rename item button is not shown");
		digitalVaultPage.tapRenameItem();
		Assert.assertNotNull(digitalVaultPage.checkCancelButton(), "Rename cancel button is not shown");
		digitalVaultPage.tapCancelButton();
		Assert.assertNull(digitalVaultPage.checkRenameDialogTitle(), "Rename dialog title is not shown");
		
		digitalVaultPage.tapFolderItem();
		Assert.assertNotNull(folderViewPage.checkDocumentMoreOption(), "Item action menu is not shown in the folder view");
		folderViewPage.tapDocumentMoreOption();
		Assert.assertNotNull(folderViewPage.checkRenameDocumentButton(), "Rename item is not shown");
		folderViewPage.tapRenameDocumentButton();
		Assert.assertNotNull(common.isKeyboardShown(), "Keyboard is not shown");
		Assert.assertNotNull(folderViewPage.checkPositiveButton(), "Rename button is not shown");
		Assert.assertFalse(folderViewPage.isPositiveButtonEnabled(), "Rename button is not disabled");
		folderViewPage.enterName(utils.readTestData("digivault", "hasItems", "newname"));
		Assert.assertTrue(folderViewPage.isPositiveButtonEnabled(), "Rename button is not enabled");
		digitalVaultPage.tapPositiveButton();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder view is not loaded");
		Assert.assertNotNull(folderViewPage.findDocumentInPage(utils.readTestData("digivault", "hasItems", "newname")), "Document not found in the folder");
		digitalVaultPage.tapDocumentMoreOption();
		Assert.assertNotNull(digitalVaultPage.checkRenameItem(), "Rename item button is not shown");
		digitalVaultPage.tapRenameItem();
		Assert.assertNotNull(folderViewPage.checkCancelButton(), "Rename cancel button is not shown");
		digitalVaultPage.tapCancelButton();
		Assert.assertNull(folderViewPage.checkRenameDialogTitle(), "Rename dialog title is not shown");
	}
	
	@Test(groups = { "DMPM-1607", "DMPM-2545","DMPM-2546","DMPM-2547","marketplace", "Document Storage", "priority-minor" })
	public void testItemActionMenuDelete() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("digivault", "hasItems", "login"), utils.readTestData("digivault", "hasItems", "pwd"));
		navigateToDigiVaultPage();
		if(digitalVaultPage.checkDigiVaultEmptyImage() != null) {
			createDummyData();
		}
		Assert.assertNotNull(digitalVaultPage.checkDocumentMoreOption(), "Item action menu is not shown");
		digitalVaultPage.tapDocumentMoreOption();
		Assert.assertNotNull(digitalVaultPage.checkDeleteItem(), "Delete item is not shown");
		digitalVaultPage.tapDeleteItem();
		Assert.assertNotNull(digitalVaultPage.checkOkButton(), "Delete button is not shown");
		Assert.assertNotNull(digitalVaultPage.checkAndroidCancelButton(), "Delete cancel button is not shown");
		digitalVaultPage.tapAndroidCancelButton();
		digitalVaultPage.swipeToDelete();
		Assert.assertNotNull(digitalVaultPage.checkBinBox(), "Bin box is not shown");
		digitalVaultPage.tapBinBox();
		Assert.assertNotNull(digitalVaultPage.checkAndroidCancelButton(), "Delete cancel button not shown");
		Assert.assertNotNull(digitalVaultPage.checkOkButton(), "Delete ok button not shown");
		digitalVaultPage.tapAndroidCancelButton();
		Assert.assertNull(digitalVaultPage.checkOkButton(), "Delete ok button is shown");
		digitalVaultPage.swipeToDelete();
		Assert.assertNotNull(digitalVaultPage.checkBinBox(), "Bin box is not shown");
		digitalVaultPage.tapBinBox();
		Assert.assertNotNull(digitalVaultPage.checkOkButton(), "Delete ok button not shown");
		digitalVaultPage.tapOkButton();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digi vault main screen is not shown");
		Assert.assertNull(digitalVaultPage.checkDocumentMoreOption(), "Item not deleted");
		
		digitalVaultPage.tapFolderItem();
		Assert.assertNotNull(folderViewPage.checkDocumentMoreOption(), "Item action menu is not shown");
		folderViewPage.tapDocumentMoreOption();
		Assert.assertNotNull(folderViewPage.checkDeleteDocumentButton(), "Delete item is not shown");
		folderViewPage.tapDeleteDocumentButton();
		Assert.assertNotNull(folderViewPage.checkOkButton(), "Delete button is not shown");
		Assert.assertNotNull(folderViewPage.checkAndroidCancelButton(), "Delete cancel button is not shown");
		digitalVaultPage.tapAndroidCancelButton();
		Assert.assertNotNull(digitalVaultPage.checkDocumentMoreOption(), "Item action menu is not shown");
		folderViewPage.swipeToDelete();
		Assert.assertNotNull(folderViewPage.checkBinBox(), "Bin box is not shown");
		folderViewPage.tapBinBox();
		Assert.assertNotNull(folderViewPage.checkAndroidCancelButton(), "Delete cancel button not shown");
		Assert.assertNotNull(folderViewPage.checkOkButton(), "Delete ok button not shown");
		folderViewPage.tapAndroidCancelButton();
		Assert.assertNull(folderViewPage.checkOkButton(), "Delete ok button is shown");
		folderViewPage.swipeToDelete();
		Assert.assertNotNull(folderViewPage.checkBinBox(), "Bin box is not shown");
		folderViewPage.tapBinBox();
		Assert.assertNotNull(folderViewPage.checkOkButton(), "Delete ok button not shown");
		folderViewPage.tapOkButton();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder title is not shown");
		Assert.assertNull(folderViewPage.checkDocumentMoreOption(), "Item not deleted");
	}
	
	@Test(groups = { "DMPM-2363", "DMPM-2923", "DMPM-2924", "DMPM-2926", "DMPM-1736", "DMPM-2359","marketplace", "Document Storage", "priority-minor" })
	public void testEditImageTitle() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("digivault", "hasItems", "login"), utils.readTestData("digivault", "hasItems", "pwd"));
		navigateToDigiVaultPage();
		digitalVaultPage.addAPhotoThroughCamera();
		cameraPage.capturePhoto();
		imagePreviewPage.tapNextButton();
		Assert.assertNotNull(imagePreviewPage.checkEditField(), "Edit field not present");
		Assert.assertNotNull(imagePreviewPage.checkCancelButton(), "Cancel button not present");
		Assert.assertNotNull(imagePreviewPage.checkPositiveButton(), "Save button not present");
		Assert.assertTrue(common.isKeyboardShown(), "Keyboard not seen");
		
		imagePreviewPage.clearEditField();
		Assert.assertFalse(imagePreviewPage.isPositiveButtonEnabled(), "Save button is enabled");
		imagePreviewPage.enterName(utils.readTestData("digivault", "hasItems", "file1"));	
		Assert.assertTrue(imagePreviewPage.isPositiveButtonEnabled(), "Save button is disabled");
		imagePreviewPage.tapPositiveButton();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Did not navigate to digi root folder");
		Assert.assertNotNull(digitalVaultPage.findDocumentInPage(utils.readTestData("digivault", "hasItems", "file1")), "Document not found in the folder");
		
		
		//From gallery
		digitalVaultPage.addAPhotoThroughGallery();
		Assert.assertNotNull(galleryPage.checkGalleryTitle(), "Gallery not loaded");
		galleryPage.choosePicture();
		imagePreviewPage.tapNextButton();
		Assert.assertNotNull(imagePreviewPage.checkEditField(), "Edit field not present");
		Assert.assertNotNull(imagePreviewPage.checkCancelButton(), "Cancel button not present");
		Assert.assertNotNull(imagePreviewPage.checkPositiveButton(), "Save button not present");
		Assert.assertTrue(common.isKeyboardShown(), "Keyboard not seen");
		
		imagePreviewPage.clearEditField();
		Assert.assertFalse(imagePreviewPage.isPositiveButtonEnabled(), "Save button is enabled");
		imagePreviewPage.enterName(utils.readTestData("digivault", "hasItems", "file2"));
		Assert.assertTrue(imagePreviewPage.isPositiveButtonEnabled(), "Save button is disabled");
		imagePreviewPage.tapPositiveButton();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Did not navigate to digi root folder");
		Assert.assertNotNull(digitalVaultPage.findDocumentInPage(utils.readTestData("digivault", "hasItems", "file2")), "Document not found in the folder");
	}
	
	@Test(groups = { "DMPM-2363", "DMPM-2927","marketplace", "Document Storage", "priority-minor" })
	public void testEditImageTitleCancel() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("digivault", "hasItems", "login"), utils.readTestData("digivault", "hasItems", "pwd"));
		navigateToDigiVaultPage();
		digitalVaultPage.addAPhotoThroughCamera();
		cameraPage.capturePhoto();
		imagePreviewPage.tapNextButton();
		Assert.assertNotNull(imagePreviewPage.checkCancelButton(), "Cancel button not present");
		imagePreviewPage.tapCancelButton();
		Assert.assertNull(imagePreviewPage.checkEditField(), "Save button not present");
	}
	
	// DMPM-799 : Scenario 2 - Navigating to the digital Vault screen
	private void navigateToDigiVaultPage() {
		Assert.assertNotNull(navigationMenu.checkSplitMenuIcon(), "Split Menu button is not displayed");
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkDigitalVaultMenuItem(), "DigiVault Menu button is not displayed");
		navigationMenu.tapDigitalVaultMenuItem();
		Assert.assertNotNull(navigationMenu.checkSplitMenuIcon(), "Hamburger menu or navigation menu is not dispalyed");
		
	}
	
	private void createDummyData() {
		Assert.assertNotNull(digitalVaultPage.checkAddButton(), "Add button not present");
		digitalVaultPage.createAnEntry();
		cameraPage.capturePhoto();
		imagePreviewPage.tapNextButton();
		imagePreviewPage.tapPositiveButton();
		
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digital vault home page is not displayed");
		digitalVaultPage.createFolder(utils.readTestData("digivault", "hasItems", "folderName"));
		digitalVaultPage.createAnEntry();
		cameraPage.capturePhoto();
		imagePreviewPage.tapNextButton();
		imagePreviewPage.tapPositiveButton();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder view page not loaded");
		Assert.assertNotNull(folderViewPage.checkAddButton(), "Folder view page not loaded");
		common.goBack();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digital vault home page is not displayed");
	}
}

