package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Created by conor on 17/12/17.
 */
public class PageOne extends BasePage {

    @FindBy(id = "email")
    WebElement usernameField;

    @FindBy(css = ".loggedout_menubar > div:nth-child(1)")
    WebElement userDetailsBox;

    public PageOne(WebDriver driver){
        super(driver);
    }

    public void enterUserName(String usrname) {
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(usrname);
        Actions build = new Actions(driver);
        build.moveToElement(usernameField).clickAndHold();
    }

    public void verifyPageIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(userDetailsBox));
        assertThat(userDetailsBox.isDisplayed(),is(true));
    }
}
