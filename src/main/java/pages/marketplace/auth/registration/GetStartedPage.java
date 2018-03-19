package pages.marketplace.auth.registration;

import java.security.KeyStore.PrivateKeyEntry;

import org.apache.xml.serializer.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import automation.framework.utils.AutoUtilities;
import io.appium.java_client.AppiumDriver;

public class GetStartedPage extends BasePage {

	public GetStartedPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By getStartedPageTitle = By.id("au.com.suncorp.marketplace:id/headingText");
	private By getStartedPageSubheader = By.id("au.com.suncorp.marketplace:id/subHeadingText");
	private By suncorpBrandIcon = By.id("au.com.suncorp.marketplace:id/suncorpButton");
	private By aamiBrandIcon = By.id("au.com.suncorp.marketplace:id/aamiButton");
	private By apiaBrandIcon = By.id("au.com.suncorp.marketplace:id/apiaButton");
	private By gioBrandIcon = By.id("au.com.suncorp.marketplace:id/gioButton");
	private By shannonsBrandIcon = By.id("au.com.suncorp.marketplace:id/shannonsButton");
	private By newAccountText = By.id("au.com.suncorp.marketplace:id/newAccountText");
	private By setupNewAccountButton = By.id("au.com.suncorp.marketplace:id/newAccountButton");
	private By backButton = By.id("au.com.suncorp.marketplace:id/backButton");

	private By suncorpAccountOptions = By.id("au.com.suncorp.marketplace:id/suncorpBottomSheet");
	private By suncorpAccountOptionsHeading = By.id("au.com.suncorp.marketplace:id/suncorpAccountQuestionText");
	private By suncorpBankingOption = By.id("au.com.suncorp.marketplace:id/bankingBottomSheetButton");
	private By suncorpInsuranceOption = By.id("au.com.suncorp.marketplace:id/insuranceBottomSheetButton");
	private By suncorpBothOption = By.id("au.com.suncorp.marketplace:id/bothBottomSheetButton");
	private By brandIcon = null;

	public WebElement checkGetStartedPageTitle() {
		return find(getStartedPageTitle);
	}

	public WebElement checkGetStartedPageSubheader() {
		return find(getStartedPageSubheader, 30);
	}

	public WebElement checkSetupNewAccountButton() {
		return find(setupNewAccountButton);
	}

	public void tapSetupNewAccount() {
		tapElement(setupNewAccountButton);
	}

	public WebElement checkSuncorpBrandIcon() {
		return find(suncorpBrandIcon, 30);
	}

	public void tapSuncorpBrandIcon() {
		tapElement(suncorpBrandIcon);
	}

	public WebElement checkAamiBrandIcon() {
		return find(aamiBrandIcon, 30);
	}

//	public void tapAamiBrandIcon() {
//		tapElement(aamiBrandIcon);
//	}

	public WebElement checkApiaBrandIcon() {
		return find(apiaBrandIcon, 30);
	}

//	public void tapApiaBrandIcon() {
//		tapElement(apiaBrandIcon);
//	}

	public WebElement checkGioBrandIcon() {
		return find(gioBrandIcon, 30);
	}

//	public void tapGioBrandIcon() {
//		tapElement(gioBrandIcon);
//	}

	public WebElement checkShannonsBrandIcon() {
		return find(shannonsBrandIcon, 30);
	}

//	public void tapShannonBrandIcon() {
//		tapElement(shannonsBrandIcon);
//	}

	public WebElement checkNewAccountText() {
		return find(newAccountText, 30);
	}

	public WebElement checkBackButton() {
		return find(backButton, 30);
	}

	public void tapBackButton() {
		tapElement(backButton);
	}

	public WebElement checkSuncorpAccountOptionsSheet() {
		return find(suncorpAccountOptions, 5);
	}

	public WebElement checkSuncorpAccountOptionsHeading() {
		return find(suncorpAccountOptionsHeading, 30);
	}

	public WebElement checkSuncorpBanking() {
		return find(suncorpBankingOption, 30);
	}

	public void tapSuncorpBankingButton() {
		tapElement(suncorpBankingOption);
	}

	public WebElement checkSuncorpInsurance() {
		return find(suncorpInsuranceOption, 30);
	}

	public void tapSuncorpInsuranceButton() {
		tapElement(suncorpInsuranceOption);
	}

	public WebElement checkSuncorpBothOption() {
		return find(suncorpBothOption, 30);
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
