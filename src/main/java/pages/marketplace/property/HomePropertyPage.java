package pages.marketplace.property;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileBy;
import pages.marketplace.common.WebviewPage;

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
	
	private By activeClaimTitle = By.id("au.com.suncorp.marketplace:id/activeClaimText");
	private By propertyImage = By.id("au.com.suncorp.marketplace:id/propertyImage");
	private By addressLineText = By.id("au.com.suncorp.marketplace:id/addressLine1Text");
	private By suburbText = By.id("au.com.suncorp.marketplace:id/addressLine2Text");
	private By productIcon = By.id("au.com.suncorp.marketplace:id/productIcon");
	private By productDescriptionText = By.id("au.com.suncorp.marketplace:id/productDescriptionText");
	private By brandIcon = By.id("au.com.suncorp.marketplace:id/brandIcon");
	private By propertyItem = By.id("au.com.suncorp.marketplace:id/propertyItemLayout");
	private By emptyStatePropertyAsset = By.xpath("//android.widget.TextView[@text='456 Sesame St, Melbourne']");
	private By featureLockedMsgTitle = By.id("au.com.suncorp.marketplace:id/alertTitle");
	private By featureLockedTextCopy = By.id("android:id/message");
	private By featureLockedMsgSignUpButton = By.id("android:id/button2");
	private By featureLockedMsgLogInButton = By.id("android:id/button1");
	private By backButton = MobileBy.AccessibilityId("Navigate up");
	

	//Articles carousel elements initialization --Start--
	
	private By articleCarousel =	By.id("au.com.suncorp.marketplace:id/articleCarouselTitle");
	private By articleCarouselDesc = By.id("au.com.suncorp.marketplace:id/articleCarouselDescription");
	private By articleImage = By.id("au.com.suncorp.marketplace:id/articleImage");
	//private By articleReadMoreBtn = By.id("au.com.suncorp.marketplace:id/articleReadMoreButton");
	private By articleReadMoreBtn = By.id("au.com.suncorp.marketplace:id/articleReadMoreAction");
	private By articleTitle = By.id("au.com.suncorp.marketplace:id/articleTitle");
	private By articleDesc = By.id("au.com.suncorp.marketplace:id/articleDescription");
		
	//Articles carousel elements initialization --End--
	public WebElement checkBackButton() {
		return find(backButton);
	}
	
	public void tapBackButton() {
		tapElement(backButton);
	}
		
	//Article carousel elements utilization --Start
	public WebElement checkArticleImage() {
		return find(articleImage, 2);
	}
		
	public WebElement checkArticleReadMoreBtn() {
		return find(articleReadMoreBtn, 2);
	}

	public void tapArticleReadMoreBtn() {
		tapElement(articleReadMoreBtn);
	}

	public WebElement checkArticleTitleElement() {
		return find(articleTitle, 2);
	}

	public String verifyArticleTitle() {
		return find(articleTitle, 5).getText();
	}

	public WebElement checkArticleDescElement() {
		return find(articleDesc, 2);
	}

	public String verifyArticleDescription() {
		return find(articleDesc, 2).getText();
	}

	public void swipeArticlesLeft() {
		swipeHorizontallyToLeft();
	}

	public void swipeArticlesRight() {
		swipeHorizontallyToRight();
	}

	public void scrollToArticles() {
		scrollToElement(articleCarousel, "true");
	}

	public void scrollToArticlesReadMoreBtn() {
		scrollToElement(articleReadMoreBtn,"true");
	}

	public WebElement checkArticleCarousel() {
		return find(articleCarousel,2);
	}

	public String getArticleCarouselText() {
		return getText(articleCarousel);
	}

	public WebElement checkArticleCarousalDescr() {
		return find(articleCarouselDesc, 1);
	}

	public String verifyArticleCarousalDescr() {
		return find(articleCarouselDesc, 1).getText();
	}
	//Article carousel elements utilization --End
	
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
		find(productDescriptionText);
		return getTextList(productDescriptionText);
	}
	
	public String getAddressLineText() {
		find(addressLineText);
		return getText(addressLineText);
	}
	
	public String getSuburbTextList() {
		find(suburbText);
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

}
