package pages.marketplace.digitalVault;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class ImagePreviewPage extends BasePage {

	private By renameDialogTitle = By.id("au.com.suncorp.marketplace:id/dialogTitle");
	private By renameEditField = By.id("au.com.suncorp.marketplace:id/dialogEditText");
	private By positiveButton = By.id("au.com.suncorp.marketplace:id/positiveButton");
	private By cancelButton = By.id("au.com.suncorp.marketplace:id/cancelButton");

	private By nextButton = By.id("au.com.suncorp.marketplace:id/nextDocumentOption");
	
	public ImagePreviewPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
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
	
	public WebElement checkEditField() {
		return find(renameEditField);
	}
	
	public void clearEditField() {
		clearValue(renameEditField);
	}
	
	public void tapEditField() {
		tapElement(renameEditField);
	}
	
	public void tapNextButton() {
		tapElement(nextButton);
	}
	
}
