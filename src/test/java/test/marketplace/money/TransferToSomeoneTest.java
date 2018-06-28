package test.marketplace.money;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import pages.App;

public class TransferToSomeoneTest extends App {

	

	@TestDetails(story1 = "DMPM-5127:DMPM-9915,DMPM-9920")
	@Test(groups = {"marketplace", "Money pillar", "priority-minor"})
	public void TestTransferToSomeone() {
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
		Assert.assertNotNull(moneyPage.checkMoneyDimensionHeader(),
				"Money Pages- Your Accounts header is not shown");
		Assert.assertEquals(moneyPage.getMoneyDimensionHeader(),
				Copy.MONEYDIMENSIONHEADER,"Money Page- Your Accounts header is not shown");
		Assert.assertNotNull(moneyPage.checkTransferPillButton(),
				"Pay/Transfer button is not displayed");		
		moneyPage.tapTransferPillBtn();
		Assert.assertNotNull(moneyPage.checkStartTransferSheetHeading(),
				"Pay/Transfer Sheet title is not displayed");
		moneyPage.tapTransferToOthersButton();
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
		Assert.assertNotNull(transferSummaryPage.checkTransferSummaryTtile(Copy.TRANSFER_SUMMARY_TITLE),"Transfer Summary page title not shown");
		Assert.assertNotNull(transferSummaryPage.checkTransferNowButton(),"Transfer Summary page \"Transfer Now\" button not shown");
	}


	@TestDetails(story1 = "DMPM-5150:DMPM-9933,DMPM-9926,DMPM-9927")
	@Test(groups = {"marketplace", "Money pillar", "priority-minor"})
	public void TestAddNewPayee() {
		String userName = utils.readTestData("addNewPayee","userAccount1","login"),
				pwd = utils.readTestData("addNewPayee","userAccount1", "pwd"),
				fromAccountName= utils.readTestData("addNewPayee","fromAccount", 
						"fromAccountName"),
				InvalidBSBNumber = utils.readTestData("addNewPayee", "BSBErrorFiled", 
						"InvalidBSBNumber"),
				InvalidBSBError = utils.readTestData("addNewPayee", "BSBErrorFiled", 
						"InvalidBSBError"),
				lessThanSixBSBNumber = utils.readTestData("addNewPayee", "BSBErrorFiled", 
						"lessThanSixBSBNumber"),
				lessThanSixBSBError = utils.readTestData("addNewPayee", "BSBErrorFiled", 
						"lessThanSixBSBError"),
				suncropMetwayBSBNumber = utils.readTestData("addNewPayee", "BSBErrorFiled", 
						"suncropMetwayBSBNumber"),
				suncropMetwayName = utils.readTestData("addNewPayee", "BSBErrorFiled", 
						"suncropMetwayName"),
				commbankBSBNumber = utils.readTestData("addNewPayee", "BSBErrorFiled", 
						"commbankBSBNumber"),
				commbankName = utils.readTestData("addNewPayee", "BSBErrorFiled", 
						"commbankName"),
				ANZBSBNumber = utils.readTestData("addNewPayee", "BSBErrorFiled", 
						"ANZBSBNumber"),
				ANZName = utils.readTestData("addNewPayee", "BSBErrorFiled", 
						"ANZName"),
				validAccountName = utils.readTestData("addNewPayee", "AddPayeeFields", 
						"validAccountName"),
				validAccountNumber = utils.readTestData("addNewPayee", "AddPayeeFields", 
						"validAccountNumber");
		navigateToMoney(userName,pwd);
		Assert.assertNotNull(moneyPage.checkMoneyDimensionHeader(),
				"Money Page- Your Accounts header is not shown");
		Assert.assertEquals(moneyPage.getMoneyDimensionHeader(),
				Copy.MONEYDIMENSIONHEADER,"Money Page- Your Accounts header is not shown");
		Assert.assertNotNull(moneyPage.checkTransferPillButton(),
				"Pay/Transfer button is not displayed");		
		moneyPage.tapTransferPillBtn();
		Assert.assertNotNull(moneyPage.checkStartTransferSheetHeading(),
				"Pay/Transfer Sheet title is not displayed");
		moneyPage.tapTransferToOthersButton();
		transferToSomeonePage.tapFromAccountBtn();
		common.waitForLoadingIndicatorToDisappear();
		fromAccountPage.chooseFromAccount(fromAccountName);
		transferToSomeonePage.tapToAccountBtn();
		toAccountPage.addPayee();
		Assert.assertNotNull(addNewPayeePage.checkAddNewPayeeTitle(Copy.ADDNEWPAYEE),
				"Add new payee- ADD PAYEE page title not shown");
		Assert.assertNotNull(addNewPayeePage.checkAddPayeeButton(),
				"Add new payee- ADD PAYEE button not shown");
		Assert.assertEquals(addNewPayeePage.getAddPayeeButton(),
				Copy.ADDNEWPAYEEBUTTONTEXT,"Add new payee- ADD PAYEE button not shown");
		assertAddNewPayeeFields();
		assertAddNewPayeeFiedInputValues();
		assertInstitutionValue(suncropMetwayBSBNumber, suncropMetwayName);
		assertInstitutionValue(commbankBSBNumber, commbankName);
		assertInstitutionValue(ANZBSBNumber, ANZName);
		assertInstitutionValue(InvalidBSBNumber, InvalidBSBError);
		assertInstitutionValue(lessThanSixBSBNumber, lessThanSixBSBError);
		
		//Enter a valid Add Payee fields to check "Add Payee" button status
		assertAccountNameField(validAccountName, validAccountName);
		assertAccountNumberField(validAccountNumber,validAccountNumber);
		assertBSBField(suncropMetwayBSBNumber, suncropMetwayBSBNumber);
		Assert.assertTrue(addNewPayeePage.isAddPayeeEnabled(),
				"Add New Payee page, add payee button is not activated");
		
	}

	private void assertInstitutionValue(String BSBNumber, String expectedInstitutionName) {
		addNewPayeePage.tapBsbField();
		addNewPayeePage.clearBSBField();
		keyboard.sendCharsToKeyboard(BSBNumber);
		addNewPayeePage.tapAccountName();
		common.dismissKeyboardShown();
		Assert.assertNotNull(addNewPayeePage.getExpectedInstitutionName(expectedInstitutionName),
				"Transfer to someone- BSB insititution name is not as expected");
	}

	private void assertAddNewPayeeFiedInputValues() {
		String maxAccountName = utils.readTestData("addNewPayee", "AddPayeeFields", 
				"maxAccountName"),
				moreThanMaxAccountName = utils.readTestData("addNewPayee", "AddPayeeFields", 
						"moreThanMaxAccountName"),
				startingSpacesInAccountName = utils.readTestData("addNewPayee", "AddPayeeFields", 
						"startingSpacesInAccountName"),
				bsbWithHyphen = utils.readTestData("addNewPayee", "AddPayeeFields", 
						"bsbWithHyphen"),
				bsbWithoutHyphen = utils.readTestData("addNewPayee", "AddPayeeFields", 
						"bsbWithoutHyphen"),
				maxAccountNumber =  utils.readTestData("addNewPayee", "AddPayeeFields",
						"maxAccountNumber"),
				moreThanMaxAccountNumber = utils.readTestData("addNewPayee", "AddPayeeFields",
						"moreThanMaxAccountNumber"),
				startingSpaceInAccountNumber = utils.readTestData("addNewPayee", "AddPayeeFields",
						"startingSpaceInAccountNumber"),
				trailingSpacesInAccountName = utils.readTestData("addNewPayee", "AddPayeeFields",
						"trailingSpacesInAccountName"),
				startingAndTrailingSpacesInAccountName = utils.readTestData("addNewPayee", "AddPayeeFields",
						"startingAndTrailingSpacesInAccountName"),
				expectedStartingSpacesInAccountName = utils.readTestData("addNewPayee", "AddPayeeFields",
						"expectedStartingSpacesInAccountName"),
				expectedTrailingSpacesInAccountName = utils.readTestData("addNewPayee", "AddPayeeFields",
						"expectedTrailingSpacesInAccountName"),
				expectedStartingAndTrailingSpacesInAccountName = utils.readTestData("addNewPayee", "AddPayeeFields",
						"expectedStartingAndTrailingSpacesInAccountName"),
				expectedStartingSpaceInAccountNumber = utils.readTestData("addNewPayee", "AddPayeeFields",
						"expectedStartingSpaceInAccountNumber");

		assertAccountNameField(maxAccountName, maxAccountName);
		assertAccountNameField(moreThanMaxAccountName, maxAccountName);
		//MACC-3148 for below three assertions
		assertAccountNameField(startingSpacesInAccountName, expectedStartingSpacesInAccountName);
		assertAccountNameField(trailingSpacesInAccountName, expectedTrailingSpacesInAccountName);
		assertAccountNameField(startingAndTrailingSpacesInAccountName, expectedStartingAndTrailingSpacesInAccountName);
		assertBSBField(bsbWithHyphen,bsbWithHyphen);
		assertBSBField(bsbWithoutHyphen,bsbWithHyphen);
		assertAccountNumberField(maxAccountNumber,maxAccountNumber);
		assertAccountNumberField(moreThanMaxAccountNumber,maxAccountNumber);
		//MACC-3148 for below assertion
		assertAccountNumberField(startingSpaceInAccountNumber,expectedStartingSpaceInAccountNumber);
	}

	private void assertBSBField(String inputBSB, String expectedBSB) {
		addNewPayeePage.tapBsbField();
		addNewPayeePage.clearBSBField();
		keyboard.sendCharsToKeyboard(inputBSB);
		addNewPayeePage.tapAccontNumberField();
		common.dismissKeyboardShown();
		Assert.assertEquals(addNewPayeePage.getBsbFiledValue(),expectedBSB,
				"Transfer to someone- BSB field value is not as expected");
	}


	private void assertAccountNumberField(String inputAccountNumber, String expectedAccountNumber) {
		addNewPayeePage.tapAccontNumberField();
		addNewPayeePage.clearAccountNumberField();
		keyboard.sendCharsToKeyboard(inputAccountNumber);
		addNewPayeePage.tapBsbField();
		common.dismissKeyboardShown();
		Assert.assertEquals(addNewPayeePage.getAccontNumberFieldValue(),expectedAccountNumber,
				"Transfer to someone- Account number field value is not as expected");
	}

	private void assertAccountNameField(String accountName, String expectedAccountName) {
		addNewPayeePage.tapAccountName();
		addNewPayeePage.clearAccountName();
		keyboard.sendCharsToKeyboard(accountName);
		addNewPayeePage.tapBsbField();
		Assert.assertTrue(addNewPayeePage.getAccountFiledValue().length()<=26,
				"Description field has more than 26 charactors");
		common.dismissKeyboardShown();
		Assert.assertEquals(addNewPayeePage.getAccountFiledValue(),expectedAccountName,
				"Transfer to someone- Account name field value is not as expected");
	}

	private void assertAddNewPayeeFields() {
		Assert.assertNotNull(addNewPayeePage.checkAccountNameInput(),
				"Add new payee- Account name field not shown");
		Assert.assertEquals(addNewPayeePage.getAccountNameInput(),Copy.ADDPAYEEACCOUNTNAME,
				"Add new payee- Account name title not as expected");
		Assert.assertNotNull(addNewPayeePage.checkBsbInput(),
				"Add new payee- BSB field not shown");
		Assert.assertEquals(addNewPayeePage.getBsbInput(),Copy.ADDPAYEEBSB,
				"Add new payee- BSB title not as expected");
		Assert.assertNotNull(addNewPayeePage.checkAccountNumberInput(),
				"Add new payee- account number field not shown");
		Assert.assertEquals(addNewPayeePage.getAccountNumberInput(),Copy.ADDPAYEEACCOUNTNUMBER,
				"Add new payee- account number title not as expected");
		Assert.assertNotNull(addNewPayeePage.isSaveSwitchStatusON(),
				"Add new payee- Save payee switch is not ON by default");
		Assert.assertNotNull(addNewPayeePage.isSwitchClickable(),
				"Add new payee- Save payee switch is clickable");
		Assert.assertNotNull(addNewPayeePage.checkSaveToAddressSwitch(),
				"Add new payee- Save Payee switch not shown");
		Assert.assertEquals(addNewPayeePage.getSaveToAddressSwitch(),Copy.ADDPAYEESWITCHON,
				"Add new payee-Save Payee switch text is not as expected");
		Assert.assertNotNull(addNewPayeePage.checkAddPayeeButton(),
				"Add new payee- Save Payee button not shown");
		Assert.assertEquals(addNewPayeePage.getAddPayeeButton(),Copy.ADDPAYEEBUTTON,
				"Add new payee-Save Payee button text is not as expected");
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

		assertDescriptionField(validDescription, validDescription);
		assertDescriptionField(specialCharDescriptionOne, expectedSpecialCharDescriptionOne);
		assertDescriptionField(specialCharDescriptionTwo, expectedSpecialCharDescriptionTwo);
		assertDescriptionField(alphaNumericDescriptionOne, alphaNumericDescriptionOne);
		assertDescriptionField(alphaNumericDescriptionTwo, alphaNumericDescriptionTwo);
		assertDescriptionField(moreThanEighteenCharDescription, expectedMoreThanEighteenCharDescription);
		assertDescriptionField(eighteenCharDescription, expectedEighteenCharDescription);
		assertDescriptionField(oneCharDescription, oneCharDescription);
		transferToSomeonePage.enterDescription();
		keyboard.sendCharsToKeyboard(validDescription);
		common.dismissKeyboardShown();
	}

	private void assertDescriptionField(String inputDescription, String expectedDescription) {
		transferToSomeonePage.enterDescription();
		keyboard.sendCharsToKeyboard(inputDescription);
		transferToSomeonePage.tapAmount();
		Assert.assertEquals(transferToSomeonePage.getTransferDescriptionText(), expectedDescription,
				"Transfer to someone- Transfer to someone- Description value is not as expected");
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

		assertAmountField(equalToMinimumAmount, verifyEqualToMinimumAmount);

		assertAmountField(equalToMaximumAmount, verifyEqualToMaximumAmount);

		assertAmountField(twoDecimalAmount, verifyTwoDecimalAmount);

		assertAmountField(oneDecimalAmount, verifyOneDecimalAmount);

		assertAmountField(lessThanMinimumAmount, verifyLessThanMinimumAmount);
		assertAmountField(negativeAmount, verifyNegativeAmount);
		assertAmountField(moreThanAvailableBalance, verifyMoreThanAvailableBalance);
		assertAmountField(moreThanEightDigitAmount, verifyMoreThanEightDigitAmount);
		assertAmountField(moreThanTwoDecimalAmount, verifyMoreThanTwoDecimalAmount);
		assertAmountField(OnlyDecimal, verifyOnlyDecimal);

		transferToSomeonePage.selectAmountField();
		keyboard.sendCharsToKeyboard(validAmount);
		common.dismissKeyboardShown();
	}

	private void assertAmountField(String inputAmount, String expectedAmount) {
		transferToSomeonePage.selectAmountField();
		keyboard.sendCharsToKeyboard(inputAmount);
		transferToSomeonePage.tapDescription();
		Assert.assertEquals(transferToSomeonePage.getTransferAmountField(), expectedAmount,
				"Transfer to someone- amount field value is not shown as expected");
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

	private void assertFormAccountsUIScreen(String accountName, String bsb, String accountNumber, 
			String availableBalance) {

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
		Assert.assertEquals(transferToSomeonePage.getFromAccountTitle(),Copy.FROMACCOUNTBUTTONTEXT,
				"Transfer money to others, pay From account title is not as expected");
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
