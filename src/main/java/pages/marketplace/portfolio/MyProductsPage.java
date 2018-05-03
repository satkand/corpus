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
	private By emptyStateLabel = By.id("au.com.suncorp.marketplace:id/emptyStateMessageTitle");
	private By emptyStateDescription = By.id("au.com.suncorp.marketplace:id/emptyStateMessageDescription");
	private By findProductButton = By.id("au.com.suncorp.marketplace:id/browseProductCatalogueButton");
	private By addExistingProductScreenLabel = By.xpath("//android.widget.TextView[@text='Add existing product']");
	private By addInsurancePolicyButton = By.id("au.com.suncorp.marketplace:id/insuranceTypeLabel");
	private By addBankAccountButton = By.id("au.com.suncorp.marketplace:id/bankingTypeLabel");
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
	private By availableBalanceLabel = By.id("au.com.suncorp.marketplace:id/availableBalanceLabel");
	private By addSuperAccountButton = By.id("au.com.suncorp.marketplace:id/superTypeLabel");
	private String addExistingProductButtonID = "au.com.suncorp.marketplace:id/addProductButton";
	private By policyLayout = By.id("au.com.suncorp.marketplace:id/policyItemLayout");

	private By riskText = null;
	private String riskXpathPrefix = "//android.widget.TextView[@text = \'";
	private String riskXpathSuffix = "\']";
	private String dateDescXpathSuffix1 = "']/following-sibling::android.widget.LinearLayout/child::android.widget.TextView[@text = \'";
	private String dateDescXpathSuffix2 = "\']";
	private String policyStatusXpathSuffix1="']/parent::android.widget.LinearLayout/parent::android.widget.LinearLayout/parent::android.widget.LinearLayout/preceding-sibling::android.widget.LinearLayout/child::android.widget.TextView[@text = \'";
	private String policyStatusXpathSuffix2="\']";
	private By dateDescText = null;
	private By endDate = null;
	private By policyStatus = null;
	private By viewButton = null;
	private String viewButtonXpathSuffix = "\']/parent::android.widget.LinearLayout/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView[@text = \'VIEW DETAILS\']";
	private By overduePaymentAmount = By.id("au.com.suncorp.marketplace:id/duePaymentAmountText");
	private By nextPaymentAmount = By.id("au.com.suncorp.marketplace:id/nextPaymentAmountText");
	private By nextPayementDueDate = By.id("au.com.suncorp.marketplace:id/nextPaymentDateText");
	
	//wealth products
	private By wealthProductAccountTypeLabel = By.id("au.com.suncorp.marketplace:id/wealthAccountTypeText");
	private By wealthProductAccountNumber = By.id("au.com.suncorp.marketplace:id/wealthAccountNumberText");
	private By wealthProductCurrentBalance = By.id("au.com.suncorp.marketplace:id/wealthAccountBalanceText");
	
	//life products
	private By lifeProductAccountTypeLabel = By.id("au.com.suncorp.marketplace:id/lifePolicyShortDescriptionText");
	private By insuredPersonName = By.id("au.com.suncorp.marketplace:id/insuredPersonNames");
	private By lifePolicyStatus = By.id("au.com.suncorp.marketplace:id/lifePolicyStatus");
	
	//policy details
	private By policyDetailsTitle = By.xpath("//android.widget.TextView[@text='Policy Details']");
	
	//Add Bank Account screen
	private By accountNumberField = By.id("au.com.suncorp.marketplace:id/accountNumberField");
	private By accountNumberError = By.id("au.com.suncorp.marketplace:id/textinput_error");
	private By addAccountButton = By.id("au.com.suncorp.marketplace:id/addAccountButton");
	private String carPolicy="Car";


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
	
	public List<String> fetchWealthProductTypeTextList() {
		return getTextList(wealthProductAccountTypeLabel);
	}
	
	public List<String> fetchLifeProductTypeTextList() {
		find(lifeProductAccountTypeLabel,30);
		return getTextList(lifeProductAccountTypeLabel);
	}
	
	public List<String> fetchLifePolicyStatusList() {
		return getTextList(lifePolicyStatus);
	}
	
	public List<String> fetchLifePolicyInsuredNamesList() {
		return getTextList(insuredPersonName);
	}
	
	public List<String> fetchAccountNumberTextList() {
		return getTextList(accountNumber);
	}
	
	public List<String> fetchWealthProductAccountNumberTextList() {
		return getTextList(wealthProductAccountNumber);
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
	
	public List<String> fetchOverduePaymentAmount() {
		return getTextList(overduePaymentAmount);
	}
	
	public List<String> fetchNextPaymentAmount() {
		return getTextList(nextPaymentAmount);
	}
	
	public List<String> fetchNextPaymentDueDate() {
		return getTextList(nextPayementDueDate);
	}
	
	public List<String> fetchWealthProductCurrentBalanceTextList() {
		find(wealthProductCurrentBalance);
		return getTextList(wealthProductCurrentBalance);
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
	
	public WebElement checkAvailableBalanceLabel(){
		return find(availableBalanceLabel);
	}
	
	public String getAvailableBalanceLabel(){
		return getText(availableBalanceLabel);
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
	
	public String getaddExistingProductScreenTitleText() {
		return getText(addExistingProductScreenLabel);
	}
	
	public String getEmptyStateLabelText() {
		return getText(emptyStateLabel);
	}
	
	public String getEmptyStateDescriptionText() {
		return getText(emptyStateDescription);
	}
	
	public void tapBackButton(){
		tapElement(backButton);
	}
	
	public WebElement checkAddExistingProductScreenLabel(){
		return find(addExistingProductScreenLabel);
	}
	
	public WebElement checkAddInsurancePolicyButton(){
		return find(addInsurancePolicyButton);
	}
	
	public void tapAddInsurancePolicyButton(){
		tapElement(addInsurancePolicyButton);
	}
	
	public void tapViewDetails(){
		tapElement(viewDetailsButton);
	}
	
	public WebElement checkViewDetailsButton(){
		return find(viewDetailsButton);
	}
	
	public WebElement checkAddBankAccountButton(){
		return find(addBankAccountButton);
	}
	
	public void tapAddBankAccountButton(){
		tapElement(addBankAccountButton);
	}
	
	public WebElement checkAddSuperAccountButton(){
		return find(addSuperAccountButton);
	}
	
	public void tapAddSuperAccountButton(){
		tapElement(addSuperAccountButton);
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
	
	public WebElement checkEmptyStateDescription(){
		return find(emptyStateDescription);
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

	public WebElement checkRisk(String riskName) {
		String riskXpath = riskXpathPrefix + riskName + riskXpathSuffix;
		riskText = By.xpath(riskXpath);
		return find(riskText);
	}
	
	public boolean scrollToPolicyRisk(String riskName) {
		String riskXpath = riskXpathPrefix + riskName + riskXpathSuffix;
		riskText = By.xpath(riskXpath);
		boolean policyRiskFound = false;
		
		if (find(riskText) == null) {
			policyRiskFound = false;

			while (find(riskText) == null && find(addExistingProductButton) == null && policyRiskFound == false) {
				swipeScreen("down");

				if (find(riskText) == null)
					policyRiskFound = false;
				else
					policyRiskFound = true;

			}
			swipeScreen("down");
			return policyRiskFound;
		} else {
			policyRiskFound = true;
			return policyRiskFound;
		}
	}
	
	public boolean checkPolicyDisplayed(By riskText)
	{
		if(find(riskText)== null)
			return false;
		else
			return true;
		
	}
	
	public WebElement checkExpiryDateDesc(String riskName, String dateDesc) {

		String dateDescXpath = riskXpathPrefix + riskName + dateDescXpathSuffix1 + dateDesc + dateDescXpathSuffix2;
		dateDescText = By.xpath(dateDescXpath); 
		return find(dateDescText,10);
		
	}
	
	public WebElement checkExpiryDate(String riskName,String Date) {
		String dateXpath = riskXpathPrefix + riskName + dateDescXpathSuffix1 + Date + dateDescXpathSuffix2;
		endDate = By.xpath(dateXpath);
		return find(endDate);
		
	}
	
	public WebElement checkPolicyStatus(String riskName, String policyDesc) {
		String policyStatusXpath = riskXpathPrefix + riskName + policyStatusXpathSuffix1 + policyDesc + policyStatusXpathSuffix2;
		policyStatus = By.xpath(policyStatusXpath); 
		return find(policyStatus);
		
	}
	
	public WebElement checkViewDetailsButtonForPolicy(String riskName) {
		String viewDetailsXpath = riskXpathPrefix + riskName + viewButtonXpathSuffix;
		viewButton = By.xpath(viewDetailsXpath);
		return find(viewButton);
	}
	
	public void tapViewPolicyButton(String riskName){
		String viewDetailsXpath = riskXpathPrefix + riskName + viewButtonXpathSuffix;
		viewButton = By.xpath(viewDetailsXpath);
		tapElement(viewButton);
	}
	
	public WebElement checkPolicyDetailsTitle(){
		return find(policyDetailsTitle);
	}
	
	public void tapAccountNumberField(){
		tapElement(accountNumberField);
	}
	
	public boolean checkKeyboardDisplayed() {
		return isKeyboardPresent();
	}
	
	public void enterAccountNumber(String accountNumber) {
		typeValue(accountNumber,accountNumberField);
	}
	
	public String getAccountNumberError() {
		return getText(accountNumberError);
	}
	
	public WebElement checkAccountNumberError(){
		return find(accountNumberError);
	}
	
	public void tapAddAccount() {
		tapElement(addAccountButton);
	}
	
	public void clearAccountNumber() {
		clearValue(accountNumberField);
	}
	
	public void scrollToAddExistingProductButton() {

		scrollToElement(addExistingProductButton, "true");

	}
	
	public void scrollToProductAndTap(String productType) {

		 tapElement(scrollToElement(productType, "text"));
		
	}
	
	public void tapProductByInstance(int instance) {

		   List <WebElement> policyLayouts = finds(policyLayout);
		   
		   tapElement(policyLayouts.get(instance));
		
	}

	public void tapProductByPolicyStatus(String status) {

		By policyItemLayoutlocator = By.xpath("//android.widget.TextView[@text = \"" + status+ "\"]/parent::android.widget.LinearLayout//following-sibling::android.widget.LinearLayout");

		WebElement element = find(policyItemLayoutlocator, 2);

		for (int i = 0; i < 2; i++) {

			if (element == null) {

				swipeScreen("DOWN");

				element = find(policyItemLayoutlocator, 2);
			} else {
				break;
			}
		}
		tapElement(element);
	}

	
	
}
