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
	private By moveDocumentToFolderButton = By.id("au.com.suncorp.marketplace:id/moveDocumentToFolderButton");
	private By renameDialogTitle = By.id("au.com.suncorp.marketplace:id/dialogTitle");
	private By renameEditField = By.id("au.com.suncorp.marketplace:id/dialogEditText");

	private By imageViewTitle = By.xpath("//android.view.ViewGroup[@resource-id='au.com.suncorp.marketplace:id/action_bar']"
			+ "/android.widget.TextView");
	
	
	public boolean isEditClickable() {
		return isClickable(editButton);
	}
	
	
	public WebElement checkMoveDocumentToFolderButton() {
		return find(moveDocumentToFolderButton);
	}
	
	public WebElement checkEditButton() {
		return find(editButton);
	}
	
	public void tapEditButton() {
		tapElement(editButton);
	}
	
	public void enterName(String name) {
		typeValue(name, renameEditField);
	}
	
	public String readTitleValue() {
		return getText(imageViewTitle);
	}
	
	public WebElement checkImageViewTitle() {
		return find(imageViewTitle);
	}
	
	public WebElement checkRenameDialogTitle() {
		return find(renameDialogTitle);
	}

}
