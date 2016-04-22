package ro.ing.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ViewFlightsPage {

  @FindBy(css="h2.huge")
  private WebElement flightOriginToDestinationHeaderText;

  @FindBy(id="header-logo")
  private WebElement headerLogo;

  @FindBy(css=".ui-state-active time")
  private WebElement activeTabTimeText;

  WebDriver driver;

   public ViewFlightsPage(WebDriver driver) {
       this.driver = driver;
       PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
  }

  public String getFlightOriginToDestinationHeaderText(){
    return flightOriginToDestinationHeaderText.getText();
  }
  public void clickHeaderLogo(){
    headerLogo.click();
  }

  public String getActiveTabTimeText(){
    return activeTabTimeText.getText();
  }

}
