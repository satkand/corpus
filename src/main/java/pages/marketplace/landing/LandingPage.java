package pages.marketplace.landing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class LandingPage extends BasePage {

	public LandingPage(AppiumDriver driver) {
		super(driver);
	}

	private By landingPageTitle = By.xpath("//android.widget.TextView[@text='One Suncorp']");
	private By chatbotOption = By.id("au.com.suncorp.marketplace:id/chatbotOption");
	
	private By suncorpTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='One Suncorp']");
	private By homeTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='Property']");
	private By vehiclesTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='Vehicles']");
	private By wealthTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='Wealth']");
	private By healthTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='Health']");
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
	
	public boolean isHomeTabSelected() {
		return isSelected(homeTab);
	}
	
	public WebElement checkVehiclesTab() {
		return find(vehiclesTab);
	}
	
	public void tapVehiclesTab() {
		tapElement(vehiclesTab);
	}
	
	public boolean isVehiclesTabSelected() {
		return isSelected(vehiclesTab);
	}
	
	public WebElement checkWealthTab() {
		return find(wealthTab);
	}
	
	public void tapWealthTab() {
		tapElement(wealthTab);
	}
	
	public boolean isWealthTabSelected() {
		return isSelected(wealthTab);
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
