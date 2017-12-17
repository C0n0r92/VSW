package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;

import pages.PageOne;
import util.DriverUtil;

/**
 * Created by conor on 17/12/17.
 */
public class homepageSteps {

    private PageOne page1 = new PageOne(DriverUtil.getWebDriver());

    @And("^I go to \"([^\"]*)\"$")
    public void I_go_to(String url){
       DriverUtil.getWebDriver().get(url);
       page1.verifyPageIsDisplayed();
    }

    @And("^I enter \"([^\"]*)\" as my username$")
    public void I_enter_as_my_username(String usrname) {
        page1.enterUserName();
    }
}
