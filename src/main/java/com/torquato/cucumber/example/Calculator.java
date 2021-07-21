package com.torquato.cucumber.example;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@NoArgsConstructor
public class Calculator {

    private BigDecimal value = BigDecimal.ZERO;

    public Calculator(BigDecimal value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public Calculator sum(BigDecimal value) {
        Objects.requireNonNull(value);
        errorIfValueLessThanZero(value);
        this.value = this.value.add(value);
        return this;
    }

    private void errorIfValueLessThanZero(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("The " + value + " must greater than zero.");
    }

    public BigDecimal result() {
        return this.value;
    }

}
