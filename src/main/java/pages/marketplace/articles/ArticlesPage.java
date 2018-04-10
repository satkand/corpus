package pages.marketplace.articles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class ArticlesPage extends BasePage{

	public ArticlesPage(AppiumDriver driver) {
		super(driver);

	}

	private By articleCarousel =	By.id("au.com.suncorp.marketplace:id/articleCarouselTitle");
	private By articleCarouselDesc = By.id("au.com.suncorp.marketplace:id/articleCarouselDescription");
	private By articleDesc = By.id("au.com.suncorp.marketplace:id/articleDescription");
	private By articleImage = By.id("au.com.suncorp.marketplace:id/articleImage");
	private By articleReadMoreBtn = By.id("au.com.suncorp.marketplace:id/articleReadMoreAction");
	private By articleTitle = By.id("au.com.suncorp.marketplace:id/articleTitle");

	private String articleCarouselId = "au.com.suncorp.marketplace:id/articleCarouselTitle";
	private String articleReadMoreBtnId = "au.com.suncorp.marketplace:id/articleReadMoreAction";
	private String articleCarouselScrollableViewId = "au.com.suncorp.marketplace:id/articleViewPager";

	public WebElement checkArticleImage() {
		return find(articleImage);
	}

	public WebElement checkArticleReadMoreBtn() {
		return find(articleReadMoreBtn);
	}

	public void tapArticleReadMoreBtn() {
		tapElement(articleReadMoreBtn);
	}

	public WebElement checkArticleTitle() {
		return find(articleTitle);
	}

	public String getArticleTitle() {
		return find(articleTitle).getText();
	}

	public WebElement checkArticleDesc() {
		return find(articleDesc);
	}

	public String getArticleDesc() {
		return find(articleDesc).getText();
	}

	public void swipeArticlesLeft(String articleTitle) {
		scrollHorizontallyToElement(articleTitle,"text",articleCarouselScrollableViewId);
	}

	public void swipeArticlesRight(String articleTitle) {
		scrollHorizontallyToElement(articleTitle,"text",articleCarouselScrollableViewId);
	}

	public WebElement checkArticleCarousel() {
		return find(articleCarousel,10);
	}

	public String getArticleCarouselText() {
		return getText(articleCarousel);
	}

	public void scrollToArticles() {

		scrollToElement(articleCarouselId,"id", 10);
		scrollToElement(articleReadMoreBtnId,"id", 10);
	}

	public WebElement checkArticleCarousalDescr() {
		return find(articleCarouselDesc);
	}

	public String getArticleCarousalDescr() {
		return find(articleCarouselDesc).getText();
	}


}
