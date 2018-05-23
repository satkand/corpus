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
	private By webViewOpenInChromeButton = MobileBy.AccessibilityId("Open in Chrome");
	private By webViewAddToBookMark = By.xpath("//android.widget.TextView[@text='Add to Bookmarks']");
	private By webViewWebAddress = By.id("com.sec.android.app.sbrowser:id/add_bookmark_page_url_input");
	private By webview = By.id("au.com.suncorp.marketplace:id/webview");
	private By webviewCloseButton = MobileBy.AccessibilityId("Navigate up");
	private By urlBar = By.id("com.android.chrome:id/url_bar");
	private By webviewBrowserUrl_samsung = By.id("com.sec.android.app.sbrowser:id/url_bar_text");
	private By webviewBrowserUrl_google= By.id("com.android.chrome:id/url_bar");
	
	
	public void tapWebViewToolbarOprions() {
		tapElement(webViewToolbarOprions);
	}
	
	public WebElement checkViewToolbarOptions() {
		return find(webViewToolbarOprions);
	}
	
	public void tapWebViewOpenInChromeButton() {
		tapElement(webViewOpenInChromeButton);
	}
	
	public WebElement checkWebViewOpenInChromeButton() {
		return find(webViewOpenInChromeButton);
	}
	
	
	public String getWebViewWebAddress() {
		find(webViewWebAddress);
		return getText(webViewWebAddress);
	}
	
	public WebElement checkWebViewAddToBookMarkButton() {
		return find(webViewAddToBookMark);
	}
	
	public WebElement checkUrlBar() {
		return find(urlBar);
	}
	
	public String getTextUrlBar() {
		return getText(urlBar);
	}
	
	public void tapWebViewAddToBookMarkButton() {
		tapElement(webViewAddToBookMark);
	}
	
	public WebElement checkWebViewLocationBarr() {
		return find(webViewLocationBar,10);
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
			tapWebViewToolbarOprions();
			tapWebViewOpenInChromeButton();
		browserUrl = find(webviewBrowserUrl_google);
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
		}
		return browserUrlText;
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
		return find(webViewPopup,5);
	}
	
	public void tapWebViewPopup() {
		tapElement(webViewPopup);
	}


}
