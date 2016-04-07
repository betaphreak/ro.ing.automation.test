package ro.ing.automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alexandru Giurovici on 07.04.2016.
 */
public class IngPageFactory extends PageFactory
{
    protected static Logger log = Logger.getLogger(IngPageFactory.class);
    protected WebDriver currentDriver = null;
    protected Wait<WebDriver> wait;

    protected static final int MAX_ATTEMPTS = 2;
    protected static final int AOP_DELAY = 250;

    private static final String js = "function absoluteXPath(e){var n,o=[],a=\"\",t=function(e){var n,o=1;if(e.nodeType==Node.ATTRIBUTE_NODE)return null;for(n=e.previousSibling;n;n=n.previousSibling)n.nodeName==e.nodeName&&++o;return o};if(e instanceof Document)return\"/\";for(;e&&!(e instanceof Document);e=e.nodeType==Node.ATTRIBUTE_NODE?e.ownerElement:e.parentNode){switch(n=o[o.length]={},e.nodeType){case Node.TEXT_NODE:n.name=\"text()\";break;case Node.ATTRIBUTE_NODE:n.name=\"@\"+e.nodeName;break;case Node.PROCESSING_INSTRUCTION_NODE:n.name=\"processing-instruction()\";break;case Node.COMMENT_NODE:n.name=\"comment()\";break;case Node.ELEMENT_NODE:n.name=e.nodeName}n.position=t(e)}for(var r=o.length-1;r>=0;r--)n=o[r],a+=\"/\"+n.name.toLowerCase(),null!==n.position&&(a+=\"[\"+n.position+\"]\");return a} return absoluteXPath(arguments[0]);";

    protected WebDriver getDriver()
    {
        return currentDriver;
    }

    protected IngPageFactory(WebDriver driver)
    {
        currentDriver = driver;
        wait = new WebDriverWait(currentDriver, AOP_DELAY / 100);
    }

    private boolean waitFor(ExpectedCondition<WebElement> expected) {
        return wait.until(expected).isDisplayed();
    }

    protected boolean waitFor(WebElement expected)
    {
        if (expected != null) try {
            String element = getAbsoluteXPath(expected);
            if (element!= null && element.length() == 0)
                return false;
            else {
                wait = new FluentWait<>(currentDriver)
                        .withTimeout(AOP_DELAY*10, TimeUnit.MILLISECONDS)
                        .pollingEvery(100, TimeUnit.MILLISECONDS)
                        .ignoring(NoSuchElementException.class);
                log.info("Waiting for \"" + element + "\"");
                return wait.until(ExpectedConditions.visibilityOf(expected)) != null;
            }
        } catch (NoSuchElementException msg)
        {
            log.warn("failed. " + msg.getMessage());
        }
        else
        {
            log.warn("Waiting for missing element (null)");
        }
        return false;
    }

    protected String getAbsoluteXPath(WebElement element) throws NullPointerException {
        try {
            return (String) ((JavascriptExecutor) currentDriver).executeScript(js, element);
        }
        catch (Exception msg)
        {
            log.error(msg.getMessage());
            return null;
        }
    }

}


