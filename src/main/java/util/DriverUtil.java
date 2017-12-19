package util;

import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Created by conor on 17/12/17.
 */
public class DriverUtil {

    @Setter
    private static WebDriver driver;

    public static WebDriver getWebDriver() {
        if (driver == null) {
//            System.setProperty("webdriver.firefox.driver", "/Users/conor/workspaces/VSW/src/drivers/chromedriver");
//            driver = new ChromeDriver();

            System.setProperty("webdriver.gecko.driver", "/Users/conor/workspaces/VSW/src/drivers/geckodriver");
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
