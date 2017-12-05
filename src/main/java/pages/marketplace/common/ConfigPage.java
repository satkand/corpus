package pages.marketplace.common;

import org.openqa.selenium.By;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class ConfigPage extends BasePage {

	private By configPageTitle = By.xpath("//android.widget.TextView[@text='Config']");
	private By continueButton = By.id("au.com.suncorp.marketplace:id/configContinueButton");
	
	public ConfigPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void dismissConfigPage() {
		if(find(configPageTitle) != null) {
			dismissKeyboard();
			if(find(continueButton, 30) != null) {
				tapElement(continueButton);
			}
		}
	}

}
