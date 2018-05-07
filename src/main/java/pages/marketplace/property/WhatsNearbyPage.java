package pages.marketplace.property;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class WhatsNearbyPage extends BasePage{

	
	public WhatsNearbyPage(AppiumDriver driver) {
		super(driver);
		}

	private By fullScreenMapPin = By.xpath("//android.widget.FrameLayout[@resource-id='au.com.suncorp.marketplace:id/whatsNearbyMapView']//android.widget.FrameLayout//android.view.View[@content-desc='Google Map']//android.view.View");
	private By fullScreenGoogleLabel = By.xpath("//android.widget.FrameLayout[@resource-id='au.com.suncorp.marketplace:id/whatsNearbyMapView']//android.widget.FrameLayout//android.widget.RelativeLayout//android.widget.ImageView");
	
	private By fullScreenMapCloseButton = MobileBy.AccessibilityId("Navigate up");
	private By fullScreenMapTitle= By.xpath("//android.view.ViewGroup[@resource-id='au.com.suncorp.marketplace:id/suncorpToolbar']//android.widget.TextView");
	private By fullScreenMap= MobileBy.AccessibilityId("Google Map");
	private By fullScreenMapPropertyPin= MobileBy.AccessibilityId("PROPERTY. ");
	
	
	private By propertyTab = By.xpath("//android.widget.TextView[@text='PROPERTY']");
	private By educationTab = By.xpath("//android.widget.TextView[@text='EDUCATION']");
	private By shoppingTab = By.xpath("//android.widget.TextView[@text='SHOPPING']");
	private By transportTab = By.xpath("//android.widget.TextView[@text='TRANSPORT']");
	private By entertainmentTab = By.xpath("//android.widget.TextView[@text='ENTERTAINMENT']");
	private By healthTab = By.xpath("//android.widget.TextView[@text='HEALTH']");
	private By diningTab = By.xpath("//android.widget.TextView[@text='DINING']");
	private By otherTab = By.xpath("//android.widget.TextView[@text='OTHER']");
	
	//Map location indicators
	private By educationCentreIndicator = MobileBy.AccessibilityId("NorthanMelbourneInstituteOfTAFE. ");
	private By shoppingAmenityIndicator = MobileBy.AccessibilityId("Penny Blue. ");
	private By transportAmenityIndicator = MobileBy.AccessibilityId("Reynolds Rd. ");
	private By entertainmentOutletIndicator = MobileBy.AccessibilityId("Rodder Reserve. ");
	private By healthCentreIndicator = MobileBy.AccessibilityId("Derma Tech Centre. ");
	private By diningCentreIndicator = MobileBy.AccessibilityId("secret garden restraunt. ");
	private By otherAmenityIndicator = MobileBy.AccessibilityId("Coomonwealth bank Niddrie. ");
	
	//Property card details
	private By propertyCardThumbnail = By.id("au.com.suncorp.marketplace:id/propertyCardThumbnail");
	private By propertyCardTitle = By.id("au.com.suncorp.marketplace:id/propertyCardTitle");
	private By propertyCardDetails = By.id("au.com.suncorp.marketplace:id/propertyCardDetail");
	
	private String tabBarID = "au.com.suncorp.marketplace:id/nearbyCategoryAppBarLayout";
	
	public String getPropertyCardTitle() {
		return getText(propertyCardTitle);
	}
	
	public void tapPropertyCardTitle() {
		tapElement(propertyCardTitle);
	}
	
	public String getPropertyCardDetails() {
		return getText(propertyCardDetails);
	}
	
	public WebElement checkPropertyCardThumbnail() {
		return find(propertyCardThumbnail,3);
	}
	
	public void tapPropertyCardThumbnail() {
		tapElement(propertyCardThumbnail);
	}
	
	public WebElement checkPropertyCardTitle() {
		return find(propertyCardTitle,3);
	}
	
	public WebElement checkPropertyCardDetails() {
		return find(propertyCardDetails,3);
	}
	
	public WebElement checkFullScreenMapPropertyPin() {
		return find(fullScreenMapPropertyPin);
	}
	
	public void tapFullScreenMapPropertyPin() {
		find(fullScreenMapPropertyPin,15);
		tapElement(fullScreenMapPropertyPin);
	}
	
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

	public boolean isEducationTabSelected() {
		return isEnabled(educationTab);
	}

	public WebElement checkEducationCentreIndicator() {
		return find(educationCentreIndicator);
	}
	
	public WebElement checkShoppingAmenityIndicator() {
		return find(shoppingAmenityIndicator);
	}
	
	public WebElement checkTransportAmenityIndicator() {
		return find(transportAmenityIndicator);
	}
	
	public WebElement checkEntertainmentOutletIndicator() {
		return find(entertainmentOutletIndicator);
	}
	
	public WebElement checkHealthCentreIndicator() {
		return find(healthCentreIndicator);
	}
	
	public WebElement checkDiningCentreIndicator() {
		return find(diningCentreIndicator);
	}
	
	public WebElement checkOtherAmenityIndicator() {
		return find(otherAmenityIndicator);
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
		return find(otherTab,3);
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
	
	public void tapFullScreenGoogleLabel(){
		find(fullScreenGoogleLabel,3);
		tapElement(fullScreenGoogleLabel);
	}
	
}
