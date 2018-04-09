package test.marketplace.wealth;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class FinanceTest extends App {
	// 486 - Scenario 1
	// 786 - Scenario 1, Scenario 2
	// 1032 - Scenario 1, Scenario 2
	@Test (groups = {"DMPM-486", "DMPM-895", "DMPM-786", "DMPM-1032", "DMPM-1302", "DMPM-1311", "marketplace", "FFI", "priority-minor"})
	public void testElementsOnFinancePageWithSuncorpBankAccounts() {
		// SpendingThisMonth button and net worth amount, should  be shown if user has suncorp bank accounts 
		navigateToWealthTabWithBankAccounts();
		Assert.assertEquals(financePage.getNetWorthLabel(), utils.readTestData("copy", "financePage", "netWorthLabel"), "Wealth tab - net worth label copy is not valid");
		Assert.assertNotNull(financePage.checkNetWorthAmount(), "Wealth tab - Net worth amount not shown");
		// Comparing the net worth amount with the expected value
		Assert.assertEquals(financePage.getNetWorthAmountValue(), utils.readTestData("hasSuncorpBankAccounts", "netWorthAmount"), "Wealth tab - Net worth amount shown is not correct");
		Assert.assertNotNull(financePage.checkViewSpendingThisMonthButton(), "Wealth tab - view spendings this month button not shown");
		Assert.assertEquals(financePage.getNetWorthDisclaimerMessage(), utils.readTestData("copy", "financePage", "netWorthDisclaimerMessage"), "Wealth tab - Net worth disclaimer message copy is not valid");
	}
	
	// 91 - Scenario 1 and Scenario 2
	// 94 - Scenario 2
	// navigating to spendings screen and again navigating back to wealth tab
	@Test (groups = {"DMPM-91", "DMPM-535", "DMPM-536", "DMPM-94", "DMPM-576", "marketplace", "FFI", "priority-minor"})
	public void testNavigatingToSpendingsScreen() {
		// SpendingThisMonth option should  be shown if user has suncorp bank accounts 
		navigateToWealthTabWithBankAccounts();
		Assert.assertNotNull(financePage.checkViewSpendingThisMonthButton(), "Wealth tab - view spendings this month button not shown");
		// Navigating to Spendings screen
		financePage.tapviewSpendingThisMonthButton();
		Assert.assertNotNull(spendingsPage.checkSpendingPageTitle(), "Spendings Page - page title not shown");
		spendingsPage.tapBackButton();
		Assert.assertTrue(landingPage.isWealthTabSelected(), "Wealth tab is not selected on landing page");
	}
	
	// 486 - Scenario 2
	// 91 - Scenario 3
	// Spending option should not be shown if user does not have suncorp bank accounts
	@Test (groups = {"DMPM-91", "DMPM-537", "DMPM-486", "DMPM-896", "marketplace", "FFI", "priority-minor"})
	public void testElementsOnFinancePageWithOutSuncorpBankAccounts() {
		// SpendingThisMonth button and net worth amount, should not be shown if user has no suncorp bank accounts 
		navigateToWealthTabWithOutSuncorpBankAccounts();
		Assert.assertNull(financePage.checkNetWorthAmount(), "Wealth tab - Net worth amount shown");
		Assert.assertNull(financePage.checkViewSpendingThisMonthButton(), "Wealth tab - view spendings this month button shown");
	}
	
	// 409 - Scenario 1
	@Test (groups = {"DMPM-409", "DMPM-1248", "marketplace", "FFI", "priority-minor"})
	public void testElementsOnFinancePageAsGuestUser() {
		// SpendingThisMonth button and net worth amount, should not be shown if user has logged in as a Guest User
		navigateToWealthTabAsGuestUser();
		Assert.assertNull(financePage.checkNetWorthAmount(), "Wealth tab - Net worth amount shown");
		Assert.assertNull(financePage.checkViewSpendingThisMonthButton(), "Wealth tab - view spendings this month button shown");
	}
	
	private void navigateToWealthTabWithBankAccounts() {
		loginToApp(utils.readTestData("hasSuncorpBankAccounts", "login"), utils.readTestData("hasSuncorpBankAccounts", "pwd"));
		if(landingPage.checkWealthTab() == null) {
			landingPage.swipeToHealthTab();
		}
		landingPage.tapWealthTab();
		Assert.assertTrue(landingPage.isWealthTabSelected(), "Wealth tab is not selected on landing page");
		
		//TODO This logic is for enabling the bank accounts option in settings, This needs to be removed, when the logic for fetching the the bank accounts from api is implemented
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.tapDevSettings();
		configPage.enableHasBankAccountsToggle();
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.tapSuncorpMenuItem();
		landingPage.tapWealthTab();
	}
	
	private void navigateToWealthTabWithOutSuncorpBankAccounts() {
		loginToApp(utils.readTestData("noSuncorpBankAccounts", "login"), utils.readTestData("noSuncorpBankAccounts", "pwd"));
		if(landingPage.checkWealthTab() == null) {
			landingPage.swipeToHealthTab();
		}
		landingPage.tapWealthTab();
		Assert.assertTrue(landingPage.isWealthTabSelected(), "Wealth tab is not selected on landing page");		
		
		//TODO This logic is for enabling the bank accounts option in settings, This needs to be removed, when the logic for fetching the the bank accounts from api is implemented
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.tapDevSettings();
		configPage.disableHasBankAccountsToggle();
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.tapSuncorpMenuItem();
		landingPage.tapWealthTab();
	}
	
	// Navigating into the app as a Guest User
	private void navigateToWealthTabAsGuestUser() {
		welcomePage.tapGuestAccessButton();
		landingPage.tapWealthTab();
		Assert.assertTrue(landingPage.isWealthTabSelected(), "Wealth tab is not selected on landing page");		
	}
	
}
