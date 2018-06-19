package pages.marketplace.common;

import org.openqa.selenium.By;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidKeyCode;

public class CameraPage extends BasePage{

	private By capturePhotoButton = By.id("com.google.android.GoogleCamera:id/shutter_button");
	private By usePhotoButtonGoogle = MobileBy.AccessibilityId("Done");
	private By usePhotoButtonSamsung = By.id("com.sec.android.app.camera:id/okay");
	
	
	public CameraPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void capturePhoto() {

		pressDeviceButton(AndroidKeyCode.KEYCODE_VOLUME_UP);
		
		if(getDeviceAttribute("deviceManufacturer").equals("samsung")) {
			find(usePhotoButtonSamsung, 60);
			tapElement(usePhotoButtonSamsung);
			
		}else if(getDeviceAttribute("deviceManufacturer").equals("Google")||getDeviceAttribute("deviceManufacturer").equals("LGE")) {
			find(usePhotoButtonGoogle, 60);
			tapElement(usePhotoButtonGoogle);
		}
		
		
	}
	
}
