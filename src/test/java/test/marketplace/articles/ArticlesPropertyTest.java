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
	 * Story DMPM 2697, test cases covered are DMPM-3074.
	 * Story DMPM-4318, Test cases covered are DMPM-4316, DMPM-4290.
	 * NOTE: Oder of items in the carousel and Testdata.JSON should be same.
	 */	
	@TestDetails(story1 = "DMPM-2697:DMPM-3074",story2 = "DMPM-4318:DMPM-4316,DMPM-4290")
	@Test (groups = {"marketplace", "Home property articles", "priority-minor"})
	public void testDisplayArticlesElements() {
		List<Object> list =  utils.readTestDataList("articlesCarousel", "property", "articleViewPager");
		JSONArray articlesArray = (JSONArray)list;
		String articleTitle = new String();
		String articleDesc = new String();
		String carouselTitle = utils.readTestData("articlesCarousel", "property", "carouselTitle");
		String screenHeight = utils.readTestData("articlesCarousel", "property", "screenHeight");
		//Preconditions
		//1. Navigate to Home Property dimension and then to articles carousel.
		navigateToHomePropertyTab("articles");
		articlesPage.waitForLoadingIndicatorToDisappear();
		articlesPage.scrollToArticlesCarousel(screenHeight);
		if(articlesPage.checkArticleReadMoreBtn()==null) {
			articlesPage.scrollToArticlesReadMoreBtn(screenHeight);
		}
		//DMPM-4316-verify Article carousel title.
		Assert.assertNotNull(articlesPage.checkArticleCarousel(), "Home Property Page - Articles is NOT Presnet");
		Assert.assertEquals(articlesPage.getArticleCarouselText(), Copy.ARTICLE_CAROUSEL_TITLE, "Home Property Page - Article text is DIFFERENT than expected");
		
		//DMPM-4316-verify Article carousel description.
		Assert.assertNotNull(articlesPage.checkArticleCarousalDescr(), "Home Property Page - Articles description is NOT Present");
		Assert.assertEquals(articlesPage.getArticleCarousalDescr(),carouselTitle, "Home Property Page - Articles description is NOT as expected!");
		//DMPM-4290 Step 1: Verify article properties present
		//DMPM-3074 Step 1: Verify each element of every article and then validate the content against the test data json
		if(articlesPage.checkArticleReadMoreBtn()==null) {
		articlesPage.scrollToArticlesReadMoreBtn(screenHeight);
		}
		verifyArticleCarousel(articlesArray, articleTitle, articleDesc);
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
		    String screenHeight = utils.readTestData("articlesCarousel", "property", "screenHeight");
			//Preconditions
			//1. Navigate to Home Property dimension and then to articles carousel.
			navigateToHomePropertyTab("articles");
			articlesPage.waitForLoadingIndicatorToDisappear();
			articlesPage.scrollToArticlesCarousel(screenHeight);
			if(articlesPage.checkArticleReadMoreBtn()==null) {
				articlesPage.scrollToArticlesReadMoreBtn(screenHeight);
			}
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
			String screenHeight = utils.readTestData("articlesCarousel", "property", "screenHeight");
			//Preconditions
			//1. Navigate to Home Property dimension and then to articles carousel.
			navigateToHomePropertyTab("articles");
			articlesPage.scrollToArticlesCarousel(screenHeight);
			if(articlesPage.checkArticleReadMoreBtn()==null) {
				articlesPage.scrollToArticlesReadMoreBtn(screenHeight);
			}
			
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
			String screenHeight = utils.readTestData("articlesCarousel", "property", "screenHeight");
			//Preconditions
			//1. Navigate to Home Property dimension and then to articles carousel.
			navigateToHomePropertyTab("articles");
			articlesPage.checkArticleCarousel();
			if(articlesPage.checkArticleReadMoreBtn()==null) {
				articlesPage.scrollToArticlesReadMoreBtn(screenHeight);
				}
			
			//Step 1: Verify Readmore button click and validate the external URL displayed against the test data json.
			verifyCallToAction();
			}
	
	private void navigateToHomePropertyTab(String loginType) {
		if(loginType.equals("articles")) {
			loginToApp(utils.readTestData("articlesCarousel", "login"), utils.readTestData("articlesCarousel","pwd"));
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
		String url;
		boolean getUrl;
		for(int i=0; i<articlesArray.size(); i++) {
			articleTitle = ((JSONObject)articlesArray.get(i)).get("articleTitle").toString();
			articlesPage.swipeArticlesLeft(articleTitle);
			webViewUrl = ((JSONObject)articlesArray.get(i)).get("webViewUrl").toString();
			Assert.assertNotNull(articlesPage.checkArticleTitle(), "Home Proeprty Page - Article Title is not shown as excpected.");
			Assert.assertNotNull(articlesPage.checkArticleReadMoreBtn(), "Home Property Page - Article button is MISSING!");
			articlesPage.tapArticleReadMoreBtn();
			Assert.assertNotNull(webviewPage.checkWebviewBrowserUrl(),"Home Property Page - Article's webview is not shown as excpected.");
			url = webviewPage.getWebviewBrowserUrl();
			Assert.assertTrue(url.contains(webViewUrl),"Home Property Page - Article ReadMore page is not as expected.");
			webviewPage.tapWebviewChromeCloseButton();
			Assert.assertNotNull(articlesPage.checkArticleTitle(), "Home Property Page - Article Title is not shown as excpected.");
			Assert.assertEquals(articlesPage.getArticleTitle(), articleTitle, "Home Property Page - Article title is not shown as expected.");
			
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
			Assert.assertNotNull(articlesPage.checkArticleTitle(), "Home Proeprty Page - Article Title is not shown as excpected.");
			Assert.assertEquals(articlesPage.getArticleTitle(), articleTitle, "Home Proeprty Page - Article title is not shown as expected.");
			Assert.assertNotNull(articlesPage.checkArticleDesc(), "Home Proeprty Page - Article description is not shown as expected.");
			Assert.assertEquals(articlesPage.getArticleDesc(), articleDesc, "Home Proeprty Page - Article description is not shown as expected.");
			Assert.assertNotNull(articlesPage.checkArticleImage(), "Home Proeprty Page - Article image is MISSING!");
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
				Assert.assertNotNull(articlesPage.checkArticleTitle(), "Home Proeprty Page - Next article swipe is not as excpected.");
				articlesPage.swipeArticlesLeft(articleTitle);
				Assert.assertEquals(articlesPage.getArticleTitle(), articleTitle, "Home Proeprty Page - Article title is not shown as expected.");
				
				}
			
			for (int j = articlesArraySize-1; j>0 ; j--) {
				articleTitle = ((JSONObject)articlesArray.get(j-1)).get("articleTitle").toString();
				Assert.assertNotNull(articlesPage.checkArticleImage(), "Home Proeprty Page - Previous article swipe is not as excpected.");
				articlesPage.swipeArticlesRight(articleTitle);
				Assert.assertEquals(articlesPage.getArticleTitle(), articleTitle, "Home Proeprty Page - Article title is not shown as expected.");
				}
			}
		
	}
	
	private void verifyArticleCarousel(JSONArray articlesArray, String articleTitle, String articleDesc) {
		
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
