package pages.marketplace.money;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class TransferSummaryPage extends BasePage {

	private By fromAccountName = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/fromAccountContainer\").childSelector(new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/accountNameText\"))");
	private By fromAccountAndBsbNumber = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/fromAccountContainer\").childSelector(new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/accountBsbNumberText\"))");
	private By fromAccountBalance = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/fromAccountContainer\").childSelector(new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/accountBalanceText\"))");
	private By toAccountName = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/toAccountContainer\").childSelector(new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/accountNameText\"))");
	private By toAccountAndBsbNumber = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/toAccountContainer\").childSelector(new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/accountBsbNumberText\"))");
	private By toAccountBalance = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/toAccountContainer\").childSelector(new UiSelector().resourceId(\"au.com.suncorp.marketplace:id/accountBalanceText\"))");
	private By transferAmount = By.id("au.com.suncorp.marketplace:id/amountValue");
	private By disclaimerLabel = By.id("au.com.suncorp.marketplace:id/transferDisclaimerLabel");
	private By transferNowButton = By.id("au.com.suncorp.marketplace:id/transferNowButton");
	private By whenValue = By.id("au.com.suncorp.marketplace:id/whenValue");
	private By processingMessage = By.id("au.com.suncorp.marketplace:id/dialogMessage");


	public TransferSummaryPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement checkTransferSummaryTtile(String title) {

		return findByUIAutomator(title, "text");
	}

	public String getFromAccountName() {

		return getText(fromAccountName);
	}

	public String getFromAccountBSB() {

		return getText(fromAccountAndBsbNumber).split(" ")[0];

	}
	public String getFromAccountAndBsbNumber() {

		return getText(fromAccountAndBsbNumber);

	}

	public String getFromAccountNumber() {

		return getText(fromAccountAndBsbNumber).split(" ")[1];

	}

	public String getFromAccountBalance() {

		return getText(fromAccountBalance).split(" ")[0].trim();
	}

	public String getToAccountName() {

		return getText(toAccountName);
	}

	public String getToAccountBSB() {

		return getText(toAccountAndBsbNumber).split(" ")[0];

	}

	public String getToAccountNumber() {

		return getText(toAccountAndBsbNumber).split(" ")[1];

	}

	public String getToAccountBalance() {

		return getText(toAccountBalance).split(" ")[0].trim();
	}

	public String getTransferAmount() {

		return getText(transferAmount);
	}

	public WebElement checkDisclaimerLabel() {

		return find(disclaimerLabel);
	}

	public WebElement checkTransferNowButton() {

		return find(transferNowButton);
	}
	
	public void  tapTransferNowButton() {

		tapElement(transferNowButton);
	}

	public String getProcessingMessage() {

		return getText(processingMessage);
	}
	public String getWhenValue() {

		return getText(whenValue);
	}
	
	public String getDisclaimerLabel() {

		return getText(disclaimerLabel);
	}
	
}
