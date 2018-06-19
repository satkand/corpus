package pages.marketplace.money;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import automation.framework.common.Copy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class MoneyPage extends BasePage{
	

	private By rewardCarouselTitle = By.id("au.com.suncorp.marketplace:id/rewardCarouselTitle");
	private By articleCarouselTitle = By.id("au.com.suncorp.marketplace:id/articleCarouselTitle");
	private By spendingInsightsLastMonth = By.id("au.com.suncorp.marketplace:id/spendingInsightsLastMonthCardLayout");
	private String wealthAddAccountButtonID = "au.com.suncorp.marketplace:id/wealthAddAccountButton";
	private String offerTitleID = "au.com.suncorp.marketplace:id/offerTitle";
	

	public MoneyPage(AppiumDriver driver) {
		super(driver);
	}
	
    public WebElement checkBSB(String accountName) {
    	
    return find(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"%s\").fromParent(new UiSelector().className(\"android.widget.LinearLayout\").className(\"android.widget.TextView\").instance(1))", accountName)));
    		
    }
    
    public WebElement scrollToOfferTitle() {
    	
    	 return scrollToElement(offerTitleID,"id");
    }
    
    public String getOfferTitle() {
    	
    	return getText(scrollToOfferTitle());
    }
    
    public String getArticleCarouselTitle() {
		
		return scrollAndGetElementText(articleCarouselTitle, 2);
	}
    public String getRewardCarouselTitle() {
		
		return scrollAndGetElementText(rewardCarouselTitle, 2);
	}
    public WebElement checkSpendingInsightsLastMonth() {
    	
    	return find(spendingInsightsLastMonth);
    	
    }
    public WebElement checkMoneyTrackerTitle(){
    	
    	return findByUIAutomator(Copy.MONEY_TRACKER_TITLE, "text");
    }
    
    public WebElement checkAvailableBalance(String accountName) {
    	
        return find(By.xpath(String.format("//android.widget.TextView[@text=\"%s\"]/ancestor::android.widget.LinearLayout/android.widget.LinearLayout[2]/descendant::android.widget.TextView[2]", accountName)));
        	
        		
        }
    
    public WebElement checkAccountNumber(String accountName) {
    	
        return find(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"%s\").fromParent(new UiSelector().className(\"android.widget.LinearLayout\").className(\"android.widget.TextView\").instance(2))", accountName)));
        	
        		
     }
    
    public String getBSB(String accountName) {
    	
      //  return getText(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"%s\").fromParent(new UiSelector().className(\"android.widget.LinearLayout\").className(\"android.widget.TextView\").instance(1))", accountName)));
    	
        return getText(checkBSB(accountName));
    	
        		
      }
     public String getAccountNumber(String accountName) {
    	
      //  return getText((MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"%s\").fromParent(new UiSelector().className(\"android.widget.LinearLayout\").className(\"android.widget.TextView\").instance(2))", accountName))));
        	
        return getText(checkAccountNumber(accountName));
    	
     }
     
     public String getAvailableBalance(String accountName) {
     	
        // return getText((By.xpath(String.format("//android.widget.TextView[@text=\"%s\"]/ancestor::android.widget.LinearLayout/android.widget.LinearLayout[2]/descendant::android.widget.TextView[2]", accountName))));
         	
         	return getText(checkAvailableBalance(accountName));	
      }

   
    public WebElement checkAccountName(String text) {
    	
    return scrollToElementByText(text, 5);
    	
    }
    
	public void tapAccountName(String accountName) {

		tapElement(checkAccountName(accountName));

	}
    
	public void tapOnExistingProductButton() {
		
		tapElement(scrollToElement(wealthAddAccountButtonID,"id"));
	}
	
	public void tapOnMoneytracker() {
		
		tapElement(spendingInsightsLastMonth);
	}


}
