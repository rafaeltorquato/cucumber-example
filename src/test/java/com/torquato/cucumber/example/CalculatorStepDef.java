package com.torquato.cucumber.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.math.BigDecimal;

public class CalculatorStepDef {

    private Calculator calculator;
    private Exception exception;

    @Given("A calculator with initial value of {double}")
    public void a_calculator_with_initial_value_of(Double value) {
        this.calculator = new Calculator(BigDecimal.valueOf(value));
    }

    @Given("Try to sum a value {double}")
    public void try_to_sum_a_value(Double value) {
        try {
            this.calculator.sum(value != null ? BigDecimal.valueOf(value) : null);
        } catch (Exception e) {
            this.exception = e;
        }
    }

    @When("Try to sum a null value")
    public void try_to_sum_a_null_value() {
        try_to_sum_a_value(null);
    }

    @Then("The error should be a NullPointerException")
    public void the_error_should_be_a_NullPointerException() {
        Assert.assertEquals(NullPointerException.class, this.exception.getClass());
    }

    @Then("The error should be an IllegalArgumentException")
    public void the_error_should_be_an_IllegalArgumentException() {
        Assert.assertEquals(IllegalArgumentException.class, this.exception.getClass());
    }

    @Then("The result should be {double}")
    public void the_result_should_be(Double value) {
        BigDecimal result = this.calculator.result();
        BigDecimal expect = BigDecimal.valueOf(value);
        Assert.assertEquals(result.compareTo(expect), 0);
    }

}