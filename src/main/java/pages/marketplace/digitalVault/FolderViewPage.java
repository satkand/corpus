package pages.marketplace.digitalVault;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class FolderViewPage extends BasePage {

	
	private By editButton = By.id("au.com.suncorp.marketplace:id/editButton");
	private By deleteItemButton = By.id("au.com.suncorp.marketplace:id/deleteDocumentButton");
	private By moveToFolderItemButton = By.id("au.com.suncorp.marketplace:id/moveDocumentToFolderButton");
	private By folderTitle  = By.xpath("//android.view.ViewGroup[@resource-id='au.com.suncorp.marketplace:id/suncorpToolbar']/android.widget.TextView");
	private By documentMoreButton = By.id("au.com.suncorp.marketplace:id/documentMoreButton");
	private By documentItem = By.id("au.com.suncorp.marketplace:id/documentForeground");
	private By folderMoreButton = By.id("au.com.suncorp.marketplace:id/folderMoreButton");
	private By uploadPhotoCard = By.id("au.com.suncorp.marketplace:id/uploadPhotoCard");
	private By takePhotoCard = By.id("au.com.suncorp.marketplace:id/takePhotoCard");
	private By addFromVaultCard = By.id("au.com.suncorp.marketplace:id/addFromVaultCard");
	private By deleteDocumentButton = By.id("au.com.suncorp.marketplace:id/deleteDocumentButton");
	private By renameDocumentButton = By.id("au.com.suncorp.marketplace:id/renameDocumentButton");
	private By moveDocumentToFolderButton = By.id("au.com.suncorp.marketplace:id/moveDocumentToFolderButton");
	private By addButton = By.id("au.com.suncorp.marketplace:id/addDocumentFab");
	private By emptyVaultImage = By.id("au.com.suncorp.marketplace:id/emptyDigitalVaultImage");
	
	private By renameItemButton = By.id("au.com.suncorp.marketplace:id/renameDocumentButton");
	private By renameDialogTitle = By.id("au.com.suncorp.marketplace:id/dialogTitle");
	private By renameEditField = By.id("au.com.suncorp.marketplace:id/dialogEditText");
	private By renameButton = By.id("au.com.suncorp.marketplace:id/positiveButton");
	private By renameCancelButton = By.id("au.com.suncorp.marketplace:id/cancelButton");
	private By binBox = By.id("au.com.suncorp.marketplace:id/deleteDocumentOption");
	
	private By permissionOkButton = By.id("com.android.packageinstaller:id/permission_allow_button");
	
	//TODO: This id will be changed
	private By okButton = By.id("android:id/button1");
	private By androidCancelButton = By.id("android:id/button2");
	
	public FolderViewPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isEditClickable() {
		return isClickable(editButton);
	}
	
	public WebElement checkFolderTitle() {
		return find(folderTitle);
	}
	
	public WebElement checkDeleteButton() {
		return find(deleteItemButton);
	}
	
	public WebElement checkMoveToFolderButton() {
		return find(moveToFolderItemButton);
	}
	
	public String getTitle() {
		return readValue(folderTitle);
	}
	
	public WebElement checkPositiveButton() {
		return find(okButton);
	}
	
	public void tapPositiveButton() {
		tapElement(okButton);
	}
	
	public WebElement checkAddButton() {
		return find(addButton);
	}
	
	public void tapAddButton() {
		tapElement(addButton);
	}
	
	public void tapUploadPhotoCard() {
		tapElement(uploadPhotoCard);
		if(find(permissionOkButton) != null) {
			tapPermissionOkButton();
		}
	}
	
	public void tapPermissionOkButton() {
		tapElement(permissionOkButton);
	}
	
	public WebElement checkAddFileFromVaultCard() {
		return find(addFromVaultCard);
	}
	
	public WebElement checkUploadPhotoCard() {
		return find(uploadPhotoCard);
	}
	
	public WebElement checkTakePhotoCard() {
		return find(takePhotoCard);
	}
	
	public void tapTakePhotoCard() {
		tapElement(takePhotoCard);
	}
	
	public void tapDocumentMoreButton() {
		tapElement(documentMoreButton);
	}
	
	public void tapDeleteDocumentButton() {
		tapElement(deleteDocumentButton);
	}
	
	
	public void tapEmptyDigitalVaultImage() {
		tapElement(emptyVaultImage);
	}
	
	public WebElement checkDocumentMoreOption() {
		return find(documentMoreButton);
	}
	
	public void addDocumentThroughCamera() {
		tapAddButton();
		tapTakePhotoCard();
		if(find(permissionOkButton) != null) {
			tapPermissionOkButton();
		}
	}
	
	public String findDocumentInPage(String fileName) {
		String file =  driver.findElementByXPath( String.format( "//*[@text=\"%s\"]", fileName )).getText();
		return file;
	}
	
	public boolean isRenameEnabled() {
		return isEnabled(renameButton);
	}
	
	public WebElement checkRenameButton() {
		return find(renameButton);
	}
	
	public WebElement checkRenameItem() {
		return find(renameItemButton);
	}
	
	public void tapEditButton() {
		tapElement(editButton);
	}
	
	public void tapRenameItem() {
		tapElement(renameItemButton);
	}
	
	public void tapRenameButton() {
		tapElement(renameButton);
	}
	
	public WebElement checkRenameCancelButton() {
		return find(renameCancelButton);
	}
	
	public void tapRenameCancelButton() {
		tapElement(renameCancelButton);
	}
	
	public void enterName(String name) {
		typeValue(name, renameEditField);
	}
	
	public WebElement checkDeleteItem() {
		return find(deleteItemButton);
	}
	
	public void tapDocumentMoreOption() {
		tapElement(documentMoreButton);
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
	
}
