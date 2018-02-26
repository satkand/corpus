package pages.marketplace.portfolio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class MyProductsPage extends BasePage {

	public MyProductsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By maybeLaterButton = By.id("au.com.suncorp.marketplace:id/enablePinPromptDismissButton");
	private By addExistingProductButton = By.id("au.com.suncorp.marketplace:id/addProductButton");
	private By emptyStateImage = By.id("au.com.suncorp.marketplace:id/emptyStateImage");
	private By emptyStateLabel = By.id("au.com.suncorp.marketplace:id/emptyStateMessageText");
	private By findProductButton = By.id("au.com.suncorp.marketplace:id/browseProductCatalogueButton");
	private By bottomSheetLabel = By.id("au.com.suncorp.marketplace:id/productSelectionQuestionText");
	private By insurancePolicyBottomSheetButton = By.id("au.com.suncorp.marketplace:id/addInsuranceButton");
	private By bankAccountBottomSheetButton = By.id("au.com.suncorp.marketplace:id/addBankAccountButton");
	private By oneSuncorpTabLabel = By.xpath("//android.widget.TextView[@text='One Suncorp']");
	private By myProductsLabel = By.xpath("//android.widget.TextView[@text='My products']");
	private By backButton = By.id("Navigate up");
	
	public String getBottomSheetTitleText() {
		return getText(bottomSheetLabel);
	}
	
	public String getInsurancePolicyBottomSheetButtonText() {
		return getText(insurancePolicyBottomSheetButton);
	}
	
	public String getBankAccountBottomSheetButtonText() {
		return getText(bankAccountBottomSheetButton);
	}
	
	public String getAddExistingProductButtonText() {
		return getText(addExistingProductButton);
	}
	
	public String getEmptyStateLabelText() {
		return getText(emptyStateLabel);
	}
	
	public String getFindProductButtonText() {
		return getText(findProductButton);
	}
	
	public String getMyProductsTitleText() {
		return getText(myProductsLabel);
	}
	
	public void tapBackButton(){
		find(backButton,30);
		tapElement(backButton);
	}
	
	public WebElement checkBottomSheetLabel(){
		return find(bottomSheetLabel);
	}
	
	public WebElement checkInsurancePolicyBottomSheetButton(){
		return find(insurancePolicyBottomSheetButton);
	}
	
	public void tapInsurancePolicyBottomSheetButton(){
		find(insurancePolicyBottomSheetButton,30);
		tapElement(insurancePolicyBottomSheetButton);
	}
	
	public WebElement checkBankAccountBottomSheetButton(){
		return find(bankAccountBottomSheetButton);
	}
	
	public void tapBankAccountBottomSheetButton(){
		find(bankAccountBottomSheetButton,30);
		tapElement(bankAccountBottomSheetButton);
	}
	
	public WebElement checkOneSuncorpTab(){
		return find(oneSuncorpTabLabel);
	}
	
	public WebElement checkMyProductsTitle(){
		return find(myProductsLabel);
	}
	
	public WebElement checkAddExistingProductButton(){
		return find(addExistingProductButton);
	}
	
	public WebElement checkEmptyStateImage(){
		return find(emptyStateImage);
	}
	
	public WebElement checkEmptyStateLabel(){
		return find(emptyStateLabel);
	}

	public WebElement checkFindProductButton(){
		return find(findProductButton);
	}
	
	public void tapAddExistingProductButton(){
		find(addExistingProductButton,30);
		tapElement(addExistingProductButton);
	}
	
	public WebElement checkEnablePinButton() {
		return find(maybeLaterButton);
	}
	
	public void tapMaybeLaterButton(){
		find(maybeLaterButton,30);
		tapElement(maybeLaterButton);
	}
	
}
