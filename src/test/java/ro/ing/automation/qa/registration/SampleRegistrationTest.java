package ro.ing.automation.qa.registration;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import ro.ing.automation.qa.pages.DemoQaRegistrationPage;
import ro.ing.automation.util.GenericTestCase;

/**
 * Created by Ovidiu Moscaliuc on 5/13/2016.
 */
public class SampleRegistrationTest extends GenericTestCase {

    protected static Logger LOG = Logger.getLogger(DemoQaRegistrationPage.class);

    @Test
    public void checkRegistrationFunctionalityTest()
    {
        DemoQaRegistrationPage demoRegistrationHome = new DemoQaRegistrationPage(driver);
        LOG.info("Test started with identifier :" +id);
        Assert.assertEquals("Registration", demoRegistrationHome.pageTitle.getText());
        LOG.info("Title validated");
        Assert.assertEquals("Registration Form", demoRegistrationHome.formHeader.getText());
        LOG.info("Form header validated");
        demoRegistrationHome.firstNameInput.sendKeys("testFirstName"+id);
        LOG.info("First name inputed");
        demoRegistrationHome.lastNameInput.sendKeys("testLastName"+id);
        LOG.info("Last name inputed");
        demoRegistrationHome.maritalStatusListRadio.get(0).click();
        LOG.info("Marital status selected");
        demoRegistrationHome.hobbyListCheckbox.get(0).click();
        LOG.info("Hobby list checked");
        demoRegistrationHome.selectCountry("Romania");
        LOG.info("Country selected");
        demoRegistrationHome.selectMonth("3");
        LOG.info("Month selected");
        demoRegistrationHome.selectDay("10");
        LOG.info("Day selected");
        demoRegistrationHome.selectYear("2014");
        LOG.info("Year selected");
        demoRegistrationHome.phoneNumberInput.sendKeys("0011"+id);
        LOG.info("Phone number filled");
        demoRegistrationHome.usernameInput.sendKeys("testUserName"+id);
        LOG.info("Username filled");
        demoRegistrationHome.emailInput.sendKeys("testUserName"+id+"@gmail.com");
        LOG.info("Email filled");
        demoRegistrationHome.aboutYourselfDescriptionTextarea.sendKeys("description"+id);
        LOG.info("Description filled");
        demoRegistrationHome.passwordInput.sendKeys("Password_123456"+id);
        LOG.info("Password selected");
        demoRegistrationHome.confirmPasswordInput.sendKeys("Password_123456"+id);
        LOG.info("Password confirmation selected");
        demoRegistrationHome.submitButton.click();
        Assert.assertEquals("Thank you for your registration",demoRegistrationHome.validationMessage.getText());
        LOG.info("Submit button pressed");
        LOG.info("Test with id " + id + " ended successfully");
    }
}
