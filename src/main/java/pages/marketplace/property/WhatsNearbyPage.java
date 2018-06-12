package pages.marketplace.property;

import java.util.ArrayList;
import java.util.List;
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
	private By fullScreenMapTitle = By.xpath("//android.view.ViewGroup[@resource-id='au.com.suncorp.marketplace:id/suncorpToolbar']//android.widget.TextView");
	
	private By fullScreenMap= MobileBy.AccessibilityId("Google Map");
	private By fullScreenMapPropertyPin= MobileBy.AccessibilityId("property_title. ");
	
	
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
	
	//POI categories
	private By placesListCountLabel = By.id("au.com.suncorp.marketplace:id/pointsOfInterestListTitleText");
	private By showListLabelButton = By.id("au.com.suncorp.marketplace:id/pointsOfInterestListButtonText");
	private By itemListdistance = By.id("au.com.suncorp.marketplace:id/educationNameText");
	private By listID = By.id("au.com.suncorp.marketplace:id/educationNameText");
	private By POIexpandableListButton = By.id("au.com.suncorp.marketplace:id/pointsOfInterestListButtonText");
	private By POIname = By.name("au.com.suncorp.marketplace:id/educationNameText");
		
	//route card
	private By routeCardNameLabel = By.id("Research Primary School");
	private By drivingButtonLabel = By.id("Driving 4 mins");
	private By walkingButtonLabel = By.id("Walking 25 mins");
		
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
	
	public void tapEducationTab() {
		tapElement(educationTab);
	}
	
	public WebElement checkShoppingTab() {
		return find(shoppingTab);
	}
	
	public void tapShoppingTab() {
		tapElement(shoppingTab);
	}
	
	public String getPlacesListCountLabel() {
		return getText(placesListCountLabel);
	}
	
	public boolean isShoppingTabSelected() {
		return isTabSelected(shoppingTab);
	}
	
	public boolean isTransportTabSelected() {
		return isTabSelected(transportTab);
	}
	
	public boolean isEntertainmentTabSelected() {
		return isTabSelected(entertainmentTab);
	}
	
	public boolean isHealthTabSelected() {
		return isTabSelected(healthTab);
	}
	
	public boolean isDiningTabSelected() {
		return isTabSelected(diningTab);
	}
	
	public boolean isOtherTabSelected() {
		return isTabSelected(otherTab);
	}
	
	public WebElement checkEducationTab() {
		return find(educationTab);
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
	
	public WebElement checkTransportTab() {
		return find(transportTab);
	}
	
	public void tapTransportTab() {
		tapElement(transportTab);
	}
	
	public WebElement checkPlacesListCountLabel() {
		return find(placesListCountLabel,3);
	}
	
	public WebElement checkPOIname() {
		return find(POIname,3);
	}
	
	public void tapPOIname() {
		tapElement(POIname);
	}

	public void tapPOIexpandableListButton() {
		tapElement(POIexpandableListButton);
	}
	
	public double getDeviceVersion() {
		double osVersion = Double.parseDouble(getDeviceAttribute("platformVersion").substring(0, 1));
		return osVersion;
		
	}
	
	public String getDeviceModel() {
		String deviceModel = getDeviceAttribute("deviceModel");
		return deviceModel;
		
	}
	
	public WebElement checkShowListLabelButton() {
		return find(showListLabelButton);
	}
	
	public String getShowListLabelButton() {
		return getText(showListLabelButton).toUpperCase();
	}
	
	public List<String> getItemsList() {
		String convertDistance = null;
		List<String> names = new ArrayList<String>();
		List<WebElement> itemListElements = finds(itemListdistance);
		for(int i=0;i<itemListElements.size();i++) {
			if(itemListElements.get(i).getText().contains("km")) {
				String POIDistance = itemListElements.get(i).getText().replace("(", "").replace(")", "");
				convertDistance = POIDistance.substring(0, (itemListElements.get(i).getText().length()-4));
				convertDistance = convertDistance.replace(".", "")+"00";
				names.add(convertDistance.substring(convertDistance.length()-4, convertDistance.length()));
			}
			else if(itemListElements.get(i).getText().contains("m")){
				String POIDistance = itemListElements.get(i).getText().replace("(", "").replace(")", "");
				convertDistance = POIDistance.substring(0, (itemListElements.get(i).getText().length()-3));
				names.add(convertDistance.substring(convertDistance.length()-3, convertDistance.length()));
			}else{
				String POIDistance = itemListElements.get(i).getText().replace("(", "").replace(")", "");
				names.add(POIDistance);
			}
		}
		return names;
	}

	public WebElement checkFullScreenMapCloseButton() {
		return find(fullScreenMapCloseButton);
	}
	
	public WebElement checkFullScreenMapTitle() {
		if(getDeviceModel().equalsIgnoreCase("SM-G900F")) {
			return find(propertyCardTitle);
		}else {
			return find(fullScreenMapTitle);
		}
		
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
	
	public void swipeTabsLeft() {
		scrollHorizontallyToElement("OTHER","text","au.com.suncorp.marketplace:id/nearbyCategoryLayout",2);
	}
	
	public void swipeTabsRight() {
		scrollHorizontallyToElement("EDUCATION","text","au.com.suncorp.marketplace:id/nearbyCategoryLayout",2);
	}
}
