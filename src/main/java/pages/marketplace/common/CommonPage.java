package pages.marketplace.common;

import org.openqa.selenium.By;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class CommonPage extends BasePage {

	public CommonPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//TODO this is a common method, need to moved to common methods class
	public void dismissKeyboardShown() {
		 dismissKeyboard();
	}
	
	//TODO this is a common method, need to moved to common methods class
	public boolean isKeyboardShown() {
		 return isKeyboardPresent();
	}
	
	//TODO this is a common method, need to moved to common methods class
	public void moveAppToBackground() {
		 putAppInBackground();
	}
	
	/* TODO
	public void scrollDown() {
		swipeScreen("Down");
	}
	*/
	
	public void swipeLeft() {
		swipeHorizontallyToLeft();
	}
}
