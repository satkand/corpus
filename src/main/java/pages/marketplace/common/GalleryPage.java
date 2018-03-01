package pages.marketplace.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class GalleryPage extends BasePage{

	private By galleryTitle = By.xpath("//android.view.ViewGroup/android.widget.TextView");
	private By pictureFolder = By.xpath("//android.widget.RelativeLayout/android.widget.TextView[@text='Pictures']");
	private By firstPicture = By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']");
	
	public GalleryPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public void choosePicture() {
		tapPictureFolder();
		checkFirstPicture();
		tapFirstPicture();
	}
	
	public WebElement checkGalleryTitle() {
		return find(galleryTitle);
	}

	
	public void tapPictureFolder() {
		tapElement(pictureFolder);
	}
	
	public WebElement checkFirstPicture() {
		return find(firstPicture);
	}
	
	public void tapFirstPicture() {
		tapElement(firstPicture);
	}
}
