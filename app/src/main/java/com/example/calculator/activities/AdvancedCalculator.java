package com.example.calculator.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.calculator.R;

public class AdvancedCalculator extends SimpleCalculator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_calculator);

        resultTextView = findViewById(R.id.resultTextView);
    }

    public void xSquaredOnClick(View view) {
        String current_on_display = resultTextView.getText().toString().replace(",", ".");
        if (current_on_display.isEmpty()) {
            return;
        }

        double current = Double.parseDouble(current_on_display);
        CalculationResult = Math.pow(current, 2);

        this.updateResultTextView();
    }

    public void xToThePowerOfYOnClick(View view) {
        if (lastOperationClicked == (Button) view) {
            return;
        }

        this.updateOpperand();
        this.lastOperationClicked = (Button) view;
        this.currentOperation = (x) -> {
            if (this.secondOperand >= 99) {
                Toast toast = Toast.makeText(getApplicationContext(), "Exponent is too big to calculate", Toast.LENGTH_SHORT);
                toast.show();
                return 0.0D;
            }
            return Math.pow(x, this.secondOperand);
        };
    }

    public void lnOnClick(View view) {
        String current_on_display = resultTextView.getText().toString().replace(",", ".");
        if (current_on_display.isEmpty()) {
            return;
        }

        double current = Double.parseDouble(current_on_display);
        if (current <= 0) {
            Toast toast = Toast.makeText(getApplicationContext(), "Logarithm of negative number is not a real number", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        CalculationResult = Math.log(current);

        this.updateResultTextView();
    }

    public void logOnClick(View view) {
        String current_on_display = resultTextView.getText().toString().replace(",", ".");
        if (current_on_display.isEmpty()) {
            return;
        }

        double current = Double.parseDouble(current_on_display);
        if (current <= 0) {
            Toast toast = Toast.makeText(getApplicationContext(), "Logarithm of negative number is not a real number", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        CalculationResult = Math.log10(current);

        this.updateResultTextView();
    }

    public void sqrtOnClick(View view) {
        String current_on_display = resultTextView.getText().toString().replace(",", ".");
        if (current_on_display.isEmpty()) {
            return;
        }

        double current = Double.parseDouble(current_on_display);
        if (current < 0) {
            Toast toast = Toast.makeText(getApplicationContext(), "Square root of negative number is not a real number", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        CalculationResult = Math.sqrt(current);

        this.updateResultTextView();
    }

    public void sinOnClick(View view) {
        String current_on_display = resultTextView.getText().toString().replace(",", ".");
        if (current_on_display.isEmpty()) {
            return;
        }

        double current = Double.parseDouble(current_on_display);
        CalculationResult = Math.sin(current);

        this.updateResultTextView();
    }

    public void cosOnClick(View view) {
        String current_on_display = resultTextView.getText().toString().replace(",", ".");
        if (current_on_display.isEmpty()) {
            return;
        }

        double current = Double.parseDouble(current_on_display);
        CalculationResult = Math.cos(current);

        this.updateResultTextView();
    }

    public void tanOnClick(View view) {
        String current_on_display = resultTextView.getText().toString().replace(",", ".");
        if (current_on_display.isEmpty()) {
            return;
        }

        double current = Double.parseDouble(current_on_display);
        CalculationResult = Math.tan(current);

        this.updateResultTextView();
    }
}
