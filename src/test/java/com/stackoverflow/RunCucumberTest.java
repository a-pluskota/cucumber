package com.stackoverflow;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@Category(value = CucumberTests.class)
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com.stackoverflow/",
        plugin = {"pretty", "html:target/Destination"})

public class RunCucumberTest {
}
