package pages.marketplace.common;

import org.openqa.selenium.By;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class CameraPage extends BasePage{

	private By capturePhotoButton = By.id("com.google.android.GoogleCamera:id/shutter_button");
	private By usePhotoButton = MobileBy.AccessibilityId("Done");
	
	public CameraPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void capturePhoto() {
		find(capturePhotoButton, 30);
		tapElement(capturePhotoButton);
		find(usePhotoButton, 60);
		tapElement(usePhotoButton);
		
	}
	
}
