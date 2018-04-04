package pages.marketplace.common;

import org.openqa.selenium.By;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class CommonPage extends BasePage {
	
	private By backNavigationButton = MobileBy.AccessibilityId("Navigate up");
	
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
	
	public void goBack() {
		navigateBack();
	}
	public void tapBackButton() {
		find(backNavigationButton);
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
