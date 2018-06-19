package pages.marketplace.digitalVault;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class SelectItemsPage extends BasePage {

	private By selectAllButton = By.id("au.com.suncorp.marketplace:id/selectAllHeaderText");
	private By deleteButton = By.id("au.com.suncorp.marketplace:id/deleteContentsOption");
	private By closeButton = MobileBy.AccessibilityId("Navigate up");
	private By itemsToBeDeleted = By.xpath("//android.widget.ImageView[@resource-id='au.com.suncorp.marketplace:id/documentItemSelector']");
	private By foldersToBeDeleted = By.xpath("//android.widget.ImageView[@resource-id='au.com.suncorp.marketplace:id/folderItemSelector']");
	private By itemSelectedDisplay = By.xpath("//android.view.ViewGroup[@resource-id='au.com.suncorp.marketplace:id/suncorpToolbar']/android.widget.TextView");
	private By moveButton = By.id("au.com.suncorp.marketplace:id/moveDocumentsOption");
	
	public SelectItemsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void selectAllItems() {
		List<WebElement> items = finds(itemsToBeDeleted);
		for(WebElement item : items) {
			tapElement(item);
		}
	}
	
	public void selectAllFolders() {
		List<WebElement> folders = finds(foldersToBeDeleted);
		for(WebElement folder : folders) {
			tapElement(folder);
		}
	}

	public boolean areAllFoldersSelected() {
		List<WebElement> folders = finds(foldersToBeDeleted);
		String numberOfFolders = Integer.toString(folders.size());
		if(getText(itemSelectedDisplay).split(" ")[0].equalsIgnoreCase(numberOfFolders)) {
			return true;
		}else
			return false;
	}
	
	public boolean areAllItemsSelected() {
		List<WebElement> items = finds(itemsToBeDeleted);
		String numberOfItems = Integer.toString(items.size());
		if(getText(itemSelectedDisplay).split(" ")[0].equalsIgnoreCase(numberOfItems)) {
			return true;
		}else
			return false;
	}
	
	public List<WebElement> getListOfItems() {
		return finds(itemsToBeDeleted);
		
	}
	
	public WebElement checkCloseButton() {
		return find(closeButton);
	}
	
	public boolean isMoveButtonEnabled() {
		return isEnabled(moveButton);
	}
	
	public WebElement checkMoveButton() {
		return find(moveButton);
	}
	
	public void tapCloseButton() {
		tapElement(closeButton);
	}
	
	public void tapMoveButton() {
		tapElement(moveButton);
	}
	
	public WebElement checkSelectAllButton() {
		return find(selectAllButton);
	}
	
	public void tapSelectAllButton() {
		tapElement(selectAllButton);
	}
	
	public boolean isDeleteButtonEnabled() {
		return isEnabled(deleteButton);
	}
	
	public WebElement checkDeleteButton() {
		return find(deleteButton);
	}
	
	public void tapDeleteButton() {
		tapElement(deleteButton);
	}
}
