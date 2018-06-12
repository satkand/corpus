package pages.marketplace.landing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class LandingPage extends BasePage {

	public LandingPage(AppiumDriver driver) {
		super(driver);
	}

	private By landingPageTitle = By.xpath("//android.widget.TextView[@text='Suncorp App']");
	private By chatbotOption = By.id("au.com.suncorp.marketplace:id/chatbotOption");
	private String naviScrollableId = "au.com.suncorp.marketplace:id/navigationTabLayout";
	private By overViewTab = By.xpath("//android.widget.TextView[@text='Overview']");
	
    private By homeTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='PROPERTY']");
	private By homeTabSmallSamsung = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='Property']");
	
	private By vehiclesTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='VEHICLE']");
	private By financeTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='MONEY']");

	private String propertyTitle = "Property";
	private String vehiclesTitle = "Vehicle";
	private By healthTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='WELLBEING']");

	/*
	private By suncorpTab = By.xpath("//android.widget.TextView[@text='ONE SUNCORP']");
	private By homeTab = By.xpath("//android.widget.TextView[@text='HOME']");
	private By vehiclesTab = By.xpath("//android.widget.TextView[@text='VEHICLES']");
	private By wealthTab = By.xpath("//android.widget.TextView[@text='WEALTH']");
	private By healthTab = By.xpath("//android.widget.TextView[@text='HEALTH']");
	 */

	public WebElement checkLandingPageTitle() {
		return find(landingPageTitle, 20);
	}
	
	public WebElement checkChatbotOption() {
		return find(chatbotOption, 20);
	}

	public void tapChatbotOption(){
		tapElement(chatbotOption);
	}

	public WebElement checkSuncorpTab() {
		return find(overViewTab, 30);
	}

	public void tapSuncorpTab() {
		tapElement(overViewTab);
	}

	public boolean isSuncorpTabSelected() {
		return isSelected(overViewTab);
	}

	public WebElement checkHomeTab() {
		if(find(homeTabSmallSamsung)!=null) {
			return find(homeTabSmallSamsung);
		}else {
			return find(homeTab);
		}
	}

	public void tapHomeTab() {
		if(find(homeTabSmallSamsung)!=null) {
			tapElement(homeTabSmallSamsung);
		}else {
			tapElement(homeTab);
		}
	}

	public void tapPropertyTab() {
		String text = getScreenTitle(propertyTitle).getText();
		tapElement(scrollHorizontallyToElement(text,"text",naviScrollableId));
	}

	public boolean ispropertyTabSelected() {
		String text = getScreenTitle(propertyTitle).getAttribute("selected");
		return Boolean.parseBoolean(text);
	}
	public boolean isHomeTabSelected() {
		if(find(homeTabSmallSamsung)!=null) {
			return isSelected(homeTabSmallSamsung);
		}else {
			return isSelected(homeTab);
		}
	}

	public WebElement checkVehiclesTab() {
		return find(vehiclesTab,30);
	}

	public void tapVehiclesTab() {
		tapElement(getScreenTitle(vehiclesTitle));
	}
   
	public boolean isVehiclesTabSelected() {
		return isSelected(vehiclesTitle);
		
	}

	public WebElement checkWealthTab() {
		return find(financeTab);
	}

	public void tapWealthTab() {
		tapElement(financeTab);
	}

	public WebElement checkFinanceTab() {
		return find(financeTab);
	}

	public void tapFinanceTab() {
		tapElement(financeTab);
	}

	public boolean isFinanceTabSelected() {
		return isSelected(financeTab);
	}

	public WebElement checkHealthTab() {
		return find(healthTab);
	}

	public void tapHealthTab() {
		tapElement(healthTab);
	}

	public boolean isHealthTabSelected() {
		return isSelected(healthTab);
	}

	public void swipeToHealthTab() {
		swipeHorizontally(vehiclesTab, overViewTab);
		swipeHorizontally(healthTab, vehiclesTab);
	}	

	public void swipeToSuncorpTab() {
		swipeHorizontally(vehiclesTab, healthTab);
		swipeHorizontally(homeTab, vehiclesTab);
	}
}
