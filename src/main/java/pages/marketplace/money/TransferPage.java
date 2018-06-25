package pages.marketplace.money;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class TransferPage extends BasePage {

	private By fromAccountButton = By.id("au.com.suncorp.marketplace:id/fromAccountButton");
	private By toAccountButton = By.id("au.com.suncorp.marketplace:id/toAccountButton");
	private By amountField = By.id("au.com.suncorp.marketplace:id/transferAmountField");
	private By nextButton = By.id("au.com.suncorp.marketplace:id/transferSummaryButton");
	private By availableBalance = By.id("au.com.suncorp.marketplace:id/availableBalanceText");
	private By descriptionField = By.id("au.com.suncorp.marketplace:id/transferDescriptionField");
	private By accountName = By.id("au.com.suncorp.marketplace:id/accountNameText");
	private By accountBSB = By.id("au.com.suncorp.marketplace:id/accountBsbText");
	private By accountNumber = By.id("au.com.suncorp.marketplace:id/accountNumberText");
	private By amountInlineError =By.id("au.com.suncorp.marketplace:id/textinput_error");

	public TransferPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement checkTransferPageTtile(String title) {

		return findByUIAutomator(title, "text");
	}

	public WebElement selectFromAccount() {

		return find(fromAccountButton);
	}

	public WebElement selectToAccount() {

		return find(toAccountButton);
	}

	public void tapSelectFromAccount() {

		tapElement(fromAccountButton);
	}

	public void tapSelectToAccount() {

		tapElement(toAccountButton);
	}

	public void enterAmount(String amount) {

		typeValue(amount, amountField);

	}
	
	public void enterDescriptionField(String text) {

		typeValue(text, descriptionField);

	}
	
	public String getDescriptionText() {

		return getText(descriptionField);

	}

	public void tapNextButton() {

		tapElement(nextButton);
	}

	public List<WebElement> getAvailableBalanceList() {

		return finds(availableBalance);

	}

	public String getFromAvailableBalance() {

		return getText(getAvailableBalanceList().get(0));

	}

	public String getToAvailableBalance() {

		return getText(getAvailableBalanceList().get(1));

	}

	public boolean isDescriptionFieldEnabled() {

		return isEnabled(descriptionField);

	}

	public boolean isAmountFieldEnabled() {

		return isEnabled(amountField);

	}

	public boolean isNextButtonEnabled() {

		return isEnabled(nextButton);

	}
	public boolean isToAccountButtonEnabled() {

		return isEnabled(toAccountButton);

	}
	

	public List<WebElement> getAccountNameList() {

		return finds(accountName);

	}

	public String getFromAccountName() {

		return getText(getAccountNameList().get(0));

	}

	public String getToAccountName() {

		return getText(getAccountNameList().get(1));

	}

	public List<WebElement> getAccountBSBList() {

		return finds(accountBSB);

	}

	public String getFromAccountBSB() {

		return getText(getAccountBSBList().get(0));

	}

	public String getToAccountBSB() {

		return getText(getAccountBSBList().get(1));

	}

	public List<WebElement> getAccountNumberList() {

		return finds(accountNumber);

	}

	public String getFromAccountNumber() {

		return getText(getAccountNumberList().get(0));

	}

	public String getToAccountNumber() {

		return getText(getAccountNumberList().get(1));

	}
	
	public String getAmountInlineError() {

		return getText(amountInlineError);

	}
	
	public void clearAmountField() {

		clearValue(amountField);

	}
	public String getAmountFieldValue() {

		return getText(amountField);

	}
	
	public boolean  isAmountFieldEmpty() {

		return getText(amountField).equals("");
			
	}
	public void  tapDescriptionField() {

		tapElement(descriptionField);
			
	}
	
	
}
