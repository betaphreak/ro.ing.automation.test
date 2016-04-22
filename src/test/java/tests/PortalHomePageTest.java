package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import ro.ing.automation.IngPageFactory;
import ro.ing.automation.pages.PortalHomePage;
import ro.ing.automation.pages.ViewFlightsPage;

public class PortalHomePageTest {

  WebDriver driver;
  PortalHomePage portalHomePage;
  ViewFlightsPage viewFlightsPage;

	@Before
	public void beforeTest() {
		driver = new FirefoxDriver();
		portalHomePage = IngPageFactory.initElements(driver, PortalHomePage.class);
		portalHomePage.open();
	}

  @Test
  public void SearchForFlightTest() {
    portalHomePage.clickFlightOneWayButton();
    portalHomePage.selectFlightOriginPopupListOptionBucharest("Bucharest");
    portalHomePage.selectFlightDestinationPopupListOptionSeville("Seville");
    portalHomePage.clickFlightDepartureDateField();
    portalHomePage.clickNextMonthArrowButton();
    portalHomePage.clickResetCalendarButton();
    portalHomePage.clickDatePickerCurrentDateButton();
    portalHomePage.clickSubmitFlightSearchButton();
    viewFlightsPage = IngPageFactory.initElements(driver, ViewFlightsPage.class);
    assertTrue(viewFlightsPage.getFlightOriginToDestinationHeaderText().contains("Bucharest") &&
    		   viewFlightsPage.getFlightOriginToDestinationHeaderText().contains("Sevilla"));
  }

	@After
	public void afterTest() {
		portalHomePage.close();
	}

}
