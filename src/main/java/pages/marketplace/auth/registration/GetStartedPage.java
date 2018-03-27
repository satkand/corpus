package pages.marketplace.auth.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class GetStartedPage extends BasePage {

	public GetStartedPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By getStartedPageTitle = By.id("au.com.suncorp.marketplace:id/headingText");
	private By getStartedPageSubheader = By.id("au.com.suncorp.marketplace:id/subHeadingText");
	private By suncorpBrandIcon = By.id("au.com.suncorp.marketplace:id/suncorpButton");
	private By newAccountText = By.id("au.com.suncorp.marketplace:id/newAccountText");
	private By suncorpAccountOptions = By.id("au.com.suncorp.marketplace:id/suncorpBottomSheet");
	private By suncorpAccountOptionsHeading = By.id("au.com.suncorp.marketplace:id/suncorpAccountQuestionText");
	private By suncorpBankingOption = By.id("au.com.suncorp.marketplace:id/bankingBottomSheetButton");
	private By suncorpInsuranceOption = By.id("au.com.suncorp.marketplace:id/insuranceBottomSheetButton");
	private By suncorpBothOption = By.id("au.com.suncorp.marketplace:id/bothBottomSheetButton");
	private By brandIcon = null;
	
	private By backButton = By.id("au.com.suncorp.marketplace:id/backButton");
	private By setupNewAccountButton = By.id("au.com.suncorp.marketplace:id/newAccountButton");	//private By registerWithSupportedGroupbutton = By.id("au.com.suncorp.marketplace:id/aamiButton");
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

	public WebElement checkSuncorpBrandIcon() {
		return find(suncorpBrandIcon);
	}

	public void tapSuncorpBrandIcon() {
		tapElement(suncorpBrandIcon);
	}

	public WebElement checkNewAccountText() {
		return find(newAccountText);
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

	public WebElement checkMemberBrandIcon(String currentBrand, String commonBundleId) {
		brandIcon = By.id(commonBundleId+currentBrand);
		return find(brandIcon, 30);
	}

	public void tapMemberBrandIcon(String currentBrand, String commonBundleId) {
		brandIcon = By.id(commonBundleId+currentBrand);
		tapElement(brandIcon);
	}
}
