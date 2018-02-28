package pages.marketplace.digitalVault;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class ChooseFolderPage extends BasePage{

	private By saveButton = By.id("au.com.suncorp.marketplace:id/pickFolderOption");
	
	public ChooseFolderPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public WebElement checkSaveButton() {
		return find(saveButton);
	}
	
	public void tapSaveButton() {
		tapElement(saveButton);
	}
}
