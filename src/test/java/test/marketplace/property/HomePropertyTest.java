package test.marketplace.property;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import automation.framework.common.BasePage;
import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import pages.App;

public class HomePropertyTest extends App {
	
	@Test (groups = {"DMPM-86", "DMPM-857", "marketplace", "Home buying journey", "priority-minor"})
	public void testHomePropertyPageElements() {
		navigateToHomePropertyTab("guest");
		
		homePropertyPage.scrollToJourneyBanner();
		Assert.assertNotNull(homePropertyPage.checkHomeJourneyBannerImage(), "Home Property Page - Home Journey Banner Image is not shown");
		Assert.assertEquals(homePropertyPage.getHomeJourneyBannerHeading(), utils.readTestData("copy", "homePropertyPage", "homeJourneyBannerHeading"), "Home Property Page - Home Journey Banner Heading text is not shown as expected");
		Assert.assertEquals(homePropertyPage.getHomeJourneyBannerDescription(), utils.readTestData("copy", "homePropertyPage", "homeJourneyBannerDescription"), "Home Property Page - Home Journey Banner Description text is not shown as expected");
		Assert.assertNotNull(homePropertyPage.checkStartYourJourneyButton(), "Home Property Page - Start your Journey button not shown on home tab");
	}
	
	// 86 - scenario
	// 503 - Scenario 1
	// navigating to home journey screen and again navigating back to home property screen
	@Test (groups = {"DMPM-86", "DMPM-893", "DMPM-503", "DMPM-971", "marketplace", "Home buying journey", "priority-minor"})
	public void testNavigatingToHomeJourneyScreen() {
		navigateToHomePropertyTab("guest");
		homePropertyPage.scrollToJourneyBanner();
		homePropertyPage.tapStartYourJourneyButton();
		Assert.assertNotNull(homeJourneyPage.checkHomeJourneyPageTitle(), "Home Journey Page - page title not shown");
		homeJourneyPage.tapBackButton();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
	}
	
	//Story 2627 - Scenario 1 (TC : DMPM-3504) and scenario 2 (TC: DMPM-3505)
	//Story 2620 - Scenario 2 (No Assets - Display my property assets - TC-DMPM-3548)
	// navigating to Property tap on add a property or policy button
	@Test (groups = {"DMPM-2627", "DMPM-3504","DMPM-3505","DMPM-2620","DMPM-3548", "marketplace", "Home buying journey", "priority-minor"})
	public void testAddAPropertyOrPolicy() {
		navigateToHomePropertyTab("noProperties");
		
		Assert.assertNull(homePropertyPage.checkaddressLineText(), "Home Property Page - Property Assets are displaying");
		Assert.assertNull(homePropertyPage.checksuburbText(), "Home Property Page - Property Assets are displaying");
		
		Assert.assertNotNull(homePropertyPage.checkAddAPropertyOrPolicyImage(), "Home Property Page - Image is not present in add property section");
		Assert.assertNotNull(homePropertyPage.checkAddAPropertyOrPolicyButton(), "Home Property Page - Add a Property or Policy button is not present");
		
		Assert.assertNotNull(homePropertyPage.checkPropertyInsightInfo(), "Home Property Page - Property insigh info is not present");
		Assert.assertEquals(homePropertyPage.getPropertyInsightInfo(), utils.readTestData("copy", "homePropertyPage", "propertyInsightInfo"), "Home Property Page - Property insight info is not shown as expected");
		
		Assert.assertNotNull(homePropertyPage.checkOrganiseDocumentsInfo(), "Home Property Page - Organise documents info is not present");
		Assert.assertEquals(homePropertyPage.getOrganiseDocumentsInfo(), utils.readTestData("copy", "homePropertyPage", "organiseDocumentsInfo"), "Home Property Page - Organise document info is not shown as expected");
		
		Assert.assertNotNull(homePropertyPage.checkAccessProfessionalInfo(), "Home Property Page - Access professional services and suburs info is not present");
		Assert.assertEquals(homePropertyPage.getAccessProfessionalInfo(), utils.readTestData("copy", "homePropertyPage", "accessProfessionalInfo"), "Home Property Page - Access Professional info is not shown as expected");
		
		homePropertyPage.tapAddAPropertyOrPolicyButton();
		Assert.assertNotNull(homePropertyPage.checkAddPropertyOrPolicyActionSheetTitle(), "Home Property Page - Add a property or Policy action sheet title is not present");
		Assert.assertEquals(homePropertyPage.getAddPropertyOrPolicyActionSheetTitle(), utils.readTestData("copy", "homePropertyPage", "addPropertyOrPolicyActionSheetTitle"), "Home Property Page - Property insight info is not shown as expected");
		Assert.assertNotNull(homePropertyPage.checkAddPolicyActionSheetButton(), "Home Property Page - Policy action sheet button is not present");
		Assert.assertNotNull(homePropertyPage.checkAddPropertyActionSheetButton(), "Home Property Page - Property action sheet button is not present");
		
		homePropertyPage.tapAddPolicyActionSheetButton();
		homePropertyPage.tapDeviceBackButton();
		Assert.assertNotNull(homePropertyPage.checkAddAPropertyOrPolicyButton(), "Home Property Page - Add a Property or Policy button is not present");
		
		homePropertyPage.tapAddAPropertyOrPolicyButton();
		homePropertyPage.tapAddPropertyActionSheetButton();
		homePropertyPage.tapDeviceBackButton();
		Assert.assertNotNull(homePropertyPage.checkAddAPropertyOrPolicyButton(), "Home Property Page - Add a Property or Policy button is not present");
		
		
	}
	
	//2646 - Scenario 1
	//2997 - scenario 1
	//2620 - scenario 1
	// navigating to Property tab and verify products
	@Test (groups = {"DMPM-2646", "DMPM-4037","DMPM-2997","DMPM-4014","DMPM-2620","DMPM-3541", "marketplace", "Home buying journey", "priority-minor"})
	public void testDisplayActiveProductsAssociatedWithAPropertyAsset() {
			
		navigateToHomePropertyTab("withProducts");

		Assert.assertNotNull(homePropertyPage.checkpropertyImage(), "Home Property Page - Property Asset image is not available");
		Assert.assertNotNull(homePropertyPage.checkaddressLineText(), "Home Property Page - Address Line is not present");
		Assert.assertNotNull(homePropertyPage.checksuburbText(), "Home Property Page - Suburb is not present");
		List<String> descriptionList = homePropertyPage.fetchProductDescriptionTextList();
		
		String addressLine = utils.readTestData("propertyDimension","propertyProducts","withProducts","addressLineText");
		String description1 = utils.readTestData("propertyDimension","propertyProducts","withProducts","productDescriptionText1");
		String description2 = utils.readTestData("propertyDimension","propertyProducts","withProducts","productDescriptionText2");
		String suburb = utils.readTestData("propertyDimension","propertyProducts","withProducts","suburbText");
					
		Assert.assertEquals(homePropertyPage.getaddressLineText(), addressLine, "Home Property Page - Address line is not shown as expected");
		Assert.assertEquals(homePropertyPage.getsuburbText(), suburb, "Home Property Page - Property suburb is not displayed as expected");
		Assert.assertEquals(descriptionList.get(0), description1, "Home Property Page - Property description1 is not displayed as expected");
		Assert.assertEquals(descriptionList.get(1), description2, "Home Property Page - Property description 2 is not displayed as expected");
				
		Assert.assertNotNull(homePropertyPage.checkactiveClaimTitle(), "Home Property Page - Active Claim status is not displaying");
		Assert.assertEquals(homePropertyPage.getactiveClaimTitle(),utils.readTestData("copy","homePropertyPage","activeClaim") , "Home Property Page - Active CLaim title is not displayed as expected");
		
	}
		
	//2646 - scenario 2 
	//2997 - scenario 2
	// navigating to Property tab and verify empty state for products
	@Test (groups = {"DMPM-2627","DMPM-4038","DMPM-2997","DMPM-4017", "marketplace", "Home buying journey", "priority-minor"})
	public void testDisplayEmptyStateForPropertyAsset() {
		
 		navigateToHomePropertyTab("withOutProducts");
		//enableFAPISettings();
		
		homePropertyPage.scrollToEmptyStatePropertyAsset();
		Assert.assertNotNull(homePropertyPage.checkaddressLineText(), "Home Property Page - Address Line is not present");
		Assert.assertNotNull(homePropertyPage.checksuburbText(), "Home Property Page - Suburb is not present");
		Assert.assertNull(homePropertyPage.checkproductDescriptionText(), "Home Property Page - Product Description is present");
		Assert.assertNull(homePropertyPage.checkactiveClaimTitle(), "Home Property Page - Active CLaime title is present");
		
		
	}
	
	//3799 - scenario 1 (TC-DMPM-3506)
	//2620 - scenario 3 (TC-DMPM-3549)
	//Add a property or policy (Guest Experience)
	@Test (groups = {"DMPM-2799","DMPM-3506","DMPM-2620","DMPM-3549", "marketplace", "Home buying journey", "priority-minor"})
	public void testAddPolicyGuestExperience() {
			
		navigateToHomePropertyTab("guest");
		Assert.assertNull(homePropertyPage.checkaddressLineText(), "Home Property Page - Property Assets are displaying for guest user");
		Assert.assertNull(homePropertyPage.checksuburbText(), "Home Property Page - Property Assets are displaying for guest user");
		
		homePropertyPage.tapAddAPropertyOrPolicyButton();
		Assert.assertNotNull(homePropertyPage.checkFeatureLockedMsgTitle(), "Home Property Page - Feature Locked Title is not present");
		Assert.assertEquals(homePropertyPage.getFeatureLockedMsgTitle(), utils.readTestData("copy", "homePropertyPage","featureLockedMsgTitle"), "Home Property Page - Feature Locked message title is different to the expected title");
			
		Assert.assertNotNull(homePropertyPage.checkFeatureLockedTextCopy(), "Home Property Page - Feature Locked message copy is not present");
		Assert.assertEquals(homePropertyPage.getFeatureLockedTextCopy(), utils.readTestData("copy", "homePropertyPage","featureLockedTextCopy"), "Home Property Page - Feature Locked message text is different to the expected message");
		
		Assert.assertNotNull(homePropertyPage.checkFeatureLockedMsgSignUpButton(), "Home Property Page - Sign Up button is not present");
		Assert.assertNotNull(homePropertyPage.checkFeatureLockedMsgLogInButton(), "Home Property Page - Log in button is not present");
			
	}
	
	
	//Story DMPM 2644, test cases covered are DMPM-3064.
	@TestDetails(story1 = "DMPM-2644:DMPM-3064")
	@Test (groups = {"DMPM-3064", "marketplace", "Home property pillar", "priority-minor"})
	public void testHomePropertyPillarBackGrndImg() {
		//Preconditions
		//1. Navigate to Home Property dimension.
		navigateToHomePropertyTab("guest");
		//Scroll to see property pillar background image element.
		homePropertyPage.scrollToArticlesReadMoreBtn();
		//DMPM-3064-verify property pillar background image.
		Assert.assertNotNull(homePropertyPage.checkPropertyPillarBackGrndImg(), "Home Property Page - Background image is NOT Present");
	}
	
	/*
	 * Story DMPM 2697, test cases covered are DMPM-3074.
	 * Story DMPM-4318, Test cases covered are DMPM-4316, DMPM-4290.
	 * NOTE: Oder of items in the carousel and Testdata.JSON should be same.
	 */	
	@TestDetails(story1 = "DMPM-2697:DMPM-3074", story2= "DMPM-4318:DMPM-4316,DMPM-4290")
	@Test (groups = {"marketplace", "Home property articles", "priority-minor"})
	public void testDisplayArticlesElements() {
		//Preconditions
		//1. Navigate to Home Property dimension and then to articles carousel.
		navigateToHomePropertyTab("guest");
		homePropertyPage.scrollToArticles();
		
		//DMPM-4316-verify Article carousel title.
		Assert.assertNotNull(homePropertyPage.checkArticleCarousel(), "Home Property Page - Articles is NOT Present");
		Assert.assertEquals(homePropertyPage.getArticleCarouselText(), utils.readTestData("copy", "articlesCarousel", "articleCarouselText"), "Home Property Page - Article carousel title is Not as expected!");
		
		//DMPM-4316-verify Article carousel description.
		Assert.assertNotNull(homePropertyPage.checkArticleCarousalDescr(), "Home Property Page - Articles description is NOT Present");
		Assert.assertEquals(homePropertyPage.verifyArticleCarousalDescr(), utils.readTestData("copy", "articlesCarousel", "articleCarouselDescription"), "Home Property Page - Articles description is NOT as expected!");
		
		homePropertyPage.scrollToArticles();
		
		//DMPM-4290 Step 1: Verify article properties present
		//DMPM-3074 Step 1: Verify each element of every article and then validate the content against the test data json
		verifyArticleCarousel();
		}
	
	/*
	 * Story DMPM 2697, Test cases covered are,
	 * DMPM-3075: Display next article [Verify each article elements and validate the contents against test data]
	 * DMPM-3076: Display previous article [Verify each article elements and validate the contents against test data]
	 * NOTE: Oder of items in the carousel and Testdata.JSON should be same.
	 */	
	@TestDetails(story1 = "DMPM-2697:DMPM-3075,DMPM-3706")
	@Test (groups = {"marketplace", "Home property articles", "priority-minor"})
	public void testDisplayArticlesPreviousElements() {
			//Preconditions
			//1. Navigate to Home Property dimension and then to articles carousel.
			navigateToHomePropertyTab("guest");
			homePropertyPage.scrollToArticles();
			Assert.assertNotNull(homePropertyPage.checkArticleCarousel(), "Home Property Page - Articles is NOT Presnet");
			
			//Step 1,2: Verify swiping carousel in forward order then repeat the same in backwards order.
			verifySwipeLeftAndRight();
			}
	
	
	/*
	 * Story DMPM 2697, Test case covered,
	 * DMPM-3085:Do not refresh articles displayed if the application has successfully loaded the content for the first time.
	 * NOTE: Oder of items in the carousel and Testdata.JSON should be same.
	 */	
	@TestDetails(story1 = "DMPM-2697:DMPM-3085")
	@Test (groups = {"marketplace", "Home property articles", "priority-minor"})
	public void testDisplayArticlesRefresh() {
			//Preconditions
			//1. Navigate to Home Property dimension and then to articles carousel.
			navigateToHomePropertyTab("guest");
			homePropertyPage.scrollToArticles();
			
			//2. Navigate to a different tab [Dimension] from articles view
			landingPage.tapVehiclesTab();
			
			//Step 1: Navigate back to articles carousel of Home-Property dimension
			landingPage.tapHomeTab();
			
			//Step 2: Verify each individual content in the Articles to ascertain that it is not refreshed.
			homePropertyPage.scrollToArticles();
			verifyArticlesNotRefreshed();
			}
	
	/*
	 *Story DMPM 2697, Test case covered,
	 * DMPM-3077: Redirect user to an external url. [Verify each article Readmore and validate the external URL launched against test data]
	 * NOTE: Oder of items in the carousel and Testdata.JSON should be same.
	 */
	@TestDetails(story1 = "DMPM-2697:DMPM-3077")
	@Test (groups = { "marketplace", "Home property articles", "priority-minor"})
	public void testDisplayArticlesCallToAction() throws InterruptedException {
			//Preconditions
			//1. Navigate to Home Property dimension and then to articles carousel.
			navigateToHomePropertyTab("guest");
			homePropertyPage.scrollToArticles();
			Assert.assertNotNull(homePropertyPage.checkArticleCarousel(), "Home Property Page - Articles is NOT Presnet");
			
			//Step 1: Verify Readmore button click and validate the external URL displayed against the test data json.
			verifyCallToAction();
			}

	
	private void navigateToHomePropertyTab(String loginType) {
		if(loginType.equals("withProducts")) {
			loginToApp(utils.readTestData("propertyDimension","propertyProducts","withProducts", "login"), utils.readTestData("propertyDimension", "propertyProducts","withProducts","pwd"));
		}else if(loginType.equals("noProperties")){
			loginToApp(utils.readTestData("propertyDimension","NoProperties", "login"), utils.readTestData("propertyDimension","NoProperties", "pwd"));
		}else if(loginType.equals("withOutProducts")){
			loginToApp(utils.readTestData("propertyDimension","propertyProducts","withOutProducts", "login"), utils.readTestData("propertyDimension","propertyProducts","withOutProducts", "pwd"));
		}else {
			welcomePage.tapGuestAccessButton();
		}
		

		landingPage.tapHomeTab();
		Assert.assertTrue(landingPage.isHomeTabSelected(), "Home tab is not selected on landing page");
		landingPage.tapPropertyTab();
		Assert.assertTrue(landingPage.ispropertyTabSelected(), "Home tab is not selected on landing page");
	}
	
	private void verifyCallToAction() {
		Assert.assertNotNull(homePropertyPage.checkArticleCarousel(), "Home Property Page - Articles is NOT Presnet");
		List<Object> list =  utils.readTestDataList("propertyDimension","articlesCarousel","articleViewPager");
		JSONArray articlesArray = (JSONArray)list;
		String articleTitle = new String();
		String webViewUrl = new String();
		for(int i=0; i<articlesArray.size(); i++) {
			articleTitle = ((JSONObject)articlesArray.get(i)).get("articleTitle").toString();
			homePropertyPage.swipeArticlesLeft(articleTitle);
			webViewUrl = ((JSONObject)articlesArray.get(i)).get("webViewUrl").toString();
			Assert.assertNotNull(homePropertyPage.checkArticleTitle(), "Home Proeprty Page - Article Title is not shown as excpected.");
			Assert.assertNotNull(homePropertyPage.checkArticleReadMoreBtn(), "Home Proeprty Page - Article button is MISSING!");
			homePropertyPage.tapArticleReadMoreBtn();
			Assert.assertNotNull(webviewPage.checkWebviewBrowserUrl(),"Home Proeprty Page - Article's webview is not shown as excpected.");
			Assert.assertEquals(webviewPage.getWebviewBrowserUrl(),webViewUrl,"Home Proeprty Page - Article ReadMore page is not as expected.");
			webviewPage.tapWebviewCloseButton();
			Assert.assertNotNull(homePropertyPage.checkArticleTitle(), "Home Proeprty Page - Article Title is not shown as excpected.");
			Assert.assertEquals(homePropertyPage.getArticleTitle(), articleTitle, "Home Proeprty Page - Article title is not shown as expected.");
			
			}	
	}
	
	private void verifyArticlesNotRefreshed() {
		Assert.assertNotNull(homePropertyPage.checkArticleCarousel(), "Home Property Page - Articles is NOT Presnet");
		List<Object> list =  utils.readTestDataList("propertyDimension","articlesCarousel","articleViewPager");
		JSONArray articlesArray = (JSONArray)list;
		String articleTitle = new String();
		String articleDesc = new String();
		for(int i=0; i<articlesArray.size(); i++) {
			articleTitle = ((JSONObject)articlesArray.get(i)).get("articleTitle").toString();
			homePropertyPage.swipeArticlesLeft(articleTitle);
			articleDesc = ((JSONObject)articlesArray.get(i)).get("articleDescription").toString();
			Assert.assertNotNull(homePropertyPage.checkArticleImage(), "Home Proeprty Page - Article image is MISSING!");
			Assert.assertNotNull(homePropertyPage.checkArticleTitle(), "Home Proeprty Page - Article Title is not shown as excpected.");
			Assert.assertNotNull(homePropertyPage.checkArticleDesc(), "Home Proeprty Page - Article description is not shown as expected.");
			Assert.assertEquals(homePropertyPage.getArticleTitle(), articleTitle, "Home Proeprty Page - Article title is not shown as expected.");
			Assert.assertEquals(homePropertyPage.getArticleDesc(), articleDesc, "Home Proeprty Page - Article description is not shown as expected.");
			Assert.assertNotNull(homePropertyPage.checkArticleReadMoreBtn(), "Home Proeprty Page - Read More button is MISSING!");
			
			}	
		
	}
	
	private void verifySwipeLeftAndRight() {
		List<Object> list =  utils.readTestDataList("propertyDimension","articlesCarousel","articleViewPager");
		JSONArray articlesArray = (JSONArray)list;
		int articlesArraySize = articlesArray.size();
		if (articlesArraySize <= 1) {
			Reporter.log("There are too few articles to test swipe functionality", true);
		}
		else {
			String articleTitle = new String();
			for (int i = 0; i<articlesArray.size() ; i++) {
				articleTitle = ((JSONObject)articlesArray.get(i)).get("articleTitle").toString();
				homePropertyPage.swipeArticlesLeft(articleTitle);
				Assert.assertNotNull(homePropertyPage.checkArticleTitle(), "Home Proeprty Page - Next article swipe is not as excpected.");
				Assert.assertEquals(homePropertyPage.getArticleTitle(), articleTitle, "Home Proeprty Page - Article title is not shown as expected.");
				
				}
			
			for (int j = articlesArraySize-1; j>0 ; j--) {
				articleTitle = ((JSONObject)articlesArray.get(j-1)).get("articleTitle").toString();
				homePropertyPage.swipeArticlesRight(articleTitle);
				Assert.assertNotNull(homePropertyPage.checkArticleImage(), "Home Proeprty Page - Previous article swipe is not as excpected.");
				Assert.assertEquals(homePropertyPage.getArticleTitle(), articleTitle, "Home Proeprty Page - Article title is not shown as expected.");
				}
			}
	}

	private void verifyArticleCarousel() {


		List<Object> list =  utils.readTestDataList("copy","articlesCarousel","articleViewPager");
		JSONArray articlesArray = (JSONArray)list;
		for(int i=0; i<articlesArray.size(); i++) {

			String articleTitle = ((JSONObject)articlesArray.get(i)).get("articleTitle").toString();
			homePropertyPage.swipeArticlesLeft();
			String articleDesc = ((JSONObject)articlesArray.get(i)).get("articleDescription").toString();

			//Verify background Image.
			Assert.assertNotNull(homePropertyPage.checkArticleImage(), "Home Proeprty Page - Article image is MISSING!");

			//Verify Article Title.
			Assert.assertNotNull(homePropertyPage.checkArticleTitle(), "Home Proeprty Page - Article Title is not as excpected.");
			Assert.assertEquals(homePropertyPage.getArticleTitle(), articleTitle, "Home Proeprty Page - Article title is not shown as expected.");

			//Verify Article description.
			Assert.assertNotNull(homePropertyPage.checkArticleDesc(), "Home Proeprty Page - Article description is not shown as expected.");
			Assert.assertEquals(homePropertyPage.getArticleDesc(), articleDesc, "Home Proeprty Page - Article description is not shown as expected.");

			//Verify Article Read More button.
			Assert.assertNotNull(homePropertyPage.checkArticleReadMoreBtn(), "Home Proeprty Page - Read More button is MISSING!");
		}	

	}

}
