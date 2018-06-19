package pages.marketplace.portfolio;

import org.openqa.selenium.By;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;

public class AddProductPage extends BasePage{

	public AddProductPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By addExistingProductScreenTitle = By.xpath("//android.widget.TextView[@text='Add existing product']");
	private By addInsurancePolicyButton = By.id("au.com.suncorp.marketplace:id/insuranceTypeLabel");
	private By addBankAccountButton = By.id("au.com.suncorp.marketplace:id/bankingTypeLabel");
	private By addSuperAccountButton = By.id("au.com.suncorp.marketplace:id/superTypeLabel");

	
	public String getaddExistingProductScreenTitleText() {
		return getText(addExistingProductScreenTitle);
	}
	
	public WebElement checkAddExistingProductScreenLabel(){
		return find(addExistingProductScreenTitle);
	}
	
	public WebElement checkAddInsurancePolicyButton(){
		return find(addInsurancePolicyButton);
	}
	
	public void tapAddInsurancePolicyButton(){
		tapElement(addInsurancePolicyButton);
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
}
