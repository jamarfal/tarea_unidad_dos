package com.example.martinfalconja.martinfalconja_u2.logic.calculator_tab;

/**
 * Created by jamarfal on 26/9/16.
 */

public class Calculator {
    private float firstOperator;
    private float secondOperator;
    private MathOperation operation;

    public Calculator(MathOperation operation) {
        this.firstOperator = 0;
        this.secondOperator = 0;
        this.operation = operation;
    }

    public Calculator(float firstOperator, float secondOperator, MathOperation operation) {
        this.firstOperator = firstOperator;
        this.secondOperator = secondOperator;
        this.operation = operation;
    }

    public float getFirstOperator() {
        return firstOperator;
    }

    public void setFirstOperator(float firstOperator) {
        this.firstOperator = firstOperator;
    }

    public float getSecondOperator() {
        return secondOperator;
    }

    public void setSecondOperator(float secondOperator) {
        this.secondOperator = secondOperator;
    }

    public MathOperation getOperation() {
        return operation;
    }

    public void setOperation(MathOperation operation) {
        this.operation = operation;
    }

    public float performOperation() {
        return operation.operate(firstOperator, secondOperator);
    }

    public void resetOperators() {
        this.firstOperator = 0.0f;
        this.secondOperator = 0.0f;
    }

}
