package test.marketplace.money;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class MoneyTest extends App {
	// scenario 1
	@Test(groups = { "DMP-2555", "marketplace", "Money", "priority-minor" })
	public void testMoneyTabNavigation() {
		navigateToMoneyScreen();
		Assert.assertNotNull(moneyPage.checkMoneyPage(), "Money Page displayed");
		try {
			captureScreenShots();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void navigateToMoneyScreen() {
		welcomePage.tapGuestAccessButton();
		Assert.assertNotNull(landingPage.checkMoneyTab(), " Money flow - Money tab not shown");
		landingPage.tapMoneyTab();

	}
	
	 private void captureScreenShots() throws IOException {
	       String folder_name="/Users/u203723/Desktop/screenshot";
	        File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        //Date format for screenshot file name
	        DateFormat df;
	        df=new  SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
	        //create dir with given folder name
	        new File(folder_name).mkdir();
	        //Setting file name
	        String file_name=df.format(new Date())+".png";
	        //copy screenshot file into screenshot folder.
	        FileUtils.copyFile(f, new File(folder_name + "/" + file_name));
	    }
}
