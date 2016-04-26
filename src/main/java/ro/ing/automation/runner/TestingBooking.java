package ro.ing.automation.runner;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import ro.ing.automation.IngPageFactory;
import ro.ing.automation.runner.BookingHomepage;


public class TestingBooking {
	WebDriver driver;

	@Before
	public void setup(){
		//use FF Driver
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://booking.com");
	}

	@Test
	public void startBookingTest() {
		BookingHomepage bookingHome = BookingHomepage.initElements(driver, BookingHomepage.class);

		// Select arrival day
		bookingHome.setCheckinMonthDay("1");

		// Select arrival month
		bookingHome.setCheckinYearMonth("2016-6");

		// Select departure day
		bookingHome.setCheckoutMonthDay("5");

		// Select departure month
		bookingHome.setCheckoutYearMonth("2016-6");

		// choosing "New York" as location
		bookingHome.inputText.sendKeys("New York City");
		bookingHome.inputText.sendKeys(Keys.ENTER);

		//choosing first result
		bookingHome.selectFirst.click();

		// Doing some assertions
		Assert.assertEquals("Booking.com: Hotels in New York City. Book your hotel now!", driver.getTitle());
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='current_account']/a/div")).isEnabled());

		//Getting the results from first page and check if all contains New York location
		List <WebElement> resultList = driver.findElements(By.className("address"));
		for (WebElement e : resultList)
		{
			Assert.assertEquals(e.getText().contains("New York City"), true);

		}
	}


	@After
	public void afterTest() {
		driver.close();
	}
}
