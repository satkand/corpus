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
	
	private By addPhotosButton = By.id("au.com.suncorp.marketplace:id/capturePhotoButton");
	private By addFromPhotoLibraryNutton = By.id("Add from Photo Library");
	private By takePhotoButton = By.id("au.com.suncorp.marketplace:id/addDocumentFab");
	private By cancelButton = By.id("Cancel");
	private By allowCameraButton = By.id("com.android.packageinstaller:id/permission_allow_button");
    private By cameraButton = By.xpath("(//GLButton[@content-desc=\"NONE\"])[3]");
    private By okButton = By.id("com.sec.android.app.camera:id/okay");
    private By saveImageButton = By.id("au.com.suncorp.marketplace:id/saveDocumentOption");
    private By renameImageButton = By.id("au.com.suncorp.marketplace:id/renameDocumentButton");
    private By backToGalleryButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    private By editPhotoTitleText = By.id("au.com.suncorp.marketplace:id/renameEditText");
    private By saveEditedTitleButton = By.id("au.com.suncorp.marketplace:id/saveDocumentButton");
    
	public WebElement checkAddPhotosButton() {
		return find(addPhotosButton);
	}

	public void tapAddPhotoButton() {
		find(addPhotosButton);
		tapElement(addPhotosButton);
	}

	public void tapAllowCameraButton() {
		tapElement(allowCameraButton);
	}
	public WebElement checkAddFromPhotoLibraryButton() {
		return find(addFromPhotoLibraryNutton);
	}

	public void tapAddFromPhotoLibraryButton() {
		tapElement(addFromPhotoLibraryNutton);
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
	
	public void tapCameraButton() {
		tapElement(cameraButton);
	}
	
	public WebElement checkCameraButton() {
		return find(cameraButton);
	}
	
	public void tapOkButton() {
		tapElement(okButton);
	}
	
	public WebElement checkOkButton() {
		return find(okButton);
	}
	
	public void tapSaveImageButton() {
		tapElement(saveImageButton);
	}
	
	public WebElement checkSaveImageButton() {
		return find(saveImageButton);
	}
	
	public void tapRenameImageButton() {
		tapElement(renameImageButton);
	}

	public WebElement checkRenameImageButton() {
		return find(renameImageButton);
	}
	
	public void tapbackToGalleryButton() {
		tapElement(backToGalleryButton);
	}
	
	public WebElement checkbackToGalleryButton() {
		return find(backToGalleryButton);
	}
	
	public void tapEditPhotoTitleText() {
		tapElement(editPhotoTitleText);
	}
	
	public void tapSaveEditedTitleButton() {
		tapElement(saveEditedTitleButton);
	}
}

