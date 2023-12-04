package com.example.calculator.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.calculator.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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

    public void updateResultTextView() {
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
        otherSymbols.setDecimalSeparator(',');
        // At least one digit before decimal separator and 9 digits after
        DecimalFormat df = new DecimalFormat("0.000000000", otherSymbols);

        // remove trailing zeros
        df.setMaximumFractionDigits(9);
        df.setMinimumFractionDigits(0);

        String formatted = df.format(CalculaitonResult);
        if (formatted.length() > this.MAX_LENGTH) {
            Toast toast = Toast.makeText(getApplicationContext(), "Result is too big", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        resultTextView.setText(formatted);
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
            Toast toast = Toast.makeText(getApplicationContext(), "Number is too big", Toast.LENGTH_SHORT);
            toast.show();
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
        String current_on_display = resultTextView.getText().toString();

        if (current_on_display.contains(",")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Number already has decimal separator", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        if (current_on_display.length() >= this.MAX_LENGTH - 1) {
            Toast toast = Toast.makeText(getApplicationContext(), "Number is too big to add decimal separator", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        resultTextView.setText(String.format(Locale.getDefault(), "%s,", current_on_display));
    }

    public void onOperationClick(View view) {
        // Create shadow on button when clicked

    }

    public void onAllClearClick(View view) {
        String state = ((Button) findViewById(R.id.allClear)).getText().toString();
        if (state.equals("AC")) {
//            this.clearAll();
        } else {
//            this.clearEntry();
        }
        resultTextView.setText("0");
        CalculaitonResult = 0.0D;
    }

    public void signOnClick(View view) {
        String current_on_display = resultTextView.getText().toString();

        if (current_on_display.equals("0")) {
            return;
        }

        if (current_on_display.charAt(0) == '-') {
            resultTextView.setText(current_on_display.substring(1));
        } else {
            resultTextView.setText(String.format(Locale.getDefault(), "-%s", current_on_display));
        }
    }

    public void percentOnClick(View view) {
        String current_on_display = resultTextView.getText().toString();

        if (current_on_display.equals("0") || current_on_display.equals("-0")) {
            return;
        }

        current_on_display = current_on_display.replace(",", ".");
        double current_on_display_double = Double.parseDouble(current_on_display);
        CalculaitonResult = current_on_display_double / 100.0D;

        this.updateResultTextView();
    }
}
