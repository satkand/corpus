package pages.marketplace.banking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class BankingHomePage extends BasePage{

	public BankingHomePage(AppiumDriver driver) {
		super(driver);
	}
	
	private By bankingHomeTitle = By.xpath("//android.widget.TextView[@text='Banking Home']");
	
	private By paySomeoneButton = By.id("au.com.suncorp.marketplace:id/paySomeoneButton");
	private By transferButton = By.id("au.com.suncorp.marketplace:id/transferBetweenAccountsButton");
	private By bpayButton = By.id("au.com.suncorp.marketplace:id/payABillButton");
	
	private By homeLoanAccounts = By.xpath("//android.widget.TextView[@text='My Home Loan']");
	private By lineOfCreditAccount = By.xpath("//android.widget.TextView[@text='My Line Of Credit Account']");
	private By variableFixedRateAccount = By.xpath("//android.widget.TextView[@text='9005']");
	
	
	public WebElement checkBankingHomeTitle() {
		return find(bankingHomeTitle, 30);
	}
	
	public WebElement checkPaysomeoneButton() {
		return find(paySomeoneButton, 30);
	}

	public WebElement checkTransferButton() {
		return find(transferButton, 30);
	}

	public WebElement checkBpayButton(){
		return find(bpayButton, 30);
	}

	public WebElement checkHomeLoanAccounts() {	
		scrollToElement(homeLoanAccounts);
		return find(homeLoanAccounts, 30);
	}
	
	public void tapMyHomeLoan () {
		tapElement(homeLoanAccounts);
	}
	
	public void tapMyLineOfCreditAccount() {
		scrollToElement(lineOfCreditAccount);
		tapElement(lineOfCreditAccount);
	}
	
	public void tapVariableFixedRateAccount() {
		scrollToElement(variableFixedRateAccount);
		tapElement(variableFixedRateAccount);
	}

}
