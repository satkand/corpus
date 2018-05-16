package pages.marketplace.portfolio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class AddBankAccountPage  extends BasePage  {

	public AddBankAccountPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private By addBankAccountPageTitle = By.xpath("//android.widget.TextView[@text='Enter account number']");
	private By addSuperAccountPageTitle = By.xpath("//android.widget.TextView[@text='Add superannuation']");
	private By addBankAccountPlaceHolderText = By.id("au.com.suncorp.marketplace:id/accountNumberField");
	private By addBankAccountButton = By.id("au.com.suncorp.marketplace:id/addAccountButton");
	private By addBankAccountForgotDetailaButton = By.id("au.com.suncorp.marketplace:id/addAccountHintText"); 
	
	public WebElement checkAddBankAccountPageTitle(){
		return find(addBankAccountPageTitle);
	}
	public WebElement checkAddBankAccountPlaceHolderText(){
		return find(addBankAccountPlaceHolderText);
	}
	public WebElement checkAddBankAccountButton(){
		return find(addBankAccountButton);
	}
	public WebElement checkAddBankAccountForgotDetailaButton(){
		return find(addBankAccountForgotDetailaButton);
	}
	public WebElement checkAddSuperAccountPageTitle() {
		return find(addSuperAccountPageTitle);
	}
}
