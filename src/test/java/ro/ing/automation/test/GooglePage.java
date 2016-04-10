package ro.ing.automation.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ro.ing.automation.IngPageFactory;

public class GooglePage extends IngPageFactory {

	private WebDriver webDriver;
	
	@FindBy(css = "h3.r > a")
	private WebElement firstResult;
	
	protected GooglePage(WebDriver driver) {
		super(driver);
		this.webDriver = driver;
	}

	public String getFirstText() {
		return firstResult.getText();
	}
	
	public boolean waitForFirstResult() {
		return waitFor(firstResult);
	}
}
