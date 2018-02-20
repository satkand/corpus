package pages.marketplace.money;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class AccountDetails extends BasePage {

	public AccountDetails(AppiumDriver driver) {
		super(driver);
	}
	private By AccountDetailsPage=By.xpath("//android.widget.TextView[@text='Account Details']");
	private By AccountInfoButton=By.xpath("//android.widget.TextView[@text='Account Info']");
	
	private By backButton = MobileBy.AccessibilityId("Navigate up");
	private By lastaccount=By.xpath("//text[@text='55 PLUS INTEREST CARD']");
	
	public WebElement checkAccountDetailsPage() {
		return find(AccountDetailsPage,40);
	}
	public void scrollDown () {
		swipeScreen("down");
    }
	
	public String ScrollToText()
	{
		  int i = 0;
		  String lastaccounttext=null;
		    do{
		    	boolean isPresent = finds(lastaccount).size()==0;
		      	if(!(isPresent))
		      	   {
		      		lastaccounttext=getText(lastaccount);
		      		break;
		      	
		      		}
		      	else{
		      		scrollDown();
		    		finds(lastaccount);
		            }
		    i++;
		    
		    } while(i<3);
		    return lastaccounttext;
		}
		
		
	 public List<WebElement> checkAccountInfobutton() {
		return finds(AccountInfoButton);
		}
	public void tapAccountInfobutton() {
		 find(AccountInfoButton);
		 tapElement(AccountInfoButton);
		}

	public void tapBackButton() {
		tapElement(backButton);
	}

}
