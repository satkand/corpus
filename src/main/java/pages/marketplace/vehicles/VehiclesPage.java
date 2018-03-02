package pages.marketplace.vehicles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class VehiclesPage extends BasePage {

	public VehiclesPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By vehicleTypeImage = By.id("au.com.suncorp.marketplace:id/vehicleTypeImage");
	private By addPhotoButton = By.id("au.com.suncorp.marketplace:id/vehicleTakePhotoImage");
	private By vehicleDescription = By.id("au.com.suncorp.marketplace:id/insuredDescriptionText");
	private By vehicleRegistrationNumber = By.id("au.com.suncorp.marketplace:id/registrationNumberText");
	private By viewDetailsButton = By.id("au.com.suncorp.marketplace:id/viewDetailsButton");
	private By loadingIndicator = By.id("au.com.suncorp.marketplace:id/vehicleLoadingIndicator");

	// TODO -> Cannot find this in ANdroid. But its there on iOS
	private By checkClaimStatusButton = By.id("VehicleCell.ClaimLabel");

	public List<WebElement> fetchVehicleTypeImageList(){
		return finds(vehicleTypeImage);
	}
	
	public List<WebElement> fetchAddPhotoButtons(){
		return finds(addPhotoButton);
	}
	
	public List<String> fetchVehicleDescriptionList(){
		return getTextList(vehicleDescription);
	}
	
	public List<String> fetchVehicleRegistrationNumberList(){
		return getTextList(vehicleRegistrationNumber);
	}
	
	public List<WebElement> fetchCheckClaimStatusButtons(){
		return finds(checkClaimStatusButton);
	}
	
	public List<WebElement> fetchViewDetailsButtons(){
		return finds(viewDetailsButton);
	}
	
	public WebElement checkViewDetailsButton() {
		return find(viewDetailsButton);
	}

	public void tapViewDetailsButton() {
		tapElement(viewDetailsButton);
	}
	
	public void waitForDataToLoad() {
		waitForLoadingIndicatorToDismiss(loadingIndicator);
	}
	
}
