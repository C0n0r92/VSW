package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @FindBy(id = "u_0_k")
    WebElement userDetailsBox;

    public PageOne(WebDriver driver){
        super(driver);
    }

    public void enterUserName() {
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys("Conor");
    }

    public void verifyPageIsDisplayed() {
        assertThat(userDetailsBox.isDisplayed(),is(true));
    }
}
