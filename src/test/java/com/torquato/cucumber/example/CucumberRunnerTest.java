package com.torquato.cucumber.example;

import io.cucumber.java.*;
import io.cucumber.junit.*;
import org.junit.runner.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.torquato.cucumber.example",
        plugin = {"pretty", "html:target/cucumber.html"}
)
public class CucumberRunnerTest {

    @ParameterType("data/person-.*\\.json")
    public PersonService.Person person(String jsonPath) {
        return new PersonService.Person();
    }

}
