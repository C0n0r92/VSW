package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.RegPage;
import util.DriverUtil;

/**
 * Created by conor on 17/12/17.
 */
public class RegSteps {

    private static final String DATE_PREFIX = "dd";
    private static final String MONTH_PREFIX = "mm";
    private static final String YEAR_PREFIX = "yy";
    private RegPage registrationPage = new RegPage(DriverUtil.getWebDriver());

    @And("^I go to \"([^\"]*)\"$")
    public void I_go_to(String url){
       DriverUtil.getWebDriver().get(url);
        registrationPage.verifyPageIsDisplayed();
    }

    @When("^I enter \"([^\"]*)\" as my first name and \"([^\"]*)\" as my last name$")
    public void I_enter_as_my_first_name_and_as_my_last_name(String fname, String lname){
        registrationPage.enterFirstAndSecondName(fname, lname);
    }

    @And("^I click the submit button$")
    public void I_click_the_submit_button(){
        registrationPage.clickSubmitBtn();
    }

    @Then("^the validation warning is \"([^\"]*)\" for names$")
    public void the_validation_warning_is_for_names(String status){
        registrationPage.verifyErrorMessageIsDisplayed(status,
                registrationPage.getNameSectionErrorMessage());
    }

    @And("^I toggle the \"([^\"]*)\" radio button$")
    public void I_toggle_the_radio_button(String radioBtn){
        registrationPage.clickRadioBtn(radioBtn);
    }

    @Then("^the radio button should be enabled$")
    public void the_radio_button_should_be_enabled(){
        registrationPage.verifyRadioButtonHasBeenSelected();
    }

    @Then("^the radio button should be selected$")
    public void the_radio_button_should_be_selected(){
        registrationPage.verifyRadioButtonHasBeenSelected();
    }

    @Then("^the validation warning is \"([^\"]*)\" for hobbies$")
    public void the_validation_warning_is_for_hobbies(String status){
        registrationPage.verifyErrorMessageIsDisplayed(status,
                registrationPage.getHobbySectionErrorMessage());
    }

    @When("^I enter \"([^\"]*)\" as the day$")
    public void I_enter_as_the_day(String day){
        registrationPage.enterDate(day, DATE_PREFIX);
    }

    @When("^I enter \"([^\"]*)\" as the month$")
    public void I_enter_as_the_month(String month){
        registrationPage.enterDate(month, MONTH_PREFIX);
    }


    @When("^I enter \"([^\"]*)\" as the year$")
    public void I_enter_as_the_year(String year ){
        registrationPage.enterDate(year, YEAR_PREFIX);
    }

    @Then("^the validation warning is \"([^\"]*)\" for dates$")
    public void the_validation_warning_is_for_dates(String status){
        registrationPage.verifyErrorMessageIsDisplayed(status,
                registrationPage.getDateSectionErrorMessage());
    }
}
