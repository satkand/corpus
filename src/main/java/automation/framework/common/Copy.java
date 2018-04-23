package automation.framework.common;

public interface Copy {
    
	//ENTER CURRENT PIN PAGE
	public String PIN_LOCK_ALERT_MESSAGE = "Your PIN is currently locked. Please re-authenticate with your password to setup a new PIN.";
	public String REAUTHENTICATE_BUTTON_TEXT = "REAUTHENTICATE";
	public String INCORRECT_PIN_ERROR_MESSAGE= "Incorrect PIN, please try again.";
	
	//SETTINGS PAGE
	public String SETTINGS_TITLE_TEXT ="Settings";
	
	//Articles common
	public static final String ARTICLE_CAROUSEL_TITLE = "Articles";

	//VEHICLES PAGE
	public static final String VEHICLE_SERVICES_TITLE = "Vehicle Services at your finger tips";
	public static final String VEHICLE_SERVICES_DESCRIPTION = "Browse and access from a range of professional services for your vehicle or just buy one.";
	public static final String VEHICLE_SERVICES_BTN_TXT = "VEHICLE SERVICES";
	public static final String ARTICLE_CAROUSEL_DESC = "Learn more about how to make the most out of your property with these insightful articles.";

	//MemberLoginPage
	public String MOBILE_NUMBER_TIP ="Use 04XXXXXXXX format";
	
	//Reset Password
	public String RESET_PASSWORD_TITLE_TEXT = "Reset password";
	public String RESET_PASSWORD_DESCRIPTION_TEXT = "Enter the email associated with your Suncorp account. We'll email you a link to a page where you can easily create a new password.";
	public String RESET_PASSWORD_SHORT_EMAIL_ERROR = "Must be between 2 and 100 characters Please enter a valid email address";
	public String RESET_PASSWORD_INVALID_EMAIL_ERROR = "Please enter a valid email address";
	public String RESET_PASSWORD_EMPTY_EMAIL_ERROR = "Field is required";
	public String RESET_PASSWORD_LONG_EMAIL_ERROR = "Must be between 2 and 100 characters";
	public String RESET_PASSWORD_SNACKBAR_TEXT = "Wrong email or password. Please check and retry.";
	public String RESET_PASSWORD_SUCCESS_SNACKBAR_TEXT = "You will shortly receive an email with reset instructions.";
	public String RESET_PASSWORD_SUCCESS_SNACKBAR_BTN = "OPEN MAIL";
}
