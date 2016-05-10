package ro.ing.automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by razvan on 5/6/2016.
 */
public class IngHomePagePF extends IngPageFactory{
    protected static Logger LOG = Logger.getLogger(IngHomePagePF.class);

    public IngHomePagePF(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="*//*[@class=\"nav\"]//a[contains(text(),'Carduri si Conturi')]")
    WebElement carduriSiConturi;

    @FindBy(xpath="*//*[@class=\"nav\"]//a[contains(text(),'Economii si Investitii')]")
    WebElement economiiSiInvestitii;


    public <T> T goToPFPages(String persFizicaArea){
        LOG.debug("Starting method goToPFPages");
        persFizicaArea = persFizicaArea.toLowerCase();
        switch (persFizicaArea){
            case "carduri si conturi":
                LOG.debug("Parameter is 'carduri si conturi'");
                carduriSiConturi.click();
                CarduriSiConturiMainPage carduriSiConturiMainPage = IngPageFactory.initElements(currentDriver, CarduriSiConturiMainPage.class);
                return (T) carduriSiConturiMainPage;
            case "economii si investitii":
                LOG.debug("Parameter is 'economii si investitii'");
                economiiSiInvestitii.click();
                EconomiiSiInvestitiiMainPage economiiSiInvestitiiMainPage = IngPageFactory.initElements(currentDriver, EconomiiSiInvestitiiMainPage.class);
                return (T) economiiSiInvestitiiMainPage;
//            case "credite":
//                return CrediteMainPage;
            default:
                System.out.println("Incorrect destination");
                return null;
        }

    }


}
