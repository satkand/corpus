package pages.marketplace.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class WebviewPage extends BasePage {

	public WebviewPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		
	private By webviewChromeCloseButton = MobileBy.AccessibilityId("Close tab");
	private By webviewBrowserUrl = By.id("com.sec.android.app.sbrowser:id/url_bar_text");
	private By webViewLocationBar = By.id("com.sec.android.app.sbrowser:id/location_bar_edit_text");
	private By webViewPopup = MobileBy.AccessibilityId("Close");
	
	private By webViewToolbarOprions = MobileBy.AccessibilityId("More options");
	private By webViewAddToBookMark = By.xpath("//android.widget.TextView[@text='Add to Bookmarks']");
	//
	private By webViewWebAddress = By.id("com.sec.android.app.sbrowser:id/add_bookmark_page_url_input");
	
	
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
	private By webview = By.id("au.com.suncorp.marketplace:id/webview");
	private By webviewCloseButton = MobileBy.AccessibilityId("Navigate up");

	private By urlBar = By.id("com.android.chrome:id/url_bar");
	
	public WebElement checkUrlBar() {
		return find(urlBar);

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
		return find(webviewBrowserUrl);
	}
	
	public String getWebviewBrowserUrl() {
		return getText(webviewBrowserUrl);
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
