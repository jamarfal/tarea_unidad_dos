package com.example.martinfalconja.martinfalconja_u2.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.martinfalconja.martinfalconja_u2.R;

import org.w3c.dom.Text;

/**
 * Created by jamarfal on 25/9/16.
 */

public class CustomButtonTab extends Fragment {
    private EditText input;
    private TextView output;
    private Button customButton, buttonZero;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_custom_button, container, false);
        getViewFields(view);
        configOnClickListeners();
        return view;
    }

    private void getViewFields(View view) {
        input = (EditText) view.findViewById(R.id.number_edit_text);
        output = (TextView) view.findViewById(R.id.output);
        customButton = (Button) view.findViewById(R.id.custom_button);
        buttonZero = (Button) view.findViewById(R.id.button0);
    }

    private void configOnClickListeners() {
        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressCustomButton();
            }
        });

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressButton0(v);
            }
        });
    }

    private void pressButton0(View v) {
        String inputText = input.getText().toString();
        input.setText(inputText + v.getTag());
    }

    private void pressCustomButton() {
        output.setText(String.valueOf(
                Float.parseFloat(input.getText().toString()) * 2.0));
    }


}
