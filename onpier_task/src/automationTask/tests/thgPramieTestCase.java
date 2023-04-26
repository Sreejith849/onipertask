package automationTask.tests;

import org.openqa.selenium.chrome.ChromeDriver;

import automationTask.resources.landing_page;
import automationTask.resources.payment_page;

import org.openqa.selenium.WebDriver;

public class thgPramieTestCase {

    private static WebDriver driver = null;
    public static void main(String[] args){

        driver = new ChromeDriver();

        landing_page.navigateToLandingPage(driver);
        landing_page.sleep(driver, 1000);

        // Goto vehicle classes section
        landing_page.headerMenuTextShouldBe(driver, "Fahrzeugklassen", 2);
        landing_page.clickMenuItem(driver, 2);
        landing_page.sctionTitleShouldBePresent(driver, "Fahrzeugklassen", 2);

        // verify that premium models are chaning based on vehicle classess
        landing_page.sectionContentClickable(driver, 2);
        landing_page.clickMenuItem(driver, 2);
        landing_page.sctionTitleShouldBePresent(driver, "Fahrzeugklassen", 2);
        landing_page.contentInPremiumModelShouldBe(driver, "Flex-Prämie", "360€", "Sie erhalten eine Prämienauszahlung von bis zu 360€, je nach aktuellem Marktwert des THG-Zertifikats.");

        //Navigate to Payment page
        landing_page.clickOnButton(driver, "Prämie beantragen");
        landing_page.sleep(driver, 5000);
        payment_page.uploadFilePageShouldBeLoaded(driver, "Fahrzeugschein hochladen");


        // Upload File
        payment_page.uploadFile(driver, "Fahrzeugschein Vorderseite hochladen");
        landing_page.sleep(driver, 5000);
        payment_page.uploadFile(driver, "Fahrzeugschein Rückseite hochladen");
        payment_page.clickOnButton(driver, "Weiter", 1);

        // payment Page
        landing_page.sleep(driver, 5000);
        payment_page.paymentDetailsPageShouldBeLoaded(driver, "Persönliche Daten eingeben");

        //Fill In Details and goto review page
        payment_page.selectPicklistFieldValue(driver, "Divers");
        payment_page.inputTextIntoField(driver, "Vorname", "Automation");
        payment_page.inputTextIntoField(driver, "Nachname", "Test");
        payment_page.inputTextIntoField(driver, "E-Mail-Adresse", "automation@test.com");
        payment_page.inputTextIntoField(driver, "Kontoinhaber", "Automation Test");
        payment_page.inputTextIntoField(driver, "IBAN", "z.B. DE45 7890 8965 5643 3454 00");
        payment_page.clickOnButton(driver, "Weiter", 2);

        //  review payment details
        payment_page.paymentDetailsPageShouldBeLoaded(driver, "Angaben überprüfen & THG-Prämie beantragen");
        payment_page.inputFieldValueShouldBe(driver, "Anrede:", "Divers");
        payment_page.inputFieldValueShouldBe(driver, "Vorname:", "Automation");
        payment_page.inputFieldValueShouldBe(driver, "Nachname:", "Test");
        payment_page.inputFieldValueShouldBe(driver, "E-Mail-Adresse:", "automation@test.com");
        payment_page.inputFieldValueShouldBe(driver, "Kontoinhaber:", "Automation Test");
        payment_page.inputFieldValueShouldBe(driver, "IBAN:", "ZBDE 4578 9089 6556 4334 5400");

        // check checkbox field and submit form
        payment_page.selectCheckBoxField(driver, 1);
        payment_page.selectCheckBoxField(driver, 2);
        payment_page.selectCheckBoxField(driver, 3);
        payment_page.clickOnButton(driver, "Jetzt Prämie beantragen", 1);

        // Wait for SuccessMessage
        landing_page.sleep(driver, 10000);
        payment_page.formSubmittionSuccessMessage(driver, "Ihre THG-Prämie wird beantragt.");

        // close browser
        landing_page.closeBrowser(driver);
    }
 
    
}
