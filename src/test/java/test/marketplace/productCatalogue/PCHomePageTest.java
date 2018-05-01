package test.marketplace.productCatalogue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class PCHomePageTest extends App {

	@Test (groups = {})
	public void testBrandNames() {
		navigateToProductCatalogue();
		Assert.assertNotNull(productCatalogueHomePage.checkPCHomePageTitle(), "Product catalogue homepage title not shown");		
		Assert.assertNotNull(productCatalogueHomePage.checkAamiTab(), "AAMI tab not shown");
		Assert.assertNotNull(productCatalogueHomePage.checkApiaTab(), "APIA tab not shown");
		Assert.assertNotNull(productCatalogueHomePage.checkBingleTab(), "BINGLE tab not shown");
		Assert.assertNotNull(productCatalogueHomePage.checkGioTab(), "GIO tab not shown");
		productCatalogueHomePage.swipeToShannonsTab();	
		Assert.assertNotNull(productCatalogueHomePage.checkShannonsTab(), "SHANNONS tab not shown");
		Assert.assertNotNull(productCatalogueHomePage.checkSuncorpTab(), "Suncorp tab not shown");
	}
	
	//DMPM-1286 - Scenario 1, 2
	//DMPM-1283 - Scenario 1, 2
	//DMPM-1279 - Scenario 15
	//DMPM-1713 - Scenario 1,2
	//DMPM-1288 - Scenario 1
	//DMPM-2733 - Scenario 1,2,3
	@Test(groups = {"DMPM-1286", "DMPM-2017", "DMPM-2018" ,"DMPM-1283", "DMPM-2016", "DMPM-2043" ,"DMPM-1713",
			"DMPM-3386", "DMPM-3387" ,"DMPM-1288", "DMPM-3395" ,"marketplace", "product catalogue", "priority-minor"})
	public void testBrandCategories() {
		navigateToProductCatalogue();
		JSONArray categories = null;
		JSONArray brandList = productCatalogueHomePage.getBrandList();
		for(Object brand : brandList.toArray()) {

			switch (((JSONObject)brand).get("name").toString().toUpperCase()) {
				case "AAMI":
					productCatalogueHomePage.tapAamiTab();
					break;
				case "APIA":
					productCatalogueHomePage.tapApiaTab();
					break;
				case "BINGLE":
					productCatalogueHomePage.tapBingleTab();
					break;
				case "GIO":
					productCatalogueHomePage.tapGioTab();
					break;
				case "SHANNONS":
					productCatalogueHomePage.tapShannonsTab();
					break;
				case "SUNCORP":
					productCatalogueHomePage.tapSuncorpTab();
					break;
			}
			Assert.assertTrue(productCatalogueHomePage.verifyDescription(brand));
			
			categories = productCatalogueHomePage.getCategories(brand);
			
			for(Object category : categories) {
				JSONArray subCategories = null;
				JSONObject categoryJSON = (JSONObject) category;
				WebElement categoryElement = productCatalogueHomePage.findCategory(categoryJSON.get("name").toString());
				Assert.assertNotNull(categoryElement, categoryJSON.get("name").toString() + " not shown" );
				productCatalogueHomePage.tapObject(categoryElement);
				
				subCategories = productCatalogueHomePage.getSubCategories(categoryJSON);
				for(Object subCategory : subCategories) {
					JSONObject subCategoryJSON = (JSONObject) subCategory;
					WebElement subCategoryElement = productCatalogueHomePage.findSubCategory(subCategoryJSON.get("type").toString());
					String subCategoryName = subCategoryJSON.get("type").toString();
					System.out.println(subCategoryName);
					Assert.assertNotNull(subCategoryElement, subCategoryJSON.get("type").toString() + " not shown" );
					productCatalogueHomePage.tapObject(subCategoryElement);
					
					Assert.assertNotNull(productCatalogueHomePage.checkFactsHeader(), "Features header not present");
					Assert.assertTrue(productCatalogueHomePage.verifyFacts(subCategoryJSON), "All facts are not expected");
					Assert.assertTrue(productCatalogueHomePage.checkDisclaimer(subCategoryJSON), "Disclaimer not as expected");			
					Assert.assertNotNull(productCatalogueHomePage.checkDetailsButton(), "More details button not present");
					
					if( (((JSONObject) subCategoryJSON.get("quote")).get("quoteUrl").toString()).contentEquals("") &&
							(((JSONObject) subCategoryJSON.get("quote")).get("phoneNumber").toString()).contentEquals("")){
						Assert.assertNull(productCatalogueHomePage.checkQuoteButton(), "Quote button present");
					}else
						Assert.assertNotNull(productCatalogueHomePage.checkQuoteButton(), "Quote button not present");
					
					
	/*To be added when url's have to be verified	
	 * 			if(productCatalogueHomePage.checkQuoteButton() != null) {
						productCatalogueHomePage.tapQuoteButton();
						productCatalogueHomePage.switchToWebView();		
						System.out.println(productCatalogueHomePage.getURL());
						Assert.assertEquals(productCatalogueHomePage.getURL(), ((JSONObject) subCategoryJSON.get("quote")).get("quoteUrl").toString());
						productCatalogueHomePage.switchContextToApp();
						productCatalogueHomePage.tapCloseWebViewButton();
						Assert.assertNotNull(productCatalogueHomePage.checkProceedButton(),"Proceed button not present");
						productCatalogueHomePage.tapProceedButton();
 					}
					
					if(productCatalogueHomePage.checkDetailsButton() != null) {
						productCatalogueHomePage.tapDetailsButton();
						productCatalogueHomePage.switchToWebView();
						System.out.println(productCatalogueHomePage.getURL());
						Assert.assertEquals(productCatalogueHomePage.getURL(), subCategoryJSON.get("detailsUrl").toString());
						productCatalogueHomePage.switchContextToApp();
						productCatalogueHomePage.tapCloseWebViewButton();
 					}
 	*/
					productCatalogueHomePage.tapObject(subCategoryName);
				}
				common.goBack();
			}
		}
		
	}
	
	@Test (groups = {"DMPM-1873", "DMPM-2001","DMPM-2002", "marketplace", "portfolio", "priority-minor"})
	public void testBrandInfo(){
		navigateToProductCatalogue();
		productCatalogueHomePage.scrollDown();
		Assert.assertNull(productCatalogueHomePage.checkBrandInfo(), "Brand info is still shown");
	}
	
	public void navigateToProductCatalogue() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapGuestAccessButton();
		Assert.assertNotNull(navigationMenu.checkSplitMenuIcon(),"Split menu icon not seen");
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkProductCatalogueItem(),"Product catalogue menu icon not seen");
		navigationMenu.tapProductCatalogueMenuItem();
		Assert.assertNotNull(productCatalogueHomePage.checkPCHomePageTitle(), "Product catalogue homepage title not shown");		
	}
}
