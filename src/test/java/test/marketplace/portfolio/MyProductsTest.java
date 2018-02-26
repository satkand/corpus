package test.marketplace.portfolio;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class MyProductsTest extends App {
	
	/*106 - Scenario 1 - DMPM-389 and DMPM-411
	Scenario 2 - DMPM-411
	Scenario 3 - DMPM-410*/
	@Test (groups = {"DMPM-106", "DMPM-389","DMPM-411","DMPM-393","DMPM-410", "marketplace", "portfolio", "priority-minor"})
	public void testProductSelectionscreen(){
		
		navigateToMyProductsScreen();
		Assert.assertNotNull(myProductsPage.checkMyProductsTitle(), "My Products Title is not shown on My Products screen");
		Assert.assertNotNull(myProductsPage.checkAddExistingProductButton(), "Add existing product button is not shown");
		Assert.assertNotNull(myProductsPage.checkEmptyStateImage(), "My Products screen image is not shown");
		Assert.assertNotNull(myProductsPage.checkEmptyStateLabel(), "My Products screen empty state label is not shown");
		Assert.assertNotNull(myProductsPage.checkFindProductButton(), "Find Product button in My Products screen is not shown");
		
		myProductsPage.tapAddExistingProductButton();
		
		Assert.assertNotNull(myProductsPage.checkBottomSheetLabel(), "Bottom sheet label is not present");
		Assert.assertNotNull(myProductsPage.checkInsurancePolicyBottomSheetButton(), "Insurance policy button on Bottom sheet label is not present");
		Assert.assertNotNull(myProductsPage.checkBankAccountBottomSheetButton(), "Bank Account button is not present");
		
		
		myProductsPage.tapInsurancePolicyBottomSheetButton();
		Assert.assertNotNull(addPolicyPage.checkAddPolicyPageTitle(), "Add policy title is not present");
	/*	Assert.assertNotNull(myProductsPage.checkPolicyNumberPlaceHolderText(), "Policy number place holder is not present");
		Assert.assertNotNull(myProductsPage.checkAddAccountButton(), "Add Account button is not present");
		Assert.assertNotNull(myProductsPage.checkForgotMyDetailsButton(), "Forgot my details button is not present");
		Assert.assertNotNull(myProductsPage.checkSupportedbrandsTextLabel(), "Supported brands label is not present");
		Assert.assertNotNull(myProductsPage.checkSupportedbrandsImage(), "Supported brands image is not present");*/
		
		spendingsPage.tapBackButton();
		Assert.assertNull(myProductsPage.checkBottomSheetLabel(), "Bottom sheet label is still presented");	
		myProductsPage.tapAddExistingProductButton();
		Assert.assertNotNull(myProductsPage.checkBottomSheetLabel(), "Bottom sheet label is not present");
		
		myProductsPage.tapBankAccountBottomSheetButton();
		Assert.assertNotNull(addBankAccountPage.checkAddBankAccountPageTitle(), "Add Bank Account page title is not present");
	/*	Assert.assertNotNull(myProductsPage.checkAddBankAccountPlaceHolderText(), "Add Bank Account placeholder text is not present");
		Assert.assertNotNull(myProductsPage.checkAddBankAccountButton(), "Add Account button is not present");
		Assert.assertNotNull(myProductsPage.checkAddBankAccountForgotDetailaButton(), "forgoten my details button is not present");*/
		
		
	}
	
	/*106 - Scenario 1 - DMPM-389 and DMPM-411*/
	@Test (groups = {"DMPM-106", "DMPM-389","DMPM-411", "marketplace", "portfolio", "priority-minor"})
	public void testProductSelectionScreenTextVerification(){
		navigateToMyProductsScreen();
		Assert.assertEquals(myProductsPage.getMyProductsTitleText(), utils.readTestData("copy", "portfolio","myProductsLabel"));
		Assert.assertEquals(myProductsPage.getEmptyStateLabelText(),  utils.readTestData("copy", "portfolio","emptyStateLabel"));
		Assert.assertEquals(myProductsPage.getFindProductButtonText(), utils.readTestData("copy", "portfolio","findProductButton"));
		Assert.assertEquals(myProductsPage.getAddExistingProductButtonText(), utils.readTestData("copy", "portfolio","addExistingProductButton"));
		
		myProductsPage.tapAddExistingProductButton();
		Assert.assertEquals(myProductsPage.getBottomSheetTitleText(), utils.readTestData("copy", "portfolio","bottomSheetLabel"));
		Assert.assertEquals(myProductsPage.getInsurancePolicyBottomSheetButtonText(), utils.readTestData("copy", "portfolio","insurancePolicyBottomSheetButton"));
		Assert.assertEquals(myProductsPage.getBankAccountBottomSheetButtonText(), utils.readTestData("copy", "portfolio","bankAccountBottomSheetButton"));
		
	}
	
	/*106 - Scenario 3(Notes) - DMPM-410*/
	@Test (groups = {"DMPM-106", "DMPM-389","DMPM-411", "marketplace", "portfolio", "priority-minor"})
	public void testProductSelectionScreenBackgroundAndForeground(){
		navigateToMyProductsScreen();
		Assert.assertEquals(myProductsPage.getMyProductsTitleText(), "My products");
		myProductsPage.tapAddExistingProductButton();
		common.moveAppToBackground();
		Assert.assertNull(myProductsPage.checkBottomSheetLabel(), "Bottom sheet label is still presented");
		Assert.assertNull(myProductsPage.checkInsurancePolicyBottomSheetButton(), "Insurance policy button on Bottom sheet label is still present");
		Assert.assertNull(myProductsPage.checkBottomSheetLabel(), "Bank Account button is still present");
		
	}

	private void navigateToMyProductsScreen(){
		loginToApp(utils.readTestData("portfolio", "login"), utils.readTestData("portfolio", "pwd"));
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.tapProductsMenuItem();
		
		
	}
	
	
}
