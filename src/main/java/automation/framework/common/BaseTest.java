/*
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * ~ Author: Anil Kumar Lekkalapudi Email : sirianil@gmail.com Intro : This is a Java based mobile
 * automation framework built using Appium/TestNG.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * ~
 */

package automation.framework.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	// The InitAppium class has the required Appium initialization
	@SuppressWarnings("rawtypes")
	public static AppiumDriver driver = null;
	
	//public AppiumServiceBuilder service;
	private AppiumDriverLocalService service = null;
	private String AppiumNodeFilePath = "/usr/local/bin/node";
	private String AppiumJavaScriptServerFile = "/usr/local/lib/node_modules/appium/build/lib/main.js";
	private File app = null;
	
	@BeforeSuite(alwaysRun = true)
	public void setup() throws IOException, InterruptedException {

		// Start the Appium Server
		//stopAppiumServer();
		//startAppiumServer();

		// Pick the app and Companion App
		app = selectApp();
		
		// Provide Capabilities for Appium session
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Samsung");
		capabilities.setCapability("automationName", "UIAutomator2");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "au.com.suncorp.marketplace");
		capabilities.setCapability("appWaitActivity", "*");
		capabilities.setCapability("udid", "FA79X1A02210");
		//capabilities.setCapability("fullReset", false);
		//capabilities.setCapability("noReset", true);
		//capabilities.setCapability("newCommandTimeout", 300);
		capabilities.setCapability("clearSystemFiles", true);
		this.driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
	}
	
	/**
	 * This method is used to start the Appium Server automatically with help of
	 * AppiumDriverLocalService and AppiumServiceBuilder classes which help in
	 * creating and starting a service by executing nodejs executable and Appium
	 * JavaScript server file main.js
	 * 
	 * @author Shanoj
	 * @param none
	 * @return void
	 */
	private void startAppiumServer() throws IOException, InterruptedException {

		System.out.println("Starting Appium Server ......");

		// Add .withArgument(GeneralServerFlag.LOG_LEVEL, "error")) to run
		// service in Error Log (By default it will run in Debug mode)
		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(AppiumNodeFilePath))
						.withAppiumJS(new File(AppiumJavaScriptServerFile)));

		// Start Appium service
		service.start();
		System.out.println("Appium Server Started !!");
	}

	/**
	 * This method is used to stop the Appium Server automatically,by stopping
	 * the service that was started by startAppiumServer method
	 * 
	 * @author Shanoj
	 * @param none
	 * @return void
	 */
	private void stopAppiumServer() throws IOException {
		try {
			service.stop();
			System.out.println("Appium Server is now Stopped!!");
		} catch (NullPointerException e) {
			System.out.println("Appium Server is already Stopped !!");
		}
	}

	// Select the app for automation testing
	private File selectApp() {
		File appDir = new File("resources");
		File app = null;
		File[] listOfFiles = appDir.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].getName().contains("Marketplace")) {
				app = listOfFiles[i];
				break;
			}

		}
		return app;
	}

	@AfterSuite(alwaysRun = true)
	private void teardown() throws IOException {
		driver.removeApp("au.com.suncorp.marketplace");
		//au.com.suncorp.suncorpgroup.marketplace
		driver.quit();
		//stopAppiumServer();
	}
}
