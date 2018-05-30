package pages.marketplace.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class WebviewPage extends BasePage {

	public WebviewPage(AppiumDriver driver) {
		super(driver);
	}
		
	private By webviewChromeCloseButton = MobileBy.AccessibilityId("Close tab");
	private By webviewBrowserUrl = By.id("com.sec.android.app.sbrowser:id/url_bar_text");
	private By webViewLocationBar = By.id("com.sec.android.app.sbrowser:id/location_bar_edit_text");
	private By webViewPopup = MobileBy.AccessibilityId("Close");
	private By webViewToolbarOprions = MobileBy.AccessibilityId("More options");
	private By webViewAddToBookMark = By.xpath("//android.widget.TextView[@text='Add to Bookmarks']");
	private By webViewWebAddress = By.id("com.sec.android.app.sbrowser:id/add_bookmark_page_url_input");
	
	private By webview = By.id("au.com.suncorp.marketplace:id/webview");
	private By webviewCloseButton = MobileBy.AccessibilityId("Navigate up");
	
	private By webviewBrowserUrl_samsung = By.id("com.sec.android.app.sbrowser:id/url_bar_text");
	private By webviewBrowserUrl_google = By.id("com.android.chrome:id/url_bar");
	
	
	public void tapWebViewToolbarOprions() {
		tapElement(webViewToolbarOprions);
	}
	
	public WebElement checkViewToolbarOptions() {
		return find(webViewToolbarOprions);
	}
	
	public String getWebViewWebAddress() {
		find(webViewWebAddress);
		return getText(webViewWebAddress);
	}
	
	public WebElement checkWebViewAddToBookMarkButton() {
		return find(webViewAddToBookMark);
	}
	
	public void tapWebViewAddToBookMarkButton() {
		tapElement(webViewAddToBookMark);
	}
	
	public WebElement checkWebViewLocationBarr() {
		return find(webViewLocationBar);
	}
	
	public String getWebViewLocationBar() {
		return getText(webViewLocationBar);
	}
	
	public WebElement checkWebviewBrowserUrl() {
		WebElement browserUrl = null;
		System.out.println("DEVICE IS :::"+getDeviceAttribute("deviceManufacturer"));
		if(getDeviceAttribute("deviceManufacturer").equalsIgnoreCase("samsung")){
			browserUrl = find(webviewBrowserUrl_samsung);
		}
		else if (getDeviceAttribute("deviceManufacturer").equalsIgnoreCase("Google")
				|| getDeviceAttribute("deviceManufacturer").equals("LGE")){
			browserUrl = find(webviewBrowserUrl_google);
		} else {
			browserUrl = find(webviewBrowserUrl_samsung);
		}
		return browserUrl;
	}
	
	public String getWebviewBrowserUrl() {
		
		String browserUrlText = null;
		if(getDeviceAttribute("deviceManufacturer").equalsIgnoreCase("samsung")){
			browserUrlText = getText(webviewBrowserUrl_samsung);
		}
		else if (getDeviceAttribute("deviceManufacturer").equalsIgnoreCase("Google")
				|| getDeviceAttribute("deviceManufacturer").equals("LGE")){
			browserUrlText = getText(webviewBrowserUrl_google);
		} else {
			browserUrlText = getText(webviewBrowserUrl_samsung);
		}
		return browserUrlText;
	}
	
	public String getExpectedBrowserUrl(String expectedValue) {

		if (getDeviceAttribute("deviceManufacturer").equalsIgnoreCase("Google")
				|| getDeviceAttribute("deviceManufacturer").equals("LGE")){
			if(expectedValue.endsWith("/")) {
				expectedValue = expectedValue.substring(0, expectedValue.length()-1);
			}
		}
		if(getDeviceAttribute("deviceManufacturer").equalsIgnoreCase("samsung")) {
			if(!expectedValue.endsWith("/")) {
				expectedValue = expectedValue+"/";
			}
		}
		return expectedValue;
	}
	
	public void tapWebviewChromeCloseButton() {
		tapElement(webviewChromeCloseButton);
	}
	
	public WebElement checkWebview() {
		
		return find(webview);
	}	
	
	public void tapWebviewCloseButton() {

		tapElement(webviewCloseButton);
	
	}

	public WebElement checkPopUp() {
		return find(webViewPopup);
	}
	
	public void tapWebViewPopup() {
		tapElement(webViewPopup);
	}


}
