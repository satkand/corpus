package automation.framework.common;

public interface Copy {
    
	// NAVIGATION MENU PAGE
	String NAV_MENU_WELCOME_MESSAGE = "Welcome back!";
	
	//ENTER CURRENT PIN PAGE
	String PIN_LOCK_ALERT_MESSAGE = "Your PIN is locked. Please set up a new one";
	String REAUTHENTICATE_BUTTON_TEXT = "REAUTHENTICATE";
	String INCORRECT_PIN_ERROR_MESSAGE= "Incorrect PIN, please try again.";
	String PIN_INSTRUCTION_MESSAGE = "Don't create a PIN that represents your name or date of birth as it puts your account at risk and increases your liability for unauthorised transactions.";
	String PIN_INSTRUCTION_TITLE = "Choose a PIN that's easy to remember, but not easy for others to guess.";
	//SETTINGS PAGE
	public String SETTINGS_TITLE_TEXT ="Settings";

	//PROPERTYHUB PAGE
	String PROPERTY_HUB_DESCRIPTION_HEADING ="Explore valuable insights on suburbs & properties";
	String PROPERTY_HUB_DESCRIPTION ="Find your perfect property and save it as a favourite, or explore whats nearby.";
	String PROPERTY_HUB_TITLE_TEXT ="Property Hub";
	String PROPERTY_HUB_SEARCH_HINT = "Search address";
	
	//PROPERTY DETAILS PAGE
	String PROPERTY_DETAILS_THIS_IS_MY_PROPERTY_LABEL ="This is my property";
	String PROPERTY_DETAILS_BOTTOM_SHEET_TITLE ="My property";
	String PROPERTY_DETAILS_OWNER_OCCUPIER_BUTTON_TEXT ="Owner/Occupier";
	String PROPERTY_DETAILS_RENTER_BUTTON_TEXT = "Renter";
	String PROPERTY_DETAILS_LANDLORD_BUTTON_TEXT = "Landlord";
	
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
	String FULL_SCREEN_MAP_EDUCATION_CENTRE_INDICATOR = "NorthanMelbourneInstituteOfTAFE. ";
	String FULL_SCREEN_MAP_SHOPPING_AMENITY_INDICATOR = "Penny Blue. ";
	String FULL_SCREEN_MAP_TRANSPORT_AMENITY_INDICATOR = "Elizabeth St. ";
	String FULL_SCREEN_MAP_ENTERTAINMENTOUTLET_INDICATOR = "Federal Coffee Palace. ";
	String FULL_SCREEN_MAP_HEALTH_CENTRE_INDICATOR = "Derma Tech Centre. ";
	String FULL_SCREEN_MAP_DINING_CENTRE_INDICATOR = "secret garden restraunt. ";
	String FULL_SCREEN_MAP_OTHER_AMENITY_INDICATOR= "Coomonwealth bank Niddrie. ";
	
	//VIRTUAL ASSETS
	String VIRTUAL_ASSETS_TITLE_TEXT ="Your saved properties";
	String VIRTUAL_ASSETS_ESTIMATED_SALES_PRICE_LABEL = "Estimated sale price";
	String VIRTUAL_ASSETS_ESTIMATED_SALE_PRICE ="$10,000,000 - $20,000,000";
	String VIRTUAL_ASSETS_PROPERTY_ADDRESS = "123 Sesame St, Melbourne Vic 3000";
	String VIRTUAL_ASSETS_PROPERTY_NO_OF_BEDROOMS ="4";
	String VIRTUAL_ASSETS_PROPERTY_NO_OF_BATHROOMS ="2";
	String VIRTUAL_ASSETS_PROPERTY_NO_OF_PARKING_SPACES ="2";
	String VIRTUAL_ASSETS_PROPERTY_LAND_SIZE="1000m²";

	//Articles common
	String ARTICLE_CAROUSEL_TITLE = "Articles";

	//VEHICLES PAGE
	public static final String VEHICLE_SERVICES_TITLE = "Vehicle Services at your finger tips";
	public static final String VEHICLE_SERVICES_DESCRIPTION = "Browse and access from a range of professional services for your vehicle or just buy one.";
	public static final String VEHICLE_SERVICES_BTN_TXT = "VEHICLE SERVICES";
	public static final String ARTICLE_CAROUSEL_DESC = "Learn more about how to make the most out of your property with these insightful articles.";
	
	//WEB VIEW
	public static final String LOCATION_BAR_TEXT = "www.suncorp.com.au";

	//SUBURB DETAILS PAGE
	public static final String SUBURB_DETAILS_RISK_AND_HAZARD_TITLE ="Risks & Hazards";
	public static final String SUBURB_DETAILS_RISK_AND_HAZARD_TEXT ="Ratings are indicative only and are based on national data";
	public static final String SUBURB_DETAILS_FLOOD_RISK_LABEL_TEXT ="Flood Risk";
	public static final String SUBURB_DETAILS_BUSH_FIRE_LABEL_TEXT="Bush Fire Risk";
	public static final String SUBURB_DETAILS_THIEF_RISK_LABEL_TAXT ="Theft Risk";
	public static final String SUBURB_DETAILS_DEMOGRAPHICS_TITLE_TEXT ="Demographics";
	public static final String SUBURB_DETAILS_DEMOGRAPHICS_TEXT ="Sourced from Australia Bureau of statistics. Data pack 2011";
	public static final String SUBURB_DETAILS_DISCLAIMER_LABEL_TEXT ="Disclaimer";

	
	//POLICY DETAILS PAGE
	String POLICY_DETAILS_SCREEN_TITLE = "Policy Details";
	String INSTALMENT_FREUENCY_MONTHLY_LABEL ="Monthly instalment";
	String INSTALMENT_FREUENCY_QUARTERLY_LABEL ="Quarterly instalment";
	String INSTALMENT_FREUENCY_HALF_YEARLY_LABEL ="Half-yearly instalment";
	String INSTALMENT_FREUENCY_ANNUAL_LABEL ="Annual premium";
	String PAYMENT_METHOD_LABEL ="Payment method";
	String INSURED_AMOUNT_LABEL="Amount covered";
	String COVER_TYPE_LABEL="Cover type";
	String COVER_PERIOD_LABEL="Cover period";
	String OPTIONAL_COVER_LABEL="Optional";
	String INCLUDED_COVER_LABEL="Included";
	String DISCOUNTS_LABEL="Discounts";
	//Risk Details Page
	String PARKING_ADDRESS_LABEL="Parking address";
	String ADDITIONAL_EXCESSES_DETAILS_LABEL="ADDITIONAL EXCESS DETAILS MAY APPLY";
	String HIDE_ADDITIONAL_EXCESSES_LABEL="HIDE ADDITIONAL EXCESSES";
	String POLICY_MAINTAINCE_ERROR_MESSAGE="Please come back and try again later.";
	String POLICY_MAINTAINCE_TITLE="Policy under maintenance";
	
	//RENEW POLICY
	String RENEW_POLICY_SCREEN_TITLE = "Renew Policy";
	
	//CLAIM DETAILS PAGE
	String CLAIM_NUMBER_LABEL = "Claim number";
	String WHAT_HAPPENED_LABEL = "What happened";
	String ACCIDENT_TYPE_LABEL = "Accident type";
	String EVENT_DATE_LABEL = "Event date";
	String YOUR_EXCESS_TOTAL_LABEL = "Your total excess";
	String YOUR_PAID_EXCESS_LABEL = "Your paid excess";
	String PAID_BUTTON_LABEL = "PAID";
	String PAID_EXCESS_LABEL = "Your paid excess";
	String REFERENCE_NUMBER_LABEL = "Reference number";
	String OUTSTANDING_EXCESS_TITLE_LABEL = "Your outstanding excess";
    String EXCESS_RECIEVED_LABEL = "Your outstanding excess";
	String EXCESS_TOTAL_EXCESS_LABEL = "Total excess";
	String CHECK_CLAIM_UPDATES_LABEL="CHECK CLAIM UPDATES";
	String DOWNLOAD_DOCUMENTS_LABEL="DOWNLOAD DOCUMENTS";
	String UPLOAD_DOCUMENTS_LABEL="UPLOAD DOCUMENTS";
	String CHECK_CLAIM_UPDATES_TITLE="Check claim updates";
	String DOWNLOAD_DOCUMENTS_TITLE ="Download documents";
	String VIEW_ITEMS_DAMAGED_AND_LOST_LABEL="VIEW ITEMS DAMAGED AND LOST";
	String VIEW_ITEMS_DAMAGED_AND_LOST_TITLE="View items and lost";
	String UPLOAD_DOCUMENTS_TITLE ="Upload documents";
	String CLAIM_DETAILS_TITLE ="Active claim details";
	
    //CLAIM INTRO PAGE
	String CLAIM_PREREQUISITE_TITLE = "Before starting a claim";
	String CLAIM_INSTRUCTION_FILE_LABEL = "Ensure everyone's safety before starting any claim - dial 000 if required";
	String CLAIM_INSTRUCTION_DOCS_LABEL = "Photograph detail about what happened on your phone";
	String CLAIM_INSTRUCTION_PEOPLE="Photograph or write down details of any other people involved";
	String CLAIM_INSTRUCTION_SUBMIT = "Submit to your Personal Archive section in Marketplace app name to assist your claim";
	
    //MAKE A CLAIM PAGE
	String INCIDENT_DATE_FIELD_LABEL = "When did the incident happen?";
	String START_CLAIM_BUTTON_LABEL = "START CLAIM";
	String INCIDENT_DATE_FIELD_INPUT_LABEL= "Select date";
	String EMPTY_DATE_ERROR_MSG = "Field is required";
	String FUTURE_DATE_ERROR_MSG = "Invalid date input.\nPlease ensure you've entered the correct date";


	// PORTFOLIO
	String AVAILABLE_BALANCE_LABEL = "Available balance";	
	String EMPTY_PORTFOLIO_SCREEN_DESCRIPTION = "Start adding your Suncorp products by tapping the button below";
	String ADD_SUPER_ACC_SPECIAL_CHARS_ERROR = "Can only contain numerical digits  Must be between 7 – 9 characters";
	String ADD_SUPER_ACC_MANDATORY_ERROR = "Field is required";
	String ADD_SUPER_ACC_LENGTH_ERROR = "Must be between 7 – 9 characters";
	

	//MEMBER LOGIN PAGE

	String MOBILE_NUMBER_TIP ="Use 04XXXXXXXX format";

	//RESET PASSWORD
	public String RESET_PASSWORD_TITLE_TEXT = "Reset password";
	public String RESET_PASSWORD_DESCRIPTION_TEXT = "Enter the email associated with your Suncorp account. We'll email you a link to a page where you can easily create a new password.";
	public String RESET_PASSWORD_SHORT_EMAIL_ERROR = "Must be between 2 and 100 characters Please enter a valid email address";
	public String RESET_PASSWORD_INVALID_EMAIL_ERROR = "Please enter a valid email address";
	public String RESET_PASSWORD_EMPTY_EMAIL_ERROR = "Field is required";
	public String RESET_PASSWORD_LONG_EMAIL_ERROR = "Must be between 2 and 100 characters";
	public String RESET_PASSWORD_SNACKBAR_TEXT = "Wrong email or password. Please check and retry.";
	public String RESET_PASSWORD_SUCCESS_SNACKBAR_TEXT = "You will shortly receive an email with reset instructions.";
	public String RESET_PASSWORD_SUCCESS_SNACKBAR_BTN = "OPEN MAIL";
<<<<<<< HEAD

=======
	
	//LOGIN PAGE
	public String LOGIN_INVALID_CREDENTIALS_SNACKBAR_TEXT = "Wrong email or password. Please check and retry.";
>>>>>>> origin/develop
}
