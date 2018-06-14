package pages.marketplace.wealth;

import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.javascript.host.event.KeyboardEvent;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class VendorDetailPage extends BasePage{

	public VendorDetailPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By avgSpend = By.id("au.com.suncorp.marketplace:id/avgSpendingText");
	private By avgTransFreq = By.id("au.com.suncorp.marketplace:id/avgTransactionText");
	private By transactionCount = By.id("au.com.suncorp.marketplace:id/transactionCount");
	private By transactionList = By.id("au.com.suncorp.marketplace:id/transactionsRecyclerView");
	private By vendorName = By.id("au.com.suncorp.marketplace:id/vendorName");
	private By vendorAmount = By.id("au.com.suncorp.marketplace:id/amount");
	private By searchField = By.id("au.com.suncorp.marketplace:id/searchBar");
	private By searchBar = By.id("au.com.suncorp.marketplace:id/search_src_text");
	private By vendorSearchList = By.id("au.com.suncorp.marketplace:id/vendorFilteredList");
	private By vendorSearchScreenTitle = By.xpath("//android.widget.TextView[@text='Vendor search']");
	private By closeButton = MobileBy.AccessibilityId("Navigate up");
	private By searchErrorMsg = By.id("au.com.suncorp.marketplace:id/noResultsMessage");
	private By searchItems = By.id("au.com.suncorp.marketplace:id/spendingItem");
	
	
	public WebElement checkAvgSpend() {
		return find(avgSpend);
	}
	
	public void tapAvgSpend() {
		tapElement(avgSpend);
	}
	
	public WebElement checkAvgTransFreq() {
		return find(avgTransFreq);
	}
	
	public WebElement checkTransactionList() {
		return find(transactionList);
	}

	public void scrollDown() {
		scrollToElement(transactionList);
	}
	
	public boolean checkVendorNames(String vendorNavigatedTo) {
		scrollToElement(transactionList);
		boolean match = false;
		List<WebElement> vendorNames  = finds(vendorName);
		if(vendorNames.size() > 0) {
			for(WebElement vendor : vendorNames){
				if(vendor.getText().contentEquals(vendorNavigatedTo))
					match = true;
				else
					match = false;
			}
		}else
			match = false;
		
		return match;
	}
	
	
	public boolean checkVendorAmount() {
		scrollToElement(transactionList);
		if(finds(vendorAmount).size() > 0) {
			return true;
		}else
			return false;
	}
	
	public WebElement checkSearchField() {
		return find(searchField);
	}
	
	public void tapSearchField() {
		tapElement(searchField);
	}
	
	public WebElement checkCloseButton() {
		return find(closeButton);
	}
	
	public void tapCloseButton() {
		tapElement(closeButton);
	}
	
	public WebElement checkVendorSearchList() {
		return find(vendorSearchList);
	}
	
	public WebElement checkVendorSearchScreenTitle() {
		return find(vendorSearchScreenTitle);
	}
	
	public void enterSearchText(String searchString) {
		typeValue(searchString, searchBar);
	}
	
	public boolean verifySearch(String resultString1,String resultString2,String resultString3 ) {
		if(findByUIAutomator(resultString1, "text") != null && findByUIAutomator(resultString2, "text") != null 
				&& findByUIAutomator(resultString3, "text") != null) {
			return true;
		}else
			return false;
	}
	
	public boolean verifySearch4Letter(String resultString1,String resultString2, String resultString3  ) {
		if(findByUIAutomator(resultString1, "text") != null && findByUIAutomator(resultString2, "text") != null 
				&& findByUIAutomator(resultString3, "text") == null) {
			return true;
		}else
			return false;
	}
	
	public boolean verifySearchItems() {
		if(finds(searchItems).size() > 2 ) {
			return true;
		}else
			return false;
		
	}
	
	public WebElement checkSearchErrorMsg() {
		return find(searchErrorMsg);
	}
	
	public void tapBackspace() {
	
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACKSPACE);
	}
}
