package org.example.ch1_1;

import java.util.List;

public class Calculator {
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(),
            new Subtraction(), new Multiplication(), new Division());

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        NewArithmeticOperator newArithmeticOperator = arithmeticOperators.stream()
                .filter(arithmeticOperate -> arithmeticOperate.supports(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
        return newArithmeticOperator.calculate(operand1, operand2);
    }
}
