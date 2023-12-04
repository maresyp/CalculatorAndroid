package com.example.calculator.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.calculator.R;

import java.util.Locale;

public class SimpleCalculator extends AppCompatActivity {
    private TextView resultTextView;
    private Double CalculaitonResult;
    private final int MAX_LENGTH = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator);

        CalculaitonResult = 0.0D;

        resultTextView = findViewById(R.id.resultTextView);

    }

    public void numberButtonHandler(View view) {
        String clicked_number = ((TextView) view).getText().toString();
        String current_on_display = resultTextView.getText().toString();

        try {
            if (current_on_display.contains(",")) {
                if (current_on_display.length() >= this.MAX_LENGTH + 1) {
                    throw new Exception();
                }
            } else if (current_on_display.length() == this.MAX_LENGTH) {
                throw new Exception();
            }
        } catch (Exception e ) {
            // TODO : Add error message
            return;
        }


        if (current_on_display.equals("0") || current_on_display.equals("-0")) {
            if (clicked_number.equals("0")) {
                return;
            }
            resultTextView.setText(clicked_number);
        } else {
            resultTextView.setText(String.format(Locale.getDefault(), "%s", current_on_display + clicked_number));
        }
    }

    public void decimalOnClick(View view) {
    }
}
