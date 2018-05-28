package test.marketplace.portfolio;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import automation.framework.common.Copy;
import automation.framework.common.CustomRetryListener;
import automation.framework.common.TestDetails;
import pages.App;

public class PolicyDetailsTest extends App {

	@DataProvider(name = "PolicyMaintainceError")
	public static Object[][] Data_PolicyMaintainceError() {

		return new Object[][] { { "policyLockedOrInReferralError" }, { "policyEndorsementError" } };

	}

	@TestDetails(story1 = "DMPM-2057:DMPM-3086,DMPM-3087", story2 = "DMPM-4120:DMPM-5214", story3 = "DMPM-3657:DMPM-5258,DMPM-5259", story4 = "DMPM-5066:DMPM-5979")
	@Test(retryAnalyzer = CustomRetryListener.class,groups = { "marketplace", "policy details", "priority-minor" })
	public void testVehicleAndPropertyPolicySummary() throws InterruptedException {

		String carPolicy = "carPolicy";
		String homePolicy = "homePolicy";
		
		String car = utils.readTestData("portfolio", "policyDetails", carPolicy, "productType");
		String home = utils.readTestData("portfolio", "policyDetails", homePolicy, "productType");
		String userName = utils.readTestData("portfolio", "policyDetails", carPolicy, "login");
		String pwd = utils.readTestData("portfolio", "policyDetails", carPolicy, "pwd");

		navigateToMyProductsScreen(userName, pwd);
		common.waitForLoadingIndicatorToDisappear();
		myProductsPage.scrollToProductAndTap(car);
		//Assert.assertNotNull(common.checkLoadingIndicator(), "Loading Indicator is not displayed");
		common.waitForLoadingIndicatorToDisappear();
		Assert.assertNull(common.checkLoadingIndicator(), "Loading Indicator is displayed");
		Assert.assertNotNull(policyDetailsPage.checkPolicyDetailsScreenTitle(Copy.POLICY_DETAILS_SCREEN_TITLE),
				"Not on policy details screen");
		Assert.assertNotNull(policyDetailsPage.checkPolicyDetailsBanner(), "Policy header is not displayed");
		Assert.assertNotNull(policyDetailsPage.checkPolicyNumberLabel(), "Policy Number Label is not displayed");
		Assert.assertNotNull(policyDetailsPage.checkPeriodOfCoverLabel(), "Period Of Cover Label is not displayed");
		Assert.assertNotNull(policyDetailsPage.checkPolicyBrandImage(), "Brand Image is not displayed");
		assertPolicySummaryValues(carPolicy);

		policyDetailsPage.tapNavigateBackButton();
		myProductsPage.scrollToProductAndTap(home);
		common.waitForLoadingIndicatorToDisappear();
		assertPolicySummaryValues(homePolicy);
	}

	@TestDetails(story1 = "DMPM-3647:DMPM-4600,DMPM-4603,DMPM-4604;DMPM-4599", story2 = "DMPM-3659:DMPM-5131")
	@Test(retryAnalyzer = CustomRetryListener.class,groups = { "marketplace", "policy details", "priority-minor" })
	public void testInstalmentAndPayments() throws InterruptedException {

		String motorHomePolicy = "motorHomePolicy";
		String carPolicy = "carPolicy";
		String carAdvantagePolicy = "carAdvantagePolicy";
		String boatPolicy = "boatPolicy";
		String homePolicy = "homePolicy";
		String home = utils.readTestData("portfolio", "policyDetails", homePolicy, "productType");
		String carProduct = utils.readTestData("portfolio", "policyDetails", carPolicy, "productType");
		String carAdvantageProduct = utils.readTestData("portfolio", "policyDetails", carAdvantagePolicy,
				"productType");
		String motorHomeProduct = utils.readTestData("portfolio", "policyDetails", motorHomePolicy, "productType");
		String boatProduct = utils.readTestData("portfolio", "policyDetails", boatPolicy, "productType");
		String monthlyInstallmentAmnt = utils.readTestData("portfolio", "policyDetails", carPolicy, "instalmentDetails",
				"instalmentAmount");
		String quarterlyInstallmentAmnt = utils.readTestData("portfolio", "policyDetails", homePolicy,
				"instalmentDetails", "instalmentAmount");
		String biAnnualInstallmentAmnt = utils.readTestData("portfolio", "policyDetails", motorHomePolicy,
				"instalmentDetails", "instalmentAmount");
		String annualInstallmentAmnt = utils.readTestData("portfolio", "policyDetails", boatPolicy, "instalmentDetails",
				"instalmentAmount");
		String debitDayDescription = utils.readTestData("portfolio", "policyDetails", carPolicy, "instalmentDetails",
				"debitDayLabel");
		String creditCardDetails = utils.readTestData("portfolio", "policyDetails", carPolicy, "paymentDetails",
				"creditCardDetails");
		String bankAccountDetails = utils.readTestData("portfolio", "policyDetails", carAdvantagePolicy,
				"paymentDetails", "bankAccountDetails");
		String userName = utils.readTestData("portfolio", "policyDetails", carPolicy, "login");
		String pwd = utils.readTestData("portfolio", "policyDetails", carPolicy, "pwd");

		navigateToMyProductsScreen(userName, pwd);
		common.waitForLoadingIndicatorToDisappear();
		myProductsPage.scrollToProductAndTap(carProduct);
		common.waitForLoadingIndicatorToDisappear();
		assertInstalmentDetails(Copy.INSTALMENT_FREUENCY_MONTHLY_LABEL, monthlyInstallmentAmnt);
		Assert.assertEquals(policyDetailsPage.getInstalmentDebitDayLabel(), debitDayDescription,
				"Debit day description is incorrect");
		Assert.assertEquals(policyDetailsPage.getPaymentMethodText(), Copy.PAYMENT_METHOD_LABEL,
				"Payment method label is incorrect");
		Assert.assertEquals(policyDetailsPage.getPaymentMethodAccountText(), creditCardDetails,
				"Credit card details are incorrect");

		policyDetailsPage.tapNavigateBackButton();
		myProductsPage.scrollToProductAndTap(home);
		common.waitForLoadingIndicatorToDisappear();
		assertInstalmentDetails(Copy.INSTALMENT_FREUENCY_QUARTERLY_LABEL, quarterlyInstallmentAmnt);

		policyDetailsPage.tapNavigateBackButton();
		myProductsPage.scrollToProductAndTap(carAdvantageProduct);
		common.waitForLoadingIndicatorToDisappear();
		Assert.assertEquals(policyDetailsPage.getPaymentMethodAccountText(), bankAccountDetails,
				"Bank Account details are incorrect");

		policyDetailsPage.tapNavigateBackButton();
		myProductsPage.scrollToProductAndTap(boatProduct);
		common.waitForLoadingIndicatorToDisappear();
		assertInstalmentDetails(Copy.INSTALMENT_FREUENCY_ANNUAL_LABEL, annualInstallmentAmnt);

		policyDetailsPage.tapNavigateBackButton();
		myProductsPage.scrollToProductAndTap(motorHomeProduct);
		common.waitForLoadingIndicatorToDisappear();
		assertInstalmentDetails(Copy.INSTALMENT_FREUENCY_HALF_YEARLY_LABEL, biAnnualInstallmentAmnt);

	}

	@TestDetails(story1 = "DMPM-3649:DMPM-4272")
	@Test(retryAnalyzer = CustomRetryListener.class, groups = { "marketplace", "policy details", "priority-minor" })
	public void testViewListOfVehicleRisk() throws InterruptedException {

		String carPolicy = "carPolicy";
		String carProduct = utils.readTestData("portfolio", "policyDetails", carPolicy, "productType");

		String[] riskDetails1 = {
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "riskDescription1"),
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "registrationNumber1"),
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "insuredAmount1"),
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "coverType1"),
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "coverPeriod1") };
		String[] riskDetails2 = {
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "riskDescription2"),
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "registrationNumber2"),
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "insuredAmount2"),
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "coverType2"),
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "coverPeriod2") };
		
		String userName = utils.readTestData("portfolio", "policyDetails", carPolicy, "login");
		String pwd = utils.readTestData("portfolio", "policyDetails", carPolicy, "pwd");

		navigateToMyProductsScreen(userName, pwd);
		common.waitForLoadingIndicatorToDisappear();
		myProductsPage.scrollToProductAndTap(carProduct);
		common.waitForLoadingIndicatorToDisappear();
		policyDetailsPage.scrollToRisksTitle();
		assertRiskDetailsList(riskDetails1);
		if(policyDetailsPage.checkDiscountsAndBenefitsTitle()==null) {
			policyDetailsPage.scrollToDiscountsAndBenefits();
		}
		policyDetailsPage.scrollToDiscountsAndBenefits();
		assertRiskDetailsList(riskDetails2);
	}

	@TestDetails(story1 = "DMPM-3983:DMPM-4835,DMPM-4845")
	@Test(retryAnalyzer = CustomRetryListener.class, groups = { "marketplace", "policy details", "priority-minor" })
	public void testOptionalAndIncludedCover() throws InterruptedException {

		String carPolicy = "carPolicy";
		String carProduct = utils.readTestData("portfolio", "policyDetails", carPolicy, "productType");
		String expectedOptionalCoverDesc = utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails",
				"optionalCoverDescription");
		String expectedIncludedCoverDesc = utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails",
				"includedCoverDescription");
		String userName = utils.readTestData("portfolio", "policyDetails", carPolicy, "login");
		String pwd = utils.readTestData("portfolio", "policyDetails", carPolicy, "pwd");

		navigateToMyProductsScreen(userName, pwd);
		common.waitForLoadingIndicatorToDisappear();
		myProductsPage.scrollToProductAndTap(carProduct);
		common.waitForLoadingIndicatorToDisappear();
		policyDetailsPage.scrollToOptionalCover();
		Assert.assertEquals(policyDetailsPage.getOptionalCoverLabel(), Copy.OPTIONAL_COVER_LABEL,
				"Optional cover label is incorrect");
		Assert.assertEquals(policyDetailsPage.getOptionalCoverDescription(), expectedOptionalCoverDesc,
				"Policy header is not displayed after scrolling up");
		Assert.assertEquals(policyDetailsPage.getIncludedCoverLabel(), Copy.INCLUDED_COVER_LABEL,
				"Included cover label is incorrect");
		Assert.assertEquals(policyDetailsPage.getIncludedCoverDescription(), expectedIncludedCoverDesc,
				"Policy header is not displayed after scrolling up");

	}

	@TestDetails(story1 = "DMPM-3655:DMPM-5030,DMPM-5031")
	@Test(retryAnalyzer = CustomRetryListener.class, groups = { "marketplace", "policy details", "priority-minor" })
	public void testRiskDetailsScreen() throws InterruptedException {
		String carPolicy = "carPolicy";
		String carProduct = utils.readTestData("portfolio", "policyDetails", carPolicy, "productType");

		String[] riskDetails = {
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "riskDescription1"),
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "registrationNumber1"),
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "insuredAmount1"),
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "coverType1"),
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "coverPeriod1"),
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "optionalCoverDescription"),
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "includedCoverDescription"),
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "parkingAddress") };
		String userName = utils.readTestData("portfolio", "policyDetails", carPolicy, "login");
		String pwd = utils.readTestData("portfolio", "policyDetails", carPolicy, "pwd");

		navigateToMyProductsScreen(userName, pwd);
		common.waitForLoadingIndicatorToDisappear();
		myProductsPage.scrollToProductAndTap(carProduct);
		common.waitForLoadingIndicatorToDisappear();
		policyDetailsPage.scrollToRiskViewDetailsButton();
		//Assert.assertNotNull(policyDetailsPage.scrollToRiskViewDetailsButton(), "View details button is not displayed");
		policyDetailsPage.tapRiskViewDetails();
		assertRiskDetailsScreen(riskDetails);
		riskDetailsPage.tapNavigateBackButton();
		Assert.assertNotNull(policyDetailsPage.checkPolicyDetailsScreenTitle(Copy.POLICY_DETAILS_SCREEN_TITLE),
				"Not on policy details screen");
	}
	
	@TestDetails(story1 = "DMPM-6151:DMPM-7074", story2 = "DMPM-5751:DMPM-7544")
	@Test(retryAnalyzer = CustomRetryListener.class, groups = { "marketplace", "policy details", "priority-minor" })
	public void testRiskDetailsCoverPeriod() throws InterruptedException {
		String carPolicy = "carPolicy";
		String CoverTypeTitle;
		String carProduct = utils.readTestData("portfolio", "policyDetails", carPolicy, "productType");
		String[] riskDetails = {
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "coverType1"),
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "coverPeriod1"),
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "riskDescription1"),
				utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "registrationNumber1")
		};
		String userName = utils.readTestData("portfolio", "policyDetails", carPolicy, "login");
		String pwd = utils.readTestData("portfolio", "policyDetails", carPolicy, "pwd");

		navigateToMyProductsScreen(userName, pwd);
		common.waitForLoadingIndicatorToDisappear();
		myProductsPage.scrollToProductAndTap(carProduct);
		common.waitForLoadingIndicatorToDisappear();
		//DMPM-6151:DMPM-7074
		policyDetailsPage.scrollToRisksTitle();
		CoverTypeTitle = policyDetailsPage.getCoverTypeTextUsingId();
		//DMPM-5751:DMPM-7544
		assertRiskTileElements(riskDetails);
		//DMPM-6151:DMPM-7074 Continued
		policyDetailsPage.scrollToRiskViewDetailsButton();
		Assert.assertNotNull(policyDetailsPage.checkRiskViewDetails(), "View details button is not displayed");
		policyDetailsPage.tapRiskViewDetails();
		assertRiskDetails(riskDetails,CoverTypeTitle);
		riskDetailsPage.tapNavigateBackButton();
		Assert.assertNotNull(policyDetailsPage.checkPolicyDetailsScreenTitle(Copy.POLICY_DETAILS_SCREEN_TITLE),
				"Not on policy details screen");
	}

	
	@TestDetails(story1 = "DMPM-3651:DMPM-3851,DMPM-3852")
	@Test(retryAnalyzer = CustomRetryListener.class, groups = { "marketplace", "policy details", "priority-minor" })	
	public void testViewDiscountsAndRewards() throws InterruptedException {
		String boatPolicy = "boatPolicy";
		String carAdvantagePolicy = "carAdvantagePolicy";
		String carProduct = utils.readTestData("portfolio", "policyDetails", boatPolicy, "productType");
		String discounts = utils.readTestData("portfolio", "policyDetails", "carPolicy", "riskDetails", "discounts");
		String rewardsTitle = utils.readTestData("portfolio", "policyDetails", "carPolicy", "riskDetails",
				"rewardsTitle");
		String rewards = utils.readTestData("portfolio", "policyDetails", "carPolicy", "riskDetails", "rewards");
		String carAdvantageProduct = utils.readTestData("portfolio", "policyDetails", carAdvantagePolicy,
				"productType");
		String userName = utils.readTestData("portfolio", "policyDetails", boatPolicy, "login");
		String pwd = utils.readTestData("portfolio", "policyDetails", boatPolicy, "pwd");
		
		navigateToMyProductsScreen(userName, pwd);
		common.waitForLoadingIndicatorToDisappear();
		
		myProductsPage.scrollToProductAndTap(carAdvantageProduct);
		common.waitForLoadingIndicatorToDisappear();
		Assert.assertFalse(policyDetailsPage.isDiscountOrRewardsDisplayed(), "Discounts/Rewards are displayed");
		policyDetailsPage.tapNavigateBackButton();
		
		myProductsPage.scrollToProductAndTap(carProduct);
		common.waitForLoadingIndicatorToDisappear();
		policyDetailsPage.scrollToRewardsSubtitle();
		Assert.assertEquals(policyDetailsPage.getDiscountsTitle(), Copy.DISCOUNTS_LABEL,
				"Discounts label is incorrect");
		Assert.assertEquals(policyDetailsPage.getDiscounts(), discounts, "Discounts are not displayed");
		Assert.assertEquals(policyDetailsPage.getRewardsTitle(), rewardsTitle, "Rewards label is not displayed");
		Assert.assertEquals(policyDetailsPage.getRewardsSubtitle(), rewards, "Rewards are not displayed");
	}
	
	
	@TestDetails(story1 = "DMPM-5523:DMPM7433,DMPM-7446")
	@Test(retryAnalyzer = CustomRetryListener.class, groups = { "marketplace", "policy details", "priority-minor" })
	public void testDisplayRewards() throws InterruptedException {
		String carPolicy = "carPolicy";
		String motorHomePolicy = "motorHomePolicy";
		String carProduct = utils.readTestData("portfolio", "policyDetails", carPolicy, "productType");
		String motorHomeProduct = utils.readTestData("portfolio", "policyDetails", motorHomePolicy,
				"productType");
		String rewardsTitle = utils.readTestData("portfolio", "policyDetails", motorHomePolicy, "riskDetails",
				"rewardsTitle");
		String rewards = utils.readTestData("portfolio", "policyDetails", motorHomePolicy, "riskDetails", "rewards");
		String userName = utils.readTestData("portfolio", "policyDetails", carPolicy, "login");
		String pwd = utils.readTestData("portfolio", "policyDetails", carPolicy, "pwd");

		navigateToMyProductsScreen(userName, pwd);
		common.waitForLoadingIndicatorToDisappear();
		myProductsPage.scrollToProductAndTap(carProduct);
		common.waitForLoadingIndicatorToDisappear();
		policyDetailsPage.scrollToRewardsSubtitle();
		Assert.assertFalse(policyDetailsPage.isDiscountOrRewardsDisplayed(), "Rewards are displayed");
		policyDetailsPage.tapNavigateBackButton();
		myProductsPage.scrollToProductAndTap(motorHomeProduct);
		common.waitForLoadingIndicatorToDisappear();
		policyDetailsPage.scrollToRewardsSubtitle();
		Assert.assertEquals(policyDetailsPage.getRewardsTitle(), rewardsTitle, "Rewards label is not displayed");
		Assert.assertEquals(policyDetailsPage.getRewardsSubtitle(), rewards, "Rewards are not displayed");
	}

	@TestDetails(story1 = "DMPM-4939:DMPM-7055,DMPM-7057")
	@Test(retryAnalyzer = CustomRetryListener.class, groups = { "marketplace", "policy details", "priority-minor" })
	public void testDiscountsCommaSeperated() throws InterruptedException {
		String homePolicy = "homePolicy";
		String userName = utils.readTestData("portfolio", "policyDetails", homePolicy, "policyStatus", "login");
		String pwd = utils.readTestData("portfolio", "policyDetails", homePolicy, "policyStatus", "pwd");
		
		
		String myProductCancellationPending = utils.readTestData("portfolio", "policyDetails", homePolicy,
				"myProductPolicyStatus", "cancellationPending");
		String myProductrenewalOverDue = utils.readTestData("portfolio", "policyDetails", homePolicy,
				"myProductPolicyStatus", "renewalOverDue");
		String myProductFutureActive = utils.readTestData("portfolio", "policyDetails", homePolicy,
				"myProductPolicyStatus", "futureActive");
		
		String discounts2 = utils.readTestData("portfolio", "policyDetails", homePolicy,"Discounts&Benefits","discounts2");
		String discounts3 = utils.readTestData("portfolio", "policyDetails", homePolicy,"Discounts&Benefits","discounts3");
		

		navigateToMyProductsScreen(userName, pwd);
		common.waitForLoadingIndicatorToDisappear();
		myProductsPage.scrollToProductAndTap(myProductCancellationPending);
		common.waitForLoadingIndicatorToDisappear();
		policyDetailsPage.scrollToDiscountsTitle();
		Assert.assertEquals(policyDetailsPage.getDiscountsTitle(), Copy.DISCOUNTS_LABEL,"Discounts label is incorrect");
		Assert.assertEquals(policyDetailsPage.getDiscounts(), discounts3, "Discounts are not displayed");
		String notCommaSeperated = policyDetailsPage.getDiscounts();
		
		//DMPM-7057: Verify that a single discount is not containing any comma
		Assert.assertFalse(notCommaSeperated.contains(","), "Discounts are comma seperated");
		
		//DMPM-7055: Verify that  discount is not present
		policyDetailsPage.tapNavigateBackButton();
		myProductsPage.scrollToProductAndTap(myProductFutureActive);
		common.waitForLoadingIndicatorToDisappear();
		policyDetailsPage.scrollToDiscountsAndBenefits();
		Assert.assertNull(policyDetailsPage.checkDiscountsTitle(),"Discounts label should not be present");
		policyDetailsPage.tapNavigateBackButton();
		
		//DMPM-7055: Verify that  discount is present and contains comma seperated multiple discounts
		myProductsPage.scrollToProductAndTap(myProductrenewalOverDue);
		common.waitForLoadingIndicatorToDisappear();
		policyDetailsPage.scrollToDiscountsTitle();
		Assert.assertEquals(policyDetailsPage.getDiscountsTitle(), Copy.DISCOUNTS_LABEL,"Discounts label is incorrect");
		Assert.assertEquals(policyDetailsPage.getDiscounts(), discounts2, "Discounts are not displayed");
		String commaSeperated = policyDetailsPage.getDiscounts();
		Assert.assertTrue(commaSeperated.contains(","),"Discounts are not comma seperated");
		
		
	}
	
	@TestDetails(story1 = "DMPM-4392:DMPM-5805,DMPM-5806")
	@Test(retryAnalyzer = CustomRetryListener.class, groups = { "marketplace", "policy details", "priority-minor" })
	public void testExcessInformation() throws InterruptedException {

		String carPolicy = "carPolicy";
		String carProduct = utils.readTestData("portfolio", "policyDetails", carPolicy, "productType");
		String excessType = utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails", "excessDetails",
				"excessType");
		String excessAmount = utils.readTestData("portfolio", "policyDetails", carPolicy, "riskDetails",
				"excessDetails", "excessAmount");
		String userName = utils.readTestData("portfolio", "policyDetails", carPolicy, "login");
		String pwd = utils.readTestData("portfolio", "policyDetails", carPolicy, "pwd");
		navigateToMyProductsScreen(userName, pwd);
		common.waitForLoadingIndicatorToDisappear();
		myProductsPage.scrollToProductAndTap(carProduct);
		common.waitForLoadingIndicatorToDisappear();
		policyDetailsPage.scrollToRiskViewDetailsButton();
		policyDetailsPage.tapRiskViewDetails();
		Assert.assertEquals(riskDetailsPage.getExcessType(), excessType, "Standard excess type label is not displayed");
		Assert.assertEquals(riskDetailsPage.getExcessAmount(), excessAmount,
				"Standard amount type label is not displayed");
		riskDetailsPage.scrollToMotorRiskParking();
		Assert.assertNull(riskDetailsPage.checkAdditionalExcessesTab(), "Additional Excesses Tab is displayed");
	}

	@TestDetails(story1 = "DMPM-4392:DMPM-5808,DMPM-5813", story2 = "DMPM-7199:DMPM-7920")
	@Test(retryAnalyzer = CustomRetryListener.class, groups = { "marketplace", "policy details", "priority-minor" })
	public void testAdditionalExcessInformation() throws InterruptedException {

		String boatPolicy = "boatPolicy";
		String carProduct = utils.readTestData("portfolio", "policyDetails", boatPolicy, "productType");
		String expctdAdditionalExcessDescription = utils.readTestData("portfolio", "policyDetails", boatPolicy,
				"riskDetails", "additionalExcessDetails", "additionalExcessDescription");
		String expctdAdditionalExcessListedDriver = utils.readTestData("portfolio", "policyDetails", boatPolicy,
				"riskDetails", "additionalExcessDetails", "additionalExcessListedDriver");
		String expctdAdditionalExcessUnListedDriver = utils.readTestData("portfolio", "policyDetails", boatPolicy,
				"riskDetails", "additionalExcessDetails", "additionalExcessUnListedDriver");
		String userName = utils.readTestData("portfolio", "policyDetails", boatPolicy, "login");
		String pwd = utils.readTestData("portfolio", "policyDetails", boatPolicy, "pwd");

		navigateToMyProductsScreen(userName, pwd);
		common.waitForLoadingIndicatorToDisappear();
		myProductsPage.scrollToProductAndTap(carProduct);
		common.waitForLoadingIndicatorToDisappear();
		policyDetailsPage.scrollToRiskViewDetailsButton();
		Assert.assertNotNull(policyDetailsPage.checkRiskViewDetails(), "Risk tile in policy details do not show risk view button!");
		policyDetailsPage.tapRiskViewDetails();
		Assert.assertEquals(riskDetailsPage.getAdditionalExcessesTabText(), Copy.ADDITIONAL_EXCESSES_DETAILS_LABEL,
				"Additional Excess Details label is not displayed");
		riskDetailsPage.tapAdditionalExcessesTab();
		Assert.assertEquals(riskDetailsPage.getAdditionalExcessDescription(), expctdAdditionalExcessDescription,
				"Additional Excess Description is incorrect");
		Assert.assertEquals(riskDetailsPage.getAdditionalExcessListedDriver(), expctdAdditionalExcessListedDriver,
				"Additional Excess Listed Driver is incorrect");
		Assert.assertEquals(riskDetailsPage.getAdditionalExcessUnListedDriver(), expctdAdditionalExcessUnListedDriver,
				"Additional Excess UnListed Driver is incorrect");
		Assert.assertEquals(riskDetailsPage.getAdditionalExcessesTabText(), Copy.HIDE_ADDITIONAL_EXCESSES_LABEL,
				"Hide Additional Excesses label is not displayed");
		riskDetailsPage.tapAdditionalExcessesTab();
		Assert.assertEquals(riskDetailsPage.getAdditionalExcessesTabText(), Copy.ADDITIONAL_EXCESSES_DETAILS_LABEL,
				"Additional Excess Detailslabel is not displayed");

	}

	@TestDetails(story1 = "DMPM-4623: DMPM-5505")
	@Test(retryAnalyzer = CustomRetryListener.class, dataProvider = "PolicyMaintainceError", groups = { "marketplace", "policy details", "priority-minor" })
	public void testPolicyUnderMaintainceError(String errorType) throws InterruptedException {

		String motorHomePolicy = "motorHomePolicy";
		String userName = utils.readTestData("portfolio", "policyDetails", motorHomePolicy, errorType, "login");
		String pwd = utils.readTestData("portfolio", "policyDetails", motorHomePolicy, errorType, "pwd");

		navigateToMyProductsScreen(userName, pwd);
		common.waitForLoadingIndicatorToDisappear();
		myProductsPage.tapProductByInstance(0);
		common.waitForLoadingIndicatorToDisappear();
		Assert.assertEquals(policyDetailsPage.getPolicyMaintenanceTitle(), Copy.POLICY_MAINTAINCE_TITLE, "Policy maintiance title is incorrect");
		Assert.assertEquals(policyDetailsPage.getPolicyMaintenanceErrorMessageText(),Copy.POLICY_MAINTAINCE_ERROR_MESSAGE, "Policy maintiance error message is incorrect");
		policyDetailsPage.tapNavigateBackButton();
		myProductsPage.checkMyProductsTitle();
		myProductsPage.tapProductByInstance(1);
		common.waitForLoadingIndicatorToDisappear();
		Assert.assertEquals(policyDetailsPage.getPolicyMaintenanceTitle(), Copy.POLICY_MAINTAINCE_TITLE,
				"Policy maintiance title is not displayed");
		Assert.assertEquals(policyDetailsPage.getPolicyMaintenanceErrorMessageText(),
				Copy.POLICY_MAINTAINCE_ERROR_MESSAGE, "Policy maintiance error message is incorrect");

	}

	@TestDetails(story1 = "DMPM-2193:DMPM-4191,DMPM-4192,DMPM-4193 ")
	@Test(retryAnalyzer = CustomRetryListener.class, groups = { "marketplace", "policy details", "priority-minor" })
	public void testPolicyDetailsStatus() throws InterruptedException {

		String homePolicy = "homePolicy";
		String userName = utils.readTestData("portfolio", "policyDetails", homePolicy, "policyStatus", "login");
		String pwd = utils.readTestData("portfolio", "policyDetails", homePolicy, "policyStatus", "pwd");
		String activePolicy = utils.readTestData("portfolio", "policyDetails", homePolicy, "policyStatus", "active");
		String cancellationPending = utils.readTestData("portfolio", "policyDetails", homePolicy, "policyStatus",
				"cancellationPending");
		String futureActive = utils.readTestData("portfolio", "policyDetails", homePolicy, "policyStatus",
				"futureActive");
		String renewalDue = utils.readTestData("portfolio", "policyDetails", homePolicy, "policyStatus", "renewalDue");
		String renewalOverDue = utils.readTestData("portfolio", "policyDetails", homePolicy, "policyStatus",
				"renewalOverDue");
		String myProductActivePolicy = utils.readTestData("portfolio", "policyDetails", homePolicy,
				"myProductPolicyStatus", "active");
		String myProductCancellationPending = utils.readTestData("portfolio", "policyDetails", homePolicy,
				"myProductPolicyStatus", "cancellationPending");
		String myProductFutureActive = utils.readTestData("portfolio", "policyDetails", homePolicy,
				"myProductPolicyStatus", "futureActive");
		String myProductRenewalDue = utils.readTestData("portfolio", "policyDetails", homePolicy,
				"myProductPolicyStatus", "renewalDue");
		String myProductrenewalOverDue = utils.readTestData("portfolio", "policyDetails", homePolicy,
				"myProductPolicyStatus", "renewalOverDue");

		navigateToMyProductsScreen(userName, pwd);
		common.waitForLoadingIndicatorToDisappear();
		myProductsPage.tapProductByPolicyStatus(myProductActivePolicy);
		common.waitForLoadingIndicatorToDisappear();
		Assert.assertEquals(policyDetailsPage.getPolicyActiveStatus().toUpperCase(), activePolicy,
				"Policy active status is incorrect");
		assertPolicyRenewalStatus(myProductCancellationPending, cancellationPending);
		assertPolicyRenewalStatus(myProductFutureActive, futureActive);
		assertPolicyRenewalStatus(myProductRenewalDue, renewalDue);
		assertPolicyRenewalStatus(myProductrenewalOverDue, renewalOverDue);
		policyDetailsPage.tapNavigateBackButton();
		/*
		 * Below Code not applicable to this script,as it should be automated as part of 
		 * DMPM-6320 and related cases
		 */
		
		/*
		 * policyDetailsPage.tapRenewNowButton();
		 * Assert.assertNotNull(renewPolicyPage.checkRenewPolicyScreenTitle(Copy.RENEW_POLICY_SCREEN_TITLE),
		 * "Not on renew policy screen");
		 */
			
		
	}
	
	@TestDetails(story1 = "DMPM-5026:DMPM-6894,DMPM-6895,DMPM-6897")
	@Test(retryAnalyzer = CustomRetryListener.class, groups = { "marketplace", "policy details", "priority-minor" })
	public void testRiskCoverPeriod() throws InterruptedException {

		String homePolicy = "homePolicy";
		String userName = utils.readTestData("portfolio", "policyDetails", homePolicy, "policyStatus", "login");
		String pwd = utils.readTestData("portfolio", "policyDetails", homePolicy, "policyStatus", "pwd");
		
		String activePolicy = utils.readTestData("portfolio", "policyDetails", homePolicy, "policyStatus", "active");
		String activeStartDate = utils.readTestData("portfolio", "policyDetails", homePolicy, "PeriodOfCover", "activeStartDate");
		String activeEndDate = utils.readTestData("portfolio", "policyDetails", homePolicy, "PeriodOfCover", "activeEndDate");

		String cancellationPending = utils.readTestData("portfolio", "policyDetails", homePolicy, "policyStatus",
				"cancellationPending");
		String cancellationPendingStartDate = utils.readTestData("portfolio", "policyDetails", homePolicy, "PeriodOfCover", 
				"cancellationPendingStartDate");
		String cancellationPendingEndDate = utils.readTestData("portfolio", "policyDetails", homePolicy, "PeriodOfCover", 
				"cancellationPendingEndDate");
		
		String futureActive = utils.readTestData("portfolio", "policyDetails", homePolicy, "policyStatus",
				"futureActive");
		String futureActiveStartDate = utils.readTestData("portfolio", "policyDetails", homePolicy, "PeriodOfCover", 
				"futureActiveStartDate");
		String futureActiveEndDate = utils.readTestData("portfolio", "policyDetails", homePolicy, "PeriodOfCover",
				"futureActiveEndDate");
		
		String renewalDue = utils.readTestData("portfolio", "policyDetails", homePolicy, "policyStatus", "renewalDue");
		String renewalDueStartDate = utils.readTestData("portfolio", "policyDetails", homePolicy, "PeriodOfCover", 
				"renewalStartDate");
		String renewalDueEndDate = utils.readTestData("portfolio", "policyDetails", homePolicy, "PeriodOfCover", 
				"renewalEndDate");
		
		String renewalOverDue = utils.readTestData("portfolio", "policyDetails", homePolicy, "policyStatus",
				"renewalOverDue");
		String renewalOverDueStartDate = utils.readTestData("portfolio", "policyDetails", homePolicy, "PeriodOfCover",
				"renewalOverDueStartDate");
		String renewalOverDueEndDate = utils.readTestData("portfolio", "policyDetails", homePolicy, "PeriodOfCover", 
				"renewalOverDueEndDate");
		
		String myProductActivePolicy = utils.readTestData("portfolio", "policyDetails", homePolicy,
				"myProductPolicyStatus", "active");
		String myProductCancellationPending = utils.readTestData("portfolio", "policyDetails", homePolicy,
				"myProductPolicyStatus", "cancellationPending");
		String myProductFutureActive = utils.readTestData("portfolio", "policyDetails", homePolicy,
				"myProductPolicyStatus", "futureActive");
		String myProductRenewalDue = utils.readTestData("portfolio", "policyDetails", homePolicy,
				"myProductPolicyStatus", "renewalDue");
		String myProductrenewalOverDue = utils.readTestData("portfolio", "policyDetails", homePolicy,
				"myProductPolicyStatus", "renewalOverDue");

		navigateToMyProductsScreen(userName, pwd);
		common.waitForLoadingIndicatorToDisappear();
		myProductsPage.tapProductByPolicyStatus(myProductActivePolicy);
		common.waitForLoadingIndicatorToDisappear();
		Assert.assertEquals(policyDetailsPage.getPolicyActiveStatus().toUpperCase(), activePolicy,
				"Policy active status is incorrect");
		assertRiskCoverPeriodDates(activeStartDate, activeEndDate);
		assertPolicyRenewalStatus(myProductCancellationPending, cancellationPending, cancellationPendingStartDate, cancellationPendingEndDate);
		assertPolicyRenewalStatus(myProductFutureActive, futureActive, futureActiveStartDate, futureActiveEndDate);
		assertPolicyRenewalStatus(myProductRenewalDue, renewalDue, renewalDueStartDate, renewalDueEndDate);
		assertPolicyRenewalStatus(myProductrenewalOverDue, renewalOverDue, renewalOverDueStartDate, renewalOverDueEndDate);
		
	}
	
	@TestDetails(story1 = "DMPM-5532:DMPM-7453,DMPM-7454,DMPM-7456")
	@Test(retryAnalyzer = CustomRetryListener.class, groups = { "marketplace", "policy details", "priority-minor" })
	public void testRiskCoverDetails() throws InterruptedException {

		String carPolicy = "carPolicy";
		String userName = utils.readTestData("portfolio", "policyDetails", carPolicy, "vehiclePolicyStatus", "login");
		String pwd = utils.readTestData("portfolio", "policyDetails", carPolicy, "vehiclePolicyStatus", "pwd");
		
		String activePolicy = utils.readTestData("portfolio", "policyDetails", carPolicy, "vehiclePolicyStatus", "active");
		String activeStartDate = utils.readTestData("portfolio", "policyDetails", carPolicy, "PeriodOfCover", "activeStartDate");
		String activeEndDate = utils.readTestData("portfolio", "policyDetails", carPolicy, "PeriodOfCover", "activeEndDate");

		String cancellationPending = utils.readTestData("portfolio", "policyDetails", carPolicy, "vehiclePolicyStatus",
				"cancellationPending");
		String cancellationPendingStartDate = utils.readTestData("portfolio", "policyDetails", carPolicy, "PeriodOfCover", 
				"cancellationPendingStartDate");
		String cancellationPendingEndDate = utils.readTestData("portfolio", "policyDetails", carPolicy, "PeriodOfCover", 
				"cancellationPendingEndDate");
		
		String futureActive = utils.readTestData("portfolio", "policyDetails", carPolicy, "vehiclePolicyStatus",
				"futureActive");
		String futureActiveStartDate = utils.readTestData("portfolio", "policyDetails", carPolicy, "PeriodOfCover", 
				"futureActiveStartDate");
		String futureActiveEndDate = utils.readTestData("portfolio", "policyDetails", carPolicy, "PeriodOfCover",
				"futureActiveEndDate");
		
		String renewalDue = utils.readTestData("portfolio", "policyDetails", carPolicy, "vehiclePolicyStatus", "renewalDue");
		String renewalDueStartDate = utils.readTestData("portfolio", "policyDetails", carPolicy, "PeriodOfCover", 
				"renewalStartDate");
		String renewalDueEndDate = utils.readTestData("portfolio", "policyDetails", carPolicy, "PeriodOfCover", 
				"renewalEndDate");
		
		String renewalOverDue = utils.readTestData("portfolio", "policyDetails", carPolicy, "vehiclePolicyStatus",
				"renewalOverDue");
		String renewalOverDueStartDate = utils.readTestData("portfolio", "policyDetails", carPolicy, "PeriodOfCover",
				"renewalOverDueStartDate");
		String renewalOverDueEndDate = utils.readTestData("portfolio", "policyDetails", carPolicy, "PeriodOfCover", 
				"renewalOverDueEndDate");
		
		String myProductActivePolicy = utils.readTestData("portfolio", "policyDetails", carPolicy,
				"myVehiclePolicyStatus", "active");
		String myProductCancellationPending = utils.readTestData("portfolio", "policyDetails", carPolicy,
				"myVehiclePolicyStatus", "cancellationPending");
		String myProductFutureActive = utils.readTestData("portfolio", "policyDetails", carPolicy,
				"myVehiclePolicyStatus", "futureActive");
		String myProductRenewalDue = utils.readTestData("portfolio", "policyDetails", carPolicy,
				"myVehiclePolicyStatus", "renewalDue");
		String myProductrenewalOverDue = utils.readTestData("portfolio", "policyDetails", carPolicy,
				"myVehiclePolicyStatus", "renewalOverDue");

		navigateToMyProductsScreen(userName, pwd);
		common.waitForLoadingIndicatorToDisappear();
		assertRiskRenewalStatus(myProductActivePolicy, activePolicy, activeStartDate, activeEndDate);
		policyDetailsPage.tapNavigateBackButton();
		policyDetailsPage.tapNavigateBackButton();
		assertRiskRenewalStatus(myProductCancellationPending, cancellationPending, cancellationPendingStartDate, cancellationPendingEndDate);
		assertRiskStatus(cancellationPending);
		assertRiskRenewalStatus(myProductFutureActive, futureActive, futureActiveStartDate, futureActiveEndDate);
		assertRiskStatus(futureActive);
		assertRiskDetailsRenewalStatus( myProductRenewalDue,renewalDueStartDate, renewalDueEndDate);
		assertRiskDetailsRenewalStatus( myProductrenewalOverDue,renewalOverDueStartDate, renewalOverDueEndDate);
	}

	@TestDetails(story1 = "DMPM-5066:DMPM-5978")
	@Test(retryAnalyzer = CustomRetryListener.class, groups = { "marketplace", "policy details", "priority-minor" })
	public void testEndDateCancellationPending() throws InterruptedException {

		String homePolicy = "homePolicy";
		String userName = utils.readTestData("portfolio", "policyDetails", homePolicy, "policyStatus", "login");
		String pwd = utils.readTestData("portfolio", "policyDetails", homePolicy, "policyStatus", "pwd");
		String myProductCancellationPending = utils.readTestData("portfolio", "policyDetails", homePolicy,
				"myProductPolicyStatus", "cancellationPending");
		String expectedPolicyEndDate = utils.readTestData("portfolio", "policyDetails", homePolicy, "periodOfCover",
				"endDateCancellationPending");
		String expectedPolicyEndYear = utils.readTestData("portfolio", "policyDetails", homePolicy, "periodOfCover",
				"endYearCancellationPending");

		navigateToMyProductsScreen(userName, pwd);
		common.waitForLoadingIndicatorToDisappear();
		myProductsPage.tapProductByPolicyStatus(myProductCancellationPending);
		common.waitForLoadingIndicatorToDisappear();
		Assert.assertEquals(policyDetailsPage.getPolicyEndDate(), expectedPolicyEndDate,
				"policy end date is incorrect");
		Assert.assertEquals(policyDetailsPage.getPolicyEndYear(), expectedPolicyEndYear,
				"policy end year is incorrect");
	}
	
	private void assertRiskDetailsRenewalStatus(String myProductRenewalDue, String renewalDueStartDate,
			String renewalDueEndDate) {
		
		myProductsPage.tapProductByPolicyStatus(myProductRenewalDue);
		policyDetailsPage.scrollToRiskViewOnlyButton();
		policyDetailsPage.tapRiskViewOnlyDetails();
		Assert.assertNotNull(riskDetailsPage.checkCoverPeriodStart(),"Risk details, period of cover start date is not shown");
		Assert.assertNotNull(riskDetailsPage.checkCoverPeriodEnd(),"Risk details, period of cover end date is not shown");
		Assert.assertEquals(riskDetailsPage.getCoverPeriodStart(), renewalDueStartDate , "Risk details, period of cover start date is not as expected");
		Assert.assertEquals(riskDetailsPage.getCoverPeriodEnd(), renewalDueEndDate , "Risk details, period of cover end date is not as expected");
		policyDetailsPage.tapNavigateBackButton();
		policyDetailsPage.tapNavigateBackButton();
	}

	private void assertRiskStatus( String policy) {
		Assert.assertEquals(riskDetailsPage.getCoverStatusBannerText(), policy, policy + " status is incorrect");
		policyDetailsPage.tapNavigateBackButton();
		policyDetailsPage.tapNavigateBackButton();
		
	}

	private void assertRiskRenewalStatus(String myProductStatus, String policy,String coverPeriodStartDate, String coverPeriodEndDate) {
		myProductsPage.tapProductByPolicyStatus(myProductStatus);
		policyDetailsPage.scrollToRiskViewDetailsButton();
		policyDetailsPage.tapRiskViewDetails();
		common.waitForLoadingIndicatorToDisappear();
		Assert.assertNotNull(riskDetailsPage.checkCoverPeriodLabel(),"Risk details, period of cover title is not shown");
		assertRiskDetailsCoverPeriodDates(coverPeriodStartDate, coverPeriodEndDate);
	}

	private void assertRiskDetailsCoverPeriodDates(String coverPeriodStartDate, String coverPeriodEndDate) {
		
		Assert.assertEquals(riskDetailsPage.getCoverPeriodLabel(), Copy.PERIOD_OF_COVER, "Risk details, period of cover title is not as expected");
		Assert.assertNotNull(riskDetailsPage.checkCoverPeriodStart(),"Risk details, period of cover start date is not shown");
		Assert.assertNotNull(riskDetailsPage.checkCoverPeriodEnd(),"Risk details, period of cover end date is not shown");
		Assert.assertEquals(riskDetailsPage.getCoverPeriodStart(), coverPeriodStartDate , "Risk details, period of cover start date is not as expected");
		Assert.assertEquals(riskDetailsPage.getCoverPeriodEnd(), coverPeriodEndDate , "Risk details, period of cover end date is not as expected");
	}
	
	private void assertRiskCoverPeriodDates(String coverPeriodStartDate, String coverPeriodEndDate) {
		policyDetailsPage.scrollToRiskViewOnlyButton();
		Assert.assertNotNull(policyDetailsPage.checkRiskViewOnlyButton(), "View details button is not displayed");
		Assert.assertNotNull(policyDetailsPage.checkCoverPeriodLabel(),"Risk details, period of cover title is not shown");
		Assert.assertEquals(policyDetailsPage.getCoverPeriodLabel(), Copy.PERIOD_OF_COVER, "Risk details, period of cover title is not as expected");
		Assert.assertNotNull(policyDetailsPage.checkCoverPeriodStart(),"Risk details, period of cover start date is not shown");
		Assert.assertNotNull(policyDetailsPage.checkCoverPeriodEnd(),"Risk details, period of cover end date is not shown");
		Assert.assertEquals(policyDetailsPage.getCoverPeriodStart(), coverPeriodStartDate , "Risk details, period of cover start date is not as expected");
		Assert.assertEquals(policyDetailsPage.getCoverPeriodEnd(), coverPeriodEndDate , "Risk details, period of cover end date is not as expected");
	}

	private void navigateToMyProductsScreen(String username, String pasword) {
		
		loginToApp(username, pasword);
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.tapProductsMenuItem();
		if(myProductsPage.checkProductDisclaimerTitle()!=null){
			myProductsPage.tapProductDisclaimer();
		}
		myProductsPage.checkMyProductsTitle();
		
				
	}

	private void assertPolicyRenewalStatus(String myProductPolicyStatus, String policy) {
		policyDetailsPage.tapNavigateBackButton();
		myProductsPage.tapProductByPolicyStatus(myProductPolicyStatus);
		common.waitForLoadingIndicatorToDisappear();
		Assert.assertEquals(policyDetailsPage.getPolicyRenewalStatus(), policy, policy + " status is incorrect");
	}
	
	private void assertPolicyRenewalStatus(String myProductPolicyStatus, String policy, String coverPeriodStartDate, String coverPeriodEndDate) {
		policyDetailsPage.tapNavigateBackButton();
		myProductsPage.tapProductByPolicyStatus(myProductPolicyStatus);
		common.waitForLoadingIndicatorToDisappear();
		Assert.assertEquals(policyDetailsPage.getPolicyRenewalStatus(), policy, policy + " status is incorrect");
		assertRiskCoverPeriodDates(coverPeriodStartDate, coverPeriodEndDate);
	}

	private void assertPolicySummaryValues(String policy) {

		String expectedPolicyDescription = utils.readTestData("portfolio", "policyDetails", policy,
				"policyDescription");
		String expectedPolicyNumber = utils.readTestData("portfolio", "policyDetails", policy, "policyNumber");
		String expectedPolicyStartDate = utils.readTestData("portfolio", "policyDetails", policy, "periodOfCover",
				"startDate");
		String expectedPolicyStartYear = utils.readTestData("portfolio", "policyDetails", policy, "periodOfCover",
				"startYear");
		String expectedPolicyEndDate = utils.readTestData("portfolio", "policyDetails", policy, "periodOfCover",
				"endDate");
		String expectedPolicyEndYear = utils.readTestData("portfolio", "policyDetails", policy, "periodOfCover",
				"endYear");

		Assert.assertEquals(policyDetailsPage.getPolicyDescriptionText(), expectedPolicyDescription,"policy description is incorrect");
		Assert.assertEquals(policyDetailsPage.getPolicyNumberText(), expectedPolicyNumber,"policy number is incorrect");
		Assert.assertEquals(policyDetailsPage.getPolicyStartDate(), expectedPolicyStartDate,"policy start date is incorrect");
		Assert.assertEquals(policyDetailsPage.getpolicyStartYear(), expectedPolicyStartYear,"policy start year is incorrect");
		
		if(policyDetailsPage.checkPolicyEndDate()==null) {
			policyDetailsPage.scrollToPolicyEndDate();
		}
		Assert.assertEquals(policyDetailsPage.getPolicyEndDate(), expectedPolicyEndDate,"policy end date is incorrect");
		
		if(policyDetailsPage.checkPolicyEndYear()==null) {
			policyDetailsPage.scrollToPolicyEndYear();
		}
		Assert.assertEquals(policyDetailsPage.getPolicyEndYear(), expectedPolicyEndYear,"policy end year is incorrect");

	}

	private void assertInstalmentDetails(String expectedInstalmentFrequency, String expectedInstalmentAmount) {
		policyDetailsPage.scrollToInstallmentFrequncy();
		Assert.assertNotNull(policyDetailsPage.checkInstallmentFreuency(),"Policy details, installment frequency not displayed");
		Assert.assertEquals(policyDetailsPage.getInstalmentFreqText(), expectedInstalmentFrequency,
				"Instalment Frequency Label is incorrect");
		Assert.assertEquals(policyDetailsPage.getInstalmentAmt(), expectedInstalmentAmount,
				"Instalment amount is incorrect");

	}

	private void assertRiskDetailsList(String[] riskDetailsList) {

		Assert.assertNotNull(policyDetailsPage.checkRiskDescriptionText(riskDetailsList[0]),
				"Risk description text is incorrect");
		Assert.assertNotNull(policyDetailsPage.checkRegistrationNumberText(riskDetailsList[1]),
				"Registration number is incorrect");
		Assert.assertNotNull(policyDetailsPage.checkInsuredAmountLabelText(Copy.INSURED_AMOUNT_LABEL),
				"Insured amount label is incorrect");
		Assert.assertNotNull(policyDetailsPage.checkInsuredAmountText(riskDetailsList[2]),
				"Insured amount is incorrect");
		Assert.assertNotNull(policyDetailsPage.checkCoverTypeLabelText(riskDetailsList[3]),
				"Cover type label is not present");
		Assert.assertNotNull(policyDetailsPage.checkCoverTypeText(riskDetailsList[3]),"Cover type is incorrect");
		if (policyDetailsPage.checkCoverPeriodEnd()==null) {
			policyDetailsPage.scrollToCoverPeriod();
		}
		Assert.assertEquals(policyDetailsPage.getCoverPeriodStart()+policyDetailsPage.getCoverPeriodEnd(), riskDetailsList[4],
				"Policy header is not displayed after scrolling up");

	}

	private void assertRiskDetailsScreen(String[] riskDetails) {

		Assert.assertNotNull(riskDetailsPage.checkRiskDescriptionText(riskDetails[0]), "Risk description is incorrect");
		Assert.assertNotNull(riskDetailsPage.checkRegistrationNumberText(riskDetails[1]),
				"Registration number is incorrect");
		Assert.assertNotNull(riskDetailsPage.checkInsuredAmountLabelText(Copy.INSURED_AMOUNT_LABEL),
				"Insured amount is incorrect");
		Assert.assertEquals(riskDetailsPage.getInsuredAmountText(), riskDetails[2], "Insured amount is incorrect");
		Assert.assertNotNull(riskDetailsPage.checkCoverTypeLabelText(riskDetails[3]),
				"Cover type label is incorrect");
		Assert.assertEquals(riskDetailsPage.getRiskCoverType(riskDetails[3]), riskDetails[3], "Cover type text is incorrect");
		Assert.assertNotNull(policyDetailsPage.checkCoverPeriodLabelText(Copy.COVER_PERIOD_LABEL),
				"Cover period label is incorrect");
		Assert.assertEquals(riskDetailsPage.getCoverPeriodStart()+riskDetailsPage.getCoverPeriodEnd(), riskDetails[4], "Risk start date is incorrect");
		riskDetailsPage.scrollToMotorRiskParking();
		Assert.assertEquals(riskDetailsPage.getOptionalCoverLabel(), Copy.OPTIONAL_COVER_LABEL,
				"Optional cover label is incorrect");
		Assert.assertEquals(riskDetailsPage.getOptionalCoverDescription(), riskDetails[5],
				"Optional cover description is incorrect");
		Assert.assertEquals(riskDetailsPage.getIncludedCoverLabel(), Copy.INCLUDED_COVER_LABEL,
				"Included cover label is incorrect");
		Assert.assertEquals(riskDetailsPage.getIncludedCoverDescription(), riskDetails[6],
				"Included cover description");
		Assert.assertEquals(riskDetailsPage.getMotorRiskParkingLabel(), Copy.PARKING_ADDRESS_LABEL,
				"Parking label is incorrect");
		Assert.assertEquals(riskDetailsPage.getMotorRiskParkingDescription(), riskDetails[7],
				"Parking description is incorrect");

	}
	
	private void assertRiskDetails(String[] riskDetails, String coverTypeTitle) {
		Assert.assertNotNull(riskDetailsPage.checkRiskCoverType(), "Risk cover type is not displayed");
		Assert.assertEquals(riskDetailsPage.getRiskCoverTypeText(), riskDetails[0], "Cover type text is incorrect");
		Assert.assertEquals(riskDetailsPage.getRiskCoverTypeText(), coverTypeTitle, "Cover type text is not matching with cover type title");
	}

	private void assertRiskTileElements(String[] riskDetails) {
		Assert.assertNotNull(policyDetailsPage.checkPolicyRiskIcon(),"Risk tile is not displaying policy risk icon");
		Assert.assertNotNull(policyDetailsPage.checkPolicyRiskDescription(),"Risk tile is not displaying policy risk description");
		Assert.assertEquals(policyDetailsPage.getPolicyRiskDescription(), riskDetails[2], "Risk tile card title is incorrect");
		Assert.assertNotNull(policyDetailsPage.checkRegistrationNumber(),"Risk tile registration number is not displayed");
		Assert.assertEquals(policyDetailsPage.getRegistrationNumber(), riskDetails[3], "Risk tile registration number is incorrect");
		Assert.assertNotNull(policyDetailsPage.checkCoverTypeTextUsingId(),"Risk tile not displaying card title");
		Assert.assertEquals(policyDetailsPage.getCoverTypeTextUsingId(), riskDetails[0], "Risk tile card title is incorrect");
	}


}
