package pages.marketplace.auth.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class GetStartedPage extends BasePage {

	public GetStartedPage(AppiumDriver driver) {
		super(driver);
	}

	private By getStartedPageTitle = By.id("au.com.suncorp.marketplace:id/headingText");
	private By getStartedPageSubheader = By.id("au.com.suncorp.marketplace:id/subHeadingText");
	private By suncorpAccountOptions = By.id("au.com.suncorp.marketplace:id/suncorpBottomSheet");
	private By suncorpAccountOptionsHeading = By.id("au.com.suncorp.marketplace:id/suncorpAccountQuestionText");
	private By suncorpBankingOption = By.id("au.com.suncorp.marketplace:id/bankingBottomSheetButton");
	private By suncorpInsuranceOption = By.id("au.com.suncorp.marketplace:id/insuranceBottomSheetButton");
	private By suncorpBothOption = By.id("au.com.suncorp.marketplace:id/bothBottomSheetButton");
	
	private By brandSelectDropDown = By.id("au.com.suncorp.marketplace:id/spinnerLayout");
	private By brandSelectListTitle = By.id("au.com.suncorp.marketplace:id/alertTitle");
	private By getStartedNextButton = By.id("au.com.suncorp.marketplace:id/nextButton");
	private By seletBrand = null;
	private By suncorpBrand = By.xpath("//android.widget.TextView[@text='Suncorp']");
	
	
	private By backButton = MobileBy.AccessibilityId("Back");
	private By setupNewAccountButton = By.id("au.com.suncorp.marketplace:id/newAccountButton");	
	private String registerWithSupportedGroupButtonsuffix = "au.com.suncorp.marketplace:id/";
	private By registerWithSupportedGroupButton;

	public WebElement checkGetStartedPageTitle() {
		return find(getStartedPageTitle);
	}
	
	public String getGetStartedPageTitleValue() {
		return getText(getStartedPageTitle);
	}

	public WebElement checkRegisterWithSupportedGroupButton(String supportedGroupName) {
		registerWithSupportedGroupButton = By.id(registerWithSupportedGroupButtonsuffix+supportedGroupName+"Button");
		return find(registerWithSupportedGroupButton);
	}
	
	public void tapBackButton() {
		tapElement(backButton);
	}

	public WebElement checkGetStartedPageSubheader() {
		return find(getStartedPageSubheader);
	}

	public WebElement checkSetupNewAccountButton() {
		return find(setupNewAccountButton);
	}

	public void tapSetupNewAccount() {
		tapElement(setupNewAccountButton);
	}
	
	public void tapRegisterWithSupportedGroupButton(String supportedGroupName){
		registerWithSupportedGroupButton = By.id(registerWithSupportedGroupButtonsuffix+supportedGroupName+"Button");
		tapElement(registerWithSupportedGroupButton);
	}

	public WebElement checkBackButton() {
		return find(backButton);
	}

	public WebElement checkSuncorpAccountOptionsSheet() {
		return find(suncorpAccountOptions);
	}

	public WebElement checkSuncorpAccountOptionsHeading() {
		return find(suncorpAccountOptionsHeading);
	}

	public WebElement checkSuncorpBanking() {
		return find(suncorpBankingOption);
	}

	public void tapSuncorpBankingButton() {
		tapElement(suncorpBankingOption);
	}

	public WebElement checkSuncorpInsurance() {
		return find(suncorpInsuranceOption);
	}

	public void tapSuncorpInsuranceButton() {
		tapElement(suncorpInsuranceOption);
	}

	public WebElement checkSuncorpBothOption() {
		return find(suncorpBothOption);
	}

	public void tapSuncorpBothButton() {
		tapElement(suncorpBothOption);
	}
	
	public WebElement checkBrandSelectDropDown() {
		return find(brandSelectDropDown);
	}
	
	public void tapBrandSelectDropDown() {
		tapElement(brandSelectDropDown);
	}
	
	public WebElement checkSelectBrandAlert() {
		return find(brandSelectListTitle);
	}
	
	public WebElement checkBrandExists(String brandName) {
		seletBrand = By.xpath("//android.widget.TextView[@text='"+brandName+"']");
		return find(seletBrand);
	}
	
	public void tapBrandFromList(String brandName) {
		seletBrand = By.xpath("//android.widget.TextView[@text='"+brandName+"']");
		tapElement(seletBrand);
	}
	
	public WebElement checkNextButton() {
		return find(getStartedNextButton);
	}
	
	public void tapNextButton() {
		tapElement(getStartedNextButton);
	}
	
	public WebElement checkSuncorpBrandExists() {
		return find(suncorpBrand);
	}
	
	public void tapSuncorpBrand(){
		tapElement(suncorpBrand);
	}
	
	public void dismissDropDownList() {
		tapOnBottomRightCorner();
	}

}
