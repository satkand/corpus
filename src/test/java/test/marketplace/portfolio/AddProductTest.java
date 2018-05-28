package test.marketplace.portfolio;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import pages.App;

public class AddProductTest extends App{
	
	/*1011 - Scenario 1 - DMPM-1247, Scenario 2 DMPM-1249*/
	@Test (groups = {"DMPM-1011", "DMPM-1247", "DMPM-1249" ,"marketplace", "portfolio", "priority-minor"})
	public void testAddingAPolicy(){

	navigateToAddProductsScreen("prodUser","loginProdList");
	
	addProductPage.tapAddInsurancePolicyButton();
	
	Assert.assertNotNull(addPolicyPage.checkAddPolicyPageTitle(), "Add policy screen - Add policy title is not present");
	
	Assert.assertNotNull(addPolicyPage.checkForgotMyDetailsButton(),"Add policy screen - Forgotten my details button is not present");

	addPolicyPage.tapPolicyNumberTextBox();
	addPolicyPage.enterPolicyNumber(utils.readTestData("portfolio","loginProdList", "addPolicy", "enterPolicyNumber"));
	Assert.assertNotNull(addPolicyPage.checkAddAccountButton(), "Add policy screen - Add account buttom is not present");
	addPolicyPage.tapAddAccountButton();
	//verify the loading indicator here
	Assert.assertNotNull(addPolicyPage.checkSuccessMessage(), "Add policy screen - Success message is not present");
	Assert.assertNotNull(addPolicyPage.checkSuccessImage(), "Add policy screen - Success image is not present");
	Assert.assertEquals(addPolicyPage.getSuccessMessage(), utils.readTestData("copy", "portfolio","policyAddedSuccessfulMsg"), "Add policy Page - Successful message is not matching");
	Assert.assertNotNull(myProductsPage.checkMyProductsTitle(), "My products page - title is not present");
	
	}

	
	/*344 - Scenario 1 - DMPM-462* and Scenario 3 - DMPM-464*/
	@Test (groups = {"DMPM-344", "DMPM-462","DMPM-464", "marketplace", "portfolio", "priority-minor"})
	public void testInlineErrorsAsItype(){
		navigateToAddProductsScreen("prodUser","loginProdList");
		
		addProductPage.tapAddInsurancePolicyButton();
		
		Assert.assertNotNull(addPolicyPage.checkAddPolicyPageTitle(), "Add policy screen - Add policy title is not present");
	
		Assert.assertNotNull(addPolicyPage.checkForgotMyDetailsButton(),"Add policy screen - Forgotten my details button is not present");

		addPolicyPage.tapPolicyNumberTextBox();
		addPolicyPage.enterPolicyNumber(utils.readTestData("portfolio","loginProdList", "addPolicy", "policyNumberExceedsMaxLimit"));
		
		Assert.assertNotNull(addPolicyPage.checkPolicyNumberinlineError(), "Add policy screen - inline Error message is not present");
		Assert.assertEquals(addPolicyPage.getPolicyNumberinlineError(), utils.readTestData("copy", "portfolio","maxLimitError"), "Add policy Page - Max limit error message is not matching");
		
		addPolicyPage.deletecharactersInPolicyNumber(1);
		Assert.assertNull(addPolicyPage.checkPolicyNumberinlineError(), "Add policy screen - inline Error message is still present");
		
		addPolicyPage.enterPolicyNumber(utils.readTestData("portfolio","loginProdList","addPolicy", "policyNumberInvalidChars"));
		Assert.assertNotNull(addPolicyPage.checkPolicyNumberinlineError(), "Add policy screen - inline Error message is not present");
		Assert.assertEquals(addPolicyPage.getPolicyNumberinlineError(), utils.readTestData("copy", "portfolio","invalidCharactor"), "Add policy Page - Invalid charactor error message is not matching");
		
		addPolicyPage.clearPolicyNumber();
		Assert.assertNull(addPolicyPage.checkPolicyNumberinlineError(), "Add policy screen - inline Error message is still present");
		
		addPolicyPage.enterPolicyNumber(utils.readTestData("portfolio","loginProdList","addPolicy", "policyNumberExceedsMaxLimit")+utils.readTestData("portfolio","loginProdList","addPolicy", "policyNumberInvalidChars"));
		Assert.assertNotNull(addPolicyPage.checkPolicyNumberinlineError(), "Add policy screen - inline Error message is not present");
		Assert.assertEquals(addPolicyPage.getPolicyNumberinlineError(), utils.readTestData("copy", "portfolio","maxLimitError")+"\n"+"\n"+utils.readTestData("copy", "portfolio","invalidCharactor"), "Add policy Page - Invalid charactor error message is not matching");
		
		addPolicyPage.deletecharactersInPolicyNumber(6);
		Assert.assertNull(addPolicyPage.checkPolicyNumberinlineError(), "Add policy screen - inline Error message is still present");
		
	}
	
	/*344 - scenario2 - "DMPM-463" and Scenario 4 - DMPM-465
	 * 108 - scenario 9 -DMPM-459*/
	@Test (groups = {"DMPM-344", "DMPM-463", "DMPM-465","DMPM-108", "DMPM-459", "marketplace", "portfolio", "priority-minor"})
	public void testInlineErrorMessagesOnTapOut(){
		
		navigateToAddProductsScreen("prodUser","loginProdList");
		
		addProductPage.tapAddInsurancePolicyButton();
		
		Assert.assertNotNull(addPolicyPage.checkAddPolicyPageTitle(), "Add policy screen - Add policy title is not present");
		Assert.assertNotNull(addPolicyPage.checkForgotMyDetailsButton(),"Add policy screen - Forgotten my details button is not present");

	
		addPolicyPage.tapAddAccountButton();
		
		Assert.assertNotNull(addPolicyPage.checkPolicyNumberinlineError(), "Add policy screen - inline Error message is not present");
		Assert.assertEquals(addPolicyPage.getPolicyNumberinlineError(), utils.readTestData("copy", "portfolio","feildValidationError"), "Add policy Page - Field validation error message is not matching");
		
		addPolicyPage.enterPolicyNumber(utils.readTestData("portfolio","loginProdList","addPolicy", "minimumChar"));
		Assert.assertNull(addPolicyPage.checkPolicyNumberinlineError(), "Add policy screen - inline Error message is still present");
		
		addPolicyPage.enterPolicyNumber(utils.readTestData("portfolio","loginProdList","addPolicy", "enterPolicyNumber"));
		addPolicyPage.tapAddAccountButton();
		Assert.assertNotNull(addPolicyPage.checkSuccessMessage(), "Add policy screen - success message is not displayed");
		Assert.assertEquals(addPolicyPage.getSuccessMessage(), utils.readTestData("copy", "portfolio","policyAddedSuccessfulMsg"), "Add policy Page - policy added Successfuly message is not matching");
		Assert.assertNotNull(addPolicyPage.checkSuccessImage(), "Add policy screen - success image is not displayed");
		
		
	}
	
	// This test case checks the error validations on adding Superannuation accounts
		// DMPM-3420 Add superannuation product
		@Test(groups = { "DMPM-3420", "DMPM-6854", "DMPM-6855", "DMPM-6856", "DMPM-6857", "DMPM-6858", "DMPM-6859", "DMPM-6860",
				"DMPM-6861", "DMPM-6862", "DMPM-6863","marketplace", "portfolio", "priority-major" })
		public void testErrorValidationsOnAddSuperAccount() {

			navigateToAddProductsScreen("emptylist", "loginEmptyProdList");
			
			addProductPage.tapAddSuperAccountButton();
			Assert.assertNotNull(addBankAccountPage.checkAddSuperAccountPageTitle(), "My Products screen - Add Super Account page title is not present");

			
			addBankAccountPage.tapSuperAccountNumberField();
			Assert.assertTrue(common.isKeyboardShown(),"Keyboard is not displayed after tapping on Account Number field");
			
			// Check mandatory field error message on Account Number
			addBankAccountPage.tapAddSuperAccount();
			Assert.assertEquals(addBankAccountPage.getAccountNumberError(), Copy.ADD_SUPER_ACC_MANDATORY_ERROR,"My Products: Add Super Account screen: Account Number field is mandatory error message is not displayed");
			
			// Check inline error message for invalid character while typing
			addBankAccountPage.enterSuperAccountNumber(utils.readTestData("portfolio","loginProdList","addSuperAccount","inValidCharacterAccountNumber"));
			Assert.assertEquals(addBankAccountPage.getAccountNumberError(),Copy.ADD_SUPER_ACC_SPECIAL_CHARS_ERROR,"My Products: Add Super Account screen: Invalid characters error message not displayed");
			
			//Check inline error message for invalid character after tapping on Add Account button
			addBankAccountPage.tapAddSuperAccount();
			Assert.assertEquals(addBankAccountPage.getAccountNumberError(),Copy.ADD_SUPER_ACC_SPECIAL_CHARS_ERROR,"My Products: Add Super Account screen: Invalid characters error message not displayed");

			// check the inline error message for invalid character is still displayed when the user taps in the field
			addBankAccountPage.tapSuperAccountNumberField();
			Assert.assertEquals(addBankAccountPage.getAccountNumberError(),Copy.ADD_SUPER_ACC_SPECIAL_CHARS_ERROR,"My Products: Add Super Account screen: Invalid characters error message not displayed");

			
			addBankAccountPage.clearSuperAccountNumber();
			
			// Check inline error message for field length while typing
			addBankAccountPage.enterSuperAccountNumber(utils.readTestData("portfolio", "loginProdList", "addSuperAccount", "moreThanMaxAccountNumber"));
			Assert.assertEquals(addBankAccountPage.getAccountNumberError(),Copy.ADD_SUPER_ACC_LENGTH_ERROR,"My Products: Add Super Account screen: Account Number field max length error message not displayed.");
			
			// Check inline error message for field length is displayed on tapping Add Account button
			addBankAccountPage.tapAddSuperAccount();
			Assert.assertEquals(addBankAccountPage.getAccountNumberError(),Copy.ADD_SUPER_ACC_LENGTH_ERROR,"My Products: Add Super Account screen: Account Number field max length error message not displayed.");

			// check the inline error message is still displayed when the user taps in the field
			addBankAccountPage.tapSuperAccountNumberField();
			Assert.assertEquals(addBankAccountPage.getAccountNumberError(),Copy.ADD_SUPER_ACC_LENGTH_ERROR,"My Products: Add Super Account screen: Account Number field max length error message not displayed.");

			addBankAccountPage.clearSuperAccountNumber();
			
			// Check inline error message for field length while typing
			addBankAccountPage.enterSuperAccountNumber(utils.readTestData("portfolio", "loginProdList", "addSuperAccount", "lessThanMinAccountNumber"));
			Assert.assertEquals(addBankAccountPage.getAccountNumberError(),Copy.ADD_SUPER_ACC_LENGTH_ERROR,"My Products: Add Super Account screen: Account Number field min length error message not displayed.");
					
			// Check inline error message for field length is displayed on tapping Add Account button
			addBankAccountPage.tapAddSuperAccount();
			Assert.assertEquals(addBankAccountPage.getAccountNumberError(),Copy.ADD_SUPER_ACC_LENGTH_ERROR,"My Products: Add Super Account screen: Account Number field min length error message not displayed.");

			// check the inline error message is still displayed when the user taps in the field
			addBankAccountPage.tapSuperAccountNumberField();
			Assert.assertEquals(addBankAccountPage.getAccountNumberError(),Copy.ADD_SUPER_ACC_LENGTH_ERROR,"My Products: Add Super Account screen: Account Number field min length error message not displayed.");

			addBankAccountPage.clearSuperAccountNumber();

			// check the inline error message disappears when user types correct Account number
			addBankAccountPage.enterSuperAccountNumber(utils.readTestData("portfolio", "loginProdList", "addSuperAccount", "validAccountNumber"));
			Assert.assertNull(addBankAccountPage.checkAccountNumberError(),"My Products: Add Super Account screen: Error message is still displayed");
			

		}
	
		// This function verifies adding bank account with inline validations
		// DMPM-112 Android - Add Bank Account and Inline Validations
		// DMPM-5901 Enforce sentence case for all product descriptions
		@Test(groups = { "DMPM-112", "DMPM-468", "DMPM-469", "DMPM-470", "DMPM-471", "DMPM-472", "DMPM-473", "DMPM-474",
				"DMPM-475", "DMPM-476", "marketplace", "portfolio", "priority-major" })
		public void testErrorValidationsOnAddBankAccount() {

			navigateToAddProductsScreen("emptylist", "loginEmptyProdList");
			
			addProductPage.tapAddBankAccountButton();
			Assert.assertNotNull(addBankAccountPage.checkAddBankAccountPageTitle(), "My Products screen - Add Bank Account page title is not present");

			addBankAccountPage.tapAccountNumberField();
			Assert.assertTrue(common.isKeyboardShown(),"Keyboard is not displayed after tapping on Account Number field");
			
			// Check mandatory field error message on Account Number
			addBankAccountPage.tapAddAccount();
			Assert.assertEquals(addBankAccountPage.getAccountNumberError(),utils.readTestData("copy", "portfolioError", "mandatoryError"),"My Products: Add Bank Account screen: MAccount Number field is mandatory error message is not displayed");
			
			// Check inline error message for invalid character while typing
			addBankAccountPage.enterAccountNumber(utils.readTestData("portfolio","loginProdList","addBankAccount","inValidCharacterAccountNumber"));
			Assert.assertEquals(addBankAccountPage.getAccountNumberError(),utils.readTestData("copy", "portfolioError", "invalidAccountNumber"),"My Products: Add Bank Account screen: Invalid characters error message not displayed");
			
			//Check inline error message for invalid character after tapping on Add Account button
			addBankAccountPage.tapAddAccount();
			Assert.assertEquals(addBankAccountPage.getAccountNumberError(),utils.readTestData("copy", "portfolioError", "invalidAccountNumber"),"My Products: Add Bank Account screen: Invalid characters error message not displayed");

			// check the inline error message for invalid character is still displayed when the user taps in the field
			addBankAccountPage.tapAccountNumberField();
			Assert.assertEquals(addBankAccountPage.getAccountNumberError(),utils.readTestData("copy", "portfolioError", "invalidAccountNumber"),"My Products: Add Bank Account screen: Invalid characters error message not displayed");

			
			addBankAccountPage.clearAccountNumber();
			
			// Check inline error message for field length while typing
			addBankAccountPage.enterAccountNumber(utils.readTestData("portfolio", "loginProdList", "addBankAccount", "moreThanMaxAccountNumber"));
			Assert.assertEquals(addBankAccountPage.getAccountNumberError(),utils.readTestData("copy", "portfolioError", "lengthError"),"My Products: Add Bank Account screen: Account Number field max length error message not displayed.");
			
			// Check inline error message for field length is displayed on tapping Add Account button
			addBankAccountPage.tapAddAccount();
			Assert.assertEquals(addBankAccountPage.getAccountNumberError(),utils.readTestData("copy", "portfolioError", "lengthError"),"My Products: Add Bank Account screen: Account Number field max length error message not displayed.");

			// check the inline error message is still displayed when the user taps in the field
			addBankAccountPage.tapAccountNumberField();
			Assert.assertEquals(addBankAccountPage.getAccountNumberError(),utils.readTestData("copy", "portfolioError", "lengthError"),"My Products: Add Bank Account screen: Account Number field max length error message not displayed.");

			addBankAccountPage.clearAccountNumber();
			
			// check the inline error message disappears when user types correct Account number
			addBankAccountPage.enterAccountNumber(utils.readTestData("portfolio", "loginProdList", "addBankAccount", "validAccountNumber"));
			Assert.assertNull(addBankAccountPage.checkAccountNumberError(),"My Products: Add Bank Account screen: Error message is still displayed");
			

		}
		
	private void navigateToAddProductsScreen(String productType, String user) {
		
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
		
		myProductsPage.scrollToAddExistingProductButton();
		
		myProductsPage.tapAddExistingProductButton();
		Assert.assertNotNull(addProductPage.checkAddExistingProductScreenLabel(),"My Products screen - Add exisitng product screen title is not present");
		
		
	}

}
