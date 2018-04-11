package pages.marketplace.vehicles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import automation.framework.common.Copy;
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

	//Vehicle Tile Common elements initialisation
	private By vehicleServicesImg = By.id("au.com.suncorp.marketplace:id/vehicleServicesImage");
	private By vehicleServicesTitle = By.id("au.com.suncorp.marketplace:id/vehicleServicesTitle");
	private String vehicleServicesTitleStr = "au.com.suncorp.marketplace:id/vehicleServicesTitle";
	private By vehicleServicesDesc = By.id("au.com.suncorp.marketplace:id/vehicleServicesDescription");
	private By vehicleServicesBtn = By.id("au.com.suncorp.marketplace:id/vehicleServicesButton");
	private String vehicleServicesBtnStr = "au.com.suncorp.marketplace:id/vehicleServicesButton";

	// TODO -> Cannot find this in ANdroid. But its there on iOS
	private By checkClaimStatusButton = By.id("VehicleCell.ClaimLabel");


	//Vehicle tile common elements utilisation
	public WebElement checkVehicleServicesImage() {
		return find(vehicleServicesImg);
	}

	public WebElement checkVehicleServicesTitle() {
		return find(vehicleServicesTitle);
	}

	public String getVehicleServicesTitle() {
		return checkVehicleServicesTitle().getText();
	}

	public WebElement checkVehiclesServicesDesc() {
		return find(vehicleServicesDesc);
	}

	public String getVehiclesServicesDesc() {
		return checkVehiclesServicesDesc().getText();
	}

	public WebElement checkVehiclesServicesBtn() {
		return find(vehicleServicesBtn);
	}

	public String getVehiclesServicesBtnTxt() {
		return checkVehiclesServicesBtn().getText();

	}

	public void tapVehiclesServicesBtn() {
		tapElement(checkVehiclesServicesBtn());
	}

	public void scrollToVechilesTile() {
		scrollToElement(vehicleServicesBtnStr, "id", 10);

	}


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
		waitForElementToDisappear(loadingIndicator);
	}


}
