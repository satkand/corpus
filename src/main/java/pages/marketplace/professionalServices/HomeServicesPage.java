package pages.marketplace.professionalServices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class HomeServicesPage  extends BasePage{

	public HomeServicesPage(AppiumDriver driver) {
		super(driver);
	}
	
	private By professionalServicesPageTitle = By.xpath("//android.widget.TextView[@text='Professional Services']");
	private By homeServicesTitle = By.id("au.com.suncorp.marketplace:id/homeServicesTitle");
	private By homeServicesImage = By.id("au.com.suncorp.marketplace:id/homeServicesImage");
	private By chatBotButton = By.id("au.com.suncorp.marketplace:id/chatbotOption");
	private By viewServicesButton = By.id("au.com.suncorp.marketplace:id/viewHomeServicesButton");
	private By chooseServiceLabel = By.id("au.com.suncorp.marketplace:id/chooseServiceText");
	private By homeServicesDescription = By.id("au.com.suncorp.marketplace:id/homeServicesDescription");
	private By urlBar = By.id("com.android.chrome:id/url_bar");
	
	public WebElement checkUrlBar() {
		return find(urlBar);
	}
	
	public String getUrlBarText() {
		return getText(urlBar);
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
	

}
