package test.marketplace.chatbot;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.CustomRetryListener;
import automation.framework.common.TestDetails;
import automation.framework.common.TestDetails.Priority;
import pages.App;

public class ChatbotTest extends App {
	
	// 51 - Scenario 1, Scenario 2
	// Along with all the elements on the screen checking for the welcome messages as well
	@TestDetails(story1 = "DMPM-191:DMPM-4993,DMPM-4998")
	@Test (groups = {"DMPM-51", "DMPM-477", "DMPM-478", "marketplace", "Chatbot", "priority-minor"})
	public void testChatbotPageElements() {
		navigateToChatbotScreenAsLoggedInUser(utils.readTestData("loginCredentials","defaultLoginCredentials", "login"), utils.readTestData("loginCredentials","defaultLoginCredentials", "pwd"));
		
		// Before the initial welcome messages are shown, response indicator is shown.
		chatbotPage.waitForResponseIndicatorToDisappear();
		
		//TODO: Chat icon is nit shown in latest build - Need to check if this is the expected behaviour in the latest stories
		//Assert.assertNotNull(chatbotPage.checkChatIcon(), "Chatbot page - chat icon not shown");
		Assert.assertNotNull(chatbotPage.checkChatbotPageTitle(), "Chatbot page - page title not shown");
		Assert.assertNotNull(chatbotPage.checkBackButton(), "Chatbot page - back button not shown");
		Assert.assertNotNull(chatbotPage.checkChatView(), "Chatbot page - Chat view not shown");
		Assert.assertNotNull(chatbotPage.checkUserInputField(), "Chatbot page - user input field not shown");
		Assert.assertNotNull(chatbotPage.checkSendButton(), "Chatbot page - send user message button not shown");
	
		// Fetch the expected welcome messages that should be shown from test data sheet
		List<Object> expectedMessages = utils.readTestDataList("chatbot", "defaultWelcomeMessage", "responses");
		
		// Fetch the chatbot welcome messages shown on chatbot screen
		List<String> welcomeMessages = chatbotPage.getResponseMessagesList();
		
		for (Object expectedMessage : expectedMessages) {
			String expectedResponse = expectedMessage.toString();
			Assert.assertEquals(welcomeMessages.get(0), expectedResponse, "Chatbot page - Welcome messages are not shown as expected");
			welcomeMessages.remove(0);
		} 
	}
	
	// 51 - Scenario 3, 4
	@Test (groups = {"DMPM-51", "DMPM-479", "DMPM-480", "marketplace", "Chatbot", "priority-minor"})
	public void testDismissingKeyboardAndSendButtonBehaviour() {
		navigateToChatbotScreenAsLoggedInUser(utils.readTestData("loginCredentials","defaultLoginCredentials", "login"), utils.readTestData("loginCredentials","defaultLoginCredentials", "pwd"));
		chatbotPage.tapUserInputField();
		Assert.assertTrue(common.isKeyboardShown(), "Chatbot page - keyboard not shown");
		// As the keyboard is already dismissed in the above step, we need to launch the keyboard again by tapping on userInputField
		chatbotPage.tapUserInputField();
		// tapping outside to dismiss the keyboard
		chatbotPage.tapChatView();
		Assert.assertFalse(common.isKeyboardShown(), "Chatbot page - keyboard shown");
		
		// Verifying send button behaviour
		Assert.assertFalse(chatbotPage.isSendButtonEnabled(), "Chatbot page - Send button is Enabled");
		chatbotPage.enterUserInput("value");
		Assert.assertTrue(chatbotPage.isSendButtonEnabled(), "Chatbot page - Send button is Disabled");
		chatbotPage.clearUserInput();
		Assert.assertFalse(chatbotPage.isSendButtonEnabled(), "Chatbot page - Send button is Enabled");
	}
		
	// 51 - Scenario 5
	// 237 - Scenario 1, Scenario 2
	// 297 - Scenario 1, Scenario 2
	// 619 - Scenario 1
	// 1200 - Scenario 1
	@Test (groups = {"DMPM-51", "DMPM-481", "DMPM-237", "DMPM-918", "DMPM-919", "DMPM-297", "DMPM-916", "DMPM-917", "DMPM-619", "DMPM-1343", "DMPM-1200", "DMPM-1330", "marketplace", "Chatbot", "priority-minor"})
	public void testChatbotResponseWithParagraphs() {
		navigateToChatbotScreenAsLoggedInUser(utils.readTestData("chatbot","paragraph", "login"), utils.readTestData("chatbot","paragraph", "pwd"));
		
		// Wait for loading indicator to dismiss and welcome messages to be shown
		chatbotPage.waitForResponseIndicatorToDisappear();
		
		String userInput = utils.readTestData("chatbot","paragraph", "input");
		chatbotPage.enterUserInput(userInput);
		chatbotPage.tapSendButton();
		// And also a response indicator should be shown when chatbot is processing the query
		Assert.assertNotNull(chatbotPage.checkResponseIndicator(), "Chatbot page - Response indicator not shown");
		// Once chatbot has processed the query, loading indicator disappears and response message from chatbot is shown
		chatbotPage.waitForResponseIndicatorToDisappear();
		common.dismissKeyboardShown();

		// When user inputs the query. The query should be shown as a message bubble in chat view. 
		Assert.assertNotNull(chatbotPage.checkUserInputQuery(), "Chatbot page - Message bubble not shown");
		Assert.assertEquals(chatbotPage.getUserInputQueryValue(), userInput, "Chatbot page - Message bubble shown in chatview does not match with user input");
		
		// Response message would be the next output message shown after the welcome messages
		int count = utils.readTestDataList("chatbot", "defaultWelcomeMessage", "responses").size();
		
		List<Object> expectedResponsesList = utils.readTestDataList("chatbot", "paragraph", "responses");
		
		// Not fetching the response, as by this time the response is not loaded properly. Hence the test is failing. Fetching the chatbot responses in the for loop itself.
		// By that time the responses are already loaded.
		List<String> actualResponsesList = null; 
		int index = 0;
		for (Object object : expectedResponsesList) {
			String expectedResponse = object.toString();
			actualResponsesList = chatbotPage.getResponseMessagesList(); 
			
			// These response message index, is after the welcome messages
			Assert.assertEquals(actualResponsesList.get(count+index), expectedResponse, "Chatbot page - the response doesnot match the expected value");
			index++;
		}
		
		Assert.assertNull(chatbotPage.checkResponseIndicator(), "Chatbot page - Response indicator shown");
	}
	
	// 350 - Scenario 1, Scenario 2
	// 619 -> Scenario 2
	@Test (groups = {"DMPM-350", "DMPM-922", "DMPM-923", "DMPM-619", "DMPM-1347", "marketplace", "Chatbot", "priority-minor"})
	public void testChatbotResponseWithExternalUrl() {
		navigateToChatbotScreenAsLoggedInUser(utils.readTestData("chatbot","externalUrl", "login"), utils.readTestData("chatbot","externalUrl", "pwd"));
		
		// Wait for loading indicator to dismiss and welcome messages to be shown
		chatbotPage.waitForResponseIndicatorToDisappear();
		
		String userInput = utils.readTestData("chatbot","externalUrl", "input");
		String externalUrlText = utils.readTestData("chatbot", "externalUrl", "websiteText");
		chatbotPage.enterUserInput(userInput);
		chatbotPage.tapSendButton();
		
		// Once chatbot has processed the query, loading indicator disappears and response message from chatbot is shown
		chatbotPage.waitForResponseIndicatorToDisappear();
		
		common.dismissKeyboardShown();
		Assert.assertEquals(chatbotPage.getUserInputQueryValue(), userInput, "Chatbot page - User Message bubble not shown");
		//Assert.assertNotNull(chatbotPage.checkResponseMessage(), "Chatbot page - Response message bubble from chatbot not shown");
		// Constructing the external url element xpath, as it has a dependancy on the test data
		Assert.assertNotNull(chatbotPage.checkExternalUrlButton(externalUrlText), "Chatbot page - External Url option not shown");
		chatbotPage.tapExternalUrlButton(externalUrlText);
		Assert.assertNotNull(webviewPage.checkWebviewBrowserUrl(), "Chatbot page - Webview - Url not shown");
		Assert.assertEquals(webviewPage.getWebviewBrowserUrl(), webviewPage.getExpectedBrowserUrl(utils.readTestData("chatbot", "externalUrl", "websiteURL")), "Chatbot page - not directed to the correct Webview");
		webviewPage.tapWebviewChromeCloseButton();
		Assert.assertNotNull(chatbotPage.checkChatbotPageTitle(), "Chatbot page - page title not shown");
	}
	
	// 527 -> Scenario 1, Scenario 2
	// 619 -> Scenario 2
	@Test (groups = {"DMPM-527", "DMPM-1332", "DMPM-1333", "DMPM-619", "DMPM-1347", "marketplace", "Chatbot", "priority-minor"})
	public void testChatbotResponseWithPhNo() {
		navigateToChatbotScreenAsLoggedInUser(utils.readTestData("chatbot","phNo", "login"), utils.readTestData("chatbot","phNo", "pwd"));
		
		// Wait for loading indicator to dismiss and welcome messages to be shown
		chatbotPage.waitForResponseIndicatorToDisappear();
		
		String userInput = utils.readTestData("chatbot","phNo", "input");
		chatbotPage.enterUserInput(userInput);
		chatbotPage.tapSendButton();
		
		// Once chatbot has processed the query, loading indicator disappears and response message from chatbot is shown
		chatbotPage.waitForResponseIndicatorToDisappear();
		
		common.dismissKeyboardShown();
		Assert.assertEquals(chatbotPage.getUserInputQueryValue(), userInput, "Chatbot page - Message bubble not shown");
		//Assert.assertNotNull(chatbotPage.checkResponseMessage(), "Chatbot page - Response message bubble from chatbot not shown");
		Assert.assertNotNull(chatbotPage.checkCallNowButton(), "Chatbot page - CALL NOW option not shown");
		chatbotPage.tapCallNowButton();
		// Constructing the ph num element xpath, as it has a dependancy on the test data
		Assert.assertNotNull(chatbotPage.checkPhNumInDialPad(utils.readTestData("chatbot", "phNo", "phone_samsung"), utils.readTestData("chatbot", "phNo", "phone_google")), "Dial Pad - Correct Ph Num not shown");
	}
	
	// 1466 - Scenario 1, Scenario 2
	@TestDetails(story1 = "DMPM-1466:DMPM-1525,DMPM-1526", priority = Priority.LOW)
	@Test(retryAnalyzer = CustomRetryListener.class, groups = { "marketplace", "Chatbot", "priority-minor" })
	public void testCopyTextContentInRequestBubbleMessage() {
		navigateToChatbotScreenAsLoggedInUser(utils.readTestData("chatbot","paragraph", "login"), utils.readTestData("chatbot","paragraph", "pwd"));
		String userInput = utils.readTestData("chatbot","paragraph", "input");
		chatbotPage.enterUserInput(userInput);
		chatbotPage.tapSendButton();
		// Once chatbot has processed the query, loading indicator disappears and response message from chatbot is shown
		chatbotPage.waitForResponseIndicatorToDisappear();
		common.dismissKeyboardShown();
		Assert.assertEquals(chatbotPage.getUserInputQueryValue(), userInput, "Chatbot page - Message bubble not shown");
		
		// copying and pasting user input text
		chatbotPage.copyTextContentInUserInputQuery();

		chatbotPage.tapUserInputField();
		common.dismissKeyboardShown();

		chatbotPage.pasteInuserInputField();
		chatbotPage.tapSendButton();
		// Once chatbot has processed the query, loading indicator disappears and response message from chatbot is shown
		chatbotPage.waitForResponseIndicatorToDisappear();
		
		//Need to add delay as the input texts are shifting up as the reponses are loaded - So tapping keyboard and dismissing it again
		chatbotPage.tapUserInputField();
		common.dismissKeyboardShown();
		
		// verifying that the pasted text is correct
		int size = chatbotPage.getUserInputQueryValueList().size();
		Assert.assertEquals(chatbotPage.getUserInputQueryValueList().get(size-1), userInput, "Chatbot page - Message bubble not shown");
		
	}
		
	// 1466 - Scenario 1, Scenario 2
	@TestDetails(story1 = "DMPM-1466:DMPM-1525,DMPM-1526", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Chatbot", "priority-minor" })
	// copying and pasting chatbot response text
	public void testCopyTextContentInResponseBubbleMessage() {
		navigateToChatbotScreenAsLoggedInUser(utils.readTestData("chatbot","paragraph", "login"), utils.readTestData("chatbot","paragraph", "pwd"));
		
		String copiedText = null;
		
		// If the default welcome response messages are shown, then we copy those response messages
		chatbotPage.waitForResponseIndicatorToDisappear();
		if(chatbotPage.checkResponseMessage() != null) {
			// copying and pasting chatbot response text
			copiedText = chatbotPage.copyTextContentInResponseMessage();
		} else { // If the default welcome messages are not shown, then send query input and the responses are sent from server. copy these responses that are received
			String userInput = utils.readTestData("chatbot","paragraph", "input");
			chatbotPage.enterUserInput(userInput);
			chatbotPage.tapSendButton();
			// Once chatbot has processed the query, loading indicator disappears and response message from chatbot is shown
			chatbotPage.waitForResponseIndicatorToDisappear();
			common.dismissKeyboardShown();
			copiedText = chatbotPage.copyTextContentInResponseMessage();

		}
		
		chatbotPage.tapUserInputField();
		chatbotPage.pasteInuserInputField();
		chatbotPage.tapSendButton();
		common.dismissKeyboardShown();
		
		// Once chatbot has processed the query, loading indicator disappears and response message from chatbot is shown
		chatbotPage.waitForResponseIndicatorToDisappear();
		
		//Need to add delay as the input texts are shifting up as the reponses are loaded - So tapping keyboard and dismissing it again
		chatbotPage.tapUserInputField();
		common.dismissKeyboardShown();
		
		// verifying that the pasted text is correct
		int size = chatbotPage.getUserInputQueryValueList().size();
		Assert.assertEquals(chatbotPage.getUserInputQueryValueList().get(size-1), copiedText, "Chatbot page - Message bubble not shown");
	}
	
	private void navigateToChatbotScreenAsLoggedInUser(String login, String pwd) {
		loginToApp(login, pwd);
		Assert.assertNotNull(landingPage.checkChatbotOption(), "Landing Page - Chatbot option is not shown");
		landingPage.tapChatbotOption();
	}
	
	// TODO R3.0 Release
	private void navigateToChatbotScreenAsGuestUser() {
		welcomePage.tapGuestAccessButton();
		Assert.assertNotNull(landingPage.checkChatbotOption(), "Landing Page - Chatbot option is not shown");
		landingPage.tapChatbotOption();
	}
}
