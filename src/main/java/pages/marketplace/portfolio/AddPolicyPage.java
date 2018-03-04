package pages.marketplace.portfolio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class AddPolicyPage extends BasePage {

	public AddPolicyPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private By addPolicyPageTitle = By.xpath("//android.widget.TextView[@text='Add policy']");
	private By policyNumberPlaceHolderText = By.id("au.com.suncorp.marketplace:id/policyNumberField");
	private By addAccountButton = By.id("au.com.suncorp.marketplace:id/addPolicyButton");
	private By forgotMyDetailsButton = By.id("au.com.suncorp.marketplace:id/forgottenDetailsTextButton");
	private By supportedbrandsTextLabel = By.id("au.com.suncorp.marketplace:id/supportedBrandsText");
	private By supportedbrandsImage = By.id("au.com.suncorp.marketplace:id/brandsGroupImage");
	
	
	public WebElement checkAddPolicyPageTitle(){
		return find(addPolicyPageTitle);
	}
	public WebElement checkPolicyNumberPlaceHolderText(){
		return find(policyNumberPlaceHolderText);
	}
	public WebElement checkAddAccountButton(){
		return find(addAccountButton);
	}
	public WebElement checkForgotMyDetailsButton(){
		return find(forgotMyDetailsButton);
	}
	public WebElement checkSupportedbrandsTextLabel(){
		return find(supportedbrandsTextLabel);
	}
	public WebElement checkSupportedbrandsImage(){
		return find(supportedbrandsImage);
	}
	
	
}
