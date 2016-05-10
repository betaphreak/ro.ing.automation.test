package ro.ing.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by razvan on 5/9/2016.
 */
public class GooglePage extends  IngPageFactory{



    WebElement q;
    @FindBy(xpath="*//*[@id='fsl']//a[1]")
    WebElement pub;

    public GooglePage(WebDriver driver){
//        this.driver = driver;
        super(driver);
    }

    public void search(String s){
        q.sendKeys(s);
        q.submit();
    }

    public PublicitatePage goToPub(){
        pub.click();
        return IngPageFactory.initElements(currentDriver, PublicitatePage.class);
    }
}
