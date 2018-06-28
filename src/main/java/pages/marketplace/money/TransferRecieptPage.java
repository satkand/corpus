package pages.marketplace.money;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class TransferRecieptPage extends BasePage {

	private By receiptMessage = By.id("au.com.suncorp.marketplace:id/receiptTitleText");
	private By receiptNumber = By.id("au.com.suncorp.marketplace:id/receiptNumberText");
	private By fromAccountName = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/fromAccountLabel\").fromParent(new UiSelector().className(\"android.widget.LinearLayout\")).childSelector(new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/payeePrimaryNameText\"))");
	private By fromAccountNumberAndBSB = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/fromAccountLabel\").fromParent(new UiSelector().className(\"android.widget.LinearLayout\")).childSelector(new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/payeeIdentifierText\"))");
	private By toAccountName = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/toAccountLabel\").fromParent(new UiSelector().className(\"android.widget.LinearLayout\")).childSelector(new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/payeePrimaryNameText\"))");
	private By toAccountNumberAndBSB = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/toAccountLabel\").fromParent(new UiSelector().className(\"android.widget.LinearLayout\")).childSelector(new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/payeeIdentifierText\"))");
	private By amount = By.id("au.com.suncorp.marketplace:id/amountValue");
	private By whenDate = By.id("au.com.suncorp.marketplace:id/whenValue");
	private By makeAnotherPaymentButton = By.id("au.com.suncorp.marketplace:id/makeAnotherTransferButton");
	private By backToAccountsButton = By.id("au.com.suncorp.marketplace:id/backToAccountsButton");
	
	

	public TransferRecieptPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement checkReceiptMessage() {

		return find(receiptMessage,20);
	}

	public String getReceiptMessage() {

		return getText(checkReceiptMessage());
	}

	public String getReceiptNumber() {

		return getText(receiptNumber);
	}

	public String getFromAccountName() {

		return getText(fromAccountName);
	}

	public String getfromAccountNumberAndBSB() {

		return getText(fromAccountNumberAndBSB);
	}

	public String getToAccountName() {

		return getText(toAccountName);
	}

	public String getToAccountNumberAndBSB() {

		return getText(toAccountNumberAndBSB);
	}
	public String getWhenDate() {

		return getText(whenDate);
	}
	
	public String getAmount() {

		return getText(amount);
	}
	
	public void tapMakeAnotherPaymentButton() {
		
		tapElement(makeAnotherPaymentButton);
	}

    public void tapBackToAccountsButton() {
		
		tapElement(backToAccountsButton);
	}
	
}
