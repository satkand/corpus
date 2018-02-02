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
	
	private By addFromPhotoLibraryNutton = By.id("Add from Photo Library");
	private By takePhotoButton = By.id("au.com.suncorp.marketplace:id/addDocumentFab");
	private By cancelButton = By.id("Cancel");
	private By allowCameraButton = By.id("com.android.packageinstaller:id/permission_allow_button");
    private By cameraButtonGalaxy = By.xpath("(//GLButton[@content-desc=\"NONE\"])[3]");
    private By cameraButtonPixel = By.id("com.google.android.GoogleCamera:id/shutter_button");
    private By okButton = By.id("com.sec.android.app.camera:id/okay");
    private By saveImageButton = By.id("au.com.suncorp.marketplace:id/saveDocumentOption");
    private By renameImageButton = By.id("au.com.suncorp.marketplace:id/renameDocumentButton");
    private By backToGalleryButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    private By editPhotoTitleText = By.id("au.com.suncorp.marketplace:id/renameEditText");
    private By saveEditedTitleButton = By.id("au.com.suncorp.marketplace:id/saveDocumentButton");
    

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
	
	public void tapCameraButtonGalaxy() {
		tapElement(cameraButtonGalaxy);
	}
	
	public WebElement checkCameraButtonGalaxy() {
		return find(cameraButtonGalaxy);
	}
	
	public void tapCameraButtonPixel() {
		tapElement(cameraButtonPixel);
	}
	
	public WebElement checkCameraButtonPixel() {
		return find(cameraButtonPixel);
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
	

	public WebElement checkBackToGalleryButton() {
		return find(backToGalleryButton);
	}
	
	public void tapBackToGalleryButton() {
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
	
	public WebElement checkSaveEditedTitleButton() {
		return find(saveEditedTitleButton);
	}
	
	public void renameImage(String renameImage) {
		typeValue(renameImage, editPhotoTitleText);
	}
}

