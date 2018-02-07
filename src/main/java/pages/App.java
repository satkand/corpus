package pages;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import automation.framework.common.BaseTest;
import automation.framework.utils.AutoUtilities;
import automation.framework.utils.FluentAssert;
import pages.marketplace.auth.LoginPage;
import pages.marketplace.auth.PINAuthPage;
import pages.marketplace.auth.PINCustomKeypad;
import pages.marketplace.auth.PINReAuthPasswordPage;
import pages.marketplace.auth.PINSetupPage;
import pages.marketplace.auth.RegistrationPage;
import pages.marketplace.chatbot.ChatbotPage;
import pages.marketplace.common.CameraPage;
import pages.marketplace.common.CommonPage;
import pages.marketplace.common.ConfigPage;
import pages.marketplace.common.DummyPageWithLinks;
import pages.marketplace.common.LandingPage;
import pages.marketplace.common.NavigationMenuPage;
import pages.marketplace.common.WelcomePage;
import pages.marketplace.digitalVault.DigitalVaultPage;
import pages.marketplace.digitalVault.FolderViewPage;
import pages.marketplace.digitalVault.ImageViewPage;
import pages.marketplace.home.HomeJourneyPage;
import pages.marketplace.home.HomePropertyPage;
import pages.marketplace.vehicles.VehicleDetailsPage;
import pages.marketplace.vehicles.VehiclesPage;
import pages.marketplace.offers.OffersPage;
import pages.marketplace.wealth.FinancePage;
import pages.marketplace.wealth.SpendingsPage;

public class App extends BaseTest {
	public AutoUtilities utils = null;
	public FluentAssert fluentAssert = null;	
	public WelcomePage welcomePage = null;
	public LoginPage loginPage = null;
	public RegistrationPage registrationPage = null;
	public PINSetupPage pinSetupPage = null;
	public DummyPageWithLinks dummy = null;
	public PINAuthPage pinAuthPage = null;
	public PINReAuthPasswordPage pinReAuthPasswordPage = null;
	public ConfigPage configPage = null;
	public PINCustomKeypad pinCustomKeypad = null;
	public CommonPage common = null;
	public NavigationMenuPage navigationMenu = null;
	public LandingPage landingPage = null;
	public HomePropertyPage homePropertyPage = null;
	public HomeJourneyPage homeJourneyPage = null;
	public FinancePage financePage = null;
	public SpendingsPage spendingsPage = null;
	public VehiclesPage vehiclesPage = null;
	public VehicleDetailsPage vehicleDetailsPage = null;
	public ChatbotPage chatbotPage = null;
	protected OffersPage offersPage = null;
	public DigitalVaultPage digitalVaultPage = null;
	public FolderViewPage folderViewPage = null;
	public ImageViewPage imageViewPage = null;
	public CameraPage cameraPage = null;
			

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
		pinSetupPage = new PINSetupPage(driver);
		dummy = new DummyPageWithLinks(driver);
		pinAuthPage = new PINAuthPage(driver);
		pinReAuthPasswordPage = new PINReAuthPasswordPage(driver);
		welcomePage = new WelcomePage(driver);
		configPage = new ConfigPage(driver);
		pinCustomKeypad = new PINCustomKeypad(driver);
		common = new CommonPage(driver);
		navigationMenu = new NavigationMenuPage(driver);
		landingPage = new LandingPage(driver);
		homePropertyPage = new HomePropertyPage(driver);
		homeJourneyPage = new HomeJourneyPage(driver);
		financePage = new FinancePage(driver);
		spendingsPage = new SpendingsPage(driver);
		vehiclesPage = new VehiclesPage(driver);
		vehicleDetailsPage = new VehicleDetailsPage(driver);
		chatbotPage = new ChatbotPage(driver);
		offersPage = new OffersPage(driver);
		digitalVaultPage = new DigitalVaultPage(driver);
		folderViewPage = new FolderViewPage(driver);
		imageViewPage = new ImageViewPage(driver);
		cameraPage = new CameraPage(driver);
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
	
	public void loginToApp(String login, String pwd) {
		loginPage.enterLoginCredentials(login, pwd);
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
