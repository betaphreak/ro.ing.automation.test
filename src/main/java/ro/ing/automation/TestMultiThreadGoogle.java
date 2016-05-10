package ro.ing.automation;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ro.ing.automation.profiles.Chrome;
import ro.ing.automation.runner.MultiThreadRunner;

/**
 * Created by razvan on 5/10/2016.
 */


@RunWith(MultiThreadRunner.class)
//    @RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Chrome.class, loader = AnnotationConfigContextLoader.class)
public class TestMultiThreadGoogle {
    @Autowired
    WebDriver driver;

    protected static Logger LOG = Logger.getLogger(ro.ing.automation.MyTests.class);

    @Test
    public void tesTwo(){
        GooglePage gp = IngPageFactory.initElements(driver, GooglePage.class);
        gp.getDriver().get("http://www.google.ro");
        PublicitatePage pub = gp.goToPub();
        pub.verifyBanner();
    }

    @Test
    public void testThree(){

        GooglePage gp = IngPageFactory.initElements(driver, GooglePage.class);
        gp.getDriver().get("http://www.google.ro");
        PublicitatePage pub = gp.goToPub();
        pub.verifyBanner();
    }
}

