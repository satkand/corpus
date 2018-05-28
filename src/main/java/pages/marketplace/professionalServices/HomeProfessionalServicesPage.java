package pages.marketplace.professionalServices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class HomeProfessionalServicesPage  extends BasePage{

	public HomeProfessionalServicesPage(AppiumDriver driver) {
		super(driver);
	}
	
	//Professional services main page elements
	private By professionalServicesPageTitle = By.xpath("//android.widget.TextView[@text='Professional Services']");
	private By homeServicesTitle = By.id("au.com.suncorp.marketplace:id/homeServicesTitle");
	private By homeServicesImage = By.id("au.com.suncorp.marketplace:id/homeServicesImage");
	private By chatBotButton = By.id("au.com.suncorp.marketplace:id/chatbotOption");
	private By viewServicesButton = By.id("au.com.suncorp.marketplace:id/viewHomeServicesButton");
	private By chooseServiceLabel = By.id("au.com.suncorp.marketplace:id/chooseServiceText");
	private By homeServicesDescription = By.id("au.com.suncorp.marketplace:id/homeServicesDescription");
	
	//ProfessionalServices intro
	private By professionalServicesIntroCloseButton = By.id("au.com.suncorp.marketplace:id/closeButton");
	private By professionalServicesIntroImage = By.id("au.com.suncorp.marketplace:id/dialogImage");
	private By professionalServicesIntroDesc = By.id("au.com.suncorp.marketplace:id/dialogMessage");
	private By professionalServicesIntroTitle = By.id("au.com.suncorp.marketplace:id/dialogTitle");
	private By professionalServicesIntroGotItButton = By.id("au.com.suncorp.marketplace:id/dismissButton");
	
	public WebElement checkProfessionalServicesIntroCloseButton() {
		return find(professionalServicesIntroCloseButton);
	}
	
	public String getProfessionalServicesIntroDesc() {
		return getText(professionalServicesIntroDesc);
	}
	
	public String getProfessionalServicesIntroTitle() {
		return getText(professionalServicesIntroTitle);
	}
	
	public void tapProfessionalServicesIntroGotItButton() {
		tapElement(professionalServicesIntroGotItButton);
	}
	
	public void tapProfessionalServicesIntroCloseButton() {
		tapElement(professionalServicesIntroCloseButton);
	}
	
	public WebElement checkProfessionalServicesIntroImage() {
		return find(professionalServicesIntroImage);
	}
	
	public WebElement checkProfessionalServicesIntroDesc() {
		return find(professionalServicesIntroDesc);
	}
	
	public WebElement checkProfessionalServicesIntroTitle() {
		return find(professionalServicesIntroTitle);
	}
	
	public WebElement checkProfessionalServicesIntroGotItButton() {
		return find(professionalServicesIntroGotItButton);
	}
	
	public WebElement checkHomeServicesDescription() {
		return find(homeServicesDescription);
	}
	
	public WebElement checkChooseServiceLabel() {
		return find(chooseServiceLabel);
	}
	
	public WebElement checkProfessionalServicesPageTitle() {
		return find(professionalServicesPageTitle);
	}
	
	public WebElement checkHomeServicesTitle() {
		return find(homeServicesTitle);
	}
	
	public WebElement checkHomeServicesImage() {
		return find(homeServicesImage);
	}
	
	public WebElement checkChatBotButton() {
		return find(chatBotButton);
	}
	
	public WebElement checkViewServicesButton() {
		return find(viewServicesButton);
	}

	public String getProfessionalServicesPageTitle() {
		return getText(professionalServicesPageTitle);
	}
	
	public String getHomeServicesTitle() {
		return getText(homeServicesTitle);
	}
	
	public String getChooseServiceLabel() {
		return getText(chooseServiceLabel);
	}
	
	public String getHomeServicesDescription() {
		return getText(homeServicesDescription);
	}
	
	public void tapViewServicesButton() {
		tapElement(viewServicesButton);
	}
	
	public void restartConfig() throws Throwable {
		restartSuncorpConfigApp();
	}

}
