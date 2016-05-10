package ro.ing.automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by razvan on 5/8/2016.
 */
public class IngCardGold extends  IngPageFactory{
    protected static Logger LOG = Logger.getLogger(IngCardGold.class);

    @FindBy(id= "product_header")
    WebElement product_header;

    public IngCardGold(WebDriver driver) {
        super(driver);
    }

    public boolean verifyProductHeader(){
        if(product_header.getText().contains("Optiunea ING Gold")){
            LOG.info("ING Gold has been found");
           return true;
        }
        LOG.error("Incorrect page; NOT Ing Gold");
        return false;
    }
}
