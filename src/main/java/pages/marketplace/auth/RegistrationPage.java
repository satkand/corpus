package pages.marketplace.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class RegistrationPage extends BasePage {
	
	public RegistrationPage(AppiumDriver driver) {
		super(driver);
	}
	
	//TODO -> id needs to be added
	private By registrationPageTitle = By.xpath("//android.widget.TextView[@text='Register for the app']");
	private By cancelButton = By.id("au.com.suncorp.marketplace:id/cancelButton");
	private By firstName = By.id("au.com.suncorp.marketplace:id/firstNameField");
	
	public WebElement checkRegistrationPageTitle(){
		return find(registrationPageTitle,20);
	}
	
	public void tapCancelButton(){
		tapElement(cancelButton);
	}
	
	public WebElement checkFirstName() {
		return find(firstName, 30);
	}

	public WebElement checkCancelButton() {
		return find(cancelButton, 30);
	}


	
}
