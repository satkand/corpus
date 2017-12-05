package pages.marketplace.common;

import org.openqa.selenium.By;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class NavigationDrawPage extends BasePage {

	private By splitMenuIcon = MobileBy.AccessibilityId("Open navigation menu");
	private By lockMenuOption = By.xpath("//android.widget.CheckedTextView[@text='Lock']");

	public NavigationDrawPage(AppiumDriver driver) {
		super(driver);
	}
	
	public void tapSplitMenuIcon() {
		 find(splitMenuIcon,30);
		 tapElement(splitMenuIcon);
	}
	
	public void tapLockMenuOption() {
		 tapElement(lockMenuOption);
	}

}
