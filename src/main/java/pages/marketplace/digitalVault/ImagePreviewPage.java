package pages.marketplace.digitalVault;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class ImagePreviewPage extends BasePage {

	DigiVaultCommonPage digiVaultCommonPage = new DigiVaultCommonPage(driver);
	//TODO: id to be added
	private By nextButton = By.xpath("//android.widget.TextView[@content-desc='NEXT button']");
	private By previousButton = MobileBy.AccessibilityId("Navigate up");
	
	private ChooseFolderPage choosefolderPage = new ChooseFolderPage(driver);
	
	public ImagePreviewPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement checkPreviousButton() {
		return find(previousButton);
	}
	
	public void tapPreviousButton() {
		tapElement(previousButton);
	}
	
	public WebElement checkNextButton() {
		return find(nextButton);
	}
	
	public void tapNextButton() {
		tapElement(nextButton);
	}
	
	public void finishSavingImageByChoosingFolder() {
		checkNextButton();
		tapNextButton();
		digiVaultCommonPage.checkPositiveButton();
		digiVaultCommonPage.tapPositiveButton();
		choosefolderPage.checkPickFolderButton();
		choosefolderPage.tapPickFolderButton();
	}
	
	public void finishSavingImageByChoosingFolder(String fileName) {
		checkNextButton();
		tapNextButton();
		digiVaultCommonPage.checkPositiveButton();
		digiVaultCommonPage.enterName(fileName);
		digiVaultCommonPage.tapPositiveButton();
		choosefolderPage.checkPickFolderButton();
		choosefolderPage.tapPickFolderButton();
	}
	
	public void finishSavingImage() {
		tapNextButton();
		digiVaultCommonPage.checkPositiveButton(); 
		digiVaultCommonPage.tapPositiveButton();
	}
	
	public void finishSavingImage(String fileName) {
		tapNextButton();
		digiVaultCommonPage.checkPositiveButton();
		digiVaultCommonPage.enterName(fileName);
		digiVaultCommonPage.tapPositiveButton();
	}
	
}
