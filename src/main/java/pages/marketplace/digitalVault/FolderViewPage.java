package pages.marketplace.digitalVault;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class FolderViewPage extends BasePage {

	DigiVaultCommonPage digiVaultCommonPage = new DigiVaultCommonPage(driver);
	private By folderTitle  = By.xpath("//android.view.ViewGroup[@resource-id='au.com.suncorp.marketplace:id/suncorpToolbar']/android.widget.TextView");
	private By deleteFolderButton = By.id("au.com.suncorp.marketplace:id/deleteFolderButton");
	private By deleteItemsButton = By.id("au.com.suncorp.marketplace:id/deleteDocumentsButton");
	private By renameFolderButton = By.id("au.com.suncorp.marketplace:id/renameFolderButton");
	private By moveDocumentToFolderButton = By.id("au.com.suncorp.marketplace:id/moveDocumentToFolderButton");
	private By editButton = By.id("au.com.suncorp.marketplace:id/editButton");
	private By addFromVaultCard = By.id("au.com.suncorp.marketplace:id/addFromVaultCard");
	private By emptyVaultImage = By.id("au.com.suncorp.marketplace:id/emptyDigitalVaultImage");
	private By permissionOkButton = By.id("com.android.packageinstaller:id/permission_allow_button");
	private By successNotification = By.id("au.com.suncorp.marketplace:id/dialogMessage");
	private By backButton = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
	
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
	
	public WebElement checkFolderTitleXPath(String str) {
		String t = "//android.widget.TextView[@text='"+str+"']";
		By titleName = By.xpath(t);
		return find(titleName);
	}
	
	public String getTitleXPath(String str) {
		String t = "//android.widget.TextView[@text='"+str+"']";
		By titleName = By.xpath(t);
		return getText(titleName);
	}
	
	public WebElement checkMoveDocumentToFolderButton() {
		return find(moveDocumentToFolderButton);
	}
	
	public String getTitle() {
		find(folderTitle);//Added to give a delay before tapping this element
		return getText(folderTitle);
	}
	
	public void tapPermissionOkButton() {
		tapElement(permissionOkButton);
	}
	
	public void tapDeleteItemsButton() {
		tapElement(deleteItemsButton);
	}
	
	public WebElement checkAddFileFromVaultCard() {
		return find(addFromVaultCard);
	}
	
	public WebElement checkEditButton() {
		return find(editButton,30);
	}
	
	public void tapAddFileFromVaultCard() {
		tapElement(addFromVaultCard);
	}
	
	public void tapEmptyDigitalVaultImage() {
		tapElement(emptyVaultImage);
	}
	
	public void addAPhotoFromVault() {
		digiVaultCommonPage.checkAddButton();
		digiVaultCommonPage.tapAddButton();
		checkAddFileFromVaultCard();
		tapAddFileFromVaultCard();
	}
	
	public String findDocumentInPage(String fileName) {
		String file =  driver.findElementByXPath( String.format( "//*[@text=\"%s\"]", fileName )).getText();
		return file;
	}
	public WebElement verifyFileNameExists(String fileName) {
		
		return findByUIAutomator(fileName, "text");
	}
	
	public void tapEditButton() {
		tapElement(editButton);
	}
	
	public WebElement checkDeleteFolderButton() {
		return find(deleteFolderButton);
	}
	
	public WebElement checkDeleteItemsButton() {
		return find(deleteItemsButton);
	}
	
	public void tapDeleteFolderButton() {
		tapElement(deleteFolderButton);
	}
	
	public WebElement checkRenameFolderButton() {
		return find(renameFolderButton);
	}
	
	public void tapRenameFolderButton() {
		tapElement(renameFolderButton);
	}
	
	public void waitForSuccessNotificationToDisappear() {
		waitForElementToDisappear(successNotification,5);
	}
	
	public void tapBackButton() {
		tapElement(backButton);
	}
	
}
