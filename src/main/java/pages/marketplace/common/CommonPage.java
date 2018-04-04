package pages.marketplace.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class CommonPage extends BasePage {

	private By loadingSpinner = MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.ProgressBar\")");
	private By backNavigationButton = MobileBy.AccessibilityId("Back");
	
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
	
	
	public void tapBackNavigateButton() {

		tapElement(backNavigationButton);
	}


	/* TODO
	public void scrollDown() {
		swipeScreen("Down");
	}
	*/
	
	public void swipeLeft() {
		swipeHorizontallyToLeft();
	}
	
	public WebElement checkLoadingSpinner() {
		return find(loadingSpinner);
	}
	
	public void waitForLoadingSpinnerToDisappear() {
		
		waitForElementToDisappear(loadingSpinner);
		
	}
	
}
