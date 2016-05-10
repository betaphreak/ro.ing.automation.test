package ro.ing.automation.profiles;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Bean;

import java.io.File;

/**
 * Created by Alexandru Giurovici on 14.01.2016.
 */
public class Firefox extends Default
{
    @Bean
    public WebDriver driver()
    {
        WebDriver result = null;
        result = new FirefoxDriver();

//            Proxy proxy = new Proxy();
//            DesiredCapabilities caps = new DesiredCapabilities();
//            try
//            {
//                String proxyUrl = props.getProperty("proxy.url", "");
//                if (proxyUrl.length() > 0)
//                {
//                    log.info("Using session proxy: " + proxyUrl);
//                    String proxyExceptions = props.getProperty("proxy.exceptions", "");
//                    proxy.setHttpProxy(proxyUrl).setFtpProxy(proxyUrl).setSslProxy(proxyUrl).setNoProxy(proxyExceptions);
//                    log.info("Using session proxy exceptions: " + proxyExceptions);
//                    caps.setCapability(CapabilityType.PROXY, proxy);
//                }
//                else log.info("Not using any session proxy.");
//            }
//            catch (Exception msg)
//            {
//                throw new RuntimeException("Missing or invalid proxy settings -> " + msg.getMessage());
//            }
//            FirefoxProfile fp;
//
//            try {
//                String fpp = props.getProperty("firefox.local.profile");
//                fp = new FirefoxProfile(new File(fpp));
//                log.info("Loading default instance of Firefox profile from " + fpp);
//                caps.setCapability(FirefoxDriver.PROFILE, fp);
//            }
//            catch(Exception msg)
//            {
//                throw new RuntimeException("Missing or invalid firefox.local profile in your config.properties file -> " + msg.getMessage());
//            }
//
//        try
//        {
//            result = new FirefoxDriver(caps);
//        }
//        catch (NumberFormatException e)
//        {
//            throw new RuntimeException("Invalid browser properties in your config.properties file -> " + e.getMessage());
//        }

        return result;
    }
}
