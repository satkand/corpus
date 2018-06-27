package pages.marketplace.money;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import pages.marketplace.common.Keyboard;

public class TransferToSomeonePage extends BasePage{
	
	private final String actionBarTextXpath = "//au.com.suncorp.marketplace[@resource-id = 'au.com.suncorp.marketplace:id/action_bar']"
			+ "//android.widget.TextView";
	private By actionBarContainer = By.xpath(actionBarTextXpath);
	
	private final String formTitleXpath = "//au.com.suncorp.marketplace[@resource-id = 'au.com.suncorp.marketplace:id/transferDetailsRoot']"
			+ "//android.widget.TextView";
	private By fromAccountPickerLabel = By.id("au.com.suncorp.marketplace:id/fromAccountPickerLabel");
	
	private By fromAccountButton = By.id("au.com.suncorp.marketplace:id/fromAccountButton");
	private final String fromAccountButtonIconXpath = "//android.widget.FrameLayout[@resource-id='au.com.suncorp.marketplace:id/fromAccountButton']"
			+ "//android.widget.ImageView";
	private By fromAccountButtonIcon = By.xpath(fromAccountButtonIconXpath);
	private final String fromAccountButtonTextXpath = "//android.widget.FrameLayout[@resource-id='au.com.suncorp.marketplace:id/fromAccountButton']"
			+ "//android.widget.TextView";
	private By fromAccountButtonText = By.xpath(fromAccountButtonTextXpath);
	private By toAccountPickerLabel = By.id("au.com.suncorp.marketplace:id/toAccountPickerLabel");
	
	private By toAccountButton = By.id("au.com.suncorp.marketplace:id/toAccountButton");
	private final String toAccountButtonIconXpath = "//android.widget.FrameLayout[@resource-id = 'au.com.suncorp.marketplace:id/toAccountButton']"
			+ "//android.widget.ImageView";
	private By toAccountButtonIcon = By.xpath(toAccountButtonIconXpath);
	private final String toAccountButtonTextXpath = "//android.widget.FrameLayout[@resource-id = 'au.com.suncorp.marketplace:id/toAccountButton']"
			+ "//android.widget.TextView";
	private By toAccountButtonText = By.xpath(toAccountButtonTextXpath);
	private By transferAmountField = By.id("au.com.suncorp.marketplace:id/transferAmountField");
	private By transferAmountInputDefaultText = By.id("au.com.suncorp.marketplace:id/transferAmountInputLayout");
	private By transferDescriptionField = By.id("au.com.suncorp.marketplace:id/transferDescriptionField");
	private By transferDescriptionDefaultText = By.id("au.com.suncorp.marketplace:id/transferDescriptionInputLayout");
	private By transferSummaryButton = By.id("au.com.suncorp.marketplace:id/transferSummaryButton");
	private By availableBalanceText = By.id("au.com.suncorp.marketplace:id/availableBalanceText");
	private By accountBsbText = By.id("au.com.suncorp.marketplace:id/accountBsbText");
	private By accountNumberText = By.id("au.com.suncorp.marketplace:id/accountNumberText");
	private By accountNameText = By.id("au.com.suncorp.marketplace:id/accountNameText");
	private By accountIconImage = By.id("au.com.suncorp.marketplace:id/accountIconImage");
	private String payeePrimaryNameText;
	private By textinputError= By.id("au.com.suncorp.marketplace:id/textinput_error");
	

	public TransferToSomeonePage(AppiumDriver driver) {
		super(driver);
	}

	public WebElement checkTransferToOtherTitle() {
		return find(actionBarContainer);
	}

	public String getTransferToOtherTitle() {
		return getText(actionBarContainer);
	}

	public WebElement checkFromAccountTitle() {
		return find(fromAccountPickerLabel);
	}

	public String getFromAccountTitle() {
		return getText(fromAccountPickerLabel);
	}

	public WebElement checkFromAccountButton() {
		return find(fromAccountButton);
	}

	public WebElement checkFromAccountButtonIcon() {
		return find(fromAccountButtonIcon);
	}

	public String getFromAccountBtnText() {
		return getText(fromAccountButtonText);
	}
	
	public boolean isFromAccountBtnEnabled() {
		return isEnabled(fromAccountButton);
	}

	public String getToAccountTitle() {
		return getText(toAccountPickerLabel);
	}
	
	public WebElement checkToAccountTitle() {
		return find(toAccountPickerLabel);
	}

	public WebElement checkToAccountButton() {
		return find(toAccountButton);
	}

	public WebElement checkToAccountButtonIcon() {
		return find(toAccountButtonIcon);
	}

	public String getToAccountBtnText() {
		return getText(toAccountButtonText);
	}

	public boolean isToAccountBtnEnabled() {
		return isEnabled(toAccountButton);
	}

	public WebElement checkTransferAmountField() {
		return find(transferAmountField);
	}

	public String getTransferAmountInputLayoutDefaultText() {
		return getText(transferAmountInputDefaultText);
	}

	public boolean isTransferAmountFieldEnabled() {
		return isEnabled(transferAmountField);
	}

	public WebElement checkTransferDescription() {
		return find(transferDescriptionField);
	}

	public String getTransferDescriptionDefaultText() {
		return getText(transferDescriptionDefaultText );
	}

	public boolean isTransferDescriptionFieldEnabled() {
		return isEnabled(transferDescriptionField);
	}

	public WebElement checkTransferSummaryButton() {
		return find(transferSummaryButton );
	}

	public String getTransferSummaryButtonText() {
		return getText(transferSummaryButton);
	}

	public boolean isTransferSummaryButtonEnabled() {
		return isEnabled(transferSummaryButton);
	}

	public void tapFromAccountBtn() {
		tapElement(fromAccountButton);	
	}

	public WebElement CheckAccountNameText() {
		return find(accountNameText);
	}

	public String getAccountNameText() {
		return getText(accountNameText);
	}

	public String getAvailableBalance() {
		return getText(availableBalanceText );
	}

	public WebElement checkAvailableBalance() {
		return find(availableBalanceText);
	}

	public String getAccountNumber() {
		return getText(accountNumberText);
	}

	public WebElement CheckAccountNumber() {
		return find(accountNumberText );
	}

	public WebElement CheckAccountBsb() {
		return find(accountBsbText);
	}

	public String getAccountBsbText() {
		return getText(accountBsbText);
	}

	public void scrollToAccount(String accountNumber) {
		scrollToElement(accountNumber, "text");
	}
	
	public void scrollToFromAccount(String text) {
		scrollToElement(text, "text",30);
	}
	public void selectFromAccount(String accountNumber) {
		 tapElement(scrollToElement(accountNumber, "text"));
		
	}

	public WebElement CheckAccountIconImage() {
		return find(accountIconImage );
	}

	public void tapToAccountBtn() {
		tapElement(find(toAccountButton,20));
		
	}

	public void selectToAccount(String toAccountName) {
		tapElement(scrollToElement(toAccountName,"text"));
		
	}

	public boolean  isKeyboardShown() {
		return isKeyboardDisplayed();
		
	}

	public String getTextinputError() {
		return getText(textinputError);
		
	}
	public String getTransferAmountField() {
		return getText(transferAmountField);
		
	}

	public void enterEqualToMaximumAmount() {
		// TODO Auto-generated method stub
		
	}

	public void tapDescription() {
		tapElement(transferDescriptionField);
		
	}

	public void selectAmountField() {
		tapElement(transferAmountField);
		clearValue(transferAmountField);
		
	}

	public String getAmountFieldInputError() {
		return getText(textinputError);
	}

	public void tapNext() {
		tapElement(transferSummaryButton);
		
	}

	public void enterDescription() {
		tapElement(transferDescriptionField);
		clearValue(transferDescriptionField);
	}
	
	public void tapAmount() {
		tapElement(transferAmountField);
	}

	public String getTransferDescriptionText() {
		
		return getText(transferDescriptionField);
	}

	public void dissmissKeyBoard() {
		dismissKeyboard();
		
	}

}
