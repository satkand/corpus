package pages.marketplace.property;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class PropertyDetailsPage   extends BasePage{

	public PropertyDetailsPage(AppiumDriver driver) {
		super(driver);
	}
	
	private By propertyAddress = By.id("au.com.suncorp.marketplace:id/propertyAddressLine1Text");
	private By propertyStatePostCode = By.id("au.com.suncorp.marketplace:id/propertyAddressLine2Text");
	private By propertyNumberOfBedrooms = By.id("au.com.suncorp.marketplace:id/bedroomNumberText");
	private By propertyNumberOfBedroomsImage = By.id("au.com.suncorp.marketplace:id/bedroomImage");
	
	private By thisIsMyPropertyLabel = By.id("au.com.suncorp.marketplace:id/thisIsMineText");
	private By thisIsMyPropertyInfo = By.id("au.com.suncorp.marketplace:id/thisIsMineInfoButton");
	private By thisIsMyPropertyToggleButton = By.id("au.com.suncorp.marketplace:id/propertyIsMineSwitch");
	
	//my Property bottom sheet
	private By myPropertyBottomSheetTitleLabel = By.id("au.com.suncorp.marketplace:id/productSelectionQuestionText");
	private By myPropertyBottomSheetOwnerOccupierButton = By.id("au.com.suncorp.marketplace:id/ownerTypeButton");
	private By myPropertyBottomSheetRenterButton = By.id("au.com.suncorp.marketplace:id/tenantTypeButton");
	private By myPropertyBottomSheetLandLordButton = By.id("au.com.suncorp.marketplace:id/landlordTypeButton");
	private By outsideOfMyPropertyBottomSheet = By.id("au.com.suncorp.marketplace:id/touch_outside");
	private By attributeBar = By.id("au.com.suncorp.marketplace:id/attributesView");
	
	private By propertyNumberOfBathrooms = By.id("au.com.suncorp.marketplace:id/bathNumberText");
	private By propertyNumberOfBathroomsImage = By.id("au.com.suncorp.marketplace:id/bathImage");
	private By propertyNumberOfParkingSpaces = By.id("au.com.suncorp.marketplace:id/parkingNumberText");
	private By propertyNumberOfParkingSpacesImage = By.id("au.com.suncorp.marketplace:id/parkingImage");
	private By propertyLandSize = By.id("au.com.suncorp.marketplace:id/landSizeNumberText");
	private By propertyLandSizeImage = By.id("au.com.suncorp.marketplace:id/landSizeImage");
	
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
	private By miniMapWhatsNearButton = By.id("au.com.suncorp.marketplace:id/nearbyButton");
	private By miniMapLocationPin = By.xpath("//android.widget.FrameLayout[@resource-id='au.com.suncorp.marketplace:id/mapView']//android.widget.FrameLayout//android.view.View[@content-desc='Google Map']//android.view.View");
	
	private By suburbInsightImage = By.id("au.com.suncorp.marketplace:id/suburbInsightImage");
	private By showMeInsightButton = By.id("au.com.suncorp.marketplace:id/viewSuburbInsightButton");
	private By suburbInsightTitleText = By.id("au.com.suncorp.marketplace:id/suburbInsightTitleText");
	private By suburbInsightDescription = By.id("au.com.suncorp.marketplace:id/suburbInsightDescriptionText");
	
	private By propertyImage = By.id("au.com.suncorp.marketplace:id/propertyImage");
	private By favouriteButton = By.id("au.com.suncorp.marketplace:id/addToFavouriteButton");
	private By backButton = By.id("au.com.suncorp.marketplace:id/backButton");
	private By imageNumberText = By.id("au.com.suncorp.marketplace:id/imageNumberText");
	
	private By fullScreenPropertyImage = By.id("au.com.suncorp.marketplace:id/propertyFullImage");
	private By fullScreenPropertyAddress = By.id("au.com.suncorp.marketplace:id/addressText");
	private By fullScreenCloseButton = By.id("au.com.suncorp.marketplace:id/closeButton");
	private By fullScreenImageCounter = By.id("au.com.suncorp.marketplace:id/imageCounterText");
	
	private By estimatedMarketValueLabel = By.id("au.com.suncorp.marketplace:id/estimateValueText");
	private By estimatedMarketValueinfoButton = By.id("au.com.suncorp.marketplace:id/estimateValueInfoButton");
	private By estimatedMarketValue = By.id("au.com.suncorp.marketplace:id/marketPriceRangeText");
	private By confidenceLevelLabel = By.id("au.com.suncorp.marketplace:id/confidenceLevelText");
	private By confidenceIndicator = By.id("au.com.suncorp.marketplace:id/confidenceLevelIndicator");
	private By confidenceIndicatorInfoButton = By.id("au.com.suncorp.marketplace:id/confidenceLevelInfoButton");
	
	private By derivedAssetText = By.xpath("//android.widget.TextView[@text='derived']");
	private By suppliedAssetText = By.xpath("//android.widget.TextView[@text='supplied']");
	private By imageLoadingIndicator = By.xpath("au.com.suncorp.marketplace:id/loadingIndicator");
	
	private By professionalServicesImage = By.id("au.com.suncorp.marketplace:id/professionalServicesImage");
	
	
	//EDUCATION CENTRES
	private By nearbyEducationTitle = By.id("au.com.suncorp.marketplace:id/nearbyEducationText");
	private By nearbyEducationViewAllButton = By.id("au.com.suncorp.marketplace:id/nearbyEducationViewAllText");
	private By nearbyEducationCentres = By.id("au.com.suncorp.marketplace:id/educationNameText");
	
	public WebElement checkNearbyEducationTitle() {
		return find(nearbyEducationTitle);
	}
	
	public void tapNearbyEducationViewAllButton(){
		tapElement(nearbyEducationViewAllButton);
	}
	
	public String getnearbyEducationTitle() {
		return getText(nearbyEducationTitle);
	}
	
	public WebElement checkNearbyEducationViewAllButton() {
		return find(nearbyEducationViewAllButton);
	}
	
	public String getnearbyEducationViewAllButton() {
		return getText(nearbyEducationViewAllButton);
	}
	
	public WebElement checkNearbyEducationCentres() {
		return find(nearbyEducationCentres);
	}
	
	public List<WebElement> fetchNearbyEducationCentres() {
		List<WebElement> elements = finds(nearbyEducationCentres);
		return elements;
	}
	
	public void scrollToProfessionalServicesImage(){
		scrollToElement(professionalServicesImage, "true");
	}
	
	public WebElement checkMyPropertyBottomSheetTitleLabel() {
		return find(myPropertyBottomSheetTitleLabel);
	}
	
	public WebElement checkPropertyLandSizeImage() {
		return find(propertyLandSizeImage,3);
	}
	
	public WebElement checkAttributeBar() {
		return find(attributeBar,3);
	}
	
	public WebElement checkMyPropertyBottomSheetOwnerOccupierButton() {
		return find(myPropertyBottomSheetOwnerOccupierButton);
	}
	
	public WebElement checkMyPropertyBottomSheetRenterButton() {
		return find(myPropertyBottomSheetRenterButton);
	}
	
	public String getMyPropertyBottomSheetOwnerOccupierButton() {
		return getText(myPropertyBottomSheetOwnerOccupierButton);
	}
	
	public String getMyPropertyBottomSheetRenterButton() {
		return getText(myPropertyBottomSheetRenterButton);
	}
	
	public String getMyPropertyBottomSheetLandLordButton() {
		return getText(myPropertyBottomSheetLandLordButton);
	}
	
	public WebElement checkMyPropertyBottomSheetLandLordButton() {
		return find(myPropertyBottomSheetLandLordButton);
	}
	
	public void tapOutsideOfMyPropertyBottomSheet(){
		tapElement(outsideOfMyPropertyBottomSheet);
	}
	
	public String getMyPropertyBottomSheetTitleLabel() {
		return getText(myPropertyBottomSheetTitleLabel);
	}
	
	public WebElement checkThisIsMyPropertyLabel() {
		return find(thisIsMyPropertyLabel);
	}
	
	public WebElement checkThisIsMyPropertyInfo() {
		return find(thisIsMyPropertyInfo);
	}
	
	public WebElement checkThisIsMyPropertyToggleButton() {
		return find(thisIsMyPropertyToggleButton);
	}
	
	public void tapThisIsMyPropertyToggleButton(){
		tapElement(thisIsMyPropertyToggleButton);
	}
	
	public boolean isToggleButtonSelected(){
		return isSelected(thisIsMyPropertyToggleButton);
	}
	
	public String getThisIsMyPropertyLabel() {
		return getText(thisIsMyPropertyLabel);
	}
	
	public void waitForFullScreenLoadingIndicatorToDisappear() {
		waitForElementToDisappear(imageLoadingIndicator);
	}
	
	public WebElement checkDerivedAssetText() {
		return find(derivedAssetText);
	}
	public WebElement checkSuppliedAssetText() {
		return find(suppliedAssetText);
	}
	
	public WebElement checkEstimatedMarketValueLabel() {
		return find(estimatedMarketValueLabel);
	}
	
	public WebElement checkEstimatedMarketValueinfoButton() {
		return find(estimatedMarketValueinfoButton);
	}
	
	public WebElement checkEstimatedMarketValue() {
		return find(estimatedMarketValue);
	}
	
	public WebElement checkConfidenceLevelLabel() {
		return find(confidenceLevelLabel);
	}
	
	public WebElement checkConfidenceIndicator() {
		return find(confidenceIndicator);
	}
	
	public WebElement checkConfidenceIndicatorInfoButton() {
		return find(confidenceIndicatorInfoButton);
	}
	
	public String getEstimatedMarketValueLabel() {
		return getText(estimatedMarketValueLabel);
	}
	
	public String getEstimatedMarketValue() {
		return getText(estimatedMarketValue);
	}
	
	public String getConfidenceLevelLabel() {
		return getText(confidenceLevelLabel);
	}
	
	public WebElement checkFullScreenPropertyImage() {
		return find(fullScreenPropertyImage);
	}
	
	public WebElement checkFullScreenPropertyAddress() {
		return find(fullScreenPropertyAddress);
	}
	
	public String getFullScreenPropertyAddress() {
		return getText(fullScreenPropertyAddress);
	}
	
	public String getfullScreenImageCounter() {
		return getText(fullScreenImageCounter);
	}
	
	public WebElement checkFullScreenCloseButton() {
		return find(fullScreenCloseButton);
	}
	
	public WebElement checkFullScreenImageCounter() {
		return find(fullScreenImageCounter);
	}
	
	public WebElement checkPropertyImage() {
		return find(propertyImage);
	}
	
	public void tapFullScreenCloseButton() {
		tapElement(fullScreenCloseButton);
	}
	
	public void tapPropertyImage() {
		tapElement(propertyImage);
	}
	
	//Swiping image carousel left in property details
	public void swipeImageCarouselLeft() {
		swipeHorizontally(favouriteButton,backButton);
	}
	
	public void swipeFullScreenImageCarouselLeft() {
		swipeHorizontallyToLeft();
	}
	
	public void swipeFullScreenImageCarouselLeftMultipleTimes() {
			swipeHorizontallyToLeft();
			swipeHorizontallyToLeft();
	}
	
	public void swipeFullScreenImageCarouselRightMultipleTimes() {
		swipeHorizontallyToRight();
		swipeHorizontallyToRight();
	}
	
	public void swipeFullScreenImageCarouselRight() {
		swipeHorizontallyToRight();
	}
	
	public WebElement checkFavouriteButton() {
		return find(favouriteButton);
	}
	
	public WebElement checkBackButton() {
		return find(backButton);
	}
	
	public void tapBackButton(){
		tapElement(backButton);
	}
	
	public String getImageNumberText() {
		return getText(imageNumberText);
	}
	
	public WebElement checkImageNumberText() {
		return find(imageNumberText);
	}
	
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
	
	public WebElement checkPropertyShowMoreDownArrow() {
		return find(propertyShowMoreDownArrow);
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
		return find(propertyNumberOfParkingSpacesImage,3);
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
		return find(propertyNumberOfBathroomsImage,3);
	}
	
	public WebElement checkPropertyNumberOfParkingSpaces() {
		return find(propertyNumberOfParkingSpaces,3);
	}
	
	public WebElement checkPropertyStatePostCode() {
		return find(propertyStatePostCode);
	}
	
	public WebElement checkPropertyNumberOfBedrooms() {
		return find(propertyNumberOfBedrooms,3);
	}
	
	public WebElement checkPropertyNumberOfBedroomsImage() {
		return find(propertyNumberOfBedroomsImage,5);
	}
	
	public WebElement checkPropertyNumberOfBathrooms() {
		return find(propertyNumberOfBathrooms,3);
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
		scrollToElement("SHOW ME INSIGHTS", "text");
	}
	
	public void tapShowMeInsightButton(){
		tapElement(showMeInsightButton);
	}
	
	public WebElement checkShowMeInsightButton() {
		return find(showMeInsightButton);
	}
	
	public WebElement checkMiniMap() {
		return find(miniMap);
	}
	
	public void tapMiniMap(){
		tapElement(miniMap);
	}
	
	
	public WebElement checkMiniMapWhatsNewButton() {
		return find(miniMapWhatsNearButton);
	}
	
	public WebElement checkMiniMapLocationPin() {
		return find(miniMapLocationPin);
	}
	
	public void scrollToWhatsNearButton() {
		scrollToElement(miniMapWhatsNearButton, "true");
	}
	
	public void tapMiniMapWhatsNearbyButton(){
		tapElement(miniMapWhatsNearButton);
	}

	//Swiping image carousel right in property details
	public void swipeImageCarouselRight() {
		swipeHorizontallyToRight();
	}
	
	public void doubleTapOnPropertyImage() {
		doubleTapOnAnElement(fullScreenPropertyImage);
	}
	
	
	
	
}
