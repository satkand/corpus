package pages.marketplace.digitalVault;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class FolderViewPage extends BasePage {

	
	private By editButton = By.id("au.com.suncorp.marketplace:id/editButton");
	private By deleteItemButton = By.id("au.com.suncorp.marketplace:id/deleteItemButton");
	private By moveToFolderButton = By.id("au.com.suncorp.marketplace:id/moveToFolderButton");
	private By folderTitle  = By.xpath("//android.view.ViewGroup[@resource-id='au.com.suncorp.marketplace:id/suncorpToolbar']/android.widget.TextView");
	private By documentMoreButton = By.id("au.com.suncorp.marketplace:id/documentMoreButton");
	private By uploadPhotoCard = By.id("au.com.suncorp.marketplace:id/uploadPhotoCard");
	private By takePhotoCard = By.id("au.com.suncorp.marketplace:id/takePhotoCard");
	private By addFromVaultCard = By.id("au.com.suncorp.marketplace:id/addFromVaultCard");
	private By deleteDocumentButton = By.id("au.com.suncorp.marketplace:id/deleteDocumentButton");
	private By renameDocumentButton = By.id("au.com.suncorp.marketplace:id/renameDocumentButton");
	private By moveDocumentToFolderButton = By.id("au.com.suncorp.marketplace:id/moveDocumentToFolderButton");
	private By addButton = By.id("au.com.suncorp.marketplace:id/addDocumentFab");
	private By emptyVaultImage = By.id("au.com.suncorp.marketplace:id/emptyDigitalVaultImage");
	
	private By permissionOkButton = By.id("com.android.packageinstaller:id/permission_allow_button");
	
	//TODO: This id will be changed
	private By positiveButton = By.id("android:id/button1");
	private By cancelButton = By.id("android:id/button2");
	
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
		return find(moveToFolderButton);
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
}
