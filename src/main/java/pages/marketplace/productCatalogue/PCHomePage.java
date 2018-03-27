package pages.marketplace.productCatalogue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import pages.marketplace.common.MyJSONParser;

public class PCHomePage extends BasePage {
	
	public PCHomePage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private By aamiTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/brandTabLayout']//android.widget.TextView[@text='AAMI']");
	private By gioTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/brandTabLayout']//android.widget.TextView[@text='GIO']");
	private By shannonsTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/brandTabLayout']//android.widget.TextView[@text='SHANNONS']");
	private By apiaTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/brandTabLayout']//android.widget.TextView[@text='APIA']");
	private By bingleTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/brandTabLayout']//android.widget.TextView[@text='BINGLE']");
	private By suncorpTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/brandTabLayout']//android.widget.TextView[@text='SUNCORP']");
	private By pcHomePageTitle = By.xpath("//android.view.ViewGroup[@resource-id='au.com.suncorp.marketplace:id/suncorpToolbar']/android.widget.TextView[@text='Product catalogue']");
	
	private By productQuoteButton = By.id("au.com.suncorp.marketplace:id/productQuoteButton");
	private By detailsButton = By.id("au.com.suncorp.marketplace:id/productDetailsButton");
	private By webView = By.id("au.com.suncorp.marketplace:id/webview");
	private By webViewCloseButton = MobileBy.AccessibilityId("Navigate up");
	private By proceedButton = By.id("android:id/button1");
	
	private By brandInfo = By.id("au.com.suncorp.marketplace:id/brandDescription");
	private By factsTitle = By.id("au.com.suncorp.marketplace:id/factsTitle");
	private By disclaimer = By.id("au.com.suncorp.marketplace:id/disclaimerText");
	
	
	public JSONArray getBrandList(){
		MyJSONParser jsonParser = new MyJSONParser();
		JSONArray brandList = jsonParser.parseJson();
		return brandList;
	}
	
	public JSONArray getCategories(Object brand) {	
			JSONObject brandJSON = (JSONObject)brand;			
			JSONArray categoryJSON = (JSONArray) brandJSON.get("categories");
			return categoryJSON;
		}
		
	public JSONArray getSubCategories(JSONObject categoryJSON) {
		return (JSONArray) categoryJSON.get("products");
	}
	
	public boolean verifyFacts(JSONObject subCategoryJson) {
		JSONArray facts = (JSONArray) subCategoryJson.get("facts");
		boolean verified = true;
		int i=0;
		for(Object fact : facts) {
			i++;
			String factText = find(By.xpath(String.format("//*[@resource-id='au.com.suncorp.marketplace:id/factsContainer']/"
					+ "android.widget.LinearLayout[%s]/android.widget.TextView",i))).getText();
			if(!factText.contentEquals(fact.toString()))
				verified = false;	
		}
		return verified;
	}
	
	public void tapObject(WebElement object) {	
		tapElement(object);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void tapObject (String objectName) {
		tapElement(By.xpath(String.format("//*[@text='%s']",objectName)));
	}
	
	public WebElement findCategory(String elementName) {
		return findElementInAListView(elementName, "au.com.suncorp.marketplace:id/categoryList");
	}
	
	public WebElement findSubCategory(String elementName) {
		return findElementInAListView(elementName, "au.com.suncorp.marketplace:id/productListView");
	}
	
	public void scrollToTop() {
	 int i = 5;
	 while(i>0) {
		 swipeScreen("up");
		 i--;
	 }
	}
	
	public void scrollDown() {
		swipeScreen("down");
	}
	
	public WebElement checkPCHomePageTitle() {
		return find(pcHomePageTitle);
	}
	
	public boolean isAamiTabSelected() {
		return isSelected(aamiTab);
	}
	
	public WebElement checkAamiTab() {
		return find(aamiTab);
	}
	
	public void tapAamiTab() {
		tapElement(aamiTab);
	}

	public boolean isApiaTabSelected() {
		return isSelected(apiaTab);
	}
	
	public WebElement checkApiaTab() {
		return find(apiaTab);
	}
	
	public void tapApiaTab() {
		tapElement(apiaTab);
	}

	
	public boolean isGioTabSelected() {
		return isSelected(gioTab);
	}
	
	public WebElement checkGioTab() {
		return find(gioTab);
	}
	
	public void tapGioTab() {
		tapElement(gioTab);
	}

	public boolean isBingleTabSelected() {
		return isSelected(bingleTab);
	}
	
	public WebElement checkBingleTab() {
		return find(bingleTab);
	}
	
	public void tapBingleTab() {
		tapElement(bingleTab);
	}
	
	public boolean isSuncorpTabSelected() {
		return isSelected(suncorpTab);
	}
	
	public WebElement checkSuncorpTab() {
		return find(suncorpTab);
	}
	
	public void tapSuncorpTab() {
		swipeToSuncorpTab();
		tapElement(suncorpTab);
	}
	
	public boolean isShannonsTabSelected() {
		return isSelected(shannonsTab);
	}
	
	public WebElement checkShannonsTab() {
		return find(shannonsTab);
	}
	
	public void tapShannonsTab() {
		swipeToShannonsTab();
		tapElement(shannonsTab);
	}
	
	public void swipeToShannonsTab() {
		swipeHorizontally(gioTab, bingleTab);
		swipeHorizontally(shannonsTab, gioTab);
	}
	
	public void swipeToSuncorpTab() {
		swipeHorizontally(gioTab, bingleTab);
		swipeHorizontally(suncorpTab, shannonsTab);
	}
	
	public WebElement checkQuoteButton() {
		return find(productQuoteButton);
	}
	
	public void tapQuoteButton() {
		tapElement(productQuoteButton);
	}
	
	public WebElement checkDetailsButton() {
		return find(detailsButton);
	}
	
	public void tapDetailsButton() {
		tapElement(detailsButton);
	}
	
	public WebElement checkDisclaimer() {
		return find(disclaimer);
	}
	
	public WebElement checkBrandInfo() {
		return find(brandInfo);
	}
	
	public WebElement checkFactsHeader() {
		return find(factsTitle);
	}
	
	public WebElement checkWebView() {
		return find(webView);
	}
	
	public String getURL() {
		return getWebURL();
		
	}
	
	public void tapCloseWebViewButton() {
		tapElement(webViewCloseButton);
	}

	public void tapProceedButton() {
		tapElement(proceedButton);
	}
	
	public WebElement checkProceedButton() {
		return find(proceedButton);
	}
}
