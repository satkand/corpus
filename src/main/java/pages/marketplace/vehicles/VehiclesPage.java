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
	private By addVehiclePOlicyInfoOneIcon = By.id("au.com.suncorp.marketplace:id/addVehiclePolicyInfoOneIcon");
	private By addVehiclePOlicyInfoTwoIcon = By.id("au.com.suncorp.marketplace:id/addVehiclePolicyInfoTwoIcon");
	private By addVehiclePolicyActionTxt = By.id("au.com.suncorp.marketplace:id/addVehiclePolicyActionText");
	private String addVehiclePolicyActionTxtId = "au.com.suncorp.marketplace:id/addVehiclePolicyActionText";
	private By addVehiclePolicyInfoOneTxt = By.id("au.com.suncorp.marketplace:id/addVehiclePolicyInfoOneText");
	private String addVehiclePolicyInfoOneTxtId = "au.com.suncorp.marketplace:id/addVehiclePolicyInfoOneText";
	private By addVehiclePolicyInfoTwoTxt = By.id("au.com.suncorp.marketplace:id/addVehiclePolicyInfoTwoText");
	private String addVehiclePolicyInfoTwoTxtId = "au.com.suncorp.marketplace:id/addVehiclePolicyInfoTwoText";
	private By addInsurancePolicyLabel =  By.id("au.com.suncorp.marketplace:id/addInsurancePolicyLabel");
	private By addInsurancePolicyButton = By.id("au.com.suncorp.marketplace:id/addPolicyButton");
	private By featureLockAlertTitle = By.id("au.com.suncorp.marketplace:id/alertTitle");
	
	public WebElement checkFeatureLockAlertTitle() {
		return find(featureLockAlertTitle);
	}
	
	public void waitForFeatureLockAlertTitle() {
		waitForElementToAppear(featureLockAlertTitle);
	}
	
	public WebElement checkAddVehiclePolicyInfoOneIcon(){
		return find(addVehiclePOlicyInfoOneIcon);
	}
	
	public WebElement isAddVehiclePolicyInfoOneIconDisplayed(){
		return find(addVehiclePOlicyInfoOneIcon);
	}
	
	public WebElement checkAddVehiclePolicyInfoTwoIcon(){
		return find(addVehiclePOlicyInfoTwoIcon);
	}
	
	public WebElement isAddVehiclePolicyInfoTwoIconDisplayed(){
		return find(addVehiclePOlicyInfoTwoIcon);
	}
	
	//Vehicles Dimension background Image
	private By vehicleDimensionBkgrndImg = By.id("au.com.suncorp.marketplace:id/vehiclePillarBackground");
	private String vehicleDimensionBkgrndImgId = "au.com.suncorp.marketplace:id/vehiclePillarBackground";

	//Vehicles dimensions asset summary
	private By policyViewDocumentsBtn = By.id("au.com.suncorp.marketplace:id/viewDetailsButton");
	
	//Vehicles Dimension asset details
	private String policyVehicleItemLayoutId = "au.com.suncorp.marketplace:id/vehicleItemLayout";
	private By policyVehicleItemLayout = By.id("au.com.suncorp.marketplace:id/vehicleItemLayout");
	private By policyVehicleImage = By.id("au.com.suncorp.marketplace:id/vehicleImage");
	private By vehicleTakePhotoImage = By.id("au.com.suncorp.marketplace:id/takePhotoImage");
	private By vehicleRegistrationNumberText = By.id("au.com.suncorp.marketplace:id/registrationNumberText");
	private By vehicleDescriptionText = By.id("au.com.suncorp.marketplace:id/vehicleDescriptionText");
	private By vehicleMakeClaimBtn = By.id("au.com.suncorp.marketplace:id/makeClaimButton");
	private By vehicleAddDocumentsBtn = By.id("au.com.suncorp.marketplace:id/addDocumentsButton");
	
	//Vehicle asset details elements utilization
	public WebElement scrollToDerivedAsset() {
		if (getScreenHeight()>1920) {
			scrollToElement(policyVehicleItemLayoutId, "id", scrollableId, 10);
		}
		else {
			scrollToElement(policyVehicleItemLayout );
		}
		return checkPolicyVehicleItemLayout();
	}
	
	public WebElement checkPolicyVehicleItemLayout() {
		return find(policyVehicleItemLayout);
	}
	
	public WebElement checkVehicleDescriptionText() {
		return find(vehicleDescriptionText);
	}
	
	public String getVehicleDescriptionText() {
		return find(vehicleDescriptionText).getText();
	}
	
	public WebElement checkPolicyRegistrationNumberText() {
		return find(vehicleRegistrationNumberText);
	}
	
	public String getRegistrationNumberText() {
		return find(vehicleRegistrationNumberText).getText();
	}
	
	
	public WebElement checkPolicyVehicleTypeImage() {
		return find(policyVehicleImage);
	}
	
	public WebElement checkVehicleTakePhotoImage() {
		return find(vehicleTakePhotoImage);
	}
	
	public WebElement checkVehicleMakeClaimBtn() {
		return find(vehicleMakeClaimBtn);
	}
	
	public String getVehicleMakeClaimBtn() {
		return find(vehicleMakeClaimBtn).getText();
	}
	
	public WebElement checkVehicleAddDocumentsBtn() {
		return find(vehicleAddDocumentsBtn);
	}
	
	public String getVehicleAddDocumentsBtn() {
		return find(vehicleAddDocumentsBtn).getText();
	}
	
	public WebElement checkPolicyViewDocumentsBtn() {
		return find(policyViewDocumentsBtn);
	}
	
	public void tapPolicyViewDocumentsBtn() {
		 tapElement(policyViewDocumentsBtn);
	}
	
	
	// TODO -> Cannot find this in ANdroid. But its there on iOS
	private By checkClaimStatusButton = By.id("VehicleCell.ClaimLabel");
	
	//check vehicle dimension background image element
	public WebElement checkVehicleDimensionBkgrndImg() {
		return find(vehicleDimensionBkgrndImg);
	}
	
	public void scrollToVehicleDimensionBkgrndImg() {
		scrollToElement(vehicleDimensionBkgrndImgId, "id", 20);
	}
	
	// Add a policy
	
	public WebElement checkAddInsurancePolicyButton() {
		return find(addInsurancePolicyButton);
	}
	
	public String getAddInsurancePolicyButtonText() {
		return getText(addInsurancePolicyButton);
	}
	
	public WebElement checkAddInsurancePolicyLabel() {
		
		return find(addInsurancePolicyLabel);
	}
	public WebElement checkAddVehiclePolicyImage() {
		return find(addVehiclePolicyImg);
	}
	
	public WebElement isAddVehiclePolicyImageDisplayed() {

		return find(addVehiclePolicyImg,1);
	}
	
	public WebElement checkAddVehiclePolicyInfoOneTxt() {
		return find(addVehiclePolicyInfoOneTxt);
	}
	
	public WebElement isAddVehiclePolicyInfoOneTxtDisplayed() {
		return find(addVehiclePolicyInfoOneTxt);
	}
	
	public String getAddVehiclePolicyInfoOneTxt() {
		return getText(addVehiclePolicyInfoOneTxt);
	}
	
	public WebElement checkAddVehiclePolicyInfoTwoTxt() {
		return find(addVehiclePolicyInfoTwoTxt);
	}
	
	public WebElement isAddVehiclePolicyInfoTwoTxtDisplayed() {
		return find(addVehiclePolicyInfoTwoTxt);
	}
	
	public String getAddVehiclePolicyInfoTwoTxt() {
		return getText(addVehiclePolicyInfoTwoTxt);
	}
	
	public WebElement checkAddVehiclePolicyActionTxt() {
		return find(addVehiclePolicyActionTxt);
	}
	
	public String getAddVehiclePolicyActionTxt() {
		return getText(addVehiclePolicyActionTxt);
	}
	
	public WebElement isAddVehiclePolicyActionTxtDisplayed() {

		return find(addVehiclePolicyActionTxt,1);
	}

	public void tapAddAVechilesPolicy() {
		
		tapElement(addVehiclePolicyActionTxt);
		
	}
	
	public void scrollToAddVechilePolicy() {

		if (getScreenHeight()>1920) {
			scrollToElement(addVehiclePolicyActionTxtId, "id", 45);

		}
		else {
			scrollToElement(addVehiclePolicyActionTxt,"deepdown");
		}
	}
	
	public void scrollToAddVechilePolicyInfoTwoText() {

		if (getScreenHeight()>1920) {
			scrollToElement(addVehiclePolicyInfoTwoTxtId, "id", 45);

		}
		else {
			scrollToElement(addVehiclePolicyInfoTwoTxt,"deepdown");
		}
	}
	
	public void scrollToAddVechilePolicyInfoOneText() {

		if (getScreenHeight()>1920) {
			scrollToElement(addVehiclePolicyInfoOneTxtId, "id", 45);

		}
		else {
			scrollToElement(addVehiclePolicyInfoOneTxt,"deepdown");
		}
	}
	
	public void scrollToAddVechilePolicyImage() {

		if (getScreenHeight()>1920) {
			scrollToElement(addVehiclePolicyImgId, "id", 45);

		}
		else if(getScreenHeight()<1920)  {
			scrollToElement(addVehiclePolicyImg,"deepdown");
		}
	}
	
	public void scrollToaddVehiclePolicyActionText() {

		if (getScreenHeight()>1920) {
			scrollToElement(addVehiclePolicyActionTxtId, "id", 30);
		}
		else if(getScreenHeight()<1920) {
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
	
	public void waitForLoadingIndicatorToAppear() {
		waitForElementToAppear(loadingIndicator);
	}
	public void waitForDataToLoad() {
		waitForElementToDisappear(loadingIndicator,30);
	}

	public void waitForInsurancePageToLoad() {
		waitForElementToAppear(addInsurancePolicyButton);
	}

	public void dismissFeatureLockedAlert() {
		tapDeviceBackButton();
		
	}



}
