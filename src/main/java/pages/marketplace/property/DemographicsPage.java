package pages.marketplace.property;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class DemographicsPage extends BasePage{

	public DemographicsPage(AppiumDriver driver) {
		super(driver);
	}
	
	//common emelemts
	private By goToNextPageArrow=  By.id("au.com.suncorp.marketplace:id/carouselForward");
	private By goToPreviousPageArrow=  By.id("au.com.suncorp.marketplace:id/carouselBack");
	private By backButton=  MobileBy.AccessibilityId("Navigate up");
	private By demographicsTitle=  By.xpath("//android.widget.TextView[@text='Demographics']");
	
	//Family Composition
	private By catTitle = By.id("au.com.suncorp.marketplace:id/categoryTitle");
	private By catSuburb = By.id("au.com.suncorp.marketplace:id/suburbText");
	private By familyCompDesc=  By.id("au.com.suncorp.marketplace:id/categorySubtitle");
	private By familyCompCatLabel=  By.id("au.com.suncorp.marketplace:id/graphTitle");
	private By familyCompCatValue=  By.id("au.com.suncorp.marketplace:id/graphPercentageText");
	private By familyCompCatBar=  By.id("au.com.suncorp.marketplace:id/barGraph");
	
	public WebElement checkdemographicsTitle() {
		return find(demographicsTitle);
	}
	
	public String getdemographicsTitle() {
		return getText(demographicsTitle);
	}
	
	public WebElement checkfamilyCompCat3Bar() {
		return checkElement(familyCompCatBar,2);
	}
	
	public String getfamilyCompCat3Bar() {
		return getValue(familyCompCatBar,2);
	}
	
	public WebElement checkfamilyCompCat3Value() {
		return checkElement(familyCompCatValue,2);
	}
	
	public String getfamilyCompCat3Value() {
		return getValue(familyCompCatValue,2);
	}
	
	public WebElement checkfamilyCompCat3Label() {
		return checkElement(familyCompCatLabel,2);
	}
	
	public String getfamilyCompCat3Label() {
		return getValue(familyCompCatLabel,2);
	}
	
	public WebElement checkfamilyCompCat2Bar() {
		return checkElement(familyCompCatBar,1);
	}
	
	public String getfamilyCompCat2Bar() {
		return getValue(familyCompCatBar,1);
	}
	
	public WebElement checkfamilyCompCat2Value() {
		return checkElement(familyCompCatValue,1);
	}
	
	public String getfamilyCompCat2Value() {
		return getValue(familyCompCatValue,1);
	}
	
	public WebElement checkfamilyCompCat2Label() {
		return checkElement(familyCompCatLabel,1);
	}
	
	public String getfamilyCompCat2Label() {
		return getValue(familyCompCatLabel,1);
	}
	
	public String getValue(By locator, int count) {
		List<WebElement> itemListElements = finds(locator);
		return itemListElements.get(count).getText().toString();
	}
	
	public WebElement checkElement(By locator, int count) {
		List<WebElement> itemListElements = finds(locator);
		return itemListElements.get(count);
	}
	
	public WebElement checkfamilyCompCat1Bar() {
		return checkElement(familyCompCatBar,0);
	}
	
	public String getfamilyCompCat1Bar() {
		return getValue(familyCompCatBar,0);
	}
	
	public WebElement checkfamilyCompCat1Value() {
		return checkElement(familyCompCatValue,0);
	}
	
	public String getfamilyCompCat1Value() {
		return getValue(familyCompCatValue,0);
	}
	
	public WebElement checkfamilyCompCat1Label() {
		return checkElement(familyCompCatLabel,0);
	}
	
	public String getfamilyCompCat1Label() {
		return getValue(familyCompCatLabel,0);
	}
	
	
	public WebElement checkfamilyCompDesc() {
		return find(familyCompDesc);
	}
	
	public String getfamilyCompDesc() {
		return getText(familyCompDesc);
	}
	
	public WebElement checkfamilyCompSuburb() {
		return find(catSuburb);
	}
	
	public String getfamilyCompSuburb() {
		return getText(catSuburb);
	}
	
	public WebElement checkfamilyCompTitle() {
		return find(catTitle);
	}
	
	public String getfamilyCompTitleTitle() {
		return getText(catTitle);
	}
	
	public WebElement checkoccupancyTypeSuburb() {
		return find(catSuburb);
	}
	
	public String getoccupancyTypeSuburb() {
		return getText(catSuburb);
	}
	
	public WebElement checkoccupancyTypeTitle() {
		return find(catTitle);
	}
	
	public String getoccupancyTypeTitle() {
		return getText(catTitle);
	}
	
	public WebElement checkAgesSuburb() {
		return find(catSuburb);
	}
	
	public String getAgesSuburb() {
		return getText(catSuburb);
	}
	
	public WebElement checkAgesTitle() {
		return find(catTitle);
	}
	
	public String getAgesTitle() {
		return getText(catTitle);
	}

	public WebElement checktravelSuburb() {
		return find(catSuburb);
	}
	
	public String gettravelSuburb() {
		return getText(catSuburb);
	}
	
	public WebElement checktravelTitle() {
		return find(catTitle);
	}
	
	public String gettravelTitle() {
		return getText(catTitle);
	}
	
	public WebElement checkincomeSuburb() {
		return find(catSuburb);
	}
	
	public String getincomeSuburb() {
		return getText(catSuburb);
	}
	
	public WebElement checkincomeTitle() {
		return find(catTitle);
	}
	
	public String getincomeTitle() {
		return getText(catTitle);
	}	
	
	public WebElement checkbackButton() {
		return find(backButton);
	}

	public void tapbackButton() {
		tapElement(backButton);
	}
	
	public WebElement checkgoToNextPageArrow() {
		return find(goToNextPageArrow);
	}
	
	public WebElement checkgoToPreviousPageArrow() {
		return find(goToPreviousPageArrow);
	}

	public void tapgoToPreviousPageArrow() {
		tapElement(goToPreviousPageArrow);
	}
	
	public void tapgoToNextPageArrow() {
		tapElement(goToNextPageArrow);
	}
	
	public void swipeFullScreenImageCarouselLeft() {
		swipeHorizontallyToLeft();
	}
	
	public void swipeFullScreenImageCarouselRight() {
			swipeHorizontallyToRight();
	}
	

}
