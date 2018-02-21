package automation.framework.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
//import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.google.common.base.Function;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
//import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BasePage {
	
	protected AppiumDriver driver = null;
	
	public BasePage(AppiumDriver driver) {
		this.driver=driver;
	}
	
	public void launchApp() throws Exception {
		// Laucnh the app
		driver.launchApp();
	}
	
	public void closeApp() throws Exception {
		try {
			driver.closeApp();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * The find method is the most frequent used method. This method takes a
	 * fixed parameter:'element By locator' and optional integer argument for
	 * timeout In cases where we need to wait longer time for an element to
	 * load, we can pass the required timeout. ex. find(userName, 10) where 10
	 * seconds timeout is requested.
	 * 
	 * @param locator
	 * @param args
	 * @return webelement
	 */
	protected WebElement find(final By locator, int... args) {
		
		int timeout = (args.length > 0 ? args[0] : 15);
		try {
			FluentWait<AppiumDriver> wait = new FluentWait<AppiumDriver>(driver).withTimeout(timeout, TimeUnit.SECONDS)
					.pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(Exception.class)
					.ignoring(NoSuchElementException.class);

			WebElement webelement = wait.until(new Function<AppiumDriver, WebElement>() {
				public WebElement apply(AppiumDriver driver) {
					return driver.findElement(locator);
				}
			});
			return webelement;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return null;
		}
	}
	
	protected List<WebElement> finds(final By locator, int... args) {

		int timeout = (args.length > 0 ? args[0] : 15);
		List<WebElement> webelements = null;

		try {
			FluentWait<AppiumDriver> wait = new FluentWait<AppiumDriver>(driver).withTimeout(timeout, TimeUnit.SECONDS)
					.pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(Exception.class)
					.ignoring(NoSuchElementException.class);

			webelements = wait.until(new Function<AppiumDriver, List<WebElement>>() {
				public List<WebElement> apply(AppiumDriver driver) {
					return (List) driver.findElements(locator);
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return webelements;
	}

	/**
	 * Method to perform the Tap action on an element. Takes the By locator as
	 * parameter
	 * 
	 * @param locator
	 */
	protected void tapElement(By locator) {
		WebElement element = find(locator);
		element.click();
	}
	
	/**
	 * Type a value into an appropriate element by passing the value to be
	 * entered and the element locator
	 * 
	 * @param inputValue
	 * @param locator
	 */
	protected void typeValue(String inputValue, By locator) {
		find(locator).clear();
		find(locator).sendKeys(inputValue);
	}
	
	protected void clearValue(By locator) {
		find(locator).clear();
	}
	
	/**
	 * Method to find an element in the page. Takes string xpath as
	 * parameter
	 * 
	 * @param filename
	 */
	public String findElementInPage(String fileName) {
		return driver.findElementByXPath(fileName).getText();
	}
	
	protected void putAppInBackground() {
		Duration duration = Duration.ofMillis((long) 10);
		driver.runAppInBackground(duration);
	}
	
	protected void longPressOnAnElement(By locator) {

		TouchAction ta = new TouchAction(driver);
		ta.longPress(find(locator)).release().perform();
		
		/* [OR]
		TouchAction ta = new TouchAction(driver);
		int startX = find(locator).getLocation().getX();
		int startY = find(locator).getLocation().getY();
		int endX = startX + find(locator).getSize().getWidth();
		int endY = startY + find(locator).getSize().getHeight();
		ta.press(startX,startY).waitAction(Duration.ofMillis(10000)).moveTo(endX,endY).release().perform();	
		 */
	}
	
	protected void tapByOffsetFromStart(By locator, int offsetX, int offsetY) {
		TouchAction ta = new TouchAction(driver);
		ta.press(find(locator).getLocation().getX() + offsetX, find(locator).getLocation().getY() + offsetY).waitAction(Duration.ofMillis(4000)).release().perform();
	}
	
	protected void tapByOffsetFromEnd(By locator, int offsetX, int offsetY) {
		TouchAction ta = new TouchAction(driver);
		ta.press(find(locator).getLocation().getX() + find(locator).getSize().getWidth() + offsetX, find(locator).getLocation().getY() + offsetY).waitAction(Duration.ofMillis(4000)).release().perform();
	}
	
	protected void swipeHorizontally(By startElementLocator, By destElementLocator) {
		WebElement startElement = find(startElementLocator);
		WebElement destElement = find(destElementLocator);

		int startX = startElement.getLocation().getX();
		int y = startElement.getLocation().getY();
		int endX = destElement.getLocation().getX();
		swipeAction(startX, y, endX, y);
	}
	
	protected void swipeHorizontallyToRight() {
		int screenHeight = driver.manage().window().getSize().getHeight();
		int screenWidth = driver.manage().window().getSize().getWidth();
		swipeAction((int)(screenWidth*.02), (int)(screenHeight*.15), (int)(screenWidth*.9), (int)(screenHeight*.01));
		//swipeAction(19, 259, 995, 15);

	}
	
	protected void swipeHorizontallyToLeft() {
		int screenHeight = driver.manage().window().getSize().getHeight();
		int screenWidth = driver.manage().window().getSize().getWidth();
		swipeAction((int)(screenWidth*.9), (int)(screenHeight*.75), (int)(screenWidth*.02), (int)(screenHeight*.61));
		//swipeAction(995, 259, 15, 15);
	}
	
	private void swipeAction(int startX, int startY, int endX, int endY) {
		TouchAction ta = new TouchAction(driver);
		ta.press(startX,startY).waitAction(Duration.ofMillis(4000)).moveTo(endX,endY).release().perform();
	}
	
//	protected void swipeDown(){
//		int screenHeight = driver.manage().window().getSize().getHeight();
//		int screenWidth = driver.manage().window().getSize().getWidth();
//		swipeAction((int)(screenWidth*.9), (int)(screenHeight*.9), (int)(screenWidth*.5), (int)(screenHeight*.01));
//	}
	
	/**
	 * Method to simulate swipe action on the screen in desired direction
	 * 
	 * @param direction
	 */
	protected void swipeScreen(String direction) {

		int y = driver.manage().window().getSize().getHeight();
		int x = driver.manage().window().getSize().getWidth();

		try {
			switch (direction.toUpperCase()) {
			case "UP":
				// when navigating up, its opening the notifications bar. so
				// changing the startY value from 10 to 300
				swipeAction(x - 50, y - 250, x - 50, y - 80);
				break;
			case "DOWN":
				swipeAction(50, y - 80, 50, y - 700);
				break;
			case "LEFT":
				swipeAction(50, y / 2, x - 10, y / 2);
				break;
			case "RIGHT":
				swipeAction(x - 50, y / 2, 10, y - 10);
				break;

			default:
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException ix) {
			System.out.println("Invalid directioN: Valid parameters- UP/DOWN/LEFT/RIGHT");
		}

	}
	
	protected void closeNavigationMenuByTappingOut() {
		int screenHeight = driver.manage().window().getSize().getHeight();
		int screenWidth = driver.manage().window().getSize().getWidth();
		tapByCoordinates((int)(screenWidth*.9), (int)(screenHeight*.9));
	}
	
	private void tapByCoordinates(int x, int y) {
		(new TouchAction(driver)).tap(x, y).perform();
		//995, 1684
	}
	
	//############## iOS #########//
	/**
	 * Read the value attribute of the element
	 * 
	 * @param locator
	 */
	protected String readValue(By locator) {
		return  find(locator).getAttribute("value");
	}
	
	protected boolean isEnabled(By locator) {
		String text = find(locator).getAttribute("enabled");
		return Boolean.parseBoolean(text);
	}
	
	//####### Android #########//

	protected void selectElementFromDropdownBasedOnText(String textValue) {
		WebElement dropdownElement = null;
		try
		{
			dropdownElement = driver.findElement(
					MobileBy.AndroidUIAutomator(
							"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+ textValue +"\").instance(0))"
							)
					);
		}
		catch (NoSuchElementException e) {
			//Added because sometimes Android doesn't scroll all the way
			WebElement frame = driver.findElement(By.className("android.widget.ScrollView"));
			int startx = frame.getLocation().getX() + (frame.getSize().getWidth() / 2);
			int starty = frame.getLocation().getY() + ((int)((frame.getSize().getHeight()) *.8) - 5);
			int endx = startx;
			int endy = frame.getLocation().getY() + 100;
			for(int i=0; i< 5; i++) {
				swipeAction(startx, starty, endx, endy);
				By elementLocator = By.xpath("//android.widget.TextView[@text='"+textValue +"']");
				dropdownElement = find(elementLocator);
				if(dropdownElement != null) {
					break;
				}
			}		 
		}
		dropdownElement.click();
	}
	
	protected String getText(By locator) {
		return find(locator).getText();
	}
	
	protected List<String> getTextList(By locator) {
		List<WebElement> elements = finds(locator);
		List<String> textList = new ArrayList();
		for (WebElement element : elements) {
			textList.add(element.getText());
		}
		return textList;
	}
	
	protected boolean isSelected(By locator) {
		String text = find(locator).getAttribute("selected");
		return Boolean.parseBoolean(text);
	}
	
	protected boolean isClickable(By locator) {
		String text = find(locator).getAttribute("clickable");
		return Boolean.parseBoolean(text);
	}
	/**
	 * This method is used to hide the keyboard
	 * 
	 * @param none
	 * @return void
	 */
	protected void dismissKeyboard() {
		driver.hideKeyboard();
	}

	protected boolean isKeyboardPresent() {
		try {
			driver.hideKeyboard();
			return true;
		} catch(WebDriverException e) {
			return false;
		}
	}
	
	protected void navigateBack() {
		driver.navigate().back();
	}
	
	protected boolean isToggleEnabled(By locator) {
		 return Boolean.parseBoolean(find(locator).getAttribute("checked"));
	}

	
//	/**
//	 * This method is specifically to use when needed to set PIN in an app.
//	 * Using this sets pin very quickly.
//	 * 
//	 * @param pinValue
//	 */
//	protected void enterPin(String pinValue) {
//		driver.getKeyboard().sendKeys(pinValue);
//	}
//
//	protected void clearAnEntryInTextField() {
//		driver.getKeyboard().sendKeys(Keys.CLEAR);
//	}
//
//	protected void deleteAnEntryInTextField() {
//		driver.getKeyboard().sendKeys(Keys.DELETE);
//	}
	
	
	
	
	
	
	
//	
//	protected WebElement findElementByText(String text, int... args) {
//
//		int timeout = (args.length > 0 ? args[0] : 10);
//
//		By locator = By.id(text);
//		return find(locator, timeout);
//
//	}
//
//	protected WebElement findElementByValue(String text, int... args) {
//
//		int timeout = (args.length > 0 ? args[0] : 10);
//
//		String xpath = "//XCUIElementTypeStaticText[@value='" + text + "']";
//		By locator = By.xpath(xpath);
//		return find(locator, timeout);
//
//	}
//
//	/**
//	 * The find method is the most frequent used method. This method takes a
//	 * fixed parameter:'element By locator' and optional integer argument for
//	 * timeout In cases where we need to wait longer time for an element to
//	 * load, we can pass the required timeout. ex. find(userName, 10) where 10
//	 * seconds timeout is requested.
//	 * 
//	 * @param locator
//	 * @param args
//	 * @return webelement
//	 */
//	protected List<WebElement> finds(final By locator, int... args) {
//
//		int timeout = (args.length > 0 ? args[0] : 15);
//		List<WebElement> webelements = null;
//
//		try {
//			FluentWait<AppiumDriver> wait = new FluentWait<AppiumDriver>(driver).withTimeout(timeout, TimeUnit.SECONDS)
//					.pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(Exception.class)
//					.ignoring(NoSuchElementException.class);
//
//			webelements = wait.until(new Function<AppiumDriver, List<WebElement>>() {
//				public List<WebElement> apply(AppiumDriver driver) {
//					return (List) driver.findElements(locator);
//				}
//			});
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			// e.printStackTrace();
//		}
//
//		return webelements;
//
//	}
//
//
//
//	/**
//	 * Method to find multiple elements
//	 * 
//	 * @param locator
//	 */
//
//	protected List<WebElement> findElements(By locator) {
//		List<WebElement> webelements = driver.findElements(locator);
//		return webelements;
//
//	}
//
//	/**
//	 * This method performs swipe actions on a particular element when invoked
//	 * with the Element and direction to swipe. Typically used to swipe on date
//	 * picker, list picker in iOS etc
//	 * 
//	 * @param locator
//	 * @param direction
//	 */
//	protected void swipeElement(By locator, SwipeElementDirection direction) {
//		MobileElement element = (MobileElement) find(locator);
//		element.swipe(direction, 1000);
//	}
//
//	/**
//	 * Method to simulate swipe action on the screen in desired direction
//	 * 
//	 * @param direction
//	 */
//	protected void swipeScreen(String direction) {
//
//		int y = driver.manage().window().getSize().getHeight();
//		int x = driver.manage().window().getSize().getWidth();
//
//		try {
//			switch (direction.toUpperCase()) {
//			case "UP":
//				// when navigating up, its opening the notifications bar. so
//				// changing the startY value from 10 to 300
//				driver.swipe(x - 50, y - 250, x - 50, y - 80, 100);
//				break;
//			case "DOWN":
//				driver.swipe(50, y - 80, 50, y - 250, 100);
//				break;
//			case "LEFT":
//				driver.swipe(50, y / 2, x - 10, y / 2, 100);
//				break;
//			case "RIGHT":
//				driver.swipe(x - 50, y / 2, 10, y - 10, 100);
//				break;
//
//			default:
//				throw new IllegalArgumentException();
//			}
//		} catch (IllegalArgumentException ix) {
//			System.out.println("Invalid directioN: Valid parameters- UP/DOWN/LEFT/RIGHT");
//		}
//
//	}
//
//	protected swipeTo(WebElement element) {
//
//		scrollToWebElement(element);
//	}
//

//

//
//	/**
//	 * Method to start the app
//	 */
//	protected void startApp() {
//		driver.launchApp();
//
//	}
//
//	/**
//	 * Method to close the app
//	 */
//	protected void closeApp() {
//		driver.closeApp();
//	}
//
//	/**
//	 * Method to restart the App. If appium server is configured with "full
//	 * reset" option then the App is reinstalled. This will kill the current
//	 * appium session and the test fails.
//	 */
//	protected void resetApp() {
//		driver.resetApp();
//	}
//
//	/**
//	 * Method to restart the App. If appium server is configured with "full
//	 * reset" option then the App is reinstalled. This will kill the current
//	 * appium session and the test fails.
//	 */
//	protected void restartApp() {
//
//		// Close the app
//		closeApp();
//
//		// Start the app
//		startApp();
//	}
//
//	protected void reInstallApp() {
//
//		// Close the app
	//au.com.suncorp.suncorpgroup.marketplace
//		driver.removeApp("com.outware.suncorp");
//
//		// Install the app
//		driver.installApp(app.getAbsolutePath());
//
//		// Start the app
//		startApp();
//	}
//
//	/**
//	 * Pass the locator of WebElement on which you want to perform the precise
//	 * single tap action. Typically used in situations like click on overlaid
//	 * video play buttons etc
//	 * 
//	 * @param locator
//	 */
//	protected void preciseTap(By locator) {
//		WebElement element = find(locator);
//		Point upperLeft = element.getLocation();
//
//		final double finalXLocation = upperLeft.getX() + 5;
//		final double finalYLocation = upperLeft.getY() + 5;
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("mobile: tap", new HashMap<String, Double>() {
//			{
//				put("tapCount", 1.0);
//				put("touchCount", 1.0);
//				put("duration", 1.0);
//				put("x", finalXLocation);
//				put("y", finalYLocation);
//			}
//		});
//	}
//
//	/**
//	 * This method takes a boolean parameter true/false. When user expects an
//	 * Alert then pass "true" as parameter else send "false" parameter
//	 * 
//	 * @param userExpectation
//	 * @throws NoAlertPresentException
//	 */
//	protected void verifyPopupExists(boolean userExpectation) throws NoAlertPresentException {
//		try {
//			driver.switchTo().alert();
//			Alert myAlert = driver.switchTo().alert();
//			String alertTxt = myAlert.getText();
//			if (userExpectation) {
//				Assert.assertTrue(userExpectation, "Popup dialog found with alert text :" + alertTxt);
//			} else {
//				Assert.assertTrue(!userExpectation, "No Popup is expected, but found one with alert text :" + alertTxt);
//			}
//
//		} catch (NoAlertPresentException noAlert) {
//			if (userExpectation) {
//				Assert.assertTrue(!userExpectation, "Popup is expected, but not found one");
//			} else {
//				Assert.assertFalse(userExpectation, "No Popup found as expected");
//			}
//		}
//	}
//
//	/**
//	 * Method to accept a Popup. Call verifyPopupExists method before calling
//	 * this method
//	 */
//	protected void acceptPopup() {
//		Alert myAlert = driver.switchTo().alert();
//		myAlert.accept();
//	}
//
//	/**
//	 * Method to read Popup Message. Call VerifyPopupExists method before
//	 * calling this method
//	 * 
//	 * @return
//	 */
//	protected String getPopupText() {
//		Alert myAlert = driver.switchTo().alert();
//		return myAlert.getText();
//	}
//
//	/*
//	 * If the field is not found on the visible part of the screen, then this
//	 * method scrolls through the whole screen and tries to find the element 1.
//	 * first finds the element on the current visible screen 2. If not found
//	 * then scrolls to the next part of the screen and tries to find the element
//	 * (This check is done as mostly the current element will be shown next to
//	 * the previous element and this might be on the start of next page of the
//	 * screen when we scroll) 3. If not found in the next part, then user
//	 * scrolls to the very top of the screen and tries to find the element 4. If
//	 * not found, then as the control is on the starting of the screen, we
//	 * scroll part by part on the screen till we reach the bottom (we will be
//	 * searching for the element on each part when we are scrolling)
//	 */
//	protected boolean assertField(By locator) {
//
//		boolean status = false;
//		WebElement element = find(locator);
//		// scrollToWebElement(element);
//		if (element != null)
//			status = true;
//
//		return status;
//	}
//
//	/*
//	 * To make sure that the screen has loaded, this method can be called by
//	 * passing the first element on the loading screen
//	 */
//	protected void waitFor(By locator, int... args) {
//		// int timeout = (args.length > 0 ? args[0] : 15);
//		// WebDriverWait wait = new WebDriverWait(driver, timeout);
//		// wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//		//
//		// // InitAppium.driver.manage().timeouts().implicitlyWait(200,
//		// // TimeUnit.SECONDS);
//	}
//
//	/**
//	 * This method is used to Tap on an element,by passing the WebElement
//	 * 
//	 * @author Shanoj
//	 * @param element,WebElement
//	 *            on which tap has to be performed
//	 * @return void
//	 */
//	protected void tapElement(WebElement element) {
//
//		element.click();
//	}
//

//
//	/**
//	 * This method is used to get the value of the specified attribute of a
//	 * WebElement
//	 * 
//	 * @author Shanoj
//	 * @param element,WebElement
//	 *            whose attribute value needs to be fetched attribute,The value
//	 *            of the specified attribute of the WebElement
//	 * @return String,The value of the specified attribute of the element
//	 */
//	protected String getAttribute(WebElement element, String attribute) {
//
//		String text = element.getAttribute(attribute);
//
//		return text;
//	}
//
//	/**
//	 * This method is used to get the value of the specified attribute of a
//	 * WebElement by passing the locator
//	 * 
//	 * @author Shanoj
//	 * @param locator,locator
//	 *            of the webelement whose attribute value needs to be fetched
//	 *            attribute,The value of the specified attribute of the
//	 *            WebElement
//	 * @return String,The value of the specified attribute of the element
//	 */
//	protected String getAttribute(By locator, String attribute) {
//
//		WebElement element = find(locator);
//		String text = element.getAttribute(attribute);
//		return text;
//	}
//
//	/**
//	 * This method clicks on an element that contains specified text,by building
//	 * a dynamic xpath
//	 * 
//	 * @author Shanoj
//	 * @param text,the
//	 *            text based on which the xpath this built to find the element
//	 * @return void
//	 */
//	protected void tapElementByText(String text) {
//
//		By locator = By.name(text);
//
//		tapElement(locator);
//
//	}
//
//	protected void tapElementByValue(String text) {
//
//		String xpath = "//XCUIElementTypeStaticText[@value='" + text + "']";
//
//		By locator = By.xpath(xpath);
//
//		tapElement(locator);
//
//	}
//
//	/**
//	 * This method clicks on an element that contains specified text,by building
//	 * a dynamic xpath for Radio Button
//	 * 
//	 * @author Sumit
//	 * @param String,the
//	 *            text based on which the xpath this built to find the element
//	 * @return void
//	 */
//	protected void tapElementByRadiobtnText(String text) {
//
//		String xpath = "//android.widget.RadioButton[@text='" + text + "']";
//		By locator = By.xpath(xpath);
//		tapElement(locator);
//	}
//
//	/**
//	 * This method is used to get the screen height
//	 * 
//	 * @author Shanoj
//	 * @param none
//	 * @return int
//	 */
//	protected int getScreenHeight() {
//
//		return driver.manage().window().getSize().getHeight();
//
//	}
//
//	/**
//	 * This method is used to get the screen width
//	 * 
//	 * @author Shanoj
//	 * @param none
//	 * @return int
//	 */
//
//	protected int getScreenWidth() {
//
//		return driver.manage().window().getSize().getWidth();
//
//	}
//
//	/**
//	 * This method is used to get the screen width
//	 * 
//	 * @author Shanoj
//	 * @param startx,starting
//	 *            x co-ordinate starty,starting y co-ordinate endx,ending x
//	 *            co-ordinate endy,ending y co-ordinate duration,amount of time
//	 *            in milliseconds for the entire swipe action to take
//	 * @return void
//	 */
//
//	protected void swipeScreen(int startx, int starty, int endx, int endy, int duration) {
//
//		try {
//
//			driver.swipe(startx, starty, endx, endy, duration);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//	/**
//	 * This method is used to clear the application data with the help of adb
//	 * command and package name of the application
//	 * 
//	 * @author Shanoj
//	 * @param apppackage,package
//	 *            name on the application under test
//	 * @return void
//	 */
//
//	protected void clearAppData() {
//		driver.resetApp();
//	}
//
//	/**
//	 * This method is used to check whether the keyboard is currently displayed
//	 * on the screen with the help of adb command
//	 * 
//	 * @author Shanoj
//	 * @param none
//	 * @return boolean
//	 */
//
//	protected boolean isKeyboardPresent() {
//
//		String status = null;
//
//		try {
//			String adbCmdOutput = null;
//
//			Runtime runtime = Runtime.getRuntime();
//			Process process = runtime.exec(new String[] { System.getenv("ANDROID_HOME") + "/platform-tools/adb",
//					"shell", "dumpsys", "input_method", "|", "grep", "mInputShown" });
//			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//			adbCmdOutput = reader.readLine().trim();
//			reader.close();
//			status = adbCmdOutput.split(" ")[3].split("=")[1];
//
//		}
//
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return status.equals("true");
//	}
//
//	/**
//	 * This method is used to tap on the screen based on the specified x and y
//	 * screen co-ordinates
//	 * 
//	 * @author Shanoj
//	 * @param x
//	 *            and y screen co-ordinates to be taped
//	 * @return void
//	 */
//
//	protected void tapElement(int start_x, int start_y) {
//
//		TouchAction touchAction = new TouchAction(driver);
//
//		touchAction.tap(start_x, start_y).perform();
//
//	}
//
//	/**
//	 * This method is used to press a key on the keybard
//	 * 
//	 * @author Shanoj
//	 * @param key,keycode
//	 *            of the corresponding key
//	 * @return void
//	 */
//
//	protected void pressEnterKey() {
//
//		driver.getKeyboard().pressKey(Keys.ENTER);
//
//	}
//

//
//	protected void scrollToElement(By locator) {
//		scrollToWebElement(find(locator));
//	}
//
//	protected WebElement scrollToElementByText(String text) {
//
//		WebElement element = find(By.xpath("//XCUIElementTypeStaticText[@value='" + text + "']"));
//
//		if (!element.isDisplayed()) {
//
//			driver.performTouchAction(new TouchAction(driver).press(0, 0).moveTo(element).release());
//		}
//
//		return element;
//	}
//
//	protected WebElement scrollToWebElement(By locator) {
//
//		WebElement element = find(locator);
//
//		if (!element.isDisplayed()) {
//
//			driver.performTouchAction(new TouchAction(driver).press(0, 0).moveTo(element).release());
//
//		}
//
//		return element;
//
//	}
//
//	protected WebElement scrollToWebElement(WebElement element) {
//
//		if (!element.isDisplayed()) {
//
//			driver.performTouchAction(new TouchAction(driver).press(0, 0).moveTo(element).release());
//
//		}
//
//		return element;
//
//	}
//
//	protected void swipeElement(String direction, By... args) {
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//		Map<String, Object> scrollObject = new HashMap<>();
//
//		scrollObject.put("direction", direction);
//
//		if (args.length > 0) {
//
//			WebElement element = find(args[0]);
//			scrollObject.put("element", ((RemoteWebElement) element).getId());
//		}
//
//		js.executeScript("mobile: swipe", scrollObject);
//
//	}
//	
//	protected void runApplicationInBackground(int time){
//		
//		driver.runAppInBackground(time);
//	}
	

}
