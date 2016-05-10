package ro.ing.automation.profiles;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Alexadru Giurovici on 07.04.2016.
 */

@Profile( { "default" } )
@Component
@Configuration
public class Default extends SpringBeanAutowiringSupport
{
    static Logger log = Logger.getLogger(Default.class);
    static Properties props = new Properties();

    static void init()
    {
//        try {
//            props.load(Default.class.getResourceAsStream("/config.properties"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    public static Properties getProps()
    {
        return props;
    }

    static
    {
        init();
    }

    @Bean
    public WebDriver driver()
    {
        log.error("Attempt to run with no target profile selected. Please use '-Dspring.profiles.active' at runtime.");
        return null;
    }

}
