package pages;

import lombok.Getter;
import lombok.extern.java.Log;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by conor on 19/12/17.
 */
@Log
public class RegPage extends BasePage {

    private static final String IS_DISPLAYED = "displayed";
    private static final String IS_NOT_DISPLAYED = "not displayed";
    private static final String SINGLE = "Single";
    private static final String MARRIED = "Married";
    private static final String DIVORCED = "Divorced";
    private static final String DANCE = "Dance";
    private static final String READING = "Reading";
    private static final String CRICKET = "Cricket";

    private String selectedRadioBtn;

    @FindBy(id = "name_3_firstname")
    WebElement firstName;

    @FindBy(id = "name_3_lastname")
    WebElement lastName;

    @Getter
    @FindBy(css = "#pie_register > li:nth-child(1) > div.fieldset.error > div.legend_txt > span")
    WebElement nameSectionErrorMessage;

    @FindBy(css = "#pie_register > li:nth-child(3) > div.fieldset.error > div.legend_txt > span")
    WebElement hobbyErrorMessage;

    @FindBy(css = "#pie_register > li:nth-child(14) > div > input[type=\"submit\"]")
    WebElement submitBtn;

    @FindBy(id = "content")
    WebElement pageContent;

    @FindBy(css = "#pie_register > li:nth-child(2) > div > div > input:nth-child(2)")
    WebElement singleRadioBtn;

    @FindBy(css = "#pie_register > li:nth-child(2) > div > div > input:nth-child(4)")
    WebElement marriedRadioBtn;

    @FindBy(css = "#pie_register > li:nth-child(2) > div > div > input:nth-child(6)")
    WebElement divorcedRadioBtn;

    @FindBy(css = "#pie_register > li:nth-child(3) > div > div.radio_wrap > input:nth-child(4)")
    WebElement readingRadioBtn;

    @FindBy(css = "#pie_register > li:nth-child(3) > div > div.radio_wrap > input:nth-child(2)")
    WebElement danceRadioBtn;

    @FindBy(css = "#pie_register > li:nth-child(3) > div > div.radio_wrap > input:nth-child(6)")
    WebElement cricketRadioBtn;


    public RegPage(WebDriver driver) {
        super(driver);
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

    public void verifyErrorMessageIsDisplayed(String displayStatus,WebElement elment) {
        switch (displayStatus) {
            case IS_DISPLAYED:
                wait.until(ExpectedConditions.visibilityOf(elment));
                assertThat(elment.isDisplayed(), is(true));
                assertThat(elment.getText(), is("* This field is required"));
                break;

            //TODO : Would Improve waiting 30s for timeout sucks.

            case IS_NOT_DISPLAYED:
                Boolean elementFound = false;
                try {
                    wait.until(ExpectedConditions.visibilityOf(elment));
                    elementFound = true;
                } catch (TimeoutException e) {
                    assertThat(elementFound, is(false));
                }
                break;
            //TODO : Throw custom exception
            default:
                log.severe("No such option ");
        }
    }

    public void clickRadioBtn(String radioBtn) {
        selectedRadioBtn = radioBtn;
        switch (radioBtn) {
            case SINGLE:
                singleRadioBtn.click();
                break;
            case MARRIED:
                marriedRadioBtn.click();
                break;
            case DIVORCED:
                divorcedRadioBtn.click();
                break;
            case DANCE:
                danceRadioBtn.click();
                break;
            case READING:
                readingRadioBtn.click();
                break;
            case CRICKET:
                cricketRadioBtn.click();
                break;
            //TODO : Throw custom exception
            default:
                log.severe("No such option ");
        }
    }

    //TODO could be refactred with above to be the same method. reduce duplicate code
    public void verifyRadioButtonHasBeenSelected() {
        switch (selectedRadioBtn) {
            case SINGLE:
                assertThat(singleRadioBtn.isSelected(), is(true));
                break;
            case MARRIED:
                assertThat(marriedRadioBtn.isSelected(), is(true));
                break;
            case DIVORCED:
                assertThat(divorcedRadioBtn.isSelected(), is(true));
                break;
            //TODO : Throw custom exception
            default:
                log.severe("No such option ");
        }
    }
}
