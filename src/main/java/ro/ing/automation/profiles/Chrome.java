package ro.ing.automation.profiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;

/**
 * Created by razvan on 5/9/2016.
 */
public class Chrome extends  Default{

    @Bean
    public WebDriver driver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\razvan\\workspace\\ro.ing.automation.test\\src\\main\\resources\\chromedriver.exe");
        return new ChromeDriver();
    }
}
