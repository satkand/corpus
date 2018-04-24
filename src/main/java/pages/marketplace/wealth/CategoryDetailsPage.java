package pages.marketplace.wealth;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class CategoryDetailsPage extends BasePage {

	public CategoryDetailsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	private By spendingsTotalAmount = By.id("au.com.suncorp.marketplace:id/totalSpendingAmount");
	private By monthPicker = By.id("au.com.suncorp.marketplace:id/monthSelector");
	private By top3VendorsList = By.id("au.com.suncorp.marketplace:id/topVendorsContainer");
	private By top3VendorTitle = By.id("au.com.suncorp.marketplace:id/topVendorsTitle");
	private By transactionList = By.id("au.com.suncorp.marketplace:id/transactionList");
	private By updateMonthButton = By.id("au.com.suncorp.marketplace:id/changeMonth");
	private By monthsOptionInPicker = By.id("au.com.suncorp.marketplace:id/monthItem");
	private By loadingIndicator = By.id("loadingIndicator");
	private By closeButton =MobileBy.AccessibilityId("Navigate up");
	private By transactionErrorMsg = By.id("au.com.suncorp.marketplace:id/missingTransactionsHeading");
	private By vendorAmount = By.xpath("//android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/vendorAmount']");
	
	public WebElement checkMonthPicker() {
		return find(monthPicker);
	}
	
	public void tapMonthPicker() {
		tapElement(monthPicker);
	}
	
	public void selectMonth(String month) {
		System.out.println("month:::"+month);
		tapMonthPicker();
		selectElementFromDropdownBasedOnText(month);
		if(checkUpdateMonthButton() != null) {
			tapElement(updateMonthButton);
		}
		int index = 0;
		// After a month is selected, Loading indicator is shown before the data is getting refreshed on the page.
		// So waiting for the loading indicator to disappear before verifying for the data on the screen.
		while (find(loadingIndicator)!= null && index<=12) {
			index++;
		}
	}
	
	public WebElement checkUpdateMonthButton() {
		return find(updateMonthButton);
	}
	
	public WebElement checkSpendingsTotalAmount() {
		return find(spendingsTotalAmount);
	}
	
	public String getSpendingsTotalAmount() {
		return getText(spendingsTotalAmount);
	}
	
	public WebElement checkMonthsOptionInPicker() {
		return find(monthsOptionInPicker);
	}
	
	public WebElement checkTop3VendorsList() {
		return find(top3VendorsList);
	}
	
	public WebElement checkTop3VendorTitle() {
		return find(top3VendorTitle);
	}
	
	public void tapTop3VendorTitle() {
		tapElement(top3VendorTitle);
	}
	
	public WebElement checkTransactionList() {
		return find(transactionList);
	}
	
	public void scrollDown() {
		scrollToElement(transactionList);
	}
	
	public void scrollUp() {
		scrollUpToElement(monthPicker);
	}
	
	public void tapCloseButton() {
		tapElement(closeButton);
	}
	
	public WebElement checkTransactionErrorMsg() {
		return find(transactionErrorMsg);
	}
	
	public boolean checkIfVendorsAreSorted() {
		List<WebElement> vendorAmountList = finds(vendorAmount);
		System.out.println(vendorAmountList.get(1).getText().substring(1));
		System.out.println(Float.parseFloat(vendorAmountList.get(0).getText().substring(1)));
		if(Float.parseFloat(vendorAmountList.get(0).getText().substring(1)) > Float.parseFloat(vendorAmountList.get(1).getText().substring(1)) && 
				Float.parseFloat(vendorAmountList.get(1).getText().substring(1)) > Float.parseFloat(vendorAmountList.get(2).getText().substring(1))) {
			return true;
		}else
			return false;
	}
}
