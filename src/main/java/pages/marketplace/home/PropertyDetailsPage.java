package pages.marketplace.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class PropertyDetailsPage   extends BasePage{

	public PropertyDetailsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By propertyAddress = By.id("au.com.suncorp.marketplace:id/propertyAddressLine1Text");
	private By propertyStatePostCode = By.id("au.com.suncorp.marketplace:id/propertyAddressLine2Text");
	private By propertyNumberOfBedrooms = By.id("au.com.suncorp.marketplace:id/bedroomNumberText");
	private By propertyNumberOfBedroomsImage = By.id("au.com.suncorp.marketplace:id/bedroomImage");
	
	private By propertyNumberOfBathrooms = By.id("au.com.suncorp.marketplace:id/bathNumberText");
	private By propertyNumberOfBathroomsImage = By.id("au.com.suncorp.marketplace:id/bathImage");
	private By propertyNumberOfParkingSpaces = By.id("au.com.suncorp.marketplace:id/parkingNumberText");
	private By propertyNumberOfParkingSpacesImage = By.id("au.com.suncorp.marketplace:id/parkingImage");
	private By propertyLandSize = By.id("au.com.suncorp.marketplace:id/landSizeNumberText");
	private By propertyType = By.id("au.com.suncorp.marketplace:id/propertyTypeText");
	private By propertyShowMoreInfo = By.id("au.com.suncorp.marketplace:id/viewExtraInfoTitleText");
	private By propertyShowMoreDownArrow = By.id("au.com.suncorp.marketplace:id/extraInfoButton");
	
	private By propertyRoofType = By.id("au.com.suncorp.marketplace:id/roofTypeText");
	private By propertyRoofTypeTitle = By.id("au.com.suncorp.marketplace:id/roofTypeTitleText");
	private By propertyWallMaterial = By.id("au.com.suncorp.marketplace:id/wallMaterialText");
	private By propertyWallMaterialTitle = By.id("au.com.suncorp.marketplace:id/wallMaterialTitleText");
	private By propertyBuiltYear = By.id("au.com.suncorp.marketplace:id/yearBuiltText");
	private By propertyBuiltYearTitle = By.id("au.com.suncorp.marketplace:id/yearBuiltTitleText");
	
	private By lastSaleTitle = By.id("au.com.suncorp.marketplace:id/lastSaleTitleText");
	private By lastSaleValue = By.id("au.com.suncorp.marketplace:id/salePriceValueText");
	private By lastSaleDate = By.id("au.com.suncorp.marketplace:id/saleDateValueText");
	
	private By miniMap = By.id("au.com.suncorp.marketplace:id/mapView");
	private By miniMapWhatsNewButton = By.id("au.com.suncorp.marketplace:id/nearbyButton");
	private By miniMapLocationPin = By.xpath("//android.widget.FrameLayout[@resource-id='au.com.suncorp.marketplace:id/mapView']//android.widget.FrameLayout//android.view.View[@content-desc='Google Map']//android.view.View");
	
	private By suburbInsightImage = By.id("au.com.suncorp.marketplace:id/suburbInsightImage");
	private By showMeInsightButton = By.id("au.com.suncorp.marketplace:id/viewSuburbInsightButton");
	private By suburbInsightTitleText = By.id("au.com.suncorp.marketplace:id/suburbInsightTitleText");
	private By suburbInsightDescription = By.id("au.com.suncorp.marketplace:id/suburbInsightDescriptionText");
	
	public String getSuburbInsightTitleText() {
		return getText(suburbInsightTitleText);
	}
	public WebElement checkSuburbInsightTitleText() {
		return find(suburbInsightTitleText);
	}
	public String getSuburbInsightDescription() {
		return getText(suburbInsightDescription);
	}
	public WebElement checkSuburbInsightDescription() {
		return find(suburbInsightDescription);
	}
	public String getSuburbInsightImage() {
		return getText(suburbInsightImage);
	}
	public WebElement checkSuburbInsightImage() {
		return find(suburbInsightImage);
	}
	public String getLastSaleValue() {
		return getText(lastSaleValue);
	}
	public String getLastSaleDate() {
		return getText(lastSaleDate);
	}
	public WebElement checkLastSaleTitle() {
		return find(lastSaleTitle);
	}
	public WebElement checkLastSaleValue() {
		return find(lastSaleValue);
	}
	public WebElement checkLastSaleDate() {
		return find(lastSaleDate);
	}
	
	public WebElement checkPropertyRoofType() {
		return find(propertyRoofType);
	}
	public String getPropertyRoofType() {
		return getText(propertyRoofType);
	}
	public WebElement checkPropertyWallMaterial() {
		return find(propertyWallMaterial);
	}
	public String getPropertyWallMaterial() {
		return getText(propertyWallMaterial);
	}
	public WebElement checkPropertyBuiltYear() {
		return find(propertyBuiltYear);
	}
	public String getPropertyBuiltYear() {
		return getText(propertyBuiltYear);
	}
	public WebElement checkPropertyRoofTypeTitle() {
		return find(propertyRoofTypeTitle);
	}
	public WebElement checkPropertyWallMaterialTitle() {
		return find(propertyWallMaterialTitle);
	}
	public WebElement checkPropertyBuiltYearTitle() {
		return find(propertyBuiltYearTitle);
	}
	public void tappropertyShowMoreDownArrow() {
		tapElement(propertyShowMoreDownArrow);
	}
	public String getPropertyAddress() {
		return getText(propertyAddress);
	}
	public String getPropertyStatePostCode() {
		return getText(propertyStatePostCode);
	}
	public String getPropertyNumberOfBedrooms() {
		return getText(propertyNumberOfBedrooms);
	}
	public String getPropertyNumberOfBathrooms() {
		return getText(propertyNumberOfBathrooms);
	}
	public String getPropertyNumberOfParkingSpaces() {
		return getText(propertyNumberOfParkingSpaces);
	}
	public String getPropertyLandSize() {
		return getText(propertyLandSize);
	}
	public String getPropertyType() {
		return getText(propertyType);
	}
	public String getPropertyShowMoreInfo() {
		return getText(propertyShowMoreInfo);
	}	
	public WebElement checkPropertyNumberOfParkingSpacesImage() {
		return find(propertyNumberOfParkingSpacesImage);
	}
	public WebElement checkPropertyLandSize() {
		return find(propertyLandSize);
	}
	public WebElement checkPropertyType() {
		return find(propertyType);
	}
	public WebElement checkPropertyShowMoreInfo() {
		return find(propertyShowMoreInfo);
	}
	public WebElement checkPropertyNumberOfBathroomsImage() {
		return find(propertyNumberOfBathroomsImage);
	}
	public WebElement checkPropertyNumberOfParkingSpaces() {
		return find(propertyNumberOfParkingSpaces);
	}
	public WebElement checkPropertyStatePostCode() {
		return find(propertyStatePostCode);
	}
	public WebElement checkPropertyNumberOfBedrooms() {
		return find(propertyNumberOfBedrooms);
	}
	public WebElement checkPropertyNumberOfBedroomsImage() {
		return find(propertyNumberOfBedroomsImage);
	}
	public WebElement checkPropertyNumberOfBathrooms() {
		return find(propertyNumberOfBathrooms);
	}
	public WebElement checkPropertyAddress() {
		return find(propertyAddress);
	}
	public void scrollToViewMoreInfo() {
		scrollToElement(propertyShowMoreInfo, "true");
	}
	public void tapAndroidDeviceBackButton(){
		tapDeviceBackButton();
	}
	public void scrollToShowMeInsightButton() {
		scrollToElement(showMeInsightButton, "true");
	}
	public void tapShowMeInsightButton(){
		tapElement(showMeInsightButton);
	}
	public WebElement checkMiniMap() {
		return find(miniMap);
	}
	public WebElement checkMiniMapWhatsNewButton() {
		return find(miniMapWhatsNewButton);
	}
	public WebElement checkMiniMapLocationPin() {
		return find(miniMapLocationPin);
	}
	public void scrollToWhatsNewButton() {
		scrollToElement(miniMapWhatsNewButton, "true");
	}
	
}
