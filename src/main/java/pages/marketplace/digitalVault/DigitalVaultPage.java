package pages.marketplace.digitalVault;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class DigitalVaultPage extends BasePage {

	public DigitalVaultPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By digiVaultTitle = By.xpath("//android.widget.TextView[@text='Digital Vault']");
	private By chatbotButton = By.id("NavigationBarChatbotBarButtonItem");
	private By digiVaultEmptyImage = By.id("au.com.suncorp.marketplace:id/emptyDigitalVaultImage");
	private By digiVaultEmptyImageTitle = By.id("au.com.suncorp.marketplace:id/emptyDigitalVaultTitle");
	private By digiVaultEmptyImageDescription = By.id("au.com.suncorp.marketplace:id/emptyDigitalVaultDescription");
	private By addFromPhotoLibraryButton = By.id("au.com.suncorp.marketplace:id/uploadPhotoCard");
	private By addButton = By.id("au.com.suncorp.marketplace:id/addDocumentFab");
	private By sortByButton = By.id("au.com.suncorp.marketplace:id/sortByButton");
	private By editButton = By.id("au.com.suncorp.marketplace:id/editButton");
	private By folderItem = By.id("au.com.suncorp.marketplace:id/folderForeground");
	private By folderMoreButton = By.id("au.com.suncorp.marketplace:id/folderMoreButton");
	private By documentItem = By.id("au.com.suncorp.marketplace:id/documentForeground");
	private By documentMoreButton = By.id("au.com.suncorp.marketplace:id/documentMoreButton");
	private By deleteItemButton = By.id("au.com.suncorp.marketplace:id/deleteDocumentButton");
	private By deleteContentsButton = By.id("au.com.suncorp.marketplace:id/deleteContentsButton");
	private By moveToFolderButton = By.id("au.com.suncorp.marketplace:id/moveToFolderButton");
	private By permissionOkButton = By.id("com.android.packageinstaller:id/permission_allow_button");
	private By imageItem = By.id("DigitalVaultFileCell0FileThumbnailImageView");
	private By takePhotoCard = By.id("au.com.suncorp.marketplace:id/takePhotoCard");
	private By createFolderCard = By.id("au.com.suncorp.marketplace:id/createFolderCard");
	private By uploadPhotoCard = By.id("au.com.suncorp.marketplace:id/uploadPhotoCard");
	private By positiveButton = By.id("au.com.suncorp.marketplace:id/positiveButton");
	private By folderNameField = By.id("au.com.suncorp.marketplace:id/dialogEditText");
	private By cancelButton = By.id("au.com.suncorp.marketplace:id/cancelButton");
	
	
	private By renameItemButton = By.id("au.com.suncorp.marketplace:id/renameDocumentButton");
	private By renameDialogTitle = By.id("au.com.suncorp.marketplace:id/dialogTitle");
	private By renameEditField = By.id("au.com.suncorp.marketplace:id/dialogEditText");
	private By moveToFolderItemButton = By.id("au.com.suncorp.marketplace:id/moveDocumentToFolderButton");
	private By binBox = By.id("au.com.suncorp.marketplace:id/deleteDocumentOption");
	private By okButton = By.id("android:id/button1");
	private By androidCancelButton = By.id("android:id/button2");
	
	public WebElement checkDigiVaultTitle() {
		return find(digiVaultTitle);
	}

	public WebElement checkChatbotButton() {
		return find(chatbotButton);
	}
	

	public WebElement checkDigiVaultEmptyImage() {
		return find(digiVaultEmptyImage);
	}

	public WebElement checkDigiVaultEmptyImageTitle() {
		return find(digiVaultEmptyImageTitle);
	}
	
	public String getDigiVaultEmptyImageTitle()
	{
		return getText(digiVaultEmptyImageTitle);
	}

	public WebElement checkDigiVaultEmptyImageDescription() {
		return find(digiVaultEmptyImageDescription);
	}
	
	public String getdigiVaultEmptyImageDescription()
	{
		return getText(digiVaultEmptyImageDescription);
	}

	public WebElement checkAddFromPhotoLibraryButton() {
		return find(addFromPhotoLibraryButton);
	}

	public void tapAddFromPhotoLibraryButton() {
		tapElement(addFromPhotoLibraryButton);
	}

	public WebElement checkTakePhotoCard() {
		return find(takePhotoCard);
	}

	public void tapTakePhotoCard() {
		tapElement(takePhotoCard);
	}


	public void tapCancelButton() {
		tapElement(cancelButton);
	}

	
	public WebElement checkForItem() {
		return find(documentItem);
	}
	
	public boolean isEditClickable() {
		return isClickable(editButton);
	}
	
	public WebElement checkFolderNameField() {
		return find(folderNameField);
	}
	
	public WebElement checkCancelButton() {
		return find(cancelButton);
	}

	
	public boolean isPositiveButtonEnabled() {
		return isEnabled(positiveButton);
	}
	
	public void enterFolderName(String folderName) {
		typeValue(folderName, folderNameField);
	}
	
	public void tapFolderItem() {
		tapElement(folderItem);
	}
	
	public void tapDocumentItem() {
		tapElement(documentItem);
	}
	
	public WebElement checkEditButton() {
		return find(editButton,30);
	}
	
	public boolean checkEditButtonEnabled() {
		return isEnabled(editButton);
	}
	
	public WebElement checkImageItem() {
		return find(imageItem);
	}
	
	public void createAnEntry() {
		tapAddButton();
		tapTakePhotoCard();
		if(find(permissionOkButton) != null) {
			tapPermissionOkButton();
		}
	}

	public void createFolder(String folderName) {
		tapAddButton();
		tapCreateFolderCard();
		typeValue(folderName, folderNameField);
		tapPositiveButton();		
	}
	
	public void tapPositiveButton() {
		tapElement(positiveButton);
	}
	
	public WebElement checkPositiveButton() {
		return find(positiveButton);
	}
	
	public void tapPermissionOkButton() {
		tapElement(permissionOkButton);
	}
	
	public WebElement checkAddButton() {
		return find(addButton);
	}
	
	public void tapAddButton() {
		tapElement(addButton);
	}
	
	public void tapFolderCreateCancelButton() {
		tapElement(cancelButton);
	}
	
	public WebElement checkCreateFolderCard() {
		return find(createFolderCard);
	}
	
	public void tapCreateFolderCard() {
		tapElement(createFolderCard);
	}
	
	public WebElement checkFolderMoreOption() {
		return find(folderMoreButton);
	}
	
	public WebElement checkDocumentMoreOption() {
		return find(documentMoreButton);
	}
	
	public WebElement checkDeleteButton() {
		return find(deleteItemButton);
	}
	
	public WebElement checkDeleteContentsButton() {
		return find(deleteContentsButton);
	}
	
	public WebElement checkRenameItem() {
		return find(renameItemButton);
	}
	
	public WebElement checkMoveToFolderButton() {
		return find(moveToFolderButton);
	}
	
	public void tapEditButton() {
		tapElement(editButton);
	}
	
	public WebElement checkDeleteItem() {
		return find(deleteItemButton);
	}
	
	public void tapRenameItem() {
		tapElement(renameItemButton);
	}
	
	public void enterName(String name) {
		typeValue(name, renameEditField);
	}
	
	public void tapDocumentMoreOption() {
		tapElement(documentMoreButton);
	}
	
	public String findDocumentInPage(String fileName) {
		return  findElementInPage( String.format( "//*[@text=\"%s\"]", fileName ));
	}
	
	public WebElement checkRenameDialogTitle() {
		return find(renameDialogTitle);
	}
	
	public void swipeToDelete() {
		 swipeHorizontally(documentMoreButton, documentItem);
	}
	
	public void tapDeleteItem() {
		tapElement(deleteItemButton);
	}
	
	public WebElement checkBinBox() {
		return find(binBox);
	}
	
	public void tapBinBox() {
		tapElement(binBox);
	}
	
	public WebElement checkAndroidCancelButton() {
		return find(androidCancelButton);
	}

	public void tapAndroidCancelButton() {
		tapElement(androidCancelButton);
	}
	
	public WebElement checkOkButton() {
		return find(okButton);
	}

	public void tapOkButton() {
		tapElement(okButton);
	}
	
	public void addAPhotoThroughCamera() {
		tapAddButton();
		tapTakePhotoCard();
		if(find(permissionOkButton) != null) {
			tapPermissionOkButton();
		}		
	}
	
	public void addAPhotoThroughGallery() {
		checkAddButton();
		tapAddButton();
		checkUploadPhotoCard();
		tapUploadPhotoCard();
		if(find(permissionOkButton) != null) {
			tapPermissionOkButton();
		}	
	}
	
	public WebElement checkUploadPhotoCard() {
		return find(uploadPhotoCard);
	}

	public void tapUploadPhotoCard() {
		tapElement(uploadPhotoCard);
	}
	
}