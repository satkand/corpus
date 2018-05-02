package pages.marketplace.vehicles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import automation.framework.common.BasePage;
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
	
	//Add a vehicle policy
	private By addVehiclePolicyImg = By.id("au.com.suncorp.marketplace:id/addVehiclePolicyImage");
	private String addVehiclePolicyImgId = "au.com.suncorp.marketplace:id/addVehiclePolicyImage";
	private By addVehiclePolicyActionTxt = By.id("au.com.suncorp.marketplace:id/addVehiclePolicyActionText");
	private String addVehiclePolicyActionTxtId = "au.com.suncorp.marketplace:id/addVehiclePolicyActionText";
	private By addVehiclePolicyInfo1Txt = By.id("au.com.suncorp.marketplace:id/addVehiclePolicyInfo1Text");
	private By addVehiclePolicyInfo2Txt = By.id("au.com.suncorp.marketplace:id/addVehiclePolicyInfo2Text");
	private By addInsurancePolicyLabel =  By.id("au.com.suncorp.marketplace:id/addInsurancePolicyLabel");
	
	
	//Vehicles Dimension background Image
	private By vehicleDimensionBkgrndImg = By.id("au.com.suncorp.marketplace:id/vehiclePillarBackground");
	private String vehicleDimensionBkgrndImgId = "au.com.suncorp.marketplace:id/vehiclePillarBackground";

	// TODO -> Cannot find this in ANdroid. But its there on iOS
	private By checkClaimStatusButton = By.id("VehicleCell.ClaimLabel");
	
	//check vehicle dimension background image element
	public WebElement checkVehicleDimensionBkgrndImg() {
		return find(vehicleDimensionBkgrndImg);
	}
	
	public void scrollToVehicleDimensionBkgrndImg() {
		scrollToElement(vehicleDimensionBkgrndImgId, "id", 20);
	}
	
	// 
	
	public WebElement checkAddInsurancePolicyLabel() {
		
		return find(addInsurancePolicyLabel);
	}
	public WebElement checkAddVehiclePolicyImage() {
		return find(addVehiclePolicyImg);
	}
	
	public WebElement isAddVehiclePolicyImageDisplayed() {

		return find(addVehiclePolicyImg,1);
	}
	
	public WebElement checkAddVehiclePolicyInfo1Txt() {
		return find(addVehiclePolicyInfo1Txt);
	}
	
	public String getAddVehiclePolicyInfo1Txt() {
		return find(addVehiclePolicyInfo1Txt).getText();
	}
	
	public WebElement checkAddVehiclePolicyInfo2Txt() {
		return find(addVehiclePolicyInfo2Txt);
	}
	
	public String getAddVehiclePolicyInfo2Txt() {
		return find(addVehiclePolicyInfo2Txt).getText();
	}
	
	public WebElement checkAddVehiclePolicyActionTxt() {
		return find(addVehiclePolicyActionTxt);
	}
	
	public String getAddVehiclePolicyActionTxt() {
		return find(addVehiclePolicyActionTxt).getText();
	}
	
	public WebElement isAddVehiclePolicyActionTxtDisplayed() {

		return find(addVehiclePolicyActionTxt,1);
	}

	public void tapAddAVechilesPolicy() {
		
		tapElement(addVehiclePolicyActionTxt);
		
	}
	
	public void scrollToAddVechilePolicyImage() {

		if (getScreenHeight()>1920) {
			scrollToElement(addVehiclePolicyImgId, "id", 45);

		}
		else {
			scrollToElement(addVehiclePolicyImg,"deepdown");
		}
	}
	
	public void scrollToaddVehiclePolicyActionText() {

		if (getScreenHeight()>1920) {
			scrollToElement(addVehiclePolicyActionTxtId, "id", scrollableId, 30);

		}
		else {
			scrollToElement(addVehiclePolicyActionTxt,"deepdown");
		}
	}
	
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
