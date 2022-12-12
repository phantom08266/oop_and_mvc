package org.example.ch1_4.calculator.tobe;


import org.example.ch1_4.calculator.domain.PositiveNumber;

public interface NewArithmeticOperator {
    boolean supports(String operator);
    int calculate(PositiveNumber operand1, PositiveNumber operand2);
}
