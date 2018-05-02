package automation.framework.common;

public interface Copy {
    
	//ENTER CURRENT PIN PAGE
	public String PIN_LOCK_ALERT_MESSAGE = "Your PIN is currently locked. Please re-authenticate with your password to setup a new PIN.";
	public String REAUTHENTICATE_BUTTON_TEXT = "REAUTHENTICATE";
	public String INCORRECT_PIN_ERROR_MESSAGE= "Incorrect PIN, please try again.";
	
	//SETTINGS PAGE
	public String SETTINGS_TITLE_TEXT ="Settings";

	//PROPERTYHUB PAGE
	public String PROPERTY_HUB_DESCRIPTION_HEADING ="Explore valuable insights on suburbs & properties";
	public String PROPERTY_HUB_DESCRIPTION ="Find your perfect property and save it as a favourite, or explore whats nearby.";
	public String PROPERTY_HUB_TITLE_TEXT ="Property Hub";
	public String PROPERTY_HUB_SEARCH_HINT = "Search address";
	
	//PROPERTY DETAILS PAGE
	public String PROPERTY_DETAILS_THIS_IS_MY_PROPERTY_LABEL ="This is my property";
	public String PROPERTY_DETAILS_BOTTOM_SHEET_TITLE ="My property";
	public String PROPERTY_DETAILS_OWNER_OCCUPIER_BUTTON_TEXT ="Owner/Occupier";
	public String PROPERTY_DETAILS_RENTER_BUTTON_TEXT = "Renter";
	public String PROPERTY_DETAILS_LANDLORD_BUTTON_TEXT = "Landlord";

	//HOME PROFESSIONAL SERVICES IN PROPERTY HUB
	public String PROPERTY_HUB_HOME_PROFESSIONAL_SERVICES_TITLE ="Home maintenance services";
	public String PROPERTY_HUB_HOME_PROFESSIONAL_SERVICES_DESCRIPTION ="Access Suncorp accredited list of vendors for regular home maintenance jobs.";
	public String PROPERTY_HUB_HOME_PROFESSIONAL_SERVICES_URL ="https://www.suncorp.com.au/banking/loans/home-loans/home-buying-guide/home-inspection-plus.html";
	
	//PROFESSIONAL SERVICES FROM NAVIGATION MENU
	public String HOME_PROFESSIONAL_SERVICES_INTRO_TITLE ="Professional services";
	public String HOME_PROFESSIONAL_SERVICES_INTRO_DESCRIPTION ="Access a range of professional services for your property.";
	public String HOME_PROFESSIONAL_SERVICES_URL ="https://www.suncorp.com.au/banking/loans/home-loans/home-buying-guide/home-inspection-plus.html";
	
	//FORCE UPDATE SCREEN
	public String FORCEUPDATE_INTRO_HEADING_TEXT ="New app version available";
	public String FORCEUPDATE_DESCRIPTION ="Please update the app to the latest version to access your account";
	

	//FULL SCREEN MAPMAP POINTS OF INTEREST INDICATORS
	public String FULL_SCREEN_MAP_EDUCATION_CENTRE_INDICATOR = "NorthanMelbourneInstituteOfTAFE. ";
	public String FULL_SCREEN_MAP_SHOPPING_AMENITY_INDICATOR = "Penny Blue. ";
	public String FULL_SCREEN_MAP_TRANSPORT_AMENITY_INDICATOR = "Elizabeth St. ";
	public String FULL_SCREEN_MAP_ENTERTAINMENTOUTLET_INDICATOR = "Federal Coffee Palace. ";
	public String FULL_SCREEN_MAP_HEALTH_CENTRE_INDICATOR = "Derma Tech Centre. ";
	public String FULL_SCREEN_MAP_DINING_CENTRE_INDICATOR = "secret garden restraunt. ";
	public String FULL_SCREEN_MAP_OTHER_AMENITY_INDICATOR= "Coomonwealth bank Niddrie. ";
	
	//VIRTUAL ASSETS
	public String VIRTUAL_ASSETS_TITLE_TEXT ="Your saved properties";
	public String VIRTUAL_ASSETS_ESTIMATED_SALES_PRICE_LABEL = "Estimated sale price";
	public String VIRTUAL_ASSETS_ESTIMATED_SALE_PRICE ="$10,000,000 - $20,000,000";
	public String VIRTUAL_ASSETS_PROPERTY_ADDRESS = "123 Sesame St, Melbourne Vic 3000";
	public String VIRTUAL_ASSETS_PROPERTY_NO_OF_BEDROOMS ="4";
	public String VIRTUAL_ASSETS_PROPERTY_NO_OF_BATHROOMS ="2";
	public String VIRTUAL_ASSETS_PROPERTY_NO_OF_PARKING_SPACES ="2";
	public String VIRTUAL_ASSETS_PROPERTY_LAND_SIZE="1000m²";

	//Articles common
	public static final String ARTICLE_CAROUSEL_TITLE = "Articles";

	//VEHICLES PAGE
	public static final String VEHICLE_SERVICES_TITLE = "Vehicle Services at your finger tips";
	public static final String VEHICLE_SERVICES_DESCRIPTION = "Browse and access from a range of professional services for your vehicle or just buy one.";
	public static final String VEHICLE_SERVICES_BTN_TXT = "VEHICLE SERVICES";
	public static final String ARTICLE_CAROUSEL_DESC = "Learn more about how to make the most out of your property with these insightful articles.";
	
	//WEB VIEW
	public static final String LOCATION_BAR_TEXT = "www.suncorp.com.au";
	


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
