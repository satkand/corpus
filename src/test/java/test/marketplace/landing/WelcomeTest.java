//package test.marketplace.landing;
//
//import org.testng.annotations.Test;
//
//import org.testng.Assert;
//
//import pages.App;
//
//public class WelcomeTest extends App {
//	
//	@Test (groups = {"DMPM-42", "DMPM-216", "marketplace", "welcome", "priority-minor"})
//	public void testWelcomePageElements(){
//		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen -Suncorp image is not shown");
//		Assert.assertNotNull(welcomePage.checkRegisterButton(), "Welcome screen - Register button is not shown");
//		Assert.assertNotNull(welcomePage.checkLoginButton(), "Welcome screen - Login button is not shown");
//		Assert.assertNotNull(welcomePage.checkGuestAccessButton(), "Welcome screen - Guest Access button is not shown");
//		Assert.assertNotNull(welcomePage.checkNeedHelpButton(), "Welcome screen - Need Help button is not shown");
//	}
//	
//	@Test (groups = {"DMPM-42", "DMPM-217", "marketplace", "welcome", "priority-minor"})
//	public void testNavigatingToLoginScreen(){
//		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen -Suncorp image is not shown");
//		welcomePage.tapLoginButton();
//		Assert.assertNotNull(loginPage.checkLoginPageTitle(), "Login page - Login Title not shown");
//		loginPage.tapBackButton();
//		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen -Suncorp image is not shown");
//	}
//	
//	@Test (groups = {"DMPM-42", "DMPM-218", "marketplace", "welcome", "priority-minor"})
//	public void testNavigatingToRegisterScreen(){
//		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen -Suncorp image is not shown");
//		welcomePage.tapRegisterButton();
//		Assert.assertNotNull(getStartedPage.checkGetStartedPageTitle(), "Get Started page - Title not shown");
//		Assert.assertNotNull(getStartedPage.checkSetupNewAccountButton(), "Get Started page - 'Set up new account' button not shown");
//		getStartedPage.tapSetupNewAccount();
//		Assert.assertNotNull(registrationPage.checkRegistrationPageTitle(), "Registration page - Register Title not shown");
//		registrationPage.tapCancelButton();
//		Assert.assertNotNull(getStartedPage.checkGetStartedPageTitle(), "Get Started page - Title not shown");
//		getStartedPage.tapBackButton();
//		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen -Suncorp image is not shown");
//	}
//	
//	@Test (groups = {"DMPM-77", "DMPM-303", "marketplace", "Guest user", "priority-minor"})
//	public void testNavigatingToGuestAccessScreen(){
//		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen -Suncorp image is not shown");
//		welcomePage.tapGuestAccessButton();
//		Assert.assertNotNull(navigationMenu.checkSplitMenuIcon(), "Guest Landing Page - menu icon not shown");
//		Assert.assertNotNull(landingPage.checkLandingPageTitle(), "Guest Landing page - Page Title not shown");
//	}
//}
