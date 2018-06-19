package pages.marketplace.portfolio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class RenewPolicyPage extends BasePage{

	public RenewPolicyPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement checkRenewPolicyScreenTitle(String copy) {

		return findByUIAutomator(copy, "text");
	}

}
