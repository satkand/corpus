package pages.marketplace.claimdetails;

import org.openqa.selenium.By;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class NextActionWebViewPage extends BasePage {

	public NextActionWebViewPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By closeButton = MobileBy.AccessibilityId("Navigate up");
	
	public void closeButton() {

		tapElement(closeButton);
	
	}

}
