package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by conor on 17/12/17.
 */
public class BasePage {

        protected final WebDriver driver;
        public WebDriverWait wait;
        static final long DEFAULT_EXPLICIT_WAIT = 10;

        public BasePage(WebDriver driver) {

            this.driver = driver;
            PageFactory.initElements(driver, this);
            wait = new WebDriverWait(driver, DEFAULT_EXPLICIT_WAIT);
        }
    }

