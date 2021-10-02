package com.github.automation.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features"},
        glue = {"com.github.automation.stepdefinitions"},
        monochrome = true,
        publish = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class TestRunner {

}
