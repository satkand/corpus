package pages.marketplace.portfolio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class AccountDetailsPage   extends BasePage{

	public AccountDetailsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By accountDetailsTitle = By.xpath("//android.widget.TextView[@text='Transactions']");
	private By backButton = MobileBy.AccessibilityId("Navigate up");

		
		public WebElement checkAccountDetailsTitle(){
			return find(accountDetailsTitle);
		}
		
		public void tapBackButton(){
			find(backButton,30);
			tapElement(backButton);
		}

}
