package pages.marketplace.money;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class AddNewPayeePage extends BasePage{


	public AddNewPayeePage(AppiumDriver driver) {
		super(driver);
		
	}
	
	private By addPayeeButton = By.id("au.com.suncorp.marketplace:id/addPayeeButton");
	private By accountNameInput = By.id("au.com.suncorp.marketplace:id/accountNameInputLayout");
	private By bsbInput = By.id("au.com.suncorp.marketplace:id/bsbInputLayout") ;
	private By accountNumberInput = By.id("au.com.suncorp.marketplace:id/accountNumberInputLayout");
	private By saveToAddressSwitch = By.id("au.com.suncorp.marketplace:id/saveToAddressSwitch");
	private By bsbField = By.id("au.com.suncorp.marketplace:id/bsbField");
	private By accountNameField = By.id("au.com.suncorp.marketplace:id/accountNameField");
	private By accountNumberField = By.id("au.com.suncorp.marketplace:id/accountNumberField");
	private By textinputError =By.id("au.com.suncorp.marketplace:id/textinput_error");

	public WebElement checkAddNewPayeeTitle(String title) {
		return findByUIAutomator(title, "text");
	}

	public WebElement checkAddPayeeButton() {
		
		return find(addPayeeButton);
	}

	public String getAddPayeeButton() {
		return getText(addPayeeButton);
	}

	public WebElement checkAccountNameInput() {
		return find(accountNameInput);
	}
	
	public String getAccountNameInput() {
		return getText(accountNameInput);
	}

	public WebElement checkBsbInput() {
		return find(bsbInput);
	}

	public String getBsbInput() {
		return getText(bsbInput);
	}

	public WebElement checkAccountNumberInput() {
		return find(accountNumberInput);
	}

	public String getAccountNumberInput() {
		return getText(accountNumberInput);
	}

	public WebElement checkSaveToAddressSwitch() {
		return find(saveToAddressSwitch );
	}

	public String getSaveToAddressSwitch() {
		return getText(saveToAddressSwitch);
	}

	public boolean  isSaveSwitchStatusON() {
		return isEnabled(saveToAddressSwitch);
	}

	public boolean isSwitchClickable() {
		return isClickable(saveToAddressSwitch);
	}

	public void tapAccountName() {
		tapElement(accountNameInput);
		
	}

	public String getAccountFiledValue() {
		// TODO Auto-generated method stub
		return getText(accountNameField );
	}

	public void tapBsbField() {
		tapElement(bsbField);
		
	}

	public void tapAccontNumberField() {
		tapElement(accountNumberField );
		
	}

	public String getBsbFiledValue() {
		
		return getText(bsbField);
	}
	
	public String getAccontNumberFieldValue() {
		return getText(accountNumberField);
		
	}

	public String getTextinputError() {
		// TODO Auto-generated method stub
		return getText(textinputError );
	}
	
	

}
