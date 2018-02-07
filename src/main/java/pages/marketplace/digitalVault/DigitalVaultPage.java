package pages.marketplace.digitalVault;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
	private By takePhotoButton = By.id("au.com.suncorp.marketplace:id/takePhotoCard");
	private By cancelButton = By.id("Cancel");
	private By sortByButton = By.id("au.com.suncorp.marketplace:id/sortByButton");
	private By editButton = By.id("au.com.suncorp.marketplace:id/editButton");
	private By folderItem = By.xpath("//android.widget.LinearLayout[@resource-id='au.com.suncorp.marketplace:id/folderForeground']");
	private By folderMoreButton = By.xpath("//android.widget.LinearLayout[@resource-id='au.com.suncorp.marketplace:id/folderMoreButton']");
	private By documentItem = By.xpath("//android.widget.LinearLayout[@resource-id='au.com.suncorp.marketplace:id/documentForeground']");
	private By documentMoreButton = By.xpath("//android.widget.LinearLayout[@resource-id='au.com.suncorp.marketplace:id/documentMoreButton']");
	private By deleteItemButton = By.id("au.com.suncorp.marketplace:id/deleteItemButton");
	private By moveToFolderButton = By.id("au.com.suncorp.marketplace:id/moveToFolderButton");
	private By cameraPermissionOkButton = By.id("com.android.packageinstaller:id/permission_allow_button");
	private By imageItem = By.id("DigitalVaultFileCell0FileThumbnailImageView");
	private By addButton = By.id("au.com.suncorp.marketplace:id/addDocumentFab");
	private By createFolderButton = By.id("au.com.suncorp.marketplace:id/createFolderCard");
	private By addFolderButton = By.id("au.com.suncorp.marketplace:id/positiveButton");
	private By folderNameField = By.id("au.com.suncorp.marketplace:id/dialogEditText");
	
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
		return readValue(digiVaultEmptyImageTitle);
	}

	public WebElement checkDigiVaultEmptyImageDescription() {
		return find(digiVaultEmptyImageDescription);
	}
	
	public String getdigiVaultEmptyImageDescription()
	{
		return readValue(digiVaultEmptyImageDescription);
	}

	public WebElement checkAddFromPhotoLibraryButton() {
		return find(addFromPhotoLibraryButton);
	}

	public void tapAddFromPhotoLibraryButton() {
		tapElement(addFromPhotoLibraryButton);
	}

	public WebElement checkTakePhotoButton() {
		return find(takePhotoButton);
	}

	public void tapTakePhotoButton() {
		tapElement(takePhotoButton);
	}

	public WebElement checkCancelButton() {
		return find(cancelButton);
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
	
	public void tapEditButton() {
		tapElement(editButton);
	}
	
	public WebElement checkDeleteButton() {
		return find(deleteItemButton);
	}
	
	public WebElement checkMoveToFolderButton() {
		return find(moveToFolderButton);
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
		tapTakePhotoButton();
		if(find(cameraPermissionOkButton) != null) {
			tapcameraPermissionOkButton();
		}
	}

	public void createFolder(String folderName) {
		tapAddButton();
		tapCreateFolder();
		typeValue(folderName, folderNameField);
		tapAddFolderButton();
		
	}
	
	public void tapcameraPermissionOkButton() {
		tapElement(cameraPermissionOkButton);
	}
	
	public WebElement checkAddButton() {
		return find(addButton);
	}
	public void tapAddButton() {
		tapElement(addButton);
	}
	
	public void tapCreateFolder() {
		tapElement(createFolderButton);
	}
	
	public void tapAddFolderButton() {
		tapElement(addFolderButton);
	}
	
}