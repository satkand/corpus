package pages.marketplace.common;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class GalleryPage extends BasePage {

	private By galleryTitle = By.xpath("//android.view.ViewGroup/android.widget.TextView");
	private By pictureFolder = By.xpath("//android.widget.RelativeLayout/android.widget.TextView[@text='Pictures']");
	private By firstPicture = By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']");
	private By galleryCancelButton = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");

	private String galleryTitleGoogle = "Select a photo";
	private String galleryTitleSamsung = "Gallery";
	private String cameraFolderGoogle = "Camera";
	private String pictureFolderGoogle = "Pictures";
	private String picturesFolderSamsung = "PICTURES";
	private By firstPictureGoogleLG = MobileBy.AndroidUIAutomator(
			"new UiSelector().className(\"android.support.v7.widget.RecyclerView\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").index(1))");
	private By galleryView = MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(0)");
	private By firstThumbNail = MobileBy.AndroidUIAutomator(
			"new UiSelector().className(\"com.sec.samsung.gallery.glview.composeView.PositionControllerBase$ThumbObject\").instance(0)");
	private String cameraFolderTitleSamsung = "Camera";
	private By cameraFolder = By.id("com.sec.android.gallery3d:id/gl_root_view");


	public GalleryPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void choosePicture() {

		tapPictureFolder();
		checkFirstPicture();
		tapFirstPicture();
	}

	public void selectPicture() {

		if (getDeviceAttribute("deviceManufacturer").equals("samsung")) {

			choosePictureFromGallerySamsung();

		} else if (getDeviceAttribute("deviceManufacturer").equals("Google")
				|| getDeviceAttribute("deviceManufacturer").equals("LGE")) {

			checkGalleryTitleGoogleLG();
			tapPictureFolderGoogleLG();
			tapFirstPictureGoogleLG();
		}

	}

	public WebElement checkGalleryTitle() {

		return find(galleryTitle);
	}


	public WebElement checkGalleryCancelButton() {
		return find(galleryCancelButton);
	}
	

	public WebElement checkGalleryTitleGoogleLG() {

		return getScreenTitle(galleryTitleGoogle);

	}

	public WebElement checkGalleryTitleSamsung() {

		return getScreenTitle(galleryTitleSamsung);

	}

	public void tapPictureFolder() {
		tapElement(pictureFolder);
	}

	public void tapPictureFolderGoogleLG() {

		tapElement(findByUIAutomator(pictureFolderGoogle, "text"));
	}
	
	public void tapCameraFolderGoogleLG() {

		tapElement(findByUIAutomator(cameraFolderGoogle, "text"));
	}

	public void tapPictureFolderSamsung() {

		tapElement(findByUIAutomator(picturesFolderSamsung, "text"));
	}

	public void tapThumbnailSamsung() {

		tapElement(firstThumbNail);
	}

	public WebElement checkFirstPicture() {
		return find(firstPicture);
	}

	public WebElement checkCameraFolderTitle() {

		return findByUIAutomatorContains(cameraFolderTitleSamsung, "text");
	}

	public void tapFirstPicture() {

		tapElement(firstPicture);
	}

	
	public void tapGalleryCancelButton() {
		tapElement(galleryCancelButton);
	}
	

	public void tapFirstPictureSamsung() {

		tapByOffsetFromStart(find(galleryView), 120, 630);

	}

	public void tapFirstPictureGoogleLG() {
		tapElement(firstPictureGoogleLG);
	}

	public void choosePictureFromGallerySamsung() {

		if (getDeviceAttribute("deviceModel").equals("SM-G935F")) {
			checkGalleryTitleSamsung();
			tapThumbnailSamsung();
			checkCameraFolderTitle();
			tapThumbnailSamsung();

		} else {
			checkGalleryTitleSamsung();
			tapPictureFolderSamsung();
			tapFirstPictureSamsung();
		}

	}

}
