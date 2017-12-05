package pages;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import automation.framework.common.BaseTest;
import automation.framework.utils.AutoUtilities;
import automation.framework.utils.FluentAssert;
import pages.marketplace.GuestAccessPage;
import pages.marketplace.auth.LoginPage;
import pages.marketplace.auth.PINAuthPage;
import pages.marketplace.auth.PINCustomKeypad;
import pages.marketplace.auth.PINReAuthPasswordPage;
import pages.marketplace.auth.PINSetupPage;
import pages.marketplace.auth.RegistrationPage;
import pages.marketplace.common.CommonPage;
import pages.marketplace.common.ConfigPage;
import pages.marketplace.common.DummyPageWithLinks;
import pages.marketplace.common.NavigationDrawPage;
import pages.marketplace.common.WelcomePage;

public class App extends BaseTest {
	
	public WelcomePage welcomePage = null;
	public LoginPage loginPage = null;
	public RegistrationPage registrationPage = null;
	public GuestAccessPage guestAccessPage = null;
	public PINSetupPage pinSetupPage = null;
	public FluentAssert fluentAssert = null;
	public AutoUtilities utils = null;
	public DummyPageWithLinks dummy = null;
	public PINAuthPage pinAuthPage = null;
	public PINReAuthPasswordPage pinReAuthPasswordPage = null;
	public ConfigPage configPage = null;
	public PINCustomKeypad pinCustomKeypad = null;
	public CommonPage common = null;
	public NavigationDrawPage navigationDrawPage = null;

	@BeforeClass
	public void initializeApp() {
		
		 utils = new AutoUtilities();
		// Autoutilites file path
		String JSONFilePath = "/TestData/TestData_Test.json";
		utils.loadTestData(JSONFilePath);
		
		// Initializing the fleuntAssert object for global use.
		fluentAssert = new FluentAssert();

		// Initializing the various pages of the app for use across all tests
		welcomePage = new WelcomePage(driver);
		loginPage = new LoginPage(driver);
		registrationPage = new RegistrationPage(driver);
		guestAccessPage = new GuestAccessPage(driver);
		pinSetupPage = new PINSetupPage(driver);
		dummy = new DummyPageWithLinks(driver);
		pinAuthPage = new PINAuthPage(driver);
		pinReAuthPasswordPage = new PINReAuthPasswordPage(driver);
		welcomePage = new WelcomePage(driver);
		configPage = new ConfigPage(driver);
		pinCustomKeypad = new PINCustomKeypad(driver);
		common = new CommonPage(driver);
		navigationDrawPage = new NavigationDrawPage(driver);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeEachTest() throws Exception {
		welcomePage.launchApp();
		configPage.dismissConfigPage();
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterEachTest() throws Exception {
		welcomePage.closeApp();
	}
	
	public void loginToApp() {
		loginPage.enterLoginCredentials(utils.readTestData("loginCredentials", "validLoginCredentials", "login1", "login"), utils.readTestData("loginCredentials", "validLoginCredentials", "login1", "pwd"));
		loginPage.tapLoginButton();
	}
	
	/*
	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		try {
			welcomePage.clearAppData();			
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	}*/
}
