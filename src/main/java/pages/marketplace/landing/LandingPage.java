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

	private By landingPageTitle = By.xpath("//android.widget.TextView[@text='One Suncorp']");
	private By chatbotOption = By.id("au.com.suncorp.marketplace:id/chatbotOption");
	private String propertyTitle = "PROPERTY";
	private String vehiclesTitle = "Vehicles";
	private String naviScrollableId = "au.com.suncorp.marketplace:id/navigationTabLayout";
/*
	private By suncorpTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='ONE SUNCORP']");
	private By suncorpTab = By.xpath("//android.widget.TextView[@text='One Suncorp']");
	private By homeTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='PROPERTY']");
	private By vehiclesTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='VEHICLES']");
	private By financeTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='MONEY']");
	private By healthTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='HEALTH']");
*/
	private String vehiclesTabTitle = "Vehicles";
	
	private By suncorpTab = By.xpath("//android.widget.TextView[@text='ONE SUNCORP']");
	private By homeTab = By.xpath("//android.widget.TextView[@text='PROPERTY']");
	private By vehiclesTab = By.xpath("//android.widget.TextView[@text='VEHICLES']");
	private By financeTab = By.xpath("//android.widget.TextView[@text='MONEY']");
	private By financeTabSmallLetters = By.xpath("//android.widget.TextView[@text='Money']");
	private By healthTab = By.xpath("//android.widget.TextView[@text='WELLBEING']");
	 

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
		return find(suncorpTab, 30);
	}

	public void tapSuncorpTab() {
		tapElement(suncorpTab);
	}

	public boolean isSuncorpTabSelected() {
		return isSelected(suncorpTab);
	}

	public WebElement checkHomeTab() {
		return find(homeTab);
	}

	public void tapHomeTab() {
		tapElement(homeTab);
	}

	public void tapPropertyTab() {
		tapElement(scrollHorizontallyToElement(propertyTitle,"text",naviScrollableId));
	}

	public boolean ispropertyTabSelected() {
		String text = getScreenTitle(propertyTitle).getAttribute("selected");
		return Boolean.parseBoolean(text);
	}
	public boolean isHomeTabSelected() {
		return isSelected(homeTab);
	}

	public WebElement checkVehiclesTab() {
		return find(vehiclesTab,30);
	}

	public void tapVehiclesTab() {
		tapElement(getScreenTitle(vehiclesTabTitle));
		//tapElement(scrollHorizontallyToElement(vehiclesTitle,"text",naviScrollableId));
	}

	public boolean isVehiclesTabSelected() {
		return isSelected(vehiclesTabTitle);
		
	}


	public WebElement checkWealthTab() {
		return find(financeTab);
	}

	public void tapWealthTab() {
		tapElement(financeTab);
	}


	public WebElement checkFinanceTab() {
		if (getDeviceAttribute("deviceModel").equals("SM-G935F")) {
			return find(financeTabSmallLetters);
		}else
			return find(financeTab);
	}

	public void tapFinanceTab() {
		if (getDeviceAttribute("deviceModel").equals("SM-G935F")) {
			tapElement(financeTabSmallLetters);
		}else
			tapElement(financeTab);
	}

	public boolean isFinanceTabSelected() {
		if (getDeviceAttribute("deviceModel").equals("SM-G935F")) {
			return isSelected(financeTabSmallLetters);
		}else
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
		swipeHorizontally(vehiclesTab, suncorpTab);
		swipeHorizontally(healthTab, vehiclesTab);
	}	

	public void swipeToSuncorpTab() {
		swipeHorizontally(vehiclesTab, healthTab);
		swipeHorizontally(homeTab, vehiclesTab);
	}
}
