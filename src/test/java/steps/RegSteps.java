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

    private RegPage registrationPage = new RegPage(DriverUtil.getWebDriver());

    @And("^I go to \"([^\"]*)\"$")
    public void I_go_to(String url){
       DriverUtil.getWebDriver().get(url);
        registrationPage.verifyPageIsDisplayed();
    }

    @When("^I enter \"([^\"]*)\" as my first name and \"([^\"]*)\" as my last name$")
    public void I_enter_as_my_first_name_and_as_my_last_name(String fname, String lname){
        registrationPage.enterFirstAndSecondName(fname,lname);


    }

    @And("^I click the submit button$")
    public void I_click_the_submit_button(){
        registrationPage.clickSubmitBtn();
    }

    @Then("^the validation warning is \"([^\"]*)\"$")
    public void the_validation_warning_is(String status){
        registrationPage.verifyErrorMessageIsDisplayed(status );
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
}
