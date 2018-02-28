package pages.marketplace.digitalVault;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class FolderViewPage extends BasePage {

	
	private By folderTitle  = By.xpath("//android.view.ViewGroup[@resource-id='au.com.suncorp.marketplace:id/suncorpToolbar']/android.widget.TextView");
	private By deleteFolderButton = By.id("au.com.suncorp.marketplace:id/deleteFolderButton");
	private By renameFolderButton = By.id("au.com.suncorp.marketplace:id/renameFolderButton");
	private By deleteDocumentsButton = By.id("au.com.suncorp.marketplace:id/deleteDocumentsButton");
	private By moveToFolderButton = By.id("au.com.suncorp.marketplace:id/moveToFolderButton");
	private By deleteDocumentButton = By.id("au.com.suncorp.marketplace:id/deleteDocumentButton");
	private By renameDocumentButton = By.id("au.com.suncorp.marketplace:id/renameDocumentButton");
	private By moveDocumentToFolderButton = By.id("au.com.suncorp.marketplace:id/moveDocumentToFolderButton");
	private By documentMoreButton = By.id("au.com.suncorp.marketplace:id/documentMoreButton");
	private By editButton = By.id("au.com.suncorp.marketplace:id/editButton");
	private By documentItem = By.id("au.com.suncorp.marketplace:id/documentForeground");
	private By uploadPhotoCard = By.id("au.com.suncorp.marketplace:id/uploadPhotoCard");
	private By takePhotoCard = By.id("au.com.suncorp.marketplace:id/takePhotoCard");
	private By addFromVaultCard = By.id("au.com.suncorp.marketplace:id/addFromVaultCard");
	private By addButton = By.id("au.com.suncorp.marketplace:id/addDocumentFab");
	private By emptyVaultImage = By.id("au.com.suncorp.marketplace:id/emptyDigitalVaultImage");
	
	private By renameDialogTitle = By.id("au.com.suncorp.marketplace:id/dialogTitle");
	private By renameEditField = By.id("au.com.suncorp.marketplace:id/dialogEditText");
	private By positiveButton = By.id("au.com.suncorp.marketplace:id/positiveButton");
	private By cancelButton = By.id("au.com.suncorp.marketplace:id/cancelButton");
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
	
	public WebElement checkDeleteDocumentButton() {
		return find(deleteDocumentButton);
	}
	
	public WebElement checkMoveDocumentToFolderButton() {
		return find(moveDocumentToFolderButton);
	}
	
	public String getTitle() {
		return readValue(folderTitle);
	}
	
	public WebElement checkPositiveButton() {
		return find(positiveButton);
	}
	
	public void tapPositiveButton() {
		tapElement(positiveButton);
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
	
	public WebElement checkRenameDocumentButton() {
		return find(renameDocumentButton);
	}
	
	public void tapEditButton() {
		tapElement(editButton);
	}
	
	public void tapRenameDocumentButton() {
		tapElement(renameDocumentButton);
	}
	
	public void enterName(String name) {
		typeValue(name, renameEditField);
	}
	
	public WebElement checkDeleteFolderButton() {
		return find(deleteFolderButton);
	}
	
	public WebElement checkMoveToFolderButton() {
		return find(moveToFolderButton);
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
	
	public WebElement checkCancelButton() {
		return find(cancelButton);
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
	
	public boolean isPositiveButtonEnabled() {
		return isEnabled(positiveButton);
	}
	
}
