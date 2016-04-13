package ro.ing.automation.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ro.ing.automation.runner.MultiThreadRunner;

import ro.ing.automation.profiles.Firefox;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(MultiThreadRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class,
classes={Firefox.class, ro.ing.automation.test.GoogleTest.ContextConfiguration.class})
@ActiveProfiles("test")
public class GoogleTest {

	@Configuration
	@Profile("test")
	public static class ContextConfiguration {
		@Bean
	    public WebDriver driver() {
			return new FirefoxDriver();
		}
	}
	
	@Autowired
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		driver.get("https://www.google.ro/#q=selenium");
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void test() {
		GooglePage page = new GooglePage(driver);
		PageFactory.initElements(driver, page);
		
		assertTrue("There are no results", page.waitForFirstResult());
		assertEquals("First result is not Selenium", "Selenium - Web Browser Automation", page.getFirstText());
	}

}
