package ro.ing.automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by razvan on 5/6/2016.
 */
public class CarduriSiConturiMainPage extends IngPageFactory{
    protected static Logger LOG = Logger.getLogger(CarduriSiConturiMainPage.class);

    @FindBy(xpath="*//*[@class='nav_left']//a[contains(text(),'ING Card Gold')]")
    WebElement ingCardGold;

    @FindBy(xpath="*//*[@id='teaser-group-2']//*[contains(text(),'ING Gold')][@href!='#']")
    WebElement ingCardGoldMain;

    public CarduriSiConturiMainPage(WebDriver driver) {
        super(driver);
    }

    public IngCardGold openIngCardGold(){
        ingCardGold.click();
        return PageFactory.initElements(currentDriver, IngCardGold.class);
    }
}
