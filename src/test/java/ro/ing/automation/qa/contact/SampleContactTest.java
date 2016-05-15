package ro.ing.automation.qa.contact;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import ro.ing.automation.qa.pages.DemoQaContactPage;
import ro.ing.automation.util.GenericTestCase;

/**
 * Created by Ovidiu Moscaliuc on 5/16/2016.
 */
public class SampleContactTest extends GenericTestCase {
    protected static Logger LOG = Logger.getLogger(DemoQaContactPage.class);

    @Test
    public void checkContactModuleWorks() {
        URL("http://demoqa.com/contact/");
        DemoQaContactPage demoQaContactPage = new DemoQaContactPage(driver);
        LOG.info("Test started with identifier :" + id);
        demoQaContactPage.nameInput.sendKeys("testName" + id);
        LOG.info("Name added successfully");
        demoQaContactPage.emailInput.sendKeys("testemail" + id +"@gmail.com");
        LOG.info("Email added successfully");
        demoQaContactPage.subjectInput.sendKeys("subject"+id);
        LOG.info("Subject adde successfully ");
        demoQaContactPage.messageInput.sendKeys("message"+id);
        LOG.info("Message added successfully");
        demoQaContactPage.sendButton.click();
        LOG.info("Send button pressed");
        Assert.assertEquals("Your message was sent successfully. Thanks.", demoQaContactPage.validationString.getText());
        LOG.info("Test with id " + id + " ended successfully");
    }
}
