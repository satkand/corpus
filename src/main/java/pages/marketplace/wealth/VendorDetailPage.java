package pages.marketplace.wealth;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

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
	
}
