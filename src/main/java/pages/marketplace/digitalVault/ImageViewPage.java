package pages.marketplace.digitalVault;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class ImageViewPage extends BasePage {

	
	private By imageViewTitle = By.xpath("//android.view.ViewGroup[@resource-id='au.com.suncorp.marketplace:id/action_bar']"
			+ "/android.widget.TextView");
	private By editButton = By.id("au.com.suncorp.marketplace:id/editDocumentOption");
	private By deleteItemButton = By.id("au.com.suncorp.marketplace:id/deleteItemButton");
	private By renameItemButton = By.id("au.com.suncorp.marketplace:id/renameItemButton");
	private By moveToFolderButton = By.id("au.com.suncorp.marketplace:id/moveToFolderButton");
	private By backButton = By.id("Navigate up");
	private By saveButton = By.id("au.com.suncorp.marketplace:id/saveDocumentOption");
	
	private By renameDialogTitle = By.id("au.com.suncorp.marketplace:id/dialogTitle");
	private By renameEditField = By.id("au.com.suncorp.marketplace:id/dialogEditText");
	private By renameButton = By.id("au.com.suncorp.marketplace:id/positiveButton");
	private By renameCancelButton = By.id("au.com.suncorp.marketplace:id/cancelButton");
	private By imageNameField = By.id("au.com.suncorp.marketplace:id/documentTitleDisplay");
	private By renameDocumentButton = By.id("au.com.suncorp.marketplace:id/renameDocumentButton");
	private By renameSaveButton = By.id("au.com.suncorp.marketplace:id/saveDocumentButton");
	private By editTextField = By.id("au.com.suncorp.marketplace:id/renameEditText");
	
	public ImageViewPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement checkImageViewTitle() {
		return find(imageViewTitle);
	}
	
	public WebElement checkSaveButton() {
		return find(saveButton);
	}
	
	public boolean isEditClickable() {
		return isClickable(editButton);
	}
	
	public boolean isRenameEnabled() {
		return isEnabled(renameButton);
	}
	
	public WebElement checkDeleteButton() {
		return find(deleteItemButton);
	}
	
	public WebElement checkRenameButton() {
		return find(renameButton);
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
	
	public void tapRenameItem() {
		tapElement(renameItemButton);
	}
	
	public void tapRenameButton() {
		tapElement(renameButton);
	}
	
	public void tapSaveButton() {
		tapElement(saveButton);
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
	
	public String readTitleValue() {
		return readValue(imageViewTitle);
	}
	
	public WebElement checkRenameDialogTitle() {
		return find(renameDialogTitle);
	}
	
	public WebElement checkImageNameField() {
		return find(imageNameField);
	}
	
	public void tapImageNameField() {
		tapElement(imageNameField);
	}
	
	public void tapRenameSaveButton() {
		tapElement(renameSaveButton);
	}
	
	public WebElement checkRenameSaveButton() {
		return find(renameSaveButton);
	}
	
	public void setName(String name) {
		typeValue(name, editTextField);
		tapRenameSaveButton();
	}
	
	public WebElement checkRenameDocumentButton() {
		return find(renameDocumentButton);
	}
	
/*	public WebElement checkRetakeButton() {
		return find(retakeButton);
	}*/
}
