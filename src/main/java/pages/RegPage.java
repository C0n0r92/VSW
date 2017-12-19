package pages;

import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by conor on 19/12/17.
 */
@Log
public class RegPage extends BasePage {

    private static final String IS_DISPLAYED = "is displayed";

    @FindBy(id = "name_3_firstname")
    WebElement firstName;

    @FindBy(id = "name_3_lastname")
    WebElement lastName;

    @FindBy(css = "#pie_register > li:nth-child(1) > div.fieldset.error > div.legend_txt > span")
    WebElement nameSectionErrorMessage;

    @FindBy(css = "#pie_register > li:nth-child(14) > div > input[type=\"submit\"]")
    WebElement submitBtn;

    @FindBy(id = "content")
    WebElement pageContent;

    public RegPage(WebDriver driver) {
        super(driver);
    }

    public void enterUserName(String usrname) {
        wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(usrname);
        Actions build = new Actions(driver);
        build.moveToElement(firstName).clickAndHold();
    }

    public void verifyPageIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(pageContent));
        assertThat(pageContent.isDisplayed(), is(true));

    }

    public void enterFirstAndSecondName(String fname, String lname) {
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);

    }

    public void clickSubmitBtn() {
        submitBtn.click();
    }

    public void verifyErrorMessageIsDisplayed(String displayStatus) {
        switch (displayStatus) {
            case IS_DISPLAYED:
              assertThat(pageContent.isDisplayed(), is(true));
              //TODO: can prod be various languages would need to be sourced from properties file
              assertThat(pageContent.getText(), is("* This field is required"));

        }
    }
}
