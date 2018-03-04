package pages.marketplace.common;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.openqa.selenium.By;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class ConfigPage extends BasePage {
	
	private By configPageTitle = By.xpath("//android.widget.TextView[@text='Config']");
	private By globalBaseURL = By.id("au.com.suncorp.marketplace:id/globalBaseUrl");
	private By applyGlobalBaseUrlButton = By.id("au.com.suncorp.marketplace:id/globalBaseUrlButton");

	private By bankingBaseUrl = By.id("au.com.suncorp.marketplace:id/bankingBaseUrlEditText");
	private By spendingUrl = By.id("au.com.suncorp.marketplace:id/spendingBaseUrlEditText");
	private By vehiclesBaseUrl = By.id("au.com.suncorp.marketplace:id/vehicleBaseUrlEditText");
	private By portfolioBaseUrl = By.id("au.com.suncorp.marketplace:id/portfolioBaseUrlEditText");
	
	private By continueButton = By.id("au.com.suncorp.marketplace:id/configContinueButton");
	
	//FAPI Settings page
	private By hasBankAccountsToggle = By.id("au.com.suncorp.marketplace:id/hasAccountsToggle");
	
	public ConfigPage(AppiumDriver driver) {
		super(driver);
	}
	
	public void dismissConfigPage(String stub) {
		if(find(configPageTitle,30) != null) {
			// Added this just to add some delay before checking for keyboard
			find(continueButton,10);
			if(!(isKeyboardPresent() == true)) {
				isKeyboardPresent();
			}
			
	        //Uncomment the below line if Stub Server is to be connect
			if(!stub.equalsIgnoreCase("false")) {
		        ConnectToStubSever(stub);
			}
			for(int i=0; i<=2; i++) {
				swipeScreen("down");
			}
			if(find(continueButton, 30) != null) {
				tapElement(continueButton);
			}
		}
	}
	
	// Connect to the Stub Server
    // Fetch the current IP address and edit the fields appropriately
    
	public void ConnectToStubSever(String stub) {
		InetAddress IP = null;
		try {
			IP = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		/*
		if(find(globalBaseURL,30) != null) {
			clearValue(globalBaseURL);
			typeValue(IP.getHostAddress()+":4567", globalBaseURL);
			tapElement(applyGlobalBaseUrlButton);
		}
		*/
		String baseURL = "http://"+IP.getHostAddress()+":4567/";

		if(stub.equalsIgnoreCase("banking") && find(bankingBaseUrl, 30) != null) {
			System.out.println("stub:::"+stub+"::::::banking");
			clearValue(bankingBaseUrl);
			typeValue(baseURL+"marketplace/api/", bankingBaseUrl);
			if(!(isKeyboardPresent() == true)) {
				isKeyboardPresent();
			}
		}	
		if(stub.equalsIgnoreCase("portfolio") && find(portfolioBaseUrl, 30) != null) {
			System.out.println("stub:::"+stub+"::::::portfolio");
			clearValue(portfolioBaseUrl);
			typeValue(baseURL, portfolioBaseUrl);
			if(!(isKeyboardPresent() == true)) {
				isKeyboardPresent();
			}
		}
		if(stub.equalsIgnoreCase("spendings") && find(spendingUrl, 30) != null) {
			System.out.println("stub:::"+stub+"::::::spendings");
			clearValue(spendingUrl);
			typeValue(baseURL, spendingUrl);
			if(!(isKeyboardPresent() == true)) {
				isKeyboardPresent();
			}
		}
		if(stub.equalsIgnoreCase("vehicles") && find(vehiclesBaseUrl, 30) != null) {
			System.out.println("stub:::"+stub+"::::::vehicles");
			clearValue(vehiclesBaseUrl);
			typeValue(baseURL, vehiclesBaseUrl);
			if(!(isKeyboardPresent() == true)) {
				isKeyboardPresent();
			}
		}
	}
	
	public void enableHasBankAccountsToggle() {
		if (!isToggleEnabled(hasBankAccountsToggle)) {
			tapElement(hasBankAccountsToggle);
		}
	}
	
	public void disableHasBankAccountsToggle() {
		if (isToggleEnabled(hasBankAccountsToggle)) {
			tapElement(hasBankAccountsToggle);
		}
	}

}
