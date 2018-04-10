package test.marketplace.portfolio;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import pages.App;

public class MyProductsTest extends App {
	
	String coverDescription; 
	String coverDateDescription;
	String coverEndDate;
	
	// DMPM-240 Scenario 4
	//106 - Scenario 1 (DMPM-389 and DMPM-411)
	// 215 - Scenario 1 (DMPM-476)
	@Test (groups = {"DMPM-106", "DMPM-389","DMPM-411","DMPM-215","DMPM-476","DMPM-240","DMPM-1327", "marketplace", "portfolio", "priority-minor"})
	public void testElementsOnMyProductsPageWithEmptyState(){

		navigateToMyProductsScreen("bankingProduct","loginEmptyProdList");
		
		Assert.assertNotNull(myProductsPage.checkMyProductsTitle(), "My Products screen - My Products Title is not shown on My Products screen");
		Assert.assertNotNull(myProductsPage.checkAddExistingProductButton(), "My Products screen - Add existing product button is not shown");
		Assert.assertNotNull(myProductsPage.checkEmptyStateImage(), "My Products screen - image is not shown");
		Assert.assertNotNull(myProductsPage.checkEmptyStateLabel(), "My Products screen - empty state label is not shown");
		Assert.assertEquals(myProductsPage.getEmptyStateLabelText(),  utils.readTestData("copy", "portfolio","emptyStateLabel"));
		Assert.assertNotNull(myProductsPage.checkFindProductButton(), "My Products screen - Find Product button in My Products screen is not shown");
		
		myProductsPage.tapAddExistingProductButton();
		
		Assert.assertNotNull(myProductsPage.checkBottomSheetLabel(), "My Products screen - Bottom sheet label is not present");
		Assert.assertEquals(myProductsPage.getBottomSheetTitleText(), utils.readTestData("copy", "portfolio","bottomSheetLabel"));
		Assert.assertNotNull(myProductsPage.checkInsurancePolicyBottomSheetButton(), "My Products screen - Insurance policy button on Bottom sheet label is not present");
		Assert.assertNotNull(myProductsPage.checkBankAccountBottomSheetButton(), "My Products screen - Bank Account button is not present");
	}
	

	// DMPM-105 Scenario 3
	// 106 - Scenario 2 (DMPM-393), Scenario 3 (DMPM-410)
	@Test (groups = {"DMPM-106", "DMPM-393","DMPM-410", "DMPM-105","DMPM-365","marketplace", "portfolio", "priority-minor"})
	public void testProductSelectionOnEmptyScreen(){
		
		navigateToMyProductsScreen("bankingProduct","loginEmptyProdList");
		myProductsPage.tapAddExistingProductButton();
		myProductsPage.tapInsurancePolicyBottomSheetButton();
		Assert.assertNotNull(addPolicyPage.checkAddPolicyPageTitle(), "Add policy screen - Add policy title is not present");
		
		myProductsPage.tapBackButton();
		Assert.assertNull(myProductsPage.checkBottomSheetLabel(), "My Products screen - Bottom sheet label is still presented");	
		myProductsPage.tapAddExistingProductButton();
		Assert.assertNotNull(myProductsPage.checkBottomSheetLabel(), "My Products screen - Bottom sheet label is not present");
		
		myProductsPage.tapBankAccountBottomSheetButton();
		Assert.assertNotNull(addBankAccountPage.checkAddBankAccountPageTitle(), "My Products screen - Add Bank Account page title is not present");
		
		myProductsPage.tapBackButton();
		Assert.assertNotNull(myProductsPage.checkMyProductsTitle(), "My products page - title is not present");
	
	}
	
	/*106 - Scenario 3(Notes) - DMPM-410*/
	@Test (groups = {"DMPM-106", "DMPM-410", "marketplace", "portfolio", "priority-minor"})
	public void testProductSelectionScreenBackgroundAndForeground(){
		
		navigateToMyProductsScreen("bankingProduct","loginEmptyProdList");
		myProductsPage.tapAddExistingProductButton();
		common.moveAppToBackground();
		Assert.assertNull(myProductsPage.checkBottomSheetLabel(), "My Products screen - Bottom sheet label is still presented");
		Assert.assertNull(myProductsPage.checkInsurancePolicyBottomSheetButton(), "My Products screen - Insurance policy button on Bottom sheet label is still present");
		Assert.assertNull(myProductsPage.checkBottomSheetLabel(), "My Products screen - Bank Account button is still present");
		Assert.assertNotNull(myProductsPage.checkMyProductsTitle(), "My products screen - title is not present");
		
	}
	
	// DMPM-240 - Scenario 2 -Display bank account
	/*167 - Scenario 1 - DMPM-466
	 DMPM-2988 : Update mapping for banking products*/
	@Test (groups = {"DMPM-167", "DMPM-466","DMPM-2988","DMPM-3124","DMPM-1325","DMPM-240","DMPM-1325","marketplace", "portfolio", "priority-minor"})
	public void testDisplayBankAccounts(){
		
		navigateToMyProductsScreen("bankingProduct","loginProdList");
		
		// fetch the actual banking products shown on the current page
		List<String> descriptionList = myProductsPage.fetchProductTypeTextList();
		List<String> bsbList = myProductsPage.fetchBsbList();
		List<String> accountNumberList = myProductsPage.fetchAccountNumberTextList();
		List<String> avaialbleBalanceList = myProductsPage.fetchAvailableBalanceTextList();
		List<String> currentBalanceList = myProductsPage.fetchCurrentBalanceTextList();
		
		// Loading expected data from data sheet
		List<Object> bankingProducts = utils.readTestDataList("portfolio","loginProdList","bankingProducts");
		for (Object bankingProduct : bankingProducts) {
			HashMap<String, String> bankingProductItem = (HashMap<String, String>)bankingProduct;
			String accountType = bankingProductItem.get("description");
			String accNumber = bankingProductItem.get("accountNumber");
			String avaialbleBalance = bankingProductItem.get("availableBalance");
			String currentBalance = bankingProductItem.get("currentBalance");
			String bsb = bankingProductItem.get("bsb");

			Assert.assertEquals(descriptionList.get(0), accountType, "My Products Page - Account Type is not matching");
			descriptionList.remove(0);
			Assert.assertEquals(accountNumberList.get(0), accNumber, "My Products Page - Account Number is not matching");
			accountNumberList.remove(0);
			Assert.assertEquals(avaialbleBalanceList.get(0), avaialbleBalance, "My Products Page - Available Balance is not matching");
			avaialbleBalanceList.remove(0);
			Assert.assertEquals(currentBalanceList.get(0), currentBalance, "My Products Page - Current Balance is not matching");
			currentBalanceList.remove(0);
			Assert.assertEquals(bsbList.get(0), bsb, "My Products Page - BSB is not matching");
			bsbList.remove(0);
			
		}
		Assert.assertNotNull(myProductsPage.checkProductTypeImage(), "My products screen - Product Type image is not present");
		Assert.assertNotNull(myProductsPage.checkAvailableBalanceLable(), "My products screen - Available balance lable is not present");
		Assert.assertNotNull(myProductsPage.checkCurrentBalanceLabel(), "My products screen - Current balance lable is not present");
		Assert.assertNotNull(myProductsPage.checkViewDetailsButton(), "My Products Page - View details button is not present");
		
			
	}
	
	/*167 - Scenario 2 - DMPM-467*/
	@Test (groups = {"DMPM-167", "DMPM-467","marketplace", "portfolio", "priority-minor"})
	public void testNavigatingToBankAccountDetails(){
		
		navigateToMyProductsScreen("bankingProduct","loginProdList");
	
		Assert.assertNotNull(myProductsPage.checkViewDetailsButton(), "My Products Page - View details button is not present");		
		myProductsPage.tapViewDetails();
		Assert.assertNotNull(accountDetailsPage.checkAccountDetailsTitle(), "Account Details page - Account details title is not present");
		accountDetailsPage.tapBackButton();
		Assert.assertNotNull(myProductsPage.checkMyProductsTitle(), "My products page - title is not present");

		List<WebElement> accountItemLayoutList = myProductsPage.fetchAccountItemLayoutList();
		
		int numOfItems = utils.readTestDataList("portfolio","loginProdList","bankingProducts").size();
		for(int i=0 ; i<numOfItems ; i++) {
			myProductsPage.tapAccountItem(accountItemLayoutList.get(i));
			accountDetailsPage.tapBackButton();
			Assert.assertNotNull(myProductsPage.checkMyProductsTitle(), "My products page - title is not present");
		}
	}

	//DMPM-3667 Highlight expiry date for Renewal Overdue policy - Scenario 1
	@DataProvider(name = "ExpiryDateRenewalDueAndOverduePolicy")
	 
	  public static Object[][] policy() {
	 
	     	return new Object[][] { {"policy1",1}, {"policy2",1}, {"policy3",1}, {"policy4",1} };
		 
	  }
	
	
	@Test (dataProvider ="ExpiryDateRenewalDueAndOverduePolicy", groups = {"DMPM-3667", "DMPM-4139","marketplace", "portfolio", "priority-major"})
	public void testExpiryDateRenewalDueAndOverduePolicy(String policy, int riskNumber){
		
		readPolicyData(policy,riskNumber);
		String policyStatus = utils.readTestData("portfolio","insuranceProducts",policy, "status");
		
		navigateToMyProductsScreen("insuranceProduct",policy);
		
		Assert.assertTrue(myProductsPage.scrollToPolicyRisk(coverDescription), "My Products Page: Insurance products "+policy+" Policy not found");
		Assert.assertNotNull(myProductsPage.checkExpiryDateDesc(coverDescription, coverDateDescription),"My Products Page: Insurance products: Cover date description is incorrect, expected:"+coverDateDescription);
		Assert.assertNotNull(myProductsPage.checkExpiryDate(coverDescription, coverEndDate),"My Products Page: Insurance products: Cover Date is incorrect, expected:"+coverEndDate);
		Assert.assertNotNull(myProductsPage.checkPolicyStatus(coverDescription, policyStatus),"My Products Page: Insurance products: Policy status is incorrect, expected:"+policyStatus);
		
	}

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
	
	
	// DMPM-2191 Display amendment date
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
	
	// DMPM-2308 Update mapping of expiry date - {policy 6,2}
	// DMPM-2093 Update mapping for risk description
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
	
	
	// DMPM-2189 Display cancellation date
	// Scenario 1 - policy 1 (Single risk, multi cover policies)
	// Scenario 2 - 2.1 : policy 9, 2.2 : policy 10 (Multi risks, single cover policies)
	// Scenario 3 - policy11
	// Scenario 4 - 4.1 : policy12, policy13
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
	
	
	// DMPM-2187 Display future date
	// Scenario 1 - policy 1 (Single risk, multi cover policies)
	// Scenario 2 - 2.1 : policy 9, 2.2 : policy 10 (Multi risks, single cover policies)
	// Scenario 3 - policy16 ( single risk, multi covers policy)
	// Scenario 4 - 4.1 : policy17, policy18
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
	
	// DMPM-2599 Display superannuation products
	@Test(groups = { "DMPM-2599", "DMPM-3118", "marketplace", "portfolio", "priority-major" })
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
	
	// DMPM-2599 Display superannuation products
		@Test(groups = { "DMPM-2599", "DMPM-3118", "marketplace", "portfolio", "priority-major" })
		public void testLifeProducts()
		{
			
			navigateToMyProductsScreen("lifeProduct","user1");	
			
			// Get the list of wealth / super accounts displayed for the user on the screen.
			List<String> descriptionList = myProductsPage.fetchLifeProductTypeTextList();
			List<String> policyStatusList = myProductsPage.fetchLifePolicyStatusList();
			List<String> insuredNameList = myProductsPage.fetchLifePolicyInsuredNamesList();
			
			// Loading expected data from data sheet.
			List<Object> lifeProducts = utils.readTestDataList("portfolio","lifeProducts","user1","products");
			for (Object lifeProduct : lifeProducts) {
				HashMap<String, String> lifeProductItem = (HashMap<String, String>)lifeProduct;
				
				String accountType = lifeProductItem.get("description");
				String policyStatus = lifeProductItem.get("policyStatus");
				String firstInsured = lifeProductItem.get("insuredPersonsname1");
				String secondInsured = lifeProductItem.get("insuredPersonsname2");
			
				// Compare the actual and expected values for wealth products.
				Assert.assertEquals(descriptionList.get(0), accountType, "My Products Page: Wealth Products - Account Description is not matching, exptected"+accountType);
				descriptionList.remove(0);
				Assert.assertEquals(policyStatusList.get(0), policyStatus, "My Products Page: Wealth Products - Current Balance is not matching, exptected"+policyStatus);
				policyStatusList.remove(0);
				Assert.assertEquals(insuredNameList.get(0), firstInsured, "My Products Page: Wealth Products - Current Balance is not matching, exptected"+firstInsured);
				
				if(!(secondInsured.isEmpty()))
				{
					Assert.assertEquals(insuredNameList.get(1), secondInsured, "My Products Page: Wealth Products - Current Balance is not matching, exptected"+secondInsured);
					insuredNameList.remove(1);
				}
				insuredNameList.remove(0);
			
				
			}
			
		}
		
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
	
	
	// DMPM-112 Android - Add Bank Account and Inline Validations
	@Test(groups = { "DMPM-112", "DMPM-468", "DMPM-469", "DMPM-470", "DMPM-471", "DMPM-472", "DMPM-473", "DMPM-474",
			"DMPM-475", "DMPM-476", "marketplace", "portfolio", "priority-major" })
	public void testErrorValidationsOnAddBankAccount() {

		navigateToMyProductsScreen("bankingProduct", "loginEmptyProdList");
		myProductsPage.tapAddExistingProductButton();
		Assert.assertNotNull(myProductsPage.checkBottomSheetLabel(),"My Products screen - Bottom sheet label is not present");
		myProductsPage.tapBankAccountBottomSheetButton();
		Assert.assertNotNull(addBankAccountPage.checkAddBankAccountPageTitle(), "My Products screen - Add Bank Account page title is not present");
		
		myProductsPage.tapAccountNumberField();
		Assert.assertTrue(common.isKeyboardShown(),"Keyboard is not displayed after tapping on Account Number field");
		
		// Check mandatory field error message on Account Number
		myProductsPage.tapAddAccount();
		Assert.assertEquals(myProductsPage.getAccountNumberError(),utils.readTestData("copy", "portfolioError", "mandatoryError"),"My Products: Add Bank Account screen: MAccount Number field is mandatory error message is not displayed");
		
		// Check inline error message for invalid character while typing
		myProductsPage.enterAccountNumber(utils.readTestData("portfolio", "loginEmptyProdList", "addBankAccount", "inValidCharacterAccountNumber"));
		Assert.assertEquals(myProductsPage.getAccountNumberError(),utils.readTestData("copy", "portfolioError", "invalidAccountNumber"),"My Products: Add Bank Account screen: Invalid characters error message not displayed");
		
		//Check inline error message for invalid character after tapping on Add Account button
		myProductsPage.tapAddAccount();
		Assert.assertEquals(myProductsPage.getAccountNumberError(),utils.readTestData("copy", "portfolioError", "invalidAccountNumber"),"My Products: Add Bank Account screen: Invalid characters error message not displayed");

		// check the inline error message for invalid character is still displayed when the user taps in the field
		myProductsPage.tapAccountNumberField();
		Assert.assertEquals(myProductsPage.getAccountNumberError(),utils.readTestData("copy", "portfolioError", "invalidAccountNumber"),"My Products: Add Bank Account screen: Invalid characters error message not displayed");

		
		myProductsPage.clearAccountNumber();
		
		// Check inline error message for field length while typing
		myProductsPage.enterAccountNumber(utils.readTestData("portfolio", "loginEmptyProdList", "addBankAccount", "moreThanMaxAccountNumber"));
		Assert.assertEquals(myProductsPage.getAccountNumberError(),utils.readTestData("copy", "portfolioError", "lengthError"),"My Products: Add Bank Account screen: Account Number field max length error message not displayed.");
		
		// Check inline error message for field length is displayed on tapping Add Account button
		myProductsPage.tapAddAccount();
		Assert.assertEquals(myProductsPage.getAccountNumberError(),utils.readTestData("copy", "portfolioError", "lengthError"),"My Products: Add Bank Account screen: Account Number field max length error message not displayed.");

		// check the inline error message is still displayed when the user taps in the field
		myProductsPage.tapAccountNumberField();
		Assert.assertEquals(myProductsPage.getAccountNumberError(),utils.readTestData("copy", "portfolioError", "lengthError"),"My Products: Add Bank Account screen: Account Number field max length error message not displayed.");

		myProductsPage.clearAccountNumber();
		
		// check the inline error message disappears when user types correct Account number
		myProductsPage.enterAccountNumber(utils.readTestData("portfolio", "loginEmptyProdList", "addBankAccount", "validAccountNumber"));
		Assert.assertNull(myProductsPage.checkAccountNumberError(),"My Products: Add Bank Account screen: Error message is still displayed");
		

	}
	
	
	private void navigateToMyProductsScreen(String productType, String user)
	{
		if(productType=="bankingProduct")
		{
			loginToApp(utils.readTestData("portfolio",user, "login"), utils.readTestData("portfolio",user, "pwd"));
		}
		if(productType=="insuranceProduct")
		{
			loginToApp(utils.readTestData("portfolio","insuranceProducts",user,"login"), utils.readTestData("portfolio","insuranceProducts",user,"pwd"));
		}
		if(productType=="wealthProduct") 
		{
			loginToApp(utils.readTestData("portfolio","wealthProducts", user,"login"), utils.readTestData("portfolio","wealthProducts",user, "pwd"));
		}
		if(productType=="lifeProduct") 
		{
			loginToApp(utils.readTestData("portfolio","lifeProducts", user,"login"), utils.readTestData("portfolio","wealthProducts",user, "pwd"));
		}
		
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.tapProductsMenuItem();
		Assert.assertNotNull(myProductsPage.checkMyProductsTitle(), "My products page - title is not present");
	}
	
	private void readPolicyData(String policy, int riskNumber)	
	{

		coverDescription = utils.readTestData("portfolio", "insuranceProducts", policy, "risks","description" + riskNumber);
		coverDateDescription = utils.readTestData("portfolio", "insuranceProducts", policy, "risks","endDateDescription" + riskNumber);
		coverEndDate = utils.readTestData("portfolio", "insuranceProducts", policy, "risks","endDate" + riskNumber);

	}
	
	
}
