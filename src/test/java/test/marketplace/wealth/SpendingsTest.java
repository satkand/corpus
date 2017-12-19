package test.marketplace.wealth;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class SpendingsTest extends App {
	
	// 361 Scenario 1
	// 388 Scenario 1 -> categories tab selected by default and vendor tab present
	@Test (groups = {"DMPM-361", "DMPM-1017", "DMPM-388", "DMPM-777", "marketplace", "FFI", "priority-minor"})
	public void testSpendingsPageElements() {
		navigateToSpendingsScreen();
		Assert.assertNotNull(spendingsPage.checkSpendingPageTitle(), "Spendings Page - page title not shown");
		Assert.assertNotNull(spendingsPage.checkMonthPicker(), "Spendings Page - Month dropdown not shown");
		Assert.assertNotNull(spendingsPage.checkMonthSelected(), "Spendings Page - Month label is not shown");
		Assert.assertNotNull(spendingsPage.checkCategoriesTab(), "Spendings Page - Categories tab not shown");
		Assert.assertTrue(spendingsPage.isCategoryTabSelected(), "Spendings Page - Categories tab not shown selected by default");
		Assert.assertNotNull(spendingsPage.checkVendorTab(), "Spendings Page - Vendor tab not shown");
		Assert.assertFalse(spendingsPage.isVendorTabSelected(), "Spendings Page - Vendor tab shown selected by default");
		Assert.assertNotNull(spendingsPage.checkSpendingsTotalAmount(), "Spendings Page - Spendings amount not shown");
		Assert.assertNotNull(spendingsPage.checkInfoIcon(), "Spendings Page - Spendings amount info not shown");
	}
	
	// 361 Scenario 2, Scenario 3
	// Select each month from the month picker and verify the spendings shown for each month against the test data
	@Test (groups = {"DMPM-361", "DMPM-1018", "DMPM-1019", "marketplace", "FFI", "priority-minor"})
	public void testSpendingsAmountForEachMonth() {
		navigateToSpendingsScreen();
		// Loading expected data
		List<Object> spendingAmountsPerMonthList = utils.readTestDataList("hasSuncorpBankAccounts", "spendingsAmountPerMonth");
		for (Object spendingAmountPerMonthItem : spendingAmountsPerMonthList) {
			HashMap<String, String> spendingAmountPerMonth = (HashMap<String, String>)spendingAmountPerMonthItem;
			String month = spendingAmountPerMonth.get("month");
			String amount = spendingAmountPerMonth.get("amount");
			spendingsPage.selectMonth(month);
			Assert.assertEquals(spendingsPage.getSelectedMonthValue(), month.toUpperCase(), "Wealth Spendings Page - Not able to select month from dropdown");
			Assert.assertEquals(spendingsPage.getSpendingsTotalAmount(), amount, "Wealth Spendings Page - Spendings amount shown is not correct");
		}
	}
	
	// 361 - Scenario 4
	// Transactions should not be shown for months prior to the (current month + last 3 months )
	@Test (groups = {"DMPM-361", "DMPM-1020", "marketplace", "FFI", "priority-minor"})
	public void testTransactionsCountOnMonthsEarlierThanLast3Months() {
		navigateToSpendingsScreen();
		String currentMonth = spendingsPage.getSelectedMonthValue().split(" ")[0];
		String[] pastMonthsList = spendingsPage.fetchPastMonthsInPicker(currentMonth);
		for (String month : pastMonthsList) {
			spendingsPage.selectMonth(month);
			Assert.assertNull(spendingsPage.fetchCategoriesTransactionsTextList(), "Transactions are still shown for months earlier than last 3 months");
			spendingsPage.tapVendorTab();
			Assert.assertNull(spendingsPage.fetchVendorsTransactionsTextList(), "Transactions are still shown for months earlier than last 3 months");
		}
	}
	
	// 361 - Scenario 5
	// Dismissing the date picker by tapping on it
	@Test  (groups = {"DMPM-361", "DMPM-1021", "marketplace", "FFI", "priority-minor"})
	public void testDismissingTheDatePickerByTappingTwice() {
		navigateToSpendingsScreen();
		spendingsPage.tapMonthPicker();
		Assert.assertNotNull(spendingsPage.checkMonthsOptionInPicker(), "Wealth Spendings Page - Month Picker is not opened");
		spendingsPage.tapMonthPicker();
		Assert.assertNull(spendingsPage.checkMonthsOptionInPicker(), "Wealth Spendings Page - Month Picker is not dismissed");
	}
	
	// 361 - Scenario 3
	// 388 - Scenario 1
	// 830 - Scenario 1
	// Navigate through each month in month picker and verify the list of transactions shown for each month
	@Test (groups = {"DMPM-361", "DMPM-1019", "DMPM-388", "DMPM-777", "DMPM-830", "DMPM-1004", "marketplace", "FFI", "priority-minor"})
	public void testSpendingsOnCategoriesTab() {
		navigateToSpendingsScreen();
		// Load the expected transactions to be shown for each month from test data sheet
		List categoriesTransactionsList = utils.readTestDataList("hasSuncorpBankAccounts", "spendingsByCategories");
		// Iterating over each month
		for (Object categoryTransaction : categoriesTransactionsList) {
			HashMap categoryCell = (HashMap)categoryTransaction;
			spendingsPage.selectMonth((String)categoryCell.get("month"));
			// Load transactions to be shown for the selected month from test data sheet
			List categories = (List) categoryCell.get("categoriesList");
			// verify the transactions shown for the selected month
			compareCategoryTransactionsForaMonth(categories);
		}
	}
	
	// 361 - Scenario 3
	// 388 - Scenario 3
	// 830 - Scenario 1
	// 92 - Scenario 1, Scenario 2, Scenario 3, Scenario 4
	// Navigate through each month in month picker and verify the list of transactions shown for each month on vendor tab
	@Test (groups = {"DMPM-361", "DMPM-1019", "DMPM-388", "DMPM-779", "DMPM-830", "DMPM-1004", "DMPM-92", "DMPM-758", "DMPM-759", "DMPM-762", "DMPM-765",  "marketplace", "FFI", "priority-minor"})
	public void testSpendingsOnVendorTab() {
		navigateToSpendingsScreen();
		// Load the expected transactions to be shown for each month from test data sheet
		List vendorSpendingsList = utils.readTestDataList("hasSuncorpBankAccounts", "spendingsByVendor");
		spendingsPage.tapVendorTab();
		Assert.assertTrue(spendingsPage.isVendorTabSelected(), "Spendings Page - Vendor tab shown not selected");
		// Iterating over each month
		for (Object vendorTransaction : vendorSpendingsList) {
			HashMap vendorCell = (HashMap)vendorTransaction;
			spendingsPage.selectMonth((String)vendorCell.get("month"));
			// Load transactions to be shown for the selected month from test data sheet
			List vendors = (List) vendorCell.get("vendorsList");
			// verify the transactions shown for the selected month
			compareVendorTransactionsForaMonth(vendors);
		}
	}
	
	// verify the empty transactions message shown on categories tab
	// 388 - Scenario 2
	@Test (groups = {"DMPM-388", "DMPM-778", "marketplace", "FFI", "priority-minor"})
	public void testNoTransactionsOnCategoryTabForMonthSelected() {
		navigateToSpendingsScreen();
		List months = utils.readTestDataList("hasSuncorpBankAccounts", "emptyCategoryMonths");
		verifyEmptyTransactionsMessage(months);
	}
	
	// 92 -> Scenario 5
	// verify the empty transactions message shown on vendors tab
	@Test (groups = {"DMPM-92", "DMPM-767", "marketplace", "FFI", "priority-minor"})
	public void testNoTransactionsOnVendorsTabForMonthSelected() {
		navigateToSpendingsScreen();
		List months = utils.readTestDataList("hasSuncorpBankAccounts", "emptyVendorMonths");
		verifyEmptyTransactionsMessage(months);
	}
	
	private void verifyEmptyTransactionsMessage(List months) {
		for (Object month : months) {
			spendingsPage.selectMonth(month.toString());
			Assert.assertEquals(spendingsPage.getSelectedMonthValue(), month.toString().toUpperCase(), "Wealth Spendings Page - Not able to select month from dropdown");
			Assert.assertEquals(spendingsPage.getEmptyTransactionsMessage(), utils.readTestData("copy", "spendingsPage", "emptyTransactionsMessage"), "Wealth Spendings Page - empty transactions message not shown");
			Assert.assertEquals(spendingsPage.getEmptyTransactionsHintMessage(), utils.readTestData("copy", "spendingsPage", "emptyTransactionsHintMessage"), "Wealth Spendings Page - empty transactions hint message not shown");
		}
	}
	
	private void compareCategoryTransactionsForaMonth(List categories) {
		
		// fetch the transactions shown on the current page
		List categoriesNameList = spendingsPage.fetchCategoriesNameList();
		List categoriesTransactionsList = spendingsPage.fetchCategoriesTransactionsTextList();
		List categoriesSpendingAmountList = spendingsPage.fetchCategoriesSpendingAmountList();
		boolean itemPresent = false;
		
		// Iterate through all the expected transactions that should be shown for that particular month
		for (Object categoryItem : categories) {
			
				itemPresent = false;
				// Has the particular transaction item which needs to be verified
				HashMap category = (HashMap) categoryItem;
				int count = categoriesNameList.size();
				
				if(count != 0) {
							// Compare the transaction details shown on the page with the expected values
							Assert.assertEquals(categoriesNameList.get(0), category.get("Name"), categoriesNameList.get(0)+ " label is not shown as expected");
							Assert.assertEquals(categoriesTransactionsList.get(0), spendingsPage.getTransactionLabel(category.get("transactionsText")), categoriesTransactionsList.get(0)+" label is not shown as expected");
							Assert.assertEquals(categoriesSpendingAmountList.get(0), category.get("Amount"), categoriesSpendingAmountList.get(0)+" label is not shown as expected");
							itemPresent = true;
							categoriesNameList.remove(0);
							categoriesTransactionsList.remove(0);
							categoriesSpendingAmountList.remove(0);
				// This block will get executed if there are more transactions on the page and if we need to scroll down and get the next set of transactions			
				} else {
							// Scroll down to get the next set of transactions
							spendingsPage.scrollDown();
							// get the next set of transactions present on the screen 
							categoriesNameList = spendingsPage.fetchCategoriesNameList();
							categoriesTransactionsList = spendingsPage.fetchCategoriesTransactionsTextList();
							categoriesSpendingAmountList = spendingsPage.fetchCategoriesSpendingAmountList();
							int count2 = categoriesNameList.size();
							int counter = 0;
							
							/* We need to iterate through the next set of transactions and find the exact transaction on the screen which needs to be verified next. 
							 * i.e., needs to figure out where we left off. 
							 * We need to iterate as the transactions shown on this page can overlap with the first page transactions which we had already verified. 
							 * */
							for(int i=0; i < count2; i++ ) {
								
										// Some times when we fetch the transaction names and transaction amounts on the second page, transaction names list returns less items than transactions amount list.
										// Actually transaction amount list is returning an extra value from the previous page as well.
										// So if thats the case, that is if name matches and amount does not match + count of items in amounts list is > count of items in names list, then delete the extra items in amounts list.
										// We adjust amounts list only once, because if this happens again on this page that means that the values shown are wrong (we use counter value to make sure this adjustment is done only once)
										if((categoriesNameList.get(0).equals(category.get("Name"))) && !(categoriesSpendingAmountList.get(0).equals(category.get("Amount"))) && (counter == 0)) {
											if(categoriesSpendingAmountList.size() > categoriesNameList.size()) {
												categoriesSpendingAmountList.remove(0);
											}
											counter++;
										}
										
										// If the values of name, amount match, then that means that we have figured out the point on the next page, from where we need to verify the values again
										if((categoriesNameList.get(0).equals(category.get("Name"))) && (categoriesSpendingAmountList.get(0).equals(category.get("Amount")))) {
													Assert.assertEquals(categoriesNameList.get(0), category.get("Name"), categoriesNameList.get(0)+ " label is not shown as expected");
													Assert.assertEquals(categoriesTransactionsList.get(0), spendingsPage.getTransactionLabel(category.get("transactionsText")), categoriesTransactionsList.get(0)+" label is not shown as expected");
													Assert.assertEquals(categoriesSpendingAmountList.get(0), category.get("Amount"), categoriesSpendingAmountList.get(0)+" label is not shown as expected");
													itemPresent = true;
													categoriesNameList.remove(0);
													categoriesTransactionsList.remove(0);
													categoriesSpendingAmountList.remove(0);
													break;
										}
										// All the initial values from the list will be removed. These values are the ones which we have already verified as part of the previous page list
										else {
													categoriesNameList.remove(0);
													categoriesTransactionsList.remove(0);
													categoriesSpendingAmountList.remove(0);
										}
							}
							
				}
				
				if(!itemPresent) {
						Assert.fail("The spendings for category " + category.get("Name") +" is not shown");
				}
		}
	}
	
	private void compareVendorTransactionsForaMonth(List vendors) {
		
		// fetch the transactions shown on the current page
		List vendorsNameList = spendingsPage.fetchVendorsTransactionsNameList();
		List vendorsTransactionsList = spendingsPage.fetchVendorsTransactionsTextList();
		List vendorsSpendingAmountList = spendingsPage.fetchVendorsTransactionsAmountList();
		boolean itemPresent = false;
		
		// Iterate through all the expected transactions that should be shown for that particular month
		for (Object vendorItem : vendors) {
			
				itemPresent = false;
				// Has the particular transaction item which needs to be verified
				HashMap vendor = (HashMap) vendorItem;
				int count = vendorsNameList.size();
				
				
				if(count != 0) {
							// Compare the transaction details shown on the page with the expected values
							Assert.assertEquals(vendorsNameList.get(0), vendor.get("Name"), vendorsNameList.get(0)+" label is not shown as expected");
							Assert.assertEquals(vendorsTransactionsList.get(0), spendingsPage.getTransactionLabel(vendor.get("transactionsText")), vendorsTransactionsList.get(0)+" label is not shown as expected");
							Assert.assertEquals(vendorsSpendingAmountList.get(0), vendor.get("Amount"), vendorsSpendingAmountList.get(0)+" label is not shown as expected");
							itemPresent = true;
							vendorsNameList.remove(0);
							vendorsTransactionsList.remove(0);
							vendorsSpendingAmountList.remove(0);
							
				// This block will get executed if there are more transactions on the page and if we need to scroll down and get the next set of transactions			
				} else {
					
							// Scroll down to get the next set of transactions
							spendingsPage.scrollDown();
							// get the next set of transactions present on the screen 
							vendorsNameList = spendingsPage.fetchCategoriesNameList();
							vendorsTransactionsList = spendingsPage.fetchCategoriesTransactionsTextList();
							vendorsSpendingAmountList = spendingsPage.fetchCategoriesSpendingAmountList();
							int count2 = vendorsNameList.size();
							int counter = 0;

							/* We need to iterate through the next set of transactions and find the exact transaction on the screen which needs to be verified next. 
							 * i.e., needs to figure out where we left off. 
							 * We need to iterate as the transactions shown on this page can overlap with the first page transactions which we had already verified. 
							 * */
							for(int i=0; i < count2; i++ ) {
								
										// Some times when we fetch the transaction names and transaction amounts on the second page, transaction names list returns less items than transactions amount list.
										// Actually transaction amount list is returning an extra value from the previous page as well.
										// So if thats the case, that is if name matches and amount does not match + count of items in amounts list is > count of items in names list, then delete the extra items in amounts list.
										// We adjust amounts list only once, because if this happens again on this page that means that the values shown are wrong (we use counter value to make sure this adjustment is done only once)
										if((vendorsNameList.get(0).equals(vendor.get("Name"))) && !(vendorsSpendingAmountList.get(0).equals(vendor.get("Amount"))) && (counter == 0)) {
											if(vendorsSpendingAmountList.size() > vendorsNameList.size()) {
												vendorsSpendingAmountList.remove(0);
											}
											counter++;
										}
								
										// If the values of name, amount match, then that means that we have figured out the point on the next page, from where we need to verify the values again
										if((vendorsNameList.get(0).equals(vendor.get("Name"))) && (vendorsSpendingAmountList.get(0).equals(vendor.get("Amount")))) {
													Assert.assertEquals(vendorsNameList.get(0), vendor.get("Name"), "Not equal");
													Assert.assertEquals(vendorsTransactionsList.get(0), spendingsPage.getTransactionLabel(vendor.get("transactionsText")), "Not equal");
													Assert.assertEquals(vendorsSpendingAmountList.get(0), vendor.get("Amount"), "Not equal");
													itemPresent = true;
													vendorsNameList.remove(0);
													vendorsTransactionsList.remove(0);
													vendorsSpendingAmountList.remove(0);
													break;
										}
										// All the initial values from the list will be removed. These values are the ones which we have already verified as part of the previous page list
										else {
													vendorsNameList.remove(0);
													vendorsTransactionsList.remove(0);
													vendorsSpendingAmountList.remove(0);
										}
							}
							
				}
				
				if(!itemPresent) {
						Assert.fail("The spendings for vendor " + vendor.get("Name") +" is not shown");
				}
		}
	}
	
	private void navigateToSpendingsScreen(){
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("hasSuncorpBankAccounts", "login"), utils.readTestData("hasSuncorpBankAccounts", "pwd"));
		if(landingPage.checkWealthTab() == null) {
			landingPage.swipeToHealthTab();
		}
		landingPage.tapWealthTab();
		Assert.assertTrue(landingPage.isWealthTabSelected(), "Wealth tab is not selected on landing page");
		
		// TODO This logic is for enabling the bank accounts option in settings, This needs to be removed, when the logic for fetching the the bank accounts from api is implemented
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.tapFAPISettingsMenuItem();
		configPage.enableHasBankAccountsToggle();
		configPage.tapSomeTransactions();
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.tapSuncorpMenuItem();
		landingPage.tapWealthTab();
		
		// Actual logic
		financePage.tapviewSpendingThisMonthButton();
	}
}
