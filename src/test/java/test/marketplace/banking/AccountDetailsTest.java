package test.marketplace.banking;

import org.testng.annotations.Test;

import org.testng.Assert;

import pages.App;

public class AccountDetailsTest extends App {

	/* Common method to navigate to the Banking Home screen */

	private void navigatingToBankingHome() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen -Suncorp image is not shown");
		welcomePage.tapGuestAccessButton();
		Assert.assertNotNull(navigationMenu.checkSplitMenuIcon(), "Guest Landing Page - menu icon not shown");
		Assert.assertNotNull(landingPage.checkGuestAccessPageTitle(), "Guest Landing page - Page Title not shown");
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkBankingHomeButton(), "Banking Home button not shown in the menu");
		navigationMenu.tapBankingHomeButton();
		Assert.assertNotNull(bankingHomePage.checkBankingHomeTitle(), "Banking Home page - Banking Home Screen not reached");
	}

	//TODO: New Ids and Xpaths to be added to the screen

	@Test (groups = {"DMPM-906", "marketplace", "FFI", "priority-minor"})
	public void testLineCreditAccount(){

		navigatingToBankingHome();

		Assert.assertNotNull(bankingHomePage.checkPaysomeoneButton(), "Banking Home page did not load");
		//Assert.assertNotNull(accountsPage.checkHomeLoanAccounts(), "Loan accounts not shown");

		bankingHomePage.tapMyLineOfCreditAccount();

		// Scenario-3 - Account Nickname

		Assert.assertNotNull(accountsPage.checkLineAccountHeader(), "Line of Credit Account display header not shown");

		// Scenario 1 - Select a Loan account to view

		Assert.assertNotNull(accountsPage.checkAccountDetailsPageBackButton(), "Line of Credit Account - Back button not displayed");
		Assert.assertNotNull(accountsPage.checkAccountDetailsPageTitle(), "Line of Credit Account - Accounts Details page title is not correct");
		Assert.assertNotNull(accountsPage.checkLineAccountHeader(), "Line of Credit Account - Line of Credit Account display header not shown");
		Assert.assertNotNull(accountsPage.checkBsbNumberHeader(), "Line of Credit Account - BSB number header not displayed");
		Assert.assertNotNull(accountsPage.checkAccountNumberHeader(), "Line of Credit Account - Account number header not displayed");
		Assert.assertNotNull(accountsPage.checkAccountTitle(), "Line of Credit Account - Account title not displayed");
		Assert.assertNotNull(accountsPage.checkAvailableBalanceHeader(), "Line of Credit Account - Available Balance not dispalyed");
		Assert.assertNotNull(accountsPage.checkCurrentBalanceHeader(), "Line of Credit Account - Current Balance Header not displayed");
		Assert.assertNotNull(accountsPage.checkPayTrasferButton(), "Line of Credit Account - Pay/Transfer button not displayed");
		Assert.assertNotNull(accountsPage.checkMoreOptionsButton(), "Line of Credit Account - More options button not displayed");


		Assert.assertEquals(accountsPage.getBsbNumberValue(), utils.readTestData("bankingHome", "lineOfCreditAccounts", "BSB") , "Line of Credit Account - BSB does not match");
		Assert.assertEquals(accountsPage.getAccountNumberValue(), utils.readTestData("bankingHome", "lineOfCreditAccounts", "ACC"), "Line of Credit Account - Account number does not match");
		Assert.assertEquals(accountsPage.getAccountProductType(), utils.readTestData("bankingHome", "lineOfCreditAccounts", "Account Product Type"), "Line of Credit Account - Account Product type not displayed");
		Assert.assertEquals(accountsPage.getAvailableBalanceValue(), utils.readTestData("bankingHome", "lineOfCreditAccounts", "Available Balance"), "Line of Credit Account - Account Available Balance value not displayed");
		Assert.assertEquals(accountsPage.getCurrentBalanceValue(), utils.readTestData("bankingHome", "lineOfCreditAccounts", "Current Balance"), "Line of Credit Account - Account Current Balance value not displayed");


		/* Credit Limit section */
		Assert.assertNotNull(accountsPage.checkCreditLimitHeader(), "Line of Credit Account - Credit Limit header not displayed");
		Assert.assertNotNull(accountsPage.checkCreditLimitMinBalance(),"Line of Credit Account - Minimum Balance header not displayed");
		String creditMinBalance = utils.readTestData("bankingHome", "lineOfCreditAccounts", "Line of Credit Account - Credit Min Value");
		//Assert.assertEquals(accountsPage.getCreditLimitMinBalanceValue(), creditMinBalance, "Line of Credit Account - Minimum credit value not retrieved");
		Assert.assertNotNull(accountsPage.checkCreditLimitMaxBalance(),"Line of Credit Account - Maximum Balance header not displayed");
		String creditMaxBalance = utils.readTestData("bankingHome", "lineOfCreditAccounts", "Line of Credit Account - Credit Max Value");
		//Assert.assertEquals(accountsPage.getCreditLimitMaxBalanceValue(), creditMaxBalance, "Line of Credit Account - Maximum credit value not retrieved");


		/* Line of Credit Details section */

		Assert.assertNotNull(accountsPage.checkLineOfCredit(), "Line of Credit Account - Line of Credit header not displayed");

		Assert.assertNotNull(accountsPage.checkDebitInterestRateHeader(),"Line of Credit Account - Debit Interest Rate header not displayed");
		String debitInterestRateValue = utils.readTestData("bankingHome", "lineOfCreditAccounts", "Line of Credit Account - Debit Interest Rate");
		//Assert.assertEquals(accountsPage.getDebitInterestRateValue(), debitInterestRateValue, "Line of Credit Account - Debit Interest Rate Value not displayed");

		Assert.assertNotNull(accountsPage.checkInterestRateTypeHeader(),"Line of Credit Account - Interest Rate Type header not displayed");
		String interestRateType = utils.readTestData("bankingHome", "lineOfCreditAccounts", "Line of Credit Account - Interest Rate Type");
		//Assert.assertEquals(accountsPage.getInterestRateTypeValue(), interestRateType, "Line of Credit Account - Interest Rate Type value not displayed");

		Assert.assertNotNull(accountsPage.checkTermLengthHeader(),"Line of Credit Account - Term length header not displayed");
		String termLengthValue = utils.readTestData("bankingHome", "lineOfCreditAccounts", "Line of Credit Account - Term Length");
		//Assert.assertEquals(accountsPage.getTermLengthValue(), termLengthValue, "Line of Credit Account - Term length value not displayed");

		Assert.assertNotNull(accountsPage.checkTermExpiryDateHeader(),"Line of Credit Account - Term expiry date header not displayed");
		String termExpiryDate = utils.readTestData("bankingHome", "lineOfCreditAccounts", "Line of Credit Account - Term Expiry Date");
		//Assert.assertEquals(accountsPage.getTermExpiryDateValue(), termExpiryDate, "Line of Credit Account - Term expiry date value not displayed");

		Assert.assertNotNull(accountsPage.checkLoanPurposeHeader(),"Line of Credit Account - Loan purpose header not displayed");
		String loanPurpose = utils.readTestData("bankingHome", "lineOfCreditAccounts", "Line of Credit Account - Loan Purpose");
		//Assert.assertEquals(accountsPage.getLoanPurposeValue(), loanPurpose, "Line of Credit Account - Loan purpose value not displayed");


		/* Current Year */

		Assert.assertNotNull(accountsPage.checkCurrentYearHeader(), "Line of Credit Account - Current Year header not displayed");

		Assert.assertNotNull(accountsPage.checkCurrentYearInterestEarnedHeader(), "Line of Credit Account - Current Year Interest Earned header not displayed");
		String currentYearInterestEarned = utils.readTestData("bankingHome", "lineOfCreditAccounts", "");
		//Assert.assertEquals(accountsPage.getCurrentYearInterestEarnedValue(), currentYearInterestEarned, "Line of Credit Account - Current Year Interest Earned value not displayed");

		Assert.assertNotNull(accountsPage.checkCurrentYearInterestPaidHeader(), "Line of Credit Account - Current Year Interest Paid header not displayed");
		String currentYearInterestPaid = utils.readTestData("bankingHome", "lineOfCreditAccounts", "");
		//Assert.assertEquals(accountsPage.getCurrentYearInterestPaidValue(), currentYearInterestPaid, "Line of Credit Account - Current Year Interest Paid value not displayed");

		Assert.assertNotNull(accountsPage.checkCurrentYearResidentTaxWithholdingHeader(), "Line of Credit Account - Current Year Resident Tax Withholding header not displayed");
		String currentYearResidentTaxWithholding = utils.readTestData("bankingHome", "lineOfCreditAccounts", "");
		//Assert.assertEquals(accountsPage.getCurrentYearResidentTaxWithholdingValue(), currentYearResidentTaxWithholding, "Line of Credit Account- Current Year Resident Tax Withholding value not displayed");

		Assert.assertNotNull(accountsPage.checkCurrentYearNonResidentTaxWithholdingHeader(), "Line of Credit Account - Current Year Non Resident Tax Withholding header not displayed");
		String currentYearNonResidentTaxWithholding = utils.readTestData("bankingHome", "lineOfCreditAccounts", "");
		//Assert.assertEquals(accountsPage.getCurrentYearNonResidentTaxWithholdingValue(), currentYearNonResidentTaxWithholding, "Line of Credit Account - Current Year Non Resident Tax Withholding value not displayed");


		/* Last Year */

		Assert.assertNotNull(accountsPage.checkLastYearHeader(), "Line of Credit Account - Last Year header not displayed");

		Assert.assertNotNull(accountsPage.checkLastYearInterestEarnedHeader(), "Line of Credit Account - Last Year Interest Earned header not displayed");
		String lastYearInterestEarned = utils.readTestData("bankingHome", "lineOfCreditAccounts", "");
		//Assert.assertEquals(accountsPage.getLastYearInterestEarnedValue(), lastYearInterestEarned, "Line of Credit Account - Last Year Interest Earned value not displayed");

		Assert.assertNotNull(accountsPage.checkLastYearInterestPaidHeader(), "Line of Credit Account - Last Year Interest Paid header not displayed");
		String lastYearInterestPaid = utils.readTestData("bankingHome", "lineOfCreditAccounts", "");
		//Assert.assertEquals(accountsPage.getLastYearInterestPaidValue(), lastYearInterestPaid, "Line of Credit Account - Last Year Interest Paid value not displayed");

		Assert.assertNotNull(accountsPage.checkLastYearResidentTaxWithholdingHeader(), "Line of Credit Account- Last Year Resident Tax Withholding header not displayed");
		String lastYearResidentTaxWithholding = utils.readTestData("bankingHome", "lineOfCreditAccounts", "");
		//Assert.assertEquals(accountsPage.getLastYearResidentTaxWithholdingValue(), lastYearResidentTaxWithholding, "Line of Credit Account- Last Year Resident Tax Withholding value not displayed");

		Assert.assertNotNull(accountsPage.checkLastYearNonResidentTaxWithholdingHeader(), "Line of Credit Account - Last Year Non Resident Tax Withholding header not displayed");
		String lastYearNonResidentTaxWithholding = utils.readTestData("bankingHome", "lineOfCreditAccounts", "");
		//Assert.assertEquals(accountsPage.getLastYearNonResidentTaxWithholdingValue(), lastYearNonResidentTaxWithholding, "Line of Credit Account - Last Year Non Resident Tax Withholding value not displayed");

		// Scenario-2 - Linked Cards

		Assert.assertNotNull(accountsPage.checkLinkedCardsHeader(), "Line of Credit Account - Linked Cards header not displayed");

		Assert.assertNotNull(accountsPage.checkFirstLinkedCardHeader(), "Line of Credit Account - First Card header not displayed");
		String firstLinkedCard = utils.readTestData("bankingHome", "lineOfCreditAccounts", "");
		//Assert.assertEquals(accountsPage.getFirstLinkedCardValue(), firstLinkedCard, "Line of Credit Account - First Card number not displayed");

		//Assert.assertNotNull(accountsPage.checkSecondLinkedCardHeader(), "Line of Credit Account - Second Card header not displayed");
		//String secondLinkedCard = utils.readTestData("bankingHome", "lineOfCreditAccounts", "");
		//Assert.assertEquals(accountsPage.getFirstLinkedCardValue(), secondLinkedCard, "Line of Credit Account - Second Card number not displayed");
	}

	//TODO: New Ids and Xpaths to be added to the screen

	/** DMPM-908 **/

	@Test (groups = {"DMPM-908", "marketplace", "FFI", "priority-minor"})
	public void testVariableFixedRateAccount() {

		navigatingToBankingHome();

		Assert.assertNotNull(bankingHomePage.checkPaysomeoneButton(), "Banking Home page did not load");

		bankingHomePage.tapVariableFixedRateAccount();

		// Scenario-2 - Account Nickname

		Assert.assertNotNull(accountsPage.checkVariableFixedRateAccountHeader(), "Variable and Fixed Rate Account display header not shown");

		// Scenario 1 - Select a Loan account to view

		Assert.assertNotNull(accountsPage.checkAccountDetailsPageBackButton(), "Variable and Fixed Rate Account - Back button not displayed");
		Assert.assertNotNull(accountsPage.checkAccountDetailsPageTitle(), "Variable and Fixed Rate Account - Accounts Details page title is not correct");
		Assert.assertNotNull(accountsPage.checkVariableFixedRateAccountHeader(), "Variable and Fixed Rate Account - Variable and Fixed Rate Account display header not shown");
		Assert.assertNotNull(accountsPage.checkBsbNumberHeader(), "Variable and Fixed Rate Account - BSB number header not displayed");
		Assert.assertNotNull(accountsPage.checkAccountNumberHeader(), "Variable and Fixed Rate Account - Account number header not displayed");
		Assert.assertNotNull(accountsPage.checkAccountTitle(), "Variable and Fixed Rate Account - Account title not displayed");
		Assert.assertNotNull(accountsPage.checkAvailableBalanceHeader(), "Variable and Fixed Rate Account - Available Balance not dispalyed");
		Assert.assertNotNull(accountsPage.checkCurrentBalanceHeader(), "Variable and Fixed Rate Account - Current Balance Header not displayed");
		Assert.assertNotNull(accountsPage.checkPayTrasferButton(), "Variable and Fixed Rate Account - Pay/Transfer button not displayed");
		Assert.assertNotNull(accountsPage.checkMoreOptionsButton(), "Variable and Fixed Rate Account - More options button not displayed");


		Assert.assertEquals(accountsPage.getBsbNumberValue(), utils.readTestData("bankingHome", "variableFixedAccounts", "BSB") , "Line of Credit Account - BSB does not match");
		Assert.assertEquals(accountsPage.getAccountNumberValue(), utils.readTestData("bankingHome", "variableFixedAccounts", "ACC"), "Line of Credit Account - Account number does not match");
		Assert.assertEquals(accountsPage.getAccountProductType(), utils.readTestData("bankingHome", "variableFixedAccounts", "Account Product Type"), "Line of Credit Account - Account Product type not displayed");
		Assert.assertEquals(accountsPage.getAvailableBalanceValue(), utils.readTestData("bankingHome", "variableFixedAccounts", "Available Balance"), "Line of Credit Account - Account Available Balance value not displayed");
		Assert.assertEquals(accountsPage.getCurrentBalanceValue(), utils.readTestData("bankingHome", "variableFixedAccounts", "Current Balance"), "Line of Credit Account - Account Current Balance value not displayed");

		/* Credit Limit section */
		Assert.assertNotNull(accountsPage.checkCreditLimitHeader(), "Credit Limit header not displayed");
		Assert.assertNotNull(accountsPage.checkCreditLimitMinBalance(),"Minimum Balance header not displayed");
		String creditMinBalance = utils.readTestData("bankingHome", "variableFixedAccounts", "Credit Min Value");
		//Assert.assertEquals(accountsPage.getCreditLimitMinBalanceValue(), creditMinBalance, "Minimum credit value not retrieved");
		Assert.assertNotNull(accountsPage.checkCreditLimitMaxBalance(),"Maximum Balance header not displayed");
		String creditMaxBalance = utils.readTestData("bankingHome", "variableFixedAccounts", "Credit Max Value");
		//Assert.assertEquals(accountsPage.getCreditLimitMaxBalanceValue(), creditMaxBalance, "Maximum credit value not retrieved");


		/* Line of Credit Details section */

		Assert.assertNotNull(accountsPage.checkLineOfCredit(), "Line of Credit Account - Line of Credit header not displayed");

		Assert.assertNotNull(accountsPage.checkDebitInterestRateHeader(),"Line of Credit Account - Debit Interest Rate header not displayed");
		String debitInterestRateValue = utils.readTestData("bankingHome", "variableFixedAccounts", "Line of Credit Account - Debit Interest Rate");
		//Assert.assertEquals(accountsPage.getDebitInterestRateValue(), debitInterestRateValue, "Line of Credit Account - Debit Interest Rate Value not displayed");

		Assert.assertNotNull(accountsPage.checkInterestRateTypeHeader(),"Line of Credit Account - Interest Rate Type header not displayed");
		String interestRateType = utils.readTestData("bankingHome", "variableFixedAccounts", "Line of Credit Account - Interest Rate Type");
		//Assert.assertEquals(accountsPage.getInterestRateTypeValue(), interestRateType, "Line of Credit Account - Interest Rate Type value not displayed");

		Assert.assertNotNull(accountsPage.checkTermLengthHeader(),"Line of Credit Account - Term length header not displayed");
		String termLengthValue = utils.readTestData("bankingHome", "variableFixedAccounts", "Line of Credit Account - Term Length");
		//Assert.assertEquals(accountsPage.getTermLengthValue(), termLengthValue, "Line of Credit Account - Term length value not displayed");

		Assert.assertNotNull(accountsPage.checkTermExpiryDateHeader(),"Line of Credit Account - Term expiry date header not displayed");
		String termExpiryDate = utils.readTestData("bankingHome", "variableFixedAccounts", "Line of Credit Account - Term Expiry Date");
		//Assert.assertEquals(accountsPage.getTermExpiryDateValue(), termExpiryDate, "Line of Credit Account - Term expiry date value not displayed");

		Assert.assertNotNull(accountsPage.checkLoanPurposeHeader(),"Line of Credit Account - Loan purpose header not displayed");
		String loanPurpose = utils.readTestData("bankingHome", "variableFixedAccounts", "Line of Credit Account - Loan Purpose");
		//Assert.assertEquals(accountsPage.getLoanPurposeValue(), loanPurpose, "Line of Credit Account - Loan purpose value not displayed");


		/* Interest Details section */
		Assert.assertNotNull(accountsPage.checkInterestDetailsHeader(), "Interest Details header not diplayed");
		Assert.assertNotNull(accountsPage.checkInterestRateHeader(), "Interest Rate header not displayed");
		String interestRateValue = utils.readTestData("bankingHome", "variableFixedAccounts", "Interest Rate");
		//Assert.assertEquals(accountsPage.getInterestRateValue(),interestRateValue, "Interest Rate value not displayed");
		Assert.assertNotNull(accountsPage.checkExpiryDateHeader(), "Expiry date header not displayed");
		String expiryDateValue = utils.readTestData("bankingHome", "variableFixedAccounts", "Expiry Dare");
		//Assert.assertEquals(accountsPage.getInterestRateValue(),expiryDateValue, "Interest Rate value not displayed");


		/* Loan Details section */
		Assert.assertNotNull(accountsPage.checkLoanDetailsHeader(), "Loan Details header not displayed");

		Assert.assertNotNull(accountsPage.checkCashBackHeader(),"Cash Back header not displayed");
		String cashBackValue = utils.readTestData("bankingHome", "variableFixedAccounts", "Cash Back");
		//Assert.assertEquals(accountsPage.getCashBackValue(), cashBackValue, "Cash Back Value not displayed");

		Assert.assertNotNull(accountsPage.checkPrinciplePaidHeader(),"Principle paid header not displayed");
		String principlePaidValue = utils.readTestData("bankingHome", "variableFixedAccounts", "Principle Paid");
		//Assert.assertEquals(accountsPage.getPrinciplePaidValue(), principlePaidValue, "Principle Paid value not displayed");

		Assert.assertNotNull(accountsPage.checkTermLengthHeader(),"Term length header not displayed");
		String variableFixedTermLengthValue = utils.readTestData("bankingHome", "variableFixedAccounts", "Term Length");
		//Assert.assertEquals(accountsPage.getTermLengthValue(), termLengthValue, "Term length value not displayed");

		Assert.assertNotNull(accountsPage.checkTermExpiryDateHeader(),"Term expiry date header not displayed");
		String variableFixedTermExpiryDate = utils.readTestData("bankingHome", "variableFixedAccounts", "Term Expiry Date");
		//Assert.assertEquals(accountsPage.getTermExpiryDateValue(), termExpiryDate, "Term expiry date value not displayed");

		Assert.assertNotNull(accountsPage.checkLoanPurposeHeader(),"Loan purpose header not displayed");
		String variableFixedLoanPurpose = utils.readTestData("bankingHome", "variableFixedAccounts", "Loan Purpose");
		//Assert.assertEquals(accountsPage.getLoanPurposeValue(), loanPurpose, "Loan purpose value not displayed");


		/* Last Statement Date section */

		Assert.assertNotNull(accountsPage.checkLastStatementDateHeader(), "Last Statement Date header not displayed");

		//Assert.assertNotNull(accountsPage.checkNextStatementDateSubHeader(), "Last Statement Date subheader not displayed");
		String lastStatementDate = utils.readTestData("bankingHome", "variableFixedAccounts", "Last Statement Date");
		//Assert.assertEquals(accountsPage.getLastStatementDateValue(), lastStatementDate, "Last Statement Date value not displayed");

		/* Next Statement Date section */

		Assert.assertNotNull(accountsPage.checkLastStatementDateHeader(), "Last Statement Date header not displayed");

		//Assert.assertNotNull(accountsPage.checkNextStatementDateSubHeader(), "Next Statement Date subheader not displayed");
		String nextStatementDate = utils.readTestData("bankingHome", "variableFixedAccounts", "Next Statement Date");
		//Assert.assertEquals(accountsPage.getNextStatementDateValue(), nextStatementDate, "Next Statement Date value not displayed");


		/** Scenario 3 and 4 - Overdue Payment Amount and Overdue number of days **/
		/* Next Payment  - Amount Overdue - Days Overdue */

		Assert.assertNotNull(accountsPage.checkNextPaymentHeader(), "Next Payment header not displayed");

		Assert.assertNotNull(accountsPage.checkAmountOverdueHeader(), "Amount Overdue header not displayed");
		String amountOverdue = utils.readTestData("bankingHome", "variableFixedAccounts", "Amount Overdue");
		//Assert.assertEquals(accountsPage.getAmountOverdueValue(), amountOverdue, "Amount Overdue value not displayed");

		Assert.assertNotNull(accountsPage.checkDaysOverdueHeader(), "Days Overdue header not displayed");
		String daysOverdue = utils.readTestData("bankingHome", "variableFixedAccounts", "Days Overdue");
		//Assert.assertEquals(accountsPage.getAmountOverdueValue(), daysOverdue, "Amount Overdue value not displayed");


		/* Last Payment */

		Assert.assertNotNull(accountsPage.checkLastPaymentHeader(), "Last Payment header not displayed");

		Assert.assertNotNull(accountsPage.checkLastPaymentDateHeader(), "last Payment Date header not displayed");
		String lastPaymentDate = utils.readTestData("bankingHome", "variableFixedAccounts", "");
		//Assert.assertEquals(accountsPage.getLastPaymentDateValue(), lastPaymentDate, "last Payment Date value not displayed");

		Assert.assertNotNull(accountsPage.checkLastPaymentDateHeader(), "last Payment Amount header not displayed");
		String lastPaymentAmount = utils.readTestData("bankingHome", "variableFixedAccounts", "");
		//Assert.assertEquals(accountsPage.getLastPaymentAmountValue(), lastPaymentAmount, "Last Payment Amount value not displayed");

	}
	
	//TODO: New Ids and Xpaths to be added to the screen

		/** DMPM-1064 **/

		@Test (groups = {"DMPM-1064", "marketplace", "FFI", "priority-minor"})

		public void testFlexirate() {

			navigatingToBankingHome();

			Assert.assertNotNull(bankingHomePage.checkPaysomeoneButton(), "Banking Home page did not load");

			bankingHomePage.tapEverydayEssentials();

			/** Scenario 1 - view flexi rates **/

			// Flexi Rate section

			Assert.assertNotNull(accountsPage.checkFlexiRateHeader(), "Everyday Essentials - Flexi Rate header not displayed");

			Assert.assertNotNull(accountsPage.checkAmountOfFlexirateHeader(), "Everyday Essentials - Amount of Flexirate header not displayed");
			String amountOfFlexirate = utils.readTestData("bankingHome", "everydayEssentialsAccount", "Amount Of Flexirate");
			//			Assert.assertEquals(accountsPage.getAmountOfFlexirateValue(), amountOfFlexirate, "Everyday Essentials - Amount of Flexirate value not displayed");

			Assert.assertNotNull(accountsPage.checkInterestRateFlexirateHeader(), "Everyday Essentials - Interest Rate header not displayed");
			String interestRate = utils.readTestData("bankingHome", "everydayEssentialsAccount", "Interst Rate");
			//			Assert.assertEquals(accountsPage.getInterestRateFlexirateValue(), interestRate, "Everyday Essentials - Interest Rate value not displayed");

			Assert.assertNotNull(accountsPage.checkMaturityDateHeader(), "Everyday Essentials - Maturity Rate header not displayed");
			String maturityRate = utils.readTestData("bankingHome", "everydayEssentialsAccount", "Maturity Rate");
			//			Assert.assertEquals(accountsPage.getMaturityDateValue(), maturityRate, "Everyday Essentials - Maturity Rate value not displayed");

		}
		
		//TODO: New Ids and Xpaths to be added to the screen

		/** DMPM-1430 **/

		@Test (groups = {"DMPM-1430", "marketplace", "FFI", "priority-minor"})

		public void testVariableLoanOffsetting() {

			navigatingToBankingHome();

			Assert.assertNotNull(bankingHomePage.checkPaysomeoneButton(), "Banking Home page did not load");

			bankingHomePage.tapVariableLoanOffsetting();

			// Scenario-2 - Account Nickname

			Assert.assertNotNull(accountsPage.checkVariableFixedRateAccountHeader(), "Varible Loan Offsetting - Variable Loan Offsetting Account display header not shown");


			// Scenario 3 - Offsetting Home Loan interest saved - this financial year
			/* Current Year */

			Assert.assertNotNull(accountsPage.checkCurrentYearHeader(), "Current Year header not displayed");

			Assert.assertNotNull(accountsPage.checkCurrentYearInterestSavedHeader(), "Varible Loan Offsetting - Current Year Interest Saved header not displayed");
			String currentYearInterestSaved = utils.readTestData("bankingHome", "varibleLoanOffsettingAccount", "");
			//Assert.assertEquals(accountsPage.getCurrentYearInterestSavedValue(), currentYearInterestSaved, "Varible Loan Offsetting - Current Year Interest Saved value not displayed");

			// Scenario 4 - Offsetting Home Loan interest saved - last financial year
			/* Last Year */

			Assert.assertNotNull(accountsPage.checkLastYearHeader(), "Last Year header not displayed");

			Assert.assertNotNull(accountsPage.checkLastYearInterestSavedHeader(), "Varible Loan Offsetting - Last Year Interest Saved header not displayed");
			String lastYearInterestSaved = utils.readTestData("bankingHome", "varibleLoanOffsettingAccount", "");
			//Assert.assertEquals(accountsPage.getLastYearInterestSavedValue(), lastYearInterestSaved, "Varible Loan Offsetting - Last Year Interest Saved value not displayed");


			// Scenario 1 - Offset Account Numbers
			/* Linked Accounts */

			Assert.assertNotNull(accountsPage.checkLinkedAccountsHeader(), "Varible Loan Offsetting - Linked Accounts header not displayed");

			Assert.assertNotNull(accountsPage.checkLinkedAccountsSuncorpLoanAccount1(), "Varible Loan Offsetting - Loan Account 1 header not displayed");
			String suncorpLoanAccount1 = utils.readTestData("bankingHome", "varibleLoanOffsettingAccount", "");
			//Assert.assertEquals(accountsPage.getLinkedAccountsSuncorpLoanAccount1Value(), suncorpLoanAccount1, "Varible Loan Offsetting - Loan Account 1 value not displayed");

			Assert.assertNotNull(accountsPage.checkLinkedAccountsSuncorpLoanAccount2(), "Varible Loan Offsetting - Loan Account 2 header not displayed");
			String suncorpLoanAccount2 = utils.readTestData("bankingHome", "varibleLoanOffsettingAccount", "");
			//Assert.assertEquals(accountsPage.getLinkedAccountsSuncorpLoanAccount2Value(), suncorpLoanAccount2, "Varible Loan Offsetting - Loan Account 2 value not displayed");

			Assert.assertNotNull(accountsPage.checkLinkedAccountsSuncorpLoanAccount3(), "Varible Loan Offsetting - Loan Account 3 header not displayed");
			String suncorpLoanAccount3 = utils.readTestData("bankingHome", "varibleLoanOffsettingAccount", "");
			//Assert.assertEquals(accountsPage.getLinkedAccountsSuncorpLoanAccount3Value(), suncorpLoanAccount3, "Varible Loan Offsetting - Loan Account 3 value not displayed");

			Assert.assertNotNull(accountsPage.checkLinkedAccountsSuncorpLoanAccount4(), "Varible Loan Offsetting - Loan Account 4 header not displayed");
			String suncorpLoanAccount4 = utils.readTestData("bankingHome", "varibleLoanOffsettingAccount", "");
			//Assert.assertEquals(accountsPage.getLinkedAccountsSuncorpLoanAccount4Value(), suncorpLoanAccount4, "Varible Loan Offsetting - Loan Account 4 value not displayed");

			Assert.assertNotNull(accountsPage.checkLinkedAccountsSuncorpLoanAccount5(), "Varible Loan Offsetting - Loan Account 5 header not displayed");
			String suncorpLoanAccount5 = utils.readTestData("bankingHome", "varibleLoanOffsettingAccount", "");
			//Assert.assertEquals(accountsPage.getLinkedAccountsSuncorpLoanAccount5Value(), suncorpLoanAccount5, "Varible Loan Offsetting - Loan Account 5 value not displayed");

			Assert.assertNotNull(accountsPage.checkLinkedAccountsSuncorpLoanAccount6(), "Varible Loan Offsetting - Loan Account 6 header not displayed");
			String suncorpLoanAccount6 = utils.readTestData("bankingHome", "varibleLoanOffsettingAccount", "");
			//Assert.assertEquals(accountsPage.getLinkedAccountsSuncorpLoanAccount6Value(), suncorpLoanAccount6, "Varible Loan Offsetting - Loan Account 6 value not displayed");

			Assert.assertNotNull(accountsPage.checkLinkedAccountsSuncorpLoanAccount7(), "Varible Loan Offsetting - Loan Account 7 header not displayed");
			String suncorpLoanAccount7 = utils.readTestData("bankingHome", "varibleLoanOffsettingAccount", "");
			//Assert.assertEquals(accountsPage.getLinkedAccountsSuncorpLoanAccount7Value(), suncorpLoanAccount7, "Varible Loan Offsetting - Loan Account 7 value not displayed");

			Assert.assertNotNull(accountsPage.checkLinkedAccountsSuncorpLoanAccount8(), "Varible Loan Offsetting - Loan Account 8 header not displayed");
			String suncorpLoanAccount8 = utils.readTestData("bankingHome", "varibleLoanOffsettingAccount", "");
			//Assert.assertEquals(accountsPage.getLinkedAccountsSuncorpLoanAccount8Value(), suncorpLoanAccount8, "Varible Loan Offsetting - Loan Account 8 value not displayed");

			Assert.assertNotNull(accountsPage.checkLinkedAccountsSuncorpLoanAccount9(), "Varible Loan Offsetting - Loan Account 9 header not displayed");
			String suncorpLoanAccount9 = utils.readTestData("bankingHome", "varibleLoanOffsettingAccount", "");
			//Assert.assertEquals(accountsPage.getLinkedAccountsSuncorpLoanAccount9Value(), suncorpLoanAccount9, "Varible Loan Offsetting - Loan Account 9 value not displayed");

			Assert.assertNotNull(accountsPage.checkLinkedAccountsSuncorpLoanAccount10(), "Varible Loan Offsetting - Loan Account 10 header not displayed");
			String suncorpLoanAccount10 = utils.readTestData("bankingHome", "varibleLoanOffsettingAccount", "");
			//Assert.assertEquals(accountsPage.getLinkedAccountsSuncorpLoanAccount10Value(), suncorpLoanAccount10, "Varible Loan Offsetting - Loan Account 10 value not displayed");

		}

}
