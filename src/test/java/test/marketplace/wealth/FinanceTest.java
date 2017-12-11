package test.marketplace.wealth;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class FinanceTest extends App {
	
	//@Test (groups = {"DMPM-", "DMPM-", "marketplace", "ey", "priority-"})
	public void testFinancePageElements() {
		// TODO ..........
	}
	
	//Scenario 1 and Scenario 2
	// navigating to spendings screen and again navigating back to wealth tab
	@Test (groups = {"DMPM-91", "DMPM-535", "DMPM-536", "marketplace", "Financial Fitness Indicator", "priority-minor"})
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
	
	//Scenario 3
	// Spending option should not be shown if user does not have suncorp bank accounts
	@Test (groups = {"DMPM-91", "DMPM-537", "marketplace", "Financial Fitness Indicator", "priority-minor"})
	public void testSpendingOptionNotShownWithNoBankAccounts() {
		// SpendingThisMonth option should not be shown if user has no suncorp bank accounts 
		navigateToWealthTabWithOutBankAccounts();
		Assert.assertNull(financePage.checkViewSpendingThisMonthButton(), "Wealth tab - view spendings this month button shown");
	}
	
	private void navigateToWealthTabWithBankAccounts() {
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("loginCredentials", "validLoginCredentials", "hasSuncorpBankAccounts", "login"), utils.readTestData("loginCredentials", "validLoginCredentials", "hasSuncorpBankAccounts", "pwd"));
		if(landingPage.checkWealthTab() == null) {
			landingPage.swipeToHealthTab();
		}
		landingPage.tapWealthTab();
		Assert.assertTrue(landingPage.isWealthTabSelected(), "Wealth tab is not selected on landing page");
		
		//TODO This logic is for enabling the bank accounts option in settings, This needs to be removed, when the logic for fetching the the bank accounts from api is implemented
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.tapFAPISettingsMenuItem();
		configPage.enableHasBankAccountsToggle();
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.tapSuncorpMenuItem();
		landingPage.tapWealthTab();
	}
	
	private void navigateToWealthTabWithOutBankAccounts() {
		welcomePage.tapLoginButton();
		loginToApp(utils.readTestData("loginCredentials", "validLoginCredentials", "noSuncorpBankAccounts", "login"), utils.readTestData("loginCredentials", "validLoginCredentials", "noSuncorpBankAccounts", "pwd"));
		if(landingPage.checkWealthTab() == null) {
			landingPage.swipeToHealthTab();
		}
		landingPage.tapWealthTab();
		Assert.assertTrue(landingPage.isWealthTabSelected(), "Wealth tab is not selected on landing page");		
		
		//TODO This logic is for enabling the bank accounts option in settings, This needs to be removed, when the logic for fetching the the bank accounts from api is implemented
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.tapFAPISettingsMenuItem();
		configPage.disableHasBankAccountsToggle();
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.tapSuncorpMenuItem();
		landingPage.tapWealthTab();
	}
}
