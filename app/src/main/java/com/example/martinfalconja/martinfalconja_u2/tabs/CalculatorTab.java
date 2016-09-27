package com.example.martinfalconja.martinfalconja_u2.tabs;

import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.martinfalconja.martinfalconja_u2.R;
import com.example.martinfalconja.martinfalconja_u2.logic.calculator_tab.Addition;
import com.example.martinfalconja.martinfalconja_u2.logic.calculator_tab.Calculator;

/**
 * Created by jamarfal on 26/9/16.
 */

public class CalculatorTab extends Fragment implements View.OnClickListener {

    private final String ZERO = "0";
    private final float PTAS = 166.386f;

    private TextView resultTextView, resultTemporalTextView;
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
        return inflate;
    }


    private void initViews(View inflate) {
        resultTextView = (TextView) inflate.findViewById(R.id.result_text_view);
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

                break;
            case R.id.button_clear:

                break;
            case R.id.button_converter:

                break;
            case R.id.button_plus:
                break;
            case R.id.button_equal:
                break;
        }
    }
}
