package util;

import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Created by conor on 17/12/17.
 */
public class DriverUtil {

    @Setter
    private static WebDriver driver;

    public static WebDriver getWebDriver(){


            if (driver == null) {
                System.setProperty("webdriver.chrome.driver", "/Users/conor/workspaces/VSW/src/drivers/chromedriver");
                WebDriver d = new ChromeDriver();
                driver = d;
            }

           return driver;
    }
}
