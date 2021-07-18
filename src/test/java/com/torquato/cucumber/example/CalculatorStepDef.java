package com.torquato.cucumber.example;

import io.cucumber.java.en.*;

import java.math.*;

import static org.junit.Assert.*;

public class CalculatorStepDef {

    private Calculator calculator;
    private Exception exception;

    @Given("A calculator with initial value of {double}")
    public void a_calculator_with_initial_value_of(Double value) {
        this.calculator = new Calculator(BigDecimal.valueOf(value));
    }

    @Given("Sum a value {double}")
    public void sum_a_value(Double value) {
        try {
            this.calculator.sum(value != null ? BigDecimal.valueOf(value) : null);
        } catch (Exception e) {
            this.exception = e;
        }
    }

    @When("Try to sum a null value")
    public void try_to_sum_a_null_value() {
        sum_a_value(null);
    }

    @Then("The error should be a NullPointerException")
    public void the_error_should_be_a_NullPointerException() {
        assertEquals(NullPointerException.class, this.exception.getClass());
    }

    @Then("The error should be an IllegalArgumentException")
    public void the_error_should_be_an_IllegalArgumentException() {
        assertEquals(IllegalArgumentException.class, this.exception.getClass());
    }

    @Then("The result should be {double}")
    public void the_result_should_be(Double value) {
        BigDecimal result = this.calculator.result();
        BigDecimal expect = BigDecimal.valueOf(value);
        assertEquals("Calculator result", 0, result.compareTo(expect));
    }

}