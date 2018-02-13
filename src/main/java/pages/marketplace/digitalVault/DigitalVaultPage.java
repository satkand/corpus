package pages.marketplace.digitalVault;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class DigitalVaultPage extends BasePage {

	public DigitalVaultPage(@SuppressWarnings("rawtypes") AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By takePhotoButton = By.id("au.com.suncorp.marketplace:id/addDocumentFab");
	private By cancelButton = By.id("Cancel");
	private By allowCameraButton = By.id("com.android.packageinstaller:id/permission_allow_button");
    // TODO --change the way of interacting with camera Button in different devices.
	private By cameraButtonGalaxy = By.xpath("(//GLButton[@content-desc=\"NONE\"])[3]");
    private By cameraButtonPixel = By.id("com.google.android.GoogleCamera:id/shutter_button");
    private By okButton = By.id("com.sec.android.app.camera:id/okay");
    private By saveImageButton = By.id("au.com.suncorp.marketplace:id/saveDocumentOption");
    private By renameImageButton = By.id("au.com.suncorp.marketplace:id/renameDocumentButton");
    private By sortByName = By.id("au.com.suncorp.marketplace:id/documentTitle");
    private By backToGalleryButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    private By editPhotoTitleText = By.id("au.com.suncorp.marketplace:id/renameEditText");
    private By saveEditedTitleButton = By.id("au.com.suncorp.marketplace:id/saveDocumentButton");
    
    private By sortingButtonIcon = By.id("au.com.suncorp.marketplace:id/sortingButtonIcon");
    private By sortByDate = By.id("au.com.suncorp.marketplace:id/headerTitle");
    private By imageTitle = By.id("au.com.suncorp.marketplace:id/documentTitle");
    
    public List<String> fetchImageTitleList(){
		return getTextList(imageTitle);
	}
    
	public void tapAllowCameraButton() {
		tapElement(allowCameraButton);
	}
	
	public WebElement checkAllowCameraButton() {
		return find(allowCameraButton);
	}
	
	public WebElement checkSortingButtonIcon() {
		return find(sortingButtonIcon);
	}
	
	public WebElement checkSortByDate() {
		return find(sortByDate);
	}
	
	public void tapSortByDate() {
		tapElement(sortByDate);
	}
	
	public void tapSortByName() {
		tapElement(sortByName);
	}
	
	public WebElement checkSortByName() {
		return find(sortByName);
	}
	
	public void tapSortingButtonIcon() {
		tapElement(sortingButtonIcon);
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

