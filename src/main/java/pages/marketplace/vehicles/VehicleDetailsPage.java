package pages.marketplace.vehicles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class VehicleDetailsPage extends BasePage {

	public VehicleDetailsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By vehicleDetailsPageTitle = By.xpath("//android.widget.TextView[@text='Vehicle Details']");
	private By backButton = MobileBy.AccessibilityId("Navigate up");
	
	public WebElement checkVehicleDetailsPageTitle() {
		return find(vehicleDetailsPageTitle);
	}
	
	public WebElement checkBackButton() {
		return find(backButton);
	}
	
	public void tapBackButton() {
		tapElement(backButton);
	}
}
