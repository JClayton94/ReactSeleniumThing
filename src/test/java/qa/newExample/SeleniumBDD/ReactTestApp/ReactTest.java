package qa.newExample.SeleniumBDD.ReactTestApp;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = Constant.FEATURES_FILE_LOCATION)
public class ReactTest {

}

