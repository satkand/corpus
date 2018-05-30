package pages.marketplace.chatbot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class ChatbotPage extends BasePage {

	public ChatbotPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		
	private By chatIcon = By.id("au.com.suncorp.marketplace:id/chatbotToolbarImage");
	private By chatbotPageTitle = By.xpath("//android.widget.TextView[@text='Scout']");
	private By backButton = By.id("au.com.suncorp.marketplace:id/backButton");
	private By chatView = By.id("au.com.suncorp.marketplace:id/chatView");
	private By userInputField = By.id("au.com.suncorp.marketplace:id/userInput");
	private By sendButton = By.id("au.com.suncorp.marketplace:id/sendMessageButton");
	
	private By userInputQuery = By.id("au.com.suncorp.marketplace:id/queryMessageText");
	private By responseMessage = By.id("au.com.suncorp.marketplace:id/responseMessageText");
	private By responseIndicator = By.id("au.com.suncorp.marketplace:id/responseIndicator");
	
	private By callNowButton = By.xpath("//android.widget.Button[@text='CALL NOW']");
	private By phNo_dailpad = By.id("com.google.android.dialer:id/digits");

	public WebElement checkChatIcon() {
		return find(chatIcon);
	}
	
	public WebElement checkChatbotPageTitle() {
		return find(chatbotPageTitle);
	}
	
	public WebElement checkBackButton() {
		return find(backButton);
	}
	
	public void tapBackButton() {
		tapElement(backButton);
	}
	
	public WebElement checkChatView() {
		return find(chatView);
	}
	
	public void tapChatView() {
		tapElement(chatView);
	}
	
	public WebElement checkUserInputField() {
		return find(userInputField);
	}
	
	public void tapUserInputField() {
		tapElement(userInputField);
	}
	
	public void enterUserInput(String userInput) {
		typeValue(userInput, userInputField);
	}
	
	public void clearUserInput() {
		clearValue(userInputField);
	}
	
	public WebElement checkSendButton() {
		return find(sendButton);
	}
	
	public void tapSendButton() {
		tapElement(sendButton);
	}
	
	public boolean isSendButtonEnabled() {
		return isEnabled(sendButton);
	}
	
	public WebElement checkUserInputQuery() {
		return find(userInputQuery);
	}
	
	public String getUserInputQueryValue() {
		find(userInputQuery, 20);
		return getText(userInputQuery);
	}
	
	public List<String> getUserInputQueryValueList() {
		return getTextList(userInputQuery);
	}
	
	public WebElement checkResponseMessage() {
		return find(responseMessage);
	}
	
	public List<String> getResponseMessagesList() {
		find(responseMessage, 30);
		return getTextList(responseMessage);
	}
	
	public WebElement checkResponseIndicator() {
		return find(responseIndicator);
	}
	
	public void waitForResponseIndicatorToDisappear() {
		waitForElementToDisappear(responseIndicator, 20);
	}
	
	public WebElement checkCallNowButton() {
		return find(callNowButton);
	}
	
	public void tapCallNowButton() {
		tapElement(callNowButton);
	}
	
	// Cannot rely on id for ph no, because it varies from device to device (i.e., from samsung to Pixel) as the dial in pads are specific to phones and ids cannot be similar
	// And also the Ph No is present in Test data sheet. As it can change later.
	public String constructPhNumInDialPadXpath(String phNo) {
		String phNumInDialPad = "//android.widget.EditText[@text='"+phNo+"']";
		return phNumInDialPad;
	}
	
	public WebElement checkPhNumInDialPad(String phNo_samsung, String phNo_google) {
		String phNo = null;
		WebElement phNoElement = null;
		if(getDeviceAttribute("deviceManufacturer").equalsIgnoreCase("Google")
				|| getDeviceAttribute("deviceManufacturer").equalsIgnoreCase("LGE")) {
			phNo = getText(phNo_dailpad).replace(" ", "").replace("-", "");
			System.out.println(":::::PH NO SHOWN IS :::"+getText(phNo_dailpad)+"::::After Conversion"+ phNo);
			if(phNo.equalsIgnoreCase(phNo_google)) {
				phNoElement = find(phNo_dailpad);
			}
			
		} else {
			phNoElement = find(By.xpath(constructPhNumInDialPadXpath(phNo_samsung)));
		}		
		return phNoElement;
	}
	
	public String constructexternalUrlXpath(String externalURLText) {
		String externalUrlXpath = "//android.widget.Button[@text='"+externalURLText+"']";
		return externalUrlXpath;
	}
	
	public WebElement checkExternalUrlButton(String externalURLText) {
		return find(By.xpath(constructexternalUrlXpath(externalURLText)));
	}
	
	public void tapExternalUrlButton(String externalURLText) {
		tapElement(By.xpath(constructexternalUrlXpath(externalURLText)));
	}
	
	public void copyTextContentInUserInputQuery() {
		tapElement(userInputQuery);
		longPressOnAnElement(find(userInputQuery));
		
		//tap on Copy Option
		if(getDeviceAttribute("deviceManufacturer").equalsIgnoreCase("Google")
				|| getDeviceAttribute("deviceManufacturer").equalsIgnoreCase("LGE")) {
			tapByOffsetFromStart(find(userInputQuery), -150, -30);
			
		} else {
			tapByOffsetFromStart(find(userInputQuery), -250, -30);
		}
	}
	
	public String copyTextContentInResponseMessage() {
		List<WebElement> responseMessagesList = finds(responseMessage);
		int count = responseMessagesList.size();
		WebElement  lastResponseMessage = responseMessagesList.get(count-1);
		tapElement(lastResponseMessage);
		longPressOnAnElement(lastResponseMessage);
		
		//tap on Copy Option
		if(getDeviceAttribute("deviceManufacturer").equalsIgnoreCase("Google")
				|| getDeviceAttribute("deviceManufacturer").equalsIgnoreCase("LGE")) {
			// tap on Select All
			tapByOffsetFromEnd(lastResponseMessage, -200, -30);
			
			//tap on Copy
			tapByOffsetFromStart(lastResponseMessage, +250, -50);
			
		} else {
			// tap on Select All
			tapByOffsetFromEnd(lastResponseMessage, 0, -30);
			
			//tap on Copy
			tapByOffsetFromStart(lastResponseMessage, +250, -50);
		}
		
		return getText(responseMessage);
	}
	
	public void pasteInuserInputField() {
		WebElement element = find(userInputField);
		longPressOnAnElement(element);
		tapByOffsetFromStart(element, +200, -30);
	}
}
