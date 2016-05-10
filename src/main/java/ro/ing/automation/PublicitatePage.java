package ro.ing.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ro.ing.automation.IngPageFactory;

/**
 * Created by razvan on 5/10/2016.
 */
public class PublicitatePage extends IngPageFactory{

    public PublicitatePage(WebDriver driver) {
        super(driver);
    }

    public void verifyBanner(){
        System.out.println(currentDriver.getTitle());
    }
}
