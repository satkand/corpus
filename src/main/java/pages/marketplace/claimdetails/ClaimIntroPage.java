package pages.marketplace.claimdetails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class ClaimIntroPage extends BasePage{

	public ClaimIntroPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private By claimPrerequisiteTitle = By.id("au.com.suncorp.marketplace:id/claimPrerequisiteTitle");
	private By claimInstructionFile = By.id("au.com.suncorp.marketplace:id/claimInstructionFile");
	private By claimInstructionDocs = By.id("au.com.suncorp.marketplace:id/claimInstructionDocs");
	private By claimInstructionPeople = By.id("au.com.suncorp.marketplace:id/claimInstructionPeople");
	private By claimInstructionSubmit = By.id("au.com.suncorp.marketplace:id/claimInstructionSubmit");
	private By claimNextButton = By.id("au.com.suncorp.marketplace:id/claimNextButton");
	private By closeButton = By.id("au.com.suncorp.marketplace:id/cancelClaimButton");
	
	
	public WebElement checkNextButton(){
		
		return find(claimNextButton);
	}
	public String getClaimPrerequisiteTitleText() {

		return getText(claimPrerequisiteTitle);

	}
	public String getClaimInstructionFileText() {

		return getText(claimInstructionFile);

	}
	public String getClaimInstructionDocsText() {

		return getText(claimInstructionDocs);

	}
	public String getClaimInstructionPeopleText() {

		return getText(claimInstructionPeople);

	}
	public String getClaimInstructionSubmitText() {

		return getText(claimInstructionSubmit);

	}
	public void tapCloseButton() {
		
		tapElement(closeButton);
	}
	public void tapNextButton() {
		
		tapElement(claimNextButton);
	}
	

}
