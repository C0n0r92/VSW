package steps;

/**
 * Created by conor on 17/12/17.
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"},
        features = {"src/test/resources/features/"},
        glue = {"src/test/java/steps"},
        tags= {"@Regression"})
public class CucumberRunner {

}
