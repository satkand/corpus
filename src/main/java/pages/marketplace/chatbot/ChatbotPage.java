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
	private By chatbotPageTitle = By.xpath("//android.widget.TextView[@text='Sunny']");
	private By backButton = By.id("au.com.suncorp.marketplace:id/backButton");
	private By chatView = By.id("au.com.suncorp.marketplace:id/chatView");
	private By userInputField = By.id("au.com.suncorp.marketplace:id/userInput");
	private By sendButton = By.id("au.com.suncorp.marketplace:id/sendMessageButton");
	
	private By userInputQuery = By.id("au.com.suncorp.marketplace:id/queryMessageText");
	private By responseMessage = By.id("au.com.suncorp.marketplace:id/responseMessageText");
	private By responseIndicator = By.id("au.com.suncorp.marketplace:id/responseIndicator");
	
	private By callNowButton = By.xpath("//android.widget.Button[@text='CALL NOW']");
	
	private By webViewCloseButton = By.id("com.sec.android.app.sbrowser:id/customtab_close");
	private By webViewUrl = By.id("com.sec.android.app.sbrowser:id/url_bar_text");

	public WebElement checkChatIcon() {
		return find(chatIcon);
	}
	
	public WebElement checkChatbotPageTitle() {
		return find(chatbotPageTitle);
	}
	
	public WebElement checkBackButton() {
		return find(backButton);
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
	
	public WebElement checkPhNumInDialPad(String phNo) {
		return find(By.xpath(constructPhNumInDialPadXpath(phNo)));
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
	
	public void tapWebViewCloseButton() {
		tapElement(webViewCloseButton);
	}
	
	public WebElement checkWebViewUrl() {
		return find(webViewUrl);
	}
	
	public String getWebViewUrl() {
		return getText(webViewUrl);
	}
	
	public void copyTextContentInUserInputQuery() {
		tapElement(userInputQuery);
		longPressOnAnElement(userInputQuery);
		
		//tap on Copy Option
		tapByOffsetFromStart(userInputQuery, -250, -30);
	}
	
	public void copyTextContentInResponseMessage() {
		tapElement(responseMessage);
		longPressOnAnElement(responseMessage);
		
		// tap on Select All
		tapByOffsetFromEnd(responseMessage, 0, -30);
		
		//tap on Copy
		tapByOffsetFromStart(responseMessage, +250, -50);
	}
	
	public void pasteInuserInputField() {
		longPressOnAnElement(userInputField);
		tapByOffsetFromStart(userInputField, +200, -30);
	}
}
