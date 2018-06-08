package pages.marketplace.wealth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class ConnectedAccountsPage extends BasePage{

	private By title = By.xpath("//android.widget.TextView[@text='Connected accounts']");
	private By closeButton = MobileBy.AccessibilityId("Navigate up");
	
	
	public ConnectedAccountsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public WebElement checkTitle() {
		return find(title);
	}
	
	public void tapCloseButton() {
		tapElement(closeButton);
	}
}
