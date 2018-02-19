package pages.marketplace.digitalVault;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class ImageViewPage extends BasePage {

	public ImageViewPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By editButton = By.id("au.com.suncorp.marketplace:id/editDocumentOption");
	private By deleteDocumentButton = By.id("au.com.suncorp.marketplace:id/deleteDocumentButton");
	private By renameDocumentButton = By.id("au.com.suncorp.marketplace:id/renameDocumentButton");
	private By moveDocumentToFolderButton = By.id("au.com.suncorp.marketplace:id/moveDocumentToFolderButton");
	private By moveContentsToFolderButton = By.id("au.com.suncorp.marketplace:id/moveToFolderButton");
	private By deleteContentsButton = By.id("au.com.suncorp.marketplace:id/deleteContentsButton");
	private By renameDialogTitle = By.id("au.com.suncorp.marketplace:id/dialogTitle");
	private By renameEditField = By.id("au.com.suncorp.marketplace:id/dialogEditText");
	private By positiveButton = By.id("au.com.suncorp.marketplace:id/positiveButton");
	private By cancelButton = By.id("au.com.suncorp.marketplace:id/cancelButton");
	private By imageViewTitle = By.xpath("//android.view.ViewGroup[@resource-id='au.com.suncorp.marketplace:id/action_bar']"
			+ "/android.widget.TextView");
	
	private By androidOkButton = By.id("android:id/button1");
	private By androidCancelButton = By.id("android:id/button2");
	
	public boolean isEditClickable() {
		return isClickable(editButton);
	}
	
	public WebElement checkDeleteDocumentButton() {
		return find(deleteDocumentButton);
	}
	
	public WebElement checkRenameDocumentButton() {
		return find(renameDocumentButton);
	}
	
	public WebElement checkMoveDocumentToFolderButton() {
		return find(moveDocumentToFolderButton);
	}
	
	public void tapEditButton() {
		tapElement(editButton);
	}
	
	public void tapRenameDocumentButton() {
		tapElement(renameDocumentButton);
	}
	
	public void tapDeleteDocumentButton() {
		tapElement(deleteDocumentButton);
	}
	
	public boolean isPositiveButtonEnabled() {
		return isEnabled(positiveButton);
	}

	public WebElement checkPositiveButton() {
		return find(positiveButton);
	}
	
	public void tapPositiveButton() {
		tapElement(positiveButton);
	}
	
	public WebElement checkCancelButton() {
		return find(cancelButton);
	}
	
	public void tapCancelButton() {
		tapElement(cancelButton);
	}
	
	public void enterName(String name) {
		typeValue(name, renameEditField);
	}
	
	public String readTitleValue() {
		return readValue(imageViewTitle);
	}
	
	public WebElement checkImageViewTitle() {
		return find(imageViewTitle);
	}
	
	public WebElement checkRenameDialogTitle() {
		return find(renameDialogTitle);
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
}
