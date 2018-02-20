package test.marketplace.money;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class AccountDetailsTest extends App{
	int counter=0;
	// scenario 1,Scenario 2 and Scenario 3
	@Test(groups = { "DMP-2605", "marketplace", "AccountDetails", "priority-minor" })
	public void testAccountDetailsElementandNavigation() {
		    navigateToMoneyScreen();
             getAccountDetails();
             AccountDetailsPage.ScrollToText();
             getAccountDetails();

        }

	private void navigateToMoneyScreen() {
		welcomePage.tapGuestAccessButton();
		Assert.assertNotNull(landingPage.checkMoneyTab(), " Money flow - Money tab not shown");
		landingPage.tapMoneyTab();
		Assert.assertNotNull(moneyPage.checkMoneyPage(), "Money Page displayed");
		
		}

	private void navigateToAccountDetailsScreen(String accountname) {
		 moneyPage.tapAccount(accountname);
		}
	 private void navigateToAccountInfoScreen() {
		    AccountDetailsPage.tapAccountInfobutton();
			
		}
	 
	 private void getAccountDetails()
	 { 
		  List<String>account=moneyPage.fetchAccountListtext();
				
 if(counter >0)
		 {
	    	 account.remove(0);
		 }
		     for(int i=0;i<account.size();i++)
				{   System.out.println(account.get(i)); 
		    	    navigateToAccountDetailsScreen(account.get(i));
			        Assert.assertNotNull(AccountDetailsPage.checkAccountDetailsPage(), "AccountDetails Page is not displayed");
					try {
						captureScreenShots("accountdetailsscreen");
					} catch (IOException e) {
						e.printStackTrace();
					}
					if(!(AccountDetailsPage.checkAccountInfobutton().isEmpty()))
					{
				       navigateToAccountInfoScreen();
					   Assert.assertNotNull(AccountInfoPage.checkAccountInfoPage(), "AccountInfo Page is not displayed");
					try {
						
						captureScreenShots("accountsinfoscreen");
					} catch (IOException e) {
						e.printStackTrace();
					}
					AccountInfoPage.tapBackButton();
					Assert.assertTrue(AccountDetailsPage.checkAccountDetailsPage().isDisplayed(), "Account Details Page is not displayed");
					}
					AccountDetailsPage.tapBackButton();
				    Assert.assertTrue(landingPage.isMoneyTabSelected(),"Money Tab is not selected");
				}
		     counter++;
		 }




	private void captureScreenShots(String Screenname) throws IOException {
		
		switch(Screenname)
		{
		case "accountdetailsscreen":
		String folder_name="/Users/u203707/Desktop/screenshot/AccountDetailsAOS";
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
		break;
	
		case "accountsinfoscreen":
			String folder_name1="/Users/u203707/Desktop/screenshot/AccountInfoAOS";
			File f1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//Date format for screenshot file name
			DateFormat df1;
			df1=new  SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
			//create dir with given folder name
			new File(folder_name1).mkdir();
			//Setting file name
			String file_name1=df1.format(new Date())+".png";
			//copy screenshot file into screenshot folder.
			FileUtils.copyFile(f1, new File(folder_name1 + "/" + file_name1));
			break;
			
		}
		
	}

}
