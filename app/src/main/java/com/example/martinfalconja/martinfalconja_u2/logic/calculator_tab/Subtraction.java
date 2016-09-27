package com.example.martinfalconja.martinfalconja_u2.logic.calculator_tab;

/**
 * Created by jamarfal on 27/9/16.
 */

public class Subtraction implements MathOperation {
    @Override
    public float operate(float firstArgument, float secondArgument) {
        return firstArgument - secondArgument;
    }
}
