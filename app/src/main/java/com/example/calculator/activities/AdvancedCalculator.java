package com.example.calculator.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.calculator.R;

import java.util.function.Function;

public class AdvancedCalculator extends SimpleCalculator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            savedInstanceState = new Bundle();
        }
        savedInstanceState.putBoolean("advancedCalculatorInstance", true);
        super.onCreate(savedInstanceState);

        operationButtons.put("xToThePowerOfY", (Button) findViewById(R.id.xToYButton));
        singleArgumentOperationButtons.put("xSquared", (Button) findViewById(R.id.xSquaredButton));
        singleArgumentOperationButtons.put("ln", (Button) findViewById(R.id.lnButton));
        singleArgumentOperationButtons.put("log", (Button) findViewById(R.id.logButton));
        singleArgumentOperationButtons.put("sqrt", (Button) findViewById(R.id.sqrtButton));
        singleArgumentOperationButtons.put("sin", (Button) findViewById(R.id.sinButton));
        singleArgumentOperationButtons.put("cos", (Button) findViewById(R.id.cosButton));
        singleArgumentOperationButtons.put("tan", (Button) findViewById(R.id.tanButton));

    }

    public void xSquaredOnClick(View view) {
        beforeOperationClick(view);

        String current_on_display = resultTextView.getText().toString().replace(",", ".");
        double current = Double.parseDouble(current_on_display);

        CalculationResult = Math.pow(current, 2);
        this.updateResultTextView();

        // in case when any other operation was not clicked ( like + - )
        if (!operationButtons.containsValue(this.lastOperationClicked)) {
            this.currentOperation = (x) -> Math.pow(Double.parseDouble(resultTextView.getText().toString().replace(",", ".")), 2);
        } else {
            //            this.firstOperand = CalculationResult;
//            double squared = Double.parseDouble(resultTextView.getText().toString().replace(",", "."));
//            this.currentOperation.andThen((x) -> {
//                this.secondOperand = squared;
//                return x;
//            });
        }

    }

    public void xToThePowerOfYOnClick(View view) {
        this.beforeOperationClick(view);

        this.currentOperation = (x) -> {
            if (this.secondOperand >= 99) {
                Toast toast = Toast.makeText(getApplicationContext(), "Exponent is too big to calculate", Toast.LENGTH_SHORT);
                toast.show();
                return 0.0D;
            }
            if (x == 0.0D && this.secondOperand == 0.0D) {
                Toast toast = Toast.makeText(getApplicationContext(), "0 to the power of 0 is undefined", Toast.LENGTH_SHORT);
                toast.show();
                return 0.0D;
            }
            return Math.pow(x, this.secondOperand);
        };
    }

    public void lnOnClick(View view) {
        beforeOperationClick(view);
        String current_on_display = resultTextView.getText().toString().replace(",", ".");

        double current = Double.parseDouble(current_on_display);
        if (current <= 0) {
            Toast toast = Toast.makeText(getApplicationContext(), "Logarithm of negative number is not a real number", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        CalculationResult = Math.log(current);
        this.updateResultTextView();

        if (!operationButtons.containsValue(this.lastOperationClicked)) {
            this.currentOperation = (x) -> Math.log(Double.parseDouble(resultTextView.getText().toString().replace(",", ".")));
        }
    }

    public void logOnClick(View view) {
        beforeOperationClick(view);
        String current_on_display = resultTextView.getText().toString().replace(",", ".");

        double current = Double.parseDouble(current_on_display);
        if (current <= 0) {
            Toast toast = Toast.makeText(getApplicationContext(), "Logarithm of negative number is not a real number", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        CalculationResult = Math.log10(current);
        this.updateResultTextView();

        if (!operationButtons.containsValue(this.lastOperationClicked)) {
            this.currentOperation = (x) -> Math.log10(Double.parseDouble(resultTextView.getText().toString().replace(",", ".")));
        }
    }

    public void sqrtOnClick(View view) {
        beforeOperationClick(view);
        String current_on_display = resultTextView.getText().toString().replace(",", ".");

        double current = Double.parseDouble(current_on_display);
        if (current < 0) {
            Toast toast = Toast.makeText(getApplicationContext(), "Square root of negative number is not a real number", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        CalculationResult = Math.sqrt(current);
        this.updateResultTextView();

        if (!operationButtons.containsValue(this.lastOperationClicked)) {
            this.currentOperation = (x) -> Math.sqrt(Double.parseDouble(resultTextView.getText().toString().replace(",", ".")));
        }
    }

    public void sinOnClick(View view) {
        beforeOperationClick(view);
        String current_on_display = resultTextView.getText().toString().replace(",", ".");

        double current = Double.parseDouble(current_on_display);
        CalculationResult = Math.sin(current);
        this.updateResultTextView();

        if (!operationButtons.containsValue(this.lastOperationClicked)) {
            this.currentOperation = (x) -> Math.sin(Double.parseDouble(resultTextView.getText().toString().replace(",", ".")));
        }
    }

    public void cosOnClick(View view) {
        beforeOperationClick(view);
        String current_on_display = resultTextView.getText().toString().replace(",", ".");

        double current = Double.parseDouble(current_on_display);
        CalculationResult = Math.cos(current);
        this.updateResultTextView();

        if (!operationButtons.containsValue(this.lastOperationClicked)) {
            this.currentOperation = (x) -> Math.cos(Double.parseDouble(resultTextView.getText().toString().replace(",", ".")));
        }
    }

    public void tanOnClick(View view) {
        beforeOperationClick(view);
        String current_on_display = resultTextView.getText().toString().replace(",", ".");

        double current = Double.parseDouble(current_on_display);
        CalculationResult = Math.tan(current);
        this.updateResultTextView();

        if (!operationButtons.containsValue(this.lastOperationClicked)) {
            this.currentOperation = (x) -> Math.tan(Double.parseDouble(resultTextView.getText().toString().replace(",", ".")));
        }
    }
}
