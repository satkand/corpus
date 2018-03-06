package pages.marketplace.digitalVault;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class DigiVaultCommonPage extends BasePage {

	
	private By renameItemButton = By.id("au.com.suncorp.marketplace:id/renameDocumentButton");
	

	private By documentItem = By.id("au.com.suncorp.marketplace:id/documentForeground");
	private By documentMoreButton = By.id("au.com.suncorp.marketplace:id/documentMoreButton");
	private By deleteDocumentButton = By.id("au.com.suncorp.marketplace:id/deleteDocumentButton");
	private By renameDocumentButton = By.id("au.com.suncorp.marketplace:id/renameDocumentButton");
	private By deleteContentsButton = By.id("au.com.suncorp.marketplace:id/deleteContentsButton");
	private By moveToFolderButton = By.id("au.com.suncorp.marketplace:id/moveToFolderButton");
	private By moveDocumentToFolderButton = By.id("au.com.suncorp.marketplace:id/moveDocumentToFolderButton");
	private By addButton = By.id("au.com.suncorp.marketplace:id/addDocumentFab");
	private By takePhotoCard = By.id("au.com.suncorp.marketplace:id/takePhotoCard");
	private By uploadPhotoCard = By.id("au.com.suncorp.marketplace:id/uploadPhotoCard");
	private By positiveButton = By.id("au.com.suncorp.marketplace:id/positiveButton");
	private By cancelButton = By.id("au.com.suncorp.marketplace:id/cancelButton");
	private By binBox = By.id("au.com.suncorp.marketplace:id/deleteDocumentOption");
	private By renameDialogTitle = By.id("au.com.suncorp.marketplace:id/dialogTitle");
	private By renameEditField = By.id("au.com.suncorp.marketplace:id/dialogEditText");
	
	private By androidOkButton = By.id("android:id/button1");
	private By androidCancelButton = By.id("android:id/button2");
	private By permissionOkButton = By.id("com.android.packageinstaller:id/permission_allow_button");
	private By androidDialogMsg = By.id("android:id/message");
	
	public DigiVaultCommonPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void tapFolder(String folderName) {
		tapElement(By.xpath(String.format( "//*[@text=\"%s\"]", folderName)));
		
	}
	
	public void tapPermissionOkButton() {
		tapElement(permissionOkButton);
	}
	
	public WebElement checkRenameItem() {
		return find(renameItemButton);
	}
	
	public void tapRenameItem() {
		tapElement(renameItemButton);
	}
	
	public WebElement checkAndroidCancelButton() {
		return find(androidCancelButton);
	}

	public void tapAndroidCancelButton() {
		tapElement(androidCancelButton);
	}
	
	public WebElement checkAndroidOkButton() {
		return find(androidOkButton);
	}

	public void tapAndroidOkButton() {
		tapElement(androidOkButton);
	}
	
	public WebElement checkAndroidDialogMsg() {
		return find(androidDialogMsg);
	}
	
	public WebElement checkTakePhotoCard() {
		return find(takePhotoCard);
	}

	public void tapTakePhotoCard() {
		tapElement(takePhotoCard);
	}

	public WebElement checkMoveToFolderButton() {
		return find(moveToFolderButton);
	}

	public void tapMoveToFolderButton() {
		tapElement(moveToFolderButton);
	}
	
	public WebElement checkMoveDocumentToFolderButton() {
		return find(moveDocumentToFolderButton);
	}

	public void tapMoveDocumentToFolderButton() {
		tapElement(moveDocumentToFolderButton);
	}
	
	public void tapCancelButton() {
		tapElement(cancelButton);
	}

	
	public WebElement checkForItem() {
		return find(documentItem);
	}
	
	public WebElement checkCancelButton() {
		return find(cancelButton);
	}

	
	public boolean isPositiveButtonEnabled() {
		return isEnabled(positiveButton);
	}
	
	public void tapDocumentItem() {
		tapElement(documentItem);
	}
	
	public void tapPositiveButton() {
		tapElement(positiveButton);
	}
	
	public WebElement checkPositiveButton() {
		return find(positiveButton);
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
	
	public WebElement checkBinBox() {
		return find(binBox);
	}
	
	public WebElement checkUploadPhotoCard() {
		return find(uploadPhotoCard);
	}
	
	public void tapDeleteContentsButton() {
		tapElement(deleteContentsButton);
	}
	
	public void tapDocumentMoreOption() {
		tapElement(documentMoreButton);
	}
	
	
	public void tapBinBox() {
		tapElement(binBox);
	}
	
	public WebElement checkDocumentMoreOption() {
		return find(documentMoreButton);
	}
	
	public WebElement checkDeleteDocumentButton() {
		return find(deleteDocumentButton);
	}
	
	public WebElement checkDeleteContentsButton() {
		return find(deleteContentsButton);
	}
	
	
	public void tapUploadPhotoCard() {
		tapElement(uploadPhotoCard);
		if(find(permissionOkButton) != null) {
			tapPermissionOkButton();
		}
	}
	
	public void addDocumentThroughCamera() {
		tapAddButton();
		tapTakePhotoCard();
		if(find(permissionOkButton) != null) {
			tapPermissionOkButton();
		}
	}
	
	public WebElement checkRenameDocumentButton() {
		return find(renameDocumentButton);
	}
	
	public void tapRenameDocumentButton() {
		tapElement(renameDocumentButton);
	}
	
	
	public void tapDeleteDocumentButton() {
		tapElement(deleteDocumentButton);
	}
	
	public void swipeToDelete() {
		swipeHorizontally(documentMoreButton, documentItem);
	}
	
	public int findNumberOfItems() {
		List<WebElement> items = finds(documentItem);
		return items.size();
	}

	
	public WebElement checkEditField() {
		return find(renameEditField);
	}
	
	public void clearEditField() {
		clearValue(renameEditField);
	}
	
	public void tapEditField() {
		tapElement(renameEditField);
	}
	
	public WebElement checkRenameDialogTitle() {
		return find(renameDialogTitle);
	}
	
	public void enterName(String name) {
		typeValue(name, renameEditField);
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
}
