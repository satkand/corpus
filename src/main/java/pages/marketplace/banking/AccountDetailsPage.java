package pages.marketplace.banking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class AccountDetailsPage extends BasePage{

	public AccountDetailsPage(AppiumDriver driver) {
		super(driver);
	}
	
	
	// Elements in the Account Details page
	private By accountDetailsPageBackButton = By.id("au.com.suncorp.marketplace:id/accountDetailsBackButton");
	private By pageTitle = By.xpath("//android.widget.TextView[@text='Account Details']");
	private By homeAccountDisplayHeader = By.xpath("//android.widget.TextView[@text='My Variable or Fixed Rate']");
	private By bsbNumberHeader = By.id("au.com.suncorp.marketplace:id/accountDetailBsbNumberHeader");
	private By bsbNumberValue = By.id("au.com.suncorp.marketplace:id/accountDetailBsbNumberValue");
	private By accountNumberHeader = By.id("au.com.suncorp.marketplace:id/accountDetailAccountNumberHeader");
	private By accountNumberValue = By.id("au.com.suncorp.marketplace:id/accountDetailAccountNumberValue");
	private By accountProductType = By.id("au.com.suncorp.marketplace:id/accountDetailProductTypeHeader");
	private By titleOfAccount = By.xpath("//android.widget.TextView[@text='Title']");
	private By titleOfAccountValue = By.xpath("//android.widget.TextView[@text='Loan with Offset Accounts']");
	private By availableBalanceHeader = By.id("au.com.suncorp.marketplace:id/accountDetailAvailableBalanceHeader");
	private By availableBalanceValue = By.id("au.com.suncorp.marketplace:id/accountDetailAvailableBalanceValue");
	private By currentBalanceHeader = By.id("au.com.suncorp.marketplace:id/accountDetailCurrentBalanceHeader");
	private By currenBalanceValue = By.id("au.com.suncorp.marketplace:id/accountDetailCurrentBalanceValue");
	private By payTransferButton = By.id("au.com.suncorp.marketplace:id/accountDetailPayButton");
	private By moreOptionsButton = By.id("au.com.suncorp.marketplace:id/accountDetailMoreOptionsButton");
	
	private By lineOfCreditAccountHeader = By.xpath("//android.widget.TextView[@text='My Line Of Credit Account']");
	private By variabelFixedRateAccountHeader = By.xpath("//android.widget.TextView[@text='My Variable or Fixed Rate']");
	
	// Elements in the Credit Limit section
	private By creditLimitHeader = By.xpath("//android.widget.TextView[@text='Credit Limit']");
	private By creditLimitMinBalance = By.xpath("//android.widget.TextView[@text='Minimum']");
	//private By creditLimitMinBalanceValue = By.xpath("//android.widget.TextView[]"); 
	private By creditLimitMaxBalance = By.xpath("//android.widget.TextView[@text='Maximum']");
	//private By creditLimitMaxBalanceValue = By.xpath("//android.widget.TextView[]");
	
	// Elements in the Interest Details section
	private By interestDetailsHeader = By.xpath("//android.widget.TextView[@text='Interest Details']");
	private By interestRateHeader = By.xpath("//android.widget.TextView[@text='Interest Rate']");
	private By interestRateValue = By.id(""); //to be edited
	private By expiryDateHeader = By.xpath("//android.widget.TextView[@text='Expiry Date']");
	private By expiryDateValue = By.id("");
	
	// Elements in the Loan Details section
	private By loanDetailsHeader = By.xpath("//android.widget.TextView[@text='Loan Details']");
	private By cashBackHeader = By.xpath("//android.widget.TextView[@text='Cash Back']");
	private By cashBackValue = By.id("");
	private By principlePaidHeader = By.xpath("//android.widget.TextView[@text='Principal Paid']");
	private By principlePaidValue = By.xpath("");
	private By termLengthHeader = By.xpath("//android.widget.TextView[@text='Term Length']");
	private By termLengthValue = By.id("");
	private By termExpiryDateHeader = By.xpath("//android.widget.TextView[@text='Term Expiry Date']");
	private By termExpiryDateValue = By.id("");
	private By loanPurposeHeader = By.xpath("//android.widget.TextView[@text='Loan Purpose']");
	private By loanPurposeValue = By.id("");
	
	// Elements in the Last Statement Date
	private By lastStatementDateHeader = By.xpath("//android.widget.TextView[@text='Last Statement Date']");
	private By lastStatementDateSubHeader = By.xpath("//android.support.v7.widget.RecyclerView[@id=‘au.com.suncorp.marketplace:id/accountDetails’]//android.widget.FrameLayout//android.widget.LinearLayout[@resource-id='au.com.suncorp.marketplace:id/accountDetailTextItemLayout']//android.widget.LinearLayout[@index='1']//android.widget.TextView[@text='Last Statement Date']");
	private By lastStatementDateValue = By.id("");
	
	// Elements in the Next Statement Date
	private By nextStatementDateHeader = By.xpath("//android.widget.TextView[@text='Last Statement Date']");
	private By nextStatementDateSubHeader = By.xpath("//android.support.v7.widget.RecyclerView[@id=‘au.com.suncorp.marketplace:id/accountDetails’]//android.widget.FrameLayout//android.widget.LinearLayout[@resource-id='au.com.suncorp.marketplace:id/accountDetailTextItemLayout']//android.widget.LinearLayout[@index='1']//android.widget.TextView[@text='Next Statement Date']");
	private By nextStatementDateValue = By.id("");
	
	// Elements in the Next Payment section
	private By nextPaymentHeader = By.xpath("//android.widget.TextView[@text='Next Payment']");
	
	private By amountsOverdueHeader = By.xpath("//android.widget.TextView[@text='Amount Overdue']");
	private By amountsOverdueValue = By.id("");
	
	private By daysOverdueHeader = By.xpath("//android.widget.TextView[@text='Days Overdue']");
	private By daysOverdueValue = By.id("");
	
	private By minRepaymentHeader = By.xpath("//android.widget.TextView[@text='Minimum Repayment']");
	private By minRepaymentValue = By.id("");
	
	private By paymentDueDateHeader = By.xpath("//android.widget.TextView[@text='Payment Due Date']");
	private By paymentDueDateValue = By.id("");
	
	private By closingBalanceHeader = By.xpath("//android.widget.TextView[@text='Closing Balance']");
	private By closingBalanceValue = By.id("");
	
	//Elements in the Last Payment section
	private By lastPaymentHeader = By.xpath("//android.widget.TextView[@text='Last Payment']");
	private By lastPaymentDateHeader = By.xpath("//android.widget.TextView[@text='Date']");
	private By lastPaymentDateValue = By.id("");
	
	private By lastPaymentAmountHeader = By.xpath("//android.widget.TextView[@text='Amount']");
	private By lastPaymentAmountValue = By.id("");
	
	//Elements in the Payments in Advance section
	private By paymentsInAdvanceHeader = By.xpath("//android.widget.TextView[@text='Payments in Advance']");
	private By paymentsInAdvanceDateHeader = By.xpath("//android.widget.TextView[@text='Date']");
	private By paymentsInAdvanceDateValue = By.id("");
	
	private By paymentsInAdvanceAmountHeader = By.xpath("//android.widget.TextView[@text='Amount']");
	private By paymentsInAdvanceAmountValue = By.id("");
	private By paymentsInAdvanceAmountHeader2 = By.xpath("//android.widget.TextView[@text='Amount']");
	private By paymentsInAdvanceAmountValue2 = By.id("");
	
	//Elements in the Current Year section
	
	private By currentYearHeader = By.xpath("//android.widget.TextView[@text='Current Year']");
	private By currentYearInterestEarnedHeader = By.xpath("//android.widget.TextView[@text='Interest Earned']");
	private By currentYearInterestEarnedValue = By.id("");
	private By currentYearInterestPaidHeader = By.xpath("//android.widget.TextView[@text='Interest Paid']");
	private By currentYearInterestPaidValue = By.id("");
	private By currentYearInterestSavedHeader = By.xpath("//android.widget.TextView[@text='Interest Saved']");
	private By currentYearInterestSavedValue = By.id("");
	private By currentYearResidentTaxWithholdingHeader = By.xpath("//android.widget.TextView[@text='Resident Tax Withholding']");
	private By currentYearResidentTaxWithholdingValue = By.id("");
	private By currentYearNonResidentTaxWithholdingHeader = By.xpath("//android.widget.TextView[@text='Non Resident Tax Withholding']");
	private By currentYearNonResidentTaxWithholdingValue = By.id("");
	
	//Elements in the Last Year section
	
	private By lastYearHeader = By.xpath("//android.widget.TextView[@text='Last Year']");
	private By lastYearInteretEarnedHeader = By.xpath("//android.widget.TextView[@text='Interest Earned']");
	private By lastYearInterestEarnedValue = By.id("");
	private By lastYearInterestPaidHeader = By.xpath("//android.widget.TextView[@text='Interest Paid']");
	private By lastYearInterestPaidValue = By.id("");
	private By lastYearInterestSavedHeader = By.xpath("//android.widget.TextView[@text='Interest Saved']");
	private By lastYearInterestSavedValue = By.id("");
	private By lastYearResidentTaxWithholdingHeader = By.xpath("//android.widget.TextView[@text='Resident Tax Withholding']");
	private By lastYearResidentTaxWithholdingValue = By.id("");
	private By lastYearNonResidentTaxWithholdingHeader = By.xpath("//android.widget.TextView[@text='Non Resident Tax Withholding']");
	private By lastYearNonResidentTaxWithholdingValue = By.id("");
	
	//Elements in the Linked Accounts
	
	private By linkedAccountsHeader = By.xpath("//android.widget.TextView[@text='Linked Accounts']");
	
	private By linkedAccountsSuncorpLoanAccount1 = By.xpath("//android.widget.TextView[@text='Suncorp Loan Account - 1']");
	private By linkedAccountsSuncorpLoanAccount1Value = By.id("");
	private By linkedAccountsSuncorpLoanAccount2 = By.xpath("//android.widget.TextView[@text='Suncorp Loan Account - 2']");
	private By linkedAccountsSuncorpLoanAccount2Value = By.id("");
	private By linkedAccountsSuncorpLoanAccount3 = By.xpath("//android.widget.TextView[@text='Suncorp Loan Account - 3']");
	private By linkedAccountsSuncorpLoanAccount3Value = By.id("");
	private By linkedAccountsSuncorpLoanAccount4 = By.xpath("//android.widget.TextView[@text='Suncorp Loan Account - 4']");
	private By linkedAccountsSuncorpLoanAccount4Value = By.id("");
	private By linkedAccountsSuncorpLoanAccount5 = By.xpath("//android.widget.TextView[@text='Suncorp Loan Account - 5']");
	private By linkedAccountsSuncorpLoanAccount5Value = By.id("");
	private By linkedAccountsSuncorpLoanAccount6 = By.xpath("//android.widget.TextView[@text='Suncorp Loan Account - 6']");
	private By linkedAccountsSuncorpLoanAccount6Value = By.id("");
	private By linkedAccountsSuncorpLoanAccount7 = By.xpath("//android.widget.TextView[@text='Suncorp Loan Account - 7']");
	private By linkedAccountsSuncorpLoanAccount7Value = By.id("");
	private By linkedAccountsSuncorpLoanAccount8 = By.xpath("//android.widget.TextView[@text='Suncorp Loan Account - 8']");
	private By linkedAccountsSuncorpLoanAccount8Value = By.id("");
	private By linkedAccountsSuncorpLoanAccount9 = By.xpath("//android.widget.TextView[@text='Suncorp Loan Account - 9']");
	private By linkedAccountsSuncorpLoanAccount9Value = By.id("");
	private By linkedAccountsSuncorpLoanAccount10 = By.xpath("//android.widget.TextView[@text='Suncorp Loan Account - 10']");
	private By linkedAccountsSuncorpLoanAccount10Value = By.id("");
	
	// Elements in the Posted Transactions section
	
	private By postedTransactionHeader = By.xpath("//android.widget.TextView[@text='Posted Transactions']");
	
	private By postedTransactionPostedDateHeader = By.xpath("//android.widget.TextView[@text='Posted Date']");
	private By postedTransactionPostedDateValue = By.id("");
	private By postedTransactionAmountHeader = By.xpath("//android.widget.TextView[@text='Amount']");
	private By postedTransactionAmountValue = By.id("");
	private By postedTransactionDescriptionHeader = By.xpath("//android.widget.TextView[@text='Description']");
	private By postedTransactionDescriptionValue = By.id("");
	private By postedTransactionRunningBalanceHeader = By.xpath("//android.widget.TextView[@text='Running Balance']");
	private By postedTransactionRunningBalanceValue = By.id("");
	
	/* Line of credit loan account elements*/
	// Line of Credit section
	
	private By lineOfCreditHeader = By.xpath("//android.widget.TextView[@text='Line of Credit']");
	private By debitInterestRateHeader = By.xpath("//android.widget.TextView[@text='Debit Interest Rate']");
	private By debitInterestRateValue = By.id("");
	private By interestRateTypeHeader = By.xpath("//android.widget.TextView[@text='Interest Rate Type']");
	private By interestRateTypeValue = By.id("");
	
	private By linkedCardsHeader = By.xpath("//android.widget.TextView[@text='Linked Cards']");
	private By linkedCardHeader1 = By.xpath("//android.widget.TextView[@text='Linked Card']");
	private By linkedCardValue1 = By.id("");
	private By linkedCardHeader2 = By.xpath("//android.widget.TextView[@text='Linked Card']");
	private By linkedCardValue2 = By.id("");
	
	
	public WebElement checkAccountDetailsPageBackButton() {
		return find(accountDetailsPageBackButton, 30);
	}
	
	public WebElement checkAccountDetailsPageTitle() {
		return find(pageTitle, 30);
	}
	
	public WebElement checkAccountDisplayHeader() {
		return find(homeAccountDisplayHeader, 30);
	}
	
	public WebElement checkBsbNumberHeader() {
		return find(bsbNumberHeader, 30);
	}
	
	public String getBsbNumberValue() {
		return getText(bsbNumberValue);
	}
	
	public WebElement checkAccountNumberHeader() {
		return find(accountNumberHeader, 30);
	}
	
	public String getAccountNumberValue() {
		return getText(accountNumberValue);
	}
	
	public String getAccountProductType() {
		return getText(accountProductType);
	}
	
	public WebElement checkAccountTitle() {
		return find(titleOfAccount,30);
	}
	
	public String getAccountTitleValue() {
		return getText(titleOfAccountValue);
	}
	
	public WebElement checkCurrentBalanceHeader() {
		return find(currentBalanceHeader,30);
	}
	
	public String getCurrentBalanceValue() {
		return getText(currenBalanceValue);
	}
	
	public WebElement checkAvailableBalanceHeader() {
		return find(availableBalanceHeader,30);
	}
	
	public String getAvailableBalanceValue() {
		return getText(availableBalanceValue);
	}
	
	public WebElement checkPayTrasferButton() {
		return find(payTransferButton, 30);
	}
	
	public WebElement checkMoreOptionsButton() {
		return find(moreOptionsButton, 30);
	}
	
	
	// Credit Limit section
	
	public WebElement checkCreditLimitHeader() {
		return find(creditLimitHeader, 30);
	}
	
	public WebElement checkCreditLimitMinBalance() {
		return find(creditLimitMinBalance, 30);
	}
	
//	public String getCreditLimitMinBalanceValue() {
//		return getText(creditLimitMinBalanceValue);
//	}
	
	public WebElement checkCreditLimitMaxBalance() {
		return find(creditLimitMaxBalance, 30);
	}
	
//	public String getCreditLimitMaxBalanceValue() {
//		return getText(creditLimitMaxBalanceValue);
//	}
	
	
	// Interest Details section
	
	public WebElement checkInterestDetailsHeader() {
		scrollToElement(interestDetailsHeader);
		return find(interestDetailsHeader, 30);
	}
	
	public WebElement checkInterestRateHeader(){
		scrollToElement(interestRateHeader);
		return find(interestRateHeader, 30);
	}
	
	public String getInterestRateValue() {
		return getText(interestRateValue);
	}
	
	public WebElement checkExpiryDateHeader() {
		scrollToElement(expiryDateHeader);
		return find(expiryDateHeader, 30);
	}
	
	public String getExpiryDateValue() {
		return getText(expiryDateValue);
	}
	
	
	// Loan Details section
	
	public WebElement checkLoanDetailsHeader() {
		return find(loanDetailsHeader, 30);
	}
	
	public WebElement checkCashBackHeader() {
		scrollToElement(cashBackHeader);
		return find(cashBackHeader, 30);
	}
	
	public String getCashBackValue() {
		find(cashBackValue, 30);
		return getText(cashBackValue);
	}
	
	public WebElement checkPrinciplePaidHeader() {
		scrollToElement(principlePaidHeader);
		return find(principlePaidHeader, 30);
	}
	
	public String getPrinciplePaidValue() {
		return getText(principlePaidValue);
	}
	
	public WebElement checkTermLengthHeader (){
		scrollToElement(termLengthHeader);
		return find(termLengthHeader, 30); 
	}
	
	public String getTermLengthValue() {
		return getText(termLengthValue);
	}
	
	public WebElement checkTermExpiryDateHeader() {
		scrollToElement(termExpiryDateHeader);
		return find(termExpiryDateHeader, 30);
	}
	
	public String getTermExpiryDateValue() {
		return getText(termExpiryDateValue);
	}
	
	public WebElement checkLoanPurposeHeader() {
		scrollToElement(loanPurposeHeader);
		return find(loanPurposeHeader, 30);
	}
	
	public String getLoanPurposeValue() {
		return getText(loanPurposeValue);
	}
	
	
	// Last Statement Date section
	
	public WebElement checkLastStatementDateHeader() {
		scrollToElement(lastStatementDateHeader);
		return find(lastStatementDateHeader, 30);
	}
	
	public WebElement checkLastStatementDateSubHeader() {
		scrollToElement(lastStatementDateSubHeader);
		return find(lastStatementDateSubHeader, 30);
	}
	
	public String getLastStatementDateValue() {
		return getText(lastStatementDateValue);
	}
	
	
	// Next Statement Date section
	
	public WebElement checkNextStatementDateHeader() {
		scrollToElement(nextStatementDateHeader);
		return find(nextStatementDateHeader, 30);
	}
	
	public WebElement checkNextStatementDateSubHeader() {
		scrollToElement(nextStatementDateSubHeader);
		return find(nextStatementDateSubHeader, 30);
	}
	
	public String getNextStatementDateValue() {
		return getText(nextStatementDateValue);
	}
	
	
	// Next Payment section
	
	public WebElement checkNextPaymentHeader() {
		scrollToElement(nextPaymentHeader);
		return find(nextPaymentHeader, 30);
	}
	
	public WebElement checkAmountOverdueHeader() {
		scrollToElement(amountsOverdueHeader);
		return find(amountsOverdueHeader, 30);
	}
	
	public String getAmountOverdueValue() {
		return getText(amountsOverdueValue);
	}
	
	public WebElement checkDaysOverdueHeader() {
		scrollToElement(daysOverdueHeader);
		return find(daysOverdueHeader, 30);
	}
	
	public String getDaysOverdueValue() {
		return getText(daysOverdueValue);
	}
	
	public WebElement checkMinRepaymentHeader() {
		scrollToElement(minRepaymentHeader);
		return find(minRepaymentHeader, 30);
	}
	
	public String getMinRepaymentValue() {
		return getText(minRepaymentValue);
	}
	
	public WebElement checkPaymentDueDateHeader() {
		scrollToElement(paymentDueDateHeader);
		return find(paymentDueDateHeader, 30);
	}
	
	public String getPaymentDueDateValue() {
		return getText(paymentDueDateValue);
	}
	
	public WebElement checkClosingBalanceHeader() {
		scrollToElement(closingBalanceHeader);
		return find(closingBalanceHeader, 30);
	}
	
	public String getClosingBalanceValue() {
		return getText(closingBalanceValue);
	}
	
	
	// Last Payment section
	
	public WebElement checkLastPaymentHeader() {
		scrollToElement(lastPaymentHeader);
		return find(lastPaymentHeader, 30);
	}
	
	public WebElement checkLastPaymentDateHeader() {
		scrollToElement(lastPaymentDateHeader);
		return find(lastPaymentDateHeader, 30);
	}
	
	public String getLastPaymentDateValue() {
		return getText(lastPaymentDateValue);
	}
	
	public WebElement checkLastPaymentAmountHeader() {
		scrollToElement(lastPaymentAmountHeader);
		return find(lastPaymentAmountHeader, 30);
	}
	
	public String getLastPaymentAmountValue() {
		return getText(lastPaymentAmountValue);
	}
	
	//Payments in Advance section
	
	public WebElement checkPaymentsInAdvanceHeader() {
		scrollToElement(paymentsInAdvanceHeader);
		return find(paymentsInAdvanceHeader, 30);
	}
	
	public WebElement checkPaymentsInAdvanceDateHeader() {
		scrollToElement(paymentsInAdvanceDateHeader);
		return find(paymentsInAdvanceDateHeader, 30);
	}
	
	public String getPaymentsInAdvanceDateValue() {
		return getText(paymentsInAdvanceDateValue);
	}
	
	public WebElement checkPaymentsInAdvanceAmountHeader() {
		scrollToElement(paymentsInAdvanceAmountHeader);
		return find(paymentsInAdvanceAmountHeader, 30);
	}
	
	public String getPaymentsInAdvanceAmountValue() {
		return getText(paymentsInAdvanceDateValue);
	}
	
	public WebElement checkPaymentsInAdvanceAmountHeader2() {
		scrollToElement(paymentsInAdvanceAmountHeader2);
		return find(paymentsInAdvanceAmountHeader2, 30);
	}
//	
//	public String getPaymentsInAdvanceAmountValue2() {
//		find(paymentsInAdvanceAmountValue2, 30);
//		return getText(paymentsInAdvanceAmountValue2);
//	}
	
	// Current Year section
	
	public WebElement checkCurrentYearHeader() {
		scrollToElement(currentYearHeader);
		return find(currentYearHeader, 30);
	}
	
	public WebElement checkCurrentYearInterestEarnedHeader() {
		scrollToElement(currentYearInterestEarnedHeader);
		return find(currentYearInterestEarnedHeader, 30);
	}
	
	public String getCurrentYearInterestEarnedValue() {
		return getText(currentYearInterestEarnedValue);
	}
	
	public WebElement checkCurrentYearInterestPaidHeader() {
		scrollToElement(currentYearInterestPaidHeader);
		return find(currentYearInterestPaidHeader, 30);
	}
	
	public String getCurrentYearInterestPaidValue() {
		return getText(currentYearInterestPaidValue);
	}
	
	public WebElement checkCurrentYearInterestSavedHeader() {
		scrollToElement(currentYearInterestSavedHeader);
		return find(currentYearInterestSavedHeader, 30);
	}
	
	public String getCurrentYearInterestSavedValue() {
		return getText(currentYearInterestSavedValue);
	}
	
	public WebElement checkCurrentYearResidentTaxWithholdingHeader() {
		scrollToElement(currentYearResidentTaxWithholdingHeader);
		return find(currentYearResidentTaxWithholdingHeader, 30);
	}
	
	public String getCurrentYearResidentTaxWithholdingValue() {
		return getText(currentYearResidentTaxWithholdingValue);
	}
	
	public WebElement checkCurrentYearNonResidentTaxWithholdingHeader() {
		scrollToElement(currentYearNonResidentTaxWithholdingHeader);
		return find(currentYearNonResidentTaxWithholdingHeader, 30);
	}
	
	public String getCurrentYearNonResidentTaxWithholdingValue() {
		return getText(currentYearNonResidentTaxWithholdingValue);
	}
	
	// Last Year section
	
	public WebElement checkLastYearHeader() {
		scrollToElement(lastYearHeader);
		return find(lastYearHeader, 30);
	}
	
	public WebElement checkLastYearInterestEarnedHeader() {
		scrollToElement(lastYearInteretEarnedHeader);
		return find(lastYearInteretEarnedHeader, 30);
	}
	
	public String getLastYearInterestEarnedValue() {
		return getText(lastYearInterestEarnedValue);
	}
	
	public WebElement checkLastYearInterestPaidHeader() {
		scrollToElement(lastYearInteretEarnedHeader);
		return find(lastYearInteretEarnedHeader, 30);
	}
	
	public String getLastYearInterestPaidValue() {
		find(lastYearInterestEarnedValue, 30);
		return getText(lastYearInterestEarnedValue);
	}
	
	public WebElement checkLastYearInterestSavedHeader() {
		scrollToElement(lastYearInteretEarnedHeader);
		return find(lastYearInteretEarnedHeader, 30);
	}
	
	public String getLastYearInterestSavedValue() {
		return getText(lastYearInterestSavedValue);
	}
	
	public WebElement checkLastYearResidentTaxWithholdingHeader() {
		scrollToElement(lastYearResidentTaxWithholdingHeader);
		return find(lastYearResidentTaxWithholdingHeader, 30);
	}
	
	public String getLastYearResidentTaxWithholdingValue() {
		return getText(lastYearResidentTaxWithholdingValue);
	}
	
	public WebElement checkLastYearNonResidentTaxWithholdingHeader() {
		scrollToElement(lastYearNonResidentTaxWithholdingHeader);
		return find(lastYearNonResidentTaxWithholdingHeader, 30);
	}
	
	public String getLastYearNonResidentTaxWithholdingValue() {
		return getText(lastYearNonResidentTaxWithholdingValue);
	}
	
	// Linked Accounts section
	
	public WebElement checkLinkedAccountsHeader() {
		scrollToElement(linkedAccountsHeader);
		return find(linkedAccountsHeader, 30);
	}
	
	public WebElement checkLinkedAccountsSuncorpLoanAccount1() {
		scrollToElement(linkedAccountsSuncorpLoanAccount1);
		return find(linkedAccountsSuncorpLoanAccount1, 30);
	}
	
	public String getLinkedAccountsSuncorpLoanAccount1Value() {
		return getText(linkedAccountsSuncorpLoanAccount1Value);
	}
	
	public WebElement checkLinkedAccountsSuncorpLoanAccount2() {
		scrollToElement(linkedAccountsSuncorpLoanAccount2);
		return find(linkedAccountsSuncorpLoanAccount2, 30);
	}
	
	public String getLinkedAccountsSuncorpLoanAccount2Value() {
		return getText(linkedAccountsSuncorpLoanAccount2Value);
	}
	
	public WebElement checkLinkedAccountsSuncorpLoanAccount3() {
		scrollToElement(linkedAccountsSuncorpLoanAccount3);
		return find(linkedAccountsSuncorpLoanAccount3, 30);
	}
	
	public String getLinkedAccountsSuncorpLoanAccount3Value() {
		return getText(linkedAccountsSuncorpLoanAccount3Value);
	}
	
	public WebElement checkLinkedAccountsSuncorpLoanAccount4() {
		scrollToElement(linkedAccountsSuncorpLoanAccount4);
		return find(linkedAccountsSuncorpLoanAccount4, 30);
	}
	
	public String getLinkedAccountsSuncorpLoanAccount4Value() {
		return getText(linkedAccountsSuncorpLoanAccount4Value);
	}
	
	public WebElement checkLinkedAccountsSuncorpLoanAccount5() {
		scrollToElement(linkedAccountsSuncorpLoanAccount5);
		return find(linkedAccountsSuncorpLoanAccount5, 30);
	}
	
	public String getLinkedAccountsSuncorpLoanAccount5Value() {
		return getText(linkedAccountsSuncorpLoanAccount5Value);
	}
	
	public WebElement checkLinkedAccountsSuncorpLoanAccount6() {
		scrollToElement(linkedAccountsSuncorpLoanAccount6);
		return find(linkedAccountsSuncorpLoanAccount6, 30);
	}
	
	public String getLinkedAccountsSuncorpLoanAccount6Value() {
		return getText(linkedAccountsSuncorpLoanAccount6Value);
	}
	
	public WebElement checkLinkedAccountsSuncorpLoanAccount7() {
		scrollToElement(linkedAccountsSuncorpLoanAccount7);
		return find(linkedAccountsSuncorpLoanAccount7, 30);
	}
	
	public String getLinkedAccountsSuncorpLoanAccount7Value() {
		return getText(linkedAccountsSuncorpLoanAccount7Value);
	}
	
	public WebElement checkLinkedAccountsSuncorpLoanAccount8() {
		scrollToElement(linkedAccountsSuncorpLoanAccount8);
		return find(linkedAccountsSuncorpLoanAccount8, 30);
	}
	
	public String getLinkedAccountsSuncorpLoanAccount8Value() {
		return getText(linkedAccountsSuncorpLoanAccount8Value);
	}
	
	public WebElement checkLinkedAccountsSuncorpLoanAccount9() {
		scrollToElement(linkedAccountsSuncorpLoanAccount9);
		return find(linkedAccountsSuncorpLoanAccount9, 30);
	}
	
	public String getLinkedAccountsSuncorpLoanAccount9Value() {
		return getText(linkedAccountsSuncorpLoanAccount9Value);
	}
	
	public WebElement checkLinkedAccountsSuncorpLoanAccount10() {
		scrollToElement(linkedAccountsSuncorpLoanAccount10);
		return find(linkedAccountsSuncorpLoanAccount10, 30);
	}
	
	public String getLinkedAccountsSuncorpLoanAccount10Value() {
		return getText(linkedAccountsSuncorpLoanAccount10Value);
	}
	
	// Posted Transactions section
	
	public WebElement checkPostedTransactionHeader() {
		scrollToElement(postedTransactionHeader);
		return find(postedTransactionHeader, 30);
	}
	
	public WebElement checkPostedTransactionPostedDateHeader() {
		scrollToElement(postedTransactionPostedDateHeader);
		return find(postedTransactionPostedDateHeader, 30);
	}
	
	public String getPostedTransactionPostedDateValue() {
		return getText(postedTransactionPostedDateValue);
	}
	
	public WebElement checkPostedTransactionAmountHeader() {
		scrollToElement(postedTransactionAmountHeader);
		return find(postedTransactionAmountHeader, 30);
	}
	
	public String getPostedTransactionAmountValue() {
		return getText(postedTransactionAmountValue);
	}
	
	public WebElement checkPostedTransactionDescriptionHeader() {
		scrollToElement(postedTransactionDescriptionHeader);
		return find(postedTransactionDescriptionHeader, 30);
	}
	
	public String getPostedTransactionDescriptionValue() {
		return getText(postedTransactionDescriptionValue);
	}
	
	public WebElement checkPostedTransactionRunningBalanceHeader() {
		scrollToElement(postedTransactionRunningBalanceHeader);
		return find(postedTransactionRunningBalanceHeader, 30);
	}
	
	public String getPostedTransactionRunningBalanceValue() {
		return getText(postedTransactionRunningBalanceValue);
	}
	
	
	/** Line of credit loan account **/
	
	public WebElement checkLineAccountHeader() {
		return find(lineOfCreditAccountHeader, 30);
	}
	
	public WebElement checkLineOfCredit() {
		scrollToElement(lineOfCreditHeader);
		return find(lineOfCreditHeader, 30);
	}
	
	public WebElement checkDebitInterestRateHeader() {
		scrollToElement(debitInterestRateHeader);
		return find(debitInterestRateHeader, 30);
	}
	
	public String getDebitInterestRateValue() {
		return getText(debitInterestRateValue);
	}
	
	public WebElement checkInterestRateTypeHeader() {
		scrollToElement(interestRateTypeHeader);
		return find(interestRateTypeHeader, 30);
	}
	
	public String getInterestRateTypeValue() {
		return getText(interestRateTypeValue);
	}
	
	// Scenario-2 - Linked Cards
	
	public WebElement checkLinkedCardsHeader() {
		scrollToElement(linkedCardsHeader);
		return find(linkedCardsHeader, 10);
	}
	
	public WebElement checkFirstLinkedCardHeader() {
		scrollToElement(linkedCardHeader1);
		return find(linkedCardHeader1, 10);
	}
	
	public String getFirstLinkedCardValue(){
		return getText(linkedCardValue1);
	}
	
	public WebElement checkSecondLinkedCardHeader() {
		scrollToElement(linkedCardHeader2);
		return find(linkedCardHeader2, 10);
	}
	
	public String getSecondLinkedCardValue(){
		return getText(linkedCardValue2);
	}
	
	/** Variable and Fixed Account **/
	
	public WebElement checkVariableFixedRateAccountHeader() {
		return find(variabelFixedRateAccountHeader, 30);
	}
}
