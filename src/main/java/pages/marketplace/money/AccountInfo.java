package pages.marketplace.money;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class AccountInfo extends BasePage {

	@SuppressWarnings("rawtypes")
	public AccountInfo( AppiumDriver driver){
		super(driver);
		}
	private By accountInfoPage=By.xpath("//android.widget.TextView[@text='Account Info']");
    private By backButton = MobileBy.AccessibilityId("Navigate up");

	public WebElement checkAccountInfoPage() {
		return find(accountInfoPage,40);
	}
	public void scrollDown() {
		swipeScreen("DOWN");
	}

	public void tapBackButton() {
		tapElement(backButton);
	}
	
 
}
