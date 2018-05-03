package pages.marketplace.common;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.openqa.selenium.By;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class ConfigPage extends BasePage {
	
	//private By configPageTitle = By.xpath("//android.widget.TextView[@text='Config']");
	private By configPageTitle = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Config\")");
	private By globalBaseURL = By.id("au.com.suncorp.marketplace:id/globalBaseUrl");
	private By applyGlobalBaseUrlButton = By.id("au.com.suncorp.marketplace:id/globalBaseUrlButton");
	private By  envSelector = By.id("au.com.suncorp.marketplace:id/environmentSpinner");
	private By bankingBaseUrl = By.id("au.com.suncorp.marketplace:id/bankingBaseUrlEditText");
	private By spendingUrl = By.id("au.com.suncorp.marketplace:id/spendingBaseUrlEditText");
	private By spendingAccNumbers = By.id("au.com.suncorp.marketplace:id/spendingAccountNumbersEditText");
	private By vehiclesBaseUrl = By.id("au.com.suncorp.marketplace:id/vehicleBaseUrlEditText");
	private By portfolioBaseUrl = By.id("au.com.suncorp.marketplace:id/portfolioBaseUrlEditText");
	
	private By continueButton = By.id("au.com.suncorp.marketplace:id/configContinueButton");
	
	//FAPI Settings page
	private By hasBankAccountsToggle = By.id("au.com.suncorp.marketplace:id/hasAccountsToggle");
	
	
	private String continueBtnID="au.com.suncorp.marketplace:id/configContinueButton";
	
	public ConfigPage(AppiumDriver driver) {
		super(driver);
	}
	
	public void tapEnvSelector(){
		
		tapElement(envSelector);
	}
	
	public void dismissConfigPage(String stub,String configFile) {
		
	   String env = lookupProperty(configFile,"env"); 
	 
	   tapEnvSelector();
	   tapElement(findByUIAutomator(env, "text"));
	    
		if (find(configPageTitle, 30) != null) {
			// Added this just to add some delay before checking for keyboard
			find(continueButton, 3);
			// if(!(isKeyboardPresent() == true)) {
			// isKeyboardPresent();
			// }

			if (isKeyboardDisplayed()) {
				dismissKeyboard();
			}
			
			// Uncomment the below line if Stub Server is to be connect
			if (!stub.equalsIgnoreCase("false")) {
				ConnectToStubSever(stub,configFile);
			}
			// for(int i=0; i<=2; i++) {
			// swipeScreen("down");
			// }

			scrollToElement(continueBtnID, "id");
			if (find(continueButton, 30) != null) {
				tapElement(continueButton);
			}
		}
	}
	
	// Connect to the Stub Server
    // Fetch the current IP address and edit the fields appropriately
    
	public void ConnectToStubSever(String stub,String configFile) {
		InetAddress IP = null;
		try {
			IP = InetAddress.getLocalHost();
			System.out.println("IPPPPPPPP:::::::::::::"+IP);
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
		
		// TODO: This hardcoding needs to removed, once we figure out a way to get the second ip from the list of ips on the mac mini
		String baseURL = lookupProperty(configFile,"baseURL"); ;//IP.getHostAddress()+":4567/";
		String accountNum = lookupProperty(configFile,"accountNum");
		System.out.println("stub:::"+stub+"::::::global");
		typeValue(baseURL, globalBaseURL);
		tapElement(applyGlobalBaseUrlButton);
		if(!(isKeyboardPresent() == true)) {
			isKeyboardPresent();
		}

		//baseURL = "http://"+IP.getHostAddress()+":4567/";
		if(stub.equalsIgnoreCase("banking") && find(bankingBaseUrl, 30) != null) {
			System.out.println("stub:::"+stub+"::::::banking");
			clearValue(bankingBaseUrl);
			typeValue(baseURL+"marketplace/api/", bankingBaseUrl);
			if(isKeyboardDisplayed()) {
				dismissKeyboard();
			}
		}	
		if(stub.equalsIgnoreCase("portfolio") && find(portfolioBaseUrl, 30) != null) {
			System.out.println("stub:::"+stub+"::::::portfolio");
			clearValue(portfolioBaseUrl);
			typeValue(baseURL, portfolioBaseUrl);
			if(isKeyboardDisplayed()) {
				dismissKeyboard();
			}
		}
		if(stub.equalsIgnoreCase("spendings") && find(spendingUrl, 30) != null) {
			System.out.println("stub:::"+stub+"::::::spendings");
	//		clearValue(spendingUrl);
	//		typeValue(baseURL, spendingUrl);
			typeValue(accountNum, spendingAccNumbers);
			if(isKeyboardDisplayed()) {
				dismissKeyboard();
			}
		}
		if(stub.equalsIgnoreCase("vehicles") && find(vehiclesBaseUrl, 30) != null) {
			System.out.println("stub:::"+stub+"::::::vehicles");
			clearValue(vehiclesBaseUrl);
			typeValue(baseURL, vehiclesBaseUrl);
			if(isKeyboardDisplayed()) {
				dismissKeyboard();
			}
		}
		if(stub.equalsIgnoreCase("memberLogin")) {
			System.out.println("stub:::"+stub+"::::::memberLogin");
			clearValue(globalBaseURL);
			
			typeValue("192.168.213.5:4567", globalBaseURL);
			//mac mini
			//typeValue("192.168.213.98:4567", globalBaseURL);
			tapElement(applyGlobalBaseUrlButton);
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
