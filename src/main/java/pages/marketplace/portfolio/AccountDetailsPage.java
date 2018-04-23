package pages.marketplace.portfolio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class AccountDetailsPage   extends BasePage{

	public AccountDetailsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By accountDetailsTitle = By.xpath("//android.widget.TextView[@text='Account details']");
	private By backButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");

		
		public WebElement checkAccountDetailsTitle(){
			return find(accountDetailsTitle);
		}
		
		public void tapBackButton(){
			find(backButton,30);
			tapElement(backButton);
		}

}
