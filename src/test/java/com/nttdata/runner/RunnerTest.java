package com.nttdata.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report-html.html"},
        features = "src/test/resources/features",
        glue = "com.nttdata",
        publish = false
)
public class RunnerTest {
}