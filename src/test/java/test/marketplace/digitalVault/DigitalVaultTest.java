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
		Assert.assertNotNull(digitalVaultPage.checkDeleteButton(), "Delete item is not displayed");
		Assert.assertNotNull(digitalVaultPage.checkMoveToFolderButton(), "Move to folder item is not displayed");
		common.goBack();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digital vault home page is not displayed");
		digitalVaultPage.tapFolderItem();
		Assert.assertTrue(folderViewPage.isEditClickable(), "Edit button is not enabled");
		digitalVaultPage.tapEditButton();
		Assert.assertNotNull(folderViewPage.checkDeleteButton(), "Delete item is not displayed");
		Assert.assertNotNull(folderViewPage.checkMoveToFolderButton(), "Move to folder item is not displayed");
		common.goBack();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder page is not displayed");
		digitalVaultPage.tapDocumentItem();
		Assert.assertNotNull(imageViewPage.checkImageViewTitle(), "Image full screen is not displayed");
		Assert.assertTrue(imageViewPage.isEditClickable(), "Edit button is not enabled");
		imageViewPage.tapEditButton();
		Assert.assertNotNull(imageViewPage.checkDeleteItemButton(), "Delete item is not displayed");
		Assert.assertNotNull(imageViewPage.checkRenameItem(), "Rename item is not displayed");
		Assert.assertNotNull(imageViewPage.checkMoveToFolderButton(), "Move to folder item is not displayed");
		
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
		Assert.assertNotNull(imageViewPage.checkRenameItem(), "Rename button is not present");
		imageViewPage.tapRenameItem();
		Assert.assertNotNull(imageViewPage.checkRenameCancelButton(), "Cancel button is not displayed");
		Assert.assertNotNull(imageViewPage.checkRenameButton(), "Rename button is not displayed");
		Assert.assertFalse(imageViewPage.isRenameEnabled(), "Rename button is not disabled");
		imageViewPage.enterName(utils.readTestData("digivault", "hasItems", "newname"));
		Assert.assertTrue(imageViewPage.isRenameEnabled(), "Rename button is not enabled");
		imageViewPage.tapRenameButton();
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
		Assert.assertNotNull(imageViewPage.checkRenameItem(), "Rename button is not present");
		imageViewPage.tapRenameItem();
		imageViewPage.enterName(utils.readTestData("digivault", "hasItems", "name"));
		imageViewPage.tapRenameCancelButton();
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
		Assert.assertNotNull(imageViewPage.checkSaveButton(), "Save button is not present");
		Assert.assertNotNull(imageViewPage.checkImageNameField(), "Title field is not present");
		Assert.assertNotNull(imageViewPage.checkRenameDocumentButton(), "Rename button is not present");
		imageViewPage.tapImageNameField();
		Assert.assertTrue(common.isKeyboardShown(), "Keyboard is not seen");
		Assert.assertNotNull(imageViewPage.checkRenameSaveButton(), "Rename save button is not present");
		imageViewPage.setName(utils.readTestData("digivault", "hasItems", "fileName"));
		imageViewPage.tapSaveButton();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder page not loaded");
		Assert.assertNotNull(folderViewPage.findDocumentInPage(utils.readTestData("digivault", "hasItems", "fileName")), "Document not found in the folder");
	}
	
	@Test(groups = { "DMPM-1736", "DMPM-2359", "marketplace", "Document Storage", "priority-minor" })
	public void testAddPhotoFromGallery() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("digivault", "hasItems", "login"), utils.readTestData("digivault", "hasItems", "pwd"));
		navigateToDigiVaultPage();
		if(digitalVaultPage.checkDigiVaultEmptyImage() != null) {
			createDummyData();
		}
		digitalVaultPage.tapFolderItem();
		Assert.assertNotNull(folderViewPage.checkAddButton(), "Add button is not present");
		folderViewPage.tapAddButton();
		Assert.assertNotNull(folderViewPage.checkUploadPhotoCard(), "Add from gallery is not present");
		folderViewPage.tapUploadPhotoCard();
		Assert.assertNotNull(galleryPage.checkGalleryTitle(), "Gallery not loaded");
		galleryPage.choosePicture();
		
		Assert.assertNotNull(imageViewPage.checkSaveButton(), "Save button is not present");
		Assert.assertNotNull(imageViewPage.checkImageNameField(), "Title field is not present");
		Assert.assertNotNull(imageViewPage.checkRenameDocumentButton(), "Rename button is not present");
		imageViewPage.tapImageNameField();
		Assert.assertTrue(common.isKeyboardShown(), "Keyboard is not seen");
		Assert.assertNotNull(imageViewPage.checkRenameSaveButton(), "Rename save button is not present");
		imageViewPage.setName(utils.readTestData("digivault", "hasItems", "fileName"));
		imageViewPage.tapSaveButton();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder page not loaded");
		Assert.assertNotNull(folderViewPage.findDocumentInPage(utils.readTestData("digivault", "hasItems", "fileName")), "Document not found in the folder");
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
		Assert.assertNotNull(digitalVaultPage.checkRenameButton(), "Rename button is not shown");
		Assert.assertFalse(digitalVaultPage.isRenameEnabled(), "Rename button is not disabled");
		Assert.assertNotNull(digitalVaultPage.checkRenameCancelButton(), "Rename cancel button is not shown");
		digitalVaultPage.enterName(utils.readTestData("digivault", "hasItems", "newname"));
		Assert.assertTrue(digitalVaultPage.isRenameEnabled(), "Rename button is not enabled");
		digitalVaultPage.tapRenameButton();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digital vault view is not loaded");
		Assert.assertNotNull(digitalVaultPage.findDocumentInPage(utils.readTestData("digivault", "hasItems", "newname")), "Document not found in the folder");
		digitalVaultPage.tapRenameItem();
		Assert.assertNotNull(digitalVaultPage.checkRenameCancelButton(), "Rename cancel button is not shown");
		digitalVaultPage.tapRenameCancelButton();
		Assert.assertNotNull(digitalVaultPage.checkRenameDialogTitle(), "Rename dialog title is not shown");
		
		digitalVaultPage.tapFolderItem();
		Assert.assertNotNull(folderViewPage.checkDocumentMoreOption(), "Item action menu is not shown in the folder view");
		folderViewPage.tapDocumentMoreOption();
		Assert.assertNotNull(folderViewPage.checkRenameItem(), "Rename item is not shown");
		folderViewPage.tapRenameItem();
		Assert.assertNotNull(common.isKeyboardShown(), "Keyboard is not shown");
		Assert.assertNotNull(folderViewPage.checkRenameButton(), "Rename button is not shown");
		Assert.assertFalse(folderViewPage.isRenameEnabled(), "Rename button is not disabled");
		Assert.assertNotNull(folderViewPage.checkRenameCancelButton(), "Rename cancel button is not shown");
		folderViewPage.enterName(utils.readTestData("digivault", "hasItems", "newname"));
		Assert.assertTrue(folderViewPage.isRenameEnabled(), "Rename button is not enabled");
		digitalVaultPage.tapRenameButton();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder view is not loaded");
		Assert.assertNotNull(folderViewPage.findDocumentInPage(utils.readTestData("digivault", "hasItems", "newname")), "Document not found in the folder");
		digitalVaultPage.tapRenameItem();
		Assert.assertNotNull(folderViewPage.checkRenameCancelButton(), "Rename cancel button is not shown");
		digitalVaultPage.tapRenameCancelButton();
		Assert.assertNotNull(folderViewPage.checkRenameDialogTitle(), "Rename dialog title is not shown");
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
		Assert.assertNotNull(folderViewPage.checkDeleteItem(), "Delete item is not shown");
		folderViewPage.tapDeleteItem();
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
	
	// DMPM-799 : Scenario 2 - Navigating to the digital Vault screen
	private void navigateToDigiVaultPage() {
		Assert.assertNotNull(navigationMenu.checkSplitMenuIcon(), "Split Menu button is not displayed");
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkDigitalVaultMenuItem(), "DigiVault Menu button is not displayed");
		navigationMenu.tapDigitalVaultMenuItem();
		Assert.assertNotNull(navigationMenu.checkSplitMenuIcon(), "Hamburger menu or navigation menu is not dispalyed");
	}
	
	private void createDummyData() {
		digitalVaultPage.createAnEntry();
		cameraPage.capturePhoto();
		imageViewPage.tapSaveButton();
		
		digitalVaultPage.createFolder(utils.readTestData("digivault", "hasItems", "folderName"));
		digitalVaultPage.createAnEntry();
		cameraPage.capturePhoto();
		imageViewPage.tapSaveButton();
		Assert.assertNotNull(folderViewPage.checkFolderTitle(), "Folder view page not loaded");
		common.goBack();
		Assert.assertNotNull(digitalVaultPage.checkDigiVaultTitle(), "Digital vault home page is not displayed");
	}
}

