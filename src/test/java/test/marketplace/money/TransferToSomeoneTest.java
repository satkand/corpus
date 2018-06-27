package test.marketplace.money;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import pages.App;
import pages.marketplace.common.Keyboard;

public class TransferToSomeoneTest extends App {

	@TestDetails(story1 = "DMPM-5127:DMPM-9915,DMPM-9920")
	@Test(groups = {"marketplace", "Money pillar", "priority-minor"})
	public void TestViewPendingAndPostedTransactions() {
		String userName = utils.readTestData("transferToOthers","userAccount1","login"),
				pwd = utils.readTestData("transferToOthers","userAccount1","pwd"),
				accountNumberOne =utils.readTestData("transferToOthers","accountOne","accountNumber"),
				fromAccountNameOne = utils.readTestData("transferToOthers","accountOne","accountName"),
				bsbOne = utils.readTestData("transferToOthers","accountOne","bsb"),
				availableBalanceOne= utils.readTestData("transferToOthers","accountOne","availableBalance"),
				accountNumberTwo =utils.readTestData("transferToOthers","accountTwo","accountNumber"),
				fromAccountNameTwo = utils.readTestData("transferToOthers","accountTwo","accountName"),
				bsbTwo = utils.readTestData("transferToOthers","accountTwo","bsb"),
				availableBalanceTwo= utils.readTestData("transferToOthers","accountTwo","availableBalance"),
				toAccountName = utils.readTestData("transferToOthers","toAccount","toAccountTitle");

		navigateToMoney(userName,pwd);
		Assert.assertNotNull(financePage.checkMoneyDimensionHeader(),"Finances- Your Accounts header is not shown");
		Assert.assertEquals(financePage.getMoneyDimensionHeader(),
				Copy.MONEYDIMENSIONHEADER,"Finances- Your Accounts header is not shown");
		Assert.assertNotNull(financePage.checkTransferPillButton(),
				"Pay/Transfer button is not displayed");		
		financePage.tapTransferPillBtn();
		Assert.assertNotNull(financePage.checkStartTransferSheetHeading(),
				"Pay/Transfer Sheet title is not displayed");
		financePage.tapTransferToOthersButton();
		assertTransferToOthersScreen();
		transferToSomeonePage.tapFromAccountBtn();
		common.waitForLoadingIndicatorToDisappear();
		//transferToSomeonePage.scrollToFromAccount(fromAccountNameOne);
		assertFormAccountsUIScreen(fromAccountNameOne, bsbOne, accountNumberOne, availableBalanceOne);
		transferToSomeonePage.scrollToFromAccount(fromAccountNameTwo);
		transferToSomeonePage.selectFromAccount(accountNumberTwo);
		assertSelectedFromAccountDetails(fromAccountNameTwo, bsbTwo, accountNumberTwo, availableBalanceTwo);
		assertElementEnabledStatus();
		if(transferToSomeonePage.checkToAccountButton()!=null) {
			transferToSomeonePage.tapToAccountBtn();
		}
		transferToSomeonePage.selectToAccount(toAccountName);
		Assert.assertTrue(transferToSomeonePage.isKeyboardShown(), "Keyboard not shown");
		verifyAmountFieldValues();
		transferToSomeonePage.dissmissKeyBoard();
		verifyDescriptionValues();
		transferToSomeonePage.dissmissKeyBoard();
		transferToSomeonePage.tapNext();
		Assert.assertNotNull(transferSummaryPage.checkTransferSummaryTtile(Copy.TRANSFER_SUMMARY_TITLE),"");
		Assert.assertNotNull(transferSummaryPage.checkTransferNowButton(),"");
	}

	private void verifyDescriptionValues() {
		String validDescription =  utils.readTestData("transferToOthers","description","validDescription"),
				specialCharDescriptionOne =  utils.readTestData("transferToOthers","description",
						"specialCharDescriptionOne"),
				specialCharDescriptionTwo =  utils.readTestData("transferToOthers","description",
						"specialCharDescriptionTwo"),
				oneCharDescription =  utils.readTestData("transferToOthers","description",
						"oneCharDescription"),
				eighteenCharDescription =  utils.readTestData("transferToOthers","description",
						"eighteenCharDescription"),
				alphaNumericDescriptionOne = utils.readTestData("transferToOthers","description",
						"alphaNumericDescriptionOne"),
				alphaNumericDescriptionTwo = utils.readTestData("transferToOthers","description",
						"alphaNumericDescriptionTwo"),
				moreThanEighteenCharDescription = utils.readTestData("transferToOthers","description",
						"moreThanEighteenCharDescription"),
				expectedSpecialCharDescriptionOne = utils.readTestData("transferToOthers","description",
						"expectedSpecialCharDescriptionOne"),
				expectedSpecialCharDescriptionTwo = utils.readTestData("transferToOthers","description",
						"expectedSpecialCharDescriptionTwo"),
				expectedEighteenCharDescription = utils.readTestData("transferToOthers","description",
						"expectedEighteenCharDescription"),
				expectedMoreThanEighteenCharDescription= utils.readTestData("transferToOthers","description",
						"expectedMoreThanEighteenCharDescription");
		transferToSomeonePage.enterDescription();
		enterAmount(validDescription);
		//transferToSomeonePage.enterDescription(validDescription);
		transferToSomeonePage.tapAmount();
		Assert.assertEquals(transferToSomeonePage.getTransferDescriptionText(), validDescription,
				"Transfer to someone- valid description is not as expected");

		transferToSomeonePage.enterDescription();
		enterAmount(specialCharDescriptionOne);
		//transferToSomeonePage.enterDescription(specialCharDescriptionOne);
		transferToSomeonePage.tapAmount();
		Assert.assertEquals(transferToSomeonePage.getTransferDescriptionText(), expectedSpecialCharDescriptionOne,
				"Transfer to someone- specialchar description is not as expected");

		transferToSomeonePage.enterDescription();
		enterAmount(specialCharDescriptionOne);
		//transferToSomeonePage.enterDescription(oneCharDescription);
		transferToSomeonePage.tapAmount();
		Assert.assertEquals(transferToSomeonePage.getTransferDescriptionText(), expectedSpecialCharDescriptionOne,
				"Transfer to someone- one description is not as expected");

		transferToSomeonePage.enterDescription();
		enterAmount(specialCharDescriptionTwo);
		//transferToSomeonePage.enterDescription(oneCharDescription);
		transferToSomeonePage.tapAmount();
		Assert.assertEquals(transferToSomeonePage.getTransferDescriptionText(), expectedSpecialCharDescriptionTwo,
				"Transfer to someone- specialchar description is not as expected");

		transferToSomeonePage.enterDescription();
		enterAmount(eighteenCharDescription);
		transferToSomeonePage.tapAmount();
		Assert.assertEquals(transferToSomeonePage.getTransferDescriptionText(), expectedEighteenCharDescription,
				"Transfer to someone- eighteen char description is not as expected");

		transferToSomeonePage.enterDescription();
		enterAmount(alphaNumericDescriptionOne);
		transferToSomeonePage.tapAmount();
		Assert.assertEquals(transferToSomeonePage.getTransferDescriptionText(), alphaNumericDescriptionOne,
				"Transfer to someone- alphanumeric description is not as expected");

		transferToSomeonePage.enterDescription();
		enterAmount(alphaNumericDescriptionTwo);
		transferToSomeonePage.tapAmount();
		Assert.assertEquals(transferToSomeonePage.getTransferDescriptionText(), alphaNumericDescriptionTwo,
				"Transfer to someone- alphanumeric description is not as expected");

		transferToSomeonePage.enterDescription();
		enterAmount(moreThanEighteenCharDescription);
		transferToSomeonePage.tapAmount();
		Assert.assertEquals(transferToSomeonePage.getTransferDescriptionText(), expectedMoreThanEighteenCharDescription,
				"Transfer to someone- more than eighteen char description is accepted!");

		transferToSomeonePage.enterDescription();
		enterAmount(validDescription);
	}
	private void verifyAmountFieldValues() {
		String equalToMinimumAmount =  utils.readTestData("transferToOthers","amount","equalToMinimumAmount"),
				equalToMaximumAmount =  utils.readTestData("transferToOthers","amount","equalToMaximumAmount"),
				twoDecimalAmount =  utils.readTestData("transferToOthers","amount","TwoDecimalAmount"),
				oneDecimalAmount =   utils.readTestData("transferToOthers","amount","OneDecimalAmount"),
				lessThanMinimumAmount =   utils.readTestData("transferToOthers","amount","lessThanMinimumAmount"),
				negativeAmount =   utils.readTestData("transferToOthers","amount","negativeAmount"),
				moreThanAvailableBalance =   utils.readTestData("transferToOthers","amount","moreThanAvailableBalance"),
				moreThanEightDigitAmount =  utils.readTestData("transferToOthers","amount","moreThanEightDigitAmount"),
				moreThanTwoDecimalAmount =   utils.readTestData("transferToOthers","amount","moreThanTwoDecimalAmount"),
				OnlyDecimal =   utils.readTestData("transferToOthers","amount","OnlyDecimal"),
				verifyEqualToMinimumAmount =  utils.readTestData("transferToOthers","amount","verifyEqualToMinimumAmount"),
				verifyEqualToMaximumAmount =  utils.readTestData("transferToOthers","amount","verifyEqualToMaximumAmount"),
				verifyTwoDecimalAmount =  utils.readTestData("transferToOthers","amount","verifyTwoDecimalAmount"),
				verifyOneDecimalAmount =   utils.readTestData("transferToOthers","amount","verifyOneDecimalAmount"),
				verifyLessThanMinimumAmount =   utils.readTestData("transferToOthers","amount","verifyLessThanMinimumAmount"),
				verifyNegativeAmount =   utils.readTestData("transferToOthers","amount","verifyNegativeAmount"),
				verifyMoreThanAvailableBalance =   utils.readTestData("transferToOthers","amount","verifyMoreThanAvailableBalance"),
				verifyMoreThanEightDigitAmount =  utils.readTestData("transferToOthers","amount","verifyMoreThanEightDigitAmount"),
				verifyMoreThanTwoDecimalAmount =   utils.readTestData("transferToOthers","amount","verifyMoreThanTwoDecimalAmount"),
				verifyOnlyDecimal =   utils.readTestData("transferToOthers","amount","verifyOnlyDecimal"),
				validAmount = utils.readTestData("transferToOthers","amount","validAmount");
		enterAmount(equalToMinimumAmount);
		transferToSomeonePage.tapDescription();
		Assert.assertEquals(transferToSomeonePage.getTransferAmountField(), verifyEqualToMinimumAmount,
				"Transfer to someone- equal to minimum amount is not as expected");

		transferToSomeonePage.selectAmountField();
		enterAmount(equalToMaximumAmount);
		transferToSomeonePage.tapDescription();
		Assert.assertEquals(transferToSomeonePage.getTransferAmountField(), verifyEqualToMaximumAmount,
				"Transfer to someone- equal to maximum amount is not as expected");

		transferToSomeonePage.selectAmountField();
		enterAmount(twoDecimalAmount);
		transferToSomeonePage.tapDescription();
		Assert.assertEquals(transferToSomeonePage.getTransferAmountField(), verifyTwoDecimalAmount,
				"Transfer to someone- two decimal amount is not as expected");

		transferToSomeonePage.selectAmountField();
		enterAmount(oneDecimalAmount);
		transferToSomeonePage.tapDescription();
		Assert.assertEquals(transferToSomeonePage.getTransferAmountField(), verifyOneDecimalAmount,
				"Transfer to someone- one decimal amount is not as expected");

		transferToSomeonePage.selectAmountField();
		enterAmount(lessThanMinimumAmount);
		transferToSomeonePage.tapDescription();
		Assert.assertEquals(transferToSomeonePage.getAmountFieldInputError(), verifyLessThanMinimumAmount,
				"Transfer to someone- less than minimum amount is not as expected");

		transferToSomeonePage.selectAmountField();
		enterAmount(negativeAmount);
		transferToSomeonePage.tapDescription();
		Assert.assertEquals(transferToSomeonePage.getTransferAmountField(), verifyNegativeAmount,
				"Transfer to someone- negative amount is not as expected");

		transferToSomeonePage.selectAmountField();
		enterAmount(moreThanAvailableBalance);
		transferToSomeonePage.tapDescription();
		Assert.assertEquals(transferToSomeonePage.getAmountFieldInputError(), verifyMoreThanAvailableBalance,
				"Transfer to someone- more than availablebalance amount is accepted!");

		transferToSomeonePage.selectAmountField();
		enterAmount(moreThanEightDigitAmount);
		transferToSomeonePage.tapDescription();
		Assert.assertEquals(transferToSomeonePage.getTransferAmountField(), verifyMoreThanEightDigitAmount,
				"Transfer to someone- more than eight digit amount is not accepted");

		transferToSomeonePage.selectAmountField();
		enterAmount(moreThanTwoDecimalAmount);
		transferToSomeonePage.tapDescription();
		Assert.assertEquals(transferToSomeonePage.getTransferAmountField(), verifyMoreThanTwoDecimalAmount,
				"Transfer to someone- more than two decimal amount is not accepted");

		transferToSomeonePage.selectAmountField();
		enterAmount(OnlyDecimal);
		transferToSomeonePage.tapDescription();
		Assert.assertEquals(transferToSomeonePage.getAmountFieldInputError(), verifyOnlyDecimal,
				"Transfer to someone- decimal amount is not accepted");

		transferToSomeonePage.selectAmountField();
		enterAmount(validAmount);
	}
	private void enterAmount(String amount) {
		for(int i=0;i<amount.length();i++) {
			keyboard.enterKeyUsingKeyboard(amount.charAt(i));
		}

	}
	private void assertElementEnabledStatus() {
		Assert.assertTrue(transferToSomeonePage.isToAccountBtnEnabled(),
				"Transfer money to other, TO account is enabled");
		Assert.assertFalse(transferToSomeonePage.isTransferAmountFieldEnabled(),
				"Transfer money to other, Amount field is enabled");
		Assert.assertFalse(transferToSomeonePage.isTransferDescriptionFieldEnabled(),
				"Transfer money to other, Description field is enabled");
		Assert.assertFalse(transferToSomeonePage.isTransferSummaryButtonEnabled(),
				"Transfer money to other, Next button is enabled");

	}
	private void assertSelectedFromAccountDetails(String accountName, String bsb, String accountNumber, String availableBalance) {
		Assert.assertNotNull(transferToSomeonePage.CheckAccountNameText(),
				"Transfer money to other, pay From account title not shown");
		Assert.assertEquals(transferToSomeonePage.getAccountNameText(),accountName,
				"Transfer money to other, pay From account title not shown");
		Assert.assertNotNull(transferToSomeonePage.CheckAccountBsb(),
				"Transfer money to other, pay From account title not shown");
		Assert.assertEquals(transferToSomeonePage.getAccountBsbText(),bsb,
				"Transfer money to other, pay From account title not shown");
		Assert.assertNotNull(transferToSomeonePage.CheckAccountNumber(),
				"Transfer money to other, pay From account title not shown");
		Assert.assertEquals(transferToSomeonePage.getAccountNumber(),accountNumber,
				"Transfer money to other, pay From account title not shown");
		Assert.assertNotNull(transferToSomeonePage.checkAvailableBalance(),
				"Transfer money to other, pay From account title not shown");
		Assert.assertEquals(transferToSomeonePage.getAvailableBalance(), availableBalance,
				"Transfer money to other, pay From account title not shown");

	}
	private void assertFormAccountsUIScreen(String accountName, String bsb, String accountNumber, String availableBalance) {

		Assert.assertNotNull(transferToSomeonePage.CheckAccountNameText(),
				"Transfer money to other, pay From account title not shown");
		Assert.assertEquals(transferToSomeonePage.getAccountNameText(),accountName,
				"Transfer money to other, pay From account title not shown");
		Assert.assertNotNull(transferToSomeonePage.CheckAccountIconImage(),
				"Transfer money to other, pay From account title not shown");
		Assert.assertNotNull(transferToSomeonePage.CheckAccountBsb(),
				"Transfer money to other, pay From account title not shown");
		Assert.assertEquals(transferToSomeonePage.getAccountBsbText(),bsb,
				"Transfer money to other, pay From account title not shown");
		Assert.assertNotNull(transferToSomeonePage.CheckAccountNumber(),
				"Transfer money to other, pay From account title not shown");
		Assert.assertEquals(transferToSomeonePage.getAccountNumber(),accountNumber,
				"Transfer money to other, pay From account title not shown");
		Assert.assertNotNull(transferToSomeonePage.checkAvailableBalance(),
				"Transfer money to other, pay From account title not shown");
		Assert.assertEquals(transferToSomeonePage.getAvailableBalance(), availableBalance,
				"Transfer money to other, pay From account title not shown");

	}
	private void assertTransferToOthersScreen() {
		Assert.assertNotNull(transferToSomeonePage.checkFromAccountTitle(),
				"Transfer money to other, pay From account title not shown");
		Assert.assertEquals(transferToSomeonePage.getFromAccountTitle(),
				Copy.FROMACCOUNTTITLE,"Transfer money to other, pay From account title is not as expected");
		Assert.assertNotNull(transferToSomeonePage.checkFromAccountButton(),
				"Transfer money to other, FROM account button not shown");
		Assert.assertNotNull(transferToSomeonePage.checkFromAccountButtonIcon(),
				"Transfer money to other, FROM accoutnbutton Icon not shown");
		Assert.assertNotNull(policyDetailsPage.checkPolicyDetailsScreenTitle(Copy.FROMACCOUNTBUTTONTEXT),
				"Transfer money to other, pay From account title is not as expected");
		Assert.assertEquals(transferToSomeonePage.getFromAccountBtnText(),
				Copy.FROMACCOUNTBUTTONTEXT,"Transfer money to other,  FROM account button text is not as expected");
		Assert.assertTrue(transferToSomeonePage.isFromAccountBtnEnabled(),
				"Transfer money to other,  FROM account button is Enabled as expected");
		Assert.assertNotNull(transferToSomeonePage.checkToAccountTitle(),
				"Transfer money to other, pay To account title not shown");
		Assert.assertEquals(transferToSomeonePage.getToAccountTitle(),Copy.TOMACCOUNTTITLE, "Transfer money to other, TO account title text is not as expected");
		Assert.assertNotNull(transferToSomeonePage.checkToAccountButton(),
				"Transfer money to other, TO account button is not shown");
		Assert.assertNotNull(transferToSomeonePage.checkToAccountButtonIcon(),"Transfer money to other, TO account button ICON not shown");
		Assert.assertEquals(transferToSomeonePage.getToAccountBtnText(),
				Copy.FROMACCOUNTBUTTONTEXT, "Transfer money to other, TO account button text is not as expected");
		Assert.assertFalse(transferToSomeonePage.isToAccountBtnEnabled(),
				"Transfer money to other, TO account is enabled");
		Assert.assertNotNull(transferToSomeonePage.checkTransferAmountField(),
				"Transfer money to other, Amount field not shown");
		Assert.assertEquals(transferToSomeonePage.getTransferAmountInputLayoutDefaultText(), 
				Copy.AMOUNTDEFAULT, "Transfer money to other, Amount field default text not as expected");
		Assert.assertFalse(transferToSomeonePage.isTransferAmountFieldEnabled(),
				"Transfer money to other, Amount field is enabled");
		Assert.assertNotNull(transferToSomeonePage.checkTransferDescription(),
				"Transfer money to other, Description field not shown");
		Assert.assertEquals(transferToSomeonePage.getTransferDescriptionDefaultText(), 
				Copy.DESCRIPTIONDEFASULTTEXT, "Transfer money to other, "
						+ "Description field default text not as expected");
		Assert.assertFalse(transferToSomeonePage.isTransferDescriptionFieldEnabled(),
				"Transfer money to other, Description field is enabled");
		Assert.assertNotNull(transferToSomeonePage.checkTransferSummaryButton(),
				"Transfer money to other, Next button not shown");
		Assert.assertEquals(transferToSomeonePage.getTransferSummaryButtonText(),
				Copy.NEXTBUTTONTEXT, "Transfer money to other, Next button text is not as expected");
		Assert.assertFalse(transferToSomeonePage.isTransferSummaryButtonEnabled(),
				"Transfer money to other, Next button is enabled");
	}
	private void navigateToMoney(String userName, String pwd) {
		loginToApp(userName,pwd);
		landingPage.tapMoneyTab();
		common.checkLoadingIndicator();
		common.waitForLoadingIndicatorToDisappear();
	}

}
