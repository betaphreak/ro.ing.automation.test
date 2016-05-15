package ro.ing.automation.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ro.ing.automation.IngPageFactory;

/**
 * Created by Ovidiu Moscaliuc on 5/16/2016.
 */
public class DemoQaContactPage extends IngPageFactory {

    public DemoQaContactPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css ="input[name='your-name']")
    public WebElement nameInput;

    @FindBy(css ="input[name='your-email']")
    public WebElement emailInput;

    @FindBy(css ="input[name='your-subject']")
    public WebElement subjectInput;

    @FindBy(css ="textarea[name='your-message']")
    public WebElement messageInput;

    @FindBy(css ="input[type='submit']")
    public WebElement sendButton;

    @FindBy(css ="div[role='alert'][style='display: block;']")
    public WebElement validationString;
}
