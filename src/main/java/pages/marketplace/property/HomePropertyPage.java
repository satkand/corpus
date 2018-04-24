package pages.marketplace.property;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;


public class HomePropertyPage extends BasePage {

	public HomePropertyPage(AppiumDriver driver) {
		super(driver);
	}

	private By homeJourneyBannerImage = By.id("au.com.suncorp.marketplace:id/homeJourneyBannerImage");
	private By homeJourneyBannerHeading = By.id("au.com.suncorp.marketplace:id/journeyHeadingText");
	private By homeJourneyBannerDescription = By.id("au.com.suncorp.marketplace:id/journeyDescriptionText");
	private By startYourJourneyButton = By.id("au.com.suncorp.marketplace:id/startHomeJourneyButton");

	private By addAPropertyOrPolicyButton = By.id("au.com.suncorp.marketplace:id/addPropertyOrPolicyActionText");
	private By addAPropertyOrPolicyImage = By.id("au.com.suncorp.marketplace:id/addPropertyOrPolicyImage");
	private By propertyInsightInfo = By.id("au.com.suncorp.marketplace:id/addPropertyOrPolicyInfo1Text");
	private By organiseDocumentsInfo = By.id("au.com.suncorp.marketplace:id/addPropertyOrPolicyInfo2Text");
	private By accessProfessionalInfo = By.id("au.com.suncorp.marketplace:id/addPropertyOrPropertyInfo3Text");

	private By addPropertyOrPolicyActionSheetTitle = By.id("au.com.suncorp.marketplace:id/propertyOrPolicySelectionText");
	private By addPolicyActionSheetButton = By.id("au.com.suncorp.marketplace:id/addPolicyButton");
	private By addPropertyActionSheetButton = By.id("au.com.suncorp.marketplace:id/addPropertyButton");
	
	//Property Assets
	private By activeClaimTitle = By.id("au.com.suncorp.marketplace:id/activeClaimText");
	private By propertyImage = By.id("au.com.suncorp.marketplace:id/propertyImage");
	private By addressLineText = By.id("au.com.suncorp.marketplace:id/addressLine1Text");
	private By suburbText = By.id("au.com.suncorp.marketplace:id/addressLine2Text");
	private By productIcon = By.id("au.com.suncorp.marketplace:id/productIcon");
	private By productDescriptionText = By.id("au.com.suncorp.marketplace:id/productDescriptionText");
	private By brandIcon = By.id("au.com.suncorp.marketplace:id/brandIcon");
	private By propertyDocumentsButton = By.id("au.com.suncorp.marketplace:id/propertyDocumentsButton");
	
	
	private By propertyItem = By.id("au.com.suncorp.marketplace:id/propertyItemLayout");
	private String startYourJourneyButtonID = "au.com.suncorp.marketplace:id/startHomeJourneyButton";
	private By emptyStatePropertyAsset = By.xpath("//android.widget.TextView[@text='456 Sesame St, Melbourne']");
	private By featureLockedMsgTitle = By.id("au.com.suncorp.marketplace:id/alertTitle");
	private By featureLockedTextCopy = By.id("android:id/message");
	private By featureLockedMsgSignUpButton = By.id("android:id/button2");
	private By featureLockedMsgLogInButton = By.id("android:id/button1");
	private By backButton = MobileBy.AccessibilityId("Navigate up");

	private By incomeProtectionTitleText = By.id("au.com.suncorp.marketplace:id/offerTitle");
	private By propertyDetailsButton = By.id("au.com.suncorp.marketplace:id/propertyDetailsButton");
	
	//Virtual Assets
	private By virtualAssetsTitleTxt = By.id("au.com.suncorp.marketplace:id/propertyCarouselTitle");
	private By virtualAssetImage = By.id("au.com.suncorp.marketplace:id/propertyImage");
	private By virtualAssetEstimatedSalesPriceLabel= By.id("au.com.suncorp.marketplace:id/priceTitleText");
	private By virtualAssetSalesPrice = By.id("au.com.suncorp.marketplace:id/priceRangeText");
	private By virtualAssetAddress = By.id("au.com.suncorp.marketplace:id/propertyAddressText");
	private By virtualAssetBedroomIcon = By.id("au.com.suncorp.marketplace:id/bedroomIcon");
	private By virtualAssetNoOFBedrooms = By.id("au.com.suncorp.marketplace:id/bedroomCountText");
	private By virtualAssetNoOFBathrooms = By.id("au.com.suncorp.marketplace:id/bathroomCountText");
	private By virtualAssetNoOFCarParks = By.id("au.com.suncorp.marketplace:id/carparkCountText");
	private By virtualAssetLandSize= By.id("au.com.suncorp.marketplace:id/landSizeText");
	private By virtualAssetViewDetailsButton = By.id("au.com.suncorp.marketplace:id/propertyDetailsButton");
	
	public void scrollToVirtualAssetsCarousel(){
		scrollToElement(incomeProtectionTitleText);
			
	}
	
	public WebElement checkVirtualAssetsTitleTxt() {
		return find(virtualAssetsTitleTxt);
	}
	
	public String getVirtualAssetsTitleTxt() {
		return getText(virtualAssetsTitleTxt);
	}
	
	public WebElement checkVirtualAssetImage() {
		return find(virtualAssetImage);
	}
	
	public WebElement checkVirtualAssetEstimatedSalesPriceLabel() {
		return find(virtualAssetEstimatedSalesPriceLabel);
	}
	
	public String getVirtualAssetEstimatedSalesPriceLabel() {
		return getText(virtualAssetEstimatedSalesPriceLabel);
	}
	
	public WebElement checkVirtualAssetSalePrice() {
		return find(virtualAssetSalesPrice);
	}
	
	public String getVirtualAssetSalePrice() {
		return getText(virtualAssetSalesPrice);
	}
	
	public WebElement checkVirtualAssetAddress() {
		return find(virtualAssetAddress);
	}
	
	public String getVirtualAssetAddress() {
		return getText(virtualAssetAddress);
	}
	
	public WebElement checkVirtualAssetBedroomIcon() {
		return find(virtualAssetBedroomIcon);
	}
	
	public WebElement checkVirtualAssetNoOFBedrooms() {
		return find(virtualAssetNoOFBedrooms);
	}
	
	public String getVirtualAssetNoOFBedrooms() {
		return getText(virtualAssetNoOFBedrooms);
	}
	
	public WebElement checkVirtualAssetNoOFBathrooms() {
		return find(virtualAssetNoOFBathrooms);
	}
	
	public String getVirtualAssetNoOFBathrooms() {
		return getText(virtualAssetNoOFBathrooms);
	}
	
	public WebElement checkVirtualAssetNoOFCarParks() {
		return find(virtualAssetNoOFCarParks);
	}
	
	public String getVirtualAssetNoOFCarParks() {
		return getText(virtualAssetNoOFCarParks);
	}
	
	public WebElement checkVirtualAssetLandSize() {
		return find(virtualAssetLandSize);
	}
	
	public String getVirtualAssetLandSize() {
		return getText(virtualAssetLandSize);
	}
	
	public WebElement checkVirtualAssetViewDetailsButton() {
		return find(virtualAssetViewDetailsButton);
	}
	
	public void tapPropertyImage() {
		tapElement(propertyImage);
	}
	
	public void tapVirtualAssetViewDetailsButton() {
		tapElement(virtualAssetViewDetailsButton);
	}
	
	public void tapAddressLineText() {
		tapElement(addressLineText);
	}
	
	public WebElement checkPropertyDetailsButton() {
		return find(propertyDetailsButton);
	}
	
	public void tapPropertyDetailsButton() {
		tapElement(propertyDetailsButton);
	}
	
	public WebElement checkPropertyDocumentsButton() {
		return find(propertyDocumentsButton);
	}
	
	public void tapPropertyDocumentsButton() {
		tapElement(propertyDocumentsButton);
	}
	
	public WebElement checkBackButton() {
		return find(backButton);
	}

	public void tapBackButton() {
		tapElement(backButton);
	}
	
	public WebElement checkFeatureLockedMsgTitle() {
		return find(featureLockedMsgTitle);
	}

	public String getFeatureLockedMsgTitle() {
		return getText(featureLockedMsgTitle);
	}

	public WebElement checkFeatureLockedTextCopy() {
		return find(featureLockedTextCopy);
	}

	public String getFeatureLockedTextCopy() {
		return getText(featureLockedTextCopy);
	}

	public WebElement checkFeatureLockedMsgSignUpButton() {
		return find(featureLockedMsgSignUpButton);
	}

	public WebElement checkFeatureLockedMsgLogInButton() {
		return find(featureLockedMsgLogInButton);
	}

	public List<String> fetchProductDescriptionTextList() {
		return getTextList(productDescriptionText);
	}

	public String getAddressLineText() {
		return getText(addressLineText);
	}

	public String getSuburbTextList() {
		return getText(suburbText);
	}

	public WebElement checkbrandIcon() {
		return find(brandIcon);
	}

	public WebElement checkproductDescriptionText() {
		return find(productDescriptionText);
	}

	public String getproductDescriptionText() {
		return getText(productDescriptionText);
	}

	public WebElement checkproductIcon() {
		return find(productIcon);
	}

	public WebElement checksuburbText() {
		return find(suburbText);
	}

	public String getsuburbText() {
		return getText(suburbText);
	}

	public WebElement checkaddressLineText() {
		return find(addressLineText);
	}

	public String getaddressLineText() {
		return getText(addressLineText);
	}

	public WebElement checkpropertyImage() {
		return find(propertyImage);
	}

	public WebElement checkactiveClaimTitle() {
		return find(activeClaimTitle);
	}

	public String getactiveClaimTitle() {
		return getText(activeClaimTitle);
	}

	public WebElement checkAddPropertyOrPolicyActionSheetTitle() {
		return find(addPropertyOrPolicyActionSheetTitle);
	}

	public String getAddPropertyOrPolicyActionSheetTitle() {
		return getText(addPropertyOrPolicyActionSheetTitle);
	}

	public WebElement checkAddPolicyActionSheetButton() {
		return find(addPolicyActionSheetButton);
	}

	public String getAddPolicyActionSheetButton() {
		return getText(addPolicyActionSheetButton);
	}

	public void tapAddPolicyActionSheetButton() {
		tapElement(addPolicyActionSheetButton);
	}

	public WebElement checkAddPropertyActionSheetButton() {
		return find(addPropertyActionSheetButton);
	}

	public String getAddPropertyActionSheetButton() {
		return getText(addPropertyActionSheetButton);
	}

	public void tapAddPropertyActionSheetButton() {
		tapElement(addPropertyActionSheetButton);
	}

	public WebElement checkAddAPropertyOrPolicyImage() {
		return find(addAPropertyOrPolicyImage);
	}

	public WebElement checkPropertyInsightInfo() {
		return find(propertyInsightInfo);
	}

	public String getPropertyInsightInfo() {
		return getText(propertyInsightInfo);
	}

	public WebElement checkOrganiseDocumentsInfo() {
		return find(organiseDocumentsInfo);
	}

	public String getOrganiseDocumentsInfo() {
		return getText(organiseDocumentsInfo);
	}

	public WebElement checkAccessProfessionalInfo() {
		return find(accessProfessionalInfo);
	}

	public String getAccessProfessionalInfo() {
		return getText(accessProfessionalInfo);
	}

	public void tapAddAPropertyOrPolicyButton() {
		scrollToElement(addAPropertyOrPolicyButton, "true");
		tapElement(addAPropertyOrPolicyButton);
	}

	public WebElement checkAddAPropertyOrPolicyButton() {
		return find(addAPropertyOrPolicyButton);
	}

	public String getAddAPropertyOrPolicyButton() {
		return getText(addAPropertyOrPolicyButton);
	}

	public void scrollToJourneyBanner(){
		scrollToElement(startYourJourneyButton, "true");
	}

	public void scrollToSuppliedAsset(){
		scrollToElement(emptyStatePropertyAsset, "true");
	}
	
	public WebElement checkHomeJourneyBannerImage() {
		return find(homeJourneyBannerImage);
	}

	public String getHomeJourneyBannerHeading() {
		return getText(homeJourneyBannerHeading);
	}

	public String getHomeJourneyBannerDescription() {
		return getText(homeJourneyBannerDescription);
	}

	public WebElement checkStartYourJourneyButton() {
		return find(startYourJourneyButton);
	}

	public void tapStartYourJourneyButton() {
		tapElement(startYourJourneyButton);
	}

	public void scrollToEmptyStatePropertyAsset() {
		scrollToElement(emptyStatePropertyAsset, "true");

	}
	
	public void swipePropertyCarouselLeft() {
		scrollHorizontallyToElement("7000m²","text","au.com.suncorp.marketplace:id/propertyViewPager",1);
	}
	
	public void swipePropertyCarouselRight() {
		scrollHorizontallyToElement("1000m²","text","au.com.suncorp.marketplace:id/propertyViewPager",1);
	}

}
