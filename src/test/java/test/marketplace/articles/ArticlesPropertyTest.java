package test.marketplace.articles;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import pages.App;

public class ArticlesPropertyTest extends App{

	/*
	 * Story DMPM 2697, Test cases covered are,
	 * DMPM-3074: Display articles.[Verify each article elements and validate the contents against test data]
	 * texts/title if applicable.
	 * NOTE: Oder of items in the carousel and Testdata.JSON should be same.
	 */	
	@TestDetails(story1 = "DMPM-2697:DMPM-3074")
	@Test (groups = {"marketplace", "Home property articles", "priority-minor"})
	public void testDisplayArticlesElements() {
		//Preconditions
		//1. Navigate to Home Property dimension and then to articles carousel.
		navigateToHomePropertyTab("guest");
		articlesPage.scrollToArticles();
		Assert.assertNotNull(articlesPage.checkArticleCarousel(), "Home Property Page - Articles is NOT Presnet");
		Assert.assertEquals(articlesPage.getArticleCarouselText(), Copy.ARTICLE_CAROUSEL_TITLE, "Home Property Page - Article text is DIFFERENT than expected");
		
		//Step 1: Verify each element of every article and then validate the content against the test data json
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
			articlesPage.scrollToArticles();
			Assert.assertNotNull(articlesPage.checkArticleCarousel(), "Home Property Page - Articles is NOT Presnet");
			
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
			articlesPage.scrollToArticles();
			
			//2. Navigate to a different tab [Dimension] from articles view
			landingPage.tapVehiclesTab();
			
			//Step 1: Navigate back to articles carousel of Home-Property dimension
			landingPage.tapPropertyTab();
			
			//Step 2: Verify each individual content in the Articles to ascertain that it is not refreshed.
			articlesPage.scrollToArticles();
			verifyArtilesNotRefreshed();		
			}
	

	/*
	 *Story DMPM 2697, Test case covered,
	 * DMPM-3077: Redirect user to an external url. [Verify each article Readmore and validate the external URL launched against test data]
	 * NOTE: Oder of items in the carousel and Testdata.JSON should be same.
	 */	
	@TestDetails(story1 = "DMPM-2697:DMPM-3077")
	@Test (groups = {"marketplace", "Home property articles", "priority-minor"})
	public void testDisplayArticlesCallToAction() throws InterruptedException {
			//Preconditions
			//1. Navigate to Home Property dimension and then to articles carousel.
			navigateToHomePropertyTab("guest");
			articlesPage.scrollToArticles();
			
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
		
		landingPage.tapPropertyTab();
		Assert.assertTrue(landingPage.ispropertyTabSelected(), "Home tab is not selected on landing page");
	}
	
	private void verifyCallToAction() throws InterruptedException {
		Assert.assertNotNull(articlesPage.checkArticleCarousel(), "Home Property Page - Articles is NOT Presnet");
		List<Object> list =  utils.readTestDataList("articlesCarousel", "property", "articleViewPager");
		JSONArray articlesArray = (JSONArray)list;
		String articleTitle = new String();
		String webViewUrl = new String();
		for(int i=0; i<articlesArray.size(); i++) {
			articleTitle = ((JSONObject)articlesArray.get(i)).get("articleTitle").toString();
			articlesPage.swipeArticlesLeft(articleTitle);
			webViewUrl = ((JSONObject)articlesArray.get(i)).get("webViewUrl").toString();
			Assert.assertNotNull(articlesPage.checkArticleTitle(), "Home Proeprty Page - Article Title is not shown as excpected.");
			Assert.assertNotNull(articlesPage.checkArticleReadMoreBtn(), "Home Proeprty Page - Article button is MISSING!");
			articlesPage.tapArticleReadMoreBtn();
			Assert.assertNotNull(webviewPage.checkWebviewBrowserUrl(),"Home Proeprty Page - Article's webview is not shown as excpected.");
			Assert.assertEquals(webviewPage.getWebviewBrowserUrl(),webViewUrl,"Home Proeprty Page - Article ReadMore page is not as expected.");
			webviewPage.tapWebviewCloseButton();
			Assert.assertNotNull(articlesPage.checkArticleTitle(), "Home Proeprty Page - Article Title is not shown as excpected.");
			Assert.assertEquals(articlesPage.getArticleTitle(), articleTitle, "Home Proeprty Page - Article title is not shown as expected.");
			
			}	
	}
	
	private void verifyArtilesNotRefreshed() {
		Assert.assertNotNull(articlesPage.checkArticleCarousel(), "Home Property Page - Articles is NOT Presnet");
		List<Object> list =  utils.readTestDataList("articlesCarousel", "property", "articleViewPager");
		JSONArray articlesArray = (JSONArray)list;
		String articleTitle = new String();
		String articleDesc = new String();
		for(int i=0; i<articlesArray.size(); i++) {
			articleTitle = ((JSONObject)articlesArray.get(i)).get("articleTitle").toString();
			articlesPage.swipeArticlesLeft(articleTitle);
			articleDesc = ((JSONObject)articlesArray.get(i)).get("articleDescription").toString();
			Assert.assertNotNull(articlesPage.checkArticleImage(), "Home Proeprty Page - Article image is MISSING!");
			Assert.assertNotNull(articlesPage.checkArticleTitle(), "Home Proeprty Page - Article Title is not shown as excpected.");
			Assert.assertNotNull(articlesPage.checkArticleDesc(), "Home Proeprty Page - Article description is not shown as expected.");
			Assert.assertEquals(articlesPage.getArticleTitle(), articleTitle, "Home Proeprty Page - Article title is not shown as expected.");
			Assert.assertEquals(articlesPage.getArticleDesc(), articleDesc, "Home Proeprty Page - Article description is not shown as expected.");
			Assert.assertNotNull(articlesPage.checkArticleReadMoreBtn(), "Home Proeprty Page - Read More button is MISSING!");
			
			}	
		
	}
	
	private void verifySwipeLeftAndRight() {
		List<Object> list =  utils.readTestDataList("articlesCarousel", "property", "articleViewPager");
		JSONArray articlesArray = (JSONArray)list;
		int articlesArraySize = articlesArray.size();
		if (articlesArraySize <= 1) {
			Reporter.log("There are too few articles to test swipe functionality", true);
		}
		else {
			String articleTitle = new String();
			for (int i = 0; i<articlesArray.size() ; i++) {
				articleTitle = ((JSONObject)articlesArray.get(i)).get("articleTitle").toString();
				articlesPage.swipeArticlesLeft(articleTitle);
				Assert.assertNotNull(articlesPage.checkArticleTitle(), "Home Proeprty Page - Next article swipe is not as excpected.");
				Assert.assertEquals(articlesPage.getArticleTitle(), articleTitle, "Home Proeprty Page - Article title is not shown as expected.");
				
				}
			
			for (int j = articlesArraySize-1; j>0 ; j--) {
				articleTitle = ((JSONObject)articlesArray.get(j-1)).get("articleTitle").toString();
				articlesPage.swipeArticlesRight(articleTitle);
				Assert.assertNotNull(articlesPage.checkArticleImage(), "Home Proeprty Page - Previous article swipe is not as excpected.");
				Assert.assertEquals(articlesPage.getArticleTitle(), articleTitle, "Home Proeprty Page - Article title is not shown as expected.");
				}
			}
		
	}
	
	private void verifyArticleCarousel() {
		List<Object> list =  utils.readTestDataList("articlesCarousel", "property", "articleViewPager");
		JSONArray articlesArray = (JSONArray)list;
		String articleTitle = new String();
		String articleDesc = new String();
		for(int i=0; i<articlesArray.size(); i++) {
			articleTitle = ((JSONObject)articlesArray.get(i)).get("articleTitle").toString();
			articlesPage.swipeArticlesLeft(articleTitle);
			articleDesc = ((JSONObject)articlesArray.get(i)).get("articleDescription").toString();
			Assert.assertNotNull(articlesPage.checkArticleImage(), "Home Proeprty Page - Article image is MISSING!");
			Assert.assertNotNull(articlesPage.checkArticleTitle(), "Home Proeprty Page - Article Title is not shown as excpected.");
			Assert.assertNotNull(articlesPage.checkArticleDesc(), "Home Proeprty Page - Article description is not shown as expected.");
			Assert.assertEquals(articlesPage.getArticleTitle(), articleTitle, "Home Proeprty Page - Article title is not shown as expected.");
			Assert.assertEquals(articlesPage.getArticleDesc(), articleDesc, "Home Proeprty Page - Article description is not shown as expected.");
			Assert.assertNotNull(articlesPage.checkArticleReadMoreBtn(), "Home Proeprty Page - Read More button is MISSING!");
			
			}	
		
	}
}
