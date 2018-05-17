package test.marketplace.portfolio;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import automation.framework.common.Copy;

import static org.testng.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import pages.App;

public class MyProductsTest extends App {
	
	String coverDescription; 
	String coverDateDescription;
	String coverEndDate;
	
	SoftAssert softAssert = new SoftAssert();
	
	// This method verifies the elements on products screen without any policies or accounts
	// DMPM-240 Scenario 4
	//106 - Scenario 1 (DMPM-389 and DMPM-411)
	// 215 - Scenario 1 (DMPM-476)
	@Test (groups = {"DMPM-106", "DMPM-389","DMPM-411","DMPM-215","DMPM-476","DMPM-240","DMPM-1327", "marketplace", "portfolio", "priority-minor"})
	public void testElementsOnMyProductsPageWithEmptyState(){

		navigateToMyProductsScreen("emptylist","loginEmptyProdList");
		
		Assert.assertNotNull(myProductsPage.checkMyProductsTitle(), "My Products screen - My Products Title is not shown on My Products screen");
		Assert.assertNotNull(myProductsPage.checkAddExistingProductButton(), "My Products screen - Add existing product button is not shown");
		Assert.assertNotNull(myProductsPage.checkEmptyStateImage(), "My Products screen - image is not shown");
		Assert.assertNotNull(myProductsPage.checkEmptyStateLabel(), "My Products screen - empty state label is not shown");
		Assert.assertEquals(myProductsPage.getEmptyStateLabelText(),  utils.readTestData("copy", "portfolio","emptyStateLabel"));
		Assert.assertNotNull(myProductsPage.checkEmptyStateDescription(), "My Products screen - empty state description is not shown");
		Assert.assertEquals(myProductsPage.getEmptyStateDescriptionText(),  Copy.EMPTY_PORTFOLIO_SCREEN_DESCRIPTION);
		Assert.assertNotNull(myProductsPage.checkFindProductButton(), "My Products screen - Find Product button in My Products screen is not shown");
		
		myProductsPage.tapAddExistingProductButton();
		
		Assert.assertNotNull(myProductsPage.checkAddExistingProductScreenLabel(), "My Products screen - Bottom sheet label is not present");
		Assert.assertEquals(myProductsPage.getaddExistingProductScreenTitleText(), utils.readTestData("copy", "portfolio","addExistingProductScreenLabel"));
		Assert.assertNotNull(myProductsPage.checkAddInsurancePolicyButton(), "My Products screen - Insurance policy button on Bottom sheet label is not present");
		Assert.assertNotNull(myProductsPage.checkAddBankAccountButton(), "My Products screen - Bank Account button is not present");
		Assert.assertNotNull(myProductsPage.checkAddSuperAccountButton(), "My Products screen - Super Account button is not present");

	}
	

	// DMPM-6705 Design updates for add policy and add bank account screen
	// DMPM-105 Scenario 3
	// 106 - Scenario 2 (DMPM-393), Scenario 3 (DMPM-410)
	@Test (groups = {"DMPM-106", "DMPM-393","DMPM-410", "DMPM-105","DMPM-365","DMPM-6705","marketplace", "portfolio", "priority-minor"})
	public void testProductSelectionOnEmptyScreen(){
		
		navigateToMyProductsScreen("emptylist","loginEmptyProdList");
		myProductsPage.tapAddExistingProductButton();
		myProductsPage.tapAddInsurancePolicyButton();
		Assert.assertNotNull(addPolicyPage.checkAddPolicyPageTitle(), "Add policy screen - Add policy title is not present");
		
		myProductsPage.tapBackButton();
		Assert.assertNull(myProductsPage.checkAddExistingProductScreenLabel(), "My Products screen - Add existing product screen title is still presented");	
		myProductsPage.tapAddExistingProductButton();
		Assert.assertNotNull(myProductsPage.checkAddExistingProductScreenLabel(), "My Products screen - Add existing product screen title is not present");
		
		myProductsPage.tapAddBankAccountButton();
		Assert.assertNotNull(addBankAccountPage.checkAddBankAccountPageTitle(), "My Products screen - Add Bank Account page title is not present");
		
		myProductsPage.tapBackButton();
		Assert.assertNull(myProductsPage.checkAddExistingProductScreenLabel(), "My Products screen - Add existing product screen title is still presented");	
		myProductsPage.tapAddExistingProductButton();
	
		Assert.assertNotNull(myProductsPage.checkAddExistingProductScreenLabel(), "My Products screen - Add existing product screen title is not present");
		myProductsPage.tapAddSuperAccountButton();
		Assert.assertNotNull(addBankAccountPage.checkAddSuperAccountPageTitle(), "My Products screen - Add Super Account page title is not present");
	
	
	}
	
	/*106 - Scenario 3(Notes) - DMPM-410*/
	@Test (groups = {"DMPM-106", "DMPM-410", "marketplace", "portfolio", "priority-minor"})
	public void testProductSelectionScreenBackgroundAndForeground(){
		
		navigateToMyProductsScreen("emptylist","loginEmptyProdList");
		myProductsPage.tapAddExistingProductButton();
		common.moveAppToBackground();
		Assert.assertNull(myProductsPage.checkAddExistingProductScreenLabel(), "My Products screen - Add existing product screen title is still presented");
		Assert.assertNull(myProductsPage.checkAddInsurancePolicyButton(), "My Products screen - Insurance policy button on Bottom sheet label is still present");
		Assert.assertNull(myProductsPage.checkAddExistingProductScreenLabel(), "My Products screen - Bank Account button is still present");
		Assert.assertNotNull(myProductsPage.checkMyProductsTitle(), "My products screen - title is not present");
		
	}
	
	// This method verifies the element on Bank Account details screens
	/*167 - Scenario 2 - DMPM-467*/
	@Test (groups = {"DMPM-167", "DMPM-467","marketplace", "portfolio", "priority-minor"})
	public void testNavigatingToBankAccountDetails(){
		
		navigateToMyProductsScreen("bankingProduct","termDepositAccount");
	
		Assert.assertNotNull(myProductsPage.checkViewDetailsButton(), "My Products Page - View details button is not present");		
		myProductsPage.tapViewDetails();
		Assert.assertNotNull(accountDetailsPage.checkAccountDetailsTitle(), "Account Details page - Account details title is not present");
		accountDetailsPage.tapBackButton();
		Assert.assertNotNull(myProductsPage.checkMyProductsTitle(), "My products page - title is not present");

		List<WebElement> accountItemLayoutList = myProductsPage.fetchAccountItemLayoutList();
		
		int numOfItems = utils.readTestDataList("portfolio","bankingProducts","termDepositAccount","products").size();
		for(int i=0 ; i<numOfItems ; i++) {
			myProductsPage.tapAccountItem(accountItemLayoutList.get(i));
			accountDetailsPage.tapBackButton();
			Assert.assertNotNull(myProductsPage.checkMyProductsTitle(), "My products page - title is not present");
		}
	}

	// DMPM-5862 Abbreviate month on the date
	// This function verifies the policy details where risk status - Expiry date
	//DMPM-3667 Highlight expiry date for Renewal Overdue policy - Scenario 1
	//DMPM-5598 Update mapping of expiry date for renewal statuses
	@DataProvider(name = "ExpiryDateRenewalDueAndOverduePolicy")
	 
	  public static Object[][] policy() {
	 
	     	return new Object[][] { {"policy1",1}, {"policy2",1}, {"policy3",1}, {"policy4",1} };
	     			 
	  }
	
	
	@Test (dataProvider ="ExpiryDateRenewalDueAndOverduePolicy", groups = {"DMPM-3667", "DMPM-4139","DMPM-5598","DMPM-6010","marketplace", "portfolio", "priority-major"})
	public void testExpiryDateRenewalDueAndOverduePolicy(String policy, int riskNumber){
		
		readPolicyData(policy,riskNumber);
		
		String policyStatus = utils.readTestData("portfolio","insuranceProducts",policy, "status");
		
		navigateToMyProductsScreen("insuranceProduct",policy);
		
		Assert.assertTrue(myProductsPage.scrollToPolicyRisk(coverDescription), "My Products Page: Insurance products "+policy+" Policy not found");
		Assert.assertNotNull(myProductsPage.checkExpiryDateDesc(coverDescription, coverDateDescription),"My Products Page: Insurance products: Cover date description is incorrect, expected:"+coverDateDescription);
		Assert.assertNotNull(myProductsPage.checkExpiryDate(coverDescription, coverEndDate),"My Products Page: Insurance products: Cover Date is incorrect, expected:"+coverEndDate);
		Assert.assertNotNull(myProductsPage.checkPolicyStatus(coverDescription, policyStatus),"My Products Page: Insurance products: Policy status is incorrect, expected:"+policyStatus);
		
	}

	// Check app navigates to policy details screen after tapping on renew now button
	@DataProvider(name = "RenewNow")
	 
	  public static Object[][] renewNow() {
	 
	     	return new Object[][] { {"policy1",1} };
	     			 
	  }
	
	@Test (dataProvider ="RenewNow", groups = {"DMPM-6669", "DMPM-7145","marketplace", "portfolio", "priority-minor"})
	public void testRenewNowButton(String policy, int riskNumber){
		
		readPolicyData(policy,riskNumber);

		navigateToMyProductsScreen("insuranceProduct",policy);
		
		Assert.assertTrue(myProductsPage.scrollToPolicyRisk(coverDescription), "My Products Page: Insurance products "+policy+" Policy not found");
		Assert.assertNotNull(myProductsPage.checkRenewNowButton(),"My Products Page: Insurance products: Renew Now button is not present");
		
		myProductsPage.tapRenewNowButton();
		
		// Check app navigates to policy details screen
		Assert.assertNotNull(myProductsPage.checkPolicyDetailsTitle(),"My Products Page: Insurance products: Policy Details screen is not displayed");	
		
	}
	
	// This function verifies the policy statuses
	// DMPM-5862 Abbreviate month on the date
	//DMPM-2087 Display policy-level status
	@DataProvider(name = "PolicyLevelStatus")
	 
	  public static Object[][] policyLevelStatus() {
	 
		return new Object[][] { { "policy1",1 }, { "policy2",1 }, { "policy5",1 },
				{ "policy6",1 }, { "policy7",1 }, { "policy8",1 }, { "policy9",1 }, { "policy10",1 }, { "policy11",1 },
				 { "policy14",1 } };

	  }
	

	@Test (dataProvider ="PolicyLevelStatus", groups = {"DMPM-2087", "DMPM-3388","marketplace", "portfolio", "priority-major"})
	public void testPolicyLevelStatus(String policy, int riskNumber){
		
		String coverDescription = utils.readTestData("portfolio","insuranceProducts",policy, "risks","description"+riskNumber);
		String policyStatus = utils.readTestData("portfolio","insuranceProducts",policy, "status");
		
		navigateToMyProductsScreen("insuranceProduct",policy);
			
		Assert.assertTrue(myProductsPage.scrollToPolicyRisk(coverDescription), "My Products Page: Insurance products "+policy+" Policy not found");
		Assert.assertNotNull(myProductsPage.checkPolicyStatus(coverDescription, policyStatus),"My Products Page: Insurance products: Policy status is incorrect, expected:"+policyStatus);
		
	}
	
	
	// This function verifies the policy details where risk status - Amendment date
	// DMPM-2191 Display amendment date
	// DMPM-5862 Abbreviate month on the date
	// Scenario 1 - policy 19, policy 20 (Single risk, multi cover policies)
	// Scenario 2 - 2.1 : policy 5, 2.2 : policy 6, 2.3 policy 7, 2.4 policy 8 (Multi risks, multi covers policies)
	@DataProvider(name = "AmendmentDatePolicies")

	public static Object[][] amendmentDatePolicies() {

		return new Object[][] { { "policy19", 1 }, { "policy20", 1 }, { "policy5", 1 }, { "policy5", 2 },
				{ "policy6", 1 }, { "policy6", 2 }, { "policy7", 1 }, { "policy7", 2 }, { "policy8", 1 },
				{ "policy8", 2 } };

	}

	@Test(dataProvider = "AmendmentDatePolicies", groups = { "DMPM-2191", "DMPM-3401","DMPM-3402", "marketplace", "portfolio",
			"priority-major" })
	public void testAmendmentDatePolicy(String policy, int riskNumber) {

		readPolicyData(policy,riskNumber);

		navigateToMyProductsScreen("insuranceProduct",policy);

		Assert.assertTrue(myProductsPage.scrollToPolicyRisk(coverDescription), "My Products Page: Insurance products "+policy+" Policy not found");
		Assert.assertNotNull(myProductsPage.checkExpiryDateDesc(coverDescription, coverDateDescription),"My Products Page: Insurance products: Cover date description is incorrect, expected:"+coverDateDescription);
		Assert.assertNotNull(myProductsPage.checkExpiryDate(coverDescription, coverEndDate),"My Products Page: Insurance products: Cover Date is incorrect, expected:"+coverEndDate);
	
	}
	
	// This function verifies the policy data
	// DMPM-2308 Update mapping of expiry date - {policy 6,2}
	// DMPM-2093 Update mapping for risk description
	// DMPM-5862 Abbreviate month on the date
	@DataProvider(name = "policyData")

	public static Object[][] policyData() {

		return new Object[][] { { "policy1", 1 },{ "policy6", 2 }};

	}

	@Test(dataProvider = "policyData", groups = { "DMPM-2308", "DMPM-2714","DMPM-2093","DMPM-2675", "DMPM-105","DMPM-363","marketplace", "portfolio",
				"priority-major" })
	public void testpolicyData(String policy, int riskNumber) {

		readPolicyData(policy,riskNumber);
		String policyStatus = utils.readTestData("portfolio", "insuranceProducts", policy, "status");

		navigateToMyProductsScreen("insuranceProduct",policy);

		Assert.assertTrue(myProductsPage.scrollToPolicyRisk(coverDescription), "My Products Page: Insurance products "+policy+"Policy not found");
		Assert.assertNotNull(myProductsPage.checkExpiryDateDesc(coverDescription, coverDateDescription),"My Products Page: Insurance products: Cover date description is incorrect, expected:"+coverDateDescription);
		Assert.assertNotNull(myProductsPage.checkExpiryDate(coverDescription, coverEndDate),"My Products Page: Insurance products: Cover Date is incorrect, expected:"+coverEndDate);
		Assert.assertNotNull(myProductsPage.checkPolicyStatus(coverDescription, policyStatus),"My Products Page: Insurance products: Policy status is incorrect, expected:"+policyStatus);

		}
	
	// This function verifies the policy details where risk status - Cancellation date
	// DMPM-2189 Display cancellation date
	// Scenario 1 - policy 1 (Single risk, multi cover policies)
	// Scenario 2 - 2.1 : policy 9, 2.2 : policy 10 (Multi risks, single cover policies)
	// Scenario 3 - policy11
	// Scenario 4 - 4.1 : policy12, policy13
	// DMPM-5862 Abbreviate month on the date
	@DataProvider(name = "CancellationDatePolicies")

	public static Object[][] cancellationDatePolicies() {

		return new Object[][] { { "policy1", 1 }, { "policy9", 1 }, { "policy9", 2 }, { "policy10", 1 },
				{ "policy10", 2 }, { "policy11", 1 }, { "policy12", 1 }, { "policy12", 2 }, { "policy13", 1 },
				{ "policy13", 2 } };

	}

	@Test(dataProvider = "CancellationDatePolicies", groups = { "DMPM-2189", "DMPM-3389", "DMPM-3390","DMPM-3391","DMPM-3392", "marketplace",
			"portfolio", "priority-major" })
	public void testCancellationDatePolicy(String policy, int riskNumber) {

		readPolicyData(policy,riskNumber);

		navigateToMyProductsScreen("insuranceProduct",policy);

		Assert.assertTrue(myProductsPage.scrollToPolicyRisk(coverDescription), "My Products Page: Insurance products "+policy+"Policy not found");
		Assert.assertNotNull(myProductsPage.checkExpiryDateDesc(coverDescription, coverDateDescription),"My Products Page: Insurance products: Cover date description is incorrect, expected:"+coverDateDescription);
		Assert.assertNotNull(myProductsPage.checkExpiryDate(coverDescription, coverEndDate),"My Products Page: Insurance products: Cover Date is incorrect, expected:"+coverEndDate);
	
	}
	
	// This function verifies the policy details where risk status - Future date
	// DMPM-2187 Display future date
	// Scenario 1 - policy 1 (Single risk, multi cover policies)
	// Scenario 2 - 2.1 : policy 9, 2.2 : policy 10 (Multi risks, single cover policies)
	// Scenario 3 - policy16 ( single risk, multi covers policy)
	// Scenario 4 - 4.1 : policy17, policy18
	// DMPM-5862 Abbreviate month on the date
	@DataProvider(name = "FutureDatePolicies")
	public static Object[][] futureDatePolicies() {

		return new Object[][] { { "policy3", 1 }, { "policy14", 1 }, { "policy14", 2 }, { "policy15", 1 },
				{ "policy15", 2 }, { "policy16", 1 }, { "policy17", 1 }, { "policy17", 2 }, { "policy18", 1 },
				{ "policy18", 2 } };
				


	}

	@Test(dataProvider = "FutureDatePolicies", groups = { "DMPM-2187", "DMPM-3397", "DMPM-3398", "DMPM-3399","DMPM-3400","marketplace",
			"portfolio", "priority-major" })
	
	public void testFutureDatePolicy(String policy, int riskNumber) {

		readPolicyData(policy,riskNumber);
		
		navigateToMyProductsScreen("insuranceProduct",policy);
		
		Assert.assertTrue(myProductsPage.scrollToPolicyRisk(coverDescription), "My Products Page: Insurance products "+policy+"Policy not found");
		Assert.assertNotNull(myProductsPage.checkExpiryDateDesc(coverDescription, coverDateDescription),"My Products Page: Insurance products: Cover date description is incorrect, expected:"+coverDateDescription);
		Assert.assertNotNull(myProductsPage.checkExpiryDate(coverDescription, coverEndDate),"My Products Page: Insurance products: Cover Date is incorrect, expected:"+coverEndDate);
	
	}
	
	// This function verifies the super accounts
	// DMPM-2599 Display superannuation products
	@Test(groups = { "DMPM-167", "DMPM-466","DMPM-2988","DMPM-3124","DMPM-1325","DMPM-240","DMPM-1325","DMPM-2599", "DMPM-3118", "marketplace", "portfolio", "priority-major" })
	public void testWealthProducts()
	{
		
		navigateToMyProductsScreen("wealthProduct","user1");	
		
		// Get the list of wealth / super accounts displayed for the user on the screen.
		List<String> descriptionList = myProductsPage.fetchWealthProductTypeTextList();
		List<String> accountNumberList = myProductsPage.fetchWealthProductAccountNumberTextList();
		List<String> currentBalanceList = myProductsPage.fetchWealthProductCurrentBalanceTextList();
		
		// Loading expected data from data sheet.
		List<Object> wealthProducts = utils.readTestDataList("portfolio","wealthProducts","user1","products");
		for (Object wealthProduct : wealthProducts) {
			HashMap<String, String> wealthProductItem = (HashMap<String, String>)wealthProduct;
			String accountType = wealthProductItem.get("description");
			String accNumber = wealthProductItem.get("accountNumber");
			String currentBalance = wealthProductItem.get("accountBalance");
			
			// Compare the actual and expected values for wealth products.
			Assert.assertEquals(descriptionList.get(0), accountType, "My Products Page: Wealth Products - Account Description is not matching, exptected"+accountType);
			descriptionList.remove(0);
			Assert.assertEquals(accountNumberList.get(0), accNumber, "My Products Page: Wealth Products - Account Number is not matching, exptected"+accNumber);
			accountNumberList.remove(0);
			Assert.assertEquals(currentBalanceList.get(0), currentBalance, "My Products Page: Wealth Products - Current Balance is not matching, exptected"+currentBalance);
			currentBalanceList.remove(0);
			
			
		}
	}
	
	// This function verifies the life insurance accounts
	// DMPM-2599 Display life insurance products
	// DMPM-5799
	// DMPM-5103 Append "insurance" to my product type
	// DMPM-5901 Enforce sentence case for all product descriptions
	@Test(groups = { "DMPM-2599", "DMPM-3118", "DMPM-5799","DMPM-5103","DMPM-6048","marketplace", "portfolio", "priority-major" })
		public void testLifeProducts()
		{
			
			navigateToMyProductsScreen("lifeProduct","lifeProductAccount");	
			Assert.assertNotNull(myProductsPage.checkMyProductsTitle(), "My products page - title is not present");
			
			// Get the list of wealth / super accounts displayed for the user on the screen.
			List<String> descriptionList = myProductsPage.fetchLifeProductTypeTextList();
			List<String> policyStatusList = myProductsPage.fetchLifePolicyStatusList();
			List<String> insuredNameList = myProductsPage.fetchLifePolicyInsuredNamesList();
			
			// Loading expected data from data sheet.
			List<Object> lifeProducts = utils.readTestDataList("portfolio","bankingProducts","lifeProductAccount","products");
			for (Object lifeProduct : lifeProducts) {
				HashMap<String, String> lifeProductItem = (HashMap<String, String>)lifeProduct;
				
				String accountType = lifeProductItem.get("description");
				String policyStatus = lifeProductItem.get("policyStatus");
				String firstInsured = lifeProductItem.get("insuredPersonsname1");
				String secondInsured = lifeProductItem.get("insuredPersonsname2");
			
				// Compare the actual and expected values for wealth products.
				Assert.assertEquals(descriptionList.get(0), accountType, "My Products Page: Wealth Products - Account Description is not matching, exptected"+accountType);
				descriptionList.remove(0);
				Assert.assertEquals(policyStatusList.get(0), policyStatus, "My Products Page: Wealth Products - Policy Status is not matching, exptected"+policyStatus);
				policyStatusList.remove(0);
				
				if((secondInsured.isEmpty()))
				{
					Assert.assertEquals(insuredNameList.get(0), firstInsured, "My Products Page: Wealth Products - Insured persons name is not matching, exptected"+firstInsured);
					insuredNameList.remove(0);
				}
				else
				{
					Assert.assertEquals(insuredNameList.get(0), firstInsured+", "+secondInsured, "My Products Page: Wealth Products - Insured persons name is not matching, exptected"+firstInsured+","+secondInsured);
					insuredNameList.remove(0);
					
				}
								
			}
			
		}
		
	// This function verifies the Insurance accounts		
	// DMPM-105 View Insurance Policies - Scenario 4	
	@DataProvider(name = "PolicyDetails")
	public static Object[][] policyDetails() {

		return new Object[][] { { "policy3", 1 } };

	}
		
	// DMPM-105 View Insurance Policies - Scenario 4
	@Test(dataProvider = "PolicyDetails", groups = { "DMPM-105", "DMPM-367", "marketplace", "portfolio",
			"priority-major" })
	public void testViewPolicyButton(String policy, int riskNumber) {

		readPolicyData(policy, riskNumber);

		navigateToMyProductsScreen("insuranceProduct", policy);

		Assert.assertTrue(myProductsPage.scrollToPolicyRisk(coverDescription),"My Products Page: Insurance products " + policy + "Policy not found");
		Assert.assertNotNull(myProductsPage.checkViewDetailsButtonForPolicy(coverDescription),"My Products Page: Insurance products: View Policy button not displayed");

		myProductsPage.tapViewPolicyButton(coverDescription);
		
		Assert.assertNotNull(myProductsPage.checkPolicyDetailsTitle(),"My Products Page: Insurance products: Policy Details screen is not displayed");

		
	}
	
	// This function verifies adding bank account with inline validations
	// DMPM-112 Android - Add Bank Account and Inline Validations
	// DMPM-5901 Enforce sentence case for all product descriptions
	@Test(groups = { "DMPM-112", "DMPM-468", "DMPM-469", "DMPM-470", "DMPM-471", "DMPM-472", "DMPM-473", "DMPM-474",
			"DMPM-475", "DMPM-476", "marketplace", "portfolio", "priority-major" })
	public void testErrorValidationsOnAddBankAccount() {

		navigateToMyProductsScreen("emptylist", "loginEmptyProdList");
		myProductsPage.tapAddExistingProductButton();
		Assert.assertNotNull(myProductsPage.checkAddExistingProductScreenLabel(),"My Products screen - Add exisitng product screen title is not present");
		myProductsPage.tapAddBankAccountButton();
		Assert.assertNotNull(addBankAccountPage.checkAddBankAccountPageTitle(), "My Products screen - Add Bank Account page title is not present");
		
		myProductsPage.tapAccountNumberField();
		Assert.assertTrue(common.isKeyboardShown(),"Keyboard is not displayed after tapping on Account Number field");
		
		// Check mandatory field error message on Account Number
		myProductsPage.tapAddAccount();
		Assert.assertEquals(myProductsPage.getAccountNumberError(),utils.readTestData("copy", "portfolioError", "mandatoryError"),"My Products: Add Bank Account screen: MAccount Number field is mandatory error message is not displayed");
		
		// Check inline error message for invalid character while typing
		myProductsPage.enterAccountNumber(utils.readTestData("portfolio","loginProdList","addBankAccount","inValidCharacterAccountNumber"));
		Assert.assertEquals(myProductsPage.getAccountNumberError(),utils.readTestData("copy", "portfolioError", "invalidAccountNumber"),"My Products: Add Bank Account screen: Invalid characters error message not displayed");
		
		//Check inline error message for invalid character after tapping on Add Account button
		myProductsPage.tapAddAccount();
		Assert.assertEquals(myProductsPage.getAccountNumberError(),utils.readTestData("copy", "portfolioError", "invalidAccountNumber"),"My Products: Add Bank Account screen: Invalid characters error message not displayed");

		// check the inline error message for invalid character is still displayed when the user taps in the field
		myProductsPage.tapAccountNumberField();
		Assert.assertEquals(myProductsPage.getAccountNumberError(),utils.readTestData("copy", "portfolioError", "invalidAccountNumber"),"My Products: Add Bank Account screen: Invalid characters error message not displayed");

		
		myProductsPage.clearAccountNumber();
		
		// Check inline error message for field length while typing
		myProductsPage.enterAccountNumber(utils.readTestData("portfolio", "loginProdList", "addBankAccount", "moreThanMaxAccountNumber"));
		Assert.assertEquals(myProductsPage.getAccountNumberError(),utils.readTestData("copy", "portfolioError", "lengthError"),"My Products: Add Bank Account screen: Account Number field max length error message not displayed.");
		
		// Check inline error message for field length is displayed on tapping Add Account button
		myProductsPage.tapAddAccount();
		Assert.assertEquals(myProductsPage.getAccountNumberError(),utils.readTestData("copy", "portfolioError", "lengthError"),"My Products: Add Bank Account screen: Account Number field max length error message not displayed.");

		// check the inline error message is still displayed when the user taps in the field
		myProductsPage.tapAccountNumberField();
		Assert.assertEquals(myProductsPage.getAccountNumberError(),utils.readTestData("copy", "portfolioError", "lengthError"),"My Products: Add Bank Account screen: Account Number field max length error message not displayed.");

		myProductsPage.clearAccountNumber();
		
		// check the inline error message disappears when user types correct Account number
		myProductsPage.enterAccountNumber(utils.readTestData("portfolio", "loginProdList", "addBankAccount", "validAccountNumber"));
		Assert.assertNull(myProductsPage.checkAccountNumberError(),"My Products: Add Bank Account screen: Error message is still displayed");
		

	}
	
	
	// This test case checks the error validations on adding Superannuation accounts
	// DMPM-3420 Add superannuation product
	@Test(groups = { "DMPM-3420", "DMPM-6854", "DMPM-6855", "DMPM-6856", "DMPM-6857", "DMPM-6858", "DMPM-6859", "DMPM-6860",
			"DMPM-6861", "DMPM-6862", "DMPM-6863","marketplace", "portfolio", "priority-major" })
	public void testErrorValidationsOnAddSuperAccount() {

		navigateToMyProductsScreen("emptylist", "loginEmptyProdList");
		myProductsPage.tapAddExistingProductButton();
		Assert.assertNotNull(myProductsPage.checkAddExistingProductScreenLabel(),"My Products screen - Add exisitng product screen title is not present");
		myProductsPage.tapAddSuperAccountButton();
		Assert.assertNotNull(addBankAccountPage.checkAddSuperAccountPageTitle(), "My Products screen - Add Super Account page title is not present");
		
		myProductsPage.tapSuperAccountNumberField();
		Assert.assertTrue(common.isKeyboardShown(),"Keyboard is not displayed after tapping on Account Number field");
		
		// Check mandatory field error message on Account Number
		myProductsPage.tapAddSuperAccount();
		Assert.assertEquals(myProductsPage.getAccountNumberError(), Copy.ADD_SUPER_ACC_MANDATORY_ERROR,"My Products: Add Super Account screen: Account Number field is mandatory error message is not displayed");
		
		// Check inline error message for invalid character while typing
		myProductsPage.enterSuperAccountNumber(utils.readTestData("portfolio","loginProdList","addSuperAccount","inValidCharacterAccountNumber"));
		Assert.assertEquals(myProductsPage.getAccountNumberError(),Copy.ADD_SUPER_ACC_SPECIAL_CHARS_ERROR,"My Products: Add Super Account screen: Invalid characters error message not displayed");
		
		//Check inline error message for invalid character after tapping on Add Account button
		myProductsPage.tapAddSuperAccount();
		Assert.assertEquals(myProductsPage.getAccountNumberError(),Copy.ADD_SUPER_ACC_SPECIAL_CHARS_ERROR,"My Products: Add Super Account screen: Invalid characters error message not displayed");

		// check the inline error message for invalid character is still displayed when the user taps in the field
		myProductsPage.tapSuperAccountNumberField();
		Assert.assertEquals(myProductsPage.getAccountNumberError(),Copy.ADD_SUPER_ACC_SPECIAL_CHARS_ERROR,"My Products: Add Super Account screen: Invalid characters error message not displayed");

		
		myProductsPage.clearSuperAccountNumber();
		
		// Check inline error message for field length while typing
		myProductsPage.enterSuperAccountNumber(utils.readTestData("portfolio", "loginProdList", "addSuperAccount", "moreThanMaxAccountNumber"));
		Assert.assertEquals(myProductsPage.getAccountNumberError(),Copy.ADD_SUPER_ACC_LENGTH_ERROR,"My Products: Add Super Account screen: Account Number field max length error message not displayed.");
		
		// Check inline error message for field length is displayed on tapping Add Account button
		myProductsPage.tapAddSuperAccount();
		Assert.assertEquals(myProductsPage.getAccountNumberError(),Copy.ADD_SUPER_ACC_LENGTH_ERROR,"My Products: Add Super Account screen: Account Number field max length error message not displayed.");

		// check the inline error message is still displayed when the user taps in the field
		myProductsPage.tapSuperAccountNumberField();
		Assert.assertEquals(myProductsPage.getAccountNumberError(),Copy.ADD_SUPER_ACC_LENGTH_ERROR,"My Products: Add Super Account screen: Account Number field max length error message not displayed.");

		myProductsPage.clearSuperAccountNumber();
		
		// Check inline error message for field length while typing
		myProductsPage.enterSuperAccountNumber(utils.readTestData("portfolio", "loginProdList", "addSuperAccount", "lessThanMinAccountNumber"));
		Assert.assertEquals(myProductsPage.getAccountNumberError(),Copy.ADD_SUPER_ACC_LENGTH_ERROR,"My Products: Add Super Account screen: Account Number field min length error message not displayed.");
				
		// Check inline error message for field length is displayed on tapping Add Account button
		myProductsPage.tapAddSuperAccount();
		Assert.assertEquals(myProductsPage.getAccountNumberError(),Copy.ADD_SUPER_ACC_LENGTH_ERROR,"My Products: Add Super Account screen: Account Number field min length error message not displayed.");

		// check the inline error message is still displayed when the user taps in the field
		myProductsPage.tapSuperAccountNumberField();
		Assert.assertEquals(myProductsPage.getAccountNumberError(),Copy.ADD_SUPER_ACC_LENGTH_ERROR,"My Products: Add Super Account screen: Account Number field min length error message not displayed.");

		myProductsPage.clearSuperAccountNumber();

		// check the inline error message disappears when user types correct Account number
		myProductsPage.enterSuperAccountNumber(utils.readTestData("portfolio", "loginProdList", "addSuperAccount", "validAccountNumber"));
		Assert.assertNull(myProductsPage.checkAccountNumberError(),"My Products: Add Super Account screen: Error message is still displayed");
		

	}
	
	// This function verifies the every day bank accounts
	// DMPM-240 - Scenario 2 -Display bank account
		/*167 - Scenario 1 - DMPM-466
		 DMPM-2988 : Update mapping for banking products*/
	//DMPM-5555 Update displaying of Everyday Accounts
	// DMPM-5901 Enforce sentence case for all product descriptions
	@Test (groups = {"DMPM-167", "DMPM-466","DMPM-2988","DMPM-3124","DMPM-1325","DMPM-240","DMPM-1325","DMPM-5555", "DMPM-6043","marketplace", "portfolio", "priority-minor"})
	public void testTransactionBankAccountDetails(){
	
		navigateToMyProductsScreen("bankingProduct", "everyDayAccount");

		// fetch the actual banking products shown on the current page
		List<String> descriptionList = myProductsPage.fetchProductTypeTextList();
		List<String> bsbList = myProductsPage.fetchBsbList();
		List<String> accountNumberList = myProductsPage.fetchAccountNumberTextList();
		List<String> avaialbleBalanceList = myProductsPage.fetchAvailableBalanceTextList();
		
		// Loading expected data from data sheet
		List<Object> bankingProducts = utils.readTestDataList("portfolio","bankingProducts","everyDayAccount","products");
		for (Object bankingProduct : bankingProducts) {
			HashMap<String, String> bankingProductItem = (HashMap<String, String>)bankingProduct;
			String accountType = bankingProductItem.get("description");
			String accNumber = bankingProductItem.get("accountNumber");
			String avaialbleBalance = bankingProductItem.get("availableBalance");
			String bsb = bankingProductItem.get("bsb");

			softAssert.assertEquals(descriptionList.get(0), accountType, "My Products Page - Account Type is not matching");
			descriptionList.remove(0);
			softAssert.assertEquals(accountNumberList.get(0), accNumber, "My Products Page - Account Number is not matching");
			accountNumberList.remove(0);
			softAssert.assertEquals(avaialbleBalanceList.get(0), avaialbleBalance, "My Products Page - Available Balance is not matching");
			avaialbleBalanceList.remove(0);
			softAssert.assertEquals(bsbList.get(0), bsb, "My Products Page - BSB is not matching");
			bsbList.remove(0);
			
			softAssert.assertAll();
			
		}
		Assert.assertNotNull(myProductsPage.checkProductTypeImage(), "My products screen - Product Type image is not present");
		
		
		Assert.assertNotNull(myProductsPage.checkAvailableBalanceLable(), "My products screen - Available balance lable is not present");
		Assert.assertNotNull(myProductsPage.checkViewDetailsButton(), "My Products Page - View details button is not present");
		
	}
	
	// This function verifies the term deposit accounts
	// DMPM-240 - Scenario 2 -Display bank account
	/*167 - Scenario 1 - DMPM-466
		 DMPM-2988 : Update mapping for banking products*/
	//DMPM-3700 Update displaying of Term deposit Accounts
		@Test (groups = {"DMPM-167", "DMPM-466","DMPM-2988","DMPM-3124","DMPM-1325","DMPM-240","DMPM-1325","DMPM-3700", "DMPM-6009","marketplace", "portfolio", "priority-minor"})
		public void testTermDepositsBankAccountDetails(){
		
			navigateToMyProductsScreen("bankingProduct", "termDepositAccount");

			// fetch the actual banking products shown on the current page
			List<String> descriptionList = myProductsPage.fetchProductTypeTextList();
			List<String> bsbList = myProductsPage.fetchBsbList();
			List<String> accountNumberList = myProductsPage.fetchAccountNumberTextList();
			List<String> currentBalanceList = myProductsPage.fetchCurrentBalanceTextList();
	
			// Loading expected data from data sheet
			List<Object> bankingProducts = utils.readTestDataList("portfolio","bankingProducts","termDepositAccount","products");
			for (Object bankingProduct : bankingProducts) {
				HashMap<String, String> bankingProductItem = (HashMap<String, String>)bankingProduct;
				String accountType = bankingProductItem.get("description");
				String accNumber = bankingProductItem.get("accountNumber");
				String currentBalance = bankingProductItem.get("currentBalance");
				String bsb = bankingProductItem.get("bsb");

				softAssert.assertEquals(descriptionList.get(0), accountType, "My Products Page - Account Type is not matching");
				descriptionList.remove(0);
				softAssert.assertEquals(accountNumberList.get(0), accNumber, "My Products Page - Account Number is not matching");
				accountNumberList.remove(0);
				softAssert.assertEquals(currentBalanceList.get(0), currentBalance, "My Products Page - Current Balance is not matching");
				currentBalanceList.remove(0);
				softAssert.assertEquals(bsbList.get(0), bsb, "My Products Page - BSB is not matching");
				bsbList.remove(0);
				
				softAssert.assertAll();
				
			}
			Assert.assertNotNull(myProductsPage.checkProductTypeImage(), "My products screen - Product Type image is not present");
			Assert.assertNotNull(myProductsPage.checkCurrentBalanceLabel(), "My products screen - Available balance lable is not present");
			Assert.assertNotNull(myProductsPage.checkViewDetailsButton(), "My Products Page - View details button is not present");
			
		}
	
	// This function verifies the credit loan accounts
	// DMPM-240 - Scenario 2 -Display bank account
	// 167 - Scenario 1 - DMPM-466 DMPM-2988 : Update mapping for banking products
	// DMPM-2607 Display line of credit loan products
	// DMPM-5901 Enforce sentence case for all product descriptions
	@Test(groups = { "DMPM-167", "DMPM-466","DMPM-2988","DMPM-3124","DMPM-1325","DMPM-240","DMPM-1325","DMPM-2607", "DMPM-6008", "marketplace", "portfolio", "priority-minor" })
	public void testLineOfCreditLoanBankAccountDetails() {

		navigateToMyProductsScreen("bankingProduct", "lineOfCreditAccount");

		// fetch the actual banking products shown on the current page
		List<String> descriptionList = myProductsPage.fetchProductTypeTextList();
		List<String> bsbList = myProductsPage.fetchBsbList();
		List<String> accountNumberList = myProductsPage.fetchAccountNumberTextList();
		List<String> currentBalanceList = myProductsPage.fetchCurrentBalanceTextList();
		List<String> avaialbleBalanceList = myProductsPage.fetchAvailableBalanceTextList();

		// Loading expected data from data sheet
		List<Object> bankingProducts = utils.readTestDataList("portfolio", "bankingProducts", "lineOfCreditAccount",
				"products");
		for (Object bankingProduct : bankingProducts) {
			HashMap<String, String> bankingProductItem = (HashMap<String, String>) bankingProduct;
			String accountType = bankingProductItem.get("description");
			String accNumber = bankingProductItem.get("accountNumber");
			String currentBalance = bankingProductItem.get("currentBalance");
			String avaialbleBalance = bankingProductItem.get("availableBalance");
			String bsb = bankingProductItem.get("bsb");

			softAssert.assertEquals(descriptionList.get(0), accountType,"My Products Page - Account Type is not matching");
			descriptionList.remove(0);
			softAssert.assertEquals(accountNumberList.get(0), accNumber,"My Products Page - Account Number is not matching");
			accountNumberList.remove(0);
			softAssert.assertEquals(currentBalanceList.get(0), currentBalance,"My Products Page - Current Balance is not matching");
			currentBalanceList.remove(0);
			softAssert.assertEquals(avaialbleBalanceList.get(0), avaialbleBalance,"My Products Page - Available Balance is not matching");
			avaialbleBalanceList.remove(0);
			softAssert.assertEquals(bsbList.get(0), bsb, "My Products Page - BSB is not matching");
			bsbList.remove(0);

			softAssert.assertAll();

		}
		Assert.assertNotNull(myProductsPage.checkProductTypeImage(),"My products screen - Product Type image is not present");
		Assert.assertNotNull(myProductsPage.checkCurrentBalanceLabel(),"My products screen - Available balance lable is not present");
		Assert.assertNotNull(myProductsPage.checkViewDetailsButton(),"My Products Page - View details button is not present");

	}
	
	// This function verifies the Loan accounts
	// DMPM-240 - Scenario 2 -Display bank account
	/*167 - Scenario 1 - DMPM-466
	DMPM-2988 : Update mapping for banking products*/
	// DMPM-2605 Display variable and fixed rate loan products
	// DMPM-5901 Enforce sentence case for all product descriptions
		@Test(groups = { "DMPM-167", "DMPM-466","DMPM-2988","DMPM-3124","DMPM-1325","DMPM-240","DMPM-1325","DMPM-2605", "DMPM-6044", "marketplace", "portfolio", "priority-minor" })
		public void testLoanBankAccountDetails() {

			navigateToMyProductsScreen("bankingProduct", "loanAccount");

			// fetch the actual banking products shown on the current page
			List<String> descriptionList = myProductsPage.fetchProductTypeTextList();
			List<String> bsbList = myProductsPage.fetchBsbList();
			List<String> overduePaymentList = myProductsPage.fetchOverduePaymentAmount();
			List<String> accountNumberList = myProductsPage.fetchAccountNumberTextList();
			List<String> currentBalanceList = myProductsPage.fetchCurrentBalanceTextList();	
			List<String> nextPaymentAmountList = myProductsPage.fetchNextPaymentAmount();
			List<String> nextPaymentDueDateList = myProductsPage.fetchNextPaymentDueDate();


			// Loading expected data from data sheet
			List<Object> bankingProducts = utils.readTestDataList("portfolio", "bankingProducts", "loanAccount",
					"products");
			for (Object bankingProduct : bankingProducts) {
				HashMap<String, String> bankingProductItem = (HashMap<String, String>) bankingProduct;
				String accountType = bankingProductItem.get("description");
				String accNumber = bankingProductItem.get("accountNumber");
				String currentBalance = bankingProductItem.get("currentBalance");
				String bsb = bankingProductItem.get("bsb");
				String overduePayment = bankingProductItem.get("arrearsAmount");
				String nextPaymentAmount =  bankingProductItem.get("nextPaymentamount");
				String nextPaymentDueDate =  bankingProductItem.get("nextPaymentdate");

				softAssert.assertEquals(descriptionList.get(0), accountType,"My Products Page - Account Type is not matching");
				descriptionList.remove(0);
				softAssert.assertEquals(accountNumberList.get(0), accNumber,"My Products Page - Account Number is not matching");
				accountNumberList.remove(0);
				softAssert.assertEquals(currentBalanceList.get(0), currentBalance,"My Products Page - Current Balance is not matching");
				currentBalanceList.remove(0);
				softAssert.assertEquals(bsbList.get(0), bsb, "My Products Page - BSB is not matching");
				bsbList.remove(0);
				
				if(overduePayment.isEmpty())
				{
					softAssert.assertEquals(nextPaymentAmountList.get(0), nextPaymentAmount,"My Products Page - Next payment amount is not matching");
					nextPaymentAmountList.remove(0);
					softAssert.assertEquals(nextPaymentDueDateList.get(0), nextPaymentDueDate, "My Products Page - Next payment due date is not matching");
					nextPaymentDueDateList.remove(0);
				}
				else
				{
					softAssert.assertEquals(overduePaymentList.get(0), overduePayment,"My Products Page - Overdue amount is not matching");
					overduePaymentList.remove(0);
				}

				softAssert.assertAll();

			}
			Assert.assertNotNull(myProductsPage.checkViewDetailsButton(),"My Products Page - View details button is not present");

		}
		
		// DMPM-1460 UI updates on the Products Portfolio screen
	@DataProvider(name = "AddExistingProduct")
	public static Object[][] addExistingProduct() {

		return new Object[][] { { "policy1", 1 } };

	}

	// DMPM-1460 UI updates on the Products Portfolio screen
	@Test(dataProvider = "AddExistingProduct", groups = { "DMPM-1460", "marketplace", "portfolio", "priority-minor" })
	public void testAddExistingProductButton(String policy, int riskNumber) {
		
		navigateToMyProductsScreen("insuranceProduct", policy);
		
		Assert.assertNull(myProductsPage.checkAddExistingProductButton(),"Add existing product button is displayed ");
		
		myProductsPage.scrollToAddExistingProductButton();
			
		Assert.assertNotNull(myProductsPage.checkAddExistingProductButton(),"Add existing product button is displayed ");

	}
		
	// DMPM-1460 UI updates on the Products Portfolio screen
		@Test(groups = { "DMPM-6127","DMPM-7151","DMPM-7153","DMPM-7154", "marketplace", "portfolio", "priority-major" })
		public void testDisclaimerPortfolioScreen() {
			
			loginToApp(utils.readTestData("portfolio","bankingProducts","lifeProductAccount", "login"), utils.readTestData("portfolio","bankingProducts", "lifeProductAccount", "pwd"));

			navigationMenu.tapSplitMenuIcon();
			Assert.assertNotNull(navigationMenu.checkProductsMenuItem(), "Main Menu : My Products menu option is not displayed");
			
			navigationMenu.tapProductsMenuItem();
			
			// Check disclaimer is displayed
			Assert.assertNotNull(myProductsPage.checkPortfolioDisclaimerScreenTitle(),"Portfolio disclaimer is not displayed.");
			
			// Tap back button
			myProductsPage.tapBackButton();
			
			Assert.assertNotNull(myProductsPage.checkMyProductsTitle(), "My products page - title is not present");

			// Navigate away from portfolio screen 
			navigationMenu.tapSplitMenuIcon();
			navigationMenu.tapSuncorpMenuItem();
			
			// Navigate to Portfolio screen and check disclaimer is not displayed
			navigationMenu.tapSplitMenuIcon();
			navigationMenu.tapProductsMenuItem();

			// Check disclaimer is not displayed
			Assert.assertNull(myProductsPage.checkPortfolioDisclaimerScreenTitle(),"Portfolio disclaimer is displayed.");
	

		}	
		
	private void navigateToMyProductsScreen(String productType, String user)
	{
		boolean productFound = false;
		if(productType=="bankingProduct")
		{
			loginToApp(utils.readTestData("portfolio","bankingProducts",user, "login"), utils.readTestData("portfolio","bankingProducts", user, "pwd"));
			productFound = true;
		}
		if(productType=="insuranceProduct")
		{
			loginToApp(utils.readTestData("portfolio","insuranceProducts",user,"login"), utils.readTestData("portfolio","insuranceProducts",user,"pwd"));
			
			
			productFound = true;
		}
		if(productType=="wealthProduct") 
		{
			loginToApp(utils.readTestData("portfolio","wealthProducts", user,"login"), utils.readTestData("portfolio","wealthProducts",user, "pwd"));
			productFound = true;
		}
		if(productType=="lifeProduct") 
		{
			loginToApp(utils.readTestData("portfolio","bankingProducts", user,"login"), utils.readTestData("portfolio","bankingProducts",user, "pwd"));
			productFound = true;
		}
		if(productFound == false)
		{
			loginToApp(utils.readTestData("portfolio",user,"login"), utils.readTestData("portfolio",user,"pwd"));

		}
		
		
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkProductsMenuItem(), "Main Menu : My Products menu option is not displayed");

		
		navigationMenu.tapProductsMenuItem();
		
		// check if disclaimer is displayed, and if displayed tap back to close the screen
		if(myProductsPage.checkPortfolioDisclaimerScreenTitle() != null) {
			myProductsPage.tapBackButton();
		}
		
		Assert.assertNotNull(myProductsPage.checkMyProductsTitle(), "My products page - title is not present");
	}
	
	private void readPolicyData(String policy, int riskNumber)	
	{

		coverDescription = utils.readTestData("portfolio", "insuranceProducts", policy, "risks","description" + riskNumber);
		coverDateDescription = utils.readTestData("portfolio", "insuranceProducts", policy, "risks","endDateDescription" + riskNumber);
		coverEndDate = utils.readTestData("portfolio", "insuranceProducts", policy, "risks","endDate" + riskNumber);

	}
	
	
}
