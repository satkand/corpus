package pages.marketplace.vehicles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.framework.common.BasePage;
import automation.framework.common.Copy;
import io.appium.java_client.AppiumDriver;

public class VehiclesPage extends BasePage {

	public VehiclesPage(AppiumDriver driver) {
		super(driver);
	}

	private By vehicleTypeImage = By.id("au.com.suncorp.marketplace:id/vehicleTypeImage");
	private By addPhotoButton = By.id("au.com.suncorp.marketplace:id/vehicleTakePhotoImage");
	private By vehicleDescription = By.id("au.com.suncorp.marketplace:id/insuredDescriptionText");
	private By vehicleRegistrationNumber = By.id("au.com.suncorp.marketplace:id/registrationNumberText");
	private By viewDetailsButton = By.id("au.com.suncorp.marketplace:id/viewDetailsButton");
	private By loadingIndicator = By.id("au.com.suncorp.marketplace:id/vehicleLoadingIndicator");

	//Vehicle Tile Common elements initialization
	private By vehicleServicesImg = By.id("au.com.suncorp.marketplace:id/vehicleServicesImage");
	private By vehicleServicesTitle = By.id("au.com.suncorp.marketplace:id/vehicleServicesTitle");
	private String vehicleServicesTitleId = "au.com.suncorp.marketplace:id/vehicleServicesTitle";
	private By vehicleServicesDesc = By.id("au.com.suncorp.marketplace:id/vehicleServicesDescription");
	private String vehicleServicesDescId = "au.com.suncorp.marketplace:id/vehicleServicesDescription";
	private By vehicleServicesBtn = By.id("au.com.suncorp.marketplace:id/vehicleServicesButton");
	private String vehicleServicesBtnId = "au.com.suncorp.marketplace:id/vehicleServicesButton";
	private String scrollableId = "au.com.suncorp.marketplace:id/navigationViewPager";

	// TODO -> Cannot find this in ANdroid. But its there on iOS
	private By checkClaimStatusButton = By.id("VehicleCell.ClaimLabel");


	//Vehicle tile common elements utilization
	public WebElement checkVehicleServicesImage() {
		return find(vehicleServicesImg);
	}
	
	public WebElement isVehicleServicesImageDisplayed() {

		return find(vehicleServicesImg,1);
	}

	public WebElement checkVehicleServicesTitle() {
		return find(vehicleServicesTitle);
	}

	public String getVehicleServicesTitle() {
		return checkVehicleServicesTitle().getText();
	}

	public WebElement isVehiclesServicesTitleDisplayed() {

		return find(vehicleServicesTitle,1);
	}

	public WebElement checkVehiclesServicesDesc() {
		return find(vehicleServicesDesc);
	}

	public String getVehiclesServicesDesc() {
		return checkVehiclesServicesDesc().getText();
	}

	public WebElement isVehiclesServicesDescDisplayed() {

		return find(vehicleServicesDesc,1);
	}

	public WebElement checkVehiclesServicesBtn() {
		return find(vehicleServicesBtn);
	}

	public String getVehiclesServicesBtnTxt() {
		String text = checkVehiclesServicesBtn().getText();
		return text.toUpperCase();

	}

	public WebElement isVehiclesServicesBtnDisplayed() {

		return find(vehicleServicesBtn,1);
	}

	public void tapVehiclesServicesBtn() {

		tapElement(checkVehiclesServicesBtn());
	}

	public void scrollToVechilesTile() {

		if (getScreenHeight()>1920) {
			scrollToElement(vehicleServicesTitleId, "id", scrollableId, 10);	
		}
		else {
			scrollToElement(vehicleServicesTitle);
		}
	}

	public void scrollToVechilesTileBtn() {

		if (getScreenHeight()>1920) {
			scrollToElement(vehicleServicesBtnId, "id", scrollableId, 10);

		}
		else {
			scrollToElement(vehicleServicesBtn);
		}
	}

	public void scrollToVechilesTileDesc() {
		if (getScreenHeight()>1920) {
			scrollToElement(vehicleServicesDescId, "id", scrollableId, 10);
		}
		else {

			scrollToElement(vehicleServicesDesc);
		}
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
