package pages.marketplace.productCatalogue;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class PCHomePage extends BasePage {

	private ArrayList<String> brandNames;
	
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
	
	public JSONArray getBrandList(){
		MyJSONParser jsonParser = new MyJSONParser();
		JSONArray brandList = jsonParser.parseJson();
		return brandList;
	}
	
	public JSONArray getCategories(Object brand) {
	
		
			JSONObject brandJSON = (JSONObject)brand;	
//			brandNames.add(brandJSON.get("name").toString());
			
			JSONArray categoryJSON = (JSONArray) brandJSON.get("categories");
			getCategoryList(categoryJSON);
			return categoryJSON;
		}
		
		
	public WebElement findEle(String elementName) {
		return findElementInAListView(elementName, "au.com.suncorp.marketplace:id/categoryList");
	}
	
	public void getCategoryList(JSONArray categoryJSON) {
		for(Object category : categoryJSON) {
			
			System.out.println(category);
		}
	}
	
	public void scrollToTop() {
	 int i = 5;
	 while(i>0) {
		 swipeScreen("up");
		 i--;
	 }
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
	
}
