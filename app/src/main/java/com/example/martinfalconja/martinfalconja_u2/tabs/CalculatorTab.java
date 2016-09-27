package com.example.martinfalconja.martinfalconja_u2.tabs;

import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.martinfalconja.martinfalconja_u2.R;
import com.example.martinfalconja.martinfalconja_u2.logic.calculator_tab.Addition;
import com.example.martinfalconja.martinfalconja_u2.logic.calculator_tab.Calculator;

public class CalculatorTab extends Fragment implements View.OnClickListener {

    private final String ZERO = "0";
    private final float PTAS = 166.386f;
    private Calculator calculator;
    private float result;
    private boolean isNewNumber = true, isNewOperation = true, pressedEqualButton = false, pressedOperation = false;

    private TextView display;
    private Button buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix,
            buttonSeven, buttonEight, buttonNine, buttonZero, buttonClear, buttonConverter,
            buttonAddition, buttonEqual;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.tab_calculator, container, false);
        initViews(inflate);
        initButtonOnclickListeners();
        calculator = new Calculator(new Addition());
        return inflate;
    }


    private void initViews(View inflate) {
        display = (TextView) inflate.findViewById(R.id.result_text_view);
        buttonOne = (Button) inflate.findViewById(R.id.button_one);
        buttonTwo = (Button) inflate.findViewById(R.id.button_two);
        buttonThree = (Button) inflate.findViewById(R.id.button_three);
        buttonFour = (Button) inflate.findViewById(R.id.button_four);
        buttonFive = (Button) inflate.findViewById(R.id.button_five);
        buttonSix = (Button) inflate.findViewById(R.id.button_six);
        buttonSeven = (Button) inflate.findViewById(R.id.button_seven);
        buttonEight = (Button) inflate.findViewById(R.id.button_eight);
        buttonNine = (Button) inflate.findViewById(R.id.button_nine);
        buttonZero = (Button) inflate.findViewById(R.id.button_zero);
        buttonClear = (Button) inflate.findViewById(R.id.button_clear);
        buttonConverter = (Button) inflate.findViewById(R.id.button_converter);
        buttonAddition = (Button) inflate.findViewById(R.id.button_plus);
        buttonEqual = (Button) inflate.findViewById(R.id.button_equal);
    }

    private void initButtonOnclickListeners() {
        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
        buttonFour.setOnClickListener(this);
        buttonFive.setOnClickListener(this);
        buttonSix.setOnClickListener(this);
        buttonSeven.setOnClickListener(this);
        buttonEight.setOnClickListener(this);
        buttonNine.setOnClickListener(this);
        buttonZero.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonConverter.setOnClickListener(this);
        buttonAddition.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_zero:
            case R.id.button_one:
            case R.id.button_two:
            case R.id.button_three:
            case R.id.button_four:
            case R.id.button_five:
            case R.id.button_six:
            case R.id.button_seven:
            case R.id.button_eight:
            case R.id.button_nine:
                String numberStr = (String) view.getTag();
                showNumberInDisplay(numberStr);
                break;
            case R.id.button_clear:
                clearButtonAction();
                break;
            case R.id.button_converter:
                converter();
                break;
            case R.id.button_plus:
                calculate();
                break;
            case R.id.button_equal:
                equalButtonAction();
                break;
        }
    }

    private void converter() {
        float amount = tryParseFloat(getTextInDisplay());
        float amountConverted = amount * PTAS;
        display.setText(String.valueOf(amountConverted));
    }

    private void clearButtonAction() {
        display.setText(ZERO);
        result = 0.0f;
        calculator.resetOperators();
        isNewNumber = true;
        isNewOperation = true;
        pressedOperation = false;
        pressedEqualButton = false;
    }


    private void showNumberInDisplay(String numberStr) {
        if (isNewNumber) {
            display.setText(numberStr);
            isNewNumber = false;
            pressedOperation = false;
        } else {
            display.setText(getTextInDisplay() + numberStr);
        }
    }


    private void calculate() {
        if (pressedOperation) {
            String text = "Ya ha pulsado una operación";
            showNotification(text);
        } else {
            calculator.setFirstOperator(result);
            calculator.setSecondOperator(tryParseFloat(getTextInDisplay()));
            result = calculator.performOperation();
            if (isNewOperation) {
                isNewOperation = false;
                isNewNumber = true;
            } else {
                display.setText(removeZeros(String.valueOf(result)));
                isNewNumber = true;
            }
        }
        pressedOperation = true;
    }

    private void equalButtonAction() {
        if (!isNewOperation) {
            result = calculator.performOperation();
            calculator.setFirstOperator(result);
            calculator.setSecondOperator(tryParseFloat(getTextInDisplay()));
            result = calculator.performOperation();
            display.setText(removeZeros(String.valueOf(result)));
            isNewNumber = true;
            isNewOperation = true;
            result = 0;
        }
    }


    private String getTextInDisplay() {
        return display.getText().toString();
    }

    private String removeZeros(String number) {
        int lastDigit = number.length() - 1;

        while (number.charAt(lastDigit) == '0') {
            number = number.substring(0, lastDigit);
            lastDigit = number.length() - 1;
        }

        if (number.charAt(lastDigit) == '.') {
            number = number.substring(0, lastDigit);
        }
        return number;
    }

    private void showNotification(String text) {
        Toast.makeText(getContext(),
                text, Toast.LENGTH_SHORT).show();
    }


    private float tryParseFloat(String numStr) {
        float number;
        try {
            number = Float.parseFloat(numStr);
        } catch (NumberFormatException exception) {
            number = 0.0f;
        }
        return number;
    }

}
