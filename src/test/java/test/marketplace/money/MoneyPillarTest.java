package test.marketplace.money;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import automation.framework.common.TestDetails.Priority;
import pages.App;
import pages.marketplace.portfolio.AddBankAccountPage;

public class MoneyPillarTest extends App {
	

	@TestDetails(story1 = "DMPM-3473:DMPM-6189,DMPM-6197,DMPM-6194", story2 = "DMPM-3476:DMPM-6358",story3="DMPM-3449:DMPM-6182",priority = Priority.LOW)
	@Test (groups = {"marketplace", "Money Pillar", "priority-minor"})
	public void testEveryDayAccountOverviewDetails() {
		
		String userName = utils.readTestData("moneypillar","EverydayAccount","login");
		String pwd = utils.readTestData("moneypillar","EverydayAccount","pwd");
		String [] everyDayAccountDetails = {utils.readTestData("moneypillar","EverydayAccount","displayName"),
				utils.readTestData("moneypillar","EverydayAccount","bsb"),
				utils.readTestData("moneypillar","EverydayAccount","accountNumber"),
				utils.readTestData("moneypillar","EverydayAccount","availableBalance")};
	
		navigateToMoney(userName,pwd);
		assertAcccountOverviewDetails(everyDayAccountDetails);
		moneyPage.tapAccountName(everyDayAccountDetails[0]);
	 	Assert.assertNotNull(transactionsPage.checkAccountDetailsButton(),"Account details button is not displayed");
		
	}
	
	@TestDetails(story1 = "DMPM-3473:DMPM-6189",story3="DMPM-3449:DMPM-6182", priority = Priority.LOW)
    @Test (groups = {"marketplace", "Money Pillar", "priority-minor"})
	public void testSaverAccountOverviewDetails() {
		
		String userName = utils.readTestData("moneypillar","SaverAccount","login");
		String pwd = utils.readTestData("moneypillar","SaverAccount","pwd");
		
		String [] saverAccountDetails = {utils.readTestData("moneypillar","SaverAccount","displayName"),
				utils.readTestData("moneypillar","SaverAccount","bsb"),
				utils.readTestData("moneypillar","SaverAccount","accountNumber"),
				utils.readTestData("moneypillar","SaverAccount","availableBalance")};
	
		navigateToMoney(userName,pwd);
		assertAcccountOverviewDetails(saverAccountDetails);
		
	}
	
	@TestDetails(story1 = "DMPM-8103:DMPM-8860",priority = Priority.LOW)
	@Test (groups = {"marketplace", "Money Pillar", "priority-minor"})
	public void testSelectingAddBanking() {
		
		String userName = utils.readTestData("moneypillar","SaverAccount","login");
		String pwd = utils.readTestData("moneypillar","SaverAccount","pwd");
		
		navigateToMoney(userName,pwd);
		moneyPage.tapOnExistingProductButton();
		Assert.assertNotNull(addProductPage.checkAddExistingProductTitle(),"Not on Add Existing Product Page");
		addProductPage.tapAddBankAccountButton();
		Assert.assertNotNull(addBankAccountPage.checkAddBankAccountTitle(),"Not on Add Bank Account");
		
	}
	
	
	@TestDetails(story1 = "DMPM-8103:DMPM-8857", priority = Priority.LOW)
    @Test (groups = {"marketplace", "Money Pillar", "priority-minor"})
	public void testMoneyContentsBankUser() {
		
		String userName = utils.readTestData("moneypillar","SaverAccount","login");
		String pwd = utils.readTestData("moneypillar","SaverAccount","pwd");
	
		navigateToMoney(userName,pwd);
		Assert.assertNotNull(moneyPage.checkMoneyTrackerTitle(),"Money Tracker title not displayed");
		Assert.assertEquals(moneyPage.getOfferTitle(),utils.readTestData("moneypillar","SaverAccount","offersTitle"));
		Assert.assertEquals(moneyPage.getRewardCarouselTitle(),utils.readTestData("moneypillar","SaverAccount","rewardsTitle"));
		Assert.assertEquals(moneyPage.getArticleCarouselTitle(),utils.readTestData("moneypillar","SaverAccount","articlesTitle"));
		
	}

	
	@TestDetails(story1 = "DMPM-6518:DMPM-6938", priority = Priority.LOW)
    @Test (groups = {"marketplace", "Money Pillar", "priority-minor"})
	public void testMoreThanOneMoneyTrackerCategory() {
		
		String userName = utils.readTestData("moneypillar","moneyTracker","login");
		String pwd = utils.readTestData("moneypillar","moneyTracker","pwd");
		String [] categoryNames = {utils.readTestData("moneypillar","moneyTracker","category1"),utils.readTestData("moneypillar","moneyTracker","category2")};
		String [] categoryAmounts = {utils.readTestData("moneypillar","moneyTracker","category1Amount"),utils.readTestData("moneypillar","moneyTracker","category2Amount")};
		navigateToMoney(userName,pwd);
		moneyPage.checkMoneyTrackerTitle();
		moneyPage.tapOnMoneytracker();
		Assert.assertEquals(moneyTrackerPage.getMonthLabel(),utils.readTestData("moneypillar","moneyTracker","monthLabel"),"Incorrect month label");
		assertCategoryDetails(categoryNames,categoryAmounts);
		moneyTrackerPage.tapCategoryCarousel();
		moneyTrackerPage.waitForMonthLabelToDisappear();
		Assert.assertNotNull(categoryBreakDownPage.checkBreakdownPageTitle(utils.readTestData("moneypillar","moneyTracker","category1")),"Not on the selected category breakdown page");
	}
	
	
	private void navigateToMoney(String userName, String pwd) {
		loginToApp(userName,pwd);
		landingPage.tapMoneyTab();
		common.checkLoadingIndicator();
	    common.waitForLoadingIndicatorToDisappear();
	}
	
	private void assertCategoryDetails(String[] exptdCategoryNames, String[] exptdCategoryAmounts) {

		for (int i = 0; i < 2; i++) {

			Assert.assertEquals(moneyTrackerPage.getCategoryName(i), exptdCategoryNames[i],
					"Category" + i + " name is incorrect");
			Assert.assertEquals(moneyTrackerPage.getCategoryAmount(i), exptdCategoryAmounts[i],
					"Category" + i + " amount is incorrect");
		}

	}
	
	private void assertAcccountOverviewDetails(String [] everyDayAccountDetails){
		
		String expectedDisplayName = everyDayAccountDetails[0];
		String expectedBSB = everyDayAccountDetails[1];
		String expectedAccountNumber = everyDayAccountDetails[2];
		String expectedAvailableBalance = everyDayAccountDetails[3];
		
	    	Assert.assertNotNull(moneyPage.checkAccountName(expectedDisplayName)," Account display name is not correct");
	 	Assert.assertEquals( moneyPage.getBSB(expectedDisplayName),expectedBSB,"BSB is inncorect");
	 	Assert.assertEquals( moneyPage.getAccountNumber(expectedDisplayName), expectedAccountNumber,"Account number is incorrect");
	 	Assert.assertEquals( moneyPage.getAvailableBalance(expectedDisplayName), expectedAvailableBalance,"Available balance is incorrect");
	
	}
	

}
