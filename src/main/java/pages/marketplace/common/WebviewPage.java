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
	private By webviewRefreshButton = MobileBy.AccessibilityId("Refresh page");

	
	public void tapWebViewToolbarOprions() {
		tapElement(webViewToolbarOprions);
	}
	
	public WebElement checkViewToolbarOptions() {
		return find(webViewToolbarOprions);
	}
	
	public void tapWebViewOpenInChromeButton() {
		tapElement(webViewOpenInChromeButton);
	}
	
	public void tapWebviewRefreshButton() {
		tapElement(webviewRefreshButton);
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
		if(getDeviceAttribute("deviceManufacturer").equalsIgnoreCase("samsung")){
			if(getDeviceAttribute("deviceModel").equalsIgnoreCase("SM-G935F")) {
				browserUrl = find(webviewBrowserUrl);
			}else {
				browserUrl = find(webviewBrowserUrl_samsung);
			}
		
		browserUrl = find(webviewBrowserUrl_samsung);
		}
		else if (getDeviceAttribute("deviceManufacturer").equalsIgnoreCase("Google")
		|| getDeviceAttribute("deviceManufacturer").equals("LGE")){
			double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));
			if(getDeviceAttribute("deviceModel").contains("Pixel")&&(osVersion >= 8.0)) {
				browserUrl = find(urlBar);
			}else {
			tapWebViewToolbarOprions();
			tapWebViewOpenInChromeButton();
			browserUrl = find(webviewBrowserUrl_google);
			}

		if(getDeviceAttribute("deviceManufacturer").equalsIgnoreCase("samsung")){
			browserUrl = find(webviewBrowserUrl_samsung);

		}
		else if (getDeviceAttribute("deviceManufacturer").equalsIgnoreCase("Google")
				|| getDeviceAttribute("deviceManufacturer").equals("LGE")){
			browserUrl = find(webviewBrowserUrl_google);
		} else {
			browserUrl = find(webviewBrowserUrl_samsung);

		}

		}
		return browserUrl;
	}
	
	public String getWebviewBrowserUrl() {
		String browserUrlText = null;
		if(getDeviceAttribute("deviceManufacturer").equalsIgnoreCase("samsung")){
			if(getDeviceAttribute("deviceModel").equalsIgnoreCase("SM-G935F")) {
				browserUrlText = getText(webviewBrowserUrl);
			}else if(getDeviceAttribute("deviceModel").equalsIgnoreCase("SM-G950F")){
				browserUrlText = getText(webviewBrowserUrl_samsung);
			}else {
				browserUrlText = getText(webViewLocationBar);
			}
		
		}
		else if (getDeviceAttribute("deviceManufacturer").equalsIgnoreCase("Google")
		|| getDeviceAttribute("deviceManufacturer").equals("LGE")){
			double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));
			if(getDeviceAttribute("deviceModel").contains("Pixel")&&(osVersion >= 8.0)) {
				//browserUrlText = getText(urlBar);
				tapWebViewToolbarOprions();
				if(find(webViewOpenInChromeButton)!=null) {
					tapWebViewOpenInChromeButton();
					browserUrlText = getText(webviewBrowserUrl_google);
				}else {
					tapWebviewRefreshButton();
					browserUrlText = getText(urlBar);
				}
			}else {
				browserUrlText = getText(webviewBrowserUrl_google);
			}
		
		browserUrlText = getText(webviewBrowserUrl_google);
		}

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
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));
		if(getDeviceAttribute("deviceModel").contains("Pixel")&&(osVersion >= 8.0)) {
			tapDeviceBackButton();
		}else if(getDeviceAttribute("deviceModel").contains("Nexus")&&(osVersion <= 8.0)){
			tapDeviceBackButton();
		}else {
			tapElement(webviewChromeCloseButton);
		}
		
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
	
	public String getDeviceModel() {
		return getDeviceAttribute("deviceModel");
	}


}
