package pages.marketplace.portfolio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import automation.framework.common.Copy;
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
	//Add Bank Account screen
	private By accountNumberField = By.id("au.com.suncorp.marketplace:id/accountNumberField");
	private By accountNumberError = By.id("au.com.suncorp.marketplace:id/textinput_error");
	private By addAccountButton = By.id("au.com.suncorp.marketplace:id/addAccountButton");
	private By addSuperAccButton = By.id("au.com.suncorp.marketplace:id/addSuperButton");
	private By superAccountNumberField = By.id("au.com.suncorp.marketplace:id/superNumberField");
	
	
public WebElement checkAddBankAccountTitle() {
		
		return findByUIAutomator(Copy.ADD_BANK_ACCOUNT_TITLE, "text");
		
	}
	
	public void tapAccountNumberField(){
		tapElement(accountNumberField);
	}
	
	public void tapSuperAccountNumberField(){
		tapElement(superAccountNumberField);
	}
	
	public void enterAccountNumber(String accountNumber) {
		typeValue(accountNumber,accountNumberField);
	}
	
	public void enterSuperAccountNumber(String accountNumber) {
		typeValue(accountNumber,superAccountNumberField);
	}
	
	public String getAccountNumberError() {
		return getText(accountNumberError).replace("\n", " ");
	}
	
	public WebElement checkAccountNumberError(){
		return find(accountNumberError);
	}
	
	public void tapAddAccount() {
		tapElement(addAccountButton);
	}
	
	public void tapAddSuperAccount() {
		tapElement(addSuperAccButton);
	}
	
	public void clearAccountNumber() {
		clearValue(accountNumberField);
	}
	
	public void clearSuperAccountNumber() {
		clearValue(superAccountNumberField);
	}
	
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
