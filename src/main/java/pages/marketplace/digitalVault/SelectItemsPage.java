package pages.marketplace.digitalVault;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class SelectItemsPage extends BasePage {

	private By selectAllButton = By.id("au.com.suncorp.marketplace:id/selectAllHeaderText");
	private By deleteButton = By.id("au.com.suncorp.marketplace:id/deleteContentsOption");
	private By closeButton = By.id("Navigate up");
	private By itemsToBeDeleted = By.xpath("//android.widget.ImageView[@resource-id='au.com.suncorp.marketplace:id/documentItemSelector']");
	private By itemSelectedDisplay = By.xpath("//android.view.ViewGroup[@resource-id='au.com.suncorp.marketplace:id/suncorpToolbar']/android.widget.TextView");
	
	public SelectItemsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean selectAllItems() {
		List<WebElement> items = finds(itemsToBeDeleted);
		String numberOfItems = Integer.toString(items.size());
		for(WebElement item : items) {
			tapElement(item);
		}
		if(getText(itemSelectedDisplay).split(" ")[0].equalsIgnoreCase(numberOfItems)) {
			return true;
		}else
			return false;
	}

	public List<WebElement> getListOfItems() {
		return finds(itemsToBeDeleted);
		
	}
}
