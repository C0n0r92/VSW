package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
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
}
