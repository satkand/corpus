package pages.marketplace.portfolio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

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
	private By myProductsLabel = By.xpath("//android.widget.TextView[@text='My products']");
	private By backButton = MobileBy.AccessibilityId("Navigate up");
	//TODO DMPM-3713
	private By currentBalanceLabel = By.xpath("//android.widget.TextView[@text='Current balance']");
    private By availableBalanceLable = By.xpath("//android.widget.TextView[@text='Available balance']");

    private By bsbText = By.id("au.com.suncorp.marketplace:id/accountBsbText");
	private By accountNumber = By.id("au.com.suncorp.marketplace:id/accountNumberText");
	private By currentBalance = By.id("au.com.suncorp.marketplace:id/currentBalanceText");
	private By availableBalance = By.id("au.com.suncorp.marketplace:id/availableBalanceText");
	private By viewDetailsButton = By.id("au.com.suncorp.marketplace:id/viewBankAccountDetailsButton");
	private By accountTypeLabel = By.id("au.com.suncorp.marketplace:id/accountTypeText");
	//TODO DMPM-3713
	private By productTypeImage = By.xpath(
			"//android.widget.LinearLayout[@resource-id='au.com.suncorp.marketplace:id/bankAccountItemLayout']//android.widget.ImageView");//
	private By accountDetailsLabel = By.xpath("//android.widget.TextView[@text='Account Details']");
	private By accountItemLayout = By.id("au.com.suncorp.marketplace:id/bankAccountItemLayout");
	private String addExistingProductButtonID = "au.com.suncorp.marketplace:id/addProductButton";
	public List<WebElement> fetchAccountItemLayoutList() {
		List<WebElement> elements = finds(accountItemLayout);
		return elements;
	}
	
	public List<String> fetchBsbList() {
		find(bsbText);
		return getTextList(bsbText);
	}
	
	public void tapAccountItem(WebElement item){
		item.click();
	}
	
	public List<String> fetchProductTypeTextList() {
		find(accountTypeLabel);
		return getTextList(accountTypeLabel);
	}
	
	public List<String> fetchAccountNumberTextList() {
		find(accountNumber);
		return getTextList(accountNumber);
	}
	
	public WebElement checkAccountDetailsTitle(){
		return find(accountDetailsLabel);
	}
	public List<String> fetchAvailableBalanceTextList() {
		find(availableBalance);
		return getTextList(availableBalance);
	}
	
	public List<String> fetchCurrentBalanceTextList() {
		find(currentBalance);
		return getTextList(currentBalance);
	}
	
	public String getAccountDetailsTitle() {
		return getText(accountDetailsLabel);
	}
	
	public WebElement checkProductTypeImage(){
		return find(productTypeImage);
	}
	
	public WebElement checkAccountTypeLabel(){
		return find(accountTypeLabel);
	}
	
	public WebElement checkAvailableBalance(){
		return find(availableBalance);
	}
	
	public WebElement checkCurrentBalance(){
		return find(currentBalance);
	}
	
	public WebElement checkAccountNumber(){
		return find(accountNumber);
	}
	
	public WebElement checkAvailableBalanceLable(){
		return find(availableBalanceLable);
	}
	
	public WebElement checkCurrentBalanceLabel(){
		return find(currentBalanceLabel);
	}
	
	public String getAccountTypeLabel() {
		return getText(accountTypeLabel);
	}
	
	public String getViewDetailsButton() {
		return getText(viewDetailsButton);
	}
	
	public String getAvailableBalance() {
		return getText(availableBalance);
	}
	
	public String getCurrentBalance() {
		return getText(currentBalance);
	}
	
	public String getAccountNumber() {
		return getText(accountNumber);
	}
	
	public String getAvailableBalanceLable() {
		return getText(availableBalanceLable);
	}
	
	public String getCurrentBalanceLabel() {
		return getText(currentBalanceLabel);
	}
	
	public String getBottomSheetTitleText() {
		return getText(bottomSheetLabel);
	}
	
	public String getEmptyStateLabelText() {
		return getText(emptyStateLabel);
	}
	
	public void tapBackButton(){
		tapElement(backButton);
	}
	
	public WebElement checkBottomSheetLabel(){
		return find(bottomSheetLabel);
	}
	
	public WebElement checkInsurancePolicyBottomSheetButton(){
		return find(insurancePolicyBottomSheetButton);
	}
	
	public void tapInsurancePolicyBottomSheetButton(){
		tapElement(insurancePolicyBottomSheetButton);
	}
	
	public void tapViewDetails(){
		tapElement(viewDetailsButton);
	}
	
	public WebElement checkViewDetailsButton(){
		return find(viewDetailsButton);
	}
	
	public WebElement checkBankAccountBottomSheetButton(){
		return find(bankAccountBottomSheetButton);
	}
	
	public void tapBankAccountBottomSheetButton(){
		tapElement(bankAccountBottomSheetButton);
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
		tapElement(addExistingProductButton);
	}
	
	public WebElement checkEnablePinButton() {
		return find(maybeLaterButton);
	}
	
	public void tapMaybeLaterButton(){
		tapElement(maybeLaterButton);
	}
	
	public void scrollToAddExistingProductButton() {
		//scrollToElement(addExistingProductButton, "true");
		scrollToElement(addExistingProductButtonID, "true");
		
	}
	
}
