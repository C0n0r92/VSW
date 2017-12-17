package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import util.DriverUtil;

/**
 * Created by conor on 17/12/17.
 */

public class InitSteps {

    @Before
    public void setUp(){
        DriverUtil.getWebDriver().get("http://www.google.com");
    }


    @After
    public void TearDown(){
        DriverUtil.getWebDriver().quit();
        DriverUtil.setDriver(null);
    }

}
