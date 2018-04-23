package pages.marketplace.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class FAPISettingsPage extends BasePage {
	
	
	public FAPISettingsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By userHasPropertiesToggle = By.id("au.com.suncorp.marketplace:id/hasPropertiesToggle");
	private By userHasBankAccounts = By.id("au.com.suncorp.marketplace:id/hasAccountsToggle");
	private By claimNumberEditText = By.id("au.com.suncorp.marketplace:id/claimNumberEditText");
	private By goToClaimDetailsButton = By.id("au.com.suncorp.marketplace:id/goToClaimDetailsButton");
	private By propertyClaimLodgementButton = By.id("au.com.suncorp.marketplace:id/propertyClaimLodgementButton");
	private By vehicleClaimLodgementButton = By.id("au.com.suncorp.marketplace:id/vehicleClaimLodgementButton");
	private By propertyBrandSpinnerButton = By.id("au.com.suncorp.marketplace:id/propertyBrandSpinner");
	private By vehicleBrandSpinnerButton = By.id("au.com.suncorp.marketplace:id/vehicleBrandSpinner");
	private String propertyClaimLodgementButtonString="au.com.suncorp.marketplace:id/propertyClaimLodgementButton";
	private String vehicleClaimLodgementButtonString ="au.com.suncorp.marketplace:id/vehicleClaimLodgementButton";
	
	public void tapUserHasPropertiesToggle() {
		tapElement(userHasPropertiesToggle);
	}
	public void tapPropertyBrandSpinnerButton() {
		tapElement(propertyBrandSpinnerButton);
	}
	public WebElement checkUserHasPropertiesToggle() {
		return find(userHasPropertiesToggle);
	}
	
	public void tapUserHasBankAccounts() {
		tapElement(userHasBankAccounts);
	}
	
	public WebElement checkUserHasBankAccounts() {
		return find(userHasBankAccounts);
	}
	
	public void tapClaimNumberEditText() {
		tapElement(userHasPropertiesToggle);
	}
	
	public void tapGoToClaimDetailsButton() {
		tapElement(goToClaimDetailsButton);
	}
	
	public void enterClaimNumber(String inputValue) {
		typeValue(inputValue, claimNumberEditText);
	}
	public void navigateToClaimDetails(String claimNumber) {
			
		enterClaimNumber(claimNumber);
		tapGoToClaimDetailsButton();
				
	}

	public void tapPropertyClaimLodgementButton() {
		
		tapElement(scrollToElement(propertyClaimLodgementButtonString,"id"));
	}
	
   public void tapVehicleClaimLodgementButton() {
		
		tapElement(scrollToElement(vehicleClaimLodgementButtonString,"id"));
	}
   public void scrollToVehicleClaimLodgementButton() {
		
		scrollToElement(vehicleClaimLodgementButtonString,"id");
	}
   
   public void selectPropertyBrand(String brand){
	   
	   tapElement(propertyBrandSpinnerButton);
	   tapElement(findByUIAutomator(brand, "text"));
   }
   public void selectVehicleBrand(String brand){
	   
	   tapElement(vehicleBrandSpinnerButton);
	   tapElement(findByUIAutomator(brand, "text"));
   }
}
