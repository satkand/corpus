package pages.marketplace.money;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class MoneyTrackerPage extends BasePage{
	
	private By monthLabel = By.id("au.com.suncorp.marketplace:id/monthLabel");
	private By connectedAccounts = By.id("au.com.suncorp.marketplace:id/connectedAccounts");
	private By categoryImage = By.id("au.com.suncorp.marketplace:id/categoryImage");
	private By nameText = By.id("au.com.suncorp.marketplace:id/nameText");
	private By amountText = By.id("au.com.suncorp.marketplace:id/amountText");
	private By categoryCarousel = By.id("au.com.suncorp.marketplace:id/spendingItem");
	
	public MoneyTrackerPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement checkMonthLabel() {
		
		return find(monthLabel,20);
	}

	public WebElement checkCategoryImage() {

		return find(categoryImage);
	}
	
	
	public String getCategoryName(int instance) {

		List<WebElement> categoryNames = finds(nameText);
		
		return categoryNames.get(instance).getText();
			
	}
	
	public String getCategoryAmount(int instance) {

		List<WebElement> categoryNames = finds(amountText);

		return categoryNames.get(instance).getText();

	}
	
	public String getMonthLabel() {

		return getText(checkMonthLabel());

	}
	
	public void tapCategoryCarousel() {
		
		tapElement(categoryCarousel);
		
	}
	
	public void waitForMonthLabelToDisappear() {
		
		waitForElementToDisappear(monthLabel);
	}
	

}
