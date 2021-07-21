package com.torquato.cucumber.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.torquato.cucumber.example",
        plugin = {"pretty", "html:target/cucumber.html"}
)
public class CucumberRunnerTest {
}
