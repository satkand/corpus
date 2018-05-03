package test.marketplace.chatbot;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class ChatbotTest extends App {
	
	// 51 - Scenario 1, Scenario 2
	@Test (groups = {"DMPM-51", "DMPM-477", "DMPM-478", "marketplace", "Chatbot", "priority-minor"})
	public void testChatbotPageElements() {
		navigateToChatbotScreenAsLoggedInUser();
		Assert.assertNotNull(chatbotPage.checkChatIcon(), "Chatbot page - chat icon not shown");
		Assert.assertNotNull(chatbotPage.checkChatbotPageTitle(), "Chatbot page - page title not shown");
		Assert.assertNotNull(chatbotPage.checkBackButton(), "Chatbot page - back button not shown");
		Assert.assertNotNull(chatbotPage.checkChatView(), "Chatbot page - Chat view not shown");
		Assert.assertNotNull(chatbotPage.checkUserInputField(), "Chatbot page - user input field not shown");
		Assert.assertNotNull(chatbotPage.checkSendButton(), "Chatbot page - send user message button not shown");
	}
	
	// 51 - Scenario 3
	@Test (groups = {"DMPM-51", "DMPM-479", "marketplace", "Chatbot", "priority-minor"})
	public void testDismissingKeyboard() {
		navigateToChatbotScreenAsLoggedInUser();
		chatbotPage.tapUserInputField();
		Assert.assertTrue(common.isKeyboardShown(), "Chatbot page - keyboard not shown");
		// As the keyboard is already dismissed in the above step, we need to launch the keyboard again by tapping on userInputField
		chatbotPage.tapUserInputField();
		// tapping outside to dismiss the keyboard
		chatbotPage.tapChatView();
		Assert.assertFalse(common.isKeyboardShown(), "Chatbot page - keyboard shown");
	}
	
	// 51 - Scenario 4
	@Test (groups = {"DMPM-51", "DMPM-480", "marketplace", "Chatbot", "priority-minor"})
	public void testSendButtonBehaviour() {
		navigateToChatbotScreenAsLoggedInUser();
		Assert.assertFalse(chatbotPage.isSendButtonEnabled(), "Chatbot page - Send button is Enabled");
		chatbotPage.enterUserInput("value");
		Assert.assertTrue(chatbotPage.isSendButtonEnabled(), "Chatbot page - Send button is Disabled");
		chatbotPage.clearUserInput();
		Assert.assertFalse(chatbotPage.isSendButtonEnabled(), "Chatbot page - Send button is Enabled");
	}
	
	// 51 - Scenario 5
	// 237 - Scenario 1, Scenario 2
	// 297 - Scenario 1, Scenario 2
	@Test (groups = {"DMPM-51", "DMPM-481", "DMPM-237", "DMPM-918", "DMPM-919", "DMPM-297", "DMPM-916", "DMPM-917", "marketplace", "Chatbot", "priority-minor"})
	public void testUserInputMessageBubble() {
		navigateToChatbotScreenAsLoggedInUser();
		chatbotPage.enterUserInput("suncorp");
		chatbotPage.tapSendButton();
		
		// When user inputs the query. The query should be shown as a message bubble in chat view. 
		// And also a response indicator should be shown when chatbot is processing the query
		Assert.assertNotNull(chatbotPage.checkResponseIndicator(), "Chatbot page - Response indicator not shown");
		Assert.assertNotNull(chatbotPage.checkUserInputQuery(), "Chatbot page - Message bubble not shown");
		Assert.assertEquals(chatbotPage.getUserInputQueryValue(), "suncorp", "Chatbot page - Message bubble shown in chatview does not match with user input");
		// Once chatbot has processed the query, loading indicator disappears and response message from chatbot is shown
		Assert.assertNotNull(chatbotPage.checkResponseMessage(), "Chatbot page - Response message from chatbot not shown");
		Assert.assertNull(chatbotPage.checkResponseIndicator(), "Chatbot page - Response indicator shown");
	}
		
	// 619 - Scenario 1
	// 1200 - Scenario 1
	@Test  (groups = {"DMPM-619", "DMPM-1343", "DMPM-1200", "DMPM-1330", "marketplace", "Chatbot", "priority-minor"})
	public void testChatbotResponseWithParagraphs() {
		navigateToChatbotScreenAsLoggedInUser();
		String userInput = utils.readTestData("chatbot","paragraph", "input");
		chatbotPage.enterUserInput(userInput);
		chatbotPage.tapSendButton();
		common.dismissKeyboardShown();
		
		Assert.assertEquals(chatbotPage.getUserInputQueryValue(), userInput, "Chatbot page - Message bubble not shown");

		List<Object> expectedResponsesList = utils.readTestDataList("chatbot", "paragraph", "responses");
		// Not fetching the response, as by this time the response is not loaded properly. Hence the test is failing. Fetching the chatbot responses in the for loop itself.
		// By that time the responses are already loaded.
		List<String> actualResponsesList = null; 
		int index = 0;
		for (Object object : expectedResponsesList) {
			String expectedResponse = object.toString();
			actualResponsesList = chatbotPage.getResponseMessagesList(); 
			Assert.assertEquals(actualResponsesList.get(index), expectedResponse, "Chatbot page - the response doesnot match the expected value");
			index++;
		}
	}
	
	// 350 - Scenario 1, Scenario 2
	// 619 -> Scenario 2
	@Test (groups = {"DMPM-350", "DMPM-922", "DMPM-923", "DMPM-619", "DMPM-1347", "marketplace", "Chatbot", "priority-minor"})
	public void testChatbotResponseWithExternalUrl() {
		navigateToChatbotScreenAsLoggedInUser();
		String userInput = utils.readTestData("chatbot","externalUrl", "input");
		String externalUrlText = utils.readTestData("chatbot", "externalUrl", "websiteText");
		chatbotPage.enterUserInput(userInput);
		chatbotPage.tapSendButton();
		common.dismissKeyboardShown();
		Assert.assertEquals(chatbotPage.getUserInputQueryValue(), userInput, "Chatbot page - User Message bubble not shown");
		Assert.assertNotNull(chatbotPage.checkResponseMessage(), "Chatbot page - Response message bubble from chatbot not shown");
		// Constructing the external url element xpath, as it has a dependancy on the test data
		Assert.assertNotNull(chatbotPage.checkExternalUrlButton(externalUrlText), "Chatbot page - External Url option not shown");
		chatbotPage.tapExternalUrlButton(externalUrlText);
		Assert.assertNotNull(webviewPage.checkWebviewBrowserUrl(), "Chatbot page - Webview - Url not shown");
		Assert.assertEquals(webviewPage.getWebviewBrowserUrl(), utils.readTestData("chatbot", "externalUrl", "websiteURL"), "Chatbot page - not directed to the correct Webview");
		webviewPage.tapWebviewChromeCloseButton();
		Assert.assertNotNull(chatbotPage.checkChatbotPageTitle(), "Chatbot page - page title not shown");
	}
	
	// 527 -> Scenario 1, Scenario 2
	// 619 -> Scenario 2
	@Test (groups = {"DMPM-527", "DMPM-1332", "DMPM-1333", "DMPM-619", "DMPM-1347", "marketplace", "Chatbot", "priority-minor"})
	public void testChatbotResponseWithPhNo() {
		navigateToChatbotScreenAsLoggedInUser();
		String userInput = utils.readTestData("chatbot","phNo", "input");
		chatbotPage.enterUserInput(userInput);
		chatbotPage.tapSendButton();
		common.dismissKeyboardShown();
		Assert.assertEquals(chatbotPage.getUserInputQueryValue(), userInput, "Chatbot page - Message bubble not shown");
		Assert.assertNotNull(chatbotPage.checkResponseMessage(), "Chatbot page - Response message bubble from chatbot not shown");
		Assert.assertNotNull(chatbotPage.checkCallNowButton(), "Chatbot page - CALL NOW option not shown");
		chatbotPage.tapCallNowButton();
		// Constructing the ph num element xpath, as it has a dependancy on the test data
		Assert.assertNotNull(chatbotPage.checkPhNumInDialPad(utils.readTestData("chatbot", "phNo", "phone")), "Dial Pad - Correct Ph Num not shown");
	}
	
	// 1466 - Scenario 1, Scenario 2
	@Test (groups = {"DMPM-1466", "DMPM-1525", "DMPM-1526", "marketplace", "Chatbot", "priority-minor"})
	public void testCopyTextContentInBubbleMessage() {
		navigateToChatbotScreenAsLoggedInUser();
		String userInput = utils.readTestData("chatbot","singleResponseFromChatbot", "input");
		chatbotPage.enterUserInput(userInput);
		chatbotPage.tapSendButton();
		common.dismissKeyboardShown();
		Assert.assertEquals(chatbotPage.getUserInputQueryValue(), userInput, "Chatbot page - Message bubble not shown");
		Assert.assertNotNull(chatbotPage.checkResponseMessage(), "Chatbot page - Response message bubble from chatbot not shown");
		
		// copying and pasting user input text
		chatbotPage.copyTextContentInUserInputQuery();
		chatbotPage.tapUserInputField();
		chatbotPage.pasteInuserInputField();
		chatbotPage.tapSendButton();
		common.dismissKeyboardShown();
		// verifying that the pasted text is correct
		int size = chatbotPage.getUserInputQueryValueList().size();
		Assert.assertEquals(chatbotPage.getUserInputQueryValueList().get(size-1), userInput, "Chatbot page - Message bubble not shown");
		
		// copying and pasting chatbot response text
		chatbotPage.copyTextContentInResponseMessage();
		chatbotPage.tapUserInputField();
		chatbotPage.pasteInuserInputField();
		chatbotPage.tapSendButton();
		common.dismissKeyboardShown();
		// verifying that the pasted text is correct
		size = chatbotPage.getUserInputQueryValueList().size();
		Assert.assertEquals(chatbotPage.getUserInputQueryValueList().get(size-1), utils.readTestData("chatbot", "singleResponseFromChatbot", "responses"), "Chatbot page - Message bubble not shown");
	}
	
	private void navigateToChatbotScreenAsLoggedInUser() {
		loginToApp(utils.readTestData("loginCredentials","validLoginCredentials", "login"), utils.readTestData("loginCredentials","validLoginCredentials", "pwd"));
		Assert.assertNotNull(landingPage.checkChatbotOption(), "Landing Page - Chatbot option is not shown");
		landingPage.tapChatbotOption();
	}
	
	private void navigateToChatbotScreenAsGuestUser() {
		welcomePage.tapGuestAccessButton();
		Assert.assertNotNull(landingPage.checkChatbotOption(), "Landing Page - Chatbot option is not shown");
		landingPage.tapChatbotOption();
	}
}
