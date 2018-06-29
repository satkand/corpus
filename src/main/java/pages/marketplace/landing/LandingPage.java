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
	//private By overViewTab = By.xpath("//android.widget.TextView[@text='Overview']");
	//private By overViewTab = By.xpath("//android.widget.TextView[@text='Overview']");
	private By overViewTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='OVERVIEW']");
	private By overViewTabSmallCase = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='Overview']");
    
	private By homeTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='PROPERTY']");
	private By homeTabSmallSamsung = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='Property']");
	
	private By vehiclesTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='VEHICLE']");
	private By vehiclesTabSmallCase = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='Vehicle']");
	
	private By financeTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='MONEY']");
	private By financeTabSmallCase = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='Money']");

	private By healthTab = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='WELLBEING']");
	private By healthTabSmallCase = By.xpath("//android.widget.HorizontalScrollView[@resource-id='au.com.suncorp.marketplace:id/navigationTabLayout']//android.widget.TextView[@text='Wellbeing']");

	private String overviewTitle = "Overview";
	private String propertyTitle = "Property";
	private String vehiclesTitle = "Vehicle";
	private String financeTitle = "Money";
	private String moneyTitle = "Money";
	private String healthTitle = "Wellbeing";

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
		if(find(overViewTabSmallCase)!=null) {
			return find(overViewTabSmallCase);
		}else {
			return find(overViewTab);
		}
	}

	public void tapSuncorpTab() {
		if(find(overViewTabSmallCase)!=null) {
			tapElement(overViewTabSmallCase);
		}else {
			tapElement(overViewTab);
		}
	}

	public boolean isSuncorpTabSelected() {
		/*
		By element = overViewTabSmallCase;
		if(find(element)!=null) {
			return isSelected(overViewTabSmallCase);
		}else {
			return isSelected(overViewTab);
		}
		*/
		String text = getScreenTitle(overviewTitle).getAttribute("selected");
		return Boolean.parseBoolean(text);
	}
	
	public WebElement checkOverViewTab() {
		WebElement element = find(overViewTabSmallCase);
		if(element!=null) {
			return element;
		}else {
			return find(overViewTab);
		}
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
		if(find(vehiclesTabSmallCase)!=null) {
			return find(vehiclesTabSmallCase, 30);
		}else {
			return find(vehiclesTab, 30);
		}
	}

	public void tapVehiclesTab() {
		if(find(vehiclesTabSmallCase)!=null) {
			tapElement(vehiclesTabSmallCase);
		}else {
			tapElement(vehiclesTab);
		}
	}
   
	public boolean isVehiclesTabSelected() {
		/*
		if(find(vehiclesTabSmallCase)!=null) {
			return isSelected(vehiclesTabSmallCase);
		}
		else {
			return isSelected(vehiclesTab);
		}
		*/
		String text = getScreenTitle(vehiclesTitle).getAttribute("selected");
		return Boolean.parseBoolean(text);		
	}

	public WebElement checkWealthTab() {
		if(find(financeTabSmallCase)!=null) {
			return find(financeTabSmallCase);
		}else {
			return find(financeTab);
		}
	}

	public void tapWealthTab() {
		if(find(financeTabSmallCase)!=null) {
			tapElement(financeTabSmallCase);
		}else {
			tapElement(financeTab);
		}
	}

	public WebElement checkFinanceTab() {
		if(find(financeTabSmallCase)!=null) {
			return find(financeTabSmallCase);
		}else {
			return find(financeTab);
		}
	}

	public void tapFinanceTab() {
		if(find(financeTabSmallCase)!=null) {
			tapElement(financeTabSmallCase);
		}else {
			tapElement(financeTab);
		}
	}

	public boolean isFinanceTabSelected() {
		String text = getScreenTitle(financeTitle).getAttribute("selected");
		return Boolean.parseBoolean(text);	
	}

	public WebElement checkHealthTab() {
		if(find(healthTabSmallCase)!=null) {
			return find(healthTabSmallCase);
		}else {
			return find(healthTab);
		}
	}

	public void tapHealthTab() {
		if(find(healthTabSmallCase,30)!=null) {
			tapElement(healthTabSmallCase);
		}else {
			tapElement(healthTab);
		}
	}

	public boolean isHealthTabSelected() {
		String text = getScreenTitle(healthTitle).getAttribute("selected");
		return Boolean.parseBoolean(text);	
	}

	public void swipeToHealthTab() {
		/*
		WebElement element = find(overViewTabSmallDevices,10);
		if(element==null) {
			swipeHorizontally(vehiclesTab, overViewTab);
		}
		else {
			swipeHorizontally(vehiclesTab, overViewTabSmallDevices);
		}
		swipeHorizontally(healthTab, vehiclesTab);
		*/
		
		if(find(vehiclesTabSmallCase, 30)!=null) {
			swipeHorizontally(vehiclesTabSmallCase, overViewTabSmallCase);
			swipeHorizontally(healthTabSmallCase, vehiclesTabSmallCase);
		} else {
			swipeHorizontally(vehiclesTab, overViewTab);
			swipeHorizontally(healthTab, vehiclesTab);
		}

	}	

	public void swipeToSuncorpTab() {
		if(find(vehiclesTabSmallCase, 30)!=null) {
			swipeHorizontally(vehiclesTabSmallCase, healthTabSmallCase);
			swipeHorizontally(homeTabSmallSamsung, vehiclesTabSmallCase);
		} else {
			swipeHorizontally(vehiclesTab, healthTab);
			swipeHorizontally(homeTab, vehiclesTab);
		}
	}

	public WebElement checkMoneyTab() {
		return getScreenTitle(moneyTitle);
	}

	public void tapMoneyTab() {
		tapElement(checkMoneyTab());
	}


}

