package pages.marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class GuestAccessPage extends BasePage {
	
	public GuestAccessPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//TODO -> id needs to be added
	private By guestAccessPageTitle = By.id("TODO");
	private By backButton = By.id("TODO");
	
	public WebElement checkGuestAccessPageTitle() {
		return find(guestAccessPageTitle, 20);
	}
	
	public void tapBackButton(){
		tapElement(backButton);

	}
}
