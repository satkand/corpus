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
	private By continueButton = By.id("au.com.suncorp.marketplace:id/configContinueButton");
	private By portfolioBaseURL = By.id("au.com.suncorp.marketplace:id/portfolioBaseUrlEditText");
	
	//FAPI Settings page
	private By hasBankAccountsToggle = By.id("au.com.suncorp.marketplace:id/hasAccountsToggle");
	private By someTransactions = By.id("au.com.suncorp.marketplace:id/spendingManyTransactions");
	
	public ConfigPage(AppiumDriver driver) {
		super(driver);
	}
	
	public void dismissConfigPage() {
        //Uncomment the below line if Stub Server is to be connect
        //ConnectToStubSever();
		if(find(configPageTitle,30) != null) {
			// Added this just to add some delay before checking for keyboard
			find(continueButton,10);
			if(!(isKeyboardPresent() == true)) {
				isKeyboardPresent();
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
	public void ConnectToStubSever() {
		InetAddress IP = null;
		try {
			IP = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		if(find(globalBaseURL,30) != null) {
			clearValue(globalBaseURL);
			typeValue(IP.getHostAddress()+":4567", globalBaseURL);
			tapElement(applyGlobalBaseUrlButton);
		}
		
		if(find(bankingBaseUrl, 30) != null) {
			String baseURL = "http://"+IP.getHostAddress()+":4567"+"/marketplace/api/";
			clearValue(bankingBaseUrl);
			typeValue(baseURL, bankingBaseUrl);
		}
	}

	private void ConnectToStubSever2() {
	//	tapElement(globalBaseURL);
	//	typeValue("192.168.213.31:4567", globalBaseURL);
	//	tapElement(applyGlobalBaseUrlButton);
		if(!(isKeyboardPresent() == true)) {
			isKeyboardPresent();
		}
		swipeScreen("down");
		tapElement(portfolioBaseURL);
		typeValue("192.168.213.1:4567", portfolioBaseURL);
		//tapElement(applyGlobalBaseUrlButton);
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
	
	public void tapSomeTransactions() {
		tapElement(someTransactions);
	}

}
