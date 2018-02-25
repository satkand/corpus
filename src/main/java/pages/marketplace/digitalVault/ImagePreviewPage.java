package pages.marketplace.digitalVault;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class ImagePreviewPage extends BasePage {

	DigiVaultCommonPage digiVaultCommonPage = new DigiVaultCommonPage(driver);
	private By nextButton = By.id("au.com.suncorp.marketplace:id/nextDocumentOption");
	
	private ChooseFolderPage choosefolderPage = new ChooseFolderPage(driver);
	
	public ImagePreviewPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public void tapNextButton() {
		tapElement(nextButton);
	}
	
	public void finishSavingImageByChoosingFolder() {
		tapNextButton();
		digiVaultCommonPage.checkPositiveButton();
		digiVaultCommonPage.tapPositiveButton();
		choosefolderPage.checkSaveButton();
		choosefolderPage.tapSaveButton();
	}
	
	public void finishSavingImage() {
		tapNextButton();
		digiVaultCommonPage.checkPositiveButton();
		digiVaultCommonPage.tapPositiveButton();
	}
	
}
