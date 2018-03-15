package test.marketplace.productCatalogue;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;
import pages.marketplace.productCatalogue.MyJSONParser;

public class PCHomePageTest extends App {


	
	@Test (groups = {"DMPM-52", "DMPM-1143", "DMPM-1146", "DMPM-1148", "DMPM-1154", "marketplace", "pin", "priority-minor"})
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
	
	@Test(groups = { })
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
			categories = productCatalogueHomePage.getCategories(brand);
			
			for(Object category : categories) {
				JSONObject categoryJSON = (JSONObject) category;
				Assert.assertNotNull(productCatalogueHomePage.findEle(categoryJSON.get("name").toString()), categoryJSON.get("name").toString() + " not shown" );

			}
		}
		
	}
	

	
	public void navigateToProductCatalogue() {
		Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapGuestAccessButton();
		Assert.assertNotNull(navigationMenu.checkSplitMenuIcon(),"Split menu icon not seen");
		navigationMenu.tapSplitMenuIcon();
		Assert.assertNotNull(navigationMenu.checkProductCatalogueItem(),"Product catalogue menu icon not seen");
		navigationMenu.tapProductCatalogueMenuItem();
	//	Assert.assertNotNull(pcHomePage.checkTitle(), "Product catalogue title is not shown");
	}
}
