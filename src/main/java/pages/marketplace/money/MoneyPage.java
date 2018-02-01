package pages.marketplace.money;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class MoneyPage extends BasePage {

	@SuppressWarnings("rawtypes")
	public MoneyPage(AppiumDriver driver) {
		super(driver);
	}

	private By moneyPage = By.id("au.com.suncorp.marketplace:id/moneyAccountsRecyclerView");

	
	public WebElement checkMoneyPage() {
		return find(moneyPage,40);
	}
	public void scrollDown() {
		swipeHorizontallyToLeft();
		swipeScreen("down");
	}
}
