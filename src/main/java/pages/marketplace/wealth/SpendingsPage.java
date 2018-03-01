package pages.marketplace.wealth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class SpendingsPage extends BasePage {
	
	public SpendingsPage(AppiumDriver driver) {
		super(driver);
	}

	private By spendingPageTitle = By.xpath("//android.widget.TextView[@text='Spending']");
	private By backButton = MobileBy.AccessibilityId("Navigate up");
	private By loadingIndicator = By.id("loadingIndicator");

	private By monthPicker = By.id("au.com.suncorp.marketplace:id/monthSelector");
	private By monthSelected = By.id("au.com.suncorp.marketplace:id/monthLabel");
	private By updateMonthButton = By.id("au.com.suncorp.marketplace:id/changeMonth");
	private By monthsOptionInPicker = By.id("au.com.suncorp.marketplace:id/monthItem");
	//Map<String, String[]> monthsMap = new HashMap<String, String[]>{"Jan": new String[] {"Dec, Nov"}, "Jan": new String[] {"Dec, Nov"}};
	
	Map<String,String[]> monthsMp = new HashMap<String, String[]>()
									{
									    {
									        put("january",   new String[] {"September", "August", "July", "June", "May", "April", "March", "February"});
									        put("february",  new String[] {"October", "September", "August", "July", "June", "May", "April", "March"});
									        put("march",     new String[] {"November", "October", "September", "August", "July", "June", "May", "April"});
									        put("april",     new String[] {"December, November", "October", "September", "August", "July", "June", "May",});
									        put("may",       new String[] {"December, November", "October", "September", "August", "July", "June", "January"});
									        put("june",      new String[] {"December, November", "October", "September", "August", "July", "February", "January"});
									        put("july",      new String[] {"December, November", "October", "September", "August", "March", "February", "January"});
									        put("august",    new String[] {"December, November", "October", "September", "April", "March", "February", "January"});
									        put("september", new String[] {"December, November", "October", "May", "April", "March", "February", "January"});
									        put("october",   new String[] {"December, November", "June", "May", "April", "March", "February", "January"});
									        put("november",  new String[] {"December", "July", "June", "May", "April", "March", "February", "January"});
									        put("december",  new String[] {"August", "July", "June", "May", "April", "March", "February", "January"});
									    }
									};
									
	private By spendingsTotalAmount = By.id("au.com.suncorp.marketplace:id/totalSpentAmount");
	private By infoIcon = By.id("au.com.suncorp.marketplace:id/infoButton");
	//TODO -> This is present on iOS not on Android. Check later, if still not present, remove this
	private By updatedInfoText = By.id("Total updated once per day.");

	
	private By categoriesTab = By.xpath("//android.widget.TextView[@text='CATEGORIES']");
	private By vendorTab = By.xpath("//android.widget.TextView[@text='VENDOR']");

	private By categoriesCell = By.id("au.com.suncorp.marketplace:id/spendingItem");
	private By categoriesImage = By.id("au.com.suncorp.marketplace:id/categoryImage");
	private By categoriesTransactionsText = By.id("au.com.suncorp.marketplace:id/transactionsText");
	private By categoriesName = By.id("au.com.suncorp.marketplace:id/nameText");
	private By categoriesSpendingAmount = By.id("au.com.suncorp.marketplace:id/amountText");
	
	private By vendorCell = By.id("au.com.suncorp.marketplace:id/spendingItem");
	private By vendorCategoryImage = By.id("au.com.suncorp.marketplace:id/categoryImage");
	private By vendorTransactionsText = By.id("au.com.suncorp.marketplace:id/transactionsText");
	private By vendorName = By.id("au.com.suncorp.marketplace:id/nameText");
	private By vendorSpendingAmount = By.id("au.com.suncorp.marketplace:id/amountText");
	
	// TODO Raised a defect for id of empty transacations image 
	private By emptyTransactionsImage = By.id("EmptySpendingImage");
	private By emptyTransactionsMessage = By.id("au.com.suncorp.marketplace:id/missingTransactionsHeading");
	private By emptyTransactionsHintMessage = By.id("au.com.suncorp.marketplace:id/missingTransactionsBodyText");
	
	public WebElement checkSpendingPageTitle() {
		return find(spendingPageTitle,30);
	}
	
	public void tapBackButton() {
		tapElement(backButton);
	}
	
	
	public WebElement checkMonthPicker() {
		return find(monthPicker);
	}
	
	public void tapMonthPicker() {
		tapElement(monthPicker);
	}
	
	public WebElement checkMonthsOptionInPicker() {
		return find(monthsOptionInPicker);
	}
	
	public WebElement checkMonthSelected() {
		return find(monthSelected);
	}
	
	public String getSelectedMonthValue() {
		return getText(monthSelected);
	}
	
	public WebElement checkUpdateMonthButton() {
		return find(updateMonthButton);
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
		/*
		switch(month) {
		case "January":
					tapElement(januaryOption);
					break;
		case "February":
					tapElement(februaryOption);
					break;
		case "March":
					tapElement(marchOption);
					break;
		case "April":
					tapElement(aprilOption);
					break;
		case "May":
					tapElement(mayOption);
					break;
		case "June":			
					tapElement(juneOption);
					break;
		case "July":	
					tapElement(julyOption);
					break;
		case "August":
					tapElement(augustOption);
					break;
		case "September":
					tapElement(septemberOption);
					break;
		case "October":
					tapElement(octoberOption);
					break;
		case "November":
					tapElement(novemberOption);
					break;
		case "December":
					tapElement(decemberOption);
					break;
		}*/
	}
	
	// Returns the months prior to the last 3 months of the current months. These months shouldn't show the transactions count in the categories and vendors list
	public List<String> fetchPastMonthsPriorToLast3Months(String currentMonth){
		//List<String> pastMonths = List.of(monthsMp.get(currentMonth.toLowerCase()));
		List<String> pastMonths = null;
		return pastMonths;
	}
	
	
	public WebElement checkSpendingsTotalAmount() {
		return find(spendingsTotalAmount);
	}
	
	public String getSpendingsTotalAmount() {
		return getText(spendingsTotalAmount);
	}
	
	public WebElement checkInfoIcon() {
		return find(infoIcon);
	}
	
	//TODO -> This is present on iOS not on Android. Check later, if still not present, remove this
	public WebElement checkUpdatedInfoText() {
		return find(updatedInfoText);
	}
	
	public WebElement checkCategoriesTab() {
		return find(categoriesTab);
	}
	
	public boolean isCategoryTabSelected() {
		return isSelected(categoriesTab);
	}
	
	public WebElement checkVendorTab() {
		return find(vendorTab);
	}
	
	public boolean isVendorTabSelected() {
		return isSelected(vendorTab);
	}
	
	public void tapVendorTab() {
		tapElement(vendorTab);
	}
	
	public WebElement checkCategoriesTransactionsText() {
		return find(categoriesTransactionsText);
	}
	
	public List<String> fetchCategoriesTransactionsTextList() {
		return getTextList(categoriesTransactionsText);
	}
	
	public List<String> fetchCategoriesNameList() {
		find(categoriesCell,15);
		return getTextList(categoriesName);
	}
	
	public List<String> fetchCategoriesSpendingAmountList() {
		return getTextList(categoriesSpendingAmount);
	}
	
	public WebElement checkVendorsTransactionsText() {
		return find(vendorTransactionsText);
	}
	
	public List<String> fetchVendorsTransactionsTextList() {
		return getTextList(vendorTransactionsText);
	}
	
	public List<String> fetchVendorsTransactionsNameList() {
		find(vendorCell,15);
		return getTextList(vendorName);
	}
	
	public List<String> fetchVendorsTransactionsAmountList() {
		return getTextList(vendorSpendingAmount);
	}
	
	public Object getTransactionLabel(Object transactionText) {
		String transaction = transactionText.toString();
		switch (transaction) {
		case "1":
			return transaction + " transaction";
		default:
			return transaction + " transactions";
		}
	}
	
	//TODO -> Defect raised for the id
	public WebElement checkEmptyTransactionsImage() {
		return find(emptyTransactionsImage);
	}
	
	public WebElement checkEmptyTransactionsMessage() {
		return find(emptyTransactionsMessage);
	}
	
	public WebElement checkEmptyTransactionsHintMessage() {
		return find(emptyTransactionsHintMessage);
	}
	
	public String getEmptyTransactionsMessage() {
		return getText(emptyTransactionsMessage);
	}
	
	public String getEmptyTransactionsHintMessage() {
		return getText(emptyTransactionsHintMessage);
	}
}

