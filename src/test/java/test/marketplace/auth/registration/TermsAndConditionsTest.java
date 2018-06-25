package test.marketplace.auth.registration;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import pages.App;

public class TermsAndConditionsTest extends App {
private String titleValue;
//Registration flow dismiss button from Terms and condition for the Suncorp Accounts
@TestDetails(story1 = "DMPM-7121:DMPM-7245")
@Test(groups = { "marketplace", "TC", "priority-Critical" } ,priority=2)
public void testTerms_Condition_Dismiss_button_Suncorp() {
System.out.println("testTerms_Condition_Dismiss_button_Suncorp");
//Registration flow dismiss button for the Account : Suncorp bank
navigateToWelcomeToSuncorpPage();

getStartedPage.tapBrandSelectDropDown();
getStartedPage.tapSuncorpBrand();
getStartedPage.tapNextButton();
Assert.assertNotNull(getStartedPage.checkSuncorpAccountOptionsSheet(), "Get Started - Suncorp login options sheet not displayed");
getStartedPage.tapSuncorpBankingButton();
if(termsAndConditionsPage.checkAcceptButton() != null){
termsAndConditionsPage.tapCancelButton();
}
verifyToWelcomeToSuncorpPage();
// Registration flow dismiss button for the Account : Suncorp Insurance 
navigateToWelcomeToSuncorpPage();

getStartedPage.tapBrandSelectDropDown();
getStartedPage.tapSuncorpBrand();
getStartedPage.tapNextButton();
// verifying Suncorp Account dialogue box
verifySuncorpAccountOption();
getStartedPage.tapSuncorpInsuranceButton();
if(termsAndConditionsPage.checkAcceptButton() != null){
termsAndConditionsPage.tapCancelButton();
}
verifyToWelcomeToSuncorpPage();
//Registartion flow dismiss button for the Account : Both Account
navigateToWelcomeToSuncorpPage();

getStartedPage.tapBrandSelectDropDown();
getStartedPage.tapSuncorpBrand();
getStartedPage.tapNextButton();
verifySuncorpAccountOption();
getStartedPage.tapSuncorpBothButton();
if(termsAndConditionsPage.checkAcceptButton() != null){
termsAndConditionsPage.tapCancelButton();
}
verifyToWelcomeToSuncorpPage();
}
//Registration flow dismiss button from Terms and condition for the Brands AAMI,GIO and SHANNONS
@TestDetails(story1 = "DMPM-7121:DMPM-7245")
@Test(groups = { "marketplace", "TC", "priority-Critical" },priority=1)
public void testTerms_Condition_Dismiss_button() {
System.out.println("testTerms_Condition_Dismiss_button");
List brandElements = utils.readTestDataList("brands");
for(Object brandIcons : brandElements) {
if(welcomePage.checkWelcomeSuncorpImage() != null) {
navigateToWelcomeToSuncorpPage();
}
commonMemberLoginCheck(brandIcons);
}
navigateToWelcomeToSuncorpPage();
// Testing navigation to Suncorp login page
getStartedPage.tapBrandSelectDropDown();
Assert.assertNotNull(getStartedPage.checkSelectBrandAlert(), "Select Brand List - The alert is not displayed");
Assert.assertNotNull(getStartedPage.checkSuncorpBrandExists(), "Select Brand List - Suncorp brand is not displayed");
getStartedPage.tapSuncorpBrand();
getStartedPage.tapNextButton();
}
private void navigateToWelcomeToSuncorpPage() {
if(loginAuthPage.checkChangeAccountButton() != null) {
loginAuthPage.tapChangeAccountButton();
}
Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome Screen - User is not navigated to the welcome screen");;
welcomePage.tapRegisterButton();
Assert.assertNotNull(getStartedPage.checkGetStartedPageTitle(), "Get Started Page - User is not navigated to the get started screen");
}
public void verifyToWelcomeToSuncorpPage() {
Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome Screen - User is not navigated to the welcome screen");;
}
public void verifySuncorpAccountOption() {
// Verify accounts options sheet 
Assert.assertNotNull(getStartedPage.checkSuncorpAccountOptionsSheet(), "Welcome to Suncorp family - Suncorp accounts sheets not displayed");
}
private void commonMemberLoginCheck(Object brandIcons) {
HashMap<String, String> brandIcon = (HashMap<String, String>)brandIcons;
getStartedPage.tapBrandSelectDropDown();
Assert.assertNotNull(getStartedPage.checkSelectBrandAlert(), "Select Brand List - The alert is not displayed");
Assert.assertNotNull(getStartedPage.checkBrandExists(brandIcon.get("brandName")), "Select Brand List - "+brandIcon.get("brandName")+" not displayed");
getStartedPage.tapBrandFromList(brandIcon.get("brandName"));
getStartedPage.tapNextButton();
if(termsAndConditionsPage.checkAcceptButton() != null){
termsAndConditionsPage.tapCancelButton();
}
}
}