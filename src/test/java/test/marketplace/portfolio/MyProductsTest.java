package test.marketplace.portfolio;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class MyProductsTest extends App {
	
	//106 - Scenario 1 (DMPM-389 and DMPM-411)
	// 215 - Scenario 1 (DMPM-476)
	@Test (groups = {"DMPM-106", "DMPM-389","DMPM-411","DMPM-215","DMPM-476", "marketplace", "portfolio", "priority-minor"})
	public void testElementsOnMyProductsPageWithEmptyState(){
		navigateToMyProductsScreen("emptyProdListUser");
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
	

	// 106 - Scenario 2 (DMPM-393), Scenario 3 (DMPM-410)
	@Test (groups = {"DMPM-106", "DMPM-393","DMPM-410", "marketplace", "portfolio", "priority-minor"})
	public void testProductSelectionscreen(){
		navigateToMyProductsScreen("emptyProdListUser");
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
		navigateToMyProductsScreen("emptyProdListUser");
		myProductsPage.tapAddExistingProductButton();
		common.moveAppToBackground();
		Assert.assertNull(myProductsPage.checkBottomSheetLabel(), "My Products screen - Bottom sheet label is still presented");
		Assert.assertNull(myProductsPage.checkInsurancePolicyBottomSheetButton(), "My Products screen - Insurance policy button on Bottom sheet label is still present");
		Assert.assertNull(myProductsPage.checkBottomSheetLabel(), "My Products screen - Bank Account button is still present");
		Assert.assertNotNull(myProductsPage.checkMyProductsTitle(), "My products screen - title is not present");
		
	}
	
	/*167 - Scenario 1 - DMPM-466*/
	@Test (groups = {"DMPM-167", "DMPM-466","marketplace", "portfolio", "priority-minor"})
	public void testDisplayBankAccounts(){
		navigateToMyProductsScreen("prodListUser");
		
		Assert.assertNotNull(myProductsPage.checkProductType(), "Product type image is not presented");
		// fetch the actual banking products shown on the current page
		List<String> descriptionList = myProductsPage.fetchProductTypeTextList();
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

			Assert.assertEquals(descriptionList.get(0), accountType, "My Products Page - Account Type is not matching");
			descriptionList.remove(0);
			Assert.assertEquals(accountNumberList.get(0), accNumber, "My Products Page - Account Number is not matching");
			accountNumberList.remove(0);
			Assert.assertEquals(avaialbleBalanceList.get(0), avaialbleBalance, "My Products Page - Available Balance is not matching");
			avaialbleBalanceList.remove(0);
			Assert.assertEquals(currentBalanceList.get(0), currentBalance, "My Products Page - Current Balance is not matching");
			currentBalanceList.remove(0);
			
		}
		
		Assert.assertNotNull(myProductsPage.checkAvailableBalanceLable(), "My products screen - Available balance lable is not present");
		Assert.assertNotNull(myProductsPage.checkCurrentBalanceLabel(), "My products screen - Current balance lable is not present");
		
			
	}
	
	/*167 - Scenario 2 - DMPM-467*/
	@Test (groups = {"DMPM-167", "DMPM-467","marketplace", "portfolio", "priority-minor"})
	public void testViewBankAccountDetails(){
		
		navigateToMyProductsScreen("prodListUser");
	
		Assert.assertNotNull(myProductsPage.checkAccountTypeLabel(), "Account Type lable is not present");
		Assert.assertNotNull(myProductsPage.checkAvailableBalanceLable(), "Available balance lable is not present");
		Assert.assertNotNull(myProductsPage.checkCurrentBalanceLabel(), "Current balance lable is not present");
		Assert.assertNotNull(myProductsPage.checkViewDetailsButton(), "View details button is not present");
		
		myProductsPage.tapViewDetails();
		Assert.assertNotNull(accountDetailsPage.checkAccountDetailsTitle(), "Account details title is not present");
		
		accountDetailsPage.tapBackButton();
		List<WebElement> accountItemLayoutList = myProductsPage.fetchAccountItemLayoutList();
		
		for(int i=0;i<accountItemLayoutList.size();i++) {
			myProductsPage.tapAccountItem(accountItemLayoutList.get(i));
			accountDetailsPage.tapBackButton();
		}
		
		Assert.assertNotNull(myProductsPage.checkAccountTypeLabel(), "Account Type lable is not present");
		
	}

	private void navigateToMyProductsScreen(String userType){
		if (userType.equals("emptyProdListUser")) {
			loginToApp(utils.readTestData("portfolio","loginEmptyProdList", "login"), utils.readTestData("portfolio","loginEmptyProdList", "pwd"));
		}else {
			loginToApp(utils.readTestData("portfolio","loginProdList", "login"), utils.readTestData("portfolio","loginProdList", "pwd"));
		}
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.tapProductsMenuItem();
		Assert.assertNotNull(myProductsPage.checkMyProductsTitle(), "My products page - title is not present");
		
		
	}
	
	
}
