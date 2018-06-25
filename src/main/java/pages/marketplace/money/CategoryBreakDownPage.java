package pages.marketplace.money;

import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class CategoryBreakDownPage extends BasePage {

	public CategoryBreakDownPage(AppiumDriver driver) {
		super(driver);
	}

	 public WebElement checkBreakdownPageTitle(String title) {
		 
		 return findByUIAutomator(title, "text");
	 }
	
	
	
}
