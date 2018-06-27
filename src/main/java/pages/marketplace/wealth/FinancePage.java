package pages.marketplace.wealth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class FinancePage extends BasePage {

	public FinancePage(AppiumDriver driver) {
		super(driver);
	}

	private By netWorthLabel = By.id("au.com.suncorp.marketplace:id/netWorthTitle");
	private By netWorthAmount = By.id("au.com.suncorp.marketplace:id/netWorthAmount");
	
	private By viewSpendingThisMonthButton = By.id("au.com.suncorp.marketplace:id/spendingInsightsLastMonthCardLayout");	
//	private By viewSpendingThisMonthButton = By.id("au.com.suncorp.marketplace:id/spendingInsightsViewAllButton");
	private By netWorthDisclaimerMessage = By.id("au.com.suncorp.marketplace:id/netWorthDisclaimer");
	private By moneyDimensionHeader = By.id("au.com.suncorp.marketplace:id/moneyDimensionHeader");
	private By moneyCardTitle = By.id("au.com.suncorp.marketplace:id/moneyCardTitle");
	private By accountIconImage = By.id("au.com.suncorp.marketplace:id/accountIconImage");

	private By transferPillButton = By.id("au.com.suncorp.marketplace:id/transferPillButton");
	private By transferPillBtnIcon = By.xpath("//android.widget.LinearLayout[@resource-id='au.com.suncorp.marketplace:id/transferPillButton']//android.widget.ImageView");
	private By transferFabTitle = By.id("au.com.suncorp.marketplace:id/transferFabTitle");
	private By startTransferSheetHeading = By.id("au.com.suncorp.marketplace:id/startTransferSheetHeading");
	private By transferToOthersButton = By.id("au.com.suncorp.marketplace:id/transferToOthersButton");
	
	public WebElement checkMoneyDimensionHeader() {
		return find(moneyDimensionHeader);
	}
	
	public String getNetWorthLabel() {
		return getText(netWorthLabel);
	}
	
	public WebElement checkNetWorthAmount() {
		scrollToElement(netWorthAmount);
		return find(netWorthAmount);
	}
	
	public String getNetWorthAmountValue() {
		return getText(netWorthAmount);
	}
	
	public WebElement checkViewSpendingThisMonthButton() {
		return find(viewSpendingThisMonthButton);
	}
	
	public void tapviewSpendingThisMonthButton() {
		tapElement(viewSpendingThisMonthButton);
	}
	
	public String getNetWorthDisclaimerMessage() {
		return getText(netWorthDisclaimerMessage);
	}

	public String getMoneyDimensionHeader() {
		return getText(moneyDimensionHeader);
	}

	public WebElement checkMoneyCardTitle() {
		// TODO Auto-generated method stub
		return find(moneyCardTitle );
	}

	public WebElement checkAccountIconImage() {
		return find(accountIconImage );
	}

	public void scrollTOAndTapOnAccount(String accountNumber) {
		tapElement(scrollToElement(accountNumber, "text"));
	}
	
	public WebElement checkTransferPillButton() {
		return find(transferPillButton);
	}

	public WebElement checkPillBtnIcon() {
		return find(transferPillBtnIcon);
	}

	public WebElement checkTransferFabTitle() {
		return find(transferFabTitle);
	}

	public String getTransferFabTitle() {
		return getText(transferFabTitle);
	}

	public WebElement checkStartTransferSheetHeading() {
		return find(startTransferSheetHeading);
	}

	public void tapTransferToOthersButton() {
		tapElement(transferToOthersButton );
		
	}
	
	public void tapTransferPillBtn() {
		tapElement(transferPillButton);
	}

}
