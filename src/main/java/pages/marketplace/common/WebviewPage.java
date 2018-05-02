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
		
	private By webviewCloseButton = MobileBy.AccessibilityId("Close tab");
	private By webviewBrowserUrl = By.id("com.sec.android.app.sbrowser:id/url_bar_text");
	private By webViewLocationBar = By.id("com.sec.android.app.sbrowser:id/location_bar_edit_text");
	private By webViewPopup = MobileBy.AccessibilityId("Close");
	private By webViewToolbarOprions = MobileBy.AccessibilityId("More options");
	private By webViewAddToBookMark = By.xpath("//android.widget.TextView[@text='Add to Bookmarks']");
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
