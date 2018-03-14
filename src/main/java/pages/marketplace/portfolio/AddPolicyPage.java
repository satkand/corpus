package pages.marketplace.portfolio;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;


import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class AddPolicyPage extends BasePage {

	public AddPolicyPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private By addPolicyPageTitle = By.xpath("//android.widget.TextView[@text='Add policy']");
	private By backButton = By.xpath("//android.widget.ImageButton[@content-desc ='Navigate up']");
	private By policyNumberTextBox = By.id("au.com.suncorp.marketplace:id/policyNumberField");
	private By addAccountButton = By.id("au.com.suncorp.marketplace:id/addPolicyButton");
	private By forgotMyDetailsButton = By.id("au.com.suncorp.marketplace:id/forgottenDetailsTextButton");
	private By supportedbrandsTextLabel = By.id("au.com.suncorp.marketplace:id/supportedBrandsText");
	private By supportedbrandsImage = By.id("au.com.suncorp.marketplace:id/brandsGroupImage");
	private By successMessage = By.id("au.com.suncorp.marketplace:id/dialogMessage");
	private By successImage = By.xpath("//android.widget.ImageView");

	private By policyNumberinlineError = By.id("au.com.suncorp.marketplace:id/textinput_error");
	
	public WebElement checkPolicyNumberinlineError(){
		return find(policyNumberinlineError);
	}
	
	public String getPolicyNumberinlineError() {
		return getText(policyNumberinlineError);
	}
	
	public String getPolicyNumberTextBox() {
		find(policyNumberTextBox,30);
		return getText(policyNumberTextBox);
	}
	
	public void enterPolicyNumber(String policyNumber) {
		find(policyNumberTextBox,30);
		typeValue(policyNumber, policyNumberTextBox);
	}
	
	public void tapBackButton(){
		tapElement(backButton);
	}
	
	public WebElement checkSuccessMessage(){
		return find(successMessage);
	}
	
	public String getSuccessMessage() {
		return getText(successMessage);
	}
	
	public WebElement checkSuccessImage(){
		return find(successImage);
	}
	
	public WebElement checkAddPolicyPageTitle(){
		return find(addPolicyPageTitle);
	}
	public WebElement checkPolicyNumberTextBox(){
		return find(policyNumberTextBox);
	}
	
	public void tapPolicyNumberTextBox(){
		find(policyNumberTextBox);
		tapElement(policyNumberTextBox);
	}
	
	public WebElement checkAddAccountButton(){
		return find(addAccountButton);
	}
	
	public void tapAddAccountButton(){
		find(addAccountButton);
		tapElement(addAccountButton);
	}
	
	public WebElement checkForgotMyDetailsButton(){
		return find(forgotMyDetailsButton);
	}
	
	public WebElement checkSupportedbrandsTextLabel(){
		return find(supportedbrandsTextLabel);
	}
	
	public WebElement checkSupportedbrandsImage(){
		return find(supportedbrandsImage);
	}
	
	public void deletecharactersInPolicyNumber(int charsCount){
		deleteCharactersOnATextField(charsCount);
	}
	
	public void clearPolicyNumber(){
		clearValue(policyNumberTextBox);
	}
	
	
}
