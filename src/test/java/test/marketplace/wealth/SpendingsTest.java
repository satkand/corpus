package test.marketplace.wealth;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import pages.App;

public class SpendingsTest extends App {
	
	// 361 Scenario 1
	// 388 Scenario 1 -> categories tab selected by default and vendor tab present
	@Test (groups = {"DMPM-361", "DMPM-1017", "DMPM-388", "DMPM-777", "marketplace", "FFI", "priority-minor"})
	public void testSpendingsPageElements() {
		navigateToSpendingsScreen();
		Assert.assertNotNull(spendingsPage.checkSpendingPageTitle(), "Spendings Page - page title not shown");
		Assert.assertNotNull(spendingsPage.checkMonthPicker(), "Spendings Page - Month picker not shown");
		Assert.assertNotNull(spendingsPage.checkMonthSelected(), "Spendings Page - Month label is not shown");
		Assert.assertNotNull(spendingsPage.checkCategoriesTab(), "Spendings Page - Categories tab not shown");
		Assert.assertTrue(spendingsPage.isCategoryTabSelected(), "Spendings Page - Categories tab not shown selected by default");
		Assert.assertNotNull(spendingsPage.checkVendorTab(), "Spendings Page - Vendor tab not shown");
		Assert.assertFalse(spendingsPage.isVendorTabSelected(), "Spendings Page - Vendor tab shown selected by default");
		Assert.assertNotNull(spendingsPage.checkSpendingsTotalAmount(), "Spendings Page - Spendings amount not shown");
		Assert.assertNotNull(spendingsPage.checkInfoIcon(), "Spendings Page - Spendings amount info icon not shown");
		//TODO -> This is present on iOS not on Android. Check later, if still not present, remove this
		//Assert.assertNotNull(spendingsPage.checkUpdatedInfoText(), "Spendings Page - Spendings updated once per month text not shown");
	}
	
	// 361 - Scenario 2, Scenario 3
	// 94 - Scenario 1
	// Select each month from the month picker and verify the spendings shown for each month against the test data
	@Test (groups = {"DMPM-361", "DMPM-1018", "DMPM-1019", "DMPM-94", "DMPM-575", "marketplace", "FFI", "priority-minor"})
	public void testSpendingsAmountForEachMonth() {
		navigateToSpendingsScreen();
		// Verify that the default month shown selected in picker, is equal to the current month in the test data sheet
		Assert.assertEquals(spendingsPage.getSelectedMonthValue(), utils.readTestData("hasSuncorpBankAccounts", "currentMonth").toUpperCase(), "Wealth Spendings Page - Default month shown in picker is not the current month");
		// Loading expected data from data sheet
		List<Object> spendingAmountsPerMonthList = utils.readTestDataList("hasSuncorpBankAccounts", "spendingsAmountPerMonth");
		for (Object spendingAmountPerMonthItem : spendingAmountsPerMonthList) {
			HashMap<String, String> spendingAmountPerMonth = (HashMap<String, String>)spendingAmountPerMonthItem;
			String month = spendingAmountPerMonth.get("month");
			String amount = spendingAmountPerMonth.get("amount");
			// selecting the month from the picker and verifying that the amount shown is correct
			spendingsPage.selectMonth(month);
			Assert.assertEquals(spendingsPage.getSelectedMonthValue(), month.toUpperCase(), "Wealth Spendings Page - Not able to select month from dropdown");
			Assert.assertEquals(spendingsPage.getSpendingsTotalAmount(), amount, "Wealth Spendings Page - Spendings amount shown is not correct");
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
	
	// 361 - Scenario 3, Scenario 4
	// 388 - Scenario 1
	// 830 - Scenario 1
	// 1034 - Scenario 1, Scenario 2
	// 788 - Scenario 1, Scenario 2
	// Navigate through each month in month picker and verify the list of transactions shown for each month on categories tab
	@Test (groups = {"DMPM-361", "DMPM-1019", "DMPM-1020", "DMPM-388", "DMPM-777", "DMPM-830", "DMPM-1004", "DMPM-1034", "DMPM-1478", "DMPM-1487", "DMPM-788", "DMPM-1309", "DMPM-1319", "marketplace", "FFI", "priority-minor"})
	public void testSpendingsOnCategoriesTab() {
		navigateToSpendingsScreen();
		
		// Load the expected transactions to be shown for each month from test data sheet
		List categoriesTransactionsList = utils.readTestDataList("hasSuncorpBankAccounts", "spendingsByCategories");
		
		// get the list prior months of last 3 months to current month. And for these months transactions count should not be shown
		String currentMonth = spendingsPage.getSelectedMonthValue().split(" ")[0];
		List<String> monthsPriorToLast3Months = spendingsPage.fetchPastMonthsPriorToLast3Months(currentMonth);
		boolean isThisMonthPriorToPast3Months = false;
		
		// Iterating over each month
		for (Object categoryTransaction : categoriesTransactionsList) {
			HashMap categoryCell = (HashMap)categoryTransaction;
			
			spendingsPage.selectMonth((String)categoryCell.get("month"));
			// These are the expected list of transactions that needs to be verified on the screen
			List categories = (List) categoryCell.get("categoriesList");
			
			// If this month is present in the list of "monthsPriorToLast3Months. Then the flag should be enabled, so that we will not check transactions count for such months
			if(monthsPriorToLast3Months.contains(((String)categoryCell.get("month")).split(" ")[0])) {
				isThisMonthPriorToPast3Months = true;
			}
			
			// verify the transactions shown for the selected month
			compareCategoryTransactionsForaMonth(categories, isThisMonthPriorToPast3Months);
			
			// Resetting the flag
			isThisMonthPriorToPast3Months = false;
		}
	}
	
	// 361 - Scenario 3, Scenario 4
	// 388 - Scenario 3
	// 830 - Scenario 1
	// 92 - Scenario 1, Scenario 2, Scenario 3, Scenario 4
	// 1034 - Scenario 1, Scenario 2
	// 788 - Scenario 1, Scenario 2
	// Navigate through each month in month picker and verify the list of transactions shown for each month on vendor tab
	@Test (groups = {"DMPM-361", "DMPM-1019", "DMPM-1020", "DMPM-388", "DMPM-779", "DMPM-830", "DMPM-1004", "DMPM-92", "DMPM-758", "DMPM-759", "DMPM-762", "DMPM-765",  "DMPM-1034", "DMPM-1478", "DMPM-1487", "DMPM-788", "DMPM-1309", "DMPM-1319", "marketplace", "FFI", "priority-minor"})
	public void testSpendingsOnVendorTab() {
		navigateToSpendingsScreen();
		
		// Load the expected transactions to be shown for each month from test data sheet
		List vendorSpendingsList = utils.readTestDataList("hasSuncorpBankAccounts", "spendingsByVendor");
		
		// get the list prior months of last 3 months to current month. And for these months transactions count should not be shown
		String currentMonth = spendingsPage.getSelectedMonthValue().split(" ")[0];
		List<String> monthsPriorToLast3Months = spendingsPage.fetchPastMonthsPriorToLast3Months(currentMonth);
		boolean isThisMonthPriorToPast3Months = false;
		
		spendingsPage.tapVendorTab();
		Assert.assertTrue(spendingsPage.isVendorTabSelected(), "Spendings Page - Vendor tab shown not selected");
		
		// Iterating over each month
		for (Object vendorTransaction : vendorSpendingsList) {
			HashMap vendorCell = (HashMap)vendorTransaction;
			
			spendingsPage.selectMonth((String)vendorCell.get("month"));
			// These are the expected list of transactions that needs to be verified on the screen
			List vendors = (List) vendorCell.get("vendorsList");
			
			// If this month is present in the list of "monthsPriorToLast3Months. Then the flag should be enabled, so that we will not check transactions count for such months
			if(monthsPriorToLast3Months.contains(((String)vendorCell.get("month")).split(" ")[0])) {
				isThisMonthPriorToPast3Months = true;
			}
			
			// verify the transactions shown for the selected month
			compareVendorTransactionsForaMonth(vendors, isThisMonthPriorToPast3Months);
			
			// Resetting the flag
			isThisMonthPriorToPast3Months = false;
		}
	}
	
	private void compareCategoryTransactionsForaMonth(List categories, boolean isTransactionCountShown) {
		spendingsPage.swipeUp();
		// fetch the actual transactions shown on the current page
		List categoriesNameList = spendingsPage.fetchCategoriesNameList();
		List categoriesTransactionsList = spendingsPage.fetchCategoriesTransactionsTextList();
		List categoriesSpendingAmountList = spendingsPage.fetchCategoriesSpendingAmountList();

		// Iterate through all the expected transactions that should be shown for this particular month
		for (Object categoryItem : categories) {
				// Has the particular transaction item expected value, which needs to be verified
				HashMap category = (HashMap) categoryItem;
				// Compare the transaction details shown on the page with the expected values
				Assert.assertEquals(categoriesNameList.get(0), category.get("name"), categoriesNameList.get(0)+ " name is not shown as expected");
				categoriesNameList.remove(0);

				Assert.assertEquals(categoriesSpendingAmountList.get(0), category.get("amount"), categoriesSpendingAmountList.get(0)+" amount is not shown as expected");
				categoriesSpendingAmountList.remove(0);

				// If this month is present in the list of "monthsPriorToLast3Months. Then the flag is enabled, so that we will not check transactions count for such months
				if(!isTransactionCountShown) {
					Assert.assertEquals(categoriesTransactionsList.get(0), spendingsPage.getTransactionLabel(category.get("transactionCount")), categoriesTransactionsList.get(0)+" count is not shown as expected");
					categoriesTransactionsList.remove(0);
				}
		}
		
		// If this month is present in the list of "monthsPriorToLast3Months. Then the flag is enabled, And we are checking that the transactions count is not shown on the screen
		if(isTransactionCountShown) {
				Assert.assertNull(spendingsPage.checkCategoriesTransactionsText(), "Transactions count is still shown for months earlier than last 3 months");
		}
	}
	
	private void compareVendorTransactionsForaMonth(List vendors, boolean isTransactionCountShown) {
		spendingsPage.swipeUp();
		// fetch actual the transactions shown on the current page
		List vendorsNameList = spendingsPage.fetchVendorsTransactionsNameList();
		List vendorsTransactionsList = spendingsPage.fetchVendorsTransactionsTextList();
		List vendorsSpendingAmountList = spendingsPage.fetchVendorsTransactionsAmountList();
		
		// Iterate through all the expected transactions that should be shown for this particular month
		for (Object vendorItem : vendors) {
			// Has the particular transaction item expected value, which needs to be verified
				HashMap vendor = (HashMap) vendorItem;
				// Compare the transaction details shown on the page with the expected values
				Assert.assertEquals(vendorsNameList.get(0), vendor.get("name"), vendorsNameList.get(0)+" name is not shown as expected");
				vendorsNameList.remove(0);

				Assert.assertEquals(vendorsSpendingAmountList.get(0), vendor.get("amount"), vendorsSpendingAmountList.get(0)+" amount is not shown as expected");
				vendorsSpendingAmountList.remove(0);

				// If this month is present in the list of "monthsPriorToLast3Months. Then the flag is enabled, so that we will not check transactions count for such months
				if(!isTransactionCountShown) {
					Assert.assertEquals(vendorsTransactionsList.get(0), spendingsPage.getTransactionLabel(vendor.get("transactionCount")), vendorsTransactionsList.get(0)+" count is not shown as expected");
					vendorsTransactionsList.remove(0);
				}
		}
		
		// If this month is present in the list of "monthsPriorToLast3Months. Then the flag is enabled, And we are checking that the transactions count is not shown on the screen
		if(isTransactionCountShown) {
			Assert.assertNull(spendingsPage.checkVendorsTransactionsText(), "Transactions count is still shown for months earlier than last 3 months");
		}
	}

	// verify the empty transactions message shown on categories tab
	// 388 - Scenario 2
	@Test (groups = {"DMPM-388", "DMPM-778", "marketplace", "FFI", "priority-minor"})
	public void testEmptyTransactionsOnCategoryTabForMonthSelected() {
		navigateToSpendingsScreen();
		List months = utils.readTestDataList("hasSuncorpBankAccounts", "emptyCategoryMonths");
		verifyEmptyTransactionsMessage(months);
	}
	
	// 92 -> Scenario 5
	// verify the empty transactions message shown on vendors tab
	@Test (groups = {"DMPM-92", "DMPM-767", "marketplace", "FFI", "priority-minor"})
	public void testEmptyTransactionsOnVendorsTabForMonthSelected() {
		navigateToSpendingsScreen();
		List months = utils.readTestDataList("hasSuncorpBankAccounts", "emptyVendorMonths");
		spendingsPage.tapVendorTab();
		verifyEmptyTransactionsMessage(months);
	}
	
	
	// 4034 - Scenario 1-6
	//5921 - Scenario 1-6
	//2480 - Scenario 1
	//2905 - Scenario 1
	//2260 - Scenario 1
	@Test (groups = {"DMPM-4034", "DMPM-5818", "DMPM-5819","DMPM-5820","DMPM-5821","DMPM-5822","DMPM-5823","DMPM-5921", "DMPM-2480", 
			"DMPM-2905", "DMPM-2260","marketplace", "FFI", "priority-minor"})
	public void testDatePickerInCategoryDetailsScreen() {
		
		navigateToCategoryDetailScreen();	
		Assert.assertNotNull(categoryDetailsPage.checkMonthPicker(), "Month picker not seen");
		categoryDetailsPage.tapMonthPicker();
		Assert.assertNotNull(categoryDetailsPage.checkMonthsOptionInPicker(), "List of months not seen");
		categoryDetailsPage.tapTop3VendorTitle();
		Assert.assertNull(categoryDetailsPage.checkMonthsOptionInPicker(), "List of months still seen");
		categoryDetailsPage.tapMonthPicker();
		categoryDetailsPage.tapDeviceBackButton();
		Assert.assertNull(categoryDetailsPage.checkMonthsOptionInPicker(), "List of months still seen");
		
		categoryDetailsPage.selectMonth(utils.readTestData("ffi", "hasData", "month"));
		Assert.assertNotNull(categoryDetailsPage.checkSpendingsTotalAmount(), "Total spent amount not seen");
		Assert.assertNotEquals(categoryDetailsPage.getSpendingsTotalAmount(), utils.readTestData("ffi", "hasData", "zeroSpending"));
		categoryDetailsPage.scrollDown();
		Assert.assertNotNull(categoryDetailsPage.checkTop3VendorTitle(), "Top 3 vendor title not seen");
		Assert.assertNotNull(categoryDetailsPage.checkTop3VendorsList(), "Top 3 vendor list not seen");
		Assert.assertTrue(categoryDetailsPage.checkIfVendorsAreSorted(),"Top vendors are not sorted by the spending amount");
		Assert.assertNotNull(categoryDetailsPage.checkTransactionList(), "Transaction list not seen");
		 
		Assert.assertTrue(categoryDetailsPage.checkVendorNames(), "Vendor names not present");
		Assert.assertTrue(categoryDetailsPage.checkVendorAmount(), "Vendor amount not present");
		
		//Check when there are no transcations
		categoryDetailsPage.scrollUp();
		categoryDetailsPage.checkMonthPicker();
		categoryDetailsPage.selectMonth(utils.readTestData("ffi", "hasNoData", "month"));
		Assert.assertEquals(categoryDetailsPage.getSpendingsTotalAmount(), utils.readTestData("ffi", "hasData", "zeroSpending"));
		Assert.assertNull(categoryDetailsPage.checkTop3VendorTitle(), "Top 3 vendor title not seen");
		Assert.assertNull(categoryDetailsPage.checkTop3VendorsList(), "Top 3 vendor list not seen");
		Assert.assertNotNull(categoryDetailsPage.checkTransactionErrorMsg(), "Transaction error msg not seen");
		Assert.assertEquals(categoryDetailsPage.getTransactionErrorMsg(), Copy.FFI_EMPTY_TRANSACTIONS);
		categoryDetailsPage.tapCloseButton();
		Assert.assertNotNull(spendingsPage.checkSpendingPageTitle(), "Did not navigate to spending screen");
		Assert.assertEquals(spendingsPage.getSpendingsTotalAmount(), utils.readTestData("ffi", "hasData", "zeroSpending"));
		
		
	}
	

	// 3980 - Scenario 1-6
	//5922 - Scenario 1-6
	//6311 - Scenario 1
	//182 - Scenario 1
	@Test (groups = {"DMPM-3980", "DMPM-5809", "DMPM-5810","DMPM-5811","DMPM-5812","DMPM-5815","DMPM-5816","DMPM-5922", "DMPM-6311", "DMPM-182", "marketplace", "FFI", "priority-minor"})
	public void testDatePickerInVendorDetailsScreen() {
		
		String vendorNavigatedTo = navigateToVendorDetailScreen();	
		Assert.assertNotNull(categoryDetailsPage.checkMonthPicker(), "Month picker not seen");
		categoryDetailsPage.tapMonthPicker();
		Assert.assertNotNull(categoryDetailsPage.checkMonthsOptionInPicker(), "List of months not seen");
		vendorDetailPage.tapAvgSpend();
		Assert.assertNull(categoryDetailsPage.checkMonthsOptionInPicker(), "List of months still seen");
		categoryDetailsPage.tapMonthPicker();
		categoryDetailsPage.tapDeviceBackButton();
		Assert.assertNull(categoryDetailsPage.checkMonthsOptionInPicker(), "List of months still seen");
		
		categoryDetailsPage.selectMonth(utils.readTestData("ffi", "hasData", "month"));
		Assert.assertNotNull(categoryDetailsPage.checkSpendingsTotalAmount(), "Total spent amount not seen");
		Assert.assertNotEquals(categoryDetailsPage.getSpendingsTotalAmount(), utils.readTestData("ffi", "hasData", "zeroSpending"));
		vendorDetailPage.scrollDown();
		Assert.assertNotNull(vendorDetailPage.checkAvgSpend(), "Avg spend details not seen");
		Assert.assertNotNull(vendorDetailPage.checkAvgTransFreq(), "Avg transaction freq not seen");
		Assert.assertNotNull(vendorDetailPage.checkTransactionList(), "Transaction list not seen");
		
		Assert.assertTrue(vendorDetailPage.checkVendorNames(vendorNavigatedTo), "Vendor names not present");
		Assert.assertTrue(vendorDetailPage.checkVendorAmount(), "Vendor amount not present");
		
		
		//Check when there are no transcations
		categoryDetailsPage.scrollUp();
		categoryDetailsPage.checkMonthPicker();
		categoryDetailsPage.selectMonth(utils.readTestData("ffi", "hasNoData", "month"));
		Assert.assertEquals(categoryDetailsPage.getSpendingsTotalAmount(), utils.readTestData("ffi", "hasData", "zeroSpending"));
		Assert.assertNull(vendorDetailPage.checkAvgSpend(), "TAvg spend details not seen");
		Assert.assertNull(vendorDetailPage.checkAvgTransFreq(), "Avg transaction freq not seen");
		Assert.assertNotNull(categoryDetailsPage.checkTransactionErrorMsg(), "Transaction error msg not seen");
		Assert.assertEquals(categoryDetailsPage.getTransactionErrorMsg(), Copy.FFI_EMPTY_TRANSACTIONS);
		categoryDetailsPage.tapCloseButton();
		Assert.assertNotNull(spendingsPage.checkSpendingPageTitle(), "Did not navigate to spending screen");
		Assert.assertEquals(spendingsPage.getSpendingsTotalAmount(), utils.readTestData("ffi", "hasData", "zeroSpending"));
	
		
		
	}
	
	//DMPM-496
	@Test (groups = {"DMPM-496",  "marketplace", "FFI", "priority-minor"})
	public void testDisclaimer() {
		navigateToSpendingsScreen();
		Assert.assertEquals(spendingsPage.getSnackBarText(), Copy.FFI_DISCLAIMER);
	}
	
	//DMPM-2520 - Scneario 1-6
		@Test (groups = {"DMPM-2520", "DMPM-6653","DMPM-6657","DMPM-6658","DMPM-6659","DMPM-6660","DMPM-6661", "marketplace", "FFI", "priority-minor"})
		public void testSearchThroughVendorList() {
			navigateToSpendingsScreen();
			categoryDetailsPage.selectMonth(utils.readTestData("ffi", "hasData", "month"));
			
			spendingsPage.tapVendorTab();
			Assert.assertNotNull(vendorDetailPage.checkSearchField(), "Search field not present");
			vendorDetailPage.tapSearchField();
			Assert.assertNotNull(vendorDetailPage.checkVendorSearchScreenTitle(), "Vendor Search screen title not present");
			Assert.assertTrue(common.isKeyboardShown(), "Keyboard not seen");
			Assert.assertNotNull(vendorDetailPage.checkCloseButton(), "Close button not present");
			Assert.assertNotNull(vendorDetailPage.checkVendorSearchList(), "No vendor list seen");
			vendorDetailPage.tapCloseButton();
			Assert.assertNotNull(spendingsPage.checkSpendingPageTitle(), "Spending page title not seen");
			
			vendorDetailPage.tapSearchField();
			vendorDetailPage.enterSearchText(utils.readTestData("ffi", "hasData", "searchString"));
			Assert.assertTrue(vendorDetailPage.verifySearch(utils.readTestData("ffi", "hasData", "resultString1"),
					utils.readTestData("ffi", "hasData", "resultString2"), utils.readTestData("ffi", "hasData", "resultString3")), "Search not as expected");
			vendorDetailPage.enterSearchText(utils.readTestData("ffi", "hasData", "searchString4Letter"));
			Assert.assertTrue(vendorDetailPage.verifySearch4Letter(utils.readTestData("ffi", "hasData", "resultString1"),
					utils.readTestData("ffi", "hasData", "resultString2"), utils.readTestData("ffi", "hasData", "resultString3")), "Search not as expected");
			vendorDetailPage.enterSearchText(utils.readTestData("ffi", "hasData", "searchString5Letter"));
			Assert.assertNotNull(vendorDetailPage.checkSearchErrorMsg(), "Error msg not seen");
			
			//3 times backspace to remove 3 characters and unfilter list
			vendorDetailPage.tapBackspace();
			vendorDetailPage.tapBackspace();
			vendorDetailPage.tapBackspace();
			
			Assert.assertTrue(vendorDetailPage.verifySearchItems(), "Search list did not unfilter");
		}

			//DMPM-4645 - Scneario 1-6
			@Test (groups = {"DMPM-4645", "marketplace", "FFI", "priority-minor"})
			public void testSearchThroughCategoryDetailsList() {
				navigateToCategoryDetailScreen();
				vendorDetailPage.tapSearchField();
				Assert.assertTrue(common.isKeyboardShown(), "Keyboard not seen");
				Assert.assertNotNull(vendorDetailPage.checkCloseButton(), "Close button not present");
				Assert.assertNotNull(categoryDetailsPage.checkVendorSearchList(), "No vendor list seen");
				categoryDetailsPage.tapCloseButton();
				Assert.assertNotNull(categoryDetailsPage.checkTop3VendorTitle(), "Did not navigate back to category screen");
				
				vendorDetailPage.tapSearchField();
				vendorDetailPage.enterSearchText(utils.readTestData("ffi", "hasData", "searchString"));
				Assert.assertTrue(vendorDetailPage.verifySearch(utils.readTestData("ffi", "hasData", "resultString1"),
						utils.readTestData("ffi", "hasData", "resultString2"), utils.readTestData("ffi", "hasData", "resultString3")), "Search not as expected");
				vendorDetailPage.enterSearchText(utils.readTestData("ffi", "hasData", "searchString4Letter"));
				Assert.assertTrue(vendorDetailPage.verifySearch4Letter(utils.readTestData("ffi", "hasData", "resultString1"),
						utils.readTestData("ffi", "hasData", "resultString2"), utils.readTestData("ffi", "hasData", "resultString3")), "Search not as expected");
				vendorDetailPage.enterSearchText(utils.readTestData("ffi", "hasData", "searchString5Letter"));
				Assert.assertNotNull(vendorDetailPage.checkSearchErrorMsg(), "Error msg not seen");
				
				//3 times backspace to remove 3 characters and unfilter list
				vendorDetailPage.tapBackspace();
				vendorDetailPage.tapBackspace();
				vendorDetailPage.tapBackspace();
				
				Assert.assertTrue(vendorDetailPage.verifySearchItems(), "Search list did not unfilter");
						
				
			}
			
		
		//DMPM-4023 - Scneario 2
		@Test (groups = {"DMPM-4023", "DMPM-6801","marketplace", "FFI", "priority-minor"})
		public void testNavigateToConnectedScreens() {
			navigateToCategoryDetailScreen();
			Assert.assertNotNull(categoryDetailsPage.checkConnectedAccountsButton(), "Connected accounts button not present");
			categoryDetailsPage.tapConnectedAccountsButton();
			Assert.assertNotNull(connectedAccountsPage.checkTitle(), "Connected accounts title not present");
			connectedAccountsPage.tapCloseButton();
			Assert.assertNotNull(categoryDetailsPage.checkTop3VendorTitle(), "Vendor details page  not present");
			categoryDetailsPage.tapCloseButton();
			spendingsPage.checkSpendingPageTitle();
			spendingsPage.tapVendorTab();
			
			Assert.assertNotNull(categoryDetailsPage.checkConnectedAccountsButton(), "Connected accounts button not present");
			categoryDetailsPage.tapConnectedAccountsButton();
			Assert.assertNotNull(connectedAccountsPage.checkTitle(), "Connected accounts title not present");
			connectedAccountsPage.tapCloseButton();
			
		}
		
		
	private void verifyEmptyTransactionsMessage(List months) {
		for (Object month : months) {
			spendingsPage.selectMonth(month.toString());
			Assert.assertEquals(spendingsPage.getSelectedMonthValue(), month.toString().toUpperCase(), "Wealth Spendings Page - Not able to select month from dropdown");
			//TODO: Defect raised for this
			//Assert.assertNotNull(spendingsPage.checkEmptyTransactionsImage(), "Wealth Spending Page - empty transactions image not shown");
			Assert.assertEquals(spendingsPage.getEmptyTransactionsMessage(), utils.readTestData("copy", "spendingsPage", "emptyTransactionsMessage"), "Wealth Spendings Page - empty transactions message not shown");
			Assert.assertEquals(spendingsPage.getEmptyTransactionsHintMessage(), utils.readTestData("copy", "spendingsPage", "emptyTransactionsHintMessage"), "Wealth Spendings Page - empty transactions hint message not shown");
		}
	}

	private String navigateToVendorDetailScreen() {
		navigateToSpendingsScreen();
		Assert.assertNotNull(spendingsPage.checkMonthPicker(), "Month picker not seen");
		spendingsPage.selectMonth(utils.readTestData("ffi", "hasData", "month"));
		spendingsPage.tapVendorTab();
		String chosenVendorName = spendingsPage.getTopMostCategory();
		spendingsPage.tapTopmostCategory();
		return chosenVendorName;
		
	}
	
	private void navigateToCategoryDetailScreen() {
		navigateToSpendingsScreen();
		Assert.assertNotNull(spendingsPage.checkMonthPicker(), "Month picker not seen");
		spendingsPage.selectMonth(utils.readTestData("ffi", "hasData", "month"));
		spendingsPage.tapTopmostCategory();
		
	}
	
	private void navigateToSpendingsScreen(){
		loginToApp(utils.readTestData("hasSuncorpBankAccounts", "login"), utils.readTestData("hasSuncorpBankAccounts", "pwd"));
		if(landingPage.checkFinanceTab() == null) {
			landingPage.swipeToHealthTab();
		}
		landingPage.tapFinanceTab();
		Assert.assertTrue(landingPage.isFinanceTabSelected(), "Wealth tab is not selected on landing page");
		
		// TODO This logic is for enabling the bank accounts option in settings, This needs to be removed, when the logic for fetching the the bank accounts from api is implemented
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.scrollToDevSettings();
		navigationMenu.tapDevSettings();
		configPage.enableHasBankAccountsToggle(); 
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.tapSuncorpMenuItem();
		landingPage.tapFinanceTab();
		
		// Actual logic
		financePage.tapviewSpendingThisMonthButton();
	}
}
