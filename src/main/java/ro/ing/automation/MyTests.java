package ro.ing.automation;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ro.ing.automation.profiles.Chrome;
import ro.ing.automation.profiles.Firefox;
import ro.ing.automation.runner.MultiThreadRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MultiThreadRunner.class)
@ContextConfiguration(classes = Chrome.class, loader = AnnotationConfigContextLoader.class)
public class MyTests  {
    @Autowired
    WebDriver driver;

    protected static Logger LOG = Logger.getLogger(MyTests.class);

    @Test
    public void testOne(){
        LOG.debug("Go to ing home page");
        driver.get("http://www.ing.ro");
        LOG.debug("Create home page");
        IngHomePagePF ingHome = IngPageFactory.initElements(driver, IngHomePagePF.class);
        LOG.debug("Go to carduri si conturi");
        CarduriSiConturiMainPage cardsiCont = ingHome.goToPFPages("carduri si conturi");
        LOG.debug("Go to Ing Card Gold");
        IngCardGold ingCardG = cardsiCont.openIngCardGold();
        assertTrue("Not on the expected page", ingCardG.verifyProductHeader());
    }
}
