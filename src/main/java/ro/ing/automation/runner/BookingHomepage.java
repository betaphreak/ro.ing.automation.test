package ro.ing.automation.runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import ro.ing.automation.IngPageFactory;

public class BookingHomepage extends IngPageFactory {
	
	@FindBy(name = "checkin_monthday")
	WebElement checkin_monthday;
	
	@FindBy(name = "checkin_year_month")
	WebElement checkin_year_month;
	
	@FindBy(name = "checkout_monthday")
	WebElement checkout_monthday;
	
	@FindBy(name = "checkout_year_month")
	WebElement checkout_year_month;
	
	@FindBy(css = "#ss")
	WebElement inputText;
	
	@FindBy(xpath = ".//*[@id='disambBlock_city']/div[2]/div[1]")
	WebElement selectFirst;
	
	
	public BookingHomepage(WebDriver driver) {
		super(driver);
	}
	
	public void setCheckinMonthDay(String checkin_monthday) {
		Select arrivalDay = new Select(this.checkin_monthday);
		arrivalDay.selectByValue(checkin_monthday);
	}
	
	public void setCheckinYearMonth(String checkin_year_month) {
		Select arrivalMonth = new Select(this.checkin_year_month);
		arrivalMonth.selectByValue(checkin_year_month);
	}
	
	public void setCheckoutMonthDay(String checkout_monthday) {
		Select departureDay = new Select(this.checkout_monthday);
		departureDay.selectByValue(checkout_monthday);
	}
	
	public void setCheckoutYearMonth(String checkout_year_month) {
		Select departureMonth = new Select(this.checkout_year_month);
		departureMonth.selectByValue(checkout_year_month);
	}
	
	public void clickOnSearchButton() {
		inputText.click();
	}
	
	public void selectFirstResult() {
		selectFirst.click();
	}
	
}
