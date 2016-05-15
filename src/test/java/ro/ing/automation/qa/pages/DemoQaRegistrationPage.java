package ro.ing.automation.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import ro.ing.automation.IngPageFactory;

import java.util.List;

/**
 * Created by Ovidiu Moscaliuc on 5/12/2016.
 */
public class DemoQaRegistrationPage extends IngPageFactory {

    public DemoQaRegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "main[id='main'] h1")
    public WebElement pageTitle;

    @FindBy(id ="piereg_pie_form_heading")
    public WebElement formHeader;

    @FindBy(id ="name_3_firstname")
    public WebElement firstNameInput;

    @FindBy(id ="name_3_lastname")
    public WebElement lastNameInput;

    @FindBy(css =".radio_wrap input[type='radio']")
    public List<WebElement> maritalStatusListRadio;

    @FindBy(css = ".radio_wrap input[type='checkbox']")
    public List<WebElement> hobbyListCheckbox;

    @FindBy(id = "dropdown_7")
    private WebElement countryList;

    @FindBy(id = "mm_date_8")
    private WebElement monthList;

    @FindBy(id = "dd_date_8")
    private WebElement dayList;

    @FindBy(id = "yy_date_8")
    private WebElement yearList;

    @FindBy(id = "phone_9")
    public WebElement phoneNumberInput;

    @FindBy(id = "username")
    public WebElement usernameInput;

    @FindBy(id = "email_1")
    public WebElement emailInput;

    @FindBy(id = "description")
    public WebElement aboutYourselfDescriptionTextarea;

    @FindBy(id = "password_2")
    public WebElement passwordInput;

    @FindBy(id = "confirm_password_password_2")
    public WebElement confirmPasswordInput;

    @FindBy(css = "input[name='pie_submit']")
    public WebElement submitButton;

    @FindBy(css = "p.piereg_message")
    public WebElement validationMessage;


    public void selectCountry(String country)
    {
        Select countryDropdown = new Select(countryList);
        countryDropdown.selectByValue(country);
    }

    public void selectMonth(String month)
    {
        Select monthDropdown = new Select(monthList);
        monthDropdown.selectByValue(month);
    }

    public void selectDay(String day)
    {
        Select dayDropdown = new Select(dayList);
        dayDropdown.selectByValue(day);
    }


    public void selectYear(String year)
    {
        Select yearDropDown = new Select(yearList);
        yearDropDown.selectByValue(year);
    }
}
