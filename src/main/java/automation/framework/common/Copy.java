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

	//POLICY DETAILS PAGE
	public String POLICY_DETAILS_SCREEN_TITLE = "Policy Details";
	public String INSTALMENT_FREUENCY_MONTHLY_LABEL ="Monthly instalment";
	public String INSTALMENT_FREUENCY_QUARTERLY_LABEL ="Quarterly instalment";
	public String INSTALMENT_FREUENCY_HALF_YEARLY_LABEL ="Half-yearly instalment";
	public String INSTALMENT_FREUENCY_ANNUAL_LABEL ="Annual premium";
	public String PAYMENT_METHOD_LABEL ="Payment method";
	public String INSURED_AMOUNT_LABEL="Amount covered";
	public String COVER_TYPE_LABEL="Cover type";
	public String COVER_PERIOD_LABEL="Cover period";
	public String OPTIONAL_COVER_LABEL="Optional";
	public String INCLUDED_COVER_LABEL="Included";
	public String DISCOUNTS_LABEL="Discounts";
	//Risk Details Page
	public String PARKING_ADDRESS_LABEL="Parking address";
	public String ADDITIONAL_EXCESSES_DETAILS_LABEL="ADDITIONAL EXCESS DETAILS MAY APPLY";
	public String HIDE_ADDITIONAL_EXCESSES_LABEL="HIDE ADDITIONAL EXCESSES";
	public String POLICY_MAINTAINCE_ERROR_MESSAGE="Please come back and try again later.";
	public String POLICY_MAINTAINCE_TITLE="Policy under maintenance";
	
	//RENEW POLICY
	public String RENEW_POLICY_SCREEN_TITLE = "Renew Policy";
	
	//CLAIM DETAILS PAGE
	public String CLAIM_NUMBER_LABEL = "Claim number";
	public String WHAT_HAPPENED_LABEL = "What happened";
	public String ACCIDENT_TYPE_LABEL = "Accident type";
	public String EVENT_DATE_LABEL = "Event date";
	public String YOUR_EXCESS_TOTAL_LABEL = "Your total excess";
	public String YOUR_PAID_EXCESS_LABEL = "Your paid excess";
	public String PAID_BUTTON_LABEL = "PAID";
	public String PAID_EXCESS_LABEL = "Your paid excess";
	public String REFERENCE_NUMBER_LABEL = "Reference number";
	public String OUTSTANDING_EXCESS_TITLE_LABEL = "Your outstanding excess";
	public String EXCESS_RECIEVED_LABEL = "Your outstanding excess";
	public String EXCESS_TOTAL_EXCESS_LABEL = "Total excess";
	public String CHECK_CLAIM_UPDATES_LABEL="CHECK CLAIM UPDATES";
	public String DOWNLOAD_DOCUMENTS_LABEL="DOWNLOAD DOCUMENTS";
	public String UPLOAD_DOCUMENTS_LABEL="UPLOAD DOCUMENTS";
	public String CHECK_CLAIM_UPDATES_TITLE="Check claim updates";
	public String DOWNLOAD_DOCUMENTS_TITLE ="Download documents";
	public String VIEW_ITEMS_DAMAGED_AND_LOST_LABEL="VIEW ITEMS DAMAGED AND LOST";
	public String VIEW_ITEMS_DAMAGED_AND_LOST_TITLE="View items and lost";
	public String UPLOAD_DOCUMENTS_TITLE ="Upload documents";
	public String CLAIM_DETAILS_TITLE ="Active claim details";
	
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

	//MemberLoginPage
	public String MOBILE_NUMBER_TIP ="Use 04XXXXXXXX format";

}
