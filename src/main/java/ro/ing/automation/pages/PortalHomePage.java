package ro.ing.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class PortalHomePage {

        @FindBy(id="flightmanagerFlightsFormOrigin")
        private WebElement flightOriginTextField;

        @FindBy(css="ul#flightmanagerFlightsFormOriginPopupList li[aria-label*='Bucharest']")
        private WebElement flightOriginPopupListOptionBucharest;

        @FindBy(id="flightmanagerFlightsFormDestination")
        private WebElement flightDestinationTextField;

        @FindBy(css="ul#flightmanagerFlightsFormDestinationPopupList li[aria-label*='Seville']")
        private WebElement flightDestinationPopupListOptionSeville;

        @FindBy(id="flightmanagerFlightsFormOutboundDateDisplay")
        private WebElement flightDepartureDateField;

        @FindBy(id="flightmanagerFlightsFormOnewayLabel")
        private WebElement flightOneWayButton;

        @FindBy(css=".month-head button.next")
        private WebElement nextMonthArrowButton;

        @FindBy(css="td.day-today button")
        private WebElement datePickerCurrentDateButton;

        @FindBy(css="a.link.reset")
        private WebElement resetCalendarButton;

        @FindBy(xpath="//button[contains(@aria-controls,'flightmanagerFlightsFormAdults')]")
        private WebElement incrementNumberOfAdultsButton;

        @FindBy(id="flightmanagerFlightsFormCabin")
        private WebElement cabinTypeSelectList;

        @FindBy(xpath="//select[@id='flightmanagerFlightsFormCabin']/option[@value='B']")
        private WebElement cabinTypeOptionFirstClass;

        @FindBy(xpath="//button[text()='Search flights']")
        private WebElement submitFlightSearchButton;

        @FindBy(css=".rte-content span.text-size-large-light-hp2014")
        private WebElement recentSearchText;

        WebDriver driver;

        public PortalHomePage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
        }
        public void open() {
            String baseUrl = "http://www.lufthansa.com/ro/en/Homepage";
            driver.get(baseUrl);
        }
        
        public void close() {
        	driver.quit();
        }
        public void selectFlightOriginPopupListOptionBucharest(String flightOrigin){
            flightOriginTextField.sendKeys(flightOrigin);
            try{
              Thread.sleep(4000);
            }catch(Exception e){

            }
            flightOriginPopupListOptionBucharest.click();
        }
        public void selectFlightDestinationPopupListOptionSeville(String flightDestination){
            flightDestinationTextField.sendKeys(flightDestination);
            try{
              Thread.sleep(4000);
            }catch(Exception e){

            }
            flightDestinationPopupListOptionSeville.click();
        }
        public void clickFlightDepartureDateField() {
            flightDepartureDateField.click();
        }
        public void clickFlightOneWayButton() {
          flightOneWayButton.click();
        }
        public void clickNextMonthArrowButton() {
            nextMonthArrowButton.click();
        }
        public void clickResetCalendarButton() {
            resetCalendarButton.click();
        }
        public void clickDatePickerCurrentDateButton() {
            datePickerCurrentDateButton.click();
            try{
              Thread.sleep(4000);
            }catch(Exception e){

            }
        }
        public void clickIncrementNumberOfAdultsButton() {
            incrementNumberOfAdultsButton.click();
            try{
                Thread.sleep(4000);
              }catch(Exception e){

              }
        }
        public void selectCabinTypeOptionFirstClass() {
            cabinTypeSelectList.click();
            try{
              Thread.sleep(4000);
            }catch(Exception e){

            }

            cabinTypeOptionFirstClass.click();
        }
        public void clickSubmitFlightSearchButton() {
            submitFlightSearchButton.click();
            try{
              Thread.sleep(4000);
            }catch(Exception e){

            }
        }
        public String getRecentSearchText(){
            return recentSearchText.getText();
        }
    }
