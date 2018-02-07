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
}
