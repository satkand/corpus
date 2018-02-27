package pages.marketplace.auth.PIN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class PINCustomKeypad extends BasePage {

	public PINCustomKeypad(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By one = By.id("au.com.suncorp.marketplace:id/customKeypadButton1");
	private By two = By.id("au.com.suncorp.marketplace:id/customKeypadButton2");
	private By three = By.id("au.com.suncorp.marketplace:id/customKeypadButton3");	
	private By four = By.id("au.com.suncorp.marketplace:id/customKeypadButton4");
	private By five = By.id("au.com.suncorp.marketplace:id/customKeypadButton5");
	private By six = By.id("au.com.suncorp.marketplace:id/customKeypadButton6");
	private By seven = By.id("au.com.suncorp.marketplace:id/customKeypadButton7");
	private By eight = By.id("au.com.suncorp.marketplace:id/customKeypadButton8");
	private By nine = By.id("au.com.suncorp.marketplace:id/customKeypadButton9");
	private By zero = By.id("au.com.suncorp.marketplace:id/customKeypadButton0");
	private By deletePinEntry = By.id("au.com.suncorp.marketplace:id/customKeypadButtonBack");
	
	public WebElement checkDeletePinEntry() {
		return find(deletePinEntry);
	}
	
	public void tapPINEntry(char c) {
		int pinEntry = Character.getNumericValue(c);
		switch(pinEntry) {
		case 1: tapElement(one);
				break;
		case 2: tapElement(two);
				break;
		case 3: tapElement(three);
				break;
		case 4: tapElement(four);
				break;
		case 5: tapElement(five);
				break;
		case 6: tapElement(six);
				break;
		case 7: tapElement(seven);
				break;
		case 8: tapElement(eight);
				break;
		case 9: tapElement(nine);				
				break;
		case 0: tapElement(zero);				
				break;
		}
	}
	
}
