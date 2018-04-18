package pages.marketplace.property;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class PropertyFullScreenMap extends BasePage{

	
	public PropertyFullScreenMap(AppiumDriver driver) {
		super(driver);
		}

	private By fullScreenMapPin = By.xpath("//android.widget.FrameLayout[@resource-id='au.com.suncorp.marketplace:id/whatsNearbyMapView']//android.widget.FrameLayout//android.view.View[@content-desc='Google Map']//android.view.View");
	private By fullScreenMapCloseButton = MobileBy.AccessibilityId("Navigate up");
	private By fullScreenMapTitle= By.xpath("//android.view.ViewGroup[@resource-id='au.com.suncorp.marketplace:id/suncorpToolbar']//android.widget.TextView");
	private By fullScreenMap= MobileBy.AccessibilityId("Google Map");
	
	private By propertyTab = By.xpath("//android.widget.TextView[@text='PROPERTY']");
	private By educationTab = By.xpath("//android.widget.TextView[@text='EDUCATION']");
	private By shoppingTab = By.xpath("//android.widget.TextView[@text='SHOPPING']");
	private By transportTab = By.xpath("//android.widget.TextView[@text='TRANSPORT']");
	private By entertainmentTab = By.xpath("//android.widget.TextView[@text='ENTERTAINMENT']");
	private By healthTab = By.xpath("//android.widget.TextView[@text='HEALTH']");
	private By diningTab = By.xpath("//android.widget.TextView[@text='DINING']");
	private By otherTab = By.xpath("//android.widget.TextView[@text='OTHER']");
	
	private String tabBarID = "au.com.suncorp.marketplace:id/nearbyCategoryAppBarLayout";
	
	public boolean checkElementWithAccessibilityID(String text) {
		String t =  "\""+text+"\"";  
		By titleName = MobileBy.AccessibilityId(t);
		WebElement element = find(titleName);
		if (element !=null) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isPropertyTabSelected() {
		return isEnabled(propertyTab);
	}

	public WebElement checkPropertyTab() {
		return find(propertyTab);
	}
	
	public void tapPropertyTab() {
		tapElement(propertyTab);
	}
	
	public WebElement checkEducationTab() {
		return find(educationTab);
	}
	
	public void tapEducationTab() {
		tapElement(educationTab);
	}
	
	public WebElement checkShoppingTab() {
		return find(shoppingTab);
	}
	
	public void tapShoppingTab() {
		tapElement(shoppingTab);
	}
	
	public WebElement checkTransportTab() {
		return find(transportTab);
	}
	
	public void tapTransportTab() {
		tapElement(transportTab);
	}
	
	public WebElement checkEntertainmentTab() {
		return find(entertainmentTab);
	}
	
	public void tapEntertainmentTab() {
		tapElement(entertainmentTab);
	}
	
	public WebElement checkHealthTab() {
		return find(healthTab);
	}
	
	public void tapHealthTab() {
		tapElement(healthTab);
	}
	
	public WebElement checkDiningTab() {
		return find(diningTab);
	}
	
	public void tapDiningTab() {
		tapElement(diningTab);
	}
	
	public WebElement checkOtherTab() {
		return find(otherTab);
	}
	
	public void tapOtherTab() {
		tapElement(otherTab);
	}
	
	public WebElement checkFullScreenMapCloseButton() {
		return find(fullScreenMapCloseButton);
	}
	
	public WebElement checkFullScreenMapTitle() {
		return find(fullScreenMapTitle);
	}
	
	public void tapFullScreenMapCloseButton() {
		tapElement(fullScreenMapCloseButton);
	}
	
	public WebElement checkFullScreenMapPin() {
		return find(fullScreenMapPin);
	}
	
	public WebElement checkFullScreenMap() {
		return find(fullScreenMap);
	}
	
	public void doubleTapFullScreenMap() {
		tapElement(fullScreenMap);
		tapElement(fullScreenMap);	
	}
	
}
