package pages.marketplace.digitalVault;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class ChooseFolderPage extends BasePage{

	private By pickFolderButton = By.id("au.com.suncorp.marketplace:id/pickFolderOption");
	private By moveToFolderButton = By.id("au.com.suncorp.marketplace:id/moveToFolderOption");
	private By addFolderButton = By.id("au.com.suncorp.marketplace:id/addFolderTitle");
	private By backButton = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
	
	public ChooseFolderPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public WebElement checkPickFolderButton() {
		return find(pickFolderButton);
	}
	
	public void tapPickFolderButton() {
		tapElement(pickFolderButton);
	}
	
	public WebElement checkMoveToFolderButton() {
		return find(moveToFolderButton);
	}
	
	public boolean isMoveToFolderButtonEnabled() {
		return isEnabled(moveToFolderButton);
	}
	
	public void tapMoveToFolderButton() {
		tapElement(moveToFolderButton);
	}
	
	public WebElement checkAddFolderButton() {
		return find(addFolderButton);
	}
	
	public void tapAddFolderButton() {
		tapElement(addFolderButton);
	}
	
	public WebElement checkBackButton() {
		return find(backButton);
	}
	
	public void tapBackButton() {
		tapElement(backButton);
	}
}
