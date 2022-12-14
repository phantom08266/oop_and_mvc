package org.example.ch1_4.calculator.domain;

import java.util.Arrays;

public enum EnumArithmeticOperator {
    ADDITION("+"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    },
    SUBTRACTION("-") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    },
    DIVISION("/") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 / operand2;
        }
    };

    private final String operator;

    EnumArithmeticOperator(String operator) {
        this.operator = operator;
    }

    protected abstract int arithmeticCalculate(final int operand1, final int operand2);

    public static int calculate(final int operand1, String operator, final int operand2) {
        EnumArithmeticOperator arithmeticOperator = Arrays.stream(EnumArithmeticOperator.values())
                .filter(op -> op.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산자가 아닙니다."));

        return arithmeticOperator.arithmeticCalculate(operand1, operand2);
    }
}
