package pages.marketplace.claimdetails;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class MakeAClaimPage extends BasePage {

	public MakeAClaimPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By policyDescriptionTitle = By.id("au.com.suncorp.marketplace:id/assetTitle");
	private By assetDescription = By.id("au.com.suncorp.marketplace:id/assetDescription");
	private By incidentDateLabel = By.id("au.com.suncorp.marketplace:id/incidentDateTitle");
	private By incidentDateField = By.id("au.com.suncorp.marketplace:id/incidentDateField");
	private By incidentDateFieldInputLayout = By.id("au.com.suncorp.marketplace:id/incidentDateInputLayout");
	private By startClaimButton = By.id("au.com.suncorp.marketplace:id/startClaim");
	private By navigateBackButton = MobileBy.AccessibilityId("Navigate up");
	private By registrationNumber = By.id("au.com.suncorp.marketplace:id/registrationNumber");
	private By datePickerHeaderYear = By.id("android:id/date_picker_header_year");
	private By datePickerHeaderDate = By.id("android:id/date_picker_header_date");
	private By monthView = By.id("android:id/month_view");
	private By firstday = MobileBy.AndroidUIAutomator(
			"new UiSelector().resourceId(\"android:id/month_view\").childSelector(new UiSelector().className(\"android.view.View\"))");
	private By prevButton = By.id("android:id/prev");
	private By nextButton = By.id("android:id/next");
	private By datePickerOkButton = By.id("android:id/button1");
	private By inLineErrorMsg = By.id("au.com.suncorp.marketplace:id/textinput_error");

	public String getPolicyDescriptionTitle() {

		return getText(policyDescriptionTitle);
	}

	public String getAssetDescriptionText() {

		return getText(assetDescription);
	}

	public String getRegistrationNumberText() {

		return getText(registrationNumber);
	}

	public WebElement checkIncidentDateField() {

		return find(incidentDateField);
	}

	public String getIncidentDateFieldText() {

		return getText(incidentDateField);
	}

	public String getIncidentDateFieldLabel() {

		return getText(incidentDateLabel);
	}

	public String getStartClaimButtonText() {

		return getText(startClaimButton);
	}

	public void tapStartClaimButton() {

		tapElement(startClaimButton);
	}

	public void tapNavigateBackButton() {

		tapElement(navigateBackButton);
	}

	public void tapIncidentDateFieldInputLayout() {

		tapElement(incidentDateFieldInputLayout);
	}

	public String getIncidentDateFieldInputText() {

		return getText(incidentDateFieldInputLayout);
	}

	public WebElement checkDatePickerHeaderYear() {

		return find(datePickerHeaderYear);
	}

	public WebElement checkDatePickerHeaderDate() {

		return find(datePickerHeaderDate);
	}

	public WebElement checkMonthView() {

		return find(monthView);
	}

	public void selectDate(String date) throws ParseException {
		
		String dateToClick = date.split("-")[0];
		int expectedMonth = Integer.parseInt(date.split("-")[1]);
		int expectedYear = Integer.parseInt(date.split("-")[2]);
		int currentYear = Integer.parseInt(getAttribute(firstday, "contentDescription").split(" ")[2]);
		int currentMonth = getMonth(getAttribute(firstday, "contentDescription").split(" ")[1]);
		
		for (int i = 0; i < 24; i++) {

			if (expectedYear > currentYear) {
				tapElement(nextButton);

			} else if (expectedYear < currentYear) {

				tapElement(prevButton);

			} else {

				break;
			}
			currentYear = Integer.parseInt(getAttribute(firstday, "contentDescription").split(" ")[2]);

		}

		if (expectedYear == currentYear) {

			for (int i = 0; i < 24; i++) {

				if (expectedMonth > currentMonth) {

					tapElement(nextButton);

				} else if (expectedMonth < currentMonth) {

					tapElement(prevButton);
				} else {

					break;
				}
				currentMonth = getMonth(getAttribute(firstday, "contentDescription").split(" ")[1]);
			}
		}

		
		tapElement(findByUIAutomator(dateToClick, "text"));

		tapElement(datePickerOkButton);

	}

	public void tapDatePickerOkButton() {

		tapElement(datePickerOkButton);

	}

	public String getInLineErrorMsgText() {

		return getText(inLineErrorMsg);
	}

	public int getMonth(String monthName) throws ParseException {

		Date date = new SimpleDateFormat("MMMMM").parse(monthName);

		Calendar cal = Calendar.getInstance();

		cal.setTime(date);

		return (cal.get(Calendar.MONTH) + 1);
	}

}
